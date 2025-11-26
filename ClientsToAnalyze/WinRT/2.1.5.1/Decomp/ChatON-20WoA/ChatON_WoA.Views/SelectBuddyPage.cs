using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.ViewModels;
using com.sec.ssm.common;
using Windows.UI;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class SelectBuddyPage : Page, IComponentConnector
{
	public delegate void SelectBuddyPageEventHandler(object sender, object arg);

	private SelectBuddyPageViewModel _viewModel;

	private static List<string> _exceptionNumbers;

	private static List<string> _preSelectedNumbers;

	private static ChatType _chatType;

	private static bool _isReturnAllMode;

	private static bool _isExceptSpecialBuddies = false;

	private static int _selectionCountLimit = 0;

	public static bool isRemoveMode = false;

	private int TotalBuddy;

	private static SelectBuddyMode _mode;

	private static SelectBuddyPage _activeInstance;

	private List<BuddySummary> _listGroupName = new List<BuddySummary>();

	private string[] Bufmembers;

	private bool _isSelectByProgram;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid Current;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button OKButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SemanticZoom semanticZoom;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView ZoomedOutGridView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView gridView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton SelectAllButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtsubCount;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static SelectBuddyPage ActiveInstance => _activeInstance;

	public static int SelectionCountLimit
	{
		get
		{
			return _selectionCountLimit;
		}
		set
		{
			_selectionCountLimit = value;
		}
	}

	public static List<string> ExceptionNumbers
	{
		get
		{
			return _exceptionNumbers;
		}
		set
		{
			_exceptionNumbers = value;
		}
	}

	public static List<string> PreSelectedNumbers
	{
		get
		{
			return _preSelectedNumbers;
		}
		set
		{
			_preSelectedNumbers = value;
		}
	}

	public static ChatType ChatType
	{
		get
		{
			return _chatType;
		}
		set
		{
			_chatType = value;
		}
	}

	public static bool IsReturnAllMode
	{
		get
		{
			return _isReturnAllMode;
		}
		set
		{
			_isReturnAllMode = value;
		}
	}

	public static bool IsExceptSpecialBuddies
	{
		get
		{
			return _isExceptSpecialBuddies;
		}
		set
		{
			_isExceptSpecialBuddies = value;
		}
	}

	public static SelectBuddyMode Mode
	{
		get
		{
			return _mode;
		}
		set
		{
			_mode = value;
		}
	}

	public static event SelectBuddyPageEventHandler SelectionCompleted;

	public SelectBuddyPage()
	{
		InitializeComponent();
		_activeInstance = this;
		_viewModel = new SelectBuddyPageViewModel(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		((Control)OKButton).put_IsEnabled(false);
		SelectionCountLimit = ChatService.MAX_CHAT_MEMBERS - 1;
	}

	private void SelectBuddyPage_Loaded(object sender, RoutedEventArgs e)
	{
		if (isRemoveMode)
		{
			((ContentControl)OKButton).put_Content((object)Utility.GetResourceString("IDS_CHATON_OPT_REMOVE"));
		}
		else
		{
			((ContentControl)OKButton).put_Content((object)Utility.GetResourceString("IDS_CHATON_BUTTON_ADD"));
		}
		if (Mode == SelectBuddyMode.StartChat || Mode == SelectBuddyMode.StartBroadcast)
		{
			((ContentControl)OKButton).put_Content((object)Utility.GetResourceString("IDS_CHATON_BUTTON_START"));
		}
		if (Mode == SelectBuddyMode.AddMember)
		{
			((ContentControl)OKButton).put_Content((object)Utility.GetResourceString("IDS_CHATON_BUTTON_ADD"));
		}
		if (Mode == SelectBuddyMode.InviteBuddy && (_viewModel.ShowingItems == null || _viewModel.ShowingItems.Count() == 0))
		{
			Utility.ShowSimpleToastNotification(string.Format("{0}", new object[1] { Utility.GetResourceString("IDS_CHATON_POP_ALL_BUDDIES_ALREADY_INVITED_TO_THIS_CHAT") }));
		}
		if (_viewModel.SelectBuddyModel.SelectedBuddyItems.Count > 0)
		{
			((Control)OKButton).put_IsEnabled(true);
		}
		if (PreSelectedNumbers != null)
		{
			ReflectPreselectedBuddies();
			PreSelectedNumbers = null;
		}
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.ClearSelectedBuddy();
		if (BuddyListPage.ActiveInstance != null)
		{
			BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: true);
		}
		if (!string.IsNullOrEmpty(_viewModel.Keyword))
		{
			Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
		}
		else if (SelectBuddyPage.SelectionCompleted != null)
		{
			SelectBuddyPage.SelectionCompleted(this, _viewModel.SelectBuddyModel.SelectedBuddyItems);
		}
		else
		{
			Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
		}
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		_isReturnAllMode = false;
		_isExceptSpecialBuddies = false;
		_exceptionNumbers = null;
		_preSelectedNumbers = null;
		SelectBuddyPage.SelectionCompleted = null;
		foreach (BuddySummary selectedBuddyItem in _viewModel.SelectBuddyModel.SelectedBuddyItems)
		{
			selectedBuddyItem.ResetColor();
		}
		if (!isRelatedChat(e.SourcePageType))
		{
			_viewModel.ClearSelectedBuddy();
		}
	}

	private bool isRelatedChat(Type page)
	{
		if ((object)page == typeof(SelectBuddyPage))
		{
			return true;
		}
		if ((object)page == typeof(ChatListPage))
		{
			return true;
		}
		if ((object)page == typeof(ChatDetailPage))
		{
			return true;
		}
		return false;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e.Parameter != null)
		{
			_viewModel.Keyword = (string)e.Parameter;
		}
		ResetHilightedBuddy();
		UpdateSelectionTitleCount();
	}

	public void ResetHilightedBuddy()
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Expected O, but got Unknown
		ObservableCollection<BuddySummary> showingItems = PivotPage.ActiveInstance.ViewModel.ShowingItems;
		SolidColorBrush nameForeground = new SolidColorBrush(Colors.Black);
		foreach (BuddySummary item in showingItems)
		{
			item.NameForeground = nameForeground;
		}
	}

	private void ReflectPreselectedBuddies()
	{
		foreach (string preSelectedNumber in _preSelectedNumbers)
		{
			ObservableCollection<BuddySummary> showingItems = _viewModel.ShowingItems;
			Func<BuddySummary, bool> predicate = (BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber == preSelectedNumber;
			BuddySummary item = showingItems.FirstOrDefault(predicate);
			((ListViewBase)gridView).SelectedItems.Add(item);
		}
	}

	private void SelecAllButton_Click(object sender, RoutedEventArgs e)
	{
		_isSelectByProgram = true;
		List<BuddySummary> list = _viewModel.ShowingItems.Where((BuddySummary x) => x.Buddy != null && x.HeaderType == BuddyListHeaderType.Normal).ToList();
		if (SelectionCountLimit > 0)
		{
			list = list.Take(SelectionCountLimit).ToList();
			List<string> phones = new List<string>();
			foreach (BuddySummary item in list)
			{
				phones.Add(item.Buddy.PhoneNumber);
			}
			list.AddRange(_viewModel.ShowingItems.Where((BuddySummary x) => x.Buddy != null && x.HeaderType != BuddyListHeaderType.Normal && x.HeaderType != BuddyListHeaderType.Group && phones.Contains(x.Buddy.PhoneNumber)));
		}
		bool selectAllState = GetSelectAllState(list);
		foreach (BuddySummary item2 in list)
		{
			if (!selectAllState)
			{
				((ListViewBase)gridView).SelectedItems.Add(item2);
			}
			else
			{
				((Selector)gridView).put_SelectedIndex(-1);
			}
		}
		if (!selectAllState)
		{
			_viewModel.AddSelectedBuddyList(((ListViewBase)gridView).SelectedItems.Cast<BuddySummary>());
		}
		else
		{
			_viewModel.ClearSelectedBuddy();
		}
		UpdateSelectionTitleCount();
		((Control)OKButton).put_IsEnabled(_viewModel.SelectBuddyModel.SelectedBuddyItems.Count > 0);
		_isSelectByProgram = false;
	}

	private bool GetSelectAllState(List<BuddySummary> buddies)
	{
		bool flag = false;
		if (SelectionCountLimit > 0)
		{
			if (buddies.Count > SelectionCountLimit)
			{
				return _viewModel.SelectBuddyModel.SelectedBuddyItems.Count >= SelectionCountLimit;
			}
			return _viewModel.SelectBuddyModel.SelectedBuddyItems.Count == buddies.Count;
		}
		return _viewModel.SelectBuddyModel.SelectedBuddyItems.Count != buddies.Count();
	}

	private void DoneButton_Click(object sender, RoutedEventArgs e)
	{
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (LoadingIndicator.ActiveIndicator == null && SelectBuddyPage.SelectionCompleted != null)
		{
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot, Utility.GetResourceString("IDS_CHATON_BODY_LOADING_ING"));
		}
		if (!Utility.CheckForInternetConnection())
		{
			try
			{
				LoadingIndicator.StopLoading();
				MessageDialog val = new MessageDialog(Utility.GetResourceString("IDS_CHATON_POP_NETWORK_ERROR"));
				val.ShowAsync();
				return;
			}
			catch
			{
				return;
			}
		}
		if (_isReturnAllMode)
		{
			if (SelectBuddyPage.SelectionCompleted != null)
			{
				SelectBuddyPage.SelectionCompleted(this, _viewModel.BuddyItems);
			}
		}
		else if (SelectBuddyPage.SelectionCompleted != null)
		{
			SelectBuddyPage.SelectionCompleted(this, _viewModel.SelectBuddyModel.SelectedBuddyItems);
		}
		_viewModel.ClearSelectedBuddy();
	}

	private void Cancel_Click_1(object sender, RoutedEventArgs e)
	{
		_viewModel.ClearSelectedBuddy();
		if (!string.IsNullOrEmpty(_viewModel.Keyword))
		{
			PivotPage.ActiveInstance.ViewModel.SelectedIndex = 0;
			((Page)this).Frame.SetNavigationState("1,0");
			((Page)this).Frame.Navigate(typeof(PivotPage));
		}
		else if (SelectBuddyPage.SelectionCompleted != null)
		{
			SelectBuddyPage.SelectionCompleted(this, _viewModel.SelectBuddyModel.SelectedBuddyItems);
		}
		else
		{
			((Page)this).Frame.GoBack();
		}
		isRemoveMode = false;
	}

	private void Buddy_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
	}

	private void RemoveSelectedGroup()
	{
		//IL_003e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0048: Expected O, but got Unknown
		IEnumerable<BuddySummary> source = ((ListViewBase)gridView).SelectedItems.Cast<BuddySummary>();
		BuddySummary buddySummary = source.FirstOrDefault((BuddySummary x) => x.Group != null);
		if (buddySummary != null)
		{
			buddySummary.NameForeground = new SolidColorBrush(Colors.Black);
			((ListViewBase)gridView).SelectedItems.Remove(buddySummary);
		}
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_002d: Expected O, but got Unknown
		BuddyListHeader buddyListHeader = null;
		FrameworkElement val = null;
		if ((val = (FrameworkElement)((sender is FrameworkElement) ? sender : null)) != null && val.DataContext is BuddyListHeader { Index: >=0 } buddyListHeader2)
		{
			SemanticZoomLocation val2 = new SemanticZoomLocation();
			val2.put_Item((object)_viewModel.ShowingItems[buddyListHeader2.Index]);
			((ListViewBase)gridView).MakeVisible(val2);
		}
	}

	private void Group_Tapped(object sender, TappedRoutedEventArgs e)
	{
		//IL_0098: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a2: Expected O, but got Unknown
		_isSelectByProgram = true;
		BuddySummary buddySummary = null;
		FrameworkElement val = null;
		if ((val = (FrameworkElement)((sender is FrameworkElement) ? sender : null)) == null || !(val.DataContext is BuddySummary buddySummary2) || buddySummary2 == null || buddySummary2.Group == null)
		{
			return;
		}
		((Selector)gridView).put_SelectedIndex(-1);
		if (!((ListViewBase)gridView).SelectedItems.Contains(buddySummary2))
		{
			_viewModel.AddSelectedGroup(buddySummary2);
			foreach (BuddySummary selectedBuddyItem in _viewModel.SelectBuddyModel.SelectedBuddyItems)
			{
				((ListViewBase)gridView).SelectedItems.Add(selectedBuddyItem);
				selectedBuddyItem.NameForeground = new SolidColorBrush(Colors.White);
			}
		}
		((Control)OKButton).put_IsEnabled(_viewModel.SelectBuddyModel.SelectedBuddyItems.Count > 0);
		UpdateSelectionTitleCount();
		_isSelectByProgram = false;
	}

	internal void UpdateCountText(int count)
	{
		string resourceString = Utility.GetResourceString("WP7_CHATON_PD_SELECTED");
		resourceString = resourceString.Replace("%d1", count.ToString());
		resourceString = resourceString.Replace("%d2", _viewModel.TotalBuddyMember.ToString());
		txtsubCount.put_Text(resourceString);
	}

	private void SelectedBuddyTapped(object sender, TappedRoutedEventArgs e)
	{
		try
		{
			BuddySummary buddySummary = null;
			FrameworkElement val = null;
			if ((val = (FrameworkElement)((sender is FrameworkElement) ? sender : null)) != null && val.DataContext is BuddySummary item)
			{
				_viewModel.RemoveSelectedBuddy(item);
				((ListViewBase)gridView).SelectedItems.Remove(item);
				UpdateSelectionTitleCount();
			}
		}
		catch (Exception)
		{
		}
	}

	private void FavoriteTapped(object sender, TappedRoutedEventArgs e)
	{
		IEnumerable<BuddySummary> enumerable = _viewModel.ShowingItems.Where((BuddySummary p) => p.Buddy != null && p.Buddy.IsFavorite);
		int num = 0;
		foreach (BuddySummary item in enumerable)
		{
			if (item.Buddy.IsChecked)
			{
				num++;
			}
			if (num == enumerable.Count())
			{
				List<BuddySummary> list = enumerable.ToList();
				for (int num2 = 0; num2 < num; num2++)
				{
					list[num2].Buddy.IsChecked = false;
					_viewModel.UpdateSelectedBuddyItems(list[num2]);
				}
			}
			else
			{
				item.Buddy.IsChecked = true;
				_viewModel.UpdateSelectedBuddyItems(item);
			}
		}
		int count = _viewModel.SelectBuddyModel.SelectedBuddyItems.Distinct().Count();
		UpdateCountText(count);
	}

	public void UpdateSelectionTitleCount()
	{
		int num = _viewModel.ShowingItems.Where((BuddySummary x) => x.Buddy != null && x.HeaderType == BuddyListHeaderType.Normal).Count();
		int count = _viewModel.SelectBuddyModel.SelectedBuddyItems.Count;
		string resourceString = Utility.GetResourceString("WP7_CHATON_PD_SELECTED");
		resourceString = resourceString.Replace("%d1", count.ToString());
		resourceString = resourceString.Replace("%d2", num.ToString());
		txtsubCount.put_Text(resourceString);
	}

	private void OnHeader_Click(object sender, TappedRoutedEventArgs e)
	{
		try
		{
			if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is BuddySummary item)
			{
				((ListViewBase)gridView).SelectedItems.Remove(item);
				semanticZoom.put_IsZoomedInViewActive(false);
			}
		}
		catch (Exception)
		{
		}
	}

	private void gridView_SelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		if (_isSelectByProgram)
		{
			return;
		}
		if (e.AddedItems.Count > 0)
		{
			BuddySummary buddySummary = e.AddedItems.Cast<BuddySummary>().FirstOrDefault();
			if (buddySummary.Type == BuddySummary.ItemType.Index)
			{
				((ListViewBase)gridView).SelectedItems.Remove(buddySummary);
				semanticZoom.put_IsZoomedInViewActive(false);
				return;
			}
			if (buddySummary.Type == BuddySummary.ItemType.Group)
			{
				RemoveSelectedGroup();
			}
			if (buddySummary.Buddy == null)
			{
				return;
			}
			_viewModel.AddSelectedBuddy(buddySummary);
			if (buddySummary.Buddy != null)
			{
				SelectBuddy(buddySummary, status: true);
			}
		}
		else if (e.RemovedItems.Count > 0)
		{
			BuddySummary buddySummary2 = e.RemovedItems.Cast<BuddySummary>().FirstOrDefault();
			if (buddySummary2.Buddy == null)
			{
				return;
			}
			_viewModel.RemoveSelectedBuddy(buddySummary2);
			if (buddySummary2.Buddy != null)
			{
				SelectBuddy(buddySummary2, status: false);
			}
		}
		UpdateSelectionTitleCount();
		((Control)OKButton).put_IsEnabled(_viewModel.SelectBuddyModel.SelectedBuddyItems.Count > 0);
	}

	private void SelectBuddy(BuddySummary item, bool status)
	{
		//IL_00ab: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b5: Expected O, but got Unknown
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected O, but got Unknown
		List<BuddySummary> list = _viewModel.ShowingItems.Where((BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber == item.Buddy.PhoneNumber).ToList();
		if (status)
		{
			if (list.Count <= 1)
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
		if (list.Count <= 1)
		{
			return;
		}
		foreach (BuddySummary item3 in list)
		{
			item3.NameForeground = new SolidColorBrush(Colors.Black);
			((ListViewBase)gridView).SelectedItems.Remove(item3);
		}
	}

	private void PerformSelectGroup(BuddySummary item)
	{
	}

	internal void ClearSelectionBegin()
	{
		_isSelectByProgram = true;
	}

	internal void ClearSelectionEnd()
	{
		_isSelectByProgram = false;
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
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SelectBuddyPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			Current = (Grid)((FrameworkElement)this).FindName("Current");
			OKButton = (Button)((FrameworkElement)this).FindName("OKButton");
			semanticZoom = (SemanticZoom)((FrameworkElement)this).FindName("semanticZoom");
			ZoomedOutGridView = (GridView)((FrameworkElement)this).FindName("ZoomedOutGridView");
			gridView = (GridView)((FrameworkElement)this).FindName("gridView");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			SelectAllButton = (ImageButton)((FrameworkElement)this).FindName("SelectAllButton");
			pageTitle1 = (TextBlock)((FrameworkElement)this).FindName("pageTitle1");
			txtsubCount = (TextBlock)((FrameworkElement)this).FindName("txtsubCount");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0038: Unknown result type (might be due to invalid IL or missing references)
		//IL_003e: Expected O, but got Unknown
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0067: Expected O, but got Unknown
		//IL_006d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0073: Expected O, but got Unknown
		//IL_0092: Unknown result type (might be due to invalid IL or missing references)
		//IL_009c: Expected O, but got Unknown
		//IL_00a2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a8: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00d7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00de: Expected O, but got Unknown
		//IL_00ff: Unknown result type (might be due to invalid IL or missing references)
		//IL_0109: Expected O, but got Unknown
		//IL_010f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0116: Expected O, but got Unknown
		//IL_0137: Unknown result type (might be due to invalid IL or missing references)
		//IL_0141: Expected O, but got Unknown
		//IL_0147: Unknown result type (might be due to invalid IL or missing references)
		//IL_014e: Expected O, but got Unknown
		//IL_016f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0179: Expected O, but got Unknown
		//IL_017f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0186: Expected O, but got Unknown
		//IL_01a7: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b1: Expected O, but got Unknown
		//IL_01b7: Unknown result type (might be due to invalid IL or missing references)
		//IL_01be: Expected O, but got Unknown
		//IL_01df: Unknown result type (might be due to invalid IL or missing references)
		//IL_01e9: Expected O, but got Unknown
		//IL_01ec: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f3: Expected O, but got Unknown
		//IL_0214: Unknown result type (might be due to invalid IL or missing references)
		//IL_021e: Expected O, but got Unknown
		//IL_022d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0237: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val9 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(SelectBuddyPage_Loaded));
			break;
		}
		case 2:
		{
			UIElement val8 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 3:
		{
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(SelectedBuddyTapped));
			break;
		}
		case 4:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Group_Tapped));
			break;
		}
		case 5:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Buddy_Tapped_1));
			break;
		}
		case 6:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(DoneButton_Click));
			break;
		}
		case 7:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(Cancel_Click_1));
			break;
		}
		case 8:
		{
			Selector val2 = (Selector)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SelectionChangedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(Selector.add_SelectionChanged)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(Selector.remove_SelectionChanged)), new SelectionChangedEventHandler(gridView_SelectionChanged));
			break;
		}
		case 9:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		case 10:
			((ImageButton)target).Click += new RoutedEventHandler(SelecAllButton_Click);
			break;
		}
		_contentLoaded = true;
	}
}
