using SharpCompress.IO;

namespace SharpCompress.Common.Rar.Headers;

internal class AVHeader : RarHeader
{
	internal int AVInfoCRC { get; private set; }

	internal byte UnpackVersion { get; private set; }

	internal byte Method { get; private set; }

	internal byte AVVersion { get; private set; }

	protected override void ReadFromReader(MarkingBinaryReader reader)
	{
		UnpackVersion = reader.ReadByte();
		Method = reader.ReadByte();
		AVVersion = reader.ReadByte();
		AVInfoCRC = reader.ReadInt32();
	}
}
