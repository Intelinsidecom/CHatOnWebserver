using System;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;
using Google.ProtocolBuffers.FieldAccess;

namespace Google.ProtocolBuffers.DescriptorProtos;

public sealed class FileDescriptorSet : GeneratedMessage<FileDescriptorSet, FileDescriptorSet.Builder>
{
	public sealed class Builder : GeneratedBuilder<FileDescriptorSet, Builder>
	{
		private FileDescriptorSet result = new FileDescriptorSet();

		protected override Builder ThisBuilder => this;

		protected override FileDescriptorSet MessageBeingBuilt => result;

		public override MessageDescriptor DescriptorForType => Descriptor;

		public override FileDescriptorSet DefaultInstanceForType => DefaultInstance;

		public IPopsicleList<FileDescriptorProto> FileList => result.file_;

		public int FileCount => result.FileCount;

		public override Builder Clear()
		{
			result = new FileDescriptorSet();
			return this;
		}

		public override Builder Clone()
		{
			return new Builder().MergeFrom(result);
		}

		public override FileDescriptorSet BuildPartial()
		{
			if (result == null)
			{
				throw new InvalidOperationException("build() has already been called on this Builder");
			}
			result.file_.MakeReadOnly();
			FileDescriptorSet fileDescriptorSet = result;
			result = null;
			return fileDescriptorSet;
		}

		public override Builder MergeFrom(IMessage other)
		{
			if (other is FileDescriptorSet)
			{
				return MergeFrom((FileDescriptorSet)other);
			}
			base.MergeFrom(other);
			return this;
		}

		public override Builder MergeFrom(FileDescriptorSet other)
		{
			if (other == DefaultInstance)
			{
				return this;
			}
			if (other.file_.Count != 0)
			{
				AddRange(other.file_, result.file_);
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
				{
					FileDescriptorProto.Builder builder2 = FileDescriptorProto.CreateBuilder();
					input.ReadMessage(builder2, extensionRegistry);
					AddFile(builder2.BuildPartial());
					continue;
				}
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

		public FileDescriptorProto GetFile(int index)
		{
			return result.GetFile(index);
		}

		public Builder SetFile(int index, FileDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.file_[index] = value;
			return this;
		}

		public Builder SetFile(int index, FileDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.file_[index] = builderForValue.Build();
			return this;
		}

		public Builder AddFile(FileDescriptorProto value)
		{
			ThrowHelper.ThrowIfNull(value, "value");
			result.file_.Add(value);
			return this;
		}

		public Builder AddFile(FileDescriptorProto.Builder builderForValue)
		{
			ThrowHelper.ThrowIfNull(builderForValue, "builderForValue");
			result.file_.Add(builderForValue.Build());
			return this;
		}

		public Builder AddRangeFile(IEnumerable<FileDescriptorProto> values)
		{
			AddRange(values, result.file_);
			return this;
		}

		public Builder ClearFile()
		{
			result.file_.Clear();
			return this;
		}
	}

	public const int FileFieldNumber = 1;

	private static readonly FileDescriptorSet defaultInstance;

	private PopsicleList<FileDescriptorProto> file_ = new PopsicleList<FileDescriptorProto>();

	private int memoizedSerializedSize = -1;

	public static FileDescriptorSet DefaultInstance => defaultInstance;

	public override FileDescriptorSet DefaultInstanceForType => defaultInstance;

	protected override FileDescriptorSet ThisMessage => this;

	public static MessageDescriptor Descriptor => DescriptorProtoFile.internal__static_google_protobuf_FileDescriptorSet__Descriptor;

	protected override FieldAccessorTable<FileDescriptorSet, Builder> InternalFieldAccessors => DescriptorProtoFile.internal__static_google_protobuf_FileDescriptorSet__FieldAccessorTable;

	public IList<FileDescriptorProto> FileList => file_;

	public int FileCount => file_.Count;

	public override bool IsInitialized
	{
		get
		{
			foreach (FileDescriptorProto file in FileList)
			{
				if (!file.IsInitialized)
				{
					return false;
				}
			}
			return true;
		}
	}

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
			foreach (FileDescriptorProto file in FileList)
			{
				num += CodedOutputStream.ComputeMessageSize(1, file);
			}
			return memoizedSerializedSize = num + UnknownFields.SerializedSize;
		}
	}

	public FileDescriptorProto GetFile(int index)
	{
		return file_[index];
	}

	public override void WriteTo(CodedOutputStream output)
	{
		_ = SerializedSize;
		foreach (FileDescriptorProto file in FileList)
		{
			output.WriteMessage(1, file);
		}
		UnknownFields.WriteTo(output);
	}

	public static FileDescriptorSet ParseFrom(ByteString data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static FileDescriptorSet ParseFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static FileDescriptorSet ParseFrom(byte[] data)
	{
		return CreateBuilder().MergeFrom(data).BuildParsed();
	}

	public static FileDescriptorSet ParseFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(data, extensionRegistry).BuildParsed();
	}

	public static FileDescriptorSet ParseFrom(Stream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static FileDescriptorSet ParseFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeFrom(input, extensionRegistry).BuildParsed();
	}

	public static FileDescriptorSet ParseDelimitedFrom(Stream input)
	{
		return CreateBuilder().MergeDelimitedFrom(input).BuildParsed();
	}

	public static FileDescriptorSet ParseDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		return CreateBuilder().MergeDelimitedFrom(input, extensionRegistry).BuildParsed();
	}

	public static FileDescriptorSet ParseFrom(CodedInputStream input)
	{
		return CreateBuilder().MergeFrom(input).BuildParsed();
	}

	public static FileDescriptorSet ParseFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
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

	public static Builder CreateBuilder(FileDescriptorSet prototype)
	{
		return new Builder().MergeFrom(prototype);
	}

	static FileDescriptorSet()
	{
		defaultInstance = new Builder().BuildPartial();
		object.ReferenceEquals(DescriptorProtoFile.Descriptor, null);
	}
}
