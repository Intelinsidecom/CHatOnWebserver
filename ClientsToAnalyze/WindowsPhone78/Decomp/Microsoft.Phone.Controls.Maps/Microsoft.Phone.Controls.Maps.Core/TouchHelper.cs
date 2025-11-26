using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Windows;
using System.Windows.Input;
using System.Windows.Media;

namespace Microsoft.Phone.Controls.Maps.Core;

internal static class TouchHelper
{
	private static bool isEnabled;

	private static readonly Dictionary<UIElement, TouchHandlers> currentHandlers = new Dictionary<UIElement, TouchHandlers>();

	private static readonly Dictionary<int, UIElement> currentCaptures = new Dictionary<int, UIElement>();

	private static readonly Dictionary<int, TouchPoint> currentTouchPoints = new Dictionary<int, TouchPoint>();

	public static bool AreAnyTouches => currentTouchPoints.Count != 0;

	public static bool Capture(this TouchDevice touchDevice, UIElement element)
	{
		if (touchDevice == null)
		{
			throw new ArgumentNullException("element");
		}
		if (currentCaptures.TryGetValue(touchDevice.Id, out var value) && !object.ReferenceEquals(value, element) && currentHandlers.TryGetValue(value, out var value2))
		{
			EventHandler<TouchEventArgs> lostTouchCapture = value2.LostTouchCapture;
			if (lostTouchCapture != null && currentTouchPoints.TryGetValue(touchDevice.Id, out var value3))
			{
				lostTouchCapture(value, new TouchEventArgs(value3));
			}
		}
		if (element != null)
		{
			currentCaptures[touchDevice.Id] = element;
		}
		else
		{
			currentCaptures.Remove(touchDevice.Id);
		}
		return true;
	}

	public static void AddHandlers(UIElement element, TouchHandlers handlers)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		if (handlers == null)
		{
			throw new ArgumentNullException("handlers");
		}
		currentHandlers[element] = handlers;
		EnableInput(enable: true);
	}

	public static void RemoveHandlers(UIElement element)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		currentHandlers.Remove(element);
		if (currentHandlers.Count == 0)
		{
			EnableInput(enable: false);
		}
	}

	private static void EnableInput(bool enable)
	{
		if (enable)
		{
			if (!isEnabled)
			{
				EnableInput();
				isEnabled = true;
			}
		}
		else if (isEnabled)
		{
			DisableInput();
			isEnabled = false;
		}
	}

	private static void EnableInput()
	{
		Touch.FrameReported += TouchFrameReported;
	}

	private static void DisableInput()
	{
		Touch.FrameReported -= TouchFrameReported;
		currentCaptures.Clear();
		currentHandlers.Clear();
		currentTouchPoints.Clear();
	}

	private static void TouchFrameReported(object sender, TouchFrameEventArgs e)
	{
		UIElement rootVisual = Application.Current.RootVisual;
		if (rootVisual == null)
		{
			return;
		}
		Collection<int> collection = new Collection<int>();
		foreach (TouchPoint touchPoint in e.GetTouchPoints(rootVisual))
		{
			int id = touchPoint.TouchDevice.Id;
			collection.Add(id);
			switch (touchPoint.Action)
			{
			case TouchAction.Down:
				HitTestAndRaiseDownEvent(rootVisual, touchPoint);
				currentTouchPoints[id] = touchPoint;
				break;
			case TouchAction.Up:
			{
				currentCaptures.TryGetValue(id, out var value);
				if (value != null)
				{
					RaiseUpEvent(value, touchPoint);
					touchPoint.TouchDevice.Capture(null);
					value = null;
				}
				currentTouchPoints.Remove(id);
				break;
			}
			case TouchAction.Move:
				currentTouchPoints[id] = touchPoint;
				break;
			}
		}
		Collection<int> collection2 = new Collection<int>();
		foreach (int key in currentTouchPoints.Keys)
		{
			if (!collection.Contains(key))
			{
				collection2.Add(key);
			}
		}
		foreach (int item in collection2)
		{
			currentTouchPoints.Remove(item);
		}
		if (currentTouchPoints.Count == 0)
		{
			currentCaptures.Clear();
		}
		RaiseCapturedReportEvent(rootVisual);
	}

	private static void RaiseCapturedReportEvent(UIElement root)
	{
		foreach (KeyValuePair<UIElement, TouchHandlers> currentHandler in currentHandlers)
		{
			EventHandler<TouchReportedEventArgs> capturedTouchReported = currentHandler.Value.CapturedTouchReported;
			if (capturedTouchReported == null)
			{
				continue;
			}
			UIElement key = currentHandler.Key;
			if (key == null)
			{
				continue;
			}
			GeneralTransform generalTransform;
			try
			{
				generalTransform = root.TransformToVisual(key);
			}
			catch (ArgumentException)
			{
				continue;
			}
			List<Point> list = new List<Point>();
			foreach (KeyValuePair<int, UIElement> currentCapture in currentCaptures)
			{
				if (object.ReferenceEquals(currentCapture.Value, currentHandler.Key) && currentTouchPoints.TryGetValue(currentCapture.Key, out var value))
				{
					list.Add(generalTransform.Transform(value.Position));
				}
			}
			capturedTouchReported(currentHandler.Key, new TouchReportedEventArgs(list));
		}
	}

	private static void HitTestAndRaiseDownEvent(UIElement root, TouchPoint touchPoint)
	{
		Point position = root.TransformToVisual(null).Transform(touchPoint.Position);
		foreach (UIElement item in InputHitTest(root, position))
		{
			if (currentHandlers.TryGetValue(item, out var value))
			{
				EventHandler<TouchEventArgs> touchDown = value.TouchDown;
				if (touchDown != null)
				{
					touchDown(item, new TouchEventArgs(touchPoint));
					break;
				}
			}
		}
	}

	private static IEnumerable<UIElement> InputHitTest(UIElement root, Point position)
	{
		foreach (UIElement element in VisualTreeHelper.FindElementsInHostCoordinates(position, root))
		{
			yield return element;
			for (UIElement parent = VisualTreeHelper.GetParent(element) as UIElement; parent != null; parent = VisualTreeHelper.GetParent(parent) as UIElement)
			{
				yield return parent;
			}
		}
	}

	private static void RaiseUpEvent(UIElement element, TouchPoint touchPoint)
	{
		if (currentHandlers.TryGetValue(element, out var value))
		{
			value.CapturedTouchUp?.Invoke(element, new TouchEventArgs(touchPoint));
		}
	}
}
