using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.Storage;
using Windows.Storage.Pickers;
using Windows.Storage.Streams;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class ImageViewer : Page, IComponentConnector
{
	private string _filePath;

	private WriteableBitmap _tempProfileBitmap;

	private SSMService _ssmService;

	private BitmapImage _img;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton SaveButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image ImageControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public ImageViewer()
	{
		InitializeComponent();
		_ssmService = new SSMService();
		SaveButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_SAVE");
	}

	protected unsafe override async void OnNavigatedTo(NavigationEventArgs e)
	{
		ImageViewerArgument arg = e.Parameter as ImageViewerArgument;
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot, "Loading...", isCancelable: true);
		if (string.IsNullOrEmpty(arg.Uri.AbsoluteUri))
		{
			_img = await Utility.LoadOrSaveWebImage(arg.FilePath, arg.Uri);
			ImageControl.put_Source((ImageSource)(object)_img);
			WindowsRuntimeMarshal.RemoveEventHandler<RoutedEventHandler>(new Action<EventRegistrationToken>(_img, (nint)__ldftn(BitmapImage.remove_ImageOpened)), new RoutedEventHandler(img_ImageOpened));
			WindowsRuntimeMarshal.RemoveEventHandler<ExceptionRoutedEventHandler>(new Action<EventRegistrationToken>(_img, (nint)__ldftn(BitmapImage.remove_ImageFailed)), new ExceptionRoutedEventHandler(img_ImageFailed));
			BitmapImage img = _img;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(img, (nint)__ldftn(BitmapImage.add_ImageOpened)), new Action<EventRegistrationToken>(img, (nint)__ldftn(BitmapImage.remove_ImageOpened)), new RoutedEventHandler(img_ImageOpened));
			BitmapImage img2 = _img;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ExceptionRoutedEventHandler, EventRegistrationToken>(img2, (nint)__ldftn(BitmapImage.add_ImageFailed)), new Action<EventRegistrationToken>(img2, (nint)__ldftn(BitmapImage.remove_ImageFailed)), new ExceptionRoutedEventHandler(img_ImageFailed));
		}
		else
		{
			_img = new BitmapImage(arg.Uri);
			ImageControl.put_Source((ImageSource)(object)_img);
			WindowsRuntimeMarshal.RemoveEventHandler<RoutedEventHandler>(new Action<EventRegistrationToken>(_img, (nint)__ldftn(BitmapImage.remove_ImageOpened)), new RoutedEventHandler(img_ImageOpened));
			WindowsRuntimeMarshal.RemoveEventHandler<ExceptionRoutedEventHandler>(new Action<EventRegistrationToken>(_img, (nint)__ldftn(BitmapImage.remove_ImageFailed)), new ExceptionRoutedEventHandler(img_ImageFailed));
			BitmapImage img3 = _img;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(img3, (nint)__ldftn(BitmapImage.add_ImageOpened)), new Action<EventRegistrationToken>(img3, (nint)__ldftn(BitmapImage.remove_ImageOpened)), new RoutedEventHandler(img_ImageOpened));
			BitmapImage img4 = _img;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ExceptionRoutedEventHandler, EventRegistrationToken>(img4, (nint)__ldftn(BitmapImage.add_ImageFailed)), new Action<EventRegistrationToken>(img4, (nint)__ldftn(BitmapImage.remove_ImageFailed)), new ExceptionRoutedEventHandler(img_ImageFailed));
		}
		_filePath = arg.FilePath;
		if (!arg.CanSave || string.IsNullOrEmpty(_filePath))
		{
			AppBar val = appBar;
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(AppBar.add_Opened)), new Action<EventRegistrationToken>(val, (nint)__ldftn(AppBar.remove_Opened)), delegate
			{
				appBar.put_IsOpen(false);
			});
		}
	}

	protected unsafe override async void OnNavigatedFrom(NavigationEventArgs e)
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		WindowsRuntimeMarshal.RemoveEventHandler<RoutedEventHandler>(new Action<EventRegistrationToken>(_img, (nint)__ldftn(BitmapImage.remove_ImageOpened)), new RoutedEventHandler(img_ImageOpened));
		WindowsRuntimeMarshal.RemoveEventHandler<ExceptionRoutedEventHandler>(new Action<EventRegistrationToken>(_img, (nint)__ldftn(BitmapImage.remove_ImageFailed)), new ExceptionRoutedEventHandler(img_ImageFailed));
	}

	private void img_ImageFailed(object sender, ExceptionRoutedEventArgs e)
	{
	}

	private void img_ImageOpened(object sender, RoutedEventArgs e)
	{
		BitmapImage val = (BitmapImage)((sender is BitmapImage) ? sender : null);
		if (val != null)
		{
			if (((BitmapSource)val).PixelHeight != ((BitmapSource)val).PixelWidth)
			{
				if (((BitmapSource)val).PixelHeight > ((BitmapSource)val).PixelWidth)
				{
					((FrameworkElement)ImageControl).put_Height(600.0);
					((FrameworkElement)ImageControl).put_Width((double)((float)((BitmapSource)val).PixelWidth * (600f / (float)((BitmapSource)val).PixelHeight)));
				}
				else
				{
					((FrameworkElement)ImageControl).put_Height((double)((float)((BitmapSource)val).PixelHeight * (600f / (float)((BitmapSource)val).PixelWidth)));
					((FrameworkElement)ImageControl).put_Width(600.0);
				}
			}
			else
			{
				((FrameworkElement)ImageControl).put_Height(600.0);
				((FrameworkElement)ImageControl).put_Width(600.0);
			}
		}
		ImageControl.put_Source((ImageSource)(object)val);
		((UIElement)ImageControl).put_Visibility((Visibility)0);
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private async void SaveButton_Click_1(object sender, RoutedEventArgs e)
	{
		StorageFile sourceFile = await Utility.IsFileExist(_filePath);
		if (sourceFile == null)
		{
			return;
		}
		FileSavePicker savePicker = new FileSavePicker();
		savePicker.put_SuggestedStartLocation((PickerLocationId)6);
		savePicker.FileTypeChoices.Add(sourceFile.DisplayType, new List<string> { sourceFile.FileType });
		savePicker.put_SuggestedFileName(sourceFile.Name);
		StorageFile file = await savePicker.PickSaveFileAsync();
		if (file == null)
		{
			return;
		}
		IBuffer buffer = await FileIO.ReadBufferAsync((IStorageFile)(object)sourceFile);
		try
		{
			await FileIO.WriteBufferAsync((IStorageFile)(object)file, buffer);
			Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_SAVED"));
		}
		catch (Exception ex)
		{
			file.DeleteAsync();
			if (ex.HResult == -2147024784)
			{
				Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_BODY_UNABLE_TO_COMPLETE_ACTION_NOT_ENOUGH_MEMORY"));
			}
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
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
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ImageViewerPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			SaveButton = (ImageButton)((FrameworkElement)this).FindName("SaveButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			ImageControl = (Image)((FrameworkElement)this).FindName("ImageControl");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0021: Unknown result type (might be due to invalid IL or missing references)
		//IL_002b: Expected O, but got Unknown
		//IL_002e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0034: Expected O, but got Unknown
		//IL_0053: Unknown result type (might be due to invalid IL or missing references)
		//IL_005d: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
			((ImageButton)target).Click += new RoutedEventHandler(SaveButton_Click_1);
			break;
		case 2:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
