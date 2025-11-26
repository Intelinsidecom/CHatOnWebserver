using System.IO;
using SharpCompress.Common;

namespace SharpCompress.IO;

internal class ListeningStream : Stream
{
	private long currentEntryTotalReadBytes;

	private IStreamListener listener;

	public Stream Stream { get; private set; }

	public override bool CanRead => Stream.CanRead;

	public override bool CanSeek => Stream.CanSeek;

	public override bool CanWrite => Stream.CanWrite;

	public override long Length => Stream.Length;

	public override long Position
	{
		get
		{
			return Stream.Position;
		}
		set
		{
			Stream.Position = value;
		}
	}

	public ListeningStream(IStreamListener listener, Stream stream)
	{
		Stream = stream;
		this.listener = listener;
	}

	protected override void Dispose(bool disposing)
	{
		if (disposing)
		{
			Stream.Dispose();
		}
	}

	public override void Flush()
	{
		Stream.Flush();
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		int num = Stream.Read(buffer, offset, count);
		currentEntryTotalReadBytes += num;
		listener.FireCompressedBytesRead(currentEntryTotalReadBytes, currentEntryTotalReadBytes);
		return num;
	}

	public override long Seek(long offset, SeekOrigin origin)
	{
		return Stream.Seek(offset, origin);
	}

	public override void SetLength(long value)
	{
		Stream.SetLength(value);
	}

	public override void Write(byte[] buffer, int offset, int count)
	{
		Stream.Write(buffer, offset, count);
	}
}
