using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.ViewModels;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class ProfileImageViewerPage : Page, IComponentConnector
{
	private ProfileImageViewerPageViewModel VM;

	private NavigationMode navigationSource;

	private BitmapImage ImageParameter;

	private int oldSelectedIndex;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton Delete;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton EditButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton Update;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView ProfileListBox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image SourceImageBG;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image SourceImage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public ProfileImageViewerPage()
	{
		InitializeComponent();
		EditButton.Text = Utility.GetResourceString("IDS_CHATON_SK3_ADD");
		Delete.Text = Utility.GetResourceString("IDS_CHATON_SK3_DELETE");
		Update.Text = Utility.GetResourceString("IDS_CHATON_SK1_SET");
		oldSelectedIndex = -1;
	}

	private void ProfileImageViewerPage_SizeChanged(object sender, SizeChangedEventArgs e)
	{
	}

	private void ProfileImageViewerPage_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_0047: Invalid comparison between Unknown and I4
		if (VM == null)
		{
			VM = new ProfileImageViewerPageViewModel
			{
				LayoutRoot = (Panel)(object)LayoutRoot,
				Page = (Page)(object)this
			};
		}
		((FrameworkElement)this).put_DataContext((object)VM);
		VM.UpdateProfileFinished = false;
		if ((int)navigationSource != 1)
		{
			VM.LoadProfileImageHistoryAsync();
		}
		VM.ForceRemoveLoadingIndicator();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		//IL_0002: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Invalid comparison between Unknown and I4
		navigationSource = e.NavigationMode;
		if ((int)navigationSource != 1)
		{
			ref BitmapImage imageParameter = ref ImageParameter;
			object parameter = e.Parameter;
			imageParameter = (BitmapImage)((parameter is BitmapImage) ? parameter : null);
			((Page)this).OnNavigatedTo(e);
		}
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private void Edit_Click(object sender, RoutedEventArgs e)
	{
		if (VM != null)
		{
			VM.EditButtonClicked(sender);
		}
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		((UIElement)SourceImageBG).put_Visibility((Visibility)0);
		((Page)this).OnNavigatedFrom(e);
	}

	private void OnProfileSelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0048: Expected O, but got Unknown
		int selectedIndex = ((Selector)((sender is ListView) ? sender : null)).SelectedIndex;
		if (VM != null && selectedIndex != -1)
		{
			UserProfileImage userProfileImage = (UserProfileImage)((Selector)((sender is ListView) ? sender : null)).SelectedItem;
			if (selectedIndex != oldSelectedIndex)
			{
				VM.ProfPictImg = (ImageSource)new BitmapImage(userProfileImage.ProfileImageUri);
			}
			VM.SelectedProfileIndex = ((Selector)((sender is ListView) ? sender : null)).SelectedIndex;
		}
		if (selectedIndex != -1)
		{
			oldSelectedIndex = selectedIndex;
		}
	}

	private void OnImageListtapped(object sender, TappedRoutedEventArgs e)
	{
	}

	private void OnProfileImageItemTapped(object sender, TappedRoutedEventArgs e)
	{
		if (VM != null)
		{
			VM.ProfPictImg = ((Image)((sender is Image) ? sender : null)).Source;
		}
	}

	private void Update_Click(object sender, RoutedEventArgs e)
	{
		if (VM != null && VM.SelectedProfileIndex != -1)
		{
			VM.UpdateProfilePicture();
		}
	}

	private void Delete_Click(object sender, RoutedEventArgs e)
	{
		if (VM != null && VM.SelectedProfileIndex != -1)
		{
			VM.DeleteProfilePict();
		}
	}

	private void OnImageItemOpened(object sender, RoutedEventArgs e)
	{
		DependencyObject parent = ((FrameworkElement)((sender is Image) ? sender : null)).Parent;
		Grid val = (Grid)(object)((parent is Grid) ? parent : null);
		if (val != null && ((Panel)val).Children != null && ((ICollection<UIElement>)((Panel)val).Children).Count > 1)
		{
			((IList<UIElement>)((Panel)val).Children).RemoveAt(0);
		}
	}

	private void OnSourceSizeChanged(object sender, SizeChangedEventArgs e)
	{
		((UIElement)SourceImageBG).put_Visibility((Visibility)1);
	}

	private void OnSourceImageOpened(object sender, RoutedEventArgs e)
	{
		((UIElement)SourceImageBG).put_Visibility((Visibility)1);
	}

	private void OnSourceImageLoaded(object sender, RoutedEventArgs e)
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
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0129: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ProfileImageViewerPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			Delete = (ImageButton)((FrameworkElement)this).FindName("Delete");
			EditButton = (ImageButton)((FrameworkElement)this).FindName("EditButton");
			Update = (ImageButton)((FrameworkElement)this).FindName("Update");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			ProfileListBox = (ListView)((FrameworkElement)this).FindName("ProfileListBox");
			SourceImageBG = (Image)((FrameworkElement)this).FindName("SourceImageBG");
			SourceImage = (Image)((FrameworkElement)this).FindName("SourceImage");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0030: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_005f: Expected O, but got Unknown
		//IL_0060: Unknown result type (might be due to invalid IL or missing references)
		//IL_0066: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_00a1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ab: Expected O, but got Unknown
		//IL_00bd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c7: Expected O, but got Unknown
		//IL_00d9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e3: Expected O, but got Unknown
		//IL_00e9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ef: Expected O, but got Unknown
		//IL_010e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0118: Expected O, but got Unknown
		//IL_011e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0125: Expected O, but got Unknown
		//IL_0146: Unknown result type (might be due to invalid IL or missing references)
		//IL_0150: Expected O, but got Unknown
		//IL_0151: Unknown result type (might be due to invalid IL or missing references)
		//IL_0158: Expected O, but got Unknown
		//IL_0179: Unknown result type (might be due to invalid IL or missing references)
		//IL_0183: Expected O, but got Unknown
		//IL_0189: Unknown result type (might be due to invalid IL or missing references)
		//IL_0190: Expected O, but got Unknown
		//IL_01b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_01bb: Expected O, but got Unknown
		//IL_01bc: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c3: Expected O, but got Unknown
		//IL_01e4: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ee: Expected O, but got Unknown
		//IL_01f4: Unknown result type (might be due to invalid IL or missing references)
		//IL_01fb: Expected O, but got Unknown
		//IL_021c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0226: Expected O, but got Unknown
		//IL_0227: Unknown result type (might be due to invalid IL or missing references)
		//IL_022e: Expected O, but got Unknown
		//IL_024f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0259: Expected O, but got Unknown
		//IL_025a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0261: Expected O, but got Unknown
		//IL_0282: Unknown result type (might be due to invalid IL or missing references)
		//IL_028c: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val9 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(ProfileImageViewerPage_Loaded));
			FrameworkElement val10 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(ProfileImageViewerPage_SizeChanged));
			break;
		}
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(Delete_Click);
			break;
		case 3:
			((ImageButton)target).Click += new RoutedEventHandler(Edit_Click);
			break;
		case 4:
			((ImageButton)target).Click += new RoutedEventHandler(Update_Click);
			break;
		case 5:
		{
			ButtonBase val8 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		case 6:
		{
			Selector val6 = (Selector)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SelectionChangedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(Selector.add_SelectionChanged)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(Selector.remove_SelectionChanged)), new SelectionChangedEventHandler(OnProfileSelectionChanged));
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnImageListtapped));
			break;
		}
		case 7:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(OnProfileImageItemTapped));
			Image val5 = (Image)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(Image.add_ImageOpened)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(Image.remove_ImageOpened)), new RoutedEventHandler(OnImageItemOpened));
			break;
		}
		case 8:
		{
			FrameworkElement val = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(OnSourceImageLoaded));
			FrameworkElement val2 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(OnSourceSizeChanged));
			Image val3 = (Image)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(Image.add_ImageOpened)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(Image.remove_ImageOpened)), new RoutedEventHandler(OnSourceImageOpened));
			break;
		}
		}
		_contentLoaded = true;
	}
}
