using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.Foundation;
using Windows.Media.Capture;
using Windows.Storage;
using Windows.Storage.Pickers;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class SelectBackgroundPopup : UserControl, IComponentConnector
{
	private SelectBubbleStylePopupViewModel _viewModel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SampleChatBubble BuddyBubbleControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SampleChatBubble MyBubbleControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public SelectBackgroundPopup()
	{
		InitializeComponent();
		_viewModel = new SelectBubbleStylePopupViewModel(isBGSelection: true);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
	}

	private void BG_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		SkinItem item = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as SkinItem;
		_viewModel.OnSelectBG(item);
		ChatSettingPage.ActiveInstance.Update();
		ChatOnService.Instance.IsChatStyleUpdated = true;
	}

	private async void Browse_Click_1(object sender, RoutedEventArgs e)
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
		List<object> pageParam = new List<object> { file, true };
		if (file != null)
		{
			CropPage.Init();
			CropPage.CropCompleted += delegate(object s2, object p)
			{
				SetCustomBGImage((StorageFile)((p is StorageFile) ? p : null));
			};
			CropPage.CroppedAspectRatio = new Size(Window.Current.Bounds.Width - 470.0, Window.Current.Bounds.Height - 220.0);
			((Page)SettingsPage.ActiveInstance).Frame.Navigate(typeof(CropPage), (object)pageParam);
		}
	}

	private async Task SetCustomBGImage(StorageFile file)
	{
		StorageFolder localFolder = ApplicationData.Current.LocalFolder;
		string prevFileName = SettingService.GetCustomBGFileName();
		if (!string.IsNullOrEmpty(prevFileName))
		{
			StorageFile prevFile = null;
			try
			{
				prevFile = await localFolder.GetFileAsync(prevFileName);
			}
			catch
			{
			}
			if (prevFile != null)
			{
				await prevFile.DeleteAsync();
			}
		}
		SettingService.SetCustomBGFileName((await file.CopyAsync((IStorageFolder)(object)localFolder, string.Concat(Guid.NewGuid(), ".jpg"), (NameCollisionOption)2)).Name);
		SettingService.SetBGType(0);
		_viewModel.OnSelectBG(null);
		ChatSettingPage.ActiveInstance.Update();
		ChatOnService.Instance.IsChatStyleUpdated = true;
	}

	private async void Camera_Click_2(object sender, RoutedEventArgs e)
	{
		try
		{
			CameraCaptureUI dialog = new CameraCaptureUI();
			Size aspectRatio = new Size
			{
				Width = (Window.Current.Bounds.Width - 468.0) / 10.0,
				Height = (Window.Current.Bounds.Height - 140.0 - 80.0) / 10.0
			};
			dialog.PhotoSettings.put_CroppedAspectRatio(aspectRatio);
			StorageFile file = await dialog.CaptureFileAsync((CameraCaptureUIMode)1);
			if (file != null)
			{
				await SetCustomBGImage(file);
			}
		}
		catch (Exception)
		{
			Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_CAMERA_NOT_AVAILABLE"), showCancel: false, Utility.GetResourceString("IDS_CHATON_BODY_ERROR"));
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SelectBackgroundPopup.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			BuddyBubbleControl = (SampleChatBubble)((FrameworkElement)this).FindName("BuddyBubbleControl");
			MyBubbleControl = (SampleChatBubble)((FrameworkElement)this).FindName("MyBubbleControl");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Expected O, but got Unknown
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Expected O, but got Unknown
		//IL_004e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0054: Expected O, but got Unknown
		//IL_0073: Unknown result type (might be due to invalid IL or missing references)
		//IL_007d: Expected O, but got Unknown
		//IL_0080: Unknown result type (might be due to invalid IL or missing references)
		//IL_0086: Expected O, but got Unknown
		//IL_00a5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00af: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BG_Tapped_1));
			break;
		}
		case 2:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Camera_Click_2));
			break;
		}
		case 3:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Browse_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
