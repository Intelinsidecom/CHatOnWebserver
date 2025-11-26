using System.IO;
using System.Text;
using SharpCompress.Compressor.Rar;

namespace SharpCompress.Compressor.PPMd.H;

internal class RangeCoder
{
	internal const int TOP = 16777216;

	internal const int BOT = 32768;

	internal const long UintMask = 4294967295L;

	private long low;

	private long code;

	private long range;

	private Unpack unpackRead;

	private Stream stream;

	internal int CurrentCount
	{
		get
		{
			range = (range / SubRange.Scale) & 0xFFFFFFFFu;
			return (int)((code - low) / range);
		}
	}

	private long Char
	{
		get
		{
			if (unpackRead != null)
			{
				return unpackRead.Char;
			}
			if (stream != null)
			{
				return stream.ReadByte();
			}
			return -1L;
		}
	}

	internal SubRange SubRange { get; private set; }

	internal RangeCoder(Unpack unpackRead)
	{
		this.unpackRead = unpackRead;
		Init();
	}

	internal RangeCoder(Stream stream)
	{
		this.stream = stream;
		Init();
	}

	private void Init()
	{
		SubRange = new SubRange();
		low = (code = 0L);
		range = 4294967295L;
		for (int i = 0; i < 4; i++)
		{
			code = ((code << 8) | Char) & 0xFFFFFFFFu;
		}
	}

	internal long GetCurrentShiftCount(int SHIFT)
	{
		range = Utility.URShift(range, SHIFT);
		return ((code - low) / range) & 0xFFFFFFFFu;
	}

	internal void Decode()
	{
		low = (low + range * SubRange.LowCount) & 0xFFFFFFFFu;
		range = (range * (SubRange.HighCount - SubRange.LowCount)) & 0xFFFFFFFFu;
	}

	internal void AriDecNormalize()
	{
		bool flag = false;
		while ((low ^ (low + range)) < 16777216 || (flag = range < 32768))
		{
			if (flag)
			{
				range = -low & 0x7FFF & 0xFFFFFFFFu;
				flag = false;
			}
			code = ((code << 8) | Char) & 0xFFFFFFFFu;
			range = (range << 8) & 0xFFFFFFFFu;
			low = (low << 8) & 0xFFFFFFFFu;
		}
	}

	public override string ToString()
	{
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.Append("RangeCoder[");
		stringBuilder.Append("\n  low=");
		stringBuilder.Append(low);
		stringBuilder.Append("\n  code=");
		stringBuilder.Append(code);
		stringBuilder.Append("\n  range=");
		stringBuilder.Append(range);
		stringBuilder.Append("\n  subrange=");
		stringBuilder.Append(SubRange);
		stringBuilder.Append("]");
		return stringBuilder.ToString();
	}
}
