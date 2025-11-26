using System.Collections;
using System.Collections.Generic;
using Google.ProtocolBuffers.Collections;
using Google.ProtocolBuffers.Descriptors;

namespace Google.ProtocolBuffers.FieldAccess;

internal sealed class RepeatedEnumAccessor<TMessage, TBuilder> : RepeatedPrimitiveAccessor<TMessage, TBuilder> where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	private readonly EnumDescriptor enumDescriptor;

	internal RepeatedEnumAccessor(FieldDescriptor field, string name)
		: base(name)
	{
		enumDescriptor = field.EnumType;
	}

	public override object GetValue(TMessage message)
	{
		List<EnumValueDescriptor> list = new List<EnumValueDescriptor>();
		foreach (int item in (IEnumerable)base.GetValue(message))
		{
			list.Add(enumDescriptor.FindValueByNumber(item));
		}
		return Lists.AsReadOnly(list);
	}

	public override object GetRepeatedValue(TMessage message, int index)
	{
		int number = (int)base.GetRepeatedValue(message, index);
		return enumDescriptor.FindValueByNumber(number);
	}

	public override void AddRepeated(TBuilder builder, object value)
	{
		ThrowHelper.ThrowIfNull(value, "value");
		base.AddRepeated(builder, ((EnumValueDescriptor)value).Number);
	}

	public override void SetRepeated(TBuilder builder, int index, object value)
	{
		ThrowHelper.ThrowIfNull(value, "value");
		base.SetRepeated(builder, index, ((EnumValueDescriptor)value).Number);
	}
}
