using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class InviteChatRequest : GeneratedMessage<InviteChatRequest, InviteChatRequest.Builder>
{
	public sealed class Builder : GeneratedBuilder<InviteChatRequest, Builder>
	{
		private InviteChatRequest result = new InviteChatRequest();

		protected override Builder ThisBuilder => this;

		protected override InviteChatRequest MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override InviteChatRequest DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<string> ReceiverList => result.receiver_;

		public int ReceiverCount => result.ReceiverCount;

		public IPopsicleList<string> InvitingMembersList => result.invitingMembers_;

		public int InvitingMembersCount => result.InvitingMembersCount;

		public override Builder Clear()
		{
			result = new InviteChatRequest();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override InviteChatRequest BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.receiver_.MakeReadOnly();
			result.invitingMembers_.MakeReadOnly();
			InviteChatRequest inviteChatRequest = result;
			result = null;
			return inviteChatRequest;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is InviteChatRequest)
			{
				return MergeFrom((InviteChatRequest)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(InviteChatRequest other)
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
			if (other.HasSessionID)
			{
				SessionID = other.SessionID;
			}
			if (other.HasSender)
			{
				Sender = other.Sender;
			}
			if (other.receiver_.Count != 0)
			{
				AddRange(other.receiver_, result.receiver_);
			}
			if (other.invitingMembers_.Count != 0)
			{
				AddRange(other.invitingMembers_, result.invitingMembers_);
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
					if (!Enum.IsDefined(typeof(MsgType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(2, (ulong)num2);
					}
					else
					{
						MsgType = (MsgType)num2;
					}
					continue;
				}
				case 26u:
					SessionID = input.ReadString();
					continue;
				case 34u:
					Sender = input.ReadString();
					continue;
				case 42u:
					AddReceiver(input.ReadString());
					continue;
				case 50u:
					AddInvitingMembers(input.ReadString());
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

		public string GetInvitingMembers(int index)
		{
			return result.GetInvitingMembers(index);
		}

		public Builder SetInvitingMembers(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.invitingMembers_[index] = value;
			return this;
		}

		public Builder AddInvitingMembers(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.invitingMembers_.Add(value);
			return this;
		}

		public Builder AddRangeInvitingMembers(IEnumerable<string> values)
		{
			AddRange(values, result.invitingMembers_);
			return this;
		}

		public Builder ClearInvitingMembers()
		{
			result.invitingMembers_.Clear();
			return this;
		}
	}

	public const int MsgIDFieldNumber = 1;

	public const int MsgTypeFieldNumber = 2;

	public const int SessionIDFieldNumber = 3;

	public const int SenderFieldNumber = 4;

	public const int ReceiverFieldNumber = 5;

	public const int InvitingMembersFieldNumber = 6;

	private static readonly InviteChatRequest defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasMsgType;

	private MsgType msgType_;

	private bool hasSessionID;

	private string sessionID_ = "";

	private bool hasSender;

	private string sender_ = "";

	private PopsicleList<string> receiver_ = new PopsicleList<string>();

	private PopsicleList<string> invitingMembers_ = new PopsicleList<string>();

	private int memoizedSerializedSize = -1;

	public static InviteChatRequest DefaultInstance => defaultInstance;

	public override InviteChatRequest DefaultInstanceForType => defaultInstance;

	protected override InviteChatRequest ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_InviteChatRequest__Descriptor;

	protected override FieldAccessorTable<InviteChatRequest, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_InviteChatRequest__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasMsgType => hasMsgType;

	public MsgType MsgType => msgType_;

	public bool HasSessionID => hasSessionID;

	public string SessionID => sessionID_;

	public bool HasSender => hasSender;

	public string Sender => sender_;

	public IList<string> ReceiverList => Lists.AsReadOnly(receiver_);

	public int ReceiverCount => receiver_.Count;

	public IList<string> InvitingMembersList => Lists.AsReadOnly(invitingMembers_);

	public int InvitingMembersCount => invitingMembers_.Count;

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
			if (HasSessionID)
			{
				num += CodedOutputStream.ComputeStringSize(3, SessionID);
			}
			if (HasSender)
			{
				num += CodedOutputStream.ComputeStringSize(4, Sender);
			}
			int num2 = 0;
			foreach (string receiver in ReceiverList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(receiver);
			}
			num += num2;
			num += receiver_.Count;
			int num3 = 0;
			foreach (string invitingMembers in InvitingMembersList)
			{
				num3 += CodedOutputStream.ComputeStringSizeNoTag(invitingMembers);
			}
			num += num3;
			num += invitingMembers_.Count;
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public string GetReceiver(int index)
	{
		return receiver_[index];
	}

	public string GetInvitingMembers(int index)
	{
		return invitingMembers_[index];
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
		if (HasSessionID)
		{
			output.WriteString(3, SessionID);
		}
		if (HasSender)
		{
			output.WriteString(4, Sender);
		}
		if (receiver_.Count > 0)
		{
			foreach (string item in receiver_)
			{
				output.WriteString(5, item);
			}
		}
		if (invitingMembers_.Count > 0)
		{
			foreach (string item2 in invitingMembers_)
			{
				output.WriteString(6, item2);
			}
		}
		UnknownFields.WriteTo(output);
	}

	public static InviteChatRequest ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InviteChatRequest ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InviteChatRequest ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static InviteChatRequest ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static InviteChatRequest ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InviteChatRequest ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static InviteChatRequest ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static InviteChatRequest ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static InviteChatRequest ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static InviteChatRequest ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(InviteChatRequest prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static InviteChatRequest()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
