using System.ComponentModel;
using System.Device.Location;
using System.Windows;
using System.Windows.Automation.Peers;
using System.Windows.Controls;
using System.Windows.Markup;
using Microsoft.Phone.Controls.Maps.AutomationPeers;
using Microsoft.Phone.Controls.Maps.Design;

namespace Microsoft.Phone.Controls.Maps;

[ContentProperty("Content")]
public sealed class Pushpin : ContentControl
{
	public static readonly DependencyProperty LocationDependencyProperty = DependencyProperty.Register("Location", typeof(GeoCoordinate), typeof(Pushpin), new PropertyMetadata(new GeoCoordinate(0.0, 0.0), OnLocationChangedCallback));

	public static readonly DependencyProperty PositionOriginDependencyProperty = DependencyProperty.Register("PositionOrigin", typeof(PositionOrigin), typeof(Pushpin), new PropertyMetadata(OnPositionOriginChangedCallback));

	[TypeConverter(typeof(LocationConverter))]
	public GeoCoordinate Location
	{
		get
		{
			return (GeoCoordinate)GetValue(LocationDependencyProperty);
		}
		set
		{
			SetValue(LocationDependencyProperty, value);
		}
	}

	public PositionOrigin PositionOrigin
	{
		get
		{
			return (PositionOrigin)GetValue(PositionOriginDependencyProperty);
		}
		set
		{
			SetValue(PositionOriginDependencyProperty, value);
		}
	}

	private static void OnLocationChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs eventArgs)
	{
		d.SetValue(MapLayer.PositionProperty, (GeoCoordinate)eventArgs.NewValue);
	}

	private static void OnPositionOriginChangedCallback(DependencyObject d, DependencyPropertyChangedEventArgs eventArgs)
	{
		d.SetValue(MapLayer.PositionOriginProperty, (PositionOrigin)eventArgs.NewValue);
	}

	public Pushpin()
	{
		base.DefaultStyleKey = typeof(Pushpin);
	}

	protected override AutomationPeer OnCreateAutomationPeer()
	{
		return new BaseAutomationPeer(this, "Pushpin");
	}
}
