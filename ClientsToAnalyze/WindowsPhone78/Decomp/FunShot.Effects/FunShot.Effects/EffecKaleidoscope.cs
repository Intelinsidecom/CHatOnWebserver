using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffecKaleidoscope : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		int[] pixels = wb.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		_ = pixelWidth / 2;
		int num = 0;
		int num2 = 0;
		double[] array = new double[4] { 1.0, 1.0, 1.0, 1.0 };
		double[] array2 = new double[4] { 1.0, -1.0, -1.0, 1.0 };
		double[] array3 = new double[4];
		int num3 = 0;
		if (pixelWidth > pixelHeight)
		{
			array3[0] = -pixelWidth / 2;
			array3[1] = -pixelWidth / 2;
			array3[2] = pixelHeight - pixelWidth / 2;
			array3[3] = -pixelHeight - pixelWidth / 2;
			num3 = 0;
			for (int i = num3; i <= pixelHeight / 2; i++)
			{
				for (int j = pixelWidth / 2 - i; j <= pixelWidth / 2 + i; j++)
				{
					pixels2[i * pixelWidth + j] = pixels[i * pixelWidth + j];
					pixels2[(pixelHeight - 1 - i) * pixelWidth + j] = pixels[i * pixelWidth + j];
				}
			}
			for (int k = num3; k <= pixelHeight / 2; k++)
			{
				for (int l = pixelWidth / 2 - k; l <= pixelWidth / 2 + k; l++)
				{
					num = (int)((double)l - 2.0 * array[0] * ((array[0] * (double)l + array2[0] * (double)k + array3[0]) / (array[0] * array[0] + array2[0] * array2[0])));
					num2 = (int)((double)k - 2.0 * array2[0] * ((array[0] * (double)l + array2[0] * (double)k + array3[0]) / (array[0] * array[0] + array2[0] * array2[0])));
					if (num >= 0 && num2 >= 0 && num < pixelWidth && num2 < pixelHeight)
					{
						pixels2[num2 * pixelWidth + num] = pixels[k * pixelWidth + l];
						pixels2[(pixelHeight - 1 - num2) * pixelWidth + num] = pixels[k * pixelWidth + l];
					}
					num = (int)((double)l - 2.0 * array[1] * ((array[1] * (double)l + array2[1] * (double)k + array3[1]) / (array[1] * array[1] + array2[1] * array2[1])));
					num2 = (int)((double)k - 2.0 * array2[1] * ((array[1] * (double)l + array2[1] * (double)k + array3[1]) / (array[1] * array[1] + array2[1] * array2[1])));
					if (num >= 0 && num2 >= 0 && num < pixelWidth && num2 < pixelHeight)
					{
						pixels2[num2 * pixelWidth + num] = pixels[k * pixelWidth + l];
						pixels2[(pixelHeight - 1 - num2) * pixelWidth + num] = pixels[k * pixelWidth + l];
					}
				}
			}
			for (int m = 0; m < pixelHeight; m++)
			{
				for (int n = (pixelWidth - pixelHeight) / 2; n <= (pixelWidth + pixelHeight) / 2; n++)
				{
					if (n >= 0 && m >= 0 && n < pixelWidth && m < pixelHeight && pixelWidth - pixelHeight - n >= 0)
					{
						pixels2[m * pixelWidth + (pixelWidth - pixelHeight - n)] = pixels2[m * pixelWidth + n];
					}
					if (n >= 0 && m >= 0 && n < pixelWidth && m < pixelHeight && pixelWidth + pixelHeight - n < pixelWidth)
					{
						pixels2[m * pixelWidth + (pixelWidth + pixelHeight - n)] = pixels2[m * pixelWidth + n];
					}
				}
			}
		}
		else
		{
			array3[0] = -pixelHeight / 2;
			array3[1] = pixelHeight / 2 - pixelWidth;
			array3[2] = pixelHeight / 2;
			array3[3] = -pixelHeight / 2 - pixelWidth;
			num3 = (pixelHeight - pixelWidth) / 2;
			for (int num4 = num3; num4 <= pixelHeight / 2; num4++)
			{
				for (int num5 = pixelHeight / 2 - num4; num5 <= num4 - pixelHeight / 2 + pixelWidth; num5++)
				{
					pixels2[num4 * pixelWidth + num5] = pixels[num4 * pixelWidth + num5];
					pixels2[(pixelHeight - 1 - num4) * pixelWidth + num5] = pixels[num4 * pixelWidth + num5];
				}
			}
			for (int num6 = num3; num6 <= pixelHeight / 2; num6++)
			{
				for (int num7 = pixelHeight / 2 - num6; num7 <= num6 - pixelHeight / 2 + pixelWidth; num7++)
				{
					num = (int)((double)num7 - 2.0 * array[0] * ((array[0] * (double)num7 + array2[0] * (double)num6 + array3[0]) / (array[0] * array[0] + array2[0] * array2[0])));
					num2 = (int)((double)num6 - 2.0 * array2[0] * ((array[0] * (double)num7 + array2[0] * (double)num6 + array3[0]) / (array[0] * array[0] + array2[0] * array2[0])));
					if (num >= 0 && num2 >= 0 && num < pixelWidth && num2 < pixelHeight)
					{
						pixels2[num2 * pixelWidth + num] = pixels2[num6 * pixelWidth + num7];
						pixels2[(pixelHeight - 1 - num2) * pixelWidth + num] = pixels2[num6 * pixelWidth + num7];
					}
					num = (int)((double)num7 - 2.0 * array[1] * ((array[1] * (double)num7 + array2[1] * (double)num6 + array3[1]) / (array[1] * array[1] + array2[1] * array2[1])));
					num2 = (int)((double)num6 - 2.0 * array2[1] * ((array[1] * (double)num7 + array2[1] * (double)num6 + array3[1]) / (array[1] * array[1] + array2[1] * array2[1])));
					if (num >= 0 && num2 >= 0 && num < pixelWidth && num2 < pixelHeight)
					{
						pixels2[num2 * pixelWidth + num] = pixels2[num6 * pixelWidth + num7];
						pixels2[(pixelHeight - 1 - num2) * pixelWidth + num] = pixels2[num6 * pixelWidth + num7];
					}
					if (num >= 0 && num2 >= 0 && num < pixelWidth && num2 < pixelHeight && pixelHeight - pixelWidth - num6 >= 0 && pixelWidth - num7 >= 0)
					{
						pixels2[(pixelHeight - pixelWidth - num6) * pixelWidth + (pixelWidth - num7)] = pixels2[num6 * pixelWidth + num7];
					}
					if (num >= 0 && num2 >= 0 && num < pixelWidth && num2 < pixelHeight && num6 + pixelWidth < pixelHeight)
					{
						pixels2[(num6 + pixelWidth) * pixelWidth + (pixelWidth - num7)] = pixels2[num6 * pixelWidth + num7];
					}
				}
			}
		}
		return writeableBitmap;
	}
}
