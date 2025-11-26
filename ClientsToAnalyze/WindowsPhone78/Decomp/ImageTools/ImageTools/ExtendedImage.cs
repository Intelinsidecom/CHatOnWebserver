using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Diagnostics.CodeAnalysis;
using System.Diagnostics.Contracts;
using System.IO;
using System.Linq;
using System.Net;
using System.Threading;
using ImageTools.Helpers;
using ImageTools.IO;

namespace ImageTools;

[ContractVerification(false)]
[DebuggerDisplay("Image: {PixelWidth}x{PixelHeight}")]
public sealed class ExtendedImage : ImageBase
{
	public const double DefaultDensityX = 75.0;

	public const double DefaultDensityY = 75.0;

	private ImageFrameCollection _frames = new ImageFrameCollection();

	private ImagePropertyCollection _properties = new ImagePropertyCollection();

	private Uri _uriSource;

	public bool IsLoading { get; private set; }

	public double DensityX { get; set; }

	public double DensityY { get; set; }

	public double InchWidth
	{
		get
		{
			double num = DensityX;
			if (num <= 0.0)
			{
				num = 75.0;
			}
			return (double)base.PixelWidth / num;
		}
	}

	public double InchHeight
	{
		get
		{
			double num = DensityY;
			if (num <= 0.0)
			{
				num = 75.0;
			}
			return (double)base.PixelHeight / num;
		}
	}

	public bool IsAnimated => _frames.Count > 0;

	public ImageFrameCollection Frames
	{
		get
		{
			Contract.Ensures(Contract.Result<ImageFrameCollection>() != null);
			return _frames;
		}
	}

	public ImagePropertyCollection Properties
	{
		get
		{
			Contract.Ensures(Contract.Result<ImagePropertyCollection>() != null);
			return _properties;
		}
	}

	public Uri UriSource
	{
		get
		{
			return _uriSource;
		}
		set
		{
			_uriSource = value;
			if (UriSource != null)
			{
				LoadAsync(UriSource);
			}
		}
	}

	public event OpenReadCompletedEventHandler DownloadCompleted;

	public event DownloadProgressChangedEventHandler DownloadProgress;

	public event EventHandler LoadingCompleted;

	public event EventHandler<UnhandledExceptionEventArgs> LoadingFailed;

	public static ExtendedImage Apply(ExtendedImage source, params IImageFilter[] filters)
	{
		Contract.Requires<ArgumentNullException>(source != null, "Source image cannot be null.");
		Contract.Requires<ArgumentException>(source.IsFilled, "Source image has not been loaded.");
		Contract.Requires<ArgumentNullException>(filters != null, "Filters cannot be null.");
		return PerformAction(source, clone: true, delegate(ImageBase sourceImage, ImageBase targetImage)
		{
			IImageFilter[] array = filters;
			foreach (IImageFilter imageFilter in array)
			{
				imageFilter.Apply(targetImage, sourceImage, targetImage.Bounds);
			}
		});
	}

	public static ExtendedImage Apply(ExtendedImage source, Rectangle rectangle, params IImageFilter[] filters)
	{
		Contract.Requires<ArgumentNullException>(source != null, "Source image cannot be null.");
		Contract.Requires<ArgumentException>(source.IsFilled, "Source image has not been loaded.");
		Contract.Requires<ArgumentNullException>(filters != null, "Filters cannot be null.");
		return PerformAction(source, clone: true, delegate(ImageBase sourceImage, ImageBase targetImage)
		{
			IImageFilter[] array = filters;
			foreach (IImageFilter imageFilter in array)
			{
				imageFilter.Apply(targetImage, sourceImage, rectangle);
			}
		});
	}

	[SuppressMessage("Microsoft.Design", "CA1011:ConsiderPassingBaseTypesAsParameters")]
	public static ExtendedImage Crop(ExtendedImage source, Rectangle bounds)
	{
		Contract.Requires<ArgumentNullException>(source != null, "Source image cannot be null.");
		Contract.Requires<ArgumentException>(source.IsFilled, "Source image has not been loaded.");
		return PerformAction(source, clone: false, delegate(ImageBase sourceImage, ImageBase targetImage)
		{
			ImageBase.Crop(sourceImage, targetImage, bounds);
		});
	}

	[SuppressMessage("Microsoft.Design", "CA1011:ConsiderPassingBaseTypesAsParameters")]
	public static ExtendedImage Transform(ExtendedImage source, RotationType rotationType, FlippingType flippingType)
	{
		Contract.Requires<ArgumentNullException>(source != null, "Source image cannot be null.");
		Contract.Requires<ArgumentException>(source.IsFilled, "Source image has not been loaded.");
		return PerformAction(source, clone: false, delegate(ImageBase sourceImage, ImageBase targetImage)
		{
			ImageBase.Transform(sourceImage, targetImage, rotationType, flippingType);
		});
	}

	[SuppressMessage("Microsoft.Design", "CA1011:ConsiderPassingBaseTypesAsParameters")]
	public static ExtendedImage Resize(ExtendedImage source, int width, int height, IImageResizer resizer)
	{
		Contract.Requires<ArgumentNullException>(source != null, "Source image cannot be null.");
		Contract.Requires<ArgumentException>(source.IsFilled, "Source image has not been loaded.");
		Contract.Requires<ArgumentNullException>(resizer != null, "Image Resizer cannot be null.");
		return PerformAction(source, clone: false, delegate(ImageBase sourceImage, ImageBase targetImage)
		{
			resizer.Resize(sourceImage, targetImage, width, height);
		});
	}

	[SuppressMessage("Microsoft.Design", "CA1011:ConsiderPassingBaseTypesAsParameters")]
	public static ExtendedImage Resize(ExtendedImage source, int size, IImageResizer resizer)
	{
		Contract.Requires<ArgumentNullException>(source != null, "Source image cannot be null.");
		Contract.Requires<ArgumentException>(source.IsFilled, "Source image has not been loaded.");
		Contract.Requires<ArgumentNullException>(resizer != null, "Image Resizer cannot be null.");
		int width = 0;
		int height = 0;
		float num = (float)source.PixelWidth / (float)source.PixelHeight;
		if (source.PixelWidth > source.PixelHeight && num > 0f)
		{
			width = size;
			height = (int)((float)width / num);
		}
		else
		{
			height = size;
			width = (int)((float)height * num);
		}
		return PerformAction(source, clone: false, delegate(ImageBase sourceImage, ImageBase targetImage)
		{
			resizer.Resize(sourceImage, targetImage, width, height);
		});
	}

	[ContractVerification(false)]
	private static ExtendedImage PerformAction(ExtendedImage source, bool clone, Action<ImageBase, ImageBase> action)
	{
		VerifyHasLoaded(source);
		ExtendedImage extendedImage = (clone ? new ExtendedImage(source) : new ExtendedImage());
		action(source, extendedImage);
		foreach (ImageFrame frame in source.Frames)
		{
			ImageFrame imageFrame = new ImageFrame();
			action(frame, imageFrame);
			if (!clone)
			{
				extendedImage.Frames.Add(imageFrame);
			}
		}
		return extendedImage;
	}

	private static void VerifyHasLoaded(ExtendedImage image)
	{
		Contract.Requires(image != null);
		if (!image.IsFilled)
		{
			throw new InvalidOperationException("Image has not been loaded");
		}
		foreach (ImageFrame frame in image.Frames)
		{
			if (frame != null && frame.IsFilled)
			{
				throw new InvalidOperationException("Not all frames has been loaded yet.");
			}
		}
	}

	private void OnDownloadCompleted(OpenReadCompletedEventArgs e)
	{
		this.DownloadCompleted?.Invoke(this, e);
	}

	private void OnDownloadProgress(DownloadProgressChangedEventArgs e)
	{
		this.DownloadProgress?.Invoke(this, e);
	}

	private void OnLoadingCompleted(EventArgs e)
	{
		this.LoadingCompleted?.Invoke(this, e);
	}

	private void OnLoadingFailed(UnhandledExceptionEventArgs e)
	{
		this.LoadingFailed?.Invoke(this, e);
	}

	public ExtendedImage(int width, int height)
		: base(width, height)
	{
		Contract.Requires<ArgumentException>(width >= 0, "Width must be greater or equals than zero.");
		Contract.Requires<ArgumentException>(height >= 0, "Height must be greater or equals than zero.");
		Contract.Ensures(base.IsFilled);
		DensityX = 75.0;
		DensityY = 75.0;
	}

	public ExtendedImage(ExtendedImage other)
		: base(other)
	{
		Contract.Requires<ArgumentNullException>(other != null, "Other image cannot be null.");
		Contract.Requires<ArgumentException>(other.IsFilled, "Other image has not been loaded.");
		Contract.Ensures(base.IsFilled);
		foreach (ImageFrame frame in other.Frames)
		{
			if (frame != null)
			{
				if (!frame.IsFilled)
				{
					throw new ArgumentException("The image contains a frame that has not been loaded yet.");
				}
				Frames.Add(new ImageFrame(frame));
			}
		}
		DensityX = 75.0;
		DensityY = 75.0;
	}

	public ExtendedImage()
	{
		DensityX = 75.0;
		DensityY = 75.0;
	}

	public void SetSource(Stream stream)
	{
		Contract.Requires<ArgumentNullException>(stream != null, "Stream cannot be null.");
		if (_uriSource == null)
		{
			LoadAsync(stream);
		}
	}

	private void Load(Stream stream)
	{
		Contract.Requires(stream != null);
		if (!stream.CanRead)
		{
			throw new InvalidOperationException("Cannot read from the stream.");
		}
		if (!stream.CanSeek)
		{
			throw new InvalidOperationException("The stream does not support seeking.");
		}
		IEnumerable<IImageDecoder> availableDecoders = Decoders.GetAvailableDecoders();
		int num = availableDecoders.Max((IImageDecoder x) => x.HeaderSize);
		if (num > 0)
		{
			byte[] header = new byte[num];
			stream.Read(header, 0, num);
			stream.Position = 0L;
			IImageDecoder imageDecoder = availableDecoders.FirstOrDefault((IImageDecoder x) => x.IsSupportedFileFormat(header));
			if (imageDecoder != null)
			{
				imageDecoder.Decode(this, stream);
				IsLoading = false;
			}
		}
		if (IsLoading)
		{
			IsLoading = false;
			throw new UnsupportedImageFormatException();
		}
	}

	private void LoadAsync(Stream stream)
	{
		Contract.Requires(stream != null);
		Contract.Requires<InvalidOperationException>(stream.CanSeek);
		IsLoading = true;
		ThreadPool.QueueUserWorkItem(delegate
		{
			try
			{
				Load(stream);
				OnLoadingCompleted(EventArgs.Empty);
			}
			catch (Exception exception)
			{
				OnLoadingFailed(new UnhandledExceptionEventArgs(exception, isTerminating: false));
			}
		});
	}

	private void LoadAsync(Uri uri)
	{
		Contract.Requires(uri != null);
		try
		{
			bool flag = false;
			if (!uri.IsAbsoluteUri)
			{
				Stream localResourceStream = Extensions.GetLocalResourceStream(uri);
				if (localResourceStream != null)
				{
					LoadAsync(localResourceStream);
					flag = true;
				}
			}
			if (!flag)
			{
				IsLoading = true;
				WebClient webClient = new WebClient();
				webClient.DownloadProgressChanged += webClient_DownloadProgressChanged;
				webClient.OpenReadCompleted += webClient_OpenReadCompleted;
				webClient.OpenReadAsync(uri);
			}
		}
		catch (ArgumentException exception)
		{
			OnLoadingFailed(new UnhandledExceptionEventArgs(exception, isTerminating: false));
		}
	}

	private void webClient_OpenReadCompleted(object sender, OpenReadCompletedEventArgs e)
	{
		Stream result = e.Result;
		if (e.Error == null && result != null)
		{
			LoadAsync(result);
		}
		else
		{
			OnLoadingFailed(new UnhandledExceptionEventArgs(e.Error, isTerminating: false));
		}
		OnDownloadCompleted(e);
	}

	private void webClient_DownloadProgressChanged(object sender, DownloadProgressChangedEventArgs e)
	{
		OnDownloadProgress(e);
	}

	public ExtendedImage Clone()
	{
		Contract.Requires(base.IsFilled);
		Contract.Ensures(Contract.Result<ExtendedImage>() != null);
		return new ExtendedImage(this);
	}
}
