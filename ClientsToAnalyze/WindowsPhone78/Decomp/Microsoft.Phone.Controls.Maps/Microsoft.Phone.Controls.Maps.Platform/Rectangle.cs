using System.Runtime.Serialization;

namespace Microsoft.Phone.Controls.Maps.Platform;

[DataContract(Namespace = "http://dev.virtualearth.net/webservices/v1/common", Name = "Rectangle")]
public class Rectangle : ShapeBase
{
	[DataMember]
	public Location Northeast { get; set; }

	[DataMember]
	public Location Southwest { get; set; }

	public static implicit operator LocationRect(Rectangle obj)
	{
		return new LocationRect(obj.Northeast.Latitude, obj.Southwest.Longitude, obj.Southwest.Latitude, obj.Northeast.Longitude);
	}

	public static implicit operator Rectangle(LocationRect obj)
	{
		Rectangle rectangle = new Rectangle();
		rectangle.Northeast = obj.Northeast;
		rectangle.Southwest = obj.Southwest;
		return rectangle;
	}
}
