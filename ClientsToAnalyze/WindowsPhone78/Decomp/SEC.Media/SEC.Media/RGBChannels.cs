namespace SEC.Media;

public class RGBChannels
{
	public ColorChannel B;

	public ColorChannel G;

	public ColorChannel R;

	public int Height;

	public int Width;

	public RGBChannels(RGBChannels rgb)
	{
		R = new ColorChannel(rgb.R);
		G = new ColorChannel(rgb.G);
		B = new ColorChannel(rgb.B);
	}

	public RGBChannels(int w, int h)
	{
		R = new ColorChannel(w, h);
		G = new ColorChannel(w, h);
		B = new ColorChannel(w, h);
	}

	public void Add(RGBChannels src)
	{
		R.Add(src.R);
		G.Add(src.G);
		B.Add(src.B);
	}

	public void CopyLinesFrom(RGBChannels src, int sy, int dy, int numLines)
	{
		R.CopyLinesFrom(src.R, sy, dy, numLines);
		G.CopyLinesFrom(src.G, sy, dy, numLines);
		B.CopyLinesFrom(src.B, sy, dy, numLines);
	}

	public void Shrink(double v)
	{
		R.Shrink(v);
		G.Shrink(v);
		B.Shrink(v);
	}

	public void Subtract(RGBChannels src)
	{
		R.Subtract(src.R);
		G.Subtract(src.G);
		B.Subtract(src.B);
	}

	public void Zero()
	{
		R.Zero();
		G.Zero();
		B.Zero();
	}
}
