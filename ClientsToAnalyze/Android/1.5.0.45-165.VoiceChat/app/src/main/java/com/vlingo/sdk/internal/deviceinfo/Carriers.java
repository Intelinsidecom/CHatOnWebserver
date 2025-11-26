package com.vlingo.sdk.internal.deviceinfo;

import java.util.Hashtable;

/* loaded from: classes.dex */
public class Carriers {
    protected static String[] ISO3_CARRIER_MAP_SRC = {"ABW", "SETAR_GSM", "ABW", "Unknown", "AFG", "TDCA", "AIA", "Cable_&_Wireless_WI", "ANT", "Unknown", "ARE", "ETISALAT", "ARG", "AR_-_Movistar", "ARG", "AR_PERSONAL", "ARG", "CTI_Argentina", "ARG", "CTI_Movil_ARG", "ARG", "Unknown", "ATG", "Cable_&_Wireless", "AUS", "3TELSTRA", "AUS", "Telstra_Mobile", "AUS", "Telstra_Mobile", "AUS", "vodafone_AU", "AUS", "YES_OPTUS", "AUT", "A1", "AUT", "one", "AUT", "T-Mobile_A", "BEL", "BASE", "BEL", "BEL_PROXIMUS", "BEL", "Mobistar", "BGD", "Banglalink", "BGD", "GrameenPhone", "BGR", "M-Tel_BG", "BHR", "BATELCO", "BHR", "zain_BH", "BHS", "The_Bahamas_Telecomm", "BMU", "BTC_MOBILITY_LTD.", "BOL", "BOMOV", "BOL", "Telecel_Bolivia_GSM", "BRA", "CLARO", "BRA", "TIM_BRASIL", "BRA", "VIVO", "BRB", "C&W", "CAN", "Bell_Mobility", "CAN", "Rogers_Wireless", "CAN", "TELUS", "CAN", "Virgin_Mobile_Canada", "CHE", "Orange", "CHE", "orange_CH", "CHE", "sunrise", "CHE", "Swisscom", "CHE", "Unknown", "CHL", "Claro", "CHL", "ENTEL_PCS", "CHL", "movistar", "CHN", "????", "CHN", "CHINA__MOBILE", "COD", "CelTel_Congo_SA", "COL", "COL_Movistar", "COL", "Comcel_3GSM", "CYM", "C&W", "CYP", "areeba", "CZE", "O2_-_CZ", "CZE", "T-Mobile_CZ", "DEU", "E-Plus", "DEU", "o2_-_de", "DEU", "T-Mobile_D", "DEU", "Vodafone.de", "DMA", "C&W", "DNK", "DK_SONOFON", "DNK", "TDC_MOBIL", "DNK", "TELIA_DK", "DOM", "CLARO_DOM", "DZA", "Djezzy", "ESP", "Orange", "ESP", "vodafone_ES", "ECU", "movistar", "ECU", "PORTA_GSM", "EGY", "EGY_MobiNiL", "EGY", "etisalat", "EGY", "vodafone", "ESP", "movistar", "ESP", "Orange", "ESP", "vodafone_ES", "FIN", "dna", "FIN", "FI_elisa", "FJI", "FJ_VODAFONE", "FRA", "F_-_BOUYGUES_TELECOM", "FRA", "F_SFR", "FRA", "F-Bouygues_Telecom", "FRA", "Orange_F", "FRA", "Unknown", "GBR", "C&W", "GBR", "Manx_Pronto", "GBR", "Manx_Telecom_Mobile", "GBR", "O2_-_UK", "GBR", "Orange", "GBR", "T-Mobile_UK", "GBR", "vodafone_UK", "GEO", "MAGTI-GSM-GEO", "GHA", "GH_MTN", "GHA", "GH_SPACEFON", "GRC", "GR_COSMOTE", "GRC", "vodafone_GR", "GRC", "WIND_GR", "GRD", "C&W", "GTM", "Comcel_GSM", "GTM", "movistar", "GUY", "GUY_TW", "HKG", "3-DUALBAND-", "HKG", "CMCC_PEOPLES", "HKG", "CSL", "HKG", "PEOPLES", "HKG", "SmarToneVodafone", "HND", "CELTELHND", "HRV", "HR_VIP", "HRV", "T-Mobile_HR", "HUN", "TMO_H", "IDN", "IND_TELKOMSEL", "IDN", "IND_XL", "IDN", "MATRIX", "IND", "AirTel", "IND", "BPL_MOBILE", "IND", "BSSL", "IND", "ESSAR", "IND", "Hutch", "IND", "IND_AIRTEL", "IND", "Reliance", "IND", "Unknown", "IND", "Vodafone_IN", "IRL", "02_-_IRL", "IRL", "O2_IRL", "IRL", "vodafone_IE", "IRQ", "IRAQNA", "ISR", "Cellcom", "ISR", "Cellcom", "ISR", "IL_ORANGE", "ITA", "I_TIM", "ITA", "vodafone_IT", "ITA", "Wind_Telecom_SpA", "JAM", "C&W", "JAM", "DIGICEL", "JOR", "Fastlink", "JOR", "UMNIAH", "KEN", "KENCELL", "KEN", "Safaricom", "KNA", "C&W", "KNA", "Unknown", "KOR", "KR_KTF", "KOR", "SK_Telecom", "KOR", "SK_Telecom", "KWT", "KT_MTCNet", "KWT", "MTC_KW", "LBN", "RL_MTC_Lebanon", "LCA", "Cable_&_Wireless", "LUX", "L_LUXGSM", "LUX", "L_TANGO", "MAC", "CTM", "MAC", "SmarTone_Macau", "MAR", "MOR_MEDITEL", "MDA", "VOXTEL", "MDG", "TELMA", "MEX", "IUSACELL", "MEX", "movistar", "MEX", "Mx_Telcel_GSM", "MEX", "TELCEL_GSM", "MNE", "YUG_03", "MYS", "MY_CELCOM", "MYS", "DiGi", "MYS", "MY_CELCOM", "MYS", "My_Maxis", "MYS", "My_Maxis", "NGA", "CELTEL_NIG", "NGA", "ECONET", "NGA", "Glo_Mobile", "NGA", "MTN_Nigeria", "NIC", "Claro_NIC", "NIC", "movistar", "NLD", "NL_KPN", "NLD", "T-Mobile_NL", "NLD", "vodafone_NL", "NOR", "NetCom", "NZL", "vodafone_NZ", "PAK", "Mobilink", "PAK", "UFONE", "PAK", "WaridTel", "PAN", "PANCW", "PER", "CLARO_PER", "PER", "movistar", "PHL", "Globe_Telecom-PH", "PHL", "Smart", "POL", "Era", "POL", "Orange_PL", "POL", "Plus", "PRI", "PR_Claro", "PRT", "vodafone_P", "PRY", "PY_Personal", "ROU", "ORANGE", "ROU", "RO_Vodafone_RO", "RUS", "Beeline", "RUS", "MegaFon", "RUS", "MTS-RUS", "SAU", "ALJAWAL", "SAU", "mobily", "SDN", "MobiTel_SDN", "SYC", "CABLE_&_WIRELESS", "SGP", "M1-3GSM", "SGP", "SingTel", "SGP", "StarHub", "SLV", "movistar", "SLV", "TELEMOVIL", "SVK", "Orange_SK", "SVK", "T-Mobile_SK", "SVN", "MOBITEL", "SVN", "SI.MOBIL", "SWE", "Telenor_SE", "SWE", "TELIA_S", "SWE", "Unknown", "TCA", "Cable_&_Wireless_WI", "THA", "TH_GSM", "THA", "TRUE", "TTO", "DIGICEL", "TTO", "TSTT", "TTO", "Unknown", "TUR", "TR_TURKCELL", "TUR", "VODAFONE_TR", "TWN", "Chunghwa_Telecom", "TWN", "Far_EasTone", "TWN", "Taiwan_Mobile", "UGA", "CELTEL_UG", "UGA", "mango", "UGA", "MTN-UGANDA", "UKR", "life:)", "UKR", "MTS_UKR", "Unknown", "1x_Test_Network", "Unknown", "CDMA_Home_Network", "Unknown", "Digital_Roaming", "Unknown", "Extended_Network", "Unknown", "Fast_100", "Unknown", "GPRS_Test_Network", "Unknown", "International", "Unknown", "Mobility", "Unknown", "Roaming", "Unknown", "Telecom", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "URY", "MOVISTAR", "USA", "ACS", "USA", "ALLTEL", "USA", "AmeriLink_PCS", "USA", "Appalachian_Wireless", "USA", "AT&T", "USA", "Bluegrass_Cellular", "USA", "Carolina_West_Wireless", "USA", "Cbeyond", "USA", "Cell1ET", "USA", "Cellular_One", "USA", "Cellular_One_DCS", "USA", "Cellular_South", "USA", "CENT_USA", "USA", "Centennial", "USA", "Chinook", "USA", "Cingular", "USA", "Corr_Wireless_Comms", "USA", "Edge_Wireless", "USA", "Einstein_PCS", "USA", "Epic_Touch", "USA", "FARMERS", "USA", "FC", "USA", "i_wireless", "USA", "Immix_Wireless", "USA", "Indigo", "USA", "indigo_Wireless", "USA", "NECCI", "USA", "NPI", "USA", "nTelos", "USA", "PetroCom", "USA", "Pine_Cellular", "USA", "Plateau_Wireless", "USA", "Smith_Bagley", "USA", "Sprint_PCS", "USA", "SunCom", "USA", "T-Mobile", "USA", "TMP_Corp", "USA", "U.S._Cellular", "USA", "Unknown", "USA", "Unknown", "USA", "US_-_Union_Telephone", "USA", "USA_-_Commnet", "USA", "USA_Unicel", "USA", "USA_XIT_Wireless", "USA", "USAC1ECI", "USA", "USAEC", "USA", "USASXLP", "USA", "Verizon_Wireless", "USA", "West_Central", "USA", "WestLink", "VEN", "DIGITEL_GSM", "VEN", "DIGITEL_TIM", "VEN", "Movilnet", "VEN", "movistar", "VGB", "Unknown", "VNM", "VINAFONE", "VNM", "VN_MOBIFONE", "VNM", "VNM_and_VIETTEL", "ZAF", "Cell_C", "ZAF", "MTN", "ZAF", "VodaCom-SA"};
    protected static String[] UNKNOWN_CARRIERS = {"Unknown", "Roaming", "Telecom", "Mobility", "1x_Test_Network", "EDGE_Test_Network", "UMTS_Test_Network", "CDMA_Home_Network", "Digital_Roaming", "Extended_Network", "GPRS_Test_Network", "International"};
    protected static Carriers instance = null;
    public Hashtable<String, Object> carrierMapTable;

    public static Carriers getInstance() {
        if (instance == null) {
            instance = new Carriers();
        }
        return instance;
    }

    protected Carriers() {
        this.carrierMapTable = null;
        this.carrierMapTable = new Hashtable<>();
        for (int i = 0; i < ISO3_CARRIER_MAP_SRC.length; i += 2) {
            String name = ISO3_CARRIER_MAP_SRC[i + 1];
            if (name != null && !isUnknownCarrier(name)) {
                String iso3 = ISO3_CARRIER_MAP_SRC[i];
                String iso2 = CountryUtils.ISO3ToISO2CountryCode(iso3);
                Carrier c = new Carrier(name, iso2 == null ? "Unknown" : iso2, iso3);
                this.carrierMapTable.put(name.toLowerCase(), c);
            }
        }
    }

    public Carrier getCarrierByName(String carrierName) {
        return (Carrier) this.carrierMapTable.get(carrierName.toLowerCase().replace(' ', '_'));
    }

    protected static boolean isUnknownCarrier(String carrierName) {
        if (carrierName == null || carrierName.length() == 0) {
            return true;
        }
        for (int i = 0; i < UNKNOWN_CARRIERS.length; i++) {
            if (carrierName.equalsIgnoreCase(UNKNOWN_CARRIERS[i])) {
                return true;
            }
        }
        return false;
    }
}
