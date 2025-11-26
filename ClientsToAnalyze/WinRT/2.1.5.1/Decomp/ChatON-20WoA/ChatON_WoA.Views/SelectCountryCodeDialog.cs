using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.ViewModels;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;

namespace ChatON_WoA.Views;

public sealed class SelectCountryCodeDialog : UserControl, IComponentConnector
{
	public delegate void SelectCountryCodeEventHandler(object sender, object e);

	private SelectCountryCodePageViewModel _viewModel;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView CountryGrid;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBox InputBox;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public event SelectCountryCodeEventHandler SelectionCompleted;

	public SelectCountryCodeDialog()
	{
		InitializeComponent();
		_viewModel = new SelectCountryCodePageViewModel();
		((FrameworkElement)this).put_DataContext((object)_viewModel);
		_viewModel.MakeResultList(loadAll: true);
	}

	private void InputBox_Loaded(object sender, RoutedEventArgs e)
	{
		((Control)InputBox).Focus((FocusState)2);
	}

	private void Keyword_TextChanged_1(object sender, TextChangedEventArgs e)
	{
		_viewModel.Keyword = ((TextBox)((sender is TextBox) ? sender : null)).Text;
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is CountryCode e2 && this.SelectionCompleted != null)
		{
			this.SelectionCompleted(this, e2);
		}
	}

	private void Image_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		Close();
	}

	public void Close()
	{
		if (((FrameworkElement)this).Parent is FrameworkElement)
		{
			CustomPopup customPopup = null;
			DependencyObject parent = ((FrameworkElement)this).Parent;
			if (((FrameworkElement)((parent is FrameworkElement) ? parent : null)).Parent is CustomPopup customPopup2)
			{
				customPopup2.Close();
			}
		}
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SelectCountryCodeDialog.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			CountryGrid = (ListView)((FrameworkElement)this).FindName("CountryGrid");
			InputBox = (TextBox)((FrameworkElement)this).FindName("InputBox");
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
		//IL_0051: Unknown result type (might be due to invalid IL or missing references)
		//IL_0057: Expected O, but got Unknown
		//IL_0076: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Expected O, but got Unknown
		//IL_0081: Unknown result type (might be due to invalid IL or missing references)
		//IL_0087: Expected O, but got Unknown
		//IL_00a6: Unknown result type (might be due to invalid IL or missing references)
		//IL_00b0: Expected O, but got Unknown
		//IL_00b3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ba: Expected O, but got Unknown
		//IL_00db: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e5: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
			break;
		}
		case 2:
		{
			FrameworkElement val2 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(InputBox_Loaded));
			TextBox val3 = (TextBox)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TextChangedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(TextBox.add_TextChanged)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(TextBox.remove_TextChanged)), new TextChangedEventHandler(Keyword_TextChanged_1));
			break;
		}
		case 3:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Image_Tapped_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
