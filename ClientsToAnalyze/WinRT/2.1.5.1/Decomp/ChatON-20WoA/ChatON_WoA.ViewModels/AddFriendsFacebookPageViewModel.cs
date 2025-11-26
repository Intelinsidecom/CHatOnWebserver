using System.Collections.ObjectModel;
using System.Linq;
using System.Threading.Tasks;
using ChatON_WoA.Services;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;

namespace ChatON_WoA.ViewModels;

public class AddFriendsFacebookPageViewModel : NotificationObject
{
	private AddFriendsFacebookPage _page;

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

	public AddFriendsFacebookPageViewModel(AddFriendsFacebookPage page)
	{
		_page = page;
		_friendsItems = new ObservableCollection<FacebookUser>();
	}

	public void GetMyInformation()
	{
		UserAccount = FacebookService.UserName;
	}

	public async Task<FacebookServiceArgument> MakeFriendsList()
	{
		FacebookFriends result = await FacebookService.GetFriendsAppList();
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
		return new FacebookServiceArgument(FacebookServiceResultType.SUCCESS);
	}
}
