using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.Foundation;
using Windows.Media.Capture;
using Windows.Storage;
using Windows.Storage.Pickers;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class MyPage : Page, IComponentConnector
{
	private static MyPage _activeInstance;

	private SSMService _ssmService;

	public static readonly DependencyProperty ListVerticalOffsetProperty = DependencyProperty.Register("ListVerticalOffset", typeof(double), typeof(MyPage), new PropertyMetadata((object)null, new PropertyChangedCallback(OnListVerticalOffsetChanged)));

	private PivotPage _pivotPage;

	public string _oldFileName;

	private DispatcherTimer delayLoadTimer;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid gridColumn1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid gridColumn3;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView BuddiesSayList;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text2;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image ProfileImageBG;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image ProfileImage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static MyPage ActiveInstance => _activeInstance;

	private static void OnListVerticalOffsetChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		//IL_0040: Unknown result type (might be due to invalid IL or missing references)
		//IL_0046: Expected O, but got Unknown
		//IL_0074: Unknown result type (might be due to invalid IL or missing references)
		//IL_007a: Expected O, but got Unknown
		try
		{
			DispatchedHandler val = null;
			MyPage page = null;
			if ((page = obj as MyPage) == null)
			{
				return;
			}
			DependencyObject child = VisualTreeHelper.GetChild((DependencyObject)(object)page.BuddiesSayList, 0);
			ScrollViewer val2 = (ScrollViewer)((FrameworkElement)((child is FrameworkElement) ? child : null)).FindName("ScrollViewer");
			if (!(val2.VerticalOffset >= val2.ScrollableHeight - 2.0))
			{
				return;
			}
			CoreDispatcher dispatcher = ((DependencyObject)page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					if (((ICollection<object>)((ItemsControl)page.BuddiesSayList).Items).Count > 0)
					{
						BuddiesSay buddiesSay = null;
						if (((IList<object>)((ItemsControl)page.BuddiesSayList).Items)[((ICollection<object>)((ItemsControl)page.BuddiesSayList).Items).Count - 1] is BuddiesSay buddiesSay2)
						{
							try
							{
								buddiesSay2.TimeStamp.ToString();
							}
							catch (Exception)
							{
							}
						}
					}
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		catch
		{
		}
	}

	public unsafe MyPage()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_00a3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ad: Expected O, but got Unknown
		InitializeComponent();
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(MyPage_Loaded));
		_activeInstance = this;
		_ssmService = new SSMService();
		Text2.put_Text(Utility.GetResourceString("IDS_CHATON_HEADER_BUDDIES_SAY"));
		_ssmService.UploadProfileImageCompleted += _ssmService_UploadProfileImageCompleted;
		_ssmService.UploadImageCompleted += _ssmService_UploadImageCompleted;
		_ssmService.AddUserProfileImageCompleted += _ssmService_AddUserProfileImageCompleted;
		delayLoadTimer = new DispatcherTimer();
		delayLoadTimer.put_Interval(new TimeSpan(0, 0, 3));
		DispatcherTimer val = delayLoadTimer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.remove_Tick)), delayLoadTimer_Tick);
	}

	private void MyPage_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_00ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d4: Expected O, but got Unknown
		//IL_00b9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c3: Expected O, but got Unknown
		if (RegistrationService.GetUserProfile() != null && RegistrationService.GetUserProfile().ProfileImage != null && !string.IsNullOrEmpty(RegistrationService.GetUserProfile().ProfileImagePath))
		{
			if ((ProfileImage.Source is BitmapImage && ((BitmapImage)/*isinst with value type is only supported in some contexts*/).UriSource != null && ((BitmapImage)/*isinst with value type is only supported in some contexts*/).UriSource.AbsoluteUri != RegistrationService.GetUserProfile().ProfileImagePath) || ((BitmapImage)/*isinst with value type is only supported in some contexts*/).UriSource == null)
			{
				ProfileImage.put_Source((ImageSource)new BitmapImage(new Uri(RegistrationService.GetUserProfile().ProfileImagePath)));
			}
		}
		else
		{
			ProfileImage.put_Source((ImageSource)new BitmapImage());
		}
	}

	private async void delayLoadTimer_Tick(object sender, object e)
	{
		delayLoadTimer.Stop();
		if (PivotPage.ActiveInstance != null && PivotPage.ActiveInstance.ViewModel != null)
		{
			int oldIndex = IsoSettingHelper.Get("LastSelectedIndex", 0);
			int currentIndex = SettingService.GetSelectedIndex();
			await PivotPage.ActiveInstance.ViewModel.UpdateMemoList();
			if (oldIndex != currentIndex)
			{
				await PivotPage.ActiveInstance.ViewModel.UpdateUserProfile();
			}
		}
	}

	private void BuddiesSayList_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_001b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0021: Expected O, but got Unknown
		//IL_002a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0030: Expected O, but got Unknown
		//IL_003d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0047: Expected O, but got Unknown
		try
		{
			DependencyObject child = VisualTreeHelper.GetChild((DependencyObject)(object)BuddiesSayList, 0);
			ScrollViewer val = (ScrollViewer)((FrameworkElement)((child is FrameworkElement) ? child : null)).FindName("ScrollViewer");
			if (val != null)
			{
				DependencyProperty listVerticalOffsetProperty = ListVerticalOffsetProperty;
				Binding val2 = new Binding();
				val2.put_Source((object)val);
				val2.put_Path(new PropertyPath("VerticalOffset"));
				val2.put_Mode((BindingMode)3);
				((FrameworkElement)this).SetBinding(listVerticalOffsetProperty, (BindingBase)(object)val2);
			}
		}
		catch
		{
		}
		delayLoadTimer.Start();
	}

	protected override async void OnNavigatedTo(NavigationEventArgs e)
	{
		if (PivotPage.ActiveInstance.ViewModel != null)
		{
			PivotPage.ActiveInstance.ViewModel.SelectedIndex = 2;
		}
		((FrameworkElement)this).put_DataContext((object)PivotPage.ActiveInstance.ViewModel);
		ChatOnService.Instance.IsProfileImageUpdated = false;
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		((Page)this).OnNavigatedFrom(e);
		delayLoadTimer.Stop();
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
			CropPage.Init();
			CropPage.CropCompleted += CropPage_CropCompleted;
			CropPage.CroppedAspectRatio = new Size(1.0, 1.0);
			List<object> pageParam = new List<object> { file, true };
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(CropPage), (object)pageParam);
		}
	}

	private void CropPage_CropCompleted(object sender, object arg)
	{
		PivotPage.ActiveInstance.ShowLoading();
		_ssmService.UploadProfileImageAsync((StorageFile)((arg is StorageFile) ? arg : null));
		_ssmService.UploadImageAsync((StorageFile)((arg is StorageFile) ? arg : null));
	}

	private async void CapturePhoto()
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			CameraCaptureUI dialog = new CameraCaptureUI();
			Size aspectRatio = new Size(1.0, 1.0);
			dialog.PhotoSettings.put_CroppedAspectRatio(aspectRatio);
			dialog.PhotoSettings.put_MaxResolution((CameraCaptureUIMaxPhotoResolution)3);
			StorageFile file = await dialog.CaptureFileAsync((CameraCaptureUIMode)1);
			if (file != null)
			{
				PivotPage.ActiveInstance.ShowLoading();
				_ssmService.UploadImageAsync(file);
			}
		}
		catch (Exception)
		{
			Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_CAMERA_NOT_AVAILABLE"), showCancel: false, Utility.GetResourceString("IDS_CHATON_BODY_ERROR"));
		}
	}

	private async void _ssmService_UploadImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error != null || e.StatusCode != HttpStatusCode.OK)
		{
			SSMService.ShowCommonErrorMessage(e);
			return;
		}
		if (e.StatusCode == HttpStatusCode.OK)
		{
			string fileName = e.Param as string;
			_oldFileName = SettingService.GetProfileImageFileName();
			await OnUploadProfileImageCompleted(e);
			await LoadProfileImage(SettingService.GetProfileImageFileName(), ProfileImage);
			ChatOnService.Instance.IsProfileImageUpdated = true;
			_ssmService.AddUserProfileImage(fileName);
			return;
		}
		LoadingIndicator.StopLoading();
		if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_UPDATE_FAILED"), showCancel: true, Utility.GetResourceString("IDS_CHATON_HEADER_ERROR_ABB")))
		{
			ShowLoading();
			object value = e.Value;
			StorageFile val = (StorageFile)((value is StorageFile) ? value : null);
			if (val != null)
			{
				_ssmService.UploadImageAsync(val);
			}
		}
		else
		{
			((Page)this).Frame.GoBack();
		}
	}

	private async void _ssmService_AddUserProfileImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			try
			{
				UserProfile profile = RegistrationService.GetUserProfile();
				profile.ImageStatus = 1;
				RegistrationService.SaveUserProfile(profile);
				await PivotPage.ActiveInstance.ViewModel.UpdateUserProfile();
				return;
			}
			catch
			{
				return;
			}
		}
		SettingService.SetProfileImageFileName(_oldFileName);
		await LoadProfileImage(SettingService.GetProfileImageFileName(), ProfileImage);
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

	private async void _ssmService_UploadProfileImageCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.Error != null || e.StatusCode != HttpStatusCode.OK)
		{
			await SSMService.ShowCommonErrorMessage(e);
			return;
		}
		try
		{
			UserProfile profile = RegistrationService.GetUserProfile();
			profile.ImageStatus = 1;
			RegistrationService.SaveUserProfile(profile);
			await OnUploadProfileImageCompleted(e);
			await LoadProfileImage(SettingService.GetProfileImageFileName(), ProfileImage);
			BuddySummary removed = PivotPage.ActiveInstance.ViewModel.BuddyItems.FirstOrDefault((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber.Equals(RegistrationService.ChatOnID));
			if (removed != null)
			{
				PivotPage.ActiveInstance.ViewModel.BuddyItems.Remove(removed);
				PivotPage.ActiveInstance.ViewModel.ShowingItems.RemoveAt(1);
				PivotPage.ActiveInstance.ViewModel.UpdateList();
			}
		}
		catch
		{
		}
	}

	public static async Task OnUploadProfileImageCompleted(SSMCompletedEventArgs e)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			_ = e.Value;
			BuddySummary removed = PivotPage.ActiveInstance.ViewModel.BuddyItems.FirstOrDefault((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber.Equals(RegistrationService.ChatOnID));
			if (removed != null)
			{
				PivotPage.ActiveInstance.ViewModel.BuddyItems.Remove(removed);
				PivotPage.ActiveInstance.ViewModel.ShowingItems.RemoveAt(1);
				PivotPage.ActiveInstance.ViewModel.UpdateList();
			}
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
		catch
		{
		}
	}

	public static async Task<bool> LoadProfileImage(string fileName, Image profileImage)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			if (await Utility.IsFileExist(fileName) == null)
			{
				_activeInstance.ProfileImage.put_Source((ImageSource)new BitmapImage(new Uri(new Uri("ms-appx://"), "/Images/chat_info_single.png")));
				return false;
			}
			BitmapImage img = new BitmapImage(new Uri(relativeUri: ApplicationData.Current.LocalFolder.Path + "\\" + fileName, baseUri: new Uri("ms-appx://")));
			if (profileImage != null)
			{
				profileImage.put_Source((ImageSource)(object)img);
			}
			ChatOnService.Instance.UserProfile.ProfileImage = img;
			return true;
		}
		catch (Exception)
		{
			return false;
		}
	}

	private async void Image_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		UserProfile ret = RegistrationService.GetUserProfile();
		if (ret.ImageStatus == 1 || ret.ImageStatus == 2)
		{
			if (!string.IsNullOrEmpty(SettingService.GetProfileImageFileName()))
			{
				StorageFolder localFolder = ApplicationData.Current.LocalFolder;
				BitmapImage val = new BitmapImage(new Uri(new Uri("ms-appx://"), localFolder.Path + "\\" + SettingService.GetProfileImageFileName()));
				((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(ProfileImageViewerPage), (object)val);
			}
			else
			{
				SSMService sSMService = new SSMService();
				BitmapImage val2 = ((!string.IsNullOrEmpty(ret.ProfileImagePath)) ? new BitmapImage(new Uri(ret.ProfileImagePath)) : new BitmapImage(sSMService.GetUserProfileImageUri(isThumbnail: false, isForceUpdate: false, 800)));
				((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(ProfileImageViewerPage), (object)val2);
			}
			return;
		}
		PopupMenu menu = new PopupMenu();
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_TAKE_A_PHOTO"), (UICommandInvokedHandler)null, (object)1));
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
				}
			}
		}
		catch (Exception)
		{
		}
	}

	private void Interaction_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(InteractionRankPage));
	}

	private void ProfileName_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(EditProfilePage));
	}

	internal void UpdateProfileImage()
	{
	}

	private async void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		PopupMenu menu = new PopupMenu();
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BUTTON2_DELETE"), (UICommandInvokedHandler)null, (object)1));
		try
		{
			Rect rect = Utility.GetElementRect((FrameworkElement)sender);
			if (rect.Y < 206.0)
			{
				rect.Y = 206.0;
			}
			rect.Y += 50.0;
			if (await menu.ShowForSelectionAsync(rect) != null)
			{
				BuddiesSay memo = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as BuddiesSay;
				PivotPage.ActiveInstance.ViewModel.DeleteMemo(memo);
			}
		}
		catch (Exception)
		{
		}
	}

	public void UpdateBuddyProfileImage(Buddy buddy)
	{
		List<BuddiesSay> list = PivotPage.ActiveInstance.ViewModel.MemoList.Where((BuddiesSay x) => x.PhoneNumber == buddy.PhoneNumber).ToList();
		if (list.Count <= 0)
		{
			return;
		}
		new SSMService();
		foreach (BuddiesSay item in list)
		{
			if (item.Name != buddy.Name)
			{
				item.Name = buddy.Name;
			}
		}
		PivotPage.ActiveInstance.ViewModel.NotifyMemoList();
	}

	private void Image_Tapped_2(object sender, TappedRoutedEventArgs e)
	{
		BuddiesSay buddiesSay = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is BuddiesSay buddiesSay2)
		{
			PivotPage.ActiveInstance.OpenBuddyProfile(buddiesSay2.PhoneNumber);
		}
	}

	private void Image_Loaded_1(object sender, RoutedEventArgs e)
	{
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_0087: Expected O, but got Unknown
		//IL_009a: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a4: Expected O, but got Unknown
		//IL_00e3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ea: Expected O, but got Unknown
		//IL_00fa: Unknown result type (might be due to invalid IL or missing references)
		//IL_0104: Expected O, but got Unknown
		FrameworkElement val = (FrameworkElement)((sender is FrameworkElement) ? sender : null);
		if (val.Tag != null && (bool)val.Tag)
		{
			return;
		}
		BuddiesSay memo = null;
		if ((memo = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as BuddiesSay) == null)
		{
			return;
		}
		new SSMService();
		if (memo.PhoneNumber == RegistrationService.ChatOnID)
		{
			RegistrationService.GetUserProfile();
			object obj = ((sender is Image) ? sender : null);
			DependencyProperty sourceProperty = Image.SourceProperty;
			Binding val2 = new Binding();
			val2.put_Source((object)memo);
			val2.put_Path(new PropertyPath("ProfileImage"));
			((FrameworkElement)obj).SetBinding(sourceProperty, (BindingBase)(object)val2);
		}
		else
		{
			DataService dataService = new DataService();
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == memo.PhoneNumber);
			if (buddy != null)
			{
				object obj2 = ((sender is Image) ? sender : null);
				DependencyProperty sourceProperty2 = Image.SourceProperty;
				Binding val3 = new Binding();
				val3.put_Source((object)buddy);
				val3.put_Path(new PropertyPath("ProfileImage"));
				((FrameworkElement)obj2).SetBinding(sourceProperty2, (BindingBase)(object)val3);
			}
		}
		((FrameworkElement)((sender is FrameworkElement) ? sender : null)).put_Tag((object)true);
	}

	private void OnSigninSamsungTapped(object sender, TappedRoutedEventArgs e)
	{
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SyncIntroPage));
	}

	private void OnRegisterPhoneNumberTapped(object sender, TappedRoutedEventArgs e)
	{
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(InputPhoneNumberPage));
	}

	public void ShowLoading(string text = "Loading...")
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot, text);
	}

	private void BuddySay_Tapped(object sender, TappedRoutedEventArgs e)
	{
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///MyPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			gridColumn1 = (Grid)((FrameworkElement)this).FindName("gridColumn1");
			gridColumn3 = (Grid)((FrameworkElement)this).FindName("gridColumn3");
			BuddiesSayList = (ListView)((FrameworkElement)this).FindName("BuddiesSayList");
			Text2 = (TextBlock)((FrameworkElement)this).FindName("Text2");
			ProfileImageBG = (Image)((FrameworkElement)this).FindName("ProfileImageBG");
			ProfileImage = (Image)((FrameworkElement)this).FindName("ProfileImage");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Expected O, but got Unknown
		//IL_0071: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_0087: Expected O, but got Unknown
		//IL_00a6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b0: Expected O, but got Unknown
		//IL_00b6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bc: Expected O, but got Unknown
		//IL_00db: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e5: Expected O, but got Unknown
		//IL_00eb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f2: Expected O, but got Unknown
		//IL_0113: Unknown result type (might be due to invalid IL or missing references)
		//IL_011d: Expected O, but got Unknown
		//IL_0123: Unknown result type (might be due to invalid IL or missing references)
		//IL_012a: Expected O, but got Unknown
		//IL_014b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Expected O, but got Unknown
		//IL_015b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0162: Expected O, but got Unknown
		//IL_0183: Unknown result type (might be due to invalid IL or missing references)
		//IL_018d: Expected O, but got Unknown
		//IL_0193: Unknown result type (might be due to invalid IL or missing references)
		//IL_019a: Expected O, but got Unknown
		//IL_01bb: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c5: Expected O, but got Unknown
		//IL_01cb: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d2: Expected O, but got Unknown
		//IL_01f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01fd: Expected O, but got Unknown
		//IL_0203: Unknown result type (might be due to invalid IL or missing references)
		//IL_020a: Expected O, but got Unknown
		//IL_022b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0235: Expected O, but got Unknown
		//IL_023b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0242: Expected O, but got Unknown
		//IL_0263: Unknown result type (might be due to invalid IL or missing references)
		//IL_026d: Expected O, but got Unknown
		//IL_0273: Unknown result type (might be due to invalid IL or missing references)
		//IL_027a: Expected O, but got Unknown
		//IL_029b: Unknown result type (might be due to invalid IL or missing references)
		//IL_02a5: Expected O, but got Unknown
		//IL_02ab: Unknown result type (might be due to invalid IL or missing references)
		//IL_02b2: Expected O, but got Unknown
		//IL_02d3: Unknown result type (might be due to invalid IL or missing references)
		//IL_02dd: Expected O, but got Unknown
		//IL_02e3: Unknown result type (might be due to invalid IL or missing references)
		//IL_02ea: Expected O, but got Unknown
		//IL_030b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0315: Expected O, but got Unknown
		//IL_0318: Unknown result type (might be due to invalid IL or missing references)
		//IL_031f: Expected O, but got Unknown
		//IL_0340: Unknown result type (might be due to invalid IL or missing references)
		//IL_034a: Expected O, but got Unknown
		//IL_034d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0354: Expected O, but got Unknown
		//IL_0375: Unknown result type (might be due to invalid IL or missing references)
		//IL_037f: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val15 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val15, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val15, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 2:
		{
			UIElement val14 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val14, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val14, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_2));
			break;
		}
		case 3:
		{
			FrameworkElement val13 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val13, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val13, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(BuddiesSayList_Loaded));
			break;
		}
		case 4:
		{
			UIElement val12 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val12, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val12, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BuddySay_Tapped));
			break;
		}
		case 5:
		{
			UIElement val11 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val11, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val11, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ProfileName_Tapped_1));
			break;
		}
		case 6:
		{
			UIElement val10 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ProfileName_Tapped_1));
			break;
		}
		case 7:
		{
			UIElement val9 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnRegisterPhoneNumberTapped));
			break;
		}
		case 8:
		{
			UIElement val8 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnRegisterPhoneNumberTapped));
			break;
		}
		case 9:
		{
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnSigninSamsungTapped));
			break;
		}
		case 10:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnRegisterPhoneNumberTapped));
			break;
		}
		case 11:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ProfileName_Tapped_1));
			break;
		}
		case 12:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ProfileName_Tapped_1));
			break;
		}
		case 13:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ProfileName_Tapped_1));
			break;
		}
		case 14:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_1));
			break;
		}
		case 15:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
