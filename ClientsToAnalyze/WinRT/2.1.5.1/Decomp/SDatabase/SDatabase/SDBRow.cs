using System;

namespace SDatabase;

[AttributeUsage(AttributeTargets.All)]
public class SDBRow : Attribute
{
	public readonly string RowName;

	public SDBRow(string name)
	{
		RowName = name;
	}

	public SDBRow()
	{
	}
}
