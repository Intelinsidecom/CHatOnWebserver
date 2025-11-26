using System.IO;

namespace SharpCompress.Common.Zip;

public class ZipVolume : GenericVolume
{
	public string Comment { get; internal set; }

	public ZipVolume(Stream stream, Options options)
		: base(stream, options)
	{
	}
}
