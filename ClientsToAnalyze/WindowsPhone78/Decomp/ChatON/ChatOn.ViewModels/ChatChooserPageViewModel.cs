using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using com.sec.ssm.common;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class ChatChooserPageViewModel : NotificationObject
{
	private ChatChooserPage _page;

	private SSMService _ssmService;

	private BuddyService _buddyService;

	private ChatService _chatService;

	private DataService _dataService;

	private List<BuddySummary> _buddyItems;

	private List<BuddySummary> _tempList = new List<BuddySummary>();

	private ObservableCollection<BuddySummary> _showingItems = new ObservableCollection<BuddySummary>();

	private CollectionViewSource _chatItems = new CollectionViewSource();

	private List<BuddyListHeader> _headerItems;

	private DispatcherTimer _timer;

	private ListIndexSelector _selector;

	public List<BuddySummary> BuddyItems
	{
		get
		{
			return _buddyItems;
		}
		set
		{
			_buddyItems = value;
		}
	}

	public ObservableCollection<BuddySummary> ShowingItems
	{
		get
		{
			return _showingItems;
		}
		set
		{
			_showingItems = value;
		}
	}

	public CollectionViewSource ChatItems
	{
		get
		{
			return _chatItems;
		}
		set
		{
			_chatItems = value;
		}
	}

	public ChatChooserPageViewModel(ChatChooserPage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.GetUserNumber());
		_chatService.UpdateAllChatSummary();
		_chatItems.Source = _dataService.ChatItems;
		_chatItems.SortDescriptions.Add(new SortDescription("Date", ListSortDirection.Descending));
		LoadBuddiesData();
		_timer = new DispatcherTimer();
		_timer.Tick += _timer_Tick;
		_timer.Interval = TimeSpan.FromMilliseconds(40.0);
	}

	internal void UpdateList()
	{
		_showingItems.Clear();
		_buddyService.MakeListByType(SettingService.ListByType.ByBuddies, ref _buddyItems, ref _headerItems, IsoSettingHelper.Get("ShowBirthday", defaultValue: true), showGroup: false);
		_tempList.Clear();
		foreach (BuddySummary buddyItem in _buddyItems)
		{
			_tempList.Add(buddyItem);
		}
		_timer.Start();
	}

	private void _timer_Tick(object sender, EventArgs e)
	{
		if (_tempList.Count > 0)
		{
			BuddySummary item = _tempList.First();
			_showingItems.Add(item);
			_tempList.Remove(item);
		}
		else
		{
			_timer.Stop();
		}
	}

	internal void ShowIndexSelector()
	{
		if (_selector != null)
		{
			_selector.IndexSource = _headerItems;
			_selector.Open();
			return;
		}
		ListIndexSelector listIndexSelector = new ListIndexSelector((PhoneApplicationPage)(object)_page);
		listIndexSelector.IndexSource = _headerItems;
		ListIndexSelector listIndexSelector2 = listIndexSelector;
		listIndexSelector2.IndexSelected += selector_IndexSelected;
		listIndexSelector2.Open();
		_page.LayoutRoot.Children.Add(listIndexSelector2);
		_selector = listIndexSelector2;
	}

	private void selector_IndexSelected(object sender, object e)
	{
		BuddyListHeader buddyListHeader = e as BuddyListHeader;
		ScrollViewer scrollViewer = Utility.GetScrollViewer(_page.BuddyList);
		scrollViewer.ScrollToVerticalOffset(buddyListHeader.Index);
	}

	internal void LoadBuddiesData()
	{
		_buddyService.LoadBuddiesProfileImage();
	}

	internal void StartChat(Buddy buddy)
	{
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
		Chat chat = _chatService.StartChat(buddy.PhoneNumber, buddy.PhoneNumber, ChatType.SINGLE);
		PageNavigationService.OpenChatDetailPage(chat, (PhoneApplicationPage)(object)_page);
	}
}
