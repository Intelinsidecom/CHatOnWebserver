using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics.CodeAnalysis;
using System.Diagnostics.Contracts;
using System.Globalization;
using System.IO;
using System.Windows;
using System.Windows.Resources;

namespace ImageTools.Helpers;

public static class Extensions
{
	public static readonly Rect ZeroRect = new Rect(0.0, 0.0, 0.0, 0.0);

	public static Stream GetLocalResourceStream(Uri uri)
	{
		Contract.Requires<ArgumentNullException>(uri != null, "Uri cannot be null.");
		StreamResourceInfo resourceStream = Application.GetResourceStream(uri);
		if (resourceStream == null)
		{
			Application current = Application.Current;
			if (current != null)
			{
				Type type = current.GetType();
				string text = type.Assembly.FullName.Split(',')[0];
				string originalString = uri.OriginalString;
				originalString = string.Format(CultureInfo.CurrentCulture, "{0};component/{1}", text, originalString);
				originalString = originalString.Replace("\\", "/");
				originalString = originalString.Replace("//", "/");
				Uri uriResource = new Uri(originalString, UriKind.Relative);
				resourceStream = Application.GetResourceStream(uriResource);
			}
		}
		return resourceStream?.Stream;
	}

	public static Rectangle Multiply(Rectangle rectangle, double factor)
	{
		rectangle.X = (int)((double)rectangle.X * factor);
		rectangle.Y = (int)((double)rectangle.Y * factor);
		rectangle.Width = (int)((double)rectangle.Width * factor);
		rectangle.Height = (int)((double)rectangle.Height * factor);
		return rectangle;
	}

	public static Rect Multiply(Rect rectangle, double factor)
	{
		rectangle.X *= factor;
		rectangle.Y *= factor;
		rectangle.Width *= factor;
		rectangle.Height *= factor;
		return rectangle;
	}

	public static bool IsNumber(this double value)
	{
		return !double.IsInfinity(value) && !double.IsNaN(value);
	}

	public static bool IsNumber(this float value)
	{
		return !float.IsInfinity(value) && !float.IsNaN(value);
	}

	public static void Foreach<T>(this IEnumerable<T> items, Action<T> action)
	{
		Contract.Requires<ArgumentNullException>(items != null, "Items cannot be null");
		Contract.Requires<ArgumentNullException>(action != null, "Action cannot be null.");
		foreach (T item in items)
		{
			if (item != null)
			{
				action(item);
			}
		}
	}

	public static void Foreach(this IEnumerable items, Action<object> action)
	{
		Contract.Requires<ArgumentNullException>(items != null, "Items cannot be null");
		Contract.Requires<ArgumentNullException>(action != null, "Action cannot be null.");
		foreach (object item in items)
		{
			if (item != null)
			{
				action(item);
			}
		}
	}

	public static void AddRange<TItem>(this ObservableCollection<TItem> target, IEnumerable<TItem> elements)
	{
		Contract.Requires<ArgumentNullException>(target != null, "Target cannot be null");
		Contract.Requires<ArgumentNullException>(elements != null, "Elements cannot be null.");
		foreach (TItem element in elements)
		{
			target.Add(element);
		}
	}

	public static void AddRange<TItem>(this Collection<TItem> target, IEnumerable<TItem> elements)
	{
		Contract.Requires<ArgumentNullException>(target != null, "Target cannot be null");
		Contract.Requires<ArgumentNullException>(elements != null, "Elements cannot be null.");
		foreach (TItem element in elements)
		{
			target.Add(element);
		}
	}

	public static bool IsBetween<TValue>(this TValue value, TValue low, TValue high) where TValue : IComparable
	{
		return Comparer<TValue>.Default.Compare(low, value) <= 0 && Comparer<TValue>.Default.Compare(high, value) >= 0;
	}

	public static TValue RemainBetween<TValue>(this TValue value, TValue low, TValue high) where TValue : IComparable
	{
		TValue result = value;
		if (Comparer<TValue>.Default.Compare(high, low) < 0)
		{
			result = low;
		}
		else if (Comparer<TValue>.Default.Compare(value, low) <= 0)
		{
			result = low;
		}
		else if (Comparer<TValue>.Default.Compare(value, high) >= 0)
		{
			result = high;
		}
		return result;
	}

	[SuppressMessage("Microsoft.Design", "CA1045:DoNotPassTypesByReference")]
	public static void Swap<TRef>(ref TRef lhs, ref TRef rhs) where TRef : class
	{
		TRef val = lhs;
		lhs = rhs;
		rhs = val;
	}
}
