using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.ViewModels;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class SuggestionsPage : Page, IComponentConnector
{
	private SuggestionsPageViewMode _viewModel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock NoListText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock txtsubCount;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public SuggestionsPage()
	{
		InitializeComponent();
		_viewModel = new SuggestionsPageViewMode(this);
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		pageTitle.put_Text(Utility.GetResourceString("IDS_CHATON_ITAB_SUGGESTIONS"));
		txtsubCount.put_Text(Utility.GetResourceString("IDS_CHATON_HEADER_PEOPLE_YOU_MAY_KNOW"));
	}

	protected override void OnNavigatedFrom(NavigationEventArgs e)
	{
		PivotPage.ActiveInstance.SetSuggestionsCount(_viewModel.BuddyItems.Count);
	}

	private void AddButton_Click_1(object sender, RoutedEventArgs e)
	{
		_viewModel.AddBuddy(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as UnknownUser);
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	public void GoBack()
	{
		((Page)this).Frame.GoBack();
	}

	internal void ShowNoList()
	{
		((UIElement)NoListText).put_Visibility((Visibility)0);
	}

	private void IgnoreButton_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.RemoveRecomendee(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as UnknownUser);
	}

	public void ShowLoading(string text = "Loading...")
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot, text);
	}

	private void backIgnoreAll_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.IgnoreAllBuddy();
	}

	private void backAddAll_Click(object sender, RoutedEventArgs e)
	{
		_viewModel.AddAllBuddy();
	}

	private async void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		PopupMenu menu = new PopupMenu();
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BUTTON_ADD"), (UICommandInvokedHandler)null, (object)1));
		menu.Commands.Add((IUICommand)new UICommand(Utility.GetResourceString("IDS_CHATON_BUTTON_IGNORE"), (UICommandInvokedHandler)null, (object)2));
		try
		{
			IUICommand chosenCommand = await menu.ShowForSelectionAsync(Utility.GetElementRect((FrameworkElement)sender));
			if (chosenCommand != null)
			{
				switch ((int)chosenCommand.Id)
				{
				case 1:
					_viewModel.AddBuddy(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as UnknownUser);
					break;
				case 2:
					_viewModel.RemoveRecomendee(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as UnknownUser);
					break;
				}
			}
		}
		catch (Exception)
		{
		}
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SuggestionsPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			NoListText = (TextBlock)((FrameworkElement)this).FindName("NoListText");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
			txtsubCount = (TextBlock)((FrameworkElement)this).FindName("txtsubCount");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0028: Unknown result type (might be due to invalid IL or missing references)
		//IL_002e: Expected O, but got Unknown
		//IL_004d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0057: Expected O, but got Unknown
		//IL_005d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_0082: Unknown result type (might be due to invalid IL or missing references)
		//IL_008c: Expected O, but got Unknown
		//IL_0092: Unknown result type (might be due to invalid IL or missing references)
		//IL_0098: Expected O, but got Unknown
		//IL_00b7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c1: Expected O, but got Unknown
		//IL_00c7: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ce: Expected O, but got Unknown
		//IL_00ef: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f9: Expected O, but got Unknown
		//IL_00fc: Unknown result type (might be due to invalid IL or missing references)
		//IL_0103: Expected O, but got Unknown
		//IL_0124: Unknown result type (might be due to invalid IL or missing references)
		//IL_012e: Expected O, but got Unknown
		//IL_0131: Unknown result type (might be due to invalid IL or missing references)
		//IL_0138: Expected O, but got Unknown
		//IL_0159: Unknown result type (might be due to invalid IL or missing references)
		//IL_0163: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 2:
		{
			ButtonBase val5 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(AddButton_Click_1));
			break;
		}
		case 3:
		{
			ButtonBase val4 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backAddAll_Click));
			break;
		}
		case 4:
		{
			ButtonBase val3 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backIgnoreAll_Click));
			break;
		}
		case 5:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		case 6:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
			break;
		}
		}
		_contentLoaded = true;
	}
}
