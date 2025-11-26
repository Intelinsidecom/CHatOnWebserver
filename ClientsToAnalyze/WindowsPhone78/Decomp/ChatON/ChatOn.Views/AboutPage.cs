using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Tasks;

namespace ChatOn.Views;

public class AboutPage : PhoneApplicationPage
{
	private MarketplaceDetailTask _marketplaceDetailTask;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal TextBlock CurrentVersion;

	internal TextBlock LatestVersion;

	internal Button UpgradeButton;

	private bool _contentLoaded;

	public AboutPage()
	{
		InitializeComponent();
		((FrameworkElement)this).Loaded += AboutPage_Loaded;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void AboutPage_Loaded(object sender, RoutedEventArgs e)
	{
		UpdatePage();
	}

	private void UpdatePage()
	{
		SSMServer serverInfo = SSMService.GetServerInfo();
		UpgradeButton.IsEnabled = false;
		CurrentVersion.Text = ResContainer.IDS_CHATON_BODY_CURRENT_VERSION + " " + Utility.GetAssemblyVersion();
		if (!string.IsNullOrEmpty(serverInfo.NewVersion))
		{
			UpgradeButton.IsEnabled = serverInfo.NewVersion != Utility.GetAssemblyVersion();
			LatestVersion.Text = ResContainer.IDS_CHATON_BODY_LATEST_VERSION + " " + serverInfo.NewVersion;
		}
		else
		{
			LatestVersion.Text = ResContainer.IDS_CHATON_BODY_LATEST_VERSION + " " + Utility.GetAssemblyVersion();
		}
	}

	private void UpgradeButton_Click(object sender, RoutedEventArgs e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected O, but got Unknown
		_marketplaceDetailTask = new MarketplaceDetailTask();
		_marketplaceDetailTask.ContentIdentifier = Utility.GetProductID();
		_marketplaceDetailTask.ContentType = (MarketplaceContentType)1;
		_marketplaceDetailTask.Show();
	}

	private void OpenSource_Click(object sender, RoutedEventArgs e)
	{
		PageNavigationService.OpenWebBrowsingPage((PhoneApplicationPage)(object)this, null, "ChatOn_OpenSourceAnnouncement.html");
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AboutPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			CurrentVersion = (TextBlock)((FrameworkElement)this).FindName("CurrentVersion");
			LatestVersion = (TextBlock)((FrameworkElement)this).FindName("LatestVersion");
			UpgradeButton = (Button)((FrameworkElement)this).FindName("UpgradeButton");
		}
	}
}
