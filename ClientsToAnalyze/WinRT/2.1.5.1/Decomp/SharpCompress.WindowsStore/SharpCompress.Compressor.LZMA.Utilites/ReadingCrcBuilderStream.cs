using System;
using System.IO;

namespace SharpCompress.Compressor.LZMA.Utilites;

internal class ReadingCrcBuilderStream : Stream
{
	private long mProcessed;

	private Stream mSource;

	private uint mCRC;

	private bool mFinished;

	public long Processed => mProcessed;

	public override bool CanRead => mSource.CanRead;

	public override bool CanSeek => false;

	public override bool CanWrite => false;

	public override long Length
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override long Position
	{
		get
		{
			throw new NotImplementedException();
		}
		set
		{
			throw new NotImplementedException();
		}
	}

	public ReadingCrcBuilderStream(Stream source)
	{
		mSource = source;
		mCRC = uint.MaxValue;
	}

	protected override void Dispose(bool disposing)
	{
		try
		{
			if (disposing)
			{
				mSource.Dispose();
			}
		}
		finally
		{
			base.Dispose(disposing);
		}
	}

	public uint Finish()
	{
		if (!mFinished)
		{
			mFinished = true;
			mCRC = CRC.Finish(mCRC);
		}
		return mCRC;
	}

	public override void Flush()
	{
		throw new NotImplementedException();
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		if (count > 0 && !mFinished)
		{
			int num = mSource.Read(buffer, offset, count);
			if (num > 0)
			{
				mProcessed += num;
				mCRC = CRC.Update(mCRC, buffer, offset, num);
				return num;
			}
			Finish();
		}
		return 0;
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
		throw new NotImplementedException();
	}
}
