namespace SEC.Media.Effect;

public class EffectBright
{
	public RawBitmap Process(RawBitmap src, int inputBright)
	{
		int num = 16711680;
		int num2 = 65280;
		int num3 = 255;
		int num4 = 255;
		for (int i = 0; i < src.Pixels.Length; i++)
		{
			int num5 = (src.Pixels[i] >> 24) & num4;
			if (num5 != 0)
			{
				int num6 = (src.Pixels[i] & num) >> 16;
				int num7 = (src.Pixels[i] & num2) >> 8;
				int num8 = src.Pixels[i] & num3;
				int num9 = num6 + inputBright * 20;
				int num10 = num7 + inputBright * 20;
				int num11 = num8 + inputBright * 20;
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
		}
		return src;
	}
}
