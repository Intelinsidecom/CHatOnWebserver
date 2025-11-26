using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Res;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class AddTextProfileInfoPage : PhoneApplicationPage
{
	private bool _isNew = true;

	private AddTextProfileInfoPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal TextBox InputBox;

	private bool _contentLoaded;

	public AddTextProfileInfoPage()
	{
		InitializeComponent();
		_viewModel = new AddTextProfileInfoPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
		InputBox.Loaded += InputBox_Loaded;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_SAVE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (queryString.ContainsKey("Param"))
			{
				_viewModel.Param = queryString["Param"];
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	protected override void OnBackKeyPress(CancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (LoadingIndicator.HandleBackKey())
		{
			e.Cancel = true;
		}
		((PhoneApplicationPage)this).OnBackKeyPress(e);
	}

	private void InputBox_Loaded(object sender, RoutedEventArgs e)
	{
		InputBox.Focus();
	}

	private void SaveButton_Click(object sender, EventArgs e)
	{
		InputBox.IsEnabled = false;
		InputBox.IsEnabled = true;
		_viewModel.Save();
	}

	private void CancelButton_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void InputBox_TextChanged(object sender, TextChangedEventArgs e)
	{
		if (InputBox.Text.Length > InputBox.MaxLength)
		{
			((Control)this).Focus();
			InputBox.Text = InputBox.Text.Remove(InputBox.MaxLength);
			InputBox.SelectionStart = InputBox.MaxLength;
			InputBox.Focus();
		}
		_viewModel.InputText = (sender as TextBox).Text;
		if (_viewModel.Param == "name")
		{
			if (string.IsNullOrEmpty(_viewModel.InputText))
			{
				object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
				((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).IsEnabled = false;
			}
			else
			{
				object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
				((ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null)).IsEnabled = true;
			}
		}
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AddTextProfileInfoPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
		}
	}
}
