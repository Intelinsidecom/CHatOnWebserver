namespace SEC.Media;

public class FastGaussianBlur
{
	private struct RgbBlurColor
	{
		public int R;

		public int G;

		public int B;

		public void AddRgb(int red, int green, int blue)
		{
			R += red;
			G += green;
			B += blue;
		}

		public void SubtractRgb(int red, int green, int blue)
		{
			R -= red;
			G -= green;
			B -= blue;
		}

		public RgbBlurColor BlurWithArea(int area, bool isLast)
		{
			RgbBlurColor result = default(RgbBlurColor);
			if (isLast)
			{
				result.R = R / area;
				result.G = G / area;
				result.B = B / area;
				return result;
			}
			int num = R + G + G + B >> 2;
			result.R = R / area + R * num >> 8;
			result.G = G / area + G * num >> 8;
			result.B = B / area + B * num >> 8;
			return result;
		}

		public void Clear()
		{
			R = 0;
			G = 0;
			B = 0;
		}
	}

	private const int REPEAT = 1;

	public static bool Blur(ref RGBChannels src, int radius, int blurRepeat)
	{
		int val = radius * 2 + 1;
		int num = 31 - clz(val);
		int num2 = 1 << num;
		int num3 = num2 / 2;
		int num4 = num2 - 1;
		int width = src.Width;
		int height = src.Height;
		int[] array = new int[width + num2];
		int[] array2 = new int[width + num2];
		int[] array3 = new int[width + num2];
		RGBChannels rGBChannels = new RGBChannels(width, num2);
		bool flag = false;
		for (int i = 0; i < blurRepeat; i++)
		{
			flag = i == 0;
			ZeroArray(array);
			ZeroArray(array2);
			ZeroArray(array3);
			rGBChannels.CopyLinesFrom(src, 0, num3, num3);
			for (int j = 0; j < num3; j++)
			{
				int num5 = j * width;
				for (int k = 0; k < width; k++)
				{
					array[k] += src.R.Values[num5];
					array2[k] += src.G.Values[num5];
					array3[k] += src.B.Values[num5];
					num5++;
				}
			}
			int num6 = 0;
			RgbBlurColor rgbBlurColor = default(RgbBlurColor);
			RgbBlurColor rgbBlurColor2 = default(RgbBlurColor);
			for (int l = 0; l < height; l++)
			{
				int num7 = 0;
				int num8 = 0;
				num6 = l * width;
				rgbBlurColor.Clear();
				int num9 = 0;
				int num10 = num2;
				if (l < num3)
				{
					num10 = l + num3;
				}
				else if (l > height - num3)
				{
					num10 = num3 + height - l;
				}
				int num11 = num3;
				do
				{
					rgbBlurColor.AddRgb(array[num7], array2[num7], array3[num7]);
					num7++;
					num9 += num10;
				}
				while (--num11 != 0);
				num11 = num3;
				do
				{
					rgbBlurColor.AddRgb(array[num7], array2[num7], array3[num7]);
					num9 += num10;
					rgbBlurColor2 = rgbBlurColor.BlurWithArea(num9, flag);
					src.R.Values[num6] = (byte)rgbBlurColor2.R;
					src.G.Values[num6] = (byte)rgbBlurColor2.G;
					src.B.Values[num6] = (byte)rgbBlurColor2.B;
					num7++;
					num6++;
				}
				while (--num11 != 0);
				num11 = width - num2;
				do
				{
					rgbBlurColor.AddRgb(array[num7], array2[num7], array3[num7]);
					rgbBlurColor.SubtractRgb(array[num8], array2[num8], array3[num8]);
					rgbBlurColor2 = rgbBlurColor.BlurWithArea(num9, flag);
					src.R.Values[num6] = (byte)rgbBlurColor2.R;
					src.G.Values[num6] = (byte)rgbBlurColor2.G;
					src.B.Values[num6] = (byte)rgbBlurColor2.B;
					num6++;
					num7++;
					num8++;
				}
				while (--num11 != 0);
				num11 = num3;
				do
				{
					rgbBlurColor.SubtractRgb(array[num8], array2[num8], array3[num8]);
					num9 -= num10;
					rgbBlurColor2 = rgbBlurColor.BlurWithArea(num9, flag);
					src.R.Values[num6] = (byte)rgbBlurColor2.R;
					src.G.Values[num6] = (byte)rgbBlurColor2.G;
					src.B.Values[num6] = (byte)rgbBlurColor2.B;
					num6++;
					num8++;
				}
				while (--num11 != 0);
				int num12 = l & num4;
				int num13 = num12 * width;
				if (l >= num3)
				{
					int num14 = num13;
					int num15 = 0;
					while (num15 < width)
					{
						array[num15] -= rGBChannels.R.Values[num14];
						array2[num15] -= rGBChannels.G.Values[num14];
						array3[num15] -= rGBChannels.B.Values[num14];
						num15++;
						num14++;
					}
				}
				if (l < height - num3)
				{
					rGBChannels.CopyLinesFrom(src, l + num3, num12, 1);
					int num16 = num13;
					int num17 = 0;
					while (num17 < width)
					{
						array[num17] += rGBChannels.R.Values[num16];
						array2[num17] += rGBChannels.G.Values[num16];
						array3[num17] += rGBChannels.B.Values[num16];
						num17++;
						num16++;
					}
				}
			}
		}
		return true;
	}

	public static int clz(int val)
	{
		if (val == 0)
		{
			return 32;
		}
		uint num = (uint)val;
		int num2 = 31;
		if ((num & 0xFFFF0000u) != 0)
		{
			num2 -= 16;
			num >>= 16;
		}
		if ((num & 0xFF00) != 0)
		{
			num2 -= 8;
			num >>= 8;
		}
		if ((num & 0xF0) != 0)
		{
			num2 -= 4;
			num >>= 4;
		}
		if ((num & 0xC) != 0)
		{
			num2 -= 2;
			num >>= 2;
		}
		if ((num & 2) != 0)
		{
			num2--;
		}
		return num2;
	}

	private static void ZeroArray(int[] v)
	{
		int num = v.Length;
		for (int i = 0; i < num; i++)
		{
			v[i] = 0;
		}
	}
}
