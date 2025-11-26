using System.IO;
using System.Windows.Media.Imaging;

namespace ChatOn.Models;

public class AttachedPhoto : Attachment
{
	private const int MaxWidth = 800;

	private const int MaxHeight = 600;

	private const int MaxThumbSize = 239;

	private BitmapImage _bitmapImage;

	public BitmapImage BitmapImage => _bitmapImage;

	public AttachedPhoto(Stream s, string dirPath)
	{
		base.AttachedMediaType = MediaType.PHOTO;
		base.ContentType = "image/jpeg";
		base.FileName = Utility.GetTimeStamp() + ".jpg";
		base.FilePath = dirPath + "\\" + base.FileName;
		base.Title = base.FileName;
		_bitmapImage = new BitmapImage();
		_bitmapImage.CreateOptions = BitmapCreateOptions.None;
		_bitmapImage.SetSource(s);
		int pixelWidth = _bitmapImage.PixelWidth;
		int pixelHeight = _bitmapImage.PixelHeight;
		int newWidth = 800;
		int newHeight = 600;
		Utility.GetPhotoSizeByRatio(pixelWidth, pixelHeight, ref newWidth, ref newHeight);
		Utility.SaveToJpeg(base.FilePath, _bitmapImage, newWidth, newHeight);
		string fileName = dirPath + "\\thumb_" + base.FileName;
		newWidth = 239;
		newHeight = 239;
		Utility.GetPhotoSizeByRatio(pixelWidth, pixelHeight, ref newWidth, ref newHeight);
		Utility.SaveToJpeg(fileName, _bitmapImage, newWidth, newHeight);
		_bitmapImage = null;
	}

	public AttachedPhoto(WriteableBitmap wb, string dirPath)
	{
		base.AttachedMediaType = MediaType.PHOTO;
		base.ContentType = "image/jpeg";
		base.FileName = Utility.GetTimeStamp() + ".jpg";
		base.FilePath = dirPath + "\\" + base.FileName;
		base.Title = base.FileName;
		int pixelWidth = wb.PixelWidth;
		int pixelHeight = wb.PixelHeight;
		int newWidth = 800;
		int newHeight = 600;
		Utility.GetPhotoSizeByRatio(pixelWidth, pixelHeight, ref newWidth, ref newHeight);
		Utility.SaveToJpeg(base.FilePath, wb, newWidth, newHeight);
		string fileName = dirPath + "\\thumb_" + base.FileName;
		newWidth = 239;
		newHeight = 239;
		Utility.GetPhotoSizeByRatio(pixelWidth, pixelHeight, ref newWidth, ref newHeight);
		Utility.SaveToJpeg(fileName, wb, newWidth, newHeight);
	}

	public void LoadBitmapImage()
	{
		_bitmapImage = Utility.LoadJpeg(base.FilePath);
	}
}
