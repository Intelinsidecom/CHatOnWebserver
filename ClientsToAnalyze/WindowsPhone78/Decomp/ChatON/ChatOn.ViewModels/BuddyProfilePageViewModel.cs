using System;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Windows;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using com.sec.ssm.common;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class BuddyProfilePageViewModel : NotificationObject
{
	private BuddyProfilePage _page;

	private Buddy _buddy;

	private bool _orgBuddyFavoriteValue;

	private BuddyService _buddyService;

	private SSMService _ssmService;

	private DataService _dataService;

	private ChatService _chatService;

	private RegistrationService _regService;

	private ObservableCollection<BuddiesSay> _memoList;

	public ObservableCollection<BuddiesSay> MemoList
	{
		get
		{
			return _memoList;
		}
		set
		{
			_memoList = value;
			NotifyPropertyChanged(() => MemoList);
		}
	}

	public Buddy Buddy
	{
		get
		{
			return _buddy;
		}
		set
		{
			_buddy = value;
		}
	}

	public BuddyProfilePageViewModel(BuddyProfilePage page)
	{
		_page = page;
		_regService = new RegistrationService();
		_ssmService = new SSMService();
		_ssmService.GetMemoListCompleted += _ssmService_GetMemoListCompleted;
		_ssmService.DeleteMemoCompleted += _ssmService_DeleteMemoCompleted;
		_ssmService.BlockBuddyCompleted += _ssmService_BlockBuddyCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.GetUserNumber());
	}

	private void _ssmService_BlockBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_buddyService.BlockBuddy(_buddy);
			ChatOnService.Instance.IsBuddiesUpdated = true;
			ChatOnService.Instance.ReUpdateInteraction = true;
			MessageBox.Show(Utility.sprintf(ResContainer.IDS_CHATON_POP_PS_BLOCKED, _buddy.Name));
			_page.IsRunningAnimation = true;
			_page.BlockStroy.Completed += BlockStroy_Completed;
			_page.BlockStroy.Begin();
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

	private void BlockStroy_Completed(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
	}

	private void _ssmService_DeleteMemoCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		long timeStamp = (long)e.Value;
		BuddiesSay buddiesSay = MemoList.FirstOrDefault((BuddiesSay c) => c.TimeStamp == timeStamp);
		if (buddiesSay != null)
		{
			MemoList.Remove(buddiesSay);
		}
	}

	private void _ssmService_GetMemoListCompleted(object sender, SSMCompletedEventArgs e)
	{
		bool isBlind = true;
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			MemoList = _buddyService.ParseMemoFromXml(e.Xml, out isBlind);
		}
		_buddy.IsBlind = isBlind;
		Utility.HideSystemTrayProgress((PhoneApplicationPage)(object)_page, HideProgressOnly: true);
	}

	public void OnNavigatedTo(string phoneNumber)
	{
		_buddy = _buddyService.GetBuddy(phoneNumber);
		_orgBuddyFavoriteValue = _buddy.IsFavorite;
		((FrameworkElement)(object)_page).DataContext = this;
		string iDS_CHATON_BODY_PS_DOES_NOT_USE_BUDDIES_SAY = ResContainer.IDS_CHATON_BODY_PS_DOES_NOT_USE_BUDDIES_SAY;
		_page.BlindNotiTextBlock.Text = iDS_CHATON_BODY_PS_DOES_NOT_USE_BUDDIES_SAY.Replace("%s", Buddy.Name);
		UpdateMemoList();
	}

	public void PinToStart()
	{
		BuddyService.PinToStart(_buddy);
	}

	internal void OpenAddCommentPage()
	{
		PageNavigationService.OpenAddCommentPage((PhoneApplicationPage)(object)_page, _buddy.PhoneNumber);
	}

	internal void UpdateMemoList()
	{
		Utility.ShowSystemTrayProgress((PhoneApplicationPage)(object)_page, ResContainer.IDS_CHATON_POP_UPDATING_ING);
		_ssmService.GetMemoListAsync(_buddy.PhoneNumber);
	}

	internal void OpenBuddiesSayContexMenu(FrameworkElement element)
	{
		BuddiesSay buddiesSay = element.DataContext as BuddiesSay;
		if (!(buddiesSay.PhoneNumber != RegistrationService.GetUserNumber()))
		{
			LightContextMenu lightContextMenu = new LightContextMenu();
			LightMenuItem lightMenuItem = new LightMenuItem(ResContainer.IDS_CHATON_OPT_DELETE_ABB);
			lightMenuItem.OnExecute += deleteMenu_OnExecute;
			lightMenuItem.Tag = buddiesSay;
			lightContextMenu.MenuItems.Add(lightMenuItem);
			lightContextMenu.Open((PhoneApplicationPage)(object)_page, _page.LayoutRoot, element);
		}
	}

	private void deleteMenu_OnExecute(object sender, EventArgs e)
	{
		BuddiesSay buddiesSay = (sender as LightMenuItem).Tag as BuddiesSay;
		_ssmService.DeleteMemoAsync(_buddy.PhoneNumber, buddiesSay.TimeStamp, fromMyProfile: false);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}

	internal void ToggleFavorite()
	{
		_buddy.IsFavorite = !_buddy.IsFavorite;
		_dataService.SubmitChanges();
	}

	internal void OnNavigatedFrom()
	{
		if (_orgBuddyFavoriteValue != _buddy.IsFavorite)
		{
			ChatOnService.Instance.IsBuddiesUpdated = true;
		}
	}

	internal void StartChat()
	{
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
		Chat chat = _chatService.StartChat(_buddy.PhoneNumber, _buddy.PhoneNumber, ChatType.SINGLE);
		PageNavigationService.OpenChatDetailPage(chat, (PhoneApplicationPage)(object)_page);
	}

	internal void StartCall()
	{
		BuddyService.CallToBuddy(_buddy);
	}

	internal void StartText()
	{
		BuddyService.MessageToBuddy(_buddy);
	}

	internal void BlockBuddy()
	{
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
		_ssmService.BlockBuddyAsync(_buddy.PhoneNumber);
	}

	internal void ShowProfileImage()
	{
		if (_buddy.ImgStatus != Buddy.ProfileImgStatus.None && _buddy.ImgStatus != Buddy.ProfileImgStatus.Deleted)
		{
			string text = "Cache\\" + _buddy.PhoneNumber + ".jpg";
			if (Utility.IsFileExist(text))
			{
				PageNavigationService.OpenImageViewerPage((PhoneApplicationPage)(object)_page, "?source=" + text);
				return;
			}
			string param = "?profileImage=" + _buddy.PhoneNumber;
			PageNavigationService.OpenImageViewerPage((PhoneApplicationPage)(object)_page, param);
		}
	}

	internal void OpenBuddyProfile(FrameworkElement element)
	{
		BuddiesSay buddiesSay = element.DataContext as BuddiesSay;
		if (buddiesSay.PhoneNumber == RegistrationService.GetUserNumber())
		{
			return;
		}
		Buddy buddy = _buddyService.GetBuddy(buddiesSay.PhoneNumber);
		if (buddy != null)
		{
			if (buddy.IsBlocked)
			{
				SplashPopup.Show(_page.LayoutRoot, ResContainer.IDS_CHATON_POP_BUDDY_BLOCKED_TO_UNBLOCK_GO_TO_SETTINGS_BLOCK_LIST);
			}
			else
			{
				PageNavigationService.OpenBuddyProfilePage((PhoneApplicationPage)(object)_page, buddiesSay.PhoneNumber);
			}
		}
		else
		{
			AddUnknownBuddyPage.BuddyAdded += AddUnknownBuddyPage_BuddyAdded;
			PageNavigationService.OpenAddUnknownBuddyPage((PhoneApplicationPage)(object)_page, buddiesSay.PhoneNumber);
		}
	}

	private void AddUnknownBuddyPage_BuddyAdded(object sender, object arg)
	{
		foreach (Chat chatItem in _dataService.ChatItems)
		{
			_chatService.UpdateChatSummary(chatItem);
		}
	}
}
