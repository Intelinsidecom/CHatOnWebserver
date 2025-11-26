using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using ChatON_WoA.Services;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media;

namespace ChatOn.ViewModels;

public class HiddenInteractionPageViewModel : NotificationObject
{
	private HiddenInteractionPage _page;

	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	private ObservableCollection<Buddy> _hideList;

	private List<string> _hideNumberList = new List<string>();

	private Visibility _showInfo = (Visibility)1;

	public ObservableCollection<Buddy> HideList
	{
		get
		{
			return _hideList;
		}
		set
		{
			_hideList = value;
			NotifyPropertyChanged(() => HideList);
		}
	}

	public Visibility ShowInfo
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _showInfo;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_showInfo = value;
			NotifyPropertyChanged(() => ShowInfo);
		}
	}

	public HiddenInteractionPageViewModel(HiddenInteractionPage page)
	{
		//IL_000d: Unknown result type (might be due to invalid IL or missing references)
		_page = page;
		_ssmService = new SSMService();
		_ssmService.GetInteractionHideListCompleted += _ssmService_GetInteractionHideListCompleted;
		_ssmService.SetInteractionHideCompleted += _ssmService_SetInteractionHideCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_hideList = new ObservableCollection<Buddy>();
		_ssmService.GetInteractionHideListAsync();
		_page.ShowLoading();
	}

	private void _ssmService_SetInteractionHideCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			if ((bool)e.Param)
			{
				foreach (string number in _hideNumberList)
				{
					IEnumerable<Buddy> buddyItems = _dataService.BuddyItems;
					Func<Buddy, bool> predicate = (Buddy c) => c.PhoneNumber == number;
					Buddy buddy = buddyItems.FirstOrDefault(predicate);
					if (buddy != null)
					{
						buddy.IsHideInteraction = true;
						_hideList.Add(buddy);
						InteractionRankService.Instance.HideBuddyInteractions(buddy);
					}
				}
			}
			else
			{
				foreach (string number2 in _hideNumberList)
				{
					ObservableCollection<Buddy> hideList = _hideList;
					Func<Buddy, bool> predicate2 = (Buddy c) => c.PhoneNumber == number2;
					Buddy buddy2 = hideList.FirstOrDefault(predicate2);
					if (buddy2 != null)
					{
						buddy2.IsHideInteraction = false;
						_hideList.Remove(buddy2);
						InteractionRankService.Instance.ShowBuddyInteractions(buddy2);
					}
				}
			}
			ChatOnService.Instance.ReUpdateInteraction = true;
			_dataService.BuddyDBSubmitChanges();
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
		_hideNumberList.Clear();
		if (HideList.Count() > 0)
		{
			ShowInfo = (Visibility)1;
		}
		else
		{
			ShowInfo = (Visibility)0;
		}
		ChatOnService.Instance.IsBuddiesUpdated = true;
		ChatOnService.Instance.ReUpdateInteraction = true;
		_page.CheckRemovePanelTriggerEnable();
	}

	private void _ssmService_GetInteractionHideListCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK && e.Xml != null)
		{
			_buddyService.ApplyInteractionHideListFromXml(e.Xml);
			IEnumerable<Buddy> enumerable = _dataService.BuddyItems.Where((Buddy b) => b.IsHideInteraction);
			foreach (Buddy item in enumerable)
			{
				_hideList.Add(item);
				_hideNumberList.Add(item.PhoneNumber);
			}
			HideList = new ObservableCollection<Buddy>(HideList.OrderBy((Buddy x) => x.Name));
		}
		else if (e.StatusCode != HttpStatusCode.NoContent)
		{
			SSMService.ShowCommonErrorMessage(e);
		}
		if (HideList.Count() > 0)
		{
			ShowInfo = (Visibility)1;
		}
		else
		{
			ShowInfo = (Visibility)0;
		}
		_page.CheckRemovePanelTriggerEnable();
	}

	internal void ShowBuddyInteraction(Buddy buddy)
	{
		_hideNumberList.Clear();
		_hideNumberList.Add(buddy.PhoneNumber);
		_ssmService.SetInteractionHideAsync(_hideNumberList, hide: false);
		_page.ShowLoading();
	}

	internal void OnAddHideBuddies()
	{
		_hideNumberList.Clear();
		foreach (Buddy hide in HideList)
		{
			_hideNumberList.Add(hide.PhoneNumber);
		}
		SelectBuddyPage.SelectionCountLimit = PivotPage.ActiveInstance.ViewModel.BuddyItems.Count;
		SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
		SelectBuddyPage.Mode = SelectBuddyMode.HideBuddy;
		SelectBuddyPage.ExceptionNumbers = _hideNumberList;
		SelectBuddyPage.IsExceptSpecialBuddies = true;
	}

	private void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= SelectBuddyPage_SelectionCompleted;
		ObservableCollection<BuddySummary> observableCollection = arg as ObservableCollection<BuddySummary>;
		if (observableCollection.Count() == 0)
		{
			return;
		}
		_hideNumberList.Clear();
		foreach (BuddySummary item in observableCollection)
		{
			_hideNumberList.Add(item.Buddy.PhoneNumber);
		}
		((Page)SelectBuddyPage.ActiveInstance).Frame.Navigate(typeof(SettingsPage));
		_ssmService.SetInteractionHideAsync(_hideNumberList, hide: true);
	}

	public void UnblockSelectedBuddy()
	{
		_hideNumberList.Clear();
		_page.ShowLoading();
		foreach (Buddy item in HideList.Where((Buddy x) => x.IsChecked))
		{
			_hideNumberList.Add(item.PhoneNumber);
			_ssmService.SetInteractionHideAsync(_hideNumberList, hide: false);
		}
	}

	public void CheckAllHideInteractionList()
	{
		//IL_0033: Unknown result type (might be due to invalid IL or missing references)
		//IL_003d: Expected O, but got Unknown
		foreach (Buddy hide in HideList)
		{
			hide.IsChecked = true;
			hide.Background = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
		}
	}

	public void DeleteMode()
	{
		foreach (Buddy hide in HideList)
		{
			hide.IsInteractionDeleteMode = true;
		}
	}

	public void DeleteMode(Buddy buddy)
	{
		buddy.IsInteractionDeleteMode = true;
	}

	public void DeleteModeCancel()
	{
		foreach (Buddy hide in HideList)
		{
			hide.IsInteractionDeleteMode = false;
		}
		UncheckAllBlockList();
	}

	internal void UncheckAllBlockList()
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		foreach (Buddy hide in HideList)
		{
			hide.IsChecked = false;
			hide.Background = (Brush)new SolidColorBrush(Colors.Transparent);
		}
	}
}
