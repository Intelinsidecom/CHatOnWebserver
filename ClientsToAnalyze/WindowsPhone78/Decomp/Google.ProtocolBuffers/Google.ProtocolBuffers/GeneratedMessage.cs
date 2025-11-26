using System.Collections;
using System.Collections.Generic;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers;

public abstract class GeneratedMessage<TMessage, TBuilder> : AbstractMessage<TMessage, TBuilder> where TMessage : GeneratedMessage<TMessage, TBuilder> where TBuilder : GeneratedBuilder<TMessage, TBuilder>
{
	private UnknownFieldSet unknownFields = UnknownFieldSet.DefaultInstance;

	protected abstract TMessage ThisMessage { get; }

	internal FieldAccessorTable<TMessage, TBuilder> FieldAccessorsFromBuilder => InternalFieldAccessors;

	protected abstract FieldAccessorTable<TMessage, TBuilder> InternalFieldAccessors { get; }

	public override MessageDescriptor DescriptorForType => InternalFieldAccessors.Descriptor;

	public override bool IsInitialized
	{
		get
		{
			foreach (FieldDescriptor field in DescriptorForType.Fields)
			{
				if (field.IsRequired && !HasField(field))
				{
					return false;
				}
				if (field.MappedType != MappedType.Message)
				{
					continue;
				}
				if (field.IsRepeated)
				{
					foreach (IMessage item in (IEnumerable)this[field])
					{
						if (!item.IsInitialized)
						{
							return false;
						}
					}
				}
				else if (HasField(field) && !((IMessage)this[field]).IsInitialized)
				{
					return false;
				}
			}
			return true;
		}
	}

	public override IDictionary<FieldDescriptor, object> AllFields => Dictionaries.AsReadOnly(GetMutableFieldMap());

	public override object this[FieldDescriptor field, int index] => InternalFieldAccessors[field].GetRepeatedValue(ThisMessage, index);

	public override object this[FieldDescriptor field] => InternalFieldAccessors[field].GetValue(ThisMessage);

	public override UnknownFieldSet UnknownFields => unknownFields;

	internal IDictionary<FieldDescriptor, object> GetMutableFieldMap()
	{
		SortedList<FieldDescriptor, object> sortedList = new SortedList<FieldDescriptor, object>();
		MessageDescriptor descriptorForType = DescriptorForType;
		foreach (FieldDescriptor field in descriptorForType.Fields)
		{
			IFieldAccessor<TMessage, TBuilder> fieldAccessor = InternalFieldAccessors[field];
			if (field.IsRepeated)
			{
				if (fieldAccessor.GetRepeatedCount(ThisMessage) != 0)
				{
					sortedList[field] = fieldAccessor.GetValue(ThisMessage);
				}
			}
			else if (HasField(field))
			{
				sortedList[field] = fieldAccessor.GetValue(ThisMessage);
			}
		}
		return sortedList;
	}

	public override bool HasField(FieldDescriptor field)
	{
		return InternalFieldAccessors[field].Has(ThisMessage);
	}

	public override int GetRepeatedFieldCount(FieldDescriptor field)
	{
		return InternalFieldAccessors[field].GetRepeatedCount(ThisMessage);
	}

	internal void SetUnknownFields(UnknownFieldSet fieldSet)
	{
		unknownFields = fieldSet;
	}
}
