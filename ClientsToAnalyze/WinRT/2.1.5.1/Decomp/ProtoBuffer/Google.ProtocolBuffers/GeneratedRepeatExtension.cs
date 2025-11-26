using System;
using System.Collections;
using System.Collections.Generic;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public sealed class GeneratedRepeatExtension<TExtensionElement> : GeneratedExtensionBase<IList<TExtensionElement>>
{
	private GeneratedRepeatExtension(FieldDescriptor field)
		: base(field, typeof(TExtensionElement))
	{
	}

	public static GeneratedExtensionBase<IList<TExtensionElement>> CreateInstance(FieldDescriptor descriptor)
	{
		if (!descriptor.IsRepeated)
		{
			throw new ArgumentException("Must call GeneratedRepeatExtension.CreateInstance() for repeated types.");
		}
		return new GeneratedRepeatExtension<TExtensionElement>(descriptor);
	}

	public override object FromReflectionType(object value)
	{
		if (base.Descriptor.MappedType == MappedType.Message || base.Descriptor.MappedType == MappedType.Enum)
		{
			List<TExtensionElement> list = new List<TExtensionElement>();
			{
				foreach (object item in (IEnumerable)value)
				{
					list.Add((TExtensionElement)SingularFromReflectionType(item));
				}
				return list;
			}
		}
		return value;
	}
}
