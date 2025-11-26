namespace SEC.Media.Effect;

public class EffectHDR
{
	public RawBitmap Process(RawBitmap src)
	{
		ToneMappingInt toneMappingInt = new ToneMappingInt();
		ToneMappingParameters inpar = new ToneMappingParameters();
		toneMappingInt.apply_parameters(inpar);
		byte[] array = src.ToByteArray();
		toneMappingInt.process_8bit_rgb_image(array, src.Width, src.Height);
		return new RawBitmap(array, src.Width, src.Height);
	}
}
