using System;
using System.Collections.Generic;

namespace Google.ProtocolBuffers;

public static class ThrowHelper
{
	public static void ThrowIfNull(object value, string name)
	{
		if (value == null)
		{
			throw new ArgumentNullException(name);
		}
	}

	public static void ThrowIfNull(object value)
	{
		if (value == null)
		{
			throw new ArgumentNullException();
		}
	}

	public static void ThrowIfAnyNull<T>(IEnumerable<T> sequence)
	{
		foreach (T item in sequence)
		{
			if (item == null)
			{
				throw new ArgumentNullException();
			}
		}
	}
}
