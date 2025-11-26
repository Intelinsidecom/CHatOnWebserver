using System;
using System.Collections.Generic;
using System.IO;
using SharpCompress.Common;
using SharpCompress.Common.Rar.Headers;
using SharpCompress.Compressor.PPMd.H;
using SharpCompress.Compressor.Rar.decode;
using SharpCompress.Compressor.Rar.PPM;
using SharpCompress.Compressor.Rar.VM;

namespace SharpCompress.Compressor.Rar;

internal sealed class Unpack : Unpack20
{
	private ModelPPM ppm = new ModelPPM();

	private int ppmEscChar;

	private RarVM rarVM = new RarVM();

	private List<UnpackFilter> filters = new List<UnpackFilter>();

	private List<UnpackFilter> prgStack = new List<UnpackFilter>();

	private List<int> oldFilterLengths = new List<int>();

	private int lastFilter;

	private bool tablesRead;

	private byte[] unpOldTable = new byte[Compress.HUFF_TABLE_SIZE];

	private BlockTypes unpBlockType;

	private long writtenFileSize;

	private bool fileExtracted;

	private bool ppmError;

	private int prevLowDist;

	private int lowDistRepCount;

	public static int[] DBitLengthCounts = new int[19]
	{
		4, 2, 2, 2, 2, 2, 2, 2, 2, 2,
		2, 2, 2, 2, 2, 2, 14, 0, 12
	};

	private FileHeader fileHeader;

	public bool FileExtracted => fileExtracted;

	public long DestSize
	{
		get
		{
			return destUnpSize;
		}
		set
		{
			destUnpSize = value;
			fileExtracted = false;
		}
	}

	public bool Suspended
	{
		set
		{
			suspended = value;
		}
	}

	public int Char
	{
		get
		{
			if (inAddr > 32738)
			{
				unpReadBuf();
			}
			return base.InBuf[inAddr++] & 0xFF;
		}
	}

	public int PpmEscChar
	{
		get
		{
			return ppmEscChar;
		}
		set
		{
			ppmEscChar = value;
		}
	}

	public Unpack()
	{
		window = null;
		suspended = false;
		unpAllBuf = false;
		unpSomeRead = false;
	}

	public void init(byte[] window)
	{
		if (window == null)
		{
			base.window = new byte[4194304];
		}
		else
		{
			base.window = window;
		}
		inAddr = 0;
		unpInitData(solid: false);
	}

	public void doUnpack(FileHeader fileHeader, Stream readStream, Stream writeStream)
	{
		destUnpSize = fileHeader.UncompressedSize;
		this.fileHeader = fileHeader;
		base.writeStream = writeStream;
		base.readStream = readStream;
		if (!FlagUtility.HasFlag(fileHeader.FileFlags, FileFlags.SOLID))
		{
			init(null);
		}
		suspended = false;
		doUnpack();
	}

	public void doUnpack()
	{
		bool solid = FlagUtility.HasFlag(fileHeader.FileFlags, FileFlags.SOLID);
		if (fileHeader.PackingMethod == 48)
		{
			unstoreFile();
			return;
		}
		switch (fileHeader.RarVersion)
		{
		case 15:
			unpack15(solid);
			break;
		case 20:
		case 26:
			unpack20(solid);
			break;
		case 29:
		case 36:
			unpack29(solid);
			break;
		}
	}

	private void unstoreFile()
	{
		byte[] array = new byte[65536];
		do
		{
			int num = readStream.Read(array, 0, (int)Math.Min(array.Length, destUnpSize));
			if (num == 0 || num == -1)
			{
				break;
			}
			num = (int)((num < destUnpSize) ? num : destUnpSize);
			writeStream.Write(array, 0, num);
			if (destUnpSize >= 0)
			{
				destUnpSize -= num;
			}
		}
		while (!suspended);
	}

	private void unpack29(bool solid)
	{
		int[] array = new int[60];
		byte[] array2 = new byte[60];
		if (array[1] == 0)
		{
			int num = 0;
			int num2 = 0;
			int num3 = 0;
			int num4 = 0;
			while (num4 < DBitLengthCounts.Length)
			{
				int num5 = DBitLengthCounts[num4];
				int num6 = 0;
				while (num6 < num5)
				{
					array[num3] = num;
					array2[num3] = (byte)num2;
					num6++;
					num3++;
					num += 1 << num2;
				}
				num4++;
				num2++;
			}
		}
		fileExtracted = true;
		if (!suspended)
		{
			unpInitData(solid);
			if (!unpReadBuf() || ((!solid || !tablesRead) && !readTables()))
			{
				return;
			}
		}
		if (ppmError)
		{
			return;
		}
		while (true)
		{
			unpPtr &= Compress.MAXWINMASK;
			if (inAddr > readBorder && !unpReadBuf())
			{
				break;
			}
			if (((wrPtr - unpPtr) & Compress.MAXWINMASK) < 260 && wrPtr != unpPtr)
			{
				UnpWriteBuf();
				if (destUnpSize <= 0)
				{
					return;
				}
				if (suspended)
				{
					fileExtracted = false;
					return;
				}
			}
			if (unpBlockType == BlockTypes.BLOCK_PPM)
			{
				int num7 = ppm.decodeChar();
				if (num7 == -1)
				{
					ppmError = true;
					break;
				}
				if (num7 == ppmEscChar)
				{
					int num8 = ppm.decodeChar();
					if (num8 == 0)
					{
						if (!readTables())
						{
							break;
						}
						continue;
					}
					if (num8 == 2 || num8 == -1)
					{
						break;
					}
					if (num8 == 3)
					{
						if (!readVMCodePPM())
						{
							break;
						}
						continue;
					}
					if (num8 == 4)
					{
						int num9 = 0;
						int num10 = 0;
						bool flag = false;
						for (int i = 0; i < 4; i++)
						{
							if (flag)
							{
								break;
							}
							int num11 = ppm.decodeChar();
							if (num11 == -1)
							{
								flag = true;
							}
							else if (i == 3)
							{
								num10 = num11 & 0xFF;
							}
							else
							{
								num9 = (num9 << 8) + (num11 & 0xFF);
							}
						}
						if (flag)
						{
							break;
						}
						copyString(num10 + 32, num9 + 2);
						continue;
					}
					if (num8 == 5)
					{
						int num12 = ppm.decodeChar();
						if (num12 == -1)
						{
							break;
						}
						copyString(num12 + 4, 1);
						continue;
					}
				}
				window[unpPtr++] = (byte)num7;
				continue;
			}
			int num13 = this.decodeNumber(LD);
			if (num13 < 256)
			{
				window[unpPtr++] = (byte)num13;
			}
			else if (num13 >= 271)
			{
				int num14 = Unpack20.LDecode[num13 -= 271] + 3;
				int num15;
				if ((num15 = Unpack20.LBits[num13]) > 0)
				{
					num14 += Utility.URShift(GetBits(), 16 - num15);
					AddBits(num15);
				}
				int num16 = this.decodeNumber(DD);
				int num17 = array[num16] + 1;
				if ((num15 = array2[num16]) > 0)
				{
					if (num16 > 9)
					{
						if (num15 > 4)
						{
							num17 += Utility.URShift(GetBits(), 20 - num15) << 4;
							AddBits(num15 - 4);
						}
						if (lowDistRepCount > 0)
						{
							lowDistRepCount--;
							num17 += prevLowDist;
						}
						else
						{
							int num18 = this.decodeNumber(LDD);
							if (num18 == 16)
							{
								lowDistRepCount = 15;
								num17 += prevLowDist;
							}
							else
							{
								num17 += num18;
								prevLowDist = num18;
							}
						}
					}
					else
					{
						num17 += Utility.URShift(GetBits(), 16 - num15);
						AddBits(num15);
					}
				}
				if (num17 >= 8192)
				{
					num14++;
					if ((long)num17 >= 262144L)
					{
						num14++;
					}
				}
				insertOldDist(num17);
				insertLastMatch(num14, num17);
				copyString(num14, num17);
			}
			else if (num13 == 256)
			{
				if (!readEndOfBlock())
				{
					break;
				}
			}
			else if (num13 == 257)
			{
				if (!readVMCode())
				{
					break;
				}
			}
			else if (num13 == 258)
			{
				if (lastLength != 0)
				{
					copyString(lastLength, lastDist);
				}
			}
			else if (num13 < 263)
			{
				int num19 = num13 - 259;
				int num20 = oldDist[num19];
				for (int num21 = num19; num21 > 0; num21--)
				{
					oldDist[num21] = oldDist[num21 - 1];
				}
				oldDist[0] = num20;
				int num22 = this.decodeNumber(RD);
				int num23 = Unpack20.LDecode[num22] + 2;
				int num15;
				if ((num15 = Unpack20.LBits[num22]) > 0)
				{
					num23 += Utility.URShift(GetBits(), 16 - num15);
					AddBits(num15);
				}
				insertLastMatch(num23, num20);
				copyString(num23, num20);
			}
			else if (num13 < 272)
			{
				int num24 = Unpack20.SDDecode[num13 -= 263] + 1;
				int num15;
				if ((num15 = Unpack20.SDBits[num13]) > 0)
				{
					num24 += Utility.URShift(GetBits(), 16 - num15);
					AddBits(num15);
				}
				insertOldDist(num24);
				insertLastMatch(2, num24);
				copyString(2, num24);
			}
		}
		UnpWriteBuf();
	}

	private void UnpWriteBuf()
	{
		int num = wrPtr;
		int num2 = (unpPtr - num) & Compress.MAXWINMASK;
		for (int i = 0; i < prgStack.Count; i++)
		{
			UnpackFilter unpackFilter = prgStack[i];
			if (unpackFilter == null)
			{
				continue;
			}
			if (unpackFilter.NextWindow)
			{
				unpackFilter.NextWindow = false;
				continue;
			}
			int blockStart = unpackFilter.BlockStart;
			int blockLength = unpackFilter.BlockLength;
			if (((blockStart - num) & Compress.MAXWINMASK) >= num2)
			{
				continue;
			}
			if (num != blockStart)
			{
				UnpWriteArea(num, blockStart);
				num = blockStart;
				num2 = (unpPtr - num) & Compress.MAXWINMASK;
			}
			if (blockLength <= num2)
			{
				int num3 = (blockStart + blockLength) & Compress.MAXWINMASK;
				if (blockStart < num3 || num3 == 0)
				{
					rarVM.setMemory(0, window, blockStart, blockLength);
				}
				else
				{
					int num4 = 4194304 - blockStart;
					rarVM.setMemory(0, window, blockStart, num4);
					rarVM.setMemory(num4, window, 0, num3);
				}
				VMPreparedProgram program = filters[unpackFilter.ParentFilter].Program;
				VMPreparedProgram program2 = unpackFilter.Program;
				if (program.GlobalData.Count > 64)
				{
					program2.GlobalData.Clear();
					for (int j = 0; j < program.GlobalData.Count - 64; j++)
					{
						program2.GlobalData[64 + j] = program.GlobalData[64 + j];
					}
				}
				ExecuteCode(program2);
				if (program2.GlobalData.Count > 64)
				{
					if (program.GlobalData.Count < program2.GlobalData.Count)
					{
						program.GlobalData.SetSize(program2.GlobalData.Count);
					}
					for (int k = 0; k < program2.GlobalData.Count - 64; k++)
					{
						program.GlobalData[64 + k] = program2.GlobalData[64 + k];
					}
				}
				else
				{
					program.GlobalData.Clear();
				}
				int filteredDataOffset = program2.FilteredDataOffset;
				int filteredDataSize = program2.FilteredDataSize;
				byte[] array = new byte[filteredDataSize];
				for (int l = 0; l < filteredDataSize; l++)
				{
					array[l] = rarVM.Mem[filteredDataOffset + l];
				}
				prgStack[i] = null;
				while (i + 1 < prgStack.Count)
				{
					UnpackFilter unpackFilter2 = prgStack[i + 1];
					if (unpackFilter2 == null || unpackFilter2.BlockStart != blockStart || unpackFilter2.BlockLength != filteredDataSize || unpackFilter2.NextWindow)
					{
						break;
					}
					rarVM.setMemory(0, array, 0, filteredDataSize);
					VMPreparedProgram program3 = filters[unpackFilter2.ParentFilter].Program;
					VMPreparedProgram program4 = unpackFilter2.Program;
					if (program3.GlobalData.Count > 64)
					{
						program4.GlobalData.SetSize(program3.GlobalData.Count);
						for (int m = 0; m < program3.GlobalData.Count - 64; m++)
						{
							program4.GlobalData[64 + m] = program3.GlobalData[64 + m];
						}
					}
					ExecuteCode(program4);
					if (program4.GlobalData.Count > 64)
					{
						if (program3.GlobalData.Count < program4.GlobalData.Count)
						{
							program3.GlobalData.SetSize(program4.GlobalData.Count);
						}
						for (int n = 0; n < program4.GlobalData.Count - 64; n++)
						{
							program3.GlobalData[64 + n] = program4.GlobalData[64 + n];
						}
					}
					else
					{
						program3.GlobalData.Clear();
					}
					filteredDataOffset = program4.FilteredDataOffset;
					filteredDataSize = program4.FilteredDataSize;
					array = new byte[filteredDataSize];
					for (int num5 = 0; num5 < filteredDataSize; num5++)
					{
						array[num5] = program4.GlobalData[filteredDataOffset + num5];
					}
					i++;
					prgStack[i] = null;
				}
				writeStream.Write(array, 0, filteredDataSize);
				unpSomeRead = true;
				writtenFileSize += filteredDataSize;
				destUnpSize -= filteredDataSize;
				num = num3;
				num2 = (unpPtr - num) & Compress.MAXWINMASK;
				continue;
			}
			for (int num6 = i; num6 < prgStack.Count; num6++)
			{
				UnpackFilter unpackFilter3 = prgStack[num6];
				if (unpackFilter3 != null && unpackFilter3.NextWindow)
				{
					unpackFilter3.NextWindow = false;
				}
			}
			wrPtr = num;
			return;
		}
		UnpWriteArea(num, unpPtr);
		wrPtr = unpPtr;
	}

	private void UnpWriteArea(int startPtr, int endPtr)
	{
		if (endPtr != startPtr)
		{
			unpSomeRead = true;
		}
		if (endPtr < startPtr)
		{
			UnpWriteData(window, startPtr, -startPtr & Compress.MAXWINMASK);
			UnpWriteData(window, 0, endPtr);
			unpAllBuf = true;
		}
		else
		{
			UnpWriteData(window, startPtr, endPtr - startPtr);
		}
	}

	private void UnpWriteData(byte[] data, int offset, int size)
	{
		if (destUnpSize > 0)
		{
			int num = size;
			if (num > destUnpSize)
			{
				num = (int)destUnpSize;
			}
			writeStream.Write(data, offset, num);
			writtenFileSize += size;
			destUnpSize -= size;
		}
	}

	private void insertOldDist(int distance)
	{
		oldDist[3] = oldDist[2];
		oldDist[2] = oldDist[1];
		oldDist[1] = oldDist[0];
		oldDist[0] = distance;
	}

	private void insertLastMatch(int length, int distance)
	{
		lastDist = distance;
		lastLength = length;
	}

	private void copyString(int length, int distance)
	{
		int num = unpPtr - distance;
		if (num >= 0 && num < 4194044 && unpPtr < 4194044)
		{
			window[unpPtr++] = window[num++];
			while (--length > 0)
			{
				window[unpPtr++] = window[num++];
			}
		}
		else
		{
			while (length-- != 0)
			{
				window[unpPtr] = window[num++ & Compress.MAXWINMASK];
				unpPtr = (unpPtr + 1) & Compress.MAXWINMASK;
			}
		}
	}

	protected internal override void unpInitData(bool solid)
	{
		if (!solid)
		{
			tablesRead = false;
			Utility.Fill(oldDist, 0);
			oldDistPtr = 0;
			lastDist = 0;
			lastLength = 0;
			Utility.Fill(unpOldTable, (byte)0);
			unpPtr = 0;
			wrPtr = 0;
			ppmEscChar = 2;
			initFilters();
		}
		InitBitInput();
		ppmError = false;
		writtenFileSize = 0L;
		readTop = 0;
		readBorder = 0;
		unpInitData20(solid);
	}

	private void initFilters()
	{
		oldFilterLengths.Clear();
		lastFilter = 0;
		filters.Clear();
		prgStack.Clear();
	}

	private bool readEndOfBlock()
	{
		int bits = GetBits();
		bool flag = false;
		bool flag2;
		if ((bits & 0x8000) != 0)
		{
			flag2 = true;
			AddBits(1);
		}
		else
		{
			flag = true;
			flag2 = (((bits & 0x4000) != 0) ? true : false);
			AddBits(2);
		}
		tablesRead = !flag2;
		if (!flag)
		{
			if (flag2)
			{
				return readTables();
			}
			return true;
		}
		return false;
	}

	private bool readTables()
	{
		byte[] array = new byte[20];
		byte[] array2 = new byte[Compress.HUFF_TABLE_SIZE];
		if (inAddr > readTop - 25 && !unpReadBuf())
		{
			return false;
		}
		AddBits((8 - inBit) & 7);
		long num = GetBits() & -1;
		if ((num & 0x8000) != 0)
		{
			unpBlockType = BlockTypes.BLOCK_PPM;
			return ppm.decodeInit(this, ppmEscChar);
		}
		unpBlockType = BlockTypes.BLOCK_LZ;
		prevLowDist = 0;
		lowDistRepCount = 0;
		if ((num & 0x4000) == 0)
		{
			Utility.Fill(unpOldTable, (byte)0);
		}
		AddBits(2);
		for (int i = 0; i < 20; i++)
		{
			int num2 = Utility.URShift(GetBits(), 12) & 0xFF;
			AddBits(4);
			if (num2 == 15)
			{
				int num3 = Utility.URShift(GetBits(), 12) & 0xFF;
				AddBits(4);
				if (num3 == 0)
				{
					array[i] = 15;
					continue;
				}
				num3 += 2;
				while (num3-- > 0 && i < array.Length)
				{
					array[i++] = 0;
				}
				i--;
			}
			else
			{
				array[i] = (byte)num2;
			}
		}
		UnpackUtility.makeDecodeTables(array, 0, BD, 20);
		int hUFF_TABLE_SIZE = Compress.HUFF_TABLE_SIZE;
		int num4 = 0;
		while (num4 < hUFF_TABLE_SIZE)
		{
			if (inAddr > readTop - 5 && !unpReadBuf())
			{
				return false;
			}
			int num5 = this.decodeNumber(BD);
			if (num5 < 16)
			{
				array2[num4] = (byte)((num5 + unpOldTable[num4]) & 0xF);
				num4++;
			}
			else if (num5 < 18)
			{
				int num6;
				if (num5 == 16)
				{
					num6 = Utility.URShift(GetBits(), 13) + 3;
					AddBits(3);
				}
				else
				{
					num6 = Utility.URShift(GetBits(), 9) + 11;
					AddBits(7);
				}
				while (num6-- > 0 && num4 < hUFF_TABLE_SIZE)
				{
					array2[num4] = array2[num4 - 1];
					num4++;
				}
			}
			else
			{
				int num7;
				if (num5 == 18)
				{
					num7 = Utility.URShift(GetBits(), 13) + 3;
					AddBits(3);
				}
				else
				{
					num7 = Utility.URShift(GetBits(), 9) + 11;
					AddBits(7);
				}
				while (num7-- > 0 && num4 < hUFF_TABLE_SIZE)
				{
					array2[num4++] = 0;
				}
			}
		}
		tablesRead = true;
		if (inAddr > readTop)
		{
			return false;
		}
		UnpackUtility.makeDecodeTables(array2, 0, LD, 299);
		UnpackUtility.makeDecodeTables(array2, 299, DD, 60);
		UnpackUtility.makeDecodeTables(array2, 359, LDD, 17);
		UnpackUtility.makeDecodeTables(array2, 376, RD, 28);
		Buffer.BlockCopy(array2, 0, unpOldTable, 0, unpOldTable.Length);
		return true;
	}

	private bool readVMCode()
	{
		int num = GetBits() >> 8;
		AddBits(8);
		int num2 = (num & 7) + 1;
		switch (num2)
		{
		case 7:
			num2 = (GetBits() >> 8) + 7;
			AddBits(8);
			break;
		case 8:
			num2 = GetBits();
			AddBits(16);
			break;
		}
		List<byte> list = new List<byte>();
		for (int i = 0; i < num2; i++)
		{
			if (inAddr >= readTop - 1 && !unpReadBuf() && i < num2 - 1)
			{
				return false;
			}
			list.Add((byte)(GetBits() >> 8));
			AddBits(8);
		}
		return addVMCode(num, list, num2);
	}

	private bool readVMCodePPM()
	{
		int num = ppm.decodeChar();
		if (num == -1)
		{
			return false;
		}
		int num2 = (num & 7) + 1;
		switch (num2)
		{
		case 7:
		{
			int num5 = ppm.decodeChar();
			if (num5 == -1)
			{
				return false;
			}
			num2 = num5 + 7;
			break;
		}
		case 8:
		{
			int num3 = ppm.decodeChar();
			if (num3 == -1)
			{
				return false;
			}
			int num4 = ppm.decodeChar();
			if (num4 == -1)
			{
				return false;
			}
			num2 = num3 * 256 + num4;
			break;
		}
		}
		List<byte> list = new List<byte>();
		for (int i = 0; i < num2; i++)
		{
			int num6 = ppm.decodeChar();
			if (num6 == -1)
			{
				return false;
			}
			list.Add((byte)num6);
		}
		return addVMCode(num, list, num2);
	}

	private bool addVMCode(int firstByte, List<byte> vmCode, int length)
	{
		BitInput bitInput = new BitInput();
		bitInput.InitBitInput();
		for (int i = 0; i < Math.Min(32768, vmCode.Count); i++)
		{
			bitInput.InBuf[i] = vmCode[i];
		}
		rarVM.init();
		int num;
		if ((firstByte & 0x80) != 0)
		{
			num = RarVM.ReadData(bitInput);
			if (num == 0)
			{
				initFilters();
			}
			else
			{
				num--;
			}
		}
		else
		{
			num = lastFilter;
		}
		if (num > filters.Count || num > oldFilterLengths.Count)
		{
			return false;
		}
		lastFilter = num;
		bool flag = num == filters.Count;
		UnpackFilter unpackFilter = new UnpackFilter();
		UnpackFilter unpackFilter2;
		if (flag)
		{
			if (num > 1024)
			{
				return false;
			}
			unpackFilter2 = new UnpackFilter();
			filters.Add(unpackFilter2);
			unpackFilter.ParentFilter = filters.Count - 1;
			oldFilterLengths.Add(0);
			unpackFilter2.ExecCount = 0;
		}
		else
		{
			unpackFilter2 = filters[num];
			unpackFilter.ParentFilter = num;
			unpackFilter2.ExecCount++;
		}
		prgStack.Add(unpackFilter);
		unpackFilter.ExecCount = unpackFilter2.ExecCount;
		int num2 = RarVM.ReadData(bitInput);
		if ((firstByte & 0x40) != 0)
		{
			num2 += 258;
		}
		unpackFilter.BlockStart = (num2 + unpPtr) & Compress.MAXWINMASK;
		if ((firstByte & 0x20) != 0)
		{
			unpackFilter.BlockLength = RarVM.ReadData(bitInput);
		}
		else
		{
			unpackFilter.BlockLength = ((num < oldFilterLengths.Count) ? oldFilterLengths[num] : 0);
		}
		unpackFilter.NextWindow = wrPtr != unpPtr && ((wrPtr - unpPtr) & Compress.MAXWINMASK) <= num2;
		oldFilterLengths[num] = unpackFilter.BlockLength;
		Utility.Fill(unpackFilter.Program.InitR, 0);
		unpackFilter.Program.InitR[3] = 245760;
		unpackFilter.Program.InitR[4] = unpackFilter.BlockLength;
		unpackFilter.Program.InitR[5] = unpackFilter.ExecCount;
		if ((firstByte & 0x10) != 0)
		{
			int num3 = Utility.URShift(bitInput.GetBits(), 9);
			bitInput.AddBits(7);
			for (int j = 0; j < 7; j++)
			{
				if ((num3 & (1 << j)) != 0)
				{
					unpackFilter.Program.InitR[j] = RarVM.ReadData(bitInput);
				}
			}
		}
		if (flag)
		{
			int num4 = RarVM.ReadData(bitInput);
			if (num4 >= 65536 || num4 == 0)
			{
				return false;
			}
			byte[] array = new byte[num4];
			for (int k = 0; k < num4; k++)
			{
				if (bitInput.Overflow(3))
				{
					return false;
				}
				array[k] = (byte)(bitInput.GetBits() >> 8);
				bitInput.AddBits(8);
			}
			rarVM.prepare(array, num4, unpackFilter2.Program);
		}
		unpackFilter.Program.AltCommands = unpackFilter2.Program.Commands;
		unpackFilter.Program.CommandCount = unpackFilter2.Program.CommandCount;
		int count = unpackFilter2.Program.StaticData.Count;
		if (count > 0 && count < 8192)
		{
			unpackFilter.Program.StaticData = unpackFilter2.Program.StaticData;
		}
		if (unpackFilter.Program.GlobalData.Count < 64)
		{
			unpackFilter.Program.GlobalData.Clear();
			unpackFilter.Program.GlobalData.SetSize(64);
		}
		List<byte> globalData = unpackFilter.Program.GlobalData;
		for (int l = 0; l < 7; l++)
		{
			rarVM.SetLowEndianValue(globalData, l * 4, unpackFilter.Program.InitR[l]);
		}
		rarVM.SetLowEndianValue(globalData, 28, unpackFilter.BlockLength);
		rarVM.SetLowEndianValue(globalData, 32, 0);
		rarVM.SetLowEndianValue(globalData, 36, 0);
		rarVM.SetLowEndianValue(globalData, 40, 0);
		rarVM.SetLowEndianValue(globalData, 44, unpackFilter.ExecCount);
		for (int m = 0; m < 16; m++)
		{
			globalData[48 + m] = 0;
		}
		if ((firstByte & 8) != 0)
		{
			if (bitInput.Overflow(3))
			{
				return false;
			}
			int num5 = RarVM.ReadData(bitInput);
			if (num5 > 8128)
			{
				return false;
			}
			int count2 = unpackFilter.Program.GlobalData.Count;
			if (count2 < num5 + 64)
			{
				unpackFilter.Program.GlobalData.SetSize(num5 + 64 - count2);
			}
			int num6 = 64;
			globalData = unpackFilter.Program.GlobalData;
			for (int n = 0; n < num5; n++)
			{
				if (bitInput.Overflow(3))
				{
					return false;
				}
				globalData[num6 + n] = (byte)Utility.URShift(bitInput.GetBits(), 8);
				bitInput.AddBits(8);
			}
		}
		return true;
	}

	private void ExecuteCode(VMPreparedProgram Prg)
	{
		if (Prg.GlobalData.Count > 0)
		{
			Prg.InitR[6] = (int)writtenFileSize;
			rarVM.SetLowEndianValue(Prg.GlobalData, 36, (int)writtenFileSize);
			rarVM.SetLowEndianValue(Prg.GlobalData, 40, (int)Utility.URShift(writtenFileSize, 32));
			rarVM.execute(Prg);
		}
	}

	public void cleanUp()
	{
		if (ppm != null)
		{
			ppm.SubAlloc?.stopSubAllocator();
		}
	}
}
