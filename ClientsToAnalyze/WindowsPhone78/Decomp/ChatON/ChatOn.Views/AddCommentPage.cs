using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Res;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class AddCommentPage : PhoneApplicationPage
{
	private bool _isNew = true;

	private string _phoneNumber;

	private static bool _isAdded;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal TextBox InputBox;

	private bool _contentLoaded;

	public static bool IsAdded
	{
		get
		{
			return _isAdded;
		}
		set
		{
			_isAdded = value;
		}
	}

	public AddCommentPage()
	{
		InitializeComponent();
		InputBox.Loaded += InputBox_Loaded;
		_isAdded = false;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_SAVE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
	}

	private void InputBox_Loaded(object sender, RoutedEventArgs e)
	{
		InputBox.Focus();
	}

	private void UploadButton_Click(object sender, EventArgs e)
	{
		InputBox.IsEnabled = false;
		InputBox.IsEnabled = true;
		LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
		LayoutRoot.Children.Add(value);
		SSMService sSMService = new SSMService();
		sSMService.WriteMemoCompleted += ssmService_WriteMemoCompleted;
		sSMService.WriteMemoAsync(_phoneNumber, InputBox.Text);
	}

	private void ssmService_WriteMemoCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode == HttpStatusCode.OK)
		{
			_isAdded = true;
			Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
		}
		else if (string.IsNullOrEmpty(e.ErrorMessage))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else if (e.ErrorMessage.Contains("CCS-00012"))
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_ACCOUNT_NO_LONGER_VALID);
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (queryString.ContainsKey("PhoneNumber"))
			{
				_phoneNumber = queryString["PhoneNumber"];
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
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AddCommentPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
		}
	}
}
