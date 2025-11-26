using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using ChatON_WoA.DataModel;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Models;
using ChatOn.Services;

namespace ChatON_WoA.ViewModels;

public class MyPageViewModel
{
	private MyPage _page;

	private InteractionRank _interactionToHide;

	private SSMService _ssmService;

	private DataService _dataService;

	private ObservableCollection<BuddiesSay> _tempList = new ObservableCollection<BuddiesSay>();

	private BuddyService _buddyService;

	public MyPageViewModel(MyPage myPage)
	{
		_page = myPage;
		_dataService = new DataService();
		_ssmService = new SSMService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_ssmService.SetInteractionHideCompleted += _ssmService_SetInteractionHideCompleted;
		_ssmService.GetMemoListCompleted += _ssmService_GetMemoListCompleted;
	}

	private void _ssmService_GetMemoListCompleted(object sender, SSMCompletedEventArgs e)
	{
		bool isBlind = true;
		if (e.StatusCode != HttpStatusCode.OK || e.Xml == null)
		{
			return;
		}
		_tempList.Clear();
		_tempList = _buddyService.ParseMemoFromXml(e.Xml, out isBlind);
		foreach (BuddiesSay item in _tempList)
		{
			ObservableCollection<BuddiesSay> memoList = PivotPage.ActiveInstance.ViewModel.MemoList;
			Func<BuddiesSay, bool> predicate = (BuddiesSay x) => x.Name == item.Name && x.Message == item.Message && x.TimeStamp == item.TimeStamp;
			if (memoList.FirstOrDefault(predicate) == null)
			{
				PivotPage.ActiveInstance.ViewModel.MemoList.Add(item);
			}
		}
		PivotPage.ActiveInstance.ViewModel.MemoList = (ObservableCollection<BuddiesSay>)PivotPage.ActiveInstance.ViewModel.MemoList.OrderByDescending((BuddiesSay x) => x.TimeStamp);
		PivotPage.ActiveInstance.ViewModel.NotifyMemoList();
	}

	private void _ssmService_SetInteractionHideCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			IEnumerable<InteractionRank> enumerable = _dataService.InteractionRanks.Where((InteractionRank x) => x.BuddyPhoneNumber == _interactionToHide.Buddy.PhoneNumber);
			foreach (InteractionRank item in enumerable)
			{
				item.Hide();
			}
			_interactionToHide.Buddy.IsHideInteraction = true;
			_interactionToHide = null;
			_dataService.BuddyDBSubmitChanges();
			_dataService.InteractionRankDBSubmitChanges();
			_dataService.UnknownUserDBSubmitChanges();
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	internal void HideInteraction(InteractionRank interaction)
	{
		_interactionToHide = interaction;
		_ssmService.SetInteractionHideAsync(interaction.Buddy.PhoneNumber, hide: true);
		_page.ShowLoading();
	}

	internal void LoadMore(string timestamp)
	{
		string chatOnID = RegistrationService.ChatOnID;
		_ssmService.GetMemoListAsync(chatOnID, timestamp);
	}
}
