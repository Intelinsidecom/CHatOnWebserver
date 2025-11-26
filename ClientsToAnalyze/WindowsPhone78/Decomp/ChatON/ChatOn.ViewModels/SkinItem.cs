using System.Windows.Media.Imaging;
using ChatOn.Infrastructure;

namespace ChatOn.ViewModels;

public class SkinItem : NotificationObject
{
	private BitmapSource _image;

	private int _value;

	private bool _isSelected;

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
}
