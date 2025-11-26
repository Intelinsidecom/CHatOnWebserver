using System;
using System.IO;
using SharpCompress.Compressor.LZMA.LZ;
using SharpCompress.Compressor.LZMA.RangeCoder;

namespace SharpCompress.Compressor.LZMA;

public class LzmaStream : Stream
{
	private Stream inputStream;

	private long inputSize;

	private long outputSize;

	private int dictionarySize;

	private OutWindow outWindow = new OutWindow();

	private SharpCompress.Compressor.LZMA.RangeCoder.Decoder rangeDecoder = new SharpCompress.Compressor.LZMA.RangeCoder.Decoder();

	private Decoder decoder;

	private long position;

	private bool endReached;

	private long availableBytes;

	private long rangeDecoderLimit;

	private long inputPosition;

	private bool isLZMA2;

	private bool uncompressedChunk;

	private bool needDictReset = true;

	private bool needProps = true;

	private byte[] props = new byte[5];

	private Encoder encoder;

	private bool isDisposed;

	public override bool CanRead => encoder == null;

	public override bool CanSeek => false;

	public override bool CanWrite => encoder != null;

	public override long Length => position + availableBytes;

	public override long Position
	{
		get
		{
			return position;
		}
		set
		{
			throw new NotImplementedException();
		}
	}

	public byte[] Properties => props;

	public LzmaStream(byte[] properties, Stream inputStream)
		: this(properties, inputStream, -1L, -1L, null, properties.Length < 5)
	{
	}

	public LzmaStream(byte[] properties, Stream inputStream, long inputSize)
		: this(properties, inputStream, inputSize, -1L, null, properties.Length < 5)
	{
	}

	public LzmaStream(byte[] properties, Stream inputStream, long inputSize, long outputSize)
		: this(properties, inputStream, inputSize, outputSize, null, properties.Length < 5)
	{
	}

	public LzmaStream(byte[] properties, Stream inputStream, long inputSize, long outputSize, Stream presetDictionary, bool isLZMA2)
	{
		this.inputStream = inputStream;
		this.inputSize = inputSize;
		this.outputSize = outputSize;
		this.isLZMA2 = isLZMA2;
		if (!isLZMA2)
		{
			dictionarySize = BitConverter.ToInt32(properties, 1);
			outWindow.Create(dictionarySize);
			if (presetDictionary != null)
			{
				outWindow.Train(presetDictionary);
			}
			rangeDecoder.Init(inputStream);
			decoder = new Decoder();
			decoder.SetDecoderProperties(properties);
			props = properties;
			availableBytes = ((outputSize < 0) ? long.MaxValue : outputSize);
			rangeDecoderLimit = inputSize;
		}
		else
		{
			dictionarySize = 2 | (properties[0] & 1);
			dictionarySize <<= (properties[0] >> 1) + 11;
			outWindow.Create(dictionarySize);
			if (presetDictionary != null)
			{
				outWindow.Train(presetDictionary);
				needDictReset = false;
			}
			props = new byte[1];
			availableBytes = 0L;
		}
	}

	public LzmaStream(LzmaEncoderProperties properties, bool isLZMA2, Stream outputStream)
		: this(properties, isLZMA2, null, outputStream)
	{
	}

	public LzmaStream(LzmaEncoderProperties properties, bool isLZMA2, Stream presetDictionary, Stream outputStream)
	{
		this.isLZMA2 = isLZMA2;
		availableBytes = 0L;
		endReached = true;
		if (isLZMA2)
		{
			throw new NotImplementedException();
		}
		encoder = new Encoder();
		encoder.SetCoderProperties(properties.propIDs, properties.properties);
		MemoryStream memoryStream = new MemoryStream(5);
		encoder.WriteCoderProperties(memoryStream);
		props = memoryStream.ToArray();
		encoder.SetStreams(null, outputStream, -1L, -1L);
		if (presetDictionary != null)
		{
			encoder.Train(presetDictionary);
		}
	}

	public override void Flush()
	{
	}

	protected override void Dispose(bool disposing)
	{
		if (isDisposed)
		{
			return;
		}
		isDisposed = true;
		if (disposing)
		{
			if (encoder != null)
			{
				position = encoder.Code(null, final: true);
			}
			if (inputStream != null)
			{
				inputStream.Dispose();
			}
		}
		base.Dispose(disposing);
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		if (endReached)
		{
			return 0;
		}
		int num = 0;
		while (num < count)
		{
			if (availableBytes == 0)
			{
				if (isLZMA2)
				{
					decodeChunkHeader();
				}
				else
				{
					endReached = true;
				}
				if (endReached)
				{
					break;
				}
			}
			int num2 = count - num;
			if (num2 > availableBytes)
			{
				num2 = (int)availableBytes;
			}
			outWindow.SetLimit(num2);
			if (uncompressedChunk)
			{
				inputPosition += outWindow.CopyStream(inputStream, num2);
			}
			else if (decoder.Code(dictionarySize, outWindow, rangeDecoder) && outputSize < 0)
			{
				availableBytes = outWindow.AvailableBytes;
			}
			int num3 = outWindow.Read(buffer, offset, num2);
			num += num3;
			offset += num3;
			position += num3;
			availableBytes -= num3;
			if (availableBytes == 0 && !uncompressedChunk)
			{
				rangeDecoder.ReleaseStream();
				if (!rangeDecoder.IsFinished || (rangeDecoderLimit >= 0 && rangeDecoder.Total != rangeDecoderLimit))
				{
					throw new DataErrorException();
				}
				inputPosition += rangeDecoder.Total;
				if (outWindow.HasPending)
				{
					throw new DataErrorException();
				}
			}
		}
		if (endReached)
		{
			if (inputSize >= 0 && inputPosition != inputSize)
			{
				throw new DataErrorException();
			}
			if (outputSize >= 0 && position != outputSize)
			{
				throw new DataErrorException();
			}
		}
		return num;
	}

	private void decodeChunkHeader()
	{
		int num = inputStream.ReadByte();
		inputPosition++;
		if (num == 0)
		{
			endReached = true;
			return;
		}
		if (num >= 224 || num == 1)
		{
			needProps = true;
			needDictReset = false;
			outWindow.Reset();
		}
		else if (needDictReset)
		{
			throw new DataErrorException();
		}
		if (num >= 128)
		{
			uncompressedChunk = false;
			availableBytes = (num & 0x1F) << 16;
			availableBytes += (inputStream.ReadByte() << 8) + inputStream.ReadByte() + 1;
			inputPosition += 2L;
			rangeDecoderLimit = (inputStream.ReadByte() << 8) + inputStream.ReadByte() + 1;
			inputPosition += 2L;
			if (num >= 192)
			{
				needProps = false;
				props[0] = (byte)inputStream.ReadByte();
				inputPosition++;
				decoder = new Decoder();
				decoder.SetDecoderProperties(props);
			}
			else
			{
				if (needProps)
				{
					throw new DataErrorException();
				}
				if (num >= 160)
				{
					decoder = new Decoder();
					decoder.SetDecoderProperties(props);
				}
			}
			rangeDecoder.Init(inputStream);
		}
		else
		{
			if (num > 2)
			{
				throw new DataErrorException();
			}
			uncompressedChunk = true;
			availableBytes = (inputStream.ReadByte() << 8) + inputStream.ReadByte() + 1;
			inputPosition += 2L;
		}
	}

	public override long Seek(long offset, SeekOrigin origin)
	{
		throw new NotImplementedException();
	}

	public override void SetLength(long value)
	{
		throw new NotImplementedException();
	}

	public override void Write(byte[] buffer, int offset, int count)
	{
		if (encoder != null)
		{
			position = encoder.Code(new MemoryStream(buffer, offset, count), final: false);
		}
	}
}
