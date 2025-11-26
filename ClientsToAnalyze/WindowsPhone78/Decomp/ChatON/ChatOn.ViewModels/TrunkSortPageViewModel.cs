using System.IO.IsolatedStorage;
using ChatOn.Infrastructure;
using Microsoft.Phone.Controls;

namespace ChatOn.ViewModels;

public class TrunkSortPageViewModel : NotificationObject
{
	private PhoneApplicationPage _page;

	private int tempTrunkSort;

	private int _selectItem;

	private int _loadTrunkList;

	public int SelectItem
	{
		get
		{
			return _selectItem;
		}
		set
		{
			_selectItem = value;
			NotifyPropertyChanged(() => SelectItem);
		}
	}

	public TrunkSortPageViewModel(PhoneApplicationPage page)
	{
		_page = page;
		if (IsolatedStorageSettings.ApplicationSettings.Contains("TrunkSort"))
		{
			tempTrunkSort = (int)IsolatedStorageSettings.ApplicationSettings["TrunkSort"];
		}
		else
		{
			IsolatedStorageSettings.ApplicationSettings.Add("TrunkSort", 0);
		}
		IsolatedStorageSettings.ApplicationSettings.Save();
		if (tempTrunkSort == 0)
		{
			SelectItem = 0;
		}
		else
		{
			SelectItem = 1;
		}
	}

	public void LatestComment()
	{
		if (IsolatedStorageSettings.ApplicationSettings.Contains("TrunkSort"))
		{
			IsolatedStorageSettings.ApplicationSettings["TrunkSort"] = 0;
		}
		else
		{
			IsolatedStorageSettings.ApplicationSettings.Add("TrunkSort", 0);
		}
		IsolatedStorageSettings.ApplicationSettings["LoadTrunkList"] = 1;
		IsolatedStorageSettings.ApplicationSettings.Save();
		Utility.SafetyGoBack(_page);
	}

	public void Recent()
	{
		if (IsolatedStorageSettings.ApplicationSettings.Contains("TrunkSort"))
		{
			IsolatedStorageSettings.ApplicationSettings["TrunkSort"] = 1;
		}
		else
		{
			IsolatedStorageSettings.ApplicationSettings.Add("TrunkSort", 1);
		}
		IsolatedStorageSettings.ApplicationSettings["LoadTrunkList"] = 1;
		IsolatedStorageSettings.ApplicationSettings.Save();
		Utility.SafetyGoBack(_page);
	}
}
