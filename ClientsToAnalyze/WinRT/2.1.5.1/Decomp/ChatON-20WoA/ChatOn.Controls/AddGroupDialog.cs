using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Net;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class AddGroupDialog : UserControl, IComponentConnector
{
	public delegate void AddGroupDialogEventHandler(object sender, object arg);

	public static BuddySummary itemtoBeAdd;

	private BuddyGroup _group;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Border LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock TitleText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputBox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button OKButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button CancelButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public BuddyGroup Group
	{
		get
		{
			return _group;
		}
		set
		{
			_group = value;
			InputBox.put_Text(_group.Name);
			TitleText.put_Text(Utility.GetResourceString("IDS_CHATON_HEADER_RENAME_GROUP"));
		}
	}

	public event AddGroupDialogEventHandler InputNameCompleted;

	public AddGroupDialog()
	{
		InitializeComponent();
	}

	private void InputBox_Loaded(object sender, RoutedEventArgs e)
	{
		((Control)InputBox).Focus((FocusState)1);
	}

	private void OKButton_Click_1(object sender, RoutedEventArgs e)
	{
		string groupName = InputBox.Text.Trim();
		if (groupName.Contains(","))
		{
			groupName = groupName.Replace(",", "");
			InputBox.put_Text(groupName);
			Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_COMMAS_WILL_BE_DELETED_AUTOMATICALLY"));
		}
		if (!(InputBox.Text.Trim() != string.Empty))
		{
			return;
		}
		DataService dataService = new DataService();
		BuddyGroup buddyGroup = dataService.BuddyGroups.FirstOrDefault((BuddyGroup c) => c.Name == groupName);
		if (buddyGroup != null && (_group == null || _group != buddyGroup))
		{
			string resourceString = Utility.GetResourceString("IDS_CHATON_POP_PS_ALREADY_IN_USE_ENTER_ANOTHER_NAME");
			resourceString = resourceString.Replace("%s", "{0:}");
			resourceString = string.Format(resourceString, new object[1] { groupName });
			Utility.ShowSimpleToastNotification(resourceString);
		}
		else if (this.InputNameCompleted != null)
		{
			this.InputNameCompleted(this, groupName);
			Close();
		}
		else if (_group != null)
		{
			SSMService sSMService = new SSMService();
			BuddyService buddyService = new BuddyService(dataService, sSMService);
			sSMService.UpdateBuddyGroupCompleted += delegate(object s2, SSMCompletedEventArgs e2)
			{
				LoadingIndicator.StopLoading();
				if (e2.StatusCode == HttpStatusCode.OK)
				{
					Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_GROUP_NAME_CHANGED"));
					_group.Name = groupName;
					dataService.GroupDBSubmitChanges();
					BuddySummary item = PivotPage.ActiveInstance.ViewModel.BuddyItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Name.Equals(_group.Name));
					BuddySummary item2 = PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Group != null && x.Group.Name.Equals(_group.Name));
					PivotPage.ActiveInstance.ViewModel.BuddyItems.Remove(item);
					PivotPage.ActiveInstance.ViewModel.ShowingItems.Remove(item2);
					PivotPage.ActiveInstance.ViewModel.UpdateList();
					Close();
				}
				else
				{
					SSMService.ShowCommonErrorMessage(e2);
				}
			};
			sSMService.UpdateBuddyGroupAsync(buddyService.MakeGroupMemberListParam(_group, delete: false, groupName));
		}
		else
		{
			if (itemtoBeAdd != null && itemtoBeAdd.Buddy != null)
			{
				List<string> list = new List<string>();
				list.Add(itemtoBeAdd.Buddy.PhoneNumber);
				SelectBuddyPage.PreSelectedNumbers = list;
			}
			SelectBuddyPage.isRemoveMode = false;
			SelectBuddyPage.Mode = SelectBuddyMode.AddMember;
			SelectBuddyPage.SelectionCountLimit = ChatService.MAX_CHAT_MEMBERS - 1;
			SelectBuddyPage.SelectionCompleted += SelectBuddyPage_SelectionCompleted;
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SelectBuddyPage));
		}
	}

	private void SelectBuddyPage_SelectionCompleted(object sender, object arg)
	{
		ObservableCollection<BuddySummary> observableCollection = arg as ObservableCollection<BuddySummary>;
		if (observableCollection.Count() == 0)
		{
			if (sender is SelectBuddyPage)
			{
				((Page)(sender as SelectBuddyPage)).Frame.GoBack();
			}
			return;
		}
		List<string> list = new List<string>();
		foreach (BuddySummary item in observableCollection)
		{
			list.Add(item.Buddy.PhoneNumber);
		}
		string members = string.Join(",", list);
		BuddyGroup group = new BuddyGroup();
		group.Name = InputBox.Text.Trim();
		group.Members = members;
		DataService dataService = new DataService();
		SSMService sSMService = new SSMService();
		BuddyService buddyService = new BuddyService(dataService, sSMService);
		sSMService.UpdateBuddyGroupCompleted += async delegate(object s2, SSMCompletedEventArgs e2)
		{
			LoadingIndicator.StopLoading();
			if (e2.StatusCode == HttpStatusCode.OK)
			{
				dataService.AddBuddyGroup(group);
				Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_NEW_GROUP_CREATED_ABB"));
				BuddySummary groupIndex = PivotPage.ActiveInstance.ViewModel.ShowingItems.FirstOrDefault((BuddySummary x) => x.Type == BuddySummary.ItemType.Index && x.HeaderType == BuddyListHeaderType.Group);
				if (groupIndex != null)
				{
					groupIndex.Count = ((dataService.BuddyGroups == null) ? 1 : dataService.BuddyGroups.Count());
					BuddyListHeader buddyListHeader = PivotPage.ActiveInstance.ViewModel.HeaderItems.FirstOrDefault((BuddyListHeader x) => x.Title == groupIndex.HeaderName && x.HeaderType == BuddyListHeaderType.Group);
					if (buddyListHeader != null)
					{
						buddyListHeader.TotalMember = ((dataService.BuddyGroups == null) ? 1 : dataService.BuddyGroups.Count());
					}
				}
				if (sender is SelectBuddyPage selectBuddyPage)
				{
					((Page)selectBuddyPage).Frame.GoBack();
				}
				if (BuddyListPage.ActiveInstance != null)
				{
					BuddyListPage.ActiveInstance.FocusToGroup(group);
				}
			}
			else
			{
				await SSMService.ShowCommonErrorMessage(e2);
				SelectBuddyPage selectBuddyPage2;
				SelectBuddyPage selectPage = (selectBuddyPage2 = sender as SelectBuddyPage);
				if (selectBuddyPage2 != null)
				{
					((Page)selectPage).Frame.GoBack();
				}
			}
		};
		sSMService.UpdateBuddyGroupAsync(buddyService.MakeGroupMemberListParam(group, delete: false));
	}

	private void CancelButton_Click_1(object sender, RoutedEventArgs e)
	{
		Close();
	}

	private void InputBox_TextChanged_1(object sender, TextChangedEventArgs e)
	{
		if (InputBox.Text.Length == 0)
		{
			((Control)OKButton).put_IsEnabled(false);
		}
		else
		{
			((Control)OKButton).put_IsEnabled(true);
		}
	}

	public void Close()
	{
		if (!(((FrameworkElement)this).Parent is FrameworkElement))
		{
			return;
		}
		CustomPopup customPopup = null;
		DependencyObject parent = ((FrameworkElement)this).Parent;
		if (((FrameworkElement)((parent is FrameworkElement) ? parent : null)).Parent is CustomPopup customPopup2)
		{
			customPopup2.Close();
			if (BuddyListPage.ActiveInstance != null)
			{
				BuddyListPage.ActiveInstance.CloseProfileDialog();
			}
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///AddGroupDialog.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Border)((FrameworkElement)this).FindName("LayoutRoot");
			TitleText = (TextBlock)((FrameworkElement)this).FindName("TitleText");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
			OKButton = (Button)((FrameworkElement)this).FindName("OKButton");
			CancelButton = (Button)((FrameworkElement)this).FindName("CancelButton");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_001c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0022: Expected O, but got Unknown
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Expected O, but got Unknown
		//IL_004c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Expected O, but got Unknown
		//IL_0071: Unknown result type (might be due to invalid IL or missing references)
		//IL_007b: Expected O, but got Unknown
		//IL_007e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0084: Expected O, but got Unknown
		//IL_00a3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ad: Expected O, but got Unknown
		//IL_00b0: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b7: Expected O, but got Unknown
		//IL_00d8: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e2: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val3 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputBox_Loaded));
			TextBox val4 = (TextBox)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TextChangedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(TextBox.add_TextChanged)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(TextBox.remove_TextChanged)), new TextChangedEventHandler(InputBox_TextChanged_1));
			break;
		}
		case 2:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(OKButton_Click_1));
			break;
		}
		case 3:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(CancelButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
