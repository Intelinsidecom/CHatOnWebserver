using System;
using System.Collections.Generic;
using System.IO;
using SharpCompress.IO;

namespace SharpCompress.Common.Rar.Headers;

internal class RarHeaderFactory
{
	private const int MAX_SFX_SIZE = 524272;

	private Options Options { get; set; }

	public string Password { get; private set; }

	internal StreamingMode StreamingMode { get; private set; }

	internal bool IsEncrypted { get; private set; }

	internal RarHeaderFactory(StreamingMode mode, Options options, string password = null)
	{
		StreamingMode = mode;
		Options = options;
		Password = password;
	}

	internal IEnumerable<RarHeader> ReadHeaders(Stream stream)
	{
		if (Options.HasFlag(Options.LookForHeader))
		{
			stream = CheckSFX(stream);
		}
		RarHeader header;
		do
		{
			RarHeader rarHeader;
			header = (rarHeader = ReadNextHeader(stream));
			if (rarHeader != null)
			{
				yield return header;
				continue;
			}
			break;
		}
		while (header.HeaderType != HeaderType.EndArchiveHeader);
	}

	private Stream CheckSFX(Stream stream)
	{
		RewindableStream rewindableStream = GetRewindableStream(stream);
		stream = rewindableStream;
		BinaryReader binaryReader = new BinaryReader(rewindableStream);
		try
		{
			int num = 0;
			do
			{
				byte b = binaryReader.ReadByte();
				if (b == 82)
				{
					MemoryStream memoryStream = new MemoryStream();
					byte[] array = binaryReader.ReadBytes(3);
					if (array[0] == 69 && array[1] == 126 && array[2] == 94)
					{
						memoryStream.WriteByte(82);
						memoryStream.Write(array, 0, 3);
						rewindableStream.Rewind(memoryStream);
						break;
					}
					byte[] array2 = binaryReader.ReadBytes(3);
					if (array[0] == 97 && array[1] == 114 && array[2] == 33 && array2[0] == 26 && array2[1] == 7 && array2[2] == 0)
					{
						memoryStream.WriteByte(82);
						memoryStream.Write(array, 0, 3);
						memoryStream.Write(array2, 0, 3);
						rewindableStream.Rewind(memoryStream);
						break;
					}
					memoryStream.Write(array, 0, 3);
					memoryStream.Write(array2, 0, 3);
					rewindableStream.Rewind(memoryStream);
				}
			}
			while (num <= 524272);
		}
		catch (Exception inner)
		{
			if (!Options.HasFlag(Options.KeepStreamsOpen))
			{
				binaryReader.Dispose();
			}
			throw new InvalidFormatException("Error trying to read rar signature.", inner);
		}
		return stream;
	}

	private RewindableStream GetRewindableStream(Stream stream)
	{
		RewindableStream rewindableStream = stream as RewindableStream;
		if (rewindableStream == null)
		{
			rewindableStream = new RewindableStream(stream);
		}
		return rewindableStream;
	}

	private RarHeader ReadNextHeader(Stream stream)
	{
		RarCryptoBinaryReader rarCryptoBinaryReader = new RarCryptoBinaryReader(stream, Password);
		if (IsEncrypted)
		{
			rarCryptoBinaryReader.SkipQueue();
			byte[] salt = rarCryptoBinaryReader.ReadBytes(8);
			rarCryptoBinaryReader.InitializeAes(salt);
		}
		RarHeader rarHeader = RarHeader.Create(rarCryptoBinaryReader);
		if (rarHeader == null)
		{
			return null;
		}
		switch (rarHeader.HeaderType)
		{
		case HeaderType.ArchiveHeader:
		{
			ArchiveHeader archiveHeader = rarHeader.PromoteHeader<ArchiveHeader>(rarCryptoBinaryReader);
			IsEncrypted = archiveHeader.HasPassword;
			return archiveHeader;
		}
		case HeaderType.MarkHeader:
			return rarHeader.PromoteHeader<MarkHeader>(rarCryptoBinaryReader);
		case HeaderType.NewSubHeader:
		{
			FileHeader fileHeader2 = rarHeader.PromoteHeader<FileHeader>(rarCryptoBinaryReader);
			switch (StreamingMode)
			{
			case StreamingMode.Seekable:
				fileHeader2.DataStartPosition = rarCryptoBinaryReader.BaseStream.Position;
				rarCryptoBinaryReader.BaseStream.Position += fileHeader2.CompressedSize;
				break;
			case StreamingMode.Streaming:
				rarCryptoBinaryReader.BaseStream.Skip(fileHeader2.CompressedSize);
				break;
			default:
				throw new InvalidFormatException("Invalid StreamingMode");
			}
			return fileHeader2;
		}
		case HeaderType.FileHeader:
		{
			FileHeader fileHeader = rarHeader.PromoteHeader<FileHeader>(rarCryptoBinaryReader);
			switch (StreamingMode)
			{
			case StreamingMode.Seekable:
				fileHeader.DataStartPosition = rarCryptoBinaryReader.BaseStream.Position;
				rarCryptoBinaryReader.BaseStream.Position += fileHeader.CompressedSize;
				break;
			case StreamingMode.Streaming:
			{
				ReadOnlySubStream readOnlySubStream = new ReadOnlySubStream(rarCryptoBinaryReader.BaseStream, fileHeader.CompressedSize);
				if (fileHeader.Salt == null)
				{
					fileHeader.PackedStream = readOnlySubStream;
				}
				else
				{
					fileHeader.PackedStream = new RarCryptoWrapper(readOnlySubStream, Password, fileHeader.Salt);
				}
				break;
			}
			default:
				throw new InvalidFormatException("Invalid StreamingMode");
			}
			return fileHeader;
		}
		case HeaderType.EndArchiveHeader:
			return rarHeader.PromoteHeader<EndArchiveHeader>(rarCryptoBinaryReader);
		default:
			throw new InvalidFormatException("Invalid Rar Header: " + rarHeader.HeaderType);
		}
	}
}
