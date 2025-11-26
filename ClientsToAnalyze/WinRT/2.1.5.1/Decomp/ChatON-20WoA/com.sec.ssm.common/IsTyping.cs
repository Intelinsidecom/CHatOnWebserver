using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class IsTyping : GeneratedMessage<IsTyping, IsTyping.Builder>
{
	public sealed class Builder : GeneratedBuilder<IsTyping, Builder>
	{
		private IsTyping result = new IsTyping();

		protected override Builder ThisBuilder => this;

		protected override IsTyping MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override IsTyping DefaultInstanceForType => DefaultInstance;

		public bool HasChatType => result.HasChatType;

		public ChatType ChatType
		{
			get
			{
				return result.ChatType;
			}
			set
			{
				SetChatType(value);
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

		public bool HasSender => result.HasSender;

		public string Sender
		{
			get
			{
				return result.Sender;
			}
			set
			{
				SetSender(value);
			}
		}

		public bool HasState => result.HasState;

		public string State
		{
			get
			{
				return result.State;
			}
			set
			{
				SetState(value);
			}
		}

		public bool HasContentType => result.HasContentType;

		public ContentType ContentType
		{
			get
			{
				return result.ContentType;
			}
			set
			{
				SetContentType(value);
			}
		}

		public bool HasRefresh => result.HasRefresh;

		public int Refresh
		{
			get
			{
				return result.Refresh;
			}
			set
			{
				SetRefresh(value);
			}
		}

		public override Builder Clear()
		{
			result = new IsTyping();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override IsTyping BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			IsTyping isTyping = result;
			result = null;
			return isTyping;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is IsTyping)
			{
				return MergeFrom((IsTyping)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(IsTyping other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasChatType)
			{
				ChatType = other.ChatType;
			}
			if (other.HasSessionID)
			{
				SessionID = other.SessionID;
			}
			if (other.HasSender)
			{
				Sender = other.Sender;
			}
			if (other.HasState)
			{
				State = other.State;
			}
			if (other.HasContentType)
			{
				ContentType = other.ContentType;
			}
			if (other.HasRefresh)
			{
				Refresh = other.Refresh;
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
					int num3 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(ChatType), num3))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(1, (ulong)num3);
					}
					else
					{
						ChatType = (ChatType)num3;
					}
					continue;
				}
				case 18u:
					SessionID = input.ReadString();
					continue;
				case 26u:
					Sender = input.ReadString();
					continue;
				case 34u:
					State = input.ReadString();
					continue;
				case 40u:
				{
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(ContentType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(5, (ulong)num2);
					}
					else
					{
						ContentType = (ContentType)num2;
					}
					continue;
				}
				case 48u:
					Refresh = input.ReadInt32();
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

		public Builder SetChatType(ChatType value)
		{
			result.hasChatType = true;
			result.chatType_ = value;
			return this;
		}

		public Builder ClearChatType()
		{
			result.hasChatType = false;
			result.chatType_ = ChatType.SINGLE;
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

		public Builder SetSender(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasSender = true;
			result.sender_ = value;
			return this;
		}

		public Builder ClearSender()
		{
			result.hasSender = false;
			result.sender_ = "";
			return this;
		}

		public Builder SetState(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasState = true;
			result.state_ = value;
			return this;
		}

		public Builder ClearState()
		{
			result.hasState = false;
			result.state_ = "";
			return this;
		}

		public Builder SetContentType(ContentType value)
		{
			result.hasContentType = true;
			result.contentType_ = value;
			return this;
		}

		public Builder ClearContentType()
		{
			result.hasContentType = false;
			result.contentType_ = ContentType.CONTENT_TEXT;
			return this;
		}

		public Builder SetRefresh(int value)
		{
			result.hasRefresh = true;
			result.refresh_ = value;
			return this;
		}

		public Builder ClearRefresh()
		{
			result.hasRefresh = false;
			result.refresh_ = 0;
			return this;
		}
	}

	public const int ChatTypeFieldNumber = 1;

	public const int SessionIDFieldNumber = 2;

	public const int SenderFieldNumber = 3;

	public const int StateFieldNumber = 4;

	public const int ContentTypeFieldNumber = 5;

	public const int RefreshFieldNumber = 6;

	private static readonly IsTyping defaultInstance;

	private bool hasChatType;

	private ChatType chatType_;

	private bool hasSessionID;

	private string sessionID_ = "";

	private bool hasSender;

	private string sender_ = "";

	private bool hasState;

	private string state_ = "";

	private bool hasContentType;

	private ContentType contentType_;

	private bool hasRefresh;

	private int refresh_;

	private int memoizedSerializedSize = -1;

	public static IsTyping DefaultInstance => defaultInstance;

	public override IsTyping DefaultInstanceForType => defaultInstance;

	protected override IsTyping ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_IsTyping__Descriptor;

	protected override FieldAccessorTable<IsTyping, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_IsTyping__FieldAccessorTable;

	public bool HasChatType => hasChatType;

	public ChatType ChatType => chatType_;

	public bool HasSessionID => hasSessionID;

	public string SessionID => sessionID_;

	public bool HasSender => hasSender;

	public string Sender => sender_;

	public bool HasState => hasState;

	public string State => state_;

	public bool HasContentType => hasContentType;

	public ContentType ContentType => contentType_;

	public bool HasRefresh => hasRefresh;

	public int Refresh => refresh_;

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
			if (HasChatType)
			{
				num += CodedOutputStream.ComputeEnumSize(1, (int)ChatType);
			}
			if (HasSessionID)
			{
				num += CodedOutputStream.ComputeStringSize(2, SessionID);
			}
			if (HasSender)
			{
				num += CodedOutputStream.ComputeStringSize(3, Sender);
			}
			if (HasState)
			{
				num += CodedOutputStream.ComputeStringSize(4, State);
			}
			if (HasContentType)
			{
				num += CodedOutputStream.ComputeEnumSize(5, (int)ContentType);
			}
			if (HasRefresh)
			{
				num += CodedOutputStream.ComputeInt32Size(6, Refresh);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasChatType)
		{
			output.WriteEnum(1, (int)ChatType);
		}
		if (HasSessionID)
		{
			output.WriteString(2, SessionID);
		}
		if (HasSender)
		{
			output.WriteString(3, Sender);
		}
		if (HasState)
		{
			output.WriteString(4, State);
		}
		if (HasContentType)
		{
			output.WriteEnum(5, (int)ContentType);
		}
		if (HasRefresh)
		{
			output.WriteInt32(6, Refresh);
		}
		UnknownFields.WriteTo(output);
	}

	public static IsTyping ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static IsTyping ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static IsTyping ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static IsTyping ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static IsTyping ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static IsTyping ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static IsTyping ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static IsTyping ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static IsTyping ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static IsTyping ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(IsTyping prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static IsTyping()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
