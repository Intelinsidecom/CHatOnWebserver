using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.InfraStructure;
using ChatON_WoA.ViewModels;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using Windows.Storage;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class InvitationTwitterPage : Page, IComponentConnector
{
	private StorageFile _imageFileToShare;

	private bool _isTwitterAvailable;

	private OauthBase _oauthBase = new OauthBase();

	private TellFriendsTwitterPageViewModel _viewModel;

	private string FriendName = "";

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton PostButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CancelButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox txtMessage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtRemaining;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image imgProfile;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtScreenName;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public InvitationTwitterPage()
	{
		_viewModel = new TellFriendsTwitterPageViewModel(TellFriendsTwitterPage.ActiveInstance);
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		CancelButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_CANCEL_ABB");
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		_viewModel.LoadMyInformation();
		FriendName = (string)e.Parameter;
		PostButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_POST_ABB");
		string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_CHATON_INVITE_MESSAGE_ABB");
		resourceString = resourceString.Replace("\\n", "\n");
		txtMessage.put_Text("@" + FriendName + " " + resourceString);
		UpdateRemaining();
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		((Page)this).OnNavigatedFrom(e);
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private async void Post_Click(object sender, RoutedEventArgs e)
	{
		if (!(await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_SHARE_CHATON_INVITATION_MESSAGE_Q"), showCancel: true, Utility.GetResourceString("IDS_CHATON_HEADER_TWITTER"))))
		{
			return;
		}
		if (txtMessage.Text.Length <= 140)
		{
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot, Utility.GetResourceString("IDS_CHATON_POP_POSTING_ING_FACEBOOK"));
			bool result = await _viewModel.PostInvitationMessage(txtMessage.Text);
			LoadingIndicator.StopLoading();
			if (result)
			{
				await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTED"), showCancel: false);
			}
			else
			{
				await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_POSTING_FAILED"), showCancel: false);
			}
		}
		else
		{
			await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_MAXIMUM_CHARACTER_LIMIT_EXCEEDED"), showCancel: false);
		}
	}

	private void Cancel_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private void txtMessage_KeyUp(object sender, KeyRoutedEventArgs e)
	{
		UpdateRemaining();
	}

	private void UpdateRemaining()
	{
		int num = 140;
		int num2 = num - txtMessage.Text.Length;
		txtRemaining.put_Text(num2.ToString());
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
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///InvitationTwitterPage.xaml"), (ComponentResourceLocation)0);
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			PostButton = (ImageButton)((FrameworkElement)this).FindName("PostButton");
			CancelButton = (ImageButton)((FrameworkElement)this).FindName("CancelButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			txtMessage = (TextBox)((FrameworkElement)this).FindName("txtMessage");
			txtRemaining = (TextBlock)((FrameworkElement)this).FindName("txtRemaining");
			imgProfile = (Image)((FrameworkElement)this).FindName("imgProfile");
			txtScreenName = (TextBlock)((FrameworkElement)this).FindName("txtScreenName");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Expected O, but got Unknown
		//IL_0052: Unknown result type (might be due to invalid IL or missing references)
		//IL_0058: Expected O, but got Unknown
		//IL_0077: Unknown result type (might be due to invalid IL or missing references)
		//IL_0081: Expected O, but got Unknown
		//IL_0084: Unknown result type (might be due to invalid IL or missing references)
		//IL_008a: Expected O, but got Unknown
		//IL_00a9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b3: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
			((ImageButton)target).Click += new RoutedEventHandler(Post_Click);
			break;
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(Cancel_Click);
			break;
		case 3:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<KeyEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_KeyUp)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_KeyUp)), new KeyEventHandler(txtMessage_KeyUp));
			break;
		}
		case 4:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
