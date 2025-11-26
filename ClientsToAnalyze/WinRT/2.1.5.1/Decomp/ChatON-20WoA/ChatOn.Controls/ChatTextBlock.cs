using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using System.Text.RegularExpressions;
using ChatON_WoA.Views;
using ChatOn.Infrastructure;
using Windows.System;
using Windows.UI;
using Windows.UI.ViewManagement;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Documents;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;

namespace ChatOn.Controls;

public class ChatTextBlock : UserControl, IComponentConnector
{
	public class KeywordMatch
	{
		private Match _matchResult;

		private int _typeIndex;

		public Match MatchResult
		{
			get
			{
				return _matchResult;
			}
			set
			{
				_matchResult = value;
			}
		}

		public int TypeIndex
		{
			get
			{
				return _typeIndex;
			}
			set
			{
				_typeIndex = value;
			}
		}

		public KeywordMatch(Match match, int index)
		{
			_matchResult = match;
			_typeIndex = index;
		}
	}

	private const string MULTIPLE_DOT = "..";

	public static readonly DependencyProperty TextProperty = DependencyProperty.RegisterAttached("Text", typeof(string), typeof(ChatTextBlock), new PropertyMetadata((object)"", new PropertyChangedCallback(OnTextChanged)));

	public static readonly DependencyProperty ForegroundTextProperty = DependencyProperty.RegisterAttached("ForegroundText", typeof(SolidColorBrush), typeof(ChatTextBlock), new PropertyMetadata((object)new SolidColorBrush(Colors.Gray), new PropertyChangedCallback(OnTextChanged)));

	public static readonly DependencyProperty EmoticonSizeProperty = DependencyProperty.RegisterAttached("EmoticonSize", typeof(double), typeof(ChatTextBlock), (PropertyMetadata)null);

	public static readonly DependencyProperty MaxLengthProperty = DependencyProperty.RegisterAttached("MaxLength", typeof(int), typeof(ChatTextBlock), (PropertyMetadata)null);

	public static readonly DependencyProperty IsParsingLinkEnabledProperty = DependencyProperty.RegisterAttached("IsParsingLinkEnabled", typeof(bool), typeof(ChatTextBlock), (PropertyMetadata)null);

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private RichTextBlock RichText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public SolidColorBrush ForegroundText
	{
		get
		{
			//IL_000b: Unknown result type (might be due to invalid IL or missing references)
			//IL_0011: Expected O, but got Unknown
			return (SolidColorBrush)((DependencyObject)this).GetValue(ForegroundTextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(ForegroundTextProperty, (object)value);
		}
	}

	public string Text
	{
		get
		{
			return (string)((DependencyObject)this).GetValue(TextProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(TextProperty, (object)value);
		}
	}

	public double EmoticonSize
	{
		get
		{
			return (double)((DependencyObject)this).GetValue(EmoticonSizeProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(EmoticonSizeProperty, (object)value);
		}
	}

	public int MaxLength
	{
		get
		{
			return (int)((DependencyObject)this).GetValue(MaxLengthProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(MaxLengthProperty, (object)value);
		}
	}

	public bool IsParsingLinkEnabled
	{
		get
		{
			return (bool)((DependencyObject)this).GetValue(IsParsingLinkEnabledProperty);
		}
		set
		{
			((DependencyObject)this).SetValue(IsParsingLinkEnabledProperty, (object)value);
		}
	}

	public ChatTextBlock()
	{
		InitializeComponent();
	}

	private static void OnTextChanged(DependencyObject obj, DependencyPropertyChangedEventArgs e)
	{
		if (obj is ChatTextBlock)
		{
			(obj as ChatTextBlock).UpdateContent();
		}
	}

	private static int CompareByIndex(KeywordMatch x, KeywordMatch y)
	{
		if (x == null)
		{
			if (y == null)
			{
				return 0;
			}
			return -1;
		}
		if (y == null)
		{
			return 1;
		}
		return x.MatchResult.Index.CompareTo(y.MatchResult.Index);
	}

	internal bool isMedia(string str)
	{
		if (str.StartsWith("video"))
		{
			return true;
		}
		if (str.StartsWith("image"))
		{
			return true;
		}
		if (str.StartsWith("audio"))
		{
			return true;
		}
		if (str.StartsWith("geo"))
		{
			return true;
		}
		if (str.StartsWith("vcal"))
		{
			return true;
		}
		if (str.StartsWith("contact"))
		{
			return true;
		}
		if (str.StartsWith("anicon"))
		{
			return true;
		}
		if (str.StartsWith("mixed"))
		{
			string[] array = Utility.Split(str, '\n');
			if (array.Length >= 2)
			{
				return true;
			}
			return false;
		}
		return false;
	}

	internal bool IsIndicateAsEmail(string str)
	{
		if (str.Contains("https://") || str.Contains("http://") || str.Contains("ftp://"))
		{
			return false;
		}
		string[] array = Utility.Split(str, '@');
		if (array.Length >= 2)
		{
			return true;
		}
		return false;
	}

	internal unsafe void UpdateContent()
	{
		//IL_009e: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a4: Expected O, but got Unknown
		//IL_0554: Unknown result type (might be due to invalid IL or missing references)
		//IL_055b: Expected O, but got Unknown
		//IL_058b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0592: Expected O, but got Unknown
		//IL_0592: Unknown result type (might be due to invalid IL or missing references)
		//IL_0599: Expected O, but got Unknown
		//IL_05d7: Unknown result type (might be due to invalid IL or missing references)
		//IL_05e1: Expected O, but got Unknown
		//IL_05e1: Unknown result type (might be due to invalid IL or missing references)
		//IL_05e8: Expected O, but got Unknown
		//IL_0609: Unknown result type (might be due to invalid IL or missing references)
		//IL_0613: Expected O, but got Unknown
		//IL_0629: Unknown result type (might be due to invalid IL or missing references)
		//IL_0630: Expected O, but got Unknown
		//IL_04ad: Unknown result type (might be due to invalid IL or missing references)
		//IL_04b4: Expected O, but got Unknown
		//IL_0528: Unknown result type (might be due to invalid IL or missing references)
		//IL_0532: Expected O, but got Unknown
		//IL_0532: Unknown result type (might be due to invalid IL or missing references)
		//IL_0539: Expected O, but got Unknown
		//IL_047e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0485: Expected O, but got Unknown
		//IL_0691: Unknown result type (might be due to invalid IL or missing references)
		//IL_0698: Expected O, but got Unknown
		try
		{
			RichText.put_FontFamily(((Control)this).FontFamily);
			RichText.put_FontSize(((Control)this).FontSize);
			RichText.put_Foreground((Brush)(object)ForegroundText);
			try
			{
				foreach (Block item in (IEnumerable<Block>)RichText.Blocks)
				{
					((ICollection<Block>)RichText.Blocks).Remove(item);
				}
			}
			catch (Exception)
			{
			}
			if (string.IsNullOrEmpty(Text))
			{
				return;
			}
			_ = DateTime.UtcNow.Ticks;
			Paragraph val = new Paragraph();
			string text = Text;
			if (Text.Length > MaxLength)
			{
				text = Text.Substring(0, MaxLength);
			}
			int num = 0;
			List<KeywordMatch> list = new List<KeywordMatch>();
			RegexOptions options = RegexOptions.IgnoreCase | RegexOptions.Multiline | RegexOptions.IgnorePatternWhitespace;
			if (IsParsingLinkEnabled && !isMedia(text))
			{
				if (text.Length >= 7 && text.Length >= 7)
				{
					try
					{
						bool flag = false;
						string pattern = "(((ht|f)tp(s?))\\://)?([\\d\\w-.]+?\\.([a-zA-Z0-9\\.\\-\\]+(\\.[a-zA-Z]{2,4})(\\b|\\W(?<!&|=)(?!\\.\\s|\\.{3}).*?))(\\s|$)";
						Regex regex = new Regex(pattern, options);
						MatchCollection matchCollection = regex.Matches(text);
						foreach (Match item2 in matchCollection)
						{
							string text2 = item2.Value;
							if (!text2.Contains("..") && CheckAfterDotIsValidDomain(text2) && !IsIndicateAsEmail(text))
							{
								KeywordMatch keywordMatch = list.Find((KeywordMatch x) => x.MatchResult.Value.Equals(text2));
								if (keywordMatch == null)
								{
									list.Add(new KeywordMatch(item2, -1));
								}
								flag = true;
							}
						}
						if (!flag)
						{
							pattern = "(((ht|f)tp(s?))\\://)?[\\d\\w-.]+?\\.([0-9\\.\\-]{4,6})(\\b|\\W(?!&|=)(?!\\.\\s|\\.{3}).*?)(\\s|$)";
							regex = new Regex(pattern, options);
							matchCollection = regex.Matches(text);
							foreach (Match item3 in matchCollection)
							{
								string text3 = item3.Value;
								if (!text3.Contains("..") && CheckAfterDotIsValidDomain(text3) && !IsIndicateAsEmail(text))
								{
									KeywordMatch keywordMatch2 = list.Find((KeywordMatch x) => x.MatchResult.Value.Equals(text3));
									if (keywordMatch2 == null)
									{
										list.Add(new KeywordMatch(item3, -1));
									}
								}
							}
						}
					}
					catch (Exception)
					{
					}
				}
				if (text.Length >= 7)
				{
					string pattern2 = "^[a-z]{1,15}[.](com|org|aero|asia|info|net|biz|co|cat|coop|int|jobs|mobi|museum|name|post|pro|tel|travel|xxx|me|gov|mil|edu)$";
					Regex regex2 = new Regex(pattern2, options);
					MatchCollection matchCollection2 = regex2.Matches(text);
					foreach (Match match3 in matchCollection2)
					{
						Predicate<KeywordMatch> match4 = (KeywordMatch x) => x.MatchResult.Value.Equals(match3.Value);
						if (list.Find(match4) == null)
						{
							list.Add(new KeywordMatch(match3, -1));
						}
					}
				}
				if (text.Length >= 5)
				{
					string pattern3 = "(?(\")(\".+?\"@)|(([0-9a-zA-Z]((\\.(?!\\.))|[-!#\\$%&'\\*\\+/=\\?\\^`\\{\\}\\|~\\w])*)(?<=[0-9a-zA-Z])@))(?(\\[)(\\[(\\d{1,3}\\.){3}\\d{1,3}\\])|(([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,6}))";
					Regex regex3 = new Regex(pattern3, options);
					MatchCollection matchCollection3 = regex3.Matches(text);
					foreach (Match item4 in matchCollection3)
					{
						list.Add(new KeywordMatch(item4, -2));
					}
				}
			}
			if (text.Length >= 3)
			{
				for (int num2 = 0; num2 < EmoticonChooser.EmotiStringArray.Length; num2++)
				{
					string pattern4 = Regex.Escape(EmoticonChooser.EmotiStringArray[num2]);
					MatchCollection matchCollection4 = Regex.Matches(text, pattern4);
					foreach (Match item5 in matchCollection4)
					{
						list.Add(new KeywordMatch(item5, num2));
					}
				}
			}
			list.Sort(CompareByIndex);
			foreach (KeywordMatch item6 in list)
			{
				try
				{
					string text4 = text.Substring(num, item6.MatchResult.Index - num);
					if (text4.Length > 0)
					{
						Run val2 = new Run();
						val2.put_Text(text4);
						((ICollection<Inline>)val.Inlines).Add((Inline)(object)val2);
					}
				}
				catch (Exception)
				{
				}
				if (item6.TypeIndex >= 0)
				{
					Image val3 = new Image();
					val3.put_Stretch((Stretch)3);
					((UIElement)val3).put_UseLayoutRounding(true);
					((FrameworkElement)val3).put_Width(EmoticonSize);
					((FrameworkElement)val3).put_Height(EmoticonSize);
					((FrameworkElement)val3).put_Margin(new Thickness(0.0, 0.0, 0.0, -4.0));
					val3.put_Source((ImageSource)new BitmapImage(new Uri(((FrameworkElement)this).BaseUri, EmoticonChooser.EmotiImagePathArray[item6.TypeIndex])));
					InlineUIContainer val4 = new InlineUIContainer();
					val4.put_Child((UIElement)(object)val3);
					((ICollection<Inline>)val.Inlines).Add((Inline)(object)val4);
				}
				else
				{
					TextBlock val5 = new TextBlock();
					((FrameworkElement)val5).put_Margin(new Thickness(0.0, 0.0, 0.0, -4.0));
					Underline val6 = new Underline();
					Run val7 = new Run();
					val7.put_Text(item6.MatchResult.Value);
					((ICollection<Inline>)((Span)val6).Inlines).Add((Inline)(object)val7);
					((ICollection<Inline>)val5.Inlines).Add((Inline)(object)val6);
					val5.put_TextWrapping((TextWrapping)2);
					val5.put_Foreground((Brush)new SolidColorBrush(Colors.DarkBlue));
					InlineUIContainer val8 = new InlineUIContainer();
					WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(txtBlock_Tapped));
					val8.put_Child((UIElement)(object)val5);
					((ICollection<Inline>)val.Inlines).Add((Inline)(object)val8);
					Run val9 = new Run();
					val9.put_Text("\n");
					((ICollection<Inline>)val.Inlines).Add((Inline)(object)val9);
				}
				num = item6.MatchResult.Index + item6.MatchResult.Length;
			}
			if (num < text.Length)
			{
				string text5 = text.Substring(num);
				Run val10 = new Run();
				val10.put_Text(text5);
				((ICollection<Inline>)val.Inlines).Add((Inline)(object)val10);
			}
			try
			{
				((ICollection<Block>)RichText.Blocks).Add((Block)(object)val);
			}
			catch (Exception)
			{
			}
		}
		catch (Exception)
		{
		}
	}

	private void txtBlock_Tapped(object sender, TappedRoutedEventArgs e)
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Invalid comparison between Unknown and I4
		if ((int)ApplicationView.Value != 2)
		{
			ChatDetailPage.ActiveInstance.ViewModel.DisableContextMenu();
		}
		else
		{
			ChatDetailPage.SnappedActiveInstance.ViewModel.DisableContextMenu();
		}
		try
		{
			TextBlock val = (TextBlock)((sender is TextBlock) ? sender : null);
			if (val.Text.Contains("@"))
			{
				string text = val.Text;
				if (text.IndexOf("mailto", StringComparison.CurrentCultureIgnoreCase) < 0)
				{
					text = "mailto://" + text;
				}
				Launcher.LaunchUriAsync(new Uri(text));
			}
			else if (val.Text.IndexOf("www", StringComparison.CurrentCultureIgnoreCase) >= 0 || val.Text.IndexOf("http", StringComparison.CurrentCultureIgnoreCase) >= 0)
			{
				string text2 = val.Text.Trim();
				if (text2.IndexOf("http", StringComparison.CurrentCultureIgnoreCase) < 0)
				{
					text2 = "http://" + text2;
				}
				Launcher.LaunchUriAsync(new Uri(text2));
			}
			else
			{
				string text3 = val.Text.Trim();
				if (text3.IndexOf("http", StringComparison.CurrentCultureIgnoreCase) < 0)
				{
					text3 = "http://" + text3;
				}
				Launcher.LaunchUriAsync(new Uri(text3));
			}
			e.put_Handled(true);
		}
		catch (Exception)
		{
		}
	}

	private void UserControl_Unloaded(object sender, RoutedEventArgs e)
	{
		try
		{
			if (RichText.Blocks != null)
			{
				((ICollection<Block>)RichText.Blocks).Clear();
			}
		}
		catch (Exception)
		{
		}
	}

	private void UserControl_Loaded(object sender, RoutedEventArgs e)
	{
		UpdateContent();
	}

	private bool CheckAfterDotIsValidDomain(string str)
	{
		string[] array = Utility.Split(str.Trim(), '.');
		if (str.StartsWith("http") || str.StartsWith("https") || str.StartsWith("ftp"))
		{
			return true;
		}
		string text = array[array.Length - 1];
		if (text.Length < 2 || text.Length > 4)
		{
			return false;
		}
		if (Regex.IsMatch(text, "\\W") || Regex.IsMatch(text, "[0-9]"))
		{
			return false;
		}
		return true;
	}

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	[DebuggerNonUserCode]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ChatTextBlock.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			RichText = (RichTextBlock)((FrameworkElement)this).FindName("RichText");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_000d: Expected O, but got Unknown
		//IL_002c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0036: Expected O, but got Unknown
		//IL_0037: Unknown result type (might be due to invalid IL or missing references)
		//IL_003d: Expected O, but got Unknown
		//IL_005c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0066: Expected O, but got Unknown
		if (connectionId == 1)
		{
			FrameworkElement val = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(UserControl_Loaded));
			FrameworkElement val2 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.add_Unloaded)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(FrameworkElement.remove_Unloaded)), new RoutedEventHandler(UserControl_Unloaded));
		}
		_contentLoaded = true;
	}
}
