using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Infrastructure;
using ChatOn.Services;
using ChatOn.ViewModels;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class SelectLanguagePage : Page, IComponentConnector
{
	private SelectCountryCodePageViewModel _viewModel;

	private bool _IsSelectCountryCode;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private SemanticZoom semanticZoom;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView ZoomedOutGridView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView CountryGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputBox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public SelectLanguagePage()
	{
		InitializeComponent();
		_viewModel = new SelectCountryCodePageViewModel();
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		pageTitle.put_Text(Utility.GetResourceString("IDS_CHATON_POP_SELECT_COUNTRY_OR_REGION_CODE"));
	}

	private void InputBox_Loaded(object sender, RoutedEventArgs e)
	{
		((Control)InputBox).Focus((FocusState)3);
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e.Parameter != null)
		{
			RegistrationService.GetUserAccount();
			_IsSelectCountryCode = true;
		}
		_viewModel.MakeResultList(loadAll: true);
	}

	private void Keyword_TextChanged_1(object sender, TextChangedEventArgs e)
	{
		_viewModel.Keyword = ((TextBox)((sender is TextBox) ? sender : null)).Text;
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		//IL_00df: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e5: Expected O, but got Unknown
		if (!(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is CountryCode countryCode) || countryCode.Name.Length == 1)
		{
			return;
		}
		if (_IsSelectCountryCode)
		{
			RegistrationService.RegisterAccount(countryCode.MCC);
			RegistrationService.SaveCountryCode(countryCode.Code.Remove(0, 1));
			RegistrationService.SaveIsoCode(Utility.GetIsoCodeFromCountryName(countryCode.Name));
			((Page)this).Frame.Navigate(typeof(InputPhoneNumberPage), (object)countryCode);
			return;
		}
		RegistrationService.RegisterAccount(countryCode.MCC);
		RegistrationService.SaveCountryCode(countryCode.Code.Remove(0, 1));
		RegistrationService.SaveIsoCode(Utility.GetIsoCodeFromCountryName(countryCode.Name));
		if (countryCode.MCC == "450")
		{
			((Page)this).Frame.Navigate(typeof(DisclaimerKoreaPage));
		}
		else if (countryCode.MCC == "432")
		{
			string text = "This service is not available in your country";
			MessageDialog val = new MessageDialog(text);
			val.ShowAsync();
		}
		else
		{
			((Page)this).Frame.Navigate(typeof(DisclaimerPage));
		}
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private void SelectedItemHeader_Selected(object sender, SelectionChangedEventArgs e)
	{
		GridView val = (GridView)((sender is GridView) ? sender : null);
		if (((Selector)val).SelectedItem != null)
		{
			_viewModel.SelectedHeaderList(((Selector)val).SelectedItem.ToString());
		}
	}

	private void Grid_Tapped_2(object sender, TappedRoutedEventArgs e)
	{
		_viewModel.SelectedHeaderList(((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext as string);
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SelectLanguagePage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			semanticZoom = (SemanticZoom)((FrameworkElement)this).FindName("semanticZoom");
			ZoomedOutGridView = (GridView)((FrameworkElement)this).FindName("ZoomedOutGridView");
			CountryGrid = (GridView)((FrameworkElement)this).FindName("CountryGrid");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0020: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected O, but got Unknown
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004f: Expected O, but got Unknown
		//IL_0055: Unknown result type (might be due to invalid IL or missing references)
		//IL_005b: Expected O, but got Unknown
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0084: Expected O, but got Unknown
		//IL_008a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0090: Expected O, but got Unknown
		//IL_00af: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b9: Expected O, but got Unknown
		//IL_00ba: Unknown result type (might be due to invalid IL or missing references)
		//IL_00c1: Expected O, but got Unknown
		//IL_00e2: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ec: Expected O, but got Unknown
		//IL_00ef: Unknown result type (might be due to invalid IL or missing references)
		//IL_00f6: Expected O, but got Unknown
		//IL_0117: Unknown result type (might be due to invalid IL or missing references)
		//IL_0121: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 2:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_2));
			break;
		}
		case 3:
		{
			FrameworkElement val2 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputBox_Loaded));
			TextBox val3 = (TextBox)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TextChangedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(TextBox.add_TextChanged)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(TextBox.remove_TextChanged)), new TextChangedEventHandler(Keyword_TextChanged_1));
			break;
		}
		case 4:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
