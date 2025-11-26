using ChatOn.Infrastructure;
using ChatOn.Services;

namespace ChatON_WoA.Views;

public class ChatSettingPageViewModel : NotificationObject
{
	private int _selectedFontSize;

	public int SelectedFontSize
	{
		get
		{
			return _selectedFontSize;
		}
		set
		{
			_selectedFontSize = value;
			NotifyPropertyChanged(() => SelectedFontSize);
			SettingService.SetFontSizeType(value);
		}
	}

	public ChatSettingPageViewModel()
	{
		_selectedFontSize = SettingService.GetFontSizeType();
	}
}
