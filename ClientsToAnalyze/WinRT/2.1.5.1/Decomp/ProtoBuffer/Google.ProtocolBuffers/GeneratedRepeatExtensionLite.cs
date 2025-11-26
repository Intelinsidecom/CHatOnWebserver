using System.Collections;
using System.Collections.Generic;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public class GeneratedRepeatExtensionLite<TContainingType, TExtensionType> : GeneratedExtensionLite<TContainingType, IList<TExtensionType>> where TContainingType : IMessageLite
{
	public GeneratedRepeatExtensionLite(string fullName, TContainingType containingTypeDefaultInstance, IMessageLite messageDefaultInstance, IEnumLiteMap enumTypeMap, int number, FieldType type, bool isPacked)
		: base(fullName, containingTypeDefaultInstance, (IList<TExtensionType>)new List<TExtensionType>(), messageDefaultInstance, enumTypeMap, number, type, isPacked)
	{
	}

	public override object ToReflectionType(object value)
	{
		IList<object> list = new List<object>();
		foreach (object item in (IEnumerable)value)
		{
			list.Add(SingularToReflectionType(item));
		}
		return list;
	}

	public override object FromReflectionType(object value)
	{
		List<TExtensionType> list = new List<TExtensionType>();
		foreach (object item in (IEnumerable)value)
		{
			list.Add((TExtensionType)SingularFromReflectionType(item));
		}
		return list;
	}
}
