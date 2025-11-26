using System;
using System.Text;
using SharpCompress.Crypto;

namespace SharpCompress.Common.Zip;

internal class WinzipAesEncryptionData
{
	private const int RFC2898_ITERATIONS = 1000;

	private byte[] salt;

	private WinzipAesKeySize keySize;

	private byte[] passwordVerifyValue;

	private string password;

	private byte[] generatedVerifyValue;

	internal byte[] IvBytes { get; set; }

	internal byte[] KeyBytes { get; set; }

	private int KeySizeInBytes => KeyLengthInBytes(keySize);

	internal WinzipAesEncryptionData(WinzipAesKeySize keySize, byte[] salt, byte[] passwordVerifyValue, string password)
	{
		this.keySize = keySize;
		this.salt = salt;
		this.passwordVerifyValue = passwordVerifyValue;
		this.password = password;
		Initialize();
	}

	internal static int KeyLengthInBytes(WinzipAesKeySize keySize)
	{
		return keySize switch
		{
			WinzipAesKeySize.KeySize128 => 16, 
			WinzipAesKeySize.KeySize192 => 24, 
			WinzipAesKeySize.KeySize256 => 32, 
			_ => throw new InvalidOperationException(), 
		};
	}

	private void Initialize()
	{
		UTF8Encoding uTF8Encoding = new UTF8Encoding(encoderShouldEmitUTF8Identifier: false);
		PBKDF2 pBKDF = new PBKDF2(uTF8Encoding.GetBytes(password), salt, 1000);
		KeyBytes = pBKDF.GetBytes(KeySizeInBytes);
		IvBytes = pBKDF.GetBytes(KeySizeInBytes);
		generatedVerifyValue = pBKDF.GetBytes(2);
		short num = BitConverter.ToInt16(passwordVerifyValue, 0);
		if (password != null)
		{
			short num2 = BitConverter.ToInt16(generatedVerifyValue, 0);
			if (num != num2)
			{
				throw new InvalidFormatException("bad password");
			}
		}
	}
}
