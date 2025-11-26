using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectSepia : EffectBase
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
		int num4 = 0;
		int num5 = 0;
		int num6 = 0;
		for (int i = 0; i < pixelHeight; i++)
		{
			for (int j = 0; j < pixelWidth; j++)
			{
				if (((pixels[i * pixelWidth + j] >> 24) & 0xFF) != 0)
				{
					num4 = (pixels[i * pixelWidth + j] & 0xFF0000) >> 16;
					num5 = (pixels[i * pixelWidth + j] & 0xFF00) >> 8;
					num6 = pixels[i * pixelWidth + j] & 0xFF;
					num = (int)((double)num4 * 0.393 + (double)num5 * 0.769 + (double)num6 * 0.189);
					num2 = (int)((double)num4 * 0.349 + (double)num5 * 0.686 + (double)num6 * 0.168);
					num3 = (int)((double)num4 * 0.272 + (double)num5 * 0.534 + (double)num6 * 0.131);
					num = ((num > 255) ? 255 : num);
					num2 = ((num2 > 255) ? 255 : num2);
					num3 = ((num3 > 255) ? 255 : num3);
					pixels2[i * pixelWidth + j] = -16777216 | ((byte)num << 16) | ((byte)num2 << 8) | (byte)num3;
				}
			}
		}
		return writeableBitmap;
	}
}
