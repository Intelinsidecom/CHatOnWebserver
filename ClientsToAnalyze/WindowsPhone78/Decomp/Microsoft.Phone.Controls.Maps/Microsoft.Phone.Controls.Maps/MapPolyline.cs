using System.Windows.Media;
using System.Windows.Shapes;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps;

public class MapPolyline : MapShapeBase
{
	protected override PointCollection ProjectedPoints
	{
		get
		{
			return ((Polyline)base.EmbeddedShape).Points;
		}
		set
		{
			if (base.EmbeddedShape != null)
			{
				((Polyline)base.EmbeddedShape).Points = value;
			}
		}
	}

	public FillRule FillRule
	{
		get
		{
			return ((Polyline)base.EmbeddedShape).FillRule;
		}
		set
		{
			if (base.EmbeddedShape != null)
			{
				((Polyline)base.EmbeddedShape).FillRule = value;
			}
		}
	}

	public MapPolyline()
	{
		base.DefaultStyleKey = typeof(MapPolyline);
		base.EmbeddedShape = new Polyline();
	}

	protected override void SetEmbeddedShape(Shape newShape)
	{
		if (base.EmbeddedShape != null)
		{
			((Polyline)newShape).FillRule = ((Polyline)base.EmbeddedShape).FillRule;
		}
		base.SetEmbeddedShape(newShape);
	}
}
