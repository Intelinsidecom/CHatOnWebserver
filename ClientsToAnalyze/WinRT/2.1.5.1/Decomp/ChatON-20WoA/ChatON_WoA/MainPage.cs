using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.Foundation;
using Windows.System;
using Windows.UI.ApplicationSettings;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA;

public sealed class MainPage : Page, IComponentConnector
{
	private MainPageViewModel _viewModel;

	private static MainPage _activeInstance;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static MainPage ActiveInstance => _activeInstance;

	public unsafe MainPage()
	{
		//IL_007e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0088: Expected O, but got Unknown
		InitializeComponent();
		_viewModel = new MainPageViewModel((Page)(object)this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		_activeInstance = this;
		SettingsPane forCurrentView = SettingsPane.GetForCurrentView();
		WindowsRuntimeMarshal.AddEventHandler(new Func<TypedEventHandler<SettingsPane, SettingsPaneCommandsRequestedEventArgs>, EventRegistrationToken>(forCurrentView, (nint)__ldftn(SettingsPane.add_CommandsRequested)), new Action<EventRegistrationToken>(forCurrentView, (nint)__ldftn(SettingsPane.remove_CommandsRequested)), CommandsRequested);
		Window current = Window.Current;
		WindowsRuntimeMarshal.AddEventHandler(new Func<WindowSizeChangedEventHandler, EventRegistrationToken>(current, (nint)__ldftn(Window.add_SizeChanged)), new Action<EventRegistrationToken>(current, (nint)__ldftn(Window.remove_SizeChanged)), new WindowSizeChangedEventHandler(Current_SizeChanged));
	}

	public static void Current_SizeChanged(object sender, WindowSizeChangedEventArgs e)
	{
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_001d: Invalid comparison between Unknown and I4
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		if (userAccount == null || string.IsNullOrEmpty(userAccount.Uid))
		{
			if ((int)ApplicationView.Value == 2)
			{
				((Page)ActiveInstance).Frame.Navigate(typeof(SnappedRegistrationPage));
			}
			else if (SnappedRegistrationPage.ActiveInstance != null)
			{
				((Page)SnappedRegistrationPage.ActiveInstance).Frame.GoBack();
			}
		}
	}

	public static void CommandsRequested(SettingsPane sender, SettingsPaneCommandsRequestedEventArgs args)
	{
		//IL_001d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0027: Expected O, but got Unknown
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		//IL_0079: Unknown result type (might be due to invalid IL or missing references)
		//IL_0083: Expected O, but got Unknown
		//IL_007e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0088: Expected O, but got Unknown
		//IL_00d5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00df: Expected O, but got Unknown
		//IL_00da: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e4: Expected O, but got Unknown
		SettingsCommand command = new SettingsCommand((object)"1", Utility.GetResourceString("IDS_CHATON_SK1_TERMS_AND_CONDITIONS"), new UICommandInvokedHandler(onSettingsCommand));
		SettingsCommand val = args.Request.ApplicationCommands.FirstOrDefault((SettingsCommand x) => x.Id == command.Id || x.Label == command.Label);
		if (val == null)
		{
			args.Request.ApplicationCommands.Add(command);
		}
		command = new SettingsCommand((object)"2", Utility.GetResourceString("IDS_CHATON_SK1_PRIVACY_POLICY"), new UICommandInvokedHandler(onSettingsCommand));
		SettingsCommand val2 = args.Request.ApplicationCommands.FirstOrDefault((SettingsCommand x) => x.Id == command.Id || x.Label == command.Label);
		if (val2 == null)
		{
			args.Request.ApplicationCommands.Add(command);
		}
		command = new SettingsCommand((object)"3", Utility.GetResourceString("setting_notificiation_service_notification"), new UICommandInvokedHandler(onSettingsCommand));
		SettingsCommand val3 = args.Request.ApplicationCommands.FirstOrDefault((SettingsCommand x) => x.Id == command.Id || x.Label == command.Label);
		if (val3 == null)
		{
			args.Request.ApplicationCommands.Add(command);
		}
	}

	private static void onSettingsCommand(IUICommand command)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		SettingsCommand val = (SettingsCommand)command;
		UserAccountInfo userAccount = RegistrationService.GetUserAccount();
		string text = "310";
		if (userAccount != null && !string.IsNullOrEmpty(userAccount.Mcc))
		{
			text = userAccount.Mcc;
		}
		if (val.Id == "1")
		{
			Launcher.LaunchUriAsync(new Uri("http://smm.samsung.com/mwv/disclaimer.html?c=" + text));
		}
		else if (val.Id == "2")
		{
			Launcher.LaunchUriAsync(new Uri("http://smm.samsung.com/mwv/disclaimer.html?c=" + text + "&f=PP"));
		}
		else
		{
			Launcher.LaunchUriAsync(new Uri("http://smm.samsung.com/mwv/disclaimer.html?c=" + text + "&f=SMM"));
		}
	}

	protected override async void OnNavigatedTo(NavigationEventArgs e)
	{
		try
		{
			string uri = ((e.Uri != null) ? e.Uri.ToString() : "");
			_viewModel.OnNavigatedTo(uri);
			if (SettingService.IsFirstRun())
			{
				if (await _viewModel.WarnDataPackageUse())
				{
					if (await _viewModel.CheckUserAge())
					{
						if (await _viewModel.CheckPushUsed())
						{
							SettingService.SetUsingPushNotification(isUsed: true);
							SettingService.SetToggleNewUpdatesPushNotification(isUsed: true);
							SettingService.SetTogglePushMarketingNotification(isUsed: true);
							if (LoadingIndicator.ActiveIndicator != null)
							{
								LoadingIndicator.StopLoading();
							}
							LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
							_viewModel.FindPushService();
						}
						else
						{
							await _viewModel.ShowPushOffAlert();
							_viewModel.OpenNextPage();
						}
						SettingService.SetFirstRun(isFirst: false);
					}
					else
					{
						Application.Current.Exit();
					}
				}
				else
				{
					Application.Current.Exit();
				}
			}
			else if (SettingService.IsUsingPushNotification())
			{
				if (LoadingIndicator.ActiveIndicator != null)
				{
					LoadingIndicator.StopLoading();
				}
				LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
				_viewModel.FindPushService();
			}
			else
			{
				_viewModel.OpenNextPage();
			}
		}
		catch
		{
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///MainPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
