using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectMirror : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		int[] pixels = wb.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		for (int i = 0; i < pixelHeight; i++)
		{
			for (int j = 0; j < pixelWidth / 2; j++)
			{
				pixels2[i * pixelWidth + j] = pixels[i * pixelWidth + j];
				pixels2[i * pixelWidth + pixelWidth - j - 1] = pixels[i * pixelWidth + j];
			}
		}
		return writeableBitmap;
	}
}
