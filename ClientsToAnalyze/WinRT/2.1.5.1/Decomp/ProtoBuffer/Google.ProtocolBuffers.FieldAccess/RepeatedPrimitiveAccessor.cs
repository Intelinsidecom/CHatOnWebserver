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
		PropertyInfo declaredProperty = typeof(TMessage).GetTypeInfo().GetDeclaredProperty(name + "List");
		PropertyInfo declaredProperty2 = typeof(TBuilder).GetTypeInfo().GetDeclaredProperty(name + "List");
		PropertyInfo declaredProperty3 = typeof(TMessage).GetTypeInfo().GetDeclaredProperty(name + "Count");
		MethodInfo declaredMethod = typeof(TBuilder).GetTypeInfo().GetDeclaredMethod("Clear" + name);
		getElementMethod = typeof(TMessage).GetTypeInfo().GetDeclaredMethod("Get" + name);
		clrType = getElementMethod.ReturnType;
		MethodInfo declaredMethod2 = typeof(TBuilder).GetTypeInfo().GetDeclaredMethod("Add" + name);
		setElementMethod = typeof(TBuilder).GetTypeInfo().GetDeclaredMethod("Set" + name);
		if ((object)declaredProperty == null || (object)declaredProperty2 == null || (object)declaredProperty3 == null || (object)declaredMethod == null || (object)declaredMethod2 == null || (object)getElementMethod == null || (object)setElementMethod == null)
		{
			throw new ArgumentException("Not all required properties/methods available");
		}
		clearDelegate = (Func<TBuilder, IBuilder>)declaredMethod.CreateDelegate(typeof(Func<TBuilder, IBuilder>), null);
		countDelegate = (Func<TMessage, int>)declaredProperty3.GetMethod.CreateDelegate(typeof(Func<TMessage, int>), null);
		getValueDelegate = ReflectionUtil.CreateUpcastDelegate<TMessage>(declaredProperty.GetMethod);
		addValueDelegate = ReflectionUtil.CreateDowncastDelegateIgnoringReturn<TBuilder>(declaredMethod2);
		getRepeatedWrapperDelegate = ReflectionUtil.CreateUpcastDelegate<TBuilder>(declaredProperty2.GetMethod);
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
