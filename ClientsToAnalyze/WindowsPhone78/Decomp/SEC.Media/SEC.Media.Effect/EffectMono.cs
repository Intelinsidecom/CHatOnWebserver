namespace SEC.Media.Effect;

public class EffectMono
{
	public RawBitmap Process(RawBitmap src)
	{
		RGBChannels rGBChannels = new RGBChannels(src.SeparateRgbChannels());
		_ = src.Pixels;
		int num = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int[] array = new int[src.Width * src.Height];
		_ = src.Height;
		int num5 = 0;
		for (int i = 0; i < src.Height; i++)
		{
			for (int j = 0; j < src.Width; j++)
			{
				num = rGBChannels.R.Values[num5];
				num2 = rGBChannels.G.Values[num5];
				num3 = rGBChannels.B.Values[num5];
				num4 = (int)((double)num * 0.3 + (double)num2 * 0.59 + (double)num3 * 0.11);
				array[num5] = -16777216 | (num4 << 16) | (num4 << 8) | num4;
				num5++;
			}
		}
		array.CopyTo(src.Pixels, 0);
		return src;
	}
}
