using System;
using System.Collections;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Text;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers;

public static class TextFormat
{
	public static void Print(IMessage message, TextWriter output)
	{
		TextGenerator generator = new TextGenerator(output, "\n");
		Print(message, generator);
	}

	public static void Print(UnknownFieldSet fields, TextWriter output)
	{
		TextGenerator generator = new TextGenerator(output, "\n");
		PrintUnknownFields(fields, generator);
	}

	public static string PrintToString(IMessage message)
	{
		StringWriter stringWriter = new StringWriter();
		Print(message, stringWriter);
		return stringWriter.ToString();
	}

	public static string PrintToString(UnknownFieldSet fields)
	{
		StringWriter stringWriter = new StringWriter();
		Print(fields, stringWriter);
		return stringWriter.ToString();
	}

	private static void Print(IMessage message, TextGenerator generator)
	{
		foreach (KeyValuePair<FieldDescriptor, object> allField in message.AllFields)
		{
			PrintField(allField.Key, allField.Value, generator);
		}
		PrintUnknownFields(message.UnknownFields, generator);
	}

	internal static void PrintField(FieldDescriptor field, object value, TextGenerator generator)
	{
		if (field.IsRepeated)
		{
			foreach (object item in (IEnumerable)value)
			{
				PrintSingleField(field, item, generator);
			}
			return;
		}
		PrintSingleField(field, value, generator);
	}

	private static void PrintSingleField(FieldDescriptor field, object value, TextGenerator generator)
	{
		if (field.IsExtension)
		{
			generator.Print("[");
			if (field.ContainingType.Options.MessageSetWireFormat && field.FieldType == FieldType.Message && field.IsOptional && field.ExtensionScope == field.MessageType)
			{
				generator.Print(field.MessageType.FullName);
			}
			else
			{
				generator.Print(field.FullName);
			}
			generator.Print("]");
		}
		else if (field.FieldType == FieldType.Group)
		{
			generator.Print(field.MessageType.Name);
		}
		else
		{
			generator.Print(field.Name);
		}
		if (field.MappedType == MappedType.Message)
		{
			generator.Print(" {\n");
			generator.Indent();
		}
		else
		{
			generator.Print(": ");
		}
		PrintFieldValue(field, value, generator);
		if (field.MappedType == MappedType.Message)
		{
			generator.Outdent();
			generator.Print("}");
		}
		generator.Print("\n");
	}

	private static void PrintFieldValue(FieldDescriptor field, object value, TextGenerator generator)
	{
		switch (field.FieldType)
		{
		case FieldType.Double:
		case FieldType.Float:
		case FieldType.Int64:
		case FieldType.UInt64:
		case FieldType.Int32:
		case FieldType.Fixed64:
		case FieldType.Fixed32:
		case FieldType.UInt32:
		case FieldType.SFixed32:
		case FieldType.SFixed64:
		case FieldType.SInt32:
		case FieldType.SInt64:
			generator.Print(value.ToString());
			break;
		case FieldType.Bool:
			generator.Print(((bool)value) ? "true" : "false");
			break;
		case FieldType.String:
			generator.Print("\"");
			generator.Print(EscapeText((string)value));
			generator.Print("\"");
			break;
		case FieldType.Bytes:
			generator.Print("\"");
			generator.Print(EscapeBytes((ByteString)value));
			generator.Print("\"");
			break;
		case FieldType.Enum:
			if (value is IEnumLite && !(value is EnumValueDescriptor))
			{
				throw new NotSupportedException("Lite enumerations are not supported.");
			}
			generator.Print(((EnumValueDescriptor)value).Name);
			break;
		case FieldType.Group:
		case FieldType.Message:
			if (value is IMessageLite && !(value is IMessage))
			{
				throw new NotSupportedException("Lite messages are not supported.");
			}
			Print((IMessage)value, generator);
			break;
		}
	}

	private static void PrintUnknownFields(UnknownFieldSet unknownFields, TextGenerator generator)
	{
		foreach (KeyValuePair<int, UnknownField> item in unknownFields.FieldDictionary)
		{
			string text = item.Key + ": ";
			UnknownField value = item.Value;
			foreach (ulong varint in value.VarintList)
			{
				generator.Print(text);
				generator.Print(varint.ToString());
				generator.Print("\n");
			}
			foreach (uint @fixed in value.Fixed32List)
			{
				generator.Print(text);
				generator.Print($"0x{@fixed:x8}");
				generator.Print("\n");
			}
			foreach (ulong fixed2 in value.Fixed64List)
			{
				generator.Print(text);
				generator.Print($"0x{fixed2:x16}");
				generator.Print("\n");
			}
			foreach (ByteString lengthDelimited in value.LengthDelimitedList)
			{
				generator.Print(item.Key.ToString());
				generator.Print(": \"");
				generator.Print(EscapeBytes(lengthDelimited));
				generator.Print("\"\n");
			}
			foreach (UnknownFieldSet group in value.GroupList)
			{
				generator.Print(item.Key.ToString());
				generator.Print(" {\n");
				generator.Indent();
				PrintUnknownFields(group, generator);
				generator.Outdent();
				generator.Print("}\n");
			}
		}
	}

	internal static ulong ParseUInt64(string text)
	{
		return (ulong)ParseInteger(text, isSigned: false, isLong: true);
	}

	internal static long ParseInt64(string text)
	{
		return ParseInteger(text, isSigned: true, isLong: true);
	}

	internal static uint ParseUInt32(string text)
	{
		return (uint)ParseInteger(text, isSigned: false, isLong: false);
	}

	internal static int ParseInt32(string text)
	{
		return (int)ParseInteger(text, isSigned: true, isLong: false);
	}

	internal static float ParseFloat(string text)
	{
		switch (text)
		{
		case "-inf":
		case "-infinity":
		case "-inff":
		case "-infinityf":
			return float.NegativeInfinity;
		case "inf":
		case "infinity":
		case "inff":
		case "infinityf":
			return float.PositiveInfinity;
		case "nan":
		case "nanf":
			return float.NaN;
		default:
			return float.Parse(text, CultureInfo.InvariantCulture);
		}
	}

	internal static double ParseDouble(string text)
	{
		switch (text)
		{
		case "-inf":
		case "-infinity":
			return double.NegativeInfinity;
		case "inf":
		case "infinity":
			return double.PositiveInfinity;
		case "nan":
			return double.NaN;
		default:
			return double.Parse(text, CultureInfo.InvariantCulture);
		}
	}

	private static long ParseInteger(string text, bool isSigned, bool isLong)
	{
		string text2 = text;
		bool flag = false;
		if (text.StartsWith("-"))
		{
			if (!isSigned)
			{
				throw new FormatException("Number must be positive: " + text2);
			}
			flag = true;
			text = text.Substring(1);
		}
		int num = 10;
		if (text.StartsWith("0x"))
		{
			num = 16;
			text = text.Substring(2);
		}
		else if (text.StartsWith("0"))
		{
			num = 8;
		}
		ulong num2;
		try
		{
			num2 = ((num == 10) ? ulong.Parse(text) : Convert.ToUInt64(text, num));
		}
		catch (OverflowException)
		{
			string text3 = string.Format("{0}-bit {1}signed integer", new object[2]
			{
				isLong ? 64 : 32,
				isSigned ? "" : "un"
			});
			throw new FormatException("Number out of range for " + text3 + ": " + text2);
		}
		if (flag)
		{
			ulong num3 = (isLong ? 9223372036854775808uL : 2147483648u);
			if (num2 > num3)
			{
				string text4 = $"{(isLong ? 64 : 32)}-bit signed integer";
				throw new FormatException("Number out of range for " + text4 + ": " + text2);
			}
			return (long)(0L - num2);
		}
		ulong num4 = ((!isSigned) ? (isLong ? ulong.MaxValue : 4294967295uL) : (isLong ? 9223372036854775807uL : int.MaxValue));
		if (num2 > num4)
		{
			string text5 = string.Format("{0}-bit {1}signed integer", new object[2]
			{
				isLong ? 64 : 32,
				isSigned ? "" : "un"
			});
			throw new FormatException("Number out of range for " + text5 + ": " + text2);
		}
		return (long)num2;
	}

	private static bool IsOctal(char c)
	{
		if ('0' <= c)
		{
			return c <= '7';
		}
		return false;
	}

	private static bool IsHex(char c)
	{
		if (('0' > c || c > '9') && ('a' > c || c > 'f'))
		{
			if ('A' <= c)
			{
				return c <= 'F';
			}
			return false;
		}
		return true;
	}

	private static int ParseDigit(char c)
	{
		if ('0' <= c && c <= '9')
		{
			return c - 48;
		}
		if ('a' <= c && c <= 'z')
		{
			return c - 97 + 10;
		}
		return c - 65 + 10;
	}

	internal static string UnescapeText(string input)
	{
		return UnescapeBytes(input).ToStringUtf8();
	}

	internal static string EscapeText(string input)
	{
		return EscapeBytes(ByteString.CopyFromUtf8(input));
	}

	internal static string EscapeBytes(ByteString input)
	{
		StringBuilder stringBuilder = new StringBuilder(input.Length);
		foreach (byte item in input)
		{
			switch (item)
			{
			case 7:
				stringBuilder.Append("\\a");
				continue;
			case 8:
				stringBuilder.Append("\\b");
				continue;
			case 12:
				stringBuilder.Append("\\f");
				continue;
			case 10:
				stringBuilder.Append("\\n");
				continue;
			case 13:
				stringBuilder.Append("\\r");
				continue;
			case 9:
				stringBuilder.Append("\\t");
				continue;
			case 11:
				stringBuilder.Append("\\v");
				continue;
			case 92:
				stringBuilder.Append("\\\\");
				continue;
			case 39:
				stringBuilder.Append("\\'");
				continue;
			case 34:
				stringBuilder.Append("\\\"");
				continue;
			}
			if (item >= 32 && item < 128)
			{
				stringBuilder.Append((char)item);
				continue;
			}
			stringBuilder.Append('\\');
			stringBuilder.Append((char)(48 + ((item >> 6) & 3)));
			stringBuilder.Append((char)(48 + ((item >> 3) & 7)));
			stringBuilder.Append((char)(48 + (item & 7)));
		}
		return stringBuilder.ToString();
	}

	internal static ByteString UnescapeBytes(string input)
	{
		byte[] array = new byte[input.Length];
		int count = 0;
		for (int i = 0; i < input.Length; i++)
		{
			char c = input[i];
			switch (c)
			{
			default:
				throw new FormatException("Escaped string must only contain ASCII");
			case ' ':
			case '!':
			case '"':
			case '#':
			case '$':
			case '%':
			case '&':
			case '\'':
			case '(':
			case ')':
			case '*':
			case '+':
			case ',':
			case '-':
			case '.':
			case '/':
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
			case ':':
			case ';':
			case '<':
			case '=':
			case '>':
			case '?':
			case '@':
			case 'A':
			case 'B':
			case 'C':
			case 'D':
			case 'E':
			case 'F':
			case 'G':
			case 'H':
			case 'I':
			case 'J':
			case 'K':
			case 'L':
			case 'M':
			case 'N':
			case 'O':
			case 'P':
			case 'Q':
			case 'R':
			case 'S':
			case 'T':
			case 'U':
			case 'V':
			case 'W':
			case 'X':
			case 'Y':
			case 'Z':
			case '[':
			case ']':
			case '^':
			case '_':
			case '`':
			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z':
			case '{':
			case '|':
			case '}':
			case '~':
			case '\u007f':
				array[count++] = (byte)c;
				break;
			case '\\':
				if (i + 1 >= input.Length)
				{
					throw new FormatException("Invalid escape sequence: '\\' at end of string.");
				}
				i++;
				c = input[i];
				if (c >= '0' && c <= '7')
				{
					int num = ParseDigit(c);
					if (i + 1 < input.Length && IsOctal(input[i + 1]))
					{
						i++;
						num = num * 8 + ParseDigit(input[i]);
					}
					if (i + 1 < input.Length && IsOctal(input[i + 1]))
					{
						i++;
						num = num * 8 + ParseDigit(input[i]);
					}
					array[count++] = (byte)num;
					break;
				}
				switch (c)
				{
				case 'a':
					array[count++] = 7;
					break;
				case 'b':
					array[count++] = 8;
					break;
				case 'f':
					array[count++] = 12;
					break;
				case 'n':
					array[count++] = 10;
					break;
				case 'r':
					array[count++] = 13;
					break;
				case 't':
					array[count++] = 9;
					break;
				case 'v':
					array[count++] = 11;
					break;
				case '\\':
					array[count++] = 92;
					break;
				case '\'':
					array[count++] = 39;
					break;
				case '"':
					array[count++] = 34;
					break;
				case 'x':
					if (i + 1 < input.Length && IsHex(input[i + 1]))
					{
						i++;
						int num2 = ParseDigit(input[i]);
						if (i + 1 < input.Length && IsHex(input[i + 1]))
						{
							i++;
							num2 = num2 * 16 + ParseDigit(input[i]);
						}
						array[count++] = (byte)num2;
						break;
					}
					throw new FormatException("Invalid escape sequence: '\\x' with no digits");
				default:
					throw new FormatException("Invalid escape sequence: '\\" + c + "'");
				}
				break;
			}
		}
		return ByteString.CopyFrom(array, 0, count);
	}

	public static void Merge(string text, IBuilder builder)
	{
		Merge(text, ExtensionRegistry.Empty, builder);
	}

	public static void Merge(TextReader reader, IBuilder builder)
	{
		Merge(reader, ExtensionRegistry.Empty, builder);
	}

	public static void Merge(TextReader reader, ExtensionRegistry registry, IBuilder builder)
	{
		Merge(reader.ReadToEnd(), registry, builder);
	}

	public static void Merge(string text, ExtensionRegistry registry, IBuilder builder)
	{
		TextTokenizer textTokenizer = new TextTokenizer(text);
		while (!textTokenizer.AtEnd)
		{
			MergeField(textTokenizer, registry, builder);
		}
	}

	private static void MergeField(TextTokenizer tokenizer, ExtensionRegistry extensionRegistry, IBuilder builder)
	{
		MessageDescriptor descriptorForType = builder.DescriptorForType;
		ExtensionInfo extensionInfo = null;
		FieldDescriptor fieldDescriptor;
		if (tokenizer.TryConsume("["))
		{
			StringBuilder stringBuilder = new StringBuilder(tokenizer.ConsumeIdentifier());
			while (tokenizer.TryConsume("."))
			{
				stringBuilder.Append(".");
				stringBuilder.Append(tokenizer.ConsumeIdentifier());
			}
			extensionInfo = extensionRegistry[stringBuilder.ToString()];
			if (extensionInfo == null)
			{
				throw tokenizer.CreateFormatExceptionPreviousToken(string.Concat("Extension \"", stringBuilder, "\" not found in the ExtensionRegistry."));
			}
			if (extensionInfo.Descriptor.ContainingType != descriptorForType)
			{
				throw tokenizer.CreateFormatExceptionPreviousToken(string.Concat("Extension \"", stringBuilder, "\" does not extend message type \"", descriptorForType.FullName, "\"."));
			}
			tokenizer.Consume("]");
			fieldDescriptor = extensionInfo.Descriptor;
		}
		else
		{
			string text = tokenizer.ConsumeIdentifier();
			fieldDescriptor = descriptorForType.FindDescriptor<FieldDescriptor>(text);
			if (fieldDescriptor == null)
			{
				string name = text.ToLower();
				fieldDescriptor = descriptorForType.FindDescriptor<FieldDescriptor>(name);
				if (fieldDescriptor != null && fieldDescriptor.FieldType != FieldType.Group)
				{
					fieldDescriptor = null;
				}
			}
			if (fieldDescriptor != null && fieldDescriptor.FieldType == FieldType.Group && fieldDescriptor.MessageType.Name != text)
			{
				fieldDescriptor = null;
			}
			if (fieldDescriptor == null)
			{
				throw tokenizer.CreateFormatExceptionPreviousToken("Message type \"" + descriptorForType.FullName + "\" has no field named \"" + text + "\".");
			}
		}
		object obj = null;
		if (fieldDescriptor.MappedType == MappedType.Message)
		{
			tokenizer.TryConsume(":");
			string text2;
			if (tokenizer.TryConsume("<"))
			{
				text2 = ">";
			}
			else
			{
				tokenizer.Consume("{");
				text2 = "}";
			}
			IBuilder builder2;
			if (extensionInfo == null)
			{
				builder2 = builder.CreateBuilderForField(fieldDescriptor);
			}
			else
			{
				builder2 = extensionInfo.DefaultInstance.WeakCreateBuilderForType() as IBuilder;
				if (builder2 == null)
				{
					throw new NotSupportedException("Lite messages are not supported.");
				}
			}
			while (!tokenizer.TryConsume(text2))
			{
				if (tokenizer.AtEnd)
				{
					throw tokenizer.CreateFormatException("Expected \"" + text2 + "\".");
				}
				MergeField(tokenizer, extensionRegistry, builder2);
			}
			obj = builder2.WeakBuild();
		}
		else
		{
			tokenizer.Consume(":");
			switch (fieldDescriptor.FieldType)
			{
			case FieldType.Int32:
			case FieldType.SFixed32:
			case FieldType.SInt32:
				obj = tokenizer.ConsumeInt32();
				break;
			case FieldType.Int64:
			case FieldType.SFixed64:
			case FieldType.SInt64:
				obj = tokenizer.ConsumeInt64();
				break;
			case FieldType.Fixed32:
			case FieldType.UInt32:
				obj = tokenizer.ConsumeUInt32();
				break;
			case FieldType.UInt64:
			case FieldType.Fixed64:
				obj = tokenizer.ConsumeUInt64();
				break;
			case FieldType.Float:
				obj = tokenizer.ConsumeFloat();
				break;
			case FieldType.Double:
				obj = tokenizer.ConsumeDouble();
				break;
			case FieldType.Bool:
				obj = tokenizer.ConsumeBoolean();
				break;
			case FieldType.String:
				obj = tokenizer.ConsumeString();
				break;
			case FieldType.Bytes:
				obj = tokenizer.ConsumeByteString();
				break;
			case FieldType.Enum:
			{
				EnumDescriptor enumType = fieldDescriptor.EnumType;
				if (tokenizer.LookingAtInteger())
				{
					int num = tokenizer.ConsumeInt32();
					obj = enumType.FindValueByNumber(num);
					if (obj == null)
					{
						throw tokenizer.CreateFormatExceptionPreviousToken("Enum type \"" + enumType.FullName + "\" has no value with number " + num + ".");
					}
				}
				else
				{
					string text3 = tokenizer.ConsumeIdentifier();
					obj = enumType.FindValueByName(text3);
					if (obj == null)
					{
						throw tokenizer.CreateFormatExceptionPreviousToken("Enum type \"" + enumType.FullName + "\" has no value named \"" + text3 + "\".");
					}
				}
				break;
			}
			case FieldType.Group:
			case FieldType.Message:
				throw new InvalidOperationException("Can't get here.");
			}
		}
		if (fieldDescriptor.IsRepeated)
		{
			builder.WeakAddRepeatedField(fieldDescriptor, obj);
		}
		else
		{
			builder.SetField(fieldDescriptor, obj);
		}
	}
}
