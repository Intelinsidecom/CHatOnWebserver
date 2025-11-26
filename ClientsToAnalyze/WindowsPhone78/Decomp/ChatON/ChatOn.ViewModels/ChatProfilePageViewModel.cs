using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.Views;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class ChatProfilePageViewModel : NotificationObject
{
	private ChatProfilePage _page;

	private SSMService _ssmService;

	private BuddyService _buddyService;

	private ChatService _chatService;

	private DataService _dataService;

	private Chat _chat;

	private List<ChatBuddy> _buddyItems = new List<ChatBuddy>();

	private List<ChatBuddy> _tempList = new List<ChatBuddy>();

	private ObservableCollection<ChatBuddy> _showingItems = new ObservableCollection<ChatBuddy>();

	private DispatcherTimer _timer;

	public ObservableCollection<ChatBuddy> ShowingItems
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

	public ChatProfilePageViewModel(ChatProfilePage page)
	{
		_page = page;
		_ssmService = new SSMService();
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.GetUserNumber());
		_timer = new DispatcherTimer();
		_timer.Tick += _timer_Tick;
		_timer.Interval = TimeSpan.FromMilliseconds(40.0);
	}

	internal void UpdateChatBuddies(Guid id)
	{
		_chat = _dataService.GetChat(id);
		string member;
		foreach (string member2 in _chat.MemberList)
		{
			member = member2;
			ChatBuddy chatBuddy = new ChatBuddy();
			chatBuddy.PhoneNumber = member;
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == member);
			if (buddy != null)
			{
				chatBuddy.Buddy = buddy;
				chatBuddy.Name = buddy.Name;
			}
			else
			{
				UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == member);
				if (unknownUser != null)
				{
					chatBuddy.Name = unknownUser.Name;
				}
				else
				{
					chatBuddy.Name = ResContainer.IDS_CHATON_BODY_UNKNOWN;
				}
			}
			_buddyItems.Add(chatBuddy);
		}
		string text = ResContainer.IDS_CHATON_HEADER_CHAT_PROFILE_HPD.ToUpper();
		text = text.Replace("%D", "{0:d}");
		_page.ApplicationTitle.Text = string.Format(text, _buddyItems.Count);
		_buddyItems.Sort((ChatBuddy m2, ChatBuddy m1) => m2.Name.CompareTo(m1.Name));
		_showingItems.Clear();
		_tempList.Clear();
		foreach (ChatBuddy buddyItem in _buddyItems)
		{
			_tempList.Add(buddyItem);
		}
		_timer.Start();
	}

	private void _timer_Tick(object sender, EventArgs e)
	{
		if (_tempList.Count > 0)
		{
			ChatBuddy item = _tempList.First();
			_showingItems.Add(item);
			_tempList.Remove(item);
		}
		else
		{
			_timer.Stop();
		}
	}

	internal void OpenBuddyProfile(ChatBuddy member)
	{
		if (member.Buddy != null)
		{
			if (member.Buddy.IsBlocked)
			{
				SplashPopup.Show(_page.LayoutRoot, ResContainer.IDS_CHATON_POP_BUDDY_BLOCKED_TO_UNBLOCK_GO_TO_SETTINGS_BLOCK_LIST);
			}
			else
			{
				PageNavigationService.OpenBuddyProfilePage((PhoneApplicationPage)(object)_page, member.PhoneNumber);
			}
		}
		else
		{
			AddUnknownBuddyPage.BuddyAdded += AddUnknownBuddyPage_BuddyAdded;
			PageNavigationService.OpenAddUnknownBuddyPage((PhoneApplicationPage)(object)_page, member.PhoneNumber);
		}
	}

	private void AddUnknownBuddyPage_BuddyAdded(object sender, object arg)
	{
		Buddy buddy = arg as Buddy;
		foreach (Message messageItem in _chat.MessageItems)
		{
			if (buddy.PhoneNumber == messageItem.Sender)
			{
				messageItem.NotifySenderUpdated();
			}
		}
		_chatService.UpdateChatSummary(_chat);
		ChatBuddy chatBuddy = _showingItems.FirstOrDefault((ChatBuddy c) => c.PhoneNumber == buddy.PhoneNumber);
		chatBuddy.Buddy = buddy;
	}
}
