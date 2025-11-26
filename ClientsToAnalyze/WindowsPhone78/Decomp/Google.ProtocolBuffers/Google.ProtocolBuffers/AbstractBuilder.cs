using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public abstract class AbstractBuilder<TMessage, TBuilder> : IBuilder<TMessage, TBuilder>, IBuilder where TMessage : AbstractMessage<TMessage, TBuilder> where TBuilder : AbstractBuilder<TMessage, TBuilder>
{
	private class LimitedInputStream : Stream
	{
		private readonly Stream proxied;

		private int bytesLeft;

		public override bool CanRead => true;

		public override bool CanSeek => false;

		public override bool CanWrite => false;

		public override long Length
		{
			get
			{
				throw new NotImplementedException();
			}
		}

		public override long Position
		{
			get
			{
				throw new NotImplementedException();
			}
			set
			{
				throw new NotImplementedException();
			}
		}

		internal LimitedInputStream(Stream proxied, int size)
		{
			this.proxied = proxied;
			bytesLeft = size;
		}

		public override void Flush()
		{
		}

		public override int Read(byte[] buffer, int offset, int count)
		{
			if (bytesLeft > 0)
			{
				int num = proxied.Read(buffer, offset, Math.Min(bytesLeft, count));
				bytesLeft -= num;
				return num;
			}
			return 0;
		}

		public override long Seek(long offset, SeekOrigin origin)
		{
			throw new NotImplementedException();
		}

		public override void SetLength(long value)
		{
			throw new NotImplementedException();
		}

		public override void Write(byte[] buffer, int offset, int count)
		{
			throw new NotImplementedException();
		}
	}

	protected abstract TBuilder ThisBuilder { get; }

	public abstract UnknownFieldSet UnknownFields { get; set; }

	public abstract bool IsInitialized { get; }

	public abstract IDictionary<FieldDescriptor, object> AllFields { get; }

	public abstract object this[FieldDescriptor field] { get; set; }

	public abstract MessageDescriptor DescriptorForType { get; }

	public abstract object this[FieldDescriptor field, int index] { get; set; }

	public abstract TMessage DefaultInstanceForType { get; }

	public IMessage WeakDefaultInstanceForType => DefaultInstanceForType;

	public abstract TBuilder MergeFrom(TMessage other);

	public abstract int GetRepeatedFieldCount(FieldDescriptor field);

	public abstract bool HasField(FieldDescriptor field);

	public abstract TMessage Build();

	public abstract TMessage BuildPartial();

	public abstract TBuilder Clone();

	public abstract IBuilder CreateBuilderForField(FieldDescriptor field);

	public abstract TBuilder ClearField(FieldDescriptor field);

	public abstract TBuilder AddRepeatedField(FieldDescriptor field, object value);

	public IMessage WeakBuild()
	{
		return Build();
	}

	public IBuilder WeakAddRepeatedField(FieldDescriptor field, object value)
	{
		return AddRepeatedField(field, value);
	}

	public IBuilder WeakClear()
	{
		return Clear();
	}

	public IBuilder WeakMergeFrom(IMessage message)
	{
		return MergeFrom(message);
	}

	public IBuilder WeakMergeFrom(CodedInputStream input)
	{
		return MergeFrom(input);
	}

	public IBuilder WeakMergeFrom(CodedInputStream input, ExtensionRegistry registry)
	{
		return MergeFrom(input, registry);
	}

	public IBuilder WeakMergeFrom(ByteString data)
	{
		return MergeFrom(data);
	}

	public IBuilder WeakMergeFrom(ByteString data, ExtensionRegistry registry)
	{
		return MergeFrom(data, registry);
	}

	public IMessage WeakBuildPartial()
	{
		return BuildPartial();
	}

	public IBuilder WeakClone()
	{
		return Clone();
	}

	public IBuilder WeakClearField(FieldDescriptor field)
	{
		return ClearField(field);
	}

	public TBuilder SetUnknownFields(UnknownFieldSet fields)
	{
		UnknownFields = fields;
		return ThisBuilder;
	}

	public virtual TBuilder Clear()
	{
		foreach (FieldDescriptor key in AllFields.Keys)
		{
			ClearField(key);
		}
		return ThisBuilder;
	}

	public virtual TBuilder MergeFrom(IMessage other)
	{
		if (other.DescriptorForType != DescriptorForType)
		{
			throw new ArgumentException("MergeFrom(IMessage) can only merge messages of the same type.");
		}
		foreach (KeyValuePair<FieldDescriptor, object> allField in other.AllFields)
		{
			FieldDescriptor key = allField.Key;
			if (key.IsRepeated)
			{
				foreach (object item in (IEnumerable)allField.Value)
				{
					AddRepeatedField(key, item);
				}
			}
			else if (key.MappedType == MappedType.Message)
			{
				IMessage message = (IMessage)this[key];
				if (message == message.WeakDefaultInstanceForType)
				{
					this[key] = allField.Value;
				}
				else
				{
					this[key] = message.WeakCreateBuilderForType().WeakMergeFrom(message).WeakMergeFrom((IMessage)allField.Value)
						.WeakBuild();
				}
			}
			else
			{
				this[key] = allField.Value;
			}
		}
		return ThisBuilder;
	}

	public virtual TBuilder MergeFrom(CodedInputStream input)
	{
		return MergeFrom(input, ExtensionRegistry.Empty);
	}

	public virtual TBuilder MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry)
	{
		UnknownFieldSet.Builder builder = UnknownFieldSet.CreateBuilder(UnknownFields);
		builder.MergeFrom(input, extensionRegistry, this);
		UnknownFields = builder.Build();
		return ThisBuilder;
	}

	public virtual TBuilder MergeUnknownFields(UnknownFieldSet unknownFields)
	{
		UnknownFields = UnknownFieldSet.CreateBuilder(UnknownFields).MergeFrom(unknownFields).Build();
		return ThisBuilder;
	}

	public virtual TBuilder MergeFrom(ByteString data)
	{
		CodedInputStream codedInputStream = data.CreateCodedInput();
		MergeFrom(codedInputStream);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	public virtual TBuilder MergeFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		CodedInputStream codedInputStream = data.CreateCodedInput();
		MergeFrom(codedInputStream, extensionRegistry);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	public virtual TBuilder MergeFrom(byte[] data)
	{
		CodedInputStream codedInputStream = CodedInputStream.CreateInstance(data);
		MergeFrom(codedInputStream);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	public virtual TBuilder MergeFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		CodedInputStream codedInputStream = CodedInputStream.CreateInstance(data);
		MergeFrom(codedInputStream, extensionRegistry);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	public virtual TBuilder MergeFrom(Stream input)
	{
		CodedInputStream codedInputStream = CodedInputStream.CreateInstance(input);
		MergeFrom(codedInputStream);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	public virtual TBuilder MergeFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		CodedInputStream codedInputStream = CodedInputStream.CreateInstance(input);
		MergeFrom(codedInputStream, extensionRegistry);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	public TBuilder MergeDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		int size = (int)CodedInputStream.ReadRawVarint32(input);
		Stream input2 = new LimitedInputStream(input, size);
		return MergeFrom(input2, extensionRegistry);
	}

	public TBuilder MergeDelimitedFrom(Stream input)
	{
		return MergeDelimitedFrom(input, ExtensionRegistry.Empty);
	}

	public virtual IBuilder SetField(FieldDescriptor field, object value)
	{
		this[field] = value;
		return ThisBuilder;
	}

	public virtual IBuilder SetRepeatedField(FieldDescriptor field, int index, object value)
	{
		this[field, index] = value;
		return ThisBuilder;
	}
}
