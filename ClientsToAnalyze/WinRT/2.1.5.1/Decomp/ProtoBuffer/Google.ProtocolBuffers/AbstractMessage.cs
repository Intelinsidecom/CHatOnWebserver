using System.Collections;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public abstract class AbstractMessage<TMessage, TBuilder> : AbstractMessageLite<TMessage, TBuilder>, IMessage<TMessage, TBuilder>, IMessage<TMessage>, IMessage, IMessageLite<TMessage, TBuilder>, IMessageLite<TMessage>, IMessageLite where TMessage : AbstractMessage<TMessage, TBuilder> where TBuilder : AbstractBuilder<TMessage, TBuilder>
{
	private int? memoizedSize = null;

	public abstract MessageDescriptor DescriptorForType { get; }

	public abstract IDictionary<FieldDescriptor, object> AllFields { get; }

	public abstract object this[FieldDescriptor field] { get; }

	public abstract object this[FieldDescriptor field, int index] { get; }

	public abstract UnknownFieldSet UnknownFields { get; }

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
			}
			foreach (KeyValuePair<FieldDescriptor, object> allField in AllFields)
			{
				FieldDescriptor key = allField.Key;
				if (key.MappedType != MappedType.Message)
				{
					continue;
				}
				if (key.IsRepeated)
				{
					foreach (IMessageLite item in (IEnumerable)allField.Value)
					{
						if (!item.IsInitialized)
						{
							return false;
						}
					}
				}
				else if (!((IMessageLite)allField.Value).IsInitialized)
				{
					return false;
				}
			}
			return true;
		}
	}

	public override int SerializedSize
	{
		get
		{
			if (memoizedSize.HasValue)
			{
				return memoizedSize.Value;
			}
			int num = 0;
			foreach (KeyValuePair<FieldDescriptor, object> allField in AllFields)
			{
				FieldDescriptor key = allField.Key;
				if (key.IsRepeated)
				{
					IEnumerable enumerable = (IEnumerable)allField.Value;
					if (key.IsPacked)
					{
						int num2 = 0;
						foreach (object item in enumerable)
						{
							num2 += CodedOutputStream.ComputeFieldSizeNoTag(key.FieldType, item);
						}
						num += num2;
						num += CodedOutputStream.ComputeTagSize(key.FieldNumber);
						num += CodedOutputStream.ComputeRawVarint32Size((uint)num2);
						continue;
					}
					foreach (object item2 in enumerable)
					{
						num += CodedOutputStream.ComputeFieldSize(key.FieldType, key.FieldNumber, item2);
					}
				}
				else
				{
					num += CodedOutputStream.ComputeFieldSize(key.FieldType, key.FieldNumber, allField.Value);
				}
			}
			UnknownFieldSet unknownFields = UnknownFields;
			num = ((!DescriptorForType.Options.MessageSetWireFormat) ? (num + unknownFields.SerializedSize) : (num + unknownFields.SerializedSizeAsMessageSet));
			memoizedSize = num;
			return num;
		}
	}

	IMessage IMessage.WeakDefaultInstanceForType => DefaultInstanceForType;

	public abstract bool HasField(FieldDescriptor field);

	public abstract int GetRepeatedFieldCount(FieldDescriptor field);

	public sealed override string ToString()
	{
		return TextFormat.PrintToString(this);
	}

	public sealed override void PrintTo(TextWriter writer)
	{
		TextFormat.Print(this, writer);
	}

	public override void WriteTo(CodedOutputStream output)
	{
		foreach (KeyValuePair<FieldDescriptor, object> allField in AllFields)
		{
			FieldDescriptor key = allField.Key;
			if (key.IsRepeated)
			{
				IEnumerable enumerable = (IEnumerable)allField.Value;
				if (key.IsPacked)
				{
					output.WriteTag(key.FieldNumber, WireFormat.WireType.LengthDelimited);
					int num = 0;
					foreach (object item in enumerable)
					{
						num += CodedOutputStream.ComputeFieldSizeNoTag(key.FieldType, item);
					}
					output.WriteRawVarint32((uint)num);
					foreach (object item2 in enumerable)
					{
						output.WriteFieldNoTag(key.FieldType, item2);
					}
					continue;
				}
				foreach (object item3 in enumerable)
				{
					output.WriteField(key.FieldType, key.FieldNumber, item3);
				}
			}
			else
			{
				output.WriteField(key.FieldType, key.FieldNumber, allField.Value);
			}
		}
		UnknownFieldSet unknownFields = UnknownFields;
		if (DescriptorForType.Options.MessageSetWireFormat)
		{
			unknownFields.WriteAsMessageSetTo(output);
		}
		else
		{
			unknownFields.WriteTo(output);
		}
	}

	public override bool Equals(object other)
	{
		if (other == this)
		{
			return true;
		}
		if (!(other is IMessage message) || message.DescriptorForType != DescriptorForType)
		{
			return false;
		}
		if (Dictionaries.Equals(AllFields, message.AllFields))
		{
			return UnknownFields.Equals(message.UnknownFields);
		}
		return false;
	}

	public override int GetHashCode()
	{
		int num = 41;
		num = 19 * num + DescriptorForType.GetHashCode();
		num = 53 * num + Dictionaries.GetHashCode(AllFields);
		return 29 * num + UnknownFields.GetHashCode();
	}

	IBuilder IMessage.WeakCreateBuilderForType()
	{
		return CreateBuilderForType();
	}

	IBuilder IMessage.WeakToBuilder()
	{
		return ToBuilder();
	}
}
