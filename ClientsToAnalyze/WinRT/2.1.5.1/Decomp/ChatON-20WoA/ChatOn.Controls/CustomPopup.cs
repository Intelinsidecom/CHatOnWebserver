using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Views;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class CustomPopup : UserControl, IComponentConnector
{
	private static CustomPopup _activeInstance;

	private Page _page;

	private FrameworkElement _child;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static CustomPopup ActiveInstance => _activeInstance;

	public Page Page => _page;

	public FrameworkElement Child => _child;

	public event EventHandler Closed;

	public static void CloseActive()
	{
		if (_activeInstance != null)
		{
			_activeInstance.Close();
		}
	}

	public CustomPopup(Page page, Panel root, FrameworkElement control)
	{
		InitializeComponent();
		Grid.SetRowSpan((FrameworkElement)(object)this, 99);
		Grid.SetColumnSpan((FrameworkElement)(object)this, 99);
		_activeInstance = this;
		_page = page;
		if (_page != null && _page.BottomAppBar != null)
		{
			((UIElement)_page.BottomAppBar).put_Visibility((Visibility)1);
		}
		((ICollection<UIElement>)((Panel)LayoutRoot).Children).Add((UIElement)(object)control);
		((ICollection<UIElement>)root.Children).Add((UIElement)(object)this);
		_child = control;
	}

	internal void Close()
	{
		_activeInstance = null;
		if (_page != null && _page.BottomAppBar != null)
		{
			((UIElement)_page.BottomAppBar).put_Visibility((Visibility)0);
		}
		DependencyObject parent = ((FrameworkElement)this).Parent;
		Panel val = (Panel)(object)((parent is Panel) ? parent : null);
		if (val != null)
		{
			((ICollection<UIElement>)val.Children).Remove((UIElement)(object)this);
		}
		if (this.Closed != null)
		{
			this.Closed(this, null);
			this.Closed = null;
		}
	}

	private void Grid_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		Close();
		if (ChatDetailPage.ActiveInstance != null)
		{
			ChatDetailPage.ActiveInstance.ViewModel.AppBarVisibility = (Visibility)0;
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///CustomPopup.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		if (connectionId == 1)
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Grid_Tapped_1));
		}
		_contentLoaded = true;
	}
}
