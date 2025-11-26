using System.Text;

namespace SharpCompress.Compressor.PPMd.H;

internal class SubRange
{
	private long lowCount;

	private long highCount;

	private long scale;

	internal long HighCount
	{
		get
		{
			return highCount;
		}
		set
		{
			highCount = value & 0xFFFFFFFFu;
		}
	}

	internal long LowCount
	{
		get
		{
			return lowCount & 0xFFFFFFFFu;
		}
		set
		{
			lowCount = value & 0xFFFFFFFFu;
		}
	}

	internal long Scale
	{
		get
		{
			return scale;
		}
		set
		{
			scale = value & 0xFFFFFFFFu;
		}
	}

	internal void incScale(int dScale)
	{
		Scale += dScale;
	}

	public override string ToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("SubRange[");
		stringBuilder.Append("\n  lowCount=");
		stringBuilder.Append(lowCount);
		stringBuilder.Append("\n  highCount=");
		stringBuilder.Append(highCount);
		stringBuilder.Append("\n  scale=");
		stringBuilder.Append(scale);
		stringBuilder.Append("]");
		return stringBuilder.ToString();
	}
}
