using Windows.UI.Xaml.Media.Imaging;

namespace ChatON_WoA.Views;

public class TempImageHolder
{
	private BitmapImage _tmpBitmapImage;

	public BitmapImage TmpBitmapImage
	{
		get
		{
			return _tmpBitmapImage;
		}
		set
		{
			_tmpBitmapImage = value;
		}
	}
}
