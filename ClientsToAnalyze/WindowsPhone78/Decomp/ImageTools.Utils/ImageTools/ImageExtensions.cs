using System;
using System.Diagnostics.Contracts;
using System.IO;
using System.Security;
using System.Windows;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using ImageTools.IO;
using ImageTools.IO.Png;

namespace ImageTools;

[ContractVerification(false)]
public static class ImageExtensions
{
	static ImageExtensions()
	{
		Encoders.AddEncoder<PngEncoder>();
	}

	public static Stream ToStream(this ExtendedImage image)
	{
		Contract.Requires<ArgumentNullException>(image != null, "Image cannot be null.");
		Contract.Requires<ArgumentException>(image.IsFilled, "Image has not been loaded.");
		return image.ToStream(null);
	}

	public static Stream ToStream(this ExtendedImage image, IImageFilter filter)
	{
		Contract.Requires<ArgumentNullException>(image != null, "Image cannot be null.");
		Contract.Requires<ArgumentException>(image.IsFilled, "Image has not been loaded.");
		MemoryStream memoryStream = new MemoryStream();
		try
		{
			ExtendedImage extendedImage = image;
			if (filter != null)
			{
				extendedImage = image.Clone();
				filter.Apply(extendedImage, image, extendedImage.Bounds);
			}
			PngEncoder pngEncoder = new PngEncoder();
			pngEncoder.IsWritingUncompressed = true;
			pngEncoder.Encode(extendedImage, memoryStream);
			memoryStream.Seek(0L, SeekOrigin.Begin);
		}
		catch
		{
			if (memoryStream != null)
			{
				memoryStream.Dispose();
				memoryStream = null;
			}
			throw;
		}
		return memoryStream;
	}

	public static Stream ToStreamByExtension(this ExtendedImage image, string extension)
	{
		Contract.Requires<ArgumentNullException>(image != null, "Image cannot be null.");
		Contract.Requires<ArgumentException>(image.IsFilled, "Image has not been loaded.");
		Contract.Requires<ArgumentException>(!string.IsNullOrEmpty(extension), "Extension cannot be null or empty.");
		IImageEncoder imageEncoder = null;
		foreach (IImageEncoder availableEncoder in Encoders.GetAvailableEncoders())
		{
			if (availableEncoder != null && availableEncoder.IsSupportedFileExtension(extension))
			{
				imageEncoder = availableEncoder;
				break;
			}
		}
		if (imageEncoder == null)
		{
			imageEncoder = new PngEncoder();
		}
		MemoryStream memoryStream = null;
		try
		{
			memoryStream = new MemoryStream();
			imageEncoder.Encode(image, memoryStream);
			memoryStream.Seek(0L, SeekOrigin.Begin);
		}
		catch
		{
			memoryStream?.Dispose();
			throw;
		}
		return memoryStream;
	}

	public static WriteableBitmap ToBitmap(this ImageBase image)
	{
		Contract.Requires<ArgumentNullException>(image != null, "Image cannot be null.");
		Contract.Requires<ArgumentException>(image.IsFilled, "Image has not been loaded.");
		return image.ToBitmap(null);
	}

	public static WriteableBitmap ToBitmap(this ImageBase image, IImageFilter filter)
	{
		Contract.Requires<ArgumentNullException>(image != null, "Image cannot be null.");
		Contract.Requires<ArgumentException>(image.IsFilled, "Image has not been loaded.");
		WriteableBitmap writeableBitmap = new WriteableBitmap(image.PixelWidth, image.PixelHeight);
		ImageBase imageBase = image;
		if (filter != null)
		{
			imageBase = new ImageBase(image);
			filter.Apply(imageBase, image, imageBase.Bounds);
		}
		byte[] pixels = imageBase.Pixels;
		if (pixels != null)
		{
			int[] pixels2 = writeableBitmap.Pixels;
			if (pixels2 != null)
			{
				Buffer.BlockCopy(pixels, 0, pixels2, 0, pixels.Length);
				for (int i = 0; i < pixels2.Length; i++)
				{
					int num = pixels2[i];
					int num2 = (num >> 24) & 0xFF;
					float num3 = (float)num2 / 255f;
					int num4 = (num2 << 24) | ((int)((float)(num & 0xFF) * num3) << 16) | ((int)((float)((num >> 8) & 0xFF) * num3) << 8) | (int)((float)((num >> 16) & 0xFF) * num3);
					pixels2[i] = num4;
				}
			}
		}
		writeableBitmap.Invalidate();
		return writeableBitmap;
	}

	public static ExtendedImage ToImage(this UIElement element)
	{
		Contract.Requires<ArgumentNullException>(element != null, "UI element cannot be null.");
		WriteableBitmap bitmap = new WriteableBitmap(element, new TranslateTransform());
		return bitmap.ToImage();
	}

	public static ExtendedImage ToImage(this WriteableBitmap bitmap)
	{
		Contract.Requires<ArgumentNullException>(bitmap != null, "Bitmap cannot be null.");
		bitmap.Invalidate();
		Contract.Assume(bitmap.PixelWidth >= 0);
		Contract.Assume(bitmap.PixelHeight >= 0);
		ExtendedImage extendedImage = new ExtendedImage(bitmap.PixelWidth, bitmap.PixelHeight);
		try
		{
			byte[] pixels = extendedImage.Pixels;
			int[] pixels2 = bitmap.Pixels;
			if (pixels2 != null)
			{
				for (int i = 0; i < extendedImage.PixelHeight; i++)
				{
					for (int j = 0; j < extendedImage.PixelWidth; j++)
					{
						int num = bitmap.PixelWidth * i + j;
						int num2 = pixels2[num];
						byte b = (byte)((num2 >> 24) & 0xFF);
						float num3 = (float)(int)b / 255f;
						if (num3 > 0f)
						{
							byte b2 = (byte)((float)((num2 >> 16) & 0xFF) / num3);
							byte b3 = (byte)((float)((num2 >> 8) & 0xFF) / num3);
							byte b4 = (byte)((float)(num2 & 0xFF) / num3);
							pixels[num * 4] = b2;
							pixels[num * 4 + 1] = b3;
							pixels[num * 4 + 2] = b4;
							pixels[num * 4 + 3] = b;
						}
					}
				}
			}
		}
		catch (SecurityException innerException)
		{
			throw new ArgumentException("Bitmap cannot accessed", innerException);
		}
		return extendedImage;
	}

	public static void WriteToStream(this ExtendedImage image, Stream stream, string fileName)
	{
		Contract.Requires<ArgumentNullException>(image != null, "Image cannot be null.");
		Contract.Requires<ArgumentException>(image.IsFilled, "Image has not been loaded.");
		Contract.Requires<ArgumentNullException>(stream != null, "Stream cannot be null.");
		Contract.Requires<ArgumentException>(!string.IsNullOrEmpty(fileName), "File name cannot be null or empty.");
		string extension = Path.GetExtension(fileName);
		if (extension == null || string.IsNullOrEmpty(extension))
		{
			throw new ArgumentException("The file name is not valid and contains no extension.");
		}
		string text = extension.Substring(1);
		Contract.Assume(!string.IsNullOrEmpty(text));
		IImageEncoder imageEncoder = null;
		foreach (IImageEncoder availableEncoder in Encoders.GetAvailableEncoders())
		{
			if (availableEncoder != null && availableEncoder.IsSupportedFileExtension(text))
			{
				imageEncoder = availableEncoder;
				break;
			}
		}
		if (imageEncoder == null)
		{
			throw new UnsupportedImageFormatException("Specified file extension is not supported.");
		}
		imageEncoder.Encode(image, stream);
		stream.Close();
	}
}
