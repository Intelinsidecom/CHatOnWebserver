package com.sec.chaton.smsplugin.p101a;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p110g.C3855a;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3891n;
import com.sec.google.android.p134a.C5077a;
import com.sec.google.android.p134a.C5111c;
import com.sec.google.android.p134a.p135a.C5086i;
import com.sec.google.android.p134a.p135a.C5094q;
import com.sec.google.android.p134a.p136b.C5110f;
import java.util.ArrayList;
import org.p138a.p142b.p143a.p144a.C5229d;

/* compiled from: MmsPartExport.java */
/* renamed from: com.sec.chaton.smsplugin.a.a */
/* loaded from: classes.dex */
public class C3779a {

    /* renamed from: a */
    private static final String f13547a = Environment.getExternalStorageDirectory() + "/" + Environment.DIRECTORY_DOWNLOADS.toLowerCase() + "/";

    /* renamed from: a */
    private static C5094q m14191a(Context context, Uri uri, Uri uri2) {
        C5086i c5086iM14200a = C3780b.m14200a(context, uri);
        if (c5086iM14200a == null) {
            return null;
        }
        int iM19333b = c5086iM14200a.m19333b();
        for (int i = 0; i < iM19333b; i++) {
            C5094q c5094qM19328a = c5086iM14200a.m19328a(i);
            String str = new String(c5094qM19328a.m19394g());
            if (!"text/plain".equals(str) && !"application/smil".equals(str) && uri2.equals(c5094qM19328a.m19383b())) {
                return c5094qM19328a;
            }
        }
        return null;
    }

    /* renamed from: c */
    private static boolean m14199c(String str) {
        return "text/x-vCard".equalsIgnoreCase(str) || "text/x-vCalendar".equalsIgnoreCase(str);
    }

    /* renamed from: a */
    public static String m14192a(Context context, Uri uri, Uri uri2, String str) {
        return m14193a(context, m14191a(context, uri2, uri), str);
    }

    /* renamed from: a */
    static String m14193a(Context context, C5094q c5094q, String str) {
        String strSubstring;
        if (c5094q == null) {
            return null;
        }
        if (C3847e.m14638V()) {
            byte[] bArrM19390e = c5094q.m19390e();
            if (bArrM19390e == null) {
                bArrM19390e = c5094q.m19398j();
            }
            if (bArrM19390e == null) {
                bArrM19390e = c5094q.m19397i();
            }
            if (bArrM19390e == null) {
                bArrM19390e = c5094q.m19386c();
            }
            if (bArrM19390e != null) {
                str = new String(bArrM19390e);
            }
        } else {
            byte[] bArrM19397i = c5094q.m19397i();
            if (bArrM19397i == null) {
                bArrM19397i = c5094q.m19398j();
            }
            if (bArrM19397i == null) {
                bArrM19397i = c5094q.m19390e();
            }
            if (bArrM19397i == null) {
                bArrM19397i = c5094q.m19386c();
            }
            if (bArrM19397i != null) {
                str = new String(bArrM19397i);
            }
        }
        String strM19926c = C5229d.m19926c(str);
        if (strM19926c.startsWith("<")) {
            strM19926c = strM19926c.substring(1);
        }
        if (strM19926c.endsWith(">")) {
            strM19926c = strM19926c.substring(0, strM19926c.length() - 1);
        }
        String strSubstring2 = strM19926c.startsWith("cid:") ? strM19926c.substring("cid:".length()) : strM19926c;
        String str2 = new String(c5094q.m19394g());
        if (C5077a.m19294g(str2)) {
            Cursor cursorM19497a = C5110f.m19497a(context, context.getContentResolver(), c5094q.m19383b(), null, null, null, null);
            if (cursorM19497a != null) {
                try {
                    cursorM19497a.moveToFirst();
                    String string = cursorM19497a.getString(cursorM19497a.getColumnIndexOrThrow("name"));
                    if (string == null) {
                        string = cursorM19497a.getString(cursorM19497a.getColumnIndexOrThrow("cl"));
                    }
                    strSubstring2 = string;
                } finally {
                    if (cursorM19497a != null) {
                        cursorM19497a.close();
                    }
                }
            }
        }
        int iLastIndexOf = strSubstring2.lastIndexOf(46);
        if (iLastIndexOf == -1) {
            strSubstring = C3891n.m15001a().m15006c(str2);
        } else {
            strSubstring = strSubstring2.substring(iLastIndexOf + 1, strSubstring2.length());
            strSubstring2 = strSubstring2.substring(0, iLastIndexOf);
        }
        C3890m.m14994a("Mms/MmsPartExport", "extension" + strSubstring);
        if (C5077a.m19294g(str2) && !"dcf".equals(strSubstring)) {
            strSubstring = "dcf";
        }
        if (strSubstring == null) {
            if (str2.equalsIgnoreCase("text/x-vCard")) {
                strSubstring = "vcf";
            } else if (str2.equalsIgnoreCase("text/x-vCalendar")) {
                strSubstring = "vcs";
            }
        }
        if (!TextUtils.isEmpty(strSubstring)) {
            strSubstring2 = strSubstring2.concat(".").concat(strSubstring);
        }
        return m14194a(strSubstring2);
    }

    /* renamed from: a */
    static String m14194a(String str) {
        if (str == null) {
            return null;
        }
        String strM14198b = m14198b(str);
        if (strM14198b.startsWith(".")) {
            if (strM14198b.length() == 1) {
                return "_";
            }
            return "_" + str.substring(1);
        }
        return strM14198b;
    }

    /* renamed from: b */
    static String m14198b(String str) {
        int length = str.length();
        String strReplace = str;
        for (int i = 0; i < length; i++) {
            if (m14197a(strReplace.charAt(i))) {
                strReplace = strReplace.replace(strReplace.charAt(i), '_');
            }
        }
        C3890m.m14996b("Mms/MmsPartExport", "replaceInvalidFilename(),from=" + str + ",to=" + strReplace);
        return strReplace;
    }

    /* renamed from: a */
    static boolean m14197a(char c2) {
        if (!C3847e.m14638V()) {
            return c2 < '!' || c2 > '~';
        }
        switch (c2) {
            case '\n':
            case '\"':
            case '*':
            case '/':
            case ':':
            case ';':
            case '<':
            case '>':
            case '?':
            case '\\':
            case '|':
                return true;
            default:
                return false;
        }
    }

    /* renamed from: a */
    public static ArrayList<C3855a> m14195a(Context context, Uri uri, boolean z) {
        return m14196a(context, uri, z, false);
    }

    /* renamed from: a */
    public static ArrayList<C3855a> m14196a(Context context, Uri uri, boolean z, boolean z2) {
        C3855a c3855a;
        ArrayList<C3855a> arrayList = new ArrayList<>();
        C5086i c5086iM14200a = C3780b.m14200a(context, uri);
        if (c5086iM14200a != null) {
            String lastPathSegment = uri.getLastPathSegment();
            int iM19333b = c5086iM14200a.m19333b();
            for (int i = 0; i < iM19333b; i++) {
                C5094q c5094qM19328a = c5086iM14200a.m19328a(i);
                String str = new String(c5094qM19328a.m19394g());
                if (!"text/plain".equals(str) && !"application/smil".equals(str) && ((z || m14199c(str)) && (!z2 || str.contains("audio/") || C5077a.m19294g(str)))) {
                    try {
                        c3855a = new C3855a(context, str, m14193a(context, c5094qM19328a, lastPathSegment), c5094qM19328a.m19383b());
                    } catch (C5111c e) {
                        C3890m.m14995a("Mms/MmsPartExport", e.getMessage(), e);
                        c3855a = null;
                    } catch (NullPointerException e2) {
                        C3890m.m14995a("Mms/MmsPartExport", e2.getMessage(), e2);
                        c3855a = null;
                    }
                    if (c3855a != null) {
                        arrayList.add(c3855a);
                    }
                }
            }
        }
        return arrayList;
    }
}
