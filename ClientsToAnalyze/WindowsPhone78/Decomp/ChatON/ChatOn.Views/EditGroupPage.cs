using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Services;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Samsung.UI;

namespace ChatOn.Views;

public class EditGroupPage : PhoneApplicationPage
{
	private EditGroupPageViewModel _viewModel;

	private ListReorder _listReorder;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal ListBox GroupList;

	private bool _contentLoaded;

	public EditGroupPage()
	{
		InitializeComponent();
		_viewModel = new EditGroupPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
		((FrameworkElement)this).Loaded += EditGroupPage_Loaded;
	}

	private void EditGroupPage_Loaded(object sender, RoutedEventArgs e)
	{
		_listReorder = new ListReorder(GroupList, _viewModel.GroupItems, null, ReorderType.GuidelineVerticalAlignment);
		_listReorder.ChangeItemOrderCompleted += _listReorder_ChangeItemOrderCompleted;
	}

	private void _listReorder_ChangeItemOrderCompleted(object sender, ChangeItemOrderEventArgs e)
	{
	}

	private void Grid_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenAddGroupPage((PhoneApplicationPage)(object)this);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		((Page)this).OnNavigatedFrom(e);
		if (_listReorder != null)
		{
			_listReorder.Dispose();
			_listReorder = null;
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void ImageButton_Click(object sender, RoutedEventArgs e)
	{
		FrameworkElement frameworkElement = sender as FrameworkElement;
		Point position = frameworkElement.TransformToVisual(Application.Current.RootVisual).Transform(new Point(frameworkElement.ActualWidth / 2.0, frameworkElement.ActualHeight / 2.0));
		_listReorder.ChangeItemOrder(position);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/EditGroupPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			GroupList = (ListBox)((FrameworkElement)this).FindName("GroupList");
		}
	}
}
