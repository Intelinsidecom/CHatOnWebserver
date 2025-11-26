using System;
using System.Collections.Generic;
using System.IO;
using System.Text;
using SharpCompress.Common;
using SharpCompress.Common.Zip;
using SharpCompress.Common.Zip.Headers;
using SharpCompress.Compressor;
using SharpCompress.Compressor.BZip2;
using SharpCompress.Compressor.Deflate;
using SharpCompress.Compressor.LZMA;
using SharpCompress.Compressor.PPMd;
using SharpCompress.IO;

namespace SharpCompress.Writer.Zip;

public class ZipWriter : AbstractWriter
{
	internal class ZipWritingStream : Stream
	{
		private readonly CRC32 crc = new CRC32();

		private readonly ZipCentralDirectoryEntry entry;

		private readonly Stream originalStream;

		private readonly Stream writeStream;

		private readonly ZipWriter writer;

		private CountingWritableSubStream counting;

		private uint decompressed;

		public override bool CanRead => false;

		public override bool CanSeek => false;

		public override bool CanWrite => true;

		public override long Length
		{
			get
			{
				throw new NotSupportedException();
			}
		}

		public override long Position
		{
			get
			{
				throw new NotSupportedException();
			}
			set
			{
				throw new NotSupportedException();
			}
		}

		internal ZipWritingStream(ZipWriter writer, Stream originalStream, ZipCentralDirectoryEntry entry)
		{
			this.writer = writer;
			this.originalStream = originalStream;
			writeStream = GetWriteStream(originalStream);
			this.writer = writer;
			this.entry = entry;
		}

		private Stream GetWriteStream(Stream writeStream)
		{
			counting = new CountingWritableSubStream(writeStream);
			Stream result = counting;
			switch (writer.compression)
			{
			case ZipCompressionMethod.None:
				return result;
			case ZipCompressionMethod.Deflate:
				return new DeflateStream(counting, CompressionMode.Compress, writer.deflateCompressionLevel, leaveOpen: true);
			case ZipCompressionMethod.BZip2:
				return new BZip2Stream(counting, CompressionMode.Compress, leaveOpen: true);
			case ZipCompressionMethod.LZMA:
			{
				counting.WriteByte(9);
				counting.WriteByte(20);
				counting.WriteByte(5);
				counting.WriteByte(0);
				LzmaStream lzmaStream = new LzmaStream(new LzmaEncoderProperties(!originalStream.CanSeek), isLZMA2: false, counting);
				counting.Write(lzmaStream.Properties, 0, lzmaStream.Properties.Length);
				return lzmaStream;
			}
			case ZipCompressionMethod.PPMd:
				counting.Write(writer.ppmdProperties.Properties, 0, 2);
				return new PpmdStream(writer.ppmdProperties, counting, compress: true);
			default:
				throw new NotSupportedException("CompressionMethod: " + writer.compression);
			}
		}

		protected override void Dispose(bool disposing)
		{
			base.Dispose(disposing);
			if (disposing)
			{
				writeStream.Dispose();
				entry.Crc = (uint)crc.Crc32Result;
				entry.Compressed = counting.Count;
				entry.Decompressed = decompressed;
				if (originalStream.CanSeek)
				{
					originalStream.Position = entry.HeaderOffset + 6;
					originalStream.WriteByte(0);
					originalStream.Position = entry.HeaderOffset + 14;
					writer.WriteFooter(entry.Crc, counting.Count, decompressed);
					originalStream.Position = writer.streamPosition + entry.Compressed;
					writer.streamPosition += entry.Compressed;
				}
				else
				{
					originalStream.Write(BitConverter.GetBytes(134695760u), 0, 4);
					writer.WriteFooter(entry.Crc, counting.Count, decompressed);
					writer.streamPosition += entry.Compressed + 16;
				}
				writer.entries.Add(entry);
			}
		}

		public override void Flush()
		{
			writeStream.Flush();
		}

		public override int Read(byte[] buffer, int offset, int count)
		{
			throw new NotSupportedException();
		}

		public override long Seek(long offset, SeekOrigin origin)
		{
			throw new NotSupportedException();
		}

		public override void SetLength(long value)
		{
			throw new NotSupportedException();
		}

		public override void Write(byte[] buffer, int offset, int count)
		{
			decompressed += (uint)count;
			crc.SlurpBlock(buffer, offset, count);
			writeStream.Write(buffer, offset, count);
		}
	}

	private readonly ZipCompressionMethod compression;

	private readonly CompressionLevel deflateCompressionLevel;

	private readonly List<ZipCentralDirectoryEntry> entries = new List<ZipCentralDirectoryEntry>();

	private readonly string zipComment;

	private long streamPosition;

	private readonly PpmdProperties ppmdProperties;

	public ZipWriter(Stream destination, CompressionInfo compressionInfo, string zipComment)
		: base(ArchiveType.Zip)
	{
		this.zipComment = zipComment ?? string.Empty;
		switch (compressionInfo.Type)
		{
		case CompressionType.None:
			compression = ZipCompressionMethod.None;
			break;
		case CompressionType.Deflate:
			compression = ZipCompressionMethod.Deflate;
			deflateCompressionLevel = compressionInfo.DeflateCompressionLevel;
			break;
		case CompressionType.BZip2:
			compression = ZipCompressionMethod.BZip2;
			break;
		case CompressionType.LZMA:
			compression = ZipCompressionMethod.LZMA;
			break;
		case CompressionType.PPMd:
			ppmdProperties = new PpmdProperties();
			compression = ZipCompressionMethod.PPMd;
			break;
		default:
			throw new InvalidFormatException("Invalid compression method: " + compressionInfo.Type);
		}
		InitalizeStream(destination, closeStream: false);
	}

	protected override void Dispose(bool isDisposing)
	{
		if (isDisposing)
		{
			uint num = 0u;
			foreach (ZipCentralDirectoryEntry entry in entries)
			{
				num += entry.Write(base.OutputStream, compression);
			}
			WriteEndRecord(num);
		}
		base.Dispose(isDisposing);
	}

	public override void Write(string entryPath, Stream source, DateTime? modificationTime)
	{
		Write(entryPath, source, modificationTime, null);
	}

	public void Write(string entryPath, Stream source, DateTime? modificationTime, string comment)
	{
		using Stream destination = WriteToStream(entryPath, modificationTime, comment);
		source.TransferTo(destination);
	}

	public Stream WriteToStream(string entryPath, DateTime? modificationTime, string comment)
	{
		entryPath = NormalizeFilename(entryPath);
		modificationTime = modificationTime ?? DateTime.Now;
		comment = comment ?? "";
		ZipCentralDirectoryEntry zipCentralDirectoryEntry = new ZipCentralDirectoryEntry();
		zipCentralDirectoryEntry.Comment = comment;
		zipCentralDirectoryEntry.FileName = entryPath;
		zipCentralDirectoryEntry.ModificationTime = modificationTime;
		zipCentralDirectoryEntry.HeaderOffset = (uint)streamPosition;
		ZipCentralDirectoryEntry entry = zipCentralDirectoryEntry;
		uint num = (uint)WriteHeader(entryPath, modificationTime);
		streamPosition += num;
		return new ZipWritingStream(this, base.OutputStream, entry);
	}

	private string NormalizeFilename(string filename)
	{
		filename = filename.Replace('\\', '/');
		int num = filename.IndexOf(':');
		if (num >= 0)
		{
			filename = filename.Remove(0, num + 1);
		}
		return filename.Trim('/');
	}

	private int WriteHeader(string filename, DateTime? modificationTime)
	{
		byte[] bytes = Encoding.UTF8.GetBytes(filename);
		base.OutputStream.Write(BitConverter.GetBytes(67324752u), 0, 4);
		base.OutputStream.Write(new byte[2] { 63, 0 }, 0, 2);
		HeaderFlags headerFlags = HeaderFlags.UTF8;
		if (!base.OutputStream.CanSeek)
		{
			headerFlags |= HeaderFlags.UsePostDataDescriptor;
			if (compression == ZipCompressionMethod.LZMA)
			{
				headerFlags |= HeaderFlags.Bit1;
			}
		}
		base.OutputStream.Write(BitConverter.GetBytes((ushort)headerFlags), 0, 2);
		base.OutputStream.Write(BitConverter.GetBytes((ushort)compression), 0, 2);
		base.OutputStream.Write(BitConverter.GetBytes(modificationTime.DateTimeToDosTime()), 0, 4);
		Stream outputStream = base.OutputStream;
		byte[] buffer = new byte[12];
		outputStream.Write(buffer, 0, 12);
		base.OutputStream.Write(BitConverter.GetBytes((ushort)bytes.Length), 0, 2);
		base.OutputStream.Write(BitConverter.GetBytes((ushort)0), 0, 2);
		base.OutputStream.Write(bytes, 0, bytes.Length);
		return 30 + bytes.Length;
	}

	private void WriteFooter(uint crc, uint compressed, uint uncompressed)
	{
		base.OutputStream.Write(BitConverter.GetBytes(crc), 0, 4);
		base.OutputStream.Write(BitConverter.GetBytes(compressed), 0, 4);
		base.OutputStream.Write(BitConverter.GetBytes(uncompressed), 0, 4);
	}

	private void WriteEndRecord(uint size)
	{
		byte[] bytes = Encoding.UTF8.GetBytes(zipComment);
		base.OutputStream.Write(new byte[8] { 80, 75, 5, 6, 0, 0, 0, 0 }, 0, 8);
		base.OutputStream.Write(BitConverter.GetBytes((ushort)entries.Count), 0, 2);
		base.OutputStream.Write(BitConverter.GetBytes((ushort)entries.Count), 0, 2);
		base.OutputStream.Write(BitConverter.GetBytes(size), 0, 4);
		base.OutputStream.Write(BitConverter.GetBytes((uint)streamPosition), 0, 4);
		base.OutputStream.Write(BitConverter.GetBytes((ushort)bytes.Length), 0, 2);
		base.OutputStream.Write(bytes, 0, bytes.Length);
	}
}
