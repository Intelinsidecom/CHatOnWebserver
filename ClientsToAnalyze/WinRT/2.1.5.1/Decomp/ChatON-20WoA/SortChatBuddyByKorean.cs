using System.Collections.Generic;
using ChatOn.ViewModels;

public class SortChatBuddyByKorean : IComparer<ChatBuddy>
{
	public int Compare(ChatBuddy x, ChatBuddy y)
	{
		int num = 0;
		char c = x.Name.ToCharArray()[0];
		char c2 = y.Name.ToCharArray()[0];
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
