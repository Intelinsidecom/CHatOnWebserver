using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using Microsoft.Phone.Controls;

namespace MiniDiary.Views;

public class WebBrowsingPage : PhoneApplicationPage
{
	private Uri _targetUri;

	private string _targetString;

	internal Grid LayoutRoot;

	internal WebBrowser myWebBrowser;

	private bool _contentLoaded;

	public WebBrowsingPage()
	{
		((FrameworkElement)this).Loaded += WebBrowsingPage_Loaded;
		InitializeComponent();
		_targetUri = null;
		_targetString = null;
	}

	public void WebBrowsingPage_Loaded(object sender, RoutedEventArgs e)
	{
		if (_targetUri != null)
		{
			myWebBrowser.Navigate(_targetUri);
		}
		else if (!string.IsNullOrEmpty(_targetString))
		{
			myWebBrowser.NavigateToString(_targetString);
		}
		else
		{
			myWebBrowser.Navigate(new Uri("", UriKind.Relative));
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
		if (queryString.ContainsKey("httpAddress"))
		{
			string text = queryString["httpAddress"];
			if (!string.IsNullOrEmpty(text))
			{
				_targetUri = new Uri(text);
			}
		}
		if (queryString.ContainsKey("filePath"))
		{
			string text2 = queryString["filePath"];
			if (!string.IsNullOrEmpty(text2))
			{
				Uri uriResource = new Uri(text2, UriKind.Relative);
				Stream stream = Application.GetResourceStream(uriResource).Stream;
				StreamReader streamReader = new StreamReader(stream);
				_targetString = streamReader.ReadToEnd();
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/WebBrowsingPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			myWebBrowser = (WebBrowser)((FrameworkElement)this).FindName("myWebBrowser");
		}
	}
}
