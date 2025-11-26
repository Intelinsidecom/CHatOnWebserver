using System;
using System.ComponentModel;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Controls;
using ChatOn.Res;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class SkinSettingPage : PhoneApplicationPage
{
	private SkinSettingPageViewModel _viewModel;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal ChatBubble MyBubbleControl;

	internal ChatBubble BuddyBubbleControl;

	private bool _contentLoaded;

	public SkinSettingPage()
	{
		InitializeComponent();
		_viewModel = new SkinSettingPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_SAVE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_BUTTON_CANCEL;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	protected override void OnBackKeyPress(CancelEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		_viewModel.RestoreData();
		((PhoneApplicationPage)this).OnBackKeyPress(e);
	}

	private void Save_Click(object sender, EventArgs e)
	{
		_viewModel.Save();
	}

	private void Cancel_Click(object sender, EventArgs e)
	{
		_viewModel.Cancel();
	}

	private void Bubble_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		SkinItem item = (sender as FrameworkElement).DataContext as SkinItem;
		_viewModel.OnSelectBubble(item);
	}

	private void BG_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		SkinItem item = (sender as FrameworkElement).DataContext as SkinItem;
		_viewModel.OnSelectBG(item);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/SkinSettingPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			MyBubbleControl = (ChatBubble)((FrameworkElement)this).FindName("MyBubbleControl");
			BuddyBubbleControl = (ChatBubble)((FrameworkElement)this).FindName("BuddyBubbleControl");
		}
	}
}
