using System;
using System.Reflection;

namespace Google.ProtocolBuffers.FieldAccess;

internal static class ReflectionUtil
{
	public static Func<T, object> CreateUpcastDelegate<T>(MethodInfo method)
	{
		MethodInfo method2 = typeof(ReflectionUtil).GetMethod("CreateUpcastDelegateImpl");
		MethodInfo methodInfo = method2.MakeGenericMethod(typeof(T), method.ReturnType);
		return (Func<T, object>)methodInfo.Invoke(null, new object[1] { method });
	}

	public static Func<TSource, object> CreateUpcastDelegateImpl<TSource, TResult>(MethodInfo method)
	{
		Func<TSource, TResult> getter = (Func<TSource, TResult>)Delegate.CreateDelegate(typeof(Func<TSource, TResult>), null, method);
		return (TSource source) => getter(source);
	}

	public static Action<T, object> CreateDowncastDelegate<T>(MethodInfo method)
	{
		MethodInfo method2 = typeof(ReflectionUtil).GetMethod("CreateDowncastDelegateImpl");
		MethodInfo methodInfo = method2.MakeGenericMethod(typeof(T), method.GetParameters()[0].ParameterType);
		return (Action<T, object>)methodInfo.Invoke(null, new object[1] { method });
	}

	public static Action<TSource, object> CreateDowncastDelegateImpl<TSource, TParam>(MethodInfo method)
	{
		Action<TSource, TParam> call = (Action<TSource, TParam>)Delegate.CreateDelegate(typeof(Action<TSource, TParam>), null, method);
		return delegate(TSource source, object parameter)
		{
			call(source, (TParam)parameter);
		};
	}

	public static Action<T, object> CreateDowncastDelegateIgnoringReturn<T>(MethodInfo method)
	{
		MethodInfo method2 = typeof(ReflectionUtil).GetMethod("CreateDowncastDelegateIgnoringReturnImpl");
		MethodInfo methodInfo = method2.MakeGenericMethod(typeof(T), method.GetParameters()[0].ParameterType, method.ReturnType);
		return (Action<T, object>)methodInfo.Invoke(null, new object[1] { method });
	}

	public static Action<TSource, object> CreateDowncastDelegateIgnoringReturnImpl<TSource, TParam, TReturn>(MethodInfo method)
	{
		Func<TSource, TParam, TReturn> call = (Func<TSource, TParam, TReturn>)Delegate.CreateDelegate(typeof(Func<TSource, TParam, TReturn>), null, method);
		return delegate(TSource source, object parameter)
		{
			call(source, (TParam)parameter);
		};
	}

	public static Func<IBuilder> CreateStaticUpcastDelegate(MethodInfo method)
	{
		MethodInfo method2 = typeof(ReflectionUtil).GetMethod("CreateStaticUpcastDelegateImpl");
		MethodInfo methodInfo = method2.MakeGenericMethod(method.ReturnType);
		return (Func<IBuilder>)methodInfo.Invoke(null, new object[1] { method });
	}

	public static Func<IBuilder> CreateStaticUpcastDelegateImpl<T>(MethodInfo method)
	{
		Func<T> call = (Func<T>)Delegate.CreateDelegate(typeof(Func<T>), null, method);
		return () => (IBuilder)(object)call();
	}
}
