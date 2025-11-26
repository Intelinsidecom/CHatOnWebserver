using System.IO;

namespace SharpCompress.Compressor.PPMd.I1;

internal class Coder
{
	private const uint RangeTop = 16777216u;

	private const uint RangeBottom = 32768u;

	private uint low;

	private uint code;

	private uint range;

	public uint LowCount;

	public uint HighCount;

	public uint Scale;

	public void RangeEncoderInitialize()
	{
		low = 0u;
		range = uint.MaxValue;
	}

	public void RangeEncoderNormalize(Stream stream)
	{
		while (true)
		{
			if ((low ^ (low + range)) >= 16777216)
			{
				if (range >= 32768)
				{
					break;
				}
				range = (uint)((int)(0L - (long)low) & 0x7FFF);
			}
			stream.WriteByte((byte)(low >> 24));
			range <<= 8;
			low <<= 8;
		}
	}

	public void RangeEncodeSymbol()
	{
		low += LowCount * (range /= Scale);
		range *= HighCount - LowCount;
	}

	public void RangeShiftEncodeSymbol(int rangeShift)
	{
		low += LowCount * (range >>= rangeShift);
		range *= HighCount - LowCount;
	}

	public void RangeEncoderFlush(Stream stream)
	{
		for (uint num = 0u; num < 4; num++)
		{
			stream.WriteByte((byte)(low >> 24));
			low <<= 8;
		}
	}

	public void RangeDecoderInitialize(Stream stream)
	{
		low = 0u;
		code = 0u;
		range = uint.MaxValue;
		for (uint num = 0u; num < 4; num++)
		{
			code = (code << 8) | (byte)stream.ReadByte();
		}
	}

	public void RangeDecoderNormalize(Stream stream)
	{
		while (true)
		{
			if ((low ^ (low + range)) >= 16777216)
			{
				if (range >= 32768)
				{
					break;
				}
				range = (uint)((int)(0L - (long)low) & 0x7FFF);
			}
			code = (code << 8) | (byte)stream.ReadByte();
			range <<= 8;
			low <<= 8;
		}
	}

	public uint RangeGetCurrentCount()
	{
		return (code - low) / (range /= Scale);
	}

	public uint RangeGetCurrentShiftCount(int rangeShift)
	{
		return (code - low) / (range >>= rangeShift);
	}

	public void RangeRemoveSubrange()
	{
		low += range * LowCount;
		range *= HighCount - LowCount;
	}
}
