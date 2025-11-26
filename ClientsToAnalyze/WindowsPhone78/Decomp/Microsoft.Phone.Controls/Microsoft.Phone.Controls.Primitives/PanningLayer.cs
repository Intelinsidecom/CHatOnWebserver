using System;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Media;
using System.Windows.Media.Animation;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Microsoft.Phone.Controls.Primitives;

[TemplatePart(Name = "LeftWraparound", Type = typeof(Rectangle))]
[TemplatePart(Name = "PanningTransform", Type = typeof(TranslateTransform))]
[TemplatePart(Name = "RightWraparound", Type = typeof(Rectangle))]
[TemplatePart(Name = "ContentPresenter", Type = typeof(ContentPresenter))]
[TemplatePart(Name = "LocalTransform", Type = typeof(TranslateTransform))]
public class PanningLayer : ContentControl
{
	private const string LocalTransformName = "LocalTransform";

	private const string PanningTransformName = "PanningTransform";

	private const string LeftWraparoundName = "LeftWraparound";

	private const string RightWraparoundName = "RightWraparound";

	private const string ContentPresenterName = "ContentPresenter";

	protected static readonly Duration Immediately = new Duration(TimeSpan.Zero);

	private readonly IEasingFunction _easingFunction = new ExponentialEase
	{
		Exponent = 5.0
	};

	private ContentPresenter contentPresenter;

	private TransformAnimator animator;

	private bool isStatic;

	protected TranslateTransform LocalTransform { get; set; }

	protected TranslateTransform PanningTransform { get; set; }

	protected Rectangle LeftWraparound { get; set; }

	protected Rectangle RightWraparound { get; set; }

	protected internal ContentPresenter ContentPresenter
	{
		get
		{
			return contentPresenter;
		}
		set
		{
			if (contentPresenter != null)
			{
				contentPresenter.SizeChanged -= OnContentSizeChanged;
			}
			contentPresenter = value;
			if (contentPresenter != null)
			{
				contentPresenter.SizeChanged += OnContentSizeChanged;
			}
		}
	}

	protected virtual double PanRate => 1.0;

	internal bool IsStatic
	{
		get
		{
			return isStatic;
		}
		set
		{
			if (value != isStatic)
			{
				isStatic = value;
				if (isStatic)
				{
					ActualOffset = 0.0;
				}
				else
				{
					UpdateWrappingRectangles();
				}
			}
		}
	}

	internal Panorama Owner { get; set; }

	internal double ActualOffset
	{
		get
		{
			if (PanningTransform == null)
			{
				return 0.0;
			}
			return PanningTransform.X;
		}
		private set
		{
			if (PanningTransform != null)
			{
				PanningTransform.X = value;
			}
		}
	}

	public PanningLayer()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_STARTUP, PerfLog.PanningLayer);
		base.DefaultStyleKey = typeof(PanningLayer);
		base.Loaded += PanningLayer_Loaded;
	}

	private void PanningLayer_Loaded(object sender, RoutedEventArgs e)
	{
		base.Loaded -= PanningLayer_Loaded;
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_STARTUP, PerfLog.PanningLayer);
	}

	public override void OnApplyTemplate()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_APPLYTEMPLATE, PerfLog.PanningLayer);
		base.OnApplyTemplate();
		LocalTransform = GetTemplateChild("LocalTransform") as TranslateTransform;
		PanningTransform = GetTemplateChild("PanningTransform") as TranslateTransform;
		LeftWraparound = GetTemplateChild("LeftWraparound") as Rectangle;
		RightWraparound = GetTemplateChild("RightWraparound") as Rectangle;
		ContentPresenter = GetTemplateChild("ContentPresenter") as ContentPresenter;
		animator = ((PanningTransform != null) ? new TransformAnimator(PanningTransform) : null);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_APPLYTEMPLATE, PerfLog.PanningLayer);
	}

	protected override Size MeasureOverride(Size availableSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_MEASURE, PerfLog.PanningLayer);
		Size result = base.MeasureOverride(availableSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_MEASURE, PerfLog.PanningLayer);
		return result;
	}

	protected override Size ArrangeOverride(Size finalSize)
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_ARRANGE, PerfLog.PanningLayer);
		Size result = base.ArrangeOverride(finalSize);
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_ARRANGE, PerfLog.PanningLayer);
		return result;
	}

	public void GoTo(int targetOffset, Duration duration, Action completionAction)
	{
		if (animator != null && !IsStatic)
		{
			animator.GoTo((int)((double)targetOffset * PanRate), duration, _easingFunction, completionAction);
		}
	}

	public virtual void Wraparound(int direction)
	{
		if (direction < 0)
		{
			GoTo((int)((ActualOffset + ContentPresenter.ActualWidth) / PanRate), Immediately, null);
		}
		else
		{
			GoTo((int)((ActualOffset - ContentPresenter.ActualWidth) / PanRate), Immediately, null);
		}
	}

	internal void Refresh()
	{
		UpdateWrappingRectangles();
	}

	protected virtual void UpdateWrappingRectangles()
	{
		PerfLog.BeginLogMarker(PerfMarkerEvents.MPC_PANO_UPDATEWRAPPING, PerfLog.PanningLayer);
		bool flag = !(base.Content is ItemsPresenter) || Owner.Panel == null || Owner.Panel.VisibleChildren.Count < 3;
		Rectangle leftWraparound = LeftWraparound;
		Visibility visibility = (RightWraparound.Visibility = ((IsStatic || !flag) ? Visibility.Collapsed : Visibility.Visible));
		leftWraparound.Visibility = visibility;
		if (!IsStatic && flag)
		{
			Rectangle rightWraparound = RightWraparound;
			double height = (LeftWraparound.Height = ContentPresenter.ActualHeight);
			rightWraparound.Height = height;
			Rectangle rightWraparound2 = RightWraparound;
			double width = (LeftWraparound.Width = Owner.ViewportWidth);
			rightWraparound2.Width = width;
			Rectangle leftWraparound2 = LeftWraparound;
			Thickness margin = (RightWraparound.Margin = ContentPresenter.Margin);
			leftWraparound2.Margin = margin;
			WriteableBitmap writeableBitmap = new WriteableBitmap(Owner.ViewportWidth, (int)ContentPresenter.ActualHeight);
			TranslateTransform translateTransform = new TranslateTransform();
			writeableBitmap.Render(ContentPresenter, translateTransform);
			writeableBitmap.Invalidate();
			RightWraparound.Fill = new ImageBrush
			{
				ImageSource = writeableBitmap
			};
			writeableBitmap = new WriteableBitmap(Owner.ViewportWidth, (int)ContentPresenter.ActualHeight);
			translateTransform.X = (double)Owner.ViewportWidth - ContentPresenter.ActualWidth;
			writeableBitmap.Render(ContentPresenter, translateTransform);
			writeableBitmap.Invalidate();
			LeftWraparound.Fill = new ImageBrush
			{
				ImageSource = writeableBitmap
			};
		}
		if (LocalTransform != null)
		{
			double num2 = ((LeftWraparound.Visibility == Visibility.Visible) ? (0.0 - LeftWraparound.Width - LeftWraparound.Margin.Left) : 0.0);
			LocalTransform.X = (IsStatic ? 0.0 : (num2 - LeftWraparound.Margin.Right));
		}
		PerfLog.EndLogMarker(PerfMarkerEvents.MPC_PANO_UPDATEWRAPPING, PerfLog.PanningLayer);
	}

	private void OnContentSizeChanged(object sender, SizeChangedEventArgs e)
	{
		UpdateWrappingRectangles();
	}
}
