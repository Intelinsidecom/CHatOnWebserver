using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class WebProvisionRequest : GeneratedMessage<WebProvisionRequest, WebProvisionRequest.Builder>
{
	public sealed class Builder : GeneratedBuilder<WebProvisionRequest, Builder>
	{
		private WebProvisionRequest result = new WebProvisionRequest();

		protected override Builder ThisBuilder => this;

		protected override WebProvisionRequest MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override WebProvisionRequest DefaultInstanceForType => DefaultInstance;

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

		public bool HasReceiver => result.HasReceiver;

		public string Receiver
		{
			get
			{
				return result.Receiver;
			}
			set
			{
				SetReceiver(value);
			}
		}

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
			result = new WebProvisionRequest();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override WebProvisionRequest BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			WebProvisionRequest webProvisionRequest = result;
			result = null;
			return webProvisionRequest;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is WebProvisionRequest)
			{
				return MergeFrom((WebProvisionRequest)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(WebProvisionRequest other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.HasUID)
			{
				UID = other.UID;
			}
			if (other.HasIMEI)
			{
				IMEI = other.IMEI;
			}
			if (other.HasReceiver)
			{
				Receiver = other.Receiver;
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
				case 18u:
					UID = input.ReadString();
					continue;
				case 26u:
					IMEI = input.ReadString();
					continue;
				case 34u:
					Receiver = input.ReadString();
					continue;
				case 42u:
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

		public Builder SetReceiver(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasReceiver = true;
			result.receiver_ = value;
			return this;
		}

		public Builder ClearReceiver()
		{
			result.hasReceiver = false;
			result.receiver_ = "";
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

	public const int UIDFieldNumber = 2;

	public const int IMEIFieldNumber = 3;

	public const int ReceiverFieldNumber = 4;

	public const int ChatMsgFieldNumber = 5;

	private static readonly WebProvisionRequest defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasUID;

	private string uID_ = "";

	private bool hasIMEI;

	private string iMEI_ = "";

	private bool hasReceiver;

	private string receiver_ = "";

	private bool hasChatMsg;

	private string chatMsg_ = "";

	private int memoizedSerializedSize = -1;

	public static WebProvisionRequest DefaultInstance => defaultInstance;

	public override WebProvisionRequest DefaultInstanceForType => defaultInstance;

	protected override WebProvisionRequest ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_WebProvisionRequest__Descriptor;

	protected override FieldAccessorTable<WebProvisionRequest, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_WebProvisionRequest__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasUID => hasUID;

	public string UID => uID_;

	public bool HasIMEI => hasIMEI;

	public string IMEI => iMEI_;

	public bool HasReceiver => hasReceiver;

	public string Receiver => receiver_;

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
			if (HasUID)
			{
				num += CodedOutputStream.ComputeStringSize(2, UID);
			}
			if (HasIMEI)
			{
				num += CodedOutputStream.ComputeStringSize(3, IMEI);
			}
			if (HasReceiver)
			{
				num += CodedOutputStream.ComputeStringSize(4, Receiver);
			}
			if (HasChatMsg)
			{
				num += CodedOutputStream.ComputeStringSize(5, ChatMsg);
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
		if (HasUID)
		{
			output.WriteString(2, UID);
		}
		if (HasIMEI)
		{
			output.WriteString(3, IMEI);
		}
		if (HasReceiver)
		{
			output.WriteString(4, Receiver);
		}
		if (HasChatMsg)
		{
			output.WriteString(5, ChatMsg);
		}
		UnknownFields.WriteTo(output);
	}

	public static WebProvisionRequest ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static WebProvisionRequest ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static WebProvisionRequest ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static WebProvisionRequest ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static WebProvisionRequest ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static WebProvisionRequest ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static WebProvisionRequest ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static WebProvisionRequest ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static WebProvisionRequest ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static WebProvisionRequest ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(WebProvisionRequest prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static WebProvisionRequest()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
