using System.Collections.Generic;

namespace Samsung.Device.PDI;

public sealed class Property
{
	internal string Name { get; set; }

	public List<Parameter> Parameters { get; set; }

	public string Value { get; set; }
}
