using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;

namespace ChatOn.Controls;

public class ImageButton : UserControl, IComponentConnector
{
	public static readonly DependencyProperty NormalImageProperty = DependencyProperty.RegisterAttached("NormalImage", typeof(ImageSource), typeof(ImageButton), (PropertyMetadata)null);

	public static readonly DependencyProperty PressedImageProperty = DependencyProperty.RegisterAttached("PressedImage", typeof(ImageSource), typeof(ImageButton), (PropertyMetadata)null);

	public static readonly DependencyProperty DisabledImageProperty = DependencyProperty.RegisterAttached("DisabledImage", typeof(ImageSource), typeof(ImageButton), (PropertyMetadata)null);

	public static readonly DependencyProperty LightNormalImageProperty = DependencyProperty.RegisterAttached("NormalImage", typeof(ImageSource), typeof(ImageButton), (PropertyMetadata)null);

	public static readonly DependencyProperty LightPressedImageProperty = DependencyProperty.RegisterAttached("PressedImage", typeof(ImageSource), typeof(ImageButton), (PropertyMetadata)null);

	public static readonly DependencyProperty LightDisabledImageProperty = DependencyProperty.RegisterAttached("DisabledImage", typeof(ImageSource), typeof(ImageButton), (PropertyMetadata)null);

	public static readonly DependencyProperty ClickModeProperty = DependencyProperty.RegisterAttached("ClickMode", typeof(ClickMode), typeof(ImageButton), new PropertyMetadata((object)(ClickMode)0));

	public static readonly DependencyProperty TextProperty = DependencyProperty.RegisterAttached("Text", typeof(string), typeof(ImageButton), (PropertyMetadata)null);

	public static readonly DependencyProperty ForegroundProperty = DependencyProperty.RegisterAttached("Foreground", typeof(Brush), typeof(ImageButton), (PropertyMetadata)null);

	private RoutedEventHandler m_Click;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButtonBase imgBtn;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public ImageSource NormalImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(NormalImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(NormalImageProperty, (object)value);
			imgBtn.NormalImage = value;
		}
	}

	public ImageSource PressedImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(PressedImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(PressedImageProperty, (object)value);
			imgBtn.PressedImage = value;
		}
	}

	public ImageSource DisabledImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(DisabledImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(DisabledImageProperty, (object)value);
			imgBtn.DisabledImage = value;
		}
	}

	public ImageSource LightNormalImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(LightNormalImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(LightNormalImageProperty, (object)value);
			imgBtn.NormalImage = value;
		}
	}

	public ImageSource LightPressedImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(LightPressedImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(LightPressedImageProperty, (object)value);
			imgBtn.PressedImage = value;
		}
	}

	public ImageSource LightDisabledImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(LightDisabledImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(LightDisabledImageProperty, (object)value);
			imgBtn.DisabledImage = value;
		}
	}

	public ClickMode ClickMode
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			return (ClickMode)((DependencyObject)this).GetValue(ClickModeProperty);
		}
		set
		{
			//IL_0006: Unknown result type (might be due to invalid IL or missing references)
			//IL_0017: Unknown result type (might be due to invalid IL or missing references)
			((DependencyObject)this).SetValue(ClickModeProperty, (object)value);
			((ButtonBase)imgBtn).put_ClickMode(value);
		}
	}

	public string Text
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(TextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(TextProperty, (object)value);
			imgBtn.Text = value;
		}
	}

	public Brush Foreground
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (Brush)((DependencyObject)this).GetValue(ForegroundProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ForegroundProperty, (object)value);
			((Control)imgBtn).put_Foreground(value);
		}
	}

	public event RoutedEventHandler Click
	{
		add
		{
			//IL_0010: Unknown result type (might be due to invalid IL or missing references)
			//IL_0016: Expected O, but got Unknown
			RoutedEventHandler val = this.m_Click;
			RoutedEventHandler val2;
			do
			{
				val2 = val;
				RoutedEventHandler value2 = (RoutedEventHandler)Delegate.Combine((Delegate)(object)val2, (Delegate)(object)value);
				val = Interlocked.CompareExchange(ref this.m_Click, value2, val2);
			}
			while (val != val2);
		}
		remove
		{
			//IL_0010: Unknown result type (might be due to invalid IL or missing references)
			//IL_0016: Expected O, but got Unknown
			RoutedEventHandler val = this.m_Click;
			RoutedEventHandler val2;
			do
			{
				val2 = val;
				RoutedEventHandler value2 = (RoutedEventHandler)Delegate.Remove((Delegate)(object)val2, (Delegate)(object)value);
				val = Interlocked.CompareExchange(ref this.m_Click, value2, val2);
			}
			while (val != val2);
		}
	}

	public unsafe ImageButton()
	{
		InitializeComponent();
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_LayoutUpdated)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_LayoutUpdated)), ImageButton_LayoutUpdated);
	}

	private void imgBtn_Click(object sender, RoutedEventArgs e)
	{
		if (this.Click != null)
		{
			this.Click.Invoke(sender, e);
		}
	}

	private void ImageButton_LayoutUpdated(object sender, object e)
	{
		if (LightPressedImage == null)
		{
			imgBtn.PressedImage = PressedImage;
		}
		if (LightNormalImage == null)
		{
			imgBtn.NormalImage = NormalImage;
		}
		if (LightDisabledImage == null)
		{
			imgBtn.DisabledImage = DisabledImage;
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ImageButton.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			imgBtn = (ImageButtonBase)((FrameworkElement)this).FindName("imgBtn");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		if (connectionId == 1)
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(imgBtn_Click));
		}
		_contentLoaded = true;
	}
}
