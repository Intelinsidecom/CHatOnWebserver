using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Xml.Linq;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using com.sec.ssm.common;
using Windows.UI;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media;

namespace ChatOn.ViewModels;

public class BlockListPageViewModel : NotificationObject
{
	private BlockListPage _page;

	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	private ObservableCollection<BlockBuddyInfo> _blockedList = new ObservableCollection<BlockBuddyInfo>();

	private List<BlockBuddyInfo> _buddiesToUnblock;

	private List<string> _blockedNumberList = new List<string>();

	private bool _isDeleteMode;

	private ChatService _chatService;

	public ObservableCollection<BlockBuddyInfo> BlockedList
	{
		get
		{
			return _blockedList;
		}
		set
		{
			_blockedList = value;
			NotifyPropertyChanged(() => BlockedList);
		}
	}

	public bool IsDeleteMode
	{
		get
		{
			return _isDeleteMode;
		}
		set
		{
			_isDeleteMode = value;
			NotifyPropertyChanged(() => IsDeleteMode);
		}
	}

	public BlockListPageViewModel(BlockListPage page)
	{
		_page = page;
		_buddiesToUnblock = new List<BlockBuddyInfo>();
		_ssmService = new SSMService();
		_ssmService.UnBlockBuddyCompleted += _ssmService_UnBlockBuddyCompleted;
		_ssmService.BlockBuddyListCompleted += _ssmService_BlockBuddyListCompleted;
		_ssmService.GetBlockListCompleted += _ssmService_GetBlockListCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.ChatOnID);
		LoadBlockList();
	}

	internal void LoadBlockList()
	{
		SettingsPage.ActiveInstance.ShowLoading();
		_ssmService.GetBlockBuddyListAsync();
	}

	private async void _ssmService_GetBlockListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			BlockedList = _buddyService.ParseBlockListFromXml(e.Xml);
			BlockedList = new ObservableCollection<BlockBuddyInfo>(BlockedList.OrderBy((BlockBuddyInfo x) => x.Name));
			DeletePartialBlocked();
			_page.OnBlockBudyUpdated();
		}
		else if (e.StatusCode != HttpStatusCode.NoContent)
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			DeleteAllBlocked();
			_page.OnBlockBudyUpdated();
		}
		_page.CheckRemovePanelTriggerEnable();
	}

	internal void DeleteAllBlocked()
	{
		List<Buddy> list = _dataService.BuddyItems.Where((Buddy p) => p.IsBlocked).ToList();
		foreach (Buddy buddy in list)
		{
			IEnumerable<Buddy> buddyItems = _dataService.BuddyItems;
			Func<Buddy, bool> predicate = (Buddy c) => c.PhoneNumber == buddy.PhoneNumber;
			buddyItems.FirstOrDefault(predicate);
			UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == buddy.PhoneNumber);
			if (unknownUser != null)
			{
				unknownUser.IsBlocked = false;
			}
			if (buddy != null)
			{
				buddy.IsBlocked = false;
				buddy.IsNew = true;
			}
		}
		_dataService.BuddyDBSubmitChanges();
		_dataService.UnknownUserDBSubmitChanges();
	}

	internal void DeletePartialBlocked()
	{
		List<Buddy> list = _dataService.BuddyItems.Where((Buddy p) => p.IsBlocked).ToList();
		foreach (Buddy buddy in list)
		{
			ObservableCollection<BlockBuddyInfo> blockedList = BlockedList;
			Func<BlockBuddyInfo, bool> predicate = (BlockBuddyInfo c) => c.Number == buddy.PhoneNumber;
			if (blockedList.FirstOrDefault(predicate) == null)
			{
				_dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == buddy.PhoneNumber);
				UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == buddy.PhoneNumber);
				if (unknownUser != null)
				{
					unknownUser.IsBlocked = false;
				}
				if (buddy != null)
				{
					buddy.IsBlocked = false;
					buddy.IsNew = true;
				}
			}
		}
		_dataService.BuddyDBSubmitChanges();
		_dataService.UnknownUserDBSubmitChanges();
	}

	private async void _ssmService_BlockBuddyListCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			foreach (string number in _blockedNumberList)
			{
				IEnumerable<Buddy> buddyItems = _dataService.BuddyItems;
				Func<Buddy, bool> predicate = (Buddy c) => c.PhoneNumber == number;
				Buddy buddy = buddyItems.FirstOrDefault(predicate);
				if (buddy != null)
				{
					buddy.IsBlocked = true;
					BlockBuddyInfo blockBuddyInfo = new BlockBuddyInfo();
					blockBuddyInfo.Name = buddy.Name;
					blockBuddyInfo.Number = buddy.PhoneNumber;
					blockBuddyInfo.ProfileImageUri = _ssmService.GetBuddyProfileImageUri(buddy.PhoneNumber);
					blockBuddyInfo.ProfileImage = buddy.ProfileImage;
					PivotPage.ActiveInstance.ViewModel.RemoveBuddyFromShowingItems(buddy);
					_buddyService.BlockBuddy(buddy);
					_chatService.HandleBlockBuddy(buddy);
					_blockedList.Add(blockBuddyInfo);
				}
			}
			LoadingIndicator.StopLoading();
			_dataService.BuddyDBSubmitChanges();
			ChatOnService.Instance.IsBuddiesUpdated = true;
			ChatOnService.Instance.ReUpdateInteraction = true;
			PivotPage.ActiveInstance.ViewModel.UpdateList();
			_page.OnBlockBudyUpdated();
		}
		else
		{
			await SSMService.ShowCommonErrorMessage(e);
			LoadingIndicator.StopLoading();
		}
	}

	private async void _ssmService_UnBlockBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			XDocument unblockResponse = XDocument.Parse(e.ResultString);
			string unblockBuddyNumber = _buddyService.GetBuddyIdFromUnblockResponse(unblockResponse);
			BlockBuddyInfo item = _buddiesToUnblock.FirstOrDefault((BlockBuddyInfo x) => x.Number == unblockBuddyNumber);
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == unblockBuddyNumber);
			UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == unblockBuddyNumber);
			if (unknownUser != null)
			{
				unknownUser.IsBlocked = false;
			}
			if (buddy != null)
			{
				buddy.IsBlocked = false;
				buddy.IsNew = true;
			}
			Chat chat = _dataService.ChatItems.FirstOrDefault((Chat x) => ((x.SingleChatBuddy != null && x.SingleChatBuddy.PhoneNumber == unblockBuddyNumber) || (x.ChatType == ChatType.SINGLE && x.Members.Contains(unblockBuddyNumber))) && !x.IsValidSession);
			if (chat != null)
			{
				chat.IsValidSession = true;
			}
			PivotPage.ActiveInstance.ViewModel.UpdateList();
			_dataService.ChatDBSubmitChanges();
			_blockedList.Remove(item);
			_buddiesToUnblock.Remove(item);
			_dataService.BuddyDBSubmitChanges();
			_dataService.UnknownUserDBSubmitChanges();
			SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
			ChatOnService.Instance.ReUpdateBuddyList = true;
			ChatOnService.Instance.ReUpdateInteraction = true;
			_page.OnBlockBudyUpdated();
			_page.EnableRemoveButton();
			_page.CheckRemovePanelTriggerEnable();
		}
		else
		{
			await SSMService.ShowCommonErrorMessage(e);
			LoadingIndicator.StopLoading();
		}
	}

	internal void OnAddBlockBuddies()
	{
		_blockedNumberList.Clear();
		foreach (BlockBuddyInfo blocked in _blockedList)
		{
			_blockedNumberList.Add(blocked.Number);
		}
		SelectBuddyPage.Mode = SelectBuddyMode.BlockBuddy;
		SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
		SelectBuddyPage.ExceptionNumbers = _blockedNumberList;
		SelectBuddyPage.SelectionCountLimit = PivotPage.ActiveInstance.ViewModel.BuddyItems.Count;
		SelectBuddyPage.IsExceptSpecialBuddies = true;
	}

	private void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= SelectBuddyPage_SelectionCompleted;
		ObservableCollection<BuddySummary> observableCollection = arg as ObservableCollection<BuddySummary>;
		if (observableCollection.Count() == 0)
		{
			if (sender is SelectBuddyPage)
			{
				((Page)(sender as SelectBuddyPage)).Frame.GoBack();
			}
			return;
		}
		_blockedNumberList.Clear();
		foreach (BuddySummary item in observableCollection)
		{
			_blockedNumberList.Add(item.Buddy.PhoneNumber);
		}
		((Page)SelectBuddyPage.ActiveInstance).Frame.Navigate(typeof(SettingsPage));
		_page.ShowLoading();
		_ssmService.BlockBuddyListAsync(_blockedNumberList, isBlock: true);
	}

	public async void UnblockSelectedBuddy()
	{
		List<BlockBuddyInfo> toBlockBuddies = BlockedList.Where((BlockBuddyInfo x) => x.IsChecked).ToList();
		if (toBlockBuddies.Count == 0)
		{
			return;
		}
		_page.ShowLoading();
		foreach (BlockBuddyInfo blockBuddyInfo in toBlockBuddies)
		{
			_buddiesToUnblock.Add(blockBuddyInfo);
			await _ssmService.UnBlockBuddyAsync(blockBuddyInfo.Number);
		}
		LoadingIndicator.StopLoading();
		PivotPage.ActiveInstance.ViewModel.UpdateList();
	}

	public void CheckAllBlockList()
	{
		//IL_0033: Unknown result type (might be due to invalid IL or missing references)
		//IL_003d: Expected O, but got Unknown
		foreach (BlockBuddyInfo blocked in BlockedList)
		{
			blocked.IsChecked = true;
			blocked.Background = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
		}
	}

	public void DeleteMode()
	{
		foreach (BlockBuddyInfo blocked in BlockedList)
		{
			blocked.IsDeleteMode = true;
		}
	}

	public void DeleteModeCancel()
	{
		foreach (BlockBuddyInfo blocked in BlockedList)
		{
			blocked.IsDeleteMode = false;
		}
		UncheckAllBlockList();
	}

	internal void UncheckAllBlockList()
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		foreach (BlockBuddyInfo blocked in BlockedList)
		{
			blocked.IsChecked = false;
			blocked.Background = new SolidColorBrush(Colors.Transparent);
		}
	}
}
