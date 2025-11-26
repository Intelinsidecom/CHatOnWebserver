using System;
using System.CodeDom.Compiler;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatON_WoA.Views;
using ChatOn.Models;
using ChatOn.Services;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Input;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;

namespace ChatOn.Controls;

public class EmoticonChooser : UserControl, IComponentConnector
{
	public delegate void EmoticonChooserEventHandler(object sender, object e);

	public static string[] EmotiStringArray = new string[160]
	{
		"[:>]", "[*_*]", "[(:]", "[-_-*]", "[B)]", "[:-\"]", "[v]", "[:-,]", "[%OD]", "[d:]",
		"[^^]", "[spicy]", "[AF]", "[IF]", "[8-0]", "[,_@]", "[:-S]", "[=:O]", "[~_~]", "[2S2]",
		"[b-(]", "[:-}]", "[=.=]", "[:-o]", "[:-~~~]", "['-3-]", "[3S2]", "[s$]", "[w*]", "[+-_-]",
		"[:(]", "[DF]", "[#]", "[:-L]", "[UT]", "[>:-<]", "[X-[]", "[X-(]", "[spit]", "[-_-]",
		"[:'(]", "[FF]", "[tears]", "[T_T]", "[CS]", "[:*(]", "[:-/]", "[):]", "[-_-+]", "[x_x]",
		"[%')]", "[:-`|]", "[-.-!]", "[medi]", "[:-(0)]", "[O.o]", "[>:-(]", "[:0]", "[~:-(]", "[eez]",
		"[(-.-)zzZZ]", "[lazy]", "[fussy]", "[>-)]", "[8-X]", "[crown]", "[~:0]", "[<:-)]", "[ghost]", "[angel]",
		"[devil]", "[j>_<]", "[P-(]", "[birthday]", "[8-/]", "[ON]", "[:P]", "[*B)]", "[hot]", "[..x]",
		"[^^>]", "[~~*]", "[7:]", "[6:]", "[4:]", "[@]", "[r=3]", "[k><]", "[p_ _;]", "[\"o.o.]",
		"[8->]", "[:$s]", "[coffee]", "[u@--]", "[Glass]", "[$:]", "[5(ll)]", "[}}=]", "[i*(((=]", "[hm]",
		"[l3]", "[o:]", "[apple]", "[dough nut]", "[cookie]", "[straw berry]", "[biscuit]", "[cherry]", "[hotdog]", "[(0)]",
		"[<((<]", "[=:]", "[>:]", "[b-m-]", "[m-\"-]", "[:@)]", "[cat]", "[tiger]", "[<:3)~]", "[~~~~8}]",
		"[@..@]", "[:(|)]", "[Horse]", "[~:>]", "[3:-O]", "[Dragon]", "[y8]", "[c~]", "[;;]", "[n@]",
		"[a*]", "[g&S]", "[%]", "[f&F]", "[9&7]", "[{@}--]", "[z88]", "[Jol]", "[Tree]", "[popper]",
		"[Present]", "[socks]", "[1S2]", "[{>O]", "[▶◀]", "[ET]", "[Big Ben]", "[pyramid]", "[Taj Mahal]", "[Opera House]",
		"[Namdaemun]", "[moai]", "[acropolis]", "[scissor]", "[rock]", "[paper]", "[victory]", "[okay]", "[best]", "[lowest]"
	};

	public static string[] _emotiImagePathArray;

	private ObservableCollection<OfflineAniconPackage> _packages = new ObservableCollection<OfflineAniconPackage>();

	private bool _isLoaded;

	private static EmoticonChooser _activeInstance;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private GridView AniconGridViewer;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton CloseButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton EmoticonButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ImageButton AniconButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static string[] EmotiImagePathArray
	{
		get
		{
			if (_emotiImagePathArray == null)
			{
				_emotiImagePathArray = new string[EmotiStringArray.Length];
				for (int i = 0; i < EmotiStringArray.Length; i++)
				{
					_emotiImagePathArray[i] = "/Images/Emoticon/1-" + (i + 1) + ".png";
				}
			}
			return _emotiImagePathArray;
		}
	}

	public ObservableCollection<OfflineAniconPackage> newPackage { get; set; }

	public ObservableCollection<OfflineAniconPackage> Packages
	{
		get
		{
			return _packages;
		}
		set
		{
			_packages = value;
		}
	}

	public static EmoticonChooser ActiveInstance => _activeInstance;

	public static event EmoticonChooserEventHandler Completed;

	public static event EmoticonChooserEventHandler Tapped;

	public static event EmoticonChooserEventHandler Closed;

	public EmoticonChooser()
	{
		_activeInstance = this;
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)new EmoticonChooserViewModel(((FrameworkElement)this).BaseUri));
	}

	private void EmoticonChooser_Loaded(object sender, RoutedEventArgs e)
	{
		EmoticonChooserViewModel emoticonChooserViewModel = null;
		if (((FrameworkElement)this).DataContext is EmoticonChooserViewModel emoticonChooserViewModel2)
		{
			emoticonChooserViewModel2.OnNavigatedToCommand.Execute(null);
		}
	}

	private void Emoticon_Tapped(object sender, TappedRoutedEventArgs e)
	{
		AniconEmoticonItem aniconEmoticonItem = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is AniconEmoticonItem aniconEmoticonItem2 && EmoticonChooser.Completed != null)
		{
			EmoticonChooser.Completed(this, aniconEmoticonItem2.Text);
		}
	}

	private void Grid_DoubleTapped_1(object sender, DoubleTappedRoutedEventArgs e)
	{
		AniconEmoticonItem aniconEmoticonItem = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is AniconEmoticonItem aniconEmoticonItem2 && EmoticonChooser.Completed != null)
		{
			EmoticonChooser.Completed(this, aniconEmoticonItem2.Text);
		}
	}

	private void Anicon_Tapped(object sender, TappedRoutedEventArgs e)
	{
		Anicon anicon = null;
		if (((FrameworkElement)((sender is FrameworkElement) ? sender : null)).DataContext is Anicon e2 && EmoticonChooser.Completed != null)
		{
			EmoticonChooser.Completed(this, e2);
		}
	}

	public void Load()
	{
	}

	private void EmoticonButton_Click(object sender, RoutedEventArgs e)
	{
		EmoticonChooserViewModel emoticonChooserViewModel = null;
		if (((FrameworkElement)this).DataContext is EmoticonChooserViewModel emoticonChooserViewModel2)
		{
			emoticonChooserViewModel2.ActiveItem = EmoticonChooserActiveItem.Emoticon;
		}
	}

	private void AniconButton_Click(object sender, RoutedEventArgs e)
	{
		EmoticonChooserViewModel emoticonChooserViewModel = null;
		if (((FrameworkElement)this).DataContext is EmoticonChooserViewModel emoticonChooserViewModel2)
		{
			if (ChatOnService.Instance.AniconPackages.ToList().Count == 0)
			{
				emoticonChooserViewModel2.ActiveItem = EmoticonChooserActiveItem.Anicon_Empty;
			}
			else
			{
				emoticonChooserViewModel2.ActiveItem = EmoticonChooserActiveItem.Anicon_Filled;
			}
		}
	}

	internal static void ResetEvent()
	{
		EmoticonChooser.Completed = null;
	}

	public static bool IsEventAlreadyRegister()
	{
		return EmoticonChooser.Completed != null;
	}

	private void PackageThumb_Tapped(object sender, TappedRoutedEventArgs e)
	{
		//IL_004b: Unknown result type (might be due to invalid IL or missing references)
		//IL_0052: Expected O, but got Unknown
		EmoticonChooserViewModel emoticonChooserViewModel = null;
		if (!(((FrameworkElement)this).DataContext is EmoticonChooserViewModel emoticonChooserViewModel2))
		{
			return;
		}
		FrameworkElement val = (FrameworkElement)((sender is FrameworkElement) ? sender : null);
		if (val == null || !(val.DataContext is OfflineAniconPackage parameter))
		{
			return;
		}
		DependencyObject child = VisualTreeHelper.GetChild((DependencyObject)(object)AniconGridViewer, 0);
		FrameworkElement val2 = (FrameworkElement)(object)((child is FrameworkElement) ? child : null);
		if (val2 != null)
		{
			ScrollViewer val3 = (ScrollViewer)val2.FindName("ScrollViewer");
			if (val3 != null)
			{
				val3.ScrollToVerticalOffset(0.0);
			}
		}
		emoticonChooserViewModel2.OnSelectAniconPackageCommand.Execute(parameter);
	}

	private void AniconDownControl_Click_1(object sender, RoutedEventArgs e)
	{
		((Page)PivotPage.ActiveInstance).Frame.Navigate(typeof(SettingsPage), (object)"Download");
	}

	private void EmoticonItems_Tapped_1(object sender, TappedRoutedEventArgs e)
	{
		if (EmoticonChooser.Tapped != null)
		{
			EmoticonChooser.Tapped(this, null);
		}
	}

	private void EmoticonItems_DoubleTapped_1(object sender, DoubleTappedRoutedEventArgs e)
	{
		if (EmoticonChooser.Tapped != null)
		{
			EmoticonChooser.Tapped(this, null);
		}
	}

	private void CloseButton_Click(object sender, RoutedEventArgs e)
	{
		if (EmoticonChooser.Closed != null)
		{
			EmoticonChooser.Closed(this, null);
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///EmoticonChooser.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			AniconGridViewer = (GridView)((FrameworkElement)this).FindName("AniconGridViewer");
			CloseButton = (ImageButton)((FrameworkElement)this).FindName("CloseButton");
			EmoticonButton = (ImageButton)((FrameworkElement)this).FindName("EmoticonButton");
			AniconButton = (ImageButton)((FrameworkElement)this).FindName("AniconButton");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0034: Unknown result type (might be due to invalid IL or missing references)
		//IL_003a: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_0069: Unknown result type (might be due to invalid IL or missing references)
		//IL_006f: Expected O, but got Unknown
		//IL_008e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0098: Expected O, but got Unknown
		//IL_009e: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a4: Expected O, but got Unknown
		//IL_00c3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00cd: Expected O, but got Unknown
		//IL_00d3: Unknown result type (might be due to invalid IL or missing references)
		//IL_00da: Expected O, but got Unknown
		//IL_00fb: Unknown result type (might be due to invalid IL or missing references)
		//IL_0105: Expected O, but got Unknown
		//IL_0106: Unknown result type (might be due to invalid IL or missing references)
		//IL_010d: Expected O, but got Unknown
		//IL_012e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0138: Expected O, but got Unknown
		//IL_013e: Unknown result type (might be due to invalid IL or missing references)
		//IL_0145: Expected O, but got Unknown
		//IL_0166: Unknown result type (might be due to invalid IL or missing references)
		//IL_0170: Expected O, but got Unknown
		//IL_0171: Unknown result type (might be due to invalid IL or missing references)
		//IL_0178: Expected O, but got Unknown
		//IL_0199: Unknown result type (might be due to invalid IL or missing references)
		//IL_01a3: Expected O, but got Unknown
		//IL_01b2: Unknown result type (might be due to invalid IL or missing references)
		//IL_01bc: Expected O, but got Unknown
		//IL_01cb: Unknown result type (might be due to invalid IL or missing references)
		//IL_01d5: Expected O, but got Unknown
		//IL_01e4: Unknown result type (might be due to invalid IL or missing references)
		//IL_01ee: Expected O, but got Unknown
		//IL_01fd: Unknown result type (might be due to invalid IL or missing references)
		//IL_0207: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			FrameworkElement val7 = (FrameworkElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val7, (nint)__ldftn(FrameworkElement.add_Loaded)), new Action<EventRegistrationToken>(val7, (nint)__ldftn(FrameworkElement.remove_Loaded)), new RoutedEventHandler(EmoticonChooser_Loaded));
			break;
		}
		case 2:
		{
			UIElement val6 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val6, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val6, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Anicon_Tapped));
			break;
		}
		case 3:
		{
			UIElement val5 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val5, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val5, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(PackageThumb_Tapped));
			break;
		}
		case 4:
		{
			UIElement val3 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val3, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val3, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(Emoticon_Tapped));
			UIElement val4 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<DoubleTappedEventHandler, EventRegistrationToken>(val4, (nint)__ldftn(UIElement.add_DoubleTapped)), new Action<EventRegistrationToken>(val4, (nint)__ldftn(UIElement.remove_DoubleTapped)), new DoubleTappedEventHandler(Grid_DoubleTapped_1));
			break;
		}
		case 5:
		{
			UIElement val = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<TappedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(UIElement.add_Tapped)), new Action<EventRegistrationToken>(val, (nint)__ldftn(UIElement.remove_Tapped)), new TappedEventHandler(EmoticonItems_Tapped_1));
			UIElement val2 = (UIElement)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<DoubleTappedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(UIElement.add_DoubleTapped)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(UIElement.remove_DoubleTapped)), new DoubleTappedEventHandler(EmoticonItems_DoubleTapped_1));
			break;
		}
		case 6:
			((ImageButton)target).Click += new RoutedEventHandler(AniconDownControl_Click_1);
			break;
		case 7:
			((ImageButton)target).Click += new RoutedEventHandler(CloseButton_Click);
			break;
		case 8:
			((ImageButton)target).Click += new RoutedEventHandler(EmoticonButton_Click);
			break;
		case 9:
			((ImageButton)target).Click += new RoutedEventHandler(AniconButton_Click);
			break;
		}
		_contentLoaded = true;
	}
}
