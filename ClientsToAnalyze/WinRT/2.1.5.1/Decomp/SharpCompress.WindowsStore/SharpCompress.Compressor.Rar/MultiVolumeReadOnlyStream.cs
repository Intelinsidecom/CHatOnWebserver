using System;
using System.Collections.Generic;
using System.IO;
using SharpCompress.Common;
using SharpCompress.Common.Rar;
using SharpCompress.Common.Rar.Headers;

namespace SharpCompress.Compressor.Rar;

internal class MultiVolumeReadOnlyStream : Stream
{
	private long currentPosition;

	private long maxPosition;

	private IEnumerator<RarFilePart> filePartEnumerator;

	private Stream currentStream;

	private readonly IStreamListener streamListener;

	private long currentPartTotalReadBytes;

	private long currentEntryTotalReadBytes;

	public override bool CanRead => true;

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

	internal MultiVolumeReadOnlyStream(IEnumerable<RarFilePart> parts, IStreamListener streamListener)
	{
		this.streamListener = streamListener;
		filePartEnumerator = parts.GetEnumerator();
		filePartEnumerator.MoveNext();
		InitializeNextFilePart();
	}

	protected override void Dispose(bool disposing)
	{
		base.Dispose(disposing);
		if (disposing)
		{
			if (filePartEnumerator != null)
			{
				filePartEnumerator.Dispose();
				filePartEnumerator = null;
			}
			if (currentStream != null)
			{
				currentStream.Dispose();
				currentStream = null;
			}
		}
	}

	private void InitializeNextFilePart()
	{
		maxPosition = filePartEnumerator.Current.FileHeader.CompressedSize;
		currentPosition = 0L;
		if (currentStream != null)
		{
			currentStream.Dispose();
		}
		currentStream = filePartEnumerator.Current.GetCompressedStream();
		currentPartTotalReadBytes = 0L;
		streamListener.FireFilePartExtractionBegin(filePartEnumerator.Current.FilePartName, filePartEnumerator.Current.FileHeader.CompressedSize, filePartEnumerator.Current.FileHeader.UncompressedSize);
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		int num = 0;
		while (count > 0)
		{
			int count2 = count;
			if (count > maxPosition - currentPosition)
			{
				count2 = (int)(maxPosition - currentPosition);
			}
			int num2 = currentStream.Read(buffer, offset, count2);
			if (num2 < 0)
			{
				throw new EndOfStreamException();
			}
			currentPosition += num2;
			offset += num2;
			count -= num2;
			num += num2;
			if (maxPosition - currentPosition != 0 || !filePartEnumerator.Current.FileHeader.FileFlags.HasFlag(FileFlags.SPLIT_AFTER))
			{
				break;
			}
			string fileName = filePartEnumerator.Current.FileHeader.FileName;
			if (!filePartEnumerator.MoveNext())
			{
				throw new InvalidFormatException("Multi-part rar file is incomplete.  Entry expects a new volume: " + fileName);
			}
			InitializeNextFilePart();
		}
		currentPartTotalReadBytes += num;
		currentEntryTotalReadBytes += num;
		streamListener.FireCompressedBytesRead(currentPartTotalReadBytes, currentEntryTotalReadBytes);
		return num;
	}

	public override void Flush()
	{
		throw new NotImplementedException();
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
