using System;
using System.Collections.Generic;
using System.Globalization;
using System.IO;
using System.Net;
using System.Net.Http;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text;
using System.Threading.Tasks;
using ChatON_WoA.Common;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.InfraStructure;
using ChatOn.Models;
using ChatOn.Services;
using Windows.ApplicationModel.Resources;
using Windows.Data.Xml.Dom;
using Windows.Devices.Enumeration.Pnp;
using Windows.Foundation;
using Windows.Graphics.Imaging;
using Windows.Networking.Connectivity;
using Windows.Security.Cryptography;
using Windows.Security.Cryptography.Core;
using Windows.Storage;
using Windows.Storage.FileProperties;
using Windows.Storage.Streams;
using Windows.System;
using Windows.UI.Notifications;
using Windows.UI.Popups;
using Windows.UI.StartScreen;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Infrastructure;

public class Utility
{
	internal static string GetResourceString(string name)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		ResourceLoader val = new ResourceLoader();
		return val.GetString(name);
	}

	internal static void SafetyGoBack(Page page)
	{
		try
		{
			if (page.Frame.CanGoBack)
			{
				page.Frame.GoBack();
			}
		}
		catch (Exception)
		{
		}
	}

	public static DateTime GetDateTimeFromMiliseconds(long miliseconds)
	{
		DateTime dateTime = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
		TimeSpan timeSpan = TimeSpan.FromMilliseconds(miliseconds);
		return (dateTime + timeSpan).ToLocalTime();
	}

	public static DateTime GetDateTimefromEpoch(long epoch)
	{
		long ticks = epoch / 10 + 621355968000000000L;
		return new DateTime(ticks).ToLocalTime();
	}

	public static long GetTimeStamp()
	{
		DateTime dateTime = new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc);
		return (long)(DateTime.UtcNow - dateTime).TotalMilliseconds;
	}

	public static byte[] HexStringToByteArray(string hex)
	{
		try
		{
			int length = hex.Length;
			byte[] array = new byte[length / 2];
			for (int i = 0; i < length; i += 2)
			{
				array[i / 2] = Convert.ToByte(hex.Substring(i, 2), 16);
			}
			return array;
		}
		catch (Exception)
		{
			return null;
		}
	}

	public static byte[] StrToByteArray(string str)
	{
		UTF8Encoding uTF8Encoding = new UTF8Encoding();
		return uTF8Encoding.GetBytes(str);
	}

	public static string ByteArrayToStr(byte[] dBytes)
	{
		UTF8Encoding uTF8Encoding = new UTF8Encoding();
		return uTF8Encoding.GetString(dBytes, 0, dBytes.Length);
	}

	public static string HexEncode(byte[] data)
	{
		string text = BitConverter.ToString(data);
		text = text.Replace("-", "");
		return text.ToLower();
	}

	public static string UrlEncrypt(string input)
	{
		if (string.IsNullOrEmpty(input))
		{
			return input;
		}
		UTF8Encoding uTF8Encoding = new UTF8Encoding();
		byte[] bytes = uTF8Encoding.GetBytes(input);
		byte[] array = new byte[16]
		{
			0, 111, 98, 105, 108, 101, 38, 87, 101, 98,
			64, 67, 104, 97, 116, 79
		};
		byte[] array2 = new byte[16]
		{
			110, 68, 101, 118, 101, 108, 111, 112, 109, 101,
			110, 116, 67, 104, 97, 116
		};
		SymmetricKeyAlgorithmProvider val = SymmetricKeyAlgorithmProvider.OpenAlgorithm("AES_CBC_PKCS7");
		IBuffer val2 = CryptographicBuffer.CreateFromByteArray(array);
		CryptographicKey val3 = val.CreateSymmetricKey(val2);
		IBuffer val4 = CryptographicBuffer.CreateFromByteArray(array2);
		IBuffer val5 = CryptographicBuffer.CreateFromByteArray(bytes);
		IBuffer val6 = CryptographicEngine.Encrypt(val3, val5, val4);
		return CryptographicBuffer.EncodeToHexString(val6);
	}

	public static byte[] Encrypt(string fullkey, string data)
	{
		UTF8Encoding uTF8Encoding = new UTF8Encoding();
		byte[] bytes = uTF8Encoding.GetBytes(data);
		return Encrypt(fullkey, bytes);
	}

	public static byte[] Encrypt(string fullkey, byte[] data)
	{
		byte[] array = HexStringToByteArray(fullkey);
		byte[] array2 = new byte[16];
		byte[] array3 = new byte[16];
		for (int i = 0; i < 16; i++)
		{
			array2[i] = array[i];
			array3[i] = array[i + 16];
		}
		SymmetricKeyAlgorithmProvider val = SymmetricKeyAlgorithmProvider.OpenAlgorithm("AES_CBC_PKCS7");
		IBuffer val2 = CryptographicBuffer.CreateFromByteArray(array2);
		CryptographicKey val3 = val.CreateSymmetricKey(val2);
		IBuffer val4 = CryptographicBuffer.CreateFromByteArray(array3);
		IBuffer val5 = CryptographicBuffer.CreateFromByteArray(data);
		IBuffer val6 = CryptographicEngine.Encrypt(val3, val5, val4);
		return HexStringToByteArray(CryptographicBuffer.EncodeToHexString(val6));
	}

	public static string ComputeMD5(string str)
	{
		HashAlgorithmProvider val = HashAlgorithmProvider.OpenAlgorithm("MD5");
		IBuffer val2 = CryptographicBuffer.ConvertStringToBinary(str, (BinaryStringEncoding)0);
		IBuffer val3 = val.HashData(val2);
		return CryptographicBuffer.EncodeToHexString(val3);
	}

	public static void Decrypt(string fullkey, byte[] data, out string ret)
	{
		byte[] ret2 = null;
		Decrypt(fullkey, data, out ret2);
		UTF8Encoding uTF8Encoding = new UTF8Encoding();
		ret = uTF8Encoding.GetString(ret2, 0, ret2.Length);
	}

	public static void Decrypt(string fullkey, byte[] data, out byte[] ret)
	{
		byte[] array = HexStringToByteArray(fullkey);
		byte[] array2 = new byte[16];
		byte[] array3 = new byte[16];
		for (int i = 0; i < 16; i++)
		{
			array2[i] = array[i];
			array3[i] = array[i + 16];
		}
		SymmetricKeyAlgorithmProvider val = SymmetricKeyAlgorithmProvider.OpenAlgorithm("AES_CBC_PKCS7");
		IBuffer val2 = CryptographicBuffer.CreateFromByteArray(array2);
		CryptographicKey val3 = val.CreateSymmetricKey(val2);
		IBuffer val4 = CryptographicBuffer.CreateFromByteArray(array3);
		IBuffer val5 = CryptographicBuffer.CreateFromByteArray(data);
		IBuffer val6 = CryptographicEngine.Decrypt(val3, val5, val4);
		ret = HexStringToByteArray(CryptographicBuffer.EncodeToHexString(val6));
	}

	public static string[] Split(string input, char delimiter = ',')
	{
		char[] separator = new char[1] { delimiter };
		return input.Split(separator);
	}

	internal static string ToFirstCharUpper(string str)
	{
		if (string.IsNullOrEmpty(str))
		{
			return null;
		}
		string text = str;
		text = text.ToLower();
		char c = char.ToUpper(text[0]);
		text = text.Remove(0, 1);
		return text.Insert(0, c.ToString());
	}

	internal static void GetPhotoSizeByRatio(int width, int height, ref int newWidth, ref int newHeight)
	{
		if (width <= newWidth && height <= newHeight)
		{
			newWidth = width;
			newHeight = height;
		}
		else if (width < height)
		{
			newWidth = newHeight * width / height;
		}
		else
		{
			newHeight = newWidth * height / width;
		}
	}

	public static void DeleteDirectory(string path)
	{
	}

	public static void SaveImageToMediaLibrary(string fileName)
	{
	}

	public static void SaveFileToShellContent(string sourceFile, string name)
	{
	}

	public static void SaveToJpeg(string fileName, BitmapImage img, int width, int height)
	{
		_ = ApplicationData.Current.LocalFolder;
	}

	public static void SaveToJpeg(string fileName, WriteableBitmap wb, int width, int height)
	{
	}

	public static BitmapImage LoadJpeg(string fileName)
	{
		return null;
	}

	public static async Task<byte[]> FileToByteArray(string fileName)
	{
		StorageFolder localfolder = ApplicationData.Current.LocalFolder;
		StorageFile file = await localfolder.GetFileAsync(fileName);
		await file.OpenAsync((FileAccessMode)0);
		return (await FileIO.ReadBufferAsync((IStorageFile)(object)file)).ToArray();
	}

	public static async Task<byte[]> FileToByteArray(StorageFile file)
	{
		return (await FileIO.ReadBufferAsync((IStorageFile)(object)file)).ToArray();
	}

	public static async Task<StorageFile> SaveByteAsFile(string fileName, byte[] inputBuffer)
	{
		if (inputBuffer == null)
		{
			return null;
		}
		StorageFolder localfolder = ApplicationData.Current.LocalFolder;
		string[] path = fileName.Split(new string[1] { "\\" }, StringSplitOptions.None);
		StorageFile file;
		if (path.Length > 1)
		{
			string dir = fileName.Replace("\\" + path[path.Length - 1], "");
			StorageFolder folder = await IsFolderExist(dir);
			if (folder == null)
			{
				folder = await localfolder.CreateFolderAsync(dir, (CreationCollisionOption)3);
			}
			file = await folder.CreateFileAsync(path[path.Length - 1], (CreationCollisionOption)1);
		}
		else
		{
			file = await localfolder.CreateFileAsync(fileName, (CreationCollisionOption)1);
		}
		await FileIO.WriteBytesAsync((IStorageFile)(object)file, inputBuffer);
		return file;
	}

	public static async void SaveStreamAsFile(string filename, Stream inputStream)
	{
		if (inputStream != null && filename != null)
		{
			StorageFolder localfolder = ApplicationData.Current.LocalFolder;
			StorageFile file = await localfolder.CreateFileAsync(filename, (CreationCollisionOption)1);
			byte[] inputBuffer = new byte[inputStream.Length];
			inputStream.Read(inputBuffer, 0, (int)inputStream.Length);
			await FileIO.WriteBytesAsync((IStorageFile)(object)file, inputBuffer);
		}
	}

	internal static void ShowSystemTrayProgress(Page page, string text, bool isIndeterminate = true)
	{
	}

	internal static void HideSystemTrayProgress(Page page, bool HideProgressOnly = false)
	{
	}

	public static async Task<Stream> OpenFileAsStream(string filename)
	{
		StorageFolder localfolder = ApplicationData.Current.LocalFolder;
		return ((IInputStream)(object)(await (await localfolder.GetFileAsync(filename)).OpenAsync((FileAccessMode)0))).AsStreamForRead();
	}

	public static CompositeTransform GetCompositeTransform(UIElement element)
	{
		//IL_001d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0023: Expected O, but got Unknown
		if (element == null)
		{
			return null;
		}
		Transform renderTransform = element.RenderTransform;
		CompositeTransform val = null;
		if (renderTransform is CompositeTransform)
		{
			return (CompositeTransform)(object)((renderTransform is CompositeTransform) ? renderTransform : null);
		}
		val = new CompositeTransform();
		element.put_RenderTransform((Transform)(object)val);
		return val;
	}

	public static ScrollViewer GetScrollViewer(ListBox target)
	{
		DependencyObject child = VisualTreeHelper.GetChild((DependencyObject)(object)target, 0);
		FrameworkElement val = (FrameworkElement)(object)((child is FrameworkElement) ? child : null);
		object obj = val.FindName("ScrollViewer");
		return (ScrollViewer)((obj is ScrollViewer) ? obj : null);
	}

	public static bool IsDarkTheme()
	{
		return true;
	}

	internal static string GetPlatformName()
	{
		return "Windows";
	}

	public static async Task<string> GetDeviceUniqueID()
	{
		StorageFolder folder = ApplicationData.Current.LocalFolder;
		StorageFile file = await (await folder.CreateFolderAsync("ChatON", (CreationCollisionOption)3)).CreateFileAsync("guid.txt", (CreationCollisionOption)3);
		if (string.IsNullOrEmpty(ChatOnService.Instance.TempGuid))
		{
			string id = await FileIOHelper.ReadGuidfromFiles(file);
			if (string.IsNullOrEmpty(id))
			{
				string text = Guid.NewGuid().ToString().Replace("-", "");
				text = text.Replace("{", "");
				text = text.Replace("}", "");
				ChatOnService.Instance.TempGuid = "MSWP12345678" + text;
				FileIOHelper.WriteToFiles(file, ChatOnService.Instance.TempGuid);
			}
			else
			{
				ChatOnService.Instance.TempGuid = id;
			}
		}
		return ChatOnService.Instance.TempGuid;
	}

	public static async Task FindDeviceInfo()
	{
		if (GetDeviceName() != "Windows8")
		{
			return;
		}
		string[] properties = new string[5] { "System.ItemNameDisplay", "System.Devices.ModelName", "System.Devices.Connected", "System.Devices.LocalMachine", "System.Devices.ModelNumber" };
		foreach (PnpObject item in (IEnumerable<PnpObject>)(await PnpObject.FindAllAsync((PnpObjectType)2, (IEnumerable<string>)properties)))
		{
			if ((bool)item.Properties["System.Devices.LocalMachine"])
			{
				string value = (string)item.Properties["System.Devices.ModelName"];
				IsoSettingHelper.Set("DeviceName", value);
				break;
			}
		}
	}

	internal static string GetDeviceName()
	{
		string text = IsoSettingHelper.Get<string>("DeviceName", null);
		if (!string.IsNullOrEmpty(text))
		{
			return text;
		}
		return "Windows8";
	}

	internal static string GetDeviceManufacturer()
	{
		return "Samsung";
	}

	internal static string GetDeviceFirmwareVersion()
	{
		return "";
	}

	internal static string GetOSVersion()
	{
		return "8.0";
	}

	public static async Task<Uri> GetLocalImageAsync(Uri internetUri, string uniqueName)
	{
		try
		{
			using WebResponse response = await WebRequest.CreateHttp(internetUri).GetResponseAsync().ConfigureAwait(continueOnCapturedContext: false);
			Stream stream = response.GetResponseStream();
			string desiredName = $"{uniqueName}.jpg";
			using (Stream filestream = await ((IStorageFile)(object)(await ApplicationData.Current.LocalFolder.CreateFileAsync(desiredName, (CreationCollisionOption)1))).OpenStreamForWriteAsync().ConfigureAwait(continueOnCapturedContext: false))
			{
				await stream.CopyToAsync(filestream).ConfigureAwait(continueOnCapturedContext: false);
				await filestream.FlushAsync().ConfigureAwait(continueOnCapturedContext: false);
			}
			return new Uri($"ms-appdata:///local/{uniqueName}.jpg", UriKind.Absolute);
		}
		catch (Exception)
		{
		}
		return null;
	}

	internal static async Task<bool> FilesAreEqual(Uri first, Uri second)
	{
		try
		{
			StorageFile firstFile = await StorageFile.GetFileFromApplicationUriAsync(first);
			StorageFile secondFile = await StorageFile.GetFileFromApplicationUriAsync(second);
			using (Stream firstStream = await ((IStorageFile)(object)firstFile).OpenStreamForReadAsync())
			{
				using Stream secondStream = await ((IStorageFile)(object)secondFile).OpenStreamForReadAsync();
				if (firstStream.Length != secondStream.Length)
				{
					return false;
				}
				int num = (int)Math.Ceiling((double)secondStream.Length / 8.0);
				byte[] array = new byte[8];
				byte[] array2 = new byte[8];
				for (int i = 0; i < num; i++)
				{
					firstStream.Read(array, 0, 8);
					secondStream.Read(array2, 0, 8);
					if (BitConverter.ToInt64(array, 0) != BitConverter.ToInt64(array2, 0))
					{
						return false;
					}
				}
			}
			return true;
		}
		catch (Exception)
		{
			return false;
		}
	}

	internal static string GetAssemblyVersion()
	{
		return "2.1.5";
	}

	public static WriteableBitmap RotateWriteableBitmap(WriteableBitmap source)
	{
		return null;
	}

	public static WriteableBitmap CropWriteableBitmap(WriteableBitmap source, int x, int y, int width, int height)
	{
		return null;
	}

	public static WriteableBitmap ResizeByRatioWriteableBitmap(BitmapSource source, double maxPixelValue, double width = 0.0, double height = 0.0, bool isStretch = false)
	{
		return null;
	}

	public static void UpdateMainTileCount(int count)
	{
		//IL_0012: Unknown result type (might be due to invalid IL or missing references)
		//IL_0018: Expected O, but got Unknown
		//IL_002b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0031: Expected O, but got Unknown
		XmlDocument templateContent = BadgeUpdateManager.GetTemplateContent((BadgeTemplateType)1);
		XmlElement val = (XmlElement)templateContent.SelectSingleNode("/badge");
		val.SetAttribute("value", count.ToString());
		BadgeNotification val2 = new BadgeNotification(templateContent);
		BadgeUpdateManager.CreateBadgeUpdaterForApplication().Update(val2);
	}

	public static async Task ClearTileInformation()
	{
		TileUpdateManager.CreateTileUpdaterForApplication().Clear();
	}

	public static async Task DeleteAllTile()
	{
		foreach (SecondaryTile tile in await SecondaryTile.FindAllAsync())
		{
			if (SecondaryTile.Exists(tile.TileId))
			{
				SecondaryTile tileToBeDeleted = new SecondaryTile(tile.TileId);
				bool result = false;
				while (!result)
				{
					result = await tileToBeDeleted.RequestDeleteAsync();
				}
			}
		}
	}

	public static string GetFileNameFromUri(string Uri)
	{
		string text = "/?.";
		char[] separator = text.ToCharArray();
		string[] array = Uri.Split(separator);
		string result = "";
		for (int i = 0; i < array.Length; i++)
		{
			if (array[i].ToLower().Equals("mp4") || array[i].ToLower().Equals("jpg") || array[i].ToLower().Equals("jpeg") || array[i].ToLower().Equals("png") || array[i].ToLower().Equals("bmp") || array[i].ToLower().Equals("tif") || array[i].ToLower().Equals("tiff") || array[i].ToLower().Equals("3gp") || array[i].ToLower().Equals("gif"))
			{
				result = array[i - 1] + "." + array[i];
			}
		}
		return result;
	}

	internal static string sprintf(string fmt, params object[] args)
	{
		StringBuilder stringBuilder = new StringBuilder();
		int num = 0;
		int num2 = 0;
		while (num < fmt.Length)
		{
			if (fmt[num] == '%')
			{
				num++;
				int num3 = 0;
				int num4 = 6;
				int num5 = 0;
				for (; char.IsNumber(fmt[num]); num++)
				{
					num5 = 10 * num5 + int.Parse(fmt[num].ToString(), CultureInfo.InvariantCulture);
				}
				num3 = num5;
				if (fmt[num] == '.')
				{
					num++;
					num5 = 0;
					for (; char.IsNumber(fmt[num]); num++)
					{
						num5 = 10 * num5 + int.Parse(fmt[num].ToString(), CultureInfo.InvariantCulture);
					}
					num4 = num5;
				}
				if (fmt[num] == 'l')
				{
					_ = fmt[num];
					num++;
				}
				switch (fmt[num])
				{
				case 'd':
					stringBuilder.Append(((int)args[num2]).ToString(CultureInfo.InvariantCulture));
					num2++;
					break;
				case 'e':
				case 'g':
					stringBuilder.Append(((double)args[num2]).ToString("r", CultureInfo.InvariantCulture).ToLowerInvariant());
					num2++;
					break;
				case 's':
					stringBuilder.Append(args[num2]);
					num2++;
					break;
				case 'c':
					stringBuilder.Append((char)args[num2]);
					num2++;
					break;
				case 'X':
				case 'x':
					stringBuilder.Append(((int)args[num2]).ToString("x", CultureInfo.InvariantCulture));
					num2++;
					break;
				case '%':
					stringBuilder.Append("%");
					break;
				case 'f':
				{
					string text = ((double)args[num2]).ToString("f" + num4.ToString(CultureInfo.InvariantCulture), CultureInfo.InvariantCulture);
					int num6 = num3 - text.Length;
					if (num6 > 0)
					{
						stringBuilder.Append(' ', num6);
					}
					stringBuilder.Append(text);
					break;
				}
				}
				num++;
			}
			else
			{
				stringBuilder.Append(fmt[num]);
				num++;
			}
		}
		return stringBuilder.ToString();
	}

	internal static string GetFacebookLogoutUrl(string html)
	{
		return string.Empty;
	}

	public static async Task<StorageFile> IsFileExist(string name)
	{
		string folderName = "";
		string fileName = name;
		if (name.Contains("\\"))
		{
			string[] array = Split(name, '\\');
			folderName = array[0];
			fileName = array[1];
		}
		StorageFolder localFolder = ApplicationData.Current.LocalFolder;
		if (!string.IsNullOrEmpty(folderName))
		{
			return await IsFileExist(folderName, fileName);
		}
		return await IsFileExist(localFolder, name);
	}

	public static async Task<StorageFile> IsFileExist(string folderPath, string name)
	{
		StorageFolder folder;
		string[] array = default(string[]);
		int num2 = default(int);
		if (folderPath.Contains("\\"))
		{
			string[] p = Split(folderPath, '\\');
			folder = ApplicationData.Current.LocalFolder;
			int num = default(int);
			if (num == 0)
			{
				goto IL_0099;
			}
			array = p;
			num2 = 0;
			goto IL_0151;
		}
		folder = await IsFolderExist(folderPath);
		if (folder == null)
		{
			return null;
		}
		goto IL_0256;
		IL_0151:
		string f = default(string);
		StorageFolder currentFolder = default(StorageFolder);
		if (num2 < array.Length)
		{
			f = array[num2];
			currentFolder = null;
			goto IL_0099;
		}
		if (1 == 0)
		{
		}
		goto IL_0256;
		IL_0256:
		return await IsFileExist(folder, name);
		IL_0099:
		try
		{
			currentFolder = await folder.GetFolderAsync(f);
		}
		catch
		{
		}
		if (currentFolder == null)
		{
			return null;
		}
		folder = currentFolder;
		num2++;
		goto IL_0151;
	}

	public static async Task<StorageFile> IsFileExistCheck(string folderPath, string name)
	{
		StorageFolder folder;
		string[] array = default(string[]);
		int num2 = default(int);
		if (folderPath.Contains("\\"))
		{
			string[] p = Split(folderPath, '\\');
			folder = ApplicationData.Current.LocalFolder;
			int num = default(int);
			if (num == 0)
			{
				goto IL_0099;
			}
			array = p;
			num2 = 0;
			goto IL_0151;
		}
		folder = await IsFolderExist(folderPath);
		if (folder == null)
		{
			return null;
		}
		goto IL_0256;
		IL_0151:
		string f = default(string);
		StorageFolder currentFolder = default(StorageFolder);
		if (num2 < array.Length)
		{
			f = array[num2];
			currentFolder = null;
			goto IL_0099;
		}
		if (1 == 0)
		{
		}
		goto IL_0256;
		IL_0256:
		return await IsFileExistCheck(folder, name);
		IL_0099:
		try
		{
			currentFolder = await folder.GetFolderAsync(f);
		}
		catch
		{
		}
		if (currentFolder == null)
		{
			return null;
		}
		folder = currentFolder;
		num2++;
		goto IL_0151;
	}

	public static async Task<StorageFile> IsFileExist(StorageFolder folder, string name)
	{
		StorageFile file = null;
		try
		{
			file = await folder.GetFileAsync(name);
		}
		catch
		{
		}
		return file;
	}

	public static async Task<StorageFile> IsFileExistCheck(StorageFolder folder, string name)
	{
		StorageFile file = null;
		try
		{
			file = await folder.GetFileAsync(name);
			if ((await file.GetBasicPropertiesAsync()).Size == 0)
			{
				return null;
			}
		}
		catch
		{
		}
		return file;
	}

	public static async Task<StorageFolder> IsFolderExist(string name)
	{
		StorageFolder localFolder = ApplicationData.Current.LocalFolder;
		StorageFolder folder = null;
		try
		{
			folder = await localFolder.GetFolderAsync(name);
		}
		catch
		{
		}
		return folder;
	}

	public static async Task DeleteFile(string name, string folderName = "")
	{
		try
		{
			StorageFolder folder = ((!(folderName == "")) ? (await IsFolderExist(folderName)) : ApplicationData.Current.LocalFolder);
			if (folder != null)
			{
				StorageFile file = await IsFileExist(folder, name);
				if (file != null)
				{
					await file.DeleteAsync();
				}
			}
		}
		catch
		{
		}
	}

	public static async Task DeleteFileFromLocalUri(Uri uri)
	{
		int num = default(int);
		_ = num;
		_ = 0;
		try
		{
			(await StorageFile.GetFileFromApplicationUriAsync(uri)).DeleteAsync();
		}
		catch (Exception)
		{
		}
	}

	public static async Task DeleteFolder(string folderName)
	{
		try
		{
			StorageFolder folder = await IsFolderExist(folderName);
			if (folder != null)
			{
				await folder.DeleteAsync((StorageDeleteOption)1);
			}
		}
		catch
		{
		}
	}

	public static async Task SaveImageFromWeb(IStorageFile file, Uri uri)
	{
		using HttpClient client = new HttpClient();
		try
		{
			await FileIO.WriteBytesAsync(file, await client.GetByteArrayAsync(uri));
		}
		catch (Exception ex)
		{
			if (ex is WebException { Response: not null } ex2)
			{
				SSMService.GetServerErrorMessage(ex2);
			}
		}
	}

	public static async Task<BitmapImage> LoadOrSaveWebImage(string filePath, Uri uri)
	{
		string[] path = Split(filePath, '\\');
		string folderName = "";
		string fileName = filePath;
		if (path.Length >= 2)
		{
			if (!string.IsNullOrEmpty(path[0]))
			{
				folderName = path[0];
			}
			fileName = path[1];
		}
		return await LoadOrSaveWebImage(fileName, uri, folderName);
	}

	public static async Task<BitmapImage> LoadOrSaveWebImage(string fileName, Uri uri, string folderPath, bool forceUpdate = false)
	{
		BitmapImage img = new BitmapImage();
		bool download = false;
		StorageFile file = await IsFileExist(folderPath, fileName);
		if (file == null)
		{
			download = true;
		}
		else if ((await file.GetBasicPropertiesAsync()).Size == 0 || forceUpdate)
		{
			download = true;
			await file.DeleteAsync();
		}
		if (download)
		{
			file = await CreateLocalFile(fileName, folderPath, replaceExisting: true);
			await SaveImageFromWeb((IStorageFile)(object)file, uri);
			if ((await file.GetBasicPropertiesAsync()).Size == 0)
			{
				await file.DeleteAsync();
				return null;
			}
		}
		try
		{
			IRandomAccessStream fs = await file.OpenAsync((FileAccessMode)0);
			if (fs == null)
			{
				return null;
			}
			((BitmapSource)img).SetSource(fs);
			return img;
		}
		catch (Exception)
		{
			return null;
		}
	}

	public static async Task<StorageFile> LoadOrSaveWebImage2(string fileName, Uri uri, string folderPath)
	{
		bool download = false;
		StorageFile file = await IsFileExist(folderPath, fileName);
		if (file == null)
		{
			download = true;
		}
		else if ((await file.GetBasicPropertiesAsync()).Size == 0)
		{
			download = true;
			await file.DeleteAsync();
		}
		if (download)
		{
			file = await CreateLocalFile(fileName, folderPath);
			await SaveImageFromWeb((IStorageFile)(object)file, uri);
		}
		return file;
	}

	public static async Task<StorageFile> LoadOrSaveWebImage3(string fileName, Uri uri, string folderPath)
	{
		bool download = false;
		StorageFile file = await IsFileExist(folderPath, fileName);
		if (file == null)
		{
			download = true;
		}
		else if ((await file.GetBasicPropertiesAsync()).Size == 0)
		{
			download = true;
			await file.DeleteAsync();
		}
		if (download)
		{
			file = await CreateLocalFile(fileName, folderPath);
			await SaveImageFromWeb((IStorageFile)(object)file, uri);
		}
		return file;
	}

	public static async Task<StorageFile> CreateLocalFile(string fileName, string folderPath, bool replaceExisting = false)
	{
		StorageFolder localFolder = ApplicationData.Current.LocalFolder;
		StorageFolder folder;
		if (folderPath.Contains("\\"))
		{
			string[] p = Split(folderPath, '\\');
			folder = localFolder;
			int num = default(int);
			string[] array = default(string[]);
			int num2 = default(int);
			StorageFolder currentFolder = default(StorageFolder);
			string f = default(string);
			switch (num)
			{
			default:
				array = p;
				num2 = 0;
				goto IL_01f3;
			case 0:
				try
				{
					currentFolder = await folder.GetFolderAsync(f);
				}
				catch
				{
				}
				if (currentFolder == null)
				{
					goto case 1;
				}
				folder = currentFolder;
				goto IL_01e5;
			case 1:
				{
					folder = await folder.CreateFolderAsync(f, (CreationCollisionOption)3);
					goto IL_01e5;
				}
				IL_01f3:
				if (num2 >= array.Length)
				{
					break;
				}
				f = array[num2];
				currentFolder = null;
				goto case 0;
				IL_01e5:
				num2++;
				goto IL_01f3;
			}
			if (1 == 0)
			{
			}
		}
		else if (string.IsNullOrEmpty(folderPath))
		{
			folder = localFolder;
		}
		else
		{
			folder = await IsFolderExist(folderPath);
			if (folder == null)
			{
				folder = await localFolder.CreateFolderAsync(folderPath, (CreationCollisionOption)3);
			}
		}
		StorageFile file = await IsFileExist(folder, fileName);
		if (replaceExisting && file != null)
		{
			await file.DeleteAsync();
			file = null;
		}
		if (file == null)
		{
			file = await folder.CreateFileAsync(fileName, (CreationCollisionOption)3);
		}
		return file;
	}

	public static async Task<BitmapImage> LoadImage(string fileName, string folderName = "")
	{
		BitmapImage img = new BitmapImage();
		StorageFolder localFolder = ApplicationData.Current.LocalFolder;
		StorageFolder folder;
		if (string.IsNullOrEmpty(folderName))
		{
			folder = localFolder;
		}
		else
		{
			folder = await IsFolderExist(folderName);
			if (folder == null)
			{
				return null;
			}
		}
		StorageFile file = await IsFileExist(folder, fileName);
		if (file == null)
		{
			return null;
		}
		((BitmapSource)img).SetSource(await file.OpenAsync((FileAccessMode)0));
		return img;
	}

	public static async Task<StorageFile> CopyFileAsync(string prevFileName, string newFilename)
	{
		StorageFolder localFolder = ApplicationData.Current.LocalFolder;
		StorageFile prevFile = null;
		try
		{
			prevFile = await localFolder.GetFileAsync(prevFileName);
		}
		catch
		{
		}
		if (prevFile == null)
		{
			return null;
		}
		return await prevFile.CopyAsync((IStorageFolder)(object)localFolder, newFilename, (NameCollisionOption)2);
	}

	public static async Task<StorageFile> CopyFileAsync(StorageFile file, string fileName, string folderName = "")
	{
		StorageFolder localFolder = ApplicationData.Current.LocalFolder;
		StorageFolder folder;
		if (string.IsNullOrEmpty(folderName))
		{
			folder = localFolder;
		}
		else
		{
			folder = await IsFolderExist(folderName);
			if (folder == null)
			{
				folder = await localFolder.CreateFolderAsync(folderName, (CreationCollisionOption)3);
			}
		}
		return await file.CopyAsync((IStorageFolder)(object)folder, fileName, (NameCollisionOption)1);
	}

	public static async Task<StorageFile> CreateVideoThumbnail(StorageFile s, string name, string folder, ThumbnailMode mode)
	{
		//IL_001a: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Unknown result type (might be due to invalid IL or missing references)
		StorageItemThumbnail thumbnail = await s.GetThumbnailAsync(mode);
		if (thumbnail == null)
		{
			return null;
		}
		StorageFile newFile = await CreateLocalFile(name, folder);
		DataReader reader = new DataReader((IInputStream)(object)thumbnail);
		try
		{
			await (IAsyncOperation<uint>)(object)reader.LoadAsync((uint)thumbnail.Size);
			IBuffer buffer = reader.ReadBuffer((uint)thumbnail.Size);
			await FileIO.WriteBufferAsync((IStorageFile)(object)newFile, buffer);
		}
		finally
		{
			((IDisposable)reader)?.Dispose();
		}
		return newFile;
	}

	public static async Task<StorageFile> CreateVideoThumbnail2(StorageFile s, string name, string folder, ThumbnailMode mode)
	{
		//IL_001a: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Unknown result type (might be due to invalid IL or missing references)
		StorageItemThumbnail thumbnail = await s.GetThumbnailAsync(mode);
		if (thumbnail == null)
		{
			return null;
		}
		StorageFile newFile = await CreateLocalFile(name.Substring(0, name.Length - 4) + "tempvid.jpg", folder);
		DataReader reader = new DataReader((IInputStream)(object)thumbnail);
		try
		{
			await (IAsyncOperation<uint>)(object)reader.LoadAsync((uint)thumbnail.Size);
			IBuffer buffer = reader.ReadBuffer((uint)thumbnail.Size);
			await FileIO.WriteBufferAsync((IStorageFile)(object)newFile, buffer);
		}
		finally
		{
			((IDisposable)reader)?.Dispose();
		}
		StorageFile newFile2 = await CreateLocalFile(name.Substring(0, name.Length - 4) + "temp.jpg", folder);
		StorageFile FileResult = await CreateLocalFile(name, folder);
		IRandomAccessStream _fileStream = await newFile.OpenAsync((FileAccessMode)0);
		BitmapDecoder decoder = await BitmapDecoder.CreateAsync(_fileStream);
		byte[] pixels = (await decoder.GetPixelDataAsync()).DetachPixelData();
		uint fileSize;
		byte[] newPixels;
		if (decoder.OrientedPixelHeight > decoder.OrientedPixelWidth)
		{
			fileSize = decoder.OrientedPixelWidth;
			int num = (int)((decoder.OrientedPixelHeight - decoder.OrientedPixelWidth) / 2 - 1);
			newPixels = new byte[fileSize * fileSize * 4];
			int num2 = 0;
			for (int i = 0; i < decoder.OrientedPixelHeight; i++)
			{
				if (i > num && i < num + decoder.OrientedPixelWidth + 1)
				{
					for (int j = 0; j < decoder.OrientedPixelWidth; j++)
					{
						newPixels[num2] = pixels[i * decoder.OrientedPixelWidth * 4 + j * 4];
						num2++;
						newPixels[num2] = pixels[i * decoder.OrientedPixelWidth * 4 + j * 4 + 1];
						num2++;
						newPixels[num2] = pixels[i * decoder.OrientedPixelWidth * 4 + j * 4 + 2];
						num2++;
						newPixels[num2] = pixels[i * decoder.OrientedPixelWidth * 4 + j * 4 + 3];
						num2++;
					}
				}
			}
		}
		else
		{
			fileSize = decoder.OrientedPixelHeight;
			int num3 = (int)((decoder.OrientedPixelWidth - decoder.OrientedPixelHeight) / 2 - 1);
			newPixels = new byte[fileSize * fileSize * 4];
			int num4 = 0;
			for (int k = 0; k < decoder.OrientedPixelHeight; k++)
			{
				for (int l = 0; l < decoder.OrientedPixelWidth; l++)
				{
					if (l > num3 && l < num3 + decoder.OrientedPixelHeight + 1)
					{
						newPixels[num4] = pixels[k * decoder.OrientedPixelWidth * 4 + l * 4];
						num4++;
						newPixels[num4] = pixels[k * decoder.OrientedPixelWidth * 4 + l * 4 + 1];
						num4++;
						newPixels[num4] = pixels[k * decoder.OrientedPixelWidth * 4 + l * 4 + 2];
						num4++;
						newPixels[num4] = pixels[k * decoder.OrientedPixelWidth * 4 + l * 4 + 3];
						num4++;
					}
				}
			}
		}
		IRandomAccessStream stream = await newFile2.OpenAsync((FileAccessMode)1);
		BitmapEncoder encoder = await BitmapEncoder.CreateAsync(BitmapEncoder.JpegEncoderId, stream);
		encoder.SetPixelData(decoder.BitmapPixelFormat, (BitmapAlphaMode)0, fileSize, fileSize, decoder.DpiX, decoder.DpiY, newPixels);
		await encoder.FlushAsync();
		await ((IOutputStream)stream).FlushAsync();
		((IDisposable)stream).Dispose();
		((IDisposable)_fileStream).Dispose();
		decoder = await BitmapDecoder.CreateAsync(await newFile2.OpenAsync((FileAccessMode)0));
		BitmapTransform val = new BitmapTransform();
		val.put_ScaledHeight(239u);
		val.put_ScaledWidth(239u);
		BitmapTransform transform = val;
		PixelDataProvider pixelData = await decoder.GetPixelDataAsync(decoder.BitmapPixelFormat, (BitmapAlphaMode)1, transform, (ExifOrientationMode)1, (ColorManagementMode)0);
		IRandomAccessStream destinationStream = await FileResult.OpenAsync((FileAccessMode)1);
		try
		{
			encoder = await BitmapEncoder.CreateAsync(BitmapEncoder.PngEncoderId, destinationStream);
			encoder.SetPixelData(decoder.BitmapPixelFormat, (BitmapAlphaMode)0, 239u, 239u, decoder.DpiX, decoder.DpiY, pixelData.DetachPixelData());
			await encoder.FlushAsync();
		}
		finally
		{
			((IDisposable)destinationStream)?.Dispose();
		}
		await newFile.DeleteAsync();
		await newFile2.DeleteAsync();
		return FileResult;
	}

	public static async Task<StorageFile> CreateImageThumbnail(StorageFile s, string name, string folder, ThumbnailMode mode)
	{
		StorageFile newFile = await CreateLocalFile(name.Substring(0, name.Length - 4) + "temp.jpg", folder);
		StorageFile FileResult = await CreateLocalFile(name, folder);
		IRandomAccessStream _fileStream = await s.OpenAsync((FileAccessMode)0);
		BitmapDecoder decoder = await BitmapDecoder.CreateAsync(_fileStream);
		byte[] pixels = (await decoder.GetPixelDataAsync()).DetachPixelData();
		uint fileSize;
		byte[] newPixels;
		if (decoder.OrientedPixelHeight > decoder.OrientedPixelWidth)
		{
			fileSize = decoder.OrientedPixelWidth;
			int num = (int)((decoder.OrientedPixelHeight - decoder.OrientedPixelWidth) / 2 - 1);
			newPixels = new byte[fileSize * fileSize * 4];
			int num2 = 0;
			for (int i = 0; i < decoder.OrientedPixelHeight; i++)
			{
				if (i > num && i < num + decoder.OrientedPixelWidth + 1)
				{
					for (int j = 0; j < decoder.OrientedPixelWidth; j++)
					{
						newPixels[num2] = pixels[i * decoder.OrientedPixelWidth * 4 + j * 4];
						num2++;
						newPixels[num2] = pixels[i * decoder.OrientedPixelWidth * 4 + j * 4 + 1];
						num2++;
						newPixels[num2] = pixels[i * decoder.OrientedPixelWidth * 4 + j * 4 + 2];
						num2++;
						newPixels[num2] = pixels[i * decoder.OrientedPixelWidth * 4 + j * 4 + 3];
						num2++;
					}
				}
			}
		}
		else
		{
			fileSize = decoder.OrientedPixelHeight;
			int num3 = (int)((decoder.OrientedPixelWidth - decoder.OrientedPixelHeight) / 2 - 1);
			newPixels = new byte[fileSize * fileSize * 4];
			int num4 = 0;
			for (int k = 0; k < decoder.OrientedPixelHeight; k++)
			{
				for (int l = 0; l < decoder.OrientedPixelWidth; l++)
				{
					if (l > num3 && l < num3 + decoder.OrientedPixelHeight + 1)
					{
						newPixels[num4] = pixels[k * decoder.OrientedPixelWidth * 4 + l * 4];
						num4++;
						newPixels[num4] = pixels[k * decoder.OrientedPixelWidth * 4 + l * 4 + 1];
						num4++;
						newPixels[num4] = pixels[k * decoder.OrientedPixelWidth * 4 + l * 4 + 2];
						num4++;
						newPixels[num4] = pixels[k * decoder.OrientedPixelWidth * 4 + l * 4 + 3];
						num4++;
					}
				}
			}
		}
		IRandomAccessStream stream = await newFile.OpenAsync((FileAccessMode)1);
		BitmapEncoder encoder = await BitmapEncoder.CreateAsync(BitmapEncoder.JpegEncoderId, stream);
		encoder.SetPixelData(decoder.BitmapPixelFormat, (BitmapAlphaMode)0, fileSize, fileSize, decoder.DpiX, decoder.DpiY, newPixels);
		await encoder.FlushAsync();
		await ((IOutputStream)stream).FlushAsync();
		((IDisposable)stream).Dispose();
		((IDisposable)_fileStream).Dispose();
		decoder = await BitmapDecoder.CreateAsync(await newFile.OpenAsync((FileAccessMode)0));
		BitmapTransform val = new BitmapTransform();
		val.put_ScaledHeight(239u);
		val.put_ScaledWidth(239u);
		BitmapTransform transform = val;
		PixelDataProvider pixelData = await decoder.GetPixelDataAsync(decoder.BitmapPixelFormat, (BitmapAlphaMode)1, transform, (ExifOrientationMode)1, (ColorManagementMode)0);
		IRandomAccessStream destinationStream = await FileResult.OpenAsync((FileAccessMode)1);
		try
		{
			encoder = await BitmapEncoder.CreateAsync(BitmapEncoder.PngEncoderId, destinationStream);
			encoder.SetPixelData(decoder.BitmapPixelFormat, (BitmapAlphaMode)0, 239u, 239u, decoder.DpiX, decoder.DpiY, pixelData.DetachPixelData());
			await encoder.FlushAsync();
		}
		finally
		{
			((IDisposable)destinationStream)?.Dispose();
		}
		await newFile.DeleteAsync();
		return FileResult;
	}

	public static async Task<StorageFile> ResizeImg600x600(StorageFile s)
	{
		IRandomAccessStream _fileStream = await s.OpenAsync((FileAccessMode)0);
		BitmapDecoder decoder = await BitmapDecoder.CreateAsync(_fileStream);
		BitmapTransform val = new BitmapTransform();
		val.put_ScaledHeight(600u);
		val.put_ScaledWidth(600u);
		BitmapTransform transform = val;
		PixelDataProvider pixelData = await decoder.GetPixelDataAsync((BitmapPixelFormat)12, (BitmapAlphaMode)0, transform, (ExifOrientationMode)1, (ColorManagementMode)1);
		IRandomAccessStream destinationStream = await s.OpenAsync((FileAccessMode)1);
		BitmapEncoder encoder = await BitmapEncoder.CreateAsync(BitmapEncoder.JpegEncoderId, destinationStream);
		encoder.SetPixelData((BitmapPixelFormat)12, (BitmapAlphaMode)0, 600u, 600u, decoder.DpiX, decoder.DpiY, pixelData.DetachPixelData());
		await encoder.FlushAsync();
		await ((IOutputStream)destinationStream).FlushAsync();
		((IDisposable)destinationStream).Dispose();
		((IDisposable)_fileStream).Dispose();
		return s;
	}

	internal static string GetNetworkInterfaceType()
	{
		return "WiFi";
	}

	public static Rect GetElementRect(FrameworkElement element)
	{
		GeneralTransform val = ((UIElement)element).TransformToVisual((UIElement)null);
		Point location = val.TransformPoint(default(Point));
		return new Rect(location, new Size(element.ActualWidth, element.ActualHeight));
	}

	public static async Task<bool> ShowCloseMessageDialog(string message, string title = "")
	{
		MessageDialog dialog = ((!(title != "")) ? new MessageDialog(message) : new MessageDialog(message, title));
		MessageDialogCommand command = new MessageDialogCommand(CommandId.NO, GetResourceString("IDS_CHATON_BUTTON_CLOSE"));
		dialog.Commands.Add((IUICommand)(object)command);
		return (CommandId)(await dialog.ShowAsync()).Id == CommandId.OK;
	}

	public static async Task<bool> ShowOKCancleMessageDialog(string message, bool showCancel = true, string title = "")
	{
		MessageDialog dialog = ((!(title != "")) ? new MessageDialog(message) : new MessageDialog(message, title));
		MessageDialogCommand command = new MessageDialogCommand(CommandId.OK, GetResourceString("IDS_CHATON_SK_OK"));
		dialog.Commands.Add((IUICommand)(object)command);
		if (showCancel)
		{
			command = new MessageDialogCommand(CommandId.NO, GetResourceString("IDS_CHATON_BUTTON_CANCEL"));
			dialog.Commands.Add((IUICommand)(object)command);
		}
		return (CommandId)(await dialog.ShowAsync()).Id == CommandId.OK;
	}

	public static async Task<bool> ShowDeleteCancleMessageDialog(string message, bool showCancel = true, string title = "")
	{
		MessageDialog dialog = ((!(title != "")) ? new MessageDialog(message) : new MessageDialog(message, title));
		MessageDialogCommand command = new MessageDialogCommand(CommandId.OK, GetResourceString("IDS_CHATON_OPT_DELETE"));
		dialog.Commands.Add((IUICommand)(object)command);
		if (showCancel)
		{
			command = new MessageDialogCommand(CommandId.NO, GetResourceString("IDS_CHATON_BUTTON_CANCEL"));
			dialog.Commands.Add((IUICommand)(object)command);
		}
		return (CommandId)(await dialog.ShowAsync()).Id == CommandId.OK;
	}

	public static async Task<bool> ShowRetryCancleMessageDialog(string message, bool showCancel = true, string title = "")
	{
		MessageDialog dialog = ((!(title != "")) ? new MessageDialog(message) : new MessageDialog(message, title));
		MessageDialogCommand command = new MessageDialogCommand(CommandId.OK, GetResourceString("IDS_CHATON_BUTTON_RETRY"));
		dialog.Commands.Add((IUICommand)(object)command);
		if (showCancel)
		{
			command = new MessageDialogCommand(CommandId.NO, GetResourceString("IDS_CHATON_BUTTON_CANCEL"));
			dialog.Commands.Add((IUICommand)(object)command);
		}
		return (CommandId)(await dialog.ShowAsync()).Id == CommandId.OK;
	}

	public static async Task<bool> ShowSingleCustomMessageBox(string message, string title = "", string button1Text = "OK")
	{
		MessageDialog dialog = ((!(title != "")) ? new MessageDialog(message) : new MessageDialog(message, title));
		MessageDialogCommand command = new MessageDialogCommand(CommandId.OK, button1Text);
		dialog.Commands.Add((IUICommand)(object)command);
		return (CommandId)(await dialog.ShowAsync()).Id == CommandId.OK;
	}

	public static string GetLanguageParam()
	{
		string name = CultureInfo.CurrentUICulture.Name;
		return name.Replace('-', '_');
	}

	public static void OpenContactUs()
	{
		string languageParam = GetLanguageParam();
		SSMServer serverInfo = SSMService.GetServerInfo();
		string input = serverInfo.ContactServer.ToString() + "-" + serverInfo.FileServer.ToString() + "-" + serverInfo.MsgServer.ToString() + "-" + serverInfo.SMSServer.ToString();
		languageParam = languageParam.Replace('-', '_');
		string uriString = "http://smm.samsung.com/mwv/voc.html?l=" + languageParam + "&Sender=" + UrlEncrypt(RegistrationService.ChatOnID) + "&Display=" + UrlEncrypt("N/A") + "&Brand=" + UrlEncrypt(GetDeviceManufacturer()) + "&Server=" + UrlEncrypt(input) + "&Connection=" + UrlEncrypt(GetNetworkInterfaceType()) + "&Model=" + UrlEncrypt(GetDeviceName()) + "&Platform=windows%2520mobile&Version=" + UrlEncrypt(GetAssemblyVersion());
		Launcher.LaunchUriAsync(new Uri(uriString));
	}

	public static bool IsEmojiIconIncluded(string str)
	{
		TextElementEnumerator textElementEnumerator = StringInfo.GetTextElementEnumerator(str);
		while (textElementEnumerator.MoveNext())
		{
			string textElement = textElementEnumerator.GetTextElement();
			int num = char.ConvertToUtf32(textElement, 0);
			if ((num >= 127744 && num <= 128591) || (num >= 128640 && num <= 128767) || (num >= 9728 && num <= 9983))
			{
				return true;
			}
		}
		return false;
	}

	public static string RemoveEmoji(string str)
	{
		string text = "";
		TextElementEnumerator textElementEnumerator = StringInfo.GetTextElementEnumerator(str);
		while (textElementEnumerator.MoveNext())
		{
			string textElement = textElementEnumerator.GetTextElement();
			int num = char.ConvertToUtf32(textElement, 0);
			if ((num < 127744 || num > 128591) && (num < 128640 || num > 128767) && (num < 9728 || num > 9983))
			{
				text += textElement;
			}
		}
		return text;
	}

	public static IDictionary<string, string> BuildParameter(string str)
	{
		IDictionary<string, string> dictionary = new Dictionary<string, string>();
		str = str.Replace("?", "");
		string[] array = Split(str, '&');
		string[] array2 = array;
		foreach (string text in array2)
		{
			string[] array3 = Split(text.ToString(), '=');
			dictionary.Add(array3[0].ToString(), array3[1].ToString());
		}
		return dictionary;
	}

	internal static string GetIsoCodeFromCountryName(string countryName)
	{
		return countryName.Substring(countryName.IndexOf('(') + 1, 3);
	}

	public static bool CheckForInternetConnection()
	{
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_000f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Unknown result type (might be due to invalid IL or missing references)
		//IL_0026: Expected I4, but got Unknown
		ConnectionProfile internetConnectionProfile = NetworkInformation.GetInternetConnectionProfile();
		if (internetConnectionProfile != null)
		{
			NetworkConnectivityLevel networkConnectivityLevel = internetConnectionProfile.GetNetworkConnectivityLevel();
			return (int)networkConnectivityLevel switch
			{
				0 => false, 
				1 => false, 
				2 => false, 
				3 => true, 
				_ => false, 
			};
		}
		return false;
	}

	public static int GetCharLength(string input)
	{
		int num = 0;
		char[] array = input.ToCharArray();
		foreach (char c in array)
		{
			int num2 = c;
			num = ((num2 < 65 || num2 > 122) ? (num + 2) : (num + 1));
		}
		return num;
	}

	public static void ShowSimpleToastNotification(string content)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0002: Unknown result type (might be due to invalid IL or missing references)
		//IL_0023: Unknown result type (might be due to invalid IL or missing references)
		//IL_0029: Expected O, but got Unknown
		ToastTemplateType val = (ToastTemplateType)4;
		XmlDocument templateContent = ToastNotificationManager.GetTemplateContent(val);
		XmlNodeList elementsByTagName = templateContent.GetElementsByTagName("text");
		((IXmlNodeSerializer)((IReadOnlyList<IXmlNode>)elementsByTagName)[0]).put_InnerText(content);
		ToastNotification val2 = new ToastNotification(templateContent);
		ToastNotificationManager.CreateToastNotifier().Show(val2);
	}

	public static async Task<IRandomAccessStream> ResizeImage(StorageFile imageStream, uint width, uint height)
	{
		IRandomAccessStream destinationStream = (IRandomAccessStream)new InMemoryRandomAccessStream();
		new WriteableBitmap((int)width, (int)height);
		IRandomAccessStream sourceStream = await imageStream.OpenAsync((FileAccessMode)0);
		try
		{
			BitmapDecoder decoder = await BitmapDecoder.CreateAsync(sourceStream);
			BitmapTransform val = new BitmapTransform();
			val.put_ScaledHeight(height);
			val.put_ScaledWidth(width);
			val.put_InterpolationMode((BitmapInterpolationMode)3);
			BitmapTransform transform = val;
			PixelDataProvider pixelData = await decoder.GetPixelDataAsync((BitmapPixelFormat)30, (BitmapAlphaMode)1, transform, (ExifOrientationMode)1, (ColorManagementMode)0);
			BitmapEncoder encoder = await BitmapEncoder.CreateForTranscodingAsync(destinationStream, decoder);
			encoder.SetPixelData((BitmapPixelFormat)30, (BitmapAlphaMode)0, width, height, 98.0, 98.0, pixelData.DetachPixelData());
			await encoder.FlushAsync();
			destinationStream.Seek(0uL);
			return destinationStream;
		}
		finally
		{
			((IDisposable)sourceStream)?.Dispose();
		}
	}

	public static async Task<bool> IsNeedDownloadAgain(Uri fileName)
	{
		if ((await (await StorageFile.GetFileFromApplicationUriAsync(fileName)).GetBasicPropertiesAsync()).Size == 0)
		{
			return true;
		}
		return false;
	}

	public static async Task<bool> UpdateImageTile(string id, string pathImage)
	{
		if (SecondaryTile.Exists(id))
		{
			SecondaryTile secondaryTile = new SecondaryTile(id);
			secondaryTile.put_Logo(new Uri(pathImage));
			if (await secondaryTile.UpdateAsync())
			{
				return true;
			}
			return false;
		}
		return false;
	}

	public static async Task<bool> CheckTheImageURL(string url)
	{
		if (!CheckForInternetConnection())
		{
			return false;
		}
		try
		{
			HttpClient client = new HttpClient();
			if (await client.GetStreamAsync(url) != null)
			{
				return true;
			}
			return false;
		}
		catch (WebException)
		{
			return false;
		}
		catch (HttpRequestException)
		{
			return false;
		}
	}

	public static string XMLStringEncode(string regularstring)
	{
		string text = regularstring.Replace("<", "&lt;");
		text = text.Replace(">", "&gt;");
		text = text.Replace("&", "&amp;");
		text = text.Replace("\"", "&quot;");
		return text.Replace("'", "&apos;");
	}

	public static string XMLStringDecode(string xmlstring)
	{
		string text = xmlstring.Replace("&lt;", "<");
		text = text.Replace("&gt;", ">");
		text = text.Replace("&amp;", "&");
		text = text.Replace("&quot;", "\"");
		return text.Replace("&apos;", "'");
	}

	public static bool IsAllEmoticon(string msgText)
	{
		string text = msgText;
		string[] emotiStringArray = EmoticonChooser.EmotiStringArray;
		foreach (string oldValue in emotiStringArray)
		{
			text = text.Replace(oldValue, "");
		}
		return text.Trim().Length == 0;
	}

	public static bool IsRelatedChat(Type page)
	{
		if ((object)page == typeof(SelectBuddyPage))
		{
			return true;
		}
		if ((object)page == typeof(ChatListPage))
		{
			return true;
		}
		if ((object)page == typeof(TrunkDetailFullViewPage))
		{
			return true;
		}
		if ((object)page == typeof(TrunkDetailPage))
		{
			return true;
		}
		if ((object)page == typeof(TrunkPage))
		{
			return true;
		}
		if ((object)page == typeof(SnappedChatListPage))
		{
			return true;
		}
		if ((object)page == typeof(SnappedChatPage))
		{
			return true;
		}
		return false;
	}

	public static void SafetyGoBackPageNavigation(Frame Frame)
	{
		//IL_000a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0010: Invalid comparison between Unknown and I4
		while (Frame.CanGoBack)
		{
			Frame.GoBack();
			bool flag = false;
			if (((int)ApplicationView.Value != 2) ? SafetyGoBack_NotSnapped(Frame) : SafetyGoBack_Snapped(Frame))
			{
				break;
			}
		}
	}

	private static bool SafetyGoBack_NotSnapped(Frame Frame)
	{
		if ((object)Frame.CurrentSourcePageType == typeof(SnappedChatPage) || (object)Frame.CurrentSourcePageType == typeof(SnappedChatListPage))
		{
			return false;
		}
		return true;
	}

	private static bool SafetyGoBack_Snapped(Frame Frame)
	{
		if ((object)Frame.CurrentSourcePageType == typeof(SnappedChatPage) || (object)Frame.CurrentSourcePageType == typeof(SnappedChatListPage))
		{
			return true;
		}
		return false;
	}

	public static string StripSlashN(string memomessage)
	{
		if (memomessage != null && memomessage.Contains("\n"))
		{
			memomessage = memomessage.Replace("\n", " ");
		}
		return memomessage;
	}

	public static async Task<BitmapImage> BitmapImageFromStorageFileAsync(StorageFile storageFile)
	{
		BitmapImage bitmapImage = new BitmapImage();
		FileRandomAccessStream val = (FileRandomAccessStream)(await storageFile.OpenAsync((FileAccessMode)0));
		FileRandomAccessStream stream = val;
		((BitmapSource)bitmapImage).SetSource((IRandomAccessStream)(object)stream);
		return bitmapImage;
	}
}
