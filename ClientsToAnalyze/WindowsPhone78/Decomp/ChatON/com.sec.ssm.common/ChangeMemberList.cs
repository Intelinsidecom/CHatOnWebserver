using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class ChangeMemberList : GeneratedMessage<ChangeMemberList, ChangeMemberList.Builder>
{
	public sealed class Builder : GeneratedBuilder<ChangeMemberList, Builder>
	{
		private ChangeMemberList result = new ChangeMemberList();

		protected override Builder ThisBuilder => this;

		protected override ChangeMemberList MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override ChangeMemberList DefaultInstanceForType => DefaultInstance;

		public bool HasStatus => result.HasStatus;

		public ChangeStatus Status
		{
			get
			{
				return result.Status;
			}
			set
			{
				SetStatus(value);
			}
		}

		public bool HasMember => result.HasMember;

		public string Member
		{
			get
			{
				return result.Member;
			}
			set
			{
				SetMember(value);
			}
		}

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

		public override Builder Clear()
		{
			result = new ChangeMemberList();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override ChangeMemberList BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			ChangeMemberList changeMemberList = result;
			result = null;
			return changeMemberList;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is ChangeMemberList)
			{
				return MergeFrom((ChangeMemberList)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(ChangeMemberList other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasStatus)
			{
				Status = other.Status;
			}
			if (other.HasMember)
			{
				Member = other.Member;
			}
			if (other.HasName)
			{
				Name = other.Name;
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
				{
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(ChangeStatus), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(1, (ulong)num2);
					}
					else
					{
						Status = (ChangeStatus)num2;
					}
					continue;
				}
				case 18u:
					Member = input.ReadString();
					continue;
				case 26u:
					Name = input.ReadString();
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

		public Builder SetStatus(ChangeStatus value)
		{
			result.hasStatus = true;
			result.status_ = value;
			return this;
		}

		public Builder ClearStatus()
		{
			result.hasStatus = false;
			result.status_ = ChangeStatus.ENTER;
			return this;
		}

		public Builder SetMember(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasMember = true;
			result.member_ = value;
			return this;
		}

		public Builder ClearMember()
		{
			result.hasMember = false;
			result.member_ = "";
			return this;
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
	}

	public const int StatusFieldNumber = 1;

	public const int MemberFieldNumber = 2;

	public const int NameFieldNumber = 3;

	private static readonly ChangeMemberList defaultInstance;

	private bool hasStatus;

	private ChangeStatus status_;

	private bool hasMember;

	private string member_ = "";

	private bool hasName;

	private string name_ = "";

	private int memoizedSerializedSize = -1;

	public static ChangeMemberList DefaultInstance => defaultInstance;

	public override ChangeMemberList DefaultInstanceForType => defaultInstance;

	protected override ChangeMemberList ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_ChangeMemberList__Descriptor;

	protected override FieldAccessorTable<ChangeMemberList, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_ChangeMemberList__FieldAccessorTable;

	public bool HasStatus => hasStatus;

	public ChangeStatus Status => status_;

	public bool HasMember => hasMember;

	public string Member => member_;

	public bool HasName => hasName;

	public string Name => name_;

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
			if (HasStatus)
			{
				num += CodedOutputStream.ComputeEnumSize(1, (int)Status);
			}
			if (HasMember)
			{
				num += CodedOutputStream.ComputeStringSize(2, Member);
			}
			if (HasName)
			{
				num += CodedOutputStream.ComputeStringSize(3, Name);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasStatus)
		{
			output.WriteEnum(1, (int)Status);
		}
		if (HasMember)
		{
			output.WriteString(2, Member);
		}
		if (HasName)
		{
			output.WriteString(3, Name);
		}
		UnknownFields.WriteTo(output);
	}

	public static ChangeMemberList ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static ChangeMemberList ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static ChangeMemberList ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static ChangeMemberList ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static ChangeMemberList ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static ChangeMemberList ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static ChangeMemberList ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static ChangeMemberList ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static ChangeMemberList ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static ChangeMemberList ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(ChangeMemberList prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static ChangeMemberList()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
