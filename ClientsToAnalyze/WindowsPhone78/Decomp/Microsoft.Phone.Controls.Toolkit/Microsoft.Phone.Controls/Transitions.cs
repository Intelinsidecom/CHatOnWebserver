using System;
using System.Collections.Generic;
using System.IO;
using System.Windows;
using System.Windows.Markup;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Resources;

namespace Microsoft.Phone.Controls;

internal static class Transitions
{
	private static Dictionary<string, string> _storyboardXamlCache;

	private static ITransition GetEnumStoryboard<T>(UIElement element, string name, T mode)
	{
		string name2 = name + Enum.GetName(typeof(T), mode);
		Storyboard storyboard = GetStoryboard(name2);
		if (storyboard == null)
		{
			return null;
		}
		Storyboard.SetTarget(storyboard, element);
		return new Transition(element, storyboard);
	}

	private static Storyboard GetStoryboard(string name)
	{
		if (_storyboardXamlCache == null)
		{
			_storyboardXamlCache = new Dictionary<string, string>();
		}
		string text = null;
		if (_storyboardXamlCache.ContainsKey(name))
		{
			text = _storyboardXamlCache[name];
		}
		else
		{
			string uriString = "/Microsoft.Phone.Controls.Toolkit;component/Transitions/Storyboards/" + name + ".xaml";
			Uri uriResource = new Uri(uriString, UriKind.Relative);
			StreamResourceInfo resourceStream = Application.GetResourceStream(uriResource);
			using StreamReader streamReader = new StreamReader(resourceStream.Stream);
			text = streamReader.ReadToEnd();
			_storyboardXamlCache[name] = text;
		}
		return XamlReader.Load(text) as Storyboard;
	}

	public static ITransition Roll(UIElement element)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		Storyboard storyboard = GetStoryboard("Roll");
		Storyboard.SetTarget(storyboard, element);
		element.Projection = new PlaneProjection
		{
			CenterOfRotationX = 0.5,
			CenterOfRotationY = 0.5
		};
		return new Transition(element, storyboard);
	}

	public static ITransition Rotate(UIElement element, RotateTransitionMode rotateTransitionMode)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		if (!Enum.IsDefined(typeof(RotateTransitionMode), rotateTransitionMode))
		{
			throw new ArgumentOutOfRangeException("rotateTransitionMode");
		}
		element.Projection = new PlaneProjection
		{
			CenterOfRotationX = 0.5,
			CenterOfRotationY = 0.5
		};
		return GetEnumStoryboard(element, "Rotate", rotateTransitionMode);
	}

	public static ITransition Slide(UIElement element, SlideTransitionMode slideTransitionMode)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		if (!Enum.IsDefined(typeof(SlideTransitionMode), slideTransitionMode))
		{
			throw new ArgumentOutOfRangeException("slideTransitionMode");
		}
		element.RenderTransform = new TranslateTransform();
		return GetEnumStoryboard(element, string.Empty, slideTransitionMode);
	}

	public static ITransition Swivel(UIElement element, SwivelTransitionMode swivelTransitionMode)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		if (!Enum.IsDefined(typeof(SwivelTransitionMode), swivelTransitionMode))
		{
			throw new ArgumentOutOfRangeException("swivelTransitionMode");
		}
		element.Projection = new PlaneProjection();
		return GetEnumStoryboard(element, "Swivel", swivelTransitionMode);
	}

	public static ITransition Turnstile(UIElement element, TurnstileTransitionMode turnstileTransitionMode)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		if (!Enum.IsDefined(typeof(TurnstileTransitionMode), turnstileTransitionMode))
		{
			throw new ArgumentOutOfRangeException("turnstileTransitionMode");
		}
		element.Projection = new PlaneProjection
		{
			CenterOfRotationX = 0.0
		};
		return GetEnumStoryboard(element, "Turnstile", turnstileTransitionMode);
	}
}
