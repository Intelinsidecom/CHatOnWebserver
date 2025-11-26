using System;
using Org.BouncyCastle.Crypto;
using Org.BouncyCastle.Crypto.Digests;
using Org.BouncyCastle.Crypto.Macs;
using Org.BouncyCastle.Crypto.Parameters;

namespace SharpCompress.Crypto;

internal class PBKDF2
{
	private readonly IMac hMac = new HMac(new Sha1Digest());

	private readonly byte[] state = new byte[20];

	private int endIndex;

	private int startIndex;

	private uint block = 1u;

	private readonly byte[] password;

	private readonly byte[] salt;

	private readonly int iterations;

	public PBKDF2(byte[] password, byte[] salt, int iterations)
	{
		this.password = password;
		this.salt = salt;
		this.iterations = iterations;
	}

	public byte[] GetBytes(int cb)
	{
		if (cb <= 0)
		{
			throw new ArgumentOutOfRangeException("cb");
		}
		byte[] array = new byte[cb];
		int i = 0;
		int num = endIndex - startIndex;
		if (num > 0)
		{
			if (cb < num)
			{
				Buffer.BlockCopy(state, startIndex, array, 0, cb);
				startIndex += cb;
				return array;
			}
			Buffer.BlockCopy(state, startIndex, array, 0, num);
			startIndex = (endIndex = 0);
			i += num;
		}
		for (; i < cb; i += 20)
		{
			byte[] src = Hash();
			int num2 = cb - i;
			if (num2 <= 20)
			{
				Buffer.BlockCopy(src, 0, array, i, num2);
				i += num2;
				Buffer.BlockCopy(src, num2, state, startIndex, 20 - num2);
				endIndex += 20 - num2;
				return array;
			}
			Buffer.BlockCopy(src, 0, array, i, 20);
		}
		return array;
	}

	private byte[] Hash()
	{
		byte[] array = UIntToOctet(block);
		ICipherParameters parameters = new KeyParameter(password);
		hMac.Init(parameters);
		hMac.BlockUpdate(salt, 0, salt.Length);
		hMac.BlockUpdate(array, 0, array.Length);
		byte[] array2 = new byte[20];
		hMac.DoFinal(array2, 0);
		hMac.Init(parameters);
		byte[] array3 = new byte[20];
		Buffer.BlockCopy(array2, 0, array3, 0, 20);
		for (int i = 2; (long)i <= (long)iterations; i++)
		{
			hMac.BlockUpdate(array2, 0, array2.Length);
			hMac.DoFinal(array2, 0);
			for (int j = 0; j < 20; j++)
			{
				array3[j] ^= array2[j];
			}
		}
		block++;
		return array3;
	}

	internal static byte[] UIntToOctet(uint i)
	{
		byte[] bytes = BitConverter.GetBytes(i);
		byte[] result = new byte[4]
		{
			bytes[3],
			bytes[2],
			bytes[1],
			bytes[0]
		};
		if (!BitConverter.IsLittleEndian)
		{
			return bytes;
		}
		return result;
	}
}
