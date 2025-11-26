using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;

namespace ChatON_WoA.Views;

public sealed class BlockListPage : Page, IComponentConnector
{
	private BlockListPageViewModel _viewModel;

	private static BlockListPage _activeInstance;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel PanelNoBlacklistItem;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock NoBlacklistItemText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RemoveTriggerPanel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RemovePanel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button RemoveBlockBuddy;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button CheckAllBlockBuddyButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button CancelBlockToogleBuddy;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button RemoveTriggerButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtTotalBuddies;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static BlockListPage ActiveInstance => _activeInstance;

	public BlockListPageViewModel ViewModel => _viewModel;

	public BlockListPage()
	{
		InitializeComponent();
		_activeInstance = this;
		_viewModel = new BlockListPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		CheckRemovePanelTriggerEnable();
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		SettingsPage.ActiveInstance.ClosePopup();
	}

	internal void ShowLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
	}

	public void OnBlockBudyUpdated()
	{
		if (_viewModel.BlockedList.Count > 0)
		{
			((UIElement)NoBlacklistItemText).put_Visibility((Visibility)1);
			((UIElement)PanelNoBlacklistItem).put_Visibility((Visibility)1);
			((UIElement)CheckAllBlockBuddyButton).put_Visibility((Visibility)0);
			EnableRemoveButton();
		}
		else
		{
			((UIElement)NoBlacklistItemText).put_Visibility((Visibility)0);
			((UIElement)PanelNoBlacklistItem).put_Visibility((Visibility)0);
			EnableRemoveButton();
		}
		SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
		CheckRemovePanelTriggerEnable();
	}

	public void DisplayAddPane()
	{
		((UIElement)RemovePanel).put_Visibility((Visibility)1);
	}

	private void AddBlockBuddy_Click_1(object sender, RoutedEventArgs e)
	{
		_viewModel.OnAddBlockBuddies();
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
	}

	private void BlockList_OnTapped(object sender, TappedRoutedEventArgs e)
	{
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_005f: Expected O, but got Unknown
		//IL_002b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0035: Expected O, but got Unknown
		BlockBuddyInfo blockBuddyInfo = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is BlockBuddyInfo blockBuddyInfo2)
		{
			if (blockBuddyInfo2.IsChecked)
			{
				blockBuddyInfo2.IsChecked = false;
				blockBuddyInfo2.Background = new SolidColorBrush(Colors.Transparent);
			}
			else
			{
				blockBuddyInfo2.IsChecked = true;
				blockBuddyInfo2.Background = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
			}
			EnableRemoveButton();
		}
	}

	private void BlockList_OnChecked(object sender, RoutedEventArgs e)
	{
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected O, but got Unknown
		//IL_0044: Unknown result type (might be due to invalid IL or missing references)
		//IL_004e: Expected O, but got Unknown
		BlockBuddyInfo blockBuddyInfo = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is BlockBuddyInfo blockBuddyInfo2)
		{
			if (((ToggleButton)((sender is CheckBox) ? sender : null)).IsChecked.Value)
			{
				blockBuddyInfo2.Background = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
			}
			else
			{
				blockBuddyInfo2.Background = new SolidColorBrush(Colors.Transparent);
			}
			EnableRemoveButton();
		}
	}

	private void BlockList_OnUnchecked(object sender, RoutedEventArgs e)
	{
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected O, but got Unknown
		//IL_0044: Unknown result type (might be due to invalid IL or missing references)
		//IL_004e: Expected O, but got Unknown
		BlockBuddyInfo blockBuddyInfo = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is BlockBuddyInfo blockBuddyInfo2)
		{
			if (((ToggleButton)((sender is CheckBox) ? sender : null)).IsChecked.Value)
			{
				blockBuddyInfo2.Background = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
			}
			else
			{
				blockBuddyInfo2.Background = new SolidColorBrush(Colors.Transparent);
			}
			EnableRemoveButton();
		}
	}

	private void RemoveBlockBuddy_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.UnblockSelectedBuddy();
		CheckRemovePanelTriggerEnable();
		_viewModel.DeleteModeCancel();
	}

	private void SelectAllBlockList_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.CheckAllBlockList();
	}

	private void CancelRemove_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.DeleteModeCancel();
		CheckRemovePanelTriggerEnable();
	}

	public void CheckRemovePanelTriggerEnable()
	{
		if (_viewModel.BlockedList.Count > 0)
		{
			((UIElement)RemoveTriggerPanel).put_Visibility((Visibility)0);
		}
		else
		{
			((UIElement)RemoveTriggerPanel).put_Visibility((Visibility)1);
		}
		((UIElement)RemovePanel).put_Visibility((Visibility)1);
	}

	public void EnableRemoveButton()
	{
		if (_viewModel.BlockedList.Any())
		{
			((Control)CheckAllBlockBuddyButton).put_IsEnabled(true);
			((Control)CancelBlockToogleBuddy).put_IsEnabled(true);
		}
		else
		{
			((Control)CheckAllBlockBuddyButton).put_IsEnabled(false);
			((Control)CancelBlockToogleBuddy).put_IsEnabled(false);
		}
		((Control)RemoveBlockBuddy).put_IsEnabled(_viewModel.BlockedList.Count((BlockBuddyInfo x) => x.IsChecked) > 0);
	}

	private void AddPanel_OnTapped(object sender, TappedRoutedEventArgs e)
	{
		_viewModel.OnAddBlockBuddies();
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
	}

	private void RemoveTriggerButton_OnClick(object sender, RoutedEventArgs e)
	{
		((UIElement)RemoveTriggerPanel).put_Visibility((Visibility)1);
		((UIElement)RemovePanel).put_Visibility((Visibility)0);
		_viewModel.DeleteMode();
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///BlockListPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			PanelNoBlacklistItem = (StackPanel)((FrameworkElement)this).FindName("PanelNoBlacklistItem");
			NoBlacklistItemText = (TextBlock)((FrameworkElement)this).FindName("NoBlacklistItemText");
			RemoveTriggerPanel = (StackPanel)((FrameworkElement)this).FindName("RemoveTriggerPanel");
			RemovePanel = (StackPanel)((FrameworkElement)this).FindName("RemovePanel");
			RemoveBlockBuddy = (Button)((FrameworkElement)this).FindName("RemoveBlockBuddy");
			CheckAllBlockBuddyButton = (Button)((FrameworkElement)this).FindName("CheckAllBlockBuddyButton");
			CancelBlockToogleBuddy = (Button)((FrameworkElement)this).FindName("CancelBlockToogleBuddy");
			RemoveTriggerButton = (Button)((FrameworkElement)this).FindName("RemoveTriggerButton");
			txtTotalBuddies = (TextBlock)((FrameworkElement)this).FindName("txtTotalBuddies");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0034: Unknown result type (might be due to invalid IL or missing references)
		//IL_003a: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_0069: Unknown result type (might be due to invalid IL or missing references)
		//IL_006f: Expected O, but got Unknown
		//IL_008e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0098: Expected O, but got Unknown
		//IL_009e: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a4: Expected O, but got Unknown
		//IL_00c3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cd: Expected O, but got Unknown
		//IL_00ce: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d5: Expected O, but got Unknown
		//IL_00f6: Unknown result type (might be due to invalid IL or missing references)
		//IL_0100: Expected O, but got Unknown
		//IL_0106: Unknown result type (might be due to invalid IL or missing references)
		//IL_010d: Expected O, but got Unknown
		//IL_012e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0138: Expected O, but got Unknown
		//IL_013e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0145: Expected O, but got Unknown
		//IL_0166: Unknown result type (might be due to invalid IL or missing references)
		//IL_0170: Expected O, but got Unknown
		//IL_0176: Unknown result type (might be due to invalid IL or missing references)
		//IL_017d: Expected O, but got Unknown
		//IL_019e: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a8: Expected O, but got Unknown
		//IL_01ae: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b5: Expected O, but got Unknown
		//IL_01d6: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e0: Expected O, but got Unknown
		//IL_01e3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ea: Expected O, but got Unknown
		//IL_020b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0215: Expected O, but got Unknown
		//IL_0218: Unknown result type (might be due to invalid IL or missing references)
		//IL_021f: Expected O, but got Unknown
		//IL_0240: Unknown result type (might be due to invalid IL or missing references)
		//IL_024a: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val10 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BlockList_OnTapped));
			break;
		}
		case 2:
		{
			UIElement val9 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BlockList_OnTapped));
			break;
		}
		case 3:
		{
			ToggleButton val7 = (ToggleButton)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(ToggleButton.add_Checked)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(ToggleButton.remove_Checked)), new RoutedEventHandler(BlockList_OnChecked));
			ToggleButton val8 = (ToggleButton)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(ToggleButton.add_Unchecked)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(ToggleButton.remove_Unchecked)), new RoutedEventHandler(BlockList_OnUnchecked));
			break;
		}
		case 4:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 5:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(AddPanel_OnTapped));
			break;
		}
		case 6:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(RemoveBlockBuddy_Click));
			break;
		}
		case 7:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(SelectAllBlockList_Click));
			break;
		}
		case 8:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(CancelRemove_Click));
			break;
		}
		case 9:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(RemoveTriggerButton_OnClick));
			break;
		}
		}
		_contentLoaded = true;
	}
}
