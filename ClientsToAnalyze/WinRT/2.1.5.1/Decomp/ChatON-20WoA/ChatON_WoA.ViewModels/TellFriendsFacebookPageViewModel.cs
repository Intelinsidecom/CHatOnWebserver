using System.Collections.ObjectModel;
using System.Linq;
using System.Threading.Tasks;
using ChatON_WoA.Services;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml.Controls;

namespace ChatON_WoA.ViewModels;

public class TellFriendsFacebookPageViewModel : NotificationObject
{
	private TellFriendsFacebookPage _page;

	private string _userAccount;

	private ObservableCollection<FacebookUser> _friendsItems;

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

	public ObservableCollection<FacebookUser> FriendsItems
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

	public TellFriendsFacebookPageViewModel(TellFriendsFacebookPage page)
	{
		_page = page;
		_friendsItems = new ObservableCollection<FacebookUser>();
	}

	public void GetMyInformation()
	{
		UserAccount = FacebookService.UserName;
	}

	public void PostInvitationCard()
	{
		PageNavigationService.OpenInvitationPage((Page)(object)_page, isFacebookAvailable: true);
	}

	public async Task<bool> PostInvitationMessage(string receiverId)
	{
		string postMessage = Utility.GetResourceString("IDS_CHATON_POP_HI_LETS_KEEP_IN_TOUCH_USING_CHATON_SEE_YOU_THERE_MSG");
		postMessage = postMessage.Replace("\\n", "\n");
		return await FacebookService.PostMessage(receiverId, postMessage);
	}

	public async Task<FacebookServiceArgument> MakeFriendsList()
	{
		FacebookFriends result = await FacebookService.GetFriendsList();
		if (result == null || result.Friends == null)
		{
			return new FacebookServiceArgument(FacebookServiceResultType.NETWORK_ERROR);
		}
		if (result.Friends.Count() < 1)
		{
			return new FacebookServiceArgument(FacebookServiceResultType.NO_RESULT);
		}
		for (int i = 0; i < result.Friends.Count(); i++)
		{
			_friendsItems.Add(result.Friends[i]);
		}
		FriendsItems = new ObservableCollection<FacebookUser>(FriendsItems.OrderBy((FacebookUser c) => c.Name));
		return new FacebookServiceArgument(FacebookServiceResultType.SUCCESS);
	}
}
