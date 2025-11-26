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
		if (type.IsAbstract || type.IsGenericTypeDefinition)
		{
			throw new ArgumentException("Unable to get a default message for an abstract or generic type (" + type.FullName + ")");
		}
		if (!typeof(IMessage).IsAssignableFrom(type))
		{
			throw new ArgumentException("Unable to get a default message for non-message type (" + type.FullName + ")");
		}
		PropertyInfo property = type.GetProperty("DefaultInstance", BindingFlags.Static | BindingFlags.Public | BindingFlags.NonPublic);
		if ((object)property == null)
		{
			throw new ArgumentException(type.FullName + " doesn't have a static DefaultInstance property");
		}
		if ((object)property.PropertyType != type)
		{
			throw new ArgumentException(type.FullName + ".DefaultInstance property is of the wrong type");
		}
		return (IMessage)property.GetValue(null, null);
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
