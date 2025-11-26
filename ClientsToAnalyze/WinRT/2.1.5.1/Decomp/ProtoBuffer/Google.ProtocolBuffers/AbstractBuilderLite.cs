using System;
using System.IO;

namespace Google.ProtocolBuffers;

public abstract class AbstractBuilderLite<TMessage, TBuilder> : IBuilderLite<TMessage, TBuilder>, IBuilderLite where TMessage : AbstractMessageLite<TMessage, TBuilder> where TBuilder : AbstractBuilderLite<TMessage, TBuilder>
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
				throw new NotSupportedException();
			}
		}

		public override long Position
		{
			get
			{
				throw new NotSupportedException();
			}
			set
			{
				throw new NotSupportedException();
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
			throw new NotSupportedException();
		}

		public override void SetLength(long value)
		{
			throw new NotSupportedException();
		}

		public override void Write(byte[] buffer, int offset, int count)
		{
			throw new NotSupportedException();
		}
	}

	protected abstract TBuilder ThisBuilder { get; }

	public abstract bool IsInitialized { get; }

	public abstract TMessage DefaultInstanceForType { get; }

	IMessageLite IBuilderLite.WeakDefaultInstanceForType => DefaultInstanceForType;

	public abstract TBuilder Clear();

	public abstract TBuilder Clone();

	public abstract TMessage Build();

	public abstract TMessage BuildPartial();

	public abstract TBuilder MergeFrom(IMessageLite other);

	public abstract TBuilder MergeFrom(CodedInputStream input, ExtensionRegistry extensionRegistry);

	public virtual TBuilder MergeFrom(CodedInputStream input)
	{
		return MergeFrom(input, ExtensionRegistry.CreateInstance());
	}

	public TBuilder MergeDelimitedFrom(Stream input)
	{
		return MergeDelimitedFrom(input, ExtensionRegistry.CreateInstance());
	}

	public TBuilder MergeDelimitedFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		int size = (int)CodedInputStream.ReadRawVarint32(input);
		Stream input2 = new LimitedInputStream(input, size);
		return MergeFrom(input2, extensionRegistry);
	}

	public TBuilder MergeFrom(ByteString data)
	{
		return MergeFrom(data, ExtensionRegistry.CreateInstance());
	}

	public TBuilder MergeFrom(ByteString data, ExtensionRegistry extensionRegistry)
	{
		CodedInputStream codedInputStream = data.CreateCodedInput();
		MergeFrom(codedInputStream, extensionRegistry);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	public TBuilder MergeFrom(byte[] data)
	{
		CodedInputStream codedInputStream = CodedInputStream.CreateInstance(data);
		MergeFrom(codedInputStream);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	public TBuilder MergeFrom(byte[] data, ExtensionRegistry extensionRegistry)
	{
		CodedInputStream codedInputStream = CodedInputStream.CreateInstance(data);
		MergeFrom(codedInputStream, extensionRegistry);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	public TBuilder MergeFrom(Stream input)
	{
		CodedInputStream codedInputStream = CodedInputStream.CreateInstance(input);
		MergeFrom(codedInputStream);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	public TBuilder MergeFrom(Stream input, ExtensionRegistry extensionRegistry)
	{
		CodedInputStream codedInputStream = CodedInputStream.CreateInstance(input);
		MergeFrom(codedInputStream, extensionRegistry);
		codedInputStream.CheckLastTagWas(0u);
		return ThisBuilder;
	}

	IBuilderLite IBuilderLite.WeakClear()
	{
		return Clear();
	}

	IBuilderLite IBuilderLite.WeakMergeFrom(IMessageLite message)
	{
		return MergeFrom(message);
	}

	IBuilderLite IBuilderLite.WeakMergeFrom(ByteString data)
	{
		return MergeFrom(data);
	}

	IBuilderLite IBuilderLite.WeakMergeFrom(ByteString data, ExtensionRegistry registry)
	{
		return MergeFrom(data, registry);
	}

	IBuilderLite IBuilderLite.WeakMergeFrom(CodedInputStream input)
	{
		return MergeFrom(input);
	}

	IBuilderLite IBuilderLite.WeakMergeFrom(CodedInputStream input, ExtensionRegistry registry)
	{
		return MergeFrom(input, registry);
	}

	IMessageLite IBuilderLite.WeakBuild()
	{
		return Build();
	}

	IMessageLite IBuilderLite.WeakBuildPartial()
	{
		return BuildPartial();
	}

	IBuilderLite IBuilderLite.WeakClone()
	{
		return Clone();
	}
}
