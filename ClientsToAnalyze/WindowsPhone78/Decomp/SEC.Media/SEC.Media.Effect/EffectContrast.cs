namespace SEC.Media.Effect;

public class EffectContrast
{
	public RawBitmap Process(RawBitmap src, int inputContrast)
	{
		int num = 16711680;
		int num2 = 65280;
		int num3 = 255;
		int num4 = 255;
		for (int i = 0; i < src.Pixels.Length; i++)
		{
			int num5 = (src.Pixels[i] >> 24) & num4;
			if (num5 == 0)
			{
				continue;
			}
			int num6 = (src.Pixels[i] & num) >> 16;
			int num7 = (src.Pixels[i] & num2) >> 8;
			int num8 = src.Pixels[i] & num3;
			int num9;
			if (num6 > 128)
			{
				num9 = num6 + inputContrast * 20;
				if (num9 < 128)
				{
					num9 = 128;
				}
			}
			else
			{
				num9 = num6 - inputContrast * 20;
				if (num9 > 128)
				{
					num9 = 128;
				}
			}
			int num10;
			if (num7 > 128)
			{
				num10 = num7 + inputContrast * 20;
				if (num10 < 128)
				{
					num10 = 128;
				}
			}
			else
			{
				num10 = num7 - inputContrast * 20;
				if (num10 > 128)
				{
					num10 = 128;
				}
			}
			int num11;
			if (num8 > 128)
			{
				num11 = num8 + inputContrast * 20;
				if (num11 < 128)
				{
					num11 = 128;
				}
			}
			else
			{
				num11 = num8 - inputContrast * 20;
				if (num11 > 128)
				{
					num11 = 128;
				}
			}
			if (num9 > 255)
			{
				num9 = 255;
			}
			if (num10 > 255)
			{
				num10 = 255;
			}
			if (num11 > 255)
			{
				num11 = 255;
			}
			if (num9 < 0)
			{
				num9 = 0;
			}
			if (num10 < 0)
			{
				num10 = 0;
			}
			if (num11 < 0)
			{
				num11 = 0;
			}
			src.Pixels[i] = (num5 << 24) | (num9 << 16) | (num10 << 8) | num11;
		}
		return src;
	}
}
