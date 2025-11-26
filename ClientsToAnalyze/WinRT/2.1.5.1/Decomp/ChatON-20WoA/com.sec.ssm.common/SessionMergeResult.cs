using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class SessionMergeResult : GeneratedMessage<SessionMergeResult, SessionMergeResult.Builder>
{
	public sealed class Builder : GeneratedBuilder<SessionMergeResult, Builder>
	{
		private SessionMergeResult result = new SessionMergeResult();

		protected override Builder ThisBuilder => this;

		protected override SessionMergeResult MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override SessionMergeResult DefaultInstanceForType => DefaultInstance;

		public bool HasLastSessionMergeTimestamp => result.HasLastSessionMergeTimestamp;

		public long LastSessionMergeTimestamp
		{
			get
			{
				return result.LastSessionMergeTimestamp;
			}
			set
			{
				SetLastSessionMergeTimestamp(value);
			}
		}

		public IPopsicleList<string> CurrentMembersList => result.currentMembers_;

		public int CurrentMembersCount => result.CurrentMembersCount;

		public IPopsicleList<MemberTransition> MembershipChangesList => result.membershipChanges_;

		public int MembershipChangesCount => result.MembershipChangesCount;

		public bool HasTransitedSessionId => result.HasTransitedSessionId;

		public string TransitedSessionId
		{
			get
			{
				return result.TransitedSessionId;
			}
			set
			{
				SetTransitedSessionId(value);
			}
		}

		public override Builder Clear()
		{
			result = new SessionMergeResult();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override SessionMergeResult BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.currentMembers_.MakeReadOnly();
			result.membershipChanges_.MakeReadOnly();
			SessionMergeResult sessionMergeResult = result;
			result = null;
			return sessionMergeResult;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is SessionMergeResult)
			{
				return MergeFrom((SessionMergeResult)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(SessionMergeResult other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasLastSessionMergeTimestamp)
			{
				LastSessionMergeTimestamp = other.LastSessionMergeTimestamp;
			}
			if (other.currentMembers_.Count != 0)
			{
				AddRange(other.currentMembers_, result.currentMembers_);
			}
			if (other.membershipChanges_.Count != 0)
			{
				AddRange(other.membershipChanges_, result.membershipChanges_);
			}
			if (other.HasTransitedSessionId)
			{
				TransitedSessionId = other.TransitedSessionId;
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
					LastSessionMergeTimestamp = input.ReadInt64();
					continue;
				case 18u:
					AddCurrentMembers(input.ReadString());
					continue;
				case 26u:
				{
					MemberTransition.Builder builder2 = MemberTransition.CreateBuilder();
					input.ReadMessage(builder2, extensionRegistry);
					AddMembershipChanges(builder2.BuildPartial());
					continue;
				}
				case 34u:
					TransitedSessionId = input.ReadString();
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

		public Builder SetLastSessionMergeTimestamp(long value)
		{
			result.hasLastSessionMergeTimestamp = true;
			result.lastSessionMergeTimestamp_ = value;
			return this;
		}

		public Builder ClearLastSessionMergeTimestamp()
		{
			result.hasLastSessionMergeTimestamp = false;
			result.lastSessionMergeTimestamp_ = 0L;
			return this;
		}

		public string GetCurrentMembers(int index)
		{
			return result.GetCurrentMembers(index);
		}

		public Builder SetCurrentMembers(int index, string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.currentMembers_[index] = value;
			return this;
		}

		public Builder AddCurrentMembers(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.currentMembers_.Add(value);
			return this;
		}

		public Builder AddRangeCurrentMembers(IEnumerable<string> values)
		{
			AddRange(values, result.currentMembers_);
			return this;
		}

		public Builder ClearCurrentMembers()
		{
			result.currentMembers_.Clear();
			return this;
		}

		public MemberTransition GetMembershipChanges(int index)
		{
			return result.GetMembershipChanges(index);
		}

		public Builder SetMembershipChanges(int index, MemberTransition value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.membershipChanges_[index] = value;
			return this;
		}

		public Builder SetMembershipChanges(int index, MemberTransition.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.membershipChanges_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddMembershipChanges(MemberTransition value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.membershipChanges_.Add(value);
			return this;
		}

		public Builder AddMembershipChanges(MemberTransition.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.membershipChanges_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeMembershipChanges(IEnumerable<MemberTransition> values)
		{
			AddRange(values, result.membershipChanges_);
			return this;
		}

		public Builder ClearMembershipChanges()
		{
			result.membershipChanges_.Clear();
			return this;
		}

		public Builder SetTransitedSessionId(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasTransitedSessionId = true;
			result.transitedSessionId_ = value;
			return this;
		}

		public Builder ClearTransitedSessionId()
		{
			result.hasTransitedSessionId = false;
			result.transitedSessionId_ = "";
			return this;
		}
	}

	public const int LastSessionMergeTimestampFieldNumber = 1;

	public const int CurrentMembersFieldNumber = 2;

	public const int MembershipChangesFieldNumber = 3;

	public const int TransitedSessionIdFieldNumber = 4;

	private static readonly SessionMergeResult defaultInstance;

	private bool hasLastSessionMergeTimestamp;

	private long lastSessionMergeTimestamp_;

	private PopsicleList<string> currentMembers_ = new PopsicleList<string>();

	private PopsicleList<MemberTransition> membershipChanges_ = new PopsicleList<MemberTransition>();

	private bool hasTransitedSessionId;

	private string transitedSessionId_ = "";

	private int memoizedSerializedSize = -1;

	public static SessionMergeResult DefaultInstance => defaultInstance;

	public override SessionMergeResult DefaultInstanceForType => defaultInstance;

	protected override SessionMergeResult ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_SessionMergeResult__Descriptor;

	protected override FieldAccessorTable<SessionMergeResult, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_SessionMergeResult__FieldAccessorTable;

	public bool HasLastSessionMergeTimestamp => hasLastSessionMergeTimestamp;

	public long LastSessionMergeTimestamp => lastSessionMergeTimestamp_;

	public IList<string> CurrentMembersList => Lists.AsReadOnly(currentMembers_);

	public int CurrentMembersCount => currentMembers_.Count;

	public IList<MemberTransition> MembershipChangesList => membershipChanges_;

	public int MembershipChangesCount => membershipChanges_.Count;

	public bool HasTransitedSessionId => hasTransitedSessionId;

	public string TransitedSessionId => transitedSessionId_;

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
			if (HasLastSessionMergeTimestamp)
			{
				num += CodedOutputStream.ComputeInt64Size(1, LastSessionMergeTimestamp);
			}
			int num2 = 0;
			foreach (string currentMembers in CurrentMembersList)
			{
				num2 += CodedOutputStream.ComputeStringSizeNoTag(currentMembers);
			}
			num += num2;
			num += currentMembers_.Count;
			foreach (MemberTransition membershipChanges in MembershipChangesList)
			{
				num += CodedOutputStream.ComputeMessageSize(3, membershipChanges);
			}
			if (HasTransitedSessionId)
			{
				num += CodedOutputStream.ComputeStringSize(4, TransitedSessionId);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public string GetCurrentMembers(int index)
	{
		return currentMembers_[index];
	}

	public MemberTransition GetMembershipChanges(int index)
	{
		return membershipChanges_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasLastSessionMergeTimestamp)
		{
			output.WriteInt64(1, LastSessionMergeTimestamp);
		}
		if (currentMembers_.Count > 0)
		{
			foreach (string item in currentMembers_)
			{
				output.WriteString(2, item);
			}
		}
		foreach (MemberTransition membershipChanges in MembershipChangesList)
		{
			output.WriteMessage(3, membershipChanges);
		}
		if (HasTransitedSessionId)
		{
			output.WriteString(4, TransitedSessionId);
		}
		UnknownFields.WriteTo(output);
	}

	public static SessionMergeResult ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static SessionMergeResult ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static SessionMergeResult ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static SessionMergeResult ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static SessionMergeResult ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static SessionMergeResult ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static SessionMergeResult ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static SessionMergeResult ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static SessionMergeResult ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static SessionMergeResult ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(SessionMergeResult prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static SessionMergeResult()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
