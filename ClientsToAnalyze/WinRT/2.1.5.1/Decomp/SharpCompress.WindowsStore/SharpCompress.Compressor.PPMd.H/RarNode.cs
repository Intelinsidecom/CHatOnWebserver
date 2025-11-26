using System.Text;

namespace SharpCompress.Compressor.PPMd.H;

internal class RarNode : Pointer
{
	public const int size = 4;

	private int next;

	public RarNode(byte[] Memory)
		: base(Memory)
	{
	}

	internal int GetNext()
	{
		if (base.Memory != null)
		{
			next = Utility.readIntLittleEndian(base.Memory, Address);
		}
		return next;
	}

	internal void SetNext(RarNode next)
	{
		SetNext(next.Address);
	}

	internal void SetNext(int next)
	{
		this.next = next;
		if (base.Memory != null)
		{
			Utility.WriteLittleEndian(base.Memory, Address, next);
		}
	}

	public override string ToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("State[");
		stringBuilder.Append("\n  Address=");
		stringBuilder.Append(Address);
		stringBuilder.Append("\n  size=");
		stringBuilder.Append(4);
		stringBuilder.Append("\n  next=");
		stringBuilder.Append(GetNext());
		stringBuilder.Append("\n]");
		return stringBuilder.ToString();
	}
}
