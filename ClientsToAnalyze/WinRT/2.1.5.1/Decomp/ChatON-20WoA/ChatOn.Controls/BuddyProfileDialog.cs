using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.Foundation;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Shapes;

namespace ChatOn.Controls;

public class BuddyProfileDialog : UserControl, IComponentConnector
{
	public static readonly DependencyProperty PhotoProperty = DependencyProperty.RegisterAttached("BuddyInfo", typeof(Buddy), typeof(BuddyProfileDialog), (PropertyMetadata)null);

	public static readonly DependencyProperty ListVerticalOffsetProperty = DependencyProperty.Register("ListVerticalOffset", typeof(double), typeof(BuddyProfileDialog), new PropertyMetadata((object)null, new PropertyChangedCallback(OnListVerticalOffsetChanged)));

	private BuddyProfilePageViewModel _viewModel;

	private Page _parentPage;

	private Point Position;

	private bool _isRenameMode;

	private string tempName;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid GridProfile;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private StackPanel DetailGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock tbLeaveYourMessage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock tbUseBuddySay;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView lvAdd;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ItemsControl PhoneNumberListControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Rectangle RectInteractionLine;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid gridAdd;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock tbEditName;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox txtEditName;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton EditName_Button;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CloseButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid PinToStartGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid BlockGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public Buddy BuddyInfo
	{
		get
		{
			return (Buddy)((DependencyObject)this).GetValue(PhotoProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(PhotoProperty, (object)value);
		}
	}

	public Page ParentPage
	{
		get
		{
			return _parentPage;
		}
		set
		{
			_parentPage = value;
		}
	}

	public bool IsRenameMode { get; set; }

	public event ProfileDialogClosedEventHandler DialogClosedTapped;

	public event StartChatEventHandler StartChatTapped;

	public event ProfileDialogClosedEventHandler RenameProfileNameTapped;

	public event ProfileDialogClosedEventHandler BlockBuddyTapped;

	public void OnDialogClosed(object sender, ProfileDialogEventArgs e)
	{
		this.DialogClosedTapped?.Invoke(this, e);
	}

	public void OnStartChatTapped(object sender, ProfileDialogEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			this.StartChatTapped?.Invoke(this, e);
		}
	}

	public void OnRenameProfileNameTapped(object sender, ProfileDialogEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			this.RenameProfileNameTapped?.Invoke(this, e);
		}
	}

	public void OnBlockBuddyTapped(object sender, ProfileDialogEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			this.BlockBuddyTapped?.Invoke(this, e);
		}
	}

	private static void OnListVerticalOffsetChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		//IL_0040: Unknown result type (might be due to invalid IL or missing references)
		//IL_0046: Expected O, but got Unknown
		//IL_0074: Unknown result type (might be due to invalid IL or missing references)
		//IL_007a: Expected O, but got Unknown
		DispatchedHandler val = null;
		BuddyProfileDialog page = null;
		if ((page = obj as BuddyProfileDialog) == null)
		{
			return;
		}
		DependencyObject child = VisualTreeHelper.GetChild((DependencyObject)(object)page.lvAdd, 0);
		ScrollViewer val2 = (ScrollViewer)((FrameworkElement)((child is FrameworkElement) ? child : null)).FindName("ScrollViewer");
		if (!(val2.VerticalOffset >= val2.ScrollableHeight - 2.0))
		{
			return;
		}
		CoreDispatcher dispatcher = ((DependencyObject)page).Dispatcher;
		if (val == null)
		{
			val = (DispatchedHandler)delegate
			{
				if (((ICollection<object>)((ItemsControl)page.lvAdd).Items).Count > 0)
				{
					BuddiesSay buddiesSay = null;
					if (((IList<object>)((ItemsControl)page.lvAdd).Items)[((ICollection<object>)((ItemsControl)page.lvAdd).Items).Count - 1] is BuddiesSay { TimeStamp: var timeStamp })
					{
						string timestamp = timeStamp.ToString();
						page._viewModel.LoadMore(timestamp);
					}
				}
			};
		}
		dispatcher.RunAsync((CoreDispatcherPriority)0, val);
	}

	public unsafe BuddyProfileDialog()
	{
		//IL_0044: Unknown result type (might be due to invalid IL or missing references)
		//IL_004e: Expected O, but got Unknown
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		InitializeComponent();
		_viewModel = new BuddyProfilePageViewModel(this);
		((UIElement)this).put_ManipulationMode((ManipulationModes)65535);
		WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationStartedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(UIElement.add_ManipulationStarted)), new Action<EventRegistrationToken>(this, (nint)__ldftn(UIElement.remove_ManipulationStarted)), new ManipulationStartedEventHandler(BuddyProfileDialog_ManipulationStarted));
		WindowsRuntimeMarshal.AddEventHandler(new Func<ManipulationCompletedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(UIElement.add_ManipulationCompleted)), new Action<EventRegistrationToken>(this, (nint)__ldftn(UIElement.remove_ManipulationCompleted)), new ManipulationCompletedEventHandler(BuddyProfileDialog_ManipulationCompleted));
		((UIElement)gridAdd).put_Visibility((Visibility)1);
		((UIElement)RectInteractionLine).put_Visibility((Visibility)1);
		((UIElement)tbUseBuddySay).put_Visibility((Visibility)1);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
	}

	private void BuddyProfileDialog_ManipulationCompleted(object sender, ManipulationCompletedRoutedEventArgs e)
	{
		double num = Position.X - e.Position.X;
		if (num > 0.0)
		{
			((Control)CloseButton).Focus((FocusState)1);
			((UIElement)this).put_Visibility((Visibility)1);
			if (((FrameworkElement)this).Parent is Grid)
			{
				Close();
			}
		}
	}

	private void BuddyProfileDialog_ManipulationStarted(object sender, ManipulationStartedRoutedEventArgs e)
	{
		Position = e.Position;
	}

	private void BuddyProfileDialog_Loaded(object sender, RoutedEventArgs e)
	{
		DataService dataService = new DataService();
		if (BuddyInfo != null)
		{
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == BuddyInfo.PhoneNumber);
			_viewModel.OnNavigatedTo(buddy);
			_ = _viewModel.MemoList;
			CheckPhoneNumberList();
			if (BuddyListPage.ActiveInstance != null && ((FrameworkElement)BuddyListPage.ActiveInstance).ActualHeight > 0.0)
			{
				((FrameworkElement)LayoutRoot).put_Height(((FrameworkElement)BuddyListPage.ActiveInstance).ActualHeight - 30.0);
			}
			((Control)CloseButton).Focus((FocusState)1);
		}
	}

	private void lvAdd_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_001b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0021: Expected O, but got Unknown
		//IL_002a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0030: Expected O, but got Unknown
		//IL_003d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0047: Expected O, but got Unknown
		DependencyObject child = VisualTreeHelper.GetChild((DependencyObject)(object)lvAdd, 0);
		ScrollViewer val = (ScrollViewer)((FrameworkElement)((child is FrameworkElement) ? child : null)).FindName("ScrollViewer");
		if (val != null)
		{
			DependencyProperty listVerticalOffsetProperty = ListVerticalOffsetProperty;
			Binding val2 = new Binding();
			val2.put_Source((object)val);
			val2.put_Path(new PropertyPath("VerticalOffset"));
			val2.put_Mode((BindingMode)3);
			((FrameworkElement)this).SetBinding(listVerticalOffsetProperty, (BindingBase)(object)val2);
		}
	}

	internal void CheckInteraction(bool isBlind)
	{
		if (!isBlind)
		{
			((UIElement)RectInteractionLine).put_Visibility((Visibility)0);
		}
		else
		{
			((UIElement)RectInteractionLine).put_Visibility((Visibility)1);
		}
	}

	private void SetFavorite_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			_viewModel.ToggleFavorite();
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

	private void Image_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			_viewModel.OpenBuddyProfileImage();
		}
	}

	private void StrtChat_Tapped(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			if (this.StartChatTapped != null)
			{
				OnStartChatTapped(sender, new ProfileDialogEventArgs
				{
					Buddy = BuddyInfo
				});
			}
			else
			{
				PivotPage.ActiveInstance.OpenChat(BuddyInfo);
			}
			Close();
		}
	}

	internal void ShowLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		if (_parentPage != null)
		{
			LoadingIndicator.StartLoading(_parentPage, (Panel)(object)LayoutRoot);
		}
		else
		{
			LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
		}
	}

	private void BlockBuddy_Tapped(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			_viewModel.BlockBuddy();
			OnBlockBuddyTapped(this, new ProfileDialogEventArgs
			{
				Buddy = BuddyInfo
			});
		}
	}

	private void BuddySay_Tapped(object sender, RoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			AddBuddiesSayDialog addBuddiesSayDialog = new AddBuddiesSayDialog();
			((FrameworkElement)addBuddiesSayDialog).put_HorizontalAlignment((HorizontalAlignment)2);
			((FrameworkElement)addBuddiesSayDialog).put_VerticalAlignment((VerticalAlignment)2);
			((FrameworkElement)addBuddiesSayDialog).put_Margin(new Thickness(0.0, 0.0, 50.0, 400.0));
			addBuddiesSayDialog.PhoneNumber = BuddyInfo.PhoneNumber;
			addBuddiesSayDialog.WritMemoCompleted += dialog_WritMemoCompleted;
			if (_viewModel.MemoList != null && _viewModel.MemoList.Count > 0)
			{
				addBuddiesSayDialog.LastBuddiesSay = _viewModel.MemoList[0];
			}
			else
			{
				addBuddiesSayDialog.LastBuddiesSay = null;
			}
			if (_parentPage != null && (object)((object)_parentPage).GetType() == typeof(ChatProfilePage))
			{
				ChatProfilePage.ActiveInstance.OpenDialog((UserControl)(object)addBuddiesSayDialog);
			}
			else
			{
				PivotPage.ActiveInstance.OpenDialog((UserControl)(object)addBuddiesSayDialog);
			}
		}
	}

	private void dialog_WritMemoCompleted(object sender, EventArgs e)
	{
		if (sender is AddBuddiesSayDialog)
		{
			(sender as AddBuddiesSayDialog).WritMemoCompleted -= dialog_WritMemoCompleted;
			_viewModel.UpdateMemoList();
		}
	}

	public void Close()
	{
		try
		{
			PivotPage.ActiveInstance.ViewModel.IsRenameMode = false;
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			if (this.DialogClosedTapped != null)
			{
				this.DialogClosedTapped(this, new ProfileDialogEventArgs
				{
					Buddy = BuddyInfo
				});
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

	private async void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			return;
		}
		BuddiesSay buddiesSay;
		BuddiesSay memo = (buddiesSay = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as BuddiesSay);
		if (buddiesSay == null || memo.PhoneNumber != RegistrationService.ChatOnID)
		{
			return;
		}
		PopupMenu menu = new PopupMenu();
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_OPT_DELETE"), (UICommandInvokedHandler)null, (object)1));
		try
		{
			if (await menu.ShowForSelectionAsync(Utility.GetElementRect((FrameworkElement)sender)) != null)
			{
				_viewModel.DeleteMemo(memo);
			}
		}
		catch (Exception)
		{
		}
	}

	internal void CheckPhoneNumberList()
	{
		if (((ICollection<object>)PhoneNumberListControl.Items).Count <= 0)
		{
			return;
		}
		try
		{
			((ICollection<object>)PhoneNumberListControl.Items).Clear();
			((FrameworkElement)PhoneNumberListControl).put_DataContext((object)null);
			BuddyProfilePageViewModel buddyProfilePageViewModel = null;
			if (((FrameworkElement)this).DataContext is BuddyProfilePageViewModel buddyProfilePageViewModel2)
			{
				PhoneNumberListControl.put_ItemsSource((object)buddyProfilePageViewModel2.Buddy.PhoneNumberList);
			}
		}
		catch (Exception)
		{
		}
	}

	private void Image_Tapped_2(object sender, TappedRoutedEventArgs e)
	{
		if (PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			return;
		}
		BuddiesSay buddiesSay = null;
		FrameworkElement val = null;
		if (!(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is BuddiesSay buddiesSay2) || buddiesSay2.PhoneNumber == RegistrationService.GetUserNumber() || buddiesSay2.PhoneNumber == RegistrationService.ChatOnID)
		{
			return;
		}
		DependencyObject parent = ((FrameworkElement)this).Parent;
		if ((val = (FrameworkElement)(object)((parent is FrameworkElement) ? parent : null)) != null && _parentPage == null && val.Parent != null)
		{
			CustomPopup customPopup = null;
			if (val.Parent is CustomPopup customPopup2)
			{
				_parentPage = customPopup2.Page;
			}
		}
		if (_parentPage != null && (object)((object)_parentPage).GetType() == typeof(ChatProfilePage))
		{
			ChatProfilePage.ActiveInstance.OpenBuddyProfile(buddiesSay2.PhoneNumber);
		}
		else if (buddiesSay2.PhoneNumber != BuddyInfo.PhoneNumber)
		{
			PivotPage.ActiveInstance.OpenBuddyProfile(buddiesSay2.PhoneNumber);
		}
	}

	private void PinToStartGrid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (!PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			_viewModel.PinToStart((FrameworkElement)((sender is FrameworkElement) ? sender : null));
		}
	}

	private void Image_Loaded_1(object sender, RoutedEventArgs e)
	{
		//IL_0092: Unknown result type (might be due to invalid IL or missing references)
		//IL_009c: Expected O, but got Unknown
		//IL_00a7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ad: Expected O, but got Unknown
		//IL_00c3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cd: Expected O, but got Unknown
		//IL_0111: Unknown result type (might be due to invalid IL or missing references)
		//IL_0118: Expected O, but got Unknown
		//IL_0128: Unknown result type (might be due to invalid IL or missing references)
		//IL_0132: Expected O, but got Unknown
		//IL_01ad: Unknown result type (might be due to invalid IL or missing references)
		//IL_01b4: Expected O, but got Unknown
		//IL_01c4: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ce: Expected O, but got Unknown
		FrameworkElement val = (FrameworkElement)((sender is FrameworkElement) ? sender : null);
		if (val.Tag != null && (bool)val.Tag)
		{
			return;
		}
		SSMService sSMService = new SSMService();
		BuddiesSay memo = null;
		if ((memo = ((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as BuddiesSay) == null)
		{
			return;
		}
		if (memo.PhoneNumber == RegistrationService.ChatOnID)
		{
			ChatOnService.Instance.UserProfile.ProfileImage = new BitmapImage(sSMService.GetBuddyProfileImageUri(memo.PhoneNumber));
			object obj = ((sender is Image) ? sender : null);
			DependencyProperty sourceProperty = Image.SourceProperty;
			Binding val2 = new Binding();
			val2.put_Source((object)ChatOnService.Instance.UserProfile);
			val2.put_Path(new PropertyPath("ProfileImage"));
			((FrameworkElement)obj).SetBinding(sourceProperty, (BindingBase)(object)val2);
		}
		else
		{
			DataService dataService = new DataService();
			Buddy buddy = dataService.BuddyItems.FirstOrDefault((Buddy c) => c.PhoneNumber == memo.PhoneNumber);
			if (buddy != null)
			{
				object obj2 = ((sender is Image) ? sender : null);
				DependencyProperty sourceProperty2 = Image.SourceProperty;
				Binding val3 = new Binding();
				val3.put_Source((object)buddy);
				val3.put_Path(new PropertyPath("ProfileImage"));
				((FrameworkElement)obj2).SetBinding(sourceProperty2, (BindingBase)(object)val3);
			}
			else
			{
				UnknownUser unknownUser = dataService.UnknownUserItems.FirstOrDefault((UnknownUser c) => c.PhoneNumber == memo.PhoneNumber);
				if (unknownUser == null)
				{
					unknownUser = new UnknownUser();
					unknownUser.PhoneNumber = memo.PhoneNumber;
					unknownUser.Name = Utility.GetResourceString("IDS_CHATON_BODY_UNKNOWN");
					dataService.AddUnknownUser(unknownUser);
				}
				unknownUser.LoadProfileImage(applyTheme: true);
				object obj3 = ((sender is Image) ? sender : null);
				DependencyProperty sourceProperty3 = Image.SourceProperty;
				Binding val4 = new Binding();
				val4.put_Source((object)unknownUser);
				val4.put_Path(new PropertyPath("ProfileImage"));
				((FrameworkElement)obj3).SetBinding(sourceProperty3, (BindingBase)(object)val4);
			}
		}
		((FrameworkElement)((sender is FrameworkElement) ? sender : null)).put_Tag((object)true);
	}

	private async void ViewContactGrid_Tapped(object sender, TappedRoutedEventArgs e)
	{
		if (PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			return;
		}
		try
		{
			PopupMenu menu = new PopupMenu();
			if (BuddyInfo.PhoneNumberList == null || BuddyInfo.PhoneNumberList.Count == 0)
			{
				if ((int)BuddyInfo.OrgPhoneNumberVisible == 0)
				{
					menu.Commands.Add((IUICommand)new UICommand(BuddyInfo.OrgNumber, (UICommandInvokedHandler)null, (object)BuddyInfo.OrgNumber));
				}
			}
			else
			{
				foreach (string phoneNumber in BuddyInfo.PhoneNumberList)
				{
					menu.Commands.Add((IUICommand)new UICommand(phoneNumber, (UICommandInvokedHandler)null, (object)phoneNumber));
				}
			}
			try
			{
				if (await menu.ShowForSelectionAsync(Utility.GetElementRect((FrameworkElement)sender)) == null)
				{
				}
			}
			catch (Exception)
			{
			}
		}
		catch (Exception)
		{
		}
	}

	private void EditName_Click(object sender, RoutedEventArgs e)
	{
		if (PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			PivotPage.ActiveInstance.ViewModel.IsRenameMode = false;
			return;
		}
		tempName = tbEditName.Text;
		PivotPage.ActiveInstance.ViewModel.IsRenameMode = true;
		_viewModel.EditName("");
		((Control)txtEditName).Focus((FocusState)3);
		txtEditName.Select(txtEditName.Text.Length, 0);
	}

	private void EditNameExecuted()
	{
		_viewModel.EditName(txtEditName.Text.Trim(), tempName, isMode: true);
		OnRenameProfileNameTapped(this, new ProfileDialogEventArgs
		{
			Buddy = BuddyInfo
		});
	}

	internal void CheckBuddySayVisibility(bool isBlind)
	{
		if (isBlind)
		{
			((UIElement)gridAdd).put_Visibility((Visibility)1);
			((UIElement)lvAdd).put_Visibility((Visibility)1);
			((UIElement)tbLeaveYourMessage).put_Visibility((Visibility)1);
			((UIElement)tbUseBuddySay).put_Visibility((Visibility)0);
			tbUseBuddySay.put_Text(tbUseBuddySay.Text.Replace("%s", BuddyInfo.Name));
		}
		else
		{
			((UIElement)gridAdd).put_Visibility((Visibility)0);
			((UIElement)lvAdd).put_Visibility((Visibility)0);
			((UIElement)tbUseBuddySay).put_Visibility((Visibility)1);
		}
	}

	private void Close_Click(object sender, RoutedEventArgs e)
	{
		if (PivotPage.ActiveInstance.ViewModel.IsRenameMode)
		{
			return;
		}
		((UIElement)this).put_Visibility((Visibility)1);
		if (((FrameworkElement)this).Parent is Grid)
		{
			Close();
			if (BuddyListPage.ActiveInstance != null)
			{
				BuddyListPage.ActiveInstance.SwitchAppBar(isOpen: true);
			}
		}
	}

	private void TxtEditName_OnLostFocus(object sender, RoutedEventArgs e)
	{
		EditNameExecuted();
	}

	internal async void RenameDone(string finalname)
	{
		tbEditName.put_Text(finalname);
		txtEditName.put_Text(finalname);
		tbUseBuddySay.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_PS_DOES_NOT_USE_BUDDIES_SAY").Replace("%s", finalname));
		await Task.Delay(500);
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
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d1: Expected O, but got Unknown
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		//IL_014b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0155: Expected O, but got Unknown
		//IL_0161: Unknown result type (might be due to invalid IL or missing references)
		//IL_016b: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///BuddyProfileDialog.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			GridProfile = (Grid)((FrameworkElement)this).FindName("GridProfile");
			DetailGrid = (StackPanel)((FrameworkElement)this).FindName("DetailGrid");
			tbLeaveYourMessage = (TextBlock)((FrameworkElement)this).FindName("tbLeaveYourMessage");
			tbUseBuddySay = (TextBlock)((FrameworkElement)this).FindName("tbUseBuddySay");
			lvAdd = (ListView)((FrameworkElement)this).FindName("lvAdd");
			PhoneNumberListControl = (ItemsControl)((FrameworkElement)this).FindName("PhoneNumberListControl");
			RectInteractionLine = (Rectangle)((FrameworkElement)this).FindName("RectInteractionLine");
			gridAdd = (Grid)((FrameworkElement)this).FindName("gridAdd");
			tbEditName = (TextBlock)((FrameworkElement)this).FindName("tbEditName");
			txtEditName = (TextBox)((FrameworkElement)this).FindName("txtEditName");
			EditName_Button = (ImageButton)((FrameworkElement)this).FindName("EditName_Button");
			CloseButton = (ImageButton)((FrameworkElement)this).FindName("CloseButton");
			PinToStartGrid = (Grid)((FrameworkElement)this).FindName("PinToStartGrid");
			BlockGrid = (Grid)((FrameworkElement)this).FindName("BlockGrid");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0048: Unknown result type (might be due to invalid IL or missing references)
		//IL_004e: Expected O, but got Unknown
		//IL_006d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Expected O, but got Unknown
		//IL_007d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0083: Expected O, but got Unknown
		//IL_00a2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ac: Expected O, but got Unknown
		//IL_00b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b8: Expected O, but got Unknown
		//IL_00d7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e1: Expected O, but got Unknown
		//IL_00e2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e9: Expected O, but got Unknown
		//IL_010a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0114: Expected O, but got Unknown
		//IL_011a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0121: Expected O, but got Unknown
		//IL_0142: Unknown result type (might be due to invalid IL or missing references)
		//IL_014c: Expected O, but got Unknown
		//IL_0152: Unknown result type (might be due to invalid IL or missing references)
		//IL_0159: Expected O, but got Unknown
		//IL_017a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0184: Expected O, but got Unknown
		//IL_018a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0191: Expected O, but got Unknown
		//IL_01b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01bc: Expected O, but got Unknown
		//IL_01c2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01c9: Expected O, but got Unknown
		//IL_01ea: Unknown result type (might be due to invalid IL or missing references)
		//IL_01f4: Expected O, but got Unknown
		//IL_0206: Unknown result type (might be due to invalid IL or missing references)
		//IL_0210: Expected O, but got Unknown
		//IL_0216: Unknown result type (might be due to invalid IL or missing references)
		//IL_021d: Expected O, but got Unknown
		//IL_023e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0248: Expected O, but got Unknown
		//IL_025a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0264: Expected O, but got Unknown
		//IL_026a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0271: Expected O, but got Unknown
		//IL_0292: Unknown result type (might be due to invalid IL or missing references)
		//IL_029c: Expected O, but got Unknown
		//IL_02a2: Unknown result type (might be due to invalid IL or missing references)
		//IL_02a9: Expected O, but got Unknown
		//IL_02ca: Unknown result type (might be due to invalid IL or missing references)
		//IL_02d4: Expected O, but got Unknown
		//IL_02d7: Unknown result type (might be due to invalid IL or missing references)
		//IL_02de: Expected O, but got Unknown
		//IL_02ff: Unknown result type (might be due to invalid IL or missing references)
		//IL_0309: Expected O, but got Unknown
		//IL_030c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0313: Expected O, but got Unknown
		//IL_0334: Unknown result type (might be due to invalid IL or missing references)
		//IL_033e: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val13 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val13, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val13, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(BuddyProfileDialog_Loaded));
			break;
		}
		case 2:
		{
			UIElement val12 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val12, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val12, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_2));
			break;
		}
		case 3:
		{
			UIElement val10 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val10, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val10, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_2));
			FrameworkElement val11 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val11, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val11, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(Image_Loaded_1));
			break;
		}
		case 4:
		{
			UIElement val9 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val9, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val9, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 5:
		{
			FrameworkElement val8 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val8, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val8, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(lvAdd_Loaded));
			break;
		}
		case 6:
		{
			UIElement val7 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BuddySay_Tapped));
			break;
		}
		case 7:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_LostFocus)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_LostFocus)), new RoutedEventHandler(TxtEditName_OnLostFocus));
			break;
		}
		case 8:
			((ImageButton)target).Click += new RoutedEventHandler(EditName_Click);
			break;
		case 9:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(SetFavorite_Tapped_1));
			break;
		}
		case 10:
			((ImageButton)target).Click += new RoutedEventHandler(Close_Click);
			break;
		case 11:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_1));
			break;
		}
		case 12:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(StrtChat_Tapped));
			break;
		}
		case 13:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(PinToStartGrid_Tapped_1));
			break;
		}
		case 14:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(BlockBuddy_Tapped));
			break;
		}
		}
		_contentLoaded = true;
	}
}
