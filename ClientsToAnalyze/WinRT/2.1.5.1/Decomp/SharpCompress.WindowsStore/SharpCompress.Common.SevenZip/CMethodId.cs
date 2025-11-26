namespace SharpCompress.Common.SevenZip;

internal struct CMethodId
{
	public const ulong kCopyId = 0uL;

	public const ulong kLzmaId = 196865uL;

	public const ulong kLzma2Id = 33uL;

	public const ulong kAESId = 116459265uL;

	public static readonly CMethodId kCopy = new CMethodId(0uL);

	public static readonly CMethodId kLzma = new CMethodId(196865uL);

	public static readonly CMethodId kLzma2 = new CMethodId(33uL);

	public static readonly CMethodId kAES = new CMethodId(116459265uL);

	public readonly ulong Id;

	public CMethodId(ulong id)
	{
		Id = id;
	}

	public override int GetHashCode()
	{
		return Id.GetHashCode();
	}

	public override bool Equals(object obj)
	{
		if (obj is CMethodId)
		{
			return (CMethodId)obj == this;
		}
		return false;
	}

	public bool Equals(CMethodId other)
	{
		return Id == other.Id;
	}

	public static bool operator ==(CMethodId left, CMethodId right)
	{
		return left.Id == right.Id;
	}

	public static bool operator !=(CMethodId left, CMethodId right)
	{
		return left.Id != right.Id;
	}

	public int GetLength()
	{
		int num = 0;
		for (ulong num2 = Id; num2 != 0; num2 >>= 8)
		{
			num++;
		}
		return num;
	}
}
