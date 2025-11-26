using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class NicknameRequest : GeneratedMessage<NicknameRequest, NicknameRequest.Builder>
{
	public sealed class Builder : GeneratedBuilder<NicknameRequest, Builder>
	{
		private NicknameRequest result = new NicknameRequest();

		protected override Builder ThisBuilder => this;

		protected override NicknameRequest MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override NicknameRequest DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<string> UserList => result.user_;

		public int UserCount => result.UserCount;

		public override Builder Clear()
		{
			result = new NicknameRequest();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override NicknameRequest BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.user_.MakeReadOnly();
			NicknameRequest nicknameRequest = result;
			result = null;
			return nicknameRequest;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is NicknameRequest)
			{
				return MergeFrom((NicknameRequest)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(NicknameRequest other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.user_.Count != 0)
			{
				AddRange(other.user_, result.user_);
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
					AddUser(input.ReadString());
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

		public string GetUser(int index)
		{
			return result.GetUser(index);
		}

		public Builder SetUser(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.user_[index] = value;
			return this;
		}

		public Builder AddUser(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.user_.Add(value);
			return this;
		}

		public Builder AddRangeUser(IEnumerable<string> values)
		{
			AddRange(values, result.user_);
			return this;
		}

		public Builder ClearUser()
		{
			result.user_.Clear();
			return this;
		}
	}

	public const int MsgIDFieldNumber = 1;

	public const int UserFieldNumber = 2;

	private static readonly NicknameRequest defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private PopsicleList<string> user_ = new PopsicleList<string>();

	private int memoizedSerializedSize = -1;

	public static NicknameRequest DefaultInstance => defaultInstance;

	public override NicknameRequest DefaultInstanceForType => defaultInstance;

	protected override NicknameRequest ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_NicknameRequest__Descriptor;

	protected override FieldAccessorTable<NicknameRequest, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_NicknameRequest__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public IList<string> UserList => Lists.AsReadOnly(user_);

	public int UserCount => user_.Count;

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
			foreach (string user in UserList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(user);
			}
			num += num2;
			num += user_.Count;
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public string GetUser(int index)
	{
		return user_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasMsgID)
		{
			output.WriteInt64(1, MsgID);
		}
		if (user_.Count > 0)
		{
			foreach (string item in user_)
			{
				output.WriteString(2, item);
			}
		}
		UnknownFields.WriteTo(output);
	}

	public static NicknameRequest ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static NicknameRequest ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static NicknameRequest ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static NicknameRequest ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static NicknameRequest ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static NicknameRequest ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static NicknameRequest ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static NicknameRequest ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static NicknameRequest ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static NicknameRequest ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(NicknameRequest prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static NicknameRequest()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
