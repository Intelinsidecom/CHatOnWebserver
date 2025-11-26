using System;
using System.Collections.Generic;

namespace Google.ProtocolBuffers;

public abstract class GeneratedBuilderLite<TMessage, TBuilder> : AbstractBuilderLite<TMessage, TBuilder> where TMessage : GeneratedMessageLite<TMessage, TBuilder> where TBuilder : GeneratedBuilderLite<TMessage, TBuilder>
{
	protected abstract TMessage MessageBeingBuilt { get; }

	public override bool IsInitialized
	{
		get
		{
			TMessage messageBeingBuilt = MessageBeingBuilt;
			return messageBeingBuilt.IsInitialized;
		}
	}

	public override TBuilder MergeFrom(IMessageLite other)
	{
		return ThisBuilder;
	}

	public abstract TBuilder MergeFrom(TMessage other);

	protected void AddRange<T>(IEnumerable<T> source, IList<T> destination)
	{
		ThrowHelper.ThrowIfNull(source);
		if (default(T) == null)
		{
			ThrowHelper.ThrowIfAnyNull(source);
		}
		if (destination is List<T> list)
		{
			list.AddRange(source);
			return;
		}
		foreach (T item in source)
		{
			destination.Add(item);
		}
	}

	[CLSCompliant(false)]
	protected virtual bool ParseUnknownField(CodedInputStream input, ExtensionRegistry extensionRegistry, uint tag)
	{
		return input.SkipField(tag);
	}

	public TMessage BuildParsed()
	{
		if (!IsInitialized)
		{
			throw new UninitializedMessageException(MessageBeingBuilt).AsInvalidProtocolBufferException();
		}
		return BuildPartial();
	}

	public override TMessage Build()
	{
		if (MessageBeingBuilt != null && !IsInitialized)
		{
			throw new UninitializedMessageException(MessageBeingBuilt);
		}
		return BuildPartial();
	}
}
