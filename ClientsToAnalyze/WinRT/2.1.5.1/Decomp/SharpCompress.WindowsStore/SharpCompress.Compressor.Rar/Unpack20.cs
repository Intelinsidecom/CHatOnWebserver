using System;
using SharpCompress.Compressor.Rar.decode;

namespace SharpCompress.Compressor.Rar;

internal abstract class Unpack20 : Unpack15
{
	protected internal MultDecode[] MD = new MultDecode[4];

	protected internal byte[] UnpOldTable20;

	protected internal int UnpAudioBlock;

	protected internal int UnpChannels;

	protected internal int UnpCurChannel;

	protected internal int UnpChannelDelta;

	private readonly AudioVariables[] AudV = new AudioVariables[4];

	protected internal LitDecode LD = new LitDecode();

	protected internal DistDecode DD = new DistDecode();

	protected internal LowDistDecode LDD = new LowDistDecode();

	protected internal RepDecode RD = new RepDecode();

	protected internal BitDecode BD = new BitDecode();

	public static readonly int[] LDecode = new int[28]
	{
		0, 1, 2, 3, 4, 5, 6, 7, 8, 10,
		12, 14, 16, 20, 24, 28, 32, 40, 48, 56,
		64, 80, 96, 112, 128, 160, 192, 224
	};

	public static readonly byte[] LBits = new byte[28]
	{
		0, 0, 0, 0, 0, 0, 0, 0, 1, 1,
		1, 1, 2, 2, 2, 2, 3, 3, 3, 3,
		4, 4, 4, 4, 5, 5, 5, 5
	};

	public static readonly int[] DDecode = new int[48]
	{
		0, 1, 2, 3, 4, 6, 8, 12, 16, 24,
		32, 48, 64, 96, 128, 192, 256, 384, 512, 768,
		1024, 1536, 2048, 3072, 4096, 6144, 8192, 12288, 16384, 24576,
		32768, 49152, 65536, 98304, 131072, 196608, 262144, 327680, 393216, 458752,
		524288, 589824, 655360, 720896, 786432, 851968, 917504, 983040
	};

	public static readonly int[] DBits = new int[48]
	{
		0, 0, 0, 0, 1, 1, 2, 2, 3, 3,
		4, 4, 5, 5, 6, 6, 7, 7, 8, 8,
		9, 9, 10, 10, 11, 11, 12, 12, 13, 13,
		14, 14, 15, 15, 16, 16, 16, 16, 16, 16,
		16, 16, 16, 16, 16, 16, 16, 16
	};

	public static readonly int[] SDDecode = new int[8] { 0, 4, 8, 16, 32, 64, 128, 192 };

	public static readonly int[] SDBits = new int[8] { 2, 2, 3, 4, 5, 6, 6, 6 };

	public Unpack20()
	{
		InitBlock();
	}

	private void InitBlock()
	{
		UnpOldTable20 = new byte[1028];
	}

	internal void unpack20(bool solid)
	{
		if (suspended)
		{
			unpPtr = wrPtr;
		}
		else
		{
			unpInitData(solid);
			if (!unpReadBuf() || (!solid && !ReadTables20()))
			{
				return;
			}
			destUnpSize--;
		}
		while (destUnpSize >= 0)
		{
			unpPtr &= Compress.MAXWINMASK;
			if (inAddr > readTop - 30 && !unpReadBuf())
			{
				break;
			}
			if (((wrPtr - unpPtr) & Compress.MAXWINMASK) < 270 && wrPtr != unpPtr)
			{
				oldUnpWriteBuf();
				if (suspended)
				{
					return;
				}
			}
			if (UnpAudioBlock != 0)
			{
				int num = this.decodeNumber(MD[UnpCurChannel]);
				if (num == 256)
				{
					if (!ReadTables20())
					{
						break;
					}
					continue;
				}
				window[unpPtr++] = DecodeAudio(num);
				if (++UnpCurChannel == UnpChannels)
				{
					UnpCurChannel = 0;
				}
				destUnpSize--;
				continue;
			}
			int num2 = this.decodeNumber(LD);
			if (num2 < 256)
			{
				window[unpPtr++] = (byte)num2;
				destUnpSize--;
			}
			else if (num2 > 269)
			{
				int num3 = LDecode[num2 -= 270] + 3;
				int num4;
				if ((num4 = LBits[num2]) > 0)
				{
					num3 += Utility.URShift(GetBits(), 16 - num4);
					AddBits(num4);
				}
				int num5 = this.decodeNumber(DD);
				int num6 = DDecode[num5] + 1;
				if ((num4 = DBits[num5]) > 0)
				{
					num6 += Utility.URShift(GetBits(), 16 - num4);
					AddBits(num4);
				}
				if (num6 >= 8192)
				{
					num3++;
					if ((long)num6 >= 262144L)
					{
						num3++;
					}
				}
				CopyString20(num3, num6);
			}
			else if (num2 == 269)
			{
				if (!ReadTables20())
				{
					break;
				}
			}
			else if (num2 == 256)
			{
				CopyString20(lastLength, lastDist);
			}
			else if (num2 < 261)
			{
				int num7 = oldDist[(oldDistPtr - (num2 - 256)) & 3];
				int num8 = this.decodeNumber(RD);
				int num9 = LDecode[num8] + 2;
				int num4;
				if ((num4 = LBits[num8]) > 0)
				{
					num9 += Utility.URShift(GetBits(), 16 - num4);
					AddBits(num4);
				}
				if (num7 >= 257)
				{
					num9++;
					if (num7 >= 8192)
					{
						num9++;
						if (num7 >= 262144)
						{
							num9++;
						}
					}
				}
				CopyString20(num9, num7);
			}
			else if (num2 < 270)
			{
				int num10 = SDDecode[num2 -= 261] + 1;
				int num4;
				if ((num4 = SDBits[num2]) > 0)
				{
					num10 += Utility.URShift(GetBits(), 16 - num4);
					AddBits(num4);
				}
				CopyString20(2, num10);
			}
		}
		ReadLastTables();
		oldUnpWriteBuf();
	}

	private void CopyString20(int Length, int Distance)
	{
		lastDist = (oldDist[oldDistPtr++ & 3] = Distance);
		lastLength = Length;
		destUnpSize -= Length;
		int num = unpPtr - Distance;
		if (num < 4194004 && unpPtr < 4194004)
		{
			window[unpPtr++] = window[num++];
			window[unpPtr++] = window[num++];
			while (Length > 2)
			{
				Length--;
				window[unpPtr++] = window[num++];
			}
		}
		else
		{
			while (Length-- != 0)
			{
				window[unpPtr] = window[num++ & Compress.MAXWINMASK];
				unpPtr = (unpPtr + 1) & Compress.MAXWINMASK;
			}
		}
	}

	private bool ReadTables20()
	{
		byte[] array = new byte[19];
		byte[] array2 = new byte[1028];
		if (inAddr > readTop - 25 && !unpReadBuf())
		{
			return false;
		}
		int bits = GetBits();
		UnpAudioBlock = bits & 0x8000;
		if ((bits & 0x4000) == 0)
		{
			Utility.Fill(UnpOldTable20, (byte)0);
		}
		AddBits(2);
		int num;
		if (UnpAudioBlock != 0)
		{
			UnpChannels = (Utility.URShift(bits, 12) & 3) + 1;
			if (UnpCurChannel >= UnpChannels)
			{
				UnpCurChannel = 0;
			}
			AddBits(2);
			num = 257 * UnpChannels;
		}
		else
		{
			num = 374;
		}
		int i;
		for (i = 0; i < 19; i++)
		{
			array[i] = (byte)Utility.URShift(GetBits(), 12);
			AddBits(4);
		}
		UnpackUtility.makeDecodeTables(array, 0, BD, 19);
		i = 0;
		while (i < num)
		{
			if (inAddr > readTop - 5 && !unpReadBuf())
			{
				return false;
			}
			int num2 = this.decodeNumber(BD);
			if (num2 < 16)
			{
				array2[i] = (byte)((num2 + UnpOldTable20[i]) & 0xF);
				i++;
				continue;
			}
			int num3;
			switch (num2)
			{
			case 16:
				num3 = Utility.URShift(GetBits(), 14) + 3;
				AddBits(2);
				while (num3-- > 0 && i < num)
				{
					array2[i] = array2[i - 1];
					i++;
				}
				continue;
			case 17:
				num3 = Utility.URShift(GetBits(), 13) + 3;
				AddBits(3);
				break;
			default:
				num3 = Utility.URShift(GetBits(), 9) + 11;
				AddBits(7);
				break;
			}
			while (num3-- > 0 && i < num)
			{
				array2[i++] = 0;
			}
		}
		if (inAddr > readTop)
		{
			return true;
		}
		if (UnpAudioBlock != 0)
		{
			for (i = 0; i < UnpChannels; i++)
			{
				UnpackUtility.makeDecodeTables(array2, i * 257, MD[i], 257);
			}
		}
		else
		{
			UnpackUtility.makeDecodeTables(array2, 0, LD, 298);
			UnpackUtility.makeDecodeTables(array2, 298, DD, 48);
			UnpackUtility.makeDecodeTables(array2, 346, RD, 28);
		}
		for (int j = 0; j < UnpOldTable20.Length; j++)
		{
			UnpOldTable20[j] = array2[j];
		}
		return true;
	}

	protected void unpInitData20(bool Solid)
	{
		if (!Solid)
		{
			UnpChannelDelta = (UnpCurChannel = 0);
			UnpChannels = 1;
			AudV[0] = new AudioVariables();
			AudV[1] = new AudioVariables();
			AudV[2] = new AudioVariables();
			AudV[3] = new AudioVariables();
			Utility.Fill(UnpOldTable20, (byte)0);
		}
	}

	private void ReadLastTables()
	{
		if (readTop < inAddr + 5)
		{
			return;
		}
		if (UnpAudioBlock != 0)
		{
			if (this.decodeNumber(MD[UnpCurChannel]) == 256)
			{
				ReadTables20();
			}
		}
		else if (this.decodeNumber(LD) == 269)
		{
			ReadTables20();
		}
	}

	private byte DecodeAudio(int Delta)
	{
		AudioVariables audioVariables = AudV[UnpCurChannel];
		audioVariables.ByteCount++;
		audioVariables.D4 = audioVariables.D3;
		audioVariables.D3 = audioVariables.D2;
		audioVariables.D2 = audioVariables.LastDelta - audioVariables.D1;
		audioVariables.D1 = audioVariables.LastDelta;
		int num = 8 * audioVariables.LastChar + audioVariables.K1 * audioVariables.D1;
		num += audioVariables.K2 * audioVariables.D2 + audioVariables.K3 * audioVariables.D3;
		num += audioVariables.K4 * audioVariables.D4 + audioVariables.K5 * UnpChannelDelta;
		num = Utility.URShift(num, 3) & 0xFF;
		int num2 = num - Delta;
		int num3 = (byte)Delta << 3;
		audioVariables.Dif[0] += Math.Abs(num3);
		audioVariables.Dif[1] += Math.Abs(num3 - audioVariables.D1);
		audioVariables.Dif[2] += Math.Abs(num3 + audioVariables.D1);
		audioVariables.Dif[3] += Math.Abs(num3 - audioVariables.D2);
		audioVariables.Dif[4] += Math.Abs(num3 + audioVariables.D2);
		audioVariables.Dif[5] += Math.Abs(num3 - audioVariables.D3);
		audioVariables.Dif[6] += Math.Abs(num3 + audioVariables.D3);
		audioVariables.Dif[7] += Math.Abs(num3 - audioVariables.D4);
		audioVariables.Dif[8] += Math.Abs(num3 + audioVariables.D4);
		audioVariables.Dif[9] += Math.Abs(num3 - UnpChannelDelta);
		audioVariables.Dif[10] += Math.Abs(num3 + UnpChannelDelta);
		audioVariables.LastDelta = (byte)(num2 - audioVariables.LastChar);
		UnpChannelDelta = audioVariables.LastDelta;
		audioVariables.LastChar = num2;
		if ((audioVariables.ByteCount & 0x1F) == 0)
		{
			int num4 = audioVariables.Dif[0];
			int num5 = 0;
			audioVariables.Dif[0] = 0;
			for (int i = 1; i < audioVariables.Dif.Length; i++)
			{
				if (audioVariables.Dif[i] < num4)
				{
					num4 = audioVariables.Dif[i];
					num5 = i;
				}
				audioVariables.Dif[i] = 0;
			}
			switch (num5)
			{
			case 1:
				if (audioVariables.K1 >= -16)
				{
					audioVariables.K1--;
				}
				break;
			case 2:
				if (audioVariables.K1 < 16)
				{
					audioVariables.K1++;
				}
				break;
			case 3:
				if (audioVariables.K2 >= -16)
				{
					audioVariables.K2--;
				}
				break;
			case 4:
				if (audioVariables.K2 < 16)
				{
					audioVariables.K2++;
				}
				break;
			case 5:
				if (audioVariables.K3 >= -16)
				{
					audioVariables.K3--;
				}
				break;
			case 6:
				if (audioVariables.K3 < 16)
				{
					audioVariables.K3++;
				}
				break;
			case 7:
				if (audioVariables.K4 >= -16)
				{
					audioVariables.K4--;
				}
				break;
			case 8:
				if (audioVariables.K4 < 16)
				{
					audioVariables.K4++;
				}
				break;
			case 9:
				if (audioVariables.K5 >= -16)
				{
					audioVariables.K5--;
				}
				break;
			case 10:
				if (audioVariables.K5 < 16)
				{
					audioVariables.K5++;
				}
				break;
			}
		}
		return (byte)num2;
	}
}
