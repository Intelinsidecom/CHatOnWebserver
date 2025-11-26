using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class FieldOptions : ExtendableMessage<FieldOptions, FieldOptions.Builder>
{
	public static class Types
	{
		public enum CType
		{
			STRING,
			CORD,
			STRING_PIECE
		}
	}

	public sealed class Builder : ExtendableBuilder<FieldOptions, Builder>
	{
		private FieldOptions result = new FieldOptions();

		protected override Builder ThisBuilder => this;

		protected override FieldOptions MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override FieldOptions DefaultInstanceForType => DefaultInstance;

		public bool HasCtype => result.HasCtype;

		public Types.CType Ctype
		{
			get
			{
				return result.Ctype;
			}
			set
			{
				SetCtype(value);
			}
		}

		public bool HasPacked => result.HasPacked;

		public bool Packed
		{
			get
			{
				return result.Packed;
			}
			set
			{
				SetPacked(value);
			}
		}

		public bool HasDeprecated => result.HasDeprecated;

		public bool Deprecated
		{
			get
			{
				return result.Deprecated;
			}
			set
			{
				SetDeprecated(value);
			}
		}

		public bool HasExperimentalMapKey => result.HasExperimentalMapKey;

		public string ExperimentalMapKey
		{
			get
			{
				return result.ExperimentalMapKey;
			}
			set
			{
				SetExperimentalMapKey(value);
			}
		}

		public IPopsicleList<UninterpretedOption> UninterpretedOptionList => result.uninterpretedOption_;

		public int UninterpretedOptionCount => result.UninterpretedOptionCount;

		public override Builder Clear()
		{
			result = new FieldOptions();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override FieldOptions BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.uninterpretedOption_.MakeReadOnly();
			FieldOptions fieldOptions = result;
			result = null;
			return fieldOptions;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is FieldOptions)
			{
				return MergeFrom((FieldOptions)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(FieldOptions other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasCtype)
			{
				Ctype = other.Ctype;
			}
			if (other.HasPacked)
			{
				Packed = other.Packed;
			}
			if (other.HasDeprecated)
			{
				Deprecated = other.Deprecated;
			}
			if (other.HasExperimentalMapKey)
			{
				ExperimentalMapKey = other.ExperimentalMapKey;
			}
			if (other.uninterpretedOption_.Count != 0)
			{
				AddRange(other.uninterpretedOption_, result.uninterpretedOption_);
			}
			MergeExtensionFields(other);
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
				{
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(Types.CType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(1, (ulong)num2);
					}
					else
					{
						Ctype = (Types.CType)num2;
					}
					continue;
				}
				case 16u:
					Packed = input.ReadBool();
					continue;
				case 24u:
					Deprecated = input.ReadBool();
					continue;
				case 74u:
					ExperimentalMapKey = input.ReadString();
					continue;
				case 7994u:
				{
					UninterpretedOption.Builder builder2 = UninterpretedOption.CreateBuilder();
					input.ReadMessage(builder2, extensionRegistry);
					AddUninterpretedOption(builder2.BuildPartial());
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

		public Builder SetCtype(Types.CType value)
		{
			result.hasCtype = true;
			result.ctype_ = value;
			return this;
		}

		public Builder ClearCtype()
		{
			result.hasCtype = false;
			result.ctype_ = Types.CType.STRING;
			return this;
		}

		public Builder SetPacked(bool value)
		{
			result.hasPacked = true;
			result.packed_ = value;
			return this;
		}

		public Builder ClearPacked()
		{
			result.hasPacked = false;
			result.packed_ = false;
			return this;
		}

		public Builder SetDeprecated(bool value)
		{
			result.hasDeprecated = true;
			result.deprecated_ = value;
			return this;
		}

		public Builder ClearDeprecated()
		{
			result.hasDeprecated = false;
			result.deprecated_ = false;
			return this;
		}

		public Builder SetExperimentalMapKey(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasExperimentalMapKey = true;
			result.experimentalMapKey_ = value;
			return this;
		}

		public Builder ClearExperimentalMapKey()
		{
			result.hasExperimentalMapKey = false;
			result.experimentalMapKey_ = "";
			return this;
		}

		public UninterpretedOption GetUninterpretedOption(int index)
		{
			return result.GetUninterpretedOption(index);
		}

		public Builder SetUninterpretedOption(int index, UninterpretedOption value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.uninterpretedOption_[index] = value;
			return this;
		}

		public Builder SetUninterpretedOption(int index, UninterpretedOption.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.uninterpretedOption_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddUninterpretedOption(UninterpretedOption value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.uninterpretedOption_.Add(value);
			return this;
		}

		public Builder AddUninterpretedOption(UninterpretedOption.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.uninterpretedOption_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeUninterpretedOption(IEnumerable<UninterpretedOption> values)
		{
			AddRange(values, result.uninterpretedOption_);
			return this;
		}

		public Builder ClearUninterpretedOption()
		{
			result.uninterpretedOption_.Clear();
			return this;
		}
	}

	public const int CtypeFieldNumber = 1;

	public const int PackedFieldNumber = 2;

	public const int DeprecatedFieldNumber = 3;

	public const int ExperimentalMapKeyFieldNumber = 9;

	public const int UninterpretedOptionFieldNumber = 999;

	private static readonly FieldOptions defaultInstance;

	private bool hasCtype;

	private Types.CType ctype_;

	private bool hasPacked;

	private bool packed_;

	private bool hasDeprecated;

	private bool deprecated_;

	private bool hasExperimentalMapKey;

	private string experimentalMapKey_ = "";

	private PopsicleList<UninterpretedOption> uninterpretedOption_ = new PopsicleList<UninterpretedOption>();

	private int memoizedSerializedSize = -1;

	public static FieldOptions DefaultInstance => defaultInstance;

	public override FieldOptions DefaultInstanceForType => defaultInstance;

	protected override FieldOptions ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_FieldOptions__Descriptor;

	protected override FieldAccessorTable<FieldOptions, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_FieldOptions__FieldAccessorTable;

	public bool HasCtype => hasCtype;

	public Types.CType Ctype => ctype_;

	public bool HasPacked => hasPacked;

	public bool Packed => packed_;

	public bool HasDeprecated => hasDeprecated;

	public bool Deprecated => deprecated_;

	public bool HasExperimentalMapKey => hasExperimentalMapKey;

	public string ExperimentalMapKey => experimentalMapKey_;

	public IList<UninterpretedOption> UninterpretedOptionList => uninterpretedOption_;

	public int UninterpretedOptionCount => uninterpretedOption_.Count;

	public override bool IsInitialized
	{
		get
		{
			foreach (UninterpretedOption uninterpretedOption in UninterpretedOptionList)
			{
				if (!uninterpretedOption.IsInitialized)
				{
					return false;
				}
			}
			if (!base.ExtensionsAreInitialized)
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
			if (HasCtype)
			{
				num += CodedOutputStream.ComputeEnumSize(1, (int)Ctype);
			}
			if (HasPacked)
			{
				num += CodedOutputStream.ComputeBoolSize(2, Packed);
			}
			if (HasDeprecated)
			{
				num += CodedOutputStream.ComputeBoolSize(3, Deprecated);
			}
			if (HasExperimentalMapKey)
			{
				num += CodedOutputStream.ComputeStringSize(9, ExperimentalMapKey);
			}
			foreach (UninterpretedOption uninterpretedOption in UninterpretedOptionList)
			{
				num += CodedOutputStream.ComputeMessageSize(999, uninterpretedOption);
			}
			num += base.ExtensionsSerializedSize;
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public UninterpretedOption GetUninterpretedOption(int index)
	{
		return uninterpretedOption_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		ExtensionWriter extensionWriter = CreateExtensionWriter(this);
		if (HasCtype)
		{
			output.WriteEnum(1, (int)Ctype);
		}
		if (HasPacked)
		{
			output.WriteBool(2, Packed);
		}
		if (HasDeprecated)
		{
			output.WriteBool(3, Deprecated);
		}
		if (HasExperimentalMapKey)
		{
			output.WriteString(9, ExperimentalMapKey);
		}
		foreach (UninterpretedOption uninterpretedOption in UninterpretedOptionList)
		{
			output.WriteMessage(999, uninterpretedOption);
		}
		extensionWriter.WriteUntil(536870912, output);
		UnknownFields.WriteTo(output);
	}

	public static FieldOptions ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static FieldOptions ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static FieldOptions ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static FieldOptions ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static FieldOptions ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static FieldOptions ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static FieldOptions ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static FieldOptions ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static FieldOptions ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static FieldOptions ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(FieldOptions prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static FieldOptions()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
