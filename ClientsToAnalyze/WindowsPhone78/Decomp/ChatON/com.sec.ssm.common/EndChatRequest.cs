using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class EndChatRequest : GeneratedMessage<EndChatRequest, EndChatRequest.Builder>
{
	public sealed class Builder : GeneratedBuilder<EndChatRequest, Builder>
	{
		private EndChatRequest result = new EndChatRequest();

		protected override Builder ThisBuilder => this;

		protected override EndChatRequest MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override EndChatRequest DefaultInstanceForType => DefaultInstance;

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

		public bool HasUID => result.HasUID;

		public string UID
		{
			get
			{
				return result.UID;
			}
			set
			{
				SetUID(value);
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

		public IPopsicleList<string> ReceiversList => result.receivers_;

		public int ReceiversCount => result.ReceiversCount;

		public override Builder Clear()
		{
			result = new EndChatRequest();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override EndChatRequest BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.receivers_.MakeReadOnly();
			EndChatRequest endChatRequest = result;
			result = null;
			return endChatRequest;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is EndChatRequest)
			{
				return MergeFrom((EndChatRequest)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(EndChatRequest other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.HasChatType)
			{
				ChatType = other.ChatType;
			}
			if (other.HasSessionID)
			{
				SessionID = other.SessionID;
			}
			if (other.HasUID)
			{
				UID = other.UID;
			}
			if (other.HasSender)
			{
				Sender = other.Sender;
			}
			if (other.receivers_.Count != 0)
			{
				AddRange(other.receivers_, result.receivers_);
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
					if (!Enum.IsDefined(typeof(ChatType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(2, (ulong)num2);
					}
					else
					{
						ChatType = (ChatType)num2;
					}
					continue;
				}
				case 26u:
					SessionID = input.ReadString();
					continue;
				case 34u:
					UID = input.ReadString();
					continue;
				case 42u:
					Sender = input.ReadString();
					continue;
				case 50u:
					AddReceivers(input.ReadString());
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

		public Builder SetUID(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasUID = true;
			result.uID_ = value;
			return this;
		}

		public Builder ClearUID()
		{
			result.hasUID = false;
			result.uID_ = "";
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

		public string GetReceivers(int index)
		{
			return result.GetReceivers(index);
		}

		public Builder SetReceivers(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.receivers_[index] = value;
			return this;
		}

		public Builder AddReceivers(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.receivers_.Add(value);
			return this;
		}

		public Builder AddRangeReceivers(IEnumerable<string> values)
		{
			AddRange(values, result.receivers_);
			return this;
		}

		public Builder ClearReceivers()
		{
			result.receivers_.Clear();
			return this;
		}
	}

	public const int MsgIDFieldNumber = 1;

	public const int ChatTypeFieldNumber = 2;

	public const int SessionIDFieldNumber = 3;

	public const int UIDFieldNumber = 4;

	public const int SenderFieldNumber = 5;

	public const int ReceiversFieldNumber = 6;

	private static readonly EndChatRequest defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasChatType;

	private ChatType chatType_;

	private bool hasSessionID;

	private string sessionID_ = "";

	private bool hasUID;

	private string uID_ = "";

	private bool hasSender;

	private string sender_ = "";

	private PopsicleList<string> receivers_ = new PopsicleList<string>();

	private int memoizedSerializedSize = -1;

	public static EndChatRequest DefaultInstance => defaultInstance;

	public override EndChatRequest DefaultInstanceForType => defaultInstance;

	protected override EndChatRequest ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_EndChatRequest__Descriptor;

	protected override FieldAccessorTable<EndChatRequest, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_EndChatRequest__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasChatType => hasChatType;

	public ChatType ChatType => chatType_;

	public bool HasSessionID => hasSessionID;

	public string SessionID => sessionID_;

	public bool HasUID => hasUID;

	public string UID => uID_;

	public bool HasSender => hasSender;

	public string Sender => sender_;

	public IList<string> ReceiversList => Lists.AsReadOnly(receivers_);

	public int ReceiversCount => receivers_.Count;

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
			if (HasChatType)
			{
				num += CodedOutputStream.ComputeEnumSize(2, (int)ChatType);
			}
			if (HasSessionID)
			{
				num += CodedOutputStream.ComputeStringSize(3, SessionID);
			}
			if (HasUID)
			{
				num += CodedOutputStream.ComputeStringSize(4, UID);
			}
			if (HasSender)
			{
				num += CodedOutputStream.ComputeStringSize(5, Sender);
			}
			int num2 = 0;
			foreach (string receivers in ReceiversList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(receivers);
			}
			num += num2;
			num += receivers_.Count;
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public string GetReceivers(int index)
	{
		return receivers_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasMsgID)
		{
			output.WriteInt64(1, MsgID);
		}
		if (HasChatType)
		{
			output.WriteEnum(2, (int)ChatType);
		}
		if (HasSessionID)
		{
			output.WriteString(3, SessionID);
		}
		if (HasUID)
		{
			output.WriteString(4, UID);
		}
		if (HasSender)
		{
			output.WriteString(5, Sender);
		}
		if (receivers_.Count > 0)
		{
			foreach (string item in receivers_)
			{
				output.WriteString(6, item);
			}
		}
		UnknownFields.WriteTo(output);
	}

	public static EndChatRequest ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static EndChatRequest ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static EndChatRequest ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static EndChatRequest ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static EndChatRequest ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static EndChatRequest ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static EndChatRequest ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static EndChatRequest ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static EndChatRequest ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static EndChatRequest ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(EndChatRequest prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static EndChatRequest()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
