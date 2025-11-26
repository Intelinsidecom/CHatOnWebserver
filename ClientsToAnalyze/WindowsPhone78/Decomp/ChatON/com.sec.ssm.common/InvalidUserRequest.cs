using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class InvalidUserRequest : GeneratedMessage<InvalidUserRequest, InvalidUserRequest.Builder>
{
	public sealed class Builder : GeneratedBuilder<InvalidUserRequest, Builder>
	{
		private InvalidUserRequest result = new InvalidUserRequest();

		protected override Builder ThisBuilder => this;

		protected override InvalidUserRequest MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override InvalidUserRequest DefaultInstanceForType => DefaultInstance;

		public bool HasMsgID => result.HasMsgID;

		public long MsgID
		{
			get
			{
				return result.MsgID;
			}
			set
			{
				SetMsgID(value);
			}
		}

		public IPopsicleList<string> UsersList => result.users_;

		public int UsersCount => result.UsersCount;

		public override Builder Clear()
		{
			result = new InvalidUserRequest();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override InvalidUserRequest BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.users_.MakeReadOnly();
			InvalidUserRequest invalidUserRequest = result;
			result = null;
			return invalidUserRequest;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is InvalidUserRequest)
			{
				return MergeFrom((InvalidUserRequest)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(InvalidUserRequest other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.users_.Count != 0)
			{
				AddRange(other.users_, result.users_);
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
					MsgID = input.ReadInt64();
					continue;
				case 18u:
					AddUsers(input.ReadString());
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

		public Builder SetMsgID(long value)
		{
			result.hasMsgID = true;
			result.msgID_ = value;
			return this;
		}

		public Builder ClearMsgID()
		{
			result.hasMsgID = false;
			result.msgID_ = 0L;
			return this;
		}

		public string GetUsers(int index)
		{
			return result.GetUsers(index);
		}

		public Builder SetUsers(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.users_[index] = value;
			return this;
		}

		public Builder AddUsers(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.users_.Add(value);
			return this;
		}

		public Builder AddRangeUsers(IEnumerable<string> values)
		{
			AddRange(values, result.users_);
			return this;
		}

		public Builder ClearUsers()
		{
			result.users_.Clear();
			return this;
		}
	}

	public const int MsgIDFieldNumber = 1;

	public const int UsersFieldNumber = 2;

	private static readonly InvalidUserRequest defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private PopsicleList<string> users_ = new PopsicleList<string>();

	private int memoizedSerializedSize = -1;

	public static InvalidUserRequest DefaultInstance => defaultInstance;

	public override InvalidUserRequest DefaultInstanceForType => defaultInstance;

	protected override InvalidUserRequest ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_InvalidUserRequest__Descriptor;

	protected override FieldAccessorTable<InvalidUserRequest, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_InvalidUserRequest__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public IList<string> UsersList => Lists.AsReadOnly(users_);

	public int UsersCount => users_.Count;

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
			if (HasMsgID)
			{
				num += CodedOutputStream.ComputeInt64Size(1, MsgID);
			}
			int num2 = 0;
			foreach (string users in UsersList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(users);
			}
			num += num2;
			num += users_.Count;
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public string GetUsers(int index)
	{
		return users_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasMsgID)
		{
			output.WriteInt64(1, MsgID);
		}
		if (users_.Count > 0)
		{
			foreach (string item in users_)
			{
				output.WriteString(2, item);
			}
		}
		UnknownFields.WriteTo(output);
	}

	public static InvalidUserRequest ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InvalidUserRequest ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InvalidUserRequest ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InvalidUserRequest ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InvalidUserRequest ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InvalidUserRequest ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static InvalidUserRequest ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static InvalidUserRequest ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static InvalidUserRequest ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InvalidUserRequest ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(InvalidUserRequest prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static InvalidUserRequest()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
