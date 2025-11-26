using System;
using System.Windows;
using System.Windows.Controls;

namespace SEC.Media.Effect;

public class EffectCrop
{
	public RawBitmap Process(Image DisplayImg, RawBitmap src, Point p1, Point p2)
	{
		if (p1.X != p2.X && p1.Y != p2.Y)
		{
			double num = src.Width;
			double num2 = src.Height;
			double width = DisplayImg.Width;
			double height = DisplayImg.Height;
			double num3 = num / width;
			double num4 = num2 / height;
			RawBitmap rawBitmap = new RawBitmap((int)(num3 * Math.Abs(p2.X - p1.X)), (int)(num4 * Math.Abs(p2.Y - p1.Y)));
			int num5 = (int)(((p1.X < p2.X) ? p1.X : p2.X) * num3);
			int num6 = (int)(((p1.Y < p2.Y) ? p1.Y : p2.Y) * num4);
			for (int i = 0; i < rawBitmap.Pixels.Length; i++)
			{
				int num7 = i % rawBitmap.Width + num5;
				int num8 = i / rawBitmap.Width + num6;
				rawBitmap.Pixels[i] = src.Pixels[num8 * src.Width + num7];
			}
			return rawBitmap;
		}
		return src;
	}
}
