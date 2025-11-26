using System;
using System.CodeDom.Compiler;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.DataModel;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.ViewModels;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class InteractionRankPage : Page, IComponentConnector
{
	private SemanticZoom _currentPanelToShow;

	private InteractionRankPageViewModel _viewModel;

	private DispatcherTimer _timer;

	private ObservableCollection<InteractionRank> _selectedInteractionRanks;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SemanticZoom semanticZoom;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SemanticZoom semanticWeek1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SemanticZoom semanticWeek2;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SemanticZoom semanticWeek3;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image LeftImageControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image RightImageControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView NormalRankControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView SmallRankControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock lastthreeweekBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock lasttwoweekBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock lastweekBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock thisweekBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public InteractionRankPage()
	{
		InitializeComponent();
		ChangeLanguage();
		_viewModel = new InteractionRankPageViewModel(this);
		_viewModel.SelectedIndex = 1;
		((FrameworkElement)this).put_DataContext((object)_viewModel);
	}

	private void InteractionRankPage_Loaded(object sender, RoutedEventArgs e)
	{
		_viewModel.Loaded();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		_viewModel.LoadInteractions();
		_currentPanelToShow = semanticZoom;
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private void OnSwitchDataSource(object sender)
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)1, (DispatchedHandler)delegate
		{
			HideSemanticInteractionPanel();
			object obj = sender;
			string text = ((FrameworkElement)((obj is FrameworkElement) ? obj : null)).Tag as string;
			int selectedIndex = int.Parse(text);
			_viewModel.SelectedIndex = selectedIndex;
			switch (text)
			{
			case "1":
				_currentPanelToShow = semanticZoom;
				((UIElement)semanticZoom).put_Visibility((Visibility)0);
				_viewModel.CheckInteractionCount(_viewModel.ThisWeekRankedBuddies);
				break;
			case "2":
				_currentPanelToShow = semanticWeek1;
				((UIElement)semanticWeek1).put_Visibility((Visibility)0);
				_viewModel.CheckInteractionCount(_viewModel.LastWeekRankedBuddies);
				break;
			case "3":
				_currentPanelToShow = semanticWeek2;
				((UIElement)semanticWeek2).put_Visibility((Visibility)0);
				_viewModel.CheckInteractionCount(_viewModel.LastTwoWeekRankedBuddies);
				break;
			case "4":
				_currentPanelToShow = semanticWeek3;
				((UIElement)semanticWeek3).put_Visibility((Visibility)0);
				_viewModel.CheckInteractionCount(_viewModel.LastThreeWeekRankedBuddies);
				break;
			default:
				_currentPanelToShow = semanticZoom;
				((UIElement)semanticZoom).put_Visibility((Visibility)0);
				_viewModel.CheckInteractionCount(_viewModel.ThisWeekRankedBuddies);
				break;
			}
		});
	}

	public void HideSemanticInteractionPanel()
	{
		if (_currentPanelToShow != null)
		{
			((UIElement)_currentPanelToShow).put_Visibility((Visibility)1);
		}
	}

	private void OnThisWeekClick(object sender, RoutedEventArgs e)
	{
		OnSwitchDataSource(sender);
	}

	private void OnLastWeekClick(object sender, RoutedEventArgs e)
	{
		OnSwitchDataSource(sender);
	}

	private void OnTwoWeeksClick(object sender, RoutedEventArgs e)
	{
		OnSwitchDataSource(sender);
	}

	private void OnThreeWeeksClick(object sender, RoutedEventArgs e)
	{
		OnSwitchDataSource(sender);
	}

	private void ChangeLanguage()
	{
		string resourceString = Utility.GetResourceString("IDS_CHATON_BUTTON_LAST_WEEK");
		string resourceString2 = Utility.GetResourceString("IDS_CHATON_BUTTON_THIS_WEEK");
		string text = Utility.GetResourceString("IDS_CHATON_BODY_PD_WEEKS_AGO").Replace("%d", "2");
		string text2 = Utility.GetResourceString("IDS_CHATON_BODY_PD_WEEKS_AGO").Replace("%d", "3");
		thisweekBtn.put_Text(resourceString2);
		lastweekBtn.put_Text(resourceString);
		lasttwoweekBtn.put_Text(text);
		lastthreeweekBtn.put_Text(text2);
	}

	private async void InteractionRankGrid_OnTapped(object sender, TappedRoutedEventArgs e)
	{
		InteractionRank interactionRank;
		InteractionRank InteractionRank = (interactionRank = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as InteractionRank);
		if (interactionRank == null)
		{
			return;
		}
		_ = InteractionRank.Buddy;
		PopupMenu menu = new PopupMenu();
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_SK1_HIDE_INTERACTIONS"), (UICommandInvokedHandler)null, (object)1));
		try
		{
			if (await menu.ShowForSelectionAsync(Utility.GetElementRect((FrameworkElement)sender)) != null)
			{
				_viewModel.HideInteraction(InteractionRank);
			}
		}
		catch (Exception)
		{
		}
	}

	public void ShowLoading(string text = "Loading...")
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot, text);
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
		//IL_0135: Unknown result type (might be due to invalid IL or missing references)
		//IL_013f: Expected O, but got Unknown
		//IL_014b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Expected O, but got Unknown
		//IL_0161: Unknown result type (might be due to invalid IL or missing references)
		//IL_016b: Expected O, but got Unknown
		//IL_0177: Unknown result type (might be due to invalid IL or missing references)
		//IL_0181: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///InteractionRankPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			semanticZoom = (SemanticZoom)((FrameworkElement)this).FindName("semanticZoom");
			semanticWeek1 = (SemanticZoom)((FrameworkElement)this).FindName("semanticWeek1");
			semanticWeek2 = (SemanticZoom)((FrameworkElement)this).FindName("semanticWeek2");
			semanticWeek3 = (SemanticZoom)((FrameworkElement)this).FindName("semanticWeek3");
			LeftImageControl = (Image)((FrameworkElement)this).FindName("LeftImageControl");
			RightImageControl = (Image)((FrameworkElement)this).FindName("RightImageControl");
			NormalRankControl = (GridView)((FrameworkElement)this).FindName("NormalRankControl");
			SmallRankControl = (GridView)((FrameworkElement)this).FindName("SmallRankControl");
			lastthreeweekBtn = (TextBlock)((FrameworkElement)this).FindName("lastthreeweekBtn");
			lasttwoweekBtn = (TextBlock)((FrameworkElement)this).FindName("lasttwoweekBtn");
			lastweekBtn = (TextBlock)((FrameworkElement)this).FindName("lastweekBtn");
			thisweekBtn = (TextBlock)((FrameworkElement)this).FindName("thisweekBtn");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0030: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_005f: Expected O, but got Unknown
		//IL_0065: Unknown result type (might be due to invalid IL or missing references)
		//IL_006b: Expected O, but got Unknown
		//IL_008a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0094: Expected O, but got Unknown
		//IL_009a: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a0: Expected O, but got Unknown
		//IL_00bf: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c9: Expected O, but got Unknown
		//IL_00cf: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d6: Expected O, but got Unknown
		//IL_00f7: Unknown result type (might be due to invalid IL or missing references)
		//IL_0101: Expected O, but got Unknown
		//IL_0107: Unknown result type (might be due to invalid IL or missing references)
		//IL_010e: Expected O, but got Unknown
		//IL_012f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0139: Expected O, but got Unknown
		//IL_013f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0146: Expected O, but got Unknown
		//IL_0167: Unknown result type (might be due to invalid IL or missing references)
		//IL_0171: Expected O, but got Unknown
		//IL_0174: Unknown result type (might be due to invalid IL or missing references)
		//IL_017b: Expected O, but got Unknown
		//IL_019c: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a6: Expected O, but got Unknown
		//IL_01a9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b0: Expected O, but got Unknown
		//IL_01d1: Unknown result type (might be due to invalid IL or missing references)
		//IL_01db: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val8 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InteractionRankPage_Loaded));
			break;
		}
		case 2:
		{
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(InteractionRankGrid_OnTapped));
			break;
		}
		case 3:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(InteractionRankGrid_OnTapped));
			break;
		}
		case 4:
		{
			ButtonBase val5 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(OnThisWeekClick));
			break;
		}
		case 5:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(OnLastWeekClick));
			break;
		}
		case 6:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(OnTwoWeeksClick));
			break;
		}
		case 7:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(OnThreeWeeksClick));
			break;
		}
		case 8:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
