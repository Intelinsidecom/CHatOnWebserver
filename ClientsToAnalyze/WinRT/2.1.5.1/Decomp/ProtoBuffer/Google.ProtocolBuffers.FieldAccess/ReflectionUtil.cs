using System.Reflection;

namespace Google.ProtocolBuffers.FieldAccess;

internal static class ReflectionUtil
{
	public static Func<T, object> CreateUpcastDelegate<T>(MethodInfo method)
	{
		MethodInfo declaredMethod = typeof(ReflectionUtil).GetTypeInfo().GetDeclaredMethod("CreateUpcastDelegateImpl");
		MethodInfo methodInfo = declaredMethod.MakeGenericMethod(typeof(T), method.ReturnType);
		return (Func<T, object>)methodInfo.Invoke(null, new object[1] { method });
	}

	public static Func<TSource, object> CreateUpcastDelegateImpl<TSource, TResult>(MethodInfo method)
	{
		Func<TSource, TResult> getter = (Func<TSource, TResult>)method.CreateDelegate(typeof(Func<TSource, TResult>), null);
		return (TSource source) => getter(source);
	}

	public static Action<T, object> CreateDowncastDelegate<T>(MethodInfo method)
	{
		MethodInfo declaredMethod = typeof(ReflectionUtil).GetTypeInfo().GetDeclaredMethod("CreateDowncastDelegateImpl");
		MethodInfo methodInfo = declaredMethod.MakeGenericMethod(typeof(T), method.GetParameters()[0].ParameterType);
		return (Action<T, object>)methodInfo.Invoke(null, new object[1] { method });
	}

	public static Action<TSource, object> CreateDowncastDelegateImpl<TSource, TParam>(MethodInfo method)
	{
		Action<TSource, TParam> call = (Action<TSource, TParam>)method.CreateDelegate(typeof(Action<TSource, TParam>), null);
		return delegate(TSource source, object parameter)
		{
			call(source, (TParam)parameter);
		};
	}

	public static Action<T, object> CreateDowncastDelegateIgnoringReturn<T>(MethodInfo method)
	{
		MethodInfo declaredMethod = typeof(ReflectionUtil).GetTypeInfo().GetDeclaredMethod("CreateDowncastDelegateIgnoringReturnImpl");
		MethodInfo methodInfo = declaredMethod.MakeGenericMethod(typeof(T), method.GetParameters()[0].ParameterType, method.ReturnType);
		return (Action<T, object>)methodInfo.Invoke(null, new object[1] { method });
	}

	public static Action<TSource, object> CreateDowncastDelegateIgnoringReturnImpl<TSource, TParam, TReturn>(MethodInfo method)
	{
		Func<TSource, TParam, TReturn> call = (Func<TSource, TParam, TReturn>)method.CreateDelegate(typeof(Func<TSource, TParam, TReturn>), null);
		return delegate(TSource source, object parameter)
		{
			call(source, (TParam)parameter);
		};
	}

	public static Func<IBuilder> CreateStaticUpcastDelegate(MethodInfo method)
	{
		MethodInfo declaredMethod = typeof(ReflectionUtil).GetTypeInfo().GetDeclaredMethod("CreateStaticUpcastDelegateImpl");
		MethodInfo methodInfo = declaredMethod.MakeGenericMethod(method.ReturnType);
		return (Func<IBuilder>)methodInfo.Invoke(null, new object[1] { method });
	}

	public static Func<IBuilder> CreateStaticUpcastDelegateImpl<T>(MethodInfo method)
	{
		Func<T> call = (Func<T>)method.CreateDelegate(typeof(Func<T>), null);
		return () => (IBuilder)(object)call();
	}
}
