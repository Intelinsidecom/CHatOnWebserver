namespace ChatON_WoA.InfraStructure;

public class StringTokenizer
{
	private string data;

	private string delimiter;

	private string[] tokens;

	private int index;

	public void init(string dataLine, string delim)
	{
		delimiter = delim;
		data = dataLine;
		tokens = data.Split(delimiter.ToCharArray());
		index = 0;
	}

	public StringTokenizer(string dataLine, string delim)
	{
		init(dataLine, delim);
	}

	public bool hasMoreTokens()
	{
		if (index < tokens.Length)
		{
			return true;
		}
		return false;
	}

	public string nextToken()
	{
		if (index < tokens.Length)
		{
			return tokens[index++];
		}
		return "";
	}

	public int countTokens()
	{
		return tokens.Length;
	}
}
