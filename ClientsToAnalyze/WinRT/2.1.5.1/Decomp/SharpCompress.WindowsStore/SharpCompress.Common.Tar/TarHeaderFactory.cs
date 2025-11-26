using System.Collections.Generic;
using System.IO;
using SharpCompress.Common.Tar.Headers;
using SharpCompress.IO;

namespace SharpCompress.Common.Tar;

internal static class TarHeaderFactory
{
	internal static IEnumerable<TarHeader> ReadHeader(StreamingMode mode, Stream stream)
	{
		while (true)
		{
			TarHeader header;
			try
			{
				BinaryReader binaryReader = new BinaryReader(stream);
				header = new TarHeader();
				if (!header.Read(binaryReader))
				{
					break;
				}
				switch (mode)
				{
				case StreamingMode.Seekable:
					header.DataStartPosition = binaryReader.BaseStream.Position;
					binaryReader.BaseStream.Position += PadTo512(header.Size);
					break;
				case StreamingMode.Streaming:
					header.PackedStream = new TarReadOnlySubStream(stream, header.Size);
					break;
				default:
					throw new InvalidFormatException("Invalid StreamingMode");
				}
			}
			catch
			{
				header = null;
			}
			yield return header;
		}
	}

	private static long PadTo512(long size)
	{
		int num = (int)(size % 512);
		if (num == 0)
		{
			return size;
		}
		return 512 - num + size;
	}
}
