using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.ApplicationModel.Search;
using Windows.UI;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class SearchBuddyPage : Page, IComponentConnector
{
	private BuddySummary _lastOpenedDialogBuddy;

	private bool _isSelectByProgram;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid Current;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button ChatButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button BroadcastButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView gridView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid BuddyProfileContainer;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtSearchQuery;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	private SearchBuddyPageViewModel ViewModel => ((FrameworkElement)this).DataContext as SearchBuddyPageViewModel;

	public SearchBuddyPage()
	{
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)new SearchBuddyPageViewModel());
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		string keyword = e.Parameter as string;
		ViewModel.Keyword = keyword;
		ViewModel.OnSearch();
		SearchPane.GetForCurrentView().Show();
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		((Page)this).OnNavigatedFrom(e);
	}

	private async void StartChat(Buddy buddy)
	{
		await PivotPage.ActiveInstance.OpenChatAsync(buddy);
		((Page)this).Frame.Navigate(typeof(PivotPage));
	}

	private void CloseProfileDialog()
	{
		//IL_0013: Unknown result type (might be due to invalid IL or missing references)
		//IL_001d: Expected O, but got Unknown
		if (_lastOpenedDialogBuddy != null)
		{
			_lastOpenedDialogBuddy.Background = new SolidColorBrush(Colors.Transparent);
			((ICollection<UIElement>)((Panel)BuddyProfileContainer).Children).Clear();
			((UIElement)BuddyProfileContainer).put_Visibility((Visibility)1);
			_lastOpenedDialogBuddy = null;
		}
	}

	private void Buddyitem_Tap(object sender, TappedRoutedEventArgs e)
	{
		BuddySummary buddySummary = null;
		FrameworkElement val = null;
		if ((val = (FrameworkElement)((sender is FrameworkElement) ? sender : null)) != null && val.DataContext is BuddySummary buddySummary2)
		{
			StartChat(buddySummary2.Buddy);
		}
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		PivotPage.ActiveInstance.ViewModel.SelectedIndex = 0;
		((FrameworkElement)this).put_DataContext((object)null);
		Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
	}

	private void gridView_SelectionChanged(object sender, SelectionChangedEventArgs e)
	{
		if (_isSelectByProgram)
		{
			return;
		}
		if (e.AddedItems.Count > 0)
		{
			SearchResult searchResult = e.AddedItems.Cast<SearchResult>().FirstOrDefault();
			_ = searchResult.BuddySummary.Type;
			_ = 2;
			if (searchResult.BuddySummary.Buddy == null)
			{
				return;
			}
			searchResult.IsEmptySearch = true;
			if (ViewModel != null)
			{
				ViewModel.AddSelectedBuddy(searchResult.BuddySummary);
			}
		}
		else if (e.RemovedItems.Count > 0)
		{
			SearchResult searchResult2 = e.RemovedItems.Cast<SearchResult>().FirstOrDefault();
			if (searchResult2.BuddySummary.Buddy == null)
			{
				return;
			}
			FrameworkElement val = null;
			if ((val = (FrameworkElement)((sender is FrameworkElement) ? sender : null)) != null)
			{
				((DependencyObject)val).SetValue(BindingService.HighlightBrushProperty, (object)"#FFFA8719");
			}
			searchResult2.IsEmptySearch = false;
			if (ViewModel != null)
			{
				ViewModel.RemoveSelectedBuddy(searchResult2.BuddySummary);
			}
		}
		if (ViewModel != null)
		{
			bool flag = ViewModel.SelectedBuddyItems.Count > 0;
			((Control)ChatButton).put_IsEnabled(flag);
			((Control)BroadcastButton).put_IsEnabled(flag);
		}
	}

	private void ChatButton_OnTapped(object sender, TappedRoutedEventArgs e)
	{
		ViewModel.StartChat();
	}

	private void BroadcastButton_OnTapped(object sender, TappedRoutedEventArgs e)
	{
		ViewModel.StartBroadcast();
	}

	private void SelectedBuddy_Tapped(object sender, TappedRoutedEventArgs e)
	{
		_isSelectByProgram = true;
		try
		{
			BuddySummary buddySummary = null;
			FrameworkElement val = null;
			if ((val = (FrameworkElement)((sender is FrameworkElement) ? sender : null)) != null && val.DataContext is BuddySummary item)
			{
				ViewModel.RemoveSelectedBuddy(item);
				((ListViewBase)gridView).SelectedItems.Remove(item);
			}
		}
		catch (Exception)
		{
		}
		_isSelectByProgram = false;
	}

	private void Cancel_Tapped(object sender, TappedRoutedEventArgs e)
	{
		while ((object)((Page)this).Frame.CurrentSourcePageType != typeof(PivotPage))
		{
			Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
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
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SearchBuddyPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			Current = (Grid)((FrameworkElement)this).FindName("Current");
			ChatButton = (Button)((FrameworkElement)this).FindName("ChatButton");
			BroadcastButton = (Button)((FrameworkElement)this).FindName("BroadcastButton");
			gridView = (GridView)((FrameworkElement)this).FindName("gridView");
			BuddyProfileContainer = (Grid)((FrameworkElement)this).FindName("BuddyProfileContainer");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle1 = (TextBlock)((FrameworkElement)this).FindName("pageTitle1");
			txtSearchQuery = (TextBlock)((FrameworkElement)this).FindName("txtSearchQuery");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0028: Unknown result type (might be due to invalid IL or missing references)
		//IL_002e: Expected O, but got Unknown
		//IL_004d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0057: Expected O, but got Unknown
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_0082: Unknown result type (might be due to invalid IL or missing references)
		//IL_008c: Expected O, but got Unknown
		//IL_0092: Unknown result type (might be due to invalid IL or missing references)
		//IL_0098: Expected O, but got Unknown
		//IL_00b7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c1: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ce: Expected O, but got Unknown
		//IL_00ef: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f9: Expected O, but got Unknown
		//IL_00fc: Unknown result type (might be due to invalid IL or missing references)
		//IL_0103: Expected O, but got Unknown
		//IL_0124: Unknown result type (might be due to invalid IL or missing references)
		//IL_012e: Expected O, but got Unknown
		//IL_0131: Unknown result type (might be due to invalid IL or missing references)
		//IL_0138: Expected O, but got Unknown
		//IL_0159: Unknown result type (might be due to invalid IL or missing references)
		//IL_0163: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(SelectedBuddy_Tapped));
			break;
		}
		case 2:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ChatButton_OnTapped));
			break;
		}
		case 3:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BroadcastButton_OnTapped));
			break;
		}
		case 4:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Cancel_Tapped));
			break;
		}
		case 5:
		{
			Selector val2 = (Selector)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SelectionChangedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(Selector.add_SelectionChanged)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(Selector.remove_SelectionChanged)), new SelectionChangedEventHandler(gridView_SelectionChanged));
			break;
		}
		case 6:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
