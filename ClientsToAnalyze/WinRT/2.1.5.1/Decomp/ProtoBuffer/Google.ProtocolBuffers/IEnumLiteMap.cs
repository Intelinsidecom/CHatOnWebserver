namespace Google.ProtocolBuffers;

public interface IEnumLiteMap
{
	bool IsValidValue(IEnumLite value);

	IEnumLite FindValueByNumber(int number);
}
public interface IEnumLiteMap<T> : IEnumLiteMap where T : IEnumLite
{
	new T FindValueByNumber(int number);
}
