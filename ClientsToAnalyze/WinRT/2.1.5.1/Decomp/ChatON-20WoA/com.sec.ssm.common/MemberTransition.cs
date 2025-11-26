using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class MemberTransition : GeneratedMessage<MemberTransition, MemberTransition.Builder>
{
	public sealed class Builder : GeneratedBuilder<MemberTransition, Builder>
	{
		private MemberTransition result = new MemberTransition();

		protected override Builder ThisBuilder => this;

		protected override MemberTransition MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override MemberTransition DefaultInstanceForType => DefaultInstance;

		public bool HasPreviousMember => result.HasPreviousMember;

		public string PreviousMember
		{
			get
			{
				return result.PreviousMember;
			}
			set
			{
				SetPreviousMember(value);
			}
		}

		public bool HasTransitedMember => result.HasTransitedMember;

		public string TransitedMember
		{
			get
			{
				return result.TransitedMember;
			}
			set
			{
				SetTransitedMember(value);
			}
		}

		public override Builder Clear()
		{
			result = new MemberTransition();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override MemberTransition BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			MemberTransition memberTransition = result;
			result = null;
			return memberTransition;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is MemberTransition)
			{
				return MergeFrom((MemberTransition)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(MemberTransition other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasPreviousMember)
			{
				PreviousMember = other.PreviousMember;
			}
			if (other.HasTransitedMember)
			{
				TransitedMember = other.TransitedMember;
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
					PreviousMember = input.ReadString();
					continue;
				case 18u:
					TransitedMember = input.ReadString();
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

		public Builder SetPreviousMember(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasPreviousMember = true;
			result.previousMember_ = value;
			return this;
		}

		public Builder ClearPreviousMember()
		{
			result.hasPreviousMember = false;
			result.previousMember_ = "";
			return this;
		}

		public Builder SetTransitedMember(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasTransitedMember = true;
			result.transitedMember_ = value;
			return this;
		}

		public Builder ClearTransitedMember()
		{
			result.hasTransitedMember = false;
			result.transitedMember_ = "";
			return this;
		}
	}

	public const int PreviousMemberFieldNumber = 1;

	public const int TransitedMemberFieldNumber = 2;

	private static readonly MemberTransition defaultInstance;

	private bool hasPreviousMember;

	private string previousMember_ = "";

	private bool hasTransitedMember;

	private string transitedMember_ = "";

	private int memoizedSerializedSize = -1;

	public static MemberTransition DefaultInstance => defaultInstance;

	public override MemberTransition DefaultInstanceForType => defaultInstance;

	protected override MemberTransition ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_MemberTransition__Descriptor;

	protected override FieldAccessorTable<MemberTransition, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_MemberTransition__FieldAccessorTable;

	public bool HasPreviousMember => hasPreviousMember;

	public string PreviousMember => previousMember_;

	public bool HasTransitedMember => hasTransitedMember;

	public string TransitedMember => transitedMember_;

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
			if (HasPreviousMember)
			{
				num += CodedOutputStream.ComputeStringSize(1, PreviousMember);
			}
			if (HasTransitedMember)
			{
				num += CodedOutputStream.ComputeStringSize(2, TransitedMember);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasPreviousMember)
		{
			output.WriteString(1, PreviousMember);
		}
		if (HasTransitedMember)
		{
			output.WriteString(2, TransitedMember);
		}
		UnknownFields.WriteTo(output);
	}

	public static MemberTransition ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static MemberTransition ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static MemberTransition ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static MemberTransition ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static MemberTransition ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static MemberTransition ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static MemberTransition ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static MemberTransition ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static MemberTransition ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static MemberTransition ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(MemberTransition prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static MemberTransition()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
