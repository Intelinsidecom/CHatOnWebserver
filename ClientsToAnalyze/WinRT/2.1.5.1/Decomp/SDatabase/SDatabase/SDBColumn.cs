using System;

namespace SDatabase;

[AttributeUsage(AttributeTargets.All)]
public class SDBColumn : Attribute
{
	public readonly string ColumnName;

	public bool Encrypt;

	public SDBColumn(string name)
	{
		ColumnName = name;
		Encrypt = false;
	}

	public SDBColumn()
	{
	}
}
