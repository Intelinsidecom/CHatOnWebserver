using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class AttachCalendarPage : PhoneApplicationPage
{
	private AttachCalendarPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal ListBox AppointmentResultsData;

	private bool _contentLoaded;

	public AttachCalendarPage()
	{
		InitializeComponent();
		_viewModel = new AttachCalendarPageViewModel((PhoneApplicationPage)(object)this);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		_viewModel.SearchCalendar();
		((Page)this).NavigationService.RemoveBackEntry();
		((Page)this).OnNavigatedTo(e);
	}

	private void AppointmentResultsData_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_viewModel.ViewCalendarDetail(sender);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AttachCalendarPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			AppointmentResultsData = (ListBox)((FrameworkElement)this).FindName("AppointmentResultsData");
		}
	}
}
