using System;
using System.Text;

namespace SharpCompress.Compressor.PPMd.H;

internal class SubAllocator
{
	public const int N1 = 4;

	public const int N2 = 4;

	public const int N3 = 4;

	public const int FIXED_UNIT_SIZE = 12;

	public static readonly int N4;

	public static readonly int N_INDEXES;

	public static readonly int UNIT_SIZE;

	private int subAllocatorSize;

	private int[] indx2Units = new int[N_INDEXES];

	private int[] units2Indx = new int[128];

	private int glueCount;

	private int heapStart;

	private int loUnit;

	private int hiUnit;

	private RarNode[] freeList = new RarNode[N_INDEXES];

	private int pText;

	private int unitsStart;

	private int heapEnd;

	private int fakeUnitsStart;

	private byte[] heap;

	private int freeListPos;

	private int tempMemBlockPos;

	private RarNode tempRarNode;

	private RarMemBlock tempRarMemBlock1;

	private RarMemBlock tempRarMemBlock2;

	private RarMemBlock tempRarMemBlock3;

	public virtual int FakeUnitsStart
	{
		get
		{
			return fakeUnitsStart;
		}
		set
		{
			fakeUnitsStart = value;
		}
	}

	public virtual int HeapEnd => heapEnd;

	public virtual int PText
	{
		get
		{
			return pText;
		}
		set
		{
			pText = value;
		}
	}

	public virtual int UnitsStart
	{
		get
		{
			return unitsStart;
		}
		set
		{
			unitsStart = value;
		}
	}

	public virtual byte[] Heap => heap;

	public SubAllocator()
	{
		clean();
	}

	public virtual void clean()
	{
		subAllocatorSize = 0;
	}

	private void insertNode(int p, int indx)
	{
		RarNode rarNode = tempRarNode;
		rarNode.Address = p;
		rarNode.SetNext(freeList[indx].GetNext());
		freeList[indx].SetNext(rarNode);
	}

	public virtual void incPText()
	{
		pText++;
	}

	private int removeNode(int indx)
	{
		int next = freeList[indx].GetNext();
		RarNode rarNode = tempRarNode;
		rarNode.Address = next;
		freeList[indx].SetNext(rarNode.GetNext());
		return next;
	}

	private int U2B(int NU)
	{
		return UNIT_SIZE * NU;
	}

	private int MBPtr(int BasePtr, int Items)
	{
		return BasePtr + U2B(Items);
	}

	private void splitBlock(int pv, int oldIndx, int newIndx)
	{
		int num = indx2Units[oldIndx] - indx2Units[newIndx];
		int num2 = pv + U2B(indx2Units[newIndx]);
		int num3;
		if (indx2Units[num3 = units2Indx[num - 1]] != num)
		{
			insertNode(num2, --num3);
			num2 += U2B(num3 = indx2Units[num3]);
			num -= num3;
		}
		insertNode(num2, units2Indx[num - 1]);
	}

	public virtual void stopSubAllocator()
	{
		if (subAllocatorSize != 0)
		{
			subAllocatorSize = 0;
			heap = null;
			heapStart = 1;
			tempRarNode = null;
			tempRarMemBlock1 = null;
			tempRarMemBlock2 = null;
			tempRarMemBlock3 = null;
		}
	}

	public virtual int GetAllocatedMemory()
	{
		return subAllocatorSize;
	}

	public virtual bool startSubAllocator(int SASize)
	{
		if (subAllocatorSize == SASize)
		{
			return true;
		}
		stopSubAllocator();
		int num = SASize / 12 * UNIT_SIZE + UNIT_SIZE;
		int num2 = (tempMemBlockPos = 1 + num + 4 * N_INDEXES) + 12;
		heap = new byte[num2];
		heapStart = 1;
		heapEnd = heapStart + num - UNIT_SIZE;
		subAllocatorSize = SASize;
		freeListPos = heapStart + num;
		int num3 = 0;
		int num4 = freeListPos;
		while (num3 < freeList.Length)
		{
			freeList[num3] = new RarNode(heap);
			freeList[num3].Address = num4;
			num3++;
			num4 += 4;
		}
		tempRarNode = new RarNode(heap);
		tempRarMemBlock1 = new RarMemBlock(heap);
		tempRarMemBlock2 = new RarMemBlock(heap);
		tempRarMemBlock3 = new RarMemBlock(heap);
		return true;
	}

	private void glueFreeBlocks()
	{
		RarMemBlock rarMemBlock = tempRarMemBlock1;
		rarMemBlock.Address = tempMemBlockPos;
		RarMemBlock rarMemBlock2 = tempRarMemBlock2;
		RarMemBlock rarMemBlock3 = tempRarMemBlock3;
		if (loUnit != hiUnit)
		{
			heap[loUnit] = 0;
		}
		int i = 0;
		rarMemBlock.SetPrev(rarMemBlock);
		rarMemBlock.SetNext(rarMemBlock);
		for (; i < N_INDEXES; i++)
		{
			while (freeList[i].GetNext() != 0)
			{
				rarMemBlock2.Address = removeNode(i);
				rarMemBlock2.InsertAt(rarMemBlock);
				rarMemBlock2.Stamp = 65535;
				rarMemBlock2.SetNU(indx2Units[i]);
			}
		}
		rarMemBlock2.Address = rarMemBlock.GetNext();
		while (rarMemBlock2.Address != rarMemBlock.Address)
		{
			rarMemBlock3.Address = MBPtr(rarMemBlock2.Address, rarMemBlock2.GetNU());
			while (rarMemBlock3.Stamp == 65535 && rarMemBlock2.GetNU() + rarMemBlock3.GetNU() < 65536)
			{
				rarMemBlock3.Remove();
				rarMemBlock2.SetNU(rarMemBlock2.GetNU() + rarMemBlock3.GetNU());
				rarMemBlock3.Address = MBPtr(rarMemBlock2.Address, rarMemBlock2.GetNU());
			}
			rarMemBlock2.Address = rarMemBlock2.GetNext();
		}
		rarMemBlock2.Address = rarMemBlock.GetNext();
		while (rarMemBlock2.Address != rarMemBlock.Address)
		{
			rarMemBlock2.Remove();
			int num = rarMemBlock2.GetNU();
			while (num > 128)
			{
				insertNode(rarMemBlock2.Address, N_INDEXES - 1);
				num -= 128;
				rarMemBlock2.Address = MBPtr(rarMemBlock2.Address, 128);
			}
			if (indx2Units[i = units2Indx[num - 1]] != num)
			{
				int num2 = num - indx2Units[--i];
				insertNode(MBPtr(rarMemBlock2.Address, num - num2), num2 - 1);
			}
			insertNode(rarMemBlock2.Address, i);
			rarMemBlock2.Address = rarMemBlock.GetNext();
		}
	}

	private int allocUnitsRare(int indx)
	{
		if (glueCount == 0)
		{
			glueCount = 255;
			glueFreeBlocks();
			if (freeList[indx].GetNext() != 0)
			{
				return removeNode(indx);
			}
		}
		int num = indx;
		do
		{
			if (++num == N_INDEXES)
			{
				glueCount--;
				num = U2B(indx2Units[indx]);
				int num2 = 12 * indx2Units[indx];
				if (fakeUnitsStart - pText > num2)
				{
					fakeUnitsStart -= num2;
					unitsStart -= num;
					return unitsStart;
				}
				return 0;
			}
		}
		while (freeList[num].GetNext() == 0);
		int num3 = removeNode(num);
		splitBlock(num3, num, indx);
		return num3;
	}

	public virtual int allocUnits(int NU)
	{
		int num = units2Indx[NU - 1];
		if (freeList[num].GetNext() != 0)
		{
			return removeNode(num);
		}
		int result = loUnit;
		loUnit += U2B(indx2Units[num]);
		if (loUnit <= hiUnit)
		{
			return result;
		}
		loUnit -= U2B(indx2Units[num]);
		return allocUnitsRare(num);
	}

	public virtual int allocContext()
	{
		if (hiUnit != loUnit)
		{
			return hiUnit -= UNIT_SIZE;
		}
		if (freeList[0].GetNext() != 0)
		{
			return removeNode(0);
		}
		return allocUnitsRare(0);
	}

	public virtual int expandUnits(int oldPtr, int OldNU)
	{
		int num = units2Indx[OldNU - 1];
		int num2 = units2Indx[OldNU - 1 + 1];
		if (num == num2)
		{
			return oldPtr;
		}
		int num3 = allocUnits(OldNU + 1);
		if (num3 != 0)
		{
			Array.Copy(heap, oldPtr, heap, num3, U2B(OldNU));
			insertNode(oldPtr, num);
		}
		return num3;
	}

	public virtual int shrinkUnits(int oldPtr, int oldNU, int newNU)
	{
		int num = units2Indx[oldNU - 1];
		int num2 = units2Indx[newNU - 1];
		if (num == num2)
		{
			return oldPtr;
		}
		if (freeList[num2].GetNext() != 0)
		{
			int num3 = removeNode(num2);
			Array.Copy(heap, oldPtr, heap, num3, U2B(newNU));
			insertNode(oldPtr, num);
			return num3;
		}
		splitBlock(oldPtr, num, num2);
		return oldPtr;
	}

	public virtual void freeUnits(int ptr, int OldNU)
	{
		insertNode(ptr, units2Indx[OldNU - 1]);
	}

	public virtual void decPText(int dPText)
	{
		PText -= dPText;
	}

	public virtual void initSubAllocator()
	{
		Utility.Fill(heap, freeListPos, freeListPos + sizeOfFreeList(), (byte)0);
		pText = heapStart;
		int num = 12 * (subAllocatorSize / 8 / 12 * 7);
		int num2 = num / 12 * UNIT_SIZE;
		int num3 = subAllocatorSize - num;
		int num4 = num3 / 12 * UNIT_SIZE + num3 % 12;
		hiUnit = heapStart + subAllocatorSize;
		loUnit = (unitsStart = heapStart + num4);
		fakeUnitsStart = heapStart + num3;
		hiUnit = loUnit + num2;
		int num5 = 0;
		int num6 = 1;
		while (num5 < 4)
		{
			indx2Units[num5] = num6 & 0xFF;
			num5++;
			num6++;
		}
		num6++;
		while (num5 < 8)
		{
			indx2Units[num5] = num6 & 0xFF;
			num5++;
			num6 += 2;
		}
		num6++;
		while (num5 < 12)
		{
			indx2Units[num5] = num6 & 0xFF;
			num5++;
			num6 += 3;
		}
		num6++;
		while (num5 < 12 + N4)
		{
			indx2Units[num5] = num6 & 0xFF;
			num5++;
			num6 += 4;
		}
		glueCount = 0;
		num6 = 0;
		num5 = 0;
		for (; num6 < 128; num6++)
		{
			num5 += ((indx2Units[num5] < num6 + 1) ? 1 : 0);
			units2Indx[num6] = num5 & 0xFF;
		}
	}

	private int sizeOfFreeList()
	{
		return freeList.Length * 4;
	}

	public override string ToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("SubAllocator[");
		stringBuilder.Append("\n  subAllocatorSize=");
		stringBuilder.Append(subAllocatorSize);
		stringBuilder.Append("\n  glueCount=");
		stringBuilder.Append(glueCount);
		stringBuilder.Append("\n  heapStart=");
		stringBuilder.Append(heapStart);
		stringBuilder.Append("\n  loUnit=");
		stringBuilder.Append(loUnit);
		stringBuilder.Append("\n  hiUnit=");
		stringBuilder.Append(hiUnit);
		stringBuilder.Append("\n  pText=");
		stringBuilder.Append(pText);
		stringBuilder.Append("\n  unitsStart=");
		stringBuilder.Append(unitsStart);
		stringBuilder.Append("\n]");
		return stringBuilder.ToString();
	}

	static SubAllocator()
	{
		N4 = 26;
		N_INDEXES = 12 + N4;
		UNIT_SIZE = Math.Max(PPMContext.size, 12);
	}
}
