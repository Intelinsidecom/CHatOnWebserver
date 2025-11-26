using System;

namespace SEC.Media.Effect;

public class EffectSoftGlow
{
	public RawBitmap Process(RawBitmap src)
	{
		RGBChannels rGBChannels = src.SeparateRgbChannels();
		RGBChannels src2 = new RGBChannels(rGBChannels);
		new RGBChannels(rGBChannels);
		int[] array = new int[src.Width * src.Height];
		int num = 0;
		int num2 = 35;
		float contrast = (float)Math.Pow((100f + (float)num2) / 100f, 2.0);
		if (!FastGaussianBlur.Blur(ref src2, 15, 1))
		{
			return null;
		}
		int num3 = 0;
		for (int i = 0; i < src.Height; i++)
		{
			for (int j = 0; j < src.Width; j++)
			{
				int num4 = src2.R.Values[num3];
				int num5 = (int)ContrastAdjust((int)rGBChannels.R.Values[num3], contrast);
				int num6 = 255 - num4;
				int num7 = 255 - num5;
				_ = num7 * num6 / 255;
				int num8 = ScreenLayers(num4, num5);
				num4 = src2.G.Values[num3];
				num5 = (int)ContrastAdjust((int)rGBChannels.G.Values[num3], contrast);
				num6 = 255 - num4;
				num7 = 255 - num5;
				_ = num7 * num6 / 255;
				int num9 = ScreenLayers(num4, num5);
				num4 = src2.B.Values[num3];
				num5 = (int)ContrastAdjust((int)rGBChannels.B.Values[num3], contrast);
				num6 = 255 - num4;
				num7 = 255 - num5;
				_ = num7 * num6 / 255;
				num = ScreenLayers(num4, num5);
				array[num3] = (num8 << 16) | (num9 << 8) | num | -16777216;
				num3++;
			}
		}
		array.CopyTo(src.Pixels, 0);
		return src;
	}

	private static float ContrastAdjust(float r, float contrast)
	{
		r /= 255f;
		r -= 0.5f;
		r *= contrast;
		r += 0.5f;
		r *= 255f;
		if (r > 255f)
		{
			r = 255f;
			return r;
		}
		if (r < 0f)
		{
			r = 0f;
		}
		return r;
	}

	private static int ScreenLayers(int m, int i)
	{
		return 255 - (255 - m) * (255 - i) / 255;
	}
}
