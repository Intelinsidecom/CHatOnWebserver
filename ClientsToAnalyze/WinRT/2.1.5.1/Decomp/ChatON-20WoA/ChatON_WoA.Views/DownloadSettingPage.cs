using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.DataModel;
using ChatON_WoA.InfraStructure;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.ViewModels;
using Windows.UI.Core;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class DownloadSettingPage : Page, IComponentConnector
{
	private static DownloadSettingPage _activeInstance;

	private IndeterminateProgressbar _progressControl = new IndeterminateProgressbar();

	private bool _isLoaded;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView List;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ComboBox cmbSelectSort;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton DownloadAllButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static DownloadSettingPage ActiveInstance => _activeInstance;

	public DownloadSettingPageViewModel ViewModel => (DownloadSettingPageViewModel)((FrameworkElement)this).DataContext;

	public bool IsLoaded
	{
		get
		{
			return _isLoaded;
		}
		set
		{
			_isLoaded = value;
		}
	}

	public DownloadSettingPage()
	{
		InitializeComponent();
		((ICollection<object>)((ItemsControl)cmbSelectSort).Items).Add((object)Utility.GetResourceString("IDS_CHATON_BODY_MOST_RECENT"));
		((ICollection<object>)((ItemsControl)cmbSelectSort).Items).Add((object)Utility.GetResourceString("IDS_CHATON_POP_TITLE"));
		((ICollection<object>)((ItemsControl)cmbSelectSort).Items).Add((object)Utility.GetResourceString("IDS_CHATON_POP_CHARACTER_M_SORT"));
		((ICollection<object>)((ItemsControl)cmbSelectSort).Items).Add((object)Utility.GetResourceString("IDS_CHATON_POP_POPULARITY"));
		((FrameworkElement)this).put_DataContext((object)new DownloadSettingPageViewModel(this));
	}

	private void DownloadSettingPage_Unloaded(object sender, RoutedEventArgs e)
	{
		_isLoaded = false;
	}

	private unsafe void DownloadSettingPage_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		_isLoaded = true;
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowSizeChangedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_SizeChanged)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
		((Control)cmbSelectSort).put_IsEnabled(true);
		((Control)cmbSelectSort).Focus((FocusState)1);
	}

	private void Current_SizeChanged(object sender, WindowSizeChangedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value == 2)
		{
			((Control)cmbSelectSort).put_IsEnabled(false);
		}
	}

	private void DownloadButton_Click_1(object sender, RoutedEventArgs e)
	{
		try
		{
			AniconPackage aniconPackage = null;
			if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is AniconPackage aniconPackage2)
			{
				if (aniconPackage2.IsNeedDownload)
				{
					ViewModel.DownloadPackage(aniconPackage2);
				}
				else
				{
					UninstallPackage(aniconPackage2);
				}
			}
		}
		catch
		{
		}
	}

	private async void UninstallPackage(AniconPackage package)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			string msg = Utility.GetResourceString("IDS_CHATON_POP_UNINSTALL_PS_Q").Replace("%s", package.Name);
			if (await Utility.ShowOKCancleMessageDialog(msg, showCancel: true, Utility.GetResourceString("IDS_CHATON_BUTTON_UNINSTALL_ABB")))
			{
				ViewModel.DeletePackage(package);
				msg = Utility.GetResourceString("IDS_CHATON_POP_PS_HAS_BEEN_UNINSTALLED").Replace("%s", package.Name);
				Utility.ShowSimpleToastNotification(msg);
			}
		}
		catch (UnauthorizedAccessException)
		{
		}
		catch (Exception)
		{
		}
	}

	public void ShowProgress()
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			_progressControl.Show((Panel)(object)LayoutRoot);
		});
	}

	public void HideProgress()
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			_progressControl.Hide();
		});
	}

	private void DownloadAllButton_Click(object sender, RoutedEventArgs e)
	{
		ViewModel.DownloadAllAnicon();
	}

	private void CancelDownload_Click(object sender, RoutedEventArgs e)
	{
		AniconPackage aniconPackage = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is AniconPackage package)
		{
			ViewModel.CancelDownload(package);
		}
	}

	protected override void OnNavigatingFrom(NavigatingCancelEventArgs e)
	{
		((Page)this).OnNavigatingFrom(e);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		SettingsPage.ActiveInstance.StopLoading();
		((Page)this).OnNavigatedFrom(e);
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///DownloadSettingPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			List = (ListView)((FrameworkElement)this).FindName("List");
			cmbSelectSort = (ComboBox)((FrameworkElement)this).FindName("cmbSelectSort");
			DownloadAllButton = (ImageButton)((FrameworkElement)this).FindName("DownloadAllButton");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Expected O, but got Unknown
		//IL_0050: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Expected O, but got Unknown
		//IL_0075: Unknown result type (might be due to invalid IL or missing references)
		//IL_007f: Expected O, but got Unknown
		//IL_0082: Unknown result type (might be due to invalid IL or missing references)
		//IL_0088: Expected O, but got Unknown
		//IL_00a7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b1: Expected O, but got Unknown
		//IL_00b4: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		//IL_00dc: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e6: Expected O, but got Unknown
		//IL_00f5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ff: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val3 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(DownloadSettingPage_Loaded));
			FrameworkElement val4 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.add_Unloaded)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.remove_Unloaded)), new RoutedEventHandler(DownloadSettingPage_Unloaded));
			break;
		}
		case 2:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(CancelDownload_Click));
			break;
		}
		case 3:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(DownloadButton_Click_1));
			break;
		}
		case 4:
			((ImageButton)target).Click += new RoutedEventHandler(DownloadAllButton_Click);
			break;
		}
		_contentLoaded = true;
	}
}
