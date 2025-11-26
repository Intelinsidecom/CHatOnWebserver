using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class AddUnknownBuddyPage : PhoneApplicationPage
{
	public delegate void AddUnknownBuddyPageEventHandler(object sender, object arg);

	private bool _isNew = true;

	private string _phoneNumber = "";

	private DataService _dataService;

	private SSMService _ssmService;

	internal Grid LayoutRoot;

	internal TextBlock NameTextBlock;

	internal TextBlock SubTextBlock;

	private bool _contentLoaded;

	public static event AddUnknownBuddyPageEventHandler BuddyAdded;

	public AddUnknownBuddyPage()
	{
		InitializeComponent();
		_ssmService = new SSMService();
		_ssmService.AddBuddyCompleted += ssmService_AddBuddyCompleted;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_DONE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
		_dataService = new DataService();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (queryString.ContainsKey("PhoneNumber"))
			{
				_phoneNumber = queryString["PhoneNumber"];
				UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == _phoneNumber);
				if (unknownUser != null)
				{
					NameTextBlock.Text = unknownUser.Name;
					string iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q = ResContainer.IDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q;
					iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q = iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q.Replace("%s", "{0:}");
					iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q = string.Format(iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q, unknownUser.Name);
					SubTextBlock.Text = iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q;
				}
				else
				{
					NameTextBlock.Text = ResContainer.IDS_CHATON_BODY_UNKNOWN;
					string iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q2 = ResContainer.IDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q;
					iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q2 = iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q2.Replace("%s", "{0:}");
					iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q2 = string.Format(iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q2, ResContainer.IDS_CHATON_BODY_UNKNOWN);
					SubTextBlock.Text = iDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q2;
				}
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		AddUnknownBuddyPage.BuddyAdded = null;
		((Page)this).OnNavigatedFrom(e);
	}

	protected override void OnBackKeyPress(CancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (LoadingIndicator.HandleBackKey())
		{
			e.Cancel = true;
		}
		((PhoneApplicationPage)this).OnBackKeyPress(e);
	}

	private void Save_Click(object sender, EventArgs e)
	{
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
		_ssmService.AddBuddyAsync("+" + _phoneNumber);
	}

	private void ssmService_AddBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Xml == null)
		{
			if (e.StatusCode == HttpStatusCode.NoContent)
			{
				string iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER = ResContainer.IDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER;
				iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER = iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER.Replace("%s", "{0:}");
				iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER = string.Format(iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER, _phoneNumber);
				MessageBox.Show(iDS_CHATON_POP_PS_IS_NOT_CHATON_SUBSCRIBER);
			}
			else if (!string.IsNullOrEmpty(e.ErrorMessage))
			{
				if (e.ErrorMessage.Contains("25007"))
				{
					MessageBox.Show(ResContainer.IDS_CHATON_POP_BUDDY_BLOCKED_TO_UNBLOCK_GO_TO_SETTINGS_BLOCK_LIST);
				}
				else
				{
					MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
				}
			}
			else
			{
				MessageBox.Show(ResContainer.IDS_CHATON_POP_FAILED);
			}
			return;
		}
		BuddyService buddyService = new BuddyService(_dataService, _ssmService);
		List<Buddy> list = buddyService.AddBuddyFromXml(e.Xml);
		if (list.Count > 0)
		{
			if (!list[0].LoadProfileImage())
			{
				list[0].LoadProfileImage(_ssmService.GetBuddyProfileImageUri(list[0].PhoneNumber));
			}
			if (AddUnknownBuddyPage.BuddyAdded != null)
			{
				AddUnknownBuddyPage.BuddyAdded(this, list[0]);
			}
		}
		ChatOnService.Instance.IsBuddiesUpdated = true;
		MessageBox.Show(ResContainer.IDS_CHATON_POP_ADDED_TO_BUDDY_LIST);
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void Cancel_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AddUnknownBuddyPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			NameTextBlock = (TextBlock)((FrameworkElement)this).FindName("NameTextBlock");
			SubTextBlock = (TextBlock)((FrameworkElement)this).FindName("SubTextBlock");
		}
	}
}
