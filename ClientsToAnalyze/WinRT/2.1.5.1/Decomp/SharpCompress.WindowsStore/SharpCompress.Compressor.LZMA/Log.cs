using System;
using System.Collections.Generic;

namespace SharpCompress.Compressor.LZMA;

internal static class Log
{
	private static Stack<string> _indent;

	private static bool _needsIndent;

	static Log()
	{
		_indent = new Stack<string>();
		_needsIndent = true;
		_indent.Push("");
	}

	public static void PushIndent(string indent = "  ")
	{
		_indent.Push(_indent.Peek() + indent);
	}

	public static void PopIndent()
	{
		if (_indent.Count == 1)
		{
			throw new InvalidOperationException();
		}
		_indent.Pop();
	}

	private static void EnsureIndent()
	{
		if (_needsIndent)
		{
			_needsIndent = false;
		}
	}

	public static void Write(object value)
	{
		EnsureIndent();
	}

	public static void Write(string text)
	{
		EnsureIndent();
	}

	public static void Write(string format, params object[] args)
	{
		EnsureIndent();
	}

	public static void WriteLine()
	{
		_needsIndent = true;
	}

	public static void WriteLine(object value)
	{
		EnsureIndent();
		_needsIndent = true;
	}

	public static void WriteLine(string text)
	{
		EnsureIndent();
		_needsIndent = true;
	}

	public static void WriteLine(string format, params object[] args)
	{
		EnsureIndent();
		_needsIndent = true;
	}
}
