namespace SharpCompress.Compressor.PPMd.I1;

internal class Allocator
{
	private const uint UnitSize = 12u;

	private const uint LocalOffset = 4u;

	private const uint NodeOffset = 16u;

	private const uint HeapOffset = 472u;

	private const uint N1 = 4u;

	private const uint N2 = 4u;

	private const uint N3 = 4u;

	private const uint N4 = 26u;

	private const uint IndexCount = 38u;

	private static readonly byte[] indexToUnits;

	private static readonly byte[] unitsToIndex;

	public uint AllocatorSize;

	public uint GlueCount;

	public Pointer BaseUnit;

	public Pointer LowUnit;

	public Pointer HighUnit;

	public Pointer Text;

	public Pointer Heap;

	public MemoryNode[] MemoryNodes;

	public byte[] Memory;

	static Allocator()
	{
		indexToUnits = new byte[38];
		uint num = 0u;
		uint num2 = 1u;
		while (num < 4)
		{
			indexToUnits[num] = (byte)num2;
			num++;
			num2++;
		}
		num2++;
		while (num < 8)
		{
			indexToUnits[num] = (byte)num2;
			num++;
			num2 += 2;
		}
		num2++;
		while (num < 12)
		{
			indexToUnits[num] = (byte)num2;
			num++;
			num2 += 3;
		}
		num2++;
		while (num < 38)
		{
			indexToUnits[num] = (byte)num2;
			num++;
			num2 += 4;
		}
		unitsToIndex = new byte[128];
		for (num2 = (num = 0u); num2 < 128; num2++)
		{
			num += (uint)((indexToUnits[num] < num2 + 1) ? 1 : 0);
			unitsToIndex[num2] = (byte)num;
		}
	}

	public Allocator()
	{
		MemoryNodes = new MemoryNode[38];
	}

	public void Initialize()
	{
		for (int i = 0; (long)i < 38L; i++)
		{
			ref MemoryNode reference = ref MemoryNodes[i];
			reference = new MemoryNode((uint)(16uL + (ulong)(i * 12)), Memory);
			MemoryNodes[i].Stamp = 0u;
			MemoryNodes[i].Next = MemoryNode.Zero;
			MemoryNodes[i].UnitCount = 0u;
		}
		Text = Heap;
		uint num = 12 * (AllocatorSize / 8 / 12 * 7);
		HighUnit = Heap + AllocatorSize;
		LowUnit = HighUnit - num;
		BaseUnit = HighUnit - num;
		GlueCount = 0u;
	}

	public void Start(int allocatorSize)
	{
		if (AllocatorSize != (uint)allocatorSize)
		{
			Stop();
			Memory = new byte[472 + allocatorSize];
			Heap = new Pointer(472u, Memory);
			AllocatorSize = (uint)allocatorSize;
		}
	}

	public void Stop()
	{
		if (AllocatorSize != 0)
		{
			AllocatorSize = 0u;
			Memory = null;
			Heap = Pointer.Zero;
		}
	}

	public uint GetMemoryUsed()
	{
		uint num = AllocatorSize - (HighUnit - LowUnit) - (BaseUnit - Text);
		for (uint num2 = 0u; num2 < 38; num2++)
		{
			num -= (uint)(12 * indexToUnits[num2] * (int)MemoryNodes[num2].Stamp);
		}
		return num;
	}

	public Pointer AllocateUnits(uint unitCount)
	{
		uint num = unitsToIndex[unitCount - 1];
		if (MemoryNodes[num].Available)
		{
			return MemoryNodes[num].Remove();
		}
		Pointer lowUnit = LowUnit;
		LowUnit += (uint)(indexToUnits[num] * 12);
		if (LowUnit <= HighUnit)
		{
			return lowUnit;
		}
		LowUnit -= (uint)(indexToUnits[num] * 12);
		return AllocateUnitsRare(num);
	}

	public Pointer AllocateContext()
	{
		if (HighUnit != LowUnit)
		{
			return HighUnit -= 12u;
		}
		if (MemoryNodes[0].Available)
		{
			return MemoryNodes[0].Remove();
		}
		return AllocateUnitsRare(0u);
	}

	public Pointer ExpandUnits(Pointer oldPointer, uint oldUnitCount)
	{
		uint num = unitsToIndex[oldUnitCount - 1];
		uint num2 = unitsToIndex[oldUnitCount];
		if (num == num2)
		{
			return oldPointer;
		}
		Pointer pointer = AllocateUnits(oldUnitCount + 1);
		if (pointer != Pointer.Zero)
		{
			CopyUnits(pointer, oldPointer, oldUnitCount);
			MemoryNodes[num].Insert(oldPointer, oldUnitCount);
		}
		return pointer;
	}

	public Pointer ShrinkUnits(Pointer oldPointer, uint oldUnitCount, uint newUnitCount)
	{
		uint num = unitsToIndex[oldUnitCount - 1];
		uint num2 = unitsToIndex[newUnitCount - 1];
		if (num == num2)
		{
			return oldPointer;
		}
		if (MemoryNodes[num2].Available)
		{
			Pointer pointer = MemoryNodes[num2].Remove();
			CopyUnits(pointer, oldPointer, newUnitCount);
			MemoryNodes[num].Insert(oldPointer, indexToUnits[num]);
			return pointer;
		}
		SplitBlock(oldPointer, num, num2);
		return oldPointer;
	}

	public void FreeUnits(Pointer pointer, uint unitCount)
	{
		uint num = unitsToIndex[unitCount - 1];
		MemoryNodes[num].Insert(pointer, indexToUnits[num]);
	}

	public void SpecialFreeUnits(Pointer pointer)
	{
		if (pointer != BaseUnit)
		{
			MemoryNodes[0].Insert(pointer, 1u);
			return;
		}
		MemoryNode memoryNode = pointer;
		memoryNode.Stamp = uint.MaxValue;
		BaseUnit += 12u;
	}

	public Pointer MoveUnitsUp(Pointer oldPointer, uint unitCount)
	{
		uint num = unitsToIndex[unitCount - 1];
		if (oldPointer > BaseUnit + 16384 || oldPointer > MemoryNodes[num].Next)
		{
			return oldPointer;
		}
		Pointer pointer = MemoryNodes[num].Remove();
		CopyUnits(pointer, oldPointer, unitCount);
		unitCount = indexToUnits[num];
		if (oldPointer != BaseUnit)
		{
			MemoryNodes[num].Insert(oldPointer, unitCount);
		}
		else
		{
			BaseUnit += unitCount * 12;
		}
		return pointer;
	}

	public void ExpandText()
	{
		uint[] array = new uint[38];
		while (true)
		{
			MemoryNode memoryNode2;
			MemoryNode memoryNode = (memoryNode2 = BaseUnit);
			if (memoryNode.Stamp != uint.MaxValue)
			{
				break;
			}
			BaseUnit = memoryNode2 + memoryNode2.UnitCount;
			array[unitsToIndex[memoryNode2.UnitCount - 1]]++;
			memoryNode2.Stamp = 0u;
		}
		for (uint num = 0u; num < 38; num++)
		{
			MemoryNode memoryNode2 = MemoryNodes[num];
			while (array[num] != 0)
			{
				while (memoryNode2.Next.Stamp == 0)
				{
					memoryNode2.Unlink();
					MemoryNodes[num].Stamp--;
					if (--array[num] == 0)
					{
						break;
					}
				}
				memoryNode2 = memoryNode2.Next;
			}
		}
	}

	private Pointer AllocateUnitsRare(uint index)
	{
		if (GlueCount == 0)
		{
			GlueFreeBlocks();
			if (MemoryNodes[index].Available)
			{
				return MemoryNodes[index].Remove();
			}
		}
		uint num = index;
		do
		{
			if (++num == 38)
			{
				GlueCount--;
				num = (uint)(indexToUnits[index] * 12);
				if (BaseUnit - Text <= num)
				{
					return Pointer.Zero;
				}
				return BaseUnit -= num;
			}
		}
		while (!MemoryNodes[num].Available);
		Pointer pointer = MemoryNodes[num].Remove();
		SplitBlock(pointer, num, index);
		return pointer;
	}

	private void SplitBlock(Pointer pointer, uint oldIndex, uint newIndex)
	{
		uint num = (uint)(indexToUnits[oldIndex] - indexToUnits[newIndex]);
		Pointer pointer2 = pointer + (uint)(indexToUnits[newIndex] * 12);
		uint num2 = unitsToIndex[num - 1];
		if (indexToUnits[num2] != num)
		{
			uint num3 = indexToUnits[--num2];
			MemoryNodes[num2].Insert(pointer2, num3);
			pointer2 += num3 * 12;
			num -= num3;
		}
		MemoryNodes[unitsToIndex[num - 1]].Insert(pointer2, num);
	}

	private void GlueFreeBlocks()
	{
		MemoryNode memoryNode = new MemoryNode(4u, Memory);
		memoryNode.Stamp = 0u;
		memoryNode.Next = MemoryNode.Zero;
		memoryNode.UnitCount = 0u;
		if (LowUnit != HighUnit)
		{
			LowUnit[0] = 0;
		}
		MemoryNode memoryNode2 = memoryNode;
		for (uint num = 0u; num < 38; num++)
		{
			while (MemoryNodes[num].Available)
			{
				MemoryNode memoryNode3 = MemoryNodes[num].Remove();
				if (memoryNode3.UnitCount == 0)
				{
					continue;
				}
				while (true)
				{
					MemoryNode memoryNode5;
					MemoryNode memoryNode4 = (memoryNode5 = memoryNode3 + memoryNode3.UnitCount);
					if (memoryNode4.Stamp != uint.MaxValue)
					{
						break;
					}
					memoryNode3.UnitCount += memoryNode5.UnitCount;
					memoryNode5.UnitCount = 0u;
				}
				memoryNode2.Link(memoryNode3);
				memoryNode2 = memoryNode3;
			}
		}
		while (memoryNode.Available)
		{
			MemoryNode memoryNode3 = memoryNode.Remove();
			uint num2 = memoryNode3.UnitCount;
			if (num2 != 0)
			{
				while (num2 > 128)
				{
					MemoryNodes[37].Insert(memoryNode3, 128u);
					num2 -= 128;
					memoryNode3 += 128;
				}
				uint num3 = unitsToIndex[num2 - 1];
				if (indexToUnits[num3] != num2)
				{
					uint num4 = num2 - indexToUnits[--num3];
					MemoryNodes[num4 - 1].Insert(memoryNode3 + (num2 - num4), num4);
				}
				MemoryNodes[num3].Insert(memoryNode3, indexToUnits[num3]);
			}
		}
		GlueCount = 8192u;
	}

	private void CopyUnits(Pointer target, Pointer source, uint unitCount)
	{
		do
		{
			target[0] = source[0];
			target[1] = source[1];
			target[2] = source[2];
			target[3] = source[3];
			target[4] = source[4];
			target[5] = source[5];
			target[6] = source[6];
			target[7] = source[7];
			target[8] = source[8];
			target[9] = source[9];
			target[10] = source[10];
			target[11] = source[11];
			target += 12u;
			source += 12u;
		}
		while (--unitCount != 0);
	}
}
