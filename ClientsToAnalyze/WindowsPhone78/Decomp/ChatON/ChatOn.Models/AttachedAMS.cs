using System.Windows.Media.Imaging;

namespace ChatOn.Models;

public class AttachedAMS : Attachment
{
	private const int MaxThumbSize = 239;

	public AttachedAMS(byte[] data, string dirPath)
	{
		base.AttachedMediaType = MediaType.AMS;
		base.ContentType = "image/jpeg";
		base.FileName = Utility.GetTimeStamp() + ".jpg";
		base.FilePath = dirPath + "\\" + base.FileName;
		base.Title = base.FileName;
		Utility.SaveByteAsFile(base.FilePath, data);
		string fileName = dirPath + "\\thumb_" + base.FileName;
		BitmapImage bitmapImage = Utility.LoadJpeg(base.FilePath);
		int newWidth = 239;
		int newHeight = 239;
		Utility.GetPhotoSizeByRatio(bitmapImage.PixelWidth, bitmapImage.PixelHeight, ref newWidth, ref newHeight);
		Utility.SaveToJpeg(fileName, bitmapImage, newWidth, newHeight);
	}
}
