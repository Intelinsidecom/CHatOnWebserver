using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using System.Windows.Threading;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class MediaPlayerPage : PhoneApplicationPage
{
	private bool _isNew = true;

	private double _defaultVol;

	internal Grid LayoutRoot;

	internal MediaElement MediaControl;

	internal Image MediaControlButton;

	private bool _contentLoaded;

	public MediaPlayerPage()
	{
		InitializeComponent();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (queryString.ContainsKey("source"))
			{
				Stream source = Utility.OpenFileAsStream(queryString["source"]);
				MediaControl.SetSource(source);
				_defaultVol = MediaControl.Volume;
				MediaControl.Volume = 0.0;
				MediaControl.MediaEnded += MediaControl_MediaEnded;
				MediaControl.MediaOpened += MediaControl_MediaOpened;
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void MediaControl_MediaOpened(object sender, RoutedEventArgs e)
	{
		DispatcherTimer dispatcherTimer = new DispatcherTimer();
		dispatcherTimer.Interval = TimeSpan.FromMilliseconds(10.0);
		dispatcherTimer.Tick += timer_Tick;
		dispatcherTimer.Start();
	}

	private void MediaControl_MediaEnded(object sender, RoutedEventArgs e)
	{
		MediaControlButton.Visibility = Visibility.Visible;
	}

	private void timer_Tick(object sender, EventArgs e)
	{
		MediaControl.Pause();
		(sender as DispatcherTimer).Stop();
	}

	private void Image_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		MediaControlButton.Visibility = Visibility.Collapsed;
		MediaControl.Volume = _defaultVol;
		MediaControl.Play();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/MediaPlayerPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			MediaControl = (MediaElement)((FrameworkElement)this).FindName("MediaControl");
			MediaControlButton = (Image)((FrameworkElement)this).FindName("MediaControlButton");
		}
	}
}
