using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using ChatOn.Infrastructure;
using Windows.UI.Core;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class LoadingIndicator : UserControl, IComponentConnector
{
	private static LoadingIndicator _activeIndicator;

	private Page _page;

	private bool _isCancelable;

	private static Panel _root;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock TextControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static LoadingIndicator ActiveIndicator => _activeIndicator;

	public static bool HandleBackKey()
	{
		if (_activeIndicator != null && !_activeIndicator._isCancelable)
		{
			return true;
		}
		if (_activeIndicator != null)
		{
			_activeIndicator.Close();
		}
		return false;
	}

	public static void StopLoading()
	{
		if (_activeIndicator != null)
		{
			_activeIndicator.Close();
		}
	}

	public LoadingIndicator(Page page, Panel root, string text = "Loading...", bool isCancelable = false)
	{
		InitializeComponent();
		Grid.SetRowSpan((FrameworkElement)(object)this, 99);
		Grid.SetColumnSpan((FrameworkElement)(object)this, 99);
		_activeIndicator = this;
		_page = page;
		if (_page != null)
		{
			if (!isCancelable)
			{
				((UIElement)_page).put_IsHitTestVisible(false);
			}
			else
			{
				((UIElement)_page).put_IsHitTestVisible(true);
			}
			if (_page.BottomAppBar != null)
			{
				((UIElement)_page.BottomAppBar).put_Visibility((Visibility)1);
			}
		}
		if (text == "Loading...")
		{
			TextControl.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_LOADING_ING"));
		}
		else
		{
			TextControl.put_Text(text);
		}
		_isCancelable = isCancelable;
		_root = root;
		List<UIElement> list = ((IEnumerable<UIElement>)_root.Children).Where((UIElement x) => (object)((object)x).GetType() == typeof(LoadingIndicator)).ToList();
		if (list.Count <= 0)
		{
			((ICollection<UIElement>)root.Children).Add((UIElement)(object)this);
		}
	}

	public LoadingIndicator()
	{
		InitializeComponent();
	}

	public static void StartLoading(Page page, Panel root, string text = "Loading...", bool isCancelable = false)
	{
		if (_activeIndicator == null)
		{
			_activeIndicator = new LoadingIndicator();
		}
		_activeIndicator.Start(page, root, text, isCancelable);
	}

	internal void Start(Page page, Panel root, string text = "Loading...", bool isCancelable = false)
	{
		Grid.SetRowSpan((FrameworkElement)(object)this, 99);
		Grid.SetColumnSpan((FrameworkElement)(object)this, 99);
		_activeIndicator = this;
		_page = page;
		if (_page != null)
		{
			if (!isCancelable)
			{
				((UIElement)_page).put_IsHitTestVisible(false);
			}
			else
			{
				((UIElement)_page).put_IsHitTestVisible(true);
			}
			if (_page.BottomAppBar != null)
			{
				((UIElement)_page.BottomAppBar).put_Visibility((Visibility)1);
			}
		}
		if (text == "Loading...")
		{
			TextControl.put_Text(Utility.GetResourceString("IDS_CHATON_BODY_LOADING_ING"));
		}
		else
		{
			TextControl.put_Text(text);
		}
		_isCancelable = isCancelable;
		_root = root;
		List<UIElement> list = ((IEnumerable<UIElement>)_root.Children).Where((UIElement x) => (object)((object)x).GetType() == typeof(LoadingIndicator)).ToList();
		if (list.Count <= 0)
		{
			((ICollection<UIElement>)root.Children).Add((UIElement)(object)this);
		}
	}

	internal void SetText(string text)
	{
		TextControl.put_Text(text);
	}

	internal void Close()
	{
		//IL_0041: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Expected O, but got Unknown
		//IL_0026: Unknown result type (might be due to invalid IL or missing references)
		//IL_002c: Expected O, but got Unknown
		DispatchedHandler val = null;
		_activeIndicator = null;
		if (_page != null)
		{
			CoreDispatcher dispatcher = ((DependencyObject)_page).Dispatcher;
			if (val == null)
			{
				val = (DispatchedHandler)delegate
				{
					if (_page.BottomAppBar != null)
					{
						((UIElement)_page.BottomAppBar).put_Visibility((Visibility)0);
					}
					((UIElement)_page).put_IsHitTestVisible(true);
				};
			}
			dispatcher.RunAsync((CoreDispatcherPriority)0, val);
		}
		((DependencyObject)this).Dispatcher.RunAsync((CoreDispatcherPriority)0, (DispatchedHandler)delegate
		{
			DependencyObject parent = ((FrameworkElement)this).Parent;
			Panel val2 = (Panel)(object)((parent is Panel) ? parent : null);
			if (val2 != null)
			{
				((ICollection<UIElement>)val2.Children).Remove((UIElement)(object)this);
			}
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///LoadingIndicator.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			TextControl = (TextBlock)((FrameworkElement)this).FindName("TextControl");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
