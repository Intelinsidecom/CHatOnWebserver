using System;
using System.Windows;
using System.Windows.Data;
using System.Windows.Media;

namespace Microsoft.Phone.Controls;

internal static class Extensions
{
	private const string ExternalAddress = "app://external/";

	public static bool Invert(this Matrix m, out Matrix outputMatrix)
	{
		double num = m.M11 * m.M22 - m.M12 * m.M21;
		if (num == 0.0)
		{
			outputMatrix = m;
			return false;
		}
		Matrix matrix = m;
		m.M11 = matrix.M22 / num;
		m.M12 = -1.0 * matrix.M12 / num;
		m.M21 = -1.0 * matrix.M21 / num;
		m.M22 = matrix.M11 / num;
		m.OffsetX = (matrix.OffsetY * matrix.M21 - matrix.OffsetX * matrix.M22) / num;
		m.OffsetY = (matrix.OffsetX * matrix.M12 - matrix.OffsetY * matrix.M11) / num;
		outputMatrix = m;
		return true;
	}

	public static bool Contains(this string s, string value, StringComparison comparison)
	{
		return s.IndexOf(value, comparison) >= 0;
	}

	public static bool IsPortrait(this PageOrientation orientation)
	{
		//IL_0002: Unknown result type (might be due to invalid IL or missing references)
		//IL_0003: Unknown result type (might be due to invalid IL or missing references)
		//IL_0004: Invalid comparison between I4 and Unknown
		return 1 == (1 & orientation);
	}

	public static bool IsDarkThemeActive(this ResourceDictionary resources)
	{
		return (Visibility)resources["PhoneDarkThemeVisibility"] == Visibility.Visible;
	}

	public static bool IsExternalNavigation(this Uri uri)
	{
		return "app://external/" == uri.ToString();
	}

	public static void RegisterNotification(this FrameworkElement element, string propertyName, PropertyChangedCallback callback)
	{
		DependencyProperty dp = DependencyProperty.RegisterAttached("Notification" + propertyName, typeof(object), typeof(FrameworkElement), new PropertyMetadata(callback));
		element.SetBinding(dp, new Binding(propertyName)
		{
			Source = element
		});
	}
}
