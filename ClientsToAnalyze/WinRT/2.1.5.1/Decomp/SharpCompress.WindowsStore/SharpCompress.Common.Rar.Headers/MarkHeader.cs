using SharpCompress.IO;

namespace SharpCompress.Common.Rar.Headers;

internal class MarkHeader : RarHeader
{
	internal bool OldFormat { get; private set; }

	protected override void ReadFromReader(MarkingBinaryReader reader)
	{
	}

	internal bool IsValid()
	{
		if (base.HeadCRC != 24914)
		{
			return false;
		}
		if (base.HeaderType != HeaderType.MarkHeader)
		{
			return false;
		}
		if (base.Flags != 6689)
		{
			return false;
		}
		if (base.HeaderSize != 7)
		{
			return false;
		}
		return true;
	}

	internal bool IsSignature()
	{
		return false;
	}
}
