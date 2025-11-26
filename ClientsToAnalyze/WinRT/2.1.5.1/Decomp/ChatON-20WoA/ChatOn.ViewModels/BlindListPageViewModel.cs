using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media;

namespace ChatOn.ViewModels;

public class BlindListPageViewModel : NotificationObject
{
	private BlindListPage _page;

	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	private ObservableCollection<Buddy> _blindList;

	private List<string> _blindNumberList;

	private Buddy _buddyToShow;

	private ObservableCollection<BuddySummary> _buddiesToBlind;

	private List<BuddySummary> _tempBuddies;

	private bool _deleteRunning;

	private int _totalBuddy;

	public ObservableCollection<Buddy> BlindList
	{
		get
		{
			return _blindList;
		}
		set
		{
			_blindList = value;
			NotifyPropertyChanged(() => BlindList);
		}
	}

	public BlindListPageViewModel(BlindListPage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_ssmService.GetBlindListCompleted += _ssmService_GetBlindListCompleted;
		_ssmService.UploadBlindListCompleted += _ssmService_UploadBlindListCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_blindList = new ObservableCollection<Buddy>();
		_tempBuddies = new List<BuddySummary>();
		_ssmService.GetBlindListAsync();
	}

	private async void _ssmService_UploadBlindListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode != HttpStatusCode.OK)
		{
			LoadingIndicator.StopLoading();
			await SSMService.ShowCommonErrorMessage(e);
			return;
		}
		if (_deleteRunning)
		{
			List<string> list = new List<string>();
			foreach (string selectedBlindNumber in _blindNumberList)
			{
				ObservableCollection<Buddy> blindList = BlindList;
				Func<Buddy, bool> predicate = (Buddy x) => x.PhoneNumber == selectedBlindNumber;
				Buddy buddy = blindList.FirstOrDefault(predicate);
				if (buddy != null)
				{
					BlindList.Remove(buddy);
					list.Add(buddy.PhoneNumber);
				}
			}
			foreach (string item in list)
			{
				_blindNumberList.Remove(item);
			}
			if (BlindList.Count == 0 && PrivacyPage.ActiveInstance != null)
			{
				PrivacyPage.ActiveInstance.ToggleNoBlindList(isOn: true);
				SSMService.SaveBuddySayBlindSetting(isBlind: true);
			}
			_deleteRunning = false;
		}
		else
		{
			foreach (BuddySummary tempBuddy in _tempBuddies)
			{
				_blindList.Add(tempBuddy.Buddy);
				_blindNumberList.Add(tempBuddy.Buddy.PhoneNumber);
			}
			IOrderedEnumerable<Buddy> source = from d in _dataService.BuddyItems
				where !d.IsBlocked && !d.IsSpecialBuddy && d.PhoneNumber.Substring(0, 4) != "0999"
				orderby d.Name
				select d;
			_totalBuddy = source.Count();
			if (BlindList.Count == _totalBuddy && PrivacyPage.ActiveInstance != null)
			{
				PrivacyPage.ActiveInstance.ToggleNoBlindList(isOn: false);
				SSMService.SaveBuddySayBlindSetting(isBlind: false);
			}
		}
		_page.CheckRemovePanelTriggerEnable();
		NotifyPropertyChanged(() => BlindList);
	}

	private async void _ssmService_GetBlindListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if ((e.Error != null && e.StatusCode != HttpStatusCode.NoContent) || e.Xml == null)
		{
			await SSMService.ShowCommonErrorMessage(e);
			return;
		}
		_blindNumberList = _buddyService.ParseBlindListFromXml(e.Xml);
		bool isNull = _blindNumberList.Count == 0;
		foreach (string number in _blindNumberList)
		{
			IEnumerable<Buddy> buddyItems = _dataService.BuddyItems;
			Func<Buddy, bool> predicate = (Buddy c) => c.PhoneNumber == number;
			Buddy item = buddyItems.FirstOrDefault(predicate);
			_blindList.Add(item);
		}
		PrivacyPage.ActiveInstance.ToggleNoBlindList(isNull);
		_page.CheckRemovePanelTriggerEnable();
	}

	internal void OnAddBlindBuddies()
	{
		SelectBuddyPage.Mode = SelectBuddyMode.BlockBuddySay;
		SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
		foreach (Buddy blind in BlindList)
		{
			_blindNumberList.Add(blind.PhoneNumber);
		}
		SelectBuddyPage.ExceptionNumbers = _blindNumberList;
		SelectBuddyPage.IsExceptSpecialBuddies = true;
	}

	private void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= SelectBuddyPage_SelectionCompleted;
		_buddiesToBlind = arg as ObservableCollection<BuddySummary>;
		_tempBuddies = _buddiesToBlind.ToList();
		string xmlString = SSMService.MakeBlindListParam(_buddiesToBlind);
		((Page)SelectBuddyPage.ActiveInstance).Frame.GoBack();
		_ssmService.UploadBlindListAsync(xmlString);
	}

	internal void RemoveFromBlindList(Buddy buddy)
	{
		_page.ShowLoading();
		_buddyToShow = buddy;
		string xmlString = SSMService.MakeBlindListParam(buddy.PhoneNumber, isBlind: false);
		_ssmService.UploadBlindListAsync(xmlString);
	}

	public void DeleteMode()
	{
		foreach (Buddy blind in BlindList)
		{
			blind.IsInteractionDeleteMode = true;
		}
	}

	public void DeleteModeCancel()
	{
		foreach (Buddy blind in BlindList)
		{
			blind.IsInteractionDeleteMode = false;
		}
		UncheckAllBlockList();
	}

	internal void UncheckAllBlockList()
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		foreach (Buddy blind in BlindList)
		{
			blind.IsChecked = false;
			blind.Background = (Brush)new SolidColorBrush(Colors.Transparent);
		}
	}

	public void CheckAllBlindList()
	{
		//IL_0033: Unknown result type (might be due to invalid IL or missing references)
		//IL_003d: Expected O, but got Unknown
		foreach (Buddy blind in BlindList)
		{
			blind.IsChecked = true;
			blind.Background = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
		}
	}

	public void UnblockSelectedBlindList()
	{
		_page.ShowLoading();
		_blindNumberList.Clear();
		IEnumerable<string> collection = from x in BlindList
			where x.IsChecked
			select x.PhoneNumber;
		_blindNumberList.AddRange(collection);
		string xmlString = SSMService.MakeBlindListParam(_blindNumberList, isBlind: false);
		_deleteRunning = true;
		_ssmService.UploadBlindListAsync(xmlString);
	}
}
