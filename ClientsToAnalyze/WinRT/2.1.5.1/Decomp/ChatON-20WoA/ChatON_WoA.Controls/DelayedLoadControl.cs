using System;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Threading.Tasks;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatON_WoA.Controls;

[TemplatePart(Name = "PART_ContentBorder", Type = typeof(Border))]
public class DelayedLoadControl : Control
{
	private const string ContentBorderName = "PART_ContentBorder";

	private Border _contentBorder;

	private int _loadRequestId;

	public static readonly DependencyProperty DelayProperty = DependencyProperty.Register("Delay", typeof(TimeSpan), typeof(DelayedLoadControl), new PropertyMetadata((object)TimeSpan.FromSeconds(0.0)));

	public static readonly DependencyProperty ContentTemplateProperty = DependencyProperty.Register("ContentTemplate", typeof(DataTemplate), typeof(DelayedLoadControl), new PropertyMetadata((object)null));

	public TimeSpan Delay
	{
		get
		{
			return (TimeSpan)((DependencyObject)this).GetValue(DelayProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(DelayProperty, (object)value);
		}
	}

	public DataTemplate ContentTemplate
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (DataTemplate)((DependencyObject)this).GetValue(ContentTemplateProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ContentTemplateProperty, (object)value);
		}
	}

	public unsafe DelayedLoadControl()
	{
		//IL_0037: Unknown result type (might be due to invalid IL or missing references)
		//IL_0041: Expected O, but got Unknown
		//IL_0062: Unknown result type (might be due to invalid IL or missing references)
		//IL_006c: Expected O, but got Unknown
		((Control)this).put_DefaultStyleKey((object)typeof(DelayedLoadControl));
		WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(this, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(OnLoaded));
		WindowsRuntimeMarshal.AddEventHandler(new Func<DependencyPropertyChangedEventHandler, EventRegistrationToken>(this, (nint)__ldftn(Control.add_IsEnabledChanged)), new Action<EventRegistrationToken>(this, (nint)__ldftn(Control.remove_IsEnabledChanged)), new DependencyPropertyChangedEventHandler(OnIsEnabledChanged));
	}

	protected override void OnApplyTemplate()
	{
		((FrameworkElement)this).OnApplyTemplate();
		ref Border contentBorder = ref _contentBorder;
		DependencyObject templateChild = ((Control)this).GetTemplateChild("PART_ContentBorder");
		contentBorder = (Border)(object)((templateChild is Border) ? templateChild : null);
	}

	private void OnIsEnabledChanged(object sender, DependencyPropertyChangedEventArgs dependencyPropertyChangedEventArgs)
	{
		_loadRequestId++;
		if (((Control)this).IsEnabled)
		{
			DelayedLoad();
		}
	}

	private void OnLoaded(object sender, RoutedEventArgs routedEventArgs)
	{
		if (((Control)this).IsEnabled)
		{
			DelayedLoad();
		}
	}

	private async void DelayedLoad()
	{
		_loadRequestId++;
		int handledRequestId = _loadRequestId;
		await Task.Delay(Delay);
		if (handledRequestId == _loadRequestId && _contentBorder.Child == null)
		{
			_contentBorder.put_Child((UIElement)ContentTemplate.LoadContent());
		}
	}
}
