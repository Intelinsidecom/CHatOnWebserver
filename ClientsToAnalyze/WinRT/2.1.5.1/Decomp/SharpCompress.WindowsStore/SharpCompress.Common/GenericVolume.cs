using System.IO;

namespace SharpCompress.Common;

public class GenericVolume : Volume
{
	public override bool IsFirstVolume => true;

	public override bool IsMultiVolume => true;

	public GenericVolume(Stream stream, Options options)
		: base(stream, options)
	{
	}
}
