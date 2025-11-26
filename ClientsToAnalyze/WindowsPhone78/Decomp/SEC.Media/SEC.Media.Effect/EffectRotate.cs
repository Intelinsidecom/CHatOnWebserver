namespace SEC.Media.Effect;

public class EffectRotate
{
	private enum NumType
	{
		TYPE_0,
		TYPE_0_LR,
		TYPE_0_TB,
		TYPE_0_LRTB,
		TYPE_90,
		TYPE_90_LR,
		TYPE_90_TB,
		TYPE_90_LRTB
	}

	public RawBitmap Process(RawBitmap src, int type)
	{
		RawBitmap rawBitmap;
		if (type >= 4)
		{
			rawBitmap = new RawBitmap(src.Height, src.Width);
			for (int i = 0; i < rawBitmap.Pixels.Length; i++)
			{
				int num = src.Height - i % src.Height - 1;
				int num2 = i / src.Height;
				rawBitmap.Pixels[i] = src.Pixels[num * src.Width + num2];
			}
			src = new RawBitmap(rawBitmap.Width, rawBitmap.Height);
			for (int j = 0; j < rawBitmap.Pixels.Length; j++)
			{
				src.Pixels[j] = rawBitmap.Pixels[j];
			}
		}
		else
		{
			rawBitmap = new RawBitmap(src.Width, src.Height);
		}
		if (type % 2 == 1)
		{
			for (int k = 0; k < rawBitmap.Pixels.Length; k++)
			{
				int num3 = src.Width - k % src.Width - 1;
				int num4 = k / src.Width;
				rawBitmap.Pixels[k] = src.Pixels[num4 * src.Width + num3];
			}
			for (int l = 0; l < rawBitmap.Pixels.Length; l++)
			{
				src.Pixels[l] = rawBitmap.Pixels[l];
			}
		}
		if (type % 4 == 2 || type % 4 == 3)
		{
			for (int m = 0; m < rawBitmap.Pixels.Length; m++)
			{
				int num5 = m % src.Width;
				int num6 = src.Height - m / src.Width - 1;
				rawBitmap.Pixels[m] = src.Pixels[num6 * src.Width + num5];
			}
			for (int n = 0; n < rawBitmap.Pixels.Length; n++)
			{
				src.Pixels[n] = rawBitmap.Pixels[n];
			}
		}
		return src;
	}
}
