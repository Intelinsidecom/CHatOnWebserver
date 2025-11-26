using System;
using System.Collections;
using System.Collections.Generic;
using System.Reflection;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public abstract class GeneratedExtensionBase<TExtension>
{
	private readonly FieldDescriptor descriptor;

	private readonly IMessage messageDefaultInstance;

	public FieldDescriptor Descriptor => descriptor;

	public IMessage MessageDefaultInstance => messageDefaultInstance;

	protected GeneratedExtensionBase(FieldDescriptor descriptor, Type singularExtensionType)
	{
		if (!descriptor.IsExtension)
		{
			throw new ArgumentException("GeneratedExtension given a regular (non-extension) field.");
		}
		this.descriptor = descriptor;
		if (descriptor.MappedType == MappedType.Message)
		{
			PropertyInfo property = singularExtensionType.GetProperty("DefaultInstance", BindingFlags.Static | BindingFlags.Public);
			if ((object)property == null)
			{
				throw new ArgumentException("No public static DefaultInstance property for type " + typeof(TExtension).Name);
			}
			messageDefaultInstance = (IMessage)property.GetValue(null, null);
		}
	}

	public object SingularFromReflectionType(object value)
	{
		switch (Descriptor.MappedType)
		{
		case MappedType.Message:
			if (value is TExtension)
			{
				return value;
			}
			return MessageDefaultInstance.WeakCreateBuilderForType().WeakMergeFrom((IMessage)value).WeakBuild();
		case MappedType.Enum:
		{
			EnumValueDescriptor enumValueDescriptor = (EnumValueDescriptor)value;
			return enumValueDescriptor.Number;
		}
		default:
			return value;
		}
	}

	public object ToReflectionType(object value)
	{
		if (descriptor.IsRepeated)
		{
			if (descriptor.MappedType == MappedType.Enum)
			{
				IList<object> list = new List<object>();
				{
					foreach (object item in (IEnumerable)value)
					{
						list.Add(SingularToReflectionType(item));
					}
					return list;
				}
			}
			return value;
		}
		return SingularToReflectionType(value);
	}

	internal object SingularToReflectionType(object value)
	{
		if (descriptor.MappedType != MappedType.Enum)
		{
			return value;
		}
		return descriptor.EnumType.FindValueByNumber((int)value);
	}

	public abstract object FromReflectionType(object value);
}
