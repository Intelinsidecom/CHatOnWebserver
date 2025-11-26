using System;
using System.Diagnostics;
using System.Globalization;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;

namespace Samsung.NowHub;

public class AllowLocationPage : PhoneApplicationPage
{
	private bool _isNew = true;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal TextBlock txtTitle;

	internal TextBlock txtMsg;

	internal HyperlinkButton linkPrivatePolicy;

	internal Button btOK;

	internal Button btCancel;

	private bool _contentLoaded;

	public AllowLocationPage()
	{
		InitializeComponent();
		string wP7_CHATON_ALLOW_LOCATION_MSG = ResContainer.WP7_CHATON_ALLOW_LOCATION_MSG;
		txtMsg.Text = string.Format(wP7_CHATON_ALLOW_LOCATION_MSG, ResContainer.IDS_CHATON_BODY_CHATON);
		wP7_CHATON_ALLOW_LOCATION_MSG = ResContainer.WP7_CHATON_ALLOW_LOCATION_TITLE;
		txtTitle.Text = string.Format(wP7_CHATON_ALLOW_LOCATION_MSG, ResContainer.IDS_CHATON_BODY_CHATON);
		string uriString = $"http://static.bada.com/contents/legal/{Utility.GetLanguageCode(CultureInfo.CurrentUICulture.EnglishName)}/pp.txt";
		linkPrivatePolicy.NavigateUri = new Uri(uriString);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		if (_isNew)
		{
			_isNew = false;
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void btOK_Click(object sender, RoutedEventArgs e)
	{
		SettingService.SetAllowLocation(allow: true);
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void btCancel_Click(object sender, RoutedEventArgs e)
	{
		SettingService.SetAllowLocation(allow: false);
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AllowLocationPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			txtTitle = (TextBlock)((FrameworkElement)this).FindName("txtTitle");
			txtMsg = (TextBlock)((FrameworkElement)this).FindName("txtMsg");
			linkPrivatePolicy = (HyperlinkButton)((FrameworkElement)this).FindName("linkPrivatePolicy");
			btOK = (Button)((FrameworkElement)this).FindName("btOK");
			btCancel = (Button)((FrameworkElement)this).FindName("btCancel");
		}
	}
}
