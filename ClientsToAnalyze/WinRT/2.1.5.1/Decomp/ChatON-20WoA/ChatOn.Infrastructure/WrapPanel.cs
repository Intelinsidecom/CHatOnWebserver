using System;
using System.Collections.Generic;
using Windows.Foundation;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;

namespace ChatOn.Infrastructure;

public class WrapPanel : Panel
{
	private bool _ignorePropertyChange;

	public static readonly DependencyProperty ItemHeightProperty = DependencyProperty.Register("ItemHeight", typeof(double), typeof(WrapPanel), new PropertyMetadata((object)double.NaN, new PropertyChangedCallback(OnItemHeightOrWidthPropertyChanged)));

	public static readonly DependencyProperty ItemWidthProperty = DependencyProperty.Register("ItemWidth", typeof(double), typeof(WrapPanel), new PropertyMetadata((object)double.NaN, new PropertyChangedCallback(OnItemHeightOrWidthPropertyChanged)));

	public static readonly DependencyProperty OrientationProperty = DependencyProperty.Register("Orientation", typeof(Orientation), typeof(WrapPanel), new PropertyMetadata((object)(Orientation)1, new PropertyChangedCallback(OnOrientationPropertyChanged)));

	public double ItemHeight
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(ItemHeightProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ItemHeightProperty, (object)value);
		}
	}

	public double ItemWidth
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(ItemWidthProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ItemWidthProperty, (object)value);
		}
	}

	public Orientation Orientation
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			return (Orientation)((DependencyObject)this).GetValue(OrientationProperty);
		}
		set
		{
			//IL_0006: Unknown result type (might be due to invalid IL or missing references)
			((DependencyObject)this).SetValue(OrientationProperty, (object)value);
		}
	}

	private static void OnOrientationPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		//IL_000d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0012: Unknown result type (might be due to invalid IL or missing references)
		//IL_0023: Unknown result type (might be due to invalid IL or missing references)
		//IL_0025: Invalid comparison between Unknown and I4
		//IL_0027: Unknown result type (might be due to invalid IL or missing references)
		//IL_003d: Unknown result type (might be due to invalid IL or missing references)
		WrapPanel wrapPanel = (WrapPanel)(object)d;
		Orientation val = (Orientation)e.NewValue;
		if (wrapPanel._ignorePropertyChange)
		{
			wrapPanel._ignorePropertyChange = false;
			return;
		}
		if ((int)val != 1 && (int)val != 0)
		{
			wrapPanel._ignorePropertyChange = true;
			((DependencyObject)wrapPanel).SetValue(OrientationProperty, (object)(Orientation)e.OldValue);
		}
		((UIElement)wrapPanel).InvalidateMeasure();
	}

	private static void OnItemHeightOrWidthPropertyChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		WrapPanel wrapPanel = (WrapPanel)(object)d;
		double num = (double)e.NewValue;
		if (wrapPanel._ignorePropertyChange)
		{
			wrapPanel._ignorePropertyChange = false;
			return;
		}
		if (!double.IsNaN(num) && (num <= 0.0 || double.IsPositiveInfinity(num)))
		{
			wrapPanel._ignorePropertyChange = true;
			((DependencyObject)wrapPanel).SetValue(e.Property, (object)(double)e.OldValue);
		}
		((UIElement)wrapPanel).InvalidateMeasure();
	}

	protected override Size MeasureOverride(Size constraint)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Unknown result type (might be due to invalid IL or missing references)
		//IL_0019: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a6: Unknown result type (might be due to invalid IL or missing references)
		//IL_017b: Unknown result type (might be due to invalid IL or missing references)
		Orientation orientation = Orientation;
		OrientedSize orientedSize = new OrientedSize(orientation);
		OrientedSize orientedSize2 = new OrientedSize(orientation);
		OrientedSize orientedSize3 = new OrientedSize(orientation, constraint.Width, constraint.Height);
		double itemWidth = ItemWidth;
		double itemHeight = ItemHeight;
		bool flag = !double.IsNaN(itemWidth);
		bool flag2 = !double.IsNaN(itemHeight);
		Size size = new Size(flag ? itemWidth : constraint.Width, flag2 ? itemHeight : constraint.Height);
		int num = 0;
		int num2 = 0;
		foreach (UIElement item in (IEnumerable<UIElement>)((Panel)this).Children)
		{
			item.Measure(size);
			OrientedSize orientedSize4 = new OrientedSize(orientation, flag ? itemWidth : item.DesiredSize.Width, flag2 ? itemHeight : item.DesiredSize.Height);
			if (NumericExtensions.IsGreaterThan(orientedSize.Direct + orientedSize4.Direct, orientedSize3.Direct))
			{
				num2++;
				num = 0;
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
				num++;
			}
			if (((FrameworkElement)((item is FrameworkElement) ? item : null)).DataContext is IVariableSizedWrapGridItem variableSizedWrapGridItem)
			{
				variableSizedWrapGridItem.ColSpan = num2;
				variableSizedWrapGridItem.RowSpan = num;
			}
		}
		orientedSize2.Direct = Math.Max(orientedSize.Direct, orientedSize2.Direct);
		orientedSize2.Indirect += orientedSize.Indirect;
		return new Size(orientedSize2.Width, orientedSize2.Height);
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Unknown result type (might be due to invalid IL or missing references)
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0058: Invalid comparison between Unknown and I4
		//IL_00b4: Unknown result type (might be due to invalid IL or missing references)
		//IL_0167: Unknown result type (might be due to invalid IL or missing references)
		Orientation orientation = Orientation;
		OrientedSize orientedSize = new OrientedSize(orientation);
		OrientedSize orientedSize2 = new OrientedSize(orientation, finalSize.Width, finalSize.Height);
		double itemWidth = ItemWidth;
		double itemHeight = ItemHeight;
		bool flag = !double.IsNaN(itemWidth);
		bool flag2 = !double.IsNaN(itemHeight);
		double num = 0.0;
		double? directDelta = (((int)orientation != 1) ? (flag2 ? new double?(itemHeight) : ((double?)null)) : (flag ? new double?(itemWidth) : ((double?)null)));
		UIElementCollection children = ((Panel)this).Children;
		int count = ((ICollection<UIElement>)children).Count;
		int num2 = 0;
		for (int i = 0; i < count; i++)
		{
			UIElement val = ((IList<UIElement>)children)[i];
			OrientedSize orientedSize3 = new OrientedSize(orientation, flag ? itemWidth : val.DesiredSize.Width, flag2 ? itemHeight : val.DesiredSize.Height);
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
		//IL_000b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Invalid comparison between Unknown and I4
		//IL_0031: Unknown result type (might be due to invalid IL or missing references)
		double num = 0.0;
		Orientation orientation = Orientation;
		bool flag = (int)orientation == 1;
		UIElementCollection children = ((Panel)this).Children;
		for (int i = lineStart; i < lineEnd; i++)
		{
			UIElement val = ((IList<UIElement>)children)[i];
			OrientedSize orientedSize = new OrientedSize(orientation, val.DesiredSize.Width, val.DesiredSize.Height);
			double num2 = (directDelta.HasValue ? directDelta.Value : orientedSize.Direct);
			Rect rect = (flag ? new Rect(num, indirectOffset, num2, indirectGrowth) : new Rect(indirectOffset, num, indirectGrowth, num2));
			val.Arrange(rect);
			num += num2;
		}
	}
}
