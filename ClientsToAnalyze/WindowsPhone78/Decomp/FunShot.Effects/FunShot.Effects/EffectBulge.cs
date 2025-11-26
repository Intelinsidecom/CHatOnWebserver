using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectBulge : EffectBase
{
	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		int[] pixels = wb.Pixels;
		int[] pixels2 = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		int num = 2;
		int num2 = pixelWidth / 2;
		int num3 = pixelHeight / 2;
		int num4 = pixelWidth * num;
		int num5 = 0;
		int num6 = 0;
		int num7 = 0;
		int num8 = 0;
		int num9 = 0;
		int num10 = 0;
		int num11 = 0;
		int num12 = 0;
		int num13 = 0;
		int num14 = 0;
		int num15 = 0;
		int num16 = 0;
		int num17 = 0;
		int num18 = 0;
		int num19 = 0;
		int num20 = 0;
		int num21 = 0;
		int num22 = 0;
		int num23 = 0;
		float num24 = 0f;
		float num25 = 0f;
		float num26 = 0f;
		float num27 = 0f;
		float num28 = 0f;
		float num29 = 0f;
		float num30 = 0f;
		float num31 = 0f;
		int num32 = 1;
		int num33 = 0;
		int num34 = 0;
		int num35 = 0;
		for (int i = 0; i < pixelHeight; i++)
		{
			num5 = i - num3;
			for (int j = 0; j < pixelWidth; j++)
			{
				num6 = j - num2;
				num24 = EffectBase.sqrt[num6 * num6 + num5 * num5];
				num25 = 1f - num24 / (float)num4;
				num25 = 1f - (float)num32 * num25 * num25;
				num26 = (float)num6 * num25 + (float)num2;
				num27 = (float)num5 * num25 + (float)num3;
				num7 = (int)num26;
				num28 = num26 - (float)num7;
				num8 = ((num28 > 0f) ? (num7 + 1) : num7);
				num9 = (int)num27;
				num29 = num27 - (float)num9;
				num10 = ((num29 > 0f) ? (num9 + 1) : num9);
				num11 = num9 * pixelWidth + num7;
				num12 = (pixels[num11] & 0xFF0000) >> 16;
				num13 = (pixels[num11] & 0xFF00) >> 8;
				num14 = pixels[num11] & 0xFF;
				num11 = num9 * pixelWidth + num8;
				num15 = (pixels[num11] & 0xFF0000) >> 16;
				num16 = (pixels[num11] & 0xFF00) >> 8;
				num17 = pixels[num11] & 0xFF;
				num11 = num10 * pixelWidth + num8;
				num18 = (pixels[num11] & 0xFF0000) >> 16;
				num19 = (pixels[num11] & 0xFF00) >> 8;
				num20 = pixels[num11] & 0xFF;
				num11 = num10 * pixelWidth + num7;
				num21 = (pixels[num11] & 0xFF0000) >> 16;
				num22 = (pixels[num11] & 0xFF00) >> 8;
				num23 = pixels[num11] & 0xFF;
				num30 = 1f - num29;
				num31 = 1f - num28;
				num33 = (byte)(((float)num12 * num30 + (float)num21 * num29) * num31 + ((float)num15 * num30 + (float)num18 * num29) * num28);
				num34 = (byte)(((float)num13 * num30 + (float)num22 * num29) * num31 + ((float)num16 * num30 + (float)num19 * num29) * num28);
				num35 = (byte)(((float)num14 * num30 + (float)num23 * num29) * num31 + ((float)num17 * num30 + (float)num20 * num29) * num28);
				pixels2[i * pixelWidth + j] = -16777216 | (num33 << 16) | (num34 << 8) | num35;
			}
		}
		return writeableBitmap;
	}
}
