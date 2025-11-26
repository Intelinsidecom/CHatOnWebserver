namespace ImageTools.IO.Png;

internal sealed class GrayscaleReader : IColorReader
{
	private int _row;

	private bool _useAlpha;

	public GrayscaleReader(bool useAlpha)
	{
		_useAlpha = useAlpha;
	}

	public void ReadScanline(byte[] scanline, byte[] pixels, PngHeader header)
	{
		int num = 0;
		if (_useAlpha)
		{
			for (int i = 0; i < scanline.Length / 2; i++)
			{
				num = (_row * header.Width + i) * 4;
				pixels[num] = scanline[i * 2];
				pixels[num + 1] = scanline[i * 2];
				pixels[num + 2] = scanline[i * 2];
				pixels[num + 3] = scanline[i * 2 + 1];
			}
		}
		else
		{
			for (int i = 0; i < scanline.Length; i++)
			{
				num = (_row * header.Width + i) * 4;
				pixels[num] = scanline[i];
				pixels[num + 1] = scanline[i];
				pixels[num + 2] = scanline[i];
				pixels[num + 3] = byte.MaxValue;
			}
		}
		_row++;
	}
}
