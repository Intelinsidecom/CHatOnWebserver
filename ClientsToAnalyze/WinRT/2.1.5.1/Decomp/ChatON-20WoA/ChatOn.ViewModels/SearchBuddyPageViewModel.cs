using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using ChatON_WoA.InfraStructure;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using com.sec.ssm.common;
using Windows.UI.Xaml.Controls;

namespace ChatOn.ViewModels;

public class SearchBuddyPageViewModel : NotificationObject
{
	private List<BuddySummary> _buddyItems = new List<BuddySummary>();

	private ObservableCollection<SearchResult> _searchResult = new ObservableCollection<SearchResult>();

	private ObservableCollection<BuddySummary> _selectedBuddyItems = new ObservableCollection<BuddySummary>();

	private string _keyword;

	private string _searchResultInfo;

	private DataService _dataService;

	private SSMService _ssmService;

	private BuddyService _buddyService;

	private bool _isEmptySearch;

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

	public ObservableCollection<SearchResult> SearchResult
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

	public ObservableCollection<BuddySummary> SelectedBuddyItems
	{
		get
		{
			return _selectedBuddyItems;
		}
		set
		{
			_selectedBuddyItems = value;
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
				NotifyPropertyChanged(() => IsEmptySearch);
				MakeResultList();
				NotifyPropertyChanged(() => Keyword);
				NotifyPropertyChanged(() => QueryText);
			}
		}
	}

	public bool IsEmptySearch
	{
		get
		{
			return _isEmptySearch;
		}
		set
		{
			if (value != _isEmptySearch)
			{
				_isEmptySearch = value;
				NotifyPropertyChanged("IsEmptySearch");
			}
		}
	}

	public string QueryText => '“' + _keyword + '”';

	public string SearchResultInfo
	{
		get
		{
			return _searchResultInfo;
		}
		set
		{
			if (value != _searchResultInfo)
			{
				_searchResultInfo = value;
				NotifyPropertyChanged("SearchResultInfo");
			}
		}
	}

	public SearchBuddyPageViewModel()
	{
		_dataService = new DataService();
		_ssmService = new SSMService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_keyword = "";
	}

	internal void UpdateBuddyList()
	{
		_buddyItems.Clear();
		DataService dataService = new DataService();
		IOrderedEnumerable<Buddy> orderedEnumerable = from b in dataService.BuddyItems
			where !b.IsBlocked
			orderby b.Name
			select b;
		foreach (Buddy item in orderedEnumerable)
		{
			BuddySummary buddySummary = new BuddySummary();
			buddySummary.Type = BuddySummary.ItemType.Buddy;
			buddySummary.Buddy = item;
			_buddyItems.Add(buddySummary);
		}
	}

	internal void MakeResultList()
	{
		bool isEmptySearch = string.IsNullOrWhiteSpace(_keyword);
		_searchResult.Clear();
		List<BuddySummary> list = new List<BuddySummary>();
		if (_keyword.Length > 0)
		{
			IEnumerable<BuddySummary> collection = _buddyItems.Where((BuddySummary d) => d.Buddy != null && !string.IsNullOrEmpty(d.Buddy.Name) && d.Buddy.Name.IndexOf(_keyword, StringComparison.CurrentCultureIgnoreCase) != -1 && !d.Buddy.IsSpecialBuddy);
			list.AddRange(collection);
		}
		else
		{
			list.AddRange(_buddyItems);
		}
		IEnumerable<BuddySummary> enumerable = list.IsNotSpecialBuddy();
		foreach (BuddySummary item in enumerable)
		{
			item.Keyword = _keyword;
			_searchResult.Add(new SearchResult
			{
				Name = item.Buddy.Name,
				Status = item.Buddy.Status,
				ProfileImage = item.Buddy.ProfileImage,
				IsEmptySearch = isEmptySearch,
				BuddySummary = item
			});
		}
		UpdateSearchResultInfoCount();
	}

	public void UpdateSearchResultInfoCount()
	{
		if (SearchResult.Count > 0)
		{
			string resourceString = Utility.GetResourceString("GS_P1SD_RESULT_FOR_P2SS");
			SearchResultInfo = resourceString.Replace("%1$d", SearchResult.Count.ToString()).Replace("%2$s", _keyword);
		}
		else
		{
			SearchResultInfo = string.Format("{0} \"{1}\"", new object[2]
			{
				Utility.GetResourceString("IDS_CHATON_SEARCH_RESULT_NOT_FOUND"),
				_keyword
			});
		}
	}

	public void OnSearch()
	{
		if (_buddyItems.Count == 0)
		{
			UpdateBuddyList();
		}
		MakeResultList();
	}

	public void AddSelectedBuddy(BuddySummary addedBuddy)
	{
		if ((SelectBuddyPage.SelectionCountLimit <= 0 || _selectedBuddyItems.Count < SelectBuddyPage.SelectionCountLimit) && !_selectedBuddyItems.Contains(addedBuddy) && _selectedBuddyItems.FirstOrDefault((BuddySummary c) => c.Buddy != null && c.Buddy.PhoneNumber == addedBuddy.Buddy.PhoneNumber) == null)
		{
			SelectedBuddyItems.Add(addedBuddy);
		}
	}

	internal void RemoveSelectedBuddy(BuddySummary item)
	{
		SelectedBuddyItems.Remove(item);
	}

	internal void StartChat()
	{
		OpenChat();
	}

	private void OpenChat(ChatType chatType = ChatType.SINGLE)
	{
		if (SelectedBuddyItems.Count == 0)
		{
			return;
		}
		List<string> list = new List<string>();
		foreach (BuddySummary selectedBuddyItem in SelectedBuddyItems)
		{
			list.Add(selectedBuddyItem.Buddy.PhoneNumber);
		}
		string member = string.Join(",", list);
		string chatOnID = RegistrationService.ChatOnID;
		ChatService chatService = new ChatService(_dataService, _buddyService, chatOnID);
		if (chatType == ChatType.SINGLE && list.Count() > 1)
		{
			chatType = ChatType.GROUP;
		}
		Chat chat = chatService.StartChat(disconnect: false, list[0], member, chatType);
		PivotPage.ActiveInstance.OpenChat(chat);
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(PivotPage));
	}

	public void StartBroadcast()
	{
		OpenChat(ChatType.BROADCAST);
	}
}
