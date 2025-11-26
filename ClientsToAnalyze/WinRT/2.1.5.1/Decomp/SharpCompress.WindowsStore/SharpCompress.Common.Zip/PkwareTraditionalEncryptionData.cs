using System;
using System.Text;
using SharpCompress.Common.Zip.Headers;
using SharpCompress.Compressor.Deflate;

namespace SharpCompress.Common.Zip;

internal class PkwareTraditionalEncryptionData
{
	private static readonly CRC32 crc32 = new CRC32();

	private readonly uint[] _Keys = new uint[3] { 305419896u, 591751049u, 878082192u };

	private byte MagicByte
	{
		get
		{
			ushort num = (ushort)((ushort)(_Keys[2] & 0xFFFF) | 2);
			return (byte)(num * (num ^ 1) >> 8);
		}
	}

	private PkwareTraditionalEncryptionData(string password)
	{
		Initialize(password);
	}

	public static PkwareTraditionalEncryptionData ForRead(string password, ZipFileEntry header, byte[] encryptionHeader)
	{
		PkwareTraditionalEncryptionData pkwareTraditionalEncryptionData = new PkwareTraditionalEncryptionData(password);
		byte[] array = pkwareTraditionalEncryptionData.Decrypt(encryptionHeader, encryptionHeader.Length);
		if (array[11] != (byte)((header.Crc >> 24) & 0xFF))
		{
			if (!FlagUtility.HasFlag(header.Flags, HeaderFlags.UsePostDataDescriptor))
			{
				throw new CryptographicException("The password did not match.");
			}
			if (array[11] != (byte)((header.LastModifiedTime >> 8) & 0xFF))
			{
				throw new CryptographicException("The password did not match.");
			}
		}
		return pkwareTraditionalEncryptionData;
	}

	public byte[] Decrypt(byte[] cipherText, int length)
	{
		if (length > cipherText.Length)
		{
			throw new ArgumentOutOfRangeException("length", "Bad length during Decryption: the length parameter must be smaller than or equal to the size of the destination array.");
		}
		byte[] array = new byte[length];
		for (int i = 0; i < length; i++)
		{
			byte b = (byte)(cipherText[i] ^ MagicByte);
			UpdateKeys(b);
			array[i] = b;
		}
		return array;
	}

	public byte[] Encrypt(byte[] plainText, int length)
	{
		if (plainText == null)
		{
			throw new ArgumentNullException("plaintext");
		}
		if (length > plainText.Length)
		{
			throw new ArgumentOutOfRangeException("length", "Bad length during Encryption: The length parameter must be smaller than or equal to the size of the destination array.");
		}
		byte[] array = new byte[length];
		for (int i = 0; i < length; i++)
		{
			byte byteValue = plainText[i];
			array[i] = (byte)(plainText[i] ^ MagicByte);
			UpdateKeys(byteValue);
		}
		return array;
	}

	private void Initialize(string password)
	{
		byte[] array = StringToByteArray(password);
		for (int i = 0; i < password.Length; i++)
		{
			UpdateKeys(array[i]);
		}
	}

	internal static byte[] StringToByteArray(string value, Encoding encoding)
	{
		return encoding.GetBytes(value);
	}

	internal static byte[] StringToByteArray(string value)
	{
		return StringToByteArray(value, ArchiveEncoding.Password);
	}

	private void UpdateKeys(byte byteValue)
	{
		_Keys[0] = (uint)crc32.ComputeCrc32((int)_Keys[0], byteValue);
		_Keys[1] = _Keys[1] + (byte)_Keys[0];
		_Keys[1] = _Keys[1] * 134775813 + 1;
		_Keys[2] = (uint)crc32.ComputeCrc32((int)_Keys[2], (byte)(_Keys[1] >> 24));
	}
}
