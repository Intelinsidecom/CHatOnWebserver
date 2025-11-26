using System.Windows;
using System.Windows.Media;

namespace Microsoft.Phone.Controls.Primitives;

public class ClipToBounds : DependencyObject
{
	public static readonly DependencyProperty IsEnabledProperty = DependencyProperty.RegisterAttached("IsEnabled", typeof(bool), typeof(ClipToBounds), new PropertyMetadata(false, OnIsEnabledPropertyChanged));

	public static bool GetIsEnabled(DependencyObject obj)
	{
		return (bool)obj.GetValue(IsEnabledProperty);
	}

	public static void SetIsEnabled(DependencyObject obj, bool value)
	{
		obj.SetValue(IsEnabledProperty, value);
	}

	private static void OnIsEnabledPropertyChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		if (obj is FrameworkElement frameworkElement)
		{
			if ((bool)e.NewValue)
			{
				frameworkElement.SizeChanged += OnSizeChanged;
			}
			else
			{
				frameworkElement.SizeChanged -= OnSizeChanged;
			}
		}
	}

	private static void OnSizeChanged(object sender, SizeChangedEventArgs e)
	{
		if (sender is FrameworkElement frameworkElement)
		{
			RectangleGeometry rectangleGeometry = new RectangleGeometry();
			rectangleGeometry.Rect = new Rect(0.0, 0.0, frameworkElement.ActualWidth, frameworkElement.ActualHeight);
			frameworkElement.Clip = rectangleGeometry;
		}
	}
}
