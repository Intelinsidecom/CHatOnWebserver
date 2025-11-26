using System;
using System.IO;
using SharpCompress.Common;

namespace SharpCompress.Writer;

public abstract class AbstractWriter : IWriter, IDisposable
{
	private bool closeStream;

	private bool isDisposed;

	protected Stream OutputStream { get; private set; }

	public ArchiveType WriterType { get; private set; }

	protected AbstractWriter(ArchiveType type)
	{
		WriterType = type;
	}

	protected void InitalizeStream(Stream stream, bool closeStream)
	{
		OutputStream = stream;
		this.closeStream = closeStream;
	}

	public abstract void Write(string filename, Stream source, DateTime? modificationTime);

	protected virtual void Dispose(bool isDisposing)
	{
		if (isDisposing && closeStream)
		{
			OutputStream.Dispose();
		}
	}

	public void Dispose()
	{
		if (!isDisposed)
		{
			GC.SuppressFinalize(this);
			Dispose(isDisposing: true);
			isDisposed = true;
		}
	}

	~AbstractWriter()
	{
		if (!isDisposed)
		{
			Dispose(isDisposing: false);
			isDisposed = true;
		}
	}
}
