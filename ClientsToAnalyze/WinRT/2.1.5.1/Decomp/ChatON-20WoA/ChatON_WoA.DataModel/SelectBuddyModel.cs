using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using ChatON_WoA.Views;
using ChatOn.Services;
using Windows.UI;
using Windows.UI.Xaml.Media;

namespace ChatON_WoA.DataModel;

public class SelectBuddyModel
{
	private ObservableCollection<BuddySummary> _selectedBuddyItems = new ObservableCollection<BuddySummary>();

	private static readonly SelectBuddyModel _instance = new SelectBuddyModel();

	public static SelectBuddyModel Instance => _instance;

	public ObservableCollection<BuddySummary> SelectedBuddyItems => _selectedBuddyItems;

	public void Add(BuddySummary addedBuddy)
	{
		//IL_007a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0084: Expected O, but got Unknown
		if (SelectBuddyPage.SelectionCountLimit <= 0 || _selectedBuddyItems.Count < SelectBuddyPage.SelectionCountLimit)
		{
			if (!_selectedBuddyItems.Contains(addedBuddy) && _selectedBuddyItems.FirstOrDefault((BuddySummary c) => c.Buddy != null && c.Buddy.PhoneNumber == addedBuddy.Buddy.PhoneNumber) == null)
			{
				SelectedBuddyItems.Add(addedBuddy);
			}
			for (int num = 0; num < SelectedBuddyItems.Count; num++)
			{
				SelectedBuddyItems[num].NameForeground = new SolidColorBrush(Colors.White);
			}
		}
	}

	public void Remove(BuddySummary item)
	{
		//IL_0006: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Expected O, but got Unknown
		item.NameForeground = new SolidColorBrush(Colors.Black);
		SelectedBuddyItems.Remove(item);
	}

	public void Reset()
	{
		_selectedBuddyItems = new ObservableCollection<BuddySummary>();
	}

	internal void Add(IEnumerable<BuddySummary> selectedBuddies)
	{
		//IL_0077: Unknown result type (might be due to invalid IL or missing references)
		//IL_0081: Expected O, but got Unknown
		foreach (BuddySummary sum in selectedBuddies)
		{
			if (sum.Buddy == null)
			{
				Remove(sum);
			}
			else if (!_selectedBuddyItems.Contains(sum) && _selectedBuddyItems.FirstOrDefault((BuddySummary c) => c.Buddy != null && c.Buddy.PhoneNumber == sum.Buddy.PhoneNumber) == null)
			{
				sum.NameForeground = new SolidColorBrush(Colors.White);
				_selectedBuddyItems.Add(sum);
			}
		}
	}

	public void ClearSelectedBuddy()
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001f: Expected O, but got Unknown
		for (int i = 0; i < SelectedBuddyItems.Count; i++)
		{
			SelectedBuddyItems[i].NameForeground = new SolidColorBrush(Colors.Black);
		}
		SelectedBuddyItems.Clear();
	}

	internal List<BuddySummary> AddSelectedGroup(BuddySummary item, ObservableCollection<BuddySummary> showingItems)
	{
		List<BuddySummary> list = new List<BuddySummary>();
		string[] array = item.Group.Members.Split(',');
		string[] array2 = array;
		foreach (string memberPhone in array2)
		{
			Func<BuddySummary, bool> predicate = (BuddySummary x) => x.Buddy != null && x.Buddy.PhoneNumber.Equals(memberPhone);
			BuddySummary buddySummary = showingItems.FirstOrDefault(predicate);
			if (buddySummary != null)
			{
				Add(buddySummary);
				list.Add(buddySummary);
			}
		}
		return list;
	}
}
