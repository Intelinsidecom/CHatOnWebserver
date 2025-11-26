using ChatON_WoA.Services;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Xaml;

namespace ChatON_WoA.ViewModels;

public class ManageAccountPageViewModel : NotificationObject
{
	private ManageAccountPage _page;

	private SSMService _ssmService;

	public Visibility btnSamsungSignoutVisibility { get; set; }

	public Visibility btnSamsungSigninVisibility { get; set; }

	public Visibility btnFBSignoutVisibility { get; set; }

	public Visibility btnFBSigninVisibility { get; set; }

	public Visibility btnTwitterSignoutVisibility { get; set; }

	public Visibility btnTwitterSigninVisibility { get; set; }

	public string SamsungEmail { get; set; }

	public string FacebookName { get; set; }

	public string TwitterName { get; set; }

	public ManageAccountPageViewModel(ManageAccountPage page)
	{
		_page = page;
		CheckButton();
	}

	public void FacebookLogout()
	{
		FacebookName = "";
		SettingService.SetSignedOnToFacebook(isSignedOn: false);
		SettingService.SetFacebookAcessToken("");
		SettingService.SetFacebookEmail("");
		btnFBSigninVisibility = (Visibility)0;
		btnFBSignoutVisibility = (Visibility)1;
		NotifyPropertyChanged("");
	}

	public void TwitterLogout()
	{
		TwitterName = "";
		SettingService.SetTwitterAccountName("");
		SettingService.SetTwitterAcessToken("");
		SettingService.SetTwitterAcessTokenSecret("");
		SettingService.SetTwitterOauthVerifier("");
		SettingService.SetSignedOnTwitter(loggedinStatus: false);
		btnTwitterSigninVisibility = (Visibility)0;
		btnTwitterSignoutVisibility = (Visibility)1;
		NotifyPropertyChanged("");
	}

	public void CheckButton()
	{
		if (SettingService.GetSignedOnSamsungAccount())
		{
			btnSamsungSigninVisibility = (Visibility)1;
			btnSamsungSignoutVisibility = (Visibility)0;
			SamsungEmail = SettingService.GetSamsungEmail();
		}
		else
		{
			btnSamsungSigninVisibility = (Visibility)0;
			btnSamsungSignoutVisibility = (Visibility)1;
		}
		if (SettingService.IsSignedOnToFacebook())
		{
			btnFBSigninVisibility = (Visibility)1;
			btnFBSignoutVisibility = (Visibility)0;
			FacebookName = SettingService.GetFacebookEmail();
		}
		else
		{
			btnFBSigninVisibility = (Visibility)0;
			btnFBSignoutVisibility = (Visibility)1;
		}
		if (SettingService.GetSignedOnTwitter())
		{
			btnTwitterSigninVisibility = (Visibility)1;
			btnTwitterSignoutVisibility = (Visibility)0;
			TwitterName = SettingService.GetTwitterAccountName();
		}
		else
		{
			btnTwitterSigninVisibility = (Visibility)0;
			btnTwitterSignoutVisibility = (Visibility)1;
		}
		NotifyPropertyChanged("");
	}

	public async void SharetoFacebook(FacebookUser user)
	{
		if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_SHARE_CHATON_INVITATION_MESSAGE_Q"), showCancel: true, Utility.GetResourceString("IDS_CHATON_BUTTON_FACEBOOK")))
		{
			try
			{
				string postMessage = Utility.GetResourceString("IDS_CHATON_BODY_CHATON_INVITE_MESSAGE_ABB");
				await FacebookService.PostMessage(message: postMessage.Replace("\\n", "\n"), receiverId: user.Id);
				await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTED"), showCancel: false);
			}
			catch
			{
				Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTING_FAILED"), showCancel: false);
			}
		}
	}

	public async void SharetoTwitter()
	{
		if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_SHARE_CHATON_INVITATION_MESSAGE_Q"), showCancel: true, Utility.GetResourceString("IDS_CHATON_HEADER_TWITTER")))
		{
			try
			{
				string postMessage = Utility.GetResourceString("IDS_CHATON_BODY_CHATON_INVITE_MESSAGE_ABB");
				postMessage = postMessage.Replace("\\n", "\n");
				await TwitterService.PostMessage(postMessage);
				await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTED"), showCancel: false);
			}
			catch
			{
				Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTING_FAILED"), showCancel: false);
			}
		}
	}
}
