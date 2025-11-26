using System;

namespace ImageTools.IO.Png;

internal sealed class TrueColorReader : IColorReader
{
	private int _row;

	private bool _useAlpha;

	public TrueColorReader(bool useAlpha)
	{
		_useAlpha = useAlpha;
	}

	public void ReadScanline(byte[] scanline, byte[] pixels, PngHeader header)
	{
		int num = 0;
		if (_useAlpha)
		{
			Array.Copy(scanline, 0, pixels, _row * header.Width * 4, scanline.Length);
		}
		else
		{
			for (int i = 0; i < scanline.Length / 3; i++)
			{
				num = (_row * header.Width + i) * 4;
				pixels[num] = scanline[i * 3];
				pixels[num + 1] = scanline[i * 3 + 1];
				pixels[num + 2] = scanline[i * 3 + 2];
				pixels[num + 3] = byte.MaxValue;
			}
		}
		_row++;
	}
}
