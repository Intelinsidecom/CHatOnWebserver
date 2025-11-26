using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Diagnostics;
using ChatON_WoA.Common;
using ChatON_WoA.Controls;
using ChatON_WoA.DataModel;
using ChatON_WoA.SNSControl;
using ChatON_WoA.ViewModels;
using ChatON_WoA.Views;
using ChatOn.Controls;
using ChatOn.Infrastructure;
using ChatOn.Models;
using ChatOn.Services;
using ChatOn.ViewModels;
using SDatabase;
using Windows.Foundation;
using Windows.Networking.BackgroundTransfer;
using Windows.Storage;
using Windows.Storage.FileProperties;
using Windows.UI.Input;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Documents;
using Windows.UI.Xaml.Markup;
using Windows.UI.Xaml.Media;
using Windows.UI.Xaml.Media.Imaging;
using Windows.UI.Xaml.Shapes;

namespace ChatON_WoA.ChatON_WoA_XamlTypeInfo;

[GeneratedCode("Microsoft.Windows.UI.Xaml.Build.Tasks", "4.0.0.0")]
[DebuggerNonUserCode]
internal class XamlTypeInfoProvider
{
	private Dictionary<string, IXamlType> _xamlTypes = new Dictionary<string, IXamlType>();

	private Dictionary<string, IXamlMember> _xamlMembers = new Dictionary<string, IXamlMember>();

	private Dictionary<Type, string> _xamlTypeToStandardName = new Dictionary<Type, string>();

	public IXamlType GetXamlTypeByType(Type type)
	{
		IXamlType val = null;
		if (_xamlTypeToStandardName.TryGetValue(type, out var value))
		{
			return GetXamlTypeByName(value);
		}
		return GetXamlTypeByName(type.FullName);
	}

	public IXamlType GetXamlTypeByName(string typeName)
	{
		if (string.IsNullOrEmpty(typeName))
		{
			return null;
		}
		if (_xamlTypes.TryGetValue(typeName, out var value))
		{
			return value;
		}
		value = CreateXamlType(typeName);
		if (value != null)
		{
			_xamlTypes.Add(typeName, value);
		}
		return value;
	}

	public IXamlMember GetMemberByLongName(string longMemberName)
	{
		if (string.IsNullOrEmpty(longMemberName))
		{
			return null;
		}
		if (_xamlMembers.TryGetValue(longMemberName, out var value))
		{
			return value;
		}
		value = CreateXamlMember(longMemberName);
		if (value != null)
		{
			_xamlMembers.Add(longMemberName, value);
		}
		return value;
	}

	private void AddToMapOfTypeToStandardName(Type t, string str)
	{
		if (!_xamlTypeToStandardName.ContainsKey(t))
		{
			_xamlTypeToStandardName.Add(t, str);
		}
	}

	private object Activate_0_InternationalPhonenumberConverter()
	{
		return new InternationalPhonenumberConverter();
	}

	private object Activate_1_ReverseBoolConverter()
	{
		return new ReverseBoolConverter();
	}

	private object Activate_2_MessageStateToSubTextVisibility()
	{
		return new MessageStateToSubTextVisibility();
	}

	private object Activate_3_ChatTodayImageConverter()
	{
		return new ChatTodayImageConverter();
	}

	private object Activate_4_WidthToGridRowConverter()
	{
		return new WidthToGridRowConverter();
	}

	private object Activate_5_WidthToGridColConverter()
	{
		return new WidthToGridColConverter();
	}

	private object Activate_6_ResourceStringConverter()
	{
		return new ResourceStringConverter();
	}

	private object Activate_7_ResourceStringLowerCaseConverter()
	{
		return new ResourceStringLowerCaseConverter();
	}

	private object Activate_8_DateToTimePolicyValue()
	{
		return new DateToTimePolicyValue();
	}

	private object Activate_9_IndexToTemplate()
	{
		return new IndexToTemplate();
	}

	private object Activate_10_PhoneNumbersToNames()
	{
		return new PhoneNumbersToNames();
	}

	private object Activate_11_MiliToChatDetailDateConverter()
	{
		return new MiliToChatDetailDateConverter();
	}

	private object Activate_12_NotiToMessageConverter()
	{
		return new NotiToMessageConverter();
	}

	private object Activate_13_CountToDoubleValue()
	{
		return new CountToDoubleValue();
	}

	private object Activate_14_BiggerThanParamToVisibility()
	{
		return new BiggerThanParamToVisibility();
	}

	private object Activate_15_SmallerThanParamToVisibility()
	{
		return new SmallerThanParamToVisibility();
	}

	private object Activate_16_IntEqualToVisibility()
	{
		return new IntEqualToVisibility();
	}

	private object Activate_17_IntNotEqualToVisibility()
	{
		return new IntNotEqualToVisibility();
	}

	private object Activate_18_BoolToVisibility()
	{
		return new BoolToVisibility();
	}

	private object Activate_19_ReverseBoolToVisibility()
	{
		return new ReverseBoolToVisibility();
	}

	private object Activate_20_StringToUriConverter()
	{
		return new StringToUriConverter();
	}

	private object Activate_21_PhoneNumberToChatFrameVisibility()
	{
		return new PhoneNumberToChatFrameVisibility();
	}

	private object Activate_22_PhoneNumberToNameConverter()
	{
		return new PhoneNumberToNameConverter();
	}

	private object Activate_23_MessageStateToVisibility()
	{
		return new MessageStateToVisibility();
	}

	private object Activate_24_MessageStateToOpacity()
	{
		return new MessageStateToOpacity();
	}

	private object Activate_25_IsFavoriteToIconUri()
	{
		return new IsFavoriteToIconUri();
	}

	private object Activate_26_RankStatusConverter()
	{
		return new RankStatusConverter();
	}

	private object Activate_27_RankValueConverter()
	{
		return new RankValueConverter();
	}

	private object Activate_28_ReceivedCountStringConverter()
	{
		return new ReceivedCountStringConverter();
	}

	private object Activate_29_SentCountStringConverter()
	{
		return new SentCountStringConverter();
	}

	private object Activate_30_StringCompToVisibility()
	{
		return new StringCompToVisibility();
	}

	private object Activate_31_StringCompToHide()
	{
		return new StringCompToHide();
	}

	private object Activate_32_StringNullOrEmptyToHide()
	{
		return new StringNullOrEmptyToHide();
	}

	private object Activate_33_MillisecondsToDate()
	{
		return new MillisecondsToDate();
	}

	private object Activate_34_DateTimeStringConverter()
	{
		return new DateTimeStringConverter();
	}

	private object Activate_35_BoolToTemplate()
	{
		return new BoolToTemplate();
	}

	private object Activate_36_ObjectNullToShow()
	{
		return new ObjectNullToShow();
	}

	private object Activate_37_ObjectNullToHide()
	{
		return new ObjectNullToHide();
	}

	private object Activate_38_IntCompToBool()
	{
		return new IntCompToBool();
	}

	private object Activate_39_StringFormatConverter()
	{
		return new StringFormatConverter();
	}

	private object Activate_40_SelectedIndexToOpacity()
	{
		return new SelectedIndexToOpacity();
	}

	private object Activate_41_TextInfoToFlowDirection()
	{
		return new TextInfoToFlowDirection();
	}

	private object Activate_42_ObjectCountToHide()
	{
		return new ObjectCountToHide();
	}

	private object Activate_43_ObjectCountToShow()
	{
		return new ObjectCountToShow();
	}

	private object Activate_44_AniconButtonTextConverter()
	{
		return new AniconButtonTextConverter();
	}

	private object Activate_45_SearchBuddyHighlightConverter()
	{
		return new SearchBuddyHighlightConverter();
	}

	private object Activate_46_GroupNameConverter()
	{
		return new GroupNameConverter();
	}

	private object Activate_47_InteractionVisibilityConverter()
	{
		return new InteractionVisibilityConverter();
	}

	private object Activate_48_BackgroundVisibilityConverter()
	{
		return new BackgroundVisibilityConverter();
	}

	private object Activate_49_BuddyStatusConverter()
	{
		return new BuddyStatusConverter();
	}

	private object Activate_50_ChatTypeToShow()
	{
		return new ChatTypeToShow();
	}

	private object Activate_51_SelectedIndexToBackground()
	{
		return new SelectedIndexToBackground();
	}

	private object Activate_52_SelectedIndexToForeground()
	{
		return new SelectedIndexToForeground();
	}

	private object Activate_53_TotalMemberConverter()
	{
		return new TotalMemberConverter();
	}

	private object Activate_54_StretchConverter()
	{
		return new StretchConverter();
	}

	private object Activate_55_UnreadMessageCountConverter()
	{
		return new UnreadMessageCountConverter();
	}

	private object Activate_56_AutoWidthConverter()
	{
		return new AutoWidthConverter();
	}

	private object Activate_57_ChatBackgroundConverter()
	{
		return new ChatBackgroundConverter();
	}

	private object Activate_58_MessagePreviewConverter()
	{
		return new MessagePreviewConverter();
	}

	private object Activate_59_SnapButtonSendMarginConverter()
	{
		return new SnapButtonSendMarginConverter();
	}

	private object Activate_60_InputTextWidthConverter()
	{
		return new InputTextWidthConverter();
	}

	private object Activate_61_ButtonSendWidthConverter()
	{
		return new ButtonSendWidthConverter();
	}

	private object Activate_62_SnapInputBoxMarginConverter()
	{
		return new SnapInputBoxMarginConverter();
	}

	private object Activate_63_ButtonSendHeightConverter()
	{
		return new ButtonSendHeightConverter();
	}

	private object Activate_64_ImageProfileSizeConverter()
	{
		return new ImageProfileSizeConverter();
	}

	private object Activate_65_ImageFrameSizeConverter()
	{
		return new ImageFrameSizeConverter();
	}

	private object Activate_66_ChatNameMarginConverter()
	{
		return new ChatNameMarginConverter();
	}

	private object Activate_67_DummyGridMarginConverter()
	{
		return new DummyGridMarginConverter();
	}

	private object Activate_68_ChatBubbleMarginConverter()
	{
		return new ChatBubbleMarginConverter();
	}

	private object Activate_69_DefaultMessageMarginConverter()
	{
		return new DefaultMessageMarginConverter();
	}

	private object Activate_70_BuddyMessageMarginConverter()
	{
		return new BuddyMessageMarginConverter();
	}

	private object Activate_71_ProgressDownloadUploadWidthConverter()
	{
		return new ProgressDownloadUploadWidthConverter();
	}

	private object Activate_72_InputBoxHeightConverter()
	{
		return new InputBoxHeightConverter();
	}

	private object Activate_73_LongToDateOnUpdatesConverter()
	{
		return new LongToDateOnUpdatesConverter();
	}

	private object Activate_74_ReverseVisibility()
	{
		return new ReverseVisibility();
	}

	private object Activate_75_QueueEngine()
	{
		return new QueueEngine();
	}

	private object Activate_76_AboutPage()
	{
		return new AboutPage();
	}

	private object Activate_77_DateChooser()
	{
		return new DateChooser();
	}

	private object Activate_80_AddBirthdayDialog()
	{
		return new AddBirthdayDialog();
	}

	private object Activate_81_UserProfile()
	{
		return new UserProfile();
	}

	private object Activate_82_NotificationObject()
	{
		return new NotificationObject();
	}

	private object Activate_83_AddBuddiesSayDialog()
	{
		return new AddBuddiesSayDialog();
	}

	private object Activate_84_ImageButton()
	{
		return new ImageButton();
	}

	private object Activate_85_AddBuddyDialog()
	{
		return new AddBuddyDialog();
	}

	private object Activate_86_ObservableCollection()
	{
		return new ObservableCollection<Buddy>();
	}

	private object Activate_87_Collection()
	{
		return new Collection<Buddy>();
	}

	private object Activate_88_Buddy()
	{
		return new Buddy();
	}

	private object Activate_89_SDBData()
	{
		return new SDBData();
	}

	private object Activate_94_List()
	{
		return new List<string>();
	}

	private object Activate_95_SDBIndex()
	{
		return new SDBIndex();
	}

	private object Activate_96_ObservableCollection()
	{
		return new ObservableCollection<TellFriendsItem>();
	}

	private object Activate_97_Collection()
	{
		return new Collection<TellFriendsItem>();
	}

	private object Activate_98_TellFriendsItem()
	{
		return new TellFriendsItem();
	}

	private object Activate_99_AddGroupDialog()
	{
		return new AddGroupDialog();
	}

	private object Activate_100_BuddyGroup()
	{
		return new BuddyGroup();
	}

	private object Activate_101_AniconPlayer()
	{
		return new AniconPlayer();
	}

	private object Activate_102_BindRichTextBlock()
	{
		return new BindRichTextBlock();
	}

	private object Activate_103_BlindListPage()
	{
		return new BlindListPage();
	}

	private object Activate_104_BlockListPage()
	{
		return new BlockListPage();
	}

	private object Activate_106_BracketConverter()
	{
		return new BracketConverter();
	}

	private object Activate_107_GroupMembersToCountConverter()
	{
		return new GroupMembersToCountConverter();
	}

	private object Activate_108_MyTemplateSelector()
	{
		return new MyTemplateSelector();
	}

	private object Activate_109_BuddyListPage()
	{
		return new BuddyListPage();
	}

	private object Activate_110_BuddyProfileDialog()
	{
		return new BuddyProfileDialog();
	}

	private object Activate_111_CalendarDetailPage()
	{
		return new CalendarDetailPage();
	}

	private object Activate_113_ChatTextBlock()
	{
		return new ChatTextBlock();
	}

	private object Activate_114_ChatBubble()
	{
		return new ChatBubble();
	}

	private object Activate_115_Message()
	{
		return new Message();
	}

	private object Activate_116_DateDisplayUserControl()
	{
		return new DateDisplayUserControl();
	}

	private object Activate_117_ProgressRing2()
	{
		return new ProgressRing2();
	}

	private object Activate_118_ChatDetailPage()
	{
		return new ChatDetailPage();
	}

	private object Activate_120_GestureRecognizer()
	{
		//IL_0000: Unknown result type (might be due to invalid IL or missing references)
		//IL_0006: Expected O, but got Unknown
		return (object)new GestureRecognizer();
	}

	private object Activate_121_EmoticonChooser()
	{
		return new EmoticonChooser();
	}

	private object Activate_122_ObservableCollection()
	{
		return new ObservableCollection<OfflineAniconPackage>();
	}

	private object Activate_123_Collection()
	{
		return new Collection<OfflineAniconPackage>();
	}

	private object Activate_124_OfflineAniconPackage()
	{
		return new OfflineAniconPackage();
	}

	private object Activate_126_AniconPackage()
	{
		return new AniconPackage();
	}

	private object Activate_127_ObservableCollection()
	{
		return new ObservableCollection<Anicon>();
	}

	private object Activate_128_Collection()
	{
		return new Collection<Anicon>();
	}

	private object Activate_129_Anicon()
	{
		return new Anicon();
	}

	private object Activate_131_List()
	{
		return new List<StorageFile>();
	}

	private object Activate_140_List()
	{
		return new List<BitmapImage>();
	}

	private object Activate_141_ChatListPage()
	{
		return new ChatListPage();
	}

	private object Activate_142_ChatProfilePage()
	{
		return new ChatProfilePage();
	}

	private object Activate_144_ChatSettingPage()
	{
		return new ChatSettingPage();
	}

	private object Activate_145_DelayedLoadControl()
	{
		return new DelayedLoadControl();
	}

	private object Activate_147_AddFriendsFacebookPage()
	{
		return new AddFriendsFacebookPage();
	}

	private object Activate_148_BuddySayItemControl()
	{
		return new BuddySayItemControl();
	}

	private object Activate_149_RingSlice()
	{
		return new RingSlice();
	}

	private object Activate_151_CountdownControl()
	{
		return new CountdownControl();
	}

	private object Activate_152_ImageDelayControl()
	{
		return new ImageDelayControl();
	}

	private object Activate_153_PopupControl()
	{
		return new PopupControl();
	}

	private object Activate_154_SampleChatBubble()
	{
		return new SampleChatBubble();
	}

	private object Activate_155_CustomCameraCapture()
	{
		return new CustomCameraCapture();
	}

	private object Activate_156_FontSizePopUp()
	{
		return new FontSizePopUp();
	}

	private object Activate_157_NewUpdatesPage()
	{
		return new NewUpdatesPage();
	}

	private object Activate_158_SplashScreenPage()
	{
		return new SplashScreenPage();
	}

	private object Activate_159_TrunkDetailFullViewPage()
	{
		return new TrunkDetailFullViewPage();
	}

	private object Activate_160_UnknownBuddyProfileDialog()
	{
		return new UnknownBuddyProfileDialog();
	}

	private object Activate_161_UnknownUser()
	{
		return new UnknownUser();
	}

	private object Activate_162_InvitationTwitterPage()
	{
		return new InvitationTwitterPage();
	}

	private object Activate_163_TellFriendsTwitterPage()
	{
		return new TellFriendsTwitterPage();
	}

	private object Activate_164_ManageAccountPage()
	{
		return new ManageAccountPage();
	}

	private object Activate_165_MultiDeviceInfoPage()
	{
		return new MultiDeviceInfoPage();
	}

	private object Activate_167_SamsungAccountSignupDialog()
	{
		return new SamsungAccountSignupDialog();
	}

	private object Activate_168_TwitterConnector()
	{
		return new TwitterConnector();
	}

	private object Activate_169_SplashPopup()
	{
		return new SplashPopup();
	}

	private object Activate_170_StartGuidePage()
	{
		return new StartGuidePage();
	}

	private object Activate_171_SuggestionsPage()
	{
		return new SuggestionsPage();
	}

	private object Activate_172_SyncIntroPage()
	{
		return new SyncIntroPage();
	}

	private object Activate_173_TellFriendsFacebookPage()
	{
		return new TellFriendsFacebookPage();
	}

	private object Activate_174_TrunkDetailPage()
	{
		return new TrunkDetailPage();
	}

	private object Activate_175_UnreadCountToBubbleimage()
	{
		return new UnreadCountToBubbleimage();
	}

	private object Activate_176_TrunkPage()
	{
		return new TrunkPage();
	}

	private object Activate_177_ContactDetailPage()
	{
		return new ContactDetailPage();
	}

	private object Activate_178_ObservableCollection()
	{
		return new ObservableCollection<ContactDetailPage.ContactInfo>();
	}

	private object Activate_179_Collection()
	{
		return new Collection<ContactDetailPage.ContactInfo>();
	}

	private object Activate_181_CropPage()
	{
		return new CropPage();
	}

	private object Activate_183_DisclaimerKoreaPage()
	{
		return new DisclaimerKoreaPage();
	}

	private object Activate_184_DisclaimerPage()
	{
		return new DisclaimerPage();
	}

	private object Activate_185_DownloadSettingPage()
	{
		return new DownloadSettingPage();
	}

	private object Activate_187_EditProfilePage()
	{
		return new EditProfilePage();
	}

	private object Activate_188_BoolToEmoticonChooserTemplate()
	{
		return new BoolToEmoticonChooserTemplate();
	}

	private object Activate_189_EmptyBuddyListPage()
	{
		return new EmptyBuddyListPage();
	}

	private object Activate_190_EmptyChatListPage()
	{
		return new EmptyChatListPage();
	}

	private object Activate_191_GeneralSettingPage()
	{
		return new GeneralSettingPage();
	}

	private object Activate_192_GroupProfileDialog()
	{
		return new GroupProfileDialog();
	}

	private object Activate_194_HiddenInteractionPage()
	{
		return new HiddenInteractionPage();
	}

	private object Activate_196_HilightedTextBlock()
	{
		return new HilightedTextBlock();
	}

	private object Activate_197_ImageButtonBase()
	{
		return new ImageButtonBase();
	}

	private object Activate_198_ImageViewer()
	{
		return new ImageViewer();
	}

	private object Activate_199_InputNamePage()
	{
		return new InputNamePage();
	}

	private object Activate_200_InputPasswordPage()
	{
		return new InputPasswordPage();
	}

	private object Activate_201_InputPhoneNumberPage()
	{
		return new InputPhoneNumberPage();
	}

	private object Activate_202_InputVerificationCodePage()
	{
		return new InputVerificationCodePage();
	}

	private object Activate_203_RatioChart()
	{
		return new RatioChart();
	}

	private object Activate_204_InteractionRankPage()
	{
		return new InteractionRankPage();
	}

	private object Activate_205_InvitationPage()
	{
		return new InvitationPage();
	}

	private object Activate_206_LoadingIndicator()
	{
		return new LoadingIndicator();
	}

	private object Activate_207_MainPage()
	{
		return new MainPage();
	}

	private object Activate_208_ManageBuddiesPage()
	{
		return new ManageBuddiesPage();
	}

	private object Activate_209_MyPage()
	{
		return new MyPage();
	}

	private object Activate_210_NoticePage()
	{
		return new NoticePage();
	}

	private object Activate_211_NotificationSettingPage()
	{
		return new NotificationSettingPage();
	}

	private object Activate_212_PasswordSettingPopup()
	{
		return new PasswordSettingPopup();
	}

	private object Activate_213_PhotoFrame()
	{
		return new PhotoFrame();
	}

	private object Activate_214_PivotPage()
	{
		return new PivotPage();
	}

	private object Activate_215_PivotPageViewModel()
	{
		return new PivotPageViewModel();
	}

	private object Activate_216_PreviewAniconDialog()
	{
		return new PreviewAniconDialog();
	}

	private object Activate_217_PrivacyPage()
	{
		return new PrivacyPage();
	}

	private object Activate_218_ProfileImageViewerPage()
	{
		return new ProfileImageViewerPage();
	}

	private object Activate_220_BindingService()
	{
		return new BindingService();
	}

	private object Activate_221_SearchBuddyPage()
	{
		return new SearchBuddyPage();
	}

	private object Activate_222_SelectACSOptionPage()
	{
		return new SelectACSOptionPage();
	}

	private object Activate_223_SelectBackgroundPopup()
	{
		return new SelectBackgroundPopup();
	}

	private object Activate_224_SelectBubbleStylePopup()
	{
		return new SelectBubbleStylePopup();
	}

	private object Activate_225_SelectBuddyTemplateSelector()
	{
		return new SelectBuddyTemplateSelector();
	}

	private object Activate_226_SelectBuddyPage()
	{
		return new SelectBuddyPage();
	}

	private object Activate_227_SelectCountryCodeDialog()
	{
		return new SelectCountryCodeDialog();
	}

	private object Activate_228_WrapPanel()
	{
		return new WrapPanel();
	}

	private object Activate_229_SelectLanguagePage()
	{
		return new SelectLanguagePage();
	}

	private object Activate_230_SettingsPage()
	{
		return new SettingsPage();
	}

	private object Activate_231_SignOutDialog()
	{
		return new SignOutDialog();
	}

	private object Activate_232_SnappedChatListPage()
	{
		return new SnappedChatListPage();
	}

	private object Activate_233_SnappedChatPage()
	{
		return new SnappedChatPage();
	}

	private object Activate_234_SnappedRegistrationPage()
	{
		return new SnappedRegistrationPage();
	}

	private object Activate_235_FacebookConnector()
	{
		return new FacebookConnector();
	}

	private void VectorAdd_86_ObservableCollection(object instance, object item)
	{
		ICollection<Buddy> collection = (ICollection<Buddy>)instance;
		Buddy item2 = (Buddy)item;
		collection.Add(item2);
	}

	private void VectorAdd_87_Collection(object instance, object item)
	{
		ICollection<Buddy> collection = (ICollection<Buddy>)instance;
		Buddy item2 = (Buddy)item;
		collection.Add(item2);
	}

	private void VectorAdd_94_List(object instance, object item)
	{
		ICollection<string> collection = (ICollection<string>)instance;
		string item2 = (string)item;
		collection.Add(item2);
	}

	private void VectorAdd_96_ObservableCollection(object instance, object item)
	{
		ICollection<TellFriendsItem> collection = (ICollection<TellFriendsItem>)instance;
		TellFriendsItem item2 = (TellFriendsItem)item;
		collection.Add(item2);
	}

	private void VectorAdd_97_Collection(object instance, object item)
	{
		ICollection<TellFriendsItem> collection = (ICollection<TellFriendsItem>)instance;
		TellFriendsItem item2 = (TellFriendsItem)item;
		collection.Add(item2);
	}

	private void VectorAdd_122_ObservableCollection(object instance, object item)
	{
		ICollection<OfflineAniconPackage> collection = (ICollection<OfflineAniconPackage>)instance;
		OfflineAniconPackage item2 = (OfflineAniconPackage)item;
		collection.Add(item2);
	}

	private void VectorAdd_123_Collection(object instance, object item)
	{
		ICollection<OfflineAniconPackage> collection = (ICollection<OfflineAniconPackage>)instance;
		OfflineAniconPackage item2 = (OfflineAniconPackage)item;
		collection.Add(item2);
	}

	private void VectorAdd_127_ObservableCollection(object instance, object item)
	{
		ICollection<Anicon> collection = (ICollection<Anicon>)instance;
		Anicon item2 = (Anicon)item;
		collection.Add(item2);
	}

	private void VectorAdd_128_Collection(object instance, object item)
	{
		ICollection<Anicon> collection = (ICollection<Anicon>)instance;
		Anicon item2 = (Anicon)item;
		collection.Add(item2);
	}

	private void VectorAdd_131_List(object instance, object item)
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_000e: Expected O, but got Unknown
		ICollection<StorageFile> collection = (ICollection<StorageFile>)instance;
		StorageFile item2 = (StorageFile)item;
		collection.Add(item2);
	}

	private void VectorAdd_140_List(object instance, object item)
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		//IL_000e: Expected O, but got Unknown
		ICollection<BitmapImage> collection = (ICollection<BitmapImage>)instance;
		BitmapImage item2 = (BitmapImage)item;
		collection.Add(item2);
	}

	private void VectorAdd_178_ObservableCollection(object instance, object item)
	{
		ICollection<ContactDetailPage.ContactInfo> collection = (ICollection<ContactDetailPage.ContactInfo>)instance;
		ContactDetailPage.ContactInfo item2 = (ContactDetailPage.ContactInfo)item;
		collection.Add(item2);
	}

	private void VectorAdd_179_Collection(object instance, object item)
	{
		ICollection<ContactDetailPage.ContactInfo> collection = (ICollection<ContactDetailPage.ContactInfo>)instance;
		ContactDetailPage.ContactInfo item2 = (ContactDetailPage.ContactInfo)item;
		collection.Add(item2);
	}

	private IXamlType CreateXamlType(string typeName)
	{
		XamlSystemBaseType result = null;
		switch (typeName)
		{
		case "Object":
			result = new XamlSystemBaseType(typeName, typeof(object));
			break;
		case "Windows.UI.Xaml.Controls.Page":
			result = new XamlSystemBaseType(typeName, typeof(Page));
			break;
		case "Windows.UI.Xaml.Controls.UserControl":
			result = new XamlSystemBaseType(typeName, typeof(UserControl));
			break;
		case "Boolean":
			result = new XamlSystemBaseType(typeName, typeof(bool));
			break;
		case "String":
			result = new XamlSystemBaseType(typeName, typeof(string));
			break;
		case "Windows.UI.Xaml.Media.ImageSource":
			result = new XamlSystemBaseType(typeName, typeof(ImageSource));
			break;
		case "Windows.UI.Xaml.Media.Brush":
			result = new XamlSystemBaseType(typeName, typeof(Brush));
			break;
		case "Windows.UI.Xaml.Controls.ClickMode":
			result = new XamlSystemBaseType(typeName, typeof(ClickMode));
			break;
		case "Int32":
			result = new XamlSystemBaseType(typeName, typeof(int));
			break;
		case "Windows.UI.Xaml.Visibility":
			result = new XamlSystemBaseType(typeName, typeof(Visibility));
			break;
		case "Windows.UI.Xaml.Media.Imaging.BitmapImage":
			result = new XamlSystemBaseType(typeName, typeof(BitmapImage));
			break;
		case "Windows.UI.Xaml.Documents.Paragraph":
			result = new XamlSystemBaseType(typeName, typeof(Paragraph));
			break;
		case "Windows.UI.Xaml.Controls.DataTemplateSelector":
			result = new XamlSystemBaseType(typeName, typeof(DataTemplateSelector));
			break;
		case "Double":
			result = new XamlSystemBaseType(typeName, typeof(double));
			break;
		case "Windows.UI.Xaml.Media.SolidColorBrush":
			result = new XamlSystemBaseType(typeName, typeof(SolidColorBrush));
			break;
		case "Windows.UI.Xaml.UIElement":
			result = new XamlSystemBaseType(typeName, typeof(UIElement));
			break;
		case "Int64":
			result = new XamlSystemBaseType(typeName, typeof(long));
			break;
		case "Windows.UI.Xaml.Controls.Control":
			result = new XamlSystemBaseType(typeName, typeof(Control));
			break;
		case "Windows.UI.Xaml.DataTemplate":
			result = new XamlSystemBaseType(typeName, typeof(DataTemplate));
			break;
		case "Windows.UI.Xaml.Shapes.Path":
			result = new XamlSystemBaseType(typeName, typeof(Path));
			break;
		case "Windows.UI.Xaml.FrameworkElement":
			result = new XamlSystemBaseType(typeName, typeof(FrameworkElement));
			break;
		case "Windows.UI.Xaml.Controls.Grid":
			result = new XamlSystemBaseType(typeName, typeof(Grid));
			break;
		case "Windows.UI.Xaml.Controls.Button":
			result = new XamlSystemBaseType(typeName, typeof(Button));
			break;
		case "Windows.UI.Xaml.Controls.ContentControl":
			result = new XamlSystemBaseType(typeName, typeof(ContentControl));
			break;
		case "Windows.UI.Xaml.Media.Stretch":
			result = new XamlSystemBaseType(typeName, typeof(Stretch));
			break;
		case "Windows.UI.Xaml.Controls.TextBlock":
			result = new XamlSystemBaseType(typeName, typeof(TextBlock));
			break;
		case "Windows.UI.Xaml.Controls.Panel":
			result = new XamlSystemBaseType(typeName, typeof(Panel));
			break;
		case "Windows.UI.Xaml.Controls.Orientation":
			result = new XamlSystemBaseType(typeName, typeof(Orientation));
			break;
		case "ChatOn.Infrastructure.InternationalPhonenumberConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InternationalPhonenumberConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_0_InternationalPhonenumberConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ReverseBoolConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ReverseBoolConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_1_ReverseBoolConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.MessageStateToSubTextVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(MessageStateToSubTextVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_2_MessageStateToSubTextVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ChatTodayImageConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatTodayImageConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_3_ChatTodayImageConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.WidthToGridRowConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(WidthToGridRowConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_4_WidthToGridRowConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.WidthToGridColConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(WidthToGridColConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_5_WidthToGridColConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ResourceStringConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ResourceStringConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_6_ResourceStringConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ResourceStringLowerCaseConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ResourceStringLowerCaseConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_7_ResourceStringLowerCaseConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.DateToTimePolicyValue":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DateToTimePolicyValue), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_8_DateToTimePolicyValue;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.IndexToTemplate":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(IndexToTemplate), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_9_IndexToTemplate;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.PhoneNumbersToNames":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(PhoneNumbersToNames), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_10_PhoneNumbersToNames;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.MiliToChatDetailDateConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(MiliToChatDetailDateConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_11_MiliToChatDetailDateConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.NotiToMessageConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(NotiToMessageConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_12_NotiToMessageConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.CountToDoubleValue":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(CountToDoubleValue), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_13_CountToDoubleValue;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.BiggerThanParamToVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BiggerThanParamToVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_14_BiggerThanParamToVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.SmallerThanParamToVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SmallerThanParamToVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_15_SmallerThanParamToVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.IntEqualToVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(IntEqualToVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_16_IntEqualToVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.IntNotEqualToVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(IntNotEqualToVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_17_IntNotEqualToVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.BoolToVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BoolToVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_18_BoolToVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ReverseBoolToVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ReverseBoolToVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_19_ReverseBoolToVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.StringToUriConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(StringToUriConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_20_StringToUriConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.PhoneNumberToChatFrameVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(PhoneNumberToChatFrameVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_21_PhoneNumberToChatFrameVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.PhoneNumberToNameConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(PhoneNumberToNameConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_22_PhoneNumberToNameConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.MessageStateToVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(MessageStateToVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_23_MessageStateToVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.MessageStateToOpacity":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(MessageStateToOpacity), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_24_MessageStateToOpacity;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.IsFavoriteToIconUri":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(IsFavoriteToIconUri), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_25_IsFavoriteToIconUri;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.RankStatusConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(RankStatusConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_26_RankStatusConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.RankValueConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(RankValueConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_27_RankValueConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ReceivedCountStringConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ReceivedCountStringConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_28_ReceivedCountStringConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.SentCountStringConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SentCountStringConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_29_SentCountStringConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.StringCompToVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(StringCompToVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_30_StringCompToVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.StringCompToHide":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(StringCompToHide), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_31_StringCompToHide;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.StringNullOrEmptyToHide":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(StringNullOrEmptyToHide), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_32_StringNullOrEmptyToHide;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.MillisecondsToDate":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(MillisecondsToDate), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_33_MillisecondsToDate;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.DateTimeStringConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DateTimeStringConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_34_DateTimeStringConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.BoolToTemplate":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BoolToTemplate), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_35_BoolToTemplate;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ObjectNullToShow":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ObjectNullToShow), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_36_ObjectNullToShow;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ObjectNullToHide":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ObjectNullToHide), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_37_ObjectNullToHide;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.IntCompToBool":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(IntCompToBool), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_38_IntCompToBool;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.StringFormatConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(StringFormatConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_39_StringFormatConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.SelectedIndexToOpacity":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SelectedIndexToOpacity), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_40_SelectedIndexToOpacity;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.TextInfoToFlowDirection":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(TextInfoToFlowDirection), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_41_TextInfoToFlowDirection;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ObjectCountToHide":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ObjectCountToHide), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_42_ObjectCountToHide;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ObjectCountToShow":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ObjectCountToShow), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_43_ObjectCountToShow;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.AniconButtonTextConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(AniconButtonTextConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_44_AniconButtonTextConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.SearchBuddyHighlightConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SearchBuddyHighlightConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_45_SearchBuddyHighlightConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.GroupNameConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(GroupNameConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_46_GroupNameConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.InteractionVisibilityConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InteractionVisibilityConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_47_InteractionVisibilityConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.BackgroundVisibilityConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BackgroundVisibilityConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_48_BackgroundVisibilityConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.BuddyStatusConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BuddyStatusConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_49_BuddyStatusConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ChatTypeToShow":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatTypeToShow), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_50_ChatTypeToShow;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.SelectedIndexToBackground":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SelectedIndexToBackground), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_51_SelectedIndexToBackground;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.SelectedIndexToForeground":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SelectedIndexToForeground), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_52_SelectedIndexToForeground;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.TotalMemberConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(TotalMemberConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_53_TotalMemberConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.StretchConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(StretchConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_54_StretchConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.UnreadMessageCountConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(UnreadMessageCountConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_55_UnreadMessageCountConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.AutoWidthConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(AutoWidthConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_56_AutoWidthConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ChatBackgroundConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatBackgroundConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_57_ChatBackgroundConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.MessagePreviewConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(MessagePreviewConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_58_MessagePreviewConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.SnapButtonSendMarginConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SnapButtonSendMarginConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_59_SnapButtonSendMarginConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.InputTextWidthConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InputTextWidthConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_60_InputTextWidthConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ButtonSendWidthConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ButtonSendWidthConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_61_ButtonSendWidthConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.SnapInputBoxMarginConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SnapInputBoxMarginConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_62_SnapInputBoxMarginConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ButtonSendHeightConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ButtonSendHeightConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_63_ButtonSendHeightConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ImageProfileSizeConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ImageProfileSizeConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_64_ImageProfileSizeConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ImageFrameSizeConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ImageFrameSizeConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_65_ImageFrameSizeConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ChatNameMarginConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatNameMarginConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_66_ChatNameMarginConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.DummyGridMarginConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DummyGridMarginConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_67_DummyGridMarginConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ChatBubbleMarginConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatBubbleMarginConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_68_ChatBubbleMarginConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.DefaultMessageMarginConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DefaultMessageMarginConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_69_DefaultMessageMarginConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.BuddyMessageMarginConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BuddyMessageMarginConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_70_BuddyMessageMarginConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ProgressDownloadUploadWidthConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ProgressDownloadUploadWidthConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_71_ProgressDownloadUploadWidthConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.InputBoxHeightConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InputBoxHeightConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_72_InputBoxHeightConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.LongToDateOnUpdatesConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(LongToDateOnUpdatesConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_73_LongToDateOnUpdatesConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.ReverseVisibility":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ReverseVisibility), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_74_ReverseVisibility;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Services.QueueEngine":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(QueueEngine), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_75_QueueEngine;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.AboutPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(AboutPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_76_AboutPage;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.DateChooser":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DateChooser), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_77_DateChooser;
			xamlUserType.AddMemberName("SelectedDate");
			result = xamlUserType;
			break;
		}
		case "System.DateTime":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DateTime), GetXamlTypeByName("System.ValueType"));
			result = xamlUserType;
			break;
		}
		case "System.ValueType":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ValueType), GetXamlTypeByName("Object"));
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.AddBirthdayDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(AddBirthdayDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_80_AddBirthdayDialog;
			xamlUserType.AddMemberName("MyProfile");
			xamlUserType.AddMemberName("IsShowYear");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("SelectedDate");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Models.UserProfile":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(UserProfile), GetXamlTypeByName("ChatOn.Infrastructure.NotificationObject"));
			xamlUserType.Activator = Activate_81_UserProfile;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.NotificationObject":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(NotificationObject), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_82_NotificationObject;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.AddBuddiesSayDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(AddBuddiesSayDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_83_AddBuddiesSayDialog;
			xamlUserType.AddMemberName("PhoneNumber");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.ImageButton":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ImageButton), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_84_ImageButton;
			xamlUserType.AddMemberName("NormalImage");
			xamlUserType.AddMemberName("PressedImage");
			xamlUserType.AddMemberName("Text");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Foreground");
			xamlUserType.AddMemberName("DisabledImage");
			xamlUserType.AddMemberName("LightNormalImage");
			xamlUserType.AddMemberName("LightPressedImage");
			xamlUserType.AddMemberName("LightDisabledImage");
			xamlUserType.AddMemberName("ClickMode");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.AddBuddyDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(AddBuddyDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_85_AddBuddyDialog;
			xamlUserType.AddMemberName("ResultList");
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<Buddy>), "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.Buddy>");
			xamlUserType.AddMemberName("ResultList2");
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<Buddy>), "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.Buddy>");
			xamlUserType.AddMemberName("TellFriendsList");
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<TellFriendsItem>), "System.Collections.ObjectModel.ObservableCollection<ChatOn.Controls.TellFriendsItem>");
			xamlUserType.AddMemberName("_updateBuddyFromUploadAddressRunning");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			result = xamlUserType;
			break;
		}
		case "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.Buddy>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ObservableCollection<Buddy>), GetXamlTypeByName("System.Collections.ObjectModel.Collection<ChatOn.Models.Buddy>"));
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<Buddy>), "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.Buddy>");
			xamlUserType.Activator = Activate_86_ObservableCollection;
			xamlUserType.CollectionAdd = VectorAdd_86_ObservableCollection;
			result = xamlUserType;
			break;
		}
		case "System.Collections.ObjectModel.Collection<ChatOn.Models.Buddy>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Collection<Buddy>), GetXamlTypeByName("Object"));
			AddToMapOfTypeToStandardName(typeof(Collection<Buddy>), "System.Collections.ObjectModel.Collection<ChatOn.Models.Buddy>");
			xamlUserType.Activator = Activate_87_Collection;
			xamlUserType.CollectionAdd = VectorAdd_87_Collection;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Models.Buddy":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Buddy), GetXamlTypeByName("SDatabase.SDBData"));
			xamlUserType.Activator = Activate_88_Buddy;
			xamlUserType.AddMemberName("BuddyID");
			AddToMapOfTypeToStandardName(typeof(Guid), "Guid");
			xamlUserType.AddMemberName("Name");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("PhoneNumber");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Sainfo");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("OrgNumber");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Status");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Birthday");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Email");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("SamsungEmail");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("ImgStatus");
			AddToMapOfTypeToStandardName(typeof(Buddy.ProfileImgStatus), "ChatOn.Models.Buddy.ProfileImgStatus");
			xamlUserType.AddMemberName("Type");
			AddToMapOfTypeToStandardName(typeof(Buddy.BuddyType), "ChatOn.Models.Buddy.BuddyType");
			xamlUserType.AddMemberName("IsFavorite");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("SentCount");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("ReceivedCount");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("IsHideInteraction");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("Rank");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("IsShowPhoneNumber");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsBlind");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsBlindText");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsBlocked");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("ProfileName");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("MSISDNS");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("HasMultipleNumbers");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsSpecialBuddy");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("OrgPhoneNumberVisible");
			xamlUserType.AddMemberName("PhoneNumberList");
			AddToMapOfTypeToStandardName(typeof(List<string>), "System.Collections.Generic.List<String>");
			xamlUserType.AddMemberName("InteractionPoint");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("BestInteractionPoint");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("ThumbProfileImage");
			xamlUserType.AddMemberName("ProfileImage");
			xamlUserType.AddMemberName("DisplayRank");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("IndexString");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("IsChecked");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsNew");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("StatusForeground");
			xamlUserType.AddMemberName("Background");
			xamlUserType.AddMemberName("IsDownloading");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsInteractionDeleteMode");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			result = xamlUserType;
			break;
		}
		case "SDatabase.SDBData":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SDBData), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_89_SDBData;
			xamlUserType.AddMemberName("Index");
			xamlUserType.AddMemberName("Id");
			AddToMapOfTypeToStandardName(typeof(Guid), "Guid");
			result = xamlUserType;
			break;
		}
		case "Guid":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Guid), GetXamlTypeByName("System.ValueType"));
			AddToMapOfTypeToStandardName(typeof(Guid), "Guid");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Models.Buddy.ProfileImgStatus":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Buddy.ProfileImgStatus), GetXamlTypeByName("System.Enum"));
			AddToMapOfTypeToStandardName(typeof(Buddy.ProfileImgStatus), "ChatOn.Models.Buddy.ProfileImgStatus");
			xamlUserType.AddEnumValue("Updated", Buddy.ProfileImgStatus.Updated);
			xamlUserType.AddEnumValue("Deleted", Buddy.ProfileImgStatus.Deleted);
			xamlUserType.AddEnumValue("None", Buddy.ProfileImgStatus.None);
			xamlUserType.AddEnumValue("NoChanges", Buddy.ProfileImgStatus.NoChanges);
			result = xamlUserType;
			break;
		}
		case "System.Enum":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Enum), GetXamlTypeByName("System.ValueType"));
			result = xamlUserType;
			break;
		}
		case "ChatOn.Models.Buddy.BuddyType":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Buddy.BuddyType), GetXamlTypeByName("System.Enum"));
			AddToMapOfTypeToStandardName(typeof(Buddy.BuddyType), "ChatOn.Models.Buddy.BuddyType");
			xamlUserType.AddEnumValue("Normal", Buddy.BuddyType.Normal);
			xamlUserType.AddEnumValue("Unknown", Buddy.BuddyType.Unknown);
			result = xamlUserType;
			break;
		}
		case "System.Collections.Generic.List<String>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(List<string>), GetXamlTypeByName("Object"));
			AddToMapOfTypeToStandardName(typeof(List<string>), "System.Collections.Generic.List<String>");
			xamlUserType.Activator = Activate_94_List;
			xamlUserType.CollectionAdd = VectorAdd_94_List;
			result = xamlUserType;
			break;
		}
		case "SDatabase.SDBIndex":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SDBIndex), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_95_SDBIndex;
			result = xamlUserType;
			break;
		}
		case "System.Collections.ObjectModel.ObservableCollection<ChatOn.Controls.TellFriendsItem>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ObservableCollection<TellFriendsItem>), GetXamlTypeByName("System.Collections.ObjectModel.Collection<ChatOn.Controls.TellFriendsItem>"));
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<TellFriendsItem>), "System.Collections.ObjectModel.ObservableCollection<ChatOn.Controls.TellFriendsItem>");
			xamlUserType.Activator = Activate_96_ObservableCollection;
			xamlUserType.CollectionAdd = VectorAdd_96_ObservableCollection;
			result = xamlUserType;
			break;
		}
		case "System.Collections.ObjectModel.Collection<ChatOn.Controls.TellFriendsItem>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Collection<TellFriendsItem>), GetXamlTypeByName("Object"));
			AddToMapOfTypeToStandardName(typeof(Collection<TellFriendsItem>), "System.Collections.ObjectModel.Collection<ChatOn.Controls.TellFriendsItem>");
			xamlUserType.Activator = Activate_97_Collection;
			xamlUserType.CollectionAdd = VectorAdd_97_Collection;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.TellFriendsItem":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(TellFriendsItem), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_98_TellFriendsItem;
			xamlUserType.AddMemberName("Name");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.AddGroupDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(AddGroupDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_99_AddGroupDialog;
			xamlUserType.AddMemberName("Group");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Models.BuddyGroup":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BuddyGroup), GetXamlTypeByName("SDatabase.SDBData"));
			xamlUserType.Activator = Activate_100_BuddyGroup;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.AniconPlayer":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(AniconPlayer), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_101_AniconPlayer;
			xamlUserType.AddMemberName("SourceID");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.BindRichTextBlock":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BindRichTextBlock), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_102_BindRichTextBlock;
			xamlUserType.AddMemberName("Text");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.BlindListPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BlindListPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_103_BlindListPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.BlockListPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BlockListPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_104_BlockListPage;
			xamlUserType.AddMemberName("ViewModel");
			result = xamlUserType;
			break;
		}
		case "ChatOn.ViewModels.BlockListPageViewModel":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BlockListPageViewModel), GetXamlTypeByName("ChatOn.Infrastructure.NotificationObject"));
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.BracketConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BracketConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_106_BracketConverter;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.GroupMembersToCountConverter":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(GroupMembersToCountConverter), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_107_GroupMembersToCountConverter;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Common.MyTemplateSelector":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(MyTemplateSelector), GetXamlTypeByName("Windows.UI.Xaml.Controls.DataTemplateSelector"));
			xamlUserType.Activator = Activate_108_MyTemplateSelector;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.BuddyListPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BuddyListPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_109_BuddyListPage;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.BuddyProfileDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BuddyProfileDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_110_BuddyProfileDialog;
			xamlUserType.AddMemberName("BuddyInfo");
			xamlUserType.AddMemberName("ParentPage");
			xamlUserType.AddMemberName("IsRenameMode");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.CalendarDetailPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(CalendarDetailPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_111_CalendarDetailPage;
			xamlUserType.AddMemberName("CalInfo");
			AddToMapOfTypeToStandardName(typeof(CalendarDetailPage.CalendarInfo), "ChatON_WoA.Views.CalendarDetailPage.CalendarInfo");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.CalendarDetailPage.CalendarInfo":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(CalendarDetailPage.CalendarInfo), GetXamlTypeByName("Object"));
			AddToMapOfTypeToStandardName(typeof(CalendarDetailPage.CalendarInfo), "ChatON_WoA.Views.CalendarDetailPage.CalendarInfo");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.ChatTextBlock":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatTextBlock), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_113_ChatTextBlock;
			xamlUserType.AddMemberName("IsParsingLinkEnabled");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("EmoticonSize");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("ForegroundText");
			xamlUserType.AddMemberName("MaxLength");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("Text");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.ChatBubble":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatBubble), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_114_ChatBubble;
			xamlUserType.AddMemberName("Text");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("SubText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("MediaText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("SubParam");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("MaxBubbleWidth");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("Type");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("Message");
			xamlUserType.AddMemberName("FixedFontSize");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Models.Message":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Message), GetXamlTypeByName("SDatabase.SDBData"));
			xamlUserType.Activator = Activate_115_Message;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.DateDisplayUserControl":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DateDisplayUserControl), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_116_DateDisplayUserControl;
			xamlUserType.AddMemberName("ItemContent");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.ProgressRing2":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ProgressRing2), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_117_ProgressRing2;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.ChatDetailPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatDetailPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_118_ChatDetailPage;
			xamlUserType.AddMemberName("ListVerticalOffset");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("ListVerticalOffsetMediator");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("ViewModel");
			xamlUserType.AddMemberName("LastAddedTick");
			AddToMapOfTypeToStandardName(typeof(long), "Int64");
			xamlUserType.AddMemberName("IsMouseHold");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("TmpSender");
			AddToMapOfTypeToStandardName(typeof(object), "Object");
			xamlUserType.AddMemberName("Gr");
			result = xamlUserType;
			break;
		}
		case "ChatOn.ViewModels.ChatDetailPageViewModel":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatDetailPageViewModel), GetXamlTypeByName("ChatOn.Infrastructure.NotificationObject"));
			result = xamlUserType;
			break;
		}
		case "Windows.UI.Input.GestureRecognizer":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(GestureRecognizer), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_120_GestureRecognizer;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.EmoticonChooser":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(EmoticonChooser), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_121_EmoticonChooser;
			xamlUserType.AddMemberName("newPackage");
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<OfflineAniconPackage>), "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.OfflineAniconPackage>");
			xamlUserType.AddMemberName("Packages");
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<OfflineAniconPackage>), "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.OfflineAniconPackage>");
			result = xamlUserType;
			break;
		}
		case "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.OfflineAniconPackage>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ObservableCollection<OfflineAniconPackage>), GetXamlTypeByName("System.Collections.ObjectModel.Collection<ChatOn.Models.OfflineAniconPackage>"));
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<OfflineAniconPackage>), "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.OfflineAniconPackage>");
			xamlUserType.Activator = Activate_122_ObservableCollection;
			xamlUserType.CollectionAdd = VectorAdd_122_ObservableCollection;
			result = xamlUserType;
			break;
		}
		case "System.Collections.ObjectModel.Collection<ChatOn.Models.OfflineAniconPackage>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Collection<OfflineAniconPackage>), GetXamlTypeByName("Object"));
			AddToMapOfTypeToStandardName(typeof(Collection<OfflineAniconPackage>), "System.Collections.ObjectModel.Collection<ChatOn.Models.OfflineAniconPackage>");
			xamlUserType.Activator = Activate_123_Collection;
			xamlUserType.CollectionAdd = VectorAdd_123_Collection;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Models.OfflineAniconPackage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(OfflineAniconPackage), GetXamlTypeByName("SDatabase.SDBData"));
			xamlUserType.Activator = Activate_124_OfflineAniconPackage;
			xamlUserType.AddMemberName("DownloadOperation");
			xamlUserType.AddMemberName("IsSelected");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("ThumbImage");
			xamlUserType.AddMemberName("LoadTemplate");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsLoaded");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("CurrentPackage");
			xamlUserType.AddMemberName("ProxyUrl");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("PackageZipUrl");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("AniconList");
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<Anicon>), "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.Anicon>");
			xamlUserType.AddMemberName("IsDelegateImagesLoaded");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("Count");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("EndDate");
			AddToMapOfTypeToStandardName(typeof(long), "Int64");
			xamlUserType.AddMemberName("ErrorText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("ThumbImageUri");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("ThumbImageFile");
			xamlUserType.AddMemberName("isCancel");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("PackageID");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("XmlString");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			result = xamlUserType;
			break;
		}
		case "Windows.Networking.BackgroundTransfer.DownloadOperation":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DownloadOperation), GetXamlTypeByName("Object"));
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.DataModel.AniconPackage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(AniconPackage), GetXamlTypeByName("ChatOn.Infrastructure.NotificationObject"));
			xamlUserType.Activator = Activate_126_AniconPackage;
			result = xamlUserType;
			break;
		}
		case "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.Anicon>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ObservableCollection<Anicon>), GetXamlTypeByName("System.Collections.ObjectModel.Collection<ChatOn.Models.Anicon>"));
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<Anicon>), "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.Anicon>");
			xamlUserType.Activator = Activate_127_ObservableCollection;
			xamlUserType.CollectionAdd = VectorAdd_127_ObservableCollection;
			result = xamlUserType;
			break;
		}
		case "System.Collections.ObjectModel.Collection<ChatOn.Models.Anicon>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Collection<Anicon>), GetXamlTypeByName("Object"));
			AddToMapOfTypeToStandardName(typeof(Collection<Anicon>), "System.Collections.ObjectModel.Collection<ChatOn.Models.Anicon>");
			xamlUserType.Activator = Activate_128_Collection;
			xamlUserType.CollectionAdd = VectorAdd_128_Collection;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Models.Anicon":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Anicon), GetXamlTypeByName("ChatOn.Infrastructure.NotificationObject"));
			xamlUserType.Activator = Activate_129_Anicon;
			xamlUserType.AddMemberName("IsShowLoading");
			xamlUserType.AddMemberName("IsLoading");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsLoaded");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("MsgUrl");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("ID");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("DelegateImageFile");
			xamlUserType.AddMemberName("DelegateImage");
			xamlUserType.AddMemberName("ImageUrlList");
			AddToMapOfTypeToStandardName(typeof(List<string>), "System.Collections.Generic.List<String>");
			xamlUserType.AddMemberName("ImageFileList");
			AddToMapOfTypeToStandardName(typeof(List<StorageFile>), "System.Collections.Generic.List<Windows.Storage.StorageFile>");
			xamlUserType.AddMemberName("ImageList");
			AddToMapOfTypeToStandardName(typeof(List<BitmapImage>), "System.Collections.Generic.List<Windows.UI.Xaml.Media.Imaging.BitmapImage>");
			xamlUserType.AddMemberName("DelegateImageName");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			result = xamlUserType;
			break;
		}
		case "Windows.Storage.StorageFile":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(StorageFile), GetXamlTypeByName("Object"));
			xamlUserType.AddMemberName("ContentType");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("FileType");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Attributes");
			xamlUserType.AddMemberName("DateCreated");
			xamlUserType.AddMemberName("Name");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Path");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("DisplayName");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("DisplayType");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("FolderRelativeId");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Properties");
			xamlUserType.AddMemberName("FileFromPathAsync");
			AddToMapOfTypeToStandardName(typeof(IAsyncOperation<StorageFile>), "Windows.Foundation.IAsyncOperation<Windows.Storage.StorageFile>");
			xamlUserType.AddMemberName("FileFromApplicationUriAsync");
			AddToMapOfTypeToStandardName(typeof(IAsyncOperation<StorageFile>), "Windows.Foundation.IAsyncOperation<Windows.Storage.StorageFile>");
			result = xamlUserType;
			break;
		}
		case "System.Collections.Generic.List<Windows.Storage.StorageFile>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(List<StorageFile>), GetXamlTypeByName("Object"));
			AddToMapOfTypeToStandardName(typeof(List<StorageFile>), "System.Collections.Generic.List<Windows.Storage.StorageFile>");
			xamlUserType.Activator = Activate_131_List;
			xamlUserType.CollectionAdd = VectorAdd_131_List;
			result = xamlUserType;
			break;
		}
		case "Windows.Storage.FileAttributes":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(FileAttributes), GetXamlTypeByName("System.Enum"));
			xamlUserType.AddEnumValue("Normal", (object)(FileAttributes)0);
			xamlUserType.AddEnumValue("ReadOnly", (object)(FileAttributes)1);
			xamlUserType.AddEnumValue("Directory", (object)(FileAttributes)16);
			xamlUserType.AddEnumValue("Archive", (object)(FileAttributes)32);
			xamlUserType.AddEnumValue("Temporary", (object)(FileAttributes)256);
			result = xamlUserType;
			break;
		}
		case "System.DateTimeOffset":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DateTimeOffset), GetXamlTypeByName("System.ValueType"));
			result = xamlUserType;
			break;
		}
		case "Windows.Storage.FileProperties.StorageItemContentProperties":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(StorageItemContentProperties), GetXamlTypeByName("Object"));
			result = xamlUserType;
			break;
		}
		case "Windows.Foundation.IAsyncOperation<Windows.Storage.StorageFile>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(IAsyncOperation<StorageFile>), null);
			AddToMapOfTypeToStandardName(typeof(IAsyncOperation<StorageFile>), "Windows.Foundation.IAsyncOperation<Windows.Storage.StorageFile>");
			result = xamlUserType;
			break;
		}
		case "System.Uri":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Uri), GetXamlTypeByName("Object"));
			xamlUserType.AddMemberName("AbsolutePath");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("AbsoluteUri");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Authority");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("DnsSafeHost");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Fragment");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Host");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("HostNameType");
			xamlUserType.AddMemberName("IsAbsoluteUri");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsDefaultPort");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsFile");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsLoopback");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsUnc");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("LocalPath");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("OriginalString");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("PathAndQuery");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Port");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("Query");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Scheme");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Segments");
			AddToMapOfTypeToStandardName(typeof(string[]), "String[]");
			xamlUserType.AddMemberName("UserEscaped");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("UserInfo");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			result = xamlUserType;
			break;
		}
		case "System.UriHostNameType":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(UriHostNameType), GetXamlTypeByName("System.Enum"));
			xamlUserType.AddEnumValue("Unknown", UriHostNameType.Unknown);
			xamlUserType.AddEnumValue("Basic", UriHostNameType.Basic);
			xamlUserType.AddEnumValue("Dns", UriHostNameType.Dns);
			xamlUserType.AddEnumValue("IPv4", UriHostNameType.IPv4);
			xamlUserType.AddEnumValue("IPv6", UriHostNameType.IPv6);
			result = xamlUserType;
			break;
		}
		case "String[]":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(string[]), GetXamlTypeByName("System.Array"));
			AddToMapOfTypeToStandardName(typeof(string[]), "String[]");
			result = xamlUserType;
			break;
		}
		case "System.Array":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Array), GetXamlTypeByName("Object"));
			result = xamlUserType;
			break;
		}
		case "System.Collections.Generic.List<Windows.UI.Xaml.Media.Imaging.BitmapImage>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(List<BitmapImage>), GetXamlTypeByName("Object"));
			AddToMapOfTypeToStandardName(typeof(List<BitmapImage>), "System.Collections.Generic.List<Windows.UI.Xaml.Media.Imaging.BitmapImage>");
			xamlUserType.Activator = Activate_140_List;
			xamlUserType.CollectionAdd = VectorAdd_140_List;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.ChatListPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatListPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_141_ChatListPage;
			xamlUserType.AddMemberName("IsOpened");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsChatDetailOpened");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsInChatMode");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.ChatProfilePage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatProfilePage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_142_ChatProfilePage;
			xamlUserType.AddMemberName("ViewModel");
			result = xamlUserType;
			break;
		}
		case "ChatOn.ViewModels.ChatProfilePageViewModel":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatProfilePageViewModel), GetXamlTypeByName("ChatOn.Infrastructure.NotificationObject"));
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.ChatSettingPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ChatSettingPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_144_ChatSettingPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Controls.DelayedLoadControl":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DelayedLoadControl), GetXamlTypeByName("Windows.UI.Xaml.Controls.Control"));
			xamlUserType.Activator = Activate_145_DelayedLoadControl;
			xamlUserType.AddMemberName("Delay");
			AddToMapOfTypeToStandardName(typeof(TimeSpan), "TimeSpan");
			xamlUserType.AddMemberName("ContentTemplate");
			result = xamlUserType;
			break;
		}
		case "TimeSpan":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(TimeSpan), GetXamlTypeByName("System.ValueType"));
			AddToMapOfTypeToStandardName(typeof(TimeSpan), "TimeSpan");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.AddFriendsFacebookPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(AddFriendsFacebookPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_147_AddFriendsFacebookPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.BuddySayItemControl":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BuddySayItemControl), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_148_BuddySayItemControl;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.ViewModels.RingSlice":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(RingSlice), GetXamlTypeByName("Windows.UI.Xaml.Shapes.Path"));
			xamlUserType.Activator = Activate_149_RingSlice;
			xamlUserType.AddMemberName("InnerRadius");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("Radius");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("StartAngle");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("EndAngle");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("Center");
			AddToMapOfTypeToStandardName(typeof(Point?), "System.Nullable<Windows.Foundation.Point>");
			result = xamlUserType;
			break;
		}
		case "System.Nullable<Windows.Foundation.Point>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Point?), GetXamlTypeByName("System.ValueType"));
			AddToMapOfTypeToStandardName(typeof(Point?), "System.Nullable<Windows.Foundation.Point>");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Controls.CountdownControl":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(CountdownControl), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_151_CountdownControl;
			xamlUserType.AddMemberName("Seconds");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.ImageDelayControl":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ImageDelayControl), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_152_ImageDelayControl;
			xamlUserType.AddMemberName("ProfileImageSource");
			xamlUserType.AddMemberName("IsDownloading");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("StretchMode");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.PopupControl":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(PopupControl), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_153_PopupControl;
			xamlUserType.AddMemberName("TitleText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("DetailText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("ShowCancel");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("OKButtonText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("CancelButtonText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("OKButtonBackground");
			xamlUserType.AddMemberName("CancelButtonBackground");
			xamlUserType.AddMemberName("OKButtonForeground");
			xamlUserType.AddMemberName("CancelButtonForeground");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.SampleChatBubble":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SampleChatBubble), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_154_SampleChatBubble;
			xamlUserType.AddMemberName("Text");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("SubText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("MediaText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("SubParam");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("MaxBubbleWidth");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("Type");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			xamlUserType.AddMemberName("Message");
			xamlUserType.AddMemberName("FixedFontSize");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.CustomCameraCapture":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(CustomCameraCapture), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_155_CustomCameraCapture;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.FontSizePopUp":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(FontSizePopUp), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_156_FontSizePopUp;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.NewUpdatesPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(NewUpdatesPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_157_NewUpdatesPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.SplashScreenPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SplashScreenPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_158_SplashScreenPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.TrunkDetailFullViewPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(TrunkDetailFullViewPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_159_TrunkDetailFullViewPage;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.UnknownBuddyProfileDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(UnknownBuddyProfileDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_160_UnknownBuddyProfileDialog;
			xamlUserType.AddMemberName("BuddyInfo");
			xamlUserType.AddMemberName("ParentPage");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Models.UnknownUser":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(UnknownUser), GetXamlTypeByName("SDatabase.SDBData"));
			xamlUserType.Activator = Activate_161_UnknownUser;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.InvitationTwitterPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InvitationTwitterPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_162_InvitationTwitterPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.TellFriendsTwitterPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(TellFriendsTwitterPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_163_TellFriendsTwitterPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.ManageAccountPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ManageAccountPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_164_ManageAccountPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.MultiDeviceInfoPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(MultiDeviceInfoPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_165_MultiDeviceInfoPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Controls.SyncLoadingIndicator":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SyncLoadingIndicator), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SamsungAccountSignupDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SamsungAccountSignupDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_167_SamsungAccountSignupDialog;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.SNSControl.TwitterConnector":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(TwitterConnector), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_168_TwitterConnector;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.SplashPopup":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SplashPopup), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_169_SplashPopup;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.StartGuidePage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(StartGuidePage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_170_StartGuidePage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SuggestionsPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SuggestionsPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_171_SuggestionsPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SyncIntroPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SyncIntroPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_172_SyncIntroPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.TellFriendsFacebookPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(TellFriendsFacebookPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_173_TellFriendsFacebookPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.TrunkDetailPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(TrunkDetailPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_174_TrunkDetailPage;
			xamlUserType.AddMemberName("LockToBottom");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.UnreadCountToBubbleimage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(UnreadCountToBubbleimage), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_175_UnreadCountToBubbleimage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.TrunkPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(TrunkPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_176_TrunkPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.ContactDetailPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ContactDetailPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_177_ContactDetailPage;
			xamlUserType.AddMemberName("ContactInfos");
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<ContactDetailPage.ContactInfo>), "System.Collections.ObjectModel.ObservableCollection<ChatON_WoA.Views.ContactDetailPage.ContactInfo>");
			result = xamlUserType;
			break;
		}
		case "System.Collections.ObjectModel.ObservableCollection<ChatON_WoA.Views.ContactDetailPage.ContactInfo>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ObservableCollection<ContactDetailPage.ContactInfo>), GetXamlTypeByName("System.Collections.ObjectModel.Collection<ChatON_WoA.Views.ContactDetailPage.ContactInfo>"));
			AddToMapOfTypeToStandardName(typeof(ObservableCollection<ContactDetailPage.ContactInfo>), "System.Collections.ObjectModel.ObservableCollection<ChatON_WoA.Views.ContactDetailPage.ContactInfo>");
			xamlUserType.Activator = Activate_178_ObservableCollection;
			xamlUserType.CollectionAdd = VectorAdd_178_ObservableCollection;
			result = xamlUserType;
			break;
		}
		case "System.Collections.ObjectModel.Collection<ChatON_WoA.Views.ContactDetailPage.ContactInfo>":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(Collection<ContactDetailPage.ContactInfo>), GetXamlTypeByName("Object"));
			AddToMapOfTypeToStandardName(typeof(Collection<ContactDetailPage.ContactInfo>), "System.Collections.ObjectModel.Collection<ChatON_WoA.Views.ContactDetailPage.ContactInfo>");
			xamlUserType.Activator = Activate_179_Collection;
			xamlUserType.CollectionAdd = VectorAdd_179_Collection;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.ContactDetailPage.ContactInfo":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ContactDetailPage.ContactInfo), GetXamlTypeByName("Object"));
			AddToMapOfTypeToStandardName(typeof(ContactDetailPage.ContactInfo), "ChatON_WoA.Views.ContactDetailPage.ContactInfo");
			xamlUserType.AddMemberName("Type");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Value");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.CropPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(CropPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_181_CropPage;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.CustomPopup":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(CustomPopup), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.AddMemberName("Page");
			xamlUserType.AddMemberName("Child");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.DisclaimerKoreaPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DisclaimerKoreaPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_183_DisclaimerKoreaPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.DisclaimerPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DisclaimerPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_184_DisclaimerPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.DownloadSettingPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DownloadSettingPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_185_DownloadSettingPage;
			xamlUserType.AddMemberName("ViewModel");
			xamlUserType.AddMemberName("IsLoaded");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			result = xamlUserType;
			break;
		}
		case "ChatOn.ViewModels.DownloadSettingPageViewModel":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(DownloadSettingPageViewModel), GetXamlTypeByName("ChatOn.Infrastructure.NotificationObject"));
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.EditProfilePage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(EditProfilePage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_187_EditProfilePage;
			xamlUserType.AddMemberName("IsToggleShowPhonenumberOn");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsToggleShowBirthdayOn");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("IsToggleShowYear");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.BoolToEmoticonChooserTemplate":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BoolToEmoticonChooserTemplate), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_188_BoolToEmoticonChooserTemplate;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.EmptyBuddyListPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(EmptyBuddyListPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_189_EmptyBuddyListPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.EmptyChatListPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(EmptyChatListPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_190_EmptyChatListPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.GeneralSettingPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(GeneralSettingPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_191_GeneralSettingPage;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.GroupProfileDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(GroupProfileDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_192_GroupProfileDialog;
			xamlUserType.AddMemberName("GroupInfo");
			xamlUserType.AddMemberName("DisplayContainer");
			xamlUserType.AddMemberName("ViewModel");
			xamlUserType.AddMemberName("IsRenameMode");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			result = xamlUserType;
			break;
		}
		case "ChatOn.ViewModels.GroupProfilePageViewModel":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(GroupProfilePageViewModel), GetXamlTypeByName("ChatOn.Infrastructure.NotificationObject"));
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.HiddenInteractionPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(HiddenInteractionPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_194_HiddenInteractionPage;
			xamlUserType.AddMemberName("ViewModel");
			result = xamlUserType;
			break;
		}
		case "ChatOn.ViewModels.HiddenInteractionPageViewModel":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(HiddenInteractionPageViewModel), GetXamlTypeByName("ChatOn.Infrastructure.NotificationObject"));
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.HilightedTextBlock":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(HilightedTextBlock), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_196_HilightedTextBlock;
			xamlUserType.AddMemberName("Text");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("Keyword");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("MaxLength");
			AddToMapOfTypeToStandardName(typeof(int), "Int32");
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.ImageButtonBase":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ImageButtonBase), GetXamlTypeByName("Windows.UI.Xaml.Controls.Button"));
			xamlUserType.Activator = Activate_197_ImageButtonBase;
			xamlUserType.AddMemberName("NormalImage");
			xamlUserType.AddMemberName("PressedImage");
			xamlUserType.AddMemberName("DisabledImage");
			xamlUserType.AddMemberName("Text");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.ImageViewer":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ImageViewer), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_198_ImageViewer;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.InputNamePage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InputNamePage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_199_InputNamePage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.InputPasswordPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InputPasswordPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_200_InputPasswordPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.InputPhoneNumberPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InputPhoneNumberPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_201_InputPhoneNumberPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.InputVerificationCodePage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InputVerificationCodePage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_202_InputVerificationCodePage;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.RatioChart":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(RatioChart), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_203_RatioChart;
			xamlUserType.AddMemberName("LeftImage");
			xamlUserType.AddMemberName("RightImage");
			xamlUserType.AddMemberName("LeftText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("RightText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("LeftValue");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("RightValue");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("StandardValue");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("LeftFontColor");
			xamlUserType.AddMemberName("RightFontColor");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.InteractionRankPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InteractionRankPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_204_InteractionRankPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.InvitationPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(InvitationPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_205_InvitationPage;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.LoadingIndicator":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(LoadingIndicator), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_206_LoadingIndicator;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.MainPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(MainPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_207_MainPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.ManageBuddiesPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ManageBuddiesPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_208_ManageBuddiesPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.MyPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(MyPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_209_MyPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.NoticePage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(NoticePage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_210_NoticePage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.NotificationSettingPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(NotificationSettingPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_211_NotificationSettingPage;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.PasswordSettingPopup":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(PasswordSettingPopup), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_212_PasswordSettingPopup;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.PhotoFrame":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(PhotoFrame), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_213_PhotoFrame;
			xamlUserType.AddMemberName("MaxBubbleWidth");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("Photo");
			xamlUserType.AddMemberName("IconVisibility");
			AddToMapOfTypeToStandardName(typeof(bool), "Boolean");
			xamlUserType.AddMemberName("Stretch");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.PivotPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(PivotPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_214_PivotPage;
			xamlUserType.AddMemberName("ViewModel");
			result = xamlUserType;
			break;
		}
		case "ChatOn.ViewModels.PivotPageViewModel":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(PivotPageViewModel), GetXamlTypeByName("ChatOn.Infrastructure.NotificationObject"));
			xamlUserType.Activator = Activate_215_PivotPageViewModel;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.PreviewAniconDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(PreviewAniconDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_216_PreviewAniconDialog;
			xamlUserType.AddMemberName("AniconID");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.PrivacyPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(PrivacyPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_217_PrivacyPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.ProfileImageViewerPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(ProfileImageViewerPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_218_ProfileImageViewerPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SamsungAccountSigninDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SamsungAccountSigninDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.BindingService":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(BindingService), GetXamlTypeByName("Object"));
			xamlUserType.Activator = Activate_220_BindingService;
			xamlUserType.AddMemberName("FullText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("HighlightedText");
			AddToMapOfTypeToStandardName(typeof(string), "String");
			xamlUserType.AddMemberName("HighlightBrush");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SearchBuddyPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SearchBuddyPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_221_SearchBuddyPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SelectACSOptionPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SelectACSOptionPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_222_SelectACSOptionPage;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.SelectBackgroundPopup":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SelectBackgroundPopup), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_223_SelectBackgroundPopup;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Controls.SelectBubbleStylePopup":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SelectBubbleStylePopup), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_224_SelectBubbleStylePopup;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Common.SelectBuddyTemplateSelector":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SelectBuddyTemplateSelector), GetXamlTypeByName("Windows.UI.Xaml.Controls.DataTemplateSelector"));
			xamlUserType.Activator = Activate_225_SelectBuddyTemplateSelector;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SelectBuddyPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SelectBuddyPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_226_SelectBuddyPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SelectCountryCodeDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SelectCountryCodeDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_227_SelectCountryCodeDialog;
			result = xamlUserType;
			break;
		}
		case "ChatOn.Infrastructure.WrapPanel":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(WrapPanel), GetXamlTypeByName("Windows.UI.Xaml.Controls.Panel"));
			xamlUserType.Activator = Activate_228_WrapPanel;
			xamlUserType.AddMemberName("Orientation");
			xamlUserType.AddMemberName("ItemHeight");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			xamlUserType.AddMemberName("ItemWidth");
			AddToMapOfTypeToStandardName(typeof(double), "Double");
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SelectLanguagePage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SelectLanguagePage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_229_SelectLanguagePage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SettingsPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SettingsPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_230_SettingsPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.SignOutDialog":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SignOutDialog), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_231_SignOutDialog;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SnappedChatListPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SnappedChatListPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_232_SnappedChatListPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SnappedChatPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SnappedChatPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_233_SnappedChatPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.Views.SnappedRegistrationPage":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(SnappedRegistrationPage), GetXamlTypeByName("Windows.UI.Xaml.Controls.Page"));
			xamlUserType.Activator = Activate_234_SnappedRegistrationPage;
			result = xamlUserType;
			break;
		}
		case "ChatON_WoA.SNSControl.FacebookConnector":
		{
			XamlUserType xamlUserType = new XamlUserType(this, typeName, typeof(FacebookConnector), GetXamlTypeByName("Windows.UI.Xaml.Controls.UserControl"));
			xamlUserType.Activator = Activate_235_FacebookConnector;
			result = xamlUserType;
			break;
		}
		}
		return (IXamlType)(object)result;
	}

	private object get_0_DateChooser_SelectedDate(object instance)
	{
		DateChooser dateChooser = (DateChooser)instance;
		return dateChooser.SelectedDate;
	}

	private object get_1_AddBirthdayDialog_MyProfile(object instance)
	{
		AddBirthdayDialog addBirthdayDialog = (AddBirthdayDialog)instance;
		return addBirthdayDialog.MyProfile;
	}

	private object get_2_AddBirthdayDialog_IsShowYear(object instance)
	{
		AddBirthdayDialog addBirthdayDialog = (AddBirthdayDialog)instance;
		return addBirthdayDialog.IsShowYear;
	}

	private object get_3_AddBirthdayDialog_SelectedDate(object instance)
	{
		AddBirthdayDialog addBirthdayDialog = (AddBirthdayDialog)instance;
		return addBirthdayDialog.SelectedDate;
	}

	private object get_4_AddBuddiesSayDialog_PhoneNumber(object instance)
	{
		AddBuddiesSayDialog addBuddiesSayDialog = (AddBuddiesSayDialog)instance;
		return addBuddiesSayDialog.PhoneNumber;
	}

	private void set_4_AddBuddiesSayDialog_PhoneNumber(object instance, object Value)
	{
		AddBuddiesSayDialog addBuddiesSayDialog = (AddBuddiesSayDialog)instance;
		addBuddiesSayDialog.PhoneNumber = (string)Value;
	}

	private object get_5_ImageButton_NormalImage(object instance)
	{
		ImageButton imageButton = (ImageButton)instance;
		return imageButton.NormalImage;
	}

	private void set_5_ImageButton_NormalImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageButton imageButton = (ImageButton)instance;
		imageButton.NormalImage = (ImageSource)Value;
	}

	private object get_6_ImageButton_PressedImage(object instance)
	{
		ImageButton imageButton = (ImageButton)instance;
		return imageButton.PressedImage;
	}

	private void set_6_ImageButton_PressedImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageButton imageButton = (ImageButton)instance;
		imageButton.PressedImage = (ImageSource)Value;
	}

	private object get_7_ImageButton_Text(object instance)
	{
		ImageButton imageButton = (ImageButton)instance;
		return imageButton.Text;
	}

	private void set_7_ImageButton_Text(object instance, object Value)
	{
		ImageButton imageButton = (ImageButton)instance;
		imageButton.Text = (string)Value;
	}

	private object get_8_ImageButton_Foreground(object instance)
	{
		ImageButton imageButton = (ImageButton)instance;
		return imageButton.Foreground;
	}

	private void set_8_ImageButton_Foreground(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageButton imageButton = (ImageButton)instance;
		imageButton.Foreground = (Brush)Value;
	}

	private object get_9_ImageButton_DisabledImage(object instance)
	{
		ImageButton imageButton = (ImageButton)instance;
		return imageButton.DisabledImage;
	}

	private void set_9_ImageButton_DisabledImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageButton imageButton = (ImageButton)instance;
		imageButton.DisabledImage = (ImageSource)Value;
	}

	private object get_10_ImageButton_LightNormalImage(object instance)
	{
		ImageButton imageButton = (ImageButton)instance;
		return imageButton.LightNormalImage;
	}

	private void set_10_ImageButton_LightNormalImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageButton imageButton = (ImageButton)instance;
		imageButton.LightNormalImage = (ImageSource)Value;
	}

	private object get_11_ImageButton_LightPressedImage(object instance)
	{
		ImageButton imageButton = (ImageButton)instance;
		return imageButton.LightPressedImage;
	}

	private void set_11_ImageButton_LightPressedImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageButton imageButton = (ImageButton)instance;
		imageButton.LightPressedImage = (ImageSource)Value;
	}

	private object get_12_ImageButton_LightDisabledImage(object instance)
	{
		ImageButton imageButton = (ImageButton)instance;
		return imageButton.LightDisabledImage;
	}

	private void set_12_ImageButton_LightDisabledImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageButton imageButton = (ImageButton)instance;
		imageButton.LightDisabledImage = (ImageSource)Value;
	}

	private object get_13_ImageButton_ClickMode(object instance)
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		ImageButton imageButton = (ImageButton)instance;
		return imageButton.ClickMode;
	}

	private void set_13_ImageButton_ClickMode(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		ImageButton imageButton = (ImageButton)instance;
		imageButton.ClickMode = (ClickMode)Value;
	}

	private object get_14_AddBuddyDialog_ResultList(object instance)
	{
		AddBuddyDialog addBuddyDialog = (AddBuddyDialog)instance;
		return addBuddyDialog.ResultList;
	}

	private void set_14_AddBuddyDialog_ResultList(object instance, object Value)
	{
		AddBuddyDialog addBuddyDialog = (AddBuddyDialog)instance;
		addBuddyDialog.ResultList = (ObservableCollection<Buddy>)Value;
	}

	private object get_15_Buddy_BuddyID(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.BuddyID;
	}

	private void set_15_Buddy_BuddyID(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.BuddyID = (Guid)Value;
	}

	private object get_16_Buddy_Name(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.Name;
	}

	private void set_16_Buddy_Name(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.Name = (string)Value;
	}

	private object get_17_Buddy_PhoneNumber(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.PhoneNumber;
	}

	private void set_17_Buddy_PhoneNumber(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.PhoneNumber = (string)Value;
	}

	private object get_18_Buddy_Sainfo(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.Sainfo;
	}

	private void set_18_Buddy_Sainfo(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.Sainfo = (string)Value;
	}

	private object get_19_Buddy_OrgNumber(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.OrgNumber;
	}

	private void set_19_Buddy_OrgNumber(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.OrgNumber = (string)Value;
	}

	private object get_20_Buddy_Status(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.Status;
	}

	private void set_20_Buddy_Status(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.Status = (string)Value;
	}

	private object get_21_Buddy_Birthday(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.Birthday;
	}

	private void set_21_Buddy_Birthday(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.Birthday = (string)Value;
	}

	private object get_22_Buddy_Email(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.Email;
	}

	private void set_22_Buddy_Email(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.Email = (string)Value;
	}

	private object get_23_Buddy_SamsungEmail(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.SamsungEmail;
	}

	private void set_23_Buddy_SamsungEmail(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.SamsungEmail = (string)Value;
	}

	private object get_24_Buddy_ImgStatus(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.ImgStatus;
	}

	private void set_24_Buddy_ImgStatus(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.ImgStatus = (Buddy.ProfileImgStatus)Value;
	}

	private object get_25_Buddy_Type(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.Type;
	}

	private void set_25_Buddy_Type(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.Type = (Buddy.BuddyType)Value;
	}

	private object get_26_Buddy_IsFavorite(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsFavorite;
	}

	private void set_26_Buddy_IsFavorite(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsFavorite = (bool)Value;
	}

	private object get_27_Buddy_SentCount(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.SentCount;
	}

	private void set_27_Buddy_SentCount(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.SentCount = (int)Value;
	}

	private object get_28_Buddy_ReceivedCount(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.ReceivedCount;
	}

	private void set_28_Buddy_ReceivedCount(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.ReceivedCount = (int)Value;
	}

	private object get_29_Buddy_IsHideInteraction(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsHideInteraction;
	}

	private void set_29_Buddy_IsHideInteraction(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsHideInteraction = (bool)Value;
	}

	private object get_30_Buddy_Rank(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.Rank;
	}

	private void set_30_Buddy_Rank(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.Rank = (int)Value;
	}

	private object get_31_Buddy_IsShowPhoneNumber(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsShowPhoneNumber;
	}

	private void set_31_Buddy_IsShowPhoneNumber(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsShowPhoneNumber = (bool)Value;
	}

	private object get_32_Buddy_IsBlind(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsBlind;
	}

	private void set_32_Buddy_IsBlind(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsBlind = (bool)Value;
	}

	private object get_33_Buddy_IsBlindText(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsBlindText;
	}

	private void set_33_Buddy_IsBlindText(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsBlindText = (bool)Value;
	}

	private object get_34_Buddy_IsBlocked(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsBlocked;
	}

	private void set_34_Buddy_IsBlocked(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsBlocked = (bool)Value;
	}

	private object get_35_Buddy_ProfileName(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.ProfileName;
	}

	private void set_35_Buddy_ProfileName(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.ProfileName = (string)Value;
	}

	private object get_36_Buddy_MSISDNS(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.MSISDNS;
	}

	private void set_36_Buddy_MSISDNS(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.MSISDNS = (string)Value;
	}

	private object get_37_Buddy_HasMultipleNumbers(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.HasMultipleNumbers;
	}

	private object get_38_Buddy_IsSpecialBuddy(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsSpecialBuddy;
	}

	private void set_38_Buddy_IsSpecialBuddy(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsSpecialBuddy = (bool)Value;
	}

	private object get_39_Buddy_OrgPhoneNumberVisible(object instance)
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		Buddy buddy = (Buddy)instance;
		return buddy.OrgPhoneNumberVisible;
	}

	private object get_40_Buddy_PhoneNumberList(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.PhoneNumberList;
	}

	private void set_40_Buddy_PhoneNumberList(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.PhoneNumberList = (List<string>)Value;
	}

	private object get_41_Buddy_InteractionPoint(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.InteractionPoint;
	}

	private object get_42_Buddy_BestInteractionPoint(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.BestInteractionPoint;
	}

	private void set_42_Buddy_BestInteractionPoint(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.BestInteractionPoint = (int)Value;
	}

	private object get_43_Buddy_ThumbProfileImage(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.ThumbProfileImage;
	}

	private void set_43_Buddy_ThumbProfileImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		Buddy buddy = (Buddy)instance;
		buddy.ThumbProfileImage = (BitmapImage)Value;
	}

	private object get_44_Buddy_ProfileImage(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.ProfileImage;
	}

	private void set_44_Buddy_ProfileImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		Buddy buddy = (Buddy)instance;
		buddy.ProfileImage = (BitmapImage)Value;
	}

	private object get_45_Buddy_DisplayRank(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.DisplayRank;
	}

	private void set_45_Buddy_DisplayRank(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.DisplayRank = (int)Value;
	}

	private object get_46_Buddy_IndexString(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IndexString;
	}

	private void set_46_Buddy_IndexString(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IndexString = (string)Value;
	}

	private object get_47_Buddy_IsChecked(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsChecked;
	}

	private void set_47_Buddy_IsChecked(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsChecked = (bool)Value;
	}

	private object get_48_Buddy_IsNew(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsNew;
	}

	private void set_48_Buddy_IsNew(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsNew = (bool)Value;
	}

	private object get_49_Buddy_StatusForeground(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.StatusForeground;
	}

	private void set_49_Buddy_StatusForeground(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		Buddy buddy = (Buddy)instance;
		buddy.StatusForeground = (Brush)Value;
	}

	private object get_50_Buddy_Background(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.Background;
	}

	private void set_50_Buddy_Background(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		Buddy buddy = (Buddy)instance;
		buddy.Background = (Brush)Value;
	}

	private object get_51_Buddy_IsDownloading(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsDownloading;
	}

	private void set_51_Buddy_IsDownloading(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsDownloading = (bool)Value;
	}

	private object get_52_Buddy_IsInteractionDeleteMode(object instance)
	{
		Buddy buddy = (Buddy)instance;
		return buddy.IsInteractionDeleteMode;
	}

	private void set_52_Buddy_IsInteractionDeleteMode(object instance, object Value)
	{
		Buddy buddy = (Buddy)instance;
		buddy.IsInteractionDeleteMode = (bool)Value;
	}

	private object get_53_SDBData_Index(object instance)
	{
		SDBData sDBData = (SDBData)instance;
		return sDBData.Index;
	}

	private void set_53_SDBData_Index(object instance, object Value)
	{
		SDBData sDBData = (SDBData)instance;
		sDBData.Index = (SDBIndex)Value;
	}

	private object get_54_SDBData_Id(object instance)
	{
		SDBData sDBData = (SDBData)instance;
		return sDBData.Id;
	}

	private void set_54_SDBData_Id(object instance, object Value)
	{
		SDBData sDBData = (SDBData)instance;
		sDBData.Id = (Guid)Value;
	}

	private object get_55_AddBuddyDialog_ResultList2(object instance)
	{
		AddBuddyDialog addBuddyDialog = (AddBuddyDialog)instance;
		return addBuddyDialog.ResultList2;
	}

	private void set_55_AddBuddyDialog_ResultList2(object instance, object Value)
	{
		AddBuddyDialog addBuddyDialog = (AddBuddyDialog)instance;
		addBuddyDialog.ResultList2 = (ObservableCollection<Buddy>)Value;
	}

	private object get_56_AddBuddyDialog_TellFriendsList(object instance)
	{
		AddBuddyDialog addBuddyDialog = (AddBuddyDialog)instance;
		return addBuddyDialog.TellFriendsList;
	}

	private void set_56_AddBuddyDialog_TellFriendsList(object instance, object Value)
	{
		AddBuddyDialog addBuddyDialog = (AddBuddyDialog)instance;
		addBuddyDialog.TellFriendsList = (ObservableCollection<TellFriendsItem>)Value;
	}

	private object get_57_TellFriendsItem_Name(object instance)
	{
		TellFriendsItem tellFriendsItem = (TellFriendsItem)instance;
		return tellFriendsItem.Name;
	}

	private void set_57_TellFriendsItem_Name(object instance, object Value)
	{
		TellFriendsItem tellFriendsItem = (TellFriendsItem)instance;
		tellFriendsItem.Name = (string)Value;
	}

	private object get_58_AddBuddyDialog__updateBuddyFromUploadAddressRunning(object instance)
	{
		AddBuddyDialog addBuddyDialog = (AddBuddyDialog)instance;
		return addBuddyDialog._updateBuddyFromUploadAddressRunning;
	}

	private void set_58_AddBuddyDialog__updateBuddyFromUploadAddressRunning(object instance, object Value)
	{
		AddBuddyDialog addBuddyDialog = (AddBuddyDialog)instance;
		addBuddyDialog._updateBuddyFromUploadAddressRunning = (bool)Value;
	}

	private object get_59_AddGroupDialog_Group(object instance)
	{
		AddGroupDialog addGroupDialog = (AddGroupDialog)instance;
		return addGroupDialog.Group;
	}

	private void set_59_AddGroupDialog_Group(object instance, object Value)
	{
		AddGroupDialog addGroupDialog = (AddGroupDialog)instance;
		addGroupDialog.Group = (BuddyGroup)Value;
	}

	private object get_60_AniconPlayer_SourceID(object instance)
	{
		AniconPlayer aniconPlayer = (AniconPlayer)instance;
		return aniconPlayer.SourceID;
	}

	private void set_60_AniconPlayer_SourceID(object instance, object Value)
	{
		AniconPlayer aniconPlayer = (AniconPlayer)instance;
		aniconPlayer.SourceID = (string)Value;
	}

	private object get_61_BindRichTextBlock_Text(object instance)
	{
		BindRichTextBlock bindRichTextBlock = (BindRichTextBlock)instance;
		return bindRichTextBlock.Text;
	}

	private void set_61_BindRichTextBlock_Text(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		BindRichTextBlock bindRichTextBlock = (BindRichTextBlock)instance;
		bindRichTextBlock.Text = (Paragraph)Value;
	}

	private object get_62_BlockListPage_ViewModel(object instance)
	{
		BlockListPage blockListPage = (BlockListPage)instance;
		return blockListPage.ViewModel;
	}

	private object get_63_BuddyProfileDialog_BuddyInfo(object instance)
	{
		BuddyProfileDialog buddyProfileDialog = (BuddyProfileDialog)instance;
		return buddyProfileDialog.BuddyInfo;
	}

	private void set_63_BuddyProfileDialog_BuddyInfo(object instance, object Value)
	{
		BuddyProfileDialog buddyProfileDialog = (BuddyProfileDialog)instance;
		buddyProfileDialog.BuddyInfo = (Buddy)Value;
	}

	private object get_64_BuddyProfileDialog_ParentPage(object instance)
	{
		BuddyProfileDialog buddyProfileDialog = (BuddyProfileDialog)instance;
		return buddyProfileDialog.ParentPage;
	}

	private void set_64_BuddyProfileDialog_ParentPage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		BuddyProfileDialog buddyProfileDialog = (BuddyProfileDialog)instance;
		buddyProfileDialog.ParentPage = (Page)Value;
	}

	private object get_65_BuddyProfileDialog_IsRenameMode(object instance)
	{
		BuddyProfileDialog buddyProfileDialog = (BuddyProfileDialog)instance;
		return buddyProfileDialog.IsRenameMode;
	}

	private void set_65_BuddyProfileDialog_IsRenameMode(object instance, object Value)
	{
		BuddyProfileDialog buddyProfileDialog = (BuddyProfileDialog)instance;
		buddyProfileDialog.IsRenameMode = (bool)Value;
	}

	private object get_66_CalendarDetailPage_CalInfo(object instance)
	{
		CalendarDetailPage calendarDetailPage = (CalendarDetailPage)instance;
		return calendarDetailPage.CalInfo;
	}

	private void set_66_CalendarDetailPage_CalInfo(object instance, object Value)
	{
		CalendarDetailPage calendarDetailPage = (CalendarDetailPage)instance;
		calendarDetailPage.CalInfo = (CalendarDetailPage.CalendarInfo)Value;
	}

	private object get_67_ChatTextBlock_IsParsingLinkEnabled(object instance)
	{
		ChatTextBlock chatTextBlock = (ChatTextBlock)instance;
		return chatTextBlock.IsParsingLinkEnabled;
	}

	private void set_67_ChatTextBlock_IsParsingLinkEnabled(object instance, object Value)
	{
		ChatTextBlock chatTextBlock = (ChatTextBlock)instance;
		chatTextBlock.IsParsingLinkEnabled = (bool)Value;
	}

	private object get_68_ChatTextBlock_EmoticonSize(object instance)
	{
		ChatTextBlock chatTextBlock = (ChatTextBlock)instance;
		return chatTextBlock.EmoticonSize;
	}

	private void set_68_ChatTextBlock_EmoticonSize(object instance, object Value)
	{
		ChatTextBlock chatTextBlock = (ChatTextBlock)instance;
		chatTextBlock.EmoticonSize = (double)Value;
	}

	private object get_69_ChatTextBlock_ForegroundText(object instance)
	{
		ChatTextBlock chatTextBlock = (ChatTextBlock)instance;
		return chatTextBlock.ForegroundText;
	}

	private void set_69_ChatTextBlock_ForegroundText(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ChatTextBlock chatTextBlock = (ChatTextBlock)instance;
		chatTextBlock.ForegroundText = (SolidColorBrush)Value;
	}

	private object get_70_ChatTextBlock_MaxLength(object instance)
	{
		ChatTextBlock chatTextBlock = (ChatTextBlock)instance;
		return chatTextBlock.MaxLength;
	}

	private void set_70_ChatTextBlock_MaxLength(object instance, object Value)
	{
		ChatTextBlock chatTextBlock = (ChatTextBlock)instance;
		chatTextBlock.MaxLength = (int)Value;
	}

	private object get_71_ChatTextBlock_Text(object instance)
	{
		ChatTextBlock chatTextBlock = (ChatTextBlock)instance;
		return chatTextBlock.Text;
	}

	private void set_71_ChatTextBlock_Text(object instance, object Value)
	{
		ChatTextBlock chatTextBlock = (ChatTextBlock)instance;
		chatTextBlock.Text = (string)Value;
	}

	private object get_72_ChatBubble_Text(object instance)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		return chatBubble.Text;
	}

	private void set_72_ChatBubble_Text(object instance, object Value)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		chatBubble.Text = (string)Value;
	}

	private object get_73_ChatBubble_SubText(object instance)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		return chatBubble.SubText;
	}

	private void set_73_ChatBubble_SubText(object instance, object Value)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		chatBubble.SubText = (string)Value;
	}

	private object get_74_ChatBubble_MediaText(object instance)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		return chatBubble.MediaText;
	}

	private void set_74_ChatBubble_MediaText(object instance, object Value)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		chatBubble.MediaText = (string)Value;
	}

	private object get_75_ChatBubble_SubParam(object instance)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		return chatBubble.SubParam;
	}

	private void set_75_ChatBubble_SubParam(object instance, object Value)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		chatBubble.SubParam = (int)Value;
	}

	private object get_76_ChatBubble_MaxBubbleWidth(object instance)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		return chatBubble.MaxBubbleWidth;
	}

	private void set_76_ChatBubble_MaxBubbleWidth(object instance, object Value)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		chatBubble.MaxBubbleWidth = (double)Value;
	}

	private object get_77_ChatBubble_Type(object instance)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		return chatBubble.Type;
	}

	private void set_77_ChatBubble_Type(object instance, object Value)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		chatBubble.Type = (int)Value;
	}

	private object get_78_ChatBubble_Message(object instance)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		return chatBubble.Message;
	}

	private void set_78_ChatBubble_Message(object instance, object Value)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		chatBubble.Message = (Message)Value;
	}

	private object get_79_ChatBubble_FixedFontSize(object instance)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		return chatBubble.FixedFontSize;
	}

	private void set_79_ChatBubble_FixedFontSize(object instance, object Value)
	{
		ChatBubble chatBubble = (ChatBubble)instance;
		chatBubble.FixedFontSize = (double)Value;
	}

	private object get_80_DateDisplayUserControl_ItemContent(object instance)
	{
		DateDisplayUserControl dateDisplayUserControl = (DateDisplayUserControl)instance;
		return dateDisplayUserControl.ItemContent;
	}

	private void set_80_DateDisplayUserControl_ItemContent(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		DateDisplayUserControl dateDisplayUserControl = (DateDisplayUserControl)instance;
		dateDisplayUserControl.ItemContent = (UIElement)Value;
	}

	private object get_81_ChatDetailPage_ListVerticalOffset(object instance)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		return chatDetailPage.ListVerticalOffset;
	}

	private void set_81_ChatDetailPage_ListVerticalOffset(object instance, object Value)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		chatDetailPage.ListVerticalOffset = (double)Value;
	}

	private object get_82_ChatDetailPage_ListVerticalOffsetMediator(object instance)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		return chatDetailPage.ListVerticalOffsetMediator;
	}

	private void set_82_ChatDetailPage_ListVerticalOffsetMediator(object instance, object Value)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		chatDetailPage.ListVerticalOffsetMediator = (double)Value;
	}

	private object get_83_ChatDetailPage_ViewModel(object instance)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		return chatDetailPage.ViewModel;
	}

	private object get_84_ChatDetailPage_LastAddedTick(object instance)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		return chatDetailPage.LastAddedTick;
	}

	private void set_84_ChatDetailPage_LastAddedTick(object instance, object Value)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		chatDetailPage.LastAddedTick = (long)Value;
	}

	private object get_85_ChatDetailPage_IsMouseHold(object instance)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		return chatDetailPage.IsMouseHold;
	}

	private void set_85_ChatDetailPage_IsMouseHold(object instance, object Value)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		chatDetailPage.IsMouseHold = (bool)Value;
	}

	private object get_86_ChatDetailPage_TmpSender(object instance)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		return chatDetailPage.TmpSender;
	}

	private void set_86_ChatDetailPage_TmpSender(object instance, object Value)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		chatDetailPage.TmpSender = Value;
	}

	private object get_87_ChatDetailPage_Gr(object instance)
	{
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		return chatDetailPage.Gr;
	}

	private void set_87_ChatDetailPage_Gr(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ChatDetailPage chatDetailPage = (ChatDetailPage)instance;
		chatDetailPage.Gr = (GestureRecognizer)Value;
	}

	private object get_88_EmoticonChooser_newPackage(object instance)
	{
		EmoticonChooser emoticonChooser = (EmoticonChooser)instance;
		return emoticonChooser.newPackage;
	}

	private void set_88_EmoticonChooser_newPackage(object instance, object Value)
	{
		EmoticonChooser emoticonChooser = (EmoticonChooser)instance;
		emoticonChooser.newPackage = (ObservableCollection<OfflineAniconPackage>)Value;
	}

	private object get_89_OfflineAniconPackage_DownloadOperation(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.DownloadOperation;
	}

	private void set_89_OfflineAniconPackage_DownloadOperation(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.DownloadOperation = (DownloadOperation)Value;
	}

	private object get_90_OfflineAniconPackage_IsSelected(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.IsSelected;
	}

	private void set_90_OfflineAniconPackage_IsSelected(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.IsSelected = (bool)Value;
	}

	private object get_91_OfflineAniconPackage_ThumbImage(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.ThumbImage;
	}

	private void set_91_OfflineAniconPackage_ThumbImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.ThumbImage = (BitmapImage)Value;
	}

	private object get_92_OfflineAniconPackage_LoadTemplate(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.LoadTemplate;
	}

	private void set_92_OfflineAniconPackage_LoadTemplate(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.LoadTemplate = (bool)Value;
	}

	private object get_93_OfflineAniconPackage_IsLoaded(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.IsLoaded;
	}

	private void set_93_OfflineAniconPackage_IsLoaded(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.IsLoaded = (bool)Value;
	}

	private object get_94_OfflineAniconPackage_CurrentPackage(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.CurrentPackage;
	}

	private void set_94_OfflineAniconPackage_CurrentPackage(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.CurrentPackage = (AniconPackage)Value;
	}

	private object get_95_OfflineAniconPackage_ProxyUrl(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.ProxyUrl;
	}

	private void set_95_OfflineAniconPackage_ProxyUrl(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.ProxyUrl = (string)Value;
	}

	private object get_96_OfflineAniconPackage_PackageZipUrl(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.PackageZipUrl;
	}

	private void set_96_OfflineAniconPackage_PackageZipUrl(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.PackageZipUrl = (string)Value;
	}

	private object get_97_OfflineAniconPackage_AniconList(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.AniconList;
	}

	private void set_97_OfflineAniconPackage_AniconList(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.AniconList = (ObservableCollection<Anicon>)Value;
	}

	private object get_98_Anicon_IsShowLoading(object instance)
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		Anicon anicon = (Anicon)instance;
		return anicon.IsShowLoading;
	}

	private void set_98_Anicon_IsShowLoading(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		Anicon anicon = (Anicon)instance;
		anicon.IsShowLoading = (Visibility)Value;
	}

	private object get_99_Anicon_IsLoading(object instance)
	{
		Anicon anicon = (Anicon)instance;
		return anicon.IsLoading;
	}

	private void set_99_Anicon_IsLoading(object instance, object Value)
	{
		Anicon anicon = (Anicon)instance;
		anicon.IsLoading = (bool)Value;
	}

	private object get_100_Anicon_IsLoaded(object instance)
	{
		Anicon anicon = (Anicon)instance;
		return anicon.IsLoaded;
	}

	private void set_100_Anicon_IsLoaded(object instance, object Value)
	{
		Anicon anicon = (Anicon)instance;
		anicon.IsLoaded = (bool)Value;
	}

	private object get_101_Anicon_MsgUrl(object instance)
	{
		Anicon anicon = (Anicon)instance;
		return anicon.MsgUrl;
	}

	private void set_101_Anicon_MsgUrl(object instance, object Value)
	{
		Anicon anicon = (Anicon)instance;
		anicon.MsgUrl = (string)Value;
	}

	private object get_102_Anicon_ID(object instance)
	{
		Anicon anicon = (Anicon)instance;
		return anicon.ID;
	}

	private void set_102_Anicon_ID(object instance, object Value)
	{
		Anicon anicon = (Anicon)instance;
		anicon.ID = (string)Value;
	}

	private object get_103_Anicon_DelegateImageFile(object instance)
	{
		Anicon anicon = (Anicon)instance;
		return anicon.DelegateImageFile;
	}

	private void set_103_Anicon_DelegateImageFile(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		Anicon anicon = (Anicon)instance;
		anicon.DelegateImageFile = (StorageFile)Value;
	}

	private object get_104_Anicon_DelegateImage(object instance)
	{
		Anicon anicon = (Anicon)instance;
		return anicon.DelegateImage;
	}

	private void set_104_Anicon_DelegateImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		Anicon anicon = (Anicon)instance;
		anicon.DelegateImage = (BitmapImage)Value;
	}

	private object get_105_Anicon_ImageUrlList(object instance)
	{
		Anicon anicon = (Anicon)instance;
		return anicon.ImageUrlList;
	}

	private void set_105_Anicon_ImageUrlList(object instance, object Value)
	{
		Anicon anicon = (Anicon)instance;
		anicon.ImageUrlList = (List<string>)Value;
	}

	private object get_106_Anicon_ImageFileList(object instance)
	{
		Anicon anicon = (Anicon)instance;
		return anicon.ImageFileList;
	}

	private void set_106_Anicon_ImageFileList(object instance, object Value)
	{
		Anicon anicon = (Anicon)instance;
		anicon.ImageFileList = (List<StorageFile>)Value;
	}

	private object get_107_StorageFile_ContentType(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		StorageFile val = (StorageFile)instance;
		return val.ContentType;
	}

	private object get_108_StorageFile_FileType(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		StorageFile val = (StorageFile)instance;
		return val.FileType;
	}

	private object get_109_StorageFile_Attributes(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		StorageFile val = (StorageFile)instance;
		return val.Attributes;
	}

	private object get_110_StorageFile_DateCreated(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		StorageFile val = (StorageFile)instance;
		return val.DateCreated;
	}

	private object get_111_StorageFile_Name(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		StorageFile val = (StorageFile)instance;
		return val.Name;
	}

	private object get_112_StorageFile_Path(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		StorageFile val = (StorageFile)instance;
		return val.Path;
	}

	private object get_113_StorageFile_DisplayName(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		StorageFile val = (StorageFile)instance;
		return val.DisplayName;
	}

	private object get_114_StorageFile_DisplayType(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		StorageFile val = (StorageFile)instance;
		return val.DisplayType;
	}

	private object get_115_StorageFile_FolderRelativeId(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		StorageFile val = (StorageFile)instance;
		return val.FolderRelativeId;
	}

	private object get_116_StorageFile_Properties(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Expected O, but got Unknown
		StorageFile val = (StorageFile)instance;
		return val.Properties;
	}

	private object get_117_StorageFile_FileFromPathAsync(object instance)
	{
		return StorageFile.GetFileFromPathAsync((string)instance);
	}

	private object get_118_StorageFile_FileFromApplicationUriAsync(object instance)
	{
		return StorageFile.GetFileFromApplicationUriAsync((Uri)instance);
	}

	private object get_119_Uri_AbsolutePath(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.AbsolutePath;
	}

	private object get_120_Uri_AbsoluteUri(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.AbsoluteUri;
	}

	private object get_121_Uri_Authority(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.Authority;
	}

	private object get_122_Uri_DnsSafeHost(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.DnsSafeHost;
	}

	private object get_123_Uri_Fragment(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.Fragment;
	}

	private object get_124_Uri_Host(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.Host;
	}

	private object get_125_Uri_HostNameType(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.HostNameType;
	}

	private object get_126_Uri_IsAbsoluteUri(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.IsAbsoluteUri;
	}

	private object get_127_Uri_IsDefaultPort(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.IsDefaultPort;
	}

	private object get_128_Uri_IsFile(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.IsFile;
	}

	private object get_129_Uri_IsLoopback(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.IsLoopback;
	}

	private object get_130_Uri_IsUnc(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.IsUnc;
	}

	private object get_131_Uri_LocalPath(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.LocalPath;
	}

	private object get_132_Uri_OriginalString(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.OriginalString;
	}

	private object get_133_Uri_PathAndQuery(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.PathAndQuery;
	}

	private object get_134_Uri_Port(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.Port;
	}

	private object get_135_Uri_Query(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.Query;
	}

	private object get_136_Uri_Scheme(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.Scheme;
	}

	private object get_137_Uri_Segments(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.Segments;
	}

	private object get_138_Uri_UserEscaped(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.UserEscaped;
	}

	private object get_139_Uri_UserInfo(object instance)
	{
		Uri uri = (Uri)instance;
		return uri.UserInfo;
	}

	private object get_140_Anicon_ImageList(object instance)
	{
		Anicon anicon = (Anicon)instance;
		return anicon.ImageList;
	}

	private void set_140_Anicon_ImageList(object instance, object Value)
	{
		Anicon anicon = (Anicon)instance;
		anicon.ImageList = (List<BitmapImage>)Value;
	}

	private object get_141_Anicon_DelegateImageName(object instance)
	{
		Anicon anicon = (Anicon)instance;
		return anicon.DelegateImageName;
	}

	private void set_141_Anicon_DelegateImageName(object instance, object Value)
	{
		Anicon anicon = (Anicon)instance;
		anicon.DelegateImageName = (string)Value;
	}

	private object get_142_OfflineAniconPackage_IsDelegateImagesLoaded(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.IsDelegateImagesLoaded;
	}

	private void set_142_OfflineAniconPackage_IsDelegateImagesLoaded(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.IsDelegateImagesLoaded = (bool)Value;
	}

	private object get_143_OfflineAniconPackage_Count(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.Count;
	}

	private void set_143_OfflineAniconPackage_Count(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.Count = (int)Value;
	}

	private object get_144_OfflineAniconPackage_EndDate(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.EndDate;
	}

	private void set_144_OfflineAniconPackage_EndDate(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.EndDate = (long)Value;
	}

	private object get_145_OfflineAniconPackage_ErrorText(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.ErrorText;
	}

	private void set_145_OfflineAniconPackage_ErrorText(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.ErrorText = (string)Value;
	}

	private object get_146_OfflineAniconPackage_ThumbImageUri(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.ThumbImageUri;
	}

	private void set_146_OfflineAniconPackage_ThumbImageUri(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.ThumbImageUri = (string)Value;
	}

	private object get_147_OfflineAniconPackage_ThumbImageFile(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.ThumbImageFile;
	}

	private void set_147_OfflineAniconPackage_ThumbImageFile(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.ThumbImageFile = (StorageFile)Value;
	}

	private object get_148_OfflineAniconPackage_isCancel(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.isCancel;
	}

	private void set_148_OfflineAniconPackage_isCancel(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.isCancel = (bool)Value;
	}

	private object get_149_OfflineAniconPackage_PackageID(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.PackageID;
	}

	private void set_149_OfflineAniconPackage_PackageID(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.PackageID = (string)Value;
	}

	private object get_150_OfflineAniconPackage_XmlString(object instance)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		return offlineAniconPackage.XmlString;
	}

	private void set_150_OfflineAniconPackage_XmlString(object instance, object Value)
	{
		OfflineAniconPackage offlineAniconPackage = (OfflineAniconPackage)instance;
		offlineAniconPackage.XmlString = (string)Value;
	}

	private object get_151_EmoticonChooser_Packages(object instance)
	{
		EmoticonChooser emoticonChooser = (EmoticonChooser)instance;
		return emoticonChooser.Packages;
	}

	private void set_151_EmoticonChooser_Packages(object instance, object Value)
	{
		EmoticonChooser emoticonChooser = (EmoticonChooser)instance;
		emoticonChooser.Packages = (ObservableCollection<OfflineAniconPackage>)Value;
	}

	private object get_152_ChatListPage_IsOpened(object instance)
	{
		ChatListPage chatListPage = (ChatListPage)instance;
		return chatListPage.IsOpened;
	}

	private void set_152_ChatListPage_IsOpened(object instance, object Value)
	{
		ChatListPage chatListPage = (ChatListPage)instance;
		chatListPage.IsOpened = (bool)Value;
	}

	private object get_153_ChatListPage_IsChatDetailOpened(object instance)
	{
		ChatListPage chatListPage = (ChatListPage)instance;
		return chatListPage.IsChatDetailOpened;
	}

	private void set_153_ChatListPage_IsChatDetailOpened(object instance, object Value)
	{
		ChatListPage chatListPage = (ChatListPage)instance;
		chatListPage.IsChatDetailOpened = (bool)Value;
	}

	private object get_154_ChatListPage_IsInChatMode(object instance)
	{
		ChatListPage chatListPage = (ChatListPage)instance;
		return chatListPage.IsInChatMode;
	}

	private void set_154_ChatListPage_IsInChatMode(object instance, object Value)
	{
		ChatListPage chatListPage = (ChatListPage)instance;
		chatListPage.IsInChatMode = (bool)Value;
	}

	private object get_155_ChatProfilePage_ViewModel(object instance)
	{
		ChatProfilePage chatProfilePage = (ChatProfilePage)instance;
		return chatProfilePage.ViewModel;
	}

	private void set_155_ChatProfilePage_ViewModel(object instance, object Value)
	{
		ChatProfilePage chatProfilePage = (ChatProfilePage)instance;
		chatProfilePage.ViewModel = (ChatProfilePageViewModel)Value;
	}

	private object get_156_DelayedLoadControl_Delay(object instance)
	{
		DelayedLoadControl delayedLoadControl = (DelayedLoadControl)instance;
		return delayedLoadControl.Delay;
	}

	private void set_156_DelayedLoadControl_Delay(object instance, object Value)
	{
		DelayedLoadControl delayedLoadControl = (DelayedLoadControl)instance;
		delayedLoadControl.Delay = (TimeSpan)Value;
	}

	private object get_157_DelayedLoadControl_ContentTemplate(object instance)
	{
		DelayedLoadControl delayedLoadControl = (DelayedLoadControl)instance;
		return delayedLoadControl.ContentTemplate;
	}

	private void set_157_DelayedLoadControl_ContentTemplate(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		DelayedLoadControl delayedLoadControl = (DelayedLoadControl)instance;
		delayedLoadControl.ContentTemplate = (DataTemplate)Value;
	}

	private object get_158_RingSlice_InnerRadius(object instance)
	{
		RingSlice ringSlice = (RingSlice)instance;
		return ringSlice.InnerRadius;
	}

	private void set_158_RingSlice_InnerRadius(object instance, object Value)
	{
		RingSlice ringSlice = (RingSlice)instance;
		ringSlice.InnerRadius = (double)Value;
	}

	private object get_159_RingSlice_Radius(object instance)
	{
		RingSlice ringSlice = (RingSlice)instance;
		return ringSlice.Radius;
	}

	private void set_159_RingSlice_Radius(object instance, object Value)
	{
		RingSlice ringSlice = (RingSlice)instance;
		ringSlice.Radius = (double)Value;
	}

	private object get_160_RingSlice_StartAngle(object instance)
	{
		RingSlice ringSlice = (RingSlice)instance;
		return ringSlice.StartAngle;
	}

	private void set_160_RingSlice_StartAngle(object instance, object Value)
	{
		RingSlice ringSlice = (RingSlice)instance;
		ringSlice.StartAngle = (double)Value;
	}

	private object get_161_RingSlice_EndAngle(object instance)
	{
		RingSlice ringSlice = (RingSlice)instance;
		return ringSlice.EndAngle;
	}

	private void set_161_RingSlice_EndAngle(object instance, object Value)
	{
		RingSlice ringSlice = (RingSlice)instance;
		ringSlice.EndAngle = (double)Value;
	}

	private object get_162_RingSlice_Center(object instance)
	{
		RingSlice ringSlice = (RingSlice)instance;
		return ringSlice.Center;
	}

	private void set_162_RingSlice_Center(object instance, object Value)
	{
		RingSlice ringSlice = (RingSlice)instance;
		ringSlice.Center = (Point?)Value;
	}

	private object get_163_CountdownControl_Seconds(object instance)
	{
		CountdownControl countdownControl = (CountdownControl)instance;
		return countdownControl.Seconds;
	}

	private void set_163_CountdownControl_Seconds(object instance, object Value)
	{
		CountdownControl countdownControl = (CountdownControl)instance;
		countdownControl.Seconds = (int)Value;
	}

	private object get_164_ImageDelayControl_ProfileImageSource(object instance)
	{
		ImageDelayControl imageDelayControl = (ImageDelayControl)instance;
		return imageDelayControl.ProfileImageSource;
	}

	private void set_164_ImageDelayControl_ProfileImageSource(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageDelayControl imageDelayControl = (ImageDelayControl)instance;
		imageDelayControl.ProfileImageSource = (BitmapImage)Value;
	}

	private object get_165_ImageDelayControl_IsDownloading(object instance)
	{
		ImageDelayControl imageDelayControl = (ImageDelayControl)instance;
		return imageDelayControl.IsDownloading;
	}

	private void set_165_ImageDelayControl_IsDownloading(object instance, object Value)
	{
		ImageDelayControl imageDelayControl = (ImageDelayControl)instance;
		imageDelayControl.IsDownloading = (bool)Value;
	}

	private object get_166_ImageDelayControl_StretchMode(object instance)
	{
		ImageDelayControl imageDelayControl = (ImageDelayControl)instance;
		return imageDelayControl.StretchMode;
	}

	private void set_166_ImageDelayControl_StretchMode(object instance, object Value)
	{
		ImageDelayControl imageDelayControl = (ImageDelayControl)instance;
		imageDelayControl.StretchMode = (int)Value;
	}

	private object get_167_PopupControl_TitleText(object instance)
	{
		PopupControl popupControl = (PopupControl)instance;
		return popupControl.TitleText;
	}

	private void set_167_PopupControl_TitleText(object instance, object Value)
	{
		PopupControl popupControl = (PopupControl)instance;
		popupControl.TitleText = (string)Value;
	}

	private object get_168_PopupControl_DetailText(object instance)
	{
		PopupControl popupControl = (PopupControl)instance;
		return popupControl.DetailText;
	}

	private void set_168_PopupControl_DetailText(object instance, object Value)
	{
		PopupControl popupControl = (PopupControl)instance;
		popupControl.DetailText = (string)Value;
	}

	private object get_169_PopupControl_ShowCancel(object instance)
	{
		PopupControl popupControl = (PopupControl)instance;
		return popupControl.ShowCancel;
	}

	private void set_169_PopupControl_ShowCancel(object instance, object Value)
	{
		PopupControl popupControl = (PopupControl)instance;
		popupControl.ShowCancel = (bool)Value;
	}

	private object get_170_PopupControl_OKButtonText(object instance)
	{
		PopupControl popupControl = (PopupControl)instance;
		return popupControl.OKButtonText;
	}

	private void set_170_PopupControl_OKButtonText(object instance, object Value)
	{
		PopupControl popupControl = (PopupControl)instance;
		popupControl.OKButtonText = (string)Value;
	}

	private object get_171_PopupControl_CancelButtonText(object instance)
	{
		PopupControl popupControl = (PopupControl)instance;
		return popupControl.CancelButtonText;
	}

	private void set_171_PopupControl_CancelButtonText(object instance, object Value)
	{
		PopupControl popupControl = (PopupControl)instance;
		popupControl.CancelButtonText = (string)Value;
	}

	private object get_172_PopupControl_OKButtonBackground(object instance)
	{
		PopupControl popupControl = (PopupControl)instance;
		return popupControl.OKButtonBackground;
	}

	private void set_172_PopupControl_OKButtonBackground(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		PopupControl popupControl = (PopupControl)instance;
		popupControl.OKButtonBackground = (SolidColorBrush)Value;
	}

	private object get_173_PopupControl_CancelButtonBackground(object instance)
	{
		PopupControl popupControl = (PopupControl)instance;
		return popupControl.CancelButtonBackground;
	}

	private void set_173_PopupControl_CancelButtonBackground(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		PopupControl popupControl = (PopupControl)instance;
		popupControl.CancelButtonBackground = (SolidColorBrush)Value;
	}

	private object get_174_PopupControl_OKButtonForeground(object instance)
	{
		PopupControl popupControl = (PopupControl)instance;
		return popupControl.OKButtonForeground;
	}

	private void set_174_PopupControl_OKButtonForeground(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		PopupControl popupControl = (PopupControl)instance;
		popupControl.OKButtonForeground = (SolidColorBrush)Value;
	}

	private object get_175_PopupControl_CancelButtonForeground(object instance)
	{
		PopupControl popupControl = (PopupControl)instance;
		return popupControl.CancelButtonForeground;
	}

	private void set_175_PopupControl_CancelButtonForeground(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		PopupControl popupControl = (PopupControl)instance;
		popupControl.CancelButtonForeground = (SolidColorBrush)Value;
	}

	private object get_176_SampleChatBubble_Text(object instance)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		return sampleChatBubble.Text;
	}

	private void set_176_SampleChatBubble_Text(object instance, object Value)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		sampleChatBubble.Text = (string)Value;
	}

	private object get_177_SampleChatBubble_SubText(object instance)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		return sampleChatBubble.SubText;
	}

	private void set_177_SampleChatBubble_SubText(object instance, object Value)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		sampleChatBubble.SubText = (string)Value;
	}

	private object get_178_SampleChatBubble_MediaText(object instance)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		return sampleChatBubble.MediaText;
	}

	private void set_178_SampleChatBubble_MediaText(object instance, object Value)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		sampleChatBubble.MediaText = (string)Value;
	}

	private object get_179_SampleChatBubble_SubParam(object instance)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		return sampleChatBubble.SubParam;
	}

	private void set_179_SampleChatBubble_SubParam(object instance, object Value)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		sampleChatBubble.SubParam = (int)Value;
	}

	private object get_180_SampleChatBubble_MaxBubbleWidth(object instance)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		return sampleChatBubble.MaxBubbleWidth;
	}

	private void set_180_SampleChatBubble_MaxBubbleWidth(object instance, object Value)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		sampleChatBubble.MaxBubbleWidth = (double)Value;
	}

	private object get_181_SampleChatBubble_Type(object instance)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		return sampleChatBubble.Type;
	}

	private void set_181_SampleChatBubble_Type(object instance, object Value)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		sampleChatBubble.Type = (int)Value;
	}

	private object get_182_SampleChatBubble_Message(object instance)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		return sampleChatBubble.Message;
	}

	private void set_182_SampleChatBubble_Message(object instance, object Value)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		sampleChatBubble.Message = (Message)Value;
	}

	private object get_183_SampleChatBubble_FixedFontSize(object instance)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		return sampleChatBubble.FixedFontSize;
	}

	private void set_183_SampleChatBubble_FixedFontSize(object instance, object Value)
	{
		SampleChatBubble sampleChatBubble = (SampleChatBubble)instance;
		sampleChatBubble.FixedFontSize = (double)Value;
	}

	private object get_184_UnknownBuddyProfileDialog_BuddyInfo(object instance)
	{
		UnknownBuddyProfileDialog unknownBuddyProfileDialog = (UnknownBuddyProfileDialog)instance;
		return unknownBuddyProfileDialog.BuddyInfo;
	}

	private void set_184_UnknownBuddyProfileDialog_BuddyInfo(object instance, object Value)
	{
		UnknownBuddyProfileDialog unknownBuddyProfileDialog = (UnknownBuddyProfileDialog)instance;
		unknownBuddyProfileDialog.BuddyInfo = (UnknownUser)Value;
	}

	private object get_185_UnknownBuddyProfileDialog_ParentPage(object instance)
	{
		UnknownBuddyProfileDialog unknownBuddyProfileDialog = (UnknownBuddyProfileDialog)instance;
		return unknownBuddyProfileDialog.ParentPage;
	}

	private void set_185_UnknownBuddyProfileDialog_ParentPage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		UnknownBuddyProfileDialog unknownBuddyProfileDialog = (UnknownBuddyProfileDialog)instance;
		unknownBuddyProfileDialog.ParentPage = (Page)Value;
	}

	private object get_186_TrunkDetailPage_LockToBottom(object instance)
	{
		TrunkDetailPage trunkDetailPage = (TrunkDetailPage)instance;
		return trunkDetailPage.LockToBottom;
	}

	private void set_186_TrunkDetailPage_LockToBottom(object instance, object Value)
	{
		TrunkDetailPage trunkDetailPage = (TrunkDetailPage)instance;
		trunkDetailPage.LockToBottom = (bool)Value;
	}

	private object get_187_ContactDetailPage_ContactInfos(object instance)
	{
		ContactDetailPage contactDetailPage = (ContactDetailPage)instance;
		return contactDetailPage.ContactInfos;
	}

	private void set_187_ContactDetailPage_ContactInfos(object instance, object Value)
	{
		ContactDetailPage contactDetailPage = (ContactDetailPage)instance;
		contactDetailPage.ContactInfos = (ObservableCollection<ContactDetailPage.ContactInfo>)Value;
	}

	private object get_188_ContactInfo_Type(object instance)
	{
		ContactDetailPage.ContactInfo contactInfo = (ContactDetailPage.ContactInfo)instance;
		return contactInfo.Type;
	}

	private void set_188_ContactInfo_Type(object instance, object Value)
	{
		ContactDetailPage.ContactInfo contactInfo = (ContactDetailPage.ContactInfo)instance;
		contactInfo.Type = (string)Value;
	}

	private object get_189_ContactInfo_Value(object instance)
	{
		ContactDetailPage.ContactInfo contactInfo = (ContactDetailPage.ContactInfo)instance;
		return contactInfo.Value;
	}

	private void set_189_ContactInfo_Value(object instance, object Value)
	{
		ContactDetailPage.ContactInfo contactInfo = (ContactDetailPage.ContactInfo)instance;
		contactInfo.Value = (string)Value;
	}

	private object get_190_CustomPopup_Page(object instance)
	{
		CustomPopup customPopup = (CustomPopup)instance;
		return customPopup.Page;
	}

	private object get_191_CustomPopup_Child(object instance)
	{
		CustomPopup customPopup = (CustomPopup)instance;
		return customPopup.Child;
	}

	private object get_192_DownloadSettingPage_ViewModel(object instance)
	{
		DownloadSettingPage downloadSettingPage = (DownloadSettingPage)instance;
		return downloadSettingPage.ViewModel;
	}

	private object get_193_DownloadSettingPage_IsLoaded(object instance)
	{
		DownloadSettingPage downloadSettingPage = (DownloadSettingPage)instance;
		return downloadSettingPage.IsLoaded;
	}

	private void set_193_DownloadSettingPage_IsLoaded(object instance, object Value)
	{
		DownloadSettingPage downloadSettingPage = (DownloadSettingPage)instance;
		downloadSettingPage.IsLoaded = (bool)Value;
	}

	private object get_194_EditProfilePage_IsToggleShowPhonenumberOn(object instance)
	{
		EditProfilePage editProfilePage = (EditProfilePage)instance;
		return editProfilePage.IsToggleShowPhonenumberOn;
	}

	private object get_195_EditProfilePage_IsToggleShowBirthdayOn(object instance)
	{
		EditProfilePage editProfilePage = (EditProfilePage)instance;
		return editProfilePage.IsToggleShowBirthdayOn;
	}

	private object get_196_EditProfilePage_IsToggleShowYear(object instance)
	{
		EditProfilePage editProfilePage = (EditProfilePage)instance;
		return editProfilePage.IsToggleShowYear;
	}

	private object get_197_GroupProfileDialog_GroupInfo(object instance)
	{
		GroupProfileDialog groupProfileDialog = (GroupProfileDialog)instance;
		return groupProfileDialog.GroupInfo;
	}

	private void set_197_GroupProfileDialog_GroupInfo(object instance, object Value)
	{
		GroupProfileDialog groupProfileDialog = (GroupProfileDialog)instance;
		groupProfileDialog.GroupInfo = (BuddyGroup)Value;
	}

	private object get_198_GroupProfileDialog_DisplayContainer(object instance)
	{
		GroupProfileDialog groupProfileDialog = (GroupProfileDialog)instance;
		return groupProfileDialog.DisplayContainer;
	}

	private void set_198_GroupProfileDialog_DisplayContainer(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		GroupProfileDialog groupProfileDialog = (GroupProfileDialog)instance;
		groupProfileDialog.DisplayContainer = (Grid)Value;
	}

	private object get_199_GroupProfileDialog_ViewModel(object instance)
	{
		GroupProfileDialog groupProfileDialog = (GroupProfileDialog)instance;
		return groupProfileDialog.ViewModel;
	}

	private object get_200_GroupProfileDialog_IsRenameMode(object instance)
	{
		GroupProfileDialog groupProfileDialog = (GroupProfileDialog)instance;
		return groupProfileDialog.IsRenameMode;
	}

	private void set_200_GroupProfileDialog_IsRenameMode(object instance, object Value)
	{
		GroupProfileDialog groupProfileDialog = (GroupProfileDialog)instance;
		groupProfileDialog.IsRenameMode = (bool)Value;
	}

	private object get_201_HiddenInteractionPage_ViewModel(object instance)
	{
		HiddenInteractionPage hiddenInteractionPage = (HiddenInteractionPage)instance;
		return hiddenInteractionPage.ViewModel;
	}

	private object get_202_HilightedTextBlock_Text(object instance)
	{
		HilightedTextBlock hilightedTextBlock = (HilightedTextBlock)instance;
		return hilightedTextBlock.Text;
	}

	private void set_202_HilightedTextBlock_Text(object instance, object Value)
	{
		HilightedTextBlock hilightedTextBlock = (HilightedTextBlock)instance;
		hilightedTextBlock.Text = (string)Value;
	}

	private object get_203_HilightedTextBlock_Keyword(object instance)
	{
		HilightedTextBlock hilightedTextBlock = (HilightedTextBlock)instance;
		return hilightedTextBlock.Keyword;
	}

	private void set_203_HilightedTextBlock_Keyword(object instance, object Value)
	{
		HilightedTextBlock hilightedTextBlock = (HilightedTextBlock)instance;
		hilightedTextBlock.Keyword = (string)Value;
	}

	private object get_204_HilightedTextBlock_MaxLength(object instance)
	{
		HilightedTextBlock hilightedTextBlock = (HilightedTextBlock)instance;
		return hilightedTextBlock.MaxLength;
	}

	private void set_204_HilightedTextBlock_MaxLength(object instance, object Value)
	{
		HilightedTextBlock hilightedTextBlock = (HilightedTextBlock)instance;
		hilightedTextBlock.MaxLength = (int)Value;
	}

	private object get_205_ImageButtonBase_NormalImage(object instance)
	{
		ImageButtonBase imageButtonBase = (ImageButtonBase)instance;
		return imageButtonBase.NormalImage;
	}

	private void set_205_ImageButtonBase_NormalImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageButtonBase imageButtonBase = (ImageButtonBase)instance;
		imageButtonBase.NormalImage = (ImageSource)Value;
	}

	private object get_206_ImageButtonBase_PressedImage(object instance)
	{
		ImageButtonBase imageButtonBase = (ImageButtonBase)instance;
		return imageButtonBase.PressedImage;
	}

	private void set_206_ImageButtonBase_PressedImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageButtonBase imageButtonBase = (ImageButtonBase)instance;
		imageButtonBase.PressedImage = (ImageSource)Value;
	}

	private object get_207_ImageButtonBase_DisabledImage(object instance)
	{
		ImageButtonBase imageButtonBase = (ImageButtonBase)instance;
		return imageButtonBase.DisabledImage;
	}

	private void set_207_ImageButtonBase_DisabledImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		ImageButtonBase imageButtonBase = (ImageButtonBase)instance;
		imageButtonBase.DisabledImage = (ImageSource)Value;
	}

	private object get_208_ImageButtonBase_Text(object instance)
	{
		ImageButtonBase imageButtonBase = (ImageButtonBase)instance;
		return imageButtonBase.Text;
	}

	private void set_208_ImageButtonBase_Text(object instance, object Value)
	{
		ImageButtonBase imageButtonBase = (ImageButtonBase)instance;
		imageButtonBase.Text = (string)Value;
	}

	private object get_209_RatioChart_LeftImage(object instance)
	{
		RatioChart ratioChart = (RatioChart)instance;
		return ratioChart.LeftImage;
	}

	private void set_209_RatioChart_LeftImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		RatioChart ratioChart = (RatioChart)instance;
		ratioChart.LeftImage = (ImageSource)Value;
	}

	private object get_210_RatioChart_RightImage(object instance)
	{
		RatioChart ratioChart = (RatioChart)instance;
		return ratioChart.RightImage;
	}

	private void set_210_RatioChart_RightImage(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		RatioChart ratioChart = (RatioChart)instance;
		ratioChart.RightImage = (ImageSource)Value;
	}

	private object get_211_RatioChart_LeftText(object instance)
	{
		RatioChart ratioChart = (RatioChart)instance;
		return ratioChart.LeftText;
	}

	private void set_211_RatioChart_LeftText(object instance, object Value)
	{
		RatioChart ratioChart = (RatioChart)instance;
		ratioChart.LeftText = (string)Value;
	}

	private object get_212_RatioChart_RightText(object instance)
	{
		RatioChart ratioChart = (RatioChart)instance;
		return ratioChart.RightText;
	}

	private void set_212_RatioChart_RightText(object instance, object Value)
	{
		RatioChart ratioChart = (RatioChart)instance;
		ratioChart.RightText = (string)Value;
	}

	private object get_213_RatioChart_LeftValue(object instance)
	{
		RatioChart ratioChart = (RatioChart)instance;
		return ratioChart.LeftValue;
	}

	private void set_213_RatioChart_LeftValue(object instance, object Value)
	{
		RatioChart ratioChart = (RatioChart)instance;
		ratioChart.LeftValue = (double)Value;
	}

	private object get_214_RatioChart_RightValue(object instance)
	{
		RatioChart ratioChart = (RatioChart)instance;
		return ratioChart.RightValue;
	}

	private void set_214_RatioChart_RightValue(object instance, object Value)
	{
		RatioChart ratioChart = (RatioChart)instance;
		ratioChart.RightValue = (double)Value;
	}

	private object get_215_RatioChart_StandardValue(object instance)
	{
		RatioChart ratioChart = (RatioChart)instance;
		return ratioChart.StandardValue;
	}

	private void set_215_RatioChart_StandardValue(object instance, object Value)
	{
		RatioChart ratioChart = (RatioChart)instance;
		ratioChart.StandardValue = (double)Value;
	}

	private object get_216_RatioChart_LeftFontColor(object instance)
	{
		RatioChart ratioChart = (RatioChart)instance;
		return ratioChart.LeftFontColor;
	}

	private void set_216_RatioChart_LeftFontColor(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		RatioChart ratioChart = (RatioChart)instance;
		ratioChart.LeftFontColor = (Brush)Value;
	}

	private object get_217_RatioChart_RightFontColor(object instance)
	{
		RatioChart ratioChart = (RatioChart)instance;
		return ratioChart.RightFontColor;
	}

	private void set_217_RatioChart_RightFontColor(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		RatioChart ratioChart = (RatioChart)instance;
		ratioChart.RightFontColor = (Brush)Value;
	}

	private object get_218_PhotoFrame_MaxBubbleWidth(object instance)
	{
		PhotoFrame photoFrame = (PhotoFrame)instance;
		return photoFrame.MaxBubbleWidth;
	}

	private void set_218_PhotoFrame_MaxBubbleWidth(object instance, object Value)
	{
		PhotoFrame photoFrame = (PhotoFrame)instance;
		photoFrame.MaxBubbleWidth = (double)Value;
	}

	private object get_219_PhotoFrame_Photo(object instance)
	{
		PhotoFrame photoFrame = (PhotoFrame)instance;
		return photoFrame.Photo;
	}

	private void set_219_PhotoFrame_Photo(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		//IL_0013: Expected O, but got Unknown
		PhotoFrame photoFrame = (PhotoFrame)instance;
		photoFrame.Photo = (ImageSource)Value;
	}

	private object get_220_PhotoFrame_IconVisibility(object instance)
	{
		PhotoFrame photoFrame = (PhotoFrame)instance;
		return photoFrame.IconVisibility;
	}

	private void set_220_PhotoFrame_IconVisibility(object instance, object Value)
	{
		PhotoFrame photoFrame = (PhotoFrame)instance;
		photoFrame.IconVisibility = (bool)Value;
	}

	private object get_221_PhotoFrame_Stretch(object instance)
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		PhotoFrame photoFrame = (PhotoFrame)instance;
		return photoFrame.Stretch;
	}

	private void set_221_PhotoFrame_Stretch(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		PhotoFrame photoFrame = (PhotoFrame)instance;
		photoFrame.Stretch = (Stretch)Value;
	}

	private object get_222_PivotPage_ViewModel(object instance)
	{
		PivotPage pivotPage = (PivotPage)instance;
		return pivotPage.ViewModel;
	}

	private void set_222_PivotPage_ViewModel(object instance, object Value)
	{
		PivotPage pivotPage = (PivotPage)instance;
		pivotPage.ViewModel = (PivotPageViewModel)Value;
	}

	private object get_223_PreviewAniconDialog_AniconID(object instance)
	{
		PreviewAniconDialog previewAniconDialog = (PreviewAniconDialog)instance;
		return previewAniconDialog.AniconID;
	}

	private void set_223_PreviewAniconDialog_AniconID(object instance, object Value)
	{
		PreviewAniconDialog previewAniconDialog = (PreviewAniconDialog)instance;
		previewAniconDialog.AniconID = (string)Value;
	}

	private object get_224_BindingService_FullText(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected O, but got Unknown
		return BindingService.GetFullText((TextBlock)instance);
	}

	private void set_224_BindingService_FullText(object instance, object Value)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Expected O, but got Unknown
		BindingService.SetFullText((TextBlock)instance, (string)Value);
	}

	private object get_225_BindingService_HighlightedText(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected O, but got Unknown
		return BindingService.GetHighlightedText((TextBlock)instance);
	}

	private void set_225_BindingService_HighlightedText(object instance, object Value)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Expected O, but got Unknown
		BindingService.SetHighlightedText((TextBlock)instance, (string)Value);
	}

	private object get_226_BindingService_HighlightBrush(object instance)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_000b: Expected O, but got Unknown
		return BindingService.GetHighlightBrush((TextBlock)instance);
	}

	private void set_226_BindingService_HighlightBrush(object instance, object Value)
	{
		//IL_0001: Unknown result type (might be due to invalid IL or missing references)
		//IL_0007: Unknown result type (might be due to invalid IL or missing references)
		//IL_0011: Expected O, but got Unknown
		//IL_0011: Expected O, but got Unknown
		BindingService.SetHighlightBrush((TextBlock)instance, (Brush)Value);
	}

	private object get_227_WrapPanel_Orientation(object instance)
	{
		//IL_0008: Unknown result type (might be due to invalid IL or missing references)
		WrapPanel wrapPanel = (WrapPanel)instance;
		return wrapPanel.Orientation;
	}

	private void set_227_WrapPanel_Orientation(object instance, object Value)
	{
		//IL_0009: Unknown result type (might be due to invalid IL or missing references)
		WrapPanel wrapPanel = (WrapPanel)instance;
		wrapPanel.Orientation = (Orientation)Value;
	}

	private object get_228_WrapPanel_ItemHeight(object instance)
	{
		WrapPanel wrapPanel = (WrapPanel)instance;
		return wrapPanel.ItemHeight;
	}

	private void set_228_WrapPanel_ItemHeight(object instance, object Value)
	{
		WrapPanel wrapPanel = (WrapPanel)instance;
		wrapPanel.ItemHeight = (double)Value;
	}

	private object get_229_WrapPanel_ItemWidth(object instance)
	{
		WrapPanel wrapPanel = (WrapPanel)instance;
		return wrapPanel.ItemWidth;
	}

	private void set_229_WrapPanel_ItemWidth(object instance, object Value)
	{
		WrapPanel wrapPanel = (WrapPanel)instance;
		wrapPanel.ItemWidth = (double)Value;
	}

	private IXamlMember CreateXamlMember(string longMemberName)
	{
		XamlMember xamlMember = null;
		switch (longMemberName)
		{
		case "ChatOn.Controls.DateChooser.SelectedDate":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.DateChooser");
			xamlMember = new XamlMember(this, "SelectedDate", "System.DateTime");
			xamlMember.Getter = get_0_DateChooser_SelectedDate;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Controls.AddBirthdayDialog.MyProfile":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.AddBirthdayDialog");
			xamlMember = new XamlMember(this, "MyProfile", "ChatOn.Models.UserProfile");
			xamlMember.Getter = get_1_AddBirthdayDialog_MyProfile;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Controls.AddBirthdayDialog.IsShowYear":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.AddBirthdayDialog");
			xamlMember = new XamlMember(this, "IsShowYear", "Boolean");
			xamlMember.Getter = get_2_AddBirthdayDialog_IsShowYear;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Controls.AddBirthdayDialog.SelectedDate":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.AddBirthdayDialog");
			xamlMember = new XamlMember(this, "SelectedDate", "System.DateTime");
			xamlMember.Getter = get_3_AddBirthdayDialog_SelectedDate;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Controls.AddBuddiesSayDialog.PhoneNumber":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.AddBuddiesSayDialog");
			xamlMember = new XamlMember(this, "PhoneNumber", "String");
			xamlMember.Getter = get_4_AddBuddiesSayDialog_PhoneNumber;
			xamlMember.Setter = set_4_AddBuddiesSayDialog_PhoneNumber;
			break;
		case "ChatOn.Controls.ImageButton.NormalImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButton");
			xamlMember = new XamlMember(this, "NormalImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_5_ImageButton_NormalImage;
			xamlMember.Setter = set_5_ImageButton_NormalImage;
			break;
		case "ChatOn.Controls.ImageButton.PressedImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButton");
			xamlMember = new XamlMember(this, "PressedImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_6_ImageButton_PressedImage;
			xamlMember.Setter = set_6_ImageButton_PressedImage;
			break;
		case "ChatOn.Controls.ImageButton.Text":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButton");
			xamlMember = new XamlMember(this, "Text", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_7_ImageButton_Text;
			xamlMember.Setter = set_7_ImageButton_Text;
			break;
		case "ChatOn.Controls.ImageButton.Foreground":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButton");
			xamlMember = new XamlMember(this, "Foreground", "Windows.UI.Xaml.Media.Brush");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_8_ImageButton_Foreground;
			xamlMember.Setter = set_8_ImageButton_Foreground;
			break;
		case "ChatOn.Controls.ImageButton.DisabledImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButton");
			xamlMember = new XamlMember(this, "DisabledImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_9_ImageButton_DisabledImage;
			xamlMember.Setter = set_9_ImageButton_DisabledImage;
			break;
		case "ChatOn.Controls.ImageButton.LightNormalImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButton");
			xamlMember = new XamlMember(this, "LightNormalImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_10_ImageButton_LightNormalImage;
			xamlMember.Setter = set_10_ImageButton_LightNormalImage;
			break;
		case "ChatOn.Controls.ImageButton.LightPressedImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButton");
			xamlMember = new XamlMember(this, "LightPressedImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_11_ImageButton_LightPressedImage;
			xamlMember.Setter = set_11_ImageButton_LightPressedImage;
			break;
		case "ChatOn.Controls.ImageButton.LightDisabledImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButton");
			xamlMember = new XamlMember(this, "LightDisabledImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_12_ImageButton_LightDisabledImage;
			xamlMember.Setter = set_12_ImageButton_LightDisabledImage;
			break;
		case "ChatOn.Controls.ImageButton.ClickMode":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButton");
			xamlMember = new XamlMember(this, "ClickMode", "Windows.UI.Xaml.Controls.ClickMode");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_13_ImageButton_ClickMode;
			xamlMember.Setter = set_13_ImageButton_ClickMode;
			break;
		case "ChatOn.Controls.AddBuddyDialog.ResultList":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.AddBuddyDialog");
			xamlMember = new XamlMember(this, "ResultList", "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.Buddy>");
			xamlMember.Getter = get_14_AddBuddyDialog_ResultList;
			xamlMember.Setter = set_14_AddBuddyDialog_ResultList;
			break;
		case "ChatOn.Models.Buddy.BuddyID":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "BuddyID", "Guid");
			xamlMember.Getter = get_15_Buddy_BuddyID;
			xamlMember.Setter = set_15_Buddy_BuddyID;
			break;
		case "ChatOn.Models.Buddy.Name":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "Name", "String");
			xamlMember.Getter = get_16_Buddy_Name;
			xamlMember.Setter = set_16_Buddy_Name;
			break;
		case "ChatOn.Models.Buddy.PhoneNumber":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "PhoneNumber", "String");
			xamlMember.Getter = get_17_Buddy_PhoneNumber;
			xamlMember.Setter = set_17_Buddy_PhoneNumber;
			break;
		case "ChatOn.Models.Buddy.Sainfo":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "Sainfo", "String");
			xamlMember.Getter = get_18_Buddy_Sainfo;
			xamlMember.Setter = set_18_Buddy_Sainfo;
			break;
		case "ChatOn.Models.Buddy.OrgNumber":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "OrgNumber", "String");
			xamlMember.Getter = get_19_Buddy_OrgNumber;
			xamlMember.Setter = set_19_Buddy_OrgNumber;
			break;
		case "ChatOn.Models.Buddy.Status":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "Status", "String");
			xamlMember.Getter = get_20_Buddy_Status;
			xamlMember.Setter = set_20_Buddy_Status;
			break;
		case "ChatOn.Models.Buddy.Birthday":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "Birthday", "String");
			xamlMember.Getter = get_21_Buddy_Birthday;
			xamlMember.Setter = set_21_Buddy_Birthday;
			break;
		case "ChatOn.Models.Buddy.Email":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "Email", "String");
			xamlMember.Getter = get_22_Buddy_Email;
			xamlMember.Setter = set_22_Buddy_Email;
			break;
		case "ChatOn.Models.Buddy.SamsungEmail":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "SamsungEmail", "String");
			xamlMember.Getter = get_23_Buddy_SamsungEmail;
			xamlMember.Setter = set_23_Buddy_SamsungEmail;
			break;
		case "ChatOn.Models.Buddy.ImgStatus":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "ImgStatus", "ChatOn.Models.Buddy.ProfileImgStatus");
			xamlMember.Getter = get_24_Buddy_ImgStatus;
			xamlMember.Setter = set_24_Buddy_ImgStatus;
			break;
		case "ChatOn.Models.Buddy.Type":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "Type", "ChatOn.Models.Buddy.BuddyType");
			xamlMember.Getter = get_25_Buddy_Type;
			xamlMember.Setter = set_25_Buddy_Type;
			break;
		case "ChatOn.Models.Buddy.IsFavorite":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsFavorite", "Boolean");
			xamlMember.Getter = get_26_Buddy_IsFavorite;
			xamlMember.Setter = set_26_Buddy_IsFavorite;
			break;
		case "ChatOn.Models.Buddy.SentCount":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "SentCount", "Int32");
			xamlMember.Getter = get_27_Buddy_SentCount;
			xamlMember.Setter = set_27_Buddy_SentCount;
			break;
		case "ChatOn.Models.Buddy.ReceivedCount":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "ReceivedCount", "Int32");
			xamlMember.Getter = get_28_Buddy_ReceivedCount;
			xamlMember.Setter = set_28_Buddy_ReceivedCount;
			break;
		case "ChatOn.Models.Buddy.IsHideInteraction":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsHideInteraction", "Boolean");
			xamlMember.Getter = get_29_Buddy_IsHideInteraction;
			xamlMember.Setter = set_29_Buddy_IsHideInteraction;
			break;
		case "ChatOn.Models.Buddy.Rank":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "Rank", "Int32");
			xamlMember.Getter = get_30_Buddy_Rank;
			xamlMember.Setter = set_30_Buddy_Rank;
			break;
		case "ChatOn.Models.Buddy.IsShowPhoneNumber":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsShowPhoneNumber", "Boolean");
			xamlMember.Getter = get_31_Buddy_IsShowPhoneNumber;
			xamlMember.Setter = set_31_Buddy_IsShowPhoneNumber;
			break;
		case "ChatOn.Models.Buddy.IsBlind":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsBlind", "Boolean");
			xamlMember.Getter = get_32_Buddy_IsBlind;
			xamlMember.Setter = set_32_Buddy_IsBlind;
			break;
		case "ChatOn.Models.Buddy.IsBlindText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsBlindText", "Boolean");
			xamlMember.Getter = get_33_Buddy_IsBlindText;
			xamlMember.Setter = set_33_Buddy_IsBlindText;
			break;
		case "ChatOn.Models.Buddy.IsBlocked":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsBlocked", "Boolean");
			xamlMember.Getter = get_34_Buddy_IsBlocked;
			xamlMember.Setter = set_34_Buddy_IsBlocked;
			break;
		case "ChatOn.Models.Buddy.ProfileName":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "ProfileName", "String");
			xamlMember.Getter = get_35_Buddy_ProfileName;
			xamlMember.Setter = set_35_Buddy_ProfileName;
			break;
		case "ChatOn.Models.Buddy.MSISDNS":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "MSISDNS", "String");
			xamlMember.Getter = get_36_Buddy_MSISDNS;
			xamlMember.Setter = set_36_Buddy_MSISDNS;
			break;
		case "ChatOn.Models.Buddy.HasMultipleNumbers":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "HasMultipleNumbers", "Boolean");
			xamlMember.Getter = get_37_Buddy_HasMultipleNumbers;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Models.Buddy.IsSpecialBuddy":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsSpecialBuddy", "Boolean");
			xamlMember.Getter = get_38_Buddy_IsSpecialBuddy;
			xamlMember.Setter = set_38_Buddy_IsSpecialBuddy;
			break;
		case "ChatOn.Models.Buddy.OrgPhoneNumberVisible":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "OrgPhoneNumberVisible", "Windows.UI.Xaml.Visibility");
			xamlMember.Getter = get_39_Buddy_OrgPhoneNumberVisible;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Models.Buddy.PhoneNumberList":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "PhoneNumberList", "System.Collections.Generic.List<String>");
			xamlMember.Getter = get_40_Buddy_PhoneNumberList;
			xamlMember.Setter = set_40_Buddy_PhoneNumberList;
			break;
		case "ChatOn.Models.Buddy.InteractionPoint":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "InteractionPoint", "Int32");
			xamlMember.Getter = get_41_Buddy_InteractionPoint;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Models.Buddy.BestInteractionPoint":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "BestInteractionPoint", "Int32");
			xamlMember.Getter = get_42_Buddy_BestInteractionPoint;
			xamlMember.Setter = set_42_Buddy_BestInteractionPoint;
			break;
		case "ChatOn.Models.Buddy.ThumbProfileImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "ThumbProfileImage", "Windows.UI.Xaml.Media.Imaging.BitmapImage");
			xamlMember.Getter = get_43_Buddy_ThumbProfileImage;
			xamlMember.Setter = set_43_Buddy_ThumbProfileImage;
			break;
		case "ChatOn.Models.Buddy.ProfileImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "ProfileImage", "Windows.UI.Xaml.Media.Imaging.BitmapImage");
			xamlMember.Getter = get_44_Buddy_ProfileImage;
			xamlMember.Setter = set_44_Buddy_ProfileImage;
			break;
		case "ChatOn.Models.Buddy.DisplayRank":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "DisplayRank", "Int32");
			xamlMember.Getter = get_45_Buddy_DisplayRank;
			xamlMember.Setter = set_45_Buddy_DisplayRank;
			break;
		case "ChatOn.Models.Buddy.IndexString":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IndexString", "String");
			xamlMember.Getter = get_46_Buddy_IndexString;
			xamlMember.Setter = set_46_Buddy_IndexString;
			break;
		case "ChatOn.Models.Buddy.IsChecked":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsChecked", "Boolean");
			xamlMember.Getter = get_47_Buddy_IsChecked;
			xamlMember.Setter = set_47_Buddy_IsChecked;
			break;
		case "ChatOn.Models.Buddy.IsNew":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsNew", "Boolean");
			xamlMember.Getter = get_48_Buddy_IsNew;
			xamlMember.Setter = set_48_Buddy_IsNew;
			break;
		case "ChatOn.Models.Buddy.StatusForeground":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "StatusForeground", "Windows.UI.Xaml.Media.Brush");
			xamlMember.Getter = get_49_Buddy_StatusForeground;
			xamlMember.Setter = set_49_Buddy_StatusForeground;
			break;
		case "ChatOn.Models.Buddy.Background":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "Background", "Windows.UI.Xaml.Media.Brush");
			xamlMember.Getter = get_50_Buddy_Background;
			xamlMember.Setter = set_50_Buddy_Background;
			break;
		case "ChatOn.Models.Buddy.IsDownloading":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsDownloading", "Boolean");
			xamlMember.Getter = get_51_Buddy_IsDownloading;
			xamlMember.Setter = set_51_Buddy_IsDownloading;
			break;
		case "ChatOn.Models.Buddy.IsInteractionDeleteMode":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Buddy");
			xamlMember = new XamlMember(this, "IsInteractionDeleteMode", "Boolean");
			xamlMember.Getter = get_52_Buddy_IsInteractionDeleteMode;
			xamlMember.Setter = set_52_Buddy_IsInteractionDeleteMode;
			break;
		case "SDatabase.SDBData.Index":
			_ = (XamlUserType)(object)GetXamlTypeByName("SDatabase.SDBData");
			xamlMember = new XamlMember(this, "Index", "SDatabase.SDBIndex");
			xamlMember.Getter = get_53_SDBData_Index;
			xamlMember.Setter = set_53_SDBData_Index;
			break;
		case "SDatabase.SDBData.Id":
			_ = (XamlUserType)(object)GetXamlTypeByName("SDatabase.SDBData");
			xamlMember = new XamlMember(this, "Id", "Guid");
			xamlMember.Getter = get_54_SDBData_Id;
			xamlMember.Setter = set_54_SDBData_Id;
			break;
		case "ChatOn.Controls.AddBuddyDialog.ResultList2":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.AddBuddyDialog");
			xamlMember = new XamlMember(this, "ResultList2", "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.Buddy>");
			xamlMember.Getter = get_55_AddBuddyDialog_ResultList2;
			xamlMember.Setter = set_55_AddBuddyDialog_ResultList2;
			break;
		case "ChatOn.Controls.AddBuddyDialog.TellFriendsList":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.AddBuddyDialog");
			xamlMember = new XamlMember(this, "TellFriendsList", "System.Collections.ObjectModel.ObservableCollection<ChatOn.Controls.TellFriendsItem>");
			xamlMember.Getter = get_56_AddBuddyDialog_TellFriendsList;
			xamlMember.Setter = set_56_AddBuddyDialog_TellFriendsList;
			break;
		case "ChatOn.Controls.TellFriendsItem.Name":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.TellFriendsItem");
			xamlMember = new XamlMember(this, "Name", "String");
			xamlMember.Getter = get_57_TellFriendsItem_Name;
			xamlMember.Setter = set_57_TellFriendsItem_Name;
			break;
		case "ChatOn.Controls.AddBuddyDialog._updateBuddyFromUploadAddressRunning":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.AddBuddyDialog");
			xamlMember = new XamlMember(this, "_updateBuddyFromUploadAddressRunning", "Boolean");
			xamlMember.Getter = get_58_AddBuddyDialog__updateBuddyFromUploadAddressRunning;
			xamlMember.Setter = set_58_AddBuddyDialog__updateBuddyFromUploadAddressRunning;
			break;
		case "ChatOn.Controls.AddGroupDialog.Group":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.AddGroupDialog");
			xamlMember = new XamlMember(this, "Group", "ChatOn.Models.BuddyGroup");
			xamlMember.Getter = get_59_AddGroupDialog_Group;
			xamlMember.Setter = set_59_AddGroupDialog_Group;
			break;
		case "ChatOn.Controls.AniconPlayer.SourceID":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.AniconPlayer");
			xamlMember = new XamlMember(this, "SourceID", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_60_AniconPlayer_SourceID;
			xamlMember.Setter = set_60_AniconPlayer_SourceID;
			break;
		case "ChatOn.Controls.BindRichTextBlock.Text":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.BindRichTextBlock");
			xamlMember = new XamlMember(this, "Text", "Windows.UI.Xaml.Documents.Paragraph");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_61_BindRichTextBlock_Text;
			xamlMember.Setter = set_61_BindRichTextBlock_Text;
			break;
		case "ChatON_WoA.Views.BlockListPage.ViewModel":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.BlockListPage");
			xamlMember = new XamlMember(this, "ViewModel", "ChatOn.ViewModels.BlockListPageViewModel");
			xamlMember.Getter = get_62_BlockListPage_ViewModel;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Controls.BuddyProfileDialog.BuddyInfo":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.BuddyProfileDialog");
			xamlMember = new XamlMember(this, "BuddyInfo", "ChatOn.Models.Buddy");
			xamlMember.Getter = get_63_BuddyProfileDialog_BuddyInfo;
			xamlMember.Setter = set_63_BuddyProfileDialog_BuddyInfo;
			break;
		case "ChatOn.Controls.BuddyProfileDialog.ParentPage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.BuddyProfileDialog");
			xamlMember = new XamlMember(this, "ParentPage", "Windows.UI.Xaml.Controls.Page");
			xamlMember.Getter = get_64_BuddyProfileDialog_ParentPage;
			xamlMember.Setter = set_64_BuddyProfileDialog_ParentPage;
			break;
		case "ChatOn.Controls.BuddyProfileDialog.IsRenameMode":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.BuddyProfileDialog");
			xamlMember = new XamlMember(this, "IsRenameMode", "Boolean");
			xamlMember.Getter = get_65_BuddyProfileDialog_IsRenameMode;
			xamlMember.Setter = set_65_BuddyProfileDialog_IsRenameMode;
			break;
		case "ChatON_WoA.Views.CalendarDetailPage.CalInfo":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.CalendarDetailPage");
			xamlMember = new XamlMember(this, "CalInfo", "ChatON_WoA.Views.CalendarDetailPage.CalendarInfo");
			xamlMember.Getter = get_66_CalendarDetailPage_CalInfo;
			xamlMember.Setter = set_66_CalendarDetailPage_CalInfo;
			break;
		case "ChatOn.Controls.ChatTextBlock.IsParsingLinkEnabled":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatTextBlock");
			xamlMember = new XamlMember(this, "IsParsingLinkEnabled", "Boolean");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_67_ChatTextBlock_IsParsingLinkEnabled;
			xamlMember.Setter = set_67_ChatTextBlock_IsParsingLinkEnabled;
			break;
		case "ChatOn.Controls.ChatTextBlock.EmoticonSize":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatTextBlock");
			xamlMember = new XamlMember(this, "EmoticonSize", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_68_ChatTextBlock_EmoticonSize;
			xamlMember.Setter = set_68_ChatTextBlock_EmoticonSize;
			break;
		case "ChatOn.Controls.ChatTextBlock.ForegroundText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatTextBlock");
			xamlMember = new XamlMember(this, "ForegroundText", "Windows.UI.Xaml.Media.SolidColorBrush");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_69_ChatTextBlock_ForegroundText;
			xamlMember.Setter = set_69_ChatTextBlock_ForegroundText;
			break;
		case "ChatOn.Controls.ChatTextBlock.MaxLength":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatTextBlock");
			xamlMember = new XamlMember(this, "MaxLength", "Int32");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_70_ChatTextBlock_MaxLength;
			xamlMember.Setter = set_70_ChatTextBlock_MaxLength;
			break;
		case "ChatOn.Controls.ChatTextBlock.Text":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatTextBlock");
			xamlMember = new XamlMember(this, "Text", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_71_ChatTextBlock_Text;
			xamlMember.Setter = set_71_ChatTextBlock_Text;
			break;
		case "ChatOn.Controls.ChatBubble.Text":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatBubble");
			xamlMember = new XamlMember(this, "Text", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_72_ChatBubble_Text;
			xamlMember.Setter = set_72_ChatBubble_Text;
			break;
		case "ChatOn.Controls.ChatBubble.SubText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatBubble");
			xamlMember = new XamlMember(this, "SubText", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_73_ChatBubble_SubText;
			xamlMember.Setter = set_73_ChatBubble_SubText;
			break;
		case "ChatOn.Controls.ChatBubble.MediaText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatBubble");
			xamlMember = new XamlMember(this, "MediaText", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_74_ChatBubble_MediaText;
			xamlMember.Setter = set_74_ChatBubble_MediaText;
			break;
		case "ChatOn.Controls.ChatBubble.SubParam":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatBubble");
			xamlMember = new XamlMember(this, "SubParam", "Int32");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_75_ChatBubble_SubParam;
			xamlMember.Setter = set_75_ChatBubble_SubParam;
			break;
		case "ChatOn.Controls.ChatBubble.MaxBubbleWidth":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatBubble");
			xamlMember = new XamlMember(this, "MaxBubbleWidth", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_76_ChatBubble_MaxBubbleWidth;
			xamlMember.Setter = set_76_ChatBubble_MaxBubbleWidth;
			break;
		case "ChatOn.Controls.ChatBubble.Type":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatBubble");
			xamlMember = new XamlMember(this, "Type", "Int32");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_77_ChatBubble_Type;
			xamlMember.Setter = set_77_ChatBubble_Type;
			break;
		case "ChatOn.Controls.ChatBubble.Message":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatBubble");
			xamlMember = new XamlMember(this, "Message", "ChatOn.Models.Message");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_78_ChatBubble_Message;
			xamlMember.Setter = set_78_ChatBubble_Message;
			break;
		case "ChatOn.Controls.ChatBubble.FixedFontSize":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ChatBubble");
			xamlMember = new XamlMember(this, "FixedFontSize", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_79_ChatBubble_FixedFontSize;
			xamlMember.Setter = set_79_ChatBubble_FixedFontSize;
			break;
		case "ChatOn.Controls.DateDisplayUserControl.ItemContent":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.DateDisplayUserControl");
			xamlMember = new XamlMember(this, "ItemContent", "Windows.UI.Xaml.UIElement");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_80_DateDisplayUserControl_ItemContent;
			xamlMember.Setter = set_80_DateDisplayUserControl_ItemContent;
			break;
		case "ChatON_WoA.Views.ChatDetailPage.ListVerticalOffset":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatDetailPage");
			xamlMember = new XamlMember(this, "ListVerticalOffset", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_81_ChatDetailPage_ListVerticalOffset;
			xamlMember.Setter = set_81_ChatDetailPage_ListVerticalOffset;
			break;
		case "ChatON_WoA.Views.ChatDetailPage.ListVerticalOffsetMediator":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatDetailPage");
			xamlMember = new XamlMember(this, "ListVerticalOffsetMediator", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_82_ChatDetailPage_ListVerticalOffsetMediator;
			xamlMember.Setter = set_82_ChatDetailPage_ListVerticalOffsetMediator;
			break;
		case "ChatON_WoA.Views.ChatDetailPage.ViewModel":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatDetailPage");
			xamlMember = new XamlMember(this, "ViewModel", "ChatOn.ViewModels.ChatDetailPageViewModel");
			xamlMember.Getter = get_83_ChatDetailPage_ViewModel;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatON_WoA.Views.ChatDetailPage.LastAddedTick":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatDetailPage");
			xamlMember = new XamlMember(this, "LastAddedTick", "Int64");
			xamlMember.Getter = get_84_ChatDetailPage_LastAddedTick;
			xamlMember.Setter = set_84_ChatDetailPage_LastAddedTick;
			break;
		case "ChatON_WoA.Views.ChatDetailPage.IsMouseHold":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatDetailPage");
			xamlMember = new XamlMember(this, "IsMouseHold", "Boolean");
			xamlMember.Getter = get_85_ChatDetailPage_IsMouseHold;
			xamlMember.Setter = set_85_ChatDetailPage_IsMouseHold;
			break;
		case "ChatON_WoA.Views.ChatDetailPage.TmpSender":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatDetailPage");
			xamlMember = new XamlMember(this, "TmpSender", "Object");
			xamlMember.Getter = get_86_ChatDetailPage_TmpSender;
			xamlMember.Setter = set_86_ChatDetailPage_TmpSender;
			break;
		case "ChatON_WoA.Views.ChatDetailPage.Gr":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatDetailPage");
			xamlMember = new XamlMember(this, "Gr", "Windows.UI.Input.GestureRecognizer");
			xamlMember.Getter = get_87_ChatDetailPage_Gr;
			xamlMember.Setter = set_87_ChatDetailPage_Gr;
			break;
		case "ChatOn.Controls.EmoticonChooser.newPackage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.EmoticonChooser");
			xamlMember = new XamlMember(this, "newPackage", "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.OfflineAniconPackage>");
			xamlMember.Getter = get_88_EmoticonChooser_newPackage;
			xamlMember.Setter = set_88_EmoticonChooser_newPackage;
			break;
		case "ChatOn.Models.OfflineAniconPackage.DownloadOperation":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "DownloadOperation", "Windows.Networking.BackgroundTransfer.DownloadOperation");
			xamlMember.Getter = get_89_OfflineAniconPackage_DownloadOperation;
			xamlMember.Setter = set_89_OfflineAniconPackage_DownloadOperation;
			break;
		case "ChatOn.Models.OfflineAniconPackage.IsSelected":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "IsSelected", "Boolean");
			xamlMember.Getter = get_90_OfflineAniconPackage_IsSelected;
			xamlMember.Setter = set_90_OfflineAniconPackage_IsSelected;
			break;
		case "ChatOn.Models.OfflineAniconPackage.ThumbImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "ThumbImage", "Windows.UI.Xaml.Media.Imaging.BitmapImage");
			xamlMember.Getter = get_91_OfflineAniconPackage_ThumbImage;
			xamlMember.Setter = set_91_OfflineAniconPackage_ThumbImage;
			break;
		case "ChatOn.Models.OfflineAniconPackage.LoadTemplate":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "LoadTemplate", "Boolean");
			xamlMember.Getter = get_92_OfflineAniconPackage_LoadTemplate;
			xamlMember.Setter = set_92_OfflineAniconPackage_LoadTemplate;
			break;
		case "ChatOn.Models.OfflineAniconPackage.IsLoaded":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "IsLoaded", "Boolean");
			xamlMember.Getter = get_93_OfflineAniconPackage_IsLoaded;
			xamlMember.Setter = set_93_OfflineAniconPackage_IsLoaded;
			break;
		case "ChatOn.Models.OfflineAniconPackage.CurrentPackage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "CurrentPackage", "ChatON_WoA.DataModel.AniconPackage");
			xamlMember.Getter = get_94_OfflineAniconPackage_CurrentPackage;
			xamlMember.Setter = set_94_OfflineAniconPackage_CurrentPackage;
			break;
		case "ChatOn.Models.OfflineAniconPackage.ProxyUrl":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "ProxyUrl", "String");
			xamlMember.Getter = get_95_OfflineAniconPackage_ProxyUrl;
			xamlMember.Setter = set_95_OfflineAniconPackage_ProxyUrl;
			break;
		case "ChatOn.Models.OfflineAniconPackage.PackageZipUrl":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "PackageZipUrl", "String");
			xamlMember.Getter = get_96_OfflineAniconPackage_PackageZipUrl;
			xamlMember.Setter = set_96_OfflineAniconPackage_PackageZipUrl;
			break;
		case "ChatOn.Models.OfflineAniconPackage.AniconList":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "AniconList", "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.Anicon>");
			xamlMember.Getter = get_97_OfflineAniconPackage_AniconList;
			xamlMember.Setter = set_97_OfflineAniconPackage_AniconList;
			break;
		case "ChatOn.Models.Anicon.IsShowLoading":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "IsShowLoading", "Windows.UI.Xaml.Visibility");
			xamlMember.Getter = get_98_Anicon_IsShowLoading;
			xamlMember.Setter = set_98_Anicon_IsShowLoading;
			break;
		case "ChatOn.Models.Anicon.IsLoading":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "IsLoading", "Boolean");
			xamlMember.Getter = get_99_Anicon_IsLoading;
			xamlMember.Setter = set_99_Anicon_IsLoading;
			break;
		case "ChatOn.Models.Anicon.IsLoaded":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "IsLoaded", "Boolean");
			xamlMember.Getter = get_100_Anicon_IsLoaded;
			xamlMember.Setter = set_100_Anicon_IsLoaded;
			break;
		case "ChatOn.Models.Anicon.MsgUrl":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "MsgUrl", "String");
			xamlMember.Getter = get_101_Anicon_MsgUrl;
			xamlMember.Setter = set_101_Anicon_MsgUrl;
			break;
		case "ChatOn.Models.Anicon.ID":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "ID", "String");
			xamlMember.Getter = get_102_Anicon_ID;
			xamlMember.Setter = set_102_Anicon_ID;
			break;
		case "ChatOn.Models.Anicon.DelegateImageFile":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "DelegateImageFile", "Windows.Storage.StorageFile");
			xamlMember.Getter = get_103_Anicon_DelegateImageFile;
			xamlMember.Setter = set_103_Anicon_DelegateImageFile;
			break;
		case "ChatOn.Models.Anicon.DelegateImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "DelegateImage", "Windows.UI.Xaml.Media.Imaging.BitmapImage");
			xamlMember.Getter = get_104_Anicon_DelegateImage;
			xamlMember.Setter = set_104_Anicon_DelegateImage;
			break;
		case "ChatOn.Models.Anicon.ImageUrlList":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "ImageUrlList", "System.Collections.Generic.List<String>");
			xamlMember.Getter = get_105_Anicon_ImageUrlList;
			xamlMember.Setter = set_105_Anicon_ImageUrlList;
			break;
		case "ChatOn.Models.Anicon.ImageFileList":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "ImageFileList", "System.Collections.Generic.List<Windows.Storage.StorageFile>");
			xamlMember.Getter = get_106_Anicon_ImageFileList;
			xamlMember.Setter = set_106_Anicon_ImageFileList;
			break;
		case "Windows.Storage.StorageFile.ContentType":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "ContentType", "String");
			xamlMember.Getter = get_107_StorageFile_ContentType;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.FileType":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "FileType", "String");
			xamlMember.Getter = get_108_StorageFile_FileType;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.Attributes":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "Attributes", "Windows.Storage.FileAttributes");
			xamlMember.Getter = get_109_StorageFile_Attributes;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.DateCreated":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "DateCreated", "System.DateTimeOffset");
			xamlMember.Getter = get_110_StorageFile_DateCreated;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.Name":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "Name", "String");
			xamlMember.Getter = get_111_StorageFile_Name;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.Path":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "Path", "String");
			xamlMember.Getter = get_112_StorageFile_Path;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.DisplayName":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "DisplayName", "String");
			xamlMember.Getter = get_113_StorageFile_DisplayName;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.DisplayType":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "DisplayType", "String");
			xamlMember.Getter = get_114_StorageFile_DisplayType;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.FolderRelativeId":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "FolderRelativeId", "String");
			xamlMember.Getter = get_115_StorageFile_FolderRelativeId;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.Properties":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "Properties", "Windows.Storage.FileProperties.StorageItemContentProperties");
			xamlMember.Getter = get_116_StorageFile_Properties;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.FileFromPathAsync":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "FileFromPathAsync", "Windows.Foundation.IAsyncOperation<Windows.Storage.StorageFile>");
			xamlMember.SetTargetTypeName("String");
			xamlMember.SetIsAttachable();
			xamlMember.Getter = get_117_StorageFile_FileFromPathAsync;
			xamlMember.SetIsReadOnly();
			break;
		case "Windows.Storage.StorageFile.FileFromApplicationUriAsync":
			_ = (XamlUserType)(object)GetXamlTypeByName("Windows.Storage.StorageFile");
			xamlMember = new XamlMember(this, "FileFromApplicationUriAsync", "Windows.Foundation.IAsyncOperation<Windows.Storage.StorageFile>");
			xamlMember.SetTargetTypeName("System.Uri");
			xamlMember.SetIsAttachable();
			xamlMember.Getter = get_118_StorageFile_FileFromApplicationUriAsync;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.AbsolutePath":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "AbsolutePath", "String");
			xamlMember.Getter = get_119_Uri_AbsolutePath;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.AbsoluteUri":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "AbsoluteUri", "String");
			xamlMember.Getter = get_120_Uri_AbsoluteUri;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.Authority":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "Authority", "String");
			xamlMember.Getter = get_121_Uri_Authority;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.DnsSafeHost":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "DnsSafeHost", "String");
			xamlMember.Getter = get_122_Uri_DnsSafeHost;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.Fragment":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "Fragment", "String");
			xamlMember.Getter = get_123_Uri_Fragment;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.Host":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "Host", "String");
			xamlMember.Getter = get_124_Uri_Host;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.HostNameType":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "HostNameType", "System.UriHostNameType");
			xamlMember.Getter = get_125_Uri_HostNameType;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.IsAbsoluteUri":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "IsAbsoluteUri", "Boolean");
			xamlMember.Getter = get_126_Uri_IsAbsoluteUri;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.IsDefaultPort":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "IsDefaultPort", "Boolean");
			xamlMember.Getter = get_127_Uri_IsDefaultPort;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.IsFile":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "IsFile", "Boolean");
			xamlMember.Getter = get_128_Uri_IsFile;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.IsLoopback":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "IsLoopback", "Boolean");
			xamlMember.Getter = get_129_Uri_IsLoopback;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.IsUnc":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "IsUnc", "Boolean");
			xamlMember.Getter = get_130_Uri_IsUnc;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.LocalPath":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "LocalPath", "String");
			xamlMember.Getter = get_131_Uri_LocalPath;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.OriginalString":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "OriginalString", "String");
			xamlMember.Getter = get_132_Uri_OriginalString;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.PathAndQuery":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "PathAndQuery", "String");
			xamlMember.Getter = get_133_Uri_PathAndQuery;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.Port":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "Port", "Int32");
			xamlMember.Getter = get_134_Uri_Port;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.Query":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "Query", "String");
			xamlMember.Getter = get_135_Uri_Query;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.Scheme":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "Scheme", "String");
			xamlMember.Getter = get_136_Uri_Scheme;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.Segments":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "Segments", "String[]");
			xamlMember.Getter = get_137_Uri_Segments;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.UserEscaped":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "UserEscaped", "Boolean");
			xamlMember.Getter = get_138_Uri_UserEscaped;
			xamlMember.SetIsReadOnly();
			break;
		case "System.Uri.UserInfo":
			_ = (XamlUserType)(object)GetXamlTypeByName("System.Uri");
			xamlMember = new XamlMember(this, "UserInfo", "String");
			xamlMember.Getter = get_139_Uri_UserInfo;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Models.Anicon.ImageList":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "ImageList", "System.Collections.Generic.List<Windows.UI.Xaml.Media.Imaging.BitmapImage>");
			xamlMember.Getter = get_140_Anicon_ImageList;
			xamlMember.Setter = set_140_Anicon_ImageList;
			break;
		case "ChatOn.Models.Anicon.DelegateImageName":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.Anicon");
			xamlMember = new XamlMember(this, "DelegateImageName", "String");
			xamlMember.Getter = get_141_Anicon_DelegateImageName;
			xamlMember.Setter = set_141_Anicon_DelegateImageName;
			break;
		case "ChatOn.Models.OfflineAniconPackage.IsDelegateImagesLoaded":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "IsDelegateImagesLoaded", "Boolean");
			xamlMember.Getter = get_142_OfflineAniconPackage_IsDelegateImagesLoaded;
			xamlMember.Setter = set_142_OfflineAniconPackage_IsDelegateImagesLoaded;
			break;
		case "ChatOn.Models.OfflineAniconPackage.Count":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "Count", "Int32");
			xamlMember.Getter = get_143_OfflineAniconPackage_Count;
			xamlMember.Setter = set_143_OfflineAniconPackage_Count;
			break;
		case "ChatOn.Models.OfflineAniconPackage.EndDate":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "EndDate", "Int64");
			xamlMember.Getter = get_144_OfflineAniconPackage_EndDate;
			xamlMember.Setter = set_144_OfflineAniconPackage_EndDate;
			break;
		case "ChatOn.Models.OfflineAniconPackage.ErrorText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "ErrorText", "String");
			xamlMember.Getter = get_145_OfflineAniconPackage_ErrorText;
			xamlMember.Setter = set_145_OfflineAniconPackage_ErrorText;
			break;
		case "ChatOn.Models.OfflineAniconPackage.ThumbImageUri":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "ThumbImageUri", "String");
			xamlMember.Getter = get_146_OfflineAniconPackage_ThumbImageUri;
			xamlMember.Setter = set_146_OfflineAniconPackage_ThumbImageUri;
			break;
		case "ChatOn.Models.OfflineAniconPackage.ThumbImageFile":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "ThumbImageFile", "Windows.Storage.StorageFile");
			xamlMember.Getter = get_147_OfflineAniconPackage_ThumbImageFile;
			xamlMember.Setter = set_147_OfflineAniconPackage_ThumbImageFile;
			break;
		case "ChatOn.Models.OfflineAniconPackage.isCancel":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "isCancel", "Boolean");
			xamlMember.Getter = get_148_OfflineAniconPackage_isCancel;
			xamlMember.Setter = set_148_OfflineAniconPackage_isCancel;
			break;
		case "ChatOn.Models.OfflineAniconPackage.PackageID":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "PackageID", "String");
			xamlMember.Getter = get_149_OfflineAniconPackage_PackageID;
			xamlMember.Setter = set_149_OfflineAniconPackage_PackageID;
			break;
		case "ChatOn.Models.OfflineAniconPackage.XmlString":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Models.OfflineAniconPackage");
			xamlMember = new XamlMember(this, "XmlString", "String");
			xamlMember.Getter = get_150_OfflineAniconPackage_XmlString;
			xamlMember.Setter = set_150_OfflineAniconPackage_XmlString;
			break;
		case "ChatOn.Controls.EmoticonChooser.Packages":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.EmoticonChooser");
			xamlMember = new XamlMember(this, "Packages", "System.Collections.ObjectModel.ObservableCollection<ChatOn.Models.OfflineAniconPackage>");
			xamlMember.Getter = get_151_EmoticonChooser_Packages;
			xamlMember.Setter = set_151_EmoticonChooser_Packages;
			break;
		case "ChatON_WoA.Views.ChatListPage.IsOpened":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatListPage");
			xamlMember = new XamlMember(this, "IsOpened", "Boolean");
			xamlMember.Getter = get_152_ChatListPage_IsOpened;
			xamlMember.Setter = set_152_ChatListPage_IsOpened;
			break;
		case "ChatON_WoA.Views.ChatListPage.IsChatDetailOpened":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatListPage");
			xamlMember = new XamlMember(this, "IsChatDetailOpened", "Boolean");
			xamlMember.Getter = get_153_ChatListPage_IsChatDetailOpened;
			xamlMember.Setter = set_153_ChatListPage_IsChatDetailOpened;
			break;
		case "ChatON_WoA.Views.ChatListPage.IsInChatMode":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatListPage");
			xamlMember = new XamlMember(this, "IsInChatMode", "Boolean");
			xamlMember.Getter = get_154_ChatListPage_IsInChatMode;
			xamlMember.Setter = set_154_ChatListPage_IsInChatMode;
			break;
		case "ChatON_WoA.Views.ChatProfilePage.ViewModel":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ChatProfilePage");
			xamlMember = new XamlMember(this, "ViewModel", "ChatOn.ViewModels.ChatProfilePageViewModel");
			xamlMember.Getter = get_155_ChatProfilePage_ViewModel;
			xamlMember.Setter = set_155_ChatProfilePage_ViewModel;
			break;
		case "ChatON_WoA.Controls.DelayedLoadControl.Delay":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Controls.DelayedLoadControl");
			xamlMember = new XamlMember(this, "Delay", "TimeSpan");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_156_DelayedLoadControl_Delay;
			xamlMember.Setter = set_156_DelayedLoadControl_Delay;
			break;
		case "ChatON_WoA.Controls.DelayedLoadControl.ContentTemplate":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Controls.DelayedLoadControl");
			xamlMember = new XamlMember(this, "ContentTemplate", "Windows.UI.Xaml.DataTemplate");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_157_DelayedLoadControl_ContentTemplate;
			xamlMember.Setter = set_157_DelayedLoadControl_ContentTemplate;
			break;
		case "ChatON_WoA.ViewModels.RingSlice.InnerRadius":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.ViewModels.RingSlice");
			xamlMember = new XamlMember(this, "InnerRadius", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_158_RingSlice_InnerRadius;
			xamlMember.Setter = set_158_RingSlice_InnerRadius;
			break;
		case "ChatON_WoA.ViewModels.RingSlice.Radius":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.ViewModels.RingSlice");
			xamlMember = new XamlMember(this, "Radius", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_159_RingSlice_Radius;
			xamlMember.Setter = set_159_RingSlice_Radius;
			break;
		case "ChatON_WoA.ViewModels.RingSlice.StartAngle":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.ViewModels.RingSlice");
			xamlMember = new XamlMember(this, "StartAngle", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_160_RingSlice_StartAngle;
			xamlMember.Setter = set_160_RingSlice_StartAngle;
			break;
		case "ChatON_WoA.ViewModels.RingSlice.EndAngle":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.ViewModels.RingSlice");
			xamlMember = new XamlMember(this, "EndAngle", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_161_RingSlice_EndAngle;
			xamlMember.Setter = set_161_RingSlice_EndAngle;
			break;
		case "ChatON_WoA.ViewModels.RingSlice.Center":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.ViewModels.RingSlice");
			xamlMember = new XamlMember(this, "Center", "System.Nullable<Windows.Foundation.Point>");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_162_RingSlice_Center;
			xamlMember.Setter = set_162_RingSlice_Center;
			break;
		case "ChatON_WoA.Controls.CountdownControl.Seconds":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Controls.CountdownControl");
			xamlMember = new XamlMember(this, "Seconds", "Int32");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_163_CountdownControl_Seconds;
			xamlMember.Setter = set_163_CountdownControl_Seconds;
			break;
		case "ChatOn.Controls.ImageDelayControl.ProfileImageSource":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageDelayControl");
			xamlMember = new XamlMember(this, "ProfileImageSource", "Windows.UI.Xaml.Media.Imaging.BitmapImage");
			xamlMember.Getter = get_164_ImageDelayControl_ProfileImageSource;
			xamlMember.Setter = set_164_ImageDelayControl_ProfileImageSource;
			break;
		case "ChatOn.Controls.ImageDelayControl.IsDownloading":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageDelayControl");
			xamlMember = new XamlMember(this, "IsDownloading", "Boolean");
			xamlMember.Getter = get_165_ImageDelayControl_IsDownloading;
			xamlMember.Setter = set_165_ImageDelayControl_IsDownloading;
			break;
		case "ChatOn.Controls.ImageDelayControl.StretchMode":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageDelayControl");
			xamlMember = new XamlMember(this, "StretchMode", "Int32");
			xamlMember.Getter = get_166_ImageDelayControl_StretchMode;
			xamlMember.Setter = set_166_ImageDelayControl_StretchMode;
			break;
		case "ChatOn.Controls.PopupControl.TitleText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PopupControl");
			xamlMember = new XamlMember(this, "TitleText", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_167_PopupControl_TitleText;
			xamlMember.Setter = set_167_PopupControl_TitleText;
			break;
		case "ChatOn.Controls.PopupControl.DetailText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PopupControl");
			xamlMember = new XamlMember(this, "DetailText", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_168_PopupControl_DetailText;
			xamlMember.Setter = set_168_PopupControl_DetailText;
			break;
		case "ChatOn.Controls.PopupControl.ShowCancel":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PopupControl");
			xamlMember = new XamlMember(this, "ShowCancel", "Boolean");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_169_PopupControl_ShowCancel;
			xamlMember.Setter = set_169_PopupControl_ShowCancel;
			break;
		case "ChatOn.Controls.PopupControl.OKButtonText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PopupControl");
			xamlMember = new XamlMember(this, "OKButtonText", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_170_PopupControl_OKButtonText;
			xamlMember.Setter = set_170_PopupControl_OKButtonText;
			break;
		case "ChatOn.Controls.PopupControl.CancelButtonText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PopupControl");
			xamlMember = new XamlMember(this, "CancelButtonText", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_171_PopupControl_CancelButtonText;
			xamlMember.Setter = set_171_PopupControl_CancelButtonText;
			break;
		case "ChatOn.Controls.PopupControl.OKButtonBackground":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PopupControl");
			xamlMember = new XamlMember(this, "OKButtonBackground", "Windows.UI.Xaml.Media.SolidColorBrush");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_172_PopupControl_OKButtonBackground;
			xamlMember.Setter = set_172_PopupControl_OKButtonBackground;
			break;
		case "ChatOn.Controls.PopupControl.CancelButtonBackground":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PopupControl");
			xamlMember = new XamlMember(this, "CancelButtonBackground", "Windows.UI.Xaml.Media.SolidColorBrush");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_173_PopupControl_CancelButtonBackground;
			xamlMember.Setter = set_173_PopupControl_CancelButtonBackground;
			break;
		case "ChatOn.Controls.PopupControl.OKButtonForeground":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PopupControl");
			xamlMember = new XamlMember(this, "OKButtonForeground", "Windows.UI.Xaml.Media.SolidColorBrush");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_174_PopupControl_OKButtonForeground;
			xamlMember.Setter = set_174_PopupControl_OKButtonForeground;
			break;
		case "ChatOn.Controls.PopupControl.CancelButtonForeground":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PopupControl");
			xamlMember = new XamlMember(this, "CancelButtonForeground", "Windows.UI.Xaml.Media.SolidColorBrush");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_175_PopupControl_CancelButtonForeground;
			xamlMember.Setter = set_175_PopupControl_CancelButtonForeground;
			break;
		case "ChatOn.Controls.SampleChatBubble.Text":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.SampleChatBubble");
			xamlMember = new XamlMember(this, "Text", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_176_SampleChatBubble_Text;
			xamlMember.Setter = set_176_SampleChatBubble_Text;
			break;
		case "ChatOn.Controls.SampleChatBubble.SubText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.SampleChatBubble");
			xamlMember = new XamlMember(this, "SubText", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_177_SampleChatBubble_SubText;
			xamlMember.Setter = set_177_SampleChatBubble_SubText;
			break;
		case "ChatOn.Controls.SampleChatBubble.MediaText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.SampleChatBubble");
			xamlMember = new XamlMember(this, "MediaText", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_178_SampleChatBubble_MediaText;
			xamlMember.Setter = set_178_SampleChatBubble_MediaText;
			break;
		case "ChatOn.Controls.SampleChatBubble.SubParam":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.SampleChatBubble");
			xamlMember = new XamlMember(this, "SubParam", "Int32");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_179_SampleChatBubble_SubParam;
			xamlMember.Setter = set_179_SampleChatBubble_SubParam;
			break;
		case "ChatOn.Controls.SampleChatBubble.MaxBubbleWidth":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.SampleChatBubble");
			xamlMember = new XamlMember(this, "MaxBubbleWidth", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_180_SampleChatBubble_MaxBubbleWidth;
			xamlMember.Setter = set_180_SampleChatBubble_MaxBubbleWidth;
			break;
		case "ChatOn.Controls.SampleChatBubble.Type":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.SampleChatBubble");
			xamlMember = new XamlMember(this, "Type", "Int32");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_181_SampleChatBubble_Type;
			xamlMember.Setter = set_181_SampleChatBubble_Type;
			break;
		case "ChatOn.Controls.SampleChatBubble.Message":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.SampleChatBubble");
			xamlMember = new XamlMember(this, "Message", "ChatOn.Models.Message");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_182_SampleChatBubble_Message;
			xamlMember.Setter = set_182_SampleChatBubble_Message;
			break;
		case "ChatOn.Controls.SampleChatBubble.FixedFontSize":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.SampleChatBubble");
			xamlMember = new XamlMember(this, "FixedFontSize", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_183_SampleChatBubble_FixedFontSize;
			xamlMember.Setter = set_183_SampleChatBubble_FixedFontSize;
			break;
		case "ChatOn.Controls.UnknownBuddyProfileDialog.BuddyInfo":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.UnknownBuddyProfileDialog");
			xamlMember = new XamlMember(this, "BuddyInfo", "ChatOn.Models.UnknownUser");
			xamlMember.Getter = get_184_UnknownBuddyProfileDialog_BuddyInfo;
			xamlMember.Setter = set_184_UnknownBuddyProfileDialog_BuddyInfo;
			break;
		case "ChatOn.Controls.UnknownBuddyProfileDialog.ParentPage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.UnknownBuddyProfileDialog");
			xamlMember = new XamlMember(this, "ParentPage", "Windows.UI.Xaml.Controls.Page");
			xamlMember.Getter = get_185_UnknownBuddyProfileDialog_ParentPage;
			xamlMember.Setter = set_185_UnknownBuddyProfileDialog_ParentPage;
			break;
		case "ChatON_WoA.Views.TrunkDetailPage.LockToBottom":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.TrunkDetailPage");
			xamlMember = new XamlMember(this, "LockToBottom", "Boolean");
			xamlMember.Getter = get_186_TrunkDetailPage_LockToBottom;
			xamlMember.Setter = set_186_TrunkDetailPage_LockToBottom;
			break;
		case "ChatON_WoA.Views.ContactDetailPage.ContactInfos":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ContactDetailPage");
			xamlMember = new XamlMember(this, "ContactInfos", "System.Collections.ObjectModel.ObservableCollection<ChatON_WoA.Views.ContactDetailPage.ContactInfo>");
			xamlMember.Getter = get_187_ContactDetailPage_ContactInfos;
			xamlMember.Setter = set_187_ContactDetailPage_ContactInfos;
			break;
		case "ChatON_WoA.Views.ContactDetailPage.ContactInfo.Type":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ContactDetailPage.ContactInfo");
			xamlMember = new XamlMember(this, "Type", "String");
			xamlMember.Getter = get_188_ContactInfo_Type;
			xamlMember.Setter = set_188_ContactInfo_Type;
			break;
		case "ChatON_WoA.Views.ContactDetailPage.ContactInfo.Value":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.ContactDetailPage.ContactInfo");
			xamlMember = new XamlMember(this, "Value", "String");
			xamlMember.Getter = get_189_ContactInfo_Value;
			xamlMember.Setter = set_189_ContactInfo_Value;
			break;
		case "ChatOn.Controls.CustomPopup.Page":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.CustomPopup");
			xamlMember = new XamlMember(this, "Page", "Windows.UI.Xaml.Controls.Page");
			xamlMember.Getter = get_190_CustomPopup_Page;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Controls.CustomPopup.Child":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.CustomPopup");
			xamlMember = new XamlMember(this, "Child", "Windows.UI.Xaml.FrameworkElement");
			xamlMember.Getter = get_191_CustomPopup_Child;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatON_WoA.Views.DownloadSettingPage.ViewModel":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.DownloadSettingPage");
			xamlMember = new XamlMember(this, "ViewModel", "ChatOn.ViewModels.DownloadSettingPageViewModel");
			xamlMember.Getter = get_192_DownloadSettingPage_ViewModel;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatON_WoA.Views.DownloadSettingPage.IsLoaded":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.DownloadSettingPage");
			xamlMember = new XamlMember(this, "IsLoaded", "Boolean");
			xamlMember.Getter = get_193_DownloadSettingPage_IsLoaded;
			xamlMember.Setter = set_193_DownloadSettingPage_IsLoaded;
			break;
		case "ChatON_WoA.Views.EditProfilePage.IsToggleShowPhonenumberOn":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.EditProfilePage");
			xamlMember = new XamlMember(this, "IsToggleShowPhonenumberOn", "Boolean");
			xamlMember.Getter = get_194_EditProfilePage_IsToggleShowPhonenumberOn;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatON_WoA.Views.EditProfilePage.IsToggleShowBirthdayOn":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.EditProfilePage");
			xamlMember = new XamlMember(this, "IsToggleShowBirthdayOn", "Boolean");
			xamlMember.Getter = get_195_EditProfilePage_IsToggleShowBirthdayOn;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatON_WoA.Views.EditProfilePage.IsToggleShowYear":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.EditProfilePage");
			xamlMember = new XamlMember(this, "IsToggleShowYear", "Boolean");
			xamlMember.Getter = get_196_EditProfilePage_IsToggleShowYear;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Controls.GroupProfileDialog.GroupInfo":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.GroupProfileDialog");
			xamlMember = new XamlMember(this, "GroupInfo", "ChatOn.Models.BuddyGroup");
			xamlMember.Getter = get_197_GroupProfileDialog_GroupInfo;
			xamlMember.Setter = set_197_GroupProfileDialog_GroupInfo;
			break;
		case "ChatOn.Controls.GroupProfileDialog.DisplayContainer":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.GroupProfileDialog");
			xamlMember = new XamlMember(this, "DisplayContainer", "Windows.UI.Xaml.Controls.Grid");
			xamlMember.Getter = get_198_GroupProfileDialog_DisplayContainer;
			xamlMember.Setter = set_198_GroupProfileDialog_DisplayContainer;
			break;
		case "ChatOn.Controls.GroupProfileDialog.ViewModel":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.GroupProfileDialog");
			xamlMember = new XamlMember(this, "ViewModel", "ChatOn.ViewModels.GroupProfilePageViewModel");
			xamlMember.Getter = get_199_GroupProfileDialog_ViewModel;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Controls.GroupProfileDialog.IsRenameMode":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.GroupProfileDialog");
			xamlMember = new XamlMember(this, "IsRenameMode", "Boolean");
			xamlMember.Getter = get_200_GroupProfileDialog_IsRenameMode;
			xamlMember.Setter = set_200_GroupProfileDialog_IsRenameMode;
			break;
		case "ChatON_WoA.Views.HiddenInteractionPage.ViewModel":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.HiddenInteractionPage");
			xamlMember = new XamlMember(this, "ViewModel", "ChatOn.ViewModels.HiddenInteractionPageViewModel");
			xamlMember.Getter = get_201_HiddenInteractionPage_ViewModel;
			xamlMember.SetIsReadOnly();
			break;
		case "ChatOn.Controls.HilightedTextBlock.Text":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.HilightedTextBlock");
			xamlMember = new XamlMember(this, "Text", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_202_HilightedTextBlock_Text;
			xamlMember.Setter = set_202_HilightedTextBlock_Text;
			break;
		case "ChatOn.Controls.HilightedTextBlock.Keyword":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.HilightedTextBlock");
			xamlMember = new XamlMember(this, "Keyword", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_203_HilightedTextBlock_Keyword;
			xamlMember.Setter = set_203_HilightedTextBlock_Keyword;
			break;
		case "ChatOn.Controls.HilightedTextBlock.MaxLength":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.HilightedTextBlock");
			xamlMember = new XamlMember(this, "MaxLength", "Int32");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_204_HilightedTextBlock_MaxLength;
			xamlMember.Setter = set_204_HilightedTextBlock_MaxLength;
			break;
		case "ChatOn.Controls.ImageButtonBase.NormalImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButtonBase");
			xamlMember = new XamlMember(this, "NormalImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_205_ImageButtonBase_NormalImage;
			xamlMember.Setter = set_205_ImageButtonBase_NormalImage;
			break;
		case "ChatOn.Controls.ImageButtonBase.PressedImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButtonBase");
			xamlMember = new XamlMember(this, "PressedImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_206_ImageButtonBase_PressedImage;
			xamlMember.Setter = set_206_ImageButtonBase_PressedImage;
			break;
		case "ChatOn.Controls.ImageButtonBase.DisabledImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButtonBase");
			xamlMember = new XamlMember(this, "DisabledImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_207_ImageButtonBase_DisabledImage;
			xamlMember.Setter = set_207_ImageButtonBase_DisabledImage;
			break;
		case "ChatOn.Controls.ImageButtonBase.Text":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.ImageButtonBase");
			xamlMember = new XamlMember(this, "Text", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_208_ImageButtonBase_Text;
			xamlMember.Setter = set_208_ImageButtonBase_Text;
			break;
		case "ChatOn.Controls.RatioChart.LeftImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.RatioChart");
			xamlMember = new XamlMember(this, "LeftImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_209_RatioChart_LeftImage;
			xamlMember.Setter = set_209_RatioChart_LeftImage;
			break;
		case "ChatOn.Controls.RatioChart.RightImage":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.RatioChart");
			xamlMember = new XamlMember(this, "RightImage", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_210_RatioChart_RightImage;
			xamlMember.Setter = set_210_RatioChart_RightImage;
			break;
		case "ChatOn.Controls.RatioChart.LeftText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.RatioChart");
			xamlMember = new XamlMember(this, "LeftText", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_211_RatioChart_LeftText;
			xamlMember.Setter = set_211_RatioChart_LeftText;
			break;
		case "ChatOn.Controls.RatioChart.RightText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.RatioChart");
			xamlMember = new XamlMember(this, "RightText", "String");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_212_RatioChart_RightText;
			xamlMember.Setter = set_212_RatioChart_RightText;
			break;
		case "ChatOn.Controls.RatioChart.LeftValue":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.RatioChart");
			xamlMember = new XamlMember(this, "LeftValue", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_213_RatioChart_LeftValue;
			xamlMember.Setter = set_213_RatioChart_LeftValue;
			break;
		case "ChatOn.Controls.RatioChart.RightValue":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.RatioChart");
			xamlMember = new XamlMember(this, "RightValue", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_214_RatioChart_RightValue;
			xamlMember.Setter = set_214_RatioChart_RightValue;
			break;
		case "ChatOn.Controls.RatioChart.StandardValue":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.RatioChart");
			xamlMember = new XamlMember(this, "StandardValue", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_215_RatioChart_StandardValue;
			xamlMember.Setter = set_215_RatioChart_StandardValue;
			break;
		case "ChatOn.Controls.RatioChart.LeftFontColor":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.RatioChart");
			xamlMember = new XamlMember(this, "LeftFontColor", "Windows.UI.Xaml.Media.Brush");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_216_RatioChart_LeftFontColor;
			xamlMember.Setter = set_216_RatioChart_LeftFontColor;
			break;
		case "ChatOn.Controls.RatioChart.RightFontColor":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.RatioChart");
			xamlMember = new XamlMember(this, "RightFontColor", "Windows.UI.Xaml.Media.Brush");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_217_RatioChart_RightFontColor;
			xamlMember.Setter = set_217_RatioChart_RightFontColor;
			break;
		case "ChatOn.Controls.PhotoFrame.MaxBubbleWidth":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PhotoFrame");
			xamlMember = new XamlMember(this, "MaxBubbleWidth", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_218_PhotoFrame_MaxBubbleWidth;
			xamlMember.Setter = set_218_PhotoFrame_MaxBubbleWidth;
			break;
		case "ChatOn.Controls.PhotoFrame.Photo":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PhotoFrame");
			xamlMember = new XamlMember(this, "Photo", "Windows.UI.Xaml.Media.ImageSource");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_219_PhotoFrame_Photo;
			xamlMember.Setter = set_219_PhotoFrame_Photo;
			break;
		case "ChatOn.Controls.PhotoFrame.IconVisibility":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PhotoFrame");
			xamlMember = new XamlMember(this, "IconVisibility", "Boolean");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_220_PhotoFrame_IconVisibility;
			xamlMember.Setter = set_220_PhotoFrame_IconVisibility;
			break;
		case "ChatOn.Controls.PhotoFrame.Stretch":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PhotoFrame");
			xamlMember = new XamlMember(this, "Stretch", "Windows.UI.Xaml.Media.Stretch");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_221_PhotoFrame_Stretch;
			xamlMember.Setter = set_221_PhotoFrame_Stretch;
			break;
		case "ChatON_WoA.Views.PivotPage.ViewModel":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatON_WoA.Views.PivotPage");
			xamlMember = new XamlMember(this, "ViewModel", "ChatOn.ViewModels.PivotPageViewModel");
			xamlMember.Getter = get_222_PivotPage_ViewModel;
			xamlMember.Setter = set_222_PivotPage_ViewModel;
			break;
		case "ChatOn.Controls.PreviewAniconDialog.AniconID":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Controls.PreviewAniconDialog");
			xamlMember = new XamlMember(this, "AniconID", "String");
			xamlMember.Getter = get_223_PreviewAniconDialog_AniconID;
			xamlMember.Setter = set_223_PreviewAniconDialog_AniconID;
			break;
		case "ChatOn.Infrastructure.BindingService.FullText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Infrastructure.BindingService");
			xamlMember = new XamlMember(this, "FullText", "String");
			xamlMember.SetTargetTypeName("Windows.UI.Xaml.Controls.TextBlock");
			xamlMember.SetIsAttachable();
			xamlMember.Getter = get_224_BindingService_FullText;
			xamlMember.Setter = set_224_BindingService_FullText;
			break;
		case "ChatOn.Infrastructure.BindingService.HighlightedText":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Infrastructure.BindingService");
			xamlMember = new XamlMember(this, "HighlightedText", "String");
			xamlMember.SetTargetTypeName("Windows.UI.Xaml.Controls.TextBlock");
			xamlMember.SetIsAttachable();
			xamlMember.Getter = get_225_BindingService_HighlightedText;
			xamlMember.Setter = set_225_BindingService_HighlightedText;
			break;
		case "ChatOn.Infrastructure.BindingService.HighlightBrush":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Infrastructure.BindingService");
			xamlMember = new XamlMember(this, "HighlightBrush", "Windows.UI.Xaml.Media.Brush");
			xamlMember.SetTargetTypeName("Windows.UI.Xaml.Controls.TextBlock");
			xamlMember.SetIsAttachable();
			xamlMember.Getter = get_226_BindingService_HighlightBrush;
			xamlMember.Setter = set_226_BindingService_HighlightBrush;
			break;
		case "ChatOn.Infrastructure.WrapPanel.Orientation":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Infrastructure.WrapPanel");
			xamlMember = new XamlMember(this, "Orientation", "Windows.UI.Xaml.Controls.Orientation");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_227_WrapPanel_Orientation;
			xamlMember.Setter = set_227_WrapPanel_Orientation;
			break;
		case "ChatOn.Infrastructure.WrapPanel.ItemHeight":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Infrastructure.WrapPanel");
			xamlMember = new XamlMember(this, "ItemHeight", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_228_WrapPanel_ItemHeight;
			xamlMember.Setter = set_228_WrapPanel_ItemHeight;
			break;
		case "ChatOn.Infrastructure.WrapPanel.ItemWidth":
			_ = (XamlUserType)(object)GetXamlTypeByName("ChatOn.Infrastructure.WrapPanel");
			xamlMember = new XamlMember(this, "ItemWidth", "Double");
			xamlMember.SetIsDependencyProperty();
			xamlMember.Getter = get_229_WrapPanel_ItemWidth;
			xamlMember.Setter = set_229_WrapPanel_ItemWidth;
			break;
		}
		return (IXamlMember)(object)xamlMember;
	}
}
