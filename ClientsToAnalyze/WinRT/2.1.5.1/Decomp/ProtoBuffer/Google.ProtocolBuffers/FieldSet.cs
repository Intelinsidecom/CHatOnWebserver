using System;
using System.Collections;
using System.Collections.Generic;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

internal sealed class FieldSet
{
	private static readonly FieldSet defaultInstance = new FieldSet(new Dictionary<IFieldDescriptorLite, object>()).MakeImmutable();

	private IDictionary<IFieldDescriptorLite, object> fields;

	internal static FieldSet DefaultInstance => defaultInstance;

	internal IDictionary<IFieldDescriptorLite, object> AllFields => Dictionaries.AsReadOnly(fields);

	internal IDictionary<FieldDescriptor, object> AllFieldDescriptors
	{
		get
		{
			SortedList<FieldDescriptor, object> sortedList = new SortedList<FieldDescriptor, object>();
			foreach (KeyValuePair<IFieldDescriptorLite, object> field in fields)
			{
				sortedList.Add((FieldDescriptor)field.Key, field.Value);
			}
			return Dictionaries.AsReadOnly(sortedList);
		}
	}

	internal object this[IFieldDescriptorLite field]
	{
		get
		{
			if (fields.TryGetValue(field, out var value))
			{
				return value;
			}
			if (field.MappedType == MappedType.Message)
			{
				if (field.IsRepeated)
				{
					return new List<object>();
				}
				return null;
			}
			return field.DefaultValue;
		}
		set
		{
			if (field.IsRepeated)
			{
				if (!(value is List<object> collection))
				{
					throw new ArgumentException("Wrong object type used with protocol message reflection.");
				}
				List<object> list = new List<object>(collection);
				foreach (object item in list)
				{
					VerifyType(field, item);
				}
				value = list;
			}
			else
			{
				VerifyType(field, value);
			}
			fields[field] = value;
		}
	}

	internal object this[IFieldDescriptorLite field, int index]
	{
		get
		{
			if (!field.IsRepeated)
			{
				throw new ArgumentException("Indexer specifying field and index can only be called on repeated fields.");
			}
			return ((IList<object>)this[field])[index];
		}
		set
		{
			if (!field.IsRepeated)
			{
				throw new ArgumentException("Indexer specifying field and index can only be called on repeated fields.");
			}
			VerifyType(field, value);
			if (!fields.TryGetValue(field, out var value2))
			{
				throw new ArgumentOutOfRangeException();
			}
			((IList<object>)value2)[index] = value;
		}
	}

	internal bool IsInitialized
	{
		get
		{
			foreach (KeyValuePair<IFieldDescriptorLite, object> field in fields)
			{
				IFieldDescriptorLite key = field.Key;
				if (key.MappedType != MappedType.Message)
				{
					continue;
				}
				if (key.IsRepeated)
				{
					foreach (IMessageLite item in (IEnumerable)field.Value)
					{
						if (!item.IsInitialized)
						{
							return false;
						}
					}
				}
				else if (!((IMessageLite)field.Value).IsInitialized)
				{
					return false;
				}
			}
			return true;
		}
	}

	public int SerializedSize
	{
		get
		{
			int num = 0;
			foreach (KeyValuePair<IFieldDescriptorLite, object> field in fields)
			{
				IFieldDescriptorLite key = field.Key;
				object value = field.Value;
				if (key.IsExtension && key.MessageSetWireFormat)
				{
					num += CodedOutputStream.ComputeMessageSetExtensionSize(key.FieldNumber, (IMessageLite)value);
				}
				else if (key.IsRepeated)
				{
					IEnumerable enumerable = (IEnumerable)value;
					if (key.IsPacked)
					{
						int num2 = 0;
						foreach (object item in enumerable)
						{
							num2 += CodedOutputStream.ComputeFieldSizeNoTag(key.FieldType, item);
						}
						num += num2 + CodedOutputStream.ComputeTagSize(key.FieldNumber) + CodedOutputStream.ComputeRawVarint32Size((uint)num2);
						continue;
					}
					foreach (object item2 in enumerable)
					{
						num += CodedOutputStream.ComputeFieldSize(key.FieldType, key.FieldNumber, item2);
					}
				}
				else
				{
					num += CodedOutputStream.ComputeFieldSize(key.FieldType, key.FieldNumber, value);
				}
			}
			return num;
		}
	}

	private FieldSet(IDictionary<IFieldDescriptorLite, object> fields)
	{
		this.fields = fields;
	}

	public static FieldSet CreateInstance()
	{
		return new FieldSet(new SortedList<IFieldDescriptorLite, object>());
	}

	internal FieldSet MakeImmutable()
	{
		bool flag = false;
		foreach (object value in fields.Values)
		{
			if (value is IList<object> { IsReadOnly: false })
			{
				flag = true;
				break;
			}
		}
		if (flag)
		{
			SortedList<IFieldDescriptorLite, object> sortedList = new SortedList<IFieldDescriptorLite, object>();
			foreach (KeyValuePair<IFieldDescriptorLite, object> field in fields)
			{
				IList<object> list2 = field.Value as IList<object>;
				sortedList[field.Key] = ((list2 == null) ? field.Value : Lists.AsReadOnly(list2));
			}
			fields = sortedList;
		}
		fields = Dictionaries.AsReadOnly(fields);
		return this;
	}

	public bool HasField(IFieldDescriptorLite field)
	{
		if (field.IsRepeated)
		{
			throw new ArgumentException("HasField() can only be called on non-repeated fields.");
		}
		return fields.ContainsKey(field);
	}

	internal void Clear()
	{
		fields.Clear();
	}

	internal void AddRepeatedField(IFieldDescriptorLite field, object value)
	{
		if (!field.IsRepeated)
		{
			throw new ArgumentException("AddRepeatedField can only be called on repeated fields.");
		}
		VerifyType(field, value);
		if (!fields.TryGetValue(field, out var value2))
		{
			value2 = new List<object>();
			fields[field] = value2;
		}
		((IList<object>)value2).Add(value);
	}

	internal IEnumerator<KeyValuePair<IFieldDescriptorLite, object>> GetEnumerator()
	{
		return fields.GetEnumerator();
	}

	internal bool IsInitializedWithRespectTo(IEnumerable typeFields)
	{
		foreach (IFieldDescriptorLite typeField in typeFields)
		{
			if (typeField.IsRequired && !HasField(typeField))
			{
				return false;
			}
		}
		return IsInitialized;
	}

	public void ClearField(IFieldDescriptorLite field)
	{
		fields.Remove(field);
	}

	public int GetRepeatedFieldCount(IFieldDescriptorLite field)
	{
		if (!field.IsRepeated)
		{
			throw new ArgumentException("GetRepeatedFieldCount() can only be called on repeated fields.");
		}
		return ((IList<object>)this[field]).Count;
	}

	public void MergeFrom(IMessage other)
	{
		foreach (KeyValuePair<FieldDescriptor, object> allField in other.AllFields)
		{
			MergeField(allField.Key, allField.Value);
		}
	}

	public void MergeFrom(FieldSet other)
	{
		foreach (KeyValuePair<IFieldDescriptorLite, object> field in other.fields)
		{
			MergeField(field.Key, field.Value);
		}
	}

	private void MergeField(IFieldDescriptorLite field, object mergeValue)
	{
		fields.TryGetValue(field, out var value);
		if (field.IsRepeated)
		{
			if (value == null)
			{
				value = new List<object>();
				fields[field] = value;
			}
			IList<object> list = (IList<object>)value;
			{
				foreach (object item in (IEnumerable)mergeValue)
				{
					list.Add(item);
				}
				return;
			}
		}
		if (field.MappedType == MappedType.Message && value != null)
		{
			IMessageLite messageLite = (IMessageLite)value;
			IMessageLite value2 = messageLite.WeakToBuilder().WeakMergeFrom((IMessageLite)mergeValue).WeakBuild();
			this[field] = value2;
		}
		else
		{
			this[field] = mergeValue;
		}
	}

	public void WriteTo(CodedOutputStream output)
	{
		foreach (KeyValuePair<IFieldDescriptorLite, object> field in fields)
		{
			WriteField(field.Key, field.Value, output);
		}
	}

	public void WriteField(IFieldDescriptorLite field, object value, CodedOutputStream output)
	{
		if (field.IsExtension && field.MessageSetWireFormat)
		{
			output.WriteMessageSetExtension(field.FieldNumber, (IMessageLite)value);
			return;
		}
		if (field.IsRepeated)
		{
			IEnumerable enumerable = (IEnumerable)value;
			if (field.IsPacked)
			{
				output.WriteTag(field.FieldNumber, WireFormat.WireType.LengthDelimited);
				int num = 0;
				foreach (object item in enumerable)
				{
					num += CodedOutputStream.ComputeFieldSizeNoTag(field.FieldType, item);
				}
				output.WriteRawVarint32((uint)num);
				{
					foreach (object item2 in enumerable)
					{
						output.WriteFieldNoTag(field.FieldType, item2);
					}
					return;
				}
			}
			{
				foreach (object item3 in enumerable)
				{
					output.WriteField(field.FieldType, field.FieldNumber, item3);
				}
				return;
			}
		}
		output.WriteField(field.FieldType, field.FieldNumber, value);
	}

	private static void VerifyType(IFieldDescriptorLite field, object value)
	{
		ThrowHelper.ThrowIfNull(value, "value");
		bool flag = false;
		switch (field.MappedType)
		{
		case MappedType.Int32:
			flag = value is int;
			break;
		case MappedType.Int64:
			flag = value is long;
			break;
		case MappedType.UInt32:
			flag = value is uint;
			break;
		case MappedType.UInt64:
			flag = value is ulong;
			break;
		case MappedType.Single:
			flag = value is float;
			break;
		case MappedType.Double:
			flag = value is double;
			break;
		case MappedType.Boolean:
			flag = value is bool;
			break;
		case MappedType.String:
			flag = value is string;
			break;
		case MappedType.ByteString:
			flag = value is ByteString;
			break;
		case MappedType.Enum:
			flag = value is IEnumLite value2 && field.EnumType.IsValidValue(value2);
			break;
		case MappedType.Message:
		{
			IMessageLite messageLite = value as IMessageLite;
			flag = messageLite != null;
			if (flag && messageLite is IMessage && field is FieldDescriptor)
			{
				flag = ((IMessage)messageLite).DescriptorForType == ((FieldDescriptor)field).MessageType;
			}
			break;
		}
		}
		if (!flag)
		{
			string text = "Wrong object type used with protocol message reflection.";
			if (field is FieldDescriptor fieldDescriptor)
			{
				text = text + "Message type \"" + fieldDescriptor.ContainingType.FullName;
				text = text + "\", field \"" + (fieldDescriptor.IsExtension ? fieldDescriptor.FullName : fieldDescriptor.Name);
				text = text + "\", value was type \"" + value.GetType().Name + "\".";
			}
			throw new ArgumentException(text);
		}
	}
}
