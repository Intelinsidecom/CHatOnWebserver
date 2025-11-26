using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.ViewModels;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA;

public sealed class MultiDeviceInfoPage : Page, IComponentConnector
{
	private MultiDeviceInfoPageViewModel _viewModel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView DeviceList;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock EmailText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public MultiDeviceInfoPage()
	{
		InitializeComponent();
		_viewModel = new MultiDeviceInfoPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		EmailText.put_Text(RegistrationService.GetUserProfile().Email);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
	}

	private void Delete_Click_1(object sender, RoutedEventArgs e)
	{
		MappingInfo device = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as MappingInfo;
		_viewModel.Deregister(device);
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///MultiDeviceInfoPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			DeviceList = (ListView)((FrameworkElement)this).FindName("DeviceList");
			EmailText = (TextBlock)((FrameworkElement)this).FindName("EmailText");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		if (connectionId == 1)
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Delete_Click_1));
		}
		_contentLoaded = true;
	}
}
