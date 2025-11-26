using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Windows;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using com.sec.ssm.common;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class GroupProfilePageViewModel : NotificationObject
{
	private GroupProfilePage _page;

	private BuddyGroup _group;

	private string _membersCountText;

	private IOrderedEnumerable<Buddy> _memberList;

	private List<Buddy> _tempList = new List<Buddy>();

	private ObservableCollection<Buddy> _displayItems = new ObservableCollection<Buddy>();

	private DataService _dataService;

	private DispatcherTimer _timer;

	public BuddyGroup Group
	{
		get
		{
			return _group;
		}
		set
		{
			_group = value;
			NotifyPropertyChanged(() => Group);
		}
	}

	public string MembersCountText
	{
		get
		{
			return _membersCountText;
		}
		set
		{
			_membersCountText = value;
			NotifyPropertyChanged(() => MembersCountText);
		}
	}

	public ObservableCollection<Buddy> DisplayItems
	{
		get
		{
			return _displayItems;
		}
		set
		{
			_displayItems = value;
		}
	}

	public GroupProfilePageViewModel(GroupProfilePage page)
	{
		_page = page;
		_dataService = new DataService();
	}

	internal void OpenGroupInfo(Guid id)
	{
		Group = _dataService.BuddyGroups.FirstOrDefault((BuddyGroup g) => g.GroupID == id);
		_timer = new DispatcherTimer();
		_timer.Tick += _timer_Tick;
		_timer.Interval = TimeSpan.FromMilliseconds(40.0);
		UpdateBuddyList();
	}

	internal void UpdateBuddyList()
	{
		string members = _group.Members;
		string[] members2 = Utility.Split(members);
		IOrderedEnumerable<Buddy> orderedEnumerable = (_memberList = from b in _dataService.BuddyItems
			where members2.Contains(b.PhoneNumber)
			orderby b.Name
			select b);
		string iDS_CHATON_BODY_PD_BUDDIES = ResContainer.IDS_CHATON_BODY_PD_BUDDIES;
		iDS_CHATON_BODY_PD_BUDDIES = iDS_CHATON_BODY_PD_BUDDIES.Replace("%d", "{0:d}");
		MembersCountText = string.Format(iDS_CHATON_BODY_PD_BUDDIES, orderedEnumerable.Count());
		foreach (Buddy item in orderedEnumerable)
		{
			_tempList.Add(item);
		}
		_displayItems.Clear();
		_timer.Start();
		if (orderedEnumerable.Count() == 0)
		{
			_page.BroadcastButton.IsEnabled = false;
			_page.ChatButton.IsEnabled = false;
		}
		else
		{
			_page.BroadcastButton.IsEnabled = true;
			_page.ChatButton.IsEnabled = true;
		}
	}

	private void _timer_Tick(object sender, EventArgs e)
	{
		if (_tempList.Count > 0)
		{
			Buddy item = _tempList.First();
			_displayItems.Add(item);
			_tempList.Remove(item);
		}
		else
		{
			_timer.Stop();
		}
	}

	internal void StartChat(ChatType type)
	{
		SSMService ssmService = new SSMService();
		BuddyService buddyService = new BuddyService(_dataService, ssmService);
		string userNumber = RegistrationService.GetUserNumber();
		ChatService chatService = new ChatService(_dataService, buddyService, userNumber);
		Chat chat = chatService.StartChat(_displayItems[0].PhoneNumber, _group.Members, type);
		PageNavigationService.OpenChatDetailPage(chat, (PhoneApplicationPage)(object)_page);
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)_page);
		_page.LayoutRoot.Children.Add(value);
	}

	internal void EditMembers()
	{
		string[] collection = Utility.Split(_group.Members);
		List<string> preSelectedNumbers = new List<string>(collection);
		SelectBuddyPage.PreSelectedNumbers = preSelectedNumbers;
		SelectBuddyPage.IsReturnAllMode = true;
		SelectBuddyPage.IsExceptSpecialBuddies = true;
		SelectBuddyPage.SelectionCountLimit = ChatService.MAX_CHAT_MEMBERS - 1;
		SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
		PageNavigationService.OpenSelectBuddyPage((PhoneApplicationPage)(object)_page);
	}

	private void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
		List<BuddySummary> list = arg as List<BuddySummary>;
		List<Buddy> list2 = new List<Buddy>();
		foreach (BuddySummary item in list)
		{
			if (item.Buddy != null && item.Buddy.IsChecked)
			{
				list2.Add(item.Buddy);
			}
		}
		bool flag = false;
		if (list2.Count() == _memberList.Count())
		{
			Buddy buddy;
			foreach (Buddy item2 in list2)
			{
				buddy = item2;
				Buddy buddy2 = _memberList.FirstOrDefault((Buddy b) => b.PhoneNumber == buddy.PhoneNumber);
				if (buddy2 == null)
				{
					flag = true;
					break;
				}
			}
		}
		else
		{
			flag = true;
		}
		if (!flag)
		{
			return;
		}
		List<string> list3 = new List<string>();
		foreach (Buddy item3 in list2)
		{
			list3.Add(item3.PhoneNumber);
		}
		_group.Members = string.Join(",", list3);
		_dataService.SubmitChanges();
		UpdateBuddyList();
	}

	internal void DeleteGroup()
	{
		if (MessageBoxResult.OK == MessageBox.Show(ResContainer.IDS_CHATON_POP_GROUP_WILL_BE_DELETED, ResContainer.IDS_CHATON_BUTTON_DELETE_GROUP, MessageBoxButton.OKCancel))
		{
			_dataService.DeleteGroup(_group);
			ChatOnService.Instance.IsBuddiesUpdated = true;
			Utility.SafetyGoBack((PhoneApplicationPage)(object)_page);
		}
	}

	internal void Rename()
	{
		PageNavigationService.OpenAddGroupPage((PhoneApplicationPage)(object)_page, _group.GroupID.ToString());
	}
}
