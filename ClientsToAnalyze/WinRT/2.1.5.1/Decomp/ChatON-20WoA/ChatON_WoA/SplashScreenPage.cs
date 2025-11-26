using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.ViewModels;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA;

public sealed class SplashScreenPage : Page, IComponentConnector
{
	private SplashScreenPageViewModel _viewModel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image imgLogoChatON;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public unsafe SplashScreenPage()
	{
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Expected O, but got Unknown
		_viewModel = new SplashScreenPageViewModel((Page)(object)this);
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(SplashScreenPage_Loaded));
	}

	private void SplashScreenPage_Loaded(object sender, RoutedEventArgs e)
	{
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
	}

	protected override void OnNavigatingFrom(NavigatingCancelEventArgs e)
	{
		_viewModel.OnNavigatingFrom();
		((Page)this).OnNavigatingFrom(e);
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SplashScreenPage.xaml"), (ComponentResourceLocation)0);
			imgLogoChatON = (Image)((FrameworkElement)this).FindName("imgLogoChatON");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
