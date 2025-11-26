using ChatON_WoA.Views;
using ChatOn.Infrastructure;

namespace ChatOn.ViewModels;

public class SettingsPageViewModel : NotificationObject
{
	private SettingsPage _page;

	private int _selectedIndex;

	public int SelectedIndex
	{
		get
		{
			return _selectedIndex;
		}
		set
		{
			_selectedIndex = value;
			NotifyPropertyChanged(() => SelectedIndex);
		}
	}

	public SettingsPageViewModel(SettingsPage page)
	{
		_page = page;
	}
}
