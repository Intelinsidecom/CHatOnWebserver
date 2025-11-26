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
		PropertyInfo property = typeof(TMessage).GetProperty(name);
		PropertyInfo property2 = typeof(TBuilder).GetProperty(name);
		if ((object)property2 == null)
		{
			property2 = typeof(TBuilder).GetProperty(name);
		}
		PropertyInfo property3 = typeof(TMessage).GetProperty("Has" + name);
		MethodInfo method = typeof(TBuilder).GetMethod("Clear" + name, EmptyTypes);
		if ((object)property == null || (object)property2 == null || (object)property3 == null || (object)method == null)
		{
			throw new ArgumentException("Not all required properties/methods available");
		}
		clrType = property.PropertyType;
		hasDelegate = (Func<TMessage, bool>)Delegate.CreateDelegate(typeof(Func<TMessage, bool>), null, property3.GetGetMethod());
		clearDelegate = (Func<TBuilder, IBuilder>)Delegate.CreateDelegate(typeof(Func<TBuilder, IBuilder>), null, method);
		getValueDelegate = ReflectionUtil.CreateUpcastDelegate<TMessage>(property.GetGetMethod());
		setValueDelegate = ReflectionUtil.CreateDowncastDelegate<TBuilder>(property2.GetSetMethod());
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
