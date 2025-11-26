namespace SharpCompress.Compressor.PPMd.I1;

internal struct MemoryNode
{
	public const int Size = 12;

	public uint Address;

	public byte[] Memory;

	public static readonly MemoryNode Zero = new MemoryNode(0u, null);

	public uint Stamp
	{
		get
		{
			return (uint)(Memory[Address] | (Memory[Address + 1] << 8) | (Memory[Address + 2] << 16) | (Memory[Address + 3] << 24));
		}
		set
		{
			Memory[Address] = (byte)value;
			Memory[Address + 1] = (byte)(value >> 8);
			Memory[Address + 2] = (byte)(value >> 16);
			Memory[Address + 3] = (byte)(value >> 24);
		}
	}

	public MemoryNode Next
	{
		get
		{
			return new MemoryNode((uint)(Memory[Address + 4] | (Memory[Address + 5] << 8) | (Memory[Address + 6] << 16) | (Memory[Address + 7] << 24)), Memory);
		}
		set
		{
			Memory[Address + 4] = (byte)value.Address;
			Memory[Address + 5] = (byte)(value.Address >> 8);
			Memory[Address + 6] = (byte)(value.Address >> 16);
			Memory[Address + 7] = (byte)(value.Address >> 24);
		}
	}

	public uint UnitCount
	{
		get
		{
			return (uint)(Memory[Address + 8] | (Memory[Address + 9] << 8) | (Memory[Address + 10] << 16) | (Memory[Address + 11] << 24));
		}
		set
		{
			Memory[Address + 8] = (byte)value;
			Memory[Address + 9] = (byte)(value >> 8);
			Memory[Address + 10] = (byte)(value >> 16);
			Memory[Address + 11] = (byte)(value >> 24);
		}
	}

	public bool Available => Next.Address != 0;

	public MemoryNode(uint address, byte[] memory)
	{
		Address = address;
		Memory = memory;
	}

	public void Link(MemoryNode memoryNode)
	{
		memoryNode.Next = Next;
		Next = memoryNode;
	}

	public void Unlink()
	{
		Next = Next.Next;
	}

	public void Insert(MemoryNode memoryNode, uint unitCount)
	{
		Link(memoryNode);
		memoryNode.Stamp = uint.MaxValue;
		memoryNode.UnitCount = unitCount;
		Stamp++;
	}

	public MemoryNode Remove()
	{
		MemoryNode next = Next;
		Unlink();
		Stamp--;
		return next;
	}

	public static implicit operator MemoryNode(Pointer pointer)
	{
		return new MemoryNode(pointer.Address, pointer.Memory);
	}

	public static MemoryNode operator +(MemoryNode memoryNode, int offset)
	{
		memoryNode.Address = (uint)(memoryNode.Address + offset * 12);
		return memoryNode;
	}

	public static MemoryNode operator +(MemoryNode memoryNode, uint offset)
	{
		memoryNode.Address += offset * 12;
		return memoryNode;
	}

	public static MemoryNode operator -(MemoryNode memoryNode, int offset)
	{
		memoryNode.Address = (uint)(memoryNode.Address - offset * 12);
		return memoryNode;
	}

	public static MemoryNode operator -(MemoryNode memoryNode, uint offset)
	{
		memoryNode.Address -= offset * 12;
		return memoryNode;
	}

	public static bool operator ==(MemoryNode memoryNode1, MemoryNode memoryNode2)
	{
		return memoryNode1.Address == memoryNode2.Address;
	}

	public static bool operator !=(MemoryNode memoryNode1, MemoryNode memoryNode2)
	{
		return memoryNode1.Address != memoryNode2.Address;
	}

	public override bool Equals(object obj)
	{
		if (obj is MemoryNode memoryNode)
		{
			return memoryNode.Address == Address;
		}
		return base.Equals(obj);
	}

	public override int GetHashCode()
	{
		return Address.GetHashCode();
	}
}
