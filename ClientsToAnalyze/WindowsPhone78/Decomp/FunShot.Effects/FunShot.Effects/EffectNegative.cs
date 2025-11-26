using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectNegative : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wbSource)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wbSource.PixelWidth, wbSource.PixelHeight);
		int pixelWidth = wbSource.PixelWidth;
		int pixelHeight = wbSource.PixelHeight;
		int[] pixels = wbSource.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		int num = 0;
		for (int i = 0; i < pixelHeight; i++)
		{
			for (int j = 0; j < pixelWidth; j++)
			{
				int num2 = (pixels[i * pixelWidth + j] & 0xFF0000) >> 16;
				int num3 = (pixels[i * pixelWidth + j] & 0xFF00) >> 8;
				int num4 = pixels[i * pixelWidth + j] & 0xFF;
				num = (num2 + num3 + num4) / 3;
				num = 255 - num;
				pixels2[i * pixelWidth + j] = -16777216 | ((byte)num << 16) | ((byte)num << 8) | (byte)num;
			}
		}
		return writeableBitmap;
	}
}
