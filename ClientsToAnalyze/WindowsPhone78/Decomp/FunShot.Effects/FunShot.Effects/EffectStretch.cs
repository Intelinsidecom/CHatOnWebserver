using System;
using System.Windows;
using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectStretch : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		int[] pixels = wb.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		int num = 0;
		num = ((Math.Min(wb.PixelWidth, wb.PixelHeight) > 60) ? 96 : 32);
		new Point(pixelWidth / 2, pixelHeight / 2);
		int num2 = 0;
		int num3 = 0;
		for (int i = num / 4; i < pixelHeight - num / 4; i++)
		{
			num3 = 0;
			for (int j = num / 4; j < pixelWidth / 2 - num / 4; j++)
			{
				if (i < pixelHeight / 2 - num / 4)
				{
					pixels2[(i - num / 4) * pixelWidth + num3] = pixels[i * pixelWidth + j];
				}
				else if (i >= pixelHeight / 2 + num / 4)
				{
					pixels2[(i + num / 4) * pixelWidth + num3] = pixels[i * pixelWidth + j];
				}
				num3++;
			}
		}
		for (int k = num / 4; k < pixelHeight - num / 4; k++)
		{
			num3 = 0;
			for (int l = pixelWidth / 2 + num / 4; l < pixelWidth - num / 4; l++)
			{
				if (k < pixelHeight / 2 - num / 4)
				{
					pixels2[(k - num / 4) * pixelWidth + num3 + pixelWidth / 2 + num / 2] = pixels[k * pixelWidth + l];
				}
				else if (k >= pixelHeight / 2 + num / 4)
				{
					pixels2[(k + num / 4) * pixelWidth + num3 + pixelWidth / 2 + num / 2] = pixels[k * pixelWidth + l];
				}
				num3++;
			}
		}
		for (int m = num / 4; m < pixelHeight / 2 - num / 4; m++)
		{
			num3 = 0;
			for (int n = pixelWidth / 2 - num / 4; n < pixelWidth / 2 + num / 4; n++)
			{
				pixels2[(m - num / 4) * pixelWidth + pixelWidth / 2 - num / 2 + num3 * 2] = pixels[m * pixelWidth + n];
				pixels2[(m - num / 4) * pixelWidth + pixelWidth / 2 - num / 2 + num3 * 2 + 1] = pixels[m * pixelWidth + n];
				num3++;
			}
		}
		for (int num4 = pixelHeight / 2 + num / 4; num4 < pixelHeight - num / 4; num4++)
		{
			num3 = 0;
			for (int num5 = pixelWidth / 2 - num / 4; num5 < pixelWidth / 2 + num / 4; num5++)
			{
				pixels2[(num4 + num / 4) * pixelWidth + pixelWidth / 2 - num / 2 + num3 * 2] = pixels[num4 * pixelWidth + num5];
				pixels2[(num4 + num / 4) * pixelWidth + pixelWidth / 2 - num / 2 + num3 * 2 + 1] = pixels[num4 * pixelWidth + num5];
				num3++;
			}
		}
		num2 = 0;
		for (int num6 = pixelHeight / 2 - num / 4; num6 < pixelHeight / 2 + num / 4; num6++)
		{
			for (int num7 = num / 4; num7 < pixelWidth / 2 - num / 4; num7++)
			{
				pixels2[(pixelHeight / 2 - num / 2 + num2 * 2) * pixelWidth + (num7 - num / 4)] = pixels[num6 * pixelWidth + num7];
				pixels2[(pixelHeight / 2 - num / 2 + num2 * 2 + 1) * pixelWidth + (num7 - num / 4)] = pixels[num6 * pixelWidth + num7];
			}
			num2++;
		}
		num2 = 0;
		for (int num8 = pixelHeight / 2 - num / 4; num8 < pixelHeight / 2 + num / 4; num8++)
		{
			for (int num9 = pixelWidth / 2 + num / 4; num9 < pixelWidth - num / 4; num9++)
			{
				pixels2[(pixelHeight / 2 - num / 2 + num2 * 2) * pixelWidth + (num9 + num / 4)] = pixels[num8 * pixelWidth + num9];
				pixels2[(pixelHeight / 2 - num / 2 + num2 * 2 + 1) * pixelWidth + (num9 + num / 4)] = pixels[num8 * pixelWidth + num9];
			}
			num2++;
		}
		num2 = 0;
		for (int num10 = pixelHeight / 2 - num / 4; num10 < pixelHeight / 2 + num / 4; num10++)
		{
			int num11 = 0;
			for (int num12 = pixelWidth / 2 - num / 4; num12 < pixelWidth / 2 + num / 4; num12++)
			{
				pixels2[(pixelHeight / 2 - num / 2 + num2 * 2) * pixelWidth + pixelWidth / 2 - num / 2 + num11 * 2] = pixels[num10 * pixelWidth + num12];
				pixels2[(pixelHeight / 2 - num / 2 + num2 * 2 + 1) * pixelWidth + pixelWidth / 2 - num / 2 + num11 * 2] = pixels[num10 * pixelWidth + num12];
				pixels2[(pixelHeight / 2 - num / 2 + num2 * 2) * pixelWidth + pixelWidth / 2 - num / 2 + num11 * 2 + 1] = pixels[num10 * pixelWidth + num12];
				pixels2[(pixelHeight / 2 - num / 2 + num2 * 2 + 1) * pixelWidth + pixelWidth / 2 - num / 2 + num11 * 2 + 1] = pixels[num10 * pixelWidth + num12];
				num11++;
			}
			num2++;
		}
		return writeableBitmap;
	}
}
