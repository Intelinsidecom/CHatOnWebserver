using System;
using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectSqueeze : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		_ = wb.Pixels;
		_ = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		int num = (int)Math.Round((double)wb.PixelHeight * 0.1);
		int num2 = (int)Math.Round((double)wb.PixelHeight * 0.3);
		int num3 = (int)Math.Round((double)wb.PixelHeight * 0.7);
		int num4 = (int)Math.Round((double)wb.PixelHeight * 0.9);
		int num5 = num + num2;
		int num6 = num4 - num;
		for (int i = 0; i < pixelHeight; i++)
		{
			for (int j = 0; j < pixelWidth; j++)
			{
				if (i < num)
				{
					writeableBitmap.Pixels[2 * i * pixelWidth + j] = (writeableBitmap.Pixels[(2 * i + 1) * pixelWidth + j] = wb.Pixels[i * pixelWidth + j]);
				}
				else if (i < num2)
				{
					writeableBitmap.Pixels[(i + num) * pixelWidth + j] = wb.Pixels[i * pixelWidth + j];
				}
				else if (i < num3)
				{
					if ((i - num2) % 2 == 0)
					{
						writeableBitmap.Pixels[((i - num2) / 2 + num5) * pixelWidth + j] = wb.Pixels[i * pixelWidth + j];
					}
				}
				else if (i < num4)
				{
					writeableBitmap.Pixels[(i - num) * pixelWidth + j] = wb.Pixels[i * pixelWidth + j];
				}
				else
				{
					writeableBitmap.Pixels[(2 * (i - num4) + num6) * pixelWidth + j] = (writeableBitmap.Pixels[(2 * (i - num4) + num6 + 1) * pixelWidth + j] = wb.Pixels[i * pixelWidth + j]);
				}
			}
		}
		int[] array = (int[])writeableBitmap.Pixels.Clone();
		int num7 = (int)Math.Round((double)wb.PixelWidth * 1.0 / 12.0);
		int num8 = (int)Math.Round((double)wb.PixelWidth * 4.0 / 12.0);
		int num9 = (int)Math.Round((double)wb.PixelWidth * 8.0 / 12.0);
		int num10 = (int)Math.Round((double)wb.PixelWidth * 11.0 / 12.0);
		int num11 = num7 + num8;
		int num12 = num10 - num7;
		for (int k = 0; k < pixelHeight; k++)
		{
			for (int l = 0; l < pixelWidth; l++)
			{
				if (l < num7)
				{
					writeableBitmap.Pixels[k * pixelWidth + l * 2] = (writeableBitmap.Pixels[k * pixelWidth + l * 2 + 1] = array[k * pixelWidth + l]);
				}
				else if (l < num8)
				{
					writeableBitmap.Pixels[k * pixelWidth + l + num7] = array[k * pixelWidth + l];
				}
				else if (l < num9)
				{
					if ((l - num8) % 2 == 0)
					{
						writeableBitmap.Pixels[k * pixelWidth + (l - num8) / 2 + num11] = array[k * pixelWidth + l];
					}
				}
				else if (l < num10)
				{
					writeableBitmap.Pixels[k * pixelWidth + l - num7] = array[k * pixelWidth + l];
				}
				else
				{
					writeableBitmap.Pixels[k * pixelWidth + (l - num10) * 2 + num12] = (writeableBitmap.Pixels[k * pixelWidth + (l - num10) * 2 + num12 + 1] = array[k * pixelWidth + l]);
				}
			}
		}
		return writeableBitmap;
	}
}
