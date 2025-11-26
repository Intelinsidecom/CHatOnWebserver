using System;
using System.Diagnostics;
using System.Net;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class InputNamePage : PhoneApplicationPage
{
	private SSMService _ssmService;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal StackPanel ContentPanel;

	internal TextBox InputName;

	private bool _contentLoaded;

	public InputNamePage()
	{
		InitializeComponent();
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).Text = ResContainer.IDS_CHATON_SK_OK;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		((ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null)).Text = ResContainer.IDS_CHATON_SK_CANCEL;
		_ssmService = new SSMService();
		_ssmService.RegisterUserCompleted += ssmService_RegisterUserCompleted;
		((FrameworkElement)this).Loaded += InputNamePage_Loaded;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void InputNamePage_Loaded(object sender, RoutedEventArgs e)
	{
		InputName.Focus();
	}

	private void OK_Click(object sender, EventArgs e)
	{
		if (!string.IsNullOrEmpty(InputName.Text))
		{
			InputName.IsEnabled = false;
			InputName.IsEnabled = true;
			LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
			LayoutRoot.Children.Add(value);
			RegistrationService.SaveName(InputName.Text);
			_ssmService.RegisterUserAsync();
		}
	}

	private void ssmService_RegisterUserCompleted(object sender, SSMCompletedEventArgs e)
	{
		LoadingIndicator.StopLoading();
		if (e.StatusCode != HttpStatusCode.OK)
		{
			MessageBox.Show(ResContainer.IDS_CHATON_POP_NETWORK_ERROR);
		}
		else
		{
			PageNavigationService.OpenPivotPage((PhoneApplicationPage)(object)this);
		}
	}

	private void Cancel_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/InputNamePage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (StackPanel)((FrameworkElement)this).FindName("ContentPanel");
			InputName = (TextBox)((FrameworkElement)this).FindName("InputName");
		}
	}
}
