using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using System.Windows.Shapes;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class LoginPage : PhoneApplicationPage
{
	private LoginPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal CheckBox checkBoxLogin;

	internal Grid ContentPanel;

	internal TextBlock textBlockEmail;

	internal TextBox textBoxUserID;

	internal TextBlock textBlockPassword;

	internal PasswordBox textBoxPassword;

	internal Button btnLogin;

	internal Button btnCancel;

	internal Rectangle UploadingBgRect;

	internal ProgressBar UploadingProgress;

	private bool _contentLoaded;

	public LoginPage()
	{
		InitializeComponent();
		_viewModel = new LoginPageViewModel((PhoneApplicationPage)(object)this);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).NavigationService.RemoveBackEntry();
		IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
		if (queryString.ContainsKey("SITE"))
		{
			_viewModel.OnNavigatedTo(queryString["SITE"]);
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void btnLogin_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.Login(textBoxUserID.Text, textBoxPassword.Password, checkBoxLogin.IsChecked.Value);
	}

	private void btnCancel_Click(object sender, RoutedEventArgs e)
	{
		try
		{
			Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
		}
		catch (InvalidOperationException)
		{
		}
	}

	private void textBoxUserID_TextInput(object sender, TextCompositionEventArgs e)
	{
		if (e.Text == "\r")
		{
			textBoxPassword.Focus();
		}
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/LoginPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			checkBoxLogin = (CheckBox)((FrameworkElement)this).FindName("checkBoxLogin");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			textBlockEmail = (TextBlock)((FrameworkElement)this).FindName("textBlockEmail");
			textBoxUserID = (TextBox)((FrameworkElement)this).FindName("textBoxUserID");
			textBlockPassword = (TextBlock)((FrameworkElement)this).FindName("textBlockPassword");
			textBoxPassword = (PasswordBox)((FrameworkElement)this).FindName("textBoxPassword");
			btnLogin = (Button)((FrameworkElement)this).FindName("btnLogin");
			btnCancel = (Button)((FrameworkElement)this).FindName("btnCancel");
			UploadingBgRect = (Rectangle)((FrameworkElement)this).FindName("UploadingBgRect");
			UploadingProgress = (ProgressBar)((FrameworkElement)this).FindName("UploadingProgress");
		}
	}
}
