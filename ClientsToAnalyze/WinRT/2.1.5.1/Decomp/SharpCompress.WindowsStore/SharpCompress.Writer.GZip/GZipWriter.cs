using System;
using System.IO;
using SharpCompress.Common;
using SharpCompress.Compressor;
using SharpCompress.Compressor.Deflate;

namespace SharpCompress.Writer.GZip;

public class GZipWriter : AbstractWriter
{
	private bool wroteToStream;

	public GZipWriter(Stream destination)
		: base(ArchiveType.GZip)
	{
		InitalizeStream(new GZipStream(destination, CompressionMode.Compress, leaveOpen: true), closeStream: true);
	}

	protected override void Dispose(bool isDisposing)
	{
		if (isDisposing)
		{
			base.OutputStream.Dispose();
		}
		base.Dispose(isDisposing);
	}

	public override void Write(string filename, Stream source, DateTime? modificationTime)
	{
		if (wroteToStream)
		{
			throw new ArgumentException("Can only write a single stream to a GZip file.");
		}
		GZipStream gZipStream = base.OutputStream as GZipStream;
		gZipStream.FileName = filename;
		gZipStream.LastModified = modificationTime;
		source.TransferTo(gZipStream);
		wroteToStream = true;
	}
}
