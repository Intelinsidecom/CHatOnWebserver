using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Res;
using ChatOn.Services;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class AttachCalendarDetailPage : PhoneApplicationPage
{
	private AttachCalendarDetailPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal TextBlock PageTitle;

	internal TextBlock textBlockSubject;

	internal ScrollViewer ContentPanel;

	internal TextBlock textBlockStartTime;

	internal TextBlock textBlockEndTime;

	internal TextBlock textBlockLocation;

	internal TextBlock textBlockDetail;

	internal ApplicationBarIconButton SendBtn;

	private bool _contentLoaded;

	public AttachCalendarDetailPage()
	{
		InitializeComponent();
		_viewModel = new AttachCalendarDetailPageViewModel((PhoneApplicationPage)(object)this);
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).Text = ResContainer.IDS_CHATON_BUTTON_SEND;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		((ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null)).Text = ResContainer.IDS_CHATON_SK_CANCEL;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
		if (queryString.ContainsKey("filePath") && !string.IsNullOrEmpty(queryString["filePath"]))
		{
			_viewModel.DecodeVcalData(queryString["filePath"]);
		}
		else
		{
			((Page)this).NavigationService.RemoveBackEntry();
			((FrameworkElement)this).DataContext = ChatOnService.Instance.Appointment;
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void SendBarIcon_Click(object sender, EventArgs e)
	{
		AttachmentService.Instance.CalendarChooser_Completed(this, ChatOnService.Instance.Appointment);
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void CancelBarIcon_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AttachCalendarDetailPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			PageTitle = (TextBlock)((FrameworkElement)this).FindName("PageTitle");
			textBlockSubject = (TextBlock)((FrameworkElement)this).FindName("textBlockSubject");
			ContentPanel = (ScrollViewer)((FrameworkElement)this).FindName("ContentPanel");
			textBlockStartTime = (TextBlock)((FrameworkElement)this).FindName("textBlockStartTime");
			textBlockEndTime = (TextBlock)((FrameworkElement)this).FindName("textBlockEndTime");
			textBlockLocation = (TextBlock)((FrameworkElement)this).FindName("textBlockLocation");
			textBlockDetail = (TextBlock)((FrameworkElement)this).FindName("textBlockDetail");
			SendBtn = (ApplicationBarIconButton)((FrameworkElement)this).FindName("SendBtn");
		}
	}
}
