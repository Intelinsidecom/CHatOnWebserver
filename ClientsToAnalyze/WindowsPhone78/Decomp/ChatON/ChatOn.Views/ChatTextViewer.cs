using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Navigation;
using System.Windows.Threading;
using ChatOn.Controls;
using ChatOn.Models;
using ChatOn.Services;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class ChatTextViewer : PhoneApplicationPage
{
	private string _text;

	private bool _isNew = true;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal StackPanel ContentPanel;

	private bool _contentLoaded;

	public ChatTextViewer()
	{
		InitializeComponent();
	}

	private void UpdateContent()
	{
		int num = 0;
		int num2 = 0;
		int num3 = 0;
		string text = _text;
		foreach (char c in text)
		{
			if (c == '\n' || c == '\r')
			{
				num++;
				if (num2 > 500 || num > 10)
				{
					string currentText = _text.Substring(num3, num2);
					num3 += num2;
					AddChatTextBlock(currentText);
					num2 = 0;
					num = 0;
					continue;
				}
			}
			else
			{
				if (num2 > 700 && c == ' ')
				{
					string currentText = _text.Substring(num3, num2);
					num3 += num2;
					AddChatTextBlock(currentText);
					num2 = 0;
					num = 0;
					continue;
				}
				if (num2 > 900)
				{
					string currentText = _text.Substring(num3, num2);
					num3 += num2;
					AddChatTextBlock(currentText);
					num2 = 0;
					num = 0;
					continue;
				}
			}
			num2++;
		}
		if (num3 < _text.Length)
		{
			string currentText = _text.Substring(num3);
			AddChatTextBlock(currentText);
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (!queryString.ContainsKey("ID"))
			{
				throw new NotImplementedException();
			}
			Guid id = Guid.Parse(queryString["ID"]);
			DataService dataService = new DataService();
			Message message = dataService.GetMessage(id);
			_text = message.Text;
			DispatcherTimer dispatcherTimer = new DispatcherTimer();
			dispatcherTimer.Interval = TimeSpan.FromTicks(1000L);
			dispatcherTimer.Tick += timer_Tick;
			dispatcherTimer.Start();
			LoadingIndicator value = new LoadingIndicator((PhoneApplicationPage)(object)this);
			LayoutRoot.Children.Add(value);
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void timer_Tick(object sender, EventArgs e)
	{
		(sender as DispatcherTimer).Stop();
		UpdateContent();
		LoadingIndicator.StopLoading();
	}

	private void AddChatTextBlock(string currentText)
	{
		ChatTextBlock chatTextBlock = new ChatTextBlock();
		chatTextBlock.Foreground = new SolidColorBrush((Color)Application.Current.Resources["PhoneForegroundColor"]);
		chatTextBlock.FontSize = 24.0;
		chatTextBlock.MaxLength = 4000;
		chatTextBlock.IsParsingLinkEnabled = false;
		chatTextBlock.EmoticonSize = 54.0;
		chatTextBlock.EmoticonMargin = new Thickness(0.0, 8.0, 0.0, -8.0);
		chatTextBlock.Text = currentText;
		ContentPanel.Children.Add(chatTextBlock);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/ChatTextViewer.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (StackPanel)((FrameworkElement)this).FindName("ContentPanel");
		}
	}
}
