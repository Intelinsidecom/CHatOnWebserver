namespace SharpCompress.Common.Zip.Headers;

internal class ExtraData
{
	internal ExtraDataType Type { get; set; }

	internal ushort Length { get; set; }

	internal byte[] DataBytes { get; set; }
}
