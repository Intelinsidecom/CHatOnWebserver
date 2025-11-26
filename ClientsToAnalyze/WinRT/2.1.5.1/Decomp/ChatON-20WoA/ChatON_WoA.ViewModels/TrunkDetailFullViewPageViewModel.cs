using System;
using System.Collections.Generic;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.ApplicationModel.DataTransfer;
using Windows.Foundation;
using Windows.Storage;
using Windows.Storage.Pickers;
using Windows.Storage.Streams;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatON_WoA.ViewModels;

public class TrunkDetailFullViewPageViewModel : NotificationObject
{
	private TrunkDetailFullViewPage _page;

	private DataTransferManager _dataTransferManager;

	private StorageFile _imageFileToShare;

	private TrunkItem _selectItem;

	private BitmapImage _itemImg;

	private Chat _chat;

	private SSMService _ssmService;

	private int _commentCnt;

	private string _uploaderName;

	private DateTime _uploadTime;

	private bool _isDownloading;

	private Visibility _deleteVisibility;

	private Visibility _commentTitleVisibility;

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

	public Visibility CommentTitleVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _commentTitleVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_commentTitleVisibility = value;
			NotifyPropertyChanged(() => CommentTitleVisibility);
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

	public bool IsDownloading
	{
		get
		{
			return _isDownloading;
		}
		set
		{
			_isDownloading = value;
			NotifyPropertyChanged(() => IsDownloading);
		}
	}

	public TrunkDetailFullViewPageViewModel(TrunkDetailFullViewPage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_ssmService.DeleteTrunkItemCompleted += _ssmService_DeleteTrunkItemCompleted;
		IsDownloading = true;
	}

	internal unsafe async void OpenTrunkItemDetail(TrunkFullMode item)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (string.IsNullOrEmpty(item.Item.SessionID))
			{
				CommentTitleVisibility = (Visibility)1;
			}
			_selectItem = item.Item;
			Chat = item.Chat;
			if (!_selectItem.Senderid.Contains("ME"))
			{
				DeleteVisibility = (Visibility)1;
			}
			_commentCnt = int.Parse(_selectItem.Totcmtcnt);
			if (_selectItem.Senderid.Contains("ME"))
			{
				UploaderName = Utility.GetResourceString("IDS_CHATON_BODY_ME");
			}
			else
			{
				UploaderName = _selectItem.Name;
			}
			UploadTime = Utility.GetDateTimeFromMiliseconds(long.Parse(_selectItem.Regdttm));
			ItemImg = new BitmapImage(new Uri(item.File.Path, UriKind.Relative));
			IsDownloading = false;
			NotifyPropertyChanged("");
			_dataTransferManager = DataTransferManager.GetForCurrentView();
			DataTransferManager dataTransferManager = _dataTransferManager;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<DataTransferManager, DataRequestedEventArgs>, EventRegistrationToken>(dataTransferManager, (nint)__ldftn(DataTransferManager.add_DataRequested)), new Action<EventRegistrationToken>(dataTransferManager, (nint)__ldftn(DataTransferManager.remove_DataRequested)), OnDataRequested);
			_imageFileToShare = await ApplicationData.Current.LocalFolder.GetFileAsync(GetCurrentItemFilePath());
		}
		catch
		{
		}
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

	internal unsafe void OnNavigatedFrom()
	{
		if (_dataTransferManager != null)
		{
			WindowsRuntimeMarshal.RemoveEventHandler<TypedEventHandler<DataTransferManager, DataRequestedEventArgs>>(new Action<EventRegistrationToken>(_dataTransferManager, (nint)__ldftn(DataTransferManager.remove_DataRequested)), OnDataRequested);
		}
	}

	internal async void SaveTrunkItem()
	{
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
		savePicker.FileTypeChoices.Add(sourceFile.DisplayType, new List<string> { sourceFile.FileType });
		savePicker.put_SuggestedFileName(sourceFile.Name);
		StorageFile file = await savePicker.PickSaveFileAsync();
		if (file == null || string.IsNullOrWhiteSpace(file.DisplayName))
		{
			return;
		}
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

	public void DeleteItem()
	{
		_page.ShowLoading();
		_ssmService.DeleteTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
	}

	private void _ssmService_DeleteTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode != HttpStatusCode.OK)
		{
			SSMService.ShowCommonErrorMessage(e);
			return;
		}
		while ((object)((Page)_page).Frame.CurrentSourcePageType != typeof(PivotPage) && (object)((Page)_page).Frame.CurrentSourcePageType != typeof(TrunkPage))
		{
			Utility.SafetyGoBackPageNavigation(((Page)_page).Frame);
		}
	}

	public void ShareTrunkItem()
	{
		DataTransferManager.ShowShareUI();
	}

	private void OnDataRequested(DataTransferManager sender, DataRequestedEventArgs e)
	{
		if (_imageFileToShare != null)
		{
			if (!string.IsNullOrEmpty(_imageFileToShare.Name))
			{
				DataPackage data = e.Request.Data;
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
}
