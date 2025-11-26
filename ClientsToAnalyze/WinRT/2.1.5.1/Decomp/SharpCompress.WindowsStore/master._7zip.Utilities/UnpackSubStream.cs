using System;
using System.IO;

namespace master._7zip.Utilities;

internal class UnpackSubStream : Stream
{
	private Stream mSource;

	private long mLength;

	private long mOffset;

	public override bool CanRead => mSource.CanRead;

	public override bool CanSeek => false;

	public override bool CanWrite => false;

	public override long Length => mLength;

	public override long Position
	{
		get
		{
			return mOffset;
		}
		set
		{
			throw new NotSupportedException();
		}
	}

	internal UnpackSubStream(Stream source, long length)
	{
		mSource = source;
		mLength = length;
	}

	public override void Flush()
	{
		throw new NotSupportedException();
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		if (buffer == null)
		{
			throw new ArgumentNullException("buffer");
		}
		if (offset < 0 || offset > buffer.Length)
		{
			throw new ArgumentOutOfRangeException("offset");
		}
		if (count < 0 || count > buffer.Length - offset)
		{
			throw new ArgumentOutOfRangeException("count");
		}
		if (count > mLength - mOffset)
		{
			count = (int)(mLength - mOffset);
		}
		if (count == 0)
		{
			return 0;
		}
		int num = mSource.Read(buffer, offset, count);
		if (num == 0)
		{
			throw new EndOfStreamException("Decoded stream ended prematurely, unpacked data is corrupt.");
		}
		mOffset += num;
		return num;
	}

	public override long Seek(long offset, SeekOrigin origin)
	{
		throw new NotSupportedException();
	}

	public override void SetLength(long value)
	{
		throw new NotSupportedException();
	}

	public override void Write(byte[] buffer, int offset, int count)
	{
		throw new NotSupportedException();
	}
}
