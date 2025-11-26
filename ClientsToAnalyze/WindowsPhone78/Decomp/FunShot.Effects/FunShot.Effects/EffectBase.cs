using System;
using System.Windows.Media.Imaging;

namespace FunShot.Effects;

public class EffectBase
{
	public static float[] sqrt;

	public static float[] aTan;

	public static float[] aTan2;

	public static float[] cos;

	public static float[] sin;

	public string EffecName { get; set; }

	static EffectBase()
	{
		sqrt = new float[160001];
		for (int i = 0; i <= 160000; i++)
		{
			sqrt[i] = (float)Math.Sqrt(i);
		}
		aTan = new float[307200];
		for (int j = 0; j < 640; j++)
		{
			for (int k = 0; k < 480; k++)
			{
				aTan[j * 480 + k] = (float)(Math.Atan2(j - 320, k - 240) * 360.0 / (Math.PI * 2.0));
			}
		}
		aTan2 = new float[307200];
		for (int l = 0; l < 640; l++)
		{
			for (int m = 0; m < 480; m++)
			{
				aTan2[l * 480 + m] = (float)Math.Atan2(l - 320, m - 240);
			}
		}
		cos = new float[361];
		for (int n = 0; n <= 360; n++)
		{
			cos[n] = (float)Math.Cos((double)(n * 2) * Math.PI / 360.0);
		}
		sin = new float[361];
		for (int num = 0; num <= 360; num++)
		{
			sin[num] = (float)Math.Sin((double)(num * 2) * Math.PI / 360.0);
		}
	}

	public virtual WriteableBitmap Process(WriteableBitmap wb)
	{
		return wb;
	}
}
