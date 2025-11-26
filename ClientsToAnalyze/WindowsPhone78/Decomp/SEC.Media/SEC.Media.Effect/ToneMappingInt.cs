using System;

namespace SEC.Media.Effect;

public class ToneMappingInt
{
	public const int FUNC_LOOKUP_TABLE_SIZE = 65536;

	private const int PROGRESS_BLOCK_FOR_STEP = 1023;

	public const int TONEMAPPING_MAX_STAGES = 4;

	private byte blue;

	private byte[] current_func_lookup_table;

	public static float current_process_power_value;

	private byte green;

	private uint hue;

	private int maximum;

	private int minimum;

	public ToneMappingParameters par;

	private Precomputed[] precomputed;

	public static float preview_zoom;

	private byte red;

	private uint saturation;

	private uint value;

	public ToneMappingInt()
	{
		current_process_power_value = 20f;
		preview_zoom = 1f;
		precomputed = new Precomputed[4];
		for (int i = 0; i < 4; i++)
		{
			precomputed[i].func_lookup_table = new byte[65536];
			for (int j = 0; j < 65536; j++)
			{
				precomputed[i].func_lookup_table[j] = 0;
			}
			precomputed[i].changed = true;
		}
		current_func_lookup_table = precomputed[0].func_lookup_table;
	}

	public void apply_parameters(ToneMappingParameters inpar)
	{
		par = inpar;
	}

	public int computeTotalProgress(int w, int h)
	{
		int num = 0;
		for (int i = 0; i < 4; i++)
		{
			if (par.stage[i].enabled)
			{
				num++;
			}
		}
		int num2 = 1;
		num2 += w / 1023 + h / 1023;
		int num3 = w * h;
		num2 += num3 / 1023;
		return 3 + num * num2;
	}

	public byte fast_func(byte x1, byte x2)
	{
		return current_func_lookup_table[(x1 << 8) + x2];
	}

	public float func(float x1, float x2)
	{
		switch (par.function_id)
		{
		case 0:
		{
			float num = (float)Math.Pow(10.0, Math.Abs(x2 * 2f - 1f) * current_process_power_value * 0.02f);
			if (x2 < 0.5f)
			{
				return 1f - (float)Math.Pow(1f - x1, num);
			}
			return (float)Math.Pow(x1, num);
		}
		case 1:
		{
			float num = 1f / (1f + (float)Math.Exp((0f - (x2 * 2f - 1f)) * current_process_power_value * 0.04f));
			if (!(x1 < num))
			{
				return 1f - num + (x1 - num) * num / (1f - num);
			}
			return x1 * (1f - num) / num;
		}
		default:
			return 0.5f;
		}
	}

	public void get_min_max_data(byte[] img, int size, int min, int max)
	{
		uint[] array = new uint[256];
		for (int i = 0; i < 256; i++)
		{
			array[i] = 0u;
		}
		for (int j = 0; j < size; j++)
		{
			array[img[j]]++;
		}
		uint num = (uint)(size / 1000);
		uint num2 = 0u;
		uint num3 = 0u;
		for (int k = 0; k < 256; k++)
		{
			num2 += array[k];
			if (num2 > num)
			{
				min = k;
				break;
			}
		}
		for (int num4 = 255; num4 >= 0; num4--)
		{
			num3 += array[num4];
			if (num3 > num)
			{
				max = num4;
				break;
			}
		}
		if (min >= max)
		{
			min = 0;
			max = 255;
		}
		maximum = max;
		minimum = min;
	}

	public void hsv2rgb(uint h, uint s, uint v, byte r, byte g, byte b)
	{
		uint num = (h >> 12) % 6;
		uint num2 = (h & 0xFFF) >> 4;
		byte b2 = (byte)(v * (0xFF ^ s) >> 8);
		byte b3 = (byte)(v * (0xFFFF ^ (num2 * s)) >> 16);
		byte b4 = (byte)(v * (0xFFFF ^ ((0xFF ^ num2) * s)) >> 16);
		switch (num)
		{
		case 0u:
			r = (byte)v;
			g = b4;
			b = b2;
			break;
		case 1u:
			r = b3;
			g = (byte)v;
			b = b2;
			break;
		case 2u:
			r = b2;
			g = (byte)v;
			b = b4;
			break;
		case 3u:
			r = b2;
			g = b3;
			b = (byte)v;
			break;
		case 4u:
			r = b4;
			g = b2;
			b = (byte)v;
			break;
		case 5u:
			r = (byte)v;
			g = b2;
			b = b3;
			break;
		}
		red = r;
		green = g;
		blue = b;
	}

	public bool inplace_blur_8bit_process(byte[] data, int sizex, int sizey, float blur)
	{
		blur /= preview_zoom;
		float num = (float)Math.Exp(Math.Log(0.5) / (double)blur * Math.Sqrt(2.0));
		if (num <= 0f || num >= 1f)
		{
			return false;
		}
		uint num2 = (uint)(65536f * num * num);
		if (num2 == 0)
		{
			return false;
		}
		for (int i = 0; i < sizey; i++)
		{
			int num3 = i * sizex;
			uint num4 = (uint)(data[num3] << 8);
			num3++;
			for (int j = 1; j < sizex; j++)
			{
				num4 = (uint)((ulong)((data[num3] << 8) * (0xFFFF ^ num2) + num4 * num2) >> 16);
				data[num3] = (byte)(num4 >> 8);
				num3++;
			}
			num3 = i * sizex + sizex - 1;
			for (int k = 1; k < sizex; k++)
			{
				num4 = (uint)((ulong)((data[num3] << 8) * (0xFFFF ^ num2) + num4 * num2) >> 16);
				data[num3] = (byte)(num4 >> 8);
				num3--;
			}
		}
		for (int l = 0; l < sizex; l++)
		{
			int num5 = l;
			uint num6 = (uint)(data[num5] << 8);
			for (int m = 1; m < sizey; m++)
			{
				num6 = (uint)((ulong)((data[num5] << 8) * (0xFFFF ^ num2) + num6 * num2) >> 16);
				data[num5] = (byte)(num6 >> 8);
				num5 += sizex;
			}
			num5 = l + sizex * (sizey - 1);
			for (int n = 1; n < sizey; n++)
			{
				num6 = (uint)((ulong)((data[num5] << 8) * (0xFFFF ^ num2) + num6 * num2) >> 16);
				data[num5] = (byte)(num6 >> 8);
				num5 -= sizex;
			}
		}
		return true;
	}

	public int max3(uint x1, uint x2, uint x3)
	{
		int num = (int)x1;
		if (x2 > num)
		{
			num = (int)x2;
		}
		if (x3 > num)
		{
			num = (int)x3;
		}
		return num;
	}

	public int min3(uint x1, uint x2, uint x3)
	{
		int num = (int)x1;
		if (x2 < num)
		{
			num = (int)x2;
		}
		if (x3 < num)
		{
			num = (int)x3;
		}
		return num;
	}

	public bool process_8bit_rgb_image(byte[] img, int sizex, int sizey)
	{
		update_preprocessed_values();
		int num = sizex * sizey;
		byte[] array = new byte[256];
		byte[] array2 = new byte[num * 3];
		byte[] array3 = new byte[num];
		for (int i = 0; i < num * 3; i++)
		{
			array2[i] = img[i];
		}
		if (par.stretch_contrast)
		{
			int min = 0;
			int max = 0;
			get_min_max_data(img, num * 3, min, max);
			min = maximum;
			max = minimum;
			stretch_contrast_8bit_rgb_image(img, sizex, sizey, min, max, array);
		}
		else
		{
			for (int j = 0; j < 256; j++)
			{
				array[j] = (byte)j;
			}
		}
		for (int k = 0; k < 4; k++)
		{
			if (par.stage[k].enabled)
			{
				int num2 = 0;
				for (int l = 0; l < num; l++)
				{
					array3[l] = (byte)((img[num2] + img[num2 + 1] + img[num2 + 2]) / 3);
					num2 += 3;
				}
				current_func_lookup_table = precomputed[k].func_lookup_table;
				if (!inplace_blur_8bit_process(array3, sizex, sizey, par.get_blur(k)))
				{
					return false;
				}
				num2 = 0;
				for (int m = 0; m < num; m++)
				{
					byte x = img[num2];
					byte x2 = img[num2 + 1];
					byte x3 = img[num2 + 2];
					byte x4 = array3[m];
					byte b = fast_func(x, x4);
					byte b2 = fast_func(x2, x4);
					byte b3 = fast_func(x3, x4);
					img[num2] = b;
					img[num2 + 1] = b2;
					img[num2 + 2] = b3;
					num2 += 3;
				}
			}
		}
		return true;
	}

	public void recompute_func_table(int nstage)
	{
		int num = 0;
		byte[] func_lookup_table = precomputed[nstage].func_lookup_table;
		current_process_power_value = par.get_power(nstage);
		for (int i = 0; i < 256; i++)
		{
			for (int j = 0; j < 256; j++)
			{
				float num2 = func((float)i / 255f, (float)j / 255f);
				func_lookup_table[num] = (byte)(num2 * 255f);
				num++;
			}
		}
		precomputed[nstage].changed = false;
	}

	public void rgb2hsv(byte r, byte g, byte b, uint h, uint s, uint v)
	{
		byte b2 = (byte)min3(r, g, b);
		byte b3 = (byte)max3(r, g, b);
		int num = b3 - b2;
		if (b3 == 0)
		{
			h = (v = (s = 0u));
			hue = h;
			saturation = s;
			value = v;
			return;
		}
		v = b3;
		s = (uint)((ulong)(255 * num) / (ulong)v);
		if (num == 0)
		{
			h = 0u;
			hue = h;
			saturation = s;
			value = v;
		}
		else if (b3 == r)
		{
			h = (uint)((4096 * (g - b) / num + 24576) % 24576);
			hue = h;
			saturation = s;
			value = v;
		}
		else if (b3 == g)
		{
			h = (uint)(8192 + 4096 * (b - r) / num);
			hue = h;
			saturation = s;
			value = v;
		}
		else if (b3 == b)
		{
			h = (uint)(16384 + 4096 * (r - g) / num);
			hue = h;
			saturation = s;
			value = v;
		}
		else
		{
			hue = h;
			saturation = s;
			value = v;
		}
	}

	public void stretch_contrast_8bit_rgb_image(byte[] img, int sizex, int sizey, int min, int max, byte[] stretch_contrast_table)
	{
		if (stretch_contrast_table == null)
		{
			stretch_contrast_table = new byte[256];
		}
		int num = max - min;
		for (int i = 0; i < 256; i++)
		{
			int num2 = (i - min << 8) / num;
			if (num2 < 0)
			{
				num2 = 0;
			}
			if (num2 > 255)
			{
				num2 = 255;
			}
			stretch_contrast_table[i] = (byte)num2;
		}
		int num3 = sizex * sizey;
		for (int j = 0; j < num3 * 3; j++)
		{
			img[j] = stretch_contrast_table[img[j]];
		}
	}

	public void update_preprocessed_values()
	{
		for (int i = 0; i < 4; i++)
		{
			if (precomputed[i].changed && par.stage[i].enabled)
			{
				recompute_func_table(i);
			}
		}
	}
}
