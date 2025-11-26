using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Views;
using ChatOn.Models;
using ChatOn.ViewModels;
using Windows.UI.Core;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class UnknownBuddyProfileDialog : UserControl, IComponentConnector
{
	public static readonly DependencyProperty PhotoProperty = DependencyProperty.RegisterAttached("BuddyInfo", typeof(Buddy), typeof(BuddyProfileDialog), (PropertyMetadata)null);

	private UnknownBuddyProfilePageViewModel _viewModel;

	private Page _parentPage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel DetailGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock WarningText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CloseButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid ProfileImageGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid BlockGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid UnBlockGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public UnknownUser BuddyInfo
	{
		get
		{
			return (UnknownUser)((DependencyObject)this).GetValue(PhotoProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(PhotoProperty, (object)value);
		}
	}

	public Page ParentPage
	{
		get
		{
			return _parentPage;
		}
		set
		{
			_parentPage = value;
		}
	}

	public UnknownBuddyProfileDialog()
	{
		InitializeComponent();
		_viewModel = new UnknownBuddyProfilePageViewModel(this);
	}

	private void BuddyProfileDialog_Loaded(object sender, RoutedEventArgs e)
	{
		_viewModel.OnNavigatedTo(BuddyInfo);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		_ = BuddyInfo.IsDeregistered;
		if (BuddyListPage.ActiveInstance != null && ((FrameworkElement)BuddyListPage.ActiveInstance).ActualHeight > 0.0)
		{
			((FrameworkElement)LayoutRoot).put_Height(((FrameworkElement)BuddyListPage.ActiveInstance).ActualHeight - 30.0);
		}
	}

	public void UpdateBuddyList()
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			PivotPage.ActiveInstance.ViewModel.UpdateList();
		});
	}

	internal void ShowLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
	}

	private void BlockGrid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		_viewModel.BlockBuddy();
	}

	public void Close()
	{
		DependencyObject parent = ((FrameworkElement)this).Parent;
		if (((FrameworkElement)((parent is FrameworkElement) ? parent : null)).Parent is CustomPopup customPopup)
		{
			customPopup.Close();
			return;
		}
		DependencyObject parent2 = ((FrameworkElement)this).Parent;
		DependencyObject parent3 = ((FrameworkElement)((parent2 is FrameworkElement) ? parent2 : null)).Parent;
		Grid val = (Grid)(object)((parent3 is Grid) ? parent3 : null);
		if (val != null)
		{
			((UIElement)this).put_Visibility((Visibility)1);
		}
	}

	internal void AddFlagImage(UnknownUser buddy)
	{
		_viewModel.AddFlagImage(ProfileImageGrid, buddy);
	}

	internal void AddWarningMessage()
	{
		_viewModel.AddWarningImage(ProfileImageGrid);
	}

	private void AddBuddyTapped(object sender, TappedRoutedEventArgs e)
	{
		_viewModel.AddBuddy(BuddyInfo.Name, BuddyInfo.PhoneNumber);
	}

	private void UnBlockGrid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		_viewModel.UnBlockBuddy();
	}

	private void Close_Click(object sender, RoutedEventArgs e)
	{
		((UIElement)this).put_Visibility((Visibility)1);
		if (((FrameworkElement)this).Parent is Grid)
		{
			Close();
			if (BuddyListPage.ActiveInstance != null)
			{
				BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: true);
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
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///UnknownBuddyProfileDialog.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			DetailGrid = (StackPanel)((FrameworkElement)this).FindName("DetailGrid");
			WarningText = (TextBlock)((FrameworkElement)this).FindName("WarningText");
			CloseButton = (ImageButton)((FrameworkElement)this).FindName("CloseButton");
			ProfileImageGrid = (Grid)((FrameworkElement)this).FindName("ProfileImageGrid");
			BlockGrid = (Grid)((FrameworkElement)this).FindName("BlockGrid");
			UnBlockGrid = (Grid)((FrameworkElement)this).FindName("UnBlockGrid");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0024: Unknown result type (might be due to invalid IL or missing references)
		//IL_002a: Expected O, but got Unknown
		//IL_0049: Unknown result type (might be due to invalid IL or missing references)
		//IL_0053: Expected O, but got Unknown
		//IL_0065: Unknown result type (might be due to invalid IL or missing references)
		//IL_006f: Expected O, but got Unknown
		//IL_0075: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		//IL_009a: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a4: Expected O, but got Unknown
		//IL_00a7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ad: Expected O, but got Unknown
		//IL_00cc: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d6: Expected O, but got Unknown
		//IL_00d9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e0: Expected O, but got Unknown
		//IL_0101: Unknown result type (might be due to invalid IL or missing references)
		//IL_010b: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val4 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(BuddyProfileDialog_Loaded));
			break;
		}
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(Close_Click);
			break;
		case 3:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(AddBuddyTapped));
			break;
		}
		case 4:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BlockGrid_Tapped_1));
			break;
		}
		case 5:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(UnBlockGrid_Tapped_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
