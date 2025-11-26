using System;
using System.Windows;
using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectTwist : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		int[] pixels = wb.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		float num = 20f;
		float num2 = (float)wb.PixelWidth / 2f;
		float num3 = (float)wb.PixelHeight / 2f;
		float num4 = Math.Min(num2, num3);
		num = num * num * (float)Math.Sign(num);
		int num5 = 1;
		int num6 = num5 * num5 + 1;
		Point[] array = new Point[num6];
		for (int i = 0; i < num6; i++)
		{
			Point point = new Point(i * num5, i);
			array[i] = point;
		}
		for (int j = 0; j < wb.PixelHeight; j++)
		{
			float num7 = (float)j - num3;
			for (int k = 0; k < wb.PixelWidth; k++)
			{
				float num8 = (float)k - num2;
				if (num8 * num8 + num7 * num7 > (num4 + 1f) * (num4 + 1f))
				{
					pixels2[j * wb.PixelWidth + k] = pixels[j * wb.PixelWidth + k];
					continue;
				}
				int num9 = 0;
				int num10 = 0;
				int num11 = 0;
				for (int l = 0; l < num6; l++)
				{
					float num12 = (float)((double)num8 + array[l].X);
					float num13 = (float)((double)num7 + array[l].Y);
					double num14 = EffectBase.sqrt[(int)(num12 * num12 + num13 * num13)];
					double num15 = EffectBase.aTan2[(int)((num13 + 240f) * 640f + num12 + 320f)];
					double num16 = 1.0 - num14 / (double)num4;
					num16 = ((num16 < 0.0) ? 0.0 : (num16 * num16 * num16));
					num15 += num16 * (double)num / 100.0;
					int num17 = pixels[(int)(num3 + (float)(num14 * Math.Sin(num15))) * wb.PixelWidth + (int)(num2 + (float)(num14 * Math.Cos(num15)))];
					num11 += (num17 & 0xFF0000) >> 16;
					num10 += (num17 & 0xFF00) >> 8;
					num9 += num17 & 0xFF;
				}
				pixels2[j * wb.PixelWidth + k] = -16777216 | ((byte)(num11 / num6) << 16) | ((byte)(num10 / num6) << 8) | (byte)(num9 / num6);
			}
		}
		return writeableBitmap;
	}
}
