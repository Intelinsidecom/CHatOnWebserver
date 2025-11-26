using System.Text;

namespace SharpCompress.Compressor.PPMd.H;

internal class SEE2Context
{
	public const int size = 4;

	private int summ;

	private int shift;

	private int count;

	public virtual int Mean
	{
		get
		{
			int num = Utility.URShift(summ, shift);
			summ -= num;
			return num + ((num == 0) ? 1 : 0);
		}
	}

	public virtual int Count
	{
		get
		{
			return count;
		}
		set
		{
			count = value & 0xFF;
		}
	}

	public virtual int Shift
	{
		get
		{
			return shift;
		}
		set
		{
			shift = value & 0xFF;
		}
	}

	public virtual int Summ
	{
		get
		{
			return summ;
		}
		set
		{
			summ = value & 0xFFFF;
		}
	}

	public void Initialize(int initVal)
	{
		shift = 3;
		summ = (initVal << shift) & 0xFFFF;
		count = 4;
	}

	public virtual void update()
	{
		if (shift < 7 && --count == 0)
		{
			summ += summ;
			count = 3 << shift++;
		}
		summ &= 65535;
		count &= 255;
		shift &= 255;
	}

	public virtual void incSumm(int dSumm)
	{
		Summ += dSumm;
	}

	public override string ToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("SEE2Context[");
		stringBuilder.Append("\n  size=");
		stringBuilder.Append(4);
		stringBuilder.Append("\n  summ=");
		stringBuilder.Append(summ);
		stringBuilder.Append("\n  shift=");
		stringBuilder.Append(shift);
		stringBuilder.Append("\n  count=");
		stringBuilder.Append(count);
		stringBuilder.Append("\n]");
		return stringBuilder.ToString();
	}
}
