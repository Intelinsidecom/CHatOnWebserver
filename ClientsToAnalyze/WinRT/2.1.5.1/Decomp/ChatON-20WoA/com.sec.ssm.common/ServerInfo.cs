using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class ServerInfo : GeneratedMessage<ServerInfo, ServerInfo.Builder>
{
	public sealed class Builder : GeneratedBuilder<ServerInfo, Builder>
	{
		private ServerInfo result = new ServerInfo();

		protected override Builder ThisBuilder => this;

		protected override ServerInfo MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override ServerInfo DefaultInstanceForType => DefaultInstance;

		public bool HasAddress => result.HasAddress;

		public string Address
		{
			get
			{
				return result.Address;
			}
			set
			{
				SetAddress(value);
			}
		}

		public bool HasPort => result.HasPort;

		public int Port
		{
			get
			{
				return result.Port;
			}
			set
			{
				SetPort(value);
			}
		}

		public override Builder Clear()
		{
			result = new ServerInfo();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override ServerInfo BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			ServerInfo serverInfo = result;
			result = null;
			return serverInfo;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is ServerInfo)
			{
				return MergeFrom((ServerInfo)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(ServerInfo other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasAddress)
			{
				Address = other.Address;
			}
			if (other.HasPort)
			{
				Port = other.Port;
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
				case 10u:
					Address = input.ReadString();
					continue;
				case 16u:
					Port = input.ReadInt32();
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

		public Builder SetAddress(string value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.hasAddress = true;
			result.address_ = value;
			return this;
		}

		public Builder ClearAddress()
		{
			result.hasAddress = false;
			result.address_ = "";
			return this;
		}

		public Builder SetPort(int value)
		{
			result.hasPort = true;
			result.port_ = value;
			return this;
		}

		public Builder ClearPort()
		{
			result.hasPort = false;
			result.port_ = 0;
			return this;
		}
	}

	public const int AddressFieldNumber = 1;

	public const int PortFieldNumber = 2;

	private static readonly ServerInfo defaultInstance;

	private bool hasAddress;

	private string address_ = "";

	private bool hasPort;

	private int port_;

	private int memoizedSerializedSize = -1;

	public static ServerInfo DefaultInstance => defaultInstance;

	public override ServerInfo DefaultInstanceForType => defaultInstance;

	protected override ServerInfo ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_ServerInfo__Descriptor;

	protected override FieldAccessorTable<ServerInfo, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_ServerInfo__FieldAccessorTable;

	public bool HasAddress => hasAddress;

	public string Address => address_;

	public bool HasPort => hasPort;

	public int Port => port_;

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
			if (HasAddress)
			{
				num += CodedOutputStream.ComputeStringSize(1, Address);
			}
			if (HasPort)
			{
				num += CodedOutputStream.ComputeInt32Size(2, Port);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasAddress)
		{
			output.WriteString(1, Address);
		}
		if (HasPort)
		{
			output.WriteInt32(2, Port);
		}
		UnknownFields.WriteTo(output);
	}

	public static ServerInfo ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static ServerInfo ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static ServerInfo ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static ServerInfo ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static ServerInfo ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static ServerInfo ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static ServerInfo ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static ServerInfo ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static ServerInfo ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static ServerInfo ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(ServerInfo prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static ServerInfo()
	{
		defaultInstance = new Builder().BuildPartial();
	}
}
