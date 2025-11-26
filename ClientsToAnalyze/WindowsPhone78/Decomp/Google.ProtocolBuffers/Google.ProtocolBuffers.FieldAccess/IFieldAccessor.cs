namespace Google.ProtocolBuffers.FieldAccess;

internal interface IFieldAccessor<TMessage, TBuilder> where TMessage : IMessage<TMessage, TBuilder> where TBuilder : IBuilder<TMessage, TBuilder>
{
	bool Has(TMessage message);

	int GetRepeatedCount(TMessage message);

	void Clear(TBuilder builder);

	IBuilder CreateBuilder();

	object GetValue(TMessage message);

	void SetValue(TBuilder builder, object value);

	object GetRepeatedValue(TMessage message, int index);

	void SetRepeated(TBuilder builder, int index, object value);

	void AddRepeated(TBuilder builder, object value);

	object GetRepeatedWrapper(TBuilder builder);
}
