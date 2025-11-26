using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Org.BouncyCastle.Crypto.Digests;
using Org.BouncyCastle.Crypto.Engines;
using Org.BouncyCastle.Crypto.Parameters;

namespace SharpCompress.Common.Rar;

internal class RarRijndael : IDisposable
{
	internal const int CRYPTO_BLOCK_SIZE = 16;

	private readonly string password;

	private readonly byte[] salt;

	private byte[] aesInitializationVector;

	private RijndaelEngine rijndael;

	private RarRijndael(string password, byte[] salt)
	{
		this.password = password;
		this.salt = salt;
	}

	private byte[] ComputeHash(byte[] input)
	{
		Sha1Digest sha1Digest = new Sha1Digest();
		sha1Digest.BlockUpdate(input, 0, input.Length);
		byte[] array = new byte[sha1Digest.GetDigestSize()];
		sha1Digest.DoFinal(array, 0);
		return array;
	}

	private void Initialize()
	{
		rijndael = new RijndaelEngine();
		aesInitializationVector = new byte[16];
		int num = 2 * password.Length;
		byte[] array = new byte[num + 8];
		byte[] bytes = Encoding.UTF8.GetBytes(password);
		for (int i = 0; i < password.Length; i++)
		{
			array[i * 2] = bytes[i];
			array[i * 2 + 1] = 0;
		}
		for (int j = 0; j < salt.Length; j++)
		{
			array[j + num] = salt[j];
		}
		IList<byte> list = new List<byte>();
		byte[] array2;
		for (int k = 0; k < 262144; k++)
		{
			list.AddRange(array);
			list.AddRange(new byte[3]
			{
				(byte)k,
				(byte)(k >> 8),
				(byte)(k >> 16)
			});
			if (k % 16384 == 0)
			{
				array2 = ComputeHash(list.ToArray());
				aesInitializationVector[k / 16384] = array2[19];
			}
		}
		array2 = ComputeHash(list.ToArray());
		byte[] array3 = new byte[16];
		for (int l = 0; l < 4; l++)
		{
			for (int m = 0; m < 4; m++)
			{
				array3[l * 4 + m] = (byte)((((array2[l * 4] * 16777216) & 0xFF000000u) | (uint)((array2[l * 4 + 1] * 65536) & 0xFF0000) | (uint)((array2[l * 4 + 2] * 256) & 0xFF00) | (uint)(array2[l * 4 + 3] & 0xFF)) >> m * 8);
			}
		}
		rijndael.Init(forEncryption: false, new KeyParameter(array3));
	}

	public static RarRijndael InitializeFrom(string password, byte[] salt)
	{
		RarRijndael rarRijndael = new RarRijndael(password, salt);
		rarRijndael.Initialize();
		return rarRijndael;
	}

	public byte[] ProcessBlock(byte[] cipherText)
	{
		byte[] array = new byte[16];
		List<byte> list = new List<byte>();
		rijndael.ProcessBlock(cipherText, 0, array, 0);
		for (int i = 0; i < array.Length; i++)
		{
			list.Add((byte)(array[i] ^ aesInitializationVector[i % 16]));
		}
		for (int j = 0; j < aesInitializationVector.Length; j++)
		{
			aesInitializationVector[j] = cipherText[j];
		}
		return list.ToArray();
	}

	public void Dispose()
	{
	}
}
