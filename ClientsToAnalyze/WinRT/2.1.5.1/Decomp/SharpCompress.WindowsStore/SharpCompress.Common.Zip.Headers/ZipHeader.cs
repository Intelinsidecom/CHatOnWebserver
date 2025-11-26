using System.IO;

namespace SharpCompress.Common.Zip.Headers;

internal abstract class ZipHeader
{
	internal ZipHeaderType ZipHeaderType { get; private set; }

	internal bool HasData { get; set; }

	protected ZipHeader(ZipHeaderType type)
	{
		ZipHeaderType = type;
		HasData = true;
	}

	internal abstract void Read(BinaryReader reader);

	internal abstract void Write(BinaryWriter writer);
}
