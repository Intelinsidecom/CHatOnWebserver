using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Data;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Animation;

namespace ChatOn.Controls;

public class RatioChart : UserControl, IComponentConnector
{
	public static readonly DependencyProperty LeftTextProperty = DependencyProperty.RegisterAttached("LeftText", typeof(string), typeof(RatioChart), (PropertyMetadata)null);

	public static readonly DependencyProperty RightTextProperty = DependencyProperty.RegisterAttached("RightText", typeof(string), typeof(RatioChart), (PropertyMetadata)null);

	public static readonly DependencyProperty LeftValueProperty = DependencyProperty.RegisterAttached("LeftValue", typeof(double), typeof(RatioChart), (PropertyMetadata)null);

	public static readonly DependencyProperty RightValueProperty = DependencyProperty.RegisterAttached("RightValue", typeof(double), typeof(RatioChart), (PropertyMetadata)null);

	public static readonly DependencyProperty StandardValueProperty = DependencyProperty.RegisterAttached("StandardValue", typeof(double), typeof(RatioChart), (PropertyMetadata)null);

	public static readonly DependencyProperty LeftImageProperty = DependencyProperty.RegisterAttached("LeftImage", typeof(ImageSource), typeof(RatioChart), (PropertyMetadata)null);

	public static readonly DependencyProperty RightImageProperty = DependencyProperty.RegisterAttached("RightImage", typeof(ImageSource), typeof(RatioChart), (PropertyMetadata)null);

	public static readonly DependencyProperty LeftFontColorProperty = DependencyProperty.RegisterAttached("LeftFontColor", typeof(Brush), typeof(RatioChart), (PropertyMetadata)null);

	public static readonly DependencyProperty RightFontColorProperty = DependencyProperty.RegisterAttached("RightFontColor", typeof(Brush), typeof(RatioChart), (PropertyMetadata)null);

	private double _leftChartTarget;

	private double _rightChartTarget;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Storyboard BeginStoryboard;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image LeftImageControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Image RightImageControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock LeftTextControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock RightTextControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public string LeftText
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(LeftTextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(LeftTextProperty, (object)value);
		}
	}

	public string RightText
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(RightTextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(RightTextProperty, (object)value);
		}
	}

	public double LeftValue
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(LeftValueProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(LeftValueProperty, (object)value);
		}
	}

	public double RightValue
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(RightValueProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(RightValueProperty, (object)value);
		}
	}

	public double StandardValue
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(StandardValueProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(StandardValueProperty, (object)value);
		}
	}

	public ImageSource LeftImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(LeftImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(LeftImageProperty, (object)value);
		}
	}

	public ImageSource RightImage
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (ImageSource)((DependencyObject)this).GetValue(RightImageProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(RightImageProperty, (object)value);
		}
	}

	public Brush LeftFontColor
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (Brush)((DependencyObject)this).GetValue(LeftFontColorProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(LeftFontColorProperty, (object)value);
		}
	}

	public Brush RightFontColor
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (Brush)((DependencyObject)this).GetValue(RightFontColorProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(RightFontColorProperty, (object)value);
		}
	}

	public RatioChart()
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
		//IL_00a1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a7: Expected O, but got Unknown
		//IL_00b4: Unknown result type (might be due to invalid IL or missing references)
		//IL_00be: Expected O, but got Unknown
		//IL_00cf: Unknown result type (might be due to invalid IL or missing references)
		//IL_00d6: Expected O, but got Unknown
		//IL_00e5: Unknown result type (might be due to invalid IL or missing references)
		//IL_00ef: Expected O, but got Unknown
		//IL_0101: Unknown result type (might be due to invalid IL or missing references)
		//IL_0108: Expected O, but got Unknown
		//IL_0117: Unknown result type (might be due to invalid IL or missing references)
		//IL_0121: Expected O, but got Unknown
		InitializeComponent();
		TextBlock leftTextControl = LeftTextControl;
		DependencyProperty textProperty = TextBlock.TextProperty;
		Binding val = new Binding();
		val.put_Source((object)this);
		val.put_Path(new PropertyPath("LeftText"));
		((FrameworkElement)leftTextControl).SetBinding(textProperty, (BindingBase)(object)val);
		TextBlock leftTextControl2 = LeftTextControl;
		DependencyProperty foregroundProperty = TextBlock.ForegroundProperty;
		Binding val2 = new Binding();
		val2.put_Source((object)this);
		val2.put_Path(new PropertyPath("LeftFontColor"));
		((FrameworkElement)leftTextControl2).SetBinding(foregroundProperty, (BindingBase)(object)val2);
		TextBlock rightTextControl = RightTextControl;
		DependencyProperty foregroundProperty2 = TextBlock.ForegroundProperty;
		Binding val3 = new Binding();
		val3.put_Source((object)this);
		val3.put_Path(new PropertyPath("RightFontColor"));
		((FrameworkElement)rightTextControl).SetBinding(foregroundProperty2, (BindingBase)(object)val3);
		TextBlock rightTextControl2 = RightTextControl;
		DependencyProperty textProperty2 = TextBlock.TextProperty;
		Binding val4 = new Binding();
		val4.put_Source((object)this);
		val4.put_Path(new PropertyPath("RightText"));
		((FrameworkElement)rightTextControl2).SetBinding(textProperty2, (BindingBase)(object)val4);
		Image leftImageControl = LeftImageControl;
		DependencyProperty sourceProperty = Image.SourceProperty;
		Binding val5 = new Binding();
		val5.put_Source((object)this);
		val5.put_Path(new PropertyPath("LeftImage"));
		((FrameworkElement)leftImageControl).SetBinding(sourceProperty, (BindingBase)(object)val5);
		Image rightImageControl = RightImageControl;
		DependencyProperty sourceProperty2 = Image.SourceProperty;
		Binding val6 = new Binding();
		val6.put_Source((object)this);
		val6.put_Path(new PropertyPath("RightImage"));
		((FrameworkElement)rightImageControl).SetBinding(sourceProperty2, (BindingBase)(object)val6);
	}

	private void LeftTextControl_SizeChanged(object sender, SizeChangedEventArgs e)
	{
		UpdateChart();
	}

	private void RatioChart_LayoutUpdated(object sender, object e)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Invalid comparison between Unknown and I4
		if ((int)((UIElement)this).Visibility == 1)
		{
			UpdateChart();
		}
	}

	private void RatioChart_Loaded(object sender, RoutedEventArgs e)
	{
		UpdateChart();
	}

	private void UpdateChart()
	{
		try
		{
			if (((FrameworkElement)this).ActualWidth == 0.0)
			{
				((UIElement)this).put_Visibility((Visibility)1);
				return;
			}
			if (LeftValue + RightValue == 0.0)
			{
				((UIElement)this).put_Visibility((Visibility)1);
				return;
			}
			((UIElement)this).put_Visibility((Visibility)0);
			((UIElement)LeftImageControl).put_Visibility((Visibility)0);
			((UIElement)RightImageControl).put_Visibility((Visibility)0);
			if (StandardValue == 0.0)
			{
				StandardValue = 1.0;
			}
			_leftChartTarget = ((FrameworkElement)this).ActualWidth * LeftValue / StandardValue;
			_rightChartTarget = ((FrameworkElement)this).ActualWidth * RightValue / StandardValue;
			if (LeftValue == 0.0)
			{
				((UIElement)LeftTextControl).put_Visibility((Visibility)1);
			}
			else if (RightValue == 0.0)
			{
				((UIElement)RightTextControl).put_Visibility((Visibility)1);
			}
			double num = 0.0;
			if (LeftValue > 0.0 && _leftChartTarget < ((FrameworkElement)LeftTextControl).ActualWidth + 10.0)
			{
				num = ((FrameworkElement)LeftTextControl).ActualWidth + 10.0 - _leftChartTarget;
				_leftChartTarget = ((FrameworkElement)LeftTextControl).ActualWidth + 10.0;
				if (StandardValue == LeftValue + RightValue)
				{
					_rightChartTarget -= num;
				}
			}
			num = 0.0;
			if (RightValue > 0.0 && _rightChartTarget < ((FrameworkElement)RightTextControl).ActualWidth + 10.0)
			{
				num = ((FrameworkElement)RightTextControl).ActualWidth + 10.0 - _rightChartTarget;
				_rightChartTarget = ((FrameworkElement)RightTextControl).ActualWidth + 10.0;
				if (StandardValue == LeftValue + RightValue)
				{
					_leftChartTarget -= num;
				}
			}
			((FrameworkElement)LeftImageControl).put_Width(_leftChartTarget);
			((FrameworkElement)RightImageControl).put_Width(_rightChartTarget);
		}
		catch
		{
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
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///RatioChart.xaml"), (ComponentResourceLocation)0);
			BeginStoryboard = (Storyboard)((FrameworkElement)this).FindName("BeginStoryboard");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			LeftImageControl = (Image)((FrameworkElement)this).FindName("LeftImageControl");
			RightImageControl = (Image)((FrameworkElement)this).FindName("RightImageControl");
			LeftTextControl = (TextBlock)((FrameworkElement)this).FindName("LeftTextControl");
			RightTextControl = (TextBlock)((FrameworkElement)this).FindName("RightTextControl");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0018: Unknown result type (might be due to invalid IL or missing references)
		//IL_001e: Expected O, but got Unknown
		//IL_0048: Unknown result type (might be due to invalid IL or missing references)
		//IL_004e: Expected O, but got Unknown
		//IL_006d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0077: Expected O, but got Unknown
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0080: Expected O, but got Unknown
		//IL_009f: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a9: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val2 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.add_LayoutUpdated)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.remove_LayoutUpdated)), RatioChart_LayoutUpdated);
			FrameworkElement val3 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(RatioChart_Loaded));
			break;
		}
		case 2:
		{
			FrameworkElement val = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<SizeChangedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.add_SizeChanged)), new Action<EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.remove_SizeChanged)), new SizeChangedEventHandler(LeftTextControl_SizeChanged));
			break;
		}
		}
		_contentLoaded = true;
	}
}
