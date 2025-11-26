using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectTunnel : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		int[] pixels = wb.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		int num = (int)((double)pixelWidth * 0.4);
		int num2 = 360;
		int[] array = new int[num2];
		for (int i = 0; i < num2; i++)
		{
			int num3 = (int)(EffectBase.cos[i] * (float)num + (float)(pixelWidth / 2));
			int num4 = (int)(EffectBase.sin[i] * (float)num + (float)(pixelHeight / 2));
			if (num3 == pixelWidth)
			{
				num3--;
			}
			if (num4 == pixelHeight)
			{
				num4--;
			}
			array[i] = pixels[num4 * pixelWidth + num3];
		}
		for (int j = 0; j < pixelHeight; j++)
		{
			for (int k = 0; k < pixelWidth; k++)
			{
				if (EffectBase.sqrt[(k - pixelWidth / 2) * (k - pixelWidth / 2) + (j - pixelHeight / 2) * (j - pixelHeight / 2)] < (float)num)
				{
					pixels2[j * pixelWidth + k] = pixels[j * pixelWidth + k];
					continue;
				}
				int num5 = (int)EffectBase.aTan[(j + 320 - pixelHeight / 2) * 480 + (k + 240 - pixelWidth / 2)];
				if (num5 < 0)
				{
					num5 += 360;
				}
				pixels2[j * pixelWidth + k] = array[num5];
			}
		}
		return writeableBitmap;
	}
}
