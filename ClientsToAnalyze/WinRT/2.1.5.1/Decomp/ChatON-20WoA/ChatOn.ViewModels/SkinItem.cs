using ChatOn.Infrastructure;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.ViewModels;

public class SkinItem : NotificationObject
{
	private BitmapSource _image;

	private int _value;

	private bool _isSelected;

	private string _name;

	public bool IsSelected
	{
		get
		{
			return _isSelected;
		}
		set
		{
			_isSelected = value;
			NotifyPropertyChanged(() => IsSelected);
		}
	}

	public BitmapSource Image
	{
		get
		{
			return _image;
		}
		set
		{
			_image = value;
			NotifyPropertyChanged(() => Image);
		}
	}

	public int Value
	{
		get
		{
			return _value;
		}
		set
		{
			_value = value;
		}
	}

	public string Name
	{
		get
		{
			return _name;
		}
		set
		{
			_name = value;
			NotifyPropertyChanged(() => Name);
		}
	}
}
