using System;
using System.Collections.Generic;
using System.IO;
using System.IO.IsolatedStorage;
using System.Net;
using System.Windows;
using System.Windows.Media.Imaging;
using ChatOn.AnimationMessage.Encoding;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;
using Microsoft.Phone.Tasks;

namespace ChatOn.ViewModels;

public class TrunkItemPageViewModel : NotificationObject
{
	private PhoneApplicationPage _page;

	private List<TrunkComment> _trunkComments;

	private SSMService _ssmService;

	private Chat _chat;

	private TrunkService _trunkService;

	private TrunkComment _tempItem;

	private DataService _dataService;

	private TrunkItem _selectItem;

	private BitmapImage _itemImg;

	private string _selectItemID;

	private string _commentCnt;

	private string _uploaderName;

	private string _uploadTime;

	private Visibility _videoVisible;

	private Visibility _playVisible;

	private Visibility _PreviousBtnVisible;

	private bool _isDownloading;

	private bool _isCommentReset;

	private int _loadCommentCnt;

	public Visibility PrevioseBtn_Visible
	{
		get
		{
			return _PreviousBtnVisible;
		}
		set
		{
			_PreviousBtnVisible = value;
			NotifyPropertyChanged(() => PrevioseBtn_Visible);
		}
	}

	public Visibility Play_Visible
	{
		get
		{
			return _playVisible;
		}
		set
		{
			_playVisible = value;
			NotifyPropertyChanged(() => Play_Visible);
		}
	}

	public Visibility Video_Visible
	{
		get
		{
			return _videoVisible;
		}
		set
		{
			_videoVisible = value;
			NotifyPropertyChanged(() => Video_Visible);
		}
	}

	public string CommentCnt
	{
		get
		{
			return _commentCnt;
		}
		set
		{
			_commentCnt = value;
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

	public string UploadTime
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

	public List<TrunkComment> TrunkComments
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

	public TrunkItemPageViewModel(PhoneApplicationPage page)
	{
		_page = page;
		TrunkComments = new List<TrunkComment>();
		_tempItem = new TrunkComment();
		_dataService = new DataService();
		_trunkService = new TrunkService(_dataService);
		_ssmService = new SSMService();
		_ssmService.GetTrunkItemCompleted += _ssmService_GetTrunkItemCompleted;
		_ssmService.GetTrunkCommentListCompleted += _ssmService_GetTrunkCommentListCompleted;
		_ssmService.DeleteTrunkItemCompleted += _ssmService_DeleteTrunkItemCompleted;
		_ssmService.DeleteTrunkCommentCompleted += _ssmService_DeleteTrunkCommentCompleted;
		_ssmService.MarkAsReadTrunkItemCompleted += _ssmService_MarkAsReadTrunkItemCompleted;
		_selectItem = new TrunkItem();
		Video_Visible = Visibility.Collapsed;
		Play_Visible = Visibility.Collapsed;
		PrevioseBtn_Visible = Visibility.Collapsed;
	}

	internal void OpenTrunkItemDetail(Guid id, string itemId)
	{
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		((FrameworkElement)(object)_page).DataContext = this;
		Chat = _dataService.GetChat(id);
		_selectItemID = itemId;
		try
		{
			_selectItem = _dataService.GetTrunkItem(_selectItemID);
		}
		catch (Exception)
		{
			Utility.SafetyGoBack(_page);
			return;
		}
		_isDownloading = true;
		ApplicationBarMenuItem val = null;
		val = new ApplicationBarMenuItem(ResContainer.IDS_CHATON_SK_DELETE);
		try
		{
			if (!_selectItem.Senderid.Contains("ME"))
			{
				val.IsEnabled = false;
			}
			val.Click += Delete_Click;
			_page.ApplicationBar.MenuItems.Add(val);
		}
		catch (Exception)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_NOT_AVAILABLE_TRY_LATER);
			Utility.SafetyGoBack(_page);
			return;
		}
		TrunkComments = _trunkService.CacheCommentLoad(_selectItem.TrunkItemID);
		CommentCnt = _selectItem.Totcmtcnt;
		if (_selectItem.Senderid.Contains("ME"))
		{
			UploaderName = ResContainer.IDS_CHATON_BODY_ME;
		}
		else
		{
			UploaderName = _selectItem.Name;
		}
		UploadTime = Utility.GetDateTimeFromMiliseconds(long.Parse(_selectItem.Regdttm)).ToString();
		string text = "";
		if (string.IsNullOrEmpty(_selectItem.TrunkDonwUri))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_NOT_AVAILABLE_TRY_LATER);
			Utility.SafetyGoBack(_page);
			return;
		}
		text = _chat.SessionID + "\\";
		text += Utility.GetFileNameFromUri(_selectItem.TrunkDonwUri);
		IsolatedStorageFile userStoreForApplication = IsolatedStorageFile.GetUserStoreForApplication();
		if (!userStoreForApplication.DirectoryExists(_chat.SessionID))
		{
			userStoreForApplication.CreateDirectory(_chat.SessionID);
		}
		if (userStoreForApplication.FileExists(text))
		{
			if (_selectItem.iType == TrunkItem.ItemType.Image)
			{
				ItemImg = Utility.LoadJpeg(text);
				if (AMSDecoder.ContainsAMSMessage(text))
				{
					Play_Visible = Visibility.Visible;
				}
				else
				{
					Play_Visible = Visibility.Collapsed;
				}
			}
			else if (_selectItem.iType != TrunkItem.ItemType.Video)
			{
			}
			Video_Visible = _selectItem.Video_Visible;
			Utility.ShowSystemTrayProgress(_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
			_isCommentReset = true;
			_ssmService.GetTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
			return;
		}
		text = _chat.SessionID + "\\thumb_";
		text += Utility.GetFileNameFromUri(_selectItem.TrunkDonwUri);
		if (userStoreForApplication.FileExists(text))
		{
			ItemImg = Utility.LoadJpeg(text);
		}
		string trunkDonwUri = _selectItem.TrunkDonwUri;
		string text2 = "/?";
		char[] separator = text2.ToCharArray();
		string[] array = trunkDonwUri.Split(separator);
		_ = _chat.SessionID + "\\" + array[5];
		_ssmService.DownloadFileCompleted += ssmService_DownloadFileCompleted;
		_ssmService.DownloadProgressChanged += ssmService_DownloadProgressChanged;
		_ssmService.DownloadTrunkFileUsingBackground("http://" + array[2] + "/file", array[5], array[4], _chat.SessionID);
		Utility.ShowSystemTrayProgress(_page, ResContainer.IDS_CHATON_POP_DOWNLOADING_ING);
	}

	internal void OnNavigatedFrom()
	{
	}

	internal void OnNavigatedTo()
	{
		_isDownloading = false;
		Utility.ShowSystemTrayProgress(_page, "");
		Utility.HideSystemTrayProgress(_page, HideProgressOnly: true);
		_selectItem = _dataService.GetTrunkItem(_selectItemID);
		if (IsoSettingHelper.Get("ReloadCommentList", 0) == 1)
		{
			IsolatedStorageSettings.ApplicationSettings["ReloadCommentList"] = 0;
			IsolatedStorageSettings.ApplicationSettings.Save();
			Utility.ShowSystemTrayProgress(_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
			_isDownloading = true;
			_isCommentReset = true;
			_ssmService.GetTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
		}
	}

	public void TestFunction()
	{
		//IL_0042: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Expected O, but got Unknown
		string text = "";
		string trunkDonwUri = _selectItem.TrunkDonwUri;
		string text2 = "/?";
		char[] separator = text2.ToCharArray();
		string[] array = trunkDonwUri.Split(separator);
		text = _chat.SessionID + "/" + array[5];
		MediaPlayerLauncher val = new MediaPlayerLauncher();
		val.Media = new Uri(text, UriKind.Relative);
		val.Location = (MediaLocationType)2;
		val.Controls = (MediaPlaybackControls)3;
		val.Orientation = (MediaPlayerOrientation)1;
		val.Show();
	}

	public void OpenFile()
	{
		//IL_00cb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d2: Expected O, but got Unknown
		string text = "";
		string trunkDonwUri = _selectItem.TrunkDonwUri;
		string text2 = "/?";
		char[] separator = text2.ToCharArray();
		string[] array = trunkDonwUri.Split(separator);
		text = _chat.SessionID + "\\" + array[5];
		if (_isDownloading)
		{
			return;
		}
		IsolatedStorageFile userStoreForApplication = IsolatedStorageFile.GetUserStoreForApplication();
		if (!userStoreForApplication.DirectoryExists(_chat.SessionID))
		{
			userStoreForApplication.CreateDirectory(_chat.SessionID);
		}
		if (userStoreForApplication.FileExists(text))
		{
			if (_selectItem.iType == TrunkItem.ItemType.Image)
			{
				if (AMSDecoder.ContainsAMSMessage(text))
				{
					PageNavigationService.OpenAMSPreviewPage(_page, text, autoPlay: true);
				}
				else
				{
					PageNavigationService.OpenImageViewerPage(_page, "?source=" + text);
				}
			}
			else if (_selectItem.iType == TrunkItem.ItemType.Video)
			{
				MediaPlayerLauncher val = new MediaPlayerLauncher();
				val.Media = new Uri(text, UriKind.Relative);
				val.Location = (MediaLocationType)2;
				val.Controls = (MediaPlaybackControls)3;
				val.Orientation = (MediaPlayerOrientation)1;
				val.Show();
			}
		}
		else
		{
			MessageBox.Show(ResContainer.IDS_CHATON_BODY_NO_FILES);
		}
	}

	private void ssmService_DownloadProgressChanged(object sender, SSMCompletedEventArgs e)
	{
		string text = "";
		text = string.Concat("Downloading file : ", e.Value, "%...");
		Utility.ShowSystemTrayProgress(_page, text);
	}

	private void ssmService_DownloadFileCompleted(object sender, SSMCompletedEventArgs e)
	{
		string currentItemFilePath = GetCurrentItemFilePath();
		IsolatedStorageFile userStoreForApplication = IsolatedStorageFile.GetUserStoreForApplication();
		if (!userStoreForApplication.DirectoryExists(_chat.SessionID))
		{
			userStoreForApplication.CreateDirectory(_chat.SessionID);
		}
		if (e.BackTransferRequest != null)
		{
			if (userStoreForApplication.FileExists(e.BackTransferRequest.DownloadLocation.OriginalString))
			{
				userStoreForApplication.MoveFile(e.BackTransferRequest.DownloadLocation.OriginalString, currentItemFilePath);
			}
			if (_selectItem.iType == TrunkItem.ItemType.Image)
			{
				ItemImg = Utility.LoadJpeg(currentItemFilePath);
				if (AMSDecoder.ContainsAMSMessage(currentItemFilePath))
				{
					Play_Visible = Visibility.Visible;
				}
				else
				{
					Play_Visible = Visibility.Collapsed;
				}
			}
			else if (_selectItem.iType == TrunkItem.ItemType.Video)
			{
				Video_Visible = _selectItem.Video_Visible;
			}
			Utility.ShowSystemTrayProgress(_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
			_isCommentReset = true;
			_ssmService.GetTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
		}
		else
		{
			IsolatedStorageFileStream isolatedStorageFileStream = userStoreForApplication.CreateFile(currentItemFilePath);
			(e.Value as Stream).CopyTo(isolatedStorageFileStream);
			isolatedStorageFileStream.Close();
			userStoreForApplication.Dispose();
			(e.Value as Stream).Close();
		}
	}

	private void _ssmService_GetTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			if (e.Xml != null)
			{
				_selectItem = _trunkService.ParseTrunkItemFromXml(e.Xml);
				_dataService.UpdateTrunkItem(_selectItem);
				if (!_selectItem.Unreadcmtcnt.Equals("0"))
				{
					_chat.UnreadTrunkMessageCount--;
					_ssmService.MarkAsReadTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
				}
				CommentCnt = _selectItem.Totcmtcnt;
				_trunkService.CommentCount = Convert.ToInt16(CommentCnt);
				if (_selectItem.Senderid.Contains("ME"))
				{
					UploaderName = ResContainer.IDS_CHATON_BODY_ME;
				}
				else
				{
					UploaderName = _selectItem.Name;
				}
				UploadTime = Utility.GetDateTimeFromMiliseconds(long.Parse(_selectItem.Regdttm)).ToString();
			}
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
		_ssmService.GetTrunkCommentListAsync(_chat.SessionID, _selectItem.TrunkItemID, 2, "-1");
	}

	private void _ssmService_GetTrunkCommentListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (_isCommentReset)
		{
			TrunkComments.Clear();
			_isCommentReset = false;
			_loadCommentCnt = 2;
			_dataService.resetTrunkComment(_selectItem.TrunkItemID);
		}
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			if (e.Xml != null)
			{
				TrunkComments = _trunkService.ParseTrunkCOmmentListFromXml(e.Xml, _selectItem.TrunkItemID, TrunkComments);
			}
			Utility.ShowSystemTrayProgress(_page, "");
			Utility.HideSystemTrayProgress(_page, HideProgressOnly: true);
			_isDownloading = false;
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
		if (TrunkComments.Count >= Convert.ToInt16(_selectItem.Totcmtcnt))
		{
			PrevioseBtn_Visible = Visibility.Collapsed;
		}
		else
		{
			PrevioseBtn_Visible = Visibility.Visible;
		}
	}

	private void _ssmService_DeleteTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			_ = e.Xml;
			IsolatedStorageSettings.ApplicationSettings["LoadTrunkList"] = 1;
			IsolatedStorageSettings.ApplicationSettings.Save();
			Utility.SafetyGoBack(_page);
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
	}

	private void _ssmService_MarkAsReadTrunkItemCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ = e.Xml;
	}

	private void _ssmService_DeleteTrunkCommentCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			_ = e.Xml;
			_isCommentReset = true;
			_ssmService.GetTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
	}

	public void MoveToCommentPage()
	{
		if (!_isDownloading)
		{
			PageNavigationService.OpenTrunkComment(_selectItem, _chat, _page);
		}
	}

	internal void OpenCommentItemContexMenu(FrameworkElement element)
	{
		TrunkComment tag = element.DataContext as TrunkComment;
		LightContextMenu lightContextMenu = new LightContextMenu();
		LightMenuItem lightMenuItem = new LightMenuItem(ResContainer.IDS_CHATON_OPT_DELETE_ABB);
		lightMenuItem.OnExecute += deleteMenu_OnExecute;
		lightMenuItem.Tag = tag;
		lightContextMenu.MenuItems.Add(lightMenuItem);
		lightContextMenu.Open(_page, (_page as TrunkItemPage).LayoutRoot, element);
	}

	private void deleteMenu_OnExecute(object sender, EventArgs e)
	{
		TrunkComment trunkComment = (sender as LightMenuItem).Tag as TrunkComment;
		if (!trunkComment.Orgname.Contains("ME"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_DELETE_FAILED);
			return;
		}
		Utility.ShowSystemTrayProgress(_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
		_ssmService.DeleteTrunkCommentAsync(_chat.SessionID, _selectItem.TrunkItemID, trunkComment.Cid);
	}

	public void ShareTrunkItem()
	{
		ChatOnService.Instance.FileNameToShare = GetCurrentItemFilePath();
		PageNavigationService.OpenShareListPage(_page);
	}

	public void deleteItem()
	{
		if (_selectItem.Senderid.Contains("ME"))
		{
			_ssmService.DeleteTrunkItemAsync(_chat.SessionID, _selectItem.TrunkItemID);
		}
	}

	internal string GetCurrentItemFilePath()
	{
		string text = "/?";
		char[] separator = text.ToCharArray();
		string[] array = _selectItem.TrunkDonwUri.Split(separator);
		return _chat.SessionID + "\\" + array[5];
	}

	private void Delete_Click(object sender, EventArgs e)
	{
		if (!_isDownloading && MessageBoxResult.OK == MessageBox.Show(ResContainer.IDS_CHATON_POP_DELETE_Q, ResContainer.IDS_CHATON_OPT_DELETE_ABB, MessageBoxButton.OKCancel))
		{
			deleteItem();
		}
	}

	public void LoadMoreComment()
	{
		Convert.ToInt16(_selectItem.Totcmtcnt);
		_loadCommentCnt += 30;
		Utility.ShowSystemTrayProgress(_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
		_ssmService.GetTrunkCommentListAsync(_chat.SessionID, _selectItem.TrunkItemID, 31, TrunkComments[0].Cid);
	}
}
