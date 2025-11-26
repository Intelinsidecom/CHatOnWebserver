namespace Microsoft.Phone.Controls.Maps;

public class AttributionInfo
{
	public string Text { get; set; }

	public AttributionInfo()
	{
		Text = string.Empty;
	}

	public override bool Equals(object obj)
	{
		if (!(obj is AttributionInfo attributionInfo))
		{
			return false;
		}
		return string.Equals(Text, attributionInfo.Text);
	}

	public override int GetHashCode()
	{
		return Text.GetHashCode();
	}
}
