using System;
using System.IO;
using SharpCompress.Common.Zip.Headers;
using SharpCompress.IO;

namespace SharpCompress.Common.Zip;

internal class ZipHeaderFactory
{
	internal const uint ENTRY_HEADER_BYTES = 67324752u;

	internal const uint POST_DATA_DESCRIPTOR = 134695760u;

	internal const uint DIRECTORY_START_HEADER_BYTES = 33639248u;

	internal const uint DIRECTORY_END_HEADER_BYTES = 101010256u;

	internal const uint DIGITAL_SIGNATURE = 84233040u;

	internal const uint SPLIT_ARCHIVE_HEADER_BYTES = 808471376u;

	private const uint ZIP64_END_OF_CENTRAL_DIRECTORY = 101075792u;

	private const uint ZIP64_END_OF_CENTRAL_DIRECTORY_LOCATOR = 117853008u;

	protected LocalEntryHeader lastEntryHeader;

	private string password;

	private StreamingMode mode;

	protected ZipHeaderFactory(StreamingMode mode, string password)
	{
		this.mode = mode;
		this.password = password;
	}

	protected ZipHeader ReadHeader(uint headerBytes, BinaryReader reader)
	{
		switch (headerBytes)
		{
		case 67324752u:
		{
			LocalEntryHeader localEntryHeader = new LocalEntryHeader();
			localEntryHeader.Read(reader);
			LoadHeader(localEntryHeader, reader.BaseStream);
			lastEntryHeader = localEntryHeader;
			return localEntryHeader;
		}
		case 33639248u:
		{
			DirectoryEntryHeader directoryEntryHeader = new DirectoryEntryHeader();
			directoryEntryHeader.Read(reader);
			return directoryEntryHeader;
		}
		case 134695760u:
			if (FlagUtility.HasFlag(lastEntryHeader.Flags, HeaderFlags.UsePostDataDescriptor))
			{
				lastEntryHeader.Crc = reader.ReadUInt32();
				lastEntryHeader.CompressedSize = reader.ReadUInt32();
				lastEntryHeader.UncompressedSize = reader.ReadUInt32();
			}
			else
			{
				reader.ReadUInt32();
				reader.ReadUInt32();
				reader.ReadUInt32();
			}
			return null;
		case 84233040u:
			return null;
		case 101010256u:
		{
			DirectoryEndHeader directoryEndHeader = new DirectoryEndHeader();
			directoryEndHeader.Read(reader);
			return directoryEndHeader;
		}
		case 808471376u:
			return new SplitHeader();
		case 101075792u:
		case 117853008u:
		{
			IgnoreHeader ignoreHeader = new IgnoreHeader(ZipHeaderType.Ignore);
			ignoreHeader.Read(reader);
			return ignoreHeader;
		}
		default:
			throw new NotSupportedException("Unknown header: " + headerBytes);
		}
	}

	internal static bool IsHeader(uint headerBytes)
	{
		switch (headerBytes)
		{
		case 33639248u:
		case 67324752u:
		case 84233040u:
		case 101010256u:
		case 101075792u:
		case 117853008u:
		case 134695760u:
		case 808471376u:
			return true;
		default:
			return false;
		}
	}

	private void LoadHeader(ZipFileEntry entryHeader, Stream stream)
	{
		if (FlagUtility.HasFlag(entryHeader.Flags, HeaderFlags.Encrypted))
		{
			if (!entryHeader.IsDirectory && entryHeader.CompressedSize == 0 && FlagUtility.HasFlag(entryHeader.Flags, HeaderFlags.UsePostDataDescriptor))
			{
				throw new NotSupportedException("SharpCompress cannot currently read non-seekable Zip Streams with encrypted data that has been written in a non-seekable manner.");
			}
			if (password == null)
			{
				throw new CryptographicException("No password supplied for encrypted zip.");
			}
			if (entryHeader.CompressionMethod == ZipCompressionMethod.WinzipAes)
			{
				throw new NotSupportedException("Cannot decrypt Winzip AES with Silverlight or WP7.");
			}
			byte[] array = new byte[12];
			stream.Read(array, 0, 12);
			entryHeader.PkwareTraditionalEncryptionData = PkwareTraditionalEncryptionData.ForRead(password, entryHeader, array);
			entryHeader.CompressedSize -= 12u;
		}
		if (!entryHeader.IsDirectory)
		{
			switch (mode)
			{
			case StreamingMode.Seekable:
				entryHeader.DataStartPosition = stream.Position;
				stream.Position += entryHeader.CompressedSize;
				break;
			case StreamingMode.Streaming:
				entryHeader.PackedStream = stream;
				break;
			default:
				throw new InvalidFormatException("Invalid StreamingMode");
			}
		}
	}
}
