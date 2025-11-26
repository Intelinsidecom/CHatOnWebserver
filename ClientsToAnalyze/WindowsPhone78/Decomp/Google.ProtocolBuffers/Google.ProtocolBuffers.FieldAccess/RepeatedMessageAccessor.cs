using System;
using System.Reflection;

namespace Google.ProtocolBuffers.FieldAccess;

internal sealed class RepeatedMessageAccessor<TMessage, TBuilder> : RepeatedPrimitiveAccessor<TMessage, TBuilder> where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	private readonly Func<IBuilder> createBuilderDelegate;

	internal RepeatedMessageAccessor(string name)
		: base(name)
	{
		MethodInfo method = base.ClrType.GetMethod("CreateBuilder", RepeatedPrimitiveAccessor<TMessage, TBuilder>.EmptyTypes);
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

	public override void SetRepeated(TBuilder builder, int index, object value)
	{
		base.SetRepeated(builder, index, CoerceType(value));
	}

	public override IBuilder CreateBuilder()
	{
		return createBuilderDelegate();
	}

	public override void AddRepeated(TBuilder builder, object value)
	{
		base.AddRepeated(builder, CoerceType(value));
	}
}
