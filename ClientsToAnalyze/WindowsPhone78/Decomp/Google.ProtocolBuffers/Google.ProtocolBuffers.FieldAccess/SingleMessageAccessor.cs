using System;
using System.Reflection;

namespace Google.ProtocolBuffers.FieldAccess;

internal sealed class SingleMessageAccessor<TMessage, TBuilder> : SinglePrimitiveAccessor<TMessage, TBuilder> where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	private readonly Func<IBuilder> createBuilderDelegate;

	internal SingleMessageAccessor(string name)
		: base(name)
	{
		MethodInfo method = base.ClrType.GetMethod("CreateBuilder", SinglePrimitiveAccessor<TMessage, TBuilder>.EmptyTypes);
		if ((object)method == null)
		{
			throw new ArgumentException("No public static CreateBuilder method declared in " + base.ClrType.Name);
		}
		createBuilderDelegate = ReflectionUtil.CreateStaticUpcastDelegate(method);
	}

	private object CoerceType(object value)
	{
		ThrowHelper.ThrowIfNull(value, "value");
		if (base.ClrType.IsInstanceOfType(value))
		{
			return value;
		}
		IMessage message = (IMessage)value;
		return CreateBuilder().WeakMergeFrom(message).WeakBuild();
	}

	public override void SetValue(TBuilder builder, object value)
	{
		base.SetValue(builder, CoerceType(value));
	}

	public override IBuilder CreateBuilder()
	{
		return createBuilderDelegate();
	}
}
