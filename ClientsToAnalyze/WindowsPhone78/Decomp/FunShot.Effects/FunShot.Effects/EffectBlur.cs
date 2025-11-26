using System;
using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectBlur : EffectBase
{
	public float Sigma { get; set; }

	public override WriteableBitmap Process(WriteableBitmap wb)
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(wb.PixelWidth, wb.PixelHeight);
		Sigma = 1f;
		int[] pixels = wb.Pixels;
		_ = writeableBitmap.Pixels;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		if (pixels == null)
		{
			return null;
		}
		int[] pixels2 = writeableBitmap.Pixels;
		float[] array = ApplyBlur(ConvertImageWithPadding<int, float>(pixels, pixelWidth, pixelHeight, 3, -16777216, ArgbIntToFloat), pixelWidth, pixelHeight, Sigma);
		for (int i = 0; i < pixelHeight; i++)
		{
			int num = (i + 3) * (pixelWidth + 6) + 3;
			int num2 = i * pixelWidth;
			for (int j = 0; j < pixelWidth; j++)
			{
				int num3 = (num + j) * 4;
				int num4 = pixels[num2 + j] >> 24;
				pixels2[num2 + j] = ((byte)num4 << 24) | ((byte)(array[num3 + 1] * 255f) << 16) | ((byte)(array[num3 + 2] * 255f) << 8) | (byte)(array[num3 + 3] * 255f);
			}
		}
		return writeableBitmap;
	}

	private static float[] ApplyBlur(float[] srcPixels, int width, int height, float sigma)
	{
		float[] array = new float[srcPixels.Length];
		Array.Copy(srcPixels, array, array.Length);
		int num = width + 6;
		int num2 = height + 6;
		float num3 = sigma * sigma;
		float num4 = num3 * sigma;
		float num5 = 1.57825f + 2.44413f * sigma + 1.4281f * num3 + 0.422205f * num4;
		float num6 = 2.44413f * sigma + 2.85619f * num3 + 1.26661f * num4;
		float num7 = 0f - (1.4281f * num3 + 1.26661f * num4);
		float num8 = 0.422205f * num4;
		float b = 1f - (num6 + num7 + num8) / num5;
		ApplyPass(array, num, num2, num5, num6, num7, num8, b);
		float[] array2 = new float[array.Length];
		Transpose(array, array2, num, num2);
		ApplyPass(array2, num2, num, num5, num6, num7, num8, b);
		Transpose(array2, array, num2, num);
		return array;
	}

	private static void ApplyPass(float[] pixels, int width, int height, float b0, float b1, float b2, float b3, float b)
	{
		float ib = 1f / b0;
		int num = width * 4;
		for (int i = 0; i < height; i++)
		{
			int num2 = i * num;
			for (int j = num2 + 12; j < num2 + num; j += 4)
			{
				FilterForward(j + 1, pixels, b, b1, b2, b3, ib);
				FilterForward(j + 2, pixels, b, b1, b2, b3, ib);
				FilterForward(j + 3, pixels, b, b1, b2, b3, ib);
			}
			for (int num3 = num2 + num - 12 - 4; num3 >= num2; num3 -= 4)
			{
				FilterBackward(num3 + 1, pixels, b, b1, b2, b3, ib);
				FilterBackward(num3 + 2, pixels, b, b1, b2, b3, ib);
				FilterBackward(num3 + 3, pixels, b, b1, b2, b3, ib);
			}
		}
	}

	private static void Transpose<T>(T[] input, T[] output, int width, int height)
	{
		for (int i = 0; i < height; i++)
		{
			int num = i * width * 4;
			for (int j = 0; j < width; j++)
			{
				int num2 = j * height * 4;
				output[num2 + i * 4] = input[num + j * 4];
				output[num2 + i * 4 + 1] = input[num + j * 4 + 1];
				output[num2 + i * 4 + 2] = input[num + j * 4 + 2];
				output[num2 + i * 4 + 3] = input[num + j * 4 + 3];
			}
		}
	}

	private static void FilterForward(int i, float[] pixels, float b, float b1, float b2, float b3, float ib0)
	{
		pixels[i] = b * pixels[i] + (b1 * pixels[i - 4] + b2 * pixels[i - 8] + b3 * pixels[i - 12]) * ib0;
	}

	private static void FilterBackward(int i, float[] pixels, float b, float b1, float b2, float b3, float ib0)
	{
		pixels[i] = b * pixels[i] + (b1 * pixels[i + 4] + b2 * pixels[i + 8] + b3 * pixels[i + 12]) * ib0;
	}

	private static T[] ConvertImageWithPadding<TS, T>(TS[] source, int width, int height, int padding, TS paddedValue, Action<TS, T[], int> decompose)
	{
		int num = height + 2 * padding;
		int num2 = width + 2 * padding;
		T[] array = new T[num * num2 * 4];
		for (int i = 0; i < padding; i++)
		{
			int num3 = num2 * i;
			for (int j = 0; j < padding; j++)
			{
				decompose(paddedValue, array, (num3 + j) * 4);
			}
			for (int k = 0; k < width; k++)
			{
				decompose(source[k], array, (num3 + k + padding) * 4);
			}
			for (int l = width; l < width + padding; l++)
			{
				decompose(paddedValue, array, (num3 + l) * 4);
			}
		}
		for (int m = 0; m < height; m++)
		{
			int num4 = num2 * (m + padding);
			int num5 = width * m;
			for (int n = 0; n < num2; n++)
			{
				if (n < padding)
				{
					decompose(source[num5], array, (n + num4) * 4);
				}
				else if (n >= padding + width)
				{
					decompose(source[num5 + width - 1], array, (n + num4) * 4);
				}
				else
				{
					decompose(source[num5 - padding + n], array, (n + num4) * 4);
				}
			}
		}
		for (int num6 = 0; num6 < padding; num6++)
		{
			int num7 = num2 * (height + padding + num6);
			int num8 = width * (height - 1);
			for (int num9 = 0; num9 < padding; num9++)
			{
				decompose(paddedValue, array, (num7 + num9) * 4);
			}
			for (int num10 = 0; num10 < width; num10++)
			{
				decompose(source[num8 + num10], array, (num7 + num10 + padding) * 4);
			}
			for (int num11 = width; num11 < width + padding; num11++)
			{
				decompose(paddedValue, array, (num7 + num11) * 4);
			}
		}
		return array;
	}

	private static void ArgbIntToFloat(int src, float[] tgt, int idx)
	{
		tgt[idx] = (float)((src >> 24) & 0xFF) * 0.003921569f;
		tgt[idx + 1] = (float)((src >> 16) & 0xFF) * 0.003921569f;
		tgt[idx + 2] = (float)((src >> 8) & 0xFF) * 0.003921569f;
		tgt[idx + 3] = (float)(src & 0xFF) * 0.003921569f;
	}
}
