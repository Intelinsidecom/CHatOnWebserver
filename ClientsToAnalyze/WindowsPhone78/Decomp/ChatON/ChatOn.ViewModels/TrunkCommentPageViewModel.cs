using System;
using System.IO.IsolatedStorage;
using System.Net;
using System.Windows;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class TrunkCommentPageViewModel : NotificationObject
{
	private PhoneApplicationPage _page;

	private SSMService _ssmService;

	private Chat _chat;

	private DataService _dataService;

	private TrunkItem _selectItem;

	private TrunkService _trunkService;

	private string _inputTextMsg = "";

	private string _commentCnt;

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

	public string InputTextMsg
	{
		get
		{
			return _inputTextMsg;
		}
		set
		{
			_inputTextMsg = value;
			NotifyPropertyChanged(() => InputTextMsg);
		}
	}

	public TrunkCommentPageViewModel(PhoneApplicationPage page)
	{
		_page = page;
		_dataService = new DataService();
		_ssmService = new SSMService();
		_selectItem = new TrunkItem();
		_trunkService = new TrunkService(_dataService);
		_ssmService.PostTrunkCommentComplet += _ssmService_PostTrunkCommentComplet;
	}

	internal void OpenTrunkCommentDetail(Guid id, string itemId)
	{
		((FrameworkElement)(object)_page).DataContext = this;
		Chat = _dataService.GetChat(id);
		try
		{
			_selectItem = _dataService.GetTrunkItem(itemId);
		}
		catch (Exception)
		{
			Utility.SafetyGoBack(_page);
		}
	}

	internal void SendComment()
	{
		_chat.IsChanged = true;
		string text = "";
		text = _inputTextMsg;
		Utility.ShowSystemTrayProgress(_page, ResContainer.IDS_CHATON_BODY_LOADING_ING);
		_ssmService.PostTrunkCommentAsync(_chat.SessionID, _selectItem.TrunkItemID, text);
		InputTextMsg = "";
	}

	internal void GoBackItem()
	{
		Utility.SafetyGoBack(_page);
	}

	private void _ssmService_PostTrunkCommentComplet(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK || e.StatusCode == HttpStatusCode.NoContent)
		{
			_ = e.Xml;
			if (!IsolatedStorageSettings.ApplicationSettings.Contains("ReloadCommentList"))
			{
				IsolatedStorageSettings.ApplicationSettings.Add("ReloadCommentList", 1);
				IsolatedStorageSettings.ApplicationSettings.Save();
			}
			if ((int)IsolatedStorageSettings.ApplicationSettings["ReloadCommentList"] == 0)
			{
				IsolatedStorageSettings.ApplicationSettings["ReloadCommentList"] = 1;
				IsolatedStorageSettings.ApplicationSettings.Save();
			}
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
}
