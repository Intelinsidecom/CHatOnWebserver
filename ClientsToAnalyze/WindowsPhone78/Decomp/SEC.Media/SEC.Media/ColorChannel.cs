using System;

namespace SEC.Media;

public class ColorChannel
{
	public int Height;

	public byte[] Values;

	public int Width;

	public ColorChannel(ColorChannel color)
	{
		Width = color.Width;
		Height = color.Height;
		Values = new byte[Width * Height];
		color.Values.CopyTo(Values, 0);
	}

	public ColorChannel(int w, int h)
	{
		Width = w;
		Height = h;
		Values = new byte[w * h];
	}

	public void Add(ColorChannel src)
	{
		int num = src.Values.Length;
		int num2 = 0;
		for (int i = 0; i < num; i++)
		{
			num2 = Values[i] + src.Values[i];
			num2 = Math.Min(num2, 255);
			Values[i] = (byte)num2;
		}
	}

	public void CopyLinesFrom(ColorChannel src, int sy, int dy, int numLines)
	{
		int num = sy * Width;
		int num2 = dy * Width;
		int num3 = numLines * Width;
		for (int i = 0; i < num3; i++)
		{
			Values[num2] = src.Values[num];
			num2++;
			num++;
		}
	}

	public void Shrink(double v)
	{
		if (v == 0.0)
		{
			Zero();
		}
		else if (v != 1.0)
		{
			uint num = (uint)(v * 1024.0);
			int num2 = Values.Length;
			uint num3 = 0u;
			for (int i = 0; i < num2; i++)
			{
				num3 = Values[i] * num >> 10;
				Values[i] = (byte)num3;
			}
		}
	}

	public void Subtract(ColorChannel src)
	{
		int num = src.Values.Length;
		int num2 = 0;
		for (int i = 0; i < num; i++)
		{
			num2 = Values[i] - src.Values[i];
			num2 = Math.Max(num2, 0);
			Values[i] = (byte)num2;
		}
	}

	public void Zero()
	{
		int num = Values.Length;
		for (int i = 0; i < num; i++)
		{
			Values[i] = 0;
		}
	}
}
