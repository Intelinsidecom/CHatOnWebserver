using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using com.sec.ssm.common;
using Windows.Foundation;
using Windows.Storage;
using Windows.Storage.Pickers;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class ChatProfilePageViewModel : NotificationObject
{
	private ChatProfilePage _page;

	private SSMService _ssmService;

	private BuddyService _buddyService;

	private ChatService _chatService;

	private DataService _dataService;

	private Chat _chat;

	private string _name;

	private string _orgName;

	private string FileName;

	private string FolderName;

	private Visibility _createGroupVisibility;

	private bool _renameButtonVisibility;

	private bool _isSaveGroup;

	private List<ChatBuddy> _buddyItems = new List<ChatBuddy>();

	private List<ChatBuddy> _tempList = new List<ChatBuddy>();

	private ObservableCollection<ChatBuddy> _showingItems = new ObservableCollection<ChatBuddy>();

	private DispatcherTimer _timer;

	private DispatcherTimer _timerImageProfile = new DispatcherTimer();

	private bool _isAlertEnable = true;

	private BitmapImage _imageProfileChat;

	private bool _addButtonVisibility;

	public Visibility CreateGroupVisibility
	{
		get
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			return _createGroupVisibility;
		}
		set
		{
			//IL_0001: Unknown result type (might be due to invalid IL or missing references)
			//IL_0002: Unknown result type (might be due to invalid IL or missing references)
			_createGroupVisibility = value;
			NotifyPropertyChanged(() => CreateGroupVisibility);
		}
	}

	public bool RenameButtonVisibility
	{
		get
		{
			return _renameButtonVisibility;
		}
		set
		{
			_renameButtonVisibility = value;
			NotifyPropertyChanged(() => RenameButtonVisibility);
		}
	}

	public BitmapImage ImageProfileChat
	{
		get
		{
			return _imageProfileChat;
		}
		set
		{
			_imageProfileChat = value;
			if (_chat.ChatType == ChatType.GROUP && _imageProfileChat == Chat.DEFAULT_GROUP_CHAT_PROFILE)
			{
				AddButtonVisibility = true;
			}
			NotifyPropertyChanged(() => ImageProfileChat);
		}
	}

	public bool AddButtonVisibility
	{
		get
		{
			return _addButtonVisibility;
		}
		set
		{
			_addButtonVisibility = value;
			NotifyPropertyChanged(() => AddButtonVisibility);
		}
	}

	public Chat Chat
	{
		get
		{
			return _chat;
		}
		set
		{
			_chat = value;
			NotifyPropertyChanged(() => Chat);
		}
	}

	public string Name
	{
		get
		{
			return _name;
		}
		set
		{
			_name = value;
			NotifyPropertyChanged(() => Name);
		}
	}

	public List<ChatBuddy> BuddyItems
	{
		get
		{
			return _buddyItems;
		}
		set
		{
			_buddyItems = value;
			NotifyPropertyChanged(() => BuddyItems);
		}
	}

	public ObservableCollection<ChatBuddy> ShowingItems
	{
		get
		{
			return _showingItems;
		}
		set
		{
			_showingItems = value;
			NotifyPropertyChanged(() => ShowingItems);
		}
	}

	public Visibility AlertVisibility { get; set; }

	public bool IsAlertEnable
	{
		get
		{
			return _isAlertEnable;
		}
		set
		{
			_isAlertEnable = value;
			NotifyPropertyChanged(() => IsAlertEnable);
		}
	}

	public unsafe ChatProfilePageViewModel(ChatProfilePage page)
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		//IL_00f1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fb: Expected O, but got Unknown
		_page = page;
		_buddyItems = new List<ChatBuddy>();
		_ssmService = new SSMService();
		_ssmService.AddBuddyCompleted += _ssmService_AddBuddyCompleted;
		_ssmService.SetGroupPushCompleted += _ssmService_SetGroupPushCompleted;
		_ssmService.SetChatRoomTitleInfoCompleted += _ssmService_SetChatRoomTitleInfoCompleted;
		_ssmService.DeleteChatRoomProfileImageCompleted += _ssmService_DeleteChatRoomProfileImageCompleted;
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.ChatOnID);
		_timer = new DispatcherTimer();
		DispatcherTimer timer = _timer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.remove_Tick)), _timer_Tick);
		_timer.put_Interval(TimeSpan.FromMilliseconds(40.0));
	}

	private void _ssmService_DeleteChatRoomProfileImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			if (e.StatusCode == HttpStatusCode.OK)
			{
				_ssmService.DeleteFileChatRoomProfileImageCompleted += delegate(object s2, SSMCompletedEventArgs e2)
				{
					if (e2.StatusCode == HttpStatusCode.OK)
					{
						_chat.ImagePath = string.Empty;
						_chat.ProfileImage = null;
						ImageProfileChat = null;
						_dataService.ChatDBSubmitChanges();
						NotifyPropertyChanged(() => Chat);
						NotifyPropertyChanged(() => ImageProfileChat);
						Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_DELETED"));
					}
					else
					{
						Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_SAPPS_POP_SERVER_ERROR_OCCURRED_TRY_LATER"));
					}
				};
				_ssmService.DeleteFileChatRoomProfileImageAsync(_chat.SessionID, _chat.FileAddress, _chat.FilePath);
			}
			else
			{
				Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_SAPPS_POP_SERVER_ERROR_OCCURRED_TRY_LATER"));
			}
		});
	}

	private void _ssmService_SetChatRoomTitleInfoCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			Chat chat = PivotPage.ActiveInstance.ViewModel.ChatItems.FirstOrDefault((Chat x) => x.SessionID == Chat.SessionID);
			if (chat != null)
			{
				chat.Name = Chat.Name;
				chat.Title = Chat.Title;
			}
			PivotPage.ActiveInstance.ViewModel.UpdateChatList();
			NotifyPropertyChanged(() => PivotPage.ActiveInstance.ViewModel.ChatItems);
			NotifyPropertyChanged(() => Chat);
			_dataService.ChatDBSubmitChanges();
			Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_SAVED"));
		}
		else
		{
			Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_SAPPS_POP_SERVER_ERROR_OCCURRED_TRY_LATER"));
		}
	}

	private void _ssmService_SetGroupPushCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error != null)
		{
			SSMService.ShowCommonErrorMessage(e);
		}
	}

	private void _timer_Tick(object sender, object e)
	{
		if (_tempList.Count > 0)
		{
			ChatBuddy item = _tempList.First();
			if (!_showingItems.Contains(item))
			{
				_showingItems.Add(item);
			}
			_tempList.Remove(item);
		}
		else
		{
			LoadImageProfileChatGroup(Chat.ImagePath, Chat.ChatID.ToString());
			_timer.Stop();
		}
	}

	private async void _ssmService_AddBuddyCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		try
		{
			if (await BuddyService.ShowAddBuddyResult(e, e.Param as string))
			{
				ChatOnService.Instance.IsBuddiesUpdated = true;
				List<Buddy> newBuddies = _buddyService.AddBuddyFromXml(e.Xml);
				if (newBuddies.Count > 0)
				{
					foreach (Buddy buddy in newBuddies)
					{
						await buddy.LoadProfileImage(_ssmService.GetBuddyProfileImageUri(buddy.PhoneNumber));
						ObservableCollection<ChatBuddy> showingItems = ShowingItems;
						Func<ChatBuddy, bool> predicate = (ChatBuddy p) => p.PhoneNumber == buddy.PhoneNumber;
						ChatBuddy dataUpdated = showingItems.Where(predicate).FirstOrDefault();
						if (dataUpdated != null)
						{
							dataUpdated.Buddy = buddy;
						}
					}
					NotifyPropertyChanged(() => ShowingItems);
				}
				MessageDialog dialog = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_ADDED_TO_BUDDY_LIST"));
				await dialog.ShowAsync();
				PivotPage.ActiveInstance.ViewModel.UpdateList();
				if (_isSaveGroup)
				{
					_isSaveGroup = false;
					InputGroupName();
				}
				return;
			}
			throw new Exception("Error occured");
		}
		catch (Exception)
		{
		}
	}

	internal void CheckAlert(Chat chat)
	{
		if (chat.ChatType == ChatType.GROUP)
		{
			AlertVisibility = (Visibility)0;
		}
		else
		{
			AlertVisibility = (Visibility)1;
		}
		NotifyPropertyChanged(() => AlertVisibility);
	}

	internal void Update(Chat chat)
	{
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		Chat = chat;
		UpdateChatBuddies(Chat.ChatID);
		if (_chat == null || (_chat != null && string.IsNullOrEmpty(_chat.SessionID) && _chat.ChatType != ChatType.BROADCAST))
		{
			RenameButtonVisibility = false;
		}
		else
		{
			RenameButtonVisibility = true;
		}
		if (Chat.ChatType == ChatType.SINGLE)
		{
			LoadImageProfileSingle();
		}
		else if (_chat.ChatType == ChatType.BROADCAST)
		{
			ImageProfileChat = new BitmapImage(new Uri("ms-appx:///Images/chat_info_broadcast.png"));
			NotifyPropertyChanged(() => ImageProfileChat);
		}
	}

	internal void UpdateChatBuddies(Guid id)
	{
		_chat = _dataService.GetChat(id);
		foreach (string member in _chat.MemberList)
		{
			if (string.IsNullOrEmpty(member))
			{
				continue;
			}
			ChatBuddy chatBuddy = new ChatBuddy();
			chatBuddy.PhoneNumber = member;
			Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == member);
			if (buddy != null)
			{
				chatBuddy.Name = buddy.Name;
				chatBuddy.ProfileImage = buddy.ProfileImage;
				chatBuddy.Buddy = buddy;
			}
			else
			{
				UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == member);
				if (unknownUser == null)
				{
					unknownUser = new UnknownUser();
					unknownUser.PhoneNumber = member;
					_dataService.AddUnknownUser(unknownUser);
				}
				chatBuddy.Name = unknownUser.Name;
				chatBuddy.Status = unknownUser.Status;
				unknownUser.LoadProfileImageCompleted += user_LoadProfileImageCompleted;
				unknownUser.LoadProfileImage(applyTheme: true, chatBuddy);
				chatBuddy.ProfileImage = unknownUser.ProfileImage;
			}
			_buddyItems.Add(chatBuddy);
		}
		_dataService.UnknownUserDBSubmitChanges();
		_buddyItems.Sort((ChatBuddy m2, ChatBuddy m1) => m2.Name.CompareTo(m1.Name));
		_showingItems.Clear();
		_tempList.Clear();
		foreach (ChatBuddy buddyItem in _buddyItems)
		{
			if (!_tempList.Contains(buddyItem))
			{
				_tempList.Add(buddyItem);
			}
		}
		string resourceString = Utility.GetResourceString("IDS_CHATON_HEADER_BUDDIES");
		object obj = resourceString;
		resourceString = string.Concat(obj, "(", _tempList.Count, ")");
		_page.SetBuddyCountText(resourceString);
		ConfigureEnableCreateGroup();
		_timer.Start();
	}

	private void ConfigureEnableCreateGroup()
	{
		List<ChatBuddy> tempList = _tempList;
		int num = tempList.Count((ChatBuddy x) => x.Buddy != null && x.Buddy.IsBlocked);
		CreateGroupVisibility = (Visibility)((tempList.Count == num) ? 1 : 0);
	}

	private void user_LoadProfileImageCompleted(object sender, object e)
	{
		UnknownUser unknownUser = null;
		if (sender is UnknownUser unknownUser2)
		{
			ChatBuddy chatBuddy = null;
			unknownUser2.LoadProfileImageCompleted -= user_LoadProfileImageCompleted;
			if (e is ChatBuddy chatBuddy2)
			{
				chatBuddy2.ProfileImage = unknownUser2.ProfileImage;
				chatBuddy2.Status = unknownUser2.Status;
				NotifyPropertyChanged("");
			}
		}
	}

	private void AddUnknownBuddyPage_BuddyAdded(object sender, object arg)
	{
		Buddy buddy = null;
		if ((buddy = arg as Buddy) == null)
		{
			return;
		}
		foreach (Message messageItem in _chat.MessageItems)
		{
			if (buddy.PhoneNumber == messageItem.Sender)
			{
				messageItem.NotifySenderUpdated();
			}
		}
		_chatService.UpdateChatSummary(_chat);
		ChatBuddy chatBuddy = _buddyItems.FirstOrDefault((ChatBuddy c) => c.PhoneNumber == buddy.PhoneNumber);
		chatBuddy.Buddy = buddy;
	}

	public void UpdateChatName()
	{
		if (string.IsNullOrEmpty(_chat.Name))
		{
			Name = _chat.Title;
		}
		else
		{
			Name = _chat.Name;
		}
		_orgName = _name;
		IsAlertEnable = _chat.IsAlert;
	}

	internal void LoadImageProfileSingle()
	{
		//IL_001a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0024: Expected O, but got Unknown
		ImageProfileChat = new BitmapImage(_ssmService.GetBuddyProfileImageUri(Chat.Sender));
		NotifyPropertyChanged(() => ImageProfileChat);
	}

	internal async void LoadImageProfileChatGroup(string name, string folder)
	{
		ImageProfileChat = Chat.ProfileImage;
		NotifyPropertyChanged(() => ImageProfileChat);
	}

	internal async void SelectMenuProfileImage(object sender)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			PopupMenu menu = new PopupMenu();
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BODY_PHOTO"), (UICommandInvokedHandler)null, (object)1));
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_REMOVE"), (UICommandInvokedHandler)null, (object)2));
			IUICommand chosenCommand = await menu.ShowForSelectionAsync(Utility.GetElementRect((FrameworkElement)sender));
			if (chosenCommand != null)
			{
				switch ((int)chosenCommand.Id)
				{
				case 1:
					SelectProfileImage();
					break;
				case 2:
					DeleteProfileImage();
					break;
				}
			}
		}
		catch (Exception)
		{
		}
	}

	internal async void DeleteProfileImage()
	{
		await Task.Run(delegate
		{
			_ssmService.DeleteChatRoomProfileImageAsync(_chat.SessionID, _chat.FileAddress, _chat.FilePath);
		});
	}

	internal async void SelectProfileImage()
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (_chat.ChatType == ChatType.SINGLE || _chat.ChatType == ChatType.BROADCAST || string.IsNullOrEmpty(_chat.SessionID))
			{
				return;
			}
			string prevFileName = Utility.Split(_chat.ImagePath, '/').Last();
			string newFilename = string.Concat("thumb_", _chat.ChatID, ".jpg");
			string folderName = "Group";
			FileOpenPicker pk = new FileOpenPicker();
			pk.put_ViewMode((PickerViewMode)1);
			pk.put_SuggestedStartLocation((PickerLocationId)6);
			pk.FileTypeFilter.Add(".jpg");
			pk.FileTypeFilter.Add(".jpeg");
			pk.FileTypeFilter.Add(".png");
			pk.FileTypeFilter.Add(".bmp");
			pk.FileTypeFilter.Add(".gif");
			StorageFile file = await pk.PickSingleFileAsync();
			if (file == null)
			{
				return;
			}
			CropPage.Init();
			CropPage.CropCompleted += async delegate(object s2, object p)
			{
				if (!string.IsNullOrEmpty(prevFileName))
				{
					StorageFile prevFile = await Utility.IsFileExist(folderName, prevFileName);
					if (prevFile != null)
					{
						await prevFile.DeleteAsync();
					}
				}
				StorageFile newFile = await Utility.CopyFileAsync((StorageFile)((p is StorageFile) ? p : null), newFilename, folderName);
				if (_chat.ChatType == ChatType.GROUP)
				{
					StorageFolder localFolder = ApplicationData.Current.LocalFolder;
					if (localFolder != null)
					{
						await _chatService.LoadGroupChatProfile(_chat);
						ImageProfileChat = Chat.ProfileImage;
						NotifyPropertyChanged(() => ImageProfileChat);
					}
				}
				FileName = newFilename;
				FolderName = folderName;
				RegistrationService.GetUserAccount();
				_ssmService.UploadImageCompleted += async delegate(object obj, SSMCompletedEventArgs e)
				{
					if (e.StatusCode != HttpStatusCode.NoContent)
					{
						if (e.StatusCode == HttpStatusCode.OK)
						{
							string text = (string)e.Value;
							string text2 = (string)e.Param;
							_chat.FileAddress = text;
							_chat.FilePath = text2;
							_ssmService.SetChatRoomProfileImageAsync(_chat.SessionID, text, text2);
							_dataService.ChatDBSubmitChanges();
						}
						else
						{
							await SSMService.ShowCommonErrorMessage(e);
						}
					}
				};
				_ssmService.UploadChatRoomImageAsync(newFile);
			};
			CropPage.CroppedAspectRatio = new Size(1.0, 1.0);
			List<object> pageParam = new List<object> { file, true };
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(CropPage), (object)pageParam);
		}
		catch (Exception)
		{
		}
	}

	internal void CheckAndSaveName(string text)
	{
		text = text.Trim();
		if (string.IsNullOrEmpty(text))
		{
			Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_INVALID_INPUT"), showCancel: false);
		}
		else
		{
			if (!(_orgName != text))
			{
				return;
			}
			if (!string.IsNullOrEmpty(_chat.SessionID))
			{
				if (_chat.ChatType == ChatType.GROUP || _chat.ChatType == ChatType.SINGLE)
				{
					if (_chat.ChatType == ChatType.GROUP)
					{
						if (text.Length >= 40)
						{
							_chat.Name = text.Substring(0, 35) + " ....";
						}
						else
						{
							_chat.Name = text;
						}
					}
					else
					{
						_chat.Name = text;
					}
					_ssmService.SetChatRoomTitleAsync(_chat.SessionID, text);
				}
				_dataService.ChatDBSubmitChanges();
			}
			else if (_chat.ChatType == ChatType.BROADCAST)
			{
				_chat.Name = text;
				_dataService.ChatDBSubmitChanges();
				Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_SAVED"));
			}
		}
	}

	internal async void SaveAsGroup()
	{
		string name = "";
		List<string> numbers = new List<string>();
		foreach (ChatBuddy buddyItem in _buddyItems)
		{
			if (buddyItem.Buddy == null)
			{
				if (!string.IsNullOrEmpty(name))
				{
					name += ", ";
				}
				name += buddyItem.Name;
				numbers.Add("+" + buddyItem.PhoneNumber);
			}
		}
		if (numbers.Count() > 0)
		{
			string msg = name;
			string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_PS_IS_NOT_YOUR_BUDDY_YET_ADD_TO_BUDDY_LIST_Q");
			resourceString = resourceString.Replace("%s", msg);
			msg = resourceString;
			if (await Utility.ShowOKCancleMessageDialog(msg))
			{
				_page.ShowLoading();
				_isSaveGroup = true;
				_ssmService.AddBuddyAsync(numbers, name);
			}
		}
		else
		{
			InputGroupName();
		}
	}

	private void InputGroupName()
	{
		AddGroupDialog addGroupDialog = new AddGroupDialog();
		((FrameworkElement)addGroupDialog).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)addGroupDialog).put_VerticalAlignment((VerticalAlignment)2);
		((FrameworkElement)addGroupDialog).put_Margin(new Thickness(0.0, 0.0, 50.0, 400.0));
		addGroupDialog.InputNameCompleted += dialog_InputNameCompleted;
		_page.OpenAddGroupDialog(addGroupDialog);
	}

	private async void dialog_InputNameCompleted(object sender, object arg)
	{
		List<string> memberList = new List<string>();
		foreach (ChatBuddy buddyItem in BuddyItems)
		{
			if (buddyItem.Buddy != null && !buddyItem.Buddy.IsBlocked)
			{
				memberList.Add(buddyItem.Buddy.PhoneNumber);
			}
		}
		string members = string.Join(",", memberList);
		BuddyGroup group = new BuddyGroup();
		group.Name = arg as string;
		group.Members = members;
		if (_chat.ChatType != ChatType.SINGLE)
		{
			group.DirectChatID = _chat.ChatID;
		}
		StorageFile file = await Utility.IsFileExist(_chat.ChatID.ToString(), _chat.ImagePath);
		if (file != null)
		{
			await Utility.CopyFileAsync(file, _chat.ImagePath, "Group");
			group.ImagePath = _chat.ImagePath;
			group.LoadProfileImage();
		}
		DataService dataService = new DataService();
		if (group == null)
		{
			return;
		}
		_page.ShowLoading();
		_ssmService.UpdateBuddyGroupCompleted += delegate(object s2, SSMCompletedEventArgs e2)
		{
			LoadingIndicator.StopLoading();
			if (e2.StatusCode == HttpStatusCode.OK)
			{
				dataService.AddBuddyGroup(group);
				Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_NEW_GROUP_CREATED_ABB"));
				ChatOnService.Instance.IsBuddiesUpdated = true;
				if (BuddyListPage.ActiveInstance != null)
				{
					BuddyListPage.ActiveInstance.FocusToGroup(group);
				}
			}
			else
			{
				SSMService.ShowCommonErrorMessage(e2);
			}
		};
		_ssmService.UpdateBuddyGroupAsync(_buddyService.MakeGroupMemberListParam(group, delete: false));
	}

	internal void AddBuddy(ChatBuddy chatBuddy)
	{
		_page.ShowLoading();
		_ssmService.AddBuddyAsync("+" + chatBuddy.PhoneNumber, isPrev: false, chatBuddy.Name);
	}

	public void UpdateAlert(bool alertEnable)
	{
		if (_chat != null && _chat.IsAlert != alertEnable)
		{
			_chat.IsAlert = alertEnable;
			_dataService.ChatDBSubmitChanges();
			int pushType = (alertEnable ? 1 : 0);
			_page.ShowLoading();
			_ssmService.SetGroupPushAsync(_chat.SessionID, pushType);
		}
	}

	public void OpenUnknownBuddyProfile(string number)
	{
		if (!(number == RegistrationService.ChatOnID))
		{
			UnknownUser unknownUser = _dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == number);
			if (unknownUser == null)
			{
				unknownUser = new UnknownUser();
				unknownUser.PhoneNumber = number;
				unknownUser.Name = Utility.GetResourceString("IDS_CHATON_BODY_UNKNOWN");
				_dataService.AddUnknownUser(unknownUser);
			}
			unknownUser.LoadProfileImage(applyTheme: true);
			unknownUser.SetMessage(unknownUser.Name);
			UnknownBuddyProfileDialog unknownBuddyProfileDialog = new UnknownBuddyProfileDialog();
			unknownBuddyProfileDialog.BuddyInfo = unknownUser;
			((FrameworkElement)unknownBuddyProfileDialog).put_HorizontalAlignment((HorizontalAlignment)1);
			((FrameworkElement)unknownBuddyProfileDialog).put_VerticalAlignment((VerticalAlignment)1);
			ChatProfilePage.ActiveInstance.OpenDialog((UserControl)(object)unknownBuddyProfileDialog);
		}
	}
}
