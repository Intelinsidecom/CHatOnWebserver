using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Input;
using System.Windows.Navigation;
using ChatOn.Res;
using ChatOn.ViewModels;
using Microsoft.Phone.Controls;

namespace ChatOn.Views;

public class SelectCountryCodePage : PhoneApplicationPage
{
	public delegate void SelectCountryCodePageEventHandler(object sender, object arg);

	private SelectCountryCodePageViewModel _viewModel;

	private bool _isNew = true;

	internal Grid LayoutRoot;

	internal StackPanel TitlePanel;

	internal TextBlock ApplicationTitle;

	internal ListBox SearchResultList;

	internal ListBox SearchResultListNonVirtual;

	internal TextBox InputBox;

	internal StackPanel SearchPanel;

	private bool _contentLoaded;

	public static event SelectCountryCodePageEventHandler SelectionCompleted;

	public SelectCountryCodePage()
	{
		InitializeComponent();
		_viewModel = new SelectCountryCodePageViewModel(this);
		((FrameworkElement)this).DataContext = _viewModel;
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (_isNew)
		{
			_isNew = false;
			if (SelectCountryCodePage.SelectionCompleted == null)
			{
				Utility.SafetyGoBack((PhoneApplicationPage)(object)this);
				return;
			}
			IDictionary<string, string> queryString = ((Page)this).NavigationContext.QueryString;
			if (queryString.ContainsKey("language"))
			{
				ApplicationTitle.Text = ResContainer.IDS_CHATON_HEADER_SELECT_COUNTRY;
				SearchResultList.Visibility = Visibility.Collapsed;
				SearchResultListNonVirtual.ItemsSource = _viewModel.SearchResult;
				_viewModel.IsCodeSelectionMode = false;
			}
			else
			{
				SearchResultListNonVirtual.Visibility = Visibility.Collapsed;
				SearchResultList.ItemsSource = _viewModel.SearchResult;
				_viewModel.IsCodeSelectionMode = true;
			}
			_viewModel.MakeResultList(loadAll: true);
		}
		((Page)this).OnNavigatedTo(e);
	}

	private void SearchPanel_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		SearchPanel.Visibility = Visibility.Collapsed;
		InputBox.Visibility = Visibility.Visible;
		InputBox.Focus();
	}

	private void InputBox_TextChanged(object sender, TextChangedEventArgs e)
	{
		TextBox textBox = sender as TextBox;
		_viewModel.Keyword = textBox.Text;
	}

	private void StackPanel_Tap(object sender, System.Windows.Input.GestureEventArgs e)
	{
		CountryCode arg = (sender as FrameworkElement).DataContext as CountryCode;
		if (SelectCountryCodePage.SelectionCompleted != null)
		{
			SelectCountryCodePage.SelectionCompleted(this, arg);
		}
	}

	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent(this, new Uri("/ChatON;component/Views/SelectCountryCodePage.xaml", UriKind.Relative));
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TitlePanel = (StackPanel)((FrameworkElement)this).FindName("TitlePanel");
			ApplicationTitle = (TextBlock)((FrameworkElement)this).FindName("ApplicationTitle");
			SearchResultList = (ListBox)((FrameworkElement)this).FindName("SearchResultList");
			SearchResultListNonVirtual = (ListBox)((FrameworkElement)this).FindName("SearchResultListNonVirtual");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
			SearchPanel = (StackPanel)((FrameworkElement)this).FindName("SearchPanel");
		}
	}
}
