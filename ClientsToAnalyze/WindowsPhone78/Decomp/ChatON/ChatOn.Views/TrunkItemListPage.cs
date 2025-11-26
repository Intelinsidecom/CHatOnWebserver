using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class TrunkItemListPage : PhoneApplicationPage
{
	private TrunkItemListPageViewModel _viewModel;

	private bool _isNew = true;

	private Point _oldPoint;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal TextBlock PageTitle;

	internal Grid ContentPanel;

	internal Image image1;

	internal Image image2;

	internal TextBlock textBlock1;

	internal ListBox TrunkListBox;

	internal ApplicationBarIconButton menu_trunk_sort;

	internal ApplicationBarIconButton menu_trunk_refresh;

	private bool _contentLoaded;

	public TrunkItemListPage()
	{
		InitializeComponent();
		_viewModel = new TrunkItemListPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_OPT1_LIST_BY;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_SK_REFRESH;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (!queryString.ContainsKey("ID"))
			{
				throw new NotImplementedException();
			}
			Guid id = Guid.Parse(queryString["ID"]);
			_viewModel.OpenTrunkList(id);
		}
		else
		{
			_viewModel.OnNavigatedTo();
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void Menu_turnk_sorttype_Click(object sender, EventArgs e)
	{
		_viewModel.MoveToTrunkSort();
	}

	private void Menu_trunk_refresh_Click(object sender, EventArgs e)
	{
		_viewModel.GetItemList();
	}

	private void TrunkItem_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		TrunkItem item = (sender as FrameworkElement).DataContext as TrunkItem;
		_viewModel.MoveToTrunkItemPage(item);
	}

	private void EventBtnUp(object sender, MouseButtonEventArgs e)
	{
		if (e.GetPosition(LayoutRoot).Y - _oldPoint.Y > 200.0)
		{
			_viewModel.GetItemList();
		}
	}

	private void EventBtnDown(object sender, MouseButtonEventArgs e)
	{
		_oldPoint = e.GetPosition(LayoutRoot);
	}

	private void TrunkListBox_SelectionChanged(object sender, SelectionChangedEventArgs e)
	{
	}

	private void Hold_TrunkItem(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_viewModel.OpenTrunkItemContexMenu(sender as FrameworkElement);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/TrunkItemListPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			PageTitle = (TextBlock)((FrameworkElement)this).FindName("PageTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			image1 = (Image)((FrameworkElement)this).FindName("image1");
			image2 = (Image)((FrameworkElement)this).FindName("image2");
			textBlock1 = (TextBlock)((FrameworkElement)this).FindName("textBlock1");
			TrunkListBox = (ListBox)((FrameworkElement)this).FindName("TrunkListBox");
			menu_trunk_sort = (ApplicationBarIconButton)((FrameworkElement)this).FindName("menu_trunk_sort");
			menu_trunk_refresh = (ApplicationBarIconButton)((FrameworkElement)this).FindName("menu_trunk_refresh");
		}
	}
}
