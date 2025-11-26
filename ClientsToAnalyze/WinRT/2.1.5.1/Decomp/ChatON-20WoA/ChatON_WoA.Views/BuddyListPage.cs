using System;
using System.CodeDom.Compiler;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI;
using Windows.UI.Popups;
using Windows.UI.StartScreen;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class BuddyListPage : Page, IComponentConnector
{
	private static BuddyListPage _activeInstance;

	private BuddySummary _buddyToScroll;

	private bool _selectedRunning;

	private DispatcherTimer delayLoadTimer;

	private bool isZoomIn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private AppBar appBar;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel LeftCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel RightCommands;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton SuggestionsButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton AddGroupButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton AddBuddyButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton RenameButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton RemoveBuddyGroupButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton AddBuddyGroupButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton ChatButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton BroadcastButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton BlockButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton DeleteGroupButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SemanticZoom semanticZoom;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid BuddyProfileContainer;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView gridView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView ZoomedOutGridView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static BuddyListPage ActiveInstance => _activeInstance;

	public unsafe BuddyListPage()
	{
		//IL_00cb: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d5: Expected O, but got Unknown
		//IL_011b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0125: Expected O, but got Unknown
		InitializeComponent();
		_activeInstance = this;
		ChatButton.Text = Utility.GetResourceString("IDS_CHATON_SK3_START_CHAT");
		BroadcastButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_BROADCAST");
		SuggestionsButton.Text = Utility.GetResourceString("IDS_CHATON_ITAB_SUGGESTIONS");
		AddGroupButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_ADD_GROUP_ABB");
		AddBuddyButton.Text = Utility.GetResourceString("IDS_CHATON_SK3_ADD_BUDDY");
		BlockButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_BLOCK");
		DeleteGroupButton.Text = Utility.GetResourceString("IDS_CHATON_BUTTON_DELETE_GROUP");
		SemanticZoom val = semanticZoom;
		WindowsRuntimeMarshal.AddEventHandler(new Func<SemanticZoomViewChangedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(SemanticZoom.add_ViewChangeStarted)), new Action<EventRegistrationToken>(val, (nint)__ldftn(SemanticZoom.remove_ViewChangeStarted)), new SemanticZoomViewChangedEventHandler(semanticZoom_ViewChangeStarted));
		RemoveBuddyGroupButton.Text = Utility.GetResourceString("IDS_CHATON_SK4_REMOVE_BUDDY");
		AddBuddyGroupButton.Text = Utility.GetResourceString("IDS_CHATON_SK3_ADD_BUDDY");
		RenameButton.Text = Utility.GetResourceString("IDS_CHATON_OPT_RENAME");
		resetAppBar();
		delayLoadTimer = new DispatcherTimer();
		delayLoadTimer.put_Interval(new TimeSpan(0, 0, 3));
		DispatcherTimer val2 = delayLoadTimer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val2, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(DispatcherTimer.remove_Tick)), delayLoadTimer_Tick);
	}

	private void delayLoadTimer_Tick(object sender, object e)
	{
		delayLoadTimer.Stop();
		PivotPage.ActiveInstance.ViewModel.UpdateBlockListAsync();
	}

	private void semanticZoom_ViewChangeStarted(object sender, SemanticZoomViewChangedEventArgs e)
	{
		if (((ICollection<UIElement>)((Panel)BuddyProfileContainer).Children).Count > 0)
		{
			((ICollection<UIElement>)((Panel)BuddyProfileContainer).Children).Clear();
		}
		((UIElement)BuddyProfileContainer).put_Visibility((Visibility)1);
		if (e.IsSourceZoomedInView)
		{
			isZoomIn = true;
			appBar.put_IsOpen(false);
			ResetHilightedBuddy();
		}
		else
		{
			isZoomIn = false;
			appBar.put_IsOpen(true);
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (PivotPage.ActiveInstance.ViewModel != null)
		{
			PivotPage.ActiveInstance.ViewModel.SelectedIndex = 0;
		}
		((Selector)gridView).put_SelectedIndex(-1);
		semanticZoom.put_IsZoomedInViewActive(true);
		appBar.put_IsSticky(true);
		appBar.put_IsOpen(true);
		resetAppBar();
		ResetHilightedBuddy();
	}

	public void ResetHilightedBuddy()
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Expected O, but got Unknown
		ObservableCollection<BuddySummary> showingItems = PivotPage.ActiveInstance.ViewModel.ShowingItems;
		SolidColorBrush nameForeground = new SolidColorBrush(Colors.Black);
		foreach (BuddySummary item in showingItems)
		{
			if (!item.NameForeground.Color.Equals(Colors.Black))
			{
				item.NameForeground = nameForeground;
			}
		}
		((ListViewBase)gridView).SelectedItems.Clear();
	}

	public void StickyAppBar()
	{
		appBar.put_IsOpen(true);
		appBar.put_IsSticky(true);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		if (((ICollection<UIElement>)((Panel)BuddyProfileContainer).Children).Count > 0)
		{
			((ICollection<UIElement>)((Panel)BuddyProfileContainer).Children).Clear();
		}
		((UIElement)BuddyProfileContainer).put_Visibility((Visibility)1);
		delayLoadTimer.Stop();
	}

	private void Buddy_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		appBar.put_IsOpen(false);
		PivotPage.ActiveInstance.OpenChat(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as BuddySummary);
	}

	private void AddBuddy_Click(object sender, RoutedEventArgs e)
	{
		AddBuddyDialog.OpenAddBuddyDialog();
		appBar.put_IsOpen(false);
	}

	private void AddGroup_Click(object sender, RoutedEventArgs e)
	{
		PivotPage.ActiveInstance.CloseAllPopup();
		AddGroupDialog addGroupDialog = new AddGroupDialog();
		((FrameworkElement)addGroupDialog).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)addGroupDialog).put_VerticalAlignment((VerticalAlignment)2);
		((FrameworkElement)addGroupDialog).put_Margin(new Thickness(0.0, 0.0, 50.0, 400.0));
		AddGroupDialog.itemtoBeAdd = ((ListViewBase)gridView).SelectedItems.FirstOrDefault() as BuddySummary;
		PivotPage.ActiveInstance.OpenDialog((UserControl)(object)addGroupDialog, closePrevPopup: true);
		appBar.put_IsOpen(false);
	}

	private void StartChat_Click(object sender, RoutedEventArgs e)
	{
		PivotPage.ActiveInstance.CloseAllPopup();
		PivotPage.ActiveInstance.ViewModel.OnStartChat();
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
	}

	private void Broadcast_Click(object sender, RoutedEventArgs e)
	{
		PivotPage.ActiveInstance.CloseAllPopup();
		PivotPage.ActiveInstance.ViewModel.OnStartBroadcast();
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
	}

	private void Suggestions_Click(object sender, RoutedEventArgs e)
	{
		PivotPage.ActiveInstance.CloseAllPopup();
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SuggestionsPage));
	}

	private void popup_Closed(object sender, object e)
	{
	}

	private void ProfileImage_Tapped(object sender, TappedRoutedEventArgs e)
	{
		//IL_0028: Unknown result type (might be due to invalid IL or missing references)
		//IL_002e: Expected O, but got Unknown
		BuddySummary buddySummary = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as BuddySummary;
		PivotPage.ActiveInstance.ViewModel.OpenBuddyProfileDialog(buddySummary, BuddyProfileContainer);
		SemanticZoomLocation val = new SemanticZoomLocation();
		val.put_Item((object)buddySummary);
		((ListViewBase)gridView).MakeVisible(val);
	}

	public void SwitchAppBar(bool isOpen)
	{
		if (appBar.IsOpen == isOpen)
		{
			appBar.put_IsOpen(false);
		}
		if (isOpen && !appBar.IsOpen)
		{
			appBar.put_IsOpen(true);
		}
		appBar.put_IsOpen(isOpen);
	}

	public void MakeArrowVisibility(bool IsShow, BuddySummary item)
	{
		try
		{
			DependencyObject child = VisualTreeHelper.GetChild(((ItemsControl)gridView).ItemContainerGenerator.ContainerFromItem((object)item), 0);
			object obj = ((FrameworkElement)((child is FrameworkElement) ? child : null)).FindName("Arrow");
			if (obj != null && IsShow)
			{
				((UIElement)((obj is Image) ? obj : null)).put_Visibility((Visibility)0);
			}
			else
			{
				((UIElement)((obj is Image) ? obj : null)).put_Visibility((Visibility)1);
			}
		}
		catch
		{
		}
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		//IL_007c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0082: Expected O, but got Unknown
		//IL_00fb: Unknown result type (might be due to invalid IL or missing references)
		//IL_0105: Expected O, but got Unknown
		//IL_0121: Unknown result type (might be due to invalid IL or missing references)
		//IL_012b: Expected O, but got Unknown
		FrameworkElement val = null;
		BuddyListHeader header = null;
		if ((val = (FrameworkElement)((sender is FrameworkElement) ? sender : null)) != null && (header = val.DataContext as BuddyListHeader) != null && header.Index >= 0)
		{
			BuddySummary buddySummary = PivotPage.ActiveInstance.ViewModel.ShowingItems.Where((BuddySummary b) => b != null && b.HeaderName == header.Title).FirstOrDefault();
			SemanticZoomLocation val2 = new SemanticZoomLocation();
			if (buddySummary == null)
			{
				val2.put_Item((object)PivotPage.ActiveInstance.ViewModel.ShowingItems[0]);
			}
			else
			{
				val2.put_Item((object)buddySummary);
			}
			BuddySummary buddySummary2 = null;
			object obj = ((IEnumerable<object>)((ItemsControl)gridView).Items).FirstOrDefault((object x) => x is BuddySummary && (x as BuddySummary).NameForeground.Color == Colors.White);
			if (obj != null && obj is BuddySummary buddySummary3)
			{
				((Selector)gridView).put_SelectedIndex(-1);
				buddySummary3.NameForeground = new SolidColorBrush(Colors.Black);
				buddySummary3.Buddy.StatusForeground = (Brush)new SolidColorBrush(Color.FromArgb(byte.MaxValue, 33, 146, 151));
			}
			((ListViewBase)gridView).MakeVisible(val2);
			if (buddySummary != null)
			{
				((ListViewBase)gridView).ScrollIntoView((object)buddySummary, (ScrollIntoViewAlignment)1);
			}
		}
	}

	public void FocusToGroup(BuddyGroup item)
	{
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		try
		{
			PivotPage.ActiveInstance.ViewModel.UpdateList();
			BuddySummary buddySummary = PivotPage.ActiveInstance.ViewModel.ShowingItems.Where((BuddySummary b) => b.HeaderType == BuddyListHeaderType.Group && b.Type == BuddySummary.ItemType.Index).FirstOrDefault();
			SemanticZoomLocation val = new SemanticZoomLocation();
			if (buddySummary == null)
			{
				val.put_Item((object)PivotPage.ActiveInstance.ViewModel.ShowingItems[0]);
			}
			else
			{
				val.put_Item((object)buddySummary);
				((ListViewBase)gridView).ScrollIntoView((object)buddySummary, (ScrollIntoViewAlignment)1);
			}
			((ListViewBase)gridView).MakeVisible(val);
		}
		catch (Exception)
		{
		}
	}

	private void GroupGrid_Tapped_2(object sender, TappedRoutedEventArgs e)
	{
		FrameworkElement val = null;
		BuddyGroup buddyGroup = null;
		BuddySummary buddySummary = null;
		if ((val = (FrameworkElement)((sender is FrameworkElement) ? sender : null)) != null && val.DataContext is BuddySummary buddySummary2 && (buddyGroup = buddySummary2.Group) != null && !string.IsNullOrEmpty(buddyGroup.Members))
		{
			PivotPage.ActiveInstance.OpenChat(buddyGroup);
		}
	}

	internal async Task DeleteGroupTile(BuddyGroup group)
	{
		foreach (SecondaryTile tile in await SecondaryTile.FindAllAsync())
		{
			if (SecondaryTile.Exists(tile.TileId) && tile.DisplayName == group.Name)
			{
				SecondaryTile tileToBeDeleted = new SecondaryTile(tile.TileId);
				await tileToBeDeleted.RequestDeleteAsync();
			}
		}
	}

	private async void DeleteGroup_Tapped(object sender, RightTappedRoutedEventArgs e)
	{
		FrameworkElement val;
		FrameworkElement framework = (val = (FrameworkElement)((sender is FrameworkElement) ? sender : null));
		if (val == null)
		{
			return;
		}
		BuddySummary buddySummary;
		BuddySummary summary = (buddySummary = framework.DataContext as BuddySummary);
		if (buddySummary == null)
		{
			return;
		}
		BuddyGroup buddyGroup;
		BuddyGroup group = (buddyGroup = summary.Group);
		if (buddyGroup == null)
		{
			return;
		}
		PopupMenu menu = new PopupMenu();
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_DELETE"), (UICommandInvokedHandler)null, (object)1));
		try
		{
			if (await menu.ShowForSelectionAsync(Utility.GetElementRect((FrameworkElement)sender)) != null)
			{
				PivotPage.ActiveInstance.ViewModel.DeleteGroup(group);
				appBar.put_IsOpen(false);
			}
		}
		catch (Exception)
		{
		}
	}

	private void BuddyList_Selected(object sender, SelectionChangedEventArgs e)
	{
		//IL_0089: Unknown result type (might be due to invalid IL or missing references)
		//IL_0093: Expected O, but got Unknown
		if (_selectedRunning)
		{
			return;
		}
		if (!appBar.IsOpen)
		{
			appBar.put_IsOpen(true);
		}
		resetAppBar();
		if (e.AddedItems.Count > 0)
		{
			BuddySummary buddySummary = e.AddedItems.Cast<BuddySummary>().FirstOrDefault();
			if (buddySummary.Type == BuddySummary.ItemType.Index)
			{
				((Selector)gridView).put_SelectedIndex(-1);
				semanticZoom.put_IsZoomedInViewActive(false);
				return;
			}
			RemovePreviousSelectedBuddy(buddySummary);
			if (buddySummary.Type == BuddySummary.ItemType.Index || buddySummary.Type == BuddySummary.ItemType.Group)
			{
				buddySummary.NameForeground = new SolidColorBrush(Colors.White);
				SetMenuGroup();
			}
			else if (buddySummary.Buddy != null && buddySummary.Buddy != null)
			{
				if (buddySummary.Buddy.PhoneNumber != RegistrationService.ChatOnID)
				{
					SetMenuBuddy();
				}
				SelectBuddy(buddySummary, status: true);
			}
		}
		else if (e.RemovedItems.Count > 0)
		{
			RemoveSelectedItem(e.RemovedItems.Cast<BuddySummary>().FirstOrDefault());
			resetAppBar();
		}
	}

	private void SetMenuBuddy()
	{
		((UIElement)ChatButton).put_Visibility((Visibility)0);
		((UIElement)SuggestionsButton).put_Visibility((Visibility)1);
		((UIElement)AddGroupButton).put_Visibility((Visibility)0);
		((UIElement)AddBuddyButton).put_Visibility((Visibility)1);
		((UIElement)BlockButton).put_Visibility((Visibility)0);
		((UIElement)BroadcastButton).put_Visibility((Visibility)0);
		((UIElement)DeleteGroupButton).put_Visibility((Visibility)1);
	}

	private void SetMenuGroup()
	{
		((UIElement)ChatButton).put_Visibility((Visibility)1);
		((UIElement)SuggestionsButton).put_Visibility((Visibility)1);
		((UIElement)AddGroupButton).put_Visibility((Visibility)1);
		((UIElement)AddBuddyButton).put_Visibility((Visibility)1);
		((UIElement)BlockButton).put_Visibility((Visibility)1);
		((UIElement)BroadcastButton).put_Visibility((Visibility)1);
		((UIElement)DeleteGroupButton).put_Visibility((Visibility)0);
		((UIElement)RenameButton).put_Visibility((Visibility)0);
		((UIElement)RemoveBuddyGroupButton).put_Visibility((Visibility)0);
		((UIElement)AddBuddyGroupButton).put_Visibility((Visibility)0);
	}

	private void RemoveSelectedItem(BuddySummary removedItem)
	{
		//IL_0005: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected O, but got Unknown
		SolidColorBrush nameForeground = (removedItem.NameForeground = new SolidColorBrush(Colors.Black));
		List<BuddySummary> list = ((ListViewBase)gridView).SelectedItems.Cast<BuddySummary>().ToList();
		foreach (BuddySummary item in list)
		{
			item.NameForeground = nameForeground;
		}
		((Selector)gridView).put_SelectedIndex(-1);
	}

	private void RemovePreviousSelectedBuddy(BuddySummary exclude)
	{
		//IL_0082: Unknown result type (might be due to invalid IL or missing references)
		//IL_008c: Expected O, but got Unknown
		_selectedRunning = true;
		IList<BuddySummary> list = null;
		list = ((exclude.Type != BuddySummary.ItemType.Group) ? (from BuddySummary x in ((ListViewBase)gridView).SelectedItems
			where x.Type == BuddySummary.ItemType.Group || (x.Buddy != null && x.Buddy.PhoneNumber != exclude.Buddy.PhoneNumber)
			select x).ToList() : ((ListViewBase)gridView).SelectedItems.Cast<BuddySummary>().ToList());
		foreach (BuddySummary item in list)
		{
			if (item != exclude)
			{
				item.NameForeground = new SolidColorBrush(Colors.Black);
				((ListViewBase)gridView).SelectedItems.Remove(item);
			}
		}
		_selectedRunning = false;
	}

	private void AddBuddyGroup_Click(object sender, RoutedEventArgs e)
	{
		//IL_0063: Unknown result type (might be due to invalid IL or missing references)
		//IL_0069: Expected O, but got Unknown
		try
		{
			if (((ListViewBase)gridView).SelectedItems != null && ((ListViewBase)gridView).SelectedItems.Count > 0)
			{
				appBar.put_IsOpen(false);
				BuddySummary buddySummary = null;
				if (((Selector)gridView).SelectedItem is BuddySummary { Group: not null } buddySummary2)
				{
					PivotPage.ActiveInstance.ViewModel.OpenBuddyProfileDialog(buddySummary2, BuddyProfileContainer, isRename: true);
					SemanticZoomLocation val = new SemanticZoomLocation();
					val.put_Item((object)buddySummary2);
					((ListViewBase)gridView).MakeVisible(val);
				}
			}
		}
		catch
		{
		}
	}

	private void DeleteGroup_Click(object sender, RoutedEventArgs e)
	{
		try
		{
			if (((ListViewBase)gridView).SelectedItems != null && ((ListViewBase)gridView).SelectedItems.Count > 0)
			{
				appBar.put_IsOpen(false);
				BuddyGroup buddyGroup = null;
				BuddySummary buddySummary = null;
				if (((Selector)gridView).SelectedItem is BuddySummary buddySummary2 && (buddyGroup = buddySummary2.Group) != null && buddyGroup != null)
				{
					RemoveSelectedItem(buddySummary2);
					PivotPage.ActiveInstance.ViewModel.DeleteGroup(buddyGroup);
				}
			}
		}
		catch
		{
		}
	}

	private void Block_Click(object sender, RoutedEventArgs e)
	{
		List<string> list = new List<string>();
		foreach (BuddySummary selectedItem in ((ListViewBase)gridView).SelectedItems)
		{
			if (selectedItem.Buddy != null)
			{
				list.Add(selectedItem.Buddy.PhoneNumber);
			}
		}
		PivotPage.ActiveInstance.ShowLoading();
		PivotPage.ActiveInstance.ViewModel.BlockBuddyList(list);
	}

	private void appBar_Closed(object sender, object e)
	{
		resetAppBar();
	}

	private void resetAppBar()
	{
		((UIElement)ChatButton).put_Visibility((Visibility)0);
		((UIElement)SuggestionsButton).put_Visibility((Visibility)0);
		((UIElement)AddGroupButton).put_Visibility((Visibility)0);
		((UIElement)AddBuddyButton).put_Visibility((Visibility)0);
		((UIElement)BlockButton).put_Visibility((Visibility)1);
		((UIElement)BroadcastButton).put_Visibility((Visibility)0);
		((UIElement)DeleteGroupButton).put_Visibility((Visibility)1);
		((UIElement)RenameButton).put_Visibility((Visibility)1);
		((UIElement)RemoveBuddyGroupButton).put_Visibility((Visibility)1);
		((UIElement)AddBuddyGroupButton).put_Visibility((Visibility)1);
	}

	private void Me_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		PivotPage.ActiveInstance.OpenMyPage();
	}

	public void OpenBuddyProfileDialog(BuddySummary item)
	{
		//IL_0075: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		try
		{
			List<BuddySummary> list = ((IEnumerable)((ItemsControl)gridView).Items).Cast<BuddySummary>().ToList();
			BuddySummary buddySummary = list.FirstOrDefault((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber == item.Buddy.PhoneNumber);
			int num = list.IndexOf(buddySummary);
			((Selector)gridView).put_SelectedIndex(num);
			PivotPage.ActiveInstance.ViewModel.OpenBuddyProfileDialog(item, BuddyProfileContainer);
			SemanticZoomLocation val = new SemanticZoomLocation();
			val.put_Item((object)buddySummary);
			((ListViewBase)gridView).MakeVisible(val);
		}
		catch (Exception)
		{
		}
	}

	private void appBar_Opened(object sender, object e)
	{
		//IL_0040: Unknown result type (might be due to invalid IL or missing references)
		try
		{
			if (gridView != null)
			{
				BuddySummary buddySummary = ((Selector)gridView).SelectedItem as BuddySummary;
				if (((ICollection<UIElement>)((Panel)BuddyProfileContainer).Children).Count >= 1 && (int)((IList<UIElement>)((Panel)BuddyProfileContainer).Children)[0].Visibility == 0)
				{
					((UIElement)appBar).put_Visibility((Visibility)1);
				}
				else
				{
					((UIElement)appBar).put_Visibility((Visibility)0);
				}
				if (buddySummary != null)
				{
					resetAppBar();
					if (buddySummary.Group != null && PivotPage.ActiveInstance.ViewModel.LastOpenedDialog != null)
					{
						if (PivotPage.ActiveInstance.ViewModel.LastOpenedDialog is GroupProfileDialog)
						{
							((UIElement)DeleteGroupButton).put_Visibility((Visibility)0);
						}
					}
					else if (buddySummary.Buddy != null && buddySummary.Buddy.PhoneNumber != RegistrationService.ChatOnID && PivotPage.ActiveInstance.ViewModel.LastOpenedDialog is BuddyProfileDialog)
					{
						((UIElement)BlockButton).put_Visibility((Visibility)0);
					}
				}
			}
			if (PivotPage.ActiveInstance.IsPopupActive() && appBar != null)
			{
				appBar.put_IsOpen(false);
			}
			if (isZoomIn && appBar != null)
			{
				appBar.put_IsOpen(false);
			}
		}
		catch (Exception)
		{
		}
	}

	internal void CloseProfileDialog()
	{
		((Selector)gridView).put_SelectedIndex(-1);
		((ICollection<UIElement>)((Panel)BuddyProfileContainer).Children).Clear();
		((UIElement)DeleteGroupButton).put_Visibility((Visibility)1);
		((UIElement)BlockButton).put_Visibility((Visibility)1);
		SwitchAppBar(isOpen: true);
	}

	private void SelectGroup(BuddySummary item, bool status)
	{
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0032: Expected O, but got Unknown
		//IL_0019: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Expected O, but got Unknown
		if (status)
		{
			SolidColorBrush background = new SolidColorBrush(Color.FromArgb(byte.MaxValue, 250, 135, 25));
			item.Background = background;
		}
		else
		{
			SolidColorBrush background2 = new SolidColorBrush(Colors.Transparent);
			item.Background = background2;
		}
	}

	internal void SelectBuddy(BuddySummary item, bool status)
	{
		//IL_00b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bc: Expected O, but got Unknown
		//IL_00d3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d9: Expected O, but got Unknown
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0067: Expected O, but got Unknown
		List<BuddySummary> list = PivotPage.ActiveInstance.ViewModel.ShowingItems.Where((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber == item.Buddy.PhoneNumber).ToList();
		if (status)
		{
			if (list.Count <= 0)
			{
				return;
			}
			{
				foreach (BuddySummary item2 in list)
				{
					item2.NameForeground = new SolidColorBrush(Colors.White);
					((ListViewBase)gridView).SelectedItems.Add(item2);
				}
				return;
			}
		}
		if (list.Count <= 0)
		{
			return;
		}
		foreach (BuddySummary item3 in list)
		{
			item3.NameForeground = new SolidColorBrush(Colors.Black);
			((ListViewBase)gridView).SelectedItems.Remove(item3);
			SolidColorBrush background = new SolidColorBrush(Colors.Transparent);
			item3.Buddy.Background = (Brush)(object)background;
		}
	}

	private void RemoveBuddyGroup_Click(object sender, RoutedEventArgs e)
	{
		if (((ListViewBase)gridView).SelectedItems != null && ((ListViewBase)gridView).SelectedItems.Count > 0)
		{
			BuddySummary buddySummary = null;
			if (((Selector)gridView).SelectedItem is BuddySummary { Group: not null } buddySummary2)
			{
				RemoveSelectedItem(buddySummary2);
				PivotPage.ActiveInstance.ViewModel.RemoveMembers(buddySummary2.Group);
			}
		}
	}

	private void AddBuddyGroup_Click_1(object sender, RoutedEventArgs e)
	{
		if (((ListViewBase)gridView).SelectedItems != null && ((ListViewBase)gridView).SelectedItems.Count > 0)
		{
			BuddySummary buddySummary = null;
			if (((Selector)gridView).SelectedItem is BuddySummary { Group: not null } buddySummary2)
			{
				RemoveSelectedItem(buddySummary2);
				PivotPage.ActiveInstance.ViewModel.AddMembers(buddySummary2.Group);
			}
		}
	}

	private void Page_Loaded(object sender, RoutedEventArgs e)
	{
		if (delayLoadTimer != null)
		{
			delayLoadTimer.Start();
		}
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
		//IL_014b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Expected O, but got Unknown
		//IL_0161: Unknown result type (might be due to invalid IL or missing references)
		//IL_016b: Expected O, but got Unknown
		//IL_0177: Unknown result type (might be due to invalid IL or missing references)
		//IL_0181: Expected O, but got Unknown
		//IL_018d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0197: Expected O, but got Unknown
		//IL_01a3: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ad: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///BuddyListPage.xaml"), (ComponentResourceLocation)0);
			appBar = (AppBar)((FrameworkElement)this).FindName("appBar");
			LeftCommands = (StackPanel)((FrameworkElement)this).FindName("LeftCommands");
			RightCommands = (StackPanel)((FrameworkElement)this).FindName("RightCommands");
			SuggestionsButton = (ImageButton)((FrameworkElement)this).FindName("SuggestionsButton");
			AddGroupButton = (ImageButton)((FrameworkElement)this).FindName("AddGroupButton");
			AddBuddyButton = (ImageButton)((FrameworkElement)this).FindName("AddBuddyButton");
			RenameButton = (ImageButton)((FrameworkElement)this).FindName("RenameButton");
			RemoveBuddyGroupButton = (ImageButton)((FrameworkElement)this).FindName("RemoveBuddyGroupButton");
			AddBuddyGroupButton = (ImageButton)((FrameworkElement)this).FindName("AddBuddyGroupButton");
			ChatButton = (ImageButton)((FrameworkElement)this).FindName("ChatButton");
			BroadcastButton = (ImageButton)((FrameworkElement)this).FindName("BroadcastButton");
			BlockButton = (ImageButton)((FrameworkElement)this).FindName("BlockButton");
			DeleteGroupButton = (ImageButton)((FrameworkElement)this).FindName("DeleteGroupButton");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			semanticZoom = (SemanticZoom)((FrameworkElement)this).FindName("semanticZoom");
			BuddyProfileContainer = (Grid)((FrameworkElement)this).FindName("BuddyProfileContainer");
			gridView = (GridView)((FrameworkElement)this).FindName("gridView");
			ZoomedOutGridView = (GridView)((FrameworkElement)this).FindName("ZoomedOutGridView");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0060: Unknown result type (might be due to invalid IL or missing references)
		//IL_0066: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_0095: Unknown result type (might be due to invalid IL or missing references)
		//IL_009b: Expected O, but got Unknown
		//IL_00ba: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c4: Expected O, but got Unknown
		//IL_00ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d0: Expected O, but got Unknown
		//IL_00ef: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f9: Expected O, but got Unknown
		//IL_00ff: Unknown result type (might be due to invalid IL or missing references)
		//IL_0106: Expected O, but got Unknown
		//IL_0127: Unknown result type (might be due to invalid IL or missing references)
		//IL_0131: Expected O, but got Unknown
		//IL_0132: Unknown result type (might be due to invalid IL or missing references)
		//IL_0139: Expected O, but got Unknown
		//IL_015a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0164: Expected O, but got Unknown
		//IL_016a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0171: Expected O, but got Unknown
		//IL_0192: Unknown result type (might be due to invalid IL or missing references)
		//IL_019c: Expected O, but got Unknown
		//IL_01a2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a9: Expected O, but got Unknown
		//IL_01ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d4: Expected O, but got Unknown
		//IL_01da: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e1: Expected O, but got Unknown
		//IL_0202: Unknown result type (might be due to invalid IL or missing references)
		//IL_020c: Expected O, but got Unknown
		//IL_0212: Unknown result type (might be due to invalid IL or missing references)
		//IL_0219: Expected O, but got Unknown
		//IL_023a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0244: Expected O, but got Unknown
		//IL_024a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0251: Expected O, but got Unknown
		//IL_027d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0284: Expected O, but got Unknown
		//IL_02c1: Unknown result type (might be due to invalid IL or missing references)
		//IL_02cb: Expected O, but got Unknown
		//IL_02dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_02e7: Expected O, but got Unknown
		//IL_02f9: Unknown result type (might be due to invalid IL or missing references)
		//IL_0303: Expected O, but got Unknown
		//IL_0315: Unknown result type (might be due to invalid IL or missing references)
		//IL_031f: Expected O, but got Unknown
		//IL_0331: Unknown result type (might be due to invalid IL or missing references)
		//IL_033b: Expected O, but got Unknown
		//IL_034d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0357: Expected O, but got Unknown
		//IL_0369: Unknown result type (might be due to invalid IL or missing references)
		//IL_0373: Expected O, but got Unknown
		//IL_0382: Unknown result type (might be due to invalid IL or missing references)
		//IL_038c: Expected O, but got Unknown
		//IL_039b: Unknown result type (might be due to invalid IL or missing references)
		//IL_03a5: Expected O, but got Unknown
		//IL_03b4: Unknown result type (might be due to invalid IL or missing references)
		//IL_03be: Expected O, but got Unknown
		//IL_03c1: Unknown result type (might be due to invalid IL or missing references)
		//IL_03c8: Expected O, but got Unknown
		//IL_03e9: Unknown result type (might be due to invalid IL or missing references)
		//IL_03f3: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val12 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val12, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val12, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(Page_Loaded));
			break;
		}
		case 2:
		{
			UIElement val11 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val11, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val11, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 3:
		{
			UIElement val10 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ProfileImage_Tapped));
			break;
		}
		case 4:
		{
			UIElement val8 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RightTappedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(UIElement.add_RightTapped)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(UIElement.remove_RightTapped)), new RightTappedEventHandler(DeleteGroup_Tapped));
			UIElement val9 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(GroupGrid_Tapped_2));
			break;
		}
		case 5:
		{
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Me_Tapped_1));
			break;
		}
		case 6:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ProfileImage_Tapped));
			break;
		}
		case 7:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ProfileImage_Tapped));
			break;
		}
		case 8:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Buddy_Tapped_1));
			break;
		}
		case 9:
		{
			AppBar val2 = (AppBar)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val2, (nint)__ldftn(AppBar.add_Closed)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(AppBar.remove_Closed)), appBar_Closed);
			AppBar val3 = (AppBar)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val3, (nint)__ldftn(AppBar.add_Opened)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(AppBar.remove_Opened)), appBar_Opened);
			break;
		}
		case 10:
			((ImageButton)target).Click += new RoutedEventHandler(Suggestions_Click);
			break;
		case 11:
			((ImageButton)target).Click += new RoutedEventHandler(AddGroup_Click);
			break;
		case 12:
			((ImageButton)target).Click += new RoutedEventHandler(AddBuddy_Click);
			break;
		case 13:
			((ImageButton)target).Click += new RoutedEventHandler(AddBuddyGroup_Click);
			break;
		case 14:
			((ImageButton)target).Click += new RoutedEventHandler(RemoveBuddyGroup_Click);
			break;
		case 15:
			((ImageButton)target).Click += new RoutedEventHandler(AddBuddyGroup_Click_1);
			break;
		case 16:
			((ImageButton)target).Click += new RoutedEventHandler(StartChat_Click);
			break;
		case 17:
			((ImageButton)target).Click += new RoutedEventHandler(Broadcast_Click);
			break;
		case 18:
			((ImageButton)target).Click += new RoutedEventHandler(Block_Click);
			break;
		case 19:
			((ImageButton)target).Click += new RoutedEventHandler(DeleteGroup_Click);
			break;
		case 20:
		{
			Selector val = (Selector)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SelectionChangedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(Selector.add_SelectionChanged)), new Action<EventRegistrationToken>(val, (nint)__ldftn(Selector.remove_SelectionChanged)), new SelectionChangedEventHandler(BuddyList_Selected));
			break;
		}
		}
		_contentLoaded = true;
	}
}
