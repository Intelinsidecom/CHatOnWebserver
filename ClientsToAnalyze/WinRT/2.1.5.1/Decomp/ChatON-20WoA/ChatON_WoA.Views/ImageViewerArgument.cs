using System;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatON_WoA.Views;

public class ImageViewerArgument
{
	private Uri _uri;

	private string _filePath;

	private BitmapImage _image;

	private bool _canSave;

	public bool CanSave
	{
		get
		{
			return _canSave;
		}
		set
		{
			_canSave = value;
		}
	}

	public string FilePath
	{
		get
		{
			return _filePath;
		}
		set
		{
			_filePath = value;
		}
	}

	public Uri Uri
	{
		get
		{
			return _uri;
		}
		set
		{
			_uri = value;
		}
	}

	public BitmapImage Image
	{
		get
		{
			return _image;
		}
		set
		{
			_image = value;
		}
	}
}
