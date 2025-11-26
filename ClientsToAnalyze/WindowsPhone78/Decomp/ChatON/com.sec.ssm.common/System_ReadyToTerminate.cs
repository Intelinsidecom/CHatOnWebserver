using System;
using System.IO;
using Google.ProtocolBuffers;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace com.sec.ssm.common;

public sealed class System_ReadyToTerminate : GeneratedMessage<System_ReadyToTerminate, System_ReadyToTerminate.Builder>
{
	public sealed class Builder : GeneratedBuilder<System_ReadyToTerminate, Builder>
	{
		private System_ReadyToTerminate result = new System_ReadyToTerminate();

		protected override Builder ThisBuilder => this;

		protected override System_ReadyToTerminate MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override System_ReadyToTerminate DefaultInstanceForType => DefaultInstance;

		public bool HasDbBackup => result.HasDbBackup;

		public bool DbBackup
		{
			get
			{
				return result.DbBackup;
			}
			set
			{
				SetDbBackup(value);
			}
		}

		public bool HasConnectionClose => result.HasConnectionClose;

		public bool ConnectionClose
		{
			get
			{
				return result.ConnectionClose;
			}
			set
			{
				SetConnectionClose(value);
			}
		}

		public bool HasTerminateProcess => result.HasTerminateProcess;

		public bool TerminateProcess
		{
			get
			{
				return result.TerminateProcess;
			}
			set
			{
				SetTerminateProcess(value);
			}
		}

		public override Builder Clear()
		{
			result = new System_ReadyToTerminate();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override System_ReadyToTerminate BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			System_ReadyToTerminate system_ReadyToTerminate = result;
			result = null;
			return system_ReadyToTerminate;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is System_ReadyToTerminate)
			{
				return MergeFrom((System_ReadyToTerminate)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(System_ReadyToTerminate other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.HasDbBackup)
			{
				DbBackup = other.DbBackup;
			}
			if (other.HasConnectionClose)
			{
				ConnectionClose = other.ConnectionClose;
			}
			if (other.HasTerminateProcess)
			{
				TerminateProcess = other.TerminateProcess;
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
					DbBackup = input.ReadBool();
					continue;
				case 16u:
					ConnectionClose = input.ReadBool();
					continue;
				case 24u:
					TerminateProcess = input.ReadBool();
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

		public Builder SetDbBackup(bool value)
		{
			result.hasDbBackup = true;
			result.dbBackup_ = value;
			return this;
		}

		public Builder ClearDbBackup()
		{
			result.hasDbBackup = false;
			result.dbBackup_ = false;
			return this;
		}

		public Builder SetConnectionClose(bool value)
		{
			result.hasConnectionClose = true;
			result.connectionClose_ = value;
			return this;
		}

		public Builder ClearConnectionClose()
		{
			result.hasConnectionClose = false;
			result.connectionClose_ = false;
			return this;
		}

		public Builder SetTerminateProcess(bool value)
		{
			result.hasTerminateProcess = true;
			result.terminateProcess_ = value;
			return this;
		}

		public Builder ClearTerminateProcess()
		{
			result.hasTerminateProcess = false;
			result.terminateProcess_ = false;
			return this;
		}
	}

	public const int DbBackupFieldNumber = 1;

	public const int ConnectionCloseFieldNumber = 2;

	public const int TerminateProcessFieldNumber = 3;

	private static readonly System_ReadyToTerminate defaultInstance;

	private bool hasDbBackup;

	private bool dbBackup_;

	private bool hasConnectionClose;

	private bool connectionClose_;

	private bool hasTerminateProcess;

	private bool terminateProcess_;

	private int memoizedSerializedSize = -1;

	public static System_ReadyToTerminate DefaultInstance => defaultInstance;

	public override System_ReadyToTerminate DefaultInstanceForType => defaultInstance;

	protected override System_ReadyToTerminate ThisMessage => this;

	public static MessageDescriptor Descriptor => SSMGPB.internal__static_com_sec_ssm_common_System_ReadyToTerminate__Descriptor;

	protected override FieldAccessorTable<System_ReadyToTerminate, Builder> InternalFieldAccessors => SSMGPB.internal__static_com_sec_ssm_common_System_ReadyToTerminate__FieldAccessorTable;

	public bool HasDbBackup => hasDbBackup;

	public bool DbBackup => dbBackup_;

	public bool HasConnectionClose => hasConnectionClose;

	public bool ConnectionClose => connectionClose_;

	public bool HasTerminateProcess => hasTerminateProcess;

	public bool TerminateProcess => terminateProcess_;

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
			if (HasDbBackup)
			{
				num += CodedOutputStream.ComputeBoolSize(1, DbBackup);
			}
			if (HasConnectionClose)
			{
				num += CodedOutputStream.ComputeBoolSize(2, ConnectionClose);
			}
			if (HasTerminateProcess)
			{
				num += CodedOutputStream.ComputeBoolSize(3, TerminateProcess);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		if (HasDbBackup)
		{
			output.WriteBool(1, DbBackup);
		}
		if (HasConnectionClose)
		{
			output.WriteBool(2, ConnectionClose);
		}
		if (HasTerminateProcess)
		{
			output.WriteBool(3, TerminateProcess);
		}
		UnknownFields.WriteTo(output);
	}

	public static System_ReadyToTerminate ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static System_ReadyToTerminate ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static System_ReadyToTerminate ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static System_ReadyToTerminate ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static System_ReadyToTerminate ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static System_ReadyToTerminate ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static System_ReadyToTerminate ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static System_ReadyToTerminate ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static System_ReadyToTerminate ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static System_ReadyToTerminate ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(System_ReadyToTerminate prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static System_ReadyToTerminate()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(SSMGPB.Descriptor, null);
	}
}
