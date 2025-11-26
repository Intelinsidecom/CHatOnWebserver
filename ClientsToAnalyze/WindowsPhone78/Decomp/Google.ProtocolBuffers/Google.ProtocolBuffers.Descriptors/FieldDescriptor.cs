using System;
using System.Collections.Generic;
using System.Reflection;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.DescriptorProtos;

namespace Google.ProtocolBuffers.Descriptors;

public sealed class FieldDescriptor : IndexedDescriptorBase<FieldDescriptorProto, FieldOptions>, IComparable<FieldDescriptor>
{
	private readonly MessageDescriptor extensionScope;

	private EnumDescriptor enumType;

	private MessageDescriptor messageType;

	private MessageDescriptor containingType;

	private object defaultValue;

	private FieldType fieldType;

	private MappedType mappedType;

	private CSharpFieldOptions csharpFieldOptions;

	private readonly object optionsLock = new object();

	public static readonly IDictionary<FieldType, MappedType> FieldTypeToMappedTypeMap = MapFieldTypes();

	public bool IsRequired => base.Proto.Label == FieldDescriptorProto.Types.Label.LABEL_REQUIRED;

	public bool IsOptional => base.Proto.Label == FieldDescriptorProto.Types.Label.LABEL_OPTIONAL;

	public bool IsRepeated => base.Proto.Label == FieldDescriptorProto.Types.Label.LABEL_REPEATED;

	public bool IsPacked => base.Proto.Options.Packed;

	public bool HasDefaultValue => base.Proto.HasDefaultValue;

	public object DefaultValue
	{
		get
		{
			if (MappedType == MappedType.Message)
			{
				throw new InvalidOperationException("FieldDescriptor.DefaultValue called on an embedded message field.");
			}
			return defaultValue;
		}
	}

	public bool IsExtension => base.Proto.HasExtendee;

	public MessageDescriptor ContainingType => containingType;

	public CSharpFieldOptions CSharpOptions
	{
		get
		{
			lock (optionsLock)
			{
				if (csharpFieldOptions == null)
				{
					csharpFieldOptions = BuildOrFakeCSharpOptions();
				}
			}
			return csharpFieldOptions;
		}
	}

	public MessageDescriptor ExtensionScope
	{
		get
		{
			if (!IsExtension)
			{
				throw new InvalidOperationException("This field is not an extension.");
			}
			return extensionScope;
		}
	}

	public MappedType MappedType => mappedType;

	public FieldType FieldType => fieldType;

	public bool IsCLSCompliant
	{
		get
		{
			if (mappedType != MappedType.UInt32)
			{
				return mappedType != MappedType.UInt64;
			}
			return false;
		}
	}

	public int FieldNumber => base.Proto.Number;

	public EnumDescriptor EnumType
	{
		get
		{
			if (MappedType != MappedType.Enum)
			{
				throw new InvalidOperationException("EnumType is only valid for enum fields.");
			}
			return enumType;
		}
	}

	public MessageDescriptor MessageType
	{
		get
		{
			if (MappedType != MappedType.Message)
			{
				throw new InvalidOperationException("MessageType is only valid for enum fields.");
			}
			return messageType;
		}
	}

	internal FieldDescriptor(FieldDescriptorProto proto, FileDescriptor file, MessageDescriptor parent, int index, bool isExtension)
		: base(proto, file, DescriptorBase<FieldDescriptorProto, FieldOptions>.ComputeFullName(file, parent, proto.Name), index)
	{
		if (proto.HasType)
		{
			fieldType = GetFieldTypeFromProtoType(proto.Type);
			mappedType = FieldTypeToMappedTypeMap[fieldType];
		}
		if (FieldNumber <= 0)
		{
			throw new DescriptorValidationException(this, "Field numbers must be positive integers.");
		}
		if (isExtension)
		{
			if (!proto.HasExtendee)
			{
				throw new DescriptorValidationException(this, "FieldDescriptorProto.Extendee not set for extension field.");
			}
			containingType = null;
			if (parent != null)
			{
				extensionScope = parent;
			}
			else
			{
				extensionScope = null;
			}
		}
		else
		{
			if (proto.HasExtendee)
			{
				throw new DescriptorValidationException(this, "FieldDescriptorProto.Extendee set for non-extension field.");
			}
			containingType = parent;
			extensionScope = null;
		}
		file.DescriptorPool.AddSymbol(this);
	}

	private CSharpFieldOptions BuildOrFakeCSharpOptions()
	{
		if (base.File.Proto.Name == "google/protobuf/csharp_options.proto")
		{
			if (base.Name == "csharp_field_options")
			{
				CSharpFieldOptions.Builder builder = new CSharpFieldOptions.Builder();
				builder.PropertyName = "CSharpFieldOptions";
				return builder.Build();
			}
			if (base.Name == "csharp_file_options")
			{
				CSharpFieldOptions.Builder builder2 = new CSharpFieldOptions.Builder();
				builder2.PropertyName = "CSharpFileOptions";
				return builder2.Build();
			}
		}
		CSharpFieldOptions.Builder builder3 = CSharpFieldOptions.CreateBuilder();
		if (base.Proto.Options.HasExtension(Google.ProtocolBuffers.DescriptorProtos.CSharpOptions.CSharpFieldOptions))
		{
			builder3.MergeFrom(base.Proto.Options.GetExtension(Google.ProtocolBuffers.DescriptorProtos.CSharpOptions.CSharpFieldOptions));
		}
		if (!builder3.HasPropertyName)
		{
			string input = ((FieldType == FieldType.Group) ? MessageType.Name : base.Name);
			string text = NameHelpers.UnderscoresToPascalCase(input);
			if (text == ContainingType.Name)
			{
				text += "_";
			}
			builder3.PropertyName = text;
		}
		return builder3.Build();
	}

	private static FieldType GetFieldTypeFromProtoType(FieldDescriptorProto.Types.Type type)
	{
		return type switch
		{
			FieldDescriptorProto.Types.Type.TYPE_DOUBLE => FieldType.Double, 
			FieldDescriptorProto.Types.Type.TYPE_FLOAT => FieldType.Float, 
			FieldDescriptorProto.Types.Type.TYPE_INT64 => FieldType.Int64, 
			FieldDescriptorProto.Types.Type.TYPE_UINT64 => FieldType.UInt64, 
			FieldDescriptorProto.Types.Type.TYPE_INT32 => FieldType.Int32, 
			FieldDescriptorProto.Types.Type.TYPE_FIXED64 => FieldType.Fixed64, 
			FieldDescriptorProto.Types.Type.TYPE_FIXED32 => FieldType.Fixed32, 
			FieldDescriptorProto.Types.Type.TYPE_BOOL => FieldType.Bool, 
			FieldDescriptorProto.Types.Type.TYPE_STRING => FieldType.String, 
			FieldDescriptorProto.Types.Type.TYPE_GROUP => FieldType.Group, 
			FieldDescriptorProto.Types.Type.TYPE_MESSAGE => FieldType.Message, 
			FieldDescriptorProto.Types.Type.TYPE_BYTES => FieldType.Bytes, 
			FieldDescriptorProto.Types.Type.TYPE_UINT32 => FieldType.UInt32, 
			FieldDescriptorProto.Types.Type.TYPE_ENUM => FieldType.Enum, 
			FieldDescriptorProto.Types.Type.TYPE_SFIXED32 => FieldType.SFixed32, 
			FieldDescriptorProto.Types.Type.TYPE_SFIXED64 => FieldType.SFixed64, 
			FieldDescriptorProto.Types.Type.TYPE_SINT32 => FieldType.SInt32, 
			FieldDescriptorProto.Types.Type.TYPE_SINT64 => FieldType.SInt64, 
			_ => throw new ArgumentException("Invalid type specified"), 
		};
	}

	private static object GetDefaultValueForMappedType(MappedType type)
	{
		return type switch
		{
			MappedType.Int32 => 0, 
			MappedType.Int64 => 0L, 
			MappedType.UInt32 => 0u, 
			MappedType.UInt64 => 0uL, 
			MappedType.Single => 0f, 
			MappedType.Double => 0.0, 
			MappedType.Boolean => false, 
			MappedType.String => "", 
			MappedType.ByteString => ByteString.Empty, 
			MappedType.Message => null, 
			MappedType.Enum => null, 
			_ => throw new ArgumentException("Invalid type specified"), 
		};
	}

	public int CompareTo(FieldDescriptor other)
	{
		if (other.containingType != containingType)
		{
			throw new ArgumentException("FieldDescriptors can only be compared to other FieldDescriptors for fields of the same message type.");
		}
		return FieldNumber - other.FieldNumber;
	}

	private static IDictionary<FieldType, MappedType> MapFieldTypes()
	{
		Dictionary<FieldType, MappedType> dictionary = new Dictionary<FieldType, MappedType>();
		FieldInfo[] fields = typeof(FieldType).GetFields(BindingFlags.Static | BindingFlags.Public);
		foreach (FieldInfo fieldInfo in fields)
		{
			FieldType key = (FieldType)fieldInfo.GetValue(null);
			FieldMappingAttribute fieldMappingAttribute = (FieldMappingAttribute)fieldInfo.GetCustomAttributes(typeof(FieldMappingAttribute), inherit: false)[0];
			dictionary[key] = fieldMappingAttribute.MappedType;
		}
		return Dictionaries.AsReadOnly(dictionary);
	}

	internal void CrossLink()
	{
		if (base.Proto.HasExtendee)
		{
			IDescriptor descriptor = base.File.DescriptorPool.LookupSymbol(base.Proto.Extendee, this);
			if (!(descriptor is MessageDescriptor))
			{
				throw new DescriptorValidationException(this, "\"" + base.Proto.Extendee + "\" is not a message type.");
			}
			containingType = (MessageDescriptor)descriptor;
			if (!containingType.IsExtensionNumber(FieldNumber))
			{
				throw new DescriptorValidationException(this, "\"" + containingType.FullName + "\" does not declare " + FieldNumber + " as an extension number.");
			}
		}
		if (base.Proto.HasTypeName)
		{
			IDescriptor descriptor2 = base.File.DescriptorPool.LookupSymbol(base.Proto.TypeName, this);
			if (!base.Proto.HasType)
			{
				if (descriptor2 is MessageDescriptor)
				{
					fieldType = FieldType.Message;
					mappedType = MappedType.Message;
				}
				else
				{
					if (!(descriptor2 is EnumDescriptor))
					{
						throw new DescriptorValidationException(this, "\"" + base.Proto.TypeName + "\" is not a type.");
					}
					fieldType = FieldType.Enum;
					mappedType = MappedType.Enum;
				}
			}
			if (MappedType == MappedType.Message)
			{
				if (!(descriptor2 is MessageDescriptor))
				{
					throw new DescriptorValidationException(this, "\"" + base.Proto.TypeName + "\" is not a message type.");
				}
				messageType = (MessageDescriptor)descriptor2;
				if (base.Proto.HasDefaultValue)
				{
					throw new DescriptorValidationException(this, "Messages can't have default values.");
				}
			}
			else
			{
				if (MappedType != MappedType.Enum)
				{
					throw new DescriptorValidationException(this, "Field with primitive type has type_name.");
				}
				if (!(descriptor2 is EnumDescriptor))
				{
					throw new DescriptorValidationException(this, "\"" + base.Proto.TypeName + "\" is not an enum type.");
				}
				enumType = (EnumDescriptor)descriptor2;
			}
		}
		else if (MappedType == MappedType.Message || MappedType == MappedType.Enum)
		{
			throw new DescriptorValidationException(this, "Field with message or enum type missing type_name.");
		}
		if (base.Proto.HasDefaultValue)
		{
			if (IsRepeated)
			{
				throw new DescriptorValidationException(this, "Repeated fields cannot have default values.");
			}
			try
			{
				switch (FieldType)
				{
				case FieldType.Int32:
				case FieldType.SFixed32:
				case FieldType.SInt32:
					defaultValue = TextFormat.ParseInt32(base.Proto.DefaultValue);
					break;
				case FieldType.Fixed32:
				case FieldType.UInt32:
					defaultValue = TextFormat.ParseUInt32(base.Proto.DefaultValue);
					break;
				case FieldType.Int64:
				case FieldType.SFixed64:
				case FieldType.SInt64:
					defaultValue = TextFormat.ParseInt64(base.Proto.DefaultValue);
					break;
				case FieldType.UInt64:
				case FieldType.Fixed64:
					defaultValue = TextFormat.ParseUInt64(base.Proto.DefaultValue);
					break;
				case FieldType.Float:
					defaultValue = TextFormat.ParseFloat(base.Proto.DefaultValue);
					break;
				case FieldType.Double:
					defaultValue = TextFormat.ParseDouble(base.Proto.DefaultValue);
					break;
				case FieldType.Bool:
					if (base.Proto.DefaultValue == "true")
					{
						defaultValue = true;
						break;
					}
					if (base.Proto.DefaultValue == "false")
					{
						defaultValue = false;
						break;
					}
					throw new FormatException("Boolean values must be \"true\" or \"false\"");
				case FieldType.String:
					defaultValue = base.Proto.DefaultValue;
					break;
				case FieldType.Bytes:
					try
					{
						defaultValue = TextFormat.UnescapeBytes(base.Proto.DefaultValue);
					}
					catch (FormatException ex)
					{
						throw new DescriptorValidationException(this, "Couldn't parse default value: " + ex.Message);
					}
					break;
				case FieldType.Enum:
					defaultValue = enumType.FindValueByName(base.Proto.DefaultValue);
					if (defaultValue == null)
					{
						throw new DescriptorValidationException(this, "Unknown enum default value: \"" + base.Proto.DefaultValue + "\"");
					}
					break;
				case FieldType.Group:
				case FieldType.Message:
					throw new DescriptorValidationException(this, "Message type had default value.");
				}
			}
			catch (FormatException cause)
			{
				DescriptorValidationException ex2 = new DescriptorValidationException(this, "Could not parse default value: \"" + base.Proto.DefaultValue + "\"", cause);
				throw ex2;
			}
		}
		else if (IsRepeated)
		{
			defaultValue = Lists<object>.Empty;
		}
		else
		{
			switch (MappedType)
			{
			case MappedType.Enum:
				defaultValue = enumType.Values[0];
				break;
			case MappedType.Message:
				defaultValue = null;
				break;
			default:
				defaultValue = GetDefaultValueForMappedType(MappedType);
				break;
			}
		}
		if (!IsExtension)
		{
			base.File.DescriptorPool.AddFieldByNumber(this);
		}
		if (containingType != null && containingType.Options.MessageSetWireFormat)
		{
			if (!IsExtension)
			{
				throw new DescriptorValidationException(this, "MessageSets cannot have fields, only extensions.");
			}
			if (!IsOptional || FieldType != FieldType.Message)
			{
				throw new DescriptorValidationException(this, "Extensions of MessageSets must be optional messages.");
			}
		}
	}
}
