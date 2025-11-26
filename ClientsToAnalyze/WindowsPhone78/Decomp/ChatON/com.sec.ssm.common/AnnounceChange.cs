using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class AnnounceChange : GeneratedMessage<AnnounceChange, AnnounceChange.Builder>
{
	public sealed class Builder : GeneratedBuilder<AnnounceChange, Builder>
	{
		private AnnounceChange result = new AnnounceChange();

		protected override Builder ThisBuilder => this;

		protected override AnnounceChange MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override AnnounceChange DefaultInstanceForType => DefaultInstance;

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

		public IPopsicleList<ChangeMemberList> ChangeMemberListList => result.changeMemberList_;

		public int ChangeMemberListCount => result.ChangeMemberListCount;

		public IPopsicleList<string> GroupMemberListList => result.groupMemberList_;

		public int GroupMemberListCount => result.GroupMemberListCount;

		public bool HasSentTime => result.HasSentTime;

		public long SentTime
		{
			get
			{
				return result.SentTime;
			}
			set
			{
				SetSentTime(value);
			}
		}

		public bool HasInviter => result.HasInviter;

		public string Inviter
		{
			get
			{
				return result.Inviter;
			}
			set
			{
				SetInviter(value);
			}
		}

		public override Builder Clear()
		{
			result = new AnnounceChange();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override AnnounceChange BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.changeMemberList_.MakeReadOnly();
			result.groupMemberList_.MakeReadOnly();
			AnnounceChange announceChange = result;
			result = null;
			return announceChange;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is AnnounceChange)
			{
				return MergeFrom((AnnounceChange)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(AnnounceChange other)
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
			if (other.changeMemberList_.Count != 0)
			{
				AddRange(other.changeMemberList_, result.changeMemberList_);
			}
			if (other.groupMemberList_.Count != 0)
			{
				AddRange(other.groupMemberList_, result.groupMemberList_);
			}
			if (other.HasSentTime)
			{
				SentTime = other.SentTime;
			}
			if (other.HasInviter)
			{
				Inviter = other.Inviter;
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
				case 26u:
				{
					ChangeMemberList.Builder builder2 = ChangeMemberList.CreateBuilder();
					input.ReadMessage(builder2, extensionRegistry);
					AddChangeMemberList(builder2.BuildPartial());
					continue;
				}
				case 34u:
					AddGroupMemberList(input.ReadString());
					continue;
				case 40u:
					SentTime = input.ReadInt64();
					continue;
				case 50u:
					Inviter = input.ReadString();
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

		public ChangeMemberList GetChangeMemberList(int index)
		{
			return result.GetChangeMemberList(index);
		}

		public Builder SetChangeMemberList(int index, ChangeMemberList value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.changeMemberList_[index] = value;
			return this;
		}

		public Builder SetChangeMemberList(int index, ChangeMemberList.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.changeMemberList_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddChangeMemberList(ChangeMemberList value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.changeMemberList_.Add(value);
			return this;
		}

		public Builder AddChangeMemberList(ChangeMemberList.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.changeMemberList_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeChangeMemberList(IEnumerable<ChangeMemberList> values)
		{
			AddRange(values, result.changeMemberList_);
			return this;
		}

		public Builder ClearChangeMemberList()
		{
			result.changeMemberList_.Clear();
			return this;
		}

		public string GetGroupMemberList(int index)
		{
			return result.GetGroupMemberList(index);
		}

		public Builder SetGroupMemberList(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.groupMemberList_[index] = value;
			return this;
		}

		public Builder AddGroupMemberList(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.groupMemberList_.Add(value);
			return this;
		}

		public Builder AddRangeGroupMemberList(IEnumerable<string> values)
		{
			AddRange(values, result.groupMemberList_);
			return this;
		}

		public Builder ClearGroupMemberList()
		{
			result.groupMemberList_.Clear();
			return this;
		}

		public Builder SetSentTime(long value)
		{
			result.hasSentTime = true;
			result.sentTime_ = value;
			return this;
		}

		public Builder ClearSentTime()
		{
			result.hasSentTime = false;
			result.sentTime_ = 0L;
			return this;
		}

		public Builder SetInviter(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasInviter = true;
			result.inviter_ = value;
			return this;
		}

		public Builder ClearInviter()
		{
			result.hasInviter = false;
			result.inviter_ = "";
			return this;
		}
	}

	public const int MsgIDFieldNumber = 1;

	public const int SessionIDFieldNumber = 2;

	public const int ChangeMemberListFieldNumber = 3;

	public const int GroupMemberListFieldNumber = 4;

	public const int SentTimeFieldNumber = 5;

	public const int InviterFieldNumber = 6;

	private static readonly AnnounceChange defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasSessionID;

	private string sessionID_ = "";

	private PopsicleList<ChangeMemberList> changeMemberList_ = new PopsicleList<ChangeMemberList>();

	private PopsicleList<string> groupMemberList_ = new PopsicleList<string>();

	private bool hasSentTime;

	private long sentTime_;

	private bool hasInviter;

	private string inviter_ = "";

	private int memoizedSerializedSize = -1;

	public static AnnounceChange DefaultInstance => defaultInstance;

	public override AnnounceChange DefaultInstanceForType => defaultInstance;

	protected override AnnounceChange ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_AnnounceChange__Descriptor;

	protected override FieldAccessorTable<AnnounceChange, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_AnnounceChange__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasSessionID => hasSessionID;

	public string SessionID => sessionID_;

	public IList<ChangeMemberList> ChangeMemberListList => changeMemberList_;

	public int ChangeMemberListCount => changeMemberList_.Count;

	public IList<string> GroupMemberListList => Lists.AsReadOnly(groupMemberList_);

	public int GroupMemberListCount => groupMemberList_.Count;

	public bool HasSentTime => hasSentTime;

	public long SentTime => sentTime_;

	public bool HasInviter => hasInviter;

	public string Inviter => inviter_;

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
			foreach (ChangeMemberList changeMemberList in ChangeMemberListList)
			{
				num += CodedOutputStream.ComputeMessageSize(3, changeMemberList);
			}
			int num2 = 0;
			foreach (string groupMemberList in GroupMemberListList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(groupMemberList);
			}
			num += num2;
			num += groupMemberList_.Count;
			if (HasSentTime)
			{
				num += CodedOutputStream.ComputeInt64Size(5, SentTime);
			}
			if (HasInviter)
			{
				num += CodedOutputStream.ComputeStringSize(6, Inviter);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public ChangeMemberList GetChangeMemberList(int index)
	{
		return changeMemberList_[index];
	}

	public string GetGroupMemberList(int index)
	{
		return groupMemberList_[index];
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
		foreach (ChangeMemberList changeMemberList in ChangeMemberListList)
		{
			output.WriteMessage(3, changeMemberList);
		}
		if (groupMemberList_.Count > 0)
		{
			foreach (string item in groupMemberList_)
			{
				output.WriteString(4, item);
			}
		}
		if (HasSentTime)
		{
			output.WriteInt64(5, SentTime);
		}
		if (HasInviter)
		{
			output.WriteString(6, Inviter);
		}
		UnknownFields.WriteTo(output);
	}

	public static AnnounceChange ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AnnounceChange ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AnnounceChange ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static AnnounceChange ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static AnnounceChange ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AnnounceChange ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static AnnounceChange ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static AnnounceChange ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static AnnounceChange ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static AnnounceChange ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(AnnounceChange prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static AnnounceChange()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
