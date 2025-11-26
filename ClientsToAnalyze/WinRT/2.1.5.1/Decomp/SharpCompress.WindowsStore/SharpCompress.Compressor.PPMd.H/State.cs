using System;
using System.Text;

namespace SharpCompress.Compressor.PPMd.H;

internal class State : Pointer
{
	internal const int Size = 6;

	internal int Symbol
	{
		get
		{
			return base.Memory[Address] & 0xFF;
		}
		set
		{
			base.Memory[Address] = (byte)value;
		}
	}

	internal int Freq
	{
		get
		{
			return base.Memory[Address + 1] & 0xFF;
		}
		set
		{
			base.Memory[Address + 1] = (byte)value;
		}
	}

	internal State(byte[] Memory)
		: base(Memory)
	{
	}

	internal State Initialize(byte[] mem)
	{
		return Initialize<State>(mem);
	}

	internal void IncrementFreq(int dFreq)
	{
		base.Memory[Address + 1] = (byte)(base.Memory[Address + 1] + dFreq);
	}

	internal int GetSuccessor()
	{
		return Utility.readIntLittleEndian(base.Memory, Address + 2);
	}

	internal void SetSuccessor(PPMContext successor)
	{
		SetSuccessor(successor.Address);
	}

	internal void SetSuccessor(int successor)
	{
		Utility.WriteLittleEndian(base.Memory, Address + 2, successor);
	}

	internal void SetValues(StateRef state)
	{
		Symbol = state.Symbol;
		Freq = state.Freq;
		SetSuccessor(state.GetSuccessor());
	}

	internal void SetValues(State ptr)
	{
		Array.Copy(ptr.Memory, ptr.Address, base.Memory, Address, 6);
	}

	internal State DecrementAddress()
	{
		Address -= 6;
		return this;
	}

	internal State IncrementAddress()
	{
		Address += 6;
		return this;
	}

	internal static void PPMDSwap(State ptr1, State ptr2)
	{
		byte[] memory = ptr1.Memory;
		byte[] memory2 = ptr2.Memory;
		int num = 0;
		int num2 = ptr1.Address;
		int num3 = ptr2.Address;
		while (num < 6)
		{
			byte b = memory[num2];
			memory[num2] = memory2[num3];
			memory2[num3] = b;
			num++;
			num2++;
			num3++;
		}
	}

	public override string ToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("State[");
		stringBuilder.Append("\n  Address=");
		stringBuilder.Append(Address);
		stringBuilder.Append("\n  size=");
		stringBuilder.Append(6);
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
