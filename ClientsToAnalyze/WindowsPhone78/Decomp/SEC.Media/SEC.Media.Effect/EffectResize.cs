using System;

namespace SEC.Media.Effect;

public class EffectResize
{
	public RawBitmap Process(RawBitmap src, int newWidth, int newHeight)
	{
		int num = 16711680;
		int num2 = 65280;
		int num3 = 255;
		int width = src.Width;
		int height = src.Height;
		if (width <= newWidth && height <= newHeight)
		{
			return src;
		}
		float num4 = Math.Min((float)newWidth / (float)width, (float)newHeight / (float)height);
		int num5 = (int)Math.Round((float)width * num4);
		int num6 = (int)Math.Round((float)height * num4);
		RawBitmap rawBitmap = new RawBitmap(num5, num6);
		double num7 = (double)width / (double)num5;
		double num8 = (double)height / (double)num6;
		int num9 = 0;
		for (int i = 0; i < rawBitmap.Height; i++)
		{
			for (int j = 0; j < rawBitmap.Width; j++)
			{
				int num10 = (int)Math.Floor((double)j * num7);
				int num11 = (int)Math.Floor((double)i * num8);
				int num12 = num10 + 1;
				if (num12 >= rawBitmap.Width)
				{
					num12 = num10;
				}
				int num13 = num11 + 1;
				if (num13 >= rawBitmap.Height)
				{
					num13 = num11;
				}
				double num14 = (double)j * num7 - (double)num10;
				double num15 = (double)i * num8 - (double)num11;
				double num16 = 1.0 - num14;
				double num17 = 1.0 - num15;
				int num18 = src.Pixels[num10 + width * num11];
				int num19 = src.Pixels[num12 + width * num11];
				int num20 = src.Pixels[num10 + width * num13];
				int num21 = src.Pixels[num10 + width * num13];
				byte b = (byte)(num16 * (double)(num18 & num3) + num14 * (double)(num19 & num3));
				byte b2 = (byte)(num16 * (double)(num20 & num3) + num14 * (double)(num21 & num3));
				byte b3 = (byte)(num17 * (double)(int)b + num15 * (double)(int)b2);
				b = (byte)(num16 * (double)((num18 & num2) >> 8) + num14 * (double)((num19 & num2) >> 8));
				b2 = (byte)(num16 * (double)((num20 & num2) >> 8) + num14 * (double)((num21 & num2) >> 8));
				byte b4 = (byte)(num17 * (double)(int)b + num15 * (double)(int)b2);
				b = (byte)(num16 * (double)((num18 & num) >> 16) + num14 * (double)((num19 & num) >> 16));
				b2 = (byte)(num16 * (double)((num20 & num) >> 16) + num14 * (double)((num21 & num) >> 16));
				byte b5 = (byte)(num17 * (double)(int)b + num15 * (double)(int)b2);
				rawBitmap.Pixels[num9] = -16777216 | (b5 << 16) | (b4 << 8) | b3;
				num9++;
			}
		}
		return rawBitmap;
	}
}
