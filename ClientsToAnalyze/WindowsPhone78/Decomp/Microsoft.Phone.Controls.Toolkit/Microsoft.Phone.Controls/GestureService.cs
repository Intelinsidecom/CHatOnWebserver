using System;
using System.Windows;

namespace Microsoft.Phone.Controls;

public static class GestureService
{
	public static readonly DependencyProperty GestureListenerProperty = DependencyProperty.RegisterAttached("GestureListener", typeof(GestureListener), typeof(GestureService), new PropertyMetadata(null));

	public static GestureListener GetGestureListener(DependencyObject obj)
	{
		if (obj == null)
		{
			throw new ArgumentNullException("obj");
		}
		return GetGestureListenerInternal(obj, createIfMissing: true);
	}

	internal static GestureListener GetGestureListenerInternal(DependencyObject obj, bool createIfMissing)
	{
		GestureListener gestureListener = (GestureListener)obj.GetValue(GestureListenerProperty);
		if (gestureListener == null && createIfMissing)
		{
			gestureListener = new GestureListener();
			SetGestureListenerInternal(obj, gestureListener);
		}
		return gestureListener;
	}

	[Obsolete("Do not add handlers using this method. Instead, use GetGestureListener, which will create a new instance if one is not already set, to add your handlers to an element.", true)]
	public static void SetGestureListener(DependencyObject obj, GestureListener value)
	{
		if (obj == null)
		{
			throw new ArgumentNullException("obj");
		}
		SetGestureListenerInternal(obj, value);
	}

	private static void SetGestureListenerInternal(DependencyObject obj, GestureListener value)
	{
		obj.SetValue(GestureListenerProperty, value);
	}
}
