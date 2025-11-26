using System.Text;

namespace SharpCompress.Compressor.PPMd.H;

internal class StateRef
{
	private int symbol;

	private int freq;

	private int successor;

	internal int Symbol
	{
		get
		{
			return symbol;
		}
		set
		{
			symbol = value & 0xFF;
		}
	}

	internal int Freq
	{
		get
		{
			return freq;
		}
		set
		{
			freq = value & 0xFF;
		}
	}

	internal State Values
	{
		set
		{
			Freq = value.Freq;
			SetSuccessor(value.GetSuccessor());
			Symbol = value.Symbol;
		}
	}

	public virtual void IncrementFreq(int dFreq)
	{
		freq = (freq + dFreq) & 0xFF;
	}

	public virtual void DecrementFreq(int dFreq)
	{
		freq = (freq - dFreq) & 0xFF;
	}

	public virtual int GetSuccessor()
	{
		return successor;
	}

	public virtual void SetSuccessor(PPMContext successor)
	{
		SetSuccessor(successor.Address);
	}

	public virtual void SetSuccessor(int successor)
	{
		this.successor = successor;
	}

	public override string ToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("State[");
		stringBuilder.Append("\n  symbol=");
		stringBuilder.Append(Symbol);
		stringBuilder.Append("\n  freq=");
		stringBuilder.Append(Freq);
		stringBuilder.Append("\n  successor=");
		stringBuilder.Append(GetSuccessor());
		stringBuilder.Append("\n]");
		return stringBuilder.ToString();
	}
}
