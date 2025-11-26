using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Windows.Threading;
using ChatOn.Infrastructure;
using ChatOn.Views;

namespace ChatOn.ViewModels;

public class SelectCountryCodePageViewModel : NotificationObject
{
	private SelectCountryCodePage _page;

	private DispatcherTimer _timer;

	private long _startTick;

	private string _keyword;

	private List<CountryCode> _tempList = new List<CountryCode>();

	private ObservableCollection<CountryCode> _searchResult = new ObservableCollection<CountryCode>();

	private bool _isCodeSelectionMode;

	private static CountryCode[] _countryData = new CountryCode[22]
	{
		new CountryCode
		{
			Name = "Chinese - China",
			MCC = "460"
		},
		new CountryCode
		{
			Name = "Chinese - Taiwan",
			MCC = "466"
		},
		new CountryCode
		{
			Name = "Czech - Czech Republic",
			MCC = "230"
		},
		new CountryCode
		{
			Name = "Danish - Denmark",
			MCC = "238"
		},
		new CountryCode
		{
			Name = "Dutch - Netherlands",
			MCC = "204"
		},
		new CountryCode
		{
			Name = "English - United Kingdom",
			MCC = "234"
		},
		new CountryCode
		{
			Name = "English - United States",
			MCC = "310"
		},
		new CountryCode
		{
			Name = "Finnish - Finland",
			MCC = "244"
		},
		new CountryCode
		{
			Name = "French - France",
			MCC = "208"
		},
		new CountryCode
		{
			Name = "German - Germany",
			MCC = "262"
		},
		new CountryCode
		{
			Name = "Greek - Greece",
			MCC = "202"
		},
		new CountryCode
		{
			Name = "Hungarian - Hungary",
			MCC = "216"
		},
		new CountryCode
		{
			Name = "Italian - Italy",
			MCC = "222"
		},
		new CountryCode
		{
			Name = "Japanese - Japan",
			MCC = "440"
		},
		new CountryCode
		{
			Name = "Korean - Korea",
			MCC = "450"
		},
		new CountryCode
		{
			Name = "Norwegian, Bokmal - Norway",
			MCC = "242"
		},
		new CountryCode
		{
			Name = "Polish - Poland",
			MCC = "260"
		},
		new CountryCode
		{
			Name = "Portuguese - Brazil",
			MCC = "724"
		},
		new CountryCode
		{
			Name = "Portuguese - Portugal",
			MCC = "268"
		},
		new CountryCode
		{
			Name = "Russian - Russia",
			MCC = "250"
		},
		new CountryCode
		{
			Name = "Spanish - Spain",
			MCC = "214"
		},
		new CountryCode
		{
			Name = "Swedish - Sweden",
			MCC = "240"
		}
	};

	private static CountryCode[] _codeData = new CountryCode[221]
	{
		new CountryCode("Greece(GR)", "+30"),
		new CountryCode("Netherlands(NL)", "+31"),
		new CountryCode("Belgium(BE)", "+32"),
		new CountryCode("France(FR)", "+33"),
		new CountryCode("Monaco(MC)", "+377"),
		new CountryCode("Andorra(AD)", "+376"),
		new CountryCode("Spain(ES)", "+34"),
		new CountryCode("Hungary(HU)", "+36"),
		new CountryCode("Bosnia and Herzegovina(BA)", "+387"),
		new CountryCode("Croatia(HR)", "+385"),
		new CountryCode("Serbia(RS)", "+381"),
		new CountryCode("Italy(IT)", "+39"),
		new CountryCode("Vatican City State(VA)", "+379"),
		new CountryCode("Romania(RO)", "+40"),
		new CountryCode("Switzerland(CH)", "+41"),
		new CountryCode("Czech Republic(CZ)", "+420"),
		new CountryCode("Slovakia(SK)", "+421"),
		new CountryCode("Austria(AT)", "+43"),
		new CountryCode("United Kingdom(GB)", "+44"),
		new CountryCode("Denmark(DK)", "+45"),
		new CountryCode("Sweden(SE)", "+46"),
		new CountryCode("Norway(NO)", "+47"),
		new CountryCode("Finland(FI)", "+358"),
		new CountryCode("Lithuania(LT)", "+370"),
		new CountryCode("Latvia(LV)", "+371"),
		new CountryCode("Estonia(EE)", "+372"),
		new CountryCode("Russian Federation(RU)", "+7"),
		new CountryCode("Ukraine(UA)", "+380"),
		new CountryCode("Belarus(BY)", "+375"),
		new CountryCode("Moldova(MD)", "+373"),
		new CountryCode("Poland(PL)", "+48"),
		new CountryCode("Germany(DE)", "+49"),
		new CountryCode("Gibraltar(GI)", "+350"),
		new CountryCode("Portugal(PT)", "+351"),
		new CountryCode("Luxembourg(LU)", "+352"),
		new CountryCode("Ireland(IE)", "+353"),
		new CountryCode("Iceland(IS)", "+354"),
		new CountryCode("Albania(AL)", "+355"),
		new CountryCode("Malta(MT)", "+356"),
		new CountryCode("Cyprus(CY)", "+357"),
		new CountryCode("Georgia(GE)", "+995"),
		new CountryCode("Armenia(AM)", "+374"),
		new CountryCode("Bulgaria(BG)", "+359"),
		new CountryCode("Turkey(TR)", "+90"),
		new CountryCode("Faroe Islands(FO)", "+298"),
		new CountryCode("Greenland(GL)", "+299"),
		new CountryCode("San Marino(SM)", "+378"),
		new CountryCode("Slovenia(SI)", "+386"),
		new CountryCode("Republic of Macedonia(MK)", "+389"),
		new CountryCode("Liechtenstein(LI)", "+423"),
		new CountryCode("Montenegro(ME)", "+382"),
		new CountryCode("Canada(CA)", "+1"),
		new CountryCode("Saint Pierre and Miquelon(PM)", "+508"),
		new CountryCode("United States of America(US)", "+1"),
		new CountryCode("Puerto Rico(PR)", "+1"),
		new CountryCode("United States Virgin Islands(VI)", "+1"),
		new CountryCode("Mexico(MX)", "+52"),
		new CountryCode("Jamaica(JM)", "+1"),
		new CountryCode("Guadeloupe(GP)", "+590"),
		new CountryCode("Martinique(France)", "+596"),
		new CountryCode("Barbados(BB)", "+1"),
		new CountryCode("Antigua and Barbuda(AG)", "+1"),
		new CountryCode("Cayman Islands(KY)", "+1"),
		new CountryCode("British Virgin Islands(VG)", "+1"),
		new CountryCode("Bermuda(BM)", "+1"),
		new CountryCode("Grenada(GD)", "+1"),
		new CountryCode("Botswana(BW)", "+267"),
		new CountryCode("Montserrat(MS)", "+1"),
		new CountryCode("Saint Kitts and Nevis(KN)", "+1"),
		new CountryCode("Saint Lucia(LC)", "+1"),
		new CountryCode("Saint Vincent and the Grenadines(VC)", "+1"),
		new CountryCode("Netherlands Antilles(AN)", "+599"),
		new CountryCode("Aruba(AW)", "+297"),
		new CountryCode("Bahamas(BS)", "+1"),
		new CountryCode("Anguilla(AI)", "+1"),
		new CountryCode("Dominica(DM)", "+1"),
		new CountryCode("Cuba(CU)", "+53"),
		new CountryCode("Dominican Republic(DO)", "+1"),
		new CountryCode("Haiti(HT)", "+509"),
		new CountryCode("Trinidad and Tobago(TT)", "+1"),
		new CountryCode("Turks and Caicos Islands(TC)", "+1"),
		new CountryCode("Azerbaijani Republic(AZ)", "+994"),
		new CountryCode("Kazakhstan(KZ)", "+7"),
		new CountryCode("Bhutan(BT)", "+975"),
		new CountryCode("India(IN)", "+91"),
		new CountryCode("Pakistan(PK)", "+92"),
		new CountryCode("Afghanistan(AF)", "+93"),
		new CountryCode("Sri Lanka(LK)", "+94"),
		new CountryCode("Myanmar(MM)", "+95"),
		new CountryCode("Lebanon(LB)", "+961"),
		new CountryCode("Jordan(JO)", "+962"),
		new CountryCode("Syria(SY)", "+963"),
		new CountryCode("Iraq(IQ)", "+964"),
		new CountryCode("Kuwait(KW)", "+965"),
		new CountryCode("Saudi Arabia(SA)", "+966"),
		new CountryCode("Yemen(YE)", "+967"),
		new CountryCode("Oman(OM)", "+968"),
		new CountryCode("Palestine(PS)", "+970"),
		new CountryCode("United Arab Emirates(AE)", "+971"),
		new CountryCode("Israel(IL)", "+972"),
		new CountryCode("Bahrain(BH)", "+973"),
		new CountryCode("Qatar(QA)", "+974"),
		new CountryCode("Mongolia(MN)", "+976"),
		new CountryCode("Nepal(NP)", "+977"),
		new CountryCode("Iran(IR)", "+98"),
		new CountryCode("Uzbekistan(UZ)", "+998"),
		new CountryCode("Tajikistan(TJ)", "+992"),
		new CountryCode("Kyrgyz Republic(KG)", "+996"),
		new CountryCode("Turkmenistan(TM)", "+993"),
		new CountryCode("Japan(JP)", "+81"),
		new CountryCode("Korea, Republic of(KR)", "+82"),
		new CountryCode("Viet Nam(VN)", "+84"),
		new CountryCode("honk Kong(HK)", "+852"),
		new CountryCode("Macau(MO)", "+853"),
		new CountryCode("Cambodia(KH)", "+855"),
		new CountryCode("Laos(LA)", "+856"),
		new CountryCode("China(CN)", "+86"),
		new CountryCode("Taiwan(TW)", "+886"),
		new CountryCode("Bangladesh(BD)", "+880"),
		new CountryCode("Maldives(MV)", "+960"),
		new CountryCode("Malaysia(MY)", "+60"),
		new CountryCode("Australia(AU)", "+61"),
		new CountryCode("Indonesia(ID)", "+62"),
		new CountryCode("East Timor(TL)", "+670"),
		new CountryCode("Philippines(PH)", "+63"),
		new CountryCode("Thailand(TH)", "+66"),
		new CountryCode("Singapore(SG)", "+65"),
		new CountryCode("Brunei Darussalam(BN)", "+673"),
		new CountryCode("New Zealand(NZ)", "+64"),
		new CountryCode("Northern Mariana Islands(US)", "+1"),
		new CountryCode("Guam(GU)", "+1"),
		new CountryCode("Nauru(NR)", "+674"),
		new CountryCode("Papua New Guinea(PG)", "+675"),
		new CountryCode("Tonga(TO)", "+676"),
		new CountryCode("Solomon Islands(SB)", "+677"),
		new CountryCode("Vanuatu(VU)", "+678"),
		new CountryCode("Fiji(FJ)", "+679"),
		new CountryCode("Wallis and Futuna(WF)", "+681"),
		new CountryCode("American Samoa(AS)", "+1"),
		new CountryCode("Kiribati(KI)", "+686"),
		new CountryCode("New Caledonia(NC)", "+687"),
		new CountryCode("French Polynesia(PF)", "+689"),
		new CountryCode("Cook Island(CK)", "+682"),
		new CountryCode("Samoa(WS)", "+685"),
		new CountryCode("Federated States of Micronesia(FM)", "+691"),
		new CountryCode("Marshall Islands(MH)", "+692"),
		new CountryCode("Palau(PW)", "+680"),
		new CountryCode("Egypt(EG)", "+20"),
		new CountryCode("Algeria(DZ)", "+213"),
		new CountryCode("Morocco(MA)", "+212"),
		new CountryCode("Tunisia(TN)", "+216"),
		new CountryCode("Libya(LY)", "+218"),
		new CountryCode("Gambia(GM)", "+220"),
		new CountryCode("Senegal(SN)", "+221"),
		new CountryCode("Mauritania(MR)", "+222"),
		new CountryCode("Mali(ML)", "+223"),
		new CountryCode("Guinea(GN)", "+224"),
		new CountryCode("Côte d'Ivoire(CI)", "+225"),
		new CountryCode("Burkina Faso(BF)", "+226"),
		new CountryCode("Niger(NE)", "+227"),
		new CountryCode("Togolese Republic(TG)", "+228"),
		new CountryCode("Benin(BJ)", "+229"),
		new CountryCode("Mauritius(MU)", "+230"),
		new CountryCode("Liberia(LR)", "+231"),
		new CountryCode("Sierra Leone(SL)", "+232"),
		new CountryCode("Ghana(GH)", "+233"),
		new CountryCode("Nigeria(NG)", "+234"),
		new CountryCode("Chad(TD)", "+235"),
		new CountryCode("Central African Republic(CF)", "+236"),
		new CountryCode("Cameroon(CM)", "+237"),
		new CountryCode("Cape Verde(CV)", "+238"),
		new CountryCode("São Tomé and Príncipe(ST)", "+239"),
		new CountryCode("Equatorial Guinea(GQ)", "+240"),
		new CountryCode("Gabonese Republic(GA)", "+241"),
		new CountryCode("Republic of the Congo(CG)", "+242"),
		new CountryCode("Democratic Republic of the Congo(CD)", "+243"),
		new CountryCode("Angola(AO)", "+244"),
		new CountryCode("Guinea-Bissau(GW)", "+245"),
		new CountryCode("Seychelles(SC)", "+248"),
		new CountryCode("Sudan(SD)", "+249"),
		new CountryCode("Rwandese Republic(RW)", "+250"),
		new CountryCode("Ethiopia(ET)", "+251"),
		new CountryCode("Somalia(SO)", "+252"),
		new CountryCode("Djibouti(DJ)", "+253"),
		new CountryCode("Kenya(KE)", "+254"),
		new CountryCode("Tanzania(TZ)", "+255"),
		new CountryCode("Uganda(UG)", "+256"),
		new CountryCode("Burundi(BI)", "+257"),
		new CountryCode("Mozambique(MZ)", "+258"),
		new CountryCode("Zambia(ZM)", "+260"),
		new CountryCode("Madagascar(MG)", "+261"),
		new CountryCode("Réunion(RE)", "+262"),
		new CountryCode("Zimbabwe(ZW)", "+263"),
		new CountryCode("Namibia(NA)", "+264"),
		new CountryCode("Malawi(MW)", "+265"),
		new CountryCode("Lesotho(LS)", "+266"),
		new CountryCode("Swaziland(SZ)", "+268"),
		new CountryCode("Comoros(KM)", "+269"),
		new CountryCode("South Africa(ZA)", "+27"),
		new CountryCode("Eritrea(ER)", "+291"),
		new CountryCode("Belize(BZ)", "+501"),
		new CountryCode("Guatemala(GT)", "+502"),
		new CountryCode("El Salvador(SV)", "+503"),
		new CountryCode("Honduras(HN)", "+504"),
		new CountryCode("Nicaragua(NI)", "+505"),
		new CountryCode("Costa Rica(CR)", "+506"),
		new CountryCode("Panama(PA)", "+507"),
		new CountryCode("Peru(PE)", "+51"),
		new CountryCode("Argentine Republic(AR)", "+54"),
		new CountryCode("Brazil(BR)", "+55"),
		new CountryCode("Chile(CL)", "+56"),
		new CountryCode("Colombia(CO)", "+57"),
		new CountryCode("Venezuela(VE)", "+58"),
		new CountryCode("Bolivia(BO)", "+591"),
		new CountryCode("Guyana(GY)", "+592"),
		new CountryCode("Ecuador(EC)", "+593"),
		new CountryCode("French Guiana(GF)", "+594"),
		new CountryCode("Paraguay(PY)", "+595"),
		new CountryCode("Suriname(SR)", "+597"),
		new CountryCode("Uruguay(UY)", "+598"),
		new CountryCode("Falkland Islands(FK)", "+500")
	};

	public CountryCode[] CodeData => _codeData;

	public CountryCode[] CountryData => _countryData;

	public ObservableCollection<CountryCode> SearchResult
	{
		get
		{
			return _searchResult;
		}
		set
		{
			_searchResult = value;
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
			if (value != _keyword)
			{
				_keyword = value;
				MakeResultList(loadAll: false);
			}
		}
	}

	public bool IsCodeSelectionMode
	{
		get
		{
			return _isCodeSelectionMode;
		}
		set
		{
			_isCodeSelectionMode = value;
		}
	}

	public static CountryCode GetCountryCode(string number)
	{
		return _codeData.FirstOrDefault((CountryCode c) => c.Code == number);
	}

	public SelectCountryCodePageViewModel(SelectCountryCodePage page)
	{
		_page = page;
		_timer = new DispatcherTimer();
		_timer.Tick += _timer_Tick;
		_timer.Interval = TimeSpan.FromMilliseconds(40.0);
		_keyword = "";
	}

	private void _timer_Tick(object sender, EventArgs e)
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

	public void MakeResultList(bool loadAll)
	{
		_startTick = DateTime.UtcNow.Ticks;
		_timer.Stop();
		_searchResult.Clear();
		_tempList.Clear();
		if (_keyword.Length > 0)
		{
			IEnumerable<CountryCode> source = (_isCodeSelectionMode ? _codeData.Where((CountryCode d) => (!string.IsNullOrEmpty(d.Name) && d.Name.IndexOf(_keyword, StringComparison.CurrentCultureIgnoreCase) != -1) || (!string.IsNullOrEmpty(d.Code) && d.Code.IndexOf(_keyword, StringComparison.CurrentCultureIgnoreCase) != -1)) : _countryData.Where((CountryCode d) => (!string.IsNullOrEmpty(d.Name) && d.Name.IndexOf(_keyword, StringComparison.CurrentCultureIgnoreCase) != -1) || (!string.IsNullOrEmpty(d.Code) && d.Code.IndexOf(_keyword, StringComparison.CurrentCultureIgnoreCase) != -1)));
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
			if (!loadAll)
			{
				_timer.Start();
			}
			return;
		}
		IEnumerable<CountryCode> enumerable = (_isCodeSelectionMode ? _codeData.OrderBy((CountryCode d) => d.Name) : _countryData.OrderBy((CountryCode d) => d.Name));
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
		if (!loadAll)
		{
			_timer.Start();
		}
	}
}
