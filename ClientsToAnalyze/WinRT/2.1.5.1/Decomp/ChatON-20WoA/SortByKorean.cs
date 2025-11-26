using System.Collections.Generic;

public class SortByKorean : IComparer<string>
{
	public int Compare(string x, string y)
	{
		int num = 0;
		char c = x.ToCharArray()[0];
		char c2 = y.ToCharArray()[0];
		int num2 = c;
		int num3 = c2;
		if (num2 < num3)
		{
			return 1;
		}
		if (num2 > num3)
		{
			return -1;
		}
		return 0;
	}
}
