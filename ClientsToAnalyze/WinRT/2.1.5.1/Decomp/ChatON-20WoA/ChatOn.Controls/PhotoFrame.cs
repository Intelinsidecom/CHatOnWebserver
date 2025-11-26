using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Infrastructure;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;

namespace ChatOn.Controls;

public class PhotoFrame : UserControl, IComponentConnector
{
	public static readonly DependencyProperty PhotoProperty = DependencyProperty.RegisterAttached("Photo", typeof(ImageSource), typeof(PhotoFrame), (PropertyMetadata)null);

	public static readonly DependencyProperty IconVisibilityProperty = DependencyProperty.RegisterAttached("IconVisibility", typeof(bool), typeof(PhotoFrame), (PropertyMetadata)null);

	public static readonly DependencyProperty MaxBubbleWidthProperty = DependencyProperty.Register("MaxBubbleWidth", typeof(double), typeof(PhotoFrame), new PropertyMetadata((object)null, new PropertyChangedCallback(MaxBubbleWidthChanged)));

	public static readonly DependencyProperty StretchProperty = DependencyProperty.RegisterAttached("Stretch", typeof(Stretch), typeof(PhotoFrame), new PropertyMetadata((object)(Stretch)3, (PropertyChangedCallback)null));

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image PhotoImage;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image tl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image tc;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image tr;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image ml;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image mr;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image bl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image bc;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image br;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image VideoIcon;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public double MaxBubbleWidth
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(MaxBubbleWidthProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(MaxBubbleWidthProperty, (object)value);
		}
	}

	public ImageSource Photo
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(PhotoProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(PhotoProperty, (object)value);
		}
	}

	public bool IconVisibility
	{
		get
		{
			return (bool)((DependencyObject)this).GetValue(IconVisibilityProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(IconVisibilityProperty, (object)value);
		}
	}

	public Stretch Stretch
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			return (Stretch)((DependencyObject)this).GetValue(StretchProperty);
		}
		set
		{
			//IL_0006: Unknown result type (might be due to invalid IL or missing references)
			((DependencyObject)this).SetValue(StretchProperty, (object)value);
		}
	}

	private static void MaxBubbleWidthChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		//IL_0022: Unknown result type (might be due to invalid IL or missing references)
		//IL_0028: Invalid comparison between Unknown and I4
		if (!((double)e.NewValue > 0.0))
		{
			return;
		}
		double num = (double)e.NewValue;
		if ((int)ApplicationView.Value != 2)
		{
			if (num > 150.0)
			{
				num = 150.0;
			}
		}
		else if (num > 100.0)
		{
			num = 100.0;
		}
		PhotoFrame photoFrame = null;
		if (obj is PhotoFrame photoFrame2)
		{
			((FrameworkElement)photoFrame2.PhotoImage).put_MaxWidth(num);
			((FrameworkElement)photoFrame2.PhotoImage).put_MaxHeight(num);
		}
	}

	public PhotoFrame()
	{
		//IL_0017: Unknown result type (might be due to invalid IL or missing references)
		//IL_001d: Expected O, but got Unknown
		//IL_002a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0034: Expected O, but got Unknown
		//IL_0045: Unknown result type (might be due to invalid IL or missing references)
		//IL_004b: Expected O, but got Unknown
		//IL_0058: Unknown result type (might be due to invalid IL or missing references)
		//IL_0062: Expected O, but got Unknown
		//IL_0073: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		//IL_0086: Unknown result type (might be due to invalid IL or missing references)
		//IL_0090: Expected O, but got Unknown
		InitializeComponent();
		Image photoImage = PhotoImage;
		DependencyProperty stretchProperty = Image.StretchProperty;
		Binding val = new Binding();
		val.put_Source((object)this);
		val.put_Path(new PropertyPath("Stretch"));
		((FrameworkElement)photoImage).SetBinding(stretchProperty, (BindingBase)(object)val);
		Image photoImage2 = PhotoImage;
		DependencyProperty sourceProperty = Image.SourceProperty;
		Binding val2 = new Binding();
		val2.put_Source((object)this);
		val2.put_Path(new PropertyPath("Photo"));
		((FrameworkElement)photoImage2).SetBinding(sourceProperty, (BindingBase)(object)val2);
		Image videoIcon = VideoIcon;
		DependencyProperty visibilityProperty = UIElement.VisibilityProperty;
		Binding val3 = new Binding();
		val3.put_Source((object)this);
		val3.put_Path(new PropertyPath("IconVisibility"));
		val3.put_Converter((IValueConverter)(object)new BoolToVisibility());
		((FrameworkElement)videoIcon).SetBinding(visibilityProperty, (BindingBase)(object)val3);
	}

	private void UserControl_Unloaded(object sender, RoutedEventArgs e)
	{
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
		//IL_00dd: Unknown result type (might be due to invalid IL or missing references)
		//IL_00e7: Expected O, but got Unknown
		//IL_00f3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00fd: Expected O, but got Unknown
		//IL_0109: Unknown result type (might be due to invalid IL or missing references)
		//IL_0113: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///PhotoFrame.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			PhotoImage = (Image)((FrameworkElement)this).FindName("PhotoImage");
			tl = (Image)((FrameworkElement)this).FindName("tl");
			tc = (Image)((FrameworkElement)this).FindName("tc");
			tr = (Image)((FrameworkElement)this).FindName("tr");
			ml = (Image)((FrameworkElement)this).FindName("ml");
			mr = (Image)((FrameworkElement)this).FindName("mr");
			bl = (Image)((FrameworkElement)this).FindName("bl");
			bc = (Image)((FrameworkElement)this).FindName("bc");
			br = (Image)((FrameworkElement)this).FindName("br");
			VideoIcon = (Image)((FrameworkElement)this).FindName("VideoIcon");
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
			FrameworkElement val = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.add_Unloaded)), new Action<EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.remove_Unloaded)), new RoutedEventHandler(UserControl_Unloaded));
		}
		_contentLoaded = true;
	}
}
