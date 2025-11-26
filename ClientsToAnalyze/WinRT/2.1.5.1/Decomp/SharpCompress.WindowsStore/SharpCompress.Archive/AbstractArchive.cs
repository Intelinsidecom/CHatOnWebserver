using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using SharpCompress.Common;
using SharpCompress.Reader;

namespace SharpCompress.Archive;

public abstract class AbstractArchive<TEntry, TVolume> : IArchive, IDisposable, IStreamListener where TEntry : IArchiveEntry where TVolume : IVolume
{
	private readonly LazyReadOnlyCollection<TVolume> lazyVolumes;

	private readonly LazyReadOnlyCollection<TEntry> lazyEntries;

	private bool disposed;

	public virtual ICollection<TEntry> Entries => lazyEntries;

	public ICollection<TVolume> Volumes => lazyVolumes;

	public long TotalSize => Entries.Aggregate(0L, (long total, TEntry cf) => total + cf.CompressedSize);

	IEnumerable<IArchiveEntry> IArchive.Entries => lazyEntries.Cast<IArchiveEntry>();

	IEnumerable<IVolume> IArchive.Volumes => lazyVolumes.Cast<IVolume>();

	public ArchiveType Type { get; private set; }

	public virtual bool IsSolid => false;

	public bool IsComplete
	{
		get
		{
			EnsureEntriesLoaded();
			return Entries.All((TEntry x) => x.IsComplete);
		}
	}

	public event EventHandler<ArchiveExtractionEventArgs<IArchiveEntry>> EntryExtractionBegin;

	public event EventHandler<ArchiveExtractionEventArgs<IArchiveEntry>> EntryExtractionEnd;

	public event EventHandler<CompressedBytesReadEventArgs> CompressedBytesRead;

	public event EventHandler<FilePartExtractionBeginEventArgs> FilePartExtractionBegin;

	internal AbstractArchive(ArchiveType type, IEnumerable<Stream> streams, Options options)
	{
		Type = type;
		lazyVolumes = new LazyReadOnlyCollection<TVolume>(LoadVolumes(streams.Select(CheckStreams), options));
		lazyEntries = new LazyReadOnlyCollection<TEntry>(LoadEntries(Volumes));
	}

	internal AbstractArchive(ArchiveType type)
	{
		Type = type;
		lazyVolumes = new LazyReadOnlyCollection<TVolume>(Enumerable.Empty<TVolume>());
		lazyEntries = new LazyReadOnlyCollection<TEntry>(Enumerable.Empty<TEntry>());
	}

	internal void FireEntryExtractionBegin(IArchiveEntry entry)
	{
		if (this.EntryExtractionBegin != null)
		{
			this.EntryExtractionBegin(this, new ArchiveExtractionEventArgs<IArchiveEntry>(entry));
		}
	}

	internal void FireEntryExtractionEnd(IArchiveEntry entry)
	{
		if (this.EntryExtractionEnd != null)
		{
			this.EntryExtractionEnd(this, new ArchiveExtractionEventArgs<IArchiveEntry>(entry));
		}
	}

	private static Stream CheckStreams(Stream stream)
	{
		if (!stream.CanSeek || !stream.CanRead)
		{
			throw new ArgumentException("Archive streams must be Readable and Seekable");
		}
		return stream;
	}

	protected abstract IEnumerable<TVolume> LoadVolumes(IEnumerable<Stream> streams, Options options);

	protected abstract IEnumerable<TEntry> LoadEntries(IEnumerable<TVolume> volumes);

	public void Dispose()
	{
		if (!disposed)
		{
			lazyVolumes.ForEach(delegate(TVolume v)
			{
				v.Dispose();
			});
			lazyEntries.GetLoaded().Cast<Entry>().ForEach(delegate(Entry x)
			{
				x.Close();
			});
			disposed = true;
		}
	}

	internal void EnsureEntriesLoaded()
	{
		lazyEntries.EnsureFullyLoaded();
		lazyVolumes.EnsureFullyLoaded();
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

	public IReader ExtractAllEntries()
	{
		EnsureEntriesLoaded();
		return CreateReaderForSolidExtraction();
	}

	protected abstract IReader CreateReaderForSolidExtraction();
}
