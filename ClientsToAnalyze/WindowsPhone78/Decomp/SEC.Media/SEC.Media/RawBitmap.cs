using System.Windows.Media.Imaging;

namespace SEC.Media;

public class RawBitmap
{
	public int Width { get; set; }

	public int Height { get; set; }

	public int[] Pixels { get; set; }

	public RawBitmap(int width, int height)
	{
		Width = width;
		Height = height;
		Pixels = new int[Width * Height];
	}

	public RawBitmap(byte[] buf, int w, int h)
	{
		int num = 0;
		int num2 = 0;
		int num3 = 0;
		int num4 = 0;
		int num5 = 0;
		if (Width == 0 && Height == 0)
		{
			Width = w;
			Height = h;
			Pixels = new int[Width * Height];
		}
		for (int i = 0; i < h; i++)
		{
			int num6 = 0;
			while (num6 < w)
			{
				num = 255 - buf[num4++];
				num2 = 255 - buf[num4++];
				num3 = 255 - buf[num4++];
				Pixels[num5] = (num << 16) | (num2 << 8) | num3 | -16777216;
				num6++;
				num5++;
			}
		}
	}

	public RawBitmap(RawBitmap rawBitmap)
	{
		Width = rawBitmap.Width;
		Height = rawBitmap.Height;
		Pixels = new int[Width * Height];
		rawBitmap.Pixels.CopyTo(Pixels, 0);
	}

	public RawBitmap(WriteableBitmap writeableBitmap)
	{
		WriteableBitmap writeableBitmap2 = new WriteableBitmap(writeableBitmap);
		Width = writeableBitmap2.PixelWidth;
		Height = writeableBitmap2.PixelHeight;
		Pixels = new int[Width * Height];
		writeableBitmap2.Pixels.CopyTo(Pixels, 0);
	}

	public WriteableBitmap ToWriteableBitmap()
	{
		WriteableBitmap writeableBitmap = new WriteableBitmap(Width, Height);
		Pixels.CopyTo(writeableBitmap.Pixels, 0);
		return writeableBitmap;
	}

	public byte[] ToByteArray()
	{
		byte[] array = new byte[Width * Height * 3];
		int[] pixels = Pixels;
		int num = 0;
		int num2 = pixels.Length;
		for (int i = 0; i < num2; i++)
		{
			int num3 = pixels[i];
			array[num++] = (byte)(num3 >> 16);
			array[num++] = (byte)(num3 >> 8);
			array[num++] = (byte)num3;
		}
		return array;
	}

	public RGBChannels SeparateRgbChannels()
	{
		RGBChannels rGBChannels = new RGBChannels(Width, Height);
		int num = 0;
		for (int i = 0; i < Height; i++)
		{
			for (int j = 0; j < Width; j++)
			{
				int num2 = Pixels[num];
				rGBChannels.R.Values[num] = (byte)((num2 & 0xFF0000) >> 16);
				rGBChannels.G.Values[num] = (byte)((num2 & 0xFF00) >> 8);
				rGBChannels.B.Values[num] = (byte)(num2 & 0xFF);
				num++;
			}
		}
		return rGBChannels;
	}

	public void CombineChannels(RGBChannels c)
	{
		int num = 0;
		for (int i = 0; i < Height; i++)
		{
			for (int j = 0; j < Width; j++)
			{
				Pixels[num] = (c.R.Values[num] << 16) | (c.G.Values[num] << 8) | c.B.Values[num] | -16777216;
				num++;
			}
		}
	}
}
