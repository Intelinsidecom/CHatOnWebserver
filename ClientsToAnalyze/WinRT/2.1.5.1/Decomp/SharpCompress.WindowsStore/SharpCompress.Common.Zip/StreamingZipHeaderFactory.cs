using System.Collections.Generic;
using System.IO;
using SharpCompress.Common.Zip.Headers;
using SharpCompress.IO;

namespace SharpCompress.Common.Zip;

internal class StreamingZipHeaderFactory : ZipHeaderFactory
{
	internal StreamingZipHeaderFactory(string password)
		: base(StreamingMode.Streaming, password)
	{
	}

	internal IEnumerable<ZipHeader> ReadStreamHeader(Stream stream)
	{
		RewindableStream rewindableStream = ((!(stream is RewindableStream)) ? new RewindableStream(stream) : (stream as RewindableStream));
		while (true)
		{
			BinaryReader reader = new BinaryReader(rewindableStream);
			if (lastEntryHeader != null && FlagUtility.HasFlag(lastEntryHeader.Flags, HeaderFlags.UsePostDataDescriptor))
			{
				reader = (lastEntryHeader.Part as StreamingZipFilePart).FixStreamedFileLocation(ref rewindableStream);
				long position = rewindableStream.Position;
				uint num = reader.ReadUInt32();
				if (num == 134695760)
				{
					num = reader.ReadUInt32();
				}
				lastEntryHeader.Crc = num;
				lastEntryHeader.CompressedSize = reader.ReadUInt32();
				lastEntryHeader.UncompressedSize = reader.ReadUInt32();
				lastEntryHeader.DataStartPosition = position - lastEntryHeader.CompressedSize;
			}
			lastEntryHeader = null;
			uint headerBytes = reader.ReadUInt32();
			ZipHeader header = ReadHeader(headerBytes, reader);
			if (header.ZipHeaderType == ZipHeaderType.LocalEntry)
			{
				bool isRecording = rewindableStream.IsRecording;
				if (!isRecording)
				{
					rewindableStream.StartRecording();
				}
				uint headerBytes2 = reader.ReadUInt32();
				header.HasData = !ZipHeaderFactory.IsHeader(headerBytes2);
				rewindableStream.Rewind(!isRecording);
			}
			yield return header;
		}
	}
}
