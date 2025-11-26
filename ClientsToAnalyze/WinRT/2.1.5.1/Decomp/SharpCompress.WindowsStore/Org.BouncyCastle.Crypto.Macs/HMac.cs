using System;
using Org.BouncyCastle.Crypto.Parameters;

namespace Org.BouncyCastle.Crypto.Macs;

public class HMac : IMac
{
	private const byte IPAD = 54;

	private const byte OPAD = 92;

	private readonly IDigest digest;

	private readonly int digestSize;

	private readonly int blockLength;

	private readonly byte[] inputPad;

	private readonly byte[] outputPad;

	public string AlgorithmName => digest.AlgorithmName + "/HMAC";

	public HMac(IDigest digest)
	{
		this.digest = digest;
		digestSize = digest.GetDigestSize();
		blockLength = digest.GetByteLength();
		inputPad = new byte[blockLength];
		outputPad = new byte[blockLength];
	}

	public IDigest GetUnderlyingDigest()
	{
		return digest;
	}

	public void Init(ICipherParameters parameters)
	{
		digest.Reset();
		byte[] key = ((KeyParameter)parameters).GetKey();
		int num = key.Length;
		if (num > blockLength)
		{
			digest.BlockUpdate(key, 0, key.Length);
			digest.DoFinal(inputPad, 0);
			num = digestSize;
		}
		else
		{
			Array.Copy(key, 0, inputPad, 0, num);
		}
		Array.Clear(inputPad, num, blockLength - num);
		Array.Copy(inputPad, 0, outputPad, 0, blockLength);
		xor(inputPad, 54);
		xor(outputPad, 92);
		digest.BlockUpdate(inputPad, 0, inputPad.Length);
	}

	public int GetMacSize()
	{
		return digestSize;
	}

	public void Update(byte input)
	{
		digest.Update(input);
	}

	public void BlockUpdate(byte[] input, int inOff, int len)
	{
		digest.BlockUpdate(input, inOff, len);
	}

	public int DoFinal(byte[] output, int outOff)
	{
		byte[] array = new byte[digestSize];
		digest.DoFinal(array, 0);
		digest.BlockUpdate(outputPad, 0, outputPad.Length);
		digest.BlockUpdate(array, 0, array.Length);
		int result = digest.DoFinal(output, outOff);
		digest.BlockUpdate(inputPad, 0, inputPad.Length);
		return result;
	}

	public void Reset()
	{
		digest.Reset();
		digest.BlockUpdate(inputPad, 0, inputPad.Length);
	}

	private static void xor(byte[] a, byte n)
	{
		for (int i = 0; i < a.Length; i++)
		{
			a[i] ^= n;
		}
	}
}
