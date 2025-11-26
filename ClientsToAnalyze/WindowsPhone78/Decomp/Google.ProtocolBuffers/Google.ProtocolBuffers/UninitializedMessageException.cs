using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public sealed class UninitializedMessageException : Exception
{
	private readonly IList<string> missingFields;

	public IList<string> MissingFields => missingFields;

	public UninitializedMessageException(IMessage message)
		: this(FindMissingFields(message))
	{
	}

	private UninitializedMessageException(IList<string> missingFields)
		: base(BuildDescription(missingFields))
	{
		this.missingFields = Lists.AsReadOnly(missingFields);
	}

	public InvalidProtocolBufferException AsInvalidProtocolBufferException()
	{
		return new InvalidProtocolBufferException(Message);
	}

	private static string BuildDescription(IEnumerable<string> missingFields)
	{
		StringBuilder stringBuilder = new StringBuilder("Message missing required fields: ");
		bool flag = true;
		foreach (string missingField in missingFields)
		{
			if (flag)
			{
				flag = false;
			}
			else
			{
				stringBuilder.Append(", ");
			}
			stringBuilder.Append(missingField);
		}
		return stringBuilder.ToString();
	}

	private static IList<string> FindMissingFields(IMessage message)
	{
		List<string> list = new List<string>();
		FindMissingFields(message, "", list);
		return list;
	}

	private static void FindMissingFields(IMessage message, string prefix, List<string> results)
	{
		foreach (FieldDescriptor field in message.DescriptorForType.Fields)
		{
			if (field.IsRequired && !message.HasField(field))
			{
				results.Add(prefix + field.Name);
			}
		}
		foreach (KeyValuePair<FieldDescriptor, object> allField in message.AllFields)
		{
			FieldDescriptor key = allField.Key;
			object value = allField.Value;
			if (key.MappedType != MappedType.Message)
			{
				continue;
			}
			if (key.IsRepeated)
			{
				int num = 0;
				foreach (object item in (IEnumerable)value)
				{
					FindMissingFields((IMessage)item, SubMessagePrefix(prefix, key, num++), results);
				}
			}
			else if (message.HasField(key))
			{
				FindMissingFields((IMessage)value, SubMessagePrefix(prefix, key, -1), results);
			}
		}
	}

	private static string SubMessagePrefix(string prefix, FieldDescriptor field, int index)
	{
		StringBuilder stringBuilder = new StringBuilder(prefix);
		if (field.IsExtension)
		{
			stringBuilder.Append('(').Append(field.FullName).Append(')');
		}
		else
		{
			stringBuilder.Append(field.Name);
		}
		if (index != -1)
		{
			stringBuilder.Append('[').Append(index).Append(']');
		}
		stringBuilder.Append('.');
		return stringBuilder.ToString();
	}
}
