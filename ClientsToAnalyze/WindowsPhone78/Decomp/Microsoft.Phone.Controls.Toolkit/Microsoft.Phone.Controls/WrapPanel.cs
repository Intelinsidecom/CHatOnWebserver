using System;
using System.ComponentModel;
using System.Globalization;
using System.Windows;
using System.Windows.Controls;
using Microsoft.Phone.Controls.Properties;

namespace Microsoft.Phone.Controls;

public class WrapPanel : Panel
{
	private bool _ignorePropertyChange;

	public static readonly DependencyProperty ItemHeightProperty = DependencyProperty.Register("ItemHeight", typeof(double), typeof(WrapPanel), new PropertyMetadata(double.NaN, OnItemHeightOrWidthPropertyChanged));

	public static readonly DependencyProperty ItemWidthProperty = DependencyProperty.Register("ItemWidth", typeof(double), typeof(WrapPanel), new PropertyMetadata(double.NaN, OnItemHeightOrWidthPropertyChanged));

	public static readonly DependencyProperty OrientationProperty = DependencyProperty.Register("Orientation", typeof(Orientation), typeof(WrapPanel), new PropertyMetadata(Orientation.Horizontal, OnOrientationPropertyChanged));

	[TypeConverter(typeof(LengthConverter))]
	public double ItemHeight
	{
		get
		{
			return (double)GetValue(ItemHeightProperty);
		}
		set
		{
			SetValue(ItemHeightProperty, value);
		}
	}

	[TypeConverter(typeof(LengthConverter))]
	public double ItemWidth
	{
		get
		{
			return (double)GetValue(ItemWidthProperty);
		}
		set
		{
			SetValue(ItemWidthProperty, value);
		}
	}

	public Orientation Orientation
	{
		get
		{
			return (Orientation)GetValue(OrientationProperty);
		}
		set
		{
			SetValue(OrientationProperty, value);
		}
	}

	private static void OnOrientationPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		WrapPanel wrapPanel = (WrapPanel)d;
		Orientation orientation = (Orientation)e.NewValue;
		if (wrapPanel._ignorePropertyChange)
		{
			wrapPanel._ignorePropertyChange = false;
			return;
		}
		if (orientation != Orientation.Horizontal && orientation != Orientation.Vertical)
		{
			wrapPanel._ignorePropertyChange = true;
			wrapPanel.SetValue(OrientationProperty, (Orientation)e.OldValue);
			string message = string.Format(CultureInfo.InvariantCulture, Microsoft.Phone.Controls.Properties.Resources.WrapPanel_OnOrientationPropertyChanged_InvalidValue, orientation);
			throw new ArgumentException(message, "value");
		}
		wrapPanel.InvalidateMeasure();
	}

	private static void OnItemHeightOrWidthPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		WrapPanel wrapPanel = (WrapPanel)d;
		double num = (double)e.NewValue;
		if (wrapPanel._ignorePropertyChange)
		{
			wrapPanel._ignorePropertyChange = false;
			return;
		}
		if (!num.IsNaN() && (num <= 0.0 || double.IsPositiveInfinity(num)))
		{
			wrapPanel._ignorePropertyChange = true;
			wrapPanel.SetValue(e.Property, (double)e.OldValue);
			string message = string.Format(CultureInfo.InvariantCulture, Microsoft.Phone.Controls.Properties.Resources.WrapPanel_OnItemHeightOrWidthPropertyChanged_InvalidValue, num);
			throw new ArgumentException(message, "value");
		}
		wrapPanel.InvalidateMeasure();
	}

	protected override Size MeasureOverride(Size constraint)
	{
		Orientation orientation = Orientation;
		OrientedSize orientedSize = new OrientedSize(orientation);
		OrientedSize orientedSize2 = new OrientedSize(orientation);
		OrientedSize orientedSize3 = new OrientedSize(orientation, constraint.Width, constraint.Height);
		double itemWidth = ItemWidth;
		double itemHeight = ItemHeight;
		bool flag = !itemWidth.IsNaN();
		bool flag2 = !itemHeight.IsNaN();
		Size availableSize = new Size(flag ? itemWidth : constraint.Width, flag2 ? itemHeight : constraint.Height);
		foreach (UIElement child in base.Children)
		{
			child.Measure(availableSize);
			OrientedSize orientedSize4 = new OrientedSize(orientation, flag ? itemWidth : child.DesiredSize.Width, flag2 ? itemHeight : child.DesiredSize.Height);
			if (NumericExtensions.IsGreaterThan(orientedSize.Direct + orientedSize4.Direct, orientedSize3.Direct))
			{
				orientedSize2.Direct = Math.Max(orientedSize.Direct, orientedSize2.Direct);
				orientedSize2.Indirect += orientedSize.Indirect;
				orientedSize = orientedSize4;
				if (NumericExtensions.IsGreaterThan(orientedSize4.Direct, orientedSize3.Direct))
				{
					orientedSize2.Direct = Math.Max(orientedSize4.Direct, orientedSize2.Direct);
					orientedSize2.Indirect += orientedSize4.Indirect;
					orientedSize = new OrientedSize(orientation);
				}
			}
			else
			{
				orientedSize.Direct += orientedSize4.Direct;
				orientedSize.Indirect = Math.Max(orientedSize.Indirect, orientedSize4.Indirect);
			}
		}
		orientedSize2.Direct = Math.Max(orientedSize.Direct, orientedSize2.Direct);
		orientedSize2.Indirect += orientedSize.Indirect;
		return new Size(orientedSize2.Width, orientedSize2.Height);
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		Orientation orientation = Orientation;
		OrientedSize orientedSize = new OrientedSize(orientation);
		OrientedSize orientedSize2 = new OrientedSize(orientation, finalSize.Width, finalSize.Height);
		double itemWidth = ItemWidth;
		double itemHeight = ItemHeight;
		bool flag = !itemWidth.IsNaN();
		bool flag2 = !itemHeight.IsNaN();
		double num = 0.0;
		double? directDelta = ((orientation != Orientation.Horizontal) ? (flag2 ? new double?(itemHeight) : ((double?)null)) : (flag ? new double?(itemWidth) : ((double?)null)));
		UIElementCollection children = base.Children;
		int count = children.Count;
		int num2 = 0;
		for (int i = 0; i < count; i++)
		{
			UIElement uIElement = children[i];
			OrientedSize orientedSize3 = new OrientedSize(orientation, flag ? itemWidth : uIElement.DesiredSize.Width, flag2 ? itemHeight : uIElement.DesiredSize.Height);
			if (NumericExtensions.IsGreaterThan(orientedSize.Direct + orientedSize3.Direct, orientedSize2.Direct))
			{
				ArrangeLine(num2, i, directDelta, num, orientedSize.Indirect);
				num += orientedSize.Indirect;
				orientedSize = orientedSize3;
				if (NumericExtensions.IsGreaterThan(orientedSize3.Direct, orientedSize2.Direct))
				{
					ArrangeLine(i, ++i, directDelta, num, orientedSize3.Indirect);
					num += orientedSize.Indirect;
					orientedSize = new OrientedSize(orientation);
				}
				num2 = i;
			}
			else
			{
				orientedSize.Direct += orientedSize3.Direct;
				orientedSize.Indirect = Math.Max(orientedSize.Indirect, orientedSize3.Indirect);
			}
		}
		if (num2 < count)
		{
			ArrangeLine(num2, count, directDelta, num, orientedSize.Indirect);
		}
		return finalSize;
	}

	private void ArrangeLine(int lineStart, int lineEnd, double? directDelta, double indirectOffset, double indirectGrowth)
	{
		double num = 0.0;
		Orientation orientation = Orientation;
		bool flag = orientation == Orientation.Horizontal;
		UIElementCollection children = base.Children;
		for (int i = lineStart; i < lineEnd; i++)
		{
			UIElement uIElement = children[i];
			OrientedSize orientedSize = new OrientedSize(orientation, uIElement.DesiredSize.Width, uIElement.DesiredSize.Height);
			double num2 = (directDelta.HasValue ? directDelta.Value : orientedSize.Direct);
			Rect finalRect = (flag ? new Rect(num, indirectOffset, num2, indirectGrowth) : new Rect(indirectOffset, num, indirectGrowth, num2));
			uIElement.Arrange(finalRect);
			num += num2;
		}
	}
}
