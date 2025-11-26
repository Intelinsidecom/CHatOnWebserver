namespace System.Diagnostics.Contracts;

public static class Contract
{
	public static void Assume(bool condition)
	{
	}

	public static void Ensures(bool condition)
	{
	}

	public static void Ensures(bool condition, string userMessage)
	{
	}

	public static void Invariant(bool condition)
	{
	}

	public static void Invariant(bool condition, string userMessage)
	{
	}

	public static void Requires(bool condition)
	{
	}

	public static void Requires<TException>(bool condition) where TException : Exception
	{
		if (!condition)
		{
			TException ex = Activator.CreateInstance<TException>();
			throw ex;
		}
	}

	public static void Requires(bool condition, string userMessage)
	{
	}

	public static void Requires<TException>(bool condition, string userMessage) where TException : Exception
	{
		if (!condition)
		{
			TException ex = Activator.CreateInstance(typeof(TException), userMessage) as TException;
			throw ex;
		}
	}

	public static T Result<T>()
	{
		return default(T);
	}
}
