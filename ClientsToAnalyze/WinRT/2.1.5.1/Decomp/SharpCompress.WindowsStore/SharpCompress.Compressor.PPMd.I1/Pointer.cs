namespace SharpCompress.Compressor.PPMd.I1;

internal struct Pointer
{
	public const int Size = 1;

	public uint Address;

	public byte[] Memory;

	public static readonly Pointer Zero = new Pointer(0u, null);

	public byte this[int offset]
	{
		get
		{
			return Memory[Address + offset];
		}
		set
		{
			Memory[Address + offset] = value;
		}
	}

	public Pointer(uint address, byte[] memory)
	{
		Address = address;
		Memory = memory;
	}

	public static implicit operator Pointer(MemoryNode memoryNode)
	{
		return new Pointer(memoryNode.Address, memoryNode.Memory);
	}

	public static implicit operator Pointer(Model.PpmContext context)
	{
		return new Pointer(context.Address, context.Memory);
	}

	public static implicit operator Pointer(PpmState state)
	{
		return new Pointer(state.Address, state.Memory);
	}

	public static Pointer operator +(Pointer pointer, int offset)
	{
		pointer.Address = (uint)(pointer.Address + offset);
		return pointer;
	}

	public static Pointer operator +(Pointer pointer, uint offset)
	{
		pointer.Address += offset;
		return pointer;
	}

	public static Pointer operator ++(Pointer pointer)
	{
		pointer.Address++;
		return pointer;
	}

	public static Pointer operator -(Pointer pointer, int offset)
	{
		pointer.Address = (uint)(pointer.Address - offset);
		return pointer;
	}

	public static Pointer operator -(Pointer pointer, uint offset)
	{
		pointer.Address -= offset;
		return pointer;
	}

	public static Pointer operator --(Pointer pointer)
	{
		pointer.Address--;
		return pointer;
	}

	public static uint operator -(Pointer pointer1, Pointer pointer2)
	{
		return pointer1.Address - pointer2.Address;
	}

	public static bool operator <(Pointer pointer1, Pointer pointer2)
	{
		return pointer1.Address < pointer2.Address;
	}

	public static bool operator <=(Pointer pointer1, Pointer pointer2)
	{
		return pointer1.Address <= pointer2.Address;
	}

	public static bool operator >(Pointer pointer1, Pointer pointer2)
	{
		return pointer1.Address > pointer2.Address;
	}

	public static bool operator >=(Pointer pointer1, Pointer pointer2)
	{
		return pointer1.Address >= pointer2.Address;
	}

	public static bool operator ==(Pointer pointer1, Pointer pointer2)
	{
		return pointer1.Address == pointer2.Address;
	}

	public static bool operator !=(Pointer pointer1, Pointer pointer2)
	{
		return pointer1.Address != pointer2.Address;
	}

	public override bool Equals(object obj)
	{
		if (obj is Pointer pointer)
		{
			return pointer.Address == Address;
		}
		return base.Equals(obj);
	}

	public override int GetHashCode()
	{
		return Address.GetHashCode();
	}
}
