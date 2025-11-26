using System;
using System.Reflection;

namespace Google.ProtocolBuffers.FieldAccess;

internal class SinglePrimitiveAccessor<TMessage, TBuilder> : IFieldAccessor<TMessage, TBuilder> where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	private readonly Type clrType;

	private readonly Func<TMessage, object> getValueDelegate;

	private readonly Action<TBuilder, object> setValueDelegate;

	private readonly Func<TMessage, bool> hasDelegate;

	private readonly Func<TBuilder, IBuilder> clearDelegate;

	internal static readonly Type[] EmptyTypes = new Type[0];

	protected Type ClrType => clrType;

	internal SinglePrimitiveAccessor(string name)
	{
		PropertyInfo declaredProperty = typeof(TMessage).GetTypeInfo().GetDeclaredProperty(name);
		PropertyInfo declaredProperty2 = typeof(TBuilder).GetTypeInfo().GetDeclaredProperty(name);
		if ((object)declaredProperty2 == null)
		{
			declaredProperty2 = typeof(TBuilder).GetTypeInfo().GetDeclaredProperty(name);
		}
		PropertyInfo declaredProperty3 = typeof(TMessage).GetTypeInfo().GetDeclaredProperty("Has" + name);
		MethodInfo declaredMethod = typeof(TBuilder).GetTypeInfo().GetDeclaredMethod("Clear" + name);
		if ((object)declaredProperty == null || (object)declaredProperty2 == null || (object)declaredProperty3 == null || (object)declaredMethod == null)
		{
			throw new ArgumentException("Not all required properties/methods available");
		}
		clrType = declaredProperty.PropertyType;
		hasDelegate = (Func<TMessage, bool>)declaredProperty3.GetMethod.CreateDelegate(typeof(Func<TMessage, bool>), null);
		clearDelegate = (Func<TBuilder, IBuilder>)declaredMethod.CreateDelegate(typeof(Func<TBuilder, IBuilder>), null);
		getValueDelegate = ReflectionUtil.CreateUpcastDelegate<TMessage>(declaredProperty.GetMethod);
		setValueDelegate = ReflectionUtil.CreateDowncastDelegate<TBuilder>(declaredProperty2.SetMethod);
	}

	public bool Has(TMessage message)
	{
		return hasDelegate(message);
	}

	public void Clear(TBuilder builder)
	{
		clearDelegate(builder);
	}

	public virtual IBuilder CreateBuilder()
	{
		throw new InvalidOperationException();
	}

	public virtual object GetValue(TMessage message)
	{
		return getValueDelegate(message);
	}

	public virtual void SetValue(TBuilder builder, object value)
	{
		setValueDelegate(builder, value);
	}

	public int GetRepeatedCount(TMessage message)
	{
		throw new InvalidOperationException();
	}

	public object GetRepeatedValue(TMessage message, int index)
	{
		throw new InvalidOperationException();
	}

	public void SetRepeated(TBuilder builder, int index, object value)
	{
		throw new InvalidOperationException();
	}

	public void AddRepeated(TBuilder builder, object value)
	{
		throw new InvalidOperationException();
	}

	public object GetRepeatedWrapper(TBuilder builder)
	{
		throw new InvalidOperationException();
	}
}
