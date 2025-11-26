using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using SharpCompress.Common;
using SharpCompress.Common.SevenZip;
using SharpCompress.IO;
using SharpCompress.Reader;

namespace SharpCompress.Archive.SevenZip;

public class SevenZipArchive : AbstractArchive<SevenZipArchiveEntry, SevenZipVolume>
{
	private class SevenZipReader : AbstractReader<SevenZipEntry, SevenZipVolume>
	{
		private readonly SevenZipArchive archive;

		private CFolder currentFolder;

		private Stream currentStream;

		private CFileItem currentItem;

		public override SevenZipVolume Volume => archive.Volumes.Single();

		internal SevenZipReader(SevenZipArchive archive)
			: base(Options.KeepStreamsOpen, ArchiveType.SevenZip)
		{
			this.archive = archive;
		}

		internal override IEnumerable<SevenZipEntry> GetEntries(Stream stream)
		{
			List<SevenZipArchiveEntry> entries = archive.Entries.ToList();
			stream.Position = 0L;
			foreach (SevenZipArchiveEntry item in entries.Where((SevenZipArchiveEntry x) => x.IsDirectory))
			{
				yield return item;
			}
			foreach (IGrouping<CFolder, SevenZipArchiveEntry> group in from x in entries
				where !x.IsDirectory
				group x by x.FilePart.Folder)
			{
				currentFolder = group.Key;
				if (group.Key == null)
				{
					currentStream = Stream.Null;
				}
				else
				{
					currentStream = archive.database.GetFolderStream(stream, currentFolder, null);
				}
				foreach (SevenZipArchiveEntry entry in group)
				{
					currentItem = entry.FilePart.Header;
					yield return entry;
				}
			}
		}

		protected override EntryStream GetEntryStream()
		{
			return new EntryStream(new ReadOnlySubStream(currentStream, currentItem.Size));
		}
	}

	private ArchiveDatabase database;

	private static readonly byte[] SIGNATURE = new byte[6] { 55, 122, 188, 175, 39, 28 };

	public override bool IsSolid => (from x in Entries
		where !x.IsDirectory
		group x by x.FilePart.Folder).Count() > 1;

	public static SevenZipArchive Open(Stream stream)
	{
		stream.CheckNotNull("stream");
		return Open(stream, Options.None);
	}

	public static SevenZipArchive Open(Stream stream, Options options)
	{
		stream.CheckNotNull("stream");
		return new SevenZipArchive(stream, options);
	}

	internal SevenZipArchive(Stream stream, Options options)
		: base(ArchiveType.SevenZip, stream.AsEnumerable(), options)
	{
	}

	internal SevenZipArchive()
		: base(ArchiveType.SevenZip)
	{
	}

	protected override IEnumerable<SevenZipVolume> LoadVolumes(IEnumerable<Stream> streams, Options options)
	{
		foreach (Stream s in streams)
		{
			if (!s.CanRead || !s.CanSeek)
			{
				throw new ArgumentException("Stream is not readable and seekable");
			}
			yield return new SevenZipVolume(s, options);
		}
	}

	protected override IEnumerable<SevenZipArchiveEntry> LoadEntries(IEnumerable<SevenZipVolume> volumes)
	{
		Stream stream = volumes.Single().Stream;
		LoadFactory(stream);
		for (int i = 0; i < database.Files.Count; i++)
		{
			CFileItem file = database.Files[i];
			if (!file.IsDir)
			{
				yield return new SevenZipArchiveEntry(this, new SevenZipFilePart(stream, database, i, file));
			}
		}
	}

	private void LoadFactory(Stream stream)
	{
		if (database == null)
		{
			stream.Position = 0L;
			ArchiveReader archiveReader = new ArchiveReader();
			archiveReader.Open(stream);
			database = archiveReader.ReadDatabase(null);
		}
	}

	public static bool IsSevenZipFile(Stream stream)
	{
		try
		{
			return SignatureMatch(stream);
		}
		catch
		{
			return false;
		}
	}

	private static bool SignatureMatch(Stream stream)
	{
		BinaryReader binaryReader = new BinaryReader(stream);
		byte[] source = binaryReader.ReadBytes(6);
		return source.BinaryEquals(SIGNATURE);
	}

	protected override IReader CreateReaderForSolidExtraction()
	{
		return new SevenZipReader(this);
	}
}
