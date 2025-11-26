using System;
using System.Collections.Generic;
using System.Reflection;
using Windows.Storage.Streams;

namespace SDatabase;

public class SDBIndex
{
	public enum DataStatus
	{
		New,
		Stored,
		Deleted,
		Updated,
		Garbage
	}

	private Guid _id = Guid.NewGuid();

	private DataStatus _status;

	private ulong _pos;

	private ulong _dataPos;

	private ulong _dataSize;

	public ulong Pos
	{
		get
		{
			return _pos;
		}
		set
		{
			_pos = value;
		}
	}

	public ulong DataSize
	{
		get
		{
			return _dataSize;
		}
		set
		{
			_dataSize = value;
		}
	}

	public ulong DataPos
	{
		get
		{
			return _dataPos;
		}
		set
		{
			_dataPos = value;
		}
	}

	public DataStatus Status
	{
		get
		{
			return _status;
		}
		set
		{
			_status = value;
		}
	}

	public Guid Id
	{
		get
		{
			return _id;
		}
		set
		{
			_id = value;
		}
	}

	public void Store(DataWriter dataWriter)
	{
		IEnumerable<PropertyInfo> declaredProperties = GetType().GetTypeInfo().DeclaredProperties;
		foreach (PropertyInfo item in declaredProperties)
		{
			object value = item.GetValue(this);
			SDBUtility.SavePropertyValueToDataWriter(dataWriter, item, value);
		}
	}

	public void Load(DataReader dataReader)
	{
		IEnumerable<PropertyInfo> declaredProperties = GetType().GetTypeInfo().DeclaredProperties;
		foreach (PropertyInfo item in declaredProperties)
		{
			SDBUtility.LoadPropertyValueFromDataReader(dataReader, item, this);
		}
	}
}
