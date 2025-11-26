using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Infrastructure;
using vitemapi;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Navigation;

namespace ChatON_WoA.Views;

public sealed class ContactDetailPage : Page, IComponentConnector
{
	public class ContactInfo
	{
		public string Type { get; set; }

		public string Value { get; set; }
	}

	private ObservableCollection<ContactInfo> _contactInfos;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ListView ContactInfoGridView;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock ContactNameText;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public ObservableCollection<ContactInfo> ContactInfos
	{
		get
		{
			return _contactInfos;
		}
		set
		{
			_contactInfos = value;
		}
	}

	public ContactDetailPage()
	{
		InitializeComponent();
	}

	protected override void OnNavigatedTo(NavigationEventArgs e)
	{
		if (e.Parameter != null)
		{
			MakeReceivedContactInfo(e.Parameter as string);
		}
		((FrameworkElement)this).put_DataContext((object)this);
	}

	private void MakeReceivedContactInfo(string vCardInfo)
	{
		vCard_t vCard_t = new vCard_t();
		vCard_t.pEncodedData = vCardInfo;
		vCard_t.nEncodedDataLen = vCardInfo.Length;
		List<Vitemnode> delTaglist = new List<Vitemnode>();
		vCardDecoder.DecodevCard(vCard_t, delTaglist);
		ContactNameText.put_Text(vCard_t.FN);
		_contactInfos = new ObservableCollection<ContactInfo>();
		for (int i = 0; i < vCard_t.EMAILList.Count(); i++)
		{
			if (!string.IsNullOrEmpty(vCard_t.EMAILList[i].email))
			{
				ContactInfo contactInfo = new ContactInfo();
				contactInfo.Value = vCard_t.EMAILList[i].email;
				if (vCard_t.EMAILList[i].type == 1)
				{
					contactInfo.Type = Utility.GetResourceString("IDS_CHATON_BODY_HOME") + " " + Utility.GetResourceString("IDS_CHATON_OPT_EMAIL");
				}
				else if (vCard_t.EMAILList[i].type == 2)
				{
					contactInfo.Type = Utility.GetResourceString("IDS_CHATON_BODY_WORK") + " " + Utility.GetResourceString("IDS_CHATON_OPT_EMAIL");
				}
				else
				{
					contactInfo.Type = Utility.GetResourceString("IDS_CHATON_OPT_EMAIL");
				}
				_contactInfos.Add(contactInfo);
			}
		}
		for (int j = 0; j < vCard_t.TELList.Count(); j++)
		{
			if (!string.IsNullOrEmpty(vCard_t.TELList[j].number))
			{
				ContactInfo contactInfo2 = new ContactInfo();
				contactInfo2.Value = vCard_t.TELList[j].number.Replace("-", string.Empty);
				if (vCard_t.TELList[j].type == 1)
				{
					contactInfo2.Type = Utility.GetResourceString("IDS_CHATON_BODY_HOME") + " " + Utility.GetResourceString("IDS_CHATON_ITAB_PHONE_NUMBER");
				}
				else if (vCard_t.TELList[j].type == 2)
				{
					contactInfo2.Type = Utility.GetResourceString("IDS_CHATON_BODY_WORK") + " " + Utility.GetResourceString("IDS_CHATON_ITAB_PHONE_NUMBER");
				}
				else if (vCard_t.TELList[j].type == 64)
				{
					contactInfo2.Type = Utility.GetResourceString("IDS_CHATON_BODY_MOBILE") + " " + Utility.GetResourceString("IDS_CHATON_ITAB_PHONE_NUMBER");
				}
				else
				{
					contactInfo2.Type = Utility.GetResourceString("IDS_CHATON_ITAB_PHONE_NUMBER");
				}
				_contactInfos.Add(contactInfo2);
			}
		}
	}

	private void backButton_Click(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public void InitializeComponent()
	{
		//IL_002d: Unknown result type (might be due to invalid IL or missing references)
		//IL_0037: Expected O, but got Unknown
		//IL_0043: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///ContactDetailPage.xaml"), (ComponentResourceLocation)0);
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			ContactInfoGridView = (ListView)((FrameworkElement)this).FindName("ContactInfoGridView");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			ContactNameText = (TextBlock)((FrameworkElement)this).FindName("ContactNameText");
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
		if (connectionId == 1)
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click));
		}
		_contentLoaded = true;
	}
}
