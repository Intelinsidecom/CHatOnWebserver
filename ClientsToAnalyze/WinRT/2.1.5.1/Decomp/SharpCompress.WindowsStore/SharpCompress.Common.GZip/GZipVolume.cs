using System.IO;

namespace SharpCompress.Common.GZip;

public class GZipVolume : Volume
{
	public override bool IsFirstVolume => true;

	public override bool IsMultiVolume => true;

	public GZipVolume(Stream stream, Options options)
		: base(stream, options)
	{
	}
}
