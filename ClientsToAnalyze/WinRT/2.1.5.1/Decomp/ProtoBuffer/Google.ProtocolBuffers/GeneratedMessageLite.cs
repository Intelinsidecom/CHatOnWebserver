using System.Collections.Generic;
using System.IO;
using System.Text;

namespace Google.ProtocolBuffers;

public abstract class GeneratedMessageLite<TMessage, TBuilder> : AbstractMessageLite<TMessage, TBuilder> where TMessage : GeneratedMessageLite<TMessage, TBuilder> where TBuilder : GeneratedBuilderLite<TMessage, TBuilder>
{
	protected abstract TMessage ThisMessage { get; }

	public sealed override string ToString()
	{
		using StringWriter stringWriter = new StringWriter();
		PrintTo(stringWriter);
		return stringWriter.ToString();
	}

	protected static void PrintField<T>(string name, IList<T> value, TextWriter writer)
	{
		foreach (T item in value)
		{
			PrintField(name, hasValue: true, item, writer);
		}
	}

	protected static void PrintField(string name, bool hasValue, object value, TextWriter writer)
	{
		if (!hasValue)
		{
			return;
		}
		if (value is IMessageLite)
		{
			writer.WriteLine("{0} {{", new object[1] { name });
			((IMessageLite)value).PrintTo(writer);
			writer.WriteLine("}");
		}
		else if (value is ByteString || value is string)
		{
			writer.Write("{0}: \"", new object[1] { name });
			if (value is string)
			{
				EscapeBytes(Encoding.UTF8.GetBytes((string)value), writer);
			}
			else
			{
				EscapeBytes((ByteString)value, writer);
			}
			writer.WriteLine("\"");
		}
		else if (value is bool)
		{
			writer.WriteLine("{0}: {1}", new object[2]
			{
				name,
				((bool)value) ? "true" : "false"
			});
		}
		else if (value is IEnumLite)
		{
			writer.WriteLine("{0}: {1}", new object[2]
			{
				name,
				((IEnumLite)value).Name
			});
		}
		else
		{
			writer.WriteLine("{0}: {1}", new object[2]
			{
				name,
				value.ToString()
			});
		}
	}

	private static void EscapeBytes(IEnumerable<byte> input, TextWriter writer)
	{
		foreach (byte item in input)
		{
			switch (item)
			{
			case 7:
				writer.Write("\\a");
				continue;
			case 8:
				writer.Write("\\b");
				continue;
			case 12:
				writer.Write("\\f");
				continue;
			case 10:
				writer.Write("\\n");
				continue;
			case 13:
				writer.Write("\\r");
				continue;
			case 9:
				writer.Write("\\t");
				continue;
			case 11:
				writer.Write("\\v");
				continue;
			case 92:
				writer.Write("\\\\");
				continue;
			case 39:
				writer.Write("\\'");
				continue;
			case 34:
				writer.Write("\\\"");
				continue;
			}
			if (item >= 32 && item < 128)
			{
				writer.Write((char)item);
				continue;
			}
			writer.Write('\\');
			writer.Write((char)(48 + ((item >> 6) & 3)));
			writer.Write((char)(48 + ((item >> 3) & 7)));
			writer.Write((char)(48 + (item & 7)));
		}
	}
}
