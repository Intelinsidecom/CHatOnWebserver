using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.IO;
using System.IO.IsolatedStorage;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Controls.Primitives;
using System.Windows.Media;
using System.Windows.Navigation;
using System.Windows.Threading;

namespace MemoryDiagnostic;

public static class MemoryDiagnosticsHelper
{
	public const string FileNameMemoryCheck = "MemoryCheckResult.xml";

	private const long MAX_MEMORY = 94371840L;

	private const long MAX_CHECKPOINTS = 10L;

	private static IsolatedStorageFile isoStore = null;

	private static Popup popup;

	private static TextBlock currentMemoryBlock;

	private static TextBlock peakMemoryBlock;

	private static TYPE_MEMORYCHECK checkType;

	private static DispatcherTimer timer;

	private static bool forceGc;

	private static int lastSafetyBand = -1;

	private static Queue<MemoryCheckpoint> recentCheckpoints;

	private static bool alreadyFailedPeak = false;

	public static IsolatedStorageFile IsolatedStorage
	{
		get
		{
			if (isoStore == null)
			{
				isoStore = IsolatedStorageFile.GetUserStoreForApplication();
			}
			return isoStore;
		}
	}

	public static string CurrentPageName
	{
		get
		{
			return SettingsHelper.Get<string>("MemoryCheckPreviousPage", null);
		}
		set
		{
			SettingsHelper.Set("MemoryCheckPreviousPage", value);
		}
	}

	public static IEnumerable<MemoryCheckpoint> RecentCheckpoints
	{
		get
		{
			try
			{
				bool flag = true;
				int num = default(int);
				bool flag2 = default(bool);
				Queue<MemoryCheckpoint>.Enumerator enumerator = default(Queue<MemoryCheckpoint>.Enumerator);
				switch (num)
				{
				default:
					if (!flag2)
					{
						if (recentCheckpoints == null)
						{
							break;
						}
						enumerator = recentCheckpoints.GetEnumerator();
						goto case 1;
					}
					yield break;
				case 1:
					try
					{
						if (num != 1 || !flag2)
						{
							if (enumerator.MoveNext())
							{
								_ = enumerator.Current;
								flag = false;
								/*Error near IL_00d0: Unexpected return in MoveNext()*/;
							}
							break;
						}
						yield break;
					}
					finally
					{
						if (flag)
						{
							((IDisposable)enumerator/*cast due to .constrained prefix*/).Dispose();
						}
					}
				case -1:
					yield break;
				}
			}
			catch (Exception)
			{
				throw;
			}
		}
	}

	[Conditional("DEBUG")]
	public static void Init(TYPE_MEMORYCHECK type, double interval)
	{
		bool flag = false;
		if (FileExists("MemoryCheckResult.xml"))
		{
			DeleteFile("MemoryCheckResult.xml");
		}
		CurrentPageName = null;
		checkType = type;
		recentCheckpoints = new Queue<MemoryCheckpoint>();
		switch (checkType)
		{
		case TYPE_MEMORYCHECK.TYPE_INTERVAL_DC:
			flag = true;
			Start(TimeSpan.FromMilliseconds(interval));
			break;
		case TYPE_MEMORYCHECK.TYPE_INTERVAL_XML:
			Start(TimeSpan.FromMilliseconds(interval));
			break;
		case TYPE_MEMORYCHECK.TYPE_PAGELOAD_DC:
			flag = true;
			ShowPopup();
			break;
		}
		forceGc = flag;
	}

	public static void Finish()
	{
		switch (checkType)
		{
		case TYPE_MEMORYCHECK.TYPE_PAGELOAD_DC:
			HidePopup();
			recentCheckpoints = null;
			break;
		case TYPE_MEMORYCHECK.TYPE_PAGELOAD_XML:
			recentCheckpoints = null;
			break;
		case TYPE_MEMORYCHECK.TYPE_INTERVAL_DC:
		case TYPE_MEMORYCHECK.TYPE_INTERVAL_XML:
			break;
		}
	}

	public static void Start(TimeSpan timespan)
	{
		if (checkType == TYPE_MEMORYCHECK.TYPE_INTERVAL_DC)
		{
			if (timer != null)
			{
				throw new InvalidOperationException("Diagnostics already running");
			}
			StartTimer(timespan);
			ShowPopup();
		}
		else if (checkType == TYPE_MEMORYCHECK.TYPE_INTERVAL_XML)
		{
			if (timer != null)
			{
				throw new InvalidOperationException("Diagnostics already running");
			}
			StartTimer(timespan);
		}
	}

	[Conditional("DEBUG")]
	public static void Stop()
	{
		if (checkType == TYPE_MEMORYCHECK.TYPE_INTERVAL_DC)
		{
			HidePopup();
			StopTimer();
			recentCheckpoints = null;
		}
		else if (checkType == TYPE_MEMORYCHECK.TYPE_INTERVAL_XML)
		{
			StopTimer();
			recentCheckpoints = null;
		}
	}

	public static void SetPage(string pageName)
	{
		CurrentPageName = pageName;
	}

	[Conditional("DEBUG")]
	public static void Checkpoint(string text)
	{
		if (recentCheckpoints != null)
		{
			if ((long)recentCheckpoints.Count >= 9L)
			{
				recentCheckpoints.Dequeue();
			}
			recentCheckpoints.Enqueue(new MemoryCheckpoint(text, GetCurrentMemoryUsage()));
		}
	}

	public static long GetCurrentMemoryUsage()
	{
		return 0L;
	}

	public static long GetPeakMemoryUsage()
	{
		return 0L;
	}

	private static void ShowPopup()
	{
		popup = new Popup();
		double fontSize = (double)Application.Current.Resources["PhoneFontSizeSmall"] - 2.0;
		Brush foreground = (Brush)Application.Current.Resources["PhoneForegroundBrush"];
		StackPanel stackPanel = new StackPanel();
		stackPanel.Orientation = Orientation.Horizontal;
		stackPanel.Background = (Brush)Application.Current.Resources["PhoneSemitransparentBrush"];
		StackPanel stackPanel2 = stackPanel;
		TextBlock textBlock = new TextBlock();
		textBlock.Text = "---";
		textBlock.FontSize = fontSize;
		textBlock.Foreground = foreground;
		currentMemoryBlock = textBlock;
		TextBlock textBlock2 = new TextBlock();
		textBlock2.Text = "";
		textBlock2.FontSize = fontSize;
		textBlock2.Foreground = foreground;
		textBlock2.Margin = new Thickness(5.0, 0.0, 0.0, 0.0);
		peakMemoryBlock = textBlock2;
		stackPanel2.Children.Add(currentMemoryBlock);
		stackPanel2.Children.Add(new TextBlock
		{
			Text = " kb",
			FontSize = fontSize,
			Foreground = foreground
		});
		stackPanel2.Children.Add(peakMemoryBlock);
		stackPanel2.RenderTransform = new CompositeTransform
		{
			Rotation = 90.0,
			TranslateX = 480.0,
			TranslateY = 425.0,
			CenterX = 0.0,
			CenterY = 0.0
		};
		popup.Child = stackPanel2;
		popup.IsOpen = true;
	}

	private static void StartTimer(TimeSpan timespan)
	{
		timer = new DispatcherTimer();
		timer.Interval = timespan;
		timer.Tick += timer_Tick;
		timer.Start();
	}

	private static void timer_Tick(object sender, EventArgs e)
	{
		if (checkType == TYPE_MEMORYCHECK.TYPE_INTERVAL_DC)
		{
			if (forceGc)
			{
				GC.Collect();
			}
			UpdateCurrentMemoryUsage();
			UpdatePeakMemoryUsage();
		}
		else if (checkType == TYPE_MEMORYCHECK.TYPE_INTERVAL_XML)
		{
			SaveMemoryInfoToXML();
		}
	}

	private static void SaveMemoryInfoToXML()
	{
		string text = null;
		string text2 = null;
		bool flag = false;
		string text3 = DateTime.Now.ToString();
		string format = "<item><CurrentTime>{0}</CurrentTime><PageName>{1}</PageName><CurrentUsage>{2}</CurrentUsage><PeakMemory>{3}</PeakMemory></item>";
		string text4 = $"{GetCurrentMemoryUsage() / 1024:N}";
		string text5 = $"{GetPeakMemoryUsage() / 1024:N}";
		string text6 = null;
		text6 = ((!string.IsNullOrEmpty(CurrentPageName)) ? CurrentPageName : "NA");
		StringBuilder stringBuilder = new StringBuilder();
		text2 = stringBuilder.AppendFormat(format, text3, text6, text4, text5).ToString();
		if (FileExists("MemoryCheckResult.xml"))
		{
			text = ReadFileToString("MemoryCheckResult.xml").Replace("</MemoryLog>\r\n", text2 + "</MemoryLog>");
			WriteStringToFile("MemoryCheckResult.xml", text, FileMode.Truncate);
		}
		else
		{
			text = "<MemoryLog>" + text2 + "</MemoryLog>";
			WriteStringToFile("MemoryCheckResult.xml", text, FileMode.CreateNew);
		}
	}

	private static void UpdatePeakMemoryUsage()
	{
		if (!alreadyFailedPeak)
		{
			long peakMemoryUsage = GetPeakMemoryUsage();
			if (peakMemoryUsage >= 94371840)
			{
				alreadyFailedPeak = true;
				peakMemoryBlock.Text = "FAIL!";
				peakMemoryBlock.Foreground = new SolidColorBrush(Colors.Red);
			}
		}
	}

	private static void UpdateCurrentMemoryUsage()
	{
		long currentMemoryUsage = GetCurrentMemoryUsage();
		currentMemoryBlock.Text = $"{currentMemoryUsage / 1024:N}";
		int safetyBand = GetSafetyBand(currentMemoryUsage);
		if (safetyBand != lastSafetyBand)
		{
			currentMemoryBlock.Foreground = GetBrushForSafetyBand(safetyBand);
			lastSafetyBand = safetyBand;
		}
	}

	private static Brush GetBrushForSafetyBand(int safetyBand)
	{
		return safetyBand switch
		{
			0 => new SolidColorBrush(Colors.Green), 
			1 => new SolidColorBrush(Colors.Orange), 
			_ => new SolidColorBrush(Colors.Red), 
		};
	}

	private static int GetSafetyBand(long mem)
	{
		double num = (double)mem / 94371840.0;
		if (num <= 0.75)
		{
			return 0;
		}
		if (num <= 0.9)
		{
			return 1;
		}
		return 2;
	}

	private static void StopTimer()
	{
		timer.Stop();
		timer = null;
	}

	private static void HidePopup()
	{
		popup.IsOpen = false;
		popup = null;
	}

	public static void Page_Loaded(object sender, RoutedEventArgs e)
	{
		if (checkType == TYPE_MEMORYCHECK.TYPE_PAGELOAD_DC)
		{
			if (forceGc)
			{
				GC.Collect();
			}
			UpdateCurrentMemoryUsage();
			UpdatePeakMemoryUsage();
		}
		else if (checkType == TYPE_MEMORYCHECK.TYPE_PAGELOAD_XML)
		{
			SaveMemoryInfoToXML();
		}
	}

	public static void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e == null)
		{
			throw new ArgumentNullException("e");
		}
		CurrentPageName = e.Uri.ToString();
	}

	public static bool FileExists(string filePath)
	{
		return IsolatedStorage.FileExists(filePath);
	}

	public static void DeleteFile(string filePath)
	{
		if (FileExists(filePath))
		{
			IsolatedStorage.DeleteFile(filePath);
		}
	}

	public static string ReadFileToString(string filePath)
	{
		if (!FileExists(filePath))
		{
			return null;
		}
		string result = null;
		IsolatedStorageFileStream isolatedStorageFileStream = IsolatedStorage.OpenFile(filePath, FileMode.Open, FileAccess.Read);
		if (isolatedStorageFileStream != null)
		{
			StreamReader streamReader = new StreamReader(isolatedStorageFileStream);
			result = streamReader.ReadToEnd();
			isolatedStorageFileStream.Close();
		}
		return result;
	}

	public static void WriteStringToFile(string filePath, string data, FileMode fileMode)
	{
		if (data == null)
		{
			return;
		}
		try
		{
			using StreamWriter streamWriter = new StreamWriter(IsolatedStorage.OpenFile(filePath, fileMode));
			streamWriter?.WriteLine(data);
		}
		catch
		{
		}
	}
}
