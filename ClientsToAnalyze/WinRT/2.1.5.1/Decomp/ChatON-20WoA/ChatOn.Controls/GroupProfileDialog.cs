using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.ViewModels;
using com.sec.ssm.common;
using Windows.Foundation;
using Windows.UI.Core;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class GroupProfileDialog : UserControl, IComponentConnector
{
	public Page parentPage;

	public static readonly DependencyProperty PhotoProperty = DependencyProperty.RegisterAttached("GroupInfo", typeof(BuddyGroup), typeof(GroupProfileDialog), (PropertyMetadata)null);

	private GroupProfilePageViewModel _viewModel;

	private Point Position;

	private static GroupProfileDialog _activeInstance;

	private string previousName;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid DetailGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock BuddiesCount;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button AddButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button RemoveButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock tbEditName;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox txtEditName;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton EditName_Button;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CloseButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid GroupChatGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid BroadcastGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid DeleteGroupGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid PinToStartGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public BuddyGroup GroupInfo
	{
		get
		{
			return (BuddyGroup)((DependencyObject)this).GetValue(PhotoProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(PhotoProperty, (object)value);
		}
	}

	public Grid DisplayContainer { get; set; }

	public GroupProfilePageViewModel ViewModel => _viewModel;

	public static GroupProfileDialog ActiveInstance => _activeInstance;

	public bool IsRenameMode { get; set; }

	public event ProfileDialogBuddyProfileEventHandler BuddyProfileTapped;

	public event ProfileDialogClosedEventHandler DialogClosedTapped;

	protected virtual void OnBuddyProfileTapped(ProfileDialogEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			this.BuddyProfileTapped?.Invoke(this, e);
		}
	}

	public GroupProfileDialog()
	{
		InitializeComponent();
		_activeInstance = this;
		_viewModel = new GroupProfilePageViewModel(this);
	}

	private void GroupProfileDialog_ManipulationCompleted(object sender, ManipulationCompletedRoutedEventArgs e)
	{
		double num = Position.X - e.Position.X;
		if (num > 0.0)
		{
			((UIElement)this).put_Visibility((Visibility)1);
			Close();
		}
	}

	public void Close()
	{
		try
		{
			PivotPage.ActiveInstance.ViewModel.IsRenameMode = false;
			if (this.DialogClosedTapped != null)
			{
				this.DialogClosedTapped(this, new ProfileDialogEventArgs());
			}
			if (((FrameworkElement)this).Parent != null && ((FrameworkElement)/*isinst with value type is only supported in some contexts*/).Parent is CustomPopup customPopup)
			{
				customPopup.Close();
			}
		}
		catch (Exception ex)
		{
			Logger.Log("Error When Closing Buddy Profile => " + ex.Message, LogType.Error);
		}
	}

	private void GroupProfileDialog_ManipulationStarted(object sender, ManipulationStartedRoutedEventArgs e)
	{
		Position = e.Position;
	}

	private void GroupProfileDialog_Loaded(object sender, RoutedEventArgs e)
	{
		_viewModel.OnNavigatedTo(GroupInfo);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		if (IsRenameMode)
		{
			PivotPage.ActiveInstance.ViewModel.IsRenameMode = true;
			tbEditName.Focus((FocusState)3);
			_viewModel.EditName();
		}
		if (BuddyListPage.ActiveInstance != null && ((FrameworkElement)BuddyListPage.ActiveInstance).ActualHeight > 0.0)
		{
			((FrameworkElement)LayoutRoot).put_Height(((FrameworkElement)BuddyListPage.ActiveInstance).ActualHeight - 30.0);
		}
	}

	public void UpdateBuddiesCount(int count)
	{
		string resourceString = Utility.GetResourceString("IDS_CHATON_HEADER_BUDDIES_HPD");
		resourceString = resourceString.Replace("%d", "{0:d}");
		resourceString = string.Format(resourceString, new object[1] { count });
		BuddiesCount.put_Text(resourceString);
	}

	private void BroadcastGrid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			_viewModel.StartChat(ChatType.BROADCAST);
		}
	}

	private void GroupChatGrid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			_viewModel.StartChat(ChatType.GROUP);
		}
	}

	private void Image_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			_viewModel.SelectProfileImage(sender);
		}
	}

	private async void DeleteGroupGrid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			await _viewModel.DeleteGroup();
		}
	}

	public void UpdateBuddyList()
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			PivotPage.ActiveInstance.ViewModel.UpdateList();
		});
	}

	private void AddButton_Click_1(object sender, RoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			_viewModel.AddMembers();
		}
	}

	private void RemoveButton_Click_1(object sender, RoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			_viewModel.RemoveMembers();
		}
	}

	private void EditName_Click(object sender, RoutedEventArgs e)
	{
		if (PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			PivotPage.ActiveInstance.ViewModel.IsRenameMode = false;
			return;
		}
		previousName = txtEditName.Text;
		PivotPage.ActiveInstance.ViewModel.IsRenameMode = true;
		_viewModel.EditName();
		((Control)txtEditName).Focus((FocusState)3);
		txtEditName.Select(tbEditName.Text.Length, 0);
	}

	internal void SwitchEditName()
	{
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		if ((int)ViewModel.EditNameVisibility == 0)
		{
			((UIElement)tbEditName).put_Visibility((Visibility)1);
		}
		else
		{
			((UIElement)tbEditName).put_Visibility((Visibility)0);
		}
	}

	private void PinToStartGrid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			_viewModel.PinToStart((FrameworkElement)((sender is FrameworkElement) ? sender : null));
		}
	}

	private void GroupMember_tapped(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			PivotPage.ActiveInstance.OpenChat(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Buddy);
		}
	}

	private void BuddyImage_tapped(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			Buddy buddy = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as Buddy;
			OnBuddyProfileTapped(new ProfileDialogEventArgs
			{
				Buddy = buddy
			});
		}
	}

	private void Close_Click(object sender, RoutedEventArgs e)
	{
		Close();
	}

	public void OpenDialog(UserControl dialog, EventHandler closedEventHandler = null)
	{
		CustomPopup customPopup = new CustomPopup(parentPage, (Panel)(object)LayoutRoot, (FrameworkElement)(object)dialog);
		if (closedEventHandler != null)
		{
			customPopup.Closed += closedEventHandler;
		}
	}

	public void OnDialogClosed(object sender, ProfileDialogEventArgs e)
	{
		this.DialogClosedTapped?.Invoke(this, e);
	}

	private void TxtEditName_OnLostFocus(object sender, RoutedEventArgs e)
	{
		_viewModel.EditName(txtEditName.Text.Trim(), isMode: true, previousName);
	}

	public async void RenameFinished(string finalname)
	{
		if (finalname.Contains(","))
		{
			finalname = finalname.Replace(",", "");
			Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_COMMAS_WILL_BE_DELETED_AUTOMATICALLY"));
		}
		txtEditName.put_Text(finalname.Trim());
		tbEditName.put_Text(finalname.Trim());
		await Task.Delay(500);
		((UIElement)tbEditName).put_Visibility((Visibility)0);
		PivotPage.ActiveInstance.ViewModel.IsRenameMode = false;
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
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		//IL_011f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0129: Expected O, but got Unknown
		//IL_0135: Unknown result type (might be due to invalid IL or missing references)
		//IL_013f: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///GroupProfileDialog.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			DetailGrid = (Grid)((FrameworkElement)this).FindName("DetailGrid");
			BuddiesCount = (TextBlock)((FrameworkElement)this).FindName("BuddiesCount");
			AddButton = (Button)((FrameworkElement)this).FindName("AddButton");
			RemoveButton = (Button)((FrameworkElement)this).FindName("RemoveButton");
			tbEditName = (TextBlock)((FrameworkElement)this).FindName("tbEditName");
			txtEditName = (TextBox)((FrameworkElement)this).FindName("txtEditName");
			EditName_Button = (ImageButton)((FrameworkElement)this).FindName("EditName_Button");
			CloseButton = (ImageButton)((FrameworkElement)this).FindName("CloseButton");
			GroupChatGrid = (Grid)((FrameworkElement)this).FindName("GroupChatGrid");
			BroadcastGrid = (Grid)((FrameworkElement)this).FindName("BroadcastGrid");
			DeleteGroupGrid = (Grid)((FrameworkElement)this).FindName("DeleteGroupGrid");
			PinToStartGrid = (Grid)((FrameworkElement)this).FindName("PinToStartGrid");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0044: Unknown result type (might be due to invalid IL or missing references)
		//IL_004a: Expected O, but got Unknown
		//IL_0069: Unknown result type (might be due to invalid IL or missing references)
		//IL_0073: Expected O, but got Unknown
		//IL_0074: Unknown result type (might be due to invalid IL or missing references)
		//IL_007a: Expected O, but got Unknown
		//IL_0099: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a3: Expected O, but got Unknown
		//IL_00a4: Unknown result type (might be due to invalid IL or missing references)
		//IL_00aa: Expected O, but got Unknown
		//IL_00c9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d3: Expected O, but got Unknown
		//IL_00d9: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e0: Expected O, but got Unknown
		//IL_0101: Unknown result type (might be due to invalid IL or missing references)
		//IL_010b: Expected O, but got Unknown
		//IL_0111: Unknown result type (might be due to invalid IL or missing references)
		//IL_0118: Expected O, but got Unknown
		//IL_0139: Unknown result type (might be due to invalid IL or missing references)
		//IL_0143: Expected O, but got Unknown
		//IL_0149: Unknown result type (might be due to invalid IL or missing references)
		//IL_0150: Expected O, but got Unknown
		//IL_0171: Unknown result type (might be due to invalid IL or missing references)
		//IL_017b: Expected O, but got Unknown
		//IL_0181: Unknown result type (might be due to invalid IL or missing references)
		//IL_0188: Expected O, but got Unknown
		//IL_01a9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b3: Expected O, but got Unknown
		//IL_01b9: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c0: Expected O, but got Unknown
		//IL_01e1: Unknown result type (might be due to invalid IL or missing references)
		//IL_01eb: Expected O, but got Unknown
		//IL_01fd: Unknown result type (might be due to invalid IL or missing references)
		//IL_0207: Expected O, but got Unknown
		//IL_0219: Unknown result type (might be due to invalid IL or missing references)
		//IL_0223: Expected O, but got Unknown
		//IL_0229: Unknown result type (might be due to invalid IL or missing references)
		//IL_0230: Expected O, but got Unknown
		//IL_0251: Unknown result type (might be due to invalid IL or missing references)
		//IL_025b: Expected O, but got Unknown
		//IL_0261: Unknown result type (might be due to invalid IL or missing references)
		//IL_0268: Expected O, but got Unknown
		//IL_0289: Unknown result type (might be due to invalid IL or missing references)
		//IL_0293: Expected O, but got Unknown
		//IL_0299: Unknown result type (might be due to invalid IL or missing references)
		//IL_02a0: Expected O, but got Unknown
		//IL_02c1: Unknown result type (might be due to invalid IL or missing references)
		//IL_02cb: Expected O, but got Unknown
		//IL_02ce: Unknown result type (might be due to invalid IL or missing references)
		//IL_02d5: Expected O, but got Unknown
		//IL_02f6: Unknown result type (might be due to invalid IL or missing references)
		//IL_0300: Expected O, but got Unknown
		//IL_0303: Unknown result type (might be due to invalid IL or missing references)
		//IL_030a: Expected O, but got Unknown
		//IL_032b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0335: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val11 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val11, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val11, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(GroupProfileDialog_Loaded));
			UIElement val12 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationStartedEventHandler, EventRegistrationToken>(val12, (nint)__ldftn(UIElement.add_ManipulationStarted)), new Action<EventRegistrationToken>(val12, (nint)__ldftn(UIElement.remove_ManipulationStarted)), new ManipulationStartedEventHandler(GroupProfileDialog_ManipulationStarted));
			UIElement val13 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationCompletedEventHandler, EventRegistrationToken>(val13, (nint)__ldftn(UIElement.add_ManipulationCompleted)), new Action<EventRegistrationToken>(val13, (nint)__ldftn(UIElement.remove_ManipulationCompleted)), new ManipulationCompletedEventHandler(GroupProfileDialog_ManipulationCompleted));
			break;
		}
		case 2:
		{
			UIElement val10 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BuddyImage_tapped));
			break;
		}
		case 3:
		{
			UIElement val9 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(GroupMember_tapped));
			break;
		}
		case 4:
		{
			ButtonBase val8 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(AddButton_Click_1));
			break;
		}
		case 5:
		{
			ButtonBase val7 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(RemoveButton_Click_1));
			break;
		}
		case 6:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_LostFocus)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_LostFocus)), new RoutedEventHandler(TxtEditName_OnLostFocus));
			break;
		}
		case 7:
			((ImageButton)target).Click += new RoutedEventHandler(EditName_Click);
			break;
		case 8:
			((ImageButton)target).Click += new RoutedEventHandler(Close_Click);
			break;
		case 9:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_1));
			break;
		}
		case 10:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(GroupChatGrid_Tapped_1));
			break;
		}
		case 11:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BroadcastGrid_Tapped_1));
			break;
		}
		case 12:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(DeleteGroupGrid_Tapped_1));
			break;
		}
		case 13:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(PinToStartGrid_Tapped_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
