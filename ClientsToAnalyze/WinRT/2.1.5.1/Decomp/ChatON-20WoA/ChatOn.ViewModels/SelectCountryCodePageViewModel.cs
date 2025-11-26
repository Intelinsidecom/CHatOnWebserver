using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Runtime.InteropServices.WindowsRuntime;
using ChatOn.Infrastructure;
using Windows.UI.Xaml;

namespace ChatOn.ViewModels;

public class SelectCountryCodePageViewModel : NotificationObject
{
	private DispatcherTimer _timer;

	private long _startTick;

	private string _keyword;

	private List<CountryCode> _tempList = new List<CountryCode>();

	private ObservableCollection<CountryCode> _searchResult = new ObservableCollection<CountryCode>();

	private ObservableCollection<string> _headerCountryCode = new ObservableCollection<string>();

	private bool _isEmtpyList = true;

	private static CountryCode[] _codeData = new CountryCode[223]
	{
		new CountryCode("Greece(GRC)", "+30", "202"),
		new CountryCode("Netherlands(NLD)", "+31", "204"),
		new CountryCode("Belgium(BEL)", "+32", "206"),
		new CountryCode("France(FRA)", "+33", "208"),
		new CountryCode("Monaco(MCO)", "+377", "212"),
		new CountryCode("Andorra(AND)", "+376", "213"),
		new CountryCode("Spain(ESP)", "+34", "214"),
		new CountryCode("Hungary(HUN)", "+36", "216"),
		new CountryCode("Bosnia and Herzegovina(BIH)", "+387", "218"),
		new CountryCode("Croatia(HRV)", "+385", "219"),
		new CountryCode("Serbia(SRB)", "+381", "220"),
		new CountryCode("Italy(ITA)", "+39", "222"),
		new CountryCode("Vatican City State(VAT)", "+379", "225"),
		new CountryCode("Romania(ROM)", "+40", "226"),
		new CountryCode("Switzerland(CHE)", "+41", "228"),
		new CountryCode("Czech Republic(CZE))", "+420", "230"),
		new CountryCode("Slovakia(SVK)", "+421", "231"),
		new CountryCode("Austria(AUT)", "+43", "232"),
		new CountryCode("United Kingdom(GBR)", "+44", "234"),
		new CountryCode("Denmark(DNK)", "+45", "238"),
		new CountryCode("Sweden(SWE)", "+46", "240"),
		new CountryCode("Norway(NOR)", "+47", "242"),
		new CountryCode("Finland(FIN)", "+358", "244"),
		new CountryCode("Lithuania(LTU)", "+370", "246"),
		new CountryCode("Latvia(LVA)", "+371", "247"),
		new CountryCode("Estonia(EST)", "+372", "248"),
		new CountryCode("Russian Federation(RUS)", "+7", "250"),
		new CountryCode("Ukraine(UKR)", "+380", "255"),
		new CountryCode("Belarus(BLR)", "+375", "257"),
		new CountryCode("Moldova(MDA)", "+373", "259"),
		new CountryCode("Poland(POL)", "+48", "260"),
		new CountryCode("Germany(DEU)", "+49", "262"),
		new CountryCode("Gibraltar(GIB)", "+350", "266"),
		new CountryCode("Portugal(PRT)", "+351", "268"),
		new CountryCode("Luxembourg(LUX)", "+352", "270"),
		new CountryCode("Ireland(IRL)", "+353", "272"),
		new CountryCode("Iceland(ISL)", "+354", "274"),
		new CountryCode("Albania(ALB)", "+355", "276"),
		new CountryCode("Malta(MLT)", "+356", "278"),
		new CountryCode("Cyprus(CYP)", "+357", "280"),
		new CountryCode("Georgia(GEO)", "+995", "282"),
		new CountryCode("Armenia(ARM)", "+374", "283"),
		new CountryCode("Bulgaria(BGR)", "+359", "284"),
		new CountryCode("Turkey(TUR)", "+90", "286"),
		new CountryCode("Faroe Islands(FRO)", "+298", "288"),
		new CountryCode("Greenland(GRL)", "+299", "290"),
		new CountryCode("San Marino(SMR)", "+378", "292"),
		new CountryCode("Slovenia(SVN)", "+386", "293"),
		new CountryCode("FYROM (MKD)", "+389", "294"),
		new CountryCode("Liechtenstein(LIE)", "+423", "295"),
		new CountryCode("Montenegro(MNE)", "+382", "297"),
		new CountryCode("Canada(CAN)", "+1", "302"),
		new CountryCode("Saint Pierre and Miquelon(SPM)", "+508", "308"),
		new CountryCode("United States of America(USA)", "+1", "310"),
		new CountryCode("Puerto Rico(PRI)", "+1", "330"),
		new CountryCode("United States Virgin Islands(VIR)", "+1", "332"),
		new CountryCode("Mexico(MEX)", "+52", "334"),
		new CountryCode("Jamaica(JAM)", "+1", "338"),
		new CountryCode("Guadeloupe (GLP)", "+590", "340"),
		new CountryCode("Martinique (MTQ)", "+596", "340"),
		new CountryCode("Barbados(BRB)", "+1", "342"),
		new CountryCode("Antigua and Barbuda(ATG)", "+1", "344"),
		new CountryCode("Cayman Islands(CYM)", "+1", "346"),
		new CountryCode("British Virgin Islands(VGB)", "+1", "348"),
		new CountryCode("Bermuda (BMU)", "+1", "350"),
		new CountryCode("Grenada(GRD)", "+1", "352"),
		new CountryCode("Botswana(BWA)", "+267", "352"),
		new CountryCode("Montserrat(MSR)", "+1", "354"),
		new CountryCode("Saint Kitts and Nevis(KNA)", "+1", "356"),
		new CountryCode("Saint Lucia(LCA)", "+1", "358"),
		new CountryCode("Saint Vincent and the Grenadines(VCT)", "+1", "360"),
		new CountryCode("Netherlands Antilles(ANT)", "+599", "362"),
		new CountryCode("Aruba(ABW)", "+297", "363"),
		new CountryCode("Bahamas(BHS)", "+1", "364"),
		new CountryCode("Anguilla(AIA)", "+1", "365"),
		new CountryCode("Dominica(DMA)", "+1", "366"),
		new CountryCode("Cuba(CUB)", "+53", "368"),
		new CountryCode("Dominican Republic(DOM)", "+1", "370"),
		new CountryCode("Haiti(HTI)", "+509", "372"),
		new CountryCode("Trinidad and Tobago(TTO)", "+1", "374"),
		new CountryCode("Turks and Caicos Islands(TCA)", "+1", "376"),
		new CountryCode("Azerbaijani Republic(AZE)", "+994", "400"),
		new CountryCode("Kazakhstan(KAZ)", "+7", "401"),
		new CountryCode("Bhutan(BTN)", "+975", "402"),
		new CountryCode("India(IND)", "+91", "404"),
		new CountryCode("Pakistan(PAK)", "+92", "410"),
		new CountryCode("Afghanistan(AFG)", "+93", "412"),
		new CountryCode("Sri Lanka(LKA)", "+94", "413"),
		new CountryCode("Myanmar(MMR)", "+95", "414"),
		new CountryCode("Lebanon(LBN)", "+961", "415"),
		new CountryCode("Jordan(JOR)", "+962", "416"),
		new CountryCode("Syria(SYR)", "+963", "417"),
		new CountryCode("Iraq(IRQ)", "+964", "418"),
		new CountryCode("Kuwait(KWT)", "+965", "419"),
		new CountryCode("Saudi Arabia(SAU)", "+966", "420"),
		new CountryCode("Yemen(YEM)", "+967", "421"),
		new CountryCode("Oman(OMN)", "+968", "422"),
		new CountryCode("Palestine(PSE)", "+970", "423"),
		new CountryCode("United Arab Emirates(UAE)", "+971", "424"),
		new CountryCode("Israel(ISR)", "+972", "425"),
		new CountryCode("Bahrain(BHR)", "+973", "426"),
		new CountryCode("Qatar(QAT)", "+974", "427"),
		new CountryCode("Mongolia(MNG)", "+976", "428"),
		new CountryCode("Nepal(NPL)", "+977", "429"),
		new CountryCode("Iran(IRN)", "+98", "432"),
		new CountryCode("Uzbekistan(UZB)", "+998", "434"),
		new CountryCode("Tajikistan(TJK)", "+992", "436"),
		new CountryCode("Kyrgyz Republic(KGZ)", "+996", "437"),
		new CountryCode("Turkmenistan (TKM)", "+993", "438"),
		new CountryCode("Japan(JPN)", "+81", "440"),
		new CountryCode("Korea, Republic of (KOR)", "+82", "450"),
		new CountryCode("Viet Nam(VNM)", "+84", "452"),
		new CountryCode("Hong Kong(HKG)", "+852", "454"),
		new CountryCode("Macau(MAC)", "+853", "455"),
		new CountryCode("Cambodia(KHM)", "+855", "456"),
		new CountryCode("Laos(LAO)", "+856", "457"),
		new CountryCode("China(CHN)", "+86", "460"),
		new CountryCode("Taiwan(TWN)", "+886", "466"),
		new CountryCode("Bangladesh(BGD)", "+880", "470"),
		new CountryCode("Maldives(MDV)", "+960", "472"),
		new CountryCode("Malaysia(MYS)", "+60", "502"),
		new CountryCode("Australia(AUS)", "+61", "505"),
		new CountryCode("Indonesia(IDN)", "+62", "510"),
		new CountryCode("East Timor(TLS)", "+670", "514"),
		new CountryCode("Philippines(PHL)", "+63", "515"),
		new CountryCode("Thailand(THA)", "+66", "520"),
		new CountryCode("Singapore(SGP)", "+65", "525"),
		new CountryCode("Brunei Darussalam(BRN)", "+673", "528"),
		new CountryCode("New Zealand(NZL)", "+64", "530"),
		new CountryCode("Northern Mariana Islands (MNP)", "+1", "534"),
		new CountryCode("Guam(GUM)", "+1", "535"),
		new CountryCode("Nauru(NRU)", "+674", "536"),
		new CountryCode("Papua New Guinea(PNG)", "+675", "537"),
		new CountryCode("Tonga(TON)", "+676", "539"),
		new CountryCode("Solomon Islands(SLB)", "+677", "540"),
		new CountryCode("Vanuatu(VUT)", "+678", "541"),
		new CountryCode("Fiji(FJI)", "+679", "542"),
		new CountryCode("Wallis and Futuna(WLF)", "+681", "543"),
		new CountryCode("American Samoa (ASM)", "+1", "544"),
		new CountryCode("Kiribati(KIR)", "+686", "545"),
		new CountryCode("New Caledonia (NCL)", "+687", "546"),
		new CountryCode("French Polynesia(PYF)", "+689", "547"),
		new CountryCode("Cook Island(COK)", "+682", "548"),
		new CountryCode("Samoa(WSM)", "+685", "549"),
		new CountryCode("Federated States of Micronesia(FSM)", "+691", "550"),
		new CountryCode("Marshall Islands(MHL)", "+692", "551"),
		new CountryCode("Palau(PLW)", "+680", "552"),
		new CountryCode("Egypt(EGY)", "+20", "602"),
		new CountryCode("Algeria(DZA)", "+213", "603"),
		new CountryCode("Morocco(MAR)", "+212", "604"),
		new CountryCode("Tunisia(TUN)", "+216", "605"),
		new CountryCode("Libya(LBY)", "+218", "606"),
		new CountryCode("Gambia(GMB)", "+220", "607"),
		new CountryCode("Senegal(SEN)", "+221", "608"),
		new CountryCode("Mauritania(MRT)", "+222", "609"),
		new CountryCode("Mali(MLI)", "+223", "610"),
		new CountryCode("Guinea(GIN)", "+224", "611"),
		new CountryCode("Côte d'Ivoire(CIV)", "+225", "612"),
		new CountryCode("Burkina Faso(BFA)", "+226", "613"),
		new CountryCode("Niger(NER)", "+227", "614"),
		new CountryCode("Togolese Republic(TGO)", "+228", "615"),
		new CountryCode("Benin(BEN)", "+229", "616"),
		new CountryCode("Mauritius(MUS)", "+230", "617"),
		new CountryCode("Liberia(LBR)", "+231", "618"),
		new CountryCode("Sierra Leone(SLE)", "+232", "619"),
		new CountryCode("Ghana(GHA)", "+233", "620"),
		new CountryCode("Nigeria(NGA)", "+234", "621"),
		new CountryCode("Chad(TCD)", "+235", "622"),
		new CountryCode("Central African Republic(CAF)", "+236", "623"),
		new CountryCode("Cameroon(CMR)", "+237", "624"),
		new CountryCode("Cape Verde(CPV)", "+238", "625"),
		new CountryCode("São Tomé and Príncipe(STP)", "+239", "626"),
		new CountryCode("Equatorial Guinea(GNQ)", "+240", "627"),
		new CountryCode("Gabonese Republic(GAB)", "+241", "628"),
		new CountryCode("Republic of the Congo(COG)", "+242", "629"),
		new CountryCode("Democratic Republic of the Congo(COD)", "+243", "630"),
		new CountryCode("Angola(AGO)", "+244", "631"),
		new CountryCode("Guinea-Bissau(GNB)", "+245", "632"),
		new CountryCode("Seychelles(SYC)", "+248", "633"),
		new CountryCode("Sudan(SDN)", "+249", "634"),
		new CountryCode("Rwandese Republic(RWA)", "+250", "635"),
		new CountryCode("Ethiopia(ETH)", "+251", "636"),
		new CountryCode("Somalia(SOM)", "+252", "637"),
		new CountryCode("Djibouti(DJI)", "+253", "638"),
		new CountryCode("Kenya(KEN)", "+254", "639"),
		new CountryCode("Tanzania(TZA)", "+255", "640"),
		new CountryCode("Uganda(UGA)", "+256", "641"),
		new CountryCode("Burundi(BDI)", "+257", "642"),
		new CountryCode("Mozambique(MOZ)", "+258", "643"),
		new CountryCode("Zambia(ZMB)", "+260", "645"),
		new CountryCode("Madagascar(MDG)", "+261", "646"),
		new CountryCode("Réunion(REU)", "+262", "647"),
		new CountryCode("Zimbabwe(ZWE)", "+263", "648"),
		new CountryCode("Namibia(NAM)", "+264", "649"),
		new CountryCode("Malawi(MWI)", "+265", "650"),
		new CountryCode("Lesotho(LSO)", "+266", "651"),
		new CountryCode("Botswana(BWA)", "+267", "652"),
		new CountryCode("Swaziland(SWZ)", "+268", "653"),
		new CountryCode("Comoros(COM)", "+269", "654"),
		new CountryCode("South Africa(ZAF)", "+27", "655"),
		new CountryCode("Eritrea(ERI)", "+291", "657"),
		new CountryCode("Belize(BLZ)", "+501", "702"),
		new CountryCode("Guatemala(GTM)", "+502", "704"),
		new CountryCode("El Salvador(SLV)", "+503", "706"),
		new CountryCode("Honduras(HND)", "+504", "708"),
		new CountryCode("Nicaragua(NIC)", "+505", "710"),
		new CountryCode("Costa Rica(CRI)", "+506", "712"),
		new CountryCode("Panama(PAN)", "+507", "714"),
		new CountryCode("Peru(PER)", "+51", "716"),
		new CountryCode("Argentine Republic(ARG)", "+54", "722"),
		new CountryCode("Brazil(BRA)", "+55", "724"),
		new CountryCode("Chile(CHL)", "+56", "730"),
		new CountryCode("Colombia(COL)", "+57", "732"),
		new CountryCode("Venezuela(VEN)", "+58", "734"),
		new CountryCode("Bolivia(BOL)", "+591", "736"),
		new CountryCode("Guyana(GUY)", "+592", "738"),
		new CountryCode("Ecuador(ECU)", "+593", "740"),
		new CountryCode("French Guiana(GUF)", "+594", "742"),
		new CountryCode("Paraguay(PRY)", "+595", "744"),
		new CountryCode("Suriname(SUR)", "+597", "746"),
		new CountryCode("Uruguay(URY)", "+598", "748"),
		new CountryCode("Falkland Islands(FLK)", "+500", "750"),
		new CountryCode("South Sudan(SSD)", "+211", "659")
	};

	public bool IsEmtpyList
	{
		get
		{
			return _isEmtpyList;
		}
		set
		{
			_isEmtpyList = value;
			NotifyPropertyChanged(() => IsEmtpyList);
		}
	}

	public static CountryCode[] CodeData => _codeData;

	public ObservableCollection<CountryCode> SearchResult
	{
		get
		{
			return _searchResult;
		}
		set
		{
			_searchResult = value;
			NotifyPropertyChanged("");
		}
	}

	public ObservableCollection<string> HeaderCountryCode
	{
		get
		{
			return _headerCountryCode;
		}
		set
		{
			_headerCountryCode = value;
		}
	}

	public string Keyword
	{
		get
		{
			return _keyword;
		}
		set
		{
			if (value == string.Empty.Trim())
			{
				_keyword = value;
				MakeResultList(loadAll: true);
			}
			else if (value != _keyword)
			{
				_keyword = value;
				MakeResultList(loadAll: false);
			}
		}
	}

	public static CountryCode GetCountryCode(string number)
	{
		return CodeData.FirstOrDefault((CountryCode c) => c.Code == number);
	}

	public void GetHeaderCountry()
	{
		CountryCode[] codeData = CodeData;
		foreach (CountryCode countryCode in codeData)
		{
			if (!_headerCountryCode.Contains(countryCode.Name[0].ToString().ToUpper()))
			{
				_headerCountryCode.Add(countryCode.Name[0].ToString().ToUpper());
			}
		}
		_headerCountryCode = new ObservableCollection<string>(_headerCountryCode.OrderBy((string p) => p));
	}

	public static CountryCode GetCountryCodeByMCC(string mcc)
	{
		return CodeData.FirstOrDefault((CountryCode c) => c.MCC == mcc);
	}

	public unsafe SelectCountryCodePageViewModel()
	{
		//IL_0035: Unknown result type (might be due to invalid IL or missing references)
		//IL_003f: Expected O, but got Unknown
		GetHeaderCountry();
		_timer = new DispatcherTimer();
		DispatcherTimer timer = _timer;
		WindowsRuntimeMarshal.AddEventHandler(new Func<EventHandler<object>, EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.add_Tick)), new Action<EventRegistrationToken>(timer, (nint)__ldftn(DispatcherTimer.remove_Tick)), _timer_Tick);
		_timer.put_Interval(TimeSpan.FromMilliseconds(20.0));
		_keyword = "";
	}

	private void _timer_Tick(object sender, object e)
	{
		if (_tempList.Count > 0)
		{
			CountryCode item = _tempList.First();
			_searchResult.Add(item);
			_tempList.Remove(item);
		}
		else
		{
			long ticks = DateTime.UtcNow.Ticks;
			new TimeSpan(ticks - _startTick);
			_timer.Stop();
		}
	}

	public void SelectedHeaderList(string value)
	{
		IEnumerable<CountryCode> enumerable = _codeData.Select((CountryCode p) => p);
		_searchResult.Clear();
		foreach (CountryCode item in enumerable)
		{
			if (item.Name[0].ToString().ToUpper() == value)
			{
				_searchResult.Add(item);
			}
		}
	}

	public void MakeResultList(bool loadAll)
	{
		_startTick = DateTime.UtcNow.Ticks;
		_timer.Stop();
		_searchResult.Clear();
		_tempList.Clear();
		if (_keyword.Length > 0)
		{
			IEnumerable<CountryCode> source = _codeData.Where((CountryCode d) => (!string.IsNullOrEmpty(d.Name) && d.Name.IndexOf(_keyword, StringComparison.CurrentCultureIgnoreCase) != -1) || (!string.IsNullOrEmpty(d.Code) && d.Code.IndexOf(_keyword, StringComparison.CurrentCultureIgnoreCase) != -1));
			IOrderedEnumerable<CountryCode> orderedEnumerable = source.OrderBy((CountryCode d) => d.Name);
			foreach (CountryCode item in orderedEnumerable)
			{
				item.Keyword = _keyword;
				if (loadAll)
				{
					_searchResult.Add(item);
				}
				else
				{
					_tempList.Add(item);
				}
			}
			IsEmtpyList = orderedEnumerable.Count() == 0;
			if (!loadAll)
			{
				_tempList = new List<CountryCode>(_tempList.OrderBy((CountryCode p) => p.Name));
				_timer.Start();
			}
			return;
		}
		IEnumerable<CountryCode> enumerable = _codeData.OrderBy((CountryCode d) => d.Name);
		foreach (CountryCode item2 in enumerable)
		{
			item2.Keyword = null;
			if (loadAll)
			{
				_searchResult.Add(item2);
			}
			else
			{
				_tempList.Add(item2);
			}
		}
		if (loadAll)
		{
			foreach (string item3 in _headerCountryCode)
			{
				_searchResult.Add(new CountryCode
				{
					Code = "",
					Keyword = "",
					MCC = "",
					Name = item3.ToUpper()
				});
			}
			SearchResult = new ObservableCollection<CountryCode>(SearchResult.OrderBy((CountryCode p) => p.Name));
		}
		IsEmtpyList = enumerable.Count() == 0;
		if (!loadAll)
		{
			_timer.Start();
		}
	}
}
