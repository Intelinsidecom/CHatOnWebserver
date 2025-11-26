using System;
using System.IO;
using SharpCompress.Compressor.Rar.decode;
using SharpCompress.Compressor.Rar.VM;

namespace SharpCompress.Compressor.Rar;

internal abstract class Unpack15 : BitInput
{
	private const int STARTL1 = 2;

	private const int STARTL2 = 3;

	private const int STARTHF0 = 4;

	private const int STARTHF1 = 5;

	private const int STARTHF2 = 5;

	private const int STARTHF3 = 6;

	private const int STARTHF4 = 8;

	protected internal int readBorder;

	protected internal bool suspended;

	protected internal bool unpAllBuf;

	protected Stream readStream;

	protected Stream writeStream;

	protected internal bool unpSomeRead;

	protected internal int readTop;

	protected internal long destUnpSize;

	protected internal byte[] window;

	protected internal int[] oldDist = new int[4];

	protected internal int unpPtr;

	protected internal int wrPtr;

	protected internal int oldDistPtr;

	protected internal int[] ChSet = new int[256];

	protected internal int[] ChSetA = new int[256];

	protected internal int[] ChSetB = new int[256];

	protected internal int[] ChSetC = new int[256];

	protected internal int[] Place = new int[256];

	protected internal int[] PlaceA = new int[256];

	protected internal int[] PlaceB = new int[256];

	protected internal int[] PlaceC = new int[256];

	protected internal int[] NToPl = new int[256];

	protected internal int[] NToPlB = new int[256];

	protected internal int[] NToPlC = new int[256];

	protected internal int FlagBuf;

	protected internal int AvrPlc;

	protected internal int AvrPlcB;

	protected internal int AvrLn1;

	protected internal int AvrLn2;

	protected internal int AvrLn3;

	protected internal int Buf60;

	protected internal int NumHuf;

	protected internal int StMode;

	protected internal int LCount;

	protected internal int FlagsCnt;

	protected internal int Nhfb;

	protected internal int Nlzb;

	protected internal int MaxDist3;

	protected internal int lastDist;

	protected internal int lastLength;

	private static int[] DecL1 = new int[11]
	{
		32768, 40960, 49152, 53248, 57344, 59904, 60928, 61440, 61952, 61952,
		65535
	};

	private static int[] PosL1 = new int[13]
	{
		0, 0, 0, 2, 3, 5, 7, 11, 16, 20,
		24, 32, 32
	};

	private static int[] DecL2 = new int[10] { 40960, 49152, 53248, 57344, 59904, 60928, 61440, 61952, 62016, 65535 };

	private static int[] PosL2 = new int[13]
	{
		0, 0, 0, 0, 5, 7, 9, 13, 18, 22,
		26, 34, 36
	};

	private static int[] DecHf0 = new int[9] { 32768, 49152, 57344, 61952, 61952, 61952, 61952, 61952, 65535 };

	private static int[] PosHf0 = new int[13]
	{
		0, 0, 0, 0, 0, 8, 16, 24, 33, 33,
		33, 33, 33
	};

	private static int[] DecHf1 = new int[8] { 8192, 49152, 57344, 61440, 61952, 61952, 63456, 65535 };

	private static int[] PosHf1 = new int[13]
	{
		0, 0, 0, 0, 0, 0, 4, 44, 60, 76,
		80, 80, 127
	};

	private static int[] DecHf2 = new int[8] { 4096, 9216, 32768, 49152, 64000, 65535, 65535, 65535 };

	private static int[] PosHf2 = new int[13]
	{
		0, 0, 0, 0, 0, 0, 2, 7, 53, 117,
		233, 0, 0
	};

	private static int[] DecHf3 = new int[7] { 2048, 9216, 60928, 65152, 65535, 65535, 65535 };

	private static int[] PosHf3 = new int[13]
	{
		0, 0, 0, 0, 0, 0, 0, 2, 16, 218,
		251, 0, 0
	};

	private static int[] DecHf4 = new int[6] { 65280, 65535, 65535, 65535, 65535, 65535 };

	private static int[] PosHf4 = new int[13]
	{
		0, 0, 0, 0, 0, 0, 0, 0, 0, 255,
		0, 0, 0
	};

	internal static int[] ShortLen1 = new int[16]
	{
		1, 3, 4, 4, 5, 6, 7, 8, 8, 4,
		4, 5, 6, 6, 4, 0
	};

	internal static int[] ShortXor1 = new int[15]
	{
		0, 160, 208, 224, 240, 248, 252, 254, 255, 192,
		128, 144, 152, 156, 176
	};

	internal static int[] ShortLen2 = new int[16]
	{
		2, 3, 3, 3, 4, 4, 5, 6, 6, 4,
		4, 5, 6, 6, 4, 0
	};

	internal static int[] ShortXor2 = new int[15]
	{
		0, 64, 96, 160, 208, 224, 240, 248, 252, 192,
		128, 144, 152, 156, 176
	};

	protected internal abstract void unpInitData(bool solid);

	protected void unpack15(bool solid)
	{
		if (suspended)
		{
			unpPtr = wrPtr;
		}
		else
		{
			unpInitData(solid);
			oldUnpInitData(solid);
			unpReadBuf();
			if (!solid)
			{
				initHuff();
				unpPtr = 0;
			}
			else
			{
				unpPtr = wrPtr;
			}
			destUnpSize--;
		}
		if (destUnpSize >= 0)
		{
			getFlagsBuf();
			FlagsCnt = 8;
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
			if (StMode != 0)
			{
				huffDecode();
				continue;
			}
			if (--FlagsCnt < 0)
			{
				getFlagsBuf();
				FlagsCnt = 7;
			}
			if ((FlagBuf & 0x80) != 0)
			{
				FlagBuf <<= 1;
				if (Nlzb > Nhfb)
				{
					longLZ();
				}
				else
				{
					huffDecode();
				}
				continue;
			}
			FlagBuf <<= 1;
			if (--FlagsCnt < 0)
			{
				getFlagsBuf();
				FlagsCnt = 7;
			}
			if ((FlagBuf & 0x80) != 0)
			{
				FlagBuf <<= 1;
				if (Nlzb > Nhfb)
				{
					huffDecode();
				}
				else
				{
					longLZ();
				}
			}
			else
			{
				FlagBuf <<= 1;
				shortLZ();
			}
		}
		oldUnpWriteBuf();
	}

	protected bool unpReadBuf()
	{
		int num = readTop - inAddr;
		if (num < 0)
		{
			return false;
		}
		if (inAddr > 16384)
		{
			if (num > 0)
			{
				Array.Copy(base.InBuf, inAddr, base.InBuf, 0, num);
			}
			inAddr = 0;
			readTop = num;
		}
		else
		{
			num = readTop;
		}
		int num2 = readStream.Read(base.InBuf, num, (32768 - num) & -16);
		if (num2 > 0)
		{
			readTop += num2;
		}
		readBorder = readTop - 30;
		return num2 != -1;
	}

	private int getShortLen1(int pos)
	{
		if (pos != 1)
		{
			return ShortLen1[pos];
		}
		return Buf60 + 3;
	}

	private int getShortLen2(int pos)
	{
		if (pos != 3)
		{
			return ShortLen2[pos];
		}
		return Buf60 + 3;
	}

	private void shortLZ()
	{
		NumHuf = 0;
		int num = GetBits();
		if (LCount == 2)
		{
			AddBits(1);
			if (num >= 32768)
			{
				oldCopyString(lastDist, lastLength);
				return;
			}
			num <<= 1;
			LCount = 0;
		}
		num = Utility.URShift(num, 8);
		int i;
		if (AvrLn1 < 37)
		{
			for (i = 0; ((num ^ ShortXor1[i]) & ~Utility.URShift(255, getShortLen1(i))) != 0; i++)
			{
			}
			AddBits(getShortLen1(i));
		}
		else
		{
			for (i = 0; ((num ^ ShortXor2[i]) & ~(255 >> getShortLen2(i))) != 0; i++)
			{
			}
			AddBits(getShortLen2(i));
		}
		if (i >= 9)
		{
			int distance;
			switch (i)
			{
			case 9:
				LCount++;
				oldCopyString(lastDist, lastLength);
				return;
			case 14:
				LCount = 0;
				i = decodeNum(GetBits(), 3, DecL2, PosL2) + 5;
				distance = (GetBits() >> 1) | 0x8000;
				AddBits(15);
				lastLength = i;
				lastDist = distance;
				oldCopyString(distance, i);
				return;
			}
			LCount = 0;
			int num2 = i;
			distance = oldDist[(oldDistPtr - (i - 9)) & 3];
			i = decodeNum(GetBits(), 2, DecL1, PosL1) + 2;
			if (i == 257 && num2 == 10)
			{
				Buf60 ^= 1;
				return;
			}
			if (distance > 256)
			{
				i++;
			}
			if (distance >= MaxDist3)
			{
				i++;
			}
			oldDist[oldDistPtr++] = distance;
			oldDistPtr &= 3;
			lastLength = i;
			lastDist = distance;
			oldCopyString(distance, i);
		}
		else
		{
			LCount = 0;
			AvrLn1 += i;
			AvrLn1 -= AvrLn1 >> 4;
			int num3 = decodeNum(GetBits(), 5, DecHf2, PosHf2) & 0xFF;
			int distance = ChSetA[num3];
			if (--num3 != -1)
			{
				PlaceA[distance]--;
				int num4 = ChSetA[num3];
				PlaceA[num4]++;
				ChSetA[num3 + 1] = num4;
				ChSetA[num3] = distance;
			}
			i += 2;
			distance = (oldDist[oldDistPtr++] = distance + 1);
			oldDistPtr &= 3;
			lastLength = i;
			lastDist = distance;
			oldCopyString(distance, i);
		}
	}

	private void longLZ()
	{
		NumHuf = 0;
		Nlzb += 16;
		if (Nlzb > 255)
		{
			Nlzb = 144;
			Nhfb = Utility.URShift(Nhfb, 1);
		}
		int avrLn = AvrLn2;
		int bits = GetBits();
		int i;
		if (AvrLn2 >= 122)
		{
			i = decodeNum(bits, 3, DecL2, PosL2);
		}
		else if (AvrLn2 >= 64)
		{
			i = decodeNum(bits, 2, DecL1, PosL1);
		}
		else if (bits < 256)
		{
			i = bits;
			AddBits(16);
		}
		else
		{
			for (i = 0; ((bits << i) & 0x8000) == 0; i++)
			{
			}
			AddBits(i + 1);
		}
		AvrLn2 += i;
		AvrLn2 -= Utility.URShift(AvrLn2, 5);
		bits = GetBits();
		int num = ((AvrPlcB > 10495) ? decodeNum(bits, 5, DecHf2, PosHf2) : ((AvrPlcB <= 1791) ? decodeNum(bits, 4, DecHf0, PosHf0) : decodeNum(bits, 5, DecHf1, PosHf1)));
		AvrPlcB += num;
		AvrPlcB -= AvrPlcB >> 8;
		int num3;
		int num2;
		while (true)
		{
			num2 = ChSetB[num & 0xFF];
			num3 = NToPlB[num2++ & 0xFF]++;
			if ((num2 & 0xFF) != 0)
			{
				break;
			}
			corrHuff(ChSetB, NToPlB);
		}
		ChSetB[num] = ChSetB[num3];
		ChSetB[num3] = num2;
		num2 = Utility.URShift((num2 & 0xFF00) | Utility.URShift(GetBits(), 8), 1);
		AddBits(7);
		int avrLn2 = AvrLn3;
		if (i != 1 && i != 4)
		{
			if (i == 0 && num2 <= MaxDist3)
			{
				AvrLn3++;
				AvrLn3 -= AvrLn3 >> 8;
			}
			else if (AvrLn3 > 0)
			{
				AvrLn3--;
			}
		}
		i += 3;
		if (num2 >= MaxDist3)
		{
			i++;
		}
		if (num2 <= 256)
		{
			i += 8;
		}
		if (avrLn2 > 176 || (AvrPlc >= 10752 && avrLn < 64))
		{
			MaxDist3 = 32512;
		}
		else
		{
			MaxDist3 = 8193;
		}
		oldDist[oldDistPtr++] = num2;
		oldDistPtr &= 3;
		lastLength = i;
		lastDist = num2;
		oldCopyString(num2, i);
	}

	private void huffDecode()
	{
		int bits = GetBits();
		int num = ((AvrPlc > 30207) ? decodeNum(bits, 8, DecHf4, PosHf4) : ((AvrPlc > 24063) ? decodeNum(bits, 6, DecHf3, PosHf3) : ((AvrPlc > 13823) ? decodeNum(bits, 5, DecHf2, PosHf2) : ((AvrPlc <= 3583) ? decodeNum(bits, 4, DecHf0, PosHf0) : decodeNum(bits, 5, DecHf1, PosHf1)))));
		num &= 0xFF;
		if (StMode != 0)
		{
			if (num == 0 && bits > 4095)
			{
				num = 256;
			}
			if (--num == -1)
			{
				bits = GetBits();
				AddBits(1);
				if ((bits & 0x8000) != 0)
				{
					NumHuf = (StMode = 0);
					return;
				}
				int length = (((bits & 0x4000) != 0) ? 4 : 3);
				AddBits(1);
				int num2 = decodeNum(GetBits(), 5, DecHf2, PosHf2);
				num2 = (num2 << 5) | Utility.URShift(GetBits(), 11);
				AddBits(5);
				oldCopyString(num2, length);
				return;
			}
		}
		else if (NumHuf++ >= 16 && FlagsCnt == 0)
		{
			StMode = 1;
		}
		AvrPlc += num;
		AvrPlc -= Utility.URShift(AvrPlc, 8);
		Nhfb += 16;
		if (Nhfb > 255)
		{
			Nhfb = 144;
			Nlzb = Utility.URShift(Nlzb, 1);
		}
		window[unpPtr++] = (byte)Utility.URShift(ChSet[num], 8);
		destUnpSize--;
		int num3;
		int num4;
		while (true)
		{
			num3 = ChSet[num];
			num4 = NToPl[num3++ & 0xFF]++;
			if ((num3 & 0xFF) <= 161)
			{
				break;
			}
			corrHuff(ChSet, NToPl);
		}
		ChSet[num] = ChSet[num4];
		ChSet[num4] = num3;
	}

	private void getFlagsBuf()
	{
		int num = decodeNum(GetBits(), 5, DecHf2, PosHf2);
		int num2;
		int num3;
		while (true)
		{
			num2 = ChSetC[num];
			FlagBuf = Utility.URShift(num2, 8);
			num3 = NToPlC[num2++ & 0xFF]++;
			if ((num2 & 0xFF) != 0)
			{
				break;
			}
			corrHuff(ChSetC, NToPlC);
		}
		ChSetC[num] = ChSetC[num3];
		ChSetC[num3] = num2;
	}

	private void oldUnpInitData(bool Solid)
	{
		if (!Solid)
		{
			AvrPlcB = (AvrLn1 = (AvrLn2 = (AvrLn3 = (NumHuf = (Buf60 = 0)))));
			AvrPlc = 13568;
			MaxDist3 = 8193;
			Nhfb = (Nlzb = 128);
		}
		FlagsCnt = 0;
		FlagBuf = 0;
		StMode = 0;
		LCount = 0;
		readTop = 0;
	}

	private void initHuff()
	{
		for (int i = 0; i < 256; i++)
		{
			Place[i] = (PlaceA[i] = (PlaceB[i] = i));
			PlaceC[i] = (~i + 1) & 0xFF;
			ChSet[i] = (ChSetB[i] = i << 8);
			ChSetA[i] = i;
			ChSetC[i] = ((~i + 1) & 0xFF) << 8;
		}
		Utility.Fill(NToPl, 0);
		Utility.Fill(NToPlB, 0);
		Utility.Fill(NToPlC, 0);
		corrHuff(ChSetB, NToPlB);
	}

	private void corrHuff(int[] CharSet, int[] NumToPlace)
	{
		int num = 0;
		for (int num2 = 7; num2 >= 0; num2--)
		{
			int num3 = 0;
			while (num3 < 32)
			{
				CharSet[num] = (CharSet[num] & -256) | num2;
				num3++;
				num++;
			}
		}
		Utility.Fill(NumToPlace, 0);
		for (int num2 = 6; num2 >= 0; num2--)
		{
			NumToPlace[num2] = (7 - num2) * 32;
		}
	}

	private void oldCopyString(int Distance, int Length)
	{
		destUnpSize -= Length;
		while (Length-- != 0)
		{
			window[unpPtr] = window[(unpPtr - Distance) & Compress.MAXWINMASK];
			unpPtr = (unpPtr + 1) & Compress.MAXWINMASK;
		}
	}

	private int decodeNum(int Num, int StartPos, int[] DecTab, int[] PosTab)
	{
		Num &= 0xFFF0;
		int i;
		for (i = 0; DecTab[i] <= Num; i++)
		{
			StartPos++;
		}
		AddBits(StartPos);
		return Utility.URShift(Num - ((i != 0) ? DecTab[i - 1] : 0), 16 - StartPos) + PosTab[StartPos];
	}

	protected void oldUnpWriteBuf()
	{
		if (unpPtr != wrPtr)
		{
			unpSomeRead = true;
		}
		if (unpPtr < wrPtr)
		{
			writeStream.Write(window, wrPtr, -wrPtr & Compress.MAXWINMASK);
			writeStream.Write(window, 0, unpPtr);
			unpAllBuf = true;
		}
		else
		{
			writeStream.Write(window, wrPtr, unpPtr - wrPtr);
		}
		wrPtr = unpPtr;
	}
}
