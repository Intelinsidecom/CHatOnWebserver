namespace SharpCompress.Compressor.PPMd.H;

internal class RarMemBlock : Pointer
{
	public const int size = 12;

	private int stamp;

	private int NU;

	private int next;

	private int prev;

	internal int Stamp
	{
		get
		{
			if (base.Memory != null)
			{
				stamp = Utility.readShortLittleEndian(base.Memory, Address) & 0xFFFF;
			}
			return stamp;
		}
		set
		{
			stamp = value;
			if (base.Memory != null)
			{
				Utility.WriteLittleEndian(base.Memory, Address, (short)value);
			}
		}
	}

	public RarMemBlock(byte[] Memory)
		: base(Memory)
	{
	}

	internal void InsertAt(RarMemBlock p)
	{
		RarMemBlock rarMemBlock = new RarMemBlock(base.Memory);
		SetPrev(p.Address);
		rarMemBlock.Address = GetPrev();
		SetNext(rarMemBlock.GetNext());
		rarMemBlock.SetNext(this);
		rarMemBlock.Address = GetNext();
		rarMemBlock.SetPrev(this);
	}

	internal void Remove()
	{
		RarMemBlock rarMemBlock = new RarMemBlock(base.Memory);
		rarMemBlock.Address = GetPrev();
		rarMemBlock.SetNext(GetNext());
		rarMemBlock.Address = GetNext();
		rarMemBlock.SetPrev(GetPrev());
	}

	internal int GetNext()
	{
		if (base.Memory != null)
		{
			next = Utility.readIntLittleEndian(base.Memory, Address + 4);
		}
		return next;
	}

	internal void SetNext(RarMemBlock next)
	{
		SetNext(next.Address);
	}

	internal void SetNext(int next)
	{
		this.next = next;
		if (base.Memory != null)
		{
			Utility.WriteLittleEndian(base.Memory, Address + 4, next);
		}
	}

	internal int GetNU()
	{
		if (base.Memory != null)
		{
			NU = Utility.readShortLittleEndian(base.Memory, Address + 2) & 0xFFFF;
		}
		return NU;
	}

	internal void SetNU(int nu)
	{
		NU = nu & 0xFFFF;
		if (base.Memory != null)
		{
			Utility.WriteLittleEndian(base.Memory, Address + 2, (short)nu);
		}
	}

	internal int GetPrev()
	{
		if (base.Memory != null)
		{
			prev = Utility.readIntLittleEndian(base.Memory, Address + 8);
		}
		return prev;
	}

	internal void SetPrev(RarMemBlock prev)
	{
		SetPrev(prev.Address);
	}

	internal void SetPrev(int prev)
	{
		this.prev = prev;
		if (base.Memory != null)
		{
			Utility.WriteLittleEndian(base.Memory, Address + 8, prev);
		}
	}
}
