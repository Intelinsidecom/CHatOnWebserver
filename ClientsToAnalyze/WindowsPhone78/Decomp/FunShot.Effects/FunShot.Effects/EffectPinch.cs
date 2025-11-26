using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectPinch : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		int[] pixels = wb.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		_ = wb.PixelHeight;
		int num = wb.PixelWidth / 2;
		int num2 = wb.PixelHeight / 2;
		int num3 = num;
		int num4 = -2;
		for (int i = 0; i < wb.PixelHeight; i++)
		{
			int num5 = i - num2;
			for (int j = 0; j < pixelWidth; j++)
			{
				int num6 = j - num;
				float num7 = EffectBase.sqrt[num6 * num6 + num5 * num5];
				float num8 = 1f - num7 / (float)num3;
				if (num8 > 0f)
				{
					num8 = 1f - (float)num4 * num8 * num8;
					float num9 = (float)num6 * num8;
					float num10 = (float)num5 * num8;
					pixels2[i * pixelWidth + j] = GetBilinearSampleWrapped(num9 + (float)num, num10 + (float)num2, wb);
				}
				else
				{
					pixels2[i * pixelWidth + j] = pixels[i * pixelWidth + j];
				}
			}
		}
		return writeableBitmap;
	}

	public int GetBilinearSampleWrapped(float x, float y, WriteableBitmap wb)
	{
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		int num = (int)x;
		int num2 = (int)(256f * (x - (float)num));
		int num3 = 256 - num2;
		int num4 = (int)y;
		int num5 = (int)(256f * (y - (float)num4));
		int num6 = 256 - num5;
		int num7 = num;
		if (num7 < 0)
		{
			num7 = pixelWidth - 1 + (num7 + 1) % pixelWidth;
		}
		else if (num7 > pixelWidth - 1)
		{
			num7 %= pixelWidth;
		}
		int num8 = num4;
		if (num8 < 0)
		{
			num8 = pixelHeight - 1 + (num8 + 1) % pixelHeight;
		}
		else if (num8 > pixelHeight - 1)
		{
			num8 %= pixelHeight;
		}
		int num9 = num7;
		int num10 = ((num9 != pixelWidth - 1) ? (num9 + 1) : 0);
		int num11 = num8;
		int num12 = ((num11 != pixelHeight - 1) ? (num11 + 1) : 0);
		int num13 = wb.Pixels[num11 * pixelWidth + num9];
		int num14 = wb.Pixels[num11 * pixelWidth + num10];
		int num15 = wb.Pixels[num12 * pixelWidth + num9];
		int num16 = wb.Pixels[num12 * pixelWidth + num10];
		byte b = (byte)((((num13 & 0xFF0000) >> 16) + ((num14 & 0xFF0000) >> 16) + ((num15 & 0xFF0000) >> 16) + ((num16 & 0xFF0000) >> 16)) / 4);
		byte b2 = (byte)((((num13 & 0xFF00) >> 8) + ((num14 & 0xFF00) >> 8) + ((num15 & 0xFF00) >> 8) + ((num16 & 0xFF00) >> 8)) / 4);
		byte b3 = (byte)(((num13 & 0xFF) + (num14 & 0xFF) + (num15 & 0xFF) + (num16 & 0xFF)) / 4);
		return -16777216 | (b << 16) | (b2 << 8) | b3;
	}
}
