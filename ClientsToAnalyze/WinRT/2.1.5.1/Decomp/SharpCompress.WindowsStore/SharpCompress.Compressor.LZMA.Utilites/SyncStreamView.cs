using System;
using System.IO;

namespace SharpCompress.Compressor.LZMA.Utilites;

internal class SyncStreamView : Stream
{
	private object mSync;

	private Stream mStream;

	private long mOrigin;

	private long mEnding;

	private long mOffset;

	private bool isDisposed;

	public override bool CanRead => true;

	public override bool CanSeek => true;

	public override bool CanWrite => false;

	public override long Length => mEnding - mOrigin;

	public override long Position
	{
		get
		{
			return mOffset;
		}
		set
		{
			if (value < 0 || value > Length)
			{
				throw new ArgumentOutOfRangeException("value");
			}
			mOffset = value;
		}
	}

	public SyncStreamView(object sync, Stream stream, long origin, long length)
	{
		mSync = sync;
		mStream = stream;
		mOrigin = origin;
		mEnding = checked(origin + length);
		mOffset = 0L;
	}

	protected override void Dispose(bool disposing)
	{
		if (!isDisposed)
		{
			isDisposed = true;
			base.Dispose(disposing);
			mStream.Dispose();
		}
	}

	public override void Flush()
	{
		throw new InvalidOperationException();
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		long num = mEnding - mOrigin - mOffset;
		if (count > num)
		{
			count = (int)num;
		}
		if (count == 0)
		{
			return 0;
		}
		int num2;
		lock (mSync)
		{
			mStream.Position = mOrigin + mOffset;
			num2 = mStream.Read(buffer, offset, count);
		}
		mOffset += num2;
		return num2;
	}

	public override long Seek(long offset, SeekOrigin origin)
	{
		return origin switch
		{
			SeekOrigin.Begin => Position = offset, 
			SeekOrigin.Current => Position += offset, 
			SeekOrigin.End => Position = Length + offset, 
			_ => throw new ArgumentOutOfRangeException("origin"), 
		};
	}

	public override void SetLength(long value)
	{
		throw new InvalidOperationException();
	}

	public override void Write(byte[] buffer, int offset, int count)
	{
		throw new InvalidOperationException();
	}
}
