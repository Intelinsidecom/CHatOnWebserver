using System;
using System.Collections.ObjectModel;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.Services;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatON_WoA.ViewModels;

public class TellFriendsTwitterPageViewModel : NotificationObject
{
	private TellFriendsTwitterPage _page;

	private DispatcherTimer _timer;

	private string _userAccount;

	private ObservableCollection<TwitterUser> _tempfriendsItems = new ObservableCollection<TwitterUser>();

	private ObservableCollection<TwitterUser> _friendsItems;

	public string UserAccount
	{
		get
		{
			return _userAccount;
		}
		set
		{
			_userAccount = value;
			NotifyPropertyChanged(() => UserAccount);
		}
	}

	public TwitterUser MyTwitter { get; set; }

	public ObservableCollection<TwitterUser> FriendsItems
	{
		get
		{
			return _friendsItems;
		}
		set
		{
			_friendsItems = value;
			NotifyPropertyChanged(() => FriendsItems);
		}
	}

	public unsafe TellFriendsTwitterPageViewModel(TellFriendsTwitterPage page)
	{
		//IL_0019: Unknown result type (might be due to invalid IL or missing references)
		//IL_0023: Expected O, but got Unknown
		_page = page;
		_timer = new DispatcherTimer();
		DispatcherTimer timer = _timer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.remove_Tick)), _timer_Tick);
		_timer.put_Interval(TimeSpan.FromMilliseconds(20.0));
		if (_friendsItems == null || _friendsItems.Count == 0)
		{
			_friendsItems = new ObservableCollection<TwitterUser>();
		}
	}

	private void _timer_Tick(object sender, object e)
	{
		if (_tempfriendsItems.Count > 0)
		{
			TwitterUser item = _tempfriendsItems.First();
			_friendsItems.Add(item);
			_tempfriendsItems.Remove(item);
			return;
		}
		FriendsItems = new ObservableCollection<TwitterUser>(FriendsItems.OrderBy((TwitterUser c) => c.Name));
		NotifyPropertyChanged(() => FriendsItems);
		_timer.Stop();
	}

	public void GetMyInformation()
	{
		UserAccount = SettingService.GetTwitterAccountName();
	}

	public void PostInvitationCard()
	{
		PageNavigationService.OpenInvitationTwitterPage((Page)(object)_page, isTwitterAvailable: true);
	}

	public void PostInvitationCard(string friends)
	{
		PageNavigationService.OpenInvitationTwitterPage((Page)(object)_page, friends);
	}

	public async Task<bool> PostInvitationMessage(string receiverId)
	{
		return await TwitterService.PostMessage(receiverId);
	}

	public async Task<bool> PostInvitationMessage()
	{
		string postMessage = Utility.GetResourceString("IDS_CHATON_BODY_CHATON_INVITE_MESSAGE_ABB");
		postMessage = postMessage.Replace("\\n", "\n");
		return await TwitterService.PostMessage(postMessage);
	}

	internal async void LoadMyInformation()
	{
		MyTwitter = await TwitterService.GetMyInformation();
		NotifyPropertyChanged(() => MyTwitter);
	}

	public async Task<TwitterServiceArgument> MakeFriendsList()
	{
		string cursor = "-1";
		int loop = 0;
		_tempfriendsItems.Clear();
		do
		{
			TwitterFriends result = await TwitterService.GetFriendsList(cursor);
			if (result == null || result.Friends == null)
			{
				if (_tempfriendsItems.Count > 0)
				{
					_timer.Start();
				}
				return new TwitterServiceArgument(TwitterServiceResultType.NETWORK_ERROR);
			}
			if (result.Friends.Count() < 1)
			{
				return new TwitterServiceArgument(TwitterServiceResultType.NO_RESULT);
			}
			for (int i = 0; i < result.Friends.Count(); i++)
			{
				_tempfriendsItems.Add(result.Friends[i]);
			}
			cursor = result.NextCursor;
			loop++;
			await Task.Delay(500);
		}
		while (loop < 10);
		_timer.Start();
		return new TwitterServiceArgument(TwitterServiceResultType.SUCCESS);
	}
}
