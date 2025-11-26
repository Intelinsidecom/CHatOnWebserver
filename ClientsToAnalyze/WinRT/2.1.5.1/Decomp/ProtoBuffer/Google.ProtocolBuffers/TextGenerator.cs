using System;
using System.IO;
using System.Text;

namespace Google.ProtocolBuffers;

public sealed class TextGenerator
{
	private readonly string lineBreak;

	private readonly TextWriter writer;

	private bool atStartOfLine = true;

	private readonly StringBuilder indent = new StringBuilder();

	public TextGenerator(TextWriter writer, string lineBreak)
	{
		this.writer = writer;
		this.lineBreak = lineBreak;
	}

	public void Indent()
	{
		indent.Append("  ");
	}

	public void Outdent()
	{
		if (indent.Length == 0)
		{
			throw new InvalidOperationException("Too many calls to Outdent()");
		}
		indent.Length -= 2;
	}

	public void WriteLine(string text)
	{
		Print(text);
		Print("\n");
	}

	public void WriteLine(string format, params object[] args)
	{
		WriteLine(string.Format(format, args));
	}

	public void WriteLine()
	{
		WriteLine("");
	}

	public void Print(string text)
	{
		int num = 0;
		for (int i = 0; i < text.Length; i++)
		{
			if (text[i] == '\n')
			{
				Write(text.Substring(num, i - num));
				Write(lineBreak);
				num = i + 1;
				atStartOfLine = true;
			}
		}
		Write(text.Substring(num));
	}

	public void Write(string format, params object[] args)
	{
		Write(string.Format(format, args));
	}

	private void Write(string data)
	{
		if (data.Length != 0)
		{
			if (atStartOfLine)
			{
				atStartOfLine = false;
				writer.Write(indent);
			}
			writer.Write(data);
		}
	}
}
