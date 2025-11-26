using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.ViewModels;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class TrunkDetailFullViewPage : Page, IComponentConnector
{
	private TrunkDetailFullViewPageViewModel _viewModel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton DeleteButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton ShareButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton SaveButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtComment;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public TrunkDetailFullViewPage()
	{
		_viewModel = new TrunkDetailFullViewPageViewModel(this);
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		DeleteButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_DELETE");
		SaveButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_SAVE");
		ShareButton.Text = Utility.GetResourceString("IDS_CHATON_BODY_SHARE");
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		((Page)this).OnNavigatedFrom(e);
		_viewModel.OnNavigatedFrom();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e.Parameter != null)
		{
			TrunkFullMode trunkFullMode = null;
			if (e.Parameter is TrunkFullMode trunkFullMode2)
			{
				_viewModel.OpenTrunkItemDetail(trunkFullMode2);
				txtComment.put_Text(trunkFullMode2.Item.Totcmtcnt + " " + Utility.GetResourceString("IDS_CHATON_BODY_COMMENTS"));
			}
		}
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private void Tap_GoBack_Click(object sender, TappedRoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private async void Delete_Click(object sender, RoutedEventArgs e)
	{
		if (await Utility.ShowOKCancleMessageDialog(Utility.GetResourceString("IDS_CHATON_POP_DELETE_Q")))
		{
			_viewModel.DeleteItem();
		}
	}

	private void ShareButton_Click_1(object sender, RoutedEventArgs e)
	{
		try
		{
			_viewModel.ShareTrunkItem();
		}
		catch (Exception)
		{
		}
	}

	private void SaveButton_Click_1(object sender, RoutedEventArgs e)
	{
		_viewModel.SaveTrunkItem();
	}

	public void ShowSplashPopup(string text, bool warning)
	{
		Utility.ShowSimpleToastNotification(text);
	}

	public void ShowLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
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
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///TrunkDetailFullViewPage.xaml"), (ComponentResourceLocation)0);
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			DeleteButton = (ImageButton)((FrameworkElement)this).FindName("DeleteButton");
			ShareButton = (ImageButton)((FrameworkElement)this).FindName("ShareButton");
			SaveButton = (ImageButton)((FrameworkElement)this).FindName("SaveButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			txtComment = (TextBlock)((FrameworkElement)this).FindName("txtComment");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0030: Unknown result type (might be due to invalid IL or missing references)
		//IL_003a: Expected O, but got Unknown
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Expected O, but got Unknown
		//IL_0065: Unknown result type (might be due to invalid IL or missing references)
		//IL_006f: Expected O, but got Unknown
		//IL_0072: Unknown result type (might be due to invalid IL or missing references)
		//IL_0078: Expected O, but got Unknown
		//IL_0097: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a1: Expected O, but got Unknown
		//IL_00a4: Unknown result type (might be due to invalid IL or missing references)
		//IL_00aa: Expected O, but got Unknown
		//IL_00c9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d3: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
			((ImageButton)target).Click += new RoutedEventHandler(Delete_Click);
			break;
		case 2:
			((ImageButton)target).Click += new RoutedEventHandler(ShareButton_Click_1);
			break;
		case 3:
			((ImageButton)target).Click += new RoutedEventHandler(SaveButton_Click_1);
			break;
		case 4:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Tap_GoBack_Click));
			break;
		}
		case 5:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
