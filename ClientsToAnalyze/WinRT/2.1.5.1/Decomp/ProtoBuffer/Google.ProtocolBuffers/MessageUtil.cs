using System;
using System.Reflection;

namespace Google.ProtocolBuffers;

public static class MessageUtil
{
	public static IMessage GetDefaultMessage(Type type)
	{
		if ((object)type == null)
		{
			throw new ArgumentNullException("type", "No type specified.");
		}
		if (type.GetTypeInfo().IsAbstract || type.GetTypeInfo().IsGenericTypeDefinition)
		{
			throw new ArgumentException("Unable to get a default message for an abstract or generic type (" + type.FullName + ")");
		}
		PropertyInfo declaredProperty = type.GetTypeInfo().GetDeclaredProperty("DefaultInstance");
		if ((object)declaredProperty == null)
		{
			throw new ArgumentException(type.FullName + " doesn't have a static DefaultInstance property");
		}
		if ((object)declaredProperty.PropertyType != type)
		{
			throw new ArgumentException(type.FullName + ".DefaultInstance property is of the wrong type");
		}
		return (IMessage)declaredProperty.GetValue(null, null);
	}

	public static IMessage GetDefaultMessage(string typeName)
	{
		if (typeName == null)
		{
			throw new ArgumentNullException("typeName", "No type name specified.");
		}
		Type type = Type.GetType(typeName);
		if ((object)type == null)
		{
			throw new ArgumentException("Unable to load type " + typeName);
		}
		return GetDefaultMessage(type);
	}
}
