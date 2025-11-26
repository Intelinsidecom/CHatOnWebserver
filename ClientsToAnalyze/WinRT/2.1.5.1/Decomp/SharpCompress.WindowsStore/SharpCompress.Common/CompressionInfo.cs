using SharpCompress.Compressor.Deflate;

namespace SharpCompress.Common;

public class CompressionInfo
{
	public CompressionType Type { get; set; }

	public CompressionLevel DeflateCompressionLevel { get; set; }

	public CompressionInfo()
	{
		DeflateCompressionLevel = CompressionLevel.Default;
	}

	public static implicit operator CompressionInfo(CompressionType compressionType)
	{
		CompressionInfo compressionInfo = new CompressionInfo();
		compressionInfo.Type = compressionType;
		return compressionInfo;
	}
}
