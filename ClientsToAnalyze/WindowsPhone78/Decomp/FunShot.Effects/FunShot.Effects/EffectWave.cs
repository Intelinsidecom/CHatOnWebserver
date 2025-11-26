using System;
using System.Windows;
using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectWave : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		int[] pixels = wb.Pixels;
		_ = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		short num = 5;
		int num2 = pixelWidth;
		int num3 = pixelHeight;
		Point[,] array = new Point[num2, num3];
		Point[,] array2 = new Point[num2, num3];
		Point point = new Point
		{
			X = num2 / 2,
			Y = num3 / 2
		};
		for (int i = 0; i < num2; i++)
		{
			for (int j = 0; j < num3; j++)
			{
				double num4 = (double)num * Math.Sin(6.283 * (double)j / 128.0);
				double num5 = (double)num * Math.Cos(6.283 * (double)i / 128.0);
				double num6 = (double)i + num4;
				double num7 = (double)j + num5;
				if (num6 > 0.0 && num6 < (double)num2)
				{
					array[i, j].X = num6;
					array2[i, j].X = (int)num6;
				}
				else
				{
					array[i, j].X = 0.0;
					array2[i, j].X = 0.0;
				}
				if (num7 > 0.0 && num7 < (double)num3)
				{
					array[i, j].Y = num7;
					array2[i, j].Y = (int)num7;
				}
				else
				{
					array[i, j].Y = 0.0;
					array2[i, j].Y = 0.0;
				}
			}
		}
		int[,] array3 = new int[pixelHeight, pixelWidth];
		Buffer.BlockCopy(pixels, 0, array3, 0, pixels.Length);
		int[,] array4 = new int[pixelWidth, pixelHeight];
		array4 = OffsetFilterAbs(array3, pixelWidth, pixelHeight, array2);
		Buffer.BlockCopy(array4, 0, writeableBitmap.Pixels, 0, array4.Length);
		return writeableBitmap;
	}

	public static int[,] OffsetFilterAbs(int[,] inputPixels, int width, int height, Point[,] offset)
	{
		int[,] array = new int[height, width];
		if (inputPixels != null && offset != null)
		{
			for (int i = 0; i < height; i++)
			{
				for (int j = 0; j < width; j++)
				{
					int num = (int)offset[j, i].X;
					int num2 = (int)offset[j, i].Y;
					if (num2 >= 0 && num2 < height && num >= 0 && num < width)
					{
						array[i, j] = inputPixels[num2, num];
					}
					int num3 = array[i, j];
					num3 += 3;
				}
			}
		}
		return array;
	}
}
