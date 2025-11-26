namespace SharpCompress.Compressor.Rar.VM;

internal class VMStandardFilterSignature
{
	internal int Length { get; private set; }

	internal uint CRC { get; private set; }

	internal VMStandardFilters Type { get; private set; }

	internal VMStandardFilterSignature(int length, uint crc, VMStandardFilters type)
	{
		Length = length;
		CRC = crc;
		Type = type;
	}
}
