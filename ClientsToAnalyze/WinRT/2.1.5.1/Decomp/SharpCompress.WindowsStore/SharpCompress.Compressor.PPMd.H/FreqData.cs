using System.Text;

namespace SharpCompress.Compressor.PPMd.H;

internal class FreqData : Pointer
{
	internal const int Size = 6;

	internal int SummFreq
	{
		get
		{
			return Utility.readShortLittleEndian(base.Memory, Address) & 0xFFFF;
		}
		set
		{
			Utility.WriteLittleEndian(base.Memory, Address, (short)value);
		}
	}

	internal FreqData(byte[] Memory)
		: base(Memory)
	{
	}

	internal FreqData Initialize(byte[] mem)
	{
		return Initialize<FreqData>(mem);
	}

	internal void IncrementSummFreq(int dSummFreq)
	{
		Utility.incShortLittleEndian(base.Memory, Address, (short)dSummFreq);
	}

	internal int GetStats()
	{
		return Utility.readIntLittleEndian(base.Memory, Address + 2);
	}

	internal virtual void SetStats(State state)
	{
		SetStats(state.Address);
	}

	internal void SetStats(int state)
	{
		Utility.WriteLittleEndian(base.Memory, Address + 2, state);
	}

	public override string ToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("FreqData[");
		stringBuilder.Append("\n  Address=");
		stringBuilder.Append(Address);
		stringBuilder.Append("\n  size=");
		stringBuilder.Append(6);
		stringBuilder.Append("\n  summFreq=");
		stringBuilder.Append(SummFreq);
		stringBuilder.Append("\n  stats=");
		stringBuilder.Append(GetStats());
		stringBuilder.Append("\n]");
		return stringBuilder.ToString();
	}
}
