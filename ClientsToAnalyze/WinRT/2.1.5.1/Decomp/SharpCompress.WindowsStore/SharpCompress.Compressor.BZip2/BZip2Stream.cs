using System.IO;

namespace SharpCompress.Compressor.BZip2;

public class BZip2Stream : Stream
{
	private readonly Stream stream;

	private bool isDisposed;

	public CompressionMode Mode { get; private set; }

	public override bool CanRead => stream.CanRead;

	public override bool CanSeek => stream.CanSeek;

	public override bool CanWrite => stream.CanWrite;

	public override long Length => stream.Length;

	public override long Position
	{
		get
		{
			return stream.Position;
		}
		set
		{
			stream.Position = value;
		}
	}

	public BZip2Stream(Stream stream, CompressionMode compressionMode, bool leaveOpen = false, bool decompressContacted = false)
	{
		Mode = compressionMode;
		if (Mode == CompressionMode.Compress)
		{
			this.stream = new CBZip2OutputStream(stream, leaveOpen);
		}
		else
		{
			this.stream = new CBZip2InputStream(stream, decompressContacted, leaveOpen);
		}
	}

	protected override void Dispose(bool disposing)
	{
		if (!isDisposed)
		{
			isDisposed = true;
			if (disposing)
			{
				stream.Dispose();
			}
		}
	}

	public override void Flush()
	{
		stream.Flush();
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		return stream.Read(buffer, offset, count);
	}

	public override long Seek(long offset, SeekOrigin origin)
	{
		return stream.Seek(offset, origin);
	}

	public override void SetLength(long value)
	{
		stream.SetLength(value);
	}

	public override void Write(byte[] buffer, int offset, int count)
	{
		stream.Write(buffer, offset, count);
	}

	public static bool IsBZip2(Stream stream)
	{
		BinaryReader binaryReader = new BinaryReader(stream);
		byte[] array = binaryReader.ReadBytes(2);
		if (array.Length < 2 || array[0] != 66 || array[1] != 90)
		{
			return false;
		}
		return true;
	}
}
