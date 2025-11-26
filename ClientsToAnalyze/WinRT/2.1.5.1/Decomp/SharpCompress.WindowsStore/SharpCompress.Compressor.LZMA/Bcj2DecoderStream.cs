using System;
using System.Collections.Generic;
using System.IO;

namespace SharpCompress.Compressor.LZMA;

internal class Bcj2DecoderStream : DecoderStream2
{
	private class RangeDecoder
	{
		internal Stream mStream;

		internal uint Range;

		internal uint Code;

		public RangeDecoder(Stream stream)
		{
			mStream = stream;
			Range = uint.MaxValue;
			for (int i = 0; i < 5; i++)
			{
				Code = (Code << 8) | ReadByte();
			}
		}

		public byte ReadByte()
		{
			int num = mStream.ReadByte();
			if (num < 0)
			{
				throw new EndOfStreamException();
			}
			return (byte)num;
		}

		public void Dispose()
		{
			mStream.Dispose();
		}
	}

	private class StatusDecoder
	{
		private const int numMoveBits = 5;

		private const int kNumBitModelTotalBits = 11;

		private const uint kBitModelTotal = 2048u;

		private uint Prob;

		public StatusDecoder()
		{
			Prob = 1024u;
		}

		private void UpdateModel(uint symbol)
		{
			if (symbol == 0)
			{
				Prob += 2048 - Prob >> 5;
			}
			else
			{
				Prob -= Prob >> 5;
			}
		}

		public uint Decode(RangeDecoder decoder)
		{
			uint num = (decoder.Range >> 11) * Prob;
			if (decoder.Code < num)
			{
				decoder.Range = num;
				Prob += 2048 - Prob >> 5;
				if (decoder.Range < 16777216)
				{
					decoder.Code = (decoder.Code << 8) | decoder.ReadByte();
					decoder.Range <<= 8;
				}
				return 0u;
			}
			decoder.Range -= num;
			decoder.Code -= num;
			Prob -= Prob >> 5;
			if (decoder.Range < 16777216)
			{
				decoder.Code = (decoder.Code << 8) | decoder.ReadByte();
				decoder.Range <<= 8;
			}
			return 1u;
		}
	}

	private const int kNumTopBits = 24;

	private const uint kTopValue = 16777216u;

	private Stream mMainStream;

	private Stream mCallStream;

	private Stream mJumpStream;

	private RangeDecoder mRangeDecoder;

	private StatusDecoder[] mStatusDecoder;

	private long mWritten;

	private long mLimit;

	private IEnumerator<byte> mIter;

	private bool mFinished;

	private bool isDisposed;

	public Bcj2DecoderStream(Stream[] streams, byte[] info, long limit)
	{
		if (info != null && info.Length > 0)
		{
			throw new NotSupportedException();
		}
		if (streams.Length != 4)
		{
			throw new NotSupportedException();
		}
		mLimit = limit;
		mMainStream = streams[0];
		mCallStream = streams[1];
		mJumpStream = streams[2];
		mRangeDecoder = new RangeDecoder(streams[3]);
		mStatusDecoder = new StatusDecoder[258];
		for (int i = 0; i < mStatusDecoder.Length; i++)
		{
			mStatusDecoder[i] = new StatusDecoder();
		}
		mIter = Run().GetEnumerator();
	}

	protected override void Dispose(bool disposing)
	{
		if (!isDisposed)
		{
			isDisposed = true;
			base.Dispose(disposing);
			mMainStream.Dispose();
			mCallStream.Dispose();
			mJumpStream.Dispose();
		}
	}

	private static bool IsJcc(byte b0, byte b1)
	{
		if (b0 == 15)
		{
			return (b1 & 0xF0) == 128;
		}
		return false;
	}

	private static bool IsJ(byte b0, byte b1)
	{
		if ((b1 & 0xFE) != 232)
		{
			return IsJcc(b0, b1);
		}
		return true;
	}

	private static int GetIndex(byte b0, byte b1)
	{
		return b1 switch
		{
			232 => b0, 
			233 => 256, 
			_ => 257, 
		};
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		if (count == 0 || mFinished)
		{
			return 0;
		}
		for (int i = 0; i < count; i++)
		{
			if (!mIter.MoveNext())
			{
				mFinished = true;
				return i;
			}
			buffer[offset + i] = mIter.Current;
		}
		return count;
	}

	public IEnumerable<byte> Run()
	{
		byte prevByte = 0;
		uint processedBytes = 0u;
		while (true)
		{
			byte b = 0;
			uint i;
			for (i = 0u; i < 262144; i++)
			{
				int tmp = mMainStream.ReadByte();
				if (tmp >= 0)
				{
					b = (byte)tmp;
					mWritten++;
					yield return b;
					if (IsJ(prevByte, b))
					{
						break;
					}
					prevByte = b;
					continue;
				}
				yield break;
			}
			processedBytes += i;
			if (i == 262144)
			{
				continue;
			}
			if (mStatusDecoder[GetIndex(prevByte, b)].Decode(mRangeDecoder) == 1)
			{
				Stream s = ((b == 232) ? mCallStream : mJumpStream);
				uint src = 0u;
				for (i = 0u; i < 4; i++)
				{
					int num = s.ReadByte();
					if (num < 0)
					{
						throw new EndOfStreamException();
					}
					src <<= 8;
					src |= (uint)num;
				}
				uint dest = src - (uint)(int)(mWritten + 4);
				mWritten++;
				yield return (byte)dest;
				mWritten++;
				yield return (byte)(dest >> 8);
				mWritten++;
				yield return (byte)(dest >> 16);
				mWritten++;
				yield return (byte)(dest >> 24);
				prevByte = (byte)(dest >> 24);
				processedBytes += 4;
			}
			else
			{
				prevByte = b;
			}
		}
	}
}
