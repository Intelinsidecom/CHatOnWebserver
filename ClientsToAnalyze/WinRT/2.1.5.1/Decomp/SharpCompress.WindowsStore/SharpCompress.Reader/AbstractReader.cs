using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using SharpCompress.Common;

namespace SharpCompress.Reader;

public abstract class AbstractReader<TEntry, TVolume> : IReader, IDisposable, IStreamListener where TEntry : Entry where TVolume : Volume
{
	private bool completed;

	private IEnumerator<TEntry> entriesForCurrentReadStream;

	private bool wroteCurrentEntry;

	private readonly byte[] skipBuffer = new byte[4096];

	internal Options Options { get; private set; }

	public ArchiveType ArchiveType { get; private set; }

	public abstract TVolume Volume { get; }

	public TEntry Entry => entriesForCurrentReadStream.Current;

	IEntry IReader.Entry => Entry;

	public event EventHandler<CompressedBytesReadEventArgs> CompressedBytesRead;

	public event EventHandler<FilePartExtractionBeginEventArgs> FilePartExtractionBegin;

	internal AbstractReader(Options options, ArchiveType archiveType)
	{
		ArchiveType = archiveType;
		Options = options;
	}

	public void Dispose()
	{
		if (entriesForCurrentReadStream != null)
		{
			entriesForCurrentReadStream.Dispose();
		}
		TVolume volume = Volume;
		volume.Dispose();
	}

	public bool MoveToNextEntry()
	{
		if (completed)
		{
			return false;
		}
		if (entriesForCurrentReadStream == null)
		{
			return LoadStreamForReading(RequestInitialStream());
		}
		if (!wroteCurrentEntry)
		{
			SkipEntry();
		}
		wroteCurrentEntry = false;
		if (NextEntryForCurrentStream())
		{
			return true;
		}
		completed = true;
		return false;
	}

	internal bool LoadStreamForReading(Stream stream)
	{
		if (entriesForCurrentReadStream != null)
		{
			entriesForCurrentReadStream.Dispose();
		}
		if (stream == null || !stream.CanRead)
		{
			TEntry entry = Entry;
			throw new MultipartStreamRequiredException("File is split into multiple archives: '" + entry.FilePath + "'. A new readable stream is required.  Use Cancel if it was intended.");
		}
		entriesForCurrentReadStream = GetEntries(stream).GetEnumerator();
		if (entriesForCurrentReadStream.MoveNext())
		{
			return true;
		}
		return false;
	}

	internal virtual Stream RequestInitialStream()
	{
		TVolume volume = Volume;
		return volume.Stream;
	}

	internal virtual bool NextEntryForCurrentStream()
	{
		return entriesForCurrentReadStream.MoveNext();
	}

	internal abstract IEnumerable<TEntry> GetEntries(Stream stream);

	private void SkipEntry()
	{
		TEntry entry = Entry;
		if (!entry.IsDirectory)
		{
			Skip();
		}
	}

	private void Skip()
	{
		TEntry entry = Entry;
		if (!entry.IsSolid)
		{
			TEntry entry2 = Entry;
			Stream rawStream = entry2.Parts.First().GetRawStream();
			if (rawStream != null)
			{
				TEntry entry3 = Entry;
				long compressedSize = entry3.CompressedSize;
				for (int i = 0; i < compressedSize / skipBuffer.Length; i++)
				{
					rawStream.Read(skipBuffer, 0, skipBuffer.Length);
				}
				rawStream.Read(skipBuffer, 0, (int)(compressedSize % skipBuffer.Length));
				return;
			}
		}
		using EntryStream entryStream = OpenEntryStream();
		while (entryStream.Read(skipBuffer, 0, skipBuffer.Length) > 0)
		{
		}
	}

	public void WriteEntryTo(Stream writableStream)
	{
		if (wroteCurrentEntry)
		{
			throw new ArgumentException("WriteEntryTo or OpenEntryStream can only be called once.");
		}
		if (writableStream == null || !writableStream.CanWrite)
		{
			throw new ArgumentNullException("A writable Stream was required.  Use Cancel if that was intended.");
		}
		Write(writableStream);
		wroteCurrentEntry = true;
	}

	internal void Write(Stream writeStream)
	{
		using Stream source = OpenEntryStream();
		source.TransferTo(writeStream);
	}

	public EntryStream OpenEntryStream()
	{
		if (wroteCurrentEntry)
		{
			throw new ArgumentException("WriteEntryTo or OpenEntryStream can only be called once.");
		}
		EntryStream entryStream = GetEntryStream();
		wroteCurrentEntry = true;
		return entryStream;
	}

	protected virtual EntryStream GetEntryStream()
	{
		TEntry entry = Entry;
		return new EntryStream(entry.Parts.First().GetCompressedStream());
	}

	void IStreamListener.FireCompressedBytesRead(long currentPartCompressedBytes, long compressedReadBytes)
	{
		if (this.CompressedBytesRead != null)
		{
			this.CompressedBytesRead(this, new CompressedBytesReadEventArgs
			{
				CurrentFilePartCompressedBytesRead = currentPartCompressedBytes,
				CompressedBytesRead = compressedReadBytes
			});
		}
	}

	void IStreamListener.FireFilePartExtractionBegin(string name, long size, long compressedSize)
	{
		if (this.FilePartExtractionBegin != null)
		{
			this.FilePartExtractionBegin(this, new FilePartExtractionBeginEventArgs
			{
				CompressedSize = compressedSize,
				Size = size,
				Name = name
			});
		}
	}
}
