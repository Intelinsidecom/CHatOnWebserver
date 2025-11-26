using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.Storage;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class Anicon : NotificationObject
{
	private string _id;

	private BitmapImage _delegateImage;

	private StorageFile _delegateImageFile;

	private List<string> _imageUrlList = new List<string>();

	private List<StorageFile> _imageFileList = new List<StorageFile>();

	private List<BitmapImage> _imageList = new List<BitmapImage>();

	private string _delegateImageName;

	private string _msgUrl;

	private bool _isLoaded;

	private bool _isLoading;

	public Visibility IsShowLoading { get; set; }

	public bool IsLoading
	{
		get
		{
			return _isLoading;
		}
		set
		{
			_isLoading = value;
		}
	}

	public bool IsLoaded
	{
		get
		{
			return _isLoaded;
		}
		set
		{
			_isLoaded = value;
			NotifyPropertyChanged(() => IsLoaded);
		}
	}

	public string MsgUrl
	{
		get
		{
			return _msgUrl;
		}
		set
		{
			_msgUrl = value;
		}
	}

	public string ID
	{
		get
		{
			return _id;
		}
		set
		{
			_id = value;
		}
	}

	public StorageFile DelegateImageFile
	{
		get
		{
			return _delegateImageFile;
		}
		set
		{
			_delegateImageFile = value;
		}
	}

	public BitmapImage DelegateImage
	{
		get
		{
			return _delegateImage;
		}
		set
		{
			_delegateImage = value;
			if (value != null)
			{
				IsShowLoading = (Visibility)1;
			}
			else
			{
				IsShowLoading = (Visibility)0;
			}
			NotifyPropertyChanged(() => IsShowLoading);
			NotifyPropertyChanged(() => DelegateImage);
		}
	}

	public List<string> ImageUrlList
	{
		get
		{
			return _imageUrlList;
		}
		set
		{
			_imageUrlList = value;
		}
	}

	public List<StorageFile> ImageFileList
	{
		get
		{
			return _imageFileList;
		}
		set
		{
			_imageFileList = value;
		}
	}

	public List<BitmapImage> ImageList
	{
		get
		{
			return _imageList;
		}
		set
		{
			_imageList = value;
		}
	}

	public string DelegateImageName
	{
		get
		{
			return _delegateImageName;
		}
		set
		{
			_delegateImageName = value;
		}
	}

	public event EventHandler LoadCompleted;

	public async Task Load(string packageID)
	{
		Stopwatch watch = new Stopwatch();
		watch.Start();
		_isLoaded = false;
		_isLoading = true;
		try
		{
			int imgIndex = 0;
			int delegateIndex = 0;
			foreach (string imgUri in ImageUrlList)
			{
				string[] p = Utility.Split(imgUri, '?');
				p = Utility.Split(p[0], '/');
				string filename = p[p.Length - 1];
				if (imgIndex == 0)
				{
					p = Utility.Split(filename, '.');
					string input = p[0];
					p = Utility.Split(input, '_');
					delegateIndex = int.Parse(p[p.Length - 1]);
				}
				BackgroundFileTransferService _background = new BackgroundFileTransferService();
				StorageFile file = await Utility.IsFileExist("Anicon\\Package_" + packageID + "\\" + ID, filename);
				if (file == null && Utility.CheckForInternetConnection())
				{
					file = await _background.AddDownload(new Uri(imgUri), filename, "Anicon\\Package_" + packageID + "\\" + ID);
				}
				if (file != null && (await file.GetBasicPropertiesAsync()).Size == 0 && Utility.CheckForInternetConnection())
				{
					file = await _background.AddDownload(new Uri(imgUri), filename, "Anicon\\Package_" + packageID + "\\" + ID);
				}
				if (file != null && (await file.GetBasicPropertiesAsync()).Size != 0)
				{
					ImageFileList.Add(file);
				}
				if (imgIndex == delegateIndex)
				{
					_delegateImageFile = file;
				}
				imgIndex++;
			}
		}
		catch
		{
		}
		finally
		{
		}
		_isLoaded = true;
		_isLoading = false;
		if (this.LoadCompleted != null)
		{
			this.LoadCompleted(this, null);
		}
	}

	public void NotifyDelegateImageChanged()
	{
		NotifyPropertyChanged(() => DelegateImageFile);
	}

	public async void Delete(string packageID)
	{
		string path = "Anicon\\Package_" + packageID + "\\" + ID;
		await Utility.DeleteFolder(path);
	}
}
