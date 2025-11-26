namespace Microsoft.Phone.Controls.Maps;

public class Range<T>
{
	private readonly T fromValue;

	private readonly T toValue;

	public T From => fromValue;

	public T To => toValue;

	public Range(T fromValue, T toValue)
	{
		this.fromValue = fromValue;
		this.toValue = toValue;
	}
}
