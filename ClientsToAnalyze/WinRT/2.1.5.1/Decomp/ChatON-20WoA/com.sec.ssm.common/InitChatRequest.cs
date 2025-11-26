using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class InitChatRequest : GeneratedMessage<InitChatRequest, InitChatRequest.Builder>
{
	public sealed class Builder : GeneratedBuilder<InitChatRequest, Builder>
	{
		private InitChatRequest result = new InitChatRequest();

		protected override Builder ThisBuilder => this;

		protected override InitChatRequest MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override InitChatRequest DefaultInstanceForType => DefaultInstance;

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

		public bool HasMsgType => result.HasMsgType;

		public MsgType MsgType
		{
			get
			{
				return result.MsgType;
			}
			set
			{
				SetMsgType(value);
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

		public bool HasIMEI => result.HasIMEI;

		public string IMEI
		{
			get
			{
				return result.IMEI;
			}
			set
			{
				SetIMEI(value);
			}
		}

		public bool HasReservationTime => result.HasReservationTime;

		public long ReservationTime
		{
			get
			{
				return result.ReservationTime;
			}
			set
			{
				SetReservationTime(value);
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

		public IPopsicleList<string> ReceiverList => result.receiver_;

		public int ReceiverCount => result.ReceiverCount;

		public bool HasChatMsg => result.HasChatMsg;

		public string ChatMsg
		{
			get
			{
				return result.ChatMsg;
			}
			set
			{
				SetChatMsg(value);
			}
		}

		public override Builder Clear()
		{
			result = new InitChatRequest();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override InitChatRequest BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.receiver_.MakeReadOnly();
			InitChatRequest initChatRequest = result;
			result = null;
			return initChatRequest;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is InitChatRequest)
			{
				return MergeFrom((InitChatRequest)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(InitChatRequest other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.HasMsgType)
			{
				MsgType = other.MsgType;
			}
			if (other.HasChatType)
			{
				ChatType = other.ChatType;
			}
			if (other.HasUID)
			{
				UID = other.UID;
			}
			if (other.HasIMEI)
			{
				IMEI = other.IMEI;
			}
			if (other.HasReservationTime)
			{
				ReservationTime = other.ReservationTime;
			}
			if (other.HasSender)
			{
				Sender = other.Sender;
			}
			if (other.receiver_.Count != 0)
			{
				AddRange(other.receiver_, result.receiver_);
			}
			if (other.HasChatMsg)
			{
				ChatMsg = other.ChatMsg;
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
					int num3 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(MsgType), num3))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(2, (ulong)num3);
					}
					else
					{
						MsgType = (MsgType)num3;
					}
					continue;
				}
				case 24u:
				{
					int num2 = input.ReadEnum();
					if (!Enum.IsDefined(typeof(ChatType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(3, (ulong)num2);
					}
					else
					{
						ChatType = (ChatType)num2;
					}
					continue;
				}
				case 34u:
					UID = input.ReadString();
					continue;
				case 42u:
					IMEI = input.ReadString();
					continue;
				case 48u:
					ReservationTime = input.ReadInt64();
					continue;
				case 58u:
					Sender = input.ReadString();
					continue;
				case 66u:
					AddReceiver(input.ReadString());
					continue;
				case 74u:
					ChatMsg = input.ReadString();
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

		public Builder SetMsgType(MsgType value)
		{
			result.hasMsgType = true;
			result.msgType_ = value;
			return this;
		}

		public Builder ClearMsgType()
		{
			result.hasMsgType = false;
			result.msgType_ = MsgType.TEXT;
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

		public Builder SetIMEI(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasIMEI = true;
			result.iMEI_ = value;
			return this;
		}

		public Builder ClearIMEI()
		{
			result.hasIMEI = false;
			result.iMEI_ = "";
			return this;
		}

		public Builder SetReservationTime(long value)
		{
			result.hasReservationTime = true;
			result.reservationTime_ = value;
			return this;
		}

		public Builder ClearReservationTime()
		{
			result.hasReservationTime = false;
			result.reservationTime_ = 0L;
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

		public string GetReceiver(int index)
		{
			return result.GetReceiver(index);
		}

		public Builder SetReceiver(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.receiver_[index] = value;
			return this;
		}

		public Builder AddReceiver(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.receiver_.Add(value);
			return this;
		}

		public Builder AddRangeReceiver(IEnumerable<string> values)
		{
			AddRange(values, result.receiver_);
			return this;
		}

		public Builder ClearReceiver()
		{
			result.receiver_.Clear();
			return this;
		}

		public Builder SetChatMsg(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasChatMsg = true;
			result.chatMsg_ = value;
			return this;
		}

		public Builder ClearChatMsg()
		{
			result.hasChatMsg = false;
			result.chatMsg_ = "";
			return this;
		}
	}

	public const int MsgIDFieldNumber = 1;

	public const int MsgTypeFieldNumber = 2;

	public const int ChatTypeFieldNumber = 3;

	public const int UIDFieldNumber = 4;

	public const int IMEIFieldNumber = 5;

	public const int ReservationTimeFieldNumber = 6;

	public const int SenderFieldNumber = 7;

	public const int ReceiverFieldNumber = 8;

	public const int ChatMsgFieldNumber = 9;

	private static readonly InitChatRequest defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasMsgType;

	private MsgType msgType_;

	private bool hasChatType;

	private ChatType chatType_;

	private bool hasUID;

	private string uID_ = "";

	private bool hasIMEI;

	private string iMEI_ = "";

	private bool hasReservationTime;

	private long reservationTime_;

	private bool hasSender;

	private string sender_ = "";

	private PopsicleList<string> receiver_ = new PopsicleList<string>();

	private bool hasChatMsg;

	private string chatMsg_ = "";

	private int memoizedSerializedSize = -1;

	public static InitChatRequest DefaultInstance => defaultInstance;

	public override InitChatRequest DefaultInstanceForType => defaultInstance;

	protected override InitChatRequest ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_InitChatRequest__Descriptor;

	protected override FieldAccessorTable<InitChatRequest, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_InitChatRequest__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasMsgType => hasMsgType;

	public MsgType MsgType => msgType_;

	public bool HasChatType => hasChatType;

	public ChatType ChatType => chatType_;

	public bool HasUID => hasUID;

	public string UID => uID_;

	public bool HasIMEI => hasIMEI;

	public string IMEI => iMEI_;

	public bool HasReservationTime => hasReservationTime;

	public long ReservationTime => reservationTime_;

	public bool HasSender => hasSender;

	public string Sender => sender_;

	public IList<string> ReceiverList => Lists.AsReadOnly(receiver_);

	public int ReceiverCount => receiver_.Count;

	public bool HasChatMsg => hasChatMsg;

	public string ChatMsg => chatMsg_;

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
			if (HasMsgType)
			{
				num += CodedOutputStream.ComputeEnumSize(2, (int)MsgType);
			}
			if (HasChatType)
			{
				num += CodedOutputStream.ComputeEnumSize(3, (int)ChatType);
			}
			if (HasUID)
			{
				num += CodedOutputStream.ComputeStringSize(4, UID);
			}
			if (HasIMEI)
			{
				num += CodedOutputStream.ComputeStringSize(5, IMEI);
			}
			if (HasReservationTime)
			{
				num += CodedOutputStream.ComputeInt64Size(6, ReservationTime);
			}
			if (HasSender)
			{
				num += CodedOutputStream.ComputeStringSize(7, Sender);
			}
			int num2 = 0;
			foreach (string receiver in ReceiverList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(receiver);
			}
			num += num2;
			num += receiver_.Count;
			if (HasChatMsg)
			{
				num += CodedOutputStream.ComputeStringSize(9, ChatMsg);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public string GetReceiver(int index)
	{
		return receiver_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasMsgID)
		{
			output.WriteInt64(1, MsgID);
		}
		if (HasMsgType)
		{
			output.WriteEnum(2, (int)MsgType);
		}
		if (HasChatType)
		{
			output.WriteEnum(3, (int)ChatType);
		}
		if (HasUID)
		{
			output.WriteString(4, UID);
		}
		if (HasIMEI)
		{
			output.WriteString(5, IMEI);
		}
		if (HasReservationTime)
		{
			output.WriteInt64(6, ReservationTime);
		}
		if (HasSender)
		{
			output.WriteString(7, Sender);
		}
		if (receiver_.Count > 0)
		{
			foreach (string item in receiver_)
			{
				output.WriteString(8, item);
			}
		}
		if (HasChatMsg)
		{
			output.WriteString(9, ChatMsg);
		}
		UnknownFields.WriteTo(output);
	}

	public static InitChatRequest ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InitChatRequest ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InitChatRequest ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InitChatRequest ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InitChatRequest ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InitChatRequest ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static InitChatRequest ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static InitChatRequest ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static InitChatRequest ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InitChatRequest ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(InitChatRequest prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static InitChatRequest()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
