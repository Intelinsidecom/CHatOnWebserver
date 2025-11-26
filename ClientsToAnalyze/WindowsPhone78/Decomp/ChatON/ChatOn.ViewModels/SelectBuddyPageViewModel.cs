using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class SelectBuddyPageViewModel : NotificationObject
{
	private SelectBuddyPage _page;

	private DataService _dataService;

	private BuddyService _buddyService;

	private SSMService _ssmService;

	private List<BuddyListHeader> _headerItems;

	private List<BuddySummary> _buddyItems;

	private List<BuddySummary> _tempList = new List<BuddySummary>();

	private ObservableCollection<BuddySummary> _showingItems = new ObservableCollection<BuddySummary>();

	private ObservableCollection<BuddySummary> _selectedBuddyItems;

	private List<BuddySummary> _tempList2 = new List<BuddySummary>();

	private ObservableCollection<BuddySummary> _searchResult = new ObservableCollection<BuddySummary>();

	private DispatcherTimer _normalItemsTimer;

	private DispatcherTimer _searchItemstimer;

	private string _keyword;

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

	public ObservableCollection<BuddySummary> SelectedBuddyItems
	{
		get
		{
			return _selectedBuddyItems;
		}
		set
		{
			_selectedBuddyItems = value;
			NotifyPropertyChanged(() => SelectedBuddyItems);
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

	public SelectBuddyPageViewModel(SelectBuddyPage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		if (SelectBuddyPage.ExceptionNumbers != null)
		{
			_buddyService.SetExceptionFilterlingBuddies(SelectBuddyPage.ExceptionNumbers);
			SelectBuddyPage.ExceptionNumbers = null;
		}
		_buddyService.MakeListByType(SettingService.ListByType.ByBuddies, ref _buddyItems, ref _headerItems, showBirthday: false, showGroup: true, SelectBuddyPage.IsExceptSpecialBuddies);
		foreach (BuddySummary buddyItem in _buddyItems)
		{
			if (buddyItem.Buddy != null)
			{
				buddyItem.Buddy.IsChecked = false;
			}
			_tempList.Add(buddyItem);
		}
		_selectedBuddyItems = new ObservableCollection<BuddySummary>();
		if (SelectBuddyPage.PreSelectedNumbers != null)
		{
			ReflectPreSelectedBuddies();
			SelectBuddyPage.PreSelectedNumbers = null;
		}
		_searchItemstimer = new DispatcherTimer();
		_searchItemstimer.Tick += _timer_Tick;
		_searchItemstimer.Interval = TimeSpan.FromMilliseconds(40.0);
		_keyword = "";
		_normalItemsTimer = new DispatcherTimer();
		_normalItemsTimer.Tick += _normalItemsTimer_Tick;
		_normalItemsTimer.Interval = TimeSpan.FromMilliseconds(40.0);
		_normalItemsTimer.Start();
	}

	private void _normalItemsTimer_Tick(object sender, EventArgs e)
	{
		if (_tempList.Count > 0)
		{
			BuddySummary item = _tempList.First();
			_showingItems.Add(item);
			_tempList.Remove(item);
		}
		else
		{
			_normalItemsTimer.Stop();
		}
	}

	private void _timer_Tick(object sender, EventArgs e)
	{
		if (_tempList2.Count > 0)
		{
			BuddySummary item = _tempList2.First();
			_searchResult.Add(item);
			_tempList2.Remove(item);
		}
		else
		{
			_searchItemstimer.Stop();
		}
	}

	private void ReflectPreSelectedBuddies()
	{
		string number;
		foreach (string preSelectedNumber in SelectBuddyPage.PreSelectedNumbers)
		{
			number = preSelectedNumber;
			BuddySummary buddySummary = _buddyItems.FirstOrDefault((BuddySummary c) => c.Buddy != null && c.Buddy.PhoneNumber == number);
			if (buddySummary != null)
			{
				buddySummary.Buddy.IsChecked = true;
				_selectedBuddyItems.Add(buddySummary);
			}
		}
	}

	private void MakeResultList()
	{
		_searchItemstimer.Stop();
		_searchResult.Clear();
		_tempList2.Clear();
		if (_keyword.Length > 0)
		{
			_page.SearchResultList.Visibility = Visibility.Visible;
			_page.BuddyList.Visibility = Visibility.Collapsed;
			IEnumerable<BuddySummary> enumerable = _buddyItems.Where((BuddySummary d) => d.Buddy != null && !string.IsNullOrEmpty(d.Buddy.Name) && !d.IsSpecialBuddy && d.Buddy.Name.IndexOf(_keyword, StringComparison.CurrentCultureIgnoreCase) != -1);
			foreach (BuddySummary item in enumerable)
			{
				item.Keyword = _keyword;
				_tempList2.Add(item);
			}
		}
		else
		{
			_page.SearchResultList.Visibility = Visibility.Collapsed;
			_page.BuddyList.Visibility = Visibility.Visible;
			foreach (BuddySummary buddyItem in _buddyItems)
			{
				buddyItem.Keyword = null;
			}
		}
		_searchItemstimer.Start();
	}

	internal void UpdateSelectedBuddyItems(BuddySummary sum)
	{
		if (sum.Buddy == null)
		{
			return;
		}
		if (sum.Buddy.IsChecked)
		{
			if (SelectBuddyPage.SelectionCountLimit > 0 && _selectedBuddyItems.Count >= SelectBuddyPage.SelectionCountLimit)
			{
				string iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_SELECTED = ResContainer.IDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_SELECTED;
				iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_SELECTED = iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_SELECTED.Replace("%d", "{0:d}");
				iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_SELECTED = string.Format(iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_SELECTED, SelectBuddyPage.SelectionCountLimit);
				MessageBox.Show(iDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_SELECTED);
				sum.Buddy.IsChecked = false;
			}
			else
			{
				_selectedBuddyItems.Add(sum);
				_page.SelectedBuddyList.UpdateLayout();
				_page.SelectedBuddyScroll.ScrollToHorizontalOffset(_page.SelectedBuddyScroll.ScrollableWidth);
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
}
