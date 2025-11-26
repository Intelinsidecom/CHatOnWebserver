using System.IO;
using System.Threading.Tasks;
using ChatOn.Infrastructure;
using Windows.Storage;
using Windows.UI.Xaml.Media.Imaging;

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
		//IL_0056: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected O, but got Unknown
		base.AttachedMediaType = MediaType.PHOTO;
		base.ContentType = "image/jpeg";
		base.FileName = Utility.GetTimeStamp() + ".jpg";
		base.FilePath = dirPath + "\\" + base.FileName;
		base.Title = base.FileName;
		_bitmapImage = new BitmapImage();
		_bitmapImage.put_CreateOptions((BitmapCreateOptions)0);
		int pixelWidth = ((BitmapSource)_bitmapImage).PixelWidth;
		int pixelHeight = ((BitmapSource)_bitmapImage).PixelHeight;
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

	public async Task<StorageFile> SetFile(StorageFile s)
	{
		_bitmapImage = null;
		return await Utility.CopyFileAsync(s, base.FileName, base.DirPath);
	}

	public AttachedPhoto(WriteableBitmap wb, string dirPath)
	{
		base.AttachedMediaType = MediaType.PHOTO;
		base.ContentType = "image/jpeg";
		base.FileName = Utility.GetTimeStamp() + ".jpg";
		base.FilePath = dirPath + "\\" + base.FileName;
		base.Title = base.FileName;
		int pixelWidth = ((BitmapSource)wb).PixelWidth;
		int pixelHeight = ((BitmapSource)wb).PixelHeight;
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

	public AttachedPhoto(string dirPath)
	{
		base.AttachedMediaType = MediaType.PHOTO;
		base.ContentType = "image/jpeg";
		base.DirPath = dirPath;
		base.FileName = Utility.GetTimeStamp() + ".jpg";
		base.FilePath = dirPath + "\\" + base.FileName;
		base.Title = base.FileName;
	}

	public void LoadBitmapImage()
	{
	}
}
