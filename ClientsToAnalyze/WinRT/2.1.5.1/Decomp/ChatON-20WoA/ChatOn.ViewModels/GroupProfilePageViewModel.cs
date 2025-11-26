using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Net;
using System.Threading.Tasks;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using com.sec.ssm.common;
using Windows.Foundation;
using Windows.Media.Capture;
using Windows.Storage;
using Windows.Storage.Pickers;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.StartScreen;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class GroupProfilePageViewModel : NotificationObject
{
	private GroupProfileDialog _page;

	private BuddyService _buddyService;

	private SSMService _ssmService;

	private DataService _dataService;

	private ChatService _chatService;

	private RegistrationService _regService;

	private BuddyGroup _group;

	private ObservableCollection<Buddy> _buddyList;

	private bool _isAddable;

	private bool _isRemovable;

	private Visibility _editNameVisibility = (Visibility)1;

	private string _oldFileName;

	private StorageFile _newFile;

	private static ObservableCollection<BuddySummary> _listtoAdd;

	private static List<BuddySummary> _listtoAddBuddies;

	private static List<BuddySummary> _listtoRemove;

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

	public bool IsAddable
	{
		get
		{
			return _isAddable;
		}
		set
		{
			_isAddable = value;
			NotifyPropertyChanged(() => IsAddable);
		}
	}

	public bool IsRemovable
	{
		get
		{
			return _isRemovable;
		}
		set
		{
			_isRemovable = value;
			NotifyPropertyChanged(() => IsRemovable);
		}
	}

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

	public ObservableCollection<Buddy> BuddyList
	{
		get
		{
			return _buddyList;
		}
		set
		{
			_buddyList = value;
			NotifyPropertyChanged(() => BuddyList);
		}
	}

	public GroupProfilePageViewModel(GroupProfileDialog page)
	{
		//IL_0002: Unknown result type (might be due to invalid IL or missing references)
		_page = page;
		_regService = new RegistrationService();
		_ssmService = new SSMService();
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_chatService = new ChatService(_dataService, _buddyService, RegistrationService.GetUserNumber());
	}

	public void OnNavigatedTo(BuddyGroup group)
	{
		_group = group;
		UpdateBuddyList();
	}

	private void UpdateBuddyList()
	{
		if (_group != null)
		{
			string members = _group.Members;
			string[] members2 = Utility.Split(members);
			IOrderedEnumerable<Buddy> collection = from b in _dataService.BuddyItems
				where members2.Contains(b.PhoneNumber)
				orderby b.Name
				select b;
			BuddyList = new ObservableCollection<Buddy>(collection);
			_page.UpdateBuddiesCount(BuddyList.Count());
			IsAddable = true;
			if (BuddyList.Count() > 0)
			{
				IsRemovable = true;
			}
			else
			{
				IsRemovable = false;
			}
		}
	}

	internal async void StartChat(ChatType type)
	{
		BuddyGroup group = _group;
		if (!string.IsNullOrEmpty(group.Members))
		{
			Chat chat = await _chatService.StartChatFromBuddyGroup(type, group, BuddyList[0].PhoneNumber);
			((DependencyObject)_page).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
			{
				PivotPage.ActiveInstance.OpenChat(chat);
			});
		}
	}

	internal async void SelectProfileImage(object sender)
	{
		PopupMenu menu = new PopupMenu();
		if (_group.ProfileImage.UriSource != null && _group.ProfileImage.UriSource.ToString().Contains("chat_info_group.png"))
		{
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BUTTON_CAMERA"), (UICommandInvokedHandler)null, (object)1));
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BODY_PHOTO"), (UICommandInvokedHandler)null, (object)2));
		}
		else
		{
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BUTTON_CAMERA"), (UICommandInvokedHandler)null, (object)1));
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BODY_PHOTO"), (UICommandInvokedHandler)null, (object)2));
			menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_REMOVE"), (UICommandInvokedHandler)null, (object)3));
		}
		try
		{
			IUICommand chosenCommand = await menu.ShowForSelectionAsync(Utility.GetElementRect((FrameworkElement)sender));
			if (chosenCommand == null)
			{
				return;
			}
			switch ((int)chosenCommand.Id)
			{
			case 2:
			{
				string prevFileName = _group.ImagePath;
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
					break;
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
					StorageFile fileCheck = await Utility.IsFileExist(folderName, prevFileName);
					_newFile = null;
					if (fileCheck != null)
					{
						_newFile = await Utility.CopyFileAsync((StorageFile)((p is StorageFile) ? p : null), prevFileName, folderName);
					}
					else
					{
						StorageFolder tempFile = await Utility.IsFolderExist("Group");
						_newFile = await ((StorageFile)((p is StorageFile) ? p : null)).CopyAsync((IStorageFolder)(object)tempFile, string.Concat(Guid.NewGuid(), ".jpg"), (NameCollisionOption)1);
					}
					SSMService _ssmService = new SSMService();
					_ssmService.UploadGroupImageAsync(_group.Name, _newFile);
					PivotPage.ActiveInstance.ShowLoading();
					_ssmService.UploadGroupImageCompleted += _ssmService_UploadGroupImageCompleted;
					_ssmService.UpdateBuddyGroupCompleted += delegate(object obj, SSMCompletedEventArgs e2)
					{
						if (e2.StatusCode != HttpStatusCode.OK)
						{
							SSMService.ShowCommonErrorMessage(e2);
						}
					};
					_oldFileName = _group.ImagePath;
					_group.ImagePath = _newFile.Name;
					_group.LoadProfileImage();
					_dataService.GroupDBSubmitChanges();
				};
				CropPage.CroppedAspectRatio = new Size(1.0, 1.0);
				List<object> pageParam = new List<object> { file, true };
				((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(CropPage), (object)pageParam);
				break;
			}
			case 1:
				CapturePhoto();
				break;
			case 3:
				await Utility.DeleteFile(_group.ImagePath, "Group");
				_group.ImagePath = "ms-appx:///Images/chat_info_group.png";
				_group.ProfileImage = new BitmapImage(new Uri("ms-appx:///Images/chat_info_group.png"));
				_dataService.GroupDBSubmitChanges();
				DeleteGroupProfileImage(_group.Name);
				NotifyPropertyChanged("");
				_group.LoadProfileImage();
				break;
			}
		}
		catch (Exception)
		{
		}
	}

	private async void _ssmService_UploadGroupImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			SSMService _ssmService = new SSMService();
			_group.ProfileImage = new BitmapImage(_ssmService.GetGroupProfileImageUri(_group.Name));
			string fileName = _group.ImagePath;
			Uri uri = ((await Utility.IsFileExist("Group", fileName) == null) ? new Uri("ms-appx:///Images/chat_info_group.png") : new Uri("ms-appdata:///local/Group/" + fileName));
			foreach (SecondaryTile tile in await SecondaryTile.FindAllForPackageAsync())
			{
				if (tile.TileId == "Group" + _group.GroupID.ToString())
				{
					await Utility.UpdateImageTile(tile.TileId.ToString(), uri.ToString());
				}
			}
			_group.NotifyPropertyChanged("GroupImage");
			LoadingIndicator.StopLoading();
			return;
		}
		try
		{
			LoadingIndicator.StopLoading();
			if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_UPDATE_FAILED"), showCancel: true, Utility.GetResourceString("IDS_CHATON_HEADER_ERROR_ABB")))
			{
				PivotPage.ActiveInstance.ShowLoading();
				this._ssmService.UploadGroupImageAsync(_group.Name, _newFile);
				this._ssmService.UploadGroupImageCompleted -= _ssmService_UploadGroupImageCompleted;
				this._ssmService.UploadGroupImageCompleted += _ssmService_UploadGroupImageCompleted;
			}
			else
			{
				this._ssmService.UploadGroupImageCompleted -= _ssmService_UploadGroupImageCompleted;
				_group.ImagePath = _oldFileName;
				_group.LoadProfileImage();
				_dataService.GroupDBSubmitChanges();
				NotifyPropertyChanged("");
			}
		}
		catch (Exception)
		{
		}
	}

	public void DeleteGroupProfileImage(string name)
	{
		_ssmService.DeleteGroupProfileImageCompleted += delegate(object s, SSMCompletedEventArgs e)
		{
			if (!string.IsNullOrEmpty(e.ErrorMessage))
			{
				SSMService.ShowCommonErrorMessage(e);
			}
		};
		_ssmService.DeleteGroupProfileImageAsync(name);
	}

	private async void CapturePhoto()
	{
		try
		{
			string prevFileName = _group.ImagePath;
			string newFilename = string.Concat(Guid.NewGuid(), ".jpg");
			string folderName = "Group";
			CameraCaptureUI dialog = new CameraCaptureUI();
			Size aspectRatio = new Size(1.0, 1.0);
			dialog.PhotoSettings.put_MaxResolution((CameraCaptureUIMaxPhotoResolution)3);
			dialog.PhotoSettings.put_CroppedAspectRatio(aspectRatio);
			StorageFile file = await dialog.CaptureFileAsync((CameraCaptureUIMode)1);
			if (file == null)
			{
				return;
			}
			if (!string.IsNullOrEmpty(prevFileName))
			{
				StorageFile prevFile = await Utility.IsFileExist(folderName, prevFileName);
				if (prevFile != null)
				{
					await prevFile.DeleteAsync();
				}
			}
			_newFile = null;
			_newFile = await Utility.CopyFileAsync(file, newFilename, folderName);
			_ssmService.UploadGroupImageAsync(_group.Name, _newFile);
			PivotPage.ActiveInstance.ShowLoading();
			_ssmService.UploadGroupImageCompleted += _ssmService_UploadGroupImageCompleted;
			_oldFileName = _group.ImagePath;
			_group.ImagePath = _newFile.Name;
			_group.LoadProfileImage();
			_dataService.GroupDBSubmitChanges();
		}
		catch (Exception)
		{
			Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_CAMERA_NOT_AVAILABLE"), showCancel: false, Utility.GetResourceString("IDS_CHATON_BODY_ERROR"));
		}
	}

	internal async Task DeleteGroup()
	{
		PivotPage.ActiveInstance.ViewModel.DeleteGroup(_group);
	}

	internal async Task<bool> DeleteGroupTile()
	{
		bool result = false;
		IReadOnlyList<SecondaryTile> tileList = await SecondaryTile.FindAllAsync();
		if (tileList.Count == 0)
		{
			return true;
		}
		foreach (SecondaryTile tile in tileList)
		{
			if (SecondaryTile.Exists(tile.TileId) && tile.TileId == "Group" + _group.GroupID.ToString())
			{
				SecondaryTile tileToBeDeleted = new SecondaryTile(tile.TileId);
				while (!result)
				{
					result = await tileToBeDeleted.RequestDeleteAsync();
				}
			}
			else
			{
				result = true;
			}
		}
		return result;
	}

	internal void AddMembers()
	{
		string[] collection = Utility.Split(_group.Members);
		SelectBuddyPage.ExceptionNumbers = new List<string>(collection);
		SelectBuddyPage.IsExceptSpecialBuddies = true;
		SelectBuddyPage.SelectionCountLimit = ChatService.MAX_CHAT_MEMBERS - 1;
		SelectBuddyPage.SelectionCompleted += SelectBuddyToAdd_SelectionCompleted;
		SelectBuddyPage.isRemoveMode = false;
		SelectBuddyPage.Mode = SelectBuddyMode.AddMember;
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
	}

	private void SelectBuddyToAdd_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= SelectBuddyToAdd_SelectionCompleted;
		_listtoAdd = arg as ObservableCollection<BuddySummary>;
		if (_listtoAdd.Count() == 0)
		{
			if (sender is SelectBuddyPage)
			{
				((Page)(sender as SelectBuddyPage)).Frame.GoBack();
			}
		}
		else
		{
			_listtoAddBuddies = _listtoAdd.ToList();
			_ssmService.UpdateBuddyGroupCompleted += ssmService_UpdateBuddyGroupCompleted;
			_ssmService.UpdateBuddyGroupAsync(_buddyService.MakeGroupMemberListParam(_group, _listtoAdd));
		}
	}

	private void ssmService_UpdateBuddyGroupCompleted(object sender, SSMCompletedEventArgs e2)
	{
		LoadingIndicator.StopLoading();
		_ssmService.UpdateBuddyGroupCompleted -= ssmService_UpdateBuddyGroupCompleted;
		if (e2.StatusCode == HttpStatusCode.OK)
		{
			string[] collection = Utility.Split(_group.Members);
			if (string.IsNullOrEmpty(_group.Members))
			{
				collection = new string[0];
			}
			List<string> list = new List<string>(collection);
			foreach (BuddySummary item in _listtoAdd)
			{
				_ = item.Buddy.IsBlocked;
				list.Add(item.Buddy.PhoneNumber);
			}
			foreach (BuddySummary buddySummary in _listtoAddBuddies)
			{
				ObservableCollection<Buddy> buddyList = _buddyList;
				Func<Buddy, bool> predicate = (Buddy x) => x.PhoneNumber == buddySummary.Buddy.PhoneNumber;
				if (!buddyList.Any(predicate))
				{
					Buddy buddy = _dataService.BuddyItems.FirstOrDefault((Buddy x) => x.PhoneNumber == buddySummary.Buddy.PhoneNumber);
					if (buddy != null && !buddy.IsBlocked)
					{
						list.Add(buddy.PhoneNumber);
					}
				}
			}
			list.Reverse();
			_group.Members = string.Join(",", list);
			NotifyPropertyChanged("");
			_dataService.GroupDBSubmitChanges();
			if (((Page)SelectBuddyPage.ActiveInstance).Frame.BackStackDepth > 2)
			{
				((Page)SelectBuddyPage.ActiveInstance).Frame.GoBack();
			}
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e2);
		}
	}

	internal void RemoveMembers()
	{
		string[] array = Utility.Split(_group.Members);
		if (array != null)
		{
			List<string> list = new List<string>();
			foreach (Buddy buddy in _dataService.BuddyItems)
			{
				Func<string, bool> predicate = (string n) => n == buddy.PhoneNumber;
				if (string.IsNullOrEmpty(array.FirstOrDefault(predicate)))
				{
					list.Add(buddy.PhoneNumber);
				}
			}
			SelectBuddyPage.ExceptionNumbers = list;
		}
		SelectBuddyPage.isRemoveMode = true;
		SelectBuddyPage.Mode = SelectBuddyMode.RemoveMember;
		SelectBuddyPage.IsExceptSpecialBuddies = true;
		SelectBuddyPage.SelectionCompleted += SelectBuddyToRemove_SelectionCompleted;
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
	}

	private void SelectBuddyToRemove_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= SelectBuddyToRemove_SelectionCompleted;
		_listtoRemove = (arg as ObservableCollection<BuddySummary>).ToList();
		if (_listtoRemove.Count() == 0)
		{
			if (sender is SelectBuddyPage)
			{
				((Page)(sender as SelectBuddyPage)).Frame.GoBack();
			}
		}
		else
		{
			_ssmService.UpdateBuddyGroupCompleted += _ssmServiceRemoveBuddyGroupCompleted;
			_ssmService.UpdateBuddyGroupAsync(_buddyService.MakeGroupMemberListParam(_group, _listtoRemove, added: false));
		}
	}

	private async void _ssmServiceRemoveBuddyGroupCompleted(object sender, SSMCompletedEventArgs e2)
	{
		LoadingIndicator.StopLoading();
		_ssmService.UpdateBuddyGroupCompleted -= _ssmServiceRemoveBuddyGroupCompleted;
		if (e2.StatusCode == HttpStatusCode.OK)
		{
			string[] members = Utility.Split(_group.Members);
			List<string> memberList = new List<string>(members);
			foreach (BuddySummary item in _listtoRemove)
			{
				memberList.Remove(item.Buddy.PhoneNumber);
			}
			_group.Members = string.Join(",", memberList);
			if (memberList.Count < 1)
			{
				if (!(await DeleteGroupTile()))
				{
					return;
				}
				_dataService.DeleteGroup(_group);
				BuddySummary deletedItem = PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Equals(_group));
				if (deletedItem != null)
				{
					PivotPage.ActiveInstance.ViewModel.ShowingItems.Remove(deletedItem);
				}
				List<BuddySummary> Groups = PivotPage.ActiveInstance.ViewModel.ShowingItems.Where((BuddySummary x) => x.Group != null).ToList();
				BuddySummary GroupHeader = PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Type == BuddySummary.ItemType.Index && x.HeaderType == BuddyListHeaderType.Group);
				if (Groups.Count < 1)
				{
					PivotPage.ActiveInstance.ViewModel.ShowingItems.Remove(GroupHeader);
				}
				_page.Close();
			}
			_dataService.GroupDBSubmitChanges();
			if (((Page)SelectBuddyPage.ActiveInstance).Frame.BackStackDepth > 2)
			{
				((Page)SelectBuddyPage.ActiveInstance).Frame.GoBack();
			}
		}
		else
		{
			SSMService.ShowCommonErrorMessage(e2);
		}
	}

	internal void EditName(string name = "", bool isMode = false, string previousname = "")
	{
		if (!isMode)
		{
			EditNameVisibility = (Visibility)0;
			return;
		}
		if (!string.IsNullOrEmpty(name.Trim()) && name.Contains(","))
		{
			name = name.Replace(",", "");
			Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_COMMAS_WILL_BE_DELETED_AUTOMATICALLY"));
		}
		if (string.IsNullOrEmpty(name.Trim()))
		{
			_page.RenameFinished(previousname);
			EditNameVisibility = (Visibility)1;
			return;
		}
		BuddyGroup buddyGroup = _dataService.BuddyGroups.FirstOrDefault((BuddyGroup c) => c.Name == name);
		if (buddyGroup != null && (_group == null || _group != buddyGroup))
		{
			string resourceString = Utility.GetResourceString("IDS_CHATON_POP_PS_ALREADY_IN_USE_ENTER_ANOTHER_NAME");
			resourceString = resourceString.Replace("%s", "{0:}");
			resourceString = string.Format(resourceString, new object[1] { name });
			Utility.ShowSimpleToastNotification(resourceString);
		}
		else if (_group.Name.Equals(name.Trim()))
		{
			_page.RenameFinished(previousname);
			EditNameVisibility = (Visibility)1;
		}
		else
		{
			if (IsContainDisallowedCharacter(name.Trim()))
			{
				return;
			}
			PivotPage.ActiveInstance.ShowLoading();
			SSMService sSMService = new SSMService();
			BuddyService buddyService = new BuddyService(_dataService, sSMService);
			sSMService.UpdateBuddyGroupCompleted += async delegate(object s2, SSMCompletedEventArgs e2)
			{
				LoadingIndicator.StopLoading();
				if (e2.StatusCode == HttpStatusCode.OK)
				{
					Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_GROUP_NAME_CHANGED"));
					_group.Name = name;
					_dataService.GroupDBSubmitChanges();
					BuddySummary item = PivotPage.ActiveInstance.ViewModel.BuddyItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Name.Equals(_group.Name));
					BuddySummary item2 = PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Name.Equals(_group.Name));
					PivotPage.ActiveInstance.ViewModel.BuddyItems.Remove(item);
					PivotPage.ActiveInstance.ViewModel.ShowingItems.Remove(item2);
					PivotPage.ActiveInstance.ViewModel.UpdateList(skipLaunchArgs: true);
					EditNameVisibility = (Visibility)1;
					NotifyPropertyChanged(() => Group);
					_page.RenameFinished(name);
				}
				else
				{
					await SSMService.ShowCommonErrorMessage(e2);
				}
			};
			EditNameVisibility = (Visibility)1;
			sSMService.UpdateBuddyGroupAsync(buddyService.MakeGroupMemberListParam(_group, delete: false, name));
		}
	}

	private bool IsContainDisallowedCharacter(string name)
	{
		if (name.Contains(","))
		{
			return true;
		}
		return false;
	}

	public async void PinToStart(FrameworkElement sender)
	{
		string fileName = _group.ImagePath;
		ForegroundText color = (ForegroundText)1;
		Uri uri;
		if (await Utility.IsFileExist("Group", fileName) != null)
		{
			uri = new Uri("ms-appdata:///local/Group/" + fileName);
		}
		else
		{
			uri = new Uri("ms-appx:///Images/chat_info_group.png");
			color = (ForegroundText)0;
		}
		SecondaryTile secondaryTile = new SecondaryTile("Group" + _group.GroupID.ToString(), _group.Name, _group.Name, "Group" + _group.GroupID.ToString(), (TileOptions)1, uri);
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
