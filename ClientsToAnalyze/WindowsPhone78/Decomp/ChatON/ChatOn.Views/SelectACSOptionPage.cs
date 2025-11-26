using System;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Navigation;
using ChatOn.Res;
using ChatOn.Services;
using Microsoft.Phone.Controls;
using Microsoft.Phone.Shell;

namespace ChatOn.Views;

public class SelectACSOptionPage : PhoneApplicationPage
{
	private int _selectedType;

	private bool _isNew = true;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal StackPanel ContentPanel;

	internal ListPicker TypePicker;

	internal TextBlock NoticeText;

	private bool _contentLoaded;

	public int SelectedType
	{
		get
		{
			return _selectedType;
		}
		set
		{
			_selectedType = value;
		}
	}

	public SelectACSOptionPage()
	{
		InitializeComponent();
		string iDS_CHATON_BODY_YOU_WILL_RECEIVE_AN_AUTOMATIC_CALL_FROM_CHATON_USE_THE_PD_DIGIT_NUMBER_YOU_HEAR_DURING_THE_CALL_TO_ACTIVATE_YOUR_CHATON_ACCOUNT_EXAMPLE_MSG = ResContainer.IDS_CHATON_BODY_YOU_WILL_RECEIVE_AN_AUTOMATIC_CALL_FROM_CHATON_USE_THE_PD_DIGIT_NUMBER_YOU_HEAR_DURING_THE_CALL_TO_ACTIVATE_YOUR_CHATON_ACCOUNT_EXAMPLE_MSG;
		iDS_CHATON_BODY_YOU_WILL_RECEIVE_AN_AUTOMATIC_CALL_FROM_CHATON_USE_THE_PD_DIGIT_NUMBER_YOU_HEAR_DURING_THE_CALL_TO_ACTIVATE_YOUR_CHATON_ACCOUNT_EXAMPLE_MSG = iDS_CHATON_BODY_YOU_WILL_RECEIVE_AN_AUTOMATIC_CALL_FROM_CHATON_USE_THE_PD_DIGIT_NUMBER_YOU_HEAR_DURING_THE_CALL_TO_ACTIVATE_YOUR_CHATON_ACCOUNT_EXAMPLE_MSG.Replace("%d", "4");
		iDS_CHATON_BODY_YOU_WILL_RECEIVE_AN_AUTOMATIC_CALL_FROM_CHATON_USE_THE_PD_DIGIT_NUMBER_YOU_HEAR_DURING_THE_CALL_TO_ACTIVATE_YOUR_CHATON_ACCOUNT_EXAMPLE_MSG = iDS_CHATON_BODY_YOU_WILL_RECEIVE_AN_AUTOMATIC_CALL_FROM_CHATON_USE_THE_PD_DIGIT_NUMBER_YOU_HEAR_DURING_THE_CALL_TO_ACTIVATE_YOUR_CHATON_ACCOUNT_EXAMPLE_MSG.Replace("%s", "1234");
		NoticeText.Text = iDS_CHATON_BODY_YOU_WILL_RECEIVE_AN_AUTOMATIC_CALL_FROM_CHATON_USE_THE_PD_DIGIT_NUMBER_YOU_HEAR_DURING_THE_CALL_TO_ACTIVATE_YOUR_CHATON_ACCOUNT_EXAMPLE_MSG;
		object obj = ((PhoneApplicationPage)this).ApplicationBar.Buttons[0];
		((ApplicationBarIconButton)((obj is ApplicationBarIconButton) ? obj : null)).Text = ResContainer.IDS_CHATON_SK_OK;
		object obj2 = ((PhoneApplicationPage)this).ApplicationBar.Buttons[1];
		((ApplicationBarIconButton)((obj2 is ApplicationBarIconButton) ? obj2 : null)).Text = ResContainer.IDS_CHATON_SK_CANCEL;
		string[] itemsSource = new string[2] { "English - United States", "Japanese - Japan" };
		TypePicker.ItemsSource = itemsSource;
		((FrameworkElement)this).DataContext = this;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void SaveButton_Click(object sender, EventArgs e)
	{
		PageNavigationService.OpenInputVerificationCodePage((PhoneApplicationPage)(object)this, (_selectedType == 0) ? "en_US" : "ja_JP");
	}

	private void CancelButton_Click(object sender, EventArgs e)
	{
		Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/SelectACSOptionPage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			ContentPanel = (StackPanel)((FrameworkElement)this).FindName("ContentPanel");
			TypePicker = (ListPicker)((FrameworkElement)this).FindName("TypePicker");
			NoticeText = (TextBlock)((FrameworkElement)this).FindName("NoticeText");
		}
	}
}
