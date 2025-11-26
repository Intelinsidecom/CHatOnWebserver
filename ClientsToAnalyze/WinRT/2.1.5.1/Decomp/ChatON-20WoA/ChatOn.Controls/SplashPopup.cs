using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public class SplashPopup : UserControl, IComponentConnector
{
	private DispatcherTimer timer;

	private DateTime startTime;

	private bool isActive;

	private static SplashPopup _activePopup;

	private static Panel _activeParent = null;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Border LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image IconImage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock TextControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	private double timeDiff => DateTime.Now.Subtract(startTime).TotalSeconds;

	public static SplashPopup ActivePopup
	{
		get
		{
			if (_activePopup == null)
			{
				_activePopup = new SplashPopup();
			}
			return _activePopup;
		}
	}

	public SplashPopup()
	{
		InitializeComponent();
		Grid.SetRowSpan((FrameworkElement)(object)this, 99);
		Grid.SetColumnSpan((FrameworkElement)(object)this, 99);
		((FrameworkElement)this).put_HorizontalAlignment((HorizontalAlignment)2);
		((FrameworkElement)this).put_VerticalAlignment((VerticalAlignment)0);
	}

	public static async void Show(Panel parent, string text, bool showIcon = true)
	{
		if (_activeParent != null)
		{
			Stop();
		}
		_activeParent = parent;
		ActivePopup.TextControl.put_Text(text);
		if (showIcon)
		{
			((UIElement)ActivePopup.IconImage).put_Visibility((Visibility)1);
			((FrameworkElement)ActivePopup.TextControl).put_Margin(new Thickness(20.0, 30.0, 30.0, 30.0));
		}
		else
		{
			((UIElement)ActivePopup.IconImage).put_Visibility((Visibility)0);
			((FrameworkElement)ActivePopup.TextControl).put_Margin(new Thickness(20.0, 30.0, 30.0, 30.0));
			ActivePopup.TextControl.put_TextAlignment((TextAlignment)1);
		}
		Start();
		((ICollection<UIElement>)_activeParent.Children).Add((UIElement)(object)ActivePopup);
	}

	private void timer_Tick(object sender, object e)
	{
		if (isActive && timeDiff > 4.0)
		{
			stop();
		}
	}

	private static void Stop()
	{
		ActivePopup.stop();
	}

	private static void Start()
	{
		ActivePopup.start();
	}

	private unsafe void start()
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		if (timer == null)
		{
			timer = new DispatcherTimer();
			timer.put_Interval(new TimeSpan(0, 0, 0, 1));
			DispatcherTimer val = timer;
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(val, (nint)__ldftn(DispatcherTimer.remove_Tick)), timer_Tick);
		}
		if (!timer.IsEnabled)
		{
			timer.Start();
		}
		isActive = true;
		startTime = DateTime.Now;
	}

	private void stop()
	{
		isActive = false;
		if (timer != null)
		{
			timer.Stop();
		}
		if (_activeParent != null)
		{
			((ICollection<UIElement>)_activeParent.Children).Remove((UIElement)(object)ActivePopup);
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
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SplashPopup.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Border)((FrameworkElement)this).FindName("LayoutRoot");
			IconImage = (Image)((FrameworkElement)this).FindName("IconImage");
			TextControl = (TextBlock)((FrameworkElement)this).FindName("TextControl");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
