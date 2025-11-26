using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Threading;
using System.Threading.Tasks;
using ChatON_WoA.ViewModels;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media.Animation;

namespace ChatON_WoA.Controls;

public sealed class CountdownControl : UserControl, IComponentConnector
{
	private bool _countingDown;

	private RoutedEventHandler m_CountdownComplete;

	public static readonly DependencyProperty SecondsProperty = DependencyProperty.Register("Seconds", typeof(int), typeof(CountdownControl), new PropertyMetadata((object)0, new PropertyChangedCallback(OnSecondsChanged)));

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock PART_Label;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private RingSlice PART_RingSlice;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public int Seconds
	{
		get
		{
			return (int)((DependencyObject)this).GetValue(SecondsProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(SecondsProperty, (object)value);
		}
	}

	public event RoutedEventHandler CountdownComplete
	{
		add
		{
			//IL_0010: Unknown result type (might be due to invalid IL or missing references)
			//IL_0016: Expected O, but got Unknown
			RoutedEventHandler val = this.m_CountdownComplete;
			RoutedEventHandler val2;
			do
			{
				val2 = val;
				RoutedEventHandler value2 = (RoutedEventHandler)Delegate.Combine((Delegate)(object)val2, (Delegate)(object)value);
				val = Interlocked.CompareExchange(ref this.m_CountdownComplete, value2, val2);
			}
			while (val != val2);
		}
		remove
		{
			//IL_0010: Unknown result type (might be due to invalid IL or missing references)
			//IL_0016: Expected O, but got Unknown
			RoutedEventHandler val = this.m_CountdownComplete;
			RoutedEventHandler val2;
			do
			{
				val2 = val;
				RoutedEventHandler value2 = (RoutedEventHandler)Delegate.Remove((Delegate)(object)val2, (Delegate)(object)value);
				val = Interlocked.CompareExchange(ref this.m_CountdownComplete, value2, val2);
			}
			while (val != val2);
		}
	}

	private static void OnSecondsChanged(DependencyObject sender, DependencyPropertyChangedEventArgs e)
	{
		CountdownControl countdownControl = (CountdownControl)(object)sender;
		int oldSeconds = (int)e.OldValue;
		int newSeconds = (int)e.NewValue;
		countdownControl.OnSecondsChanged(oldSeconds, newSeconds);
	}

	private void OnSecondsChanged(int oldSeconds, int newSeconds)
	{
		if (!_countingDown && newSeconds > 0)
		{
			StartCountdownAsync(newSeconds);
		}
	}

	public CountdownControl()
	{
		InitializeComponent();
	}

	public async Task StartCountdownAsync(int seconds)
	{
		_countingDown = true;
		Seconds = seconds;
		bool grow = true;
		while (Seconds > 0)
		{
			Storyboard sb = new Storyboard();
			if (grow)
			{
				DoubleAnimation val = new DoubleAnimation();
				val.put_From((double?)0.0);
				val.put_To((double?)359.999);
				((Timeline)val).put_Duration(new Duration(TimeSpan.FromSeconds(1.0)));
				val.put_EnableDependentAnimation(true);
				DoubleAnimation val2 = val;
				((ICollection<Timeline>)sb.Children).Add((Timeline)(object)val2);
				Storyboard.SetTargetProperty((Timeline)(object)val2, "EndAngle");
				Storyboard.SetTarget((Timeline)(object)sb, (DependencyObject)(object)PART_RingSlice);
			}
			else
			{
				DoubleAnimation val3 = new DoubleAnimation();
				val3.put_From((double?)0.0);
				val3.put_To((double?)359.999);
				((Timeline)val3).put_Duration(new Duration(TimeSpan.FromSeconds(1.0)));
				val3.put_EnableDependentAnimation(true);
				DoubleAnimation val4 = val3;
				((ICollection<Timeline>)sb.Children).Add((Timeline)(object)val4);
				Storyboard.SetTargetProperty((Timeline)(object)val4, "StartAngle");
				Storyboard.SetTarget((Timeline)(object)sb, (DependencyObject)(object)PART_RingSlice);
			}
			PART_Label.put_Text(Seconds.ToString());
			await sb.BeginAsync();
			if (grow)
			{
				PART_RingSlice.StartAngle = 0.0;
				PART_RingSlice.EndAngle = 359.999;
			}
			else
			{
				PART_RingSlice.StartAngle = 0.0;
				PART_RingSlice.EndAngle = 0.0;
			}
			grow = !grow;
			Seconds--;
		}
		PART_Label.put_Text(Seconds.ToString());
		if (this.CountdownComplete != null)
		{
			this.CountdownComplete.Invoke((object)this, new RoutedEventArgs());
		}
		_countingDown = false;
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
			Application.LoadComponent((object)this, new Uri("ms-appx:///Controls/CountdownControl.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			PART_Label = (TextBlock)((FrameworkElement)this).FindName("PART_Label");
			PART_RingSlice = (RingSlice)((FrameworkElement)this).FindName("PART_RingSlice");
		}
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
