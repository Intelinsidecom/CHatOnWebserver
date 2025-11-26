using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class DescriptorProto : GeneratedMessage<DescriptorProto, DescriptorProto.Builder>, IDescriptorProto<MessageOptions>
{
	public static class Types
	{
		public sealed class ExtensionRange : GeneratedMessage<ExtensionRange, ExtensionRange.Builder>
		{
			public sealed class Builder : GeneratedBuilder<ExtensionRange, Builder>
			{
				private ExtensionRange result = new ExtensionRange();

				protected override Builder ThisBuilder => this;

				protected override ExtensionRange MessageBeingBuilt => result;

				public override MessageDescriptor DescriptorForType => Descriptor;

				public override ExtensionRange DefaultInstanceForType => DefaultInstance;

				public bool HasStart => result.HasStart;

				public int Start
				{
					get
					{
						return result.Start;
					}
					set
					{
						SetStart(value);
					}
				}

				public bool HasEnd => result.HasEnd;

				public int End
				{
					get
					{
						return result.End;
					}
					set
					{
						SetEnd(value);
					}
				}

				public override Builder Clear()
				{
					result = new ExtensionRange();
					return this;
				}

				public override Builder Clone()
				{
					return new Builder().MergeFrom(result);
				}

				public override ExtensionRange BuildPartial()
				{
					if (result == null)
					{
						throw new InvalidOperationException("build() has already been called on this Builder");
					}
					ExtensionRange extensionRange = result;
					result = null;
					return extensionRange;
				}

				public override Builder MergeFrom(IMessage other)
				{
					if (other is ExtensionRange)
					{
						return MergeFrom((ExtensionRange)other);
					}
					base.MergeFrom(other);
					return this;
				}

				public override Builder MergeFrom(ExtensionRange other)
				{
					if (other == DefaultInstance)
					{
						return this;
					}
					if (other.HasStart)
					{
						Start = other.Start;
					}
					if (other.HasEnd)
					{
						End = other.End;
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
						case 8u:
							Start = input.ReadInt32();
							continue;
						case 16u:
							End = input.ReadInt32();
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

				public Builder SetStart(int value)
				{
					result.hasStart = true;
					result.start_ = value;
					return this;
				}

				public Builder ClearStart()
				{
					result.hasStart = false;
					result.start_ = 0;
					return this;
				}

				public Builder SetEnd(int value)
				{
					result.hasEnd = true;
					result.end_ = value;
					return this;
				}

				public Builder ClearEnd()
				{
					result.hasEnd = false;
					result.end_ = 0;
					return this;
				}
			}

			public const int StartFieldNumber = 1;

			public const int EndFieldNumber = 2;

			private static readonly ExtensionRange defaultInstance;

			private bool hasStart;

			private int start_;

			private bool hasEnd;

			private int end_;

			private int memoizedSerializedSize = -1;

			public static ExtensionRange DefaultInstance => defaultInstance;

			public override ExtensionRange DefaultInstanceForType => defaultInstance;

			protected override ExtensionRange ThisMessage => this;

			public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_DescriptorProto_ExtensionRange__Descriptor;

			protected override FieldAccessorTable<ExtensionRange, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_DescriptorProto_ExtensionRange__FieldAccessorTable;

			public bool HasStart => hasStart;

			public int Start => start_;

			public bool HasEnd => hasEnd;

			public int End => end_;

			public override bool IsInitialized => true;

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
					if (HasStart)
					{
						num += CodedOutputStream.ComputeInt32Size(1, Start);
					}
					if (HasEnd)
					{
						num += CodedOutputStream.ComputeInt32Size(2, End);
					}
					return memoizedSerializedSize = num + UnknownFields.SerializedSize;
				}
			}

			public override void WriteTo(CodedOutputStream output)
			{
				_ = SerializedSize;
				if (HasStart)
				{
					output.WriteInt32(1, Start);
				}
				if (HasEnd)
				{
					output.WriteInt32(2, End);
				}
				UnknownFields.WriteTo(output);
			}

			public static ExtensionRange ParseFrom(ByteString data)
			{
				return CreateBuilder().MergeFrom(data).BuildParsed();
			}

			public static ExtensionRange ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
			{
				return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
			}

			public static ExtensionRange ParseFrom(byte[] data)
			{
				return CreateBuilder().MergeFrom(data).BuildParsed();
			}

			public static ExtensionRange ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
			{
				return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
			}

			public static ExtensionRange ParseFrom(Stream input)
			{
				return CreateBuilder().MergeFrom(input).BuildParsed();
			}

			public static ExtensionRange ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
			{
				return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
			}

			public static ExtensionRange ParseDelimitedFrom(Stream input)
			{
				return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
			}

			public static ExtensionRange ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
			{
				return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
			}

			public static ExtensionRange ParseFrom(CodedInputStream input)
			{
				return CreateBuilder().MergeFrom(input).BuildParsed();
			}

			public static ExtensionRange ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

			public static Builder CreateBuilder(ExtensionRange prototype)
			{
				return new Builder().MergeFrom(prototype);
			}

			static ExtensionRange()
			{
				defaultInstance = new Builder().BuildPartial();
				object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
			}
		}
	}

	public sealed class Builder : GeneratedBuilder<DescriptorProto, Builder>
	{
		private DescriptorProto result = new DescriptorProto();

		protected override Builder ThisBuilder => this;

		protected override DescriptorProto MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override DescriptorProto DefaultInstanceForType => DefaultInstance;

		public bool HasName => result.HasName;

		public string Name
		{
			get
			{
				return result.Name;
			}
			set
			{
				SetName(value);
			}
		}

		public IPopsicleList<FieldDescriptorProto> FieldList => result.field_;

		public int FieldCount => result.FieldCount;

		public IPopsicleList<FieldDescriptorProto> ExtensionList => result.extension_;

		public int ExtensionCount => result.ExtensionCount;

		public IPopsicleList<DescriptorProto> NestedTypeList => result.nestedType_;

		public int NestedTypeCount => result.NestedTypeCount;

		public IPopsicleList<EnumDescriptorProto> EnumTypeList => result.enumType_;

		public int EnumTypeCount => result.EnumTypeCount;

		public IPopsicleList<Types.ExtensionRange> ExtensionRangeList => result.extensionRange_;

		public int ExtensionRangeCount => result.ExtensionRangeCount;

		public bool HasOptions => result.HasOptions;

		public MessageOptions Options
		{
			get
			{
				return result.Options;
			}
			set
			{
				SetOptions(value);
			}
		}

		public override Builder Clear()
		{
			result = new DescriptorProto();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override DescriptorProto BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.field_.MakeReadOnly();
			result.extension_.MakeReadOnly();
			result.nestedType_.MakeReadOnly();
			result.enumType_.MakeReadOnly();
			result.extensionRange_.MakeReadOnly();
			DescriptorProto descriptorProto = result;
			result = null;
			return descriptorProto;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is DescriptorProto)
			{
				return MergeFrom((DescriptorProto)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(DescriptorProto other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasName)
			{
				Name = other.Name;
			}
			if (other.field_.Count != 0)
			{
				AddRange(other.field_, result.field_);
			}
			if (other.extension_.Count != 0)
			{
				AddRange(other.extension_, result.extension_);
			}
			if (other.nestedType_.Count != 0)
			{
				AddRange(other.nestedType_, result.nestedType_);
			}
			if (other.enumType_.Count != 0)
			{
				AddRange(other.enumType_, result.enumType_);
			}
			if (other.extensionRange_.Count != 0)
			{
				AddRange(other.extensionRange_, result.extensionRange_);
			}
			if (other.HasOptions)
			{
				MergeOptions(other.Options);
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
					Name = input.ReadString();
					continue;
				case 18u:
				{
					FieldDescriptorProto.Builder builder7 = FieldDescriptorProto.CreateBuilder();
					input.ReadMessage(builder7, extensionRegistry);
					AddField(builder7.BuildPartial());
					continue;
				}
				case 26u:
				{
					Builder builder6 = CreateBuilder();
					input.ReadMessage(builder6, extensionRegistry);
					AddNestedType(builder6.BuildPartial());
					continue;
				}
				case 34u:
				{
					EnumDescriptorProto.Builder builder5 = EnumDescriptorProto.CreateBuilder();
					input.ReadMessage(builder5, extensionRegistry);
					AddEnumType(builder5.BuildPartial());
					continue;
				}
				case 42u:
				{
					Types.ExtensionRange.Builder builder4 = Types.ExtensionRange.CreateBuilder();
					input.ReadMessage(builder4, extensionRegistry);
					AddExtensionRange(builder4.BuildPartial());
					continue;
				}
				case 50u:
				{
					FieldDescriptorProto.Builder builder3 = FieldDescriptorProto.CreateBuilder();
					input.ReadMessage(builder3, extensionRegistry);
					AddExtension(builder3.BuildPartial());
					continue;
				}
				case 58u:
				{
					MessageOptions.Builder builder2 = MessageOptions.CreateBuilder();
					if (HasOptions)
					{
						builder2.MergeFrom(Options);
					}
					input.ReadMessage(builder2, extensionRegistry);
					Options = builder2.BuildPartial();
					continue;
				}
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

		public Builder SetName(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasName = true;
			result.name_ = value;
			return this;
		}

		public Builder ClearName()
		{
			result.hasName = false;
			result.name_ = "";
			return this;
		}

		public FieldDescriptorProto GetField(int index)
		{
			return result.GetField(index);
		}

		public Builder SetField(int index, FieldDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.field_[index] = value;
			return this;
		}

		public Builder SetField(int index, FieldDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.field_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddField(FieldDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.field_.Add(value);
			return this;
		}

		public Builder AddField(FieldDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.field_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeField(IEnumerable<FieldDescriptorProto> values)
		{
			AddRange(values, result.field_);
			return this;
		}

		public Builder ClearField()
		{
			result.field_.Clear();
			return this;
		}

		public FieldDescriptorProto GetExtension(int index)
		{
			return result.GetExtension(index);
		}

		public Builder SetExtension(int index, FieldDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.extension_[index] = value;
			return this;
		}

		public Builder SetExtension(int index, FieldDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.extension_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddExtension(FieldDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.extension_.Add(value);
			return this;
		}

		public Builder AddExtension(FieldDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.extension_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeExtension(IEnumerable<FieldDescriptorProto> values)
		{
			AddRange(values, result.extension_);
			return this;
		}

		public Builder ClearExtension()
		{
			result.extension_.Clear();
			return this;
		}

		public DescriptorProto GetNestedType(int index)
		{
			return result.GetNestedType(index);
		}

		public Builder SetNestedType(int index, DescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.nestedType_[index] = value;
			return this;
		}

		public Builder SetNestedType(int index, Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.nestedType_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddNestedType(DescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.nestedType_.Add(value);
			return this;
		}

		public Builder AddNestedType(Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.nestedType_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeNestedType(IEnumerable<DescriptorProto> values)
		{
			AddRange(values, result.nestedType_);
			return this;
		}

		public Builder ClearNestedType()
		{
			result.nestedType_.Clear();
			return this;
		}

		public EnumDescriptorProto GetEnumType(int index)
		{
			return result.GetEnumType(index);
		}

		public Builder SetEnumType(int index, EnumDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.enumType_[index] = value;
			return this;
		}

		public Builder SetEnumType(int index, EnumDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.enumType_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddEnumType(EnumDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.enumType_.Add(value);
			return this;
		}

		public Builder AddEnumType(EnumDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.enumType_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeEnumType(IEnumerable<EnumDescriptorProto> values)
		{
			AddRange(values, result.enumType_);
			return this;
		}

		public Builder ClearEnumType()
		{
			result.enumType_.Clear();
			return this;
		}

		public Types.ExtensionRange GetExtensionRange(int index)
		{
			return result.GetExtensionRange(index);
		}

		public Builder SetExtensionRange(int index, Types.ExtensionRange value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.extensionRange_[index] = value;
			return this;
		}

		public Builder SetExtensionRange(int index, Types.ExtensionRange.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.extensionRange_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddExtensionRange(Types.ExtensionRange value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.extensionRange_.Add(value);
			return this;
		}

		public Builder AddExtensionRange(Types.ExtensionRange.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.extensionRange_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeExtensionRange(IEnumerable<Types.ExtensionRange> values)
		{
			AddRange(values, result.extensionRange_);
			return this;
		}

		public Builder ClearExtensionRange()
		{
			result.extensionRange_.Clear();
			return this;
		}

		public Builder SetOptions(MessageOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasOptions = true;
			result.options_ = value;
			return this;
		}

		public Builder SetOptions(MessageOptions.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.hasOptions = true;
			result.options_ = builderForValue.Build();
			return this;
		}

		public Builder MergeOptions(MessageOptions value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			if (result.HasOptions && result.options_ != MessageOptions.DefaultInstance)
			{
				result.options_ = MessageOptions.CreateBuilder(result.options_).MergeFrom(value).BuildPartial();
			}
			else
			{
				result.options_ = value;
			}
			result.hasOptions = true;
			return this;
		}

		public Builder ClearOptions()
		{
			result.hasOptions = false;
			result.options_ = MessageOptions.DefaultInstance;
			return this;
		}
	}

	public const int NameFieldNumber = 1;

	public const int FieldFieldNumber = 2;

	public const int ExtensionFieldNumber = 6;

	public const int NestedTypeFieldNumber = 3;

	public const int EnumTypeFieldNumber = 4;

	public const int ExtensionRangeFieldNumber = 5;

	public const int OptionsFieldNumber = 7;

	private static readonly DescriptorProto defaultInstance;

	private bool hasName;

	private string name_ = "";

	private PopsicleList<FieldDescriptorProto> field_ = new PopsicleList<FieldDescriptorProto>();

	private PopsicleList<FieldDescriptorProto> extension_ = new PopsicleList<FieldDescriptorProto>();

	private PopsicleList<DescriptorProto> nestedType_ = new PopsicleList<DescriptorProto>();

	private PopsicleList<EnumDescriptorProto> enumType_ = new PopsicleList<EnumDescriptorProto>();

	private PopsicleList<Types.ExtensionRange> extensionRange_ = new PopsicleList<Types.ExtensionRange>();

	private bool hasOptions;

	private MessageOptions options_ = MessageOptions.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static DescriptorProto DefaultInstance => defaultInstance;

	public override DescriptorProto DefaultInstanceForType => defaultInstance;

	protected override DescriptorProto ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_DescriptorProto__Descriptor;

	protected override FieldAccessorTable<DescriptorProto, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_DescriptorProto__FieldAccessorTable;

	public bool HasName => hasName;

	public string Name => name_;

	public IList<FieldDescriptorProto> FieldList => field_;

	public int FieldCount => field_.Count;

	public IList<FieldDescriptorProto> ExtensionList => extension_;

	public int ExtensionCount => extension_.Count;

	public IList<DescriptorProto> NestedTypeList => nestedType_;

	public int NestedTypeCount => nestedType_.Count;

	public IList<EnumDescriptorProto> EnumTypeList => enumType_;

	public int EnumTypeCount => enumType_.Count;

	public IList<Types.ExtensionRange> ExtensionRangeList => extensionRange_;

	public int ExtensionRangeCount => extensionRange_.Count;

	public bool HasOptions => hasOptions;

	public MessageOptions Options => options_;

	public override bool IsInitialized
	{
		get
		{
			foreach (FieldDescriptorProto field in FieldList)
			{
				if (!field.IsInitialized)
				{
					return false;
				}
			}
			foreach (FieldDescriptorProto extension in ExtensionList)
			{
				if (!extension.IsInitialized)
				{
					return false;
				}
			}
			foreach (DescriptorProto nestedType in NestedTypeList)
			{
				if (!nestedType.IsInitialized)
				{
					return false;
				}
			}
			foreach (EnumDescriptorProto enumType in EnumTypeList)
			{
				if (!enumType.IsInitialized)
				{
					return false;
				}
			}
			if (HasOptions && !Options.IsInitialized)
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
			if (HasName)
			{
				num += CodedOutputStream.ComputeStringSize(1, Name);
			}
			foreach (FieldDescriptorProto field in FieldList)
			{
				num += CodedOutputStream.ComputeMessageSize(2, field);
			}
			foreach (FieldDescriptorProto extension in ExtensionList)
			{
				num += CodedOutputStream.ComputeMessageSize(6, extension);
			}
			foreach (DescriptorProto nestedType in NestedTypeList)
			{
				num += CodedOutputStream.ComputeMessageSize(3, nestedType);
			}
			foreach (EnumDescriptorProto enumType in EnumTypeList)
			{
				num += CodedOutputStream.ComputeMessageSize(4, enumType);
			}
			foreach (Types.ExtensionRange extensionRange in ExtensionRangeList)
			{
				num += CodedOutputStream.ComputeMessageSize(5, extensionRange);
			}
			if (HasOptions)
			{
				num += CodedOutputStream.ComputeMessageSize(7, Options);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public FieldDescriptorProto GetField(int index)
	{
		return field_[index];
	}

	public FieldDescriptorProto GetExtension(int index)
	{
		return extension_[index];
	}

	public DescriptorProto GetNestedType(int index)
	{
		return nestedType_[index];
	}

	public EnumDescriptorProto GetEnumType(int index)
	{
		return enumType_[index];
	}

	public Types.ExtensionRange GetExtensionRange(int index)
	{
		return extensionRange_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasName)
		{
			output.WriteString(1, Name);
		}
		foreach (FieldDescriptorProto field in FieldList)
		{
			output.WriteMessage(2, field);
		}
		foreach (DescriptorProto nestedType in NestedTypeList)
		{
			output.WriteMessage(3, nestedType);
		}
		foreach (EnumDescriptorProto enumType in EnumTypeList)
		{
			output.WriteMessage(4, enumType);
		}
		foreach (Types.ExtensionRange extensionRange in ExtensionRangeList)
		{
			output.WriteMessage(5, extensionRange);
		}
		foreach (FieldDescriptorProto extension in ExtensionList)
		{
			output.WriteMessage(6, extension);
		}
		if (HasOptions)
		{
			output.WriteMessage(7, Options);
		}
		UnknownFields.WriteTo(output);
	}

	public static DescriptorProto ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DescriptorProto ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DescriptorProto ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DescriptorProto ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DescriptorProto ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DescriptorProto ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static DescriptorProto ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static DescriptorProto ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static DescriptorProto ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DescriptorProto ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(DescriptorProto prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static DescriptorProto()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
