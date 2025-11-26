using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class InvalidUserReply : GeneratedMessage<InvalidUserReply, InvalidUserReply.Builder>
{
	public sealed class Builder : GeneratedBuilder<InvalidUserReply, Builder>
	{
		private InvalidUserReply result = new InvalidUserReply();

		protected override Builder ThisBuilder => this;

		protected override InvalidUserReply MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override InvalidUserReply DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<string> InvalidUsersList => result.invalidUsers_;

		public int InvalidUsersCount => result.InvalidUsersCount;

		public bool HasResult => result.HasResult;

		public Result Result
		{
			get
			{
				return result.Result;
			}
			set
			{
				SetResult(value);
			}
		}

		public override Builder Clear()
		{
			result = new InvalidUserReply();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override InvalidUserReply BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.invalidUsers_.MakeReadOnly();
			InvalidUserReply invalidUserReply = result;
			result = null;
			return invalidUserReply;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is InvalidUserReply)
			{
				return MergeFrom((InvalidUserReply)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(InvalidUserReply other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.invalidUsers_.Count != 0)
			{
				AddRange(other.invalidUsers_, result.invalidUsers_);
			}
			if (other.HasResult)
			{
				MergeResult(other.Result);
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
					AddInvalidUsers(input.ReadString());
					continue;
				case 26u:
				{
					Result.Builder builder2 = Result.CreateBuilder();
					if (HasResult)
					{
						builder2.MergeFrom(Result);
					}
					input.ReadMessage(builder2, extensionRegistry);
					Result = builder2.BuildPartial();
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

		public string GetInvalidUsers(int index)
		{
			return result.GetInvalidUsers(index);
		}

		public Builder SetInvalidUsers(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.invalidUsers_[index] = value;
			return this;
		}

		public Builder AddInvalidUsers(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.invalidUsers_.Add(value);
			return this;
		}

		public Builder AddRangeInvalidUsers(IEnumerable<string> values)
		{
			AddRange(values, result.invalidUsers_);
			return this;
		}

		public Builder ClearInvalidUsers()
		{
			result.invalidUsers_.Clear();
			return this;
		}

		public Builder SetResult(Result value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasResult = true;
			result.result_ = value;
			return this;
		}

		public Builder SetResult(Result.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.hasResult = true;
			result.result_ = builderForValue.Build();
			return this;
		}

		public Builder MergeResult(Result value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			if (result.HasResult && result.result_ != Result.DefaultInstance)
			{
				result.result_ = Result.CreateBuilder(result.result_).MergeFrom(value).BuildPartial();
			}
			else
			{
				result.result_ = value;
			}
			result.hasResult = true;
			return this;
		}

		public Builder ClearResult()
		{
			result.hasResult = false;
			result.result_ = Result.DefaultInstance;
			return this;
		}
	}

	public const int MsgIDFieldNumber = 1;

	public const int InvalidUsersFieldNumber = 2;

	public const int ResultFieldNumber = 3;

	private static readonly InvalidUserReply defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private PopsicleList<string> invalidUsers_ = new PopsicleList<string>();

	private bool hasResult;

	private Result result_ = Result.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static InvalidUserReply DefaultInstance => defaultInstance;

	public override InvalidUserReply DefaultInstanceForType => defaultInstance;

	protected override InvalidUserReply ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_InvalidUserReply__Descriptor;

	protected override FieldAccessorTable<InvalidUserReply, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_InvalidUserReply__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public IList<string> InvalidUsersList => Lists.AsReadOnly(invalidUsers_);

	public int InvalidUsersCount => invalidUsers_.Count;

	public bool HasResult => hasResult;

	public Result Result => result_;

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
			foreach (string invalidUsers in InvalidUsersList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(invalidUsers);
			}
			num += num2;
			num += invalidUsers_.Count;
			if (HasResult)
			{
				num += CodedOutputStream.ComputeMessageSize(3, Result);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public string GetInvalidUsers(int index)
	{
		return invalidUsers_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasMsgID)
		{
			output.WriteInt64(1, MsgID);
		}
		if (invalidUsers_.Count > 0)
		{
			foreach (string item in invalidUsers_)
			{
				output.WriteString(2, item);
			}
		}
		if (HasResult)
		{
			output.WriteMessage(3, Result);
		}
		UnknownFields.WriteTo(output);
	}

	public static InvalidUserReply ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InvalidUserReply ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InvalidUserReply ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InvalidUserReply ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InvalidUserReply ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InvalidUserReply ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static InvalidUserReply ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static InvalidUserReply ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static InvalidUserReply ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InvalidUserReply ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(InvalidUserReply prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static InvalidUserReply()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
