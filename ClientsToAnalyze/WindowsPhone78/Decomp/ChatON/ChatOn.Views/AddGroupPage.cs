using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class AddGroupPage : PhoneApplicationPage
{
	private bool _isNew = true;

	private BuddyGroup _group;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal TextBox InputBox;

	internal Button SaveButton;

	private bool _contentLoaded;

	public AddGroupPage()
	{
		InitializeComponent();
		InputBox.Loaded += InputBox_Loaded;
	}

	private void InputBox_Loaded(object sender, RoutedEventArgs e)
	{
		InputBox.Focus();
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
				DataService dataService = new DataService();
				_group = dataService.BuddyGroups.FirstOrDefault((BuddyGroup g) => g.GroupID == id);
				InputBox.Text = _group.Name;
				ApplicationTitle.Text = ResContainer.IDS_CHATON_HEADER_RENAME_GROUP.ToUpper();
			}
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void SaveButton_Click(object sender, RoutedEventArgs e)
	{
		if (_group != null)
		{
			_group.Name = InputBox.Text;
			Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
		}
		else
		{
			SelectBuddyPage.SelectionCountLimit = ChatService.MAX_CHAT_MEMBERS - 1;
			SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
			PageNavigationService.OpenSelectBuddyPage((PhoneApplicationPage)(object)this);
		}
	}

	private void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		SelectBuddyPage.SelectionCompleted -= SelectBuddyPage_SelectionCompleted;
		ObservableCollection<BuddySummary> observableCollection = arg as ObservableCollection<BuddySummary>;
		List<string> list = new List<string>();
		foreach (BuddySummary item in observableCollection)
		{
			list.Add(item.Buddy.PhoneNumber);
		}
		string members = string.Join(",", list);
		BuddyGroup buddyGroup = new BuddyGroup();
		buddyGroup.Name = InputBox.Text;
		buddyGroup.Members = members;
		DataService dataService = new DataService();
		dataService.AddBuddyGroup(buddyGroup);
		ChatOnService.Instance.IsBuddiesUpdated = true;
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void CancelButton_Click(object sender, RoutedEventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	private void InputBox_TextChanged(object sender, TextChangedEventArgs e)
	{
		if (InputBox.Text.Length == 0)
		{
			SaveButton.IsEnabled = false;
		}
		else
		{
			SaveButton.IsEnabled = true;
		}
		if (InputBox.Text.Length > InputBox.MaxLength)
		{
			((Control)this).Focus();
			InputBox.Text = InputBox.Text.Remove(InputBox.MaxLength);
			InputBox.SelectionStart = InputBox.MaxLength;
			InputBox.Focus();
		}
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/AddGroupPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
			SaveButton = (Button)((FrameworkElement)this).FindName("SaveButton");
		}
	}
}
