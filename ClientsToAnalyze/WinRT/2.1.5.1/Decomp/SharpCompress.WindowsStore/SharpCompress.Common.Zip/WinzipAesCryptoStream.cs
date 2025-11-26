using System;
using System.IO;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Engines;
using Org.BouncyCastle.Crypto.Parameters;

namespace SharpCompress.Common.Zip;

internal class WinzipAesCryptoStream : Stream
{
	private const int BLOCK_SIZE_IN_BYTES = 16;

	private readonly IBufferedCipher rijndael;

	private readonly byte[] counter = new byte[16];

	private readonly Stream stream;

	private int nonce = 1;

	private byte[] counterOut = new byte[16];

	private bool isFinalBlock;

	private long totalBytesLeftToRead;

	private bool isDisposed;

	public override bool CanRead => true;

	public override bool CanSeek => false;

	public override bool CanWrite => false;

	public override long Length
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override long Position
	{
		get
		{
			throw new NotImplementedException();
		}
		set
		{
			throw new NotImplementedException();
		}
	}

	internal WinzipAesCryptoStream(Stream stream, WinzipAesEncryptionData winzipAesEncryptionData, long length)
	{
		this.stream = stream;
		totalBytesLeftToRead = length;
		rijndael = CreateRijndael(winzipAesEncryptionData);
	}

	private IBufferedCipher CreateRijndael(WinzipAesEncryptionData winzipAesEncryptionData)
	{
		BufferedBlockCipher bufferedBlockCipher = new BufferedBlockCipher(new RijndaelEngine());
		KeyParameter parameters = new KeyParameter(winzipAesEncryptionData.KeyBytes);
		bufferedBlockCipher.Init(forEncryption: true, parameters);
		return bufferedBlockCipher;
	}

	protected override void Dispose(bool disposing)
	{
		if (!isDisposed)
		{
			isDisposed = true;
			if (disposing)
			{
				byte[] buffer = new byte[10];
				stream.Read(buffer, 0, 10);
				stream.Dispose();
			}
		}
	}

	public override void Flush()
	{
		throw new NotImplementedException();
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		if (totalBytesLeftToRead == 0)
		{
			return 0;
		}
		int count2 = count;
		if (count > totalBytesLeftToRead)
		{
			count2 = (int)totalBytesLeftToRead;
		}
		int num = stream.Read(buffer, offset, count2);
		totalBytesLeftToRead -= num;
		ReadTransformBlocks(buffer, offset, num);
		return num;
	}

	private int ReadTransformOneBlock(byte[] buffer, int offset, int last)
	{
		if (isFinalBlock)
		{
			throw new InvalidOperationException();
		}
		int num = last - offset;
		int num2 = ((num > 16) ? 16 : num);
		Array.Copy(BitConverter.GetBytes(nonce++), 0, counter, 0, 4);
		if (num2 == num && totalBytesLeftToRead == 0)
		{
			counterOut = rijndael.DoFinal(counter, 0, 16);
			isFinalBlock = true;
		}
		else
		{
			rijndael.ProcessBytes(counter, 0, 16, counterOut, 0);
		}
		XorInPlace(buffer, offset, num2);
		return num2;
	}

	private void XorInPlace(byte[] buffer, int offset, int count)
	{
		for (int i = 0; i < count; i++)
		{
			buffer[offset + i] = (byte)(counterOut[i] ^ buffer[offset + i]);
		}
	}

	private void ReadTransformBlocks(byte[] buffer, int offset, int count)
	{
		int i = offset;
		int num2;
		for (int num = count + offset; i < buffer.Length && i < num; i += num2)
		{
			num2 = ReadTransformOneBlock(buffer, i, num);
		}
	}

	public override long Seek(long offset, SeekOrigin origin)
	{
		throw new NotImplementedException();
	}

	public override void SetLength(long value)
	{
		throw new NotImplementedException();
	}

	public override void Write(byte[] buffer, int offset, int count)
	{
		throw new NotImplementedException();
	}
}
