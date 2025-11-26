using System;
using System.Collections;
using System.Collections.Generic;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

internal sealed class FieldSet
{
	private static readonly FieldSet defaultInstance = new FieldSet(new Dictionary<FieldDescriptor, object>()).MakeImmutable();

	private IDictionary<FieldDescriptor, object> fields;

	internal static FieldSet DefaultInstance => defaultInstance;

	internal IDictionary<FieldDescriptor, object> AllFields => Dictionaries.AsReadOnly(fields);

	internal object this[FieldDescriptor field]
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

	internal object this[FieldDescriptor field, int index]
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
			foreach (KeyValuePair<FieldDescriptor, object> field in fields)
			{
				FieldDescriptor key = field.Key;
				if (key.MappedType != MappedType.Message)
				{
					continue;
				}
				if (key.IsRepeated)
				{
					foreach (IMessage item in (IEnumerable)field.Value)
					{
						if (!item.IsInitialized)
						{
							return false;
						}
					}
				}
				else if (!((IMessage)field.Value).IsInitialized)
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
			foreach (KeyValuePair<FieldDescriptor, object> field in fields)
			{
				FieldDescriptor key = field.Key;
				object value = field.Value;
				if (key.IsExtension && key.ContainingType.Options.MessageSetWireFormat)
				{
					num += CodedOutputStream.ComputeMessageSetExtensionSize(key.FieldNumber, (IMessage)value);
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

	private FieldSet(IDictionary<FieldDescriptor, object> fields)
	{
		this.fields = fields;
	}

	public static FieldSet CreateInstance()
	{
		return new FieldSet(new SortedList<FieldDescriptor, object>());
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
			SortedList<FieldDescriptor, object> sortedList = new SortedList<FieldDescriptor, object>();
			foreach (KeyValuePair<FieldDescriptor, object> field in fields)
			{
				IList<object> list2 = field.Value as IList<object>;
				sortedList[field.Key] = ((list2 == null) ? field.Value : Lists.AsReadOnly(list2));
			}
			fields = sortedList;
		}
		fields = Dictionaries.AsReadOnly(fields);
		return this;
	}

	public bool HasField(FieldDescriptor field)
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

	internal void AddRepeatedField(FieldDescriptor field, object value)
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

	internal IEnumerator<KeyValuePair<FieldDescriptor, object>> GetEnumerator()
	{
		return fields.GetEnumerator();
	}

	internal bool IsInitializedWithRespectTo(MessageDescriptor type)
	{
		foreach (FieldDescriptor field in type.Fields)
		{
			if (field.IsRequired && !HasField(field))
			{
				return false;
			}
		}
		return IsInitialized;
	}

	public void ClearField(FieldDescriptor field)
	{
		fields.Remove(field);
	}

	public int GetRepeatedFieldCount(FieldDescriptor field)
	{
		if (!field.IsRepeated)
		{
			throw new ArgumentException("GetRepeatedFieldCount() can only be called on repeated fields.");
		}
		return ((IList<object>)this[field]).Count;
	}

	private void MergeFields(IEnumerable<KeyValuePair<FieldDescriptor, object>> otherFields)
	{
		foreach (KeyValuePair<FieldDescriptor, object> otherField in otherFields)
		{
			FieldDescriptor key = otherField.Key;
			fields.TryGetValue(key, out var value);
			if (key.IsRepeated)
			{
				if (value == null)
				{
					value = new List<object>();
					fields[key] = value;
				}
				IList<object> list = (IList<object>)value;
				foreach (object item in (IEnumerable)otherField.Value)
				{
					list.Add(item);
				}
			}
			else if (key.MappedType == MappedType.Message && value != null)
			{
				IMessage message = (IMessage)value;
				IMessage value2 = message.WeakToBuilder().WeakMergeFrom((IMessage)otherField.Value).WeakBuild();
				this[key] = value2;
			}
			else
			{
				this[key] = otherField.Value;
			}
		}
	}

	public void MergeFrom(IMessage other)
	{
		MergeFields(other.AllFields);
	}

	public void MergeFrom(FieldSet other)
	{
		MergeFields(other.fields);
	}

	public void WriteTo(CodedOutputStream output)
	{
		foreach (KeyValuePair<FieldDescriptor, object> field in fields)
		{
			WriteField(field.Key, field.Value, output);
		}
	}

	public void WriteField(FieldDescriptor field, object value, CodedOutputStream output)
	{
		if (field.IsExtension && field.ContainingType.Options.MessageSetWireFormat)
		{
			output.WriteMessageSetExtension(field.FieldNumber, (IMessage)value);
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

	private static void VerifyType(FieldDescriptor field, object value)
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
			flag = value is EnumValueDescriptor enumValueDescriptor && enumValueDescriptor.EnumDescriptor == field.EnumType;
			break;
		case MappedType.Message:
			flag = value is IMessage message && message.DescriptorForType == field.MessageType;
			break;
		}
		if (!flag)
		{
			throw new ArgumentException("Wrong object type used with protocol message reflection. Message type \"" + field.ContainingType.FullName + "\", field \"" + (field.IsExtension ? field.FullName : field.Name) + "\", value was type \"" + value.GetType().Name + "\".");
		}
	}
}
