using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectGray : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		int[] pixels = wb.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		int num = 0;
		int num2 = 0;
		int num3 = 0;
		byte b = 0;
		for (int i = 0; i < pixelHeight; i++)
		{
			for (int j = 0; j < pixelWidth; j++)
			{
				if (((pixels[i * pixelWidth + j] >> 24) & 0xFF) != 0)
				{
					num = (pixels[i * pixelWidth + j] & 0xFF0000) >> 16;
					num2 = (pixels[i * pixelWidth + j] & 0xFF00) >> 8;
					num3 = pixels[i * pixelWidth + j] & 0xFF;
					b = (byte)((num + num2 + num3) / 3);
					pixels2[i * pixelWidth + j] = -16777216 | (b << 16) | (b << 8) | b;
				}
			}
		}
		return writeableBitmap;
	}
}
