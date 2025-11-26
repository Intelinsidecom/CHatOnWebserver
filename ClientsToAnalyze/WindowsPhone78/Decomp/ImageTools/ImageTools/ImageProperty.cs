using System;
using System.Diagnostics.Contracts;

namespace ImageTools;

public sealed class ImageProperty : IEquatable<ImageProperty>
{
	private string _name;

	public string Name
	{
		get
		{
			Contract.Ensures(!string.IsNullOrEmpty(Contract.Result<string>()));
			return _name;
		}
	}

	public string Value { get; set; }

	public ImageProperty(string name, string value)
	{
		Contract.Requires<ArgumentException>(!string.IsNullOrEmpty(name), "Name cannot be null or empty.");
		_name = name;
		Value = value;
	}

	public override bool Equals(object obj)
	{
		if (obj == null)
		{
			return false;
		}
		return Equals(obj as ImageProperty);
	}

	public bool Equals(ImageProperty other)
	{
		if (other == null)
		{
			return false;
		}
		return object.Equals(Name, other.Name) && object.Equals(Value, other.Value);
	}

	public override int GetHashCode()
	{
		int num = 1;
		if (Name != null)
		{
			num ^= Name.GetHashCode();
		}
		if (Value != null)
		{
			num ^= Value.GetHashCode();
		}
		return num;
	}
}
