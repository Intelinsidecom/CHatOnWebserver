using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers.FieldAccess;

internal sealed class SingleEnumAccessor<TMessage, TBuilder> : SinglePrimitiveAccessor<TMessage, TBuilder> where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	private readonly EnumDescriptor enumDescriptor;

	internal SingleEnumAccessor(FieldDescriptor field, string name)
		: base(name)
	{
		enumDescriptor = field.EnumType;
	}

	public override object GetValue(TMessage message)
	{
		int number = (int)base.GetValue(message);
		return enumDescriptor.FindValueByNumber(number);
	}

	public override void SetValue(TBuilder builder, object value)
	{
		ThrowHelper.ThrowIfNull(value, "value");
		EnumValueDescriptor enumValueDescriptor = (EnumValueDescriptor)value;
		base.SetValue(builder, enumValueDescriptor.Number);
	}
}
