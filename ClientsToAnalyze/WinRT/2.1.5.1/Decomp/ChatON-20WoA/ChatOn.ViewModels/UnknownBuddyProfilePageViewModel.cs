using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Net;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Queue;
using ChatOn.Services;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class UnknownBuddyProfilePageViewModel : NotificationObject
{
	private UnknownBuddyProfileDialog _page;

	private UnknownUser _buddy;

	private BuddyService _buddyService;

	private SSMService _ssmService;

	private DataService _dataService;

	private ChatService _chatService;

	private RegistrationService _regService;

	public Visibility btnAddVisibility { get; set; }

	public Visibility btnUnblockVisibility { get; set; }

	public UnknownUser Buddy
	{
		get
		{
			return _buddy;
		}
		set
		{
			_buddy = value;
		}
	}

	public UnknownBuddyProfilePageViewModel(UnknownBuddyProfileDialog page)
	{
		_page = page;
		_regService = new RegistrationService();
		_ssmService = new SSMService();
		_ssmService.BlockBuddyCompleted += _ssmService_BlockBuddyCompleted;
		_ssmService.AddBuddyCompleted += _ssmService_AddBuddyCompleted;
		_ssmService.UnBlockBuddyCompleted += _ssmService_UnBlockBuddyCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.ChatOnID);
	}

	private void _ssmService_BlockBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0066: Unknown result type (might be due to invalid IL or missing references)
		//IL_006c: Expected O, but got Unknown
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_buddy.IsBlocked = true;
			_buddy.SetMessage(Buddy.Name);
			_dataService.UnknownUserDBSubmitChanges();
			string text = Utility.sprintf(Utility.GetResourceString("IDS_CHATON_POP_PS_BLOCKED"), _buddy.Name);
			MessageDialog val = new MessageDialog(text);
			val.ShowAsync();
			CheckButton();
			_page.Close();
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void _ssmService_UnBlockBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			UnknownUser user = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == _buddy.PhoneNumber);
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == _buddy.PhoneNumber);
			if (user != null)
			{
				user.IsBlocked = false;
				user.SetMessage(user.Name);
				Chat chat = null;
				chat = _dataService.ChatItems.FirstOrDefault((Chat x) => x.Members.Contains(user.PhoneNumber) && !x.IsValidSession);
				if (chat != null)
				{
					chat.IsValidSession = true;
				}
			}
			if (buddy != null)
			{
				buddy.IsBlocked = false;
				Chat chat2 = null;
				chat2 = _dataService.ChatItems.FirstOrDefault((Chat x) => x.SingleChatBuddy != null && x.SingleChatBuddy.PhoneNumber == buddy.PhoneNumber && !x.IsValidSession);
				if (chat2 != null)
				{
					chat2.IsValidSession = true;
				}
			}
			_dataService.ChatDBSubmitChanges();
			_dataService.BuddyDBSubmitChanges();
			_dataService.UnknownUserDBSubmitChanges();
			SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
			ChatOnService.Instance.ReUpdateBuddyList = true;
			ChatOnService.Instance.ReUpdateInteraction = true;
			PivotPage.ActiveInstance.ViewModel.UpdateList();
			NotifyPropertyChanged(() => PivotPage.ActiveInstance.ViewModel.ChatItems);
			CheckButton();
			_page.Close();
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void BlockStroy_Completed(object sender, EventArgs e)
	{
	}

	public void OnNavigatedTo(UnknownUser buddy)
	{
		if (_buddy == null)
		{
			_buddy = buddy;
		}
		if (buddy == null)
		{
			return;
		}
		UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == buddy.PhoneNumber);
		if (unknownUser == null)
		{
			unknownUser = new UnknownUser();
			unknownUser.PhoneNumber = buddy.PhoneNumber;
			unknownUser.Name = Utility.GetResourceString("IDS_CHATON_BODY_UNKNOWN");
			_dataService.AddUnknownUser(unknownUser);
		}
		if (unknownUser.Name == Utility.GetResourceString("IDS_CHATON_BODY_UNKNOWN") && unknownUser.Name != buddy.Name)
		{
			unknownUser.Name = buddy.Name;
		}
		if (string.IsNullOrEmpty(unknownUser.Name))
		{
			unknownUser.Name = Utility.GetResourceString("IDS_CHATON_BODY_UNKNOWN");
		}
		if (buddy.IsBlocked)
		{
			unknownUser.IsBlocked = true;
		}
		Buddy = unknownUser;
		Buddy.PropertyChanged += Buddy_PropertyChanged;
		Buddy.LoadProfileImage(applyTheme: true);
		Buddy.SetMessage(unknownUser.Name);
		QueueEngine queueEngine = ((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] as QueueEngine;
		GetBuddyProfileImage_QueueItem getBuddyProfileImage_QueueItem = new GetBuddyProfileImage_QueueItem(_ssmService, Buddy.PhoneNumber);
		getBuddyProfileImage_QueueItem.InvokeBack = delegate(object o, Exception ex)
		{
			if (ex == null && o != null)
			{
				Buddy.IsDownloading = false;
				Buddy.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
				Buddy.NotifyPropertyChanged("ProfileImage");
				Buddy.ImgStatus = ChatOn.Models.Buddy.ProfileImgStatus.NoChanges;
				_dataService.UnknownUserDBSubmitChanges();
				Chat chat = PivotPage.ActiveInstance.ViewModel.ChatItems.FirstOrDefault((Chat x) => x.SingleChatBuddy != null && x.SingleChatBuddy.PhoneNumber == Buddy.PhoneNumber);
				if (chat != null)
				{
					chat.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					chat.SingleChatBuddy.ThumbProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
				}
				else
				{
					Chat chat2 = PivotPage.ActiveInstance.ViewModel.ChatItems.FirstOrDefault((Chat x) => x.MemberList.Count() == 1 && x.MemberList.FirstOrDefault() == Buddy.PhoneNumber);
					if (chat2 != null)
					{
						chat2.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					}
				}
				_dataService.ChatDBSubmitChanges();
				NotifyPropertyChanged(() => PivotPage.ActiveInstance.ViewModel.ChatItems);
				if (ChatDetailPage.ActiveInstance != null)
				{
					ChatDetailPage.ActiveInstance.ViewModel.UpdateUnknownBuddyProfile(Buddy);
				}
			}
		};
		queueEngine?.Add(getBuddyProfileImage_QueueItem);
		CheckButton();
		NotifyPropertyChanged("");
	}

	private void Buddy_PropertyChanged(object sender, PropertyChangedEventArgs e)
	{
		if (e.PropertyName.ToLower() == "isblocked" && !Buddy.IsDeregistered)
		{
			CheckButton();
		}
		if (Buddy.Status != null && Buddy.Status.Contains("\n"))
		{
			Buddy.Status = Buddy.Status.Replace("\n", " ");
		}
	}

	internal void CheckButton()
	{
		if (!Buddy.IsDeregistered)
		{
			if (Buddy.IsBlocked)
			{
				btnAddVisibility = (Visibility)1;
				btnUnblockVisibility = (Visibility)0;
				NotifyPropertyChanged("");
			}
			else
			{
				btnAddVisibility = (Visibility)0;
				btnUnblockVisibility = (Visibility)1;
				NotifyPropertyChanged("");
			}
		}
		else
		{
			btnAddVisibility = (Visibility)1;
			btnUnblockVisibility = (Visibility)1;
			NotifyPropertyChanged("");
		}
		NotifyPropertyChanged("");
	}

	internal void CheckBuddyProfile(UnknownUser buddy)
	{
		if (buddy == null)
		{
			return;
		}
		SSMService sSMService = new SSMService();
		sSMService.CheckBuddyProfileCompleted += delegate(object s, SSMCompletedEventArgs e)
		{
			if (e.StatusCode != HttpStatusCode.NoContent && e.Xml != null)
			{
				string text = _buddyService.ParseUnknownBuddyInfo(e.Xml);
				if (!string.IsNullOrEmpty(text))
				{
					buddy.CountryCode = text;
					_buddy = buddy;
					_page.AddFlagImage(buddy);
				}
				else
				{
					_page.AddWarningMessage();
				}
			}
		};
		sSMService.CheckBuddyProfileAsync(buddy.PhoneNumber);
	}

	internal void OnNavigatedFrom()
	{
	}

	internal void BlockBuddy()
	{
		_page.ShowLoading();
		_ssmService.BlockBuddyAsync(Buddy.PhoneNumber);
	}

	internal void AddBuddy(string name, string number)
	{
		_page.ShowLoading();
		_ssmService.AddBuddyAsync("+" + Buddy.PhoneNumber, isPrev: false, Buddy.Name);
	}

	internal void UnBlockBuddy()
	{
		_page.ShowLoading();
		_ssmService.UnBlockBuddyAsync(Buddy.PhoneNumber);
	}

	private async void _ssmService_AddBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (await BuddyService.ShowAddBuddyResult(e, e.Param as string))
		{
			ChatOnService.Instance.IsBuddiesUpdated = true;
			List<Buddy> list = _buddyService.AddBuddyFromXml(e.Xml);
			if (list.Count > 0)
			{
				list[0].LoadProfileImage(_ssmService.GetBuddyProfileImageUri(list[0].PhoneNumber));
			}
			PivotPage.ActiveInstance.ViewModel.UpdateList();
			try
			{
				Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_PS_ADDED").Replace("%s", list[0].Name));
			}
			catch (Exception)
			{
			}
		}
		_page.Close();
	}

	internal void AddFlagImage(Grid grid, UnknownUser user)
	{
		QueueEngine queueEngine = null;
		if (!(((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] is QueueEngine queueEngine2))
		{
			return;
		}
		GetNationalFlag_QueueItem getNationalFlag_QueueItem = new GetNationalFlag_QueueItem(_ssmService, user.CountryCode);
		getNationalFlag_QueueItem.InvokeBack = delegate(object o, Exception e)
		{
			//IL_0000: Unknown result type (might be due to invalid IL or missing references)
			//IL_0006: Expected O, but got Unknown
			Image val = new Image();
			((FrameworkElement)val).put_Margin(new Thickness(0.0, 0.0, 3.0, 3.0));
			((FrameworkElement)val).put_Width(29.0);
			((FrameworkElement)val).put_Height(20.0);
			((FrameworkElement)val).put_HorizontalAlignment((HorizontalAlignment)2);
			((FrameworkElement)val).put_VerticalAlignment((VerticalAlignment)2);
			if (o != null)
			{
				val.put_Source((ImageSource)((o is BitmapImage) ? o : null));
			}
			((ICollection<UIElement>)((Panel)grid).Children).Add((UIElement)(object)val);
			Logger.Log("Unknown Buddy Profile ViewModel -> National Flag Retreived --> w :" + ((BitmapSource)((o is BitmapImage) ? o : null)).PixelWidth + " h : " + ((BitmapSource)((o is BitmapImage) ? o : null)).PixelHeight);
		};
		queueEngine2.Add(getNationalFlag_QueueItem);
	}

	internal void AddWarningImage(Grid grid)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		//IL_0076: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Expected O, but got Unknown
		Image val = new Image();
		((FrameworkElement)val).put_Margin(new Thickness(0.0, 0.0, 3.0, 3.0));
		((FrameworkElement)val).put_Width(79.0);
		((FrameworkElement)val).put_Height(57.0);
		((FrameworkElement)val).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)val).put_VerticalAlignment((VerticalAlignment)2);
		val.put_Source((ImageSource)new BitmapImage(new Uri(new Uri("ms-appx://"), "/Images/icon_noti.png")));
		((ICollection<UIElement>)((Panel)grid).Children).Add((UIElement)(object)val);
	}
}
