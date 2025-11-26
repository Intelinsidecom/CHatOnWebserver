using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Linq.Expressions;
using System.Reflection;
using Windows.Storage.Streams;

namespace SDatabase;

public class SDBData : INotifyPropertyChanged
{
	public static bool SkipPropertyChangedNoti;

	public static bool SkipDataUpdatedNoti;

	private Guid _id = Guid.NewGuid();

	private SDBIndex _index;

	public SDBIndex Index
	{
		get
		{
			return _index;
		}
		set
		{
			_index = value;
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

	public event PropertyChangedEventHandler PropertyChanged;

	public void SetDataUpdated()
	{
		if (_index != null && _index.Status == SDBIndex.DataStatus.Stored)
		{
			_index.Status = SDBIndex.DataStatus.Updated;
		}
	}

	public void Store(DataWriter dataWriter)
	{
		dataWriter.WriteGuid(_id);
		IEnumerable<PropertyInfo> declaredProperties = GetType().GetTypeInfo().DeclaredProperties;
		IOrderedEnumerable<PropertyInfo> orderedEnumerable = declaredProperties.OrderBy((PropertyInfo d) => d.Name);
		foreach (PropertyInfo item in orderedEnumerable)
		{
			if (item.CustomAttributes.Count() != 0)
			{
				object value = item.GetValue(this);
				if (item.CustomAttributes.First().NamedArguments.Count > 0)
				{
					SDBUtility.SavePropertyValueToDataWriter(dataWriter, item, value, encrypt: true);
				}
				else
				{
					SDBUtility.SavePropertyValueToDataWriter(dataWriter, item, value);
				}
			}
		}
	}

	public void Load(DataReader dataReader)
	{
		_id = dataReader.ReadGuid();
		IEnumerable<PropertyInfo> declaredProperties = GetType().GetTypeInfo().DeclaredProperties;
		IOrderedEnumerable<PropertyInfo> orderedEnumerable = declaredProperties.OrderBy((PropertyInfo d) => d.Name);
		foreach (PropertyInfo item in orderedEnumerable)
		{
			if (item.CustomAttributes.Count() != 0)
			{
				if (item.CustomAttributes.First().NamedArguments.Count > 0)
				{
					SDBUtility.LoadPropertyValueFromDataReader(dataReader, item, this, decrypt: true);
				}
				else
				{
					SDBUtility.LoadPropertyValueFromDataReader(dataReader, item, this);
				}
			}
		}
	}

	public void NotifyPropertyChanged(string propertyName)
	{
		try
		{
			this.PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
		}
		catch
		{
		}
	}

	public void NotifyPropertyChanged<T>(Expression<Func<T>> propertyExpression)
	{
		string propertyName = ExtractPropertyName(propertyExpression);
		NotifyPropertyChanged(propertyName);
	}

	public static string ExtractPropertyName<T>(Expression<Func<T>> propertyExpression)
	{
		if (propertyExpression == null)
		{
			throw new ArgumentNullException("propertyExpression");
		}
		if (!(propertyExpression.Body is MemberExpression memberExpression))
		{
			throw new ArgumentException("propertyExpression");
		}
		if (!(memberExpression.Member is PropertyInfo { GetMethod: var getMethod }))
		{
			throw new ArgumentException("propertyExpression");
		}
		if (getMethod.IsStatic)
		{
			throw new ArgumentException("propertyExpression");
		}
		return memberExpression.Member.Name;
	}
}
