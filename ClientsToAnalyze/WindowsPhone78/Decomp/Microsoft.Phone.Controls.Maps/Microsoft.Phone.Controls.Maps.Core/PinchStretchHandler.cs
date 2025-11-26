using System;
using System.Linq;
using System.Windows;

namespace Microsoft.Phone.Controls.Maps.Core;

internal class PinchStretchHandler
{
	private bool inProgress;

	private Point[] lastKnownPoints = new Point[2];

	private ushort minimumUpdateThreshold = 3;

	private Point[] trackingPoints = new Point[2];

	private UIElement root;

	private bool isEnabled;

	public event EventHandler<PinchStretchEventArgs> PinchStretchReported;

	public PinchStretchHandler(UIElement element)
	{
		if (element == null)
		{
			throw new ArgumentNullException("element");
		}
		root = element;
	}

	public void Enable(bool enable)
	{
		if (enable && !isEnabled)
		{
			TouchHelper.AddHandlers(root, new TouchHandlers
			{
				TouchDown = delegate(object o, TouchEventArgs e)
				{
					e.TouchPoint.TouchDevice.Capture(root);
				},
				CapturedTouchUp = delegate
				{
					Reset();
				},
				CapturedTouchReported = OnCapturedTouchReported
			});
			isEnabled = true;
		}
		else if (!enable && isEnabled)
		{
			TouchHelper.RemoveHandlers(root);
			isEnabled = false;
		}
	}

	private void Reset()
	{
		inProgress = false;
		trackingPoints = new Point[2];
		lastKnownPoints = new Point[2];
	}

	private void OnCapturedTouchReported(object sender, TouchReportedEventArgs e)
	{
		if (e.TouchPoints.Count() == 2)
		{
			RecordPoints(e.TouchPoints.ElementAt(0), e.TouchPoints.ElementAt(1));
			inProgress = true;
		}
	}

	private void RecordPoints(Point p1, Point p2)
	{
		trackingPoints[0] = p1;
		trackingPoints[1] = p2;
		if (!inProgress)
		{
			lastKnownPoints[0] = p1;
			lastKnownPoints[1] = p2;
		}
		Point point = PhysicsHelper.Delta(trackingPoints[0], lastKnownPoints[0]);
		Point point2 = PhysicsHelper.Delta(trackingPoints[1], lastKnownPoints[1]);
		if (!inProgress || PhysicsHelper.ExceedsThreshold(point, minimumUpdateThreshold) || PhysicsHelper.ExceedsThreshold(point2, minimumUpdateThreshold))
		{
			PinchStretchData data = new PinchStretchData
			{
				ContactPoint1 = trackingPoints[0],
				ContactPoint2 = trackingPoints[1],
				ContactPoint1Delta = point,
				ContactPoint2Delta = point2
			};
			Point p3 = PhysicsHelper.Center(lastKnownPoints[0], lastKnownPoints[1]);
			Point p4 = (data.CenterPoint = PhysicsHelper.Center(trackingPoints[0], trackingPoints[1]));
			data.CenterPointDelta = PhysicsHelper.Delta(p4, p3);
			double num = PhysicsHelper.Distance(lastKnownPoints[0], lastKnownPoints[1]);
			double num2 = PhysicsHelper.Distance(trackingPoints[0], trackingPoints[1]);
			data.Scale = num2 / num;
			ref Point reference = ref lastKnownPoints[0];
			reference = trackingPoints[0];
			ref Point reference2 = ref lastKnownPoints[1];
			reference2 = trackingPoints[1];
			FirePinchStretchReported(data);
		}
	}

	private void FirePinchStretchReported(PinchStretchData data)
	{
		this.PinchStretchReported?.Invoke(this, new PinchStretchEventArgs(data));
	}
}
