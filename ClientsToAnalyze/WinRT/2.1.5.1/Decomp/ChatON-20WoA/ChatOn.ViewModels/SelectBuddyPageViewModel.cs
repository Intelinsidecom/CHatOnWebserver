using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.DataModel;
using ChatON_WoA.InfraStructure;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.ApplicationModel.Search;
using Windows.Foundation;
using Windows.UI.Xaml.Controls;

namespace ChatOn.ViewModels;

public class SelectBuddyPageViewModel : NotificationObject
{
	private SelectBuddyPage _page;

	private DataService _dataService;

	private BuddyService _buddyService;

	private SSMService _ssmService;

	private ObservableCollection<BuddyListHeader> _headerItems;

	private List<BuddySummary> _buddyItems;

	private ObservableCollection<BuddySummary> _showingItems = new ObservableCollection<BuddySummary>();

	private ObservableCollection<BuddySummary> _selectedBuddyItems;

	private ObservableCollection<BuddySummary> _searchResult = new ObservableCollection<BuddySummary>();

	private string _keyword;

	private SearchPane _searchPane;

	private SelectBuddyModel _selectBuddyModel;

	public int TotalBuddyMember { get; set; }

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

	public SelectBuddyModel SelectBuddyModel => _selectBuddyModel;

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
				NotifyPropertyChanged(() => Keyword);
				ReinitilizeHandler();
				MakeResultList();
			}
		}
	}

	public ObservableCollection<BuddyListHeader> HeaderItems
	{
		get
		{
			return _headerItems;
		}
		set
		{
			_headerItems = value;
			NotifyPropertyChanged(() => HeaderItems);
		}
	}

	public SelectBuddyPageViewModel(SelectBuddyPage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_selectBuddyModel = SelectBuddyModel.Instance;
		if (SelectBuddyPage.ExceptionNumbers != null)
		{
			_buddyService.SetExceptionFilterlingBuddies(SelectBuddyPage.ExceptionNumbers);
			SelectBuddyPage.ExceptionNumbers = null;
		}
		_buddyService.MakeListByType(SettingService.ListByType.ByBuddies, ref _buddyItems, ref _headerItems, showBirthday: false, showGroup: true, SelectBuddyPage.IsExceptSpecialBuddies, includeMe: false);
		IEnumerable<BuddySummary> enumerable = _buddyItems.Where((BuddySummary x) => x.HeaderType == BuddyListHeaderType.Normal || x.HeaderType == BuddyListHeaderType.Group || x.HeaderType == BuddyListHeaderType.Favorite);
		for (int num = 0; num < _headerItems.Count(); num++)
		{
			if (_headerItems[num].HeaderType == BuddyListHeaderType.New)
			{
				_headerItems.RemoveAt(num);
				num--;
			}
		}
		foreach (BuddySummary item in enumerable)
		{
			_showingItems.Add(item);
		}
		IOrderedEnumerable<Buddy> source = from d in _dataService.BuddyItems
			where !d.IsBlocked && !d.IsSpecialBuddy && d.PhoneNumber.Substring(0, 4) != "0999"
			orderby d.Name
			select d;
		if (SelectBuddyPage.Mode == SelectBuddyMode.RemoveMember || SelectBuddyPage.Mode == SelectBuddyMode.AddMember)
		{
			TotalBuddyMember = _showingItems.Where((BuddySummary x) => x.Type != BuddySummary.ItemType.Index).ToList().Count;
		}
		else
		{
			TotalBuddyMember = source.Count();
		}
		NotifyPropertyChanged(() => TotalBuddyMember);
		_selectedBuddyItems = new ObservableCollection<BuddySummary>();
	}

	internal void ReinitilizeHandler()
	{
		if (SelectBuddyPage.Mode == SelectBuddyMode.StartChat)
		{
			if (PivotPage.ActiveInstance != null)
			{
				PivotPage.ActiveInstance.ViewModel.OnStartChat();
			}
		}
		else if (SelectBuddyPage.Mode == SelectBuddyMode.StartBroadcast)
		{
			if (PivotPage.ActiveInstance != null)
			{
				PivotPage.ActiveInstance.ViewModel.OnStartBroadcast();
			}
		}
		else if (SelectBuddyPage.Mode == SelectBuddyMode.BlockBuddy)
		{
			if (BlockListPage.ActiveInstance != null)
			{
				BlockListPage.ActiveInstance.ViewModel.OnAddBlockBuddies();
			}
		}
		else if (SelectBuddyPage.Mode == SelectBuddyMode.InviteBuddy)
		{
			if (ChatDetailPage.ActiveInstance != null)
			{
				ChatDetailPage.ActiveInstance.ViewModel.InviteBuddies();
			}
		}
		else if (SelectBuddyPage.Mode == SelectBuddyMode.HideBuddy)
		{
			if (HiddenInteractionPage.ActiveInstance != null)
			{
				HiddenInteractionPage.ActiveInstance.ViewModel.OnAddHideBuddies();
			}
		}
		else if (SelectBuddyPage.Mode == SelectBuddyMode.RemoveMember)
		{
			if (GroupProfileDialog.ActiveInstance != null)
			{
				GroupProfileDialog.ActiveInstance.ViewModel.RemoveMembers();
			}
		}
		else if (SelectBuddyPage.Mode == SelectBuddyMode.AddMember)
		{
			if (GroupProfileDialog.ActiveInstance != null)
			{
				GroupProfileDialog.ActiveInstance.ViewModel.AddMembers();
			}
		}
		else if (SelectBuddyPage.Mode == SelectBuddyMode.BlockBuddySay && BlindListPage.ActiveInstance != null)
		{
			BlindListPage.ActiveInstance._viewModel.OnAddBlindBuddies();
		}
	}

	public unsafe void ActivateSearchPane()
	{
		if (_searchPane == null)
		{
			_searchPane = SearchPane.GetForCurrentView();
			SearchPane searchPane = _searchPane;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<SearchPane, SearchPaneSuggestionsRequestedEventArgs>, EventRegistrationToken>(searchPane, (nint)__ldftn(SearchPane.add_SuggestionsRequested)), new Action<EventRegistrationToken>(searchPane, (nint)__ldftn(SearchPane.remove_SuggestionsRequested)), _searchPane_SuggestionsRequested);
			SearchPane searchPane2 = _searchPane;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<SearchPane, SearchPaneQuerySubmittedEventArgs>, EventRegistrationToken>(searchPane2, (nint)__ldftn(SearchPane.add_QuerySubmitted)), new Action<EventRegistrationToken>(searchPane2, (nint)__ldftn(SearchPane.remove_QuerySubmitted)), _searchPane_QuerySubmitted);
		}
	}

	private unsafe void _searchPane_QuerySubmitted(SearchPane sender, SearchPaneQuerySubmittedEventArgs args)
	{
		WindowsRuntimeMarshal.RemoveEventHandler<TypedEventHandler<SearchPane, SearchPaneQuerySubmittedEventArgs>>(new Action<EventRegistrationToken>(_searchPane, (nint)__ldftn(SearchPane.remove_QuerySubmitted)), _searchPane_QuerySubmitted);
		if (!string.IsNullOrEmpty(args.QueryText))
		{
			Keyword = args.QueryText;
			((Page)_page).Frame.Navigate(typeof(SelectBuddyPage), (object)args.QueryText);
		}
	}

	private unsafe void _searchPane_SuggestionsRequested(SearchPane sender, SearchPaneSuggestionsRequestedEventArgs args)
	{
		WindowsRuntimeMarshal.RemoveEventHandler<TypedEventHandler<SearchPane, SearchPaneSuggestionsRequestedEventArgs>>(new Action<EventRegistrationToken>(_searchPane, (nint)__ldftn(SearchPane.remove_SuggestionsRequested)), _searchPane_SuggestionsRequested);
		foreach (Buddy buddyItem in _dataService.BuddyItems)
		{
			if (!string.IsNullOrEmpty(buddyItem.Name))
			{
				if (buddyItem.Name.IndexOf(sender.QueryText, StringComparison.CurrentCultureIgnoreCase) != -1)
				{
					args.Request.SearchSuggestionCollection.AppendQuerySuggestion(buddyItem.Name);
				}
				if (args.Request.SearchSuggestionCollection.Size >= 5)
				{
					break;
				}
			}
		}
	}

	public void MakeResultList()
	{
		if (_keyword.Length > 0)
		{
			List<BuddySummary> list = _buddyItems.Where((BuddySummary d) => d.Buddy != null && !string.IsNullOrEmpty(d.Buddy.Name) && d.Buddy.Name.IndexOf(_keyword, StringComparison.CurrentCultureIgnoreCase) != -1 && !d.Buddy.IsSpecialBuddy).DistinctBy((BuddySummary x) => x.Buddy.PhoneNumber).ToList();
			_page.ClearSelectionBegin();
			_showingItems.Clear();
			_page.ClearSelectionEnd();
			for (int num = 0; num < list.Count(); num++)
			{
				if (!_showingItems.Contains(list[num]))
				{
					_showingItems.Add(list[num]);
				}
			}
		}
		NotifyPropertyChanged(() => ShowingItems);
		_page.UpdateSelectionTitleCount();
	}

	internal void UpdateSelectedBuddyItems(BuddySummary sum)
	{
		if (sum.Buddy == null)
		{
			return;
		}
		if (sum.Buddy.IsChecked)
		{
			if (SelectBuddyPage.SelectionCountLimit > 0 && _selectedBuddyItems.Count <= SelectBuddyPage.SelectionCountLimit)
			{
				sum.Buddy.IsChecked = false;
			}
			else if (!_selectedBuddyItems.Contains(sum) && _selectedBuddyItems.FirstOrDefault((BuddySummary c) => c.Buddy != null && c.Buddy.PhoneNumber == sum.Buddy.PhoneNumber) == null)
			{
				sum.Buddy.IsChecked = true;
				_selectedBuddyItems.Add(sum);
			}
			return;
		}
		for (int num = _selectedBuddyItems.Count - 1; num >= 0; num--)
		{
			if (_selectedBuddyItems[num].Buddy != null && _selectedBuddyItems[num].Buddy.BuddyID == sum.Buddy.BuddyID)
			{
				_selectedBuddyItems.RemoveAt(num);
			}
		}
	}

	public void AddSelectedBuddy(BuddySummary addedBuddy)
	{
		_selectBuddyModel.Add(addedBuddy);
	}

	internal void RemoveSelectedBuddy(BuddySummary item)
	{
		_selectBuddyModel.Remove(item);
	}

	internal void AddSelectedBuddyList(IEnumerable<BuddySummary> selectedBuddies)
	{
		SelectBuddyModel.Add(selectedBuddies);
	}

	internal void ClearSelectedBuddy()
	{
		_selectBuddyModel.ClearSelectedBuddy();
	}

	internal List<BuddySummary> AddSelectedGroup(BuddySummary item)
	{
		return _selectBuddyModel.AddSelectedGroup(item, _showingItems);
	}
}
