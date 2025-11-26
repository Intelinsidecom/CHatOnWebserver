using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Services;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class ProfileEditPage : PhoneApplicationPage
{
	private ProfileEditPageViewModel _viewModel;

	private bool _isNew = true;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	private bool _contentLoaded;

	public ProfileEditPage()
	{
		InitializeComponent();
		_viewModel = new ProfileEditPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
	}

	private void BirthdayGrid_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenAddBirthdayPage((PhoneApplicationPage)(object)this);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
		}
		_viewModel.LoadData();
		((Page)this).OnNavigatedTo(e);
	}

	private void StaticHeightBubble_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenAddTextProfileInfoPage((PhoneApplicationPage)(object)this, "status");
	}

	private void NameBlock_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenAddTextProfileInfoPage((PhoneApplicationPage)(object)this, "name");
	}

	private void Image_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_viewModel.OpenPhotoChooser();
	}

	private void SettingPrivacy_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		PageNavigationService.OpenShowPhoneNumberSettingPage((PhoneApplicationPage)(object)this);
	}

	private void FacebookGrid_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_viewModel.OnClickFacebookAccount();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/ProfileEditPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
		}
	}
}
