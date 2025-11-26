using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading;
using ChatON_WoA.ViewModels;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using com.sec.ssm.common;
using Windows.ApplicationModel.DataTransfer;
using Windows.Foundation;
using Windows.Networking.BackgroundTransfer;
using Windows.Storage;
using Windows.Storage.FileProperties;
using Windows.Storage.Pickers;
using Windows.Storage.Streams;
using Windows.System;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class TrunkItemPageViewModel : NotificationObject
{
	private static readonly int InitialLoadCommentCount = 4;

	private TrunkDetailPage _page;

	private ObservableCollection<TrunkComment> _trunkComments;

	private List<TrunkComment> _trunkCommentsAll;

	private List<TrunkComment> _trunkCommentsView;

	private int _iViewTrunk;

	private int _iViewTrunkNow;

	private int _iTrunk;

	private SSMService _ssmService;

	private Chat _chat;

	private TrunkService _trunkService;

	private string CommentId_delete;

	private TrunkComment _tempItem;

	private DataService _dataService;

	private TrunkItem _selectItem;

	private BitmapImage _itemImg;

	private int _commentCnt;

	private int _TempCommentCount;

	private string _uploaderName;

	private DateTime _uploadTime;

	private Visibility _videoVisible;

	private Visibility _playVisible;

	private Visibility _PreviousBtnVisible;

	private Visibility _deleteVisibility;

	private Visibility _commentVisibility;

	private Visibility _gridVisibility;

	private Visibility _uploadTimeVisibility;

	private DataTransferManager _dataTransferManager;

	private StorageFile _imageFileToShare;

	private Message _tempMsg;

	private bool _isDownloading;

	private bool _isCommentReset;

	private bool _isFirstLoadCommentList = true;

	private bool _isUpdateNewCommentList;

	private int _loadCommentCnt;

	private Uri _videoItemSource;

	private string _comment;

	private static TrunkItem TrunkItemTemp;

	private int _index;

	private bool _isMenuNextandPrev;

	public bool IsUpdateNewCommentList
	{
		get
		{
			return _isUpdateNewCommentList;
		}
		set
		{
			_isUpdateNewCommentList = value;
			NotifyPropertyChanged(() => _isUpdateNewCommentList);
		}
	}

	public Uri VideoItemSource
	{
		get
		{
			return _videoItemSource;
		}
		set
		{
			_videoItemSource = value;
			NotifyPropertyChanged(() => VideoItemSource);
		}
	}

	public Visibility DeleteVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _deleteVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_deleteVisibility = value;
			NotifyPropertyChanged(() => DeleteVisibility);
		}
	}

	public Visibility PrevioseBtn_Visible
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _PreviousBtnVisible;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_PreviousBtnVisible = value;
			NotifyPropertyChanged(() => PrevioseBtn_Visible);
		}
	}

	public Visibility Play_Visible
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _playVisible;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_playVisible = value;
			NotifyPropertyChanged(() => Play_Visible);
		}
	}

	public Visibility Video_Visible
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _videoVisible;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_videoVisible = value;
			NotifyPropertyChanged(() => Video_Visible);
		}
	}

	public Visibility Comment_Visible
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _commentVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_commentVisibility = value;
			NotifyPropertyChanged(() => Comment_Visible);
		}
	}

	public Visibility Grid_Visible
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _gridVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_gridVisibility = value;
			NotifyPropertyChanged(() => Grid_Visible);
		}
	}

	public Visibility UploadTime_Visible
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _uploadTimeVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_uploadTimeVisibility = value;
			NotifyPropertyChanged(() => UploadTime_Visible);
		}
	}

	public int CommentCnt
	{
		get
		{
			return _commentCnt;
		}
		set
		{
			if (value < 0)
			{
				_commentCnt = 0;
			}
			else
			{
				_commentCnt = value;
			}
			NotifyPropertyChanged(() => CommentCnt);
		}
	}

	public string UploaderName
	{
		get
		{
			return _uploaderName;
		}
		set
		{
			_uploaderName = value;
			NotifyPropertyChanged(() => UploaderName);
		}
	}

	public DateTime UploadTime
	{
		get
		{
			return _uploadTime;
		}
		set
		{
			_uploadTime = value;
			NotifyPropertyChanged(() => UploadTime);
		}
	}

	public BitmapImage ItemImg
	{
		get
		{
			return _itemImg;
		}
		set
		{
			_itemImg = value;
			NotifyPropertyChanged(() => ItemImg);
		}
	}

	public Chat Chat
	{
		get
		{
			return _chat;
		}
		set
		{
			_chat = value;
			NotifyPropertyChanged(() => Chat);
		}
	}

	public ObservableCollection<TrunkComment> TrunkComments
	{
		get
		{
			return _trunkComments;
		}
		set
		{
			_trunkComments = value;
			NotifyPropertyChanged(() => TrunkComments);
		}
	}

	public List<TrunkComment> TrunkCommentsView
	{
		get
		{
			return _trunkCommentsView;
		}
		set
		{
			_trunkCommentsView = value;
			NotifyPropertyChanged(() => TrunkCommentsView);
		}
	}

	public List<TrunkComment> TrunkCommentsAll
	{
		get
		{
			return _trunkCommentsAll;
		}
		set
		{
			_trunkCommentsAll = value;
			NotifyPropertyChanged(() => TrunkCommentsAll);
		}
	}

	public TrunkItem TrunkItem
	{
		get
		{
			return _selectItem;
		}
		set
		{
			_selectItem = value;
			NotifyPropertyChanged(() => TrunkItem);
		}
	}

	public bool isMenuNextandPrev
	{
		get
		{
			return _isMenuNextandPrev;
		}
		set
		{
			_isMenuNextandPrev = value;
			NotifyPropertyChanged(() => isMenuNextandPrev);
		}
	}

	public TrunkItemPageViewModel(TrunkDetailPage page)
	{
		_page = page;
		TrunkComments = new ObservableCollection<TrunkComment>();
		TrunkCommentsAll = new List<TrunkComment>();
		TrunkCommentsView = new List<TrunkComment>();
		_tempItem = new TrunkComment();
		_dataService = new DataService();
		_trunkService = new TrunkService(_dataService);
		_ssmService = new SSMService();
		_ssmService.GetTrunkItemCompleted += _ssmService_GetTrunkItemCompleted;
		_ssmService.GetTrunkCommentListCompleted += _ssmService_GetTrunkCommentListCompleted;
		_ssmService.DeleteTrunkItemCompleted += _ssmService_DeleteTrunkItemCompleted;
		_ssmService.MarkAsReadTrunkItemCompleted += _ssmService_MarkAsReadTrunkItemCompleted;
		_ssmService.PostTrunkCommentComplet += _ssmService_PostTrunkCommentComplet;
		_ssmService.DeleteTrunkCommentCompleted += _ssmService_DeleteTrunkCommentCompleted;
		_selectItem = new TrunkItem();
		Video_Visible = (Visibility)1;
		Play_Visible = (Visibility)1;
		PrevioseBtn_Visible = (Visibility)1;
		UploadTime_Visible = (Visibility)1;
	}

	public void NextTrunkItem()
	{
		if (_index < ChatOnService.Instance.TrunkItems.Count() - 1 && _isMenuNextandPrev)
		{
			_index++;
			TrunkItem item = ChatOnService.Instance.TrunkItems[_index];
			OpenTrunkDetail(item);
		}
	}

	public void PrevTrunkItem()
	{
		if (_index > 0 && _isMenuNextandPrev)
		{
			_index--;
			TrunkItem item = ChatOnService.Instance.TrunkItems[_index];
			OpenTrunkDetail(item);
		}
	}

	public void OpenLastTrunkDetail(Chat chat, TrunkItem trunkItem = null)
	{
		_chat = chat;
		if (TrunkItemTemp != null)
		{
			OpenTrunkDetail(TrunkItemTemp);
		}
		else
		{
			OpenTrunkDetail(trunkItem);
		}
	}

	private async void OpenTrunkDetail(TrunkItem item)
	{
		try
		{
			TrunkItemTemp = item;
			Grid_Visible = (Visibility)1;
			_selectItem = item;
			_isDownloading = true;
			CancellationTokenSource cts = new CancellationTokenSource();
			if (!_selectItem.Senderid.Contains("ME"))
			{
				DeleteVisibility = (Visibility)1;
			}
			TrunkCommentsView = await _trunkService.CacheCommentLoad(_selectItem.TrunkItemID);
			if (_selectItem.Senderid.Contains("ME"))
			{
				UploaderName = Utility.GetResourceString("IDS_CHATON_BODY_ME");
			}
			else
			{
				UploaderName = _selectItem.Name;
			}
			if (Chat.ChatType != ChatType.BROADCAST)
			{
				UploadTime = Utility.GetDateTimeFromMiliseconds(long.Parse(_selectItem.Regdttm));
				UploadTime_Visible = (Visibility)0;
			}
			IReadOnlyList<DownloadOperation> downloads = await BackgroundDownloader.GetCurrentDownloadsAsync();
			Progress<DownloadOperation> progressCallback = new Progress<DownloadOperation>(DownloadProgress);
			StorageFolder localFolder = ApplicationData.Current.LocalFolder;
			StorageFolder folder = null;
			StorageFile file = null;
			bool isResumed = false;
			foreach (DownloadOperation download in downloads)
			{
				if (download.RequestedUri.ToString() == _selectItem.TrunkDownUri)
				{
					isResumed = true;
					_page.ShowLoading();
					await download.AttachAsync().AsTask<DownloadOperation, DownloadOperation>(cts.Token, progressCallback);
					LoadingIndicator.StopLoading();
					IStorageFile resultFile = download.ResultFile;
					file = (StorageFile)(object)((resultFile is StorageFile) ? resultFile : null);
					break;
				}
			}
			if (!isResumed)
			{
				folder = await Utility.IsFolderExist(Chat.ChatID.ToString());
				if (folder == null)
				{
					folder = await localFolder.CreateFolderAsync(Chat.ChatID.ToString());
				}
				file = await Utility.IsFileExist(folder, _selectItem.CachedFileName);
			}
			if (!isResumed && file == null)
			{
				BackgroundDownloader downloader = new BackgroundDownloader();
				file = await folder.CreateFileAsync(_selectItem.CachedFileName);
				if (file == null)
				{
					return;
				}
				DownloadOperation newDownload = downloader.CreateDownload(new Uri(_selectItem.TrunkDownUri), (IStorageFile)(object)file);
				_page.ShowLoading();
				await newDownload.StartAsync().AsTask<DownloadOperation, DownloadOperation>(cts.Token, progressCallback);
				LoadingIndicator.StopLoading();
			}
			if (_selectItem.iType == TrunkItem.ItemType.Image)
			{
				IRandomAccessStream s = await file.OpenAsync((FileAccessMode)0);
				ItemImg = new BitmapImage();
				((BitmapSource)ItemImg).SetSource(s);
			}
			else if (_selectItem.iType == TrunkItem.ItemType.Video)
			{
				StorageItemThumbnail thumbnail = await file.GetThumbnailAsync((ThumbnailMode)1);
				if (thumbnail != null)
				{
					ItemImg = new BitmapImage();
					((BitmapSource)ItemImg).SetSource((IRandomAccessStream)(object)thumbnail);
				}
				else
				{
					ItemImg = new BitmapImage(new Uri(_selectItem.TrunkThumbUri));
				}
			}
			Video_Visible = _selectItem.Video_Visible;
			_isCommentReset = true;
			_ssmService.GetTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
			_page.ShowLoading();
			_ssmService.GetTrunkCommentListAsync(_chat.SessionID, _selectItem.TrunkItemID, 100, "-1");
		}
		catch
		{
		}
	}

	internal unsafe async void OpenTrunkItemDetail(Chat chat, TrunkItem item, StorageFile tempFile = null, Message msg = null, string type = null)
	{
		TrunkItemTemp = null;
		CancellationTokenSource cts = new CancellationTokenSource();
		if (tempFile != null && (await tempFile.GetBasicPropertiesAsync()).Size == 0)
		{
			try
			{
				await tempFile.DeleteAsync();
				tempFile = null;
			}
			catch (Exception)
			{
			}
		}
		if (tempFile != null)
		{
			try
			{
				_isMenuNextandPrev = false;
				IRandomAccessStream s = await tempFile.OpenAsync((FileAccessMode)0);
				_tempMsg = msg;
				_chat = chat;
				if (type == "image")
				{
					ItemImg = new BitmapImage();
					((BitmapSource)ItemImg).SetSource(s);
				}
				else if (type == "video")
				{
					StorageItemThumbnail thumbnail = await tempFile.GetThumbnailAsync((ThumbnailMode)1);
					ItemImg = new BitmapImage();
					((BitmapSource)ItemImg).SetSource((IRandomAccessStream)(object)thumbnail);
				}
				NotifyPropertyChanged("");
				_page.ShowLoading();
				if (_chat.ChatType != ChatType.BROADCAST)
				{
					if (msg != null)
					{
						_page.SwitchAppBar(isOpen: true);
						_ssmService.GetTrunkItemListCompleted += _ssmService_GetTrunkItemListCompleted;
						_ssmService.GetTrunkItemListByTimeStampAsync(msg.SessionID, 30, "0", msg.Time.ToString(), msg.Time.ToString());
						Grid_Visible = (Visibility)1;
						Comment_Visible = (Visibility)0;
					}
				}
				else
				{
					Grid_Visible = (Visibility)0;
					if (_selectItem.Senderid.Contains("ME"))
					{
						UploaderName = Utility.GetResourceString("IDS_CHATON_BODY_ME");
					}
					else
					{
						UploaderName = _selectItem.Name;
						DeleteVisibility = (Visibility)1;
					}
					if (msg != null)
					{
						UploadTime = Utility.GetDateTimeFromMiliseconds(msg.Time);
						UploadTime_Visible = (Visibility)0;
					}
					Comment_Visible = (Visibility)1;
					_page.SwitchAppBar(isOpen: false);
					LoadingIndicator.StopLoading();
				}
				return;
			}
			catch
			{
				return;
			}
		}
		try
		{
			Grid_Visible = (Visibility)0;
			_isMenuNextandPrev = true;
			((FrameworkElement)_page).put_DataContext((object)this);
			Chat = chat;
			_selectItem = item;
			_isDownloading = true;
			if (!_selectItem.Senderid.Contains("ME"))
			{
				DeleteVisibility = (Visibility)1;
			}
			TrunkCommentsView = await _trunkService.CacheCommentLoad(_selectItem.TrunkItemID);
			if (_selectItem.Senderid.Contains("ME"))
			{
				UploaderName = Utility.GetResourceString("IDS_CHATON_BODY_ME");
			}
			else
			{
				UploaderName = _selectItem.Name;
			}
			if (chat.ChatType != ChatType.BROADCAST)
			{
				UploadTime = Utility.GetDateTimeFromMiliseconds(long.Parse(_selectItem.Regdttm));
			}
			else
			{
				UploadTime = Utility.GetDateTimeFromMiliseconds(msg.Time);
			}
			UploadTime_Visible = (Visibility)0;
			IReadOnlyList<DownloadOperation> downloads = await BackgroundDownloader.GetCurrentDownloadsAsync();
			Progress<DownloadOperation> progressCallback = new Progress<DownloadOperation>(DownloadProgress);
			StorageFolder localFolder = ApplicationData.Current.LocalFolder;
			StorageFolder folder = null;
			StorageFile file = null;
			bool isResumed = false;
			foreach (DownloadOperation download in downloads)
			{
				if (download.RequestedUri.ToString() == _selectItem.TrunkDownUri)
				{
					isResumed = true;
					_page.ShowLoading();
					await download.AttachAsync().AsTask<DownloadOperation, DownloadOperation>(cts.Token, progressCallback);
					LoadingIndicator.StopLoading();
					IStorageFile resultFile = download.ResultFile;
					file = (StorageFile)(object)((resultFile is StorageFile) ? resultFile : null);
					break;
				}
			}
			if (!isResumed)
			{
				folder = await Utility.IsFolderExist(Chat.ChatID.ToString());
				if (folder == null)
				{
					folder = await localFolder.CreateFolderAsync(Chat.ChatID.ToString());
				}
				file = await Utility.IsFileExistCheck(folder, _selectItem.CachedFileName);
				if (file == null)
				{
					file = await Utility.IsFileExist(folder, _selectItem.CachedFileName);
					if (file != null)
					{
						try
						{
							await file.DeleteAsync();
							file = null;
						}
						catch (Exception)
						{
						}
					}
				}
			}
			if (!isResumed && file == null)
			{
				BackgroundDownloader downloader = new BackgroundDownloader();
				file = await folder.CreateFileAsync(_selectItem.CachedFileName);
				if (file == null)
				{
					return;
				}
				DownloadOperation newDownload = downloader.CreateDownload(new Uri(_selectItem.TrunkDownUri), (IStorageFile)(object)file);
				_page.ShowLoading();
				await newDownload.StartAsync().AsTask<DownloadOperation, DownloadOperation>(cts.Token, progressCallback);
				LoadingIndicator.StopLoading();
			}
			if (_selectItem.iType == TrunkItem.ItemType.Image)
			{
				IRandomAccessStream s2 = await file.OpenAsync((FileAccessMode)0);
				ItemImg = new BitmapImage();
				((BitmapSource)ItemImg).SetSource(s2);
			}
			else if (_selectItem.iType == TrunkItem.ItemType.Video)
			{
				StorageItemThumbnail thumbnail2 = await file.GetThumbnailAsync((ThumbnailMode)1);
				if (thumbnail2 != null)
				{
					ItemImg = new BitmapImage();
					((BitmapSource)ItemImg).SetSource((IRandomAccessStream)(object)thumbnail2);
				}
				else
				{
					ItemImg = new BitmapImage(new Uri(_selectItem.TrunkThumbUri));
				}
			}
			Video_Visible = _selectItem.Video_Visible;
			_isCommentReset = true;
			_page.ShowLoading();
			_ssmService.GetTrunkCommentListAsync(_chat.SessionID, _selectItem.TrunkItemID, 100, "-1");
			_dataTransferManager = DataTransferManager.GetForCurrentView();
			DataTransferManager dataTransferManager = _dataTransferManager;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<DataTransferManager, DataRequestedEventArgs>, EventRegistrationToken>(dataTransferManager, (nint)__ldftn(DataTransferManager.add_DataRequested)), new Action<EventRegistrationToken>(dataTransferManager, (nint)__ldftn(DataTransferManager.remove_DataRequested)), OnDataRequested);
			_imageFileToShare = await ApplicationData.Current.LocalFolder.GetFileAsync(GetCurrentItemFilePath());
		}
		catch
		{
		}
	}

	private unsafe async void _ssmService_GetTrunkItemListCompleted(object sender, SSMCompletedEventArgs e)
	{
		Grid_Visible = (Visibility)0;
		Trunk trunk = new Trunk();
		List<TrunkItem> tempList = new List<TrunkItem>();
		tempList = _trunkService.ParseTrunkItemListFromXml(e.Xml, trunk, tempList);
		if (tempList == null)
		{
			LoadingIndicator.StopLoading();
			return;
		}
		string[] mediaPath = _tempMsg.MediaFilePath.Split('\\');
		string fileName = mediaPath[1];
		TrunkItem findedTrunkItem = tempList.FirstOrDefault((TrunkItem c) => c.CachedFileName == fileName);
		if (findedTrunkItem != null)
		{
			_selectItem = findedTrunkItem;
			_selectItem.SessionID = _tempMsg.SessionID;
			if (_selectItem.Senderid.Contains("ME"))
			{
				UploaderName = Utility.GetResourceString("IDS_CHATON_BODY_ME");
			}
			else
			{
				UploaderName = _selectItem.Name;
				DeleteVisibility = (Visibility)1;
			}
			UploadTime = Utility.GetDateTimeFromMiliseconds(long.Parse(findedTrunkItem.Regdttm));
			UploadTime_Visible = (Visibility)0;
			_ssmService.GetTrunkCommentListAsync(_chat.SessionID, _selectItem.TrunkItemID, 100, "-1");
			TrunkCommentsView = await _trunkService.CacheCommentLoad(_selectItem.TrunkItemID);
			_isCommentReset = true;
			Video_Visible = _selectItem.Video_Visible;
			_page.SwitchAppBar(isOpen: true);
			try
			{
				_dataTransferManager = DataTransferManager.GetForCurrentView();
				DataTransferManager dataTransferManager = _dataTransferManager;
				WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<DataTransferManager, DataRequestedEventArgs>, EventRegistrationToken>(dataTransferManager, (nint)__ldftn(DataTransferManager.add_DataRequested)), new Action<EventRegistrationToken>(dataTransferManager, (nint)__ldftn(DataTransferManager.remove_DataRequested)), OnDataRequested);
				_imageFileToShare = await ApplicationData.Current.LocalFolder.GetFileAsync(GetCurrentItemFilePath());
			}
			catch (Exception)
			{
			}
		}
		else
		{
			_selectItem.CachedFileName = fileName;
			if (!string.IsNullOrEmpty(_tempMsg.Text))
			{
				if (_tempMsg.Text.StartsWith("image"))
				{
					_selectItem.iType = TrunkItem.ItemType.Image;
				}
				else if (_tempMsg.Text.StartsWith("video"))
				{
					_selectItem.iType = TrunkItem.ItemType.Video;
				}
			}
			else
			{
				_selectItem.iType = TrunkItem.ItemType.Image;
			}
			_selectItem.Regdttm = _tempMsg.Time.ToString();
			_selectItem.Totcmtcnt = "0";
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy x) => x.PhoneNumber == _tempMsg.Sender);
			if (buddy != null)
			{
				if (_tempMsg.Sender == RegistrationService.ChatOnID)
				{
					UploaderName = Utility.GetResourceString("IDS_CHATON_BODY_ME");
				}
				else
				{
					UploaderName = buddy.Name;
					DeleteVisibility = (Visibility)1;
				}
			}
			UploadTime = Utility.GetDateTimeFromMiliseconds(_tempMsg.Time);
			UploadTime_Visible = (Visibility)0;
			_page.SwitchAppBar(isOpen: false);
			Comment_Visible = (Visibility)1;
			if (_tempMsg.Text.StartsWith("video"))
			{
				Video_Visible = (Visibility)0;
				Play_Visible = (Visibility)0;
			}
			LoadingIndicator.StopLoading();
		}
		NotifyPropertyChanged("");
	}

	private void DownloadProgress(DownloadOperation download)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Unknown result type (might be due to invalid IL or missing references)
		//IL_004a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0054: Expected O, but got Unknown
		if (download.Progress.TotalBytesToReceive == 0)
		{
			return;
		}
		int percent = (int)(download.Progress.BytesReceived * 100 / download.Progress.TotalBytesToReceive);
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.ActiveIndicator.SetText("Downloading: " + percent + "%");
			}
		});
	}

	internal unsafe void OnNavigatedFrom()
	{
		if (_dataTransferManager != null)
		{
			WindowsRuntimeMarshal.RemoveEventHandler<TypedEventHandler<DataTransferManager, DataRequestedEventArgs>>(new Action<EventRegistrationToken>(_dataTransferManager, (nint)__ldftn(DataTransferManager.remove_DataRequested)), OnDataRequested);
		}
	}

	public async void OpenFile()
	{
		if (string.IsNullOrEmpty(_selectItem.CachedFileName))
		{
			Message item = _tempMsg;
			if (item != null && item.Text.StartsWith("video"))
			{
				await Launcher.LaunchFileAsync((IStorageFile)(object)(await Utility.IsFileExist(name: item.Text.Split('\n')[3], folderPath: item.Chat.ChatID.ToString())));
			}
			return;
		}
		StorageFile file = await Utility.IsFileExist(Chat.ChatID.ToString(), _selectItem.CachedFileName);
		if (_selectItem.iType == TrunkItem.ItemType.Image)
		{
			TrunkFullMode trunkFullMode = new TrunkFullMode();
			trunkFullMode.File = file;
			trunkFullMode.Item = _selectItem;
			trunkFullMode.Chat = Chat;
			trunkFullMode.CommentCounter = CommentCnt;
			((Page)_page).Frame.Navigate(typeof(TrunkDetailFullViewPage), (object)trunkFullMode);
		}
		else
		{
			await Launcher.LaunchFileAsync((IStorageFile)(object)file);
		}
	}

	private void _ssmService_GetTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		Grid_Visible = (Visibility)0;
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			if (e.Xml != null)
			{
				_selectItem = _trunkService.ParseTrunkItemFromXml(e.Xml, _chat.ChatID);
				_ = _selectItem.Unreadcmtcnt;
				_ = 0;
				int commentCount = int.Parse(_selectItem.Totcmtcnt);
				_trunkService.CommentCount = commentCount;
				if (_selectItem.Senderid.Contains("ME"))
				{
					UploaderName = Utility.GetResourceString("IDS_CHATON_BODY_ME");
				}
				else
				{
					UploaderName = _selectItem.Name;
				}
				UploadTime = Utility.GetDateTimeFromMiliseconds(long.Parse(_selectItem.Regdttm));
				UploadTime_Visible = (Visibility)0;
			}
		}
		else if (e.ErrorMessage.ToLower().EndsWith("does not exist"))
		{
			Comment_Visible = (Visibility)1;
			_page.SwitchAppBar(isOpen: false);
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
		_ssmService.GetTrunkCommentListAsync(_chat.SessionID, _selectItem.TrunkItemID, 100, "-1");
		NotifyPropertyChanged("");
	}

	private async void _ssmService_GetTrunkCommentListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (_isCommentReset)
		{
			TrunkComments.Clear();
			TrunkCommentsAll.Clear();
			TrunkCommentsView.Clear();
			_isCommentReset = false;
			_loadCommentCnt = InitialLoadCommentCount;
		}
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			if (e.Xml != null)
			{
				TrunkCommentsAll = await _trunkService.ParseTrunkCommentListFromXml(e.Xml, _selectItem.TrunkItemID, TrunkCommentsAll);
				if (TrunkCommentsAll.Count > 0)
				{
					foreach (TrunkComment item in TrunkCommentsAll)
					{
						ObservableCollection<TrunkComment> trunkComments = TrunkComments;
						Func<TrunkComment, bool> predicate = (TrunkComment p) => p.Cid == item.Cid;
						if (trunkComments.Where(predicate).Count() == 0)
						{
							TrunkComments.Add(item);
						}
					}
					TrunkComments = new ObservableCollection<TrunkComment>(TrunkComments.OrderBy((TrunkComment p) => p.Regdttm));
					_trunkService.LoadProfileImages(TrunkComments);
				}
				CommentCnt = TrunkComments.Count();
				if (_selectItem.Unreadcmtcnt > 0)
				{
					ChatOnService.Instance.IsUnreadTrunkCommentUpdated = true;
					_chat.UnreadTrunkMessageCount -= _selectItem.Unreadcmtcnt;
					_ssmService.MarkAsReadTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
				}
				if (e.Log != null)
				{
					string text = e.Log.Split('&').FirstOrDefault((string x) => x.Contains("startcommentid"));
					string[] array = text.Split('=');
					if (array.Length == 2 && array[1] == "-1")
					{
						_page.ScrollToBottom(isToBottom: true);
					}
				}
			}
			else
			{
				SSMService.ShowCommonErrorMessage(e);
			}
			if (TrunkComments.Count >= Convert.ToInt16(_selectItem.Totcmtcnt))
			{
				PrevioseBtn_Visible = (Visibility)1;
			}
			else
			{
				PrevioseBtn_Visible = (Visibility)0;
			}
		}
		LoadingIndicator.StopLoading();
		NotifyPropertyChanged("");
	}

	private void _ssmService_DeleteTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode != HttpStatusCode.OK)
		{
			SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			((Page)_page).Frame.GoBack();
		}
	}

	private void _ssmService_MarkAsReadTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_chat.UnreadTrunkMessageCount = 0;
			_selectItem.Unreadcmtcnt = 0;
		}
	}

	public void ShareTrunkItem()
	{
		DataTransferManager.ShowShareUI();
	}

	private unsafe void OnDataRequested(DataTransferManager sender, DataRequestedEventArgs e)
	{
		if (_imageFileToShare != null)
		{
			if (!string.IsNullOrEmpty(_imageFileToShare.Name))
			{
				DataPackage data = e.Request.Data;
				WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<DataPackage, OperationCompletedEventArgs>, EventRegistrationToken>(data, (nint)__ldftn(DataPackage.add_OperationCompleted)), new Action<EventRegistrationToken>(data, (nint)__ldftn(DataPackage.remove_OperationCompleted)), requestData_OperationCompleted);
				data.Properties.put_Title(_imageFileToShare.Name);
				List<IStorageItem> list = new List<IStorageItem>();
				list.Add((IStorageItem)(object)_imageFileToShare);
				data.SetStorageItems((IEnumerable<IStorageItem>)list);
			}
			else
			{
				e.Request.FailWithDisplayText("The file name is needed to share it");
			}
		}
		else
		{
			e.Request.FailWithDisplayText("Select an image you would like to share and try again.");
		}
	}

	private void requestData_OperationCompleted(DataPackage sender, OperationCompletedEventArgs args)
	{
		Utility.ShowSimpleToastNotification("Tesss");
	}

	public void DeleteItem()
	{
		_page.ShowLoading();
		_ssmService.DeleteTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
	}

	internal string GetCurrentItemFilePath()
	{
		string text = _selectItem.TrunkDownUri;
		if (text.Contains("http://https://"))
		{
			text = text.Replace("http://", "");
		}
		string text2 = "/?";
		char[] separator = text2.ToCharArray();
		string[] array = text.Split(separator);
		return string.Concat(_chat.ChatID, "\\", array[5]);
	}

	public void LoadMoreComment()
	{
		if (TrunkComments.Count > 0 && _TempCommentCount < TrunkComments.Count)
		{
			_page.ShowLoading();
			_ssmService.GetTrunkCommentListAsync(_chat.SessionID, _selectItem.TrunkItemID, 100, TrunkComments.First().Cid);
			_TempCommentCount = TrunkComments.Count;
		}
	}

	private async void _ssmService_PostTrunkCommentComplet(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			CommentCnt++;
			NotifyPropertyChanged(() => CommentCnt);
			_ssmService.GetTrunkCommentListAsync(_chat.SessionID, _selectItem.TrunkItemID, 100, "-1");
			return;
		}
		LoadingIndicator.StopLoading();
		if (e.ErrorMessage == null)
		{
			if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_UPDATE_FAILED"), showCancel: true, Utility.GetResourceString("IDS_CHATON_BODY_ERROR")))
			{
				UploadComment(_comment);
			}
		}
		else if (e.ErrorMessage.Contains("CCS-89411") || e.ErrorMessage.Contains("does not exist"))
		{
			MessageDialog val = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_DELETED_ITEM"));
			val.ShowAsync();
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	internal void UploadComment(string comment)
	{
		_page.ShowLoading();
		_comment = comment;
		_ssmService.PostTrunkCommentAsync(_chat.SessionID, _selectItem.TrunkItemID, _comment);
	}

	internal void DeleteTrunkComment(string cid)
	{
		_page.ShowLoading();
		CommentId_delete = cid;
		_ssmService.DeleteTrunkCommentAsync(_chat.SessionID, _selectItem.TrunkItemID, cid);
	}

	private void _ssmService_DeleteTrunkCommentCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			TrunkComment item = TrunkComments.Where((TrunkComment p) => p.Cid == CommentId_delete).FirstOrDefault();
			TrunkComments.Remove(item);
			NotifyPropertyChanged(() => TrunkComments);
			TrunkCommentsAll.Remove(item);
			CommentCnt--;
			if (CommentCnt == 0)
			{
				_isCommentReset = true;
			}
			NotifyPropertyChanged(() => CommentCnt);
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	internal async void SaveTrunkItem()
	{
		try
		{
			if (string.IsNullOrEmpty(_selectItem.CachedFileName))
			{
				return;
			}
			StorageFile sourceFile = await Utility.IsFileExist(Chat.ChatID.ToString(), _selectItem.CachedFileName);
			if (sourceFile == null)
			{
				return;
			}
			FileSavePicker savePicker = new FileSavePicker();
			if (_selectItem.iType == TrunkItem.ItemType.Image)
			{
				savePicker.put_SuggestedStartLocation((PickerLocationId)6);
			}
			else if (_selectItem.iType == TrunkItem.ItemType.Video)
			{
				savePicker.put_SuggestedStartLocation((PickerLocationId)7);
			}
			savePicker.FileTypeChoices.Add(sourceFile.DisplayType, new List<string> { sourceFile.FileType });
			savePicker.put_SuggestedFileName(sourceFile.Name);
			StorageFile file = await savePicker.PickSaveFileAsync();
			if (file == null)
			{
				return;
			}
			if (file != null && !string.IsNullOrWhiteSpace(file.DisplayName))
			{
				IBuffer buffer = await FileIO.ReadBufferAsync((IStorageFile)(object)sourceFile);
				try
				{
					await FileIO.WriteBufferAsync((IStorageFile)(object)file, buffer);
					_page.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_POP_SAVED"), warning: false);
				}
				catch (Exception ex)
				{
					file.DeleteAsync();
					if (ex.HResult == -2147024784)
					{
						_page.ShowSplashPopup(Utility.GetResourceString("IDS_CHATON_BODY_UNABLE_TO_COMPLETE_ACTION_NOT_ENOUGH_MEMORY"), warning: true);
					}
				}
			}
			else
			{
				file.DeleteAsync();
			}
			NotifyPropertyChanged("");
		}
		catch
		{
		}
	}
}
