using System;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using Google.ProtocolBuffers.Collections;

namespace Google.ProtocolBuffers;

public abstract class ExtendableMessageLite<TMessage, TBuilder> : GeneratedMessageLite<TMessage, TBuilder> where TMessage : GeneratedMessageLite<TMessage, TBuilder> where TBuilder : GeneratedBuilderLite<TMessage, TBuilder>
{
	protected class ExtensionWriter
	{
		private readonly IEnumerator<KeyValuePair<IFieldDescriptorLite, object>> iterator;

		private readonly FieldSet extensions;

		private KeyValuePair<IFieldDescriptorLite, object>? next = null;

		internal ExtensionWriter(ExtendableMessageLite<TMessage, TBuilder> message)
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

	public override bool IsInitialized => ExtensionsAreInitialized;

	protected int ExtensionsSerializedSize => extensions.SerializedSize;

	public override bool Equals(object obj)
	{
		ExtendableMessageLite<TMessage, TBuilder> extendableMessageLite = obj as ExtendableMessageLite<TMessage, TBuilder>;
		if (!object.ReferenceEquals(null, extendableMessageLite))
		{
			return Dictionaries.Equals(extensions.AllFields, extendableMessageLite.extensions.AllFields);
		}
		return false;
	}

	public override int GetHashCode()
	{
		return Dictionaries.GetHashCode(extensions.AllFields);
	}

	public override void PrintTo(TextWriter writer)
	{
		foreach (KeyValuePair<IFieldDescriptorLite, object> allField in extensions.AllFields)
		{
			string name = $"[{allField.Key.FullName}]";
			if (allField.Key.IsRepeated)
			{
				foreach (object item in (IEnumerable)allField.Value)
				{
					GeneratedMessageLite<TMessage, TBuilder>.PrintField(name, hasValue: true, item, writer);
				}
			}
			else
			{
				GeneratedMessageLite<TMessage, TBuilder>.PrintField(name, hasValue: true, allField.Value, writer);
			}
		}
	}

	public bool HasExtension<TExtension>(GeneratedExtensionLite<TMessage, TExtension> extension)
	{
		VerifyExtensionContainingType(extension);
		return extensions.HasField(extension.Descriptor);
	}

	public int GetExtensionCount<TExtension>(GeneratedExtensionLite<TMessage, IList<TExtension>> extension)
	{
		VerifyExtensionContainingType(extension);
		return extensions.GetRepeatedFieldCount(extension.Descriptor);
	}

	public TExtension GetExtension<TExtension>(GeneratedExtensionLite<TMessage, TExtension> extension)
	{
		VerifyExtensionContainingType(extension);
		object obj = extensions[extension.Descriptor];
		if (obj == null)
		{
			return extension.DefaultValue;
		}
		return (TExtension)extension.FromReflectionType(obj);
	}

	public TExtension GetExtension<TExtension>(GeneratedExtensionLite<TMessage, IList<TExtension>> extension, int index)
	{
		VerifyExtensionContainingType(extension);
		return (TExtension)extension.SingularFromReflectionType(extensions[extension.Descriptor, index]);
	}

	protected ExtensionWriter CreateExtensionWriter(ExtendableMessageLite<TMessage, TBuilder> message)
	{
		return new ExtensionWriter(message);
	}

	internal void VerifyExtensionContainingType<TExtension>(GeneratedExtensionLite<TMessage, TExtension> extension)
	{
		if (!object.ReferenceEquals(extension.ContainingTypeDefaultInstance, DefaultInstanceForType))
		{
			throw new ArgumentException(string.Format("Extension is for type \"{0}\" which does not match message type \"{1}\".", new object[2] { extension.ContainingTypeDefaultInstance, DefaultInstanceForType }));
		}
	}
}
