using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class TrunkCommentPage : PhoneApplicationPage
{
	private TrunkCommentPageViewModel _viewModel;

	private bool _isNew = true;

	private bool _isMax;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock PageTitle;

	internal Grid ContentPanel;

	internal TextBox InputBox;

	internal Button button1;

	internal Button button2;

	private bool _contentLoaded;

	public TrunkCommentPage()
	{
		InitializeComponent();
		_viewModel = new TrunkCommentPageViewModel((PhoneApplicationPage)(object)this);
		((FrameworkElement)this).DataContext = _viewModel;
		((FrameworkElement)this).Loaded += TrunkCommentPage_Loaded;
	}

	private void TrunkCommentPage_Loaded(object sender, RoutedEventArgs e)
	{
		InputBox.Focus();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			((Page)this).NavigationContext.QueryString.TryGetValue("itemID", out var value);
			((Page)this).NavigationContext.QueryString.TryGetValue("ID", out var value2);
			Guid id = Guid.Parse(value2);
			_viewModel.OpenTrunkCommentDetail(id, value);
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void TextBox_TextChanged(object sender, TextChangedEventArgs e)
	{
		if (InputBox.Text.Length > 140)
		{
			((Control)this).Focus();
			InputBox.Text = InputBox.Text.Remove(140);
			InputBox.SelectionStart = 140;
			InputBox.Focus();
		}
		_viewModel.InputTextMsg = (sender as TextBox).Text;
	}

	private void BtnUploadClick(object sender, RoutedEventArgs e)
	{
		if (!string.IsNullOrEmpty(InputBox.Text))
		{
			_viewModel.SendComment();
			InputBox.Text = "";
			InputBox.UpdateLayout();
		}
	}

	private void BtnCancelClick(object sender, RoutedEventArgs e)
	{
		_viewModel.GoBackItem();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/TrunkCommentPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			PageTitle = (TextBlock)((FrameworkElement)this).FindName("PageTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
			button1 = (Button)((FrameworkElement)this).FindName("button1");
			button2 = (Button)((FrameworkElement)this).FindName("button2");
		}
	}
}
