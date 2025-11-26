using System;
using System.Globalization;
using System.Text.RegularExpressions;

namespace Google.ProtocolBuffers;

internal sealed class TextTokenizer
{
	private readonly string text;

	private string currentToken;

	private int matchPos;

	private int pos;

	private int line;

	private int column;

	private int previousLine;

	private int previousColumn;

	internal static readonly Regex WhitespaceAndCommentPattern = new Regex("\\G(?>(\\s|(#.*$))+)", RegexOptions.Multiline);

	private static readonly Regex TokenPattern = new Regex("\\G[a-zA-Z_](?>[0-9a-zA-Z_+-]*)|\\G[0-9+-](?>[0-9a-zA-Z_.+-]*)|\\G\"(?>([^\"\\\n\\\\]|\\\\.)*)(\"|\\\\?$)|\\G'(?>([^\"\\\n\\\\]|\\\\.)*)('|\\\\?$)", RegexOptions.Multiline);

	private static readonly Regex DoubleInfinity = new Regex("^-?inf(inity)?$", RegexOptions.IgnoreCase);

	private static readonly Regex FloatInfinity = new Regex("^-?inf(inity)?f?$", RegexOptions.IgnoreCase);

	private static readonly Regex FloatNan = new Regex("^nanf?$", RegexOptions.IgnoreCase);

	public bool AtEnd => currentToken.Length == 0;

	public TextTokenizer(string text)
	{
		this.text = text;
		SkipWhitespace();
		NextToken();
	}

	public void NextToken()
	{
		previousLine = line;
		for (previousColumn = column; pos < matchPos; pos++)
		{
			if (text[pos] == '\n')
			{
				line++;
				column = 0;
			}
			else
			{
				column++;
			}
		}
		if (matchPos == text.Length)
		{
			currentToken = "";
			return;
		}
		Match match = TokenPattern.Match(text, matchPos);
		if (match.Success)
		{
			currentToken = match.Value;
			matchPos += match.Length;
		}
		else
		{
			currentToken = text[matchPos].ToString();
			matchPos++;
		}
		SkipWhitespace();
	}

	private void SkipWhitespace()
	{
		Match match = WhitespaceAndCommentPattern.Match(text, matchPos);
		if (match.Success)
		{
			matchPos += match.Length;
		}
	}

	public bool TryConsume(string token)
	{
		if (currentToken == token)
		{
			NextToken();
			return true;
		}
		return false;
	}

	public void Consume(string token)
	{
		if (!TryConsume(token))
		{
			throw CreateFormatException("Expected \"" + token + "\".");
		}
	}

	public bool LookingAtInteger()
	{
		if (currentToken.Length == 0)
		{
			return false;
		}
		char c = currentToken[0];
		if (('0' > c || c > '9') && c != '-')
		{
			return c == '+';
		}
		return true;
	}

	public string ConsumeIdentifier()
	{
		string text = currentToken;
		foreach (char c in text)
		{
			if (('a' > c || c > 'z') && ('A' > c || c > 'Z') && ('0' > c || c > '9') && c != '_' && c != '.')
			{
				throw CreateFormatException("Expected identifier.");
			}
		}
		string result = currentToken;
		NextToken();
		return result;
	}

	public int ConsumeInt32()
	{
		try
		{
			int result = TextFormat.ParseInt32(currentToken);
			NextToken();
			return result;
		}
		catch (FormatException e)
		{
			throw CreateIntegerParseException(e);
		}
	}

	public uint ConsumeUInt32()
	{
		try
		{
			uint result = TextFormat.ParseUInt32(currentToken);
			NextToken();
			return result;
		}
		catch (FormatException e)
		{
			throw CreateIntegerParseException(e);
		}
	}

	public long ConsumeInt64()
	{
		try
		{
			long result = TextFormat.ParseInt64(currentToken);
			NextToken();
			return result;
		}
		catch (FormatException e)
		{
			throw CreateIntegerParseException(e);
		}
	}

	public ulong ConsumeUInt64()
	{
		try
		{
			ulong result = TextFormat.ParseUInt64(currentToken);
			NextToken();
			return result;
		}
		catch (FormatException e)
		{
			throw CreateIntegerParseException(e);
		}
	}

	public double ConsumeDouble()
	{
		if (DoubleInfinity.IsMatch(currentToken))
		{
			bool flag = currentToken.StartsWith("-");
			NextToken();
			if (!flag)
			{
				return double.PositiveInfinity;
			}
			return double.NegativeInfinity;
		}
		if (currentToken.Equals("nan", StringComparison.InvariantCultureIgnoreCase))
		{
			NextToken();
			return double.NaN;
		}
		try
		{
			double result = double.Parse(currentToken, CultureInfo.InvariantCulture);
			NextToken();
			return result;
		}
		catch (FormatException e)
		{
			throw CreateFloatParseException(e);
		}
		catch (OverflowException e2)
		{
			throw CreateFloatParseException(e2);
		}
	}

	public float ConsumeFloat()
	{
		if (FloatInfinity.IsMatch(currentToken))
		{
			bool flag = currentToken.StartsWith("-");
			NextToken();
			if (!flag)
			{
				return float.PositiveInfinity;
			}
			return float.NegativeInfinity;
		}
		if (FloatNan.IsMatch(currentToken))
		{
			NextToken();
			return float.NaN;
		}
		if (currentToken.EndsWith("f"))
		{
			currentToken = currentToken.TrimEnd('f');
		}
		try
		{
			float result = float.Parse(currentToken, CultureInfo.InvariantCulture);
			NextToken();
			return result;
		}
		catch (FormatException e)
		{
			throw CreateFloatParseException(e);
		}
		catch (OverflowException e2)
		{
			throw CreateFloatParseException(e2);
		}
	}

	public bool ConsumeBoolean()
	{
		if (currentToken == "true")
		{
			NextToken();
			return true;
		}
		if (currentToken == "false")
		{
			NextToken();
			return false;
		}
		throw CreateFormatException("Expected \"true\" or \"false\".");
	}

	public string ConsumeString()
	{
		return ConsumeByteString().ToStringUtf8();
	}

	public ByteString ConsumeByteString()
	{
		char c = ((currentToken.Length > 0) ? currentToken[0] : '\0');
		if (c != '"' && c != '\'')
		{
			throw CreateFormatException("Expected string.");
		}
		if (currentToken.Length < 2 || currentToken[currentToken.Length - 1] != c)
		{
			throw CreateFormatException("String missing ending quote.");
		}
		try
		{
			string input = currentToken.Substring(1, currentToken.Length - 2);
			ByteString result = TextFormat.UnescapeBytes(input);
			NextToken();
			return result;
		}
		catch (FormatException ex)
		{
			throw CreateFormatException(ex.Message);
		}
	}

	public FormatException CreateFormatException(string description)
	{
		return new FormatException(line + 1 + ":" + (column + 1) + ": " + description);
	}

	public FormatException CreateFormatExceptionPreviousToken(string description)
	{
		return new FormatException(previousLine + 1 + ":" + (previousColumn + 1) + ": " + description);
	}

	private FormatException CreateIntegerParseException(FormatException e)
	{
		return CreateFormatException("Couldn't parse integer: " + e.Message);
	}

	private FormatException CreateFloatParseException(Exception e)
	{
		return CreateFormatException("Couldn't parse number: " + e.Message);
	}
}
