using System;
using System.IO;
using System.Linq;
using SharpCompress.Common.Zip.Headers;
using SharpCompress.Compressor;
using SharpCompress.Compressor.BZip2;
using SharpCompress.Compressor.Deflate;
using SharpCompress.Compressor.LZMA;
using SharpCompress.Compressor.PPMd;
using SharpCompress.IO;

namespace SharpCompress.Common.Zip;

internal abstract class ZipFilePart : FilePart
{
	internal Stream BaseStream { get; private set; }

	internal ZipFileEntry Header { get; set; }

	internal override string FilePartName => Header.Name;

	protected bool LeaveStreamOpen => FlagUtility.HasFlag(Header.Flags, HeaderFlags.UsePostDataDescriptor);

	internal ZipFilePart(ZipFileEntry header, Stream stream)
	{
		Header = header;
		header.Part = this;
		BaseStream = stream;
	}

	internal override Stream GetCompressedStream()
	{
		if (!Header.HasData)
		{
			return Stream.Null;
		}
		Stream stream = CreateDecompressionStream(GetCryptoStream(CreateBaseStream()));
		if (LeaveStreamOpen)
		{
			return new NonDisposingStream(stream);
		}
		return stream;
	}

	internal override Stream GetRawStream()
	{
		if (!Header.HasData)
		{
			return Stream.Null;
		}
		return CreateBaseStream();
	}

	protected abstract Stream CreateBaseStream();

	protected Stream CreateDecompressionStream(Stream stream)
	{
		switch (Header.CompressionMethod)
		{
		case ZipCompressionMethod.None:
			return stream;
		case ZipCompressionMethod.Deflate:
			return new DeflateStream(stream, CompressionMode.Decompress);
		case ZipCompressionMethod.BZip2:
			return new BZip2Stream(stream, CompressionMode.Decompress);
		case ZipCompressionMethod.LZMA:
		{
			if (FlagUtility.HasFlag(Header.Flags, HeaderFlags.Encrypted))
			{
				throw new NotSupportedException("LZMA with pkware encryption.");
			}
			BinaryReader binaryReader = new BinaryReader(stream);
			binaryReader.ReadUInt16();
			byte[] array = new byte[binaryReader.ReadUInt16()];
			binaryReader.Read(array, 0, array.Length);
			return new LzmaStream(array, stream, (Header.CompressedSize != 0) ? (Header.CompressedSize - 4 - array.Length) : (-1), FlagUtility.HasFlag(Header.Flags, HeaderFlags.Bit1) ? (-1L) : ((long)Header.UncompressedSize));
		}
		case ZipCompressionMethod.PPMd:
		{
			byte[] array2 = new byte[2];
			stream.Read(array2, 0, array2.Length);
			return new PpmdStream(new PpmdProperties(array2), stream, compress: false);
		}
		case ZipCompressionMethod.WinzipAes:
		{
			ExtraData extraData = Header.Extra.Where((ExtraData x) => x.Type == ExtraDataType.WinZipAes).SingleOrDefault();
			if (extraData == null)
			{
				throw new InvalidFormatException("No Winzip AES extra data found.");
			}
			if (extraData.Length != 7)
			{
				throw new InvalidFormatException("Winzip data length is not 7.");
			}
			ushort num = BitConverter.ToUInt16(extraData.DataBytes, 0);
			if (num != 1 && num != 2)
			{
				throw new InvalidFormatException("Unexpected vendor version number for WinZip AES metadata");
			}
			ushort num2 = BitConverter.ToUInt16(extraData.DataBytes, 2);
			if (num2 != 17729)
			{
				throw new InvalidFormatException("Unexpected vendor ID for WinZip AES metadata");
			}
			Header.CompressionMethod = (ZipCompressionMethod)BitConverter.ToUInt16(extraData.DataBytes, 5);
			return CreateDecompressionStream(stream);
		}
		default:
			throw new NotSupportedException("CompressionMethod: " + Header.CompressionMethod);
		}
	}

	protected Stream GetCryptoStream(Stream plainStream)
	{
		if (Header.CompressedSize == 0 && Header.PkwareTraditionalEncryptionData != null)
		{
			throw new NotSupportedException("Cannot encrypt file with unknown size at start.");
		}
		plainStream = ((Header.CompressedSize != 0 || !FlagUtility.HasFlag(Header.Flags, HeaderFlags.UsePostDataDescriptor)) ? ((Stream)new ReadOnlySubStream(plainStream, Header.CompressedSize)) : ((Stream)new NonDisposingStream(plainStream)));
		if (Header.PkwareTraditionalEncryptionData != null)
		{
			return new PkwareTraditionalCryptoStream(plainStream, Header.PkwareTraditionalEncryptionData, CryptoMode.Decrypt);
		}
		return plainStream;
	}
}
