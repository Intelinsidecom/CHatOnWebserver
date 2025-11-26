using System;
using System.Collections.Generic;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public sealed class ExtensionRegistry
{
	private struct DescriptorIntPair : IEquatable<DescriptorIntPair>
	{
		private readonly MessageDescriptor descriptor;

		private readonly int number;

		internal DescriptorIntPair(MessageDescriptor descriptor, int number)
		{
			this.descriptor = descriptor;
			this.number = number;
		}

		public override int GetHashCode()
		{
			return descriptor.GetHashCode() * 65535 + number;
		}

		public override bool Equals(object obj)
		{
			if (!(obj is DescriptorIntPair))
			{
				return false;
			}
			return Equals((DescriptorIntPair)obj);
		}

		public bool Equals(DescriptorIntPair other)
		{
			if (descriptor == other.descriptor)
			{
				return number == other.number;
			}
			return false;
		}
	}

	private static readonly ExtensionRegistry empty = new ExtensionRegistry(new Dictionary<string, ExtensionInfo>(), new Dictionary<DescriptorIntPair, ExtensionInfo>(), readOnly: true);

	private readonly IDictionary<string, ExtensionInfo> extensionsByName;

	private readonly IDictionary<DescriptorIntPair, ExtensionInfo> extensionsByNumber;

	private readonly bool readOnly;

	public static ExtensionRegistry Empty => empty;

	public ExtensionInfo this[string fullName]
	{
		get
		{
			extensionsByName.TryGetValue(fullName, out var value);
			return value;
		}
	}

	public ExtensionInfo this[MessageDescriptor containingType, int fieldNumber]
	{
		get
		{
			extensionsByNumber.TryGetValue(new DescriptorIntPair(containingType, fieldNumber), out var value);
			return value;
		}
	}

	private ExtensionRegistry(IDictionary<string, ExtensionInfo> extensionsByName, IDictionary<DescriptorIntPair, ExtensionInfo> extensionsByNumber, bool readOnly)
	{
		this.extensionsByName = extensionsByName;
		this.extensionsByNumber = extensionsByNumber;
		this.readOnly = readOnly;
	}

	public static ExtensionRegistry CreateInstance()
	{
		return new ExtensionRegistry(new Dictionary<string, ExtensionInfo>(), new Dictionary<DescriptorIntPair, ExtensionInfo>(), readOnly: false);
	}

	public ExtensionRegistry AsReadOnly()
	{
		return new ExtensionRegistry(extensionsByName, extensionsByNumber, readOnly: true);
	}

	public void Add<TExtension>(GeneratedExtensionBase<TExtension> extension)
	{
		if (extension.Descriptor.MappedType == MappedType.Message)
		{
			Add(new ExtensionInfo(extension.Descriptor, extension.MessageDefaultInstance));
		}
		else
		{
			Add(new ExtensionInfo(extension.Descriptor, null));
		}
	}

	public void Add(FieldDescriptor type)
	{
		if (type.MappedType == MappedType.Message)
		{
			throw new ArgumentException("ExtensionRegistry.Add() must be provided a default instance when adding an embedded message extension.");
		}
		Add(new ExtensionInfo(type, null));
	}

	public void Add(FieldDescriptor type, IMessage defaultInstance)
	{
		if (type.MappedType != MappedType.Message)
		{
			throw new ArgumentException("ExtensionRegistry.Add() provided a default instance for a non-message extension.");
		}
		Add(new ExtensionInfo(type, defaultInstance));
	}

	private void Add(ExtensionInfo extension)
	{
		if (readOnly)
		{
			throw new InvalidOperationException("Cannot add entries to a read-only extension registry");
		}
		if (!extension.Descriptor.IsExtension)
		{
			throw new ArgumentException("ExtensionRegistry.add() was given a FieldDescriptor for a regular (non-extension) field.");
		}
		extensionsByName[extension.Descriptor.FullName] = extension;
		extensionsByNumber[new DescriptorIntPair(extension.Descriptor.ContainingType, extension.Descriptor.FieldNumber)] = extension;
		FieldDescriptor descriptor = extension.Descriptor;
		if (descriptor.ContainingType.Options.MessageSetWireFormat && descriptor.FieldType == FieldType.Message && descriptor.IsOptional && descriptor.ExtensionScope == descriptor.MessageType)
		{
			extensionsByName[descriptor.MessageType.FullName] = extension;
		}
	}
}
