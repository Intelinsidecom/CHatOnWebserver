using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Res;
using ChatOn.ViewModels;
using com.sec.ssm.common;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class GroupProfilePage : PhoneApplicationPage
{
	private bool _isNew = true;

	private GroupProfilePageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal Button ChatButton;

	internal Button BroadcastButton;

	private bool _contentLoaded;

	public GroupProfilePage()
	{
		InitializeComponent();
		_viewModel = new GroupProfilePageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_EDIT;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_SK_DELETE;
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
			_viewModel.OpenGroupInfo(id);
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void Chat_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.StartChat(ChatType.GROUP);
	}

	private void Broadcast_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.StartChat(ChatType.BROADCAST);
	}

	private void Edit_Click(object sender, EventArgs e)
	{
		_viewModel.EditMembers();
	}

	private void Delete_Click(object sender, EventArgs e)
	{
		_viewModel.DeleteGroup();
	}

	private void Rename_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		_viewModel.Rename();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/GroupProfilePage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			ChatButton = (Button)((FrameworkElement)this).FindName("ChatButton");
			BroadcastButton = (Button)((FrameworkElement)this).FindName("BroadcastButton");
		}
	}
}
