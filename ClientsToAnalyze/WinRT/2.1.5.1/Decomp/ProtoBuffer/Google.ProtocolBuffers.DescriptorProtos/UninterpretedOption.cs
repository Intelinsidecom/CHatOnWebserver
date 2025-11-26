using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class UninterpretedOption : GeneratedMessage<UninterpretedOption, UninterpretedOption.Builder>
{
	public static class Types
	{
		public sealed class NamePart : GeneratedMessage<NamePart, NamePart.Builder>
		{
			public sealed class Builder : GeneratedBuilder<NamePart, Builder>
			{
				private NamePart result = new NamePart();

				protected override Builder ThisBuilder => this;

				protected override NamePart MessageBeingBuilt => result;

				public override MessageDescriptor DescriptorForType => Descriptor;

				public override NamePart DefaultInstanceForType => DefaultInstance;

				public bool HasNamePart_ => result.HasNamePart_;

				public string NamePart_
				{
					get
					{
						return result.NamePart_;
					}
					set
					{
						SetNamePart_(value);
					}
				}

				public bool HasIsExtension => result.HasIsExtension;

				public bool IsExtension
				{
					get
					{
						return result.IsExtension;
					}
					set
					{
						SetIsExtension(value);
					}
				}

				public override Builder Clear()
				{
					result = new NamePart();
					return this;
				}

				public override Builder Clone()
				{
					return new Builder().MergeFrom(result);
				}

				public override NamePart BuildPartial()
				{
					if (result == null)
					{
						throw new InvalidOperationException("build() has already been called on this Builder");
					}
					NamePart namePart = result;
					result = null;
					return namePart;
				}

				public override Builder MergeFrom(IMessage other)
				{
					if (other is NamePart)
					{
						return MergeFrom((NamePart)other);
					}
					base.MergeFrom(other);
					return this;
				}

				public override Builder MergeFrom(NamePart other)
				{
					if (other == DefaultInstance)
					{
						return this;
					}
					if (other.HasNamePart_)
					{
						NamePart_ = other.NamePart_;
					}
					if (other.HasIsExtension)
					{
						IsExtension = other.IsExtension;
					}
					MergeUnknownFields(other.UnknownFields);
					return this;
				}

				public override Builder MergeFrom(CodedInputStream input)
				{
					return MergeFrom(input, ExtensionRegistry.Empty);
				}

				public override Builder MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
				{
					UnknownFieldSet.Builder builder = null;
					while (true)
					{
						uint num = input.ReadTag();
						switch (num)
						{
						case 0u:
							if (builder != null)
							{
								UnknownFields = builder.Build();
							}
							return this;
						case 10u:
							NamePart_ = input.ReadString();
							continue;
						case 16u:
							IsExtension = input.ReadBool();
							continue;
						}
						if (WireFormat.IsEndGroupTag(num))
						{
							if (builder != null)
							{
								UnknownFields = builder.Build();
							}
							return this;
						}
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						ParseUnknownField(input, builder, extensionRegistry, num);
					}
				}

				public Builder SetNamePart_(string value)
				{
					ThrowHelper.ThrowIfNull(value, "value");
					result.hasNamePart_ = true;
					result.namePart_ = value;
					return this;
				}

				public Builder ClearNamePart_()
				{
					result.hasNamePart_ = false;
					result.namePart_ = "";
					return this;
				}

				public Builder SetIsExtension(bool value)
				{
					result.hasIsExtension = true;
					result.isExtension_ = value;
					return this;
				}

				public Builder ClearIsExtension()
				{
					result.hasIsExtension = false;
					result.isExtension_ = false;
					return this;
				}
			}

			public const int NamePart_FieldNumber = 1;

			public const int IsExtensionFieldNumber = 2;

			private static readonly NamePart defaultInstance;

			private bool hasNamePart_;

			private string namePart_ = "";

			private bool hasIsExtension;

			private bool isExtension_;

			private int memoizedSerializedSize = -1;

			public static NamePart DefaultInstance => defaultInstance;

			public override NamePart DefaultInstanceForType => defaultInstance;

			protected override NamePart ThisMessage => this;

			public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_UninterpretedOption_NamePart__Descriptor;

			protected override FieldAccessorTable<NamePart, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_UninterpretedOption_NamePart__FieldAccessorTable;

			public bool HasNamePart_ => hasNamePart_;

			public string NamePart_ => namePart_;

			public bool HasIsExtension => hasIsExtension;

			public bool IsExtension => isExtension_;

			public override bool IsInitialized
			{
				get
				{
					if (!hasNamePart_)
					{
						return false;
					}
					if (!hasIsExtension)
					{
						return false;
					}
					return true;
				}
			}

			public override int SerializedSize
			{
				get
				{
					int num = memoizedSerializedSize;
					if (num != -1)
					{
						return num;
					}
					num = 0;
					if (HasNamePart_)
					{
						num += CodedOutputStream.ComputeStringSize(1, NamePart_);
					}
					if (HasIsExtension)
					{
						num += CodedOutputStream.ComputeBoolSize(2, IsExtension);
					}
					return memoizedSerializedSize = num + UnknownFields.SerializedSize;
				}
			}

			public override void WriteTo(CodedOutputStream output)
			{
				_ = SerializedSize;
				if (HasNamePart_)
				{
					output.WriteString(1, NamePart_);
				}
				if (HasIsExtension)
				{
					output.WriteBool(2, IsExtension);
				}
				UnknownFields.WriteTo(output);
			}

			public static NamePart ParseFrom(ByteString data)
			{
				return CreateBuilder().MergeFrom(data).BuildParsed();
			}

			public static NamePart ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
			{
				return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
			}

			public static NamePart ParseFrom(byte[] data)
			{
				return CreateBuilder().MergeFrom(data).BuildParsed();
			}

			public static NamePart ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
			{
				return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
			}

			public static NamePart ParseFrom(Stream input)
			{
				return CreateBuilder().MergeFrom(input).BuildParsed();
			}

			public static NamePart ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
			{
				return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
			}

			public static NamePart ParseDelimitedFrom(Stream input)
			{
				return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
			}

			public static NamePart ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
			{
				return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
			}

			public static NamePart ParseFrom(CodedInputStream input)
			{
				return CreateBuilder().MergeFrom(input).BuildParsed();
			}

			public static NamePart ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
			{
				return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
			}

			public static Builder CreateBuilder()
			{
				return new Builder();
			}

			public override Builder ToBuilder()
			{
				return CreateBuilder(this);
			}

			public override Builder CreateBuilderForType()
			{
				return new Builder();
			}

			public static Builder CreateBuilder(NamePart prototype)
			{
				return new Builder().MergeFrom(prototype);
			}

			static NamePart()
			{
				defaultInstance = new Builder().BuildPartial();
				object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
			}
		}
	}

	public sealed class Builder : GeneratedBuilder<UninterpretedOption, Builder>
	{
		private UninterpretedOption result = new UninterpretedOption();

		protected override Builder ThisBuilder => this;

		protected override UninterpretedOption MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override UninterpretedOption DefaultInstanceForType => DefaultInstance;

		public IPopsicleList<Types.NamePart> NameList => result.name_;

		public int NameCount => result.NameCount;

		public bool HasIdentifierValue => result.HasIdentifierValue;

		public string IdentifierValue
		{
			get
			{
				return result.IdentifierValue;
			}
			set
			{
				SetIdentifierValue(value);
			}
		}

		public bool HasPositiveIntValue => result.HasPositiveIntValue;

		[CLSCompliant(false)]
		public ulong PositiveIntValue
		{
			get
			{
				return result.PositiveIntValue;
			}
			set
			{
				SetPositiveIntValue(value);
			}
		}

		public bool HasNegativeIntValue => result.HasNegativeIntValue;

		public long NegativeIntValue
		{
			get
			{
				return result.NegativeIntValue;
			}
			set
			{
				SetNegativeIntValue(value);
			}
		}

		public bool HasDoubleValue => result.HasDoubleValue;

		public double DoubleValue
		{
			get
			{
				return result.DoubleValue;
			}
			set
			{
				SetDoubleValue(value);
			}
		}

		public bool HasStringValue => result.HasStringValue;

		public ByteString StringValue
		{
			get
			{
				return result.StringValue;
			}
			set
			{
				SetStringValue(value);
			}
		}

		public override Builder Clear()
		{
			result = new UninterpretedOption();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override UninterpretedOption BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.name_.MakeReadOnly();
			UninterpretedOption uninterpretedOption = result;
			result = null;
			return uninterpretedOption;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is UninterpretedOption)
			{
				return MergeFrom((UninterpretedOption)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(UninterpretedOption other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.name_.Count != 0)
			{
				AddRange(other.name_, result.name_);
			}
			if (other.HasIdentifierValue)
			{
				IdentifierValue = other.IdentifierValue;
			}
			if (other.HasPositiveIntValue)
			{
				PositiveIntValue = other.PositiveIntValue;
			}
			if (other.HasNegativeIntValue)
			{
				NegativeIntValue = other.NegativeIntValue;
			}
			if (other.HasDoubleValue)
			{
				DoubleValue = other.DoubleValue;
			}
			if (other.HasStringValue)
			{
				StringValue = other.StringValue;
			}
			MergeUnknownFields(other.UnknownFields);
			return this;
		}

		public override Builder MergeFrom(CodedInputStream input)
		{
			return MergeFrom(input, ExtensionRegistry.Empty);
		}

		public override Builder MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
		{
			UnknownFieldSet.Builder builder = null;
			while (true)
			{
				uint num = input.ReadTag();
				switch (num)
				{
				case 0u:
					if (builder != null)
					{
						UnknownFields = builder.Build();
					}
					return this;
				case 18u:
				{
					Types.NamePart.Builder builder2 = Types.NamePart.CreateBuilder();
					input.ReadMessage(builder2, extensionRegistry);
					AddName(builder2.BuildPartial());
					continue;
				}
				case 26u:
					IdentifierValue = input.ReadString();
					continue;
				case 32u:
					PositiveIntValue = input.ReadUInt64();
					continue;
				case 40u:
					NegativeIntValue = input.ReadInt64();
					continue;
				case 49u:
					DoubleValue = input.ReadDouble();
					continue;
				case 58u:
					StringValue = input.ReadBytes();
					continue;
				}
				if (WireFormat.IsEndGroupTag(num))
				{
					if (builder != null)
					{
						UnknownFields = builder.Build();
					}
					return this;
				}
				if (builder == null)
				{
					builder = UnknownFieldSet.CreateBuilder(UnknownFields);
				}
				ParseUnknownField(input, builder, extensionRegistry, num);
			}
		}

		public Types.NamePart GetName(int index)
		{
			return result.GetName(index);
		}

		public Builder SetName(int index, Types.NamePart value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.name_[index] = value;
			return this;
		}

		public Builder SetName(int index, Types.NamePart.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.name_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddName(Types.NamePart value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.name_.Add(value);
			return this;
		}

		public Builder AddName(Types.NamePart.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.name_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeName(IEnumerable<Types.NamePart> values)
		{
			AddRange(values, result.name_);
			return this;
		}

		public Builder ClearName()
		{
			result.name_.Clear();
			return this;
		}

		public Builder SetIdentifierValue(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasIdentifierValue = true;
			result.identifierValue_ = value;
			return this;
		}

		public Builder ClearIdentifierValue()
		{
			result.hasIdentifierValue = false;
			result.identifierValue_ = "";
			return this;
		}

		[CLSCompliant(false)]
		public Builder SetPositiveIntValue(ulong value)
		{
			result.hasPositiveIntValue = true;
			result.positiveIntValue_ = value;
			return this;
		}

		public Builder ClearPositiveIntValue()
		{
			result.hasPositiveIntValue = false;
			result.positiveIntValue_ = 0uL;
			return this;
		}

		public Builder SetNegativeIntValue(long value)
		{
			result.hasNegativeIntValue = true;
			result.negativeIntValue_ = value;
			return this;
		}

		public Builder ClearNegativeIntValue()
		{
			result.hasNegativeIntValue = false;
			result.negativeIntValue_ = 0L;
			return this;
		}

		public Builder SetDoubleValue(double value)
		{
			result.hasDoubleValue = true;
			result.doubleValue_ = value;
			return this;
		}

		public Builder ClearDoubleValue()
		{
			result.hasDoubleValue = false;
			result.doubleValue_ = 0.0;
			return this;
		}

		public Builder SetStringValue(ByteString value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasStringValue = true;
			result.stringValue_ = value;
			return this;
		}

		public Builder ClearStringValue()
		{
			result.hasStringValue = false;
			result.stringValue_ = ByteString.Empty;
			return this;
		}
	}

	public const int NameFieldNumber = 2;

	public const int IdentifierValueFieldNumber = 3;

	public const int PositiveIntValueFieldNumber = 4;

	public const int NegativeIntValueFieldNumber = 5;

	public const int DoubleValueFieldNumber = 6;

	public const int StringValueFieldNumber = 7;

	private static readonly UninterpretedOption defaultInstance;

	private PopsicleList<Types.NamePart> name_ = new PopsicleList<Types.NamePart>();

	private bool hasIdentifierValue;

	private string identifierValue_ = "";

	private bool hasPositiveIntValue;

	private ulong positiveIntValue_;

	private bool hasNegativeIntValue;

	private long negativeIntValue_;

	private bool hasDoubleValue;

	private double doubleValue_;

	private bool hasStringValue;

	private ByteString stringValue_ = ByteString.Empty;

	private int memoizedSerializedSize = -1;

	public static UninterpretedOption DefaultInstance => defaultInstance;

	public override UninterpretedOption DefaultInstanceForType => defaultInstance;

	protected override UninterpretedOption ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_UninterpretedOption__Descriptor;

	protected override FieldAccessorTable<UninterpretedOption, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_UninterpretedOption__FieldAccessorTable;

	public IList<Types.NamePart> NameList => name_;

	public int NameCount => name_.Count;

	public bool HasIdentifierValue => hasIdentifierValue;

	public string IdentifierValue => identifierValue_;

	public bool HasPositiveIntValue => hasPositiveIntValue;

	[CLSCompliant(false)]
	public ulong PositiveIntValue => positiveIntValue_;

	public bool HasNegativeIntValue => hasNegativeIntValue;

	public long NegativeIntValue => negativeIntValue_;

	public bool HasDoubleValue => hasDoubleValue;

	public double DoubleValue => doubleValue_;

	public bool HasStringValue => hasStringValue;

	public ByteString StringValue => stringValue_;

	public override bool IsInitialized
	{
		get
		{
			foreach (Types.NamePart name in NameList)
			{
				if (!name.IsInitialized)
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
			int num = memoizedSerializedSize;
			if (num != -1)
			{
				return num;
			}
			num = 0;
			foreach (Types.NamePart name in NameList)
			{
				num += CodedOutputStream.ComputeMessageSize(2, name);
			}
			if (HasIdentifierValue)
			{
				num += CodedOutputStream.ComputeStringSize(3, IdentifierValue);
			}
			if (HasPositiveIntValue)
			{
				num += CodedOutputStream.ComputeUInt64Size(4, PositiveIntValue);
			}
			if (HasNegativeIntValue)
			{
				num += CodedOutputStream.ComputeInt64Size(5, NegativeIntValue);
			}
			if (HasDoubleValue)
			{
				num += CodedOutputStream.ComputeDoubleSize(6, DoubleValue);
			}
			if (HasStringValue)
			{
				num += CodedOutputStream.ComputeBytesSize(7, StringValue);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public Types.NamePart GetName(int index)
	{
		return name_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		foreach (Types.NamePart name in NameList)
		{
			output.WriteMessage(2, name);
		}
		if (HasIdentifierValue)
		{
			output.WriteString(3, IdentifierValue);
		}
		if (HasPositiveIntValue)
		{
			output.WriteUInt64(4, PositiveIntValue);
		}
		if (HasNegativeIntValue)
		{
			output.WriteInt64(5, NegativeIntValue);
		}
		if (HasDoubleValue)
		{
			output.WriteDouble(6, DoubleValue);
		}
		if (HasStringValue)
		{
			output.WriteBytes(7, StringValue);
		}
		UnknownFields.WriteTo(output);
	}

	public static UninterpretedOption ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static UninterpretedOption ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static UninterpretedOption ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static UninterpretedOption ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static UninterpretedOption ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static UninterpretedOption ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static UninterpretedOption ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static UninterpretedOption ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static UninterpretedOption ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static UninterpretedOption ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static Builder CreateBuilder()
	{
		return new Builder();
	}

	public override Builder ToBuilder()
	{
		return CreateBuilder(this);
	}

	public override Builder CreateBuilderForType()
	{
		return new Builder();
	}

	public static Builder CreateBuilder(UninterpretedOption prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static UninterpretedOption()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
