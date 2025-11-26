using System;
using System.Globalization;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Shapes;
using Microsoft.Phone.Controls.Maps.AutomationPeers;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps.Overlays;

[TemplatePart(Name = "ScaleString", Type = typeof(ShadowText))]
[TemplatePart(Name = "ScaleRectangle", Type = typeof(Rectangle))]
public class Scale : Overlay
{
	internal const string ScaleStringElementName = "ScaleString";

	internal const string ScaleRectangleElementName = "ScaleRectangle";

	private const int metersPerKm = 1000;

	private const double yardsPerMeter = 1.0936133;

	private const int yardsPerMile = 1760;

	private const int feetPerYard = 3;

	private const double feetPerMeter = 3.2808398999999997;

	private const int feetPerMile = 5280;

	private double currentMetersPerPixel;

	private double previousMaxWidth;

	private RegionInfo regionInfo;

	private double scaleInMetersPerPixel;

	private Rectangle scaleRectangle;

	private ShadowText scaleString;

	private ModeBackground setForBackground;

	public static readonly DependencyProperty DistanceUnitProperty = DependencyProperty.Register("DistanceUnit", typeof(DistanceUnit), typeof(Scale), new PropertyMetadata(OnUnitChanged));

	public static readonly DependencyProperty CultureProperty = DependencyProperty.Register("Culture", typeof(CultureInfo), typeof(Scale), new PropertyMetadata(OnCultureChanged));

	private static readonly int[] singleDigitValues = new int[2] { 5, 2 };

	private static readonly double[] multiDigitValues = new double[3] { 5.0, 2.5, 2.0 };

	public double MetersPerPixel
	{
		get
		{
			return scaleInMetersPerPixel;
		}
		internal set
		{
			scaleInMetersPerPixel = value;
			OnPerPixelChanged();
		}
	}

	public DistanceUnit DistanceUnit
	{
		get
		{
			return (DistanceUnit)GetValue(DistanceUnitProperty);
		}
		set
		{
			SetValue(DistanceUnitProperty, value);
		}
	}

	public CultureInfo Culture
	{
		get
		{
			return (CultureInfo)GetValue(CultureProperty);
		}
		set
		{
			SetValue(CultureProperty, value);
		}
	}

	internal ModeBackground SetForBackground
	{
		get
		{
			return setForBackground;
		}
		set
		{
			setForBackground = value;
			if (setForBackground == ModeBackground.Light)
			{
				scaleString.SetForegroundColorsForLightBackground();
			}
			else
			{
				scaleString.SetForegroundColorsForDarkBackground();
			}
		}
	}

	public Scale()
	{
		base.DefaultStyleKey = typeof(Scale);
		base.MaxWidth = 150.0;
		scaleString = new ShadowText();
		scaleRectangle = new Rectangle();
		base.LayoutUpdated += Scale_LayoutUpdated;
	}

	public override void OnApplyTemplate()
	{
		base.OnApplyTemplate();
		scaleString = GetTemplateChild("ScaleString") as ShadowText;
		scaleRectangle = GetTemplateChild("ScaleRectangle") as Rectangle;
		Refresh();
		FireTemplateApplied();
	}

	private void SetScaling(double metersPerPixel)
	{
		if (base.Visibility != Visibility.Visible || !(metersPerPixel > 0.0))
		{
			return;
		}
		CultureInfo provider = ((Culture != null) ? Culture : CultureInfo.CurrentUICulture);
		DistanceUnit distanceUnit = DistanceUnit;
		if (distanceUnit == DistanceUnit.Default)
		{
			RegionInfo regionInfo = ((this.regionInfo != null) ? this.regionInfo : RegionInfo.CurrentRegion);
			distanceUnit = ((!regionInfo.IsMetric) ? DistanceUnit.MilesFeet : DistanceUnit.KilometersMeters);
		}
		double num = (previousMaxWidth = base.MaxWidth);
		if (DistanceUnit.KilometersMeters == distanceUnit)
		{
			double num2 = metersPerPixel * num;
			if (num2 > 1000.0)
			{
				double dIn = num2 / 1000.0;
				int num3 = LargestNiceNumber(dIn);
				int pixels = (int)((double)(num3 * 1000) / metersPerPixel);
				SetScaling(pixels, string.Format(provider, OverlayResources.Kilometers, num3));
			}
			else
			{
				int num4 = LargestNiceNumber(num2);
				int pixels2 = (int)((double)num4 / metersPerPixel);
				SetScaling(pixels2, string.Format(provider, OverlayResources.Meters, num4));
			}
		}
		else
		{
			double num5 = metersPerPixel * 3.2808398999999997;
			double num6 = num5 * num;
			if (num6 > 5280.0)
			{
				double dIn2 = num6 / 5280.0;
				int num7 = LargestNiceNumber(dIn2);
				int pixels3 = (int)((double)(num7 * 5280) / num5);
				SetScaling(pixels3, string.Format(provider, OverlayResources.Miles, num7));
			}
			else if (DistanceUnit.MilesFeet == distanceUnit)
			{
				int num8 = LargestNiceNumber(num6);
				int pixels4 = (int)((double)num8 / num5);
				SetScaling(pixels4, string.Format(provider, OverlayResources.Feet, num8));
			}
			else
			{
				double dIn3 = num6 / 3.0;
				int num9 = LargestNiceNumber(dIn3);
				int pixels5 = (int)((double)(num9 * 3) / num5);
				SetScaling(pixels5, string.Format(provider, OverlayResources.Yards, num9));
			}
		}
		currentMetersPerPixel = metersPerPixel;
	}

	private void SetScaling(int pixels, string text)
	{
		base.Width = (double)pixels + scaleRectangle.Margin.Left + scaleRectangle.Margin.Right;
		scaleString.Text = text;
		scaleRectangle.Width = pixels;
	}

	private void Refresh()
	{
		if (currentMetersPerPixel > 0.0)
		{
			SetScaling(currentMetersPerPixel);
		}
	}

	private void Scale_LayoutUpdated(object sender, EventArgs e)
	{
		if (previousMaxWidth != base.MaxWidth)
		{
			Refresh();
		}
	}

	protected virtual void OnPerPixelChanged()
	{
		SetScaling(MetersPerPixel);
	}

	private static void OnUnitChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		((Scale)d).OnUnitChanged();
	}

	protected virtual void OnUnitChanged()
	{
		Refresh();
	}

	private static void OnCultureChanged(DependencyObject d, DependencyPropertyChangedEventArgs e)
	{
		((Scale)d).OnCultureChanged();
	}

	protected virtual void OnCultureChanged()
	{
		if (Culture != null)
		{
			regionInfo = null;
		}
		else
		{
			regionInfo = ResourceUtility.GetRegionInfo(Culture.Name);
			OverlayResources.Culture = Culture;
		}
		Refresh();
	}

	private static int GetSingleDigitValue(double value)
	{
		int num = (int)Math.Floor(value);
		int[] array = singleDigitValues;
		foreach (int num2 in array)
		{
			if (num > num2)
			{
				return num2;
			}
		}
		return 1;
	}

	private static int GetMultiDigitValue(double value, double exponentOf10)
	{
		double[] array = multiDigitValues;
		foreach (double num in array)
		{
			if (value > num)
			{
				return (int)(num * exponentOf10);
			}
		}
		return (int)exponentOf10;
	}

	private static int LargestNiceNumber(double dIn)
	{
		double d = Math.Log(dIn) / Math.Log(10.0);
		double y = Math.Floor(d);
		double num = Math.Pow(10.0, y);
		double value = dIn / num;
		if (1.0 == num)
		{
			return GetSingleDigitValue(value);
		}
		return GetMultiDigitValue(value, num);
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "Scale");
	}
}
