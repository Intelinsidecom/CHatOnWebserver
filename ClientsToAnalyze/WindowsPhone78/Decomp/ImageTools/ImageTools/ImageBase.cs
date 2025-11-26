using System;
using System.Diagnostics.Contracts;
using System.Windows.Media;
using ImageTools.Helpers;

namespace ImageTools;

[ContractVerification(false)]
public class ImageBase
{
	public const int DefaultDelayTime = 10;

	private int _delayTime;

	private bool _isFilled;

	private byte[] _pixels;

	private int _pixelHeight;

	private int _pixelWidth;

	[Pure]
	public int DelayTime
	{
		get
		{
			int num = _delayTime;
			if (num <= 0)
			{
				num = 10;
			}
			return num;
		}
		set
		{
			_delayTime = value;
		}
	}

	[Pure]
	public bool IsFilled => _isFilled;

	[Pure]
	public byte[] Pixels
	{
		get
		{
			Contract.Ensures(!IsFilled || Contract.Result<byte[]>() != null);
			return _pixels;
		}
	}

	public int PixelHeight
	{
		get
		{
			Contract.Ensures(!IsFilled || Contract.Result<int>() > 0);
			return _pixelHeight;
		}
	}

	public int PixelWidth
	{
		get
		{
			Contract.Ensures(!IsFilled || Contract.Result<int>() > 0);
			return _pixelWidth;
		}
	}

	public double PixelRatio
	{
		get
		{
			Contract.Ensures(!IsFilled || Contract.Result<double>() > 0.0);
			if (IsFilled)
			{
				return (double)PixelWidth / (double)PixelHeight;
			}
			return 0.0;
		}
	}

	[Pure]
	public Color this[int x, int y]
	{
		get
		{
			Contract.Requires<InvalidOperationException>(IsFilled, "Image is not loaded.");
			Contract.Requires<ArgumentException>(x >= 0 && x < PixelWidth, "X must be in the range of the image.");
			Contract.Requires<ArgumentException>(y >= 0 && y < PixelHeight, "Y must be in the range of the image.");
			Contract.Ensures(IsFilled);
			int num = (y * PixelWidth + x) * 4;
			return new Color
			{
				R = _pixels[num],
				G = _pixels[num + 1],
				B = _pixels[num + 2],
				A = _pixels[num + 3]
			};
		}
		set
		{
			Contract.Requires<InvalidOperationException>(IsFilled, "Image is not loaded.");
			Contract.Requires<ArgumentException>(x >= 0 && x < PixelWidth, "X must be in the range of the image.");
			Contract.Requires<ArgumentException>(y >= 0 && y < PixelHeight, "Y must be in the range of the image.");
			Contract.Ensures(IsFilled);
			int num = (y * PixelWidth + x) * 4;
			_pixels[num] = value.R;
			_pixels[num + 1] = value.G;
			_pixels[num + 2] = value.B;
			_pixels[num + 3] = value.A;
		}
	}

	[Pure]
	public Rectangle Bounds => new Rectangle(0, 0, PixelWidth, PixelHeight);

	internal static void Transform(ImageBase source, ImageBase target, RotationType rotationType, FlippingType flippingType)
	{
		Contract.Requires<ArgumentNullException>(source != null, "Source image cannot be null.");
		Contract.Requires<ArgumentException>(source.IsFilled, "Source image has not been loaded.");
		Contract.Requires<ArgumentNullException>(target != null, "Target image cannot be null.");
		switch (rotationType)
		{
		case RotationType.None:
		{
			byte[] pixels = source.Pixels;
			byte[] array = new byte[pixels.Length];
			Array.Copy(pixels, array, pixels.Length);
			target.SetPixels(source.PixelWidth, source.PixelHeight, array);
			break;
		}
		case RotationType.Rotate90:
			Rotate90(source, target);
			break;
		case RotationType.Rotate180:
			Rotate180(source, target);
			break;
		case RotationType.Rotate270:
			Rotate270(source, target);
			break;
		default:
			throw new InvalidOperationException();
		}
		switch (flippingType)
		{
		case FlippingType.FlipX:
			FlipX(target);
			break;
		case FlippingType.FlipY:
			FlipY(target);
			break;
		}
	}

	private static void Rotate270(ImageBase source, ImageBase target)
	{
		Contract.Requires(source != null);
		Contract.Requires(source.IsFilled);
		Contract.Requires(target != null);
		Contract.Ensures(target.IsFilled);
		int num = 0;
		int num2 = 0;
		byte[] pixels = source.Pixels;
		byte[] array = new byte[source.PixelWidth * source.PixelHeight * 4];
		for (int i = 0; i < source.PixelHeight; i++)
		{
			for (int j = 0; j < source.PixelWidth; j++)
			{
				num = (i * source.PixelWidth + j) * 4;
				num2 = ((source.PixelWidth - j - 1) * source.PixelHeight + i) * 4;
				array[num2] = pixels[num];
				array[num2 + 1] = pixels[num + 1];
				array[num2 + 2] = pixels[num + 2];
				array[num2 + 3] = pixels[num + 3];
			}
		}
		target.SetPixels(source.PixelHeight, source.PixelWidth, array);
	}

	private static void Rotate180(ImageBase source, ImageBase target)
	{
		Contract.Requires(source != null);
		Contract.Requires(source.IsFilled);
		Contract.Requires(target != null);
		Contract.Ensures(target.IsFilled);
		int num = 0;
		int num2 = 0;
		byte[] pixels = source.Pixels;
		byte[] array = new byte[source.PixelWidth * source.PixelHeight * 4];
		for (int i = 0; i < source.PixelHeight; i++)
		{
			for (int j = 0; j < source.PixelWidth; j++)
			{
				num = (i * source.PixelHeight + j) * 4;
				num2 = ((source.PixelHeight - i - 1) * source.PixelWidth + source.PixelWidth - j - 1) * 4;
				array[num2] = pixels[num];
				array[num2 + 1] = pixels[num + 1];
				array[num2 + 2] = pixels[num + 2];
				array[num2 + 3] = pixels[num + 3];
			}
		}
		target.SetPixels(source.PixelWidth, source.PixelHeight, array);
	}

	private static void Rotate90(ImageBase source, ImageBase target)
	{
		Contract.Requires(source != null);
		Contract.Requires(source.IsFilled);
		Contract.Requires(target != null);
		Contract.Ensures(target.IsFilled);
		int num = 0;
		int num2 = 0;
		byte[] pixels = source.Pixels;
		byte[] array = new byte[source.PixelWidth * source.PixelHeight * 4];
		for (int i = 0; i < source.PixelHeight; i++)
		{
			for (int j = 0; j < source.PixelWidth; j++)
			{
				num = (i * source.PixelWidth + j) * 4;
				num2 = ((j + 1) * source.PixelHeight - i - 1) * 4;
				array[num2] = pixels[num];
				array[num2 + 1] = pixels[num + 1];
				array[num2 + 2] = pixels[num + 2];
				array[num2 + 3] = pixels[num + 3];
			}
		}
		target.SetPixels(source.PixelHeight, source.PixelWidth, array);
	}

	private static void FlipX(ImageBase image)
	{
		Contract.Requires<ArgumentNullException>(image != null, "Image cannot be null.");
		Contract.Requires<ArgumentException>(image.IsFilled, "Other image has not been loaded.");
		int num = 0;
		int num2 = 0;
		byte[] pixels = image.Pixels;
		for (int i = 0; i < image.PixelHeight / 2; i++)
		{
			for (int j = 0; j < image.PixelWidth; j++)
			{
				num = (i * image.PixelWidth + j) * 4;
				byte b = pixels[num];
				byte b2 = pixels[num + 1];
				byte b3 = pixels[num + 2];
				byte b4 = pixels[num + 3];
				num2 = ((image.PixelHeight - i - 1) * image.PixelWidth + j) * 4;
				pixels[num] = pixels[num2];
				pixels[num + 1] = pixels[num2 + 1];
				pixels[num + 2] = pixels[num2 + 2];
				pixels[num + 3] = pixels[num2 + 3];
				pixels[num2] = b;
				pixels[num2 + 1] = b2;
				pixels[num2 + 2] = b3;
				pixels[num2 + 3] = b4;
			}
		}
	}

	private static void FlipY(ImageBase image)
	{
		Contract.Requires<ArgumentNullException>(image != null, "Image cannot be null.");
		Contract.Requires<ArgumentException>(image.IsFilled, "Other image has not been loaded.");
		int num = 0;
		int num2 = 0;
		byte[] pixels = image.Pixels;
		for (int i = 0; i < image.PixelHeight; i++)
		{
			for (int j = 0; j < image.PixelWidth / 2; j++)
			{
				num = (i * image.PixelWidth + j) * 4;
				byte b = pixels[num];
				byte b2 = pixels[num + 1];
				byte b3 = pixels[num + 2];
				byte b4 = pixels[num + 3];
				num2 = (i * image.PixelWidth + image.PixelWidth - j - 1) * 4;
				pixels[num] = pixels[num2];
				pixels[num + 1] = pixels[num2 + 1];
				pixels[num + 2] = pixels[num2 + 2];
				pixels[num + 3] = pixels[num2 + 3];
				pixels[num2] = b;
				pixels[num2 + 1] = b2;
				pixels[num2 + 2] = b3;
				pixels[num2 + 3] = b4;
			}
		}
	}

	[ContractVerification(false)]
	internal static void Crop(ImageBase source, ImageBase target, Rectangle bounds)
	{
		Contract.Requires<ArgumentNullException>(source != null, "Source image cannot be null.");
		Contract.Requires<ArgumentException>(source.IsFilled, "Source image has not been loaded.");
		Contract.Requires<ArgumentNullException>(target != null, "Target image cannot be null.");
		Guard.GreaterThan(bounds.Width, 0, "bounds", "Width of the rectangle must be greater than zero.");
		Guard.GreaterThan(bounds.Height, 0, "bounds", "Height of the rectangle must be greater than zero.");
		if (bounds.Right > source.PixelWidth || bounds.Bottom > source.PixelHeight)
		{
			throw new ArgumentException("Rectangle must be in the range of the image's dimension.", "bounds");
		}
		byte[] pixels = source.Pixels;
		byte[] array = new byte[bounds.Width * bounds.Height * 4];
		int num = bounds.Top;
		int num2 = 0;
		while (num < bounds.Bottom)
		{
			Array.Copy(pixels, (num * source.PixelWidth + bounds.Left) * 4, array, num2 * bounds.Width * 4, bounds.Width * 4);
			num++;
			num2++;
		}
		target.SetPixels(bounds.Width, bounds.Height, array);
	}

	public ImageBase(int width, int height)
	{
		Contract.Requires<ArgumentException>(width >= 0, "Width must be greater or equals than zero.");
		Contract.Requires<ArgumentException>(height >= 0, "Height must be greater or equals than zero.");
		Contract.Ensures(IsFilled);
		_pixelWidth = width;
		_pixelHeight = height;
		_pixels = new byte[PixelWidth * PixelHeight * 4];
		_isFilled = true;
	}

	public ImageBase(ImageBase other)
	{
		Contract.Requires<ArgumentNullException>(other != null, "Other image cannot be null.");
		Contract.Requires<ArgumentException>(other.IsFilled, "Other image has not been loaded.");
		Contract.Ensures(IsFilled);
		byte[] pixels = other.Pixels;
		_pixelWidth = other.PixelWidth;
		_pixelHeight = other.PixelHeight;
		_pixels = new byte[pixels.Length];
		Array.Copy(pixels, _pixels, pixels.Length);
		_isFilled = other.IsFilled;
	}

	public ImageBase()
	{
	}

	public void SetPixels(int width, int height, byte[] pixels)
	{
		Contract.Requires<ArgumentException>(width >= 0, "Width must be greater than zero.");
		Contract.Requires<ArgumentException>(height >= 0, "Height must be greater than zero.");
		Contract.Requires<ArgumentNullException>(pixels != null, "Pixels cannot be null.");
		Contract.Ensures(IsFilled);
		if (pixels.Length != width * height * 4)
		{
			throw new ArgumentException("Pixel array must have the length of width * height * 4.", "pixels");
		}
		_pixelWidth = width;
		_pixelHeight = height;
		_pixels = pixels;
		_isFilled = true;
	}
}
