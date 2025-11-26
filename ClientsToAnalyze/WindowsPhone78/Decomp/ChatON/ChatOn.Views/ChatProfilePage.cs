using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class ChatProfilePage : PhoneApplicationPage
{
	private bool _isNew = true;

	private ChatProfilePageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal ListBox BuddyList;

	private bool _contentLoaded;

	public ChatProfilePage()
	{
		InitializeComponent();
		_viewModel = new ChatProfilePageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (queryString.ContainsKey("ID"))
			{
				Guid id = Guid.Parse(queryString["ID"]);
				_viewModel.UpdateChatBuddies(id);
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void Item_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		ChatBuddy member = (sender as FrameworkElement).DataContext as ChatBuddy;
		_viewModel.OpenBuddyProfile(member);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/ChatProfilePage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			BuddyList = (ListBox)((FrameworkElement)this).FindName("BuddyList");
		}
	}
}
