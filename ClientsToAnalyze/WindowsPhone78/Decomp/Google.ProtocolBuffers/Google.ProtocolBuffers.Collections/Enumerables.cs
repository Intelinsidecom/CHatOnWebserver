using System;
using System.Collections;

namespace Google.ProtocolBuffers.Collections;

public static class Enumerables
{
	public static bool Equals(IEnumerable left, IEnumerable right)
	{
		IEnumerator enumerator = left.GetEnumerator();
		try
		{
			foreach (object item in right)
			{
				if (!enumerator.MoveNext())
				{
					return false;
				}
				if (!object.Equals(enumerator.Current, item))
				{
					return false;
				}
			}
			if (enumerator.MoveNext())
			{
				return false;
			}
		}
		finally
		{
			IDisposable disposable = enumerator as IDisposable;
			if (disposable != null)
			{
				disposable.Dispose();
			}
		}
		return true;
	}
}
