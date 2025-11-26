namespace SEC.Media.Effect;

public class EffectRGB
{
	public RawBitmap Process(RawBitmap src, int input_R, int input_G, int input_B)
	{
		int num = 16711680;
		int num2 = 65280;
		int num3 = 255;
		for (int i = 0; i < src.Pixels.Length; i++)
		{
			int num4 = (src.Pixels[i] & num) >> 16;
			int num5 = (src.Pixels[i] & num2) >> 8;
			int num6 = src.Pixels[i] & num3;
			int num7 = num4 + input_R * 20;
			int num8 = num5 + input_G * 20;
			int num9 = num6 + input_B * 20;
			if (num7 > 255)
			{
				num7 = 255;
			}
			if (num8 > 255)
			{
				num8 = 255;
			}
			if (num9 > 255)
			{
				num9 = 255;
			}
			if (num7 < 0)
			{
				num7 = 0;
			}
			if (num8 < 0)
			{
				num8 = 0;
			}
			if (num9 < 0)
			{
				num9 = 0;
			}
			src.Pixels[i] = -16777216 | (num7 << 16) | (num8 << 8) | num9;
		}
		return src;
	}
}
