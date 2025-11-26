namespace SEC.Media.Effect;

public class EffectEnhance
{
	public RawBitmap Process(RawBitmap src)
	{
		RGBChannels rGBChannels = src.SeparateRgbChannels();
		RGBChannels src2 = new RGBChannels(rGBChannels);
		RGBChannels rGBChannels2 = new RGBChannels(rGBChannels);
		if (!FastGaussianBlur.Blur(ref src2, 100, 3))
		{
			return null;
		}
		rGBChannels2.Subtract(src2);
		rGBChannels2.Shrink(0.2);
		rGBChannels.Add(rGBChannels2);
		src.CombineChannels(rGBChannels);
		return src;
	}
}
