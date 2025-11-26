package org.p138a.p142b.p143a.p145b;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/* compiled from: CharsetUtil.java */
/* renamed from: org.a.b.a.b.a */
/* loaded from: classes.dex */
public class C5233a {

    /* renamed from: a */
    public static final Charset f19078a;

    /* renamed from: b */
    public static final Charset f19079b;

    /* renamed from: c */
    public static final Charset f19080c;

    /* renamed from: d */
    public static final Charset f19081d;

    /* renamed from: e */
    private static Log f19082e = LogFactory.getLog(C5233a.class);

    /* renamed from: f */
    private static C5235c[] f19083f = {new C5235c("ISO8859_1", "ISO-8859-1", new String[]{"ISO_8859-1:1987", "iso-ir-100", "ISO_8859-1", "latin1", "l1", "IBM819", "CP819", "csISOLatin1", "8859_1", "819", "IBM-819", "ISO8859-1", "ISO_8859_1"}), new C5235c("ISO8859_2", "ISO-8859-2", new String[]{"ISO_8859-2:1987", "iso-ir-101", "ISO_8859-2", "latin2", "l2", "csISOLatin2", "8859_2", "iso8859_2"}), new C5235c("ISO8859_3", "ISO-8859-3", new String[]{"ISO_8859-3:1988", "iso-ir-109", "ISO_8859-3", "latin3", "l3", "csISOLatin3", "8859_3"}), new C5235c("ISO8859_4", "ISO-8859-4", new String[]{"ISO_8859-4:1988", "iso-ir-110", "ISO_8859-4", "latin4", "l4", "csISOLatin4", "8859_4"}), new C5235c("ISO8859_5", "ISO-8859-5", new String[]{"ISO_8859-5:1988", "iso-ir-144", "ISO_8859-5", "cyrillic", "csISOLatinCyrillic", "8859_5"}), new C5235c("ISO8859_6", "ISO-8859-6", new String[]{"ISO_8859-6:1987", "iso-ir-127", "ISO_8859-6", "ECMA-114", "ASMO-708", "arabic", "csISOLatinArabic", "8859_6"}), new C5235c("ISO8859_7", "ISO-8859-7", new String[]{"ISO_8859-7:1987", "iso-ir-126", "ISO_8859-7", "ELOT_928", "ECMA-118", "greek", "greek8", "csISOLatinGreek", "8859_7", "sun_eu_greek"}), new C5235c("ISO8859_8", "ISO-8859-8", new String[]{"ISO_8859-8:1988", "iso-ir-138", "ISO_8859-8", "hebrew", "csISOLatinHebrew", "8859_8"}), new C5235c("ISO8859_9", "ISO-8859-9", new String[]{"ISO_8859-9:1989", "iso-ir-148", "ISO_8859-9", "latin5", "l5", "csISOLatin5", "8859_9"}), new C5235c("ISO8859_13", "ISO-8859-13", new String[0]), new C5235c("ISO8859_15", "ISO-8859-15", new String[]{"ISO_8859-15", "Latin-9", "8859_15", "csISOlatin9", "IBM923", "cp923", "923", "L9", "IBM-923", "ISO8859-15", "LATIN9", "LATIN0", "csISOlatin0", "ISO8859_15_FDIS"}), new C5235c("KOI8_R", "KOI8-R", new String[]{"csKOI8R", "koi8"}), new C5235c("ASCII", "US-ASCII", new String[]{"ANSI_X3.4-1968", "iso-ir-6", "ANSI_X3.4-1986", "ISO_646.irv:1991", "ISO646-US", "us", "IBM367", "cp367", "csASCII", "ascii7", "646", "iso_646.irv:1983"}), new C5235c("UTF8", "UTF-8", new String[0]), new C5235c("UTF-16", "UTF-16", new String[]{"UTF_16"}), new C5235c("UnicodeBigUnmarked", "UTF-16BE", new String[]{"X-UTF-16BE", "UTF_16BE", "ISO-10646-UCS-2"}), new C5235c("UnicodeLittleUnmarked", "UTF-16LE", new String[]{"UTF_16LE", "X-UTF-16LE"}), new C5235c("Big5", "Big5", new String[]{"csBig5", "CN-Big5", "BIG-FIVE", "BIGFIVE"}), new C5235c("Big5_HKSCS", "Big5-HKSCS", new String[]{"big5hkscs"}), new C5235c("EUC_JP", "EUC-JP", new String[]{"csEUCPkdFmtJapanese", "Extended_UNIX_Code_Packed_Format_for_Japanese", "eucjis", "x-eucjp", "eucjp", "x-euc-jp"}), new C5235c("EUC_KR", "EUC-KR", new String[]{"csEUCKR", "ksc5601", "5601", "ksc5601_1987", "ksc_5601", "ksc5601-1987", "ks_c_5601-1987", "euckr"}), new C5235c("GB18030", "GB18030", new String[]{"gb18030-2000"}), new C5235c("EUC_CN", "GB2312", new String[]{"x-EUC-CN", "csGB2312", "euccn", "euc-cn", "gb2312-80", "gb2312-1980", "CN-GB", "CN-GB-ISOIR165"}), new C5235c("GBK", "windows-936", new String[]{"CP936", "MS936", "ms_936", "x-mswin-936"}), new C5235c("Cp037", "IBM037", new String[]{"ebcdic-cp-us", "ebcdic-cp-ca", "ebcdic-cp-wt", "ebcdic-cp-nl", "csIBM037"}), new C5235c("Cp273", "IBM273", new String[]{"csIBM273"}), new C5235c("Cp277", "IBM277", new String[]{"EBCDIC-CP-DK", "EBCDIC-CP-NO", "csIBM277"}), new C5235c("Cp278", "IBM278", new String[]{"CP278", "ebcdic-cp-fi", "ebcdic-cp-se", "csIBM278"}), new C5235c("Cp280", "IBM280", new String[]{"ebcdic-cp-it", "csIBM280"}), new C5235c("Cp284", "IBM284", new String[]{"ebcdic-cp-es", "csIBM284"}), new C5235c("Cp285", "IBM285", new String[]{"ebcdic-cp-gb", "csIBM285"}), new C5235c("Cp297", "IBM297", new String[]{"ebcdic-cp-fr", "csIBM297"}), new C5235c("Cp420", "IBM420", new String[]{"ebcdic-cp-ar1", "csIBM420"}), new C5235c("Cp424", "IBM424", new String[]{"ebcdic-cp-he", "csIBM424"}), new C5235c("Cp437", "IBM437", new String[]{"437", "csPC8CodePage437"}), new C5235c("Cp500", "IBM500", new String[]{"ebcdic-cp-be", "ebcdic-cp-ch", "csIBM500"}), new C5235c("Cp775", "IBM775", new String[]{"csPC775Baltic"}), new C5235c("Cp838", "IBM-Thai", new String[0]), new C5235c("Cp850", "IBM850", new String[]{"850", "csPC850Multilingual"}), new C5235c("Cp852", "IBM852", new String[]{"852", "csPCp852"}), new C5235c("Cp855", "IBM855", new String[]{"855", "csIBM855"}), new C5235c("Cp857", "IBM857", new String[]{"857", "csIBM857"}), new C5235c("Cp858", "IBM00858", new String[]{"CCSID00858", "CP00858", "PC-Multilingual-850+euro"}), new C5235c("Cp860", "IBM860", new String[]{"860", "csIBM860"}), new C5235c("Cp861", "IBM861", new String[]{"861", "cp-is", "csIBM861"}), new C5235c("Cp862", "IBM862", new String[]{"862", "csPC862LatinHebrew"}), new C5235c("Cp863", "IBM863", new String[]{"863", "csIBM863"}), new C5235c("Cp864", "IBM864", new String[]{"cp864", "csIBM864"}), new C5235c("Cp865", "IBM865", new String[]{"865", "csIBM865"}), new C5235c("Cp866", "IBM866", new String[]{"866", "csIBM866"}), new C5235c("Cp868", "IBM868", new String[]{"cp-ar", "csIBM868"}), new C5235c("Cp869", "IBM869", new String[]{"cp-gr", "csIBM869"}), new C5235c("Cp870", "IBM870", new String[]{"ebcdic-cp-roece", "ebcdic-cp-yu", "csIBM870"}), new C5235c("Cp871", "IBM871", new String[]{"ebcdic-cp-is", "csIBM871"}), new C5235c("Cp918", "IBM918", new String[]{"ebcdic-cp-ar2", "csIBM918"}), new C5235c("Cp1026", "IBM1026", new String[]{"csIBM1026"}), new C5235c("Cp1047", "IBM1047", new String[]{"IBM-1047"}), new C5235c("Cp1140", "IBM01140", new String[]{"CCSID01140", "CP01140", "ebcdic-us-37+euro"}), new C5235c("Cp1141", "IBM01141", new String[]{"CCSID01141", "CP01141", "ebcdic-de-273+euro"}), new C5235c("Cp1142", "IBM01142", new String[]{"CCSID01142", "CP01142", "ebcdic-dk-277+euro", "ebcdic-no-277+euro"}), new C5235c("Cp1143", "IBM01143", new String[]{"CCSID01143", "CP01143", "ebcdic-fi-278+euro", "ebcdic-se-278+euro"}), new C5235c("Cp1144", "IBM01144", new String[]{"CCSID01144", "CP01144", "ebcdic-it-280+euro"}), new C5235c("Cp1145", "IBM01145", new String[]{"CCSID01145", "CP01145", "ebcdic-es-284+euro"}), new C5235c("Cp1146", "IBM01146", new String[]{"CCSID01146", "CP01146", "ebcdic-gb-285+euro"}), new C5235c("Cp1147", "IBM01147", new String[]{"CCSID01147", "CP01147", "ebcdic-fr-297+euro"}), new C5235c("Cp1148", "IBM01148", new String[]{"CCSID01148", "CP01148", "ebcdic-international-500+euro"}), new C5235c("Cp1149", "IBM01149", new String[]{"CCSID01149", "CP01149", "ebcdic-is-871+euro"}), new C5235c("Cp1250", "windows-1250", new String[0]), new C5235c("Cp1251", "windows-1251", new String[0]), new C5235c("Cp1252", "windows-1252", new String[0]), new C5235c("Cp1253", "windows-1253", new String[0]), new C5235c("Cp1254", "windows-1254", new String[0]), new C5235c("Cp1255", "windows-1255", new String[0]), new C5235c("Cp1256", "windows-1256", new String[0]), new C5235c("Cp1257", "windows-1257", new String[0]), new C5235c("Cp1258", "windows-1258", new String[0]), new C5235c("ISO2022CN", "ISO-2022-CN", new String[0]), new C5235c("ISO2022JP", "ISO-2022-JP", new String[]{"csISO2022JP", "JIS", "jis_encoding", "csjisencoding"}), new C5235c("ISO2022KR", "ISO-2022-KR", new String[]{"csISO2022KR"}), new C5235c("JIS_X0201", "JIS_X0201", new String[]{"X0201", "JIS0201", "csHalfWidthKatakana"}), new C5235c("JIS_X0212-1990", "JIS_X0212-1990", new String[]{"iso-ir-159", "x0212", "JIS0212", "csISO159JISX02121990"}), new C5235c("JIS_C6626-1983", "JIS_C6626-1983", new String[]{"x-JIS0208", "JIS0208", "csISO87JISX0208", "x0208", "JIS_X0208-1983", "iso-ir-87"}), new C5235c("SJIS", "Shift_JIS", new String[]{"MS_Kanji", "csShiftJIS", "shift-jis", "x-sjis", "pck"}), new C5235c("TIS620", "TIS-620", new String[0]), new C5235c("MS932", "Windows-31J", new String[]{"windows-932", "csWindows31J", "x-ms-cp932"}), new C5235c("EUC_TW", "EUC-TW", new String[]{"x-EUC-TW", "cns11643", "euctw"}), new C5235c("x-Johab", "johab", new String[]{"johab", "cp1361", "ms1361", "ksc5601-1992", "ksc5601_1992"}), new C5235c("MS950_HKSCS", "", new String[0]), new C5235c("MS874", "windows-874", new String[]{"cp874"}), new C5235c("MS949", "windows-949", new String[]{"windows949", "ms_949", "x-windows-949"}), new C5235c("MS950", "windows-950", new String[]{"x-windows-950"}), new C5235c("Cp737", null, new String[0]), new C5235c("Cp856", null, new String[0]), new C5235c("Cp875", null, new String[0]), new C5235c("Cp921", null, new String[0]), new C5235c("Cp922", null, new String[0]), new C5235c("Cp930", null, new String[0]), new C5235c("Cp933", null, new String[0]), new C5235c("Cp935", null, new String[0]), new C5235c("Cp937", null, new String[0]), new C5235c("Cp939", null, new String[0]), new C5235c("Cp942", null, new String[0]), new C5235c("Cp942C", null, new String[0]), new C5235c("Cp943", null, new String[0]), new C5235c("Cp943C", null, new String[0]), new C5235c("Cp948", null, new String[0]), new C5235c("Cp949", null, new String[0]), new C5235c("Cp949C", null, new String[0]), new C5235c("Cp950", null, new String[0]), new C5235c("Cp964", null, new String[0]), new C5235c("Cp970", null, new String[0]), new C5235c("Cp1006", null, new String[0]), new C5235c("Cp1025", null, new String[0]), new C5235c("Cp1046", null, new String[0]), new C5235c("Cp1097", null, new String[0]), new C5235c("Cp1098", null, new String[0]), new C5235c("Cp1112", null, new String[0]), new C5235c("Cp1122", null, new String[0]), new C5235c("Cp1123", null, new String[0]), new C5235c("Cp1124", null, new String[0]), new C5235c("Cp1381", null, new String[0]), new C5235c("Cp1383", null, new String[0]), new C5235c("Cp33722", null, new String[0]), new C5235c("Big5_Solaris", null, new String[0]), new C5235c("EUC_JP_LINUX", null, new String[0]), new C5235c("EUC_JP_Solaris", null, new String[0]), new C5235c("ISCII91", null, new String[]{"x-ISCII91", "iscii"}), new C5235c("ISO2022_CN_CNS", null, new String[0]), new C5235c("ISO2022_CN_GB", null, new String[0]), new C5235c("x-iso-8859-11", null, new String[0]), new C5235c("JISAutoDetect", null, new String[0]), new C5235c("MacArabic", null, new String[0]), new C5235c("MacCentralEurope", null, new String[0]), new C5235c("MacCroatian", null, new String[0]), new C5235c("MacCyrillic", null, new String[0]), new C5235c("MacDingbat", null, new String[0]), new C5235c("MacGreek", "MacGreek", new String[0]), new C5235c("MacHebrew", null, new String[0]), new C5235c("MacIceland", null, new String[0]), new C5235c("MacRoman", "MacRoman", new String[]{"Macintosh", "MAC", "csMacintosh"}), new C5235c("MacRomania", null, new String[0]), new C5235c("MacSymbol", null, new String[0]), new C5235c("MacThai", null, new String[0]), new C5235c("MacTurkish", null, new String[0]), new C5235c("MacUkraine", null, new String[0]), new C5235c("UnicodeBig", null, new String[0]), new C5235c("UnicodeLittle", null, new String[0])};

    /* renamed from: g */
    private static SortedSet<String> f19084g;

    /* renamed from: h */
    private static SortedSet<String> f19085h;

    /* renamed from: i */
    private static Map<String, C5235c> f19086i;

    static {
        f19084g = null;
        f19085h = null;
        f19086i = null;
        f19084g = new TreeSet();
        f19085h = new TreeSet();
        byte[] bArr = {100, 117, 109, 109, 121};
        for (C5235c c5235c : f19083f) {
            try {
                new String(bArr, c5235c.f19087a);
                f19084g.add(c5235c.f19087a.toLowerCase());
            } catch (UnsupportedEncodingException e) {
            } catch (UnsupportedOperationException e2) {
            }
            try {
                "dummy".getBytes(c5235c.f19087a);
                f19085h.add(c5235c.f19087a.toLowerCase());
            } catch (UnsupportedEncodingException e3) {
            } catch (UnsupportedOperationException e4) {
            }
        }
        f19086i = new HashMap();
        for (C5235c c5235c2 : f19083f) {
            f19086i.put(c5235c2.f19087a.toLowerCase(), c5235c2);
            if (c5235c2.f19088b != null) {
                f19086i.put(c5235c2.f19088b.toLowerCase(), c5235c2);
            }
            if (c5235c2.f19089c != null) {
                for (String str : c5235c2.f19089c) {
                    f19086i.put(str.toLowerCase(), c5235c2);
                }
            }
        }
        if (f19082e.isDebugEnabled()) {
            f19082e.debug("Character sets which support decoding: " + f19084g);
            f19082e.debug("Character sets which support encoding: " + f19085h);
        }
        f19078a = Charset.forName("US-ASCII");
        f19079b = Charset.forName("ISO-8859-1");
        f19080c = Charset.forName("UTF-8");
        f19081d = f19078a;
    }

    /* renamed from: a */
    public static boolean m19940a(char c2) {
        return c2 == ' ' || c2 == '\t' || c2 == '\r' || c2 == '\n';
    }

    /* renamed from: a */
    public static boolean m19941a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("String may not be null");
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!m19940a(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: b */
    public static boolean m19942b(String str) {
        return f19084g.contains(str.toLowerCase());
    }

    /* renamed from: c */
    public static String m19943c(String str) {
        C5235c c5235c = f19086i.get(str.toLowerCase());
        if (c5235c != null) {
            return c5235c.f19087a;
        }
        return null;
    }
}
