using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.InfraStructure;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.UI.Core;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class TrunkPage : Page, IComponentConnector
{
	private IndeterminateProgressbar _progressControl = new IndeterminateProgressbar();

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView TrunkGridView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid tempLoadingIndicator;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock TextControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock TrunkDescription;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	private TrunkItemListPageViewModel ViewModel
	{
		get
		{
			object dataContext = ((FrameworkElement)this).DataContext;
			if (dataContext != null)
			{
				return dataContext as TrunkItemListPageViewModel;
			}
			return new TrunkItemListPageViewModel(this, tempLoadingIndicator);
		}
	}

	public TrunkPage()
	{
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)new TrunkItemListPageViewModel(this, tempLoadingIndicator));
	}

	private void TrunkPage_Loaded(object sender, RoutedEventArgs e)
	{
		TextControl.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_LOADING_ING"));
	}

	private void TrunkPage_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value == 2)
		{
			((FrameworkElement)TrunkGridView).put_Margin(new Thickness(20.0, 0.0, 0.0, 0.0));
			((UIElement)TrunkDescription).put_Visibility((Visibility)1);
		}
		else
		{
			((FrameworkElement)TrunkGridView).put_Margin(new Thickness(120.0, 0.0, 0.0, 0.0));
			((UIElement)TrunkDescription).put_Visibility((Visibility)0);
		}
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		//IL_0025: Unknown result type (might be due to invalid IL or missing references)
		//IL_002b: Invalid comparison between Unknown and I4
		if (ChatDetailPage.ActiveInstance != null)
		{
			ChatDetailPage.ActiveInstance.Disconnect(IsNullChat: false);
		}
		if (ChatDetailPage.SnappedActiveInstance != null)
		{
			ChatDetailPage.SnappedActiveInstance.Disconnect(IsNullChat: false);
		}
		if ((int)e.NavigationMode != 3 && e.Parameter != null)
		{
			Guid id = (Guid)e.Parameter;
			((UIElement)tempLoadingIndicator).put_Visibility((Visibility)0);
			if (ViewModel != null)
			{
				ViewModel.OpenTrunkList(id);
			}
		}
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		while ((object)((Page)this).Frame.CurrentSourcePageType == typeof(TrunkPage))
		{
			Utility.SafetyGoBackPageNavigation(((Page)this).Frame);
		}
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value == 2)
		{
			return;
		}
		FrameworkElement val;
		if ((val = (FrameworkElement)((sender is FrameworkElement) ? sender : null)) != null && val.DataContext is TrunkItem trunkItem && ViewModel != null)
		{
			if (trunkItem.CachedFileName.Contains("3gp"))
			{
				Utility.ShowSimpleToastNotification(Utility.GetResourceString("IDS_CHATON_POP_UNSUPPORTED_MEDIA_TYPE"));
				return;
			}
			ViewModel.MoveToTrunkItemPage(trunkItem);
		}
		if (ChatOnService.Instance.RecentChat != null)
		{
			PivotPage.ActiveInstance.ViewModel.UpdateTrunkUnreadCount(ChatOnService.Instance.RecentChat);
		}
	}

	public void SetTrunkDescription(int photoCount, int videoCount)
	{
		if (photoCount != 0 && videoCount == 0)
		{
			TrunkDescription.put_Text(photoCount + " " + Utility.GetResourceString("IDS_CHATON_OPT_IMAGES"));
			return;
		}
		if (photoCount == 0 && videoCount != 0)
		{
			TrunkDescription.put_Text(videoCount + " " + Utility.GetResourceString("IDS_CHATON_OPT_VIDEOS_ABB"));
			return;
		}
		if (photoCount == 0 && videoCount == 0)
		{
			TrunkDescription.put_Text("");
			return;
		}
		TrunkDescription.put_Text(photoCount + " " + Utility.GetResourceString("IDS_CHATON_OPT_IMAGES") + ", " + videoCount + " " + Utility.GetResourceString("IDS_CHATON_OPT_VIDEOS_ABB"));
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_0049: Invalid comparison between Unknown and I4
		PivotPage.ActiveInstance.ViewModel.UpdateTrunkUnreadCount(ChatOnService.Instance.RecentChat);
		if (ChatDetailPage.ActiveInstance != null && ChatDetailPage.ActiveInstance.ViewModel.Chat != null && !ChatDetailPage.ActiveInstance.ViewModel.IsConnected && (int)e.NavigationMode == 1)
		{
			ChatDetailPage.ActiveInstance.ViewModel.ReConnect();
		}
		((Page)this).OnNavigatedFrom(e);
	}

	public void ShowProgress()
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			_progressControl.Show((Panel)(object)LayoutRoot);
		});
	}

	public void HideProgress()
	{
		//IL_000e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			_progressControl.Hide();
		});
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
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///TrunkPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TrunkGridView = (GridView)((FrameworkElement)this).FindName("TrunkGridView");
			tempLoadingIndicator = (Grid)((FrameworkElement)this).FindName("tempLoadingIndicator");
			TextControl = (TextBlock)((FrameworkElement)this).FindName("TextControl");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			TrunkDescription = (TextBlock)((FrameworkElement)this).FindName("TrunkDescription");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
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
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(TrunkPage_Loaded));
			FrameworkElement val4 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(TrunkPage_SizeChanged));
			break;
		}
		case 2:
		{
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 3:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
