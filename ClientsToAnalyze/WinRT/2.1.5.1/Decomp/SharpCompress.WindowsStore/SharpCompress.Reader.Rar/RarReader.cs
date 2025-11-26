using System.Collections.Generic;
using System.IO;
using System.Linq;
using SharpCompress.Common;
using SharpCompress.Common.Rar;
using SharpCompress.Compressor.Rar;

namespace SharpCompress.Reader.Rar;

public abstract class RarReader : AbstractReader<RarReaderEntry, RarVolume>
{
	private RarVolume volume;

	private readonly Unpack pack = new Unpack();

	public string Password { get; set; }

	public override RarVolume Volume => volume;

	internal RarReader(Options options)
		: base(options, ArchiveType.Rar)
	{
	}

	internal abstract void ValidateArchive(RarVolume archive);

	public static RarReader Open(Stream stream, Options options = Options.KeepStreamsOpen)
	{
		return Open(stream, null, options);
	}

	public static RarReader Open(IEnumerable<Stream> streams, Options options = Options.KeepStreamsOpen)
	{
		streams.CheckNotNull("streams");
		return new MultiVolumeRarReader(streams, options);
	}

	internal override IEnumerable<RarReaderEntry> GetEntries(Stream stream)
	{
		volume = new RarReaderVolume(stream, Password, base.Options);
		foreach (RarFilePart fp in volume.ReadFileParts())
		{
			ValidateArchive(volume);
			yield return new RarReaderEntry(volume.IsSolidArchive, fp);
		}
	}

	protected virtual IEnumerable<FilePart> CreateFilePartEnumerableForCurrentEntry()
	{
		return base.Entry.Parts;
	}

	protected override EntryStream GetEntryStream()
	{
		return new EntryStream(new RarStream(pack, base.Entry.FileHeader, new MultiVolumeReadOnlyStream(CreateFilePartEnumerableForCurrentEntry().Cast<RarFilePart>(), this)));
	}

	public static RarReader Open(Stream stream, string password, Options options = Options.KeepStreamsOpen)
	{
		stream.CheckNotNull("stream");
		return new SingleVolumeRarReader(stream, password, options);
	}
}
