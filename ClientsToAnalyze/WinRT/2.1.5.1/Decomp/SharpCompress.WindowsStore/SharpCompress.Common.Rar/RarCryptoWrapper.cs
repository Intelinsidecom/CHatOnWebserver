using System;
using System.Collections.Generic;
using System.IO;

namespace SharpCompress.Common.Rar;

internal class RarCryptoWrapper : Stream
{
	private readonly Stream actualStream;

	private readonly byte[] salt;

	private RarRijndael rijndael;

	private readonly Queue<byte> data = new Queue<byte>();

	public override bool CanRead
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override bool CanSeek
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override bool CanWrite
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override long Length
	{
		get
		{
			throw new NotImplementedException();
		}
	}

	public override long Position { get; set; }

	public RarCryptoWrapper(Stream actualStream, string password, byte[] salt)
	{
		this.actualStream = actualStream;
		this.salt = salt;
		rijndael = RarRijndael.InitializeFrom(password, salt);
	}

	public override void Flush()
	{
		throw new NotImplementedException();
	}

	public override long Seek(long offset, SeekOrigin origin)
	{
		throw new NotImplementedException();
	}

	public override void SetLength(long value)
	{
		throw new NotImplementedException();
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		if (salt == null)
		{
			return actualStream.Read(buffer, offset, count);
		}
		return ReadAndDecrypt(buffer, offset, count);
	}

	public int ReadAndDecrypt(byte[] buffer, int offset, int count)
	{
		int count2 = data.Count;
		int num = count - count2;
		if (num > 0)
		{
			int num2 = num + ((~num + 1) & 0xF);
			for (int i = 0; i < num2 / 16; i++)
			{
				byte[] array = new byte[16];
				actualStream.Read(array, 0, 16);
				byte[] array2 = rijndael.ProcessBlock(array);
				byte[] array3 = array2;
				foreach (byte item in array3)
				{
					data.Enqueue(item);
				}
			}
			for (int k = 0; k < count; k++)
			{
				buffer[offset + k] = data.Dequeue();
			}
		}
		return count;
	}

	public override void Write(byte[] buffer, int offset, int count)
	{
		throw new NotImplementedException();
	}

	protected override void Dispose(bool disposing)
	{
		if (rijndael != null)
		{
			rijndael.Dispose();
			rijndael = null;
		}
		base.Dispose(disposing);
	}
}
