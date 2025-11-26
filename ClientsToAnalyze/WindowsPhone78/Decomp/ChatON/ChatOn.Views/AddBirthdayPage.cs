using System;
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

public class AddBirthdayPage : PhoneApplicationPage
{
	private AddBirthdayPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal ListPicker TypePicker;

	internal TextBlock DateBlock;

	internal DatePicker DatePickerControl;

	private bool _contentLoaded;

	public AddBirthdayPage()
	{
		InitializeComponent();
		_viewModel = new AddBirthdayPageViewModel(this);
		string[] itemsSource = new string[3]
		{
			ResContainer.IDS_CHATON_BODY_FULL_BIRTHDAY,
			ResContainer.IDS_CHATON_BODY_MONTH_AND_DAY,
			ResContainer.IDS_CHATON_BODY_DONT_SHOW_BIRTHDAY
		};
		TypePicker.ItemsSource = itemsSource;
		((FrameworkElement)this).DataContext = _viewModel;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_SAVE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void DatePicker_ValueChanged(object sender, DateTimeValueChangedEventArgs e)
	{
		if (_viewModel != null)
		{
			_viewModel.Birthday = e.NewDateTime.Value;
		}
	}

	private void SaveButton_Click(object sender, EventArgs e)
	{
		_viewModel.Save();
	}

	private void CancelButton_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
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

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AddBirthdayPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			TypePicker = (ListPicker)((FrameworkElement)this).FindName("TypePicker");
			DateBlock = (TextBlock)((FrameworkElement)this).FindName("DateBlock");
			DatePickerControl = (DatePicker)((FrameworkElement)this).FindName("DatePickerControl");
		}
	}
}
