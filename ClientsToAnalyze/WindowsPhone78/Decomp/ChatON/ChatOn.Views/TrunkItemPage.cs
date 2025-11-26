using System;
using System.ComponentModel;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Res;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class TrunkItemPage : PhoneApplicationPage
{
	private TrunkItemPageViewModel _viewModel;

	private bool _isNew = true;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal TextBlock PageTitle;

	internal Grid ContentPanel;

	internal Image image2;

	internal Button PreviousButton;

	internal TextBlock textBlock2;

	internal Image image3;

	internal Grid BtnPanel;

	internal Button button1;

	internal ApplicationBarIconButton menu_trunkitem_share;

	private bool _contentLoaded;

	public TrunkItemPage()
	{
		InitializeComponent();
		_viewModel = new TrunkItemPageViewModel((PhoneApplicationPage)(object)this);
		((FrameworkElement)this).DataContext = _viewModel;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_SHARE;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			((Page)this).NavigationContext.QueryString.TryGetValue("itemID", out var value);
			((Page)this).NavigationContext.QueryString.TryGetValue("ID", out var value2);
			Guid id = Guid.Parse(value2);
			_viewModel.OpenTrunkItemDetail(id, value);
		}
		else
		{
			_viewModel.OnNavigatedTo();
		}
		((Page)this).OnNavigatedTo(e);
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		_viewModel.OnNavigatedFrom();
		((Page)this).OnNavigatedFrom(e);
	}

	protected override void OnBackKeyPress(CancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (LightContextMenu.HandleMenuBackKey())
		{
			e.Cancel = true;
		}
		((PhoneApplicationPage)this).OnBackKeyPress(e);
	}

	private void Menu_turnkcomment_share_Click(object sender, EventArgs e)
	{
		_viewModel.ShareTrunkItem();
	}

	private void OpenFile(object sender, MouseButtonEventArgs e)
	{
		_viewModel.OpenFile();
	}

	private void WriteCommentClick(object sender, RoutedEventArgs e)
	{
		_viewModel.MoveToCommentPage();
	}

	private void Hold_CommentItem(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_viewModel.OpenCommentItemContexMenu(sender as FrameworkElement);
	}

	private void OpenVideoFile(object sender, MouseButtonEventArgs e)
	{
		_viewModel.OpenFile();
	}

	private void OpenAMSPlay(object sender, MouseButtonEventArgs e)
	{
		_viewModel.OpenFile();
	}

	private void PreviousBtnClick(object sender, RoutedEventArgs e)
	{
		_viewModel.LoadMoreComment();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0129: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/TrunkItemPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			PageTitle = (TextBlock)((FrameworkElement)this).FindName("PageTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			image2 = (Image)((FrameworkElement)this).FindName("image2");
			PreviousButton = (Button)((FrameworkElement)this).FindName("PreviousButton");
			textBlock2 = (TextBlock)((FrameworkElement)this).FindName("textBlock2");
			image3 = (Image)((FrameworkElement)this).FindName("image3");
			BtnPanel = (Grid)((FrameworkElement)this).FindName("BtnPanel");
			button1 = (Button)((FrameworkElement)this).FindName("button1");
			menu_trunkitem_share = (ApplicationBarIconButton)((FrameworkElement)this).FindName("menu_trunkitem_share");
		}
	}
}
