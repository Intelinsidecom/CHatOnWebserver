using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Models;
using ChatOn.Res;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class InteractionRankPage : PhoneApplicationPage
{
	private InteractionRankPageViewModel _viewModel;

	internal ApplicationBarIconButton Share;

	internal ApplicationBarIconButton Refresh;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal Grid ContentPanel;

	internal ScrollViewer InteractionScroll;

	internal ItemsControl InteractionList;

	private bool _contentLoaded;

	public InteractionRankPage()
	{
		InitializeComponent();
		_viewModel = new InteractionRankPageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
		((FrameworkElement)this).Loaded += InteractionRankPage_Loaded;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		ApplicationBarIconButton val = (ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null);
		val.Text = ResContainer.IDS_CHATON_BUTTON_SHARE;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		ApplicationBarIconButton val2 = (ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null);
		val2.Text = ResContainer.IDS_CHATON_SK_REFRESH;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void InteractionRankPage_Loaded(object sender, RoutedEventArgs e)
	{
		_viewModel.MakeRankedBuddies();
	}

	private void Refresh_Click(object sender, EventArgs e)
	{
		_viewModel.Refresh();
	}

	private void Grid_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		Buddy buddy = (sender as FrameworkElement).DataContext as Buddy;
		string iDS_CHATON_POP_HIDE_INTERACTION_WITH_PS_Q = ResContainer.IDS_CHATON_POP_HIDE_INTERACTION_WITH_PS_Q;
		iDS_CHATON_POP_HIDE_INTERACTION_WITH_PS_Q = iDS_CHATON_POP_HIDE_INTERACTION_WITH_PS_Q.Replace("%s", "{0:}");
		iDS_CHATON_POP_HIDE_INTERACTION_WITH_PS_Q = string.Format(iDS_CHATON_POP_HIDE_INTERACTION_WITH_PS_Q, buddy.Name);
		if (MessageBoxResult.OK == MessageBox.Show(iDS_CHATON_POP_HIDE_INTERACTION_WITH_PS_Q, ResContainer.IDS_CHATON_SK1_HIDE_INTERACTIONS, MessageBoxButton.OKCancel))
		{
			_viewModel.HideInteraction(buddy);
		}
	}

	private void Share_Click(object sender, EventArgs e)
	{
		_viewModel.ShareInteraction();
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/InteractionRankPage.xaml", UriKind.Relative));
			Share = (ApplicationBarIconButton)((FrameworkElement)this).FindName("Share");
			Refresh = (ApplicationBarIconButton)((FrameworkElement)this).FindName("Refresh");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (Grid)((FrameworkElement)this).FindName("ContentPanel");
			InteractionScroll = (ScrollViewer)((FrameworkElement)this).FindName("InteractionScroll");
			InteractionList = (ItemsControl)((FrameworkElement)this).FindName("InteractionList");
		}
	}
}
