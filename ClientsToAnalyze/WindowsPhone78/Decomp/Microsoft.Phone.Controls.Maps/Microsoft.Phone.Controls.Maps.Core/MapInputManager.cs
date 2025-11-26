using System;
using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class MapInputManager
{
	private readonly MapCore parentMap;

	private ManipulationHandler manipulationProcessor;

	private PinchStretchHandler pinchStretchRecognizer;

	internal event EventHandler<MapDragEventArgs> TouchDrag;

	internal event EventHandler<MapFlickEventArgs> TouchFlick;

	internal event EventHandler<MapZoomEventArgs> TouchZoom;

	internal MapInputManager(MapCore map)
	{
		parentMap = map;
		MapCore mapCore = parentMap;
		RoutedEventHandler value = delegate
		{
			pinchStretchRecognizer.Enable(enable: true);
		};
		mapCore.Loaded += value;
		parentMap.Unloaded += delegate
		{
			pinchStretchRecognizer.Enable(enable: false);
			if (manipulationProcessor != null)
			{
				manipulationProcessor.Unload();
			}
		};
		Initialize();
	}

	private void Initialize()
	{
		manipulationProcessor = new ManipulationHandler(parentMap);
		manipulationProcessor.DoubleTap += OnDoubleTap;
		manipulationProcessor.Pan += OnPan;
		manipulationProcessor.Flick += OnFlick;
		pinchStretchRecognizer = new PinchStretchHandler(parentMap);
		pinchStretchRecognizer.PinchStretchReported += PinchStretchReported;
	}

	internal void OnDoubleTap(object sender, GestureEventArgs e)
	{
		DoubleTapGestureEventArgs e2 = e as DoubleTapGestureEventArgs;
		_ = e2.Origin;
		OnTouchZoom(new MapZoomEventArgs(e.Origin, 1.0));
	}

	internal void OnPan(object sender, GestureEventArgs e)
	{
		PanGestureEventArgs e2 = e as PanGestureEventArgs;
		Point origin = e2.Origin;
		Point translation = e2.Translation;
		OnTouchDrag(new MapDragEventArgs(origin, translation));
	}

	internal void OnFlick(object sender, GestureEventArgs e)
	{
		FlickGestureEventArgs e2 = e as FlickGestureEventArgs;
		Point origin = e2.Origin;
		Point velocity = e2.Velocity;
		OnTouchFlick(new MapFlickEventArgs(origin, velocity));
	}

	internal void OnScale(object sender, GestureEventArgs e)
	{
		ScaleGestureEventArgs e2 = e as ScaleGestureEventArgs;
		Point origin = e2.Origin;
		double num = 1.0;
		num = ((e2.Scale.X == 1.0) ? e2.Scale.Y : ((e2.Scale.Y != 1.0) ? ((e2.Scale.X + e2.Scale.Y) / 2.0) : e2.Scale.Y));
		num = Math.Log(num) / Math.Log(2.0);
		OnTouchZoom(new MapZoomEventArgs(origin, num));
	}

	internal void PinchStretchReported(object sender, PinchStretchEventArgs e)
	{
		PinchStretchData data = e.Data;
		double zoomDelta = Math.Log(data.Scale) / Math.Log(2.0);
		OnTouchZoom(new MapZoomEventArgs(data.CenterPoint, zoomDelta));
	}

	internal void OnTouchDrag(MapDragEventArgs ea)
	{
		this.TouchDrag?.Invoke(parentMap, ea);
		if (!ea.Handled)
		{
			parentMap.Mode.OnMapDrag(ea);
		}
	}

	internal void OnTouchFlick(MapFlickEventArgs ea)
	{
		this.TouchFlick?.Invoke(parentMap, ea);
		if (!ea.Handled)
		{
			parentMap.Mode.OnMapFlick(ea);
		}
	}

	internal void OnTouchZoom(MapZoomEventArgs ea)
	{
		this.TouchZoom?.Invoke(parentMap, ea);
		if (!ea.Handled)
		{
			parentMap.Mode.OnMapZoom(ea);
		}
	}
}
