using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatOn.Controls;

public sealed class DateDisplayUserControl : UserControl, IComponentConnector
{
	public static readonly DependencyProperty ItemContentProperty = DependencyProperty.Register("ItemContent", typeof(UIElement), typeof(DateDisplayUserControl), new PropertyMetadata((object)null));

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public UIElement ItemContent
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (UIElement)((DependencyObject)this).GetValue(ItemContentProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ItemContentProperty, (object)value);
		}
	}

	public DateDisplayUserControl()
	{
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)this);
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///Controls/DateDisplayUserControl.xaml"), (ComponentResourceLocation)0);
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void Connect(int connectionId, object target)
	{
		_contentLoaded = true;
	}
}
