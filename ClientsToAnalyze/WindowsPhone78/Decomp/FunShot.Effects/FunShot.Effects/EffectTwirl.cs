using System;
using System.Windows;
using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectTwirl : EffectBase
{
	private float _twist;

	public EffectTwirl()
	{
		_twist = 20f;
		_twist = _twist * _twist * (float)Math.Sign(_twist);
	}

	public EffectTwirl(int twist)
	{
		_twist = twist * twist * Math.Sign(twist);
	}

	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		int[] pixels = wb.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		int num = wb.PixelWidth / 2;
		int num2 = wb.PixelHeight / 2;
		int num3 = num;
		int num4 = (num3 + 1) * (num3 + 1);
		int num5 = 1;
		int num6 = num5 * num5 + 1;
		Point[] array = new Point[num6];
		for (int i = 0; i < num6; i++)
		{
			Point point = new Point(i * num5, i);
			array[i] = point;
		}
		for (int j = 0; j < pixelHeight; j++)
		{
			int num7 = j - num2;
			for (int k = 0; k < pixelWidth; k++)
			{
				int num8 = k - num;
				if (num8 * num8 + num7 * num7 > num4)
				{
					pixels2[j * pixelWidth + k] = pixels[j * pixelWidth + k];
					continue;
				}
				int num9 = 0;
				int num10 = 0;
				int num11 = 0;
				for (int l = 0; l < num6; l++)
				{
					int num12 = (int)((double)num8 + array[l].X);
					int num13 = (int)((double)num7 + array[l].Y);
					float num14 = EffectBase.sqrt[num12 * num12 + num13 * num13];
					float num15 = EffectBase.aTan2[(num13 + 320) * 480 + num12 + 240];
					float num16 = 1f - num14 / (float)num3;
					num16 = ((num16 < 0f) ? 0f : (num16 * num16 * num16));
					num15 += num16 * _twist / 100f;
					if (num15 < 0f)
					{
						num15 += 6.283185f;
					}
					else if ((double)num15 >= Math.PI * 2.0)
					{
						num15 -= 6.283185f;
					}
					int num17 = (int)((double)num15 * 57.2957979);
					int num18 = pixels[(int)((float)num2 + num14 * EffectBase.sin[num17]) * pixelWidth + (int)((float)num + num14 * EffectBase.cos[num17])];
					num11 += (num18 & 0xFF0000) >> 16;
					num10 += (num18 & 0xFF00) >> 8;
					num9 += num18 & 0xFF;
				}
				pixels2[j * pixelWidth + k] = -16777216 | ((byte)(num11 / num6) << 16) | ((byte)(num10 / num6) << 8) | (byte)(num9 / num6);
			}
		}
		return writeableBitmap;
	}
}
