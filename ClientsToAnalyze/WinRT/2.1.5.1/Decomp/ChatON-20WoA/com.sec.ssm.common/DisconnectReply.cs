using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class DisconnectReply : GeneratedMessage<DisconnectReply, DisconnectReply.Builder>
{
	public sealed class Builder : GeneratedBuilder<DisconnectReply, Builder>
	{
		private DisconnectReply result = new DisconnectReply();

		protected override Builder ThisBuilder => this;

		protected override DisconnectReply MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override DisconnectReply DefaultInstanceForType => DefaultInstance;

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

		public bool HasDisconnectActionType => result.HasDisconnectActionType;

		public DisconnectActionType DisconnectActionType
		{
			get
			{
				return result.DisconnectActionType;
			}
			set
			{
				SetDisconnectActionType(value);
			}
		}

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
			result = new DisconnectReply();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override DisconnectReply BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			DisconnectReply disconnectReply = result;
			result = null;
			return disconnectReply;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is DisconnectReply)
			{
				return MergeFrom((DisconnectReply)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(DisconnectReply other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.HasDisconnectActionType)
			{
				DisconnectActionType = other.DisconnectActionType;
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
				case 16u:
				{
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(DisconnectActionType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(2, (ulong)num2);
					}
					else
					{
						DisconnectActionType = (DisconnectActionType)num2;
					}
					continue;
				}
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

		public Builder SetDisconnectActionType(DisconnectActionType value)
		{
			result.hasDisconnectActionType = true;
			result.disconnectActionType_ = value;
			return this;
		}

		public Builder ClearDisconnectActionType()
		{
			result.hasDisconnectActionType = false;
			result.disconnectActionType_ = DisconnectActionType.CLOSE;
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

	public const int DisconnectActionTypeFieldNumber = 2;

	public const int ResultFieldNumber = 3;

	private static readonly DisconnectReply defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasDisconnectActionType;

	private DisconnectActionType disconnectActionType_;

	private bool hasResult;

	private Result result_ = Result.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static DisconnectReply DefaultInstance => defaultInstance;

	public override DisconnectReply DefaultInstanceForType => defaultInstance;

	protected override DisconnectReply ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_DisconnectReply__Descriptor;

	protected override FieldAccessorTable<DisconnectReply, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_DisconnectReply__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasDisconnectActionType => hasDisconnectActionType;

	public DisconnectActionType DisconnectActionType => disconnectActionType_;

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
			if (HasDisconnectActionType)
			{
				num += CodedOutputStream.ComputeEnumSize(2, (int)DisconnectActionType);
			}
			if (HasResult)
			{
				num += CodedOutputStream.ComputeMessageSize(3, Result);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasMsgID)
		{
			output.WriteInt64(1, MsgID);
		}
		if (HasDisconnectActionType)
		{
			output.WriteEnum(2, (int)DisconnectActionType);
		}
		if (HasResult)
		{
			output.WriteMessage(3, Result);
		}
		UnknownFields.WriteTo(output);
	}

	public static DisconnectReply ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DisconnectReply ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DisconnectReply ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DisconnectReply ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DisconnectReply ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DisconnectReply ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static DisconnectReply ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static DisconnectReply ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static DisconnectReply ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DisconnectReply ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(DisconnectReply prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static DisconnectReply()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
