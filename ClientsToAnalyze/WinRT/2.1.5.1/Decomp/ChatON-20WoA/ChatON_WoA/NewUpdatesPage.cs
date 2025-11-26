using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.DataModel;
using ChatON_WoA.ViewModels;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using Windows.UI.Core;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA;

public sealed class NewUpdatesPage : Page, IComponentConnector
{
	public static readonly DependencyProperty ListVerticalOffsetProperty = DependencyProperty.Register("ListVerticalOffset", typeof(double), typeof(NewUpdatesPage), new PropertyMetadata((object)null, new PropertyChangedCallback(OnListVerticalOffsetChanged)));

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock NoListText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListBox NewUpdateList;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	private NewUpdatesPageViewModel VM => (NewUpdatesPageViewModel)((FrameworkElement)this).DataContext;

	private static void OnListVerticalOffsetChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_0087: Expected O, but got Unknown
		try
		{
			if (!(obj is NewUpdatesPage))
			{
				return;
			}
			DispatchedHandler val = null;
			NewUpdatesPage page = obj as NewUpdatesPage;
			ScrollViewer val2 = null;
			double num = 0.0;
			if ((val2 = page.GetMessageScrollViewer()) == null)
			{
				return;
			}
			_ = val2.ScrollableHeight;
			double num2 = (double)e.NewValue;
			num = val2.ScrollableHeight;
			if (val2 == null || !(num2 >= num - 0.5))
			{
				return;
			}
			CoreDispatcher dispatcher = ((DependencyObject)page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					page.VM.LoadMoreNewUpdate();
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		catch (Exception)
		{
		}
	}

	private void NewUpdateList_Loaded(object sender, RoutedEventArgs e)
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0032: Expected O, but got Unknown
		//IL_003f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Expected O, but got Unknown
		DependencyObject child = VisualTreeHelper.GetChild((DependencyObject)(object)NewUpdateList, 0);
		FrameworkElement val = (FrameworkElement)(object)((child is FrameworkElement) ? child : null);
		if (val != null)
		{
			ScrollViewer val2 = (ScrollViewer)val.FindName("ScrollViewer");
			DependencyProperty listVerticalOffsetProperty = ListVerticalOffsetProperty;
			Binding val3 = new Binding();
			val3.put_Source((object)val2);
			val3.put_Path(new PropertyPath("VerticalOffset"));
			val3.put_Mode((BindingMode)3);
			((FrameworkElement)this).SetBinding(listVerticalOffsetProperty, (BindingBase)(object)val3);
		}
	}

	internal ScrollViewer GetMessageScrollViewer()
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		DependencyObject child = VisualTreeHelper.GetChild((DependencyObject)(object)NewUpdateList, 0);
		FrameworkElement val = (FrameworkElement)(object)((child is FrameworkElement) ? child : null);
		if (val != null)
		{
			return (ScrollViewer)val.FindName("ScrollViewer");
		}
		return null;
	}

	public unsafe NewUpdatesPage()
	{
		//IL_0039: Unknown result type (might be due to invalid IL or missing references)
		//IL_0043: Expected O, but got Unknown
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)new NewUpdatesPageViewModel(this));
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(NewUpdatesPage_Loaded));
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
	}

	private void NewUpdatesPage_Loaded(object sender, RoutedEventArgs e)
	{
		VM.OnLoaded();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		VM.OnNavigatedTo(e);
		((Page)this).OnNavigatedTo(e);
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private async void ListBox_Tapped(object sender, TappedRoutedEventArgs e)
	{
		if (VM == null || VM._isTapped || (int)(ListBox)sender == 0 || ((Selector)(ListBox)sender).SelectedIndex == -1)
		{
			return;
		}
		NewUpdate newUpdate = VM.NavigationPage(((Selector)(ListBox)sender).SelectedIndex);
		if (newUpdate.service.Equals("trunk"))
		{
			if (newUpdate.status == "dereg")
			{
				MessageDialog dialog = new MessageDialog(Utility.sprintf(Utility.GetResourceString("toast_deleted_account"), newUpdate.sender.buddy.name));
				await dialog.ShowAsync();
				VM._isTapped = false;
				return;
			}
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
			VM.OpenTrunkItemPage(newUpdate);
		}
		else if (newUpdate.service.Equals("buddy"))
		{
			if (newUpdate.status == "dereg")
			{
				MessageDialog dialog2 = new MessageDialog(Utility.sprintf(Utility.GetResourceString("toast_deleted_account"), newUpdate.sender.buddy.name));
				await dialog2.ShowAsync();
				VM._isTapped = false;
				return;
			}
			if (LoadingIndicator.ActiveIndicator != null)
			{
				LoadingIndicator.StopLoading();
			}
			LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
			VM.StartChat(newUpdate);
		}
		else if (newUpdate.service.Equals("profile"))
		{
			if (newUpdate.status == "dereg")
			{
				MessageDialog dialog3 = new MessageDialog(Utility.sprintf(Utility.GetResourceString("toast_deleted_account"), newUpdate.sender.buddy.name));
				await dialog3.ShowAsync();
				VM._isTapped = false;
			}
			else
			{
				OpenBuddyProfile(newUpdate.sender.buddy.id);
			}
		}
		else if (newUpdate.service.Equals("suggestion"))
		{
			((Page)this).Frame.Navigate(typeof(SuggestionsPage));
		}
		else
		{
			PivotPage.ActiveInstance.OpenMyPage();
			((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(PivotPage));
		}
	}

	public void OpenBuddyProfile(string number)
	{
		Buddy buddyFromNumber = PivotPage.ActiveInstance.ViewModel.GetBuddyFromNumber(number);
		if (((ICollection<UIElement>)((Panel)LayoutRoot).Children).Count > 0)
		{
			UIElement val = null;
			if ((val = ((IEnumerable<UIElement>)((Panel)LayoutRoot).Children).FirstOrDefault((UIElement x) => (object)((object)x).GetType() == typeof(CustomPopup))) != null)
			{
				CustomPopup customPopup = null;
				if (val is CustomPopup customPopup2)
				{
					customPopup2.Close();
				}
			}
		}
		if (buddyFromNumber != null)
		{
			if (buddyFromNumber.IsBlocked)
			{
				UnknownUser unknownUser = new UnknownUser(buddyFromNumber.Name, buddyFromNumber.PhoneNumber);
				unknownUser.SetMessage(unknownUser.Name);
				unknownUser.IsBlocked = true;
				UnknownBuddyProfileDialog unknownBuddyProfileDialog = new UnknownBuddyProfileDialog();
				unknownBuddyProfileDialog.BuddyInfo = unknownUser;
				UnknownBuddyProfileDialog control = unknownBuddyProfileDialog;
				new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)control);
			}
			else
			{
				BuddyProfileDialog buddyProfileDialog = new BuddyProfileDialog();
				buddyProfileDialog.BuddyInfo = buddyFromNumber;
				((FrameworkElement)buddyProfileDialog).put_HorizontalAlignment((HorizontalAlignment)1);
				((FrameworkElement)buddyProfileDialog).put_VerticalAlignment((VerticalAlignment)1);
				new CustomPopup((Page)(object)this, (Panel)(object)LayoutRoot, (FrameworkElement)(object)buddyProfileDialog);
			}
		}
		VM._isTapped = false;
	}

	internal void ShowNoList()
	{
		((UIElement)NoListText).put_Visibility((Visibility)0);
	}

	public void ShowLoading()
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading(null, (Panel)(object)LayoutRoot);
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///NewUpdatesPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			NoListText = (TextBlock)((FrameworkElement)this).FindName("NoListText");
			NewUpdateList = (ListBox)((FrameworkElement)this).FindName("NewUpdateList");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0018: Unknown result type (might be due to invalid IL or missing references)
		//IL_001e: Expected O, but got Unknown
		//IL_003d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0047: Expected O, but got Unknown
		//IL_0048: Unknown result type (might be due to invalid IL or missing references)
		//IL_004e: Expected O, but got Unknown
		//IL_006d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Expected O, but got Unknown
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Expected O, but got Unknown
		//IL_009f: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a9: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(ListBox_Tapped));
			FrameworkElement val3 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(NewUpdateList_Loaded));
			break;
		}
		case 2:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
