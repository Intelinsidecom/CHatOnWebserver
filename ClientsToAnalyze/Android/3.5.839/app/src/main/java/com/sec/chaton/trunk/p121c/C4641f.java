package com.sec.chaton.trunk.p121c;

import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C4816ah;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: TrunkUtil.java */
/* renamed from: com.sec.chaton.trunk.c.f */
/* loaded from: classes.dex */
public class C4641f {
    /* renamed from: a */
    public static EnumC4642g m17614a(String str, boolean z) {
        if (z) {
            return EnumC4642g.AMS;
        }
        if (str.startsWith(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            return EnumC4642g.IMAGE;
        }
        if (str.startsWith("video")) {
            return EnumC4642g.VIDEO;
        }
        if (str.startsWith("mixed")) {
            if (str.substring(6).equals(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                return EnumC4642g.IMAGE;
            }
            return EnumC4642g.VIDEO;
        }
        return EnumC4642g.UNKNOWN;
    }

    /* renamed from: a */
    public static String m17615a(String str) throws MalformedURLException {
        if (str == null) {
            return null;
        }
        String file = new URL(str).getFile();
        int iLastIndexOf = file.lastIndexOf("/");
        int iLastIndexOf2 = file.lastIndexOf("?");
        if (iLastIndexOf == -1) {
            return null;
        }
        if (iLastIndexOf2 == -1) {
            iLastIndexOf2 = file.length();
        }
        String strSubstring = file.substring(iLastIndexOf + 1, iLastIndexOf2);
        if (strSubstring == null || strSubstring.trim().equals("")) {
            throw new MalformedURLException("File name is null.");
        }
        return strSubstring;
    }

    /* renamed from: b */
    public static boolean m17617b(String str) {
        return new C4816ah().m18177a(str);
    }

    /* renamed from: a */
    public static void m17616a(TextView textView, int i) {
        String strValueOf = String.valueOf(i);
        if (strValueOf.length() >= 3) {
            textView.setText(R.string.chat_max_unread);
        } else {
            textView.setText(strValueOf);
        }
    }
}
