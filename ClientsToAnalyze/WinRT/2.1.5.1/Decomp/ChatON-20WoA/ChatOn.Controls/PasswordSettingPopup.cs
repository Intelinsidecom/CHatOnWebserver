using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class PasswordSettingPopup : UserControl, IComponentConnector
{
	public delegate void PasswordSettingEventHandler(object sender, object e);

	private PasswordSettingPopupViewModel _viewModel;

	private int _count;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock TitleText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private PasswordBox CurrentPasswordbox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private PasswordBox NewPasswordbox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private PasswordBox ConfirmPasswordbox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox PasswordHint;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock HintMessage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public event PasswordSettingEventHandler Completed;

	public PasswordSettingPopup()
	{
		InitializeComponent();
		_viewModel = new PasswordSettingPopupViewModel();
		((FrameworkElement)this).put_DataContext((object)_viewModel);
	}

	private void PasswordSettingPopup_KeyUp(object sender, KeyRoutedEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0008: Invalid comparison between Unknown and I4
		//IL_0072: Unknown result type (might be due to invalid IL or missing references)
		//IL_0078: Invalid comparison between Unknown and I4
		if ((int)e.Key == 13 && ((CurrentPasswordbox.PasswordChar.Length > 0 && NewPasswordbox.PasswordChar.Length > 0 && PasswordHint.Text.Length > 0 && ConfirmPasswordbox.PasswordChar.Length > 0) || (CurrentPasswordbox.PasswordChar.Length > 0 && (int)_viewModel.NewPasswordVisibility == 1)) && _viewModel.OnSetPassword(CurrentPasswordbox.Password, NewPasswordbox.Password, ConfirmPasswordbox.Password, PasswordHint.Text))
		{
			Close();
			if (this.Completed != null)
			{
				this.Completed(this, true);
			}
		}
	}

	private void PasswordSettingPopup_Loaded(object sender, RoutedEventArgs e)
	{
		switch (_viewModel.Mode)
		{
		case PasswordSettingPopupViewModel.PasswordSettingMode.NewPassword:
			((Control)NewPasswordbox).Focus((FocusState)1);
			break;
		case PasswordSettingPopupViewModel.PasswordSettingMode.ChangePassword:
			((Control)CurrentPasswordbox).Focus((FocusState)1);
			break;
		case PasswordSettingPopupViewModel.PasswordSettingMode.DisablePassword:
			TitleText.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_PASSWORD"));
			((Control)CurrentPasswordbox).Focus((FocusState)1);
			HintMessage.put_Text(Utility.GetResourceString("IDS_CHATON_MBODY_PASSWORD_HINT") + ":" + SettingService.GetPasswordHint());
			((UIElement)HintMessage).put_Visibility((Visibility)1);
			break;
		case PasswordSettingPopupViewModel.PasswordSettingMode.ChangeHint:
			TitleText.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_SET_PASSWORD_HINT_ABB"));
			((Control)PasswordHint).Focus((FocusState)1);
			break;
		}
	}

	public void CreateNewPassword()
	{
		_viewModel.Mode = PasswordSettingPopupViewModel.PasswordSettingMode.NewPassword;
	}

	public void DeletePassword()
	{
		_viewModel.Mode = PasswordSettingPopupViewModel.PasswordSettingMode.DisablePassword;
	}

	public void ChangePassword()
	{
		_viewModel.Mode = PasswordSettingPopupViewModel.PasswordSettingMode.ChangePassword;
	}

	public void ChangeHint()
	{
		_viewModel.Mode = PasswordSettingPopupViewModel.PasswordSettingMode.ChangeHint;
		PasswordHint.put_Text(SettingService.GetPasswordHint());
	}

	private void Next_Click(object sender, RoutedEventArgs e)
	{
		_count++;
		if (_count >= 5)
		{
			((UIElement)HintMessage).put_Visibility((Visibility)0);
		}
		if (_viewModel.OnSetPassword(CurrentPasswordbox.Password, NewPasswordbox.Password, ConfirmPasswordbox.Password, PasswordHint.Text))
		{
			Close();
			if (this.Completed != null)
			{
				this.Completed(this, true);
			}
		}
	}

	private void Cancel_Click(object sender, RoutedEventArgs e)
	{
		Close();
		if (this.Completed != null)
		{
			this.Completed(this, false);
		}
	}

	public void Close()
	{
		DependencyObject parent = ((FrameworkElement)this).Parent;
		if (((FrameworkElement)((parent is FrameworkElement) ? parent : null)).Parent is CustomPopup customPopup)
		{
			customPopup.Close();
		}
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///PasswordSettingPopup.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitleText = (TextBlock)((FrameworkElement)this).FindName("TitleText");
			CurrentPasswordbox = (PasswordBox)((FrameworkElement)this).FindName("CurrentPasswordbox");
			NewPasswordbox = (PasswordBox)((FrameworkElement)this).FindName("NewPasswordbox");
			ConfirmPasswordbox = (PasswordBox)((FrameworkElement)this).FindName("ConfirmPasswordbox");
			PasswordHint = (TextBox)((FrameworkElement)this).FindName("PasswordHint");
			HintMessage = (TextBlock)((FrameworkElement)this).FindName("HintMessage");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Expected O, but got Unknown
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Expected O, but got Unknown
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Expected O, but got Unknown
		//IL_0071: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		//IL_007e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0084: Expected O, but got Unknown
		//IL_00a3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ad: Expected O, but got Unknown
		//IL_00b0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b7: Expected O, but got Unknown
		//IL_00d8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e2: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val3 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(PasswordSettingPopup_Loaded));
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<KeyEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_KeyUp)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_KeyUp)), new KeyEventHandler(PasswordSettingPopup_KeyUp));
			break;
		}
		case 2:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Next_Click));
			break;
		}
		case 3:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Cancel_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
