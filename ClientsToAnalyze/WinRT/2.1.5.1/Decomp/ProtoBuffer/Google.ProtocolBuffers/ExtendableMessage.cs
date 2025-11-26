using System;
using System.Collections.Generic;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public abstract class ExtendableMessage<TMessage, TBuilder> : GeneratedMessage<TMessage, TBuilder> where TMessage : GeneratedMessage<TMessage, TBuilder> where TBuilder : GeneratedBuilder<TMessage, TBuilder>
{
	protected class ExtensionWriter
	{
		private readonly IEnumerator<KeyValuePair<IFieldDescriptorLite, object>> iterator;

		private readonly FieldSet extensions;

		private KeyValuePair<IFieldDescriptorLite, object>? next = null;

		internal ExtensionWriter(ExtendableMessage<TMessage, TBuilder> message)
		{
			extensions = message.extensions;
			iterator = message.extensions.GetEnumerator();
			if (iterator.MoveNext())
			{
				next = iterator.Current;
			}
		}

		public void WriteUntil(int end, CodedOutputStream output)
		{
			while (next.HasValue && next.Value.Key.FieldNumber < end)
			{
				extensions.WriteField(next.Value.Key, next.Value.Value, output);
				if (iterator.MoveNext())
				{
					next = iterator.Current;
				}
				else
				{
					next = null;
				}
			}
		}
	}

	private readonly FieldSet extensions = FieldSet.CreateInstance();

	internal FieldSet Extensions => extensions;

	protected bool ExtensionsAreInitialized => extensions.IsInitialized;

	public override bool IsInitialized
	{
		get
		{
			if (base.IsInitialized)
			{
				return ExtensionsAreInitialized;
			}
			return false;
		}
	}

	public override IDictionary<FieldDescriptor, object> AllFields
	{
		get
		{
			IDictionary<FieldDescriptor, object> mutableFieldMap = GetMutableFieldMap();
			foreach (KeyValuePair<IFieldDescriptorLite, object> allField in extensions.AllFields)
			{
				mutableFieldMap[(FieldDescriptor)allField.Key] = allField.Value;
			}
			return Dictionaries.AsReadOnly(mutableFieldMap);
		}
	}

	public override object this[FieldDescriptor field]
	{
		get
		{
			if (field.IsExtension)
			{
				VerifyContainingType(field);
				object obj = extensions[field];
				if (obj == null)
				{
					return DynamicMessage.GetDefaultInstance(field.MessageType);
				}
				return obj;
			}
			return base[field];
		}
	}

	public override object this[FieldDescriptor field, int index]
	{
		get
		{
			if (field.IsExtension)
			{
				VerifyContainingType(field);
				return extensions[field, index];
			}
			return base[field, index];
		}
	}

	protected int ExtensionsSerializedSize => extensions.SerializedSize;

	public bool HasExtension<TExtension>(GeneratedExtensionBase<TExtension> extension)
	{
		return extensions.HasField(extension.Descriptor);
	}

	public int GetExtensionCount<TExtension>(GeneratedExtensionBase<IList<TExtension>> extension)
	{
		return extensions.GetRepeatedFieldCount(extension.Descriptor);
	}

	public TExtension GetExtension<TExtension>(GeneratedExtensionBase<TExtension> extension)
	{
		object obj = extensions[extension.Descriptor];
		if (obj == null)
		{
			return (TExtension)extension.MessageDefaultInstance;
		}
		return (TExtension)extension.FromReflectionType(obj);
	}

	public TExtension GetExtension<TExtension>(GeneratedExtensionBase<IList<TExtension>> extension, int index)
	{
		return (TExtension)extension.SingularFromReflectionType(extensions[extension.Descriptor, index]);
	}

	public override bool HasField(FieldDescriptor field)
	{
		if (field.IsExtension)
		{
			VerifyContainingType(field);
			return extensions.HasField(field);
		}
		return base.HasField(field);
	}

	public override int GetRepeatedFieldCount(FieldDescriptor field)
	{
		if (field.IsExtension)
		{
			VerifyContainingType(field);
			return extensions.GetRepeatedFieldCount(field);
		}
		return base.GetRepeatedFieldCount(field);
	}

	internal void VerifyContainingType(FieldDescriptor field)
	{
		if (field.ContainingType != DescriptorForType)
		{
			throw new ArgumentException("FieldDescriptor does not match message type.");
		}
	}

	protected ExtensionWriter CreateExtensionWriter(ExtendableMessage<TMessage, TBuilder> message)
	{
		return new ExtensionWriter(message);
	}

	internal void VerifyExtensionContainingType<TExtension>(GeneratedExtensionBase<TExtension> extension)
	{
		if (extension.Descriptor.ContainingType != DescriptorForType)
		{
			throw new ArgumentException("Extension is for type \"" + extension.Descriptor.ContainingType.FullName + "\" which does not match message type \"" + DescriptorForType.FullName + "\".");
		}
	}
}
