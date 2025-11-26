using System;
using System.Collections;
using System.Reflection;

namespace Google.ProtocolBuffers.FieldAccess;

internal class RepeatedPrimitiveAccessor<TMessage, TBuilder> : IFieldAccessor<TMessage, TBuilder> where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	private readonly Type clrType;

	private readonly Func<TMessage, object> getValueDelegate;

	private readonly Func<TBuilder, IBuilder> clearDelegate;

	private readonly Action<TBuilder, object> addValueDelegate;

	private readonly Func<TBuilder, object> getRepeatedWrapperDelegate;

	private readonly Func<TMessage, int> countDelegate;

	private readonly MethodInfo getElementMethod;

	private readonly MethodInfo setElementMethod;

	internal static readonly Type[] EmptyTypes = new Type[0];

	protected Type ClrType => clrType;

	internal RepeatedPrimitiveAccessor(string name)
	{
		PropertyInfo property = typeof(TMessage).GetProperty(name + "List");
		PropertyInfo property2 = typeof(TBuilder).GetProperty(name + "List");
		PropertyInfo property3 = typeof(TMessage).GetProperty(name + "Count");
		MethodInfo method = typeof(TBuilder).GetMethod("Clear" + name, EmptyTypes);
		getElementMethod = typeof(TMessage).GetMethod("Get" + name, new Type[1] { typeof(int) });
		clrType = getElementMethod.ReturnType;
		MethodInfo method2 = typeof(TBuilder).GetMethod("Add" + name, new Type[1] { ClrType });
		setElementMethod = typeof(TBuilder).GetMethod("Set" + name, new Type[2]
		{
			typeof(int),
			ClrType
		});
		if ((object)property == null || (object)property2 == null || (object)property3 == null || (object)method == null || (object)method2 == null || (object)getElementMethod == null || (object)setElementMethod == null)
		{
			throw new ArgumentException("Not all required properties/methods available");
		}
		clearDelegate = (Func<TBuilder, IBuilder>)Delegate.CreateDelegate(typeof(Func<TBuilder, IBuilder>), null, method);
		countDelegate = (Func<TMessage, int>)Delegate.CreateDelegate(typeof(Func<TMessage, int>), null, property3.GetGetMethod());
		getValueDelegate = ReflectionUtil.CreateUpcastDelegate<TMessage>(property.GetGetMethod());
		addValueDelegate = ReflectionUtil.CreateDowncastDelegateIgnoringReturn<TBuilder>(method2);
		getRepeatedWrapperDelegate = ReflectionUtil.CreateUpcastDelegate<TBuilder>(property2.GetGetMethod());
	}

	public bool Has(TMessage message)
	{
		throw new InvalidOperationException();
	}

	public virtual IBuilder CreateBuilder()
	{
		throw new InvalidOperationException();
	}

	public virtual object GetValue(TMessage message)
	{
		return getValueDelegate(message);
	}

	public void SetValue(TBuilder builder, object value)
	{
		Clear(builder);
		foreach (object item in (IEnumerable)value)
		{
			AddRepeated(builder, item);
		}
	}

	public void Clear(TBuilder builder)
	{
		clearDelegate(builder);
	}

	public int GetRepeatedCount(TMessage message)
	{
		return countDelegate(message);
	}

	public virtual object GetRepeatedValue(TMessage message, int index)
	{
		return getElementMethod.Invoke(message, new object[1] { index });
	}

	public virtual void SetRepeated(TBuilder builder, int index, object value)
	{
		ThrowHelper.ThrowIfNull(value, "value");
		setElementMethod.Invoke(builder, new object[2] { index, value });
	}

	public virtual void AddRepeated(TBuilder builder, object value)
	{
		ThrowHelper.ThrowIfNull(value, "value");
		addValueDelegate(builder, value);
	}

	public object GetRepeatedWrapper(TBuilder builder)
	{
		return getRepeatedWrapperDelegate(builder);
	}
}
