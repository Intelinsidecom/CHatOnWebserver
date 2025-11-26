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
using Windows.Foundation;
using Windows.Media.Capture;
using Windows.Storage;
using Windows.Storage.Pickers;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatON_WoA.ViewModels;

public class ProfileImageViewerPageViewModel : NotificationObject
{
	private BitmapImage bitmapFromFilePick;

	private bool _isLoadingProfPictHistory;

	private int _selectedProfileIndex;

	private ImageSource _profPictImg;

	private SSMService _ssmService;

	private DataService _dataService;

	private BuddyService _buddyService;

	private int _retryLoadHistory;

	public bool UpdateProfileFinished;

	private string _oldFileName;

	private string _candidateProfPictPath;

	private string _candidateProfPict;

	private StorageFile fileToUpload;

	public Panel LayoutRoot { get; set; }

	public Page Page { get; set; }

	public ObservableCollection<UserProfileImage> UserProfileImageList { get; set; }

	public bool IsLoadingProfPictHistory
	{
		get
		{
			if (UserProfileImageList != null && UserProfileImageList.Count > 0)
			{
				return false;
			}
			return _isLoadingProfPictHistory;
		}
		set
		{
			_isLoadingProfPictHistory = value;
			NotifyPropertyChanged(() => IsLoadingProfPictHistory);
			NotifyPropertyChanged(() => IsEnabledUpdateDelete);
		}
	}

	public bool IsEnabledUpdateDelete
	{
		get
		{
			if (SelectedProfileIndex == -1)
			{
				return false;
			}
			return !IsLoadingProfPictHistory;
		}
	}

	public int SelectedProfileIndex
	{
		get
		{
			return _selectedProfileIndex;
		}
		set
		{
			_selectedProfileIndex = value;
			NotifyPropertyChanged(() => SelectedProfileIndex);
			NotifyPropertyChanged(() => IsEnabledUpdateDelete);
		}
	}

	public ImageSource ProfPictImg
	{
		get
		{
			return _profPictImg;
		}
		set
		{
			_profPictImg = value;
			NotifyPropertyChanged(() => ProfPictImg);
		}
	}

	public ProfileImageViewerPageViewModel()
	{
		_ssmService = new SSMService();
		_dataService = new DataService();
		_buddyService = new BuddyService(_dataService, _ssmService);
		_ssmService.UpdateUserProfileCompleted += _ssmService_UploadProfileImageCompleted;
		_ssmService.UploadProfileImageCompleted += _ssmService_UploadProfileImageCompleted;
		_ssmService.UpdateUserProfileFromHistoryCompleted += _ssmService_UpdateUserProfileFromHistoryCompleted;
		_ssmService.DeleteProfileImageCompleted += _ssmService_DeleteProfileImageCompleted;
		_ssmService.AddUserProfileImageCompleted += _ssmService_AddUserProfileImageCompleted;
		_ssmService.UploadImageCompleted += _ssmService_UploadImageCompleted;
		_ssmService.GetUserProfileImageHistoryCompleted += _ssmService_GetUserProfileImageHistoryCompleted;
		_oldFileName = SettingService.GetProfileImageFileName();
		SelectedProfileIndex = -1;
		UserProfileImageList = new ObservableCollection<UserProfileImage>();
		NotifyPropertyChanged("");
	}

	private async void _ssmService_UpdateUserProfileFromHistoryCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Error != null || e.StatusCode != HttpStatusCode.OK)
		{
			await SSMService.ShowCommonErrorMessage(e);
			LoadingIndicator.StopLoading();
			ForceRemoveLoadingIndicator();
			return;
		}
		UserProfile profile = RegistrationService.GetUserProfile();
		try
		{
			string text = (profile.ProfileImagePath.Contains("\\") ? "\\" : "/");
			Utility.DeleteFile(profile.ProfileImagePath.Split(text[0]).Last());
		}
		catch
		{
		}
		_candidateProfPict = Guid.NewGuid().ToString() + ".jpg";
		StorageFile sf = await Utility.IsFileExistCheck("files", UserProfileImageList[SelectedProfileIndex].ProfileImageId + ".jpg");
		if (sf != null)
		{
			await sf.CopyAsync((IStorageFolder)(object)ApplicationData.Current.LocalFolder, _candidateProfPict, (NameCollisionOption)1);
		}
		else
		{
			sf = await Utility.CreateLocalFile(_candidateProfPict, "", replaceExisting: true);
			await Utility.SaveImageFromWeb((IStorageFile)(object)sf, UserProfileImageList[SelectedProfileIndex].ProfileImageUri);
		}
		_candidateProfPictPath = ApplicationData.Current.LocalFolder.Path + "\\" + _candidateProfPict;
		profile.ImageStatus = 1;
		profile.ProfileImage = new BitmapImage(new Uri(new Uri("ms-appx://"), sf.Path));
		profile.ProfileImageId = UserProfileImageList[SelectedProfileIndex].ProfileImageId;
		profile.ProfileImagePath = _candidateProfPictPath;
		ChatOnService.Instance.UserProfile.ImageStatus = 1;
		RegistrationService.SaveUserProfile(profile);
		UserProfileImageList[0].IsRepresent = false;
		UserProfileImageList[SelectedProfileIndex].IsRepresent = true;
		MoveSelectedProfPictToTop(SelectedProfileIndex);
		ChatOnService.Instance.IsProfileImageUpdated = true;
		ChatOnService.Instance.UserProfile.ImageStatus = 1;
		LoadingIndicator.StopLoading();
		ForceRemoveLoadingIndicator();
	}

	private async void _ssmService_AddUserProfileImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			ChatOnService.Instance.IsProfileImageUpdated = true;
			SSMService.UserProfileImageTimeStamp = Utility.GetTimeStamp();
			UserProfile profile = RegistrationService.GetUserProfile();
			profile.ImageStatus = 1;
			ChatOnService.Instance.UserProfile.ImageStatus = 1;
			RegistrationService.SaveUserProfile(profile);
			await PivotPage.ActiveInstance.ViewModel.UpdateUserProfile();
			UpdateProfileFinished = true;
			LoadProfileImageHistoryAsync();
		}
		else
		{
			LoadingIndicator.StopLoading();
			ForceRemoveLoadingIndicator();
			SettingService.SetProfileImageFileName(_oldFileName);
			ChatOnService.Instance.IsProfileImageUpdated = false;
			if (e.ErrorMessage == null || !e.ErrorMessage.Contains("CCS-45904"))
			{
				await SSMService.ShowCommonErrorMessage(e);
			}
			else
			{
				await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_BODY_MAXIMUM_NUMBER_OF_PROFILE_IMAGE_REACHED"), showCancel: false);
			}
		}
	}

	private async void _ssmService_GetUserProfileImageHistoryCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (!string.IsNullOrEmpty(e.ResultString))
		{
			UserProfileImage oldSelectedPP = UserProfileImageList.FirstOrDefault((UserProfileImage p) => p.IsRepresent);
			ObservableCollection<UserProfileImage> newList = new ObservableCollection<UserProfileImage>((IEnumerable<UserProfileImage>)_buddyService.ParseImageListHistoryfromXml(e.Xml, 800));
			IEnumerable<UserProfileImage> diff = newList.Except(UserProfileImageList, new ProfileImageComparer());
			IEnumerable<UserProfileImage> diff2 = UserProfileImageList.Except(newList, new ProfileImageComparer());
			if (diff.Count() > 0 || diff2.Count() > 0)
			{
				UserProfileImageList = newList;
				NotifyPropertyChanged(() => UserProfileImageList);
				UserProfileImageList = await GetUserProfPictWithLocalImage(new ObservableCollection<UserProfileImage>(newList));
				NotifyPropertyChanged(() => UserProfileImageList);
			}
			UserProfileImage selectedPP = newList.FirstOrDefault((UserProfileImage p) => p.IsRepresent);
			if (selectedPP != null && (oldSelectedPP == null || oldSelectedPP.ProfileImageId != selectedPP.ProfileImageId))
			{
				UserProfileImageList = newList;
				NotifyPropertyChanged(() => UserProfileImageList);
				UserProfileImageList = await GetUserProfPictWithLocalImage(new ObservableCollection<UserProfileImage>(newList));
				NotifyPropertyChanged(() => UserProfileImageList);
				MoveSelectedProfPictToTop(UserProfileImageList.IndexOf(selectedPP));
				ProfPictImg = (ImageSource)new BitmapImage(UserProfileImageList[0].ProfileImageUri);
			}
			StorageFolder sf = null;
			try
			{
				sf = await ApplicationData.Current.LocalFolder.GetFolderAsync("files");
			}
			catch
			{
			}
			if (sf != null)
			{
				foreach (StorageFile item in await sf.GetFilesAsync())
				{
					string s = item.DisplayName;
					if (UserProfileImageList.Where((UserProfileImage p) => p.ProfileImageId == s).Count() == 0)
					{
						try
						{
							Utility.DeleteFile(s + ".jpg", "files");
						}
						catch
						{
						}
					}
				}
			}
			IsLoadingProfPictHistory = false;
			LoadingIndicator.StopLoading();
			ForceRemoveLoadingIndicator();
			_retryLoadHistory = 0;
		}
		else if (++_retryLoadHistory <= 5)
		{
			await Task.Delay(2000);
			LoadProfileImageHistoryAsync();
		}
		else
		{
			await SSMService.ShowCommonErrorMessage(e);
			LoadingIndicator.StopLoading();
			ForceRemoveLoadingIndicator();
		}
	}

	private async void _ssmService_UploadProfileImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Error != null || e.StatusCode != HttpStatusCode.OK)
		{
			await SSMService.ShowCommonErrorMessage(e);
			LoadingIndicator.StopLoading();
			ForceRemoveLoadingIndicator();
			StorageFile sf = await Utility.IsFileExist(_candidateProfPict);
			if (sf != null)
			{
				try
				{
					await sf.DeleteAsync();
					return;
				}
				catch
				{
					return;
				}
			}
			return;
		}
		UserProfile profile = RegistrationService.GetUserProfile();
		object value = e.Value;
		StorageFile file = (StorageFile)((value is StorageFile) ? value : null);
		_oldFileName = SettingService.GetProfileImageFileName();
		if (file != null)
		{
			string path = (profile.ProfileImagePath = file.Path);
			string name = path.Split('\\').Last();
			profile.ProfileImagePath = path;
			SettingService.SetProfileImageFileName(name);
			PivotPage.ActiveInstance.ViewModel.MyProfile.ProfileImagePath = path;
			RegistrationService.SaveUserProfile(profile);
			await MyPage.OnUploadProfileImageCompleted(e);
			ProfPictImg = (ImageSource)new BitmapImage(UserProfileImageList[SelectedProfileIndex].ProfileImageUri);
			ImageSource profPictImg = ProfPictImg;
			profile.ProfileImage = (BitmapImage)(object)((profPictImg is BitmapImage) ? profPictImg : null);
			LoadProfileImageHistoryAsync();
		}
	}

	private void MoveSelectedProfPictToTop(int oldIndex)
	{
		if (oldIndex == -1)
		{
			SelectedProfileIndex = 0;
			return;
		}
		UserProfileImageList.Move(oldIndex, 0);
		SelectedProfileIndex = 0;
	}

	private async void _ssmService_DeleteProfileImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Error != null)
		{
			await SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			if (!string.IsNullOrEmpty(SettingService.GetProfileImageFileName()))
			{
				Utility.DeleteFile(SettingService.GetProfileImageFileName());
			}
			BuddySummary item = PivotPage.ActiveInstance.ViewModel.BuddyItems.FirstOrDefault((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber.Equals(RegistrationService.ChatOnID));
			PivotPage.ActiveInstance.ViewModel.BuddyItems.Remove(item);
			PivotPage.ActiveInstance.ViewModel.ShowingItems.RemoveAt(1);
			PivotPage.ActiveInstance.ViewModel.UpdateList();
			PivotPage.ActiveInstance.ViewModel.NotifyMemoList();
			UpdateProfileFinished = true;
			LoadProfileImageHistoryAsync();
			StorageFolder localFolder = ApplicationData.Current.LocalFolder;
			BitmapImage profPictImg = new BitmapImage(new Uri(new Uri("ms-appx://"), localFolder.Path + "\\" + SettingService.GetProfileImageFileName()));
			ProfPictImg = (ImageSource)(object)profPictImg;
			if (UserProfileImageList.Count <= 1 || UserProfileImageList[SelectedProfileIndex].IsRepresent)
			{
				RegistrationService.DeleteUserProfileImage();
				SettingService.SetProfileImageFileName("");
				UserProfile userProfile = RegistrationService.GetUserProfile();
				userProfile.ImageStatus = 2;
				userProfile.ProfileImage = null;
				userProfile.ProfileImagePath = "";
				ProfPictImg = (ImageSource)new BitmapImage();
				PivotPage.ActiveInstance.ViewModel.MyProfile.ProfileImagePath = "";
				RegistrationService.SaveUserProfile(userProfile);
				ChatOnService.Instance.IsProfileImageUpdated = true;
				Page.Frame.GoBack();
			}
			else
			{
				SelectedProfileIndex = 0;
				ProfPictImg = (ImageSource)new BitmapImage(UserProfileImageList[0].ProfileImageUri);
			}
		}
		LoadingIndicator.StopLoading();
		ForceRemoveLoadingIndicator();
	}

	private async void _ssmService_UploadImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.StatusCode == HttpStatusCode.OK)
		{
			ShowLoading();
			if (fileToUpload != null)
			{
				await fileToUpload.DeleteAsync();
			}
			string fileName = e.Param as string;
			_oldFileName = SettingService.GetProfileImageFileName();
			await MyPage.OnUploadProfileImageCompleted(e);
			_ssmService.AddUserProfileImage(fileName);
			ProfPictImg = (ImageSource)(object)bitmapFromFilePick;
			return;
		}
		LoadingIndicator.StopLoading();
		ForceRemoveLoadingIndicator();
		if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_UPDATE_FAILED"), showCancel: true, Utility.GetResourceString("IDS_CHATON_HEADER_ERROR_ABB")))
		{
			if (fileToUpload != null)
			{
				ShowLoading();
				_ssmService.UploadImageAsync(fileToUpload);
			}
		}
		else
		{
			Page.Frame.GoBack();
		}
	}

	private async void CapturePhoto()
	{
		bool isError = false;
		try
		{
			CameraCaptureUI dialog = new CameraCaptureUI();
			Size aspectRatio = new Size(1.0, 1.0);
			dialog.PhotoSettings.put_MaxResolution((CameraCaptureUIMaxPhotoResolution)3);
			dialog.PhotoSettings.put_CroppedAspectRatio(aspectRatio);
			StorageFile file = await dialog.CaptureFileAsync((CameraCaptureUIMode)1);
			if (file == null)
			{
				return;
			}
			StorageFolder folder = ApplicationData.Current.LocalFolder;
			fileToUpload = await file.CopyAsync((IStorageFolder)(object)folder);
			ShowLoading();
			_ssmService.UploadImageAsync(fileToUpload);
			bitmapFromFilePick = await Utility.BitmapImageFromStorageFileAsync(fileToUpload);
		}
		catch (Exception)
		{
			isError = true;
		}
		if (isError)
		{
			await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_CAMERA_NOT_AVAILABLE"), showCancel: false, Utility.GetResourceString("IDS_CHATON_BODY_ERROR"));
		}
	}

	private async void OpenFile()
	{
		FileOpenPicker pk = new FileOpenPicker();
		pk.put_ViewMode((PickerViewMode)1);
		pk.put_SuggestedStartLocation((PickerLocationId)6);
		pk.FileTypeFilter.Add(".jpg");
		pk.FileTypeFilter.Add(".jpeg");
		pk.FileTypeFilter.Add(".png");
		pk.FileTypeFilter.Add(".bmp");
		pk.FileTypeFilter.Add(".gif");
		StorageFile file = await pk.PickSingleFileAsync();
		if (file != null)
		{
			NavigateToCropPage(file);
		}
	}

	private async void CropPage_CropCompleted(object sender, object arg)
	{
		fileToUpload = (StorageFile)((arg is StorageFile) ? arg : null);
		StorageFolder folder = ApplicationData.Current.LocalFolder;
		fileToUpload = await fileToUpload.CopyAsync((IStorageFolder)(object)folder, "cropped.jpg", (NameCollisionOption)1);
		_ssmService.UploadImageAsync(fileToUpload);
		bitmapFromFilePick = await Utility.BitmapImageFromStorageFileAsync(fileToUpload);
	}

	public void LoadProfileImageHistoryAsync()
	{
		_ssmService.GetUserProfileImageHistoryAsync();
		IsLoadingProfPictHistory = true;
	}

	public async void Init()
	{
		List<BuddiesSay> MyCommentList = PivotPage.ActiveInstance.ViewModel.MemoList.Where((BuddiesSay x) => x.PhoneNumber == RegistrationService.ChatOnID).ToList();
		if (MyCommentList.Count <= 0)
		{
			return;
		}
		new SSMService();
		foreach (BuddiesSay item in MyCommentList)
		{
			item.NotifyPropertyChanged("");
		}
		await PivotPage.ActiveInstance.ViewModel.UpdateMemoList();
		PivotPage.ActiveInstance.ViewModel.NotifyMemoList();
	}

	public async void EditButtonClicked(object sender)
	{
		UpdateProfileFinished = false;
		PopupMenu menu = new PopupMenu();
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BUTTON_CAMERA"), (UICommandInvokedHandler)null, (object)1));
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BODY_PHOTO"), (UICommandInvokedHandler)null, (object)2));
		try
		{
			IUICommand chosenCommand = await menu.ShowForSelectionAsync(Utility.GetElementRect((FrameworkElement)sender));
			if (chosenCommand != null)
			{
				switch ((int)chosenCommand.Id)
				{
				case 1:
					CapturePhoto();
					break;
				case 2:
					OpenFile();
					break;
				case 3:
					DeleteProfilePict();
					break;
				}
			}
		}
		catch (Exception)
		{
		}
	}

	public void UpdateProfilePicture()
	{
		if (ProfPictImg != null && ProfPictImg != null && SelectedProfileIndex != -1)
		{
			LoadingIndicator.StartLoading(Page, LayoutRoot);
			if (SelectedProfileIndex != -1)
			{
				_ssmService.UpdateUserProfileFromHistory(UserProfileImageList[SelectedProfileIndex].ProfileImageId);
			}
		}
	}

	private async Task<ObservableCollection<UserProfileImage>> GetUserProfPictWithLocalImage(ObservableCollection<UserProfileImage> UserProfPictList)
	{
		foreach (UserProfileImage upi in UserProfPictList)
		{
			bool success = false;
			StorageFile val;
			StorageFile sf = (val = await Utility.IsFileExistCheck("files", upi.ProfileImageId + ".jpg"));
			if (val != null)
			{
				upi.ProfileImageUri = new Uri(new Uri("ms-appx://"), sf.Path);
				success = true;
			}
			else
			{
				try
				{
					sf = await Utility.CreateLocalFile(upi.ProfileImageId + ".jpg", "files", replaceExisting: true);
					await Utility.SaveImageFromWeb((IStorageFile)(object)sf, upi.ProfileImageUri);
					success = true;
				}
				catch
				{
				}
			}
			if (success)
			{
				if (!upi.IsRepresent)
				{
					continue;
				}
				UserProfile userProfile;
				UserProfile profile = (userProfile = RegistrationService.GetUserProfile());
				if (userProfile != null && profile.ProfileImageId != upi.ProfileImageId)
				{
					try
					{
						string splitter = (profile.ProfileImagePath.Contains("\\") ? "\\" : "/");
						await Utility.DeleteFile(profile.ProfileImagePath.Split(splitter[0]).Last());
					}
					catch
					{
					}
					_candidateProfPict = Guid.NewGuid().ToString() + ".jpg";
					if (sf != null)
					{
						await sf.CopyAsync((IStorageFolder)(object)ApplicationData.Current.LocalFolder, _candidateProfPict, (NameCollisionOption)1);
					}
					_candidateProfPictPath = ApplicationData.Current.LocalFolder.Path + "\\" + _candidateProfPict;
					profile.ImageStatus = 1;
					if (sf != null)
					{
						profile.ProfileImage = new BitmapImage(new Uri(new Uri("ms-appx://"), sf.Path));
					}
					profile.ProfileImageId = upi.ProfileImageId;
					profile.ProfileImagePath = _candidateProfPictPath;
					ChatOnService.Instance.UserProfile.ImageStatus = 1;
					RegistrationService.SaveUserProfile(profile);
				}
			}
			else
			{
				try
				{
					sf.DeleteAsync((StorageDeleteOption)1);
				}
				catch
				{
				}
			}
		}
		return UserProfPictList;
	}

	private void NavigateToCropPage(StorageFile file)
	{
		CropPage.Init();
		CropPage.CropCompleted += CropPage_CropCompleted;
		CropPage.CroppedAspectRatio = new Size(1.0, 1.0);
		List<object> list = new List<object>();
		list.Add(file);
		list.Add(true);
		Page.Frame.Navigate(typeof(CropPage), (object)list);
	}

	private void ShowLoading()
	{
		ForceRemoveLoadingIndicator();
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading(Page, LayoutRoot);
	}

	public void ForceRemoveLoadingIndicator()
	{
		UIElement val = ((IEnumerable<UIElement>)LayoutRoot.Children).FirstOrDefault((UIElement x) => (object)((object)x).GetType() == typeof(LoadingIndicator));
		if (val != null)
		{
			((ICollection<UIElement>)LayoutRoot.Children).Remove(val);
		}
	}

	internal void DeleteProfilePict()
	{
		if (UserProfileImageList != null && SelectedProfileIndex != -1 && SelectedProfileIndex < UserProfileImageList.Count)
		{
			ShowLoading();
			_ssmService.DeleteUserProfileImageAsync(UserProfileImageList[SelectedProfileIndex].ProfileImageId);
		}
	}
}
