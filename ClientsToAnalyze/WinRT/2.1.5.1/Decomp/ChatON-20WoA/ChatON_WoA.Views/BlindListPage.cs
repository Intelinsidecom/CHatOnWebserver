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

public sealed class BlindListPage : Page, IComponentConnector
{
	internal BlindListPageViewModel _viewModel;

	private static BlindListPage _activeInstance;

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
	private bool _contentLoaded;

	public static BlindListPage ActiveInstance => _activeInstance;

	public BlindListPage()
	{
		InitializeComponent();
		_activeInstance = this;
		_viewModel = new BlindListPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		CheckRemovePanelTriggerEnable();
	}

	private void Show_Click_1(object sender, RoutedEventArgs e)
	{
		Buddy buddy = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Buddy;
		_viewModel.RemoveFromBlindList(buddy);
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

	private void AddBlindBuddyButton_Click_1(object sender, RoutedEventArgs e)
	{
		_viewModel.OnAddBlindBuddies();
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
	}

	public void CheckRemovePanelTriggerEnable()
	{
		if (_viewModel.BlindList.Count > 0)
		{
			((UIElement)RemoveTriggerPanel).put_Visibility((Visibility)0);
			((UIElement)NoBlacklistItemText).put_Visibility((Visibility)1);
			((UIElement)PanelNoBlacklistItem).put_Visibility((Visibility)1);
		}
		else
		{
			((UIElement)RemoveTriggerPanel).put_Visibility((Visibility)1);
			((UIElement)NoBlacklistItemText).put_Visibility((Visibility)0);
			((UIElement)PanelNoBlacklistItem).put_Visibility((Visibility)0);
		}
		((UIElement)RemovePanel).put_Visibility((Visibility)1);
		_viewModel.DeleteModeCancel();
	}

	private void AddPanel_OnTapped(object sender, TappedRoutedEventArgs e)
	{
		_viewModel.OnAddBlindBuddies();
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
	}

	public void OnBlockBudyUpdated()
	{
		if (_viewModel.BlindList.Count > 0)
		{
			((UIElement)NoBlacklistItemText).put_Visibility((Visibility)1);
			((UIElement)CheckAllBlockBuddyButton).put_Visibility((Visibility)0);
			EnableRemoveButton();
		}
		else
		{
			((UIElement)NoBlacklistItemText).put_Visibility((Visibility)0);
			EnableRemoveButton();
		}
		SSMService.SetUpdateAllBuddyListFlag(resetTimeStamp: true);
		CheckRemovePanelTriggerEnable();
	}

	public void EnableRemoveButton()
	{
		if (_viewModel.BlindList.Any())
		{
			((Control)CheckAllBlockBuddyButton).put_IsEnabled(true);
			((Control)CancelBlockToogleBuddy).put_IsEnabled(true);
		}
		else
		{
			((Control)CheckAllBlockBuddyButton).put_IsEnabled(false);
			((Control)CancelBlockToogleBuddy).put_IsEnabled(false);
		}
		((Control)RemoveBlockBuddy).put_IsEnabled(_viewModel.BlindList.Count((Buddy x) => x.IsChecked) > 0);
	}

	private void RemoveBlockBuddy_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.UnblockSelectedBlindList();
		CheckRemovePanelTriggerEnable();
		_viewModel.DeleteModeCancel();
	}

	private void CancelRemove_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.DeleteModeCancel();
		CheckRemovePanelTriggerEnable();
	}

	private void RemoveTriggerButton_OnClick(object sender, RoutedEventArgs e)
	{
		((UIElement)RemoveTriggerPanel).put_Visibility((Visibility)1);
		((UIElement)RemovePanel).put_Visibility((Visibility)0);
		EnableRemoveButton();
		_viewModel.DeleteMode();
	}

	private void BlockList_OnUnchecked(object sender, RoutedEventArgs e)
	{
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected O, but got Unknown
		//IL_0044: Unknown result type (might be due to invalid IL or missing references)
		//IL_004e: Expected O, but got Unknown
		Buddy buddy = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is Buddy buddy2)
		{
			if (((ToggleButton)((sender is CheckBox) ? sender : null)).IsChecked.Value)
			{
				buddy2.Background = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
			}
			else
			{
				buddy2.Background = (Brush)new SolidColorBrush(Colors.Transparent);
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
		Buddy buddy = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is Buddy buddy2)
		{
			if (((ToggleButton)((sender is CheckBox) ? sender : null)).IsChecked.Value)
			{
				buddy2.Background = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
			}
			else
			{
				buddy2.Background = (Brush)new SolidColorBrush(Colors.Transparent);
			}
			EnableRemoveButton();
		}
	}

	private void SelectAllBlockList_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.CheckAllBlindList();
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///BlindListPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			PanelNoBlacklistItem = (StackPanel)((FrameworkElement)this).FindName("PanelNoBlacklistItem");
			NoBlacklistItemText = (TextBlock)((FrameworkElement)this).FindName("NoBlacklistItemText");
			RemoveTriggerPanel = (StackPanel)((FrameworkElement)this).FindName("RemoveTriggerPanel");
			RemovePanel = (StackPanel)((FrameworkElement)this).FindName("RemovePanel");
			RemoveBlockBuddy = (Button)((FrameworkElement)this).FindName("RemoveBlockBuddy");
			CheckAllBlockBuddyButton = (Button)((FrameworkElement)this).FindName("CheckAllBlockBuddyButton");
			CancelBlockToogleBuddy = (Button)((FrameworkElement)this).FindName("CancelBlockToogleBuddy");
			RemoveTriggerButton = (Button)((FrameworkElement)this).FindName("RemoveTriggerButton");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0032: Expected O, but got Unknown
		//IL_0051: Unknown result type (might be due to invalid IL or missing references)
		//IL_005b: Expected O, but got Unknown
		//IL_005c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0062: Expected O, but got Unknown
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_008b: Expected O, but got Unknown
		//IL_0091: Unknown result type (might be due to invalid IL or missing references)
		//IL_0097: Expected O, but got Unknown
		//IL_00b6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c0: Expected O, but got Unknown
		//IL_00c6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cd: Expected O, but got Unknown
		//IL_00ee: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f8: Expected O, but got Unknown
		//IL_00fe: Unknown result type (might be due to invalid IL or missing references)
		//IL_0105: Expected O, but got Unknown
		//IL_0126: Unknown result type (might be due to invalid IL or missing references)
		//IL_0130: Expected O, but got Unknown
		//IL_0136: Unknown result type (might be due to invalid IL or missing references)
		//IL_013d: Expected O, but got Unknown
		//IL_015e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0168: Expected O, but got Unknown
		//IL_016b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0172: Expected O, but got Unknown
		//IL_0193: Unknown result type (might be due to invalid IL or missing references)
		//IL_019d: Expected O, but got Unknown
		//IL_01a0: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a7: Expected O, but got Unknown
		//IL_01c8: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d2: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			ToggleButton val7 = (ToggleButton)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(ToggleButton.add_Checked)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(ToggleButton.remove_Checked)), new RoutedEventHandler(BlockList_OnChecked));
			ToggleButton val8 = (ToggleButton)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(ToggleButton.add_Unchecked)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(ToggleButton.remove_Unchecked)), new RoutedEventHandler(BlockList_OnUnchecked));
			break;
		}
		case 2:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 3:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(AddPanel_OnTapped));
			break;
		}
		case 4:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(RemoveBlockBuddy_Click));
			break;
		}
		case 5:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(SelectAllBlockList_Click));
			break;
		}
		case 6:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(CancelRemove_Click));
			break;
		}
		case 7:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(RemoveTriggerButton_OnClick));
			break;
		}
		}
		_contentLoaded = true;
	}
}
