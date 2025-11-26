using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class InitChatReply : GeneratedMessage<InitChatReply, InitChatReply.Builder>
{
	public sealed class Builder : GeneratedBuilder<InitChatReply, Builder>
	{
		private InitChatReply result = new InitChatReply();

		protected override Builder ThisBuilder => this;

		protected override InitChatReply MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override InitChatReply DefaultInstanceForType => DefaultInstance;

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

		public bool HasSessionID => result.HasSessionID;

		public string SessionID
		{
			get
			{
				return result.SessionID;
			}
			set
			{
				SetSessionID(value);
			}
		}

		public bool HasMsgReceivedTime => result.HasMsgReceivedTime;

		public long MsgReceivedTime
		{
			get
			{
				return result.MsgReceivedTime;
			}
			set
			{
				SetMsgReceivedTime(value);
			}
		}

		public bool HasServerInfo => result.HasServerInfo;

		public ServerInfo ServerInfo
		{
			get
			{
				return result.ServerInfo;
			}
			set
			{
				SetServerInfo(value);
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
			result = new InitChatReply();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override InitChatReply BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			InitChatReply initChatReply = result;
			result = null;
			return initChatReply;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is InitChatReply)
			{
				return MergeFrom((InitChatReply)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(InitChatReply other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.HasSessionID)
			{
				SessionID = other.SessionID;
			}
			if (other.HasMsgReceivedTime)
			{
				MsgReceivedTime = other.MsgReceivedTime;
			}
			if (other.HasServerInfo)
			{
				MergeServerInfo(other.ServerInfo);
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
					SessionID = input.ReadString();
					continue;
				case 24u:
					MsgReceivedTime = input.ReadInt64();
					continue;
				case 34u:
				{
					ServerInfo.Builder builder3 = ServerInfo.CreateBuilder();
					if (HasServerInfo)
					{
						builder3.MergeFrom(ServerInfo);
					}
					input.ReadMessage(builder3, extensionRegistry);
					ServerInfo = builder3.BuildPartial();
					continue;
				}
				case 42u:
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

		public Builder SetSessionID(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasSessionID = true;
			result.sessionID_ = value;
			return this;
		}

		public Builder ClearSessionID()
		{
			result.hasSessionID = false;
			result.sessionID_ = "";
			return this;
		}

		public Builder SetMsgReceivedTime(long value)
		{
			result.hasMsgReceivedTime = true;
			result.msgReceivedTime_ = value;
			return this;
		}

		public Builder ClearMsgReceivedTime()
		{
			result.hasMsgReceivedTime = false;
			result.msgReceivedTime_ = 0L;
			return this;
		}

		public Builder SetServerInfo(ServerInfo value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasServerInfo = true;
			result.serverInfo_ = value;
			return this;
		}

		public Builder SetServerInfo(ServerInfo.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.hasServerInfo = true;
			result.serverInfo_ = builderForValue.Build();
			return this;
		}

		public Builder MergeServerInfo(ServerInfo value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			if (result.HasServerInfo && result.serverInfo_ != ServerInfo.DefaultInstance)
			{
				result.serverInfo_ = ServerInfo.CreateBuilder(result.serverInfo_).MergeFrom(value).BuildPartial();
			}
			else
			{
				result.serverInfo_ = value;
			}
			result.hasServerInfo = true;
			return this;
		}

		public Builder ClearServerInfo()
		{
			result.hasServerInfo = false;
			result.serverInfo_ = ServerInfo.DefaultInstance;
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

	public const int SessionIDFieldNumber = 2;

	public const int MsgReceivedTimeFieldNumber = 3;

	public const int ServerInfoFieldNumber = 4;

	public const int ResultFieldNumber = 5;

	private static readonly InitChatReply defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasSessionID;

	private string sessionID_ = "";

	private bool hasMsgReceivedTime;

	private long msgReceivedTime_;

	private bool hasServerInfo;

	private ServerInfo serverInfo_ = ServerInfo.DefaultInstance;

	private bool hasResult;

	private Result result_ = Result.DefaultInstance;

	private int memoizedSerializedSize = -1;

	public static InitChatReply DefaultInstance => defaultInstance;

	public override InitChatReply DefaultInstanceForType => defaultInstance;

	protected override InitChatReply ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_InitChatReply__Descriptor;

	protected override FieldAccessorTable<InitChatReply, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_InitChatReply__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasSessionID => hasSessionID;

	public string SessionID => sessionID_;

	public bool HasMsgReceivedTime => hasMsgReceivedTime;

	public long MsgReceivedTime => msgReceivedTime_;

	public bool HasServerInfo => hasServerInfo;

	public ServerInfo ServerInfo => serverInfo_;

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
			if (HasSessionID)
			{
				num += CodedOutputStream.ComputeStringSize(2, SessionID);
			}
			if (HasMsgReceivedTime)
			{
				num += CodedOutputStream.ComputeInt64Size(3, MsgReceivedTime);
			}
			if (HasServerInfo)
			{
				num += CodedOutputStream.ComputeMessageSize(4, ServerInfo);
			}
			if (HasResult)
			{
				num += CodedOutputStream.ComputeMessageSize(5, Result);
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
		if (HasSessionID)
		{
			output.WriteString(2, SessionID);
		}
		if (HasMsgReceivedTime)
		{
			output.WriteInt64(3, MsgReceivedTime);
		}
		if (HasServerInfo)
		{
			output.WriteMessage(4, ServerInfo);
		}
		if (HasResult)
		{
			output.WriteMessage(5, Result);
		}
		UnknownFields.WriteTo(output);
	}

	public static InitChatReply ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InitChatReply ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InitChatReply ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InitChatReply ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InitChatReply ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InitChatReply ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static InitChatReply ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static InitChatReply ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static InitChatReply ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InitChatReply ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(InitChatReply prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static InitChatReply()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
