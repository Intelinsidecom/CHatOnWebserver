using System.Net;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml.Controls;

namespace ChatON_WoA.ViewModels;

public class SplashScreenPageViewModel : NotificationObject
{
	private SSMService _ssmService;

	private BuddyService _buddyService;

	private ChatService _chatService;

	private DataService _dataService;

	private Page page;

	private int _valueProgressBar;

	private string _textProgressBar;

	public int ValueProgressBar
	{
		get
		{
			return _valueProgressBar;
		}
		set
		{
			_valueProgressBar = value;
			NotifyPropertyChanged(() => ValueProgressBar);
		}
	}

	public string TextProgressBar
	{
		get
		{
			return _textProgressBar;
		}
		set
		{
			_textProgressBar = value;
			NotifyPropertyChanged(() => TextProgressBar);
		}
	}

	public SplashScreenPageViewModel(Page _page)
	{
		page = _page;
		_dataService = new DataService();
		_ssmService = new SSMService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.ChatOnID);
		_ssmService.GetChatListInfoCompleted += _ssmService_GetChatListInfoCompleted;
		_ssmService.GetBuddyCompleted += _ssmService_GetBuddyCompleted;
		_ssmService.GetVersionCompleted += _ssmService_GetVersionCompleted;
		StartSplashScreen();
	}

	private async void StartSplashScreen()
	{
		UpdateSplashScreen(Utility.GetResourceString("IDS_CHATON_BODY_PREPARING_CHATON_ING"), 0);
		await Task.Delay(100);
		UpdateSplashScreen(Utility.GetResourceString("IDS_CHATON_BODY_CHECKING_FOR_NEW_VERSIONS_ING"), 10);
		_ssmService.GetVersionAsync(forceUpdate: false);
	}

	private void UpdateSplashScreen(string text, int value)
	{
		ValueProgressBar = value;
		TextProgressBar = text;
	}

	private async void FinishSplashScreen()
	{
		ValueProgressBar = 100;
		await Task.Delay(100);
		PageNavigationService.OpenPivotPage(page);
	}

	internal void GetUnreadMessage()
	{
		_ssmService.GetUnReadMessageListAsync();
	}

	private void _ssmService_GetVersionCompleted(object sender, SSMCompletedEventArgs e)
	{
		_ssmService.GetVersionCompleted -= _ssmService_GetVersionCompleted;
		SSMServer serverInfo = SSMService.GetServerInfo();
		if (string.IsNullOrEmpty(serverInfo.Key))
		{
			_ssmService.GetVersionCompleted += _ssmService_GetVersionCompleted;
			_ssmService.GetVersionAsync(forceUpdate: false);
		}
		_ssmService.GetBuddyListAsync();
	}

	private void _ssmService_GetBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Xml != null)
		{
			_buddyService.AddBuddyFromXml(e.Xml);
		}
		_ssmService.GetChatListInfoAsync();
		UpdateSplashScreen(Utility.GetResourceString("IDS_CHATON_BODY_SYNCING_YOUR_BUDDY_LIST_ING"), 75);
	}

	private void _ssmService_GetChatListInfoCompleted(object sender, SSMCompletedEventArgs e)
	{
		UpdateSplashScreen(Utility.GetResourceString("IDS_CHATON_BODY_SYNCING_YOUR_BUDDY_LIST_ING"), 85);
		if (e.StatusCode == HttpStatusCode.OK)
		{
			if (e.Xml != null)
			{
				_chatService.ApplyChatInfoAllusingJoinTime(e.Xml);
			}
			FinishSplashScreen();
		}
		else
		{
			FinishSplashScreen();
		}
	}

	public void OnNavigatingFrom()
	{
		try
		{
			_ssmService.GetChatListInfoCompleted -= _ssmService_GetChatListInfoCompleted;
			_ssmService.GetBuddyCompleted -= _ssmService_GetBuddyCompleted;
			_ssmService.GetVersionCompleted -= _ssmService_GetVersionCompleted;
		}
		catch
		{
		}
	}
}
