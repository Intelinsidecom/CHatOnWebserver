using System.Windows.Media;
using System.Windows.Shapes;
using Microsoft.Phone.Controls.Maps.Core;

namespace Microsoft.Phone.Controls.Maps;

public class MapPolygon : MapShapeBase
{
	protected override PointCollection ProjectedPoints
	{
		get
		{
			return ((Polygon)base.EmbeddedShape).Points;
		}
		set
		{
			if (base.EmbeddedShape != null)
			{
				((Polygon)base.EmbeddedShape).Points = value;
			}
		}
	}

	public FillRule FillRule
	{
		get
		{
			return ((Polygon)base.EmbeddedShape).FillRule;
		}
		set
		{
			if (base.EmbeddedShape != null)
			{
				((Polygon)base.EmbeddedShape).FillRule = value;
			}
		}
	}

	public MapPolygon()
	{
		base.DefaultStyleKey = typeof(MapPolygon);
		base.EmbeddedShape = new Polygon();
	}

	protected override void SetEmbeddedShape(Shape newShape)
	{
		if (base.EmbeddedShape != null)
		{
			((Polygon)newShape).FillRule = ((Polygon)base.EmbeddedShape).FillRule;
		}
		base.SetEmbeddedShape(newShape);
	}
}
