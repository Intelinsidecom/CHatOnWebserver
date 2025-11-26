using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using ChatON_WoA.DataModel;
using ChatON_WoA.Services;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.InfraStructure;
using ChatOn.Models;
using ChatOn.Queue;
using ChatOn.Services;
using com.sec.ssm.common;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.StartScreen;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class BuddyProfilePageViewModel : NotificationObject
{
	private BuddyProfileDialog _page;

	private Buddy _buddy;

	private InteractionRank _interactionRank;

	private ObservableCollection<InteractionRank> _interactionRanks = new ObservableCollection<InteractionRank>();

	private string _birthDay;

	private bool _orgBuddyFavoriteValue;

	private BuddyService _buddyService;

	private SSMService _ssmService;

	private DataService _dataService;

	private ChatService _chatService;

	private RegistrationService _regService;

	private ObservableCollection<BuddiesSay> _memoList;

	private int _iViewMemoList;

	private Visibility _editNameVisibility = (Visibility)1;

	private bool _isAddPostOnEnable;

	private int CountBuddyList;

	private Visibility _isShowLoadingBuddySay;

	private ObservableCollection<BuddiesSay> _memoListAll;

	private ObservableCollection<BuddiesSay> _tempList = new ObservableCollection<BuddiesSay>();

	private bool IsBlockProcess;

	public Visibility IsShowLoadingBuddySay
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _isShowLoadingBuddySay;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_isShowLoadingBuddySay = value;
			NotifyPropertyChanged(() => IsShowLoadingBuddySay);
		}
	}

	public Visibility isShowFavorite
	{
		get
		{
			if (_buddy != null)
			{
				if (!Buddy.IsBlocked)
				{
					return (Visibility)0;
				}
				return (Visibility)1;
			}
			return (Visibility)0;
		}
	}

	public Visibility EditNameVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _editNameVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_editNameVisibility = value;
			NotifyPropertyChanged(() => EditNameVisibility);
			NotifyPropertyChanged(() => ShowNameVisibility);
			NotifyPropertyChanged(() => IsCloseEnabled);
		}
	}

	public Visibility ShowNameVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			if ((int)_editNameVisibility == 0)
			{
				return (Visibility)1;
			}
			return (Visibility)0;
		}
	}

	public bool IsCloseEnabled => (int)_editNameVisibility != 0;

	public DelegateCommand LoadMoreCommand { get; set; }

	public ObservableCollection<BuddiesSay> MemoList
	{
		get
		{
			return _memoList;
		}
		set
		{
			_memoList = value;
			NotifyPropertyChanged(() => MemoList);
		}
	}

	public ObservableCollection<BuddiesSay> MemoListAll
	{
		get
		{
			return _memoListAll;
		}
		set
		{
			_memoListAll = value;
			NotifyPropertyChanged(() => MemoListAll);
		}
	}

	public Buddy Buddy
	{
		get
		{
			return _buddy;
		}
		set
		{
			_buddy = value;
			NotifyPropertyChanged(() => Buddy);
		}
	}

	public string BirthDay
	{
		get
		{
			if (Buddy == null)
			{
				return "";
			}
			string birthday = Buddy.Birthday;
			if (string.IsNullOrWhiteSpace(birthday))
			{
				return "";
			}
			try
			{
				string[] array = birthday.Split('-');
				if (array.Length > 2)
				{
					return DateTime.Parse(birthday).ToString("d MMM, yyyy");
				}
				return DateTime.Parse(birthday).ToString("d MMM");
			}
			catch (Exception)
			{
				return "";
			}
		}
	}

	public InteractionRank InteractionRank
	{
		get
		{
			return _interactionRank;
		}
		set
		{
			_interactionRank = value;
			NotifyPropertyChanged(() => InteractionRank);
		}
	}

	public bool IsAddPostOnEnable
	{
		get
		{
			return _isAddPostOnEnable;
		}
		set
		{
			_isAddPostOnEnable = value;
			NotifyPropertyChanged(() => IsAddPostOnEnable);
		}
	}

	public int iViewMemoList
	{
		get
		{
			return _iViewMemoList;
		}
		set
		{
			_iViewMemoList = value;
		}
	}

	public Visibility ViewContactGridVisibility
	{
		get
		{
			//IL_0013: Unknown result type (might be due to invalid IL or missing references)
			if (_buddy.IsShowPhoneNumber && (int)_buddy.OrgPhoneNumberVisible == 0)
			{
				if (string.IsNullOrEmpty(_buddy.OrgNumber))
				{
					if (string.IsNullOrEmpty(_buddy.PhoneNumber))
					{
						if (_buddy.PhoneNumberList.Count <= 0)
						{
							return (Visibility)1;
						}
						return (Visibility)0;
					}
					return (Visibility)0;
				}
				return (Visibility)0;
			}
			if (_buddy.IsShowPhoneNumber)
			{
				if (_buddy.PhoneNumberList.Count <= 0)
				{
					return (Visibility)1;
				}
				return (Visibility)0;
			}
			return (Visibility)1;
		}
	}

	public BuddyProfilePageViewModel(BuddyProfileDialog page)
	{
		//IL_000d: Unknown result type (might be due to invalid IL or missing references)
		_page = page;
		_regService = new RegistrationService();
		_ssmService = new SSMService();
		_ssmService.GetMemoListCompleted += _ssmService_GetMemoListCompleted;
		_ssmService.DeleteMemoCompleted += _ssmService_DeleteMemoCompleted;
		_ssmService.BlockBuddyCompleted += _ssmService_BlockBuddyCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.ChatOnID);
		MemoList = new ObservableCollection<BuddiesSay>();
	}

	private async void _ssmService_BlockBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		IsBlockProcess = false;
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_buddyService.BlockBuddy(_buddy);
			ChatOnService.Instance.IsBuddiesUpdated = true;
			ChatOnService.Instance.ReUpdateInteraction = true;
			PivotPage.ActiveInstance.ViewModel.RemoveBuddyFromShowingItems(_buddy);
			_chatService.HandleBlockBuddy(_buddy);
			PivotPage.ActiveInstance.ViewModel.UpdateList();
			string msg = Utility.sprintf(Utility.GetResourceString("IDS_CHATON_POP_PS_BLOCKED"), _buddy.Name);
			MessageDialog dialog = new MessageDialog(msg);
			try
			{
				await dialog.ShowAsync();
			}
			catch (Exception)
			{
			}
			_page.Close();
		}
		else
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void BlockStroy_Completed(object sender, EventArgs e)
	{
	}

	private async void _ssmService_DeleteMemoCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error != null)
		{
			MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"));
			await dialog.ShowAsync();
			return;
		}
		long timeStamp = (long)e.Value;
		BuddiesSay memo = MemoList.FirstOrDefault((BuddiesSay c) => c.TimeStamp == timeStamp);
		if (memo != null)
		{
			MemoList.Remove(memo);
		}
	}

	private async void _ssmService_GetMemoListCompleted(object sender, SSMCompletedEventArgs e)
	{
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)async delegate
		{
			while (LoadingIndicator.ActiveIndicator != null && (object)((Page)PivotPage.ActiveInstance).Frame.CurrentSourcePageType != typeof(ImageViewer))
			{
				LoadingIndicator.StopLoading();
			}
			bool isBlind = true;
			if (e.StatusCode != HttpStatusCode.NoContent)
			{
				if (e.StatusCode != HttpStatusCode.OK || e.Xml == null)
				{
					await SSMService.ShowCommonErrorMessage(e);
				}
				else
				{
					_tempList.Clear();
					_tempList = _buddyService.ParseMemoFromXml(e.Xml, out isBlind);
					foreach (BuddiesSay item in _tempList)
					{
						ObservableCollection<BuddiesSay> memoList = MemoList;
						Func<BuddiesSay, bool> predicate = (BuddiesSay x) => x.PhoneNumber == item.PhoneNumber && x.Message == item.Message && x.TimeStamp == item.TimeStamp;
						if (memoList.FirstOrDefault(predicate) == null)
						{
							if (item.PhoneNumber == RegistrationService.ChatOnID)
							{
								item.Name = Utility.GetResourceString("IDS_CHATON_BODY_ME");
							}
							item.Message = item.Message;
							MemoList.Add(item);
						}
					}
					MemoList = new ObservableCollection<BuddiesSay>(MemoList.OrderByDescending((BuddiesSay x) => x.TimeStamp));
					IEnumerable<string> source = MemoList.Select((BuddiesSay x) => x.PhoneNumber).Distinct();
					_ssmService.CheckBuddySayProfileCompleted += _ssmService_CheckBuddySayProfileCompleted;
					for (int num = 0; num < source.Count(); num++)
					{
						_ssmService.CheckBuddySayProfileAsync(source.ElementAt(num));
					}
					NotifyPropertyChanged("");
				}
				if (MemoList.Count == 0)
				{
					Buddy.IsBlindText = true;
				}
				else
				{
					_buddy.IsBlindText = false;
				}
				Buddy.IsBlind = isBlind;
				IsAddPostOnEnable = !isBlind;
				_page.CheckBuddySayVisibility(Buddy.IsBlind);
			}
		});
	}

	private void _ssmService_CheckBuddySayProfileCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.NoContent || e.Xml == null)
		{
			return;
		}
		Buddy buddyFromNumber = GetBuddyFromNumber(e.ResultString);
		Buddy buddyInfo = _buddyService.ParseCheckBuddyInfos(e.Xml, buddyFromNumber);
		switch (buddyInfo.ImgStatus)
		{
		case Buddy.ProfileImgStatus.None:
			buddyInfo.IsDownloading = false;
			buddyInfo.ProfileImage = null;
			buddyInfo.ThumbProfileImage = null;
			buddyInfo.NotifyPropertyChanged("");
			_dataService.BuddyDBSubmitChanges();
			break;
		case Buddy.ProfileImgStatus.Deleted:
			buddyInfo.IsDownloading = false;
			buddyInfo.ProfileImage = null;
			buddyInfo.ThumbProfileImage = null;
			buddyInfo.NotifyPropertyChanged("");
			_dataService.BuddyDBSubmitChanges();
			break;
		case Buddy.ProfileImgStatus.Updated:
		{
			QueueEngine queueEngine = ((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] as QueueEngine;
			GetBuddyProfileImage_QueueItem getBuddyProfileImage_QueueItem = new GetBuddyProfileImage_QueueItem(_ssmService, buddyInfo.PhoneNumber);
			getBuddyProfileImage_QueueItem.InvokeBack = delegate(object o, Exception ex)
			{
				if (ex == null && o != null)
				{
					buddyInfo.IsDownloading = false;
					buddyInfo.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					buddyInfo.ThumbProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					buddyInfo.NotifyPropertyChanged("ProfileImage");
					buddyInfo.ImgStatus = Buddy.ProfileImgStatus.NoChanges;
					buddyInfo.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
					_dataService.BuddyDBSubmitChanges();
					UpdateBuddyProfileImage(buddyInfo);
				}
			};
			queueEngine?.Add(getBuddyProfileImage_QueueItem);
			break;
		}
		case Buddy.ProfileImgStatus.NoChanges:
			break;
		}
	}

	internal Buddy GetBuddyFromNumber(string number)
	{
		return _buddyService.GetBuddy(number);
	}

	public void UpdateBuddyProfileImage(Buddy buddy)
	{
		PivotPage.ActiveInstance.ViewModel.NotifyMemoList();
		PivotPage.ActiveInstance.ViewModel.UpdateMessageList(buddy);
	}

	public async void OnNavigatedTo(Buddy buddy)
	{
		if (buddy != null)
		{
			Buddy = buddy;
			NotifyPropertyChanged(() => BirthDay);
			NotifyPropertyChanged(() => isShowFavorite);
			InteractionRank = InteractionRankService.Instance.GetBuddyInteraction(buddy);
			_orgBuddyFavoriteValue = _buddy.IsFavorite;
			Utility.GetResourceString("IDS_CHATON_BODY_PS_DOES_NOT_USE_BUDDIES_SAY");
			_page.CheckInteraction(_buddy.IsBlind);
			UpdateMemoList();
			UpdateProfileImage(buddy);
		}
	}

	private void UpdateProfileImage(Buddy buddy)
	{
		_ssmService.CheckBuddyProfileCompleted += delegate(object s, SSMCompletedEventArgs e)
		{
			//IL_00d1: Unknown result type (might be due to invalid IL or missing references)
			//IL_00db: Expected O, but got Unknown
			//IL_00eb: Unknown result type (might be due to invalid IL or missing references)
			//IL_00f5: Expected O, but got Unknown
			if (e.StatusCode != HttpStatusCode.NoContent && e.Xml != null)
			{
				Buddy buddy2 = _buddyService.ParseCheckBuddyInfos(e.Xml, buddy);
				_page.BuddyInfo = buddy2;
				if (buddy2.ImgStatus != Buddy.ProfileImgStatus.Deleted)
				{
					QueueEngine queueEngine = ((IDictionary<object, object>)Application.Current.Resources)[(object)"QueueEngine"] as QueueEngine;
					GetBuddyProfileImage_QueueItem item = new GetBuddyProfileImage_QueueItem(_ssmService, buddy.PhoneNumber)
					{
						InvokeBack = delegate(object o, Exception ex)
						{
							if (ex == null && o != null)
							{
								buddy.IsDownloading = false;
								buddy.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
								buddy.ThumbProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
								buddy.NotifyPropertyChanged("ProfileImage");
								buddy.ImgStatus = Buddy.ProfileImgStatus.NoChanges;
								buddy.ProfileImage = (BitmapImage)((o is BitmapImage) ? o : null);
								_dataService.BuddyDBSubmitChanges();
								PivotPage.ActiveInstance.ViewModel.NotifyMemoList();
								if (ChatDetailPage.ActiveInstance != null)
								{
									ChatDetailPage.ActiveInstance.ViewModel.UpdateBuddyProfile(buddy);
								}
								if (MyPage.ActiveInstance != null)
								{
									MyPage.ActiveInstance.UpdateBuddyProfileImage(buddy);
								}
							}
						}
					};
					queueEngine?.Add(item);
				}
				else if (buddy2.ImgStatus == Buddy.ProfileImgStatus.Deleted)
				{
					buddy.IsDownloading = false;
					buddy.ProfileImage = new BitmapImage(new Uri("ms-appx:///Images/chat_info_single.png"));
					buddy.ThumbProfileImage = new BitmapImage(new Uri("ms-appx:///Images/chat_info_single.png"));
					buddy.NotifyPropertyChanged("ProfileImage");
				}
			}
		};
		_ssmService.CheckBuddyProfileAsync(buddy.PhoneNumber);
	}

	public async void PinToStart(FrameworkElement sender)
	{
		try
		{
			if (!string.IsNullOrEmpty(_buddy.Name))
			{
				string fileName = "thumb_" + _buddy.PhoneNumber + ".jpg";
				ForegroundText color = (ForegroundText)1;
				Uri uri;
				if (await Utility.IsFileExist("Cache", fileName) != null)
				{
					uri = new Uri("ms-appdata:///local/Cache/" + fileName);
				}
				else
				{
					uri = new Uri("ms-appx:///Images/chat_info_single.png");
					color = (ForegroundText)0;
				}
				SecondaryTile secondaryTile = new SecondaryTile(_buddy.PhoneNumber, _buddy.Name, _buddy.Name, _buddy.PhoneNumber, (TileOptions)1, uri);
				secondaryTile.put_ForegroundText(color);
				string id = secondaryTile.TileId;
				SecondaryTile exsistingTile = (await SecondaryTile.FindAllAsync()).Where((SecondaryTile p) => p.TileId == id).FirstOrDefault();
				if (exsistingTile != null)
				{
					await exsistingTile.RequestDeleteForSelectionAsync(Utility.GetElementRect(sender), (Placement)3);
				}
				else if (await secondaryTile.RequestCreateForSelectionAsync(Utility.GetElementRect(sender), (Placement)3))
				{
					await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("WP7_CHATON_UPLOADINGCOMPLETED"), showCancel: false, Utility.GetResourceString("WP7_CHATON_PIN_TO_START"));
				}
			}
		}
		catch (Exception)
		{
		}
	}

	internal void OpenAddCommentPage()
	{
	}

	internal void UpdateMemoList()
	{
		_page.ShowLoading();
		_ssmService.GetMemoListAsync(_buddy.PhoneNumber);
	}

	internal async void ToggleFavorite()
	{
		List<Buddy> buddy = _dataService.BuddyItems.Where((Buddy p) => p.IsFavorite).ToList();
		int buddyCount = buddy.Count();
		if (buddyCount >= 50 && !_buddy.IsFavorite)
		{
			string msg = Utility.GetResourceString("IDS_CHATON_POP_MAXIMUM_NUMBER_OF_BUDDIES_HPD_REACHED_IN_FAVOURITES");
			msg = msg.Replace("%d", buddyCount.ToString());
			MessageDialog dialog = new MessageDialog(msg);
			await dialog.ShowAsync();
			return;
		}
		_buddy.IsFavorite = !_buddy.IsFavorite;
		_dataService.BuddyDBSubmitChanges();
		if (_buddy.IsFavorite)
		{
			PivotPage.ActiveInstance.ViewModel.AddFavorite(_buddy);
		}
		else
		{
			PivotPage.ActiveInstance.ViewModel.RemoveFavorite(_buddy);
		}
		List<Buddy> favorites = _dataService.BuddyItems.Where((Buddy d) => d.IsFavorite).ToList();
		if (favorites.Count == 0)
		{
			return;
		}
		BuddySummary groupIndex = PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Type == BuddySummary.ItemType.Index && x.HeaderType == BuddyListHeaderType.Favorite);
		if (groupIndex != null)
		{
			groupIndex.Count = favorites.Count;
			BuddyListHeader buddyListHeader = PivotPage.ActiveInstance.ViewModel.HeaderItems.FirstOrDefault((BuddyListHeader x) => x.Title == groupIndex.HeaderName && x.HeaderType == BuddyListHeaderType.Favorite);
			buddyListHeader.TotalMember = favorites.Count;
		}
	}

	internal void OnNavigatedFrom()
	{
		if (_orgBuddyFavoriteValue != _buddy.IsFavorite)
		{
			ChatOnService.Instance.IsBuddiesUpdated = true;
		}
	}

	internal async void StartChat()
	{
		_chatService.StartChat(disconnect: false, _buddy.PhoneNumber, _buddy.PhoneNumber, ChatType.SINGLE);
	}

	internal void StartCall()
	{
		BuddyService.CallToBuddy(_buddy);
	}

	internal void StartText()
	{
		BuddyService.MessageToBuddy(_buddy);
	}

	internal void BlockBuddy()
	{
		if (!IsBlockProcess)
		{
			_page.ShowLoading();
			IsBlockProcess = true;
			_ssmService.BlockBuddyAsync(_buddy.PhoneNumber);
		}
	}

	internal void LoadMore(string timestamp)
	{
		if (CountBuddyList != MemoList.Count())
		{
			CountBuddyList = MemoList.Count();
			if (LoadingIndicator.ActiveIndicator == null)
			{
				_page.ShowLoading();
			}
			_ssmService.GetMemoListAsync(_buddy.PhoneNumber, timestamp);
		}
	}

	internal void ShowProfileImage()
	{
		if (_buddy.ImgStatus != Buddy.ProfileImgStatus.None && _buddy.ImgStatus != Buddy.ProfileImgStatus.Deleted)
		{
			_ = "Cache\\" + _buddy.PhoneNumber + ".jpg";
		}
	}

	internal void OpenBuddyProfileImage()
	{
		//IL_0071: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		if (Buddy.ImgStatus != Buddy.ProfileImgStatus.Deleted && Buddy.ImgStatus != Buddy.ProfileImgStatus.None)
		{
			_page.Close();
			ImageViewerArgument imageViewerArgument = new ImageViewerArgument();
			imageViewerArgument.FilePath = string.Concat("Cache\\", Buddy.BuddyID, ".jpg");
			imageViewerArgument.Image = new BitmapImage(_ssmService.GetBuddyProfileImageUri(Buddy.PhoneNumber, isThumbnail: false, forceUpdate: true, 800));
			imageViewerArgument.Uri = _ssmService.GetBuddyProfileImageUri(Buddy.PhoneNumber, isThumbnail: false);
			imageViewerArgument.CanSave = false;
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(ImageViewer), (object)imageViewerArgument);
		}
	}

	internal void DeleteMemo(BuddiesSay memo)
	{
		_page.ShowLoading();
		_ssmService.DeleteMemoAsync(_buddy.PhoneNumber, memo.TimeStamp, fromMyProfile: false);
		if (MemoList.Count - 1 == 0)
		{
			_buddy.IsBlindText = true;
		}
		else
		{
			_buddy.IsBlindText = false;
		}
	}

	internal async void AddContact(string name, string phoneNumber, string email = "")
	{
		try
		{
		}
		catch (Exception)
		{
			LoadingIndicator.StopLoading();
		}
	}

	public void EditName(string name, string defaultname = "", bool isMode = false)
	{
		if (!isMode)
		{
			EditNameVisibility = (Visibility)0;
			return;
		}
		string value = name;
		if (_buddy.Name.Equals(name))
		{
			EditNameVisibility = (Visibility)1;
			_page.RenameDone(_buddy.Name);
			return;
		}
		if (string.IsNullOrEmpty(name.Trim()))
		{
			EditNameVisibility = (Visibility)1;
			_page.RenameDone(_buddy.Name);
			return;
		}
		_page.ShowLoading();
		_ = _buddy.Name;
		Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy x) => x.PhoneNumber == _buddy.PhoneNumber);
		_ssmService.UploadAddressCompleted += async delegate(object s, SSMCompletedEventArgs err)
		{
			LoadingIndicator.StopLoading();
			if (err.StatusCode != HttpStatusCode.OK)
			{
				await SSMService.ShowCommonErrorMessage(err);
			}
			else
			{
				MyContact myContact = _dataService.ContactItems.FirstOrDefault((MyContact c) => c.PhoneNumber == _buddy.PhoneNumber);
				if (myContact != null)
				{
					myContact.DisplayName = name;
				}
				if (buddy != null)
				{
					buddy.Name = name;
					buddy.ProfileName = name;
				}
				Chat chat = _dataService.ChatItems.FirstOrDefault((Chat x) => x.SingleChatBuddy != null && x.SingleChatBuddy.PhoneNumber == _buddy.PhoneNumber && x.IsValidSession);
				if (chat != null)
				{
					chat.CustomTitle = name;
					chat.Name = name;
					_dataService.ChatDBSubmitChanges();
					NotifyPropertyChanged(() => PivotPage.ActiveInstance.ViewModel.ChatItems);
				}
				List<Chat> list = _dataService.ChatItems.Where((Chat x) => x.Members.Contains(buddy.PhoneNumber)).ToList();
				foreach (Chat item2 in list)
				{
					_chatService.HandleBuddyRename(item2, buddy);
					_chatService.UpdateChatSummary(item2);
				}
				PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber == _buddy.PhoneNumber);
				List<BuddySummary> list2 = PivotPage.ActiveInstance.ViewModel.ShowingItems.Where((BuddySummary x) => x.Buddy != null && x.Buddy.IndexString.ToLower().Equals(_buddy.IndexString.ToLower())).ToList();
				BuddyListHeader item = PivotPage.ActiveInstance.ViewModel.HeaderItems.FirstOrDefault((BuddyListHeader x) => x.Title.ToLower().Equals(_buddy.IndexString.ToLower()));
				List<BuddySummary> source = PivotPage.ActiveInstance.ViewModel.ShowingItems.Where((BuddySummary x) => x.Type.Equals(BuddySummary.ItemType.Index) && x.HeaderName.ToLower().Equals(_buddy.IndexString.ToLower())).ToList();
				if (list2.Count < 1)
				{
					PivotPage.ActiveInstance.ViewModel.HeaderItems.Remove(item);
					PivotPage.ActiveInstance.ViewModel.ShowingItems.Remove(source.FirstOrDefault());
				}
				if (ChatProfilePage.ActiveInstance != null)
				{
					ChatBuddy chatBuddy = ChatProfilePage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((ChatBuddy x) => x.PhoneNumber == _buddy.PhoneNumber);
					if (chatBuddy != null)
					{
						chatBuddy.Name = name;
					}
					ChatProfilePage.ActiveInstance.ViewModel.UpdateChatName();
					NotifyPropertyChanged(() => ChatProfilePage.ActiveInstance.ViewModel.ShowingItems);
				}
				List<BuddiesSay> list3 = MemoList.Where((BuddiesSay x) => x.PhoneNumber == _buddy.PhoneNumber).ToList();
				foreach (BuddiesSay item3 in list3)
				{
					item3.Name = _buddy.Name;
				}
				NotifyPropertyChanged(() => MemoList);
				UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser x) => x.PhoneNumber == _buddy.PhoneNumber);
				if (unknownUser != null)
				{
					unknownUser.Name = _buddy.Name;
					_dataService.UnknownUserDBSubmitChanges();
				}
			}
			_page.RenameDone(_buddy.Name);
			PivotPage.ActiveInstance.ViewModel.RemoveBuddyFromShowingItems(buddy);
			PivotPage.ActiveInstance.ViewModel.UpdateList(skipLaunchArgs: true);
			NotifyPropertyChanged(() => Buddy);
		};
		_ssmService.UploadAddressListAsync(_buddyService.MakeParamUploadAddressList(WebUtility.HtmlEncode(value), _buddy.PhoneNumber), isUpdate: true);
		_dataService.ContactDBSubmitChanges();
		_dataService.BuddyDBSubmitChanges();
		EditNameVisibility = (Visibility)1;
	}
}
