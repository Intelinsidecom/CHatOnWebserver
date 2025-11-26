using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public sealed class UnknownFieldSet : IMessageLite
{
	public sealed class Builder : IBuilderLite
	{
		private IDictionary<int, UnknownField> fields;

		private int lastFieldNumber;

		private UnknownField.Builder lastField;

		bool IBuilderLite.IsInitialized => fields != null;

		IMessageLite IBuilderLite.WeakDefaultInstanceForType => DefaultInstance;

		internal Builder()
		{
			fields = new SortedList<int, UnknownField>();
		}

		internal Builder(IDictionary<int, UnknownField> dictionary)
		{
			fields = new SortedList<int, UnknownField>(dictionary);
		}

		private UnknownField.Builder GetFieldBuilder(int number)
		{
			if (lastField != null)
			{
				if (number == lastFieldNumber)
				{
					return lastField;
				}
				AddField(lastFieldNumber, lastField.Build());
			}
			if (number == 0)
			{
				return null;
			}
			lastField = UnknownField.CreateBuilder();
			if (fields.TryGetValue(number, out var value))
			{
				lastField.MergeFrom(value);
			}
			lastFieldNumber = number;
			return lastField;
		}

		public UnknownFieldSet Build()
		{
			GetFieldBuilder(0);
			UnknownFieldSet result = ((fields.Count == 0) ? DefaultInstance : new UnknownFieldSet(fields));
			fields = null;
			return result;
		}

		public Builder AddField(int number, UnknownField field)
		{
			if (number == 0)
			{
				throw new ArgumentOutOfRangeException("number", "Zero is not a valid field number.");
			}
			if (lastField != null && lastFieldNumber == number)
			{
				lastField = null;
				lastFieldNumber = 0;
			}
			fields[number] = field;
			return this;
		}

		public Builder Clear()
		{
			fields.Clear();
			lastFieldNumber = 0;
			lastField = null;
			return this;
		}

		public Builder MergeFrom(CodedInputStream input)
		{
			uint num;
			do
			{
				num = input.ReadTag();
			}
			while (num != 0 && MergeFieldFrom(num, input));
			return this;
		}

		[CLSCompliant(false)]
		public bool MergeFieldFrom(uint tag, CodedInputStream input)
		{
			int tagFieldNumber = WireFormat.GetTagFieldNumber(tag);
			switch (WireFormat.GetTagWireType(tag))
			{
			case WireFormat.WireType.Varint:
				GetFieldBuilder(tagFieldNumber).AddVarint(input.ReadUInt64());
				return true;
			case WireFormat.WireType.Fixed64:
				GetFieldBuilder(tagFieldNumber).AddFixed64(input.ReadFixed64());
				return true;
			case WireFormat.WireType.LengthDelimited:
				GetFieldBuilder(tagFieldNumber).AddLengthDelimited(input.ReadBytes());
				return true;
			case WireFormat.WireType.StartGroup:
			{
				Builder builder = CreateBuilder();
				input.ReadUnknownGroup(tagFieldNumber, builder);
				GetFieldBuilder(tagFieldNumber).AddGroup(builder.Build());
				return true;
			}
			case WireFormat.WireType.EndGroup:
				return false;
			case WireFormat.WireType.Fixed32:
				GetFieldBuilder(tagFieldNumber).AddFixed32(input.ReadFixed32());
				return true;
			default:
				throw InvalidProtocolBufferException.InvalidWireType();
			}
		}

		public Builder MergeFrom(Stream input)
		{
			CodedInputStream codedInputStream = CodedInputStream.CreateInstance(input);
			MergeFrom(codedInputStream);
			codedInputStream.CheckLastTagWas(0u);
			return this;
		}

		public Builder MergeFrom(ByteString data)
		{
			CodedInputStream codedInputStream = data.CreateCodedInput();
			MergeFrom(codedInputStream);
			codedInputStream.CheckLastTagWas(0u);
			return this;
		}

		public Builder MergeFrom(byte[] data)
		{
			CodedInputStream codedInputStream = CodedInputStream.CreateInstance(data);
			MergeFrom(codedInputStream);
			codedInputStream.CheckLastTagWas(0u);
			return this;
		}

		[CLSCompliant(false)]
		public Builder MergeVarintField(int number, ulong value)
		{
			if (number == 0)
			{
				throw new ArgumentOutOfRangeException("number", "Zero is not a valid field number.");
			}
			GetFieldBuilder(number).AddVarint(value);
			return this;
		}

		public Builder MergeFrom(UnknownFieldSet other)
		{
			if (other != DefaultInstance)
			{
				foreach (KeyValuePair<int, UnknownField> field in other.fields)
				{
					MergeField(field.Key, field.Value);
				}
			}
			return this;
		}

		public bool HasField(int number)
		{
			if (number == 0)
			{
				throw new ArgumentOutOfRangeException("number", "Zero is not a valid field number.");
			}
			if (number != lastFieldNumber)
			{
				return fields.ContainsKey(number);
			}
			return true;
		}

		public Builder MergeField(int number, UnknownField field)
		{
			if (number == 0)
			{
				throw new ArgumentOutOfRangeException("number", "Zero is not a valid field number.");
			}
			if (HasField(number))
			{
				GetFieldBuilder(number).MergeFrom(field);
			}
			else
			{
				AddField(number, field);
			}
			return this;
		}

		internal void MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry, IBuilder builder)
		{
			uint num;
			do
			{
				num = input.ReadTag();
			}
			while (num != 0 && MergeFieldFrom(input, extensionRegistry, builder, num));
		}

		internal bool MergeFieldFrom(CodedInputStream input, ExtensionRegistry extensionRegistry, IBuilder builder, uint tag)
		{
			MessageDescriptor descriptorForType = builder.DescriptorForType;
			if (descriptorForType.Options.MessageSetWireFormat && tag == WireFormat.MessageSetTag.ItemStart)
			{
				MergeMessageSetExtensionFromCodedStream(input, extensionRegistry, builder);
				return true;
			}
			WireFormat.WireType tagWireType = WireFormat.GetTagWireType(tag);
			int tagFieldNumber = WireFormat.GetTagFieldNumber(tag);
			IMessageLite messageLite = null;
			FieldDescriptor fieldDescriptor;
			if (descriptorForType.IsExtensionNumber(tagFieldNumber))
			{
				ExtensionInfo extensionInfo = extensionRegistry[descriptorForType, tagFieldNumber];
				if (extensionInfo == null)
				{
					fieldDescriptor = null;
				}
				else
				{
					fieldDescriptor = extensionInfo.Descriptor;
					messageLite = extensionInfo.DefaultInstance;
				}
			}
			else
			{
				fieldDescriptor = descriptorForType.FindFieldByNumber(tagFieldNumber);
			}
			if (fieldDescriptor == null || tagWireType != WireFormat.GetWireType(fieldDescriptor))
			{
				return MergeFieldFrom(tag, input);
			}
			if (fieldDescriptor.IsPacked)
			{
				int byteLimit = (int)input.ReadRawVarint32();
				int oldLimit = input.PushLimit(byteLimit);
				if (fieldDescriptor.FieldType == FieldType.Enum)
				{
					while (!input.ReachedLimit)
					{
						int number = input.ReadEnum();
						object obj = fieldDescriptor.EnumType.FindValueByNumber(number);
						if (obj == null)
						{
							return true;
						}
						builder.WeakAddRepeatedField(fieldDescriptor, obj);
					}
				}
				else
				{
					while (!input.ReachedLimit)
					{
						object value = input.ReadPrimitiveField(fieldDescriptor.FieldType);
						builder.WeakAddRepeatedField(fieldDescriptor, value);
					}
				}
				input.PopLimit(oldLimit);
			}
			else
			{
				object obj2;
				switch (fieldDescriptor.FieldType)
				{
				case FieldType.Group:
				case FieldType.Message:
				{
					IBuilderLite builderLite = ((messageLite == null) ? builder.CreateBuilderForField(fieldDescriptor) : messageLite.WeakCreateBuilderForType());
					if (!fieldDescriptor.IsRepeated)
					{
						builderLite.WeakMergeFrom((IMessageLite)builder[fieldDescriptor]);
					}
					if (fieldDescriptor.FieldType == FieldType.Group)
					{
						input.ReadGroup(fieldDescriptor.FieldNumber, builderLite, extensionRegistry);
					}
					else
					{
						input.ReadMessage(builderLite, extensionRegistry);
					}
					obj2 = builderLite.WeakBuild();
					break;
				}
				case FieldType.Enum:
				{
					int num = input.ReadEnum();
					obj2 = fieldDescriptor.EnumType.FindValueByNumber(num);
					if (obj2 == null)
					{
						MergeVarintField(tagFieldNumber, (ulong)num);
						return true;
					}
					break;
				}
				default:
					obj2 = input.ReadPrimitiveField(fieldDescriptor.FieldType);
					break;
				}
				if (fieldDescriptor.IsRepeated)
				{
					builder.WeakAddRepeatedField(fieldDescriptor, obj2);
				}
				else
				{
					builder[fieldDescriptor] = obj2;
				}
			}
			return true;
		}

		private void MergeMessageSetExtensionFromCodedStream(CodedInputStream input, ExtensionRegistry extensionRegistry, IBuilder builder)
		{
			MessageDescriptor descriptorForType = builder.DescriptorForType;
			int num = 0;
			ByteString byteString = null;
			IBuilderLite builderLite = null;
			FieldDescriptor field = null;
			while (true)
			{
				uint num2 = input.ReadTag();
				if (num2 == 0)
				{
					break;
				}
				if (num2 == WireFormat.MessageSetTag.TypeID)
				{
					num = input.ReadInt32();
					if (num == 0)
					{
						continue;
					}
					ExtensionInfo extensionInfo = extensionRegistry[descriptorForType, num];
					if (extensionInfo != null)
					{
						field = extensionInfo.Descriptor;
						builderLite = extensionInfo.DefaultInstance.WeakCreateBuilderForType();
						IMessageLite messageLite = (IMessageLite)builder[field];
						if (messageLite != null)
						{
							builderLite.WeakMergeFrom(messageLite);
						}
						if (byteString != null)
						{
							builderLite.WeakMergeFrom(byteString.CreateCodedInput());
							byteString = null;
						}
					}
					else if (byteString != null)
					{
						MergeField(num, UnknownField.CreateBuilder().AddLengthDelimited(byteString).Build());
						byteString = null;
					}
				}
				else if (num2 == WireFormat.MessageSetTag.Message)
				{
					if (num == 0)
					{
						byteString = input.ReadBytes();
					}
					else if (builderLite == null)
					{
						MergeField(num, UnknownField.CreateBuilder().AddLengthDelimited(input.ReadBytes()).Build());
					}
					else
					{
						input.ReadMessage(builderLite, extensionRegistry);
					}
				}
				else if (!input.SkipField(num2))
				{
					break;
				}
			}
			input.CheckLastTagWas(WireFormat.MessageSetTag.ItemEnd);
			if (builderLite != null)
			{
				builder[field] = builderLite.WeakBuild();
			}
		}

		IBuilderLite IBuilderLite.WeakClear()
		{
			return Clear();
		}

		IBuilderLite IBuilderLite.WeakMergeFrom(IMessageLite message)
		{
			return MergeFrom((UnknownFieldSet)message);
		}

		IBuilderLite IBuilderLite.WeakMergeFrom(ByteString data)
		{
			return MergeFrom(data);
		}

		IBuilderLite IBuilderLite.WeakMergeFrom(ByteString data, ExtensionRegistry registry)
		{
			return MergeFrom(data);
		}

		IBuilderLite IBuilderLite.WeakMergeFrom(CodedInputStream input)
		{
			return MergeFrom(input);
		}

		IBuilderLite IBuilderLite.WeakMergeFrom(CodedInputStream input, ExtensionRegistry registry)
		{
			return MergeFrom(input);
		}

		IMessageLite IBuilderLite.WeakBuild()
		{
			return Build();
		}

		IMessageLite IBuilderLite.WeakBuildPartial()
		{
			return Build();
		}

		IBuilderLite IBuilderLite.WeakClone()
		{
			return Build().WeakToBuilder();
		}
	}

	private static readonly UnknownFieldSet defaultInstance = new UnknownFieldSet(new Dictionary<int, UnknownField>());

	private readonly IDictionary<int, UnknownField> fields;

	public static UnknownFieldSet DefaultInstance => defaultInstance;

	public IDictionary<int, UnknownField> FieldDictionary => Dictionaries.AsReadOnly(fields);

	public UnknownField this[int number]
	{
		get
		{
			if (!fields.TryGetValue(number, out var value))
			{
				return UnknownField.DefaultInstance;
			}
			return value;
		}
	}

	public int SerializedSize
	{
		get
		{
			int num = 0;
			foreach (KeyValuePair<int, UnknownField> field in fields)
			{
				num += field.Value.GetSerializedSize(field.Key);
			}
			return num;
		}
	}

	public int SerializedSizeAsMessageSet
	{
		get
		{
			int num = 0;
			foreach (KeyValuePair<int, UnknownField> field in fields)
			{
				num += field.Value.GetSerializedSizeAsMessageSetExtension(field.Key);
			}
			return num;
		}
	}

	public bool IsInitialized => fields != null;

	public IMessageLite WeakDefaultInstanceForType => defaultInstance;

	private UnknownFieldSet(IDictionary<int, UnknownField> fields)
	{
		this.fields = fields;
	}

	public static Builder CreateBuilder()
	{
		return new Builder();
	}

	public static Builder CreateBuilder(UnknownFieldSet original)
	{
		return new Builder().MergeFrom(original);
	}

	public bool HasField(int field)
	{
		return fields.ContainsKey(field);
	}

	public void WriteTo(CodedOutputStream output)
	{
		foreach (KeyValuePair<int, UnknownField> field in fields)
		{
			field.Value.WriteTo(field.Key, output);
		}
	}

	public override string ToString()
	{
		return TextFormat.PrintToString(this);
	}

	public void PrintTo(TextWriter writer)
	{
		TextFormat.Print(this, writer);
	}

	public ByteString ToByteString()
	{
		ByteString.CodedBuilder codedBuilder = new ByteString.CodedBuilder(SerializedSize);
		WriteTo(codedBuilder.CodedOutput);
		return codedBuilder.Build();
	}

	public byte[] ToByteArray()
	{
		byte[] array = new byte[SerializedSize];
		CodedOutputStream codedOutputStream = CodedOutputStream.CreateInstance(array);
		WriteTo(codedOutputStream);
		codedOutputStream.CheckNoSpaceLeft();
		return array;
	}

	public void WriteTo(Stream output)
	{
		CodedOutputStream codedOutputStream = CodedOutputStream.CreateInstance(output);
		WriteTo(codedOutputStream);
		codedOutputStream.Flush();
	}

	public void WriteAsMessageSetTo(CodedOutputStream output)
	{
		foreach (KeyValuePair<int, UnknownField> field in fields)
		{
			field.Value.WriteAsMessageSetExtensionTo(field.Key, output);
		}
	}

	public override bool Equals(object other)
	{
		if (object.ReferenceEquals(this, other))
		{
			return true;
		}
		if (other is UnknownFieldSet unknownFieldSet)
		{
			return Dictionaries.Equals(fields, unknownFieldSet.fields);
		}
		return false;
	}

	public override int GetHashCode()
	{
		return Dictionaries.GetHashCode(fields);
	}

	public static UnknownFieldSet ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).Build();
	}

	public static UnknownFieldSet ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).Build();
	}

	public static UnknownFieldSet ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).Build();
	}

	public static UnknownFieldSet ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).Build();
	}

	public void WriteDelimitedTo(Stream output)
	{
		CodedOutputStream codedOutputStream = CodedOutputStream.CreateInstance(output);
		codedOutputStream.WriteRawVarint32((uint)SerializedSize);
		WriteTo(codedOutputStream);
		codedOutputStream.Flush();
	}

	public IBuilderLite WeakCreateBuilderForType()
	{
		return new Builder();
	}

	public IBuilderLite WeakToBuilder()
	{
		return new Builder(fields);
	}
}
