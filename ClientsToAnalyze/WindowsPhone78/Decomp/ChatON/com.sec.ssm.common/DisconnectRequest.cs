using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class DisconnectRequest : GeneratedMessage<DisconnectRequest, DisconnectRequest.Builder>
{
	public sealed class Builder : GeneratedBuilder<DisconnectRequest, Builder>
	{
		private DisconnectRequest result = new DisconnectRequest();

		protected override Builder ThisBuilder => this;

		protected override DisconnectRequest MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override DisconnectRequest DefaultInstanceForType => DefaultInstance;

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

		public bool HasDisconnectType => result.HasDisconnectType;

		public DisconnectType DisconnectType
		{
			get
			{
				return result.DisconnectType;
			}
			set
			{
				SetDisconnectType(value);
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

		public override Builder Clear()
		{
			result = new DisconnectRequest();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override DisconnectRequest BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			DisconnectRequest disconnectRequest = result;
			result = null;
			return disconnectRequest;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is DisconnectRequest)
			{
				return MergeFrom((DisconnectRequest)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(DisconnectRequest other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasMsgID)
			{
				MsgID = other.MsgID;
			}
			if (other.HasDisconnectType)
			{
				DisconnectType = other.DisconnectType;
			}
			if (other.HasSessionID)
			{
				SessionID = other.SessionID;
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
					if (!Enum.IsDefined(typeof(DisconnectType), num2))
					{
						if (builder == null)
						{
							builder = UnknownFieldSet.CreateBuilder(UnknownFields);
						}
						builder.MergeVarintField(2, (ulong)num2);
					}
					else
					{
						DisconnectType = (DisconnectType)num2;
					}
					continue;
				}
				case 26u:
					SessionID = input.ReadString();
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

		public Builder SetDisconnectType(DisconnectType value)
		{
			result.hasDisconnectType = true;
			result.disconnectType_ = value;
			return this;
		}

		public Builder ClearDisconnectType()
		{
			result.hasDisconnectType = false;
			result.disconnectType_ = DisconnectType.TIMEOUT;
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
	}

	public const int MsgIDFieldNumber = 1;

	public const int DisconnectTypeFieldNumber = 2;

	public const int SessionIDFieldNumber = 3;

	private static readonly DisconnectRequest defaultInstance;

	private bool hasMsgID;

	private long msgID_;

	private bool hasDisconnectType;

	private DisconnectType disconnectType_;

	private bool hasSessionID;

	private string sessionID_ = "";

	private int memoizedSerializedSize = -1;

	public static DisconnectRequest DefaultInstance => defaultInstance;

	public override DisconnectRequest DefaultInstanceForType => defaultInstance;

	protected override DisconnectRequest ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_DisconnectRequest__Descriptor;

	protected override FieldAccessorTable<DisconnectRequest, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_DisconnectRequest__FieldAccessorTable;

	public bool HasMsgID => hasMsgID;

	public long MsgID => msgID_;

	public bool HasDisconnectType => hasDisconnectType;

	public DisconnectType DisconnectType => disconnectType_;

	public bool HasSessionID => hasSessionID;

	public string SessionID => sessionID_;

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
			if (HasDisconnectType)
			{
				num += CodedOutputStream.ComputeEnumSize(2, (int)DisconnectType);
			}
			if (HasSessionID)
			{
				num += CodedOutputStream.ComputeStringSize(3, SessionID);
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
		if (HasDisconnectType)
		{
			output.WriteEnum(2, (int)DisconnectType);
		}
		if (HasSessionID)
		{
			output.WriteString(3, SessionID);
		}
		UnknownFields.WriteTo(output);
	}

	public static DisconnectRequest ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DisconnectRequest ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DisconnectRequest ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static DisconnectRequest ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static DisconnectRequest ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DisconnectRequest ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static DisconnectRequest ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static DisconnectRequest ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static DisconnectRequest ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static DisconnectRequest ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(DisconnectRequest prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static DisconnectRequest()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
