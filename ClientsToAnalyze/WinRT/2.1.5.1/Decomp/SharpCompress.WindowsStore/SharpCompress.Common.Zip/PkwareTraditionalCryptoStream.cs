using System;
using System.IO;

namespace SharpCompress.Common.Zip;

internal class PkwareTraditionalCryptoStream : Stream
{
	private readonly PkwareTraditionalEncryptionData encryptor;

	private readonly CryptoMode mode;

	private readonly Stream stream;

	private bool isDisposed;

	public override bool CanRead => mode == CryptoMode.Decrypt;

	public override bool CanSeek => false;

	public override bool CanWrite => mode == CryptoMode.Encrypt;

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

	public PkwareTraditionalCryptoStream(Stream stream, PkwareTraditionalEncryptionData encryptor, CryptoMode mode)
	{
		this.encryptor = encryptor;
		this.stream = stream;
		this.mode = mode;
	}

	public override int Read(byte[] buffer, int offset, int count)
	{
		if (mode == CryptoMode.Encrypt)
		{
			throw new NotSupportedException("This stream does not encrypt via Read()");
		}
		if (buffer == null)
		{
			throw new ArgumentNullException("buffer");
		}
		byte[] array = new byte[count];
		int num = stream.Read(array, 0, count);
		byte[] src = encryptor.Decrypt(array, num);
		Buffer.BlockCopy(src, 0, buffer, offset, num);
		return num;
	}

	public override void Write(byte[] buffer, int offset, int count)
	{
		if (mode == CryptoMode.Decrypt)
		{
			throw new NotSupportedException("This stream does not Decrypt via Write()");
		}
		if (count != 0)
		{
			byte[] array = null;
			if (offset != 0)
			{
				array = new byte[count];
				Buffer.BlockCopy(buffer, offset, array, 0, count);
			}
			else
			{
				array = buffer;
			}
			byte[] array2 = encryptor.Encrypt(array, count);
			stream.Write(array2, 0, array2.Length);
		}
	}

	public override void Flush()
	{
	}

	public override long Seek(long offset, SeekOrigin origin)
	{
		throw new NotSupportedException();
	}

	public override void SetLength(long value)
	{
		throw new NotSupportedException();
	}

	protected override void Dispose(bool disposing)
	{
		if (!isDisposed)
		{
			isDisposed = true;
			base.Dispose(disposing);
			stream.Dispose();
		}
	}
}
