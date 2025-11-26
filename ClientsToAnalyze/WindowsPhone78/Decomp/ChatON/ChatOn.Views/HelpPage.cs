using System;
using System.Diagnostics;
using System.Globalization;
using System.Windows;
using System.Windows.Controls;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class HelpPage : PhoneApplicationPage
{
	internal Grid LayoutRoot;

	internal StackPanel ContentPanel;

	internal WebBrowser WebControl;

	private bool _contentLoaded;

	public HelpPage()
	{
		InitializeComponent();
		((FrameworkElement)this).Loaded += HelpPage_Loaded;
	}

	private void HelpPage_Loaded(object sender, RoutedEventArgs e)
	{
		_ = CultureInfo.CurrentCulture.Name;
		WebControl.Navigate(new Uri("http://www.chaton.com/mwv/faq.html?l=ko_KR"));
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/HelpPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			ContentPanel = (StackPanel)((FrameworkElement)this).FindName("ContentPanel");
			WebControl = (WebBrowser)((FrameworkElement)this).FindName("WebControl");
		}
	}
}
