using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text.RegularExpressions;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class AddBuddiesSayDialog : UserControl, IComponentConnector
{
	private string _phoneNumber;

	private bool usingEnterKey;

	public BuddiesSay LastBuddiesSay;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Border LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputBox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtStatusCharacter;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public string PhoneNumber
	{
		get
		{
			return _phoneNumber;
		}
		set
		{
			_phoneNumber = value;
		}
	}

	public event EventHandler WritMemoCompleted;

	public AddBuddiesSayDialog()
	{
		usingEnterKey = SettingService.GetSendEnterKey();
		InitializeComponent();
	}

	private void InputBox_Loaded(object sender, RoutedEventArgs e)
	{
		((Control)InputBox).Focus((FocusState)1);
		txtStatusCharacter.put_Text(InputBox.MaxLength.ToString());
	}

	private async void UploadButton_Click_1(object sender, RoutedEventArgs e)
	{
		if (string.IsNullOrEmpty(InputBox.Text.Trim()))
		{
			((Control)InputBox).Focus((FocusState)3);
			return;
		}
		if (Utility.IsEmojiIconIncluded(InputBox.Text))
		{
			Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("WP7_FST_EMOJI_NOT_SUPPORTED"), showCancel: false);
			return;
		}
		if (LastBuddiesSay != null && InputBox.Text.Trim() == LastBuddiesSay.Message.Trim() && DateTime.Now.Subtract(Utility.GetDateTimeFromMiliseconds(LastBuddiesSay.TimeStamp)).TotalMinutes <= 15.0)
		{
			string msg = Utility.GetResourceString("IDS_CHATON_POP_COMMENT_ALREADY_POSTED_ON_BUDDIES_SAY");
			await Utility.ShowOKCancleMessageDialog(msg, showCancel: false, Utility.GetResourceString("IDS_CHATON_HEADER_BUDDIES_SAY"));
			return;
		}
		PivotPage.ActiveInstance.ShowLoading();
		SSMService ssmService = new SSMService();
		ssmService.WriteMemoCompleted += ssmService_WriteMemoCompleted;
		ssmService.WriteMemoAsync(_phoneNumber, InputBox.Text.Trim());
	}

	private async void ssmService_WriteMemoCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode != HttpStatusCode.OK)
		{
			if (e.ErrorMessage != null)
			{
				if (e.ErrorMessage.Contains("00800"))
				{
					string msg = Utility.GetResourceString("IDS_CHATON_POP_PSS_SAMSUNG_ACCOUNT_IS_SYNCHRONISING_WITH_CHATON_TRY_LATER");
					msg = msg.Replace("%s", "");
					MessageDialog dialog = new MessageDialog(msg);
					await dialog.ShowAsync();
					return;
				}
				if (e.ErrorMessage.Contains("[CCS-93403]"))
				{
					string msg2 = Utility.GetResourceString("IDS_CHATON_POP_COMMENT_ALREADY_POSTED_ON_BUDDIES_SAY");
					await Utility.ShowOKCancleMessageDialog(msg2, showCancel: false, Utility.GetResourceString("IDS_CHATON_HEADER_BUDDIES_SAY"));
					return;
				}
			}
			if (await Utility.ShowRetryCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_UPDATE_FAILED"), showCancel: true, Utility.GetResourceString("IDS_CHATON_HEADER_BUDDIES_SAY")))
			{
				PivotPage.ActiveInstance.ShowLoading();
				SSMService sSMService = new SSMService();
				sSMService.WriteMemoCompleted -= ssmService_WriteMemoCompleted;
				sSMService.WriteMemoCompleted += ssmService_WriteMemoCompleted;
				sSMService.WriteMemoAsync(_phoneNumber, InputBox.Text);
			}
		}
		else
		{
			InputBox.put_Text("");
			if (this.WritMemoCompleted != null)
			{
				this.WritMemoCompleted(this, null);
			}
			Close();
		}
	}

	private void CancelButton_Click_2(object sender, RoutedEventArgs e)
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			Close();
		});
	}

	private void Close()
	{
		if (((FrameworkElement)this).Parent is FrameworkElement)
		{
			CustomPopup customPopup = null;
			DependencyObject parent = ((FrameworkElement)this).Parent;
			if (((FrameworkElement)((parent is FrameworkElement) ? parent : null)).Parent is CustomPopup customPopup2)
			{
				customPopup2.Close();
			}
		}
	}

	private void InputBox_SelectionChanged_1(object sender, RoutedEventArgs e)
	{
		txtStatusCharacter.put_Text((InputBox.MaxLength - InputBox.Text.Replace("\r\n", string.Empty).Length - Regex.Matches(InputBox.Text, "\r\n").Count).ToString());
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///AddBuddiesSayDialog.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Border)((FrameworkElement)this).FindName("LayoutRoot");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
			txtStatusCharacter = (TextBlock)((FrameworkElement)this).FindName("txtStatusCharacter");
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
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputBox_Loaded));
			TextBox val4 = (TextBox)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(TextBox.add_SelectionChanged)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(TextBox.remove_SelectionChanged)), new RoutedEventHandler(InputBox_SelectionChanged_1));
			break;
		}
		case 2:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(UploadButton_Click_1));
			break;
		}
		case 3:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(CancelButton_Click_2));
			break;
		}
		}
		_contentLoaded = true;
	}
}
