using System;
using System.IO;
using SharpCompress.Common.Rar.Headers;

namespace SharpCompress.Compressor.Rar;

internal class RarStream : Stream
{
	private readonly Unpack unpack;

	private readonly FileHeader fileHeader;

	private Stream readStream;

	private bool fetch;

	private byte[] tmpBuffer = new byte[65536];

	private int tmpOffset;

	private int tmpCount;

	private byte[] outBuffer;

	private int outOffset;

	private int outCount;

	private int outTotal;

	private bool isDisposed;

	public override bool CanRead
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override bool CanSeek
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override bool CanWrite
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override long Length => fileHeader.UncompressedSize;

	public override long Position
	{
		get
		{
			return fileHeader.UncompressedSize - unpack.DestSize;
		}
		set
		{
			throw new NotImplementedException();
		}
	}

	public RarStream(Unpack unpack, FileHeader fileHeader, Stream readStream)
	{
		this.unpack = unpack;
		this.fileHeader = fileHeader;
		this.readStream = readStream;
		fetch = true;
		unpack.doUnpack(fileHeader, readStream, this);
		fetch = false;
	}

	protected override void Dispose(bool disposing)
	{
		if (!isDisposed)
		{
			isDisposed = true;
			base.Dispose(disposing);
			readStream.Dispose();
		}
	}

	public override void Flush()
	{
		throw new NotImplementedException();
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		outTotal = 0;
		if (tmpCount > 0)
		{
			int num = ((tmpCount < count) ? tmpCount : count);
			Buffer.BlockCopy(tmpBuffer, tmpOffset, buffer, offset, num);
			tmpOffset += num;
			tmpCount -= num;
			offset += num;
			count -= num;
			outTotal += num;
		}
		if (count > 0 && unpack.DestSize > 0)
		{
			outBuffer = buffer;
			outOffset = offset;
			outCount = count;
			fetch = true;
			unpack.doUnpack();
			fetch = false;
		}
		return outTotal;
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
		if (!fetch)
		{
			throw new NotImplementedException();
		}
		if (outCount > 0)
		{
			int num = ((outCount < count) ? outCount : count);
			Buffer.BlockCopy(buffer, offset, outBuffer, outOffset, num);
			outOffset += num;
			outCount -= num;
			offset += num;
			count -= num;
			outTotal += num;
		}
		if (count > 0)
		{
			if (tmpBuffer.Length < tmpCount + count)
			{
				byte[] dst = new byte[(tmpBuffer.Length * 2 > tmpCount + count) ? (tmpBuffer.Length * 2) : (tmpCount + count)];
				Buffer.BlockCopy(tmpBuffer, 0, dst, 0, tmpCount);
				tmpBuffer = dst;
			}
			Buffer.BlockCopy(buffer, offset, tmpBuffer, tmpCount, count);
			tmpCount += count;
			tmpOffset = 0;
			unpack.Suspended = true;
		}
		else
		{
			unpack.Suspended = false;
		}
	}
}
