using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn_WoA.Services;
using ChatON_WoA.ViewModels;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.Foundation;
using Windows.UI.Input;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class SyncIntroPage : Page, IComponentConnector
{
	private Point _startPoint;

	private SyncIntroPageViewModel _viewModel;

	private SamsungAccountService _ssaService;

	private string _email;

	private static SyncIntroPage _instance;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button NextButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button SignInButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button SkipButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static SyncIntroPage ActiveInstance => _instance;

	public SyncIntroPage()
	{
		_viewModel = new SyncIntroPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		_instance = this;
		_ssaService = new SamsungAccountService();
		InitializeComponent();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		_viewModel.CheckStatusSignin();
	}

	internal void OpenDialog(UserControl dialog, bool closePrevPopup = false)
	{
		if (closePrevPopup)
		{
			CloseAllPopup();
		}
		new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)dialog);
	}

	private void SkipButton_Click(object sender, RoutedEventArgs e)
	{
		if (string.IsNullOrEmpty(RegistrationService.ChatOnID))
		{
			PageNavigationService.OpenSelectLanguagePage((Page)(object)this);
		}
		else
		{
			Utility.SafetyGoBack((Page)(object)this);
		}
	}

	private void SignInButton_Click(object sender, RoutedEventArgs e)
	{
		((Control)NextButton).put_IsEnabled(false);
		((Control)SkipButton).put_IsEnabled(false);
		((Control)SignInButton).put_IsEnabled(false);
		OpenSamsungAccountSigninPage();
		((Control)NextButton).put_IsEnabled(true);
		((Control)SkipButton).put_IsEnabled(true);
	}

	internal void CloseAllPopup()
	{
		int count = ((ICollection<UIElement>)((Panel)LayoutRoot).Children).Count;
		for (int num = count - 1; num >= 0; num--)
		{
			UIElement val = ((IList<UIElement>)((Panel)LayoutRoot).Children)[num];
			if ((object)((object)val).GetType() == typeof(CustomPopup))
			{
				((ICollection<UIElement>)((Panel)LayoutRoot).Children).Remove(val);
			}
		}
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		SamsungAccountSigninDialog.Type = null;
		((Page)this).OnNavigatedFrom(e);
	}

	internal void OpenSamsungAccountSigninPage()
	{
		if (SamsungAccountSigninDialog.Type == null)
		{
			SamsungAccountSigninDialog.Type = "signin";
			new SamsungAccountSigninDialog((Page)(object)this, (Panel)(object)LayoutRoot);
		}
	}

	public void DisableSkipButton()
	{
		((Control)SkipButton).put_IsEnabled(false);
	}

	private void LayoutRoot_PointerPressed(object sender, PointerRoutedEventArgs e)
	{
		PointerPoint currentPoint = e.GetCurrentPoint((UIElement)((sender is StackPanel) ? sender : null));
		_startPoint = currentPoint.Position;
		Point position = currentPoint.Position;
		if (Math.Abs(_startPoint.X - position.X) >= 0.0)
		{
			_viewModel.ChangeSyncIntroImage(_startPoint.X > position.X);
		}
	}

	private void NextButton_Click(object sender, RoutedEventArgs e)
	{
		((Control)NextButton).put_IsEnabled(false);
		((Control)SkipButton).put_IsEnabled(false);
		((Control)SignInButton).put_IsEnabled(false);
		if (SettingService.GetSignedOnSamsungAccount())
		{
			_email = SettingService.GetSamsungEmail();
		}
		RegistrationService.TempEmail = _email;
		PageNavigationService.OpenInputNamePage((Page)(object)this, "?mode=SamsungAccount&code=" + SamsungAccountService.AccessToken + "&email=" + _email);
		((Control)NextButton).put_IsEnabled(true);
		((Control)SkipButton).put_IsEnabled(true);
		((Control)SignInButton).put_IsEnabled(true);
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///SyncIntroPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			NextButton = (Button)((FrameworkElement)this).FindName("NextButton");
			SignInButton = (Button)((FrameworkElement)this).FindName("SignInButton");
			SkipButton = (Button)((FrameworkElement)this).FindName("SkipButton");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Expected O, but got Unknown
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_005b: Expected O, but got Unknown
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0084: Expected O, but got Unknown
		//IL_0087: Unknown result type (might be due to invalid IL or missing references)
		//IL_008d: Expected O, but got Unknown
		//IL_00ac: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b6: Expected O, but got Unknown
		//IL_00b9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c0: Expected O, but got Unknown
		//IL_00e1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00eb: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<PointerEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_PointerPressed)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_PointerPressed)), new PointerEventHandler(LayoutRoot_PointerPressed));
			break;
		}
		case 2:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(NextButton_Click));
			break;
		}
		case 3:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(SignInButton_Click));
			break;
		}
		case 4:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(SkipButton_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
