using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.Views;
using com.sec.ssm.common;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class SearchBuddyPageViewModel : NotificationObject
{
	private SearchBuddyPage _page;

	private List<BuddySummary> _buddyItems = new List<BuddySummary>();

	private List<BuddySummary> _tempList = new List<BuddySummary>();

	private ObservableCollection<BuddySummary> _searchResult = new ObservableCollection<BuddySummary>();

	private DispatcherTimer _searchItemstimer;

	private string _keyword;

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

	public ObservableCollection<BuddySummary> SearchResult
	{
		get
		{
			return _searchResult;
		}
		set
		{
			_searchResult = value;
		}
	}

	public string Keyword
	{
		get
		{
			return _keyword;
		}
		set
		{
			if (value != _keyword)
			{
				_keyword = value;
				MakeResultList();
			}
		}
	}

	public SearchBuddyPageViewModel(SearchBuddyPage page)
	{
		_page = page;
		_searchItemstimer = new DispatcherTimer();
		_searchItemstimer.Tick += _timer_Tick;
		_searchItemstimer.Interval = TimeSpan.FromMilliseconds(40.0);
		_keyword = "";
		UpdateBuddyList();
	}

	internal void UpdateBuddyList()
	{
		_buddyItems.Clear();
		DataService dataService = new DataService();
		IOrderedEnumerable<Buddy> orderedEnumerable = dataService.BuddyItems.OrderBy((Buddy b) => b.Name);
		foreach (Buddy item in orderedEnumerable)
		{
			BuddySummary buddySummary = new BuddySummary();
			buddySummary.Buddy = item;
			_buddyItems.Add(buddySummary);
		}
		MakeResultList();
	}

	private void _timer_Tick(object sender, EventArgs e)
	{
		if (_tempList.Count > 0)
		{
			BuddySummary item = _tempList.First();
			_searchResult.Add(item);
			_tempList.Remove(item);
		}
		else
		{
			_searchItemstimer.Stop();
		}
	}

	private void MakeResultList()
	{
		_searchItemstimer.Stop();
		_searchResult.Clear();
		_tempList.Clear();
		if (_keyword.Length > 0)
		{
			IEnumerable<BuddySummary> enumerable = _buddyItems.Where((BuddySummary d) => d.Buddy != null && !string.IsNullOrEmpty(d.Buddy.Name) && d.Buddy.Name.IndexOf(_keyword, StringComparison.CurrentCultureIgnoreCase) != -1);
			foreach (BuddySummary item in enumerable)
			{
				item.Keyword = _keyword;
				_tempList.Add(item);
			}
		}
		else
		{
			foreach (BuddySummary buddyItem in _buddyItems)
			{
				buddyItem.Keyword = null;
				_tempList.Add(buddyItem);
			}
		}
		_searchItemstimer.Start();
	}

	internal void StartChat(Buddy buddy)
	{
		SSMService ssmService = new SSMService();
		DataService dataService = new DataService();
		BuddyService buddyService = new BuddyService(dataService, ssmService);
		ChatService chatService = new ChatService(dataService, buddyService, RegistrationService.GetUserNumber());
		Chat chat = chatService.StartChat(buddy.PhoneNumber, buddy.PhoneNumber, ChatType.SINGLE);
		PageNavigationService.OpenChatDetailPage(chat, (PhoneApplicationPage)(object)_page);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}
}
