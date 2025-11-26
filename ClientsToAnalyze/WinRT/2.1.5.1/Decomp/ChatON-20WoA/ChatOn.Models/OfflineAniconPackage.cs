using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.IO;
using System.Threading.Tasks;
using ChatON_WoA.DataModel;
using ChatOn.Infrastructure;
using ChatOn.Services;
using SDatabase;
using SharpCompress.Archive;
using Windows.Foundation;
using Windows.Networking.BackgroundTransfer;
using Windows.Storage;
using Windows.Storage.Streams;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Models;

public class OfflineAniconPackage : SDBData
{
	private string _packageID;

	private string _xmlString;

	private string _proxyUrl;

	private ObservableCollection<Anicon> _aniconList = new ObservableCollection<Anicon>();

	private AniconPackage _currentPackage;

	private bool _isLoaded;

	private bool _loadTemplate;

	private BitmapImage _thumbImage;

	private bool _isSelected;

	private string _packageZipUrl;

	private StorageFolder _chek;

	private StorageFolder _createFolder;

	private bool _isDownloadComplete;

	private DownloadOperation _downloadOperation;

	public DownloadOperation DownloadOperation
	{
		get
		{
			return _downloadOperation;
		}
		set
		{
			_downloadOperation = value;
			NotifyPropertyChanged(() => DownloadOperation);
		}
	}

	public bool IsSelected
	{
		get
		{
			return _isSelected;
		}
		set
		{
			if (value != _isSelected)
			{
				_isSelected = value;
				NotifyPropertyChanged(() => IsSelected);
			}
		}
	}

	public BitmapImage ThumbImage
	{
		get
		{
			return _thumbImage;
		}
		set
		{
			_thumbImage = value;
			NotifyPropertyChanged(() => ThumbImage);
		}
	}

	public bool LoadTemplate
	{
		get
		{
			return _loadTemplate;
		}
		set
		{
			_loadTemplate = value;
			NotifyPropertyChanged(() => LoadTemplate);
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
		}
	}

	public AniconPackage CurrentPackage
	{
		get
		{
			return _currentPackage;
		}
		set
		{
			_currentPackage = value;
		}
	}

	public string ProxyUrl
	{
		get
		{
			return _proxyUrl;
		}
		set
		{
			_proxyUrl = value;
		}
	}

	public string PackageZipUrl
	{
		get
		{
			return _packageZipUrl;
		}
		set
		{
			_packageZipUrl = value;
		}
	}

	public ObservableCollection<Anicon> AniconList
	{
		get
		{
			return _aniconList;
		}
		set
		{
			_aniconList = value;
		}
	}

	public bool IsDelegateImagesLoaded { get; set; }

	public int Count { get; set; }

	public long EndDate { get; set; }

	public string ErrorText { get; set; }

	public string ThumbImageUri { get; set; }

	public StorageFile ThumbImageFile { get; set; }

	public bool isCancel { get; set; }

	[SDBColumn]
	public string PackageID
	{
		get
		{
			return _packageID;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _packageID != value)
			{
				SetDataUpdated();
			}
			_packageID = value;
		}
	}

	[SDBColumn(Encrypt = true)]
	public string XmlString
	{
		get
		{
			return _xmlString;
		}
		set
		{
			if (!SDBData.SkipDataUpdatedNoti && _xmlString != value)
			{
				SetDataUpdated();
			}
			_xmlString = value;
		}
	}

	public event EventHandler ProgressChanged;

	public event EventHandler LoadCompleted;

	public OfflineAniconPackage()
	{
		IsDelegateImagesLoaded = false;
	}

	public async Task Load()
	{
		if (_currentPackage != null)
		{
			_currentPackage.DownloadPercent = 0.0;
		}
		BackgroundDownloader downloader = new BackgroundDownloader();
		string filename = "Package_" + PackageID + ".zip";
		StorageFolder folder = await ApplicationData.Current.LocalFolder.CreateFolderAsync("Anicon\\Package_" + PackageID, (CreationCollisionOption)3);
		StorageFile file = await folder.CreateFileAsync(filename, (CreationCollisionOption)1);
		DownloadOperation = downloader.CreateDownload(new Uri(PackageZipUrl), (IStorageFile)(object)file);
		Progress<DownloadOperation> progress = new Progress<DownloadOperation>(async delegate(DownloadOperation downloadOperation)
		{
			double curProgress = (double)downloadOperation.Progress.BytesReceived / (double)downloadOperation.Progress.TotalBytesToReceive;
			_currentPackage.DownloadPercent = curProgress * 30.0;
			if (this.ProgressChanged != null)
			{
				this.ProgressChanged(this, null);
			}
			if (isCancel)
			{
				((IAsyncInfo)downloadOperation.AttachAsync()).Cancel();
				IsLoaded = false;
				if (this.LoadCompleted != null)
				{
					this.LoadCompleted(this, null);
				}
				_isDownloadComplete = true;
			}
			else if (_currentPackage.DownloadPercent >= 30.0)
			{
				if (!isCancel)
				{
					await Task.Delay(1000);
					await Extract(folder, file, _currentPackage);
					if (!isCancel)
					{
						IsLoaded = true;
						if (this.LoadCompleted != null)
						{
							this.LoadCompleted(this, null);
						}
						_isDownloadComplete = true;
						_currentPackage.IsNeedDownload = false;
					}
					else
					{
						DownloadOperation = null;
						IsLoaded = false;
						if (this.LoadCompleted != null)
						{
							this.LoadCompleted(this, null);
						}
						_isDownloadComplete = true;
					}
				}
				else
				{
					DownloadOperation = null;
					IsLoaded = false;
					if (this.LoadCompleted != null)
					{
						this.LoadCompleted(this, null);
					}
					_isDownloadComplete = true;
				}
			}
		});
		if (!isCancel)
		{
			try
			{
				if (_currentPackage.IsNeedDownload)
				{
					_isDownloadComplete = false;
					await DownloadOperation.StartAsync().AsTask<DownloadOperation, DownloadOperation>(progress);
					await Wait();
				}
				return;
			}
			catch
			{
				return;
			}
		}
		DownloadOperation = null;
		_isDownloadComplete = true;
	}

	public async Task Wait()
	{
		while (!_isDownloadComplete)
		{
			await Task.Delay(1000);
		}
	}

	public async Task Extract(StorageFolder folder, StorageFile file, AniconPackage aniconPackage)
	{
		using (Stream stream = await ((IStorageFile)(object)file).OpenStreamForReadAsync())
		{
			IArchive archive = ArchiveFactory.Open(stream);
			int totalEntry = 0;
			foreach (IArchiveEntry entry2 in archive.Entries)
			{
				_ = entry2;
				totalEntry++;
			}
			int entryIdx = 1;
			foreach (IArchiveEntry entry in archive.Entries)
			{
				if (!isCancel)
				{
					if (!entry.IsDirectory)
					{
						await ExtractFile(entry, folder, aniconPackage);
					}
					double curProgress = (double)entryIdx / (double)totalEntry;
					_currentPackage.DownloadPercent = 30.0 + curProgress * 70.0;
					if (this.ProgressChanged != null)
					{
						this.ProgressChanged(this, null);
					}
					entryIdx++;
					continue;
				}
				break;
			}
		}
		if (!isCancel)
		{
			await Task.Delay(1000);
			_currentPackage.IsDownloading = false;
			_currentPackage.IsNeedDownload = false;
			_currentPackage.IsEnableButtonCancel = false;
			aniconPackage.IsNeedDownload = false;
			await file.DeleteAsync((StorageDeleteOption)0);
		}
	}

	private async Task ExtractFile(IArchiveEntry entry, StorageFolder folder, AniconPackage aniconPackage)
	{
		string[] arr = entry.FilePath.Split('/');
		List<string> step = new List<string>(arr);
		step.RemoveAt(step.Count - 1);
		foreach (string item in step)
		{
			try
			{
				_chek = await folder.GetFolderAsync(item);
			}
			catch
			{
				_chek = null;
			}
			if (_chek == null)
			{
				_createFolder = await folder.CreateFolderAsync(item, (CreationCollisionOption)1);
			}
		}
		try
		{
			using Stream fileData = entry.OpenEntryStream();
			new List<string>();
			StorageFile output = ((_chek == null) ? (await _createFolder.CreateFileAsync(entry.FilePath.Split('/')[1], (CreationCollisionOption)1)) : (await _chek.CreateFileAsync(entry.FilePath.Split('/')[1], (CreationCollisionOption)1)));
			using Stream outputStream = await ((IStorageFile)(object)output).OpenStreamForWriteAsync();
			await fileData.CopyToAsync(outputStream);
			await outputStream.FlushAsync();
		}
		catch
		{
		}
	}

	public async Task LoadThumbImageFile()
	{
		if (ThumbImageFile == null)
		{
			ThumbImageFile = await Utility.LoadOrSaveWebImage2("thumb.png", new Uri(ThumbImageUri), "Anicon\\Package_" + _packageID);
		}
	}

	public async void LoadThumbImage()
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (ThumbImageFile != null)
			{
				IRandomAccessStream fs = await ThumbImageFile.OpenAsync((FileAccessMode)0);
				if (fs != null)
				{
					BitmapImage val = new BitmapImage();
					((BitmapSource)val).SetSource(fs);
					ThumbImage = val;
				}
			}
		}
		catch (Exception)
		{
		}
	}

	public void NotifyLoaded()
	{
		NotifyPropertyChanged(() => IsLoaded);
	}

	public async Task<StorageFile> DownloadAnicon(Anicon anicon)
	{
		StorageFile _delegateImageFile = null;
		_ = anicon.DelegateImageName;
		int imgIndex = 0;
		int delegateIndex = 0;
		foreach (string imgUri in anicon.ImageUrlList)
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
			StorageFile file = ((await Utility.IsFileExistCheck("Anicon\\Package_" + _packageID + "\\" + anicon.ID, filename) != null) ? (await Utility.IsFileExist("Anicon\\Package_" + _packageID + "\\" + anicon.ID, filename)) : (await _background.AddDownload(new Uri(imgUri), filename, "Anicon\\Package_" + _packageID + "\\" + anicon.ID)));
			if (imgIndex == delegateIndex)
			{
				_delegateImageFile = file;
			}
			imgIndex++;
		}
		return _delegateImageFile;
	}

	public async void LoadDelegateImages()
	{
		if (isCancel)
		{
			return;
		}
		foreach (Anicon a in _aniconList)
		{
			if (isCancel)
			{
				return;
			}
			if (a.DelegateImageFile == null)
			{
				DownloadAniconCorrupt(a);
				continue;
			}
			try
			{
				IRandomAccessStream fs = await Utility.ResizeImage(a.DelegateImageFile, 80u, 80u);
				if (fs == null)
				{
					return;
				}
				a.DelegateImage = new BitmapImage();
				((BitmapSource)a.DelegateImage).SetSource(fs);
			}
			catch (Exception)
			{
				DownloadAniconCorrupt(a);
			}
		}
		IsDelegateImagesLoaded = true;
	}

	private async void DownloadAniconCorrupt(Anicon item)
	{
		await item.Load(PackageID);
		try
		{
			IRandomAccessStream fs = await Utility.ResizeImage(item.DelegateImageFile, 80u, 80u);
			if (fs != null)
			{
				item.DelegateImage = new BitmapImage();
				((BitmapSource)item.DelegateImage).SetSource(fs);
			}
		}
		catch (Exception)
		{
			DownloadAniconCorrupt(item);
		}
	}

	public async Task Delete()
	{
		try
		{
			string path = "Anicon\\Package_" + _packageID;
			try
			{
				foreach (Anicon anicon in _aniconList)
				{
					foreach (StorageFile file in anicon.ImageFileList)
					{
						await file.DeleteAsync((StorageDeleteOption)1);
					}
					await ThumbImageFile.DeleteAsync((StorageDeleteOption)1);
				}
			}
			catch
			{
			}
			await Utility.DeleteFolder(path);
		}
		catch
		{
		}
	}

	public void LoadCancel()
	{
		isCancel = true;
	}

	public void LoadEnable()
	{
		isCancel = false;
	}
}
