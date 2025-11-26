using SharpCompress.Compressor.Rar.decode;
using SharpCompress.Compressor.Rar.VM;

namespace SharpCompress.Compressor.Rar;

internal static class UnpackUtility
{
	internal static int decodeNumber(this BitInput input, Decode dec)
	{
		long num = input.GetBits() & 0xFFFE;
		int[] decodeLen = dec.DecodeLen;
		int num2 = ((num < decodeLen[8]) ? ((num < decodeLen[4]) ? ((num < decodeLen[2]) ? ((num < decodeLen[1]) ? 1 : 2) : ((num >= decodeLen[3]) ? 4 : 3)) : ((num < decodeLen[6]) ? ((num >= decodeLen[5]) ? 6 : 5) : ((num >= decodeLen[7]) ? 8 : 7))) : ((num < decodeLen[12]) ? ((num < decodeLen[10]) ? ((num >= decodeLen[9]) ? 10 : 9) : ((num >= decodeLen[11]) ? 12 : 11)) : ((num >= decodeLen[14]) ? 15 : ((num >= decodeLen[13]) ? 14 : 13))));
		input.AddBits(num2);
		int num3 = dec.DecodePos[num2] + Utility.URShift((int)num - decodeLen[num2 - 1], 16 - num2);
		if (num3 >= dec.MaxNum)
		{
			num3 = 0;
		}
		return dec.DecodeNum[num3];
	}

	internal static void makeDecodeTables(byte[] lenTab, int offset, Decode dec, int size)
	{
		int[] array = new int[16];
		int[] array2 = new int[16];
		Utility.Fill(array, 0);
		Utility.Fill(dec.DecodeNum, 0);
		for (int i = 0; i < size; i++)
		{
			array[lenTab[offset + i] & 0xF]++;
		}
		array[0] = 0;
		array2[0] = 0;
		dec.DecodePos[0] = 0;
		dec.DecodeLen[0] = 0;
		long num = 0L;
		for (int i = 1; i < 16; i++)
		{
			num = 2 * (num + array[i]);
			long num2 = num << 15 - i;
			if (num2 > 65535)
			{
				num2 = 65535L;
			}
			dec.DecodeLen[i] = (int)num2;
			array2[i] = (dec.DecodePos[i] = dec.DecodePos[i - 1] + array[i - 1]);
		}
		for (int i = 0; i < size; i++)
		{
			if (lenTab[offset + i] != 0)
			{
				dec.DecodeNum[array2[lenTab[offset + i] & 0xF]++] = i;
			}
		}
		dec.MaxNum = size;
	}
}
