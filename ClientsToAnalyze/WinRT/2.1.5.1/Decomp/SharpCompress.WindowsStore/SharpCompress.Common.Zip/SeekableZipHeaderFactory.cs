using System;
using System.Collections.Generic;
using System.IO;
using SharpCompress.Common.Zip.Headers;
using SharpCompress.IO;

namespace SharpCompress.Common.Zip;

internal class SeekableZipHeaderFactory : ZipHeaderFactory
{
	private const int MAX_ITERATIONS_FOR_DIRECTORY_HEADER = 1000;

	internal SeekableZipHeaderFactory(string password)
		: base(StreamingMode.Seekable, password)
	{
	}

	internal IEnumerable<DirectoryEntryHeader> ReadSeekableHeader(Stream stream)
	{
		long offset = 0L;
		BinaryReader reader = new BinaryReader(stream);
		int iterationCount = 0;
		uint signature;
		do
		{
			if (stream.Length + offset - 4 < 0)
			{
				throw new ArchiveException("Failed to locate the Zip Header");
			}
			stream.Seek(offset - 4, SeekOrigin.End);
			signature = reader.ReadUInt32();
			offset--;
			iterationCount++;
			if (iterationCount > 1000)
			{
				throw new ArchiveException("Could not find Zip file Directory at the end of the file.  File may be corrupted.");
			}
		}
		while (signature != 101010256);
		DirectoryEndHeader entry = new DirectoryEndHeader();
		entry.Read(reader);
		stream.Seek(entry.DirectoryStartOffsetRelativeToDisk, SeekOrigin.Begin);
		long position = stream.Position;
		while (true)
		{
			stream.Position = position;
			signature = reader.ReadUInt32();
			DirectoryEntryHeader directoryEntryHeader = ReadHeader(signature, reader) as DirectoryEntryHeader;
			position = stream.Position;
			if (directoryEntryHeader != null)
			{
				directoryEntryHeader.HasData = directoryEntryHeader.CompressedSize != 0;
				yield return directoryEntryHeader;
				continue;
			}
			break;
		}
	}

	internal LocalEntryHeader GetLocalHeader(Stream stream, DirectoryEntryHeader directoryEntryHeader)
	{
		stream.Seek(directoryEntryHeader.RelativeOffsetOfEntryHeader, SeekOrigin.Begin);
		BinaryReader binaryReader = new BinaryReader(stream);
		uint headerBytes = binaryReader.ReadUInt32();
		if (!(ReadHeader(headerBytes, binaryReader) is LocalEntryHeader result))
		{
			throw new InvalidOperationException();
		}
		return result;
	}
}
