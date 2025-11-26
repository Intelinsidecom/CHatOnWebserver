using System;
using System.CodeDom.Compiler;
using System.Diagnostics;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Services;
using Windows.UI.Popups;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Controls.Primitives;
using Windows.UI.Xaml.Markup;

namespace ChatON_WoA.Views;

public sealed class SelectACSOptionPage : Page, IComponentConnector
{
	public class LanguageData : NotificationObject
	{
		private string _name;

		private string _code;

		private string _keyword;

		public string Keyword
		{
			get
			{
				return _keyword;
			}
			set
			{
				_keyword = value;
			}
		}

		public string Code
		{
			get
			{
				return _code;
			}
			set
			{
				_code = value;
			}
		}

		public string Name
		{
			get
			{
				return _name;
			}
			set
			{
				_name = value;
			}
		}

		public LanguageData()
		{
		}

		public LanguageData(string name, string code)
		{
			_name = name;
			_code = code;
			_keyword = "";
		}

		public override string ToString()
		{
			if (string.IsNullOrEmpty(_code))
			{
				return _name;
			}
			return _name;
		}
	}

	private static LanguageData[] _languageData = new LanguageData[36]
	{
		new LanguageData("English", "en_US"),
		new LanguageData("Japanese", "ja_JP"),
		new LanguageData("Korean", "ko_KR"),
		new LanguageData("Uzbek", "uz_UZ"),
		new LanguageData("Dutch", "nl_DE"),
		new LanguageData("Hindi", "hi_IN"),
		new LanguageData("Italian", "it_IT"),
		new LanguageData("Norwegian", "no_NO"),
		new LanguageData("Persian", "fa"),
		new LanguageData("Russian", "ru_RU"),
		new LanguageData("Sri Lankan (Sinhala)", "si_LK"),
		new LanguageData("Swedish", "sv_SE"),
		new LanguageData("Turkish", "tr_TR"),
		new LanguageData("Arabic", "ar_SA"),
		new LanguageData("Bengali", "bn_BD"),
		new LanguageData("Chinese (Mandarin)", "zh_CN"),
		new LanguageData("German", "de_AR"),
		new LanguageData("French", "fr_FR"),
		new LanguageData("Greek", "el_GR"),
		new LanguageData("Chinese (Cantonese)", "zh_HK"),
		new LanguageData("Malay", "in_ID"),
		new LanguageData("Filipino", "tl_PH"),
		new LanguageData("Mongolian", "mn_MN"),
		new LanguageData("Nepali", "ne_NP"),
		new LanguageData("Polish", "pl_PL"),
		new LanguageData("Portuguese", "pt_BR"),
		new LanguageData("Cambodian (Khmer)", "km_KH"),
		new LanguageData("Romanian", "ro_RO"),
		new LanguageData("Spanish", "es_ES"),
		new LanguageData("Thai", "th_TH"),
		new LanguageData("Urdu", "ur_PK"),
		new LanguageData("Vietnamese", "vi_VN"),
		new LanguageData("Hebrew", "he_IL"),
		new LanguageData("Danish", "da_DK"),
		new LanguageData("Burmese", "my_MM"),
		new LanguageData("Czech", "cs_CZ")
	};

	private SSMService _ssmService;

	private string _language;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Page pageRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Grid LayoutRoot;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock Text1;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private ComboBox ComboBoxControl;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button NextButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private Button backButton;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private TextBlock pageTitle;

	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	private bool _contentLoaded;

	public static LanguageData[] Languages => _languageData;

	public SelectACSOptionPage()
	{
		InitializeComponent();
		((FrameworkElement)this).put_DataContext((object)this);
		((Selector)ComboBoxControl).put_SelectedIndex(0);
		string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_YOU_WILL_RECEIVE_AN_AUTOMATIC_CALL_FROM_CHATON_USE_THE_PD_DIGIT_NUMBER_YOU_HEAR_DURING_THE_CALL_TO_ACTIVATE_YOUR_CHATON_ACCOUNT_EXAMPLE_MSG");
		resourceString = resourceString.Replace("%d", "4");
		resourceString = resourceString.Replace("%s", "1234");
		Text1.put_Text(resourceString);
		_ssmService = new SSMService();
		_ssmService.GetACSTokenCompleted += _ssmService_GetACSTokenCompleted;
		_ssmService.SendACSCompleted += _ssmService_SendACSCompleted;
	}

	private void NextButton_Click_1(object sender, RoutedEventArgs e)
	{
		LanguageData languageData = null;
		if (((Selector)ComboBoxControl).SelectedItem is LanguageData languageData2)
		{
			_language = languageData2.Code;
			sendACS(RegistrationService.GetUserAccount());
		}
	}

	private void backButton_Click_1(object sender, RoutedEventArgs e)
	{
		((Page)this).Frame.GoBack();
	}

	private void _ssmService_GetACSTokenCompleted(object sender, SSMCompletedEventArgs e)
	{
		if (e.Error != null)
		{
			LoadingIndicator.StopLoading();
			SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			_ssmService.SendACS(_language);
		}
	}

	private void sendACS(UserAccountInfo account)
	{
		if (LoadingIndicator.ActiveIndicator != null)
		{
			LoadingIndicator.StopLoading();
		}
		LoadingIndicator.StartLoading((Page)(object)this, (Panel)(object)LayoutRoot);
		_ssmService.GetACSToken();
	}

	private void _ssmService_SendACSCompleted(object sender, SSMCompletedEventArgs e)
	{
		//IL_005a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0060: Expected O, but got Unknown
		if (!string.IsNullOrEmpty(e.ErrorMessage))
		{
			if (e.ErrorMessage.Contains("CSS-22005"))
			{
				LoadingIndicator.StopLoading();
				string resourceString = Utility.GetResourceString("IDS_CHATON_BODY_TOO_MANY_ATTEMPTS_TRY_AGAIN_AFTER_PD_HOURS");
				resourceString = resourceString.Replace("%d", "{0:d}");
				resourceString = string.Format(resourceString, new object[1] { 24 });
				MessageDialog val = new MessageDialog(resourceString);
				val.ShowAsync();
			}
			else if (e.ErrorMessage.Contains("CSS-22002"))
			{
				_ssmService.GetACSToken();
			}
		}
		else if (e.Error != null)
		{
			LoadingIndicator.StopLoading();
			SSMService.ShowCommonErrorMessage(e);
		}
		else
		{
			LoadingIndicator.StopLoading();
			SettingService.SetCodeSentTime(DateTime.Now.Ticks);
			((Page)this).Frame.GoBack();
			((Page)this).Frame.Navigate(typeof(InputVerificationCodePage));
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
		//IL_0059: Unknown result type (might be due to invalid IL or missing references)
		//IL_0063: Expected O, but got Unknown
		//IL_006f: Unknown result type (might be due to invalid IL or missing references)
		//IL_0079: Expected O, but got Unknown
		//IL_0085: Unknown result type (might be due to invalid IL or missing references)
		//IL_008f: Expected O, but got Unknown
		//IL_009b: Unknown result type (might be due to invalid IL or missing references)
		//IL_00a5: Expected O, but got Unknown
		//IL_00b1: Unknown result type (might be due to invalid IL or missing references)
		//IL_00bb: Expected O, but got Unknown
		if (!_contentLoaded)
		{
			_contentLoaded = true;
			Application.LoadComponent((object)this, new Uri("ms-appx:///SelectACSOptionPage.xaml"), (ComponentResourceLocation)0);
			pageRoot = (Page)((FrameworkElement)this).FindName("pageRoot");
			LayoutRoot = (Grid)((FrameworkElement)this).FindName("LayoutRoot");
			Text1 = (TextBlock)((FrameworkElement)this).FindName("Text1");
			ComboBoxControl = (ComboBox)((FrameworkElement)this).FindName("ComboBoxControl");
			NextButton = (Button)((FrameworkElement)this).FindName("NextButton");
			backButton = (Button)((FrameworkElement)this).FindName("backButton");
			pageTitle = (TextBlock)((FrameworkElement)this).FindName("pageTitle");
		}
	}

	[DebuggerNonUserCode]
	[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", " 4.0.0.0")]
	public unsafe void Connect(int connectionId, object target)
	{
		//IL_0015: Unknown result type (might be due to invalid IL or missing references)
		//IL_001b: Expected O, but got Unknown
		//IL_003a: Unknown result type (might be due to invalid IL or missing references)
		//IL_0044: Expected O, but got Unknown
		//IL_0047: Unknown result type (might be due to invalid IL or missing references)
		//IL_004d: Expected O, but got Unknown
		//IL_006c: Unknown result type (might be due to invalid IL or missing references)
		//IL_0076: Expected O, but got Unknown
		switch (connectionId)
		{
		case 1:
		{
			ButtonBase val2 = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val2, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(NextButton_Click_1));
			break;
		}
		case 2:
		{
			ButtonBase val = (ButtonBase)target;
			WindowsRuntimeMarshal.AddEventHandler(new Func<RoutedEventHandler, EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.add_Click)), new Action<EventRegistrationToken>(val, (nint)__ldftn(ButtonBase.remove_Click)), new RoutedEventHandler(backButton_Click_1));
			break;
		}
		}
		_contentLoaded = true;
	}
}
