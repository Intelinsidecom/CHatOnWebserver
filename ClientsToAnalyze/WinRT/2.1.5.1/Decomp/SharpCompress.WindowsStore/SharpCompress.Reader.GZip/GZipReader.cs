using System.Collections.Generic;
using System.IO;
using SharpCompress.Common;
using SharpCompress.Common.GZip;

namespace SharpCompress.Reader.GZip;

public class GZipReader : AbstractReader<GZipEntry, GZipVolume>
{
	private readonly GZipVolume volume;

	public override GZipVolume Volume => volume;

	internal GZipReader(Stream stream, Options options)
		: base(options, ArchiveType.GZip)
	{
		volume = new GZipVolume(stream, options);
	}

	public static GZipReader Open(Stream stream, Options options = Options.KeepStreamsOpen)
	{
		stream.CheckNotNull("stream");
		return new GZipReader(stream, options);
	}

	internal override IEnumerable<GZipEntry> GetEntries(Stream stream)
	{
		return GZipEntry.GetEntries(stream);
	}
}
