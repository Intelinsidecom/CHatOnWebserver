using System;

namespace SharpCompress.Compressor.Rar;

internal static class RarCRC
{
	private static uint[] crcTab;

	public static uint CheckCrc(uint startCrc, byte[] data, int offset, int count)
	{
		int num = Math.Min(data.Length - offset, count);
		for (int i = 0; i < num; i++)
		{
			startCrc = crcTab[(startCrc ^ data[offset + i]) & 0xFF] ^ (startCrc >> 8);
		}
		return startCrc;
	}

	static RarCRC()
	{
		crcTab = new uint[256];
		for (uint num = 0u; num < 256; num++)
		{
			uint num2 = num;
			for (int i = 0; i < 8; i++)
			{
				if ((num2 & 1) != 0)
				{
					num2 >>= 1;
					num2 ^= 0xEDB88320u;
				}
				else
				{
					num2 >>= 1;
				}
			}
			crcTab[num] = num2;
		}
	}
}
