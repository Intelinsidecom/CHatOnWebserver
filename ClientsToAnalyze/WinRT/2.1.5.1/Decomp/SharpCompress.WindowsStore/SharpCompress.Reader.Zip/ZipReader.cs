using System.Collections.Generic;
using System.IO;
using SharpCompress.Common;
using SharpCompress.Common.Zip;
using SharpCompress.Common.Zip.Headers;

namespace SharpCompress.Reader.Zip;

public class ZipReader : AbstractReader<ZipEntry, ZipVolume>
{
	private readonly StreamingZipHeaderFactory headerFactory;

	private readonly ZipVolume volume;

	public override ZipVolume Volume => volume;

	internal ZipReader(Stream stream, Options options, string password)
		: base(options, ArchiveType.Zip)
	{
		volume = new ZipVolume(stream, options);
		headerFactory = new StreamingZipHeaderFactory(password);
	}

	public static ZipReader Open(Stream stream, string password = null, Options options = Options.KeepStreamsOpen)
	{
		stream.CheckNotNull("stream");
		return new ZipReader(stream, options, password);
	}

	internal override IEnumerable<ZipEntry> GetEntries(Stream stream)
	{
		foreach (ZipHeader h in headerFactory.ReadStreamHeader(stream))
		{
			if (h != null)
			{
				switch (h.ZipHeaderType)
				{
				case ZipHeaderType.LocalEntry:
					yield return new ZipEntry(new StreamingZipFilePart(h as LocalEntryHeader, stream));
					break;
				case ZipHeaderType.DirectoryEnd:
					yield break;
				}
			}
		}
	}
}
