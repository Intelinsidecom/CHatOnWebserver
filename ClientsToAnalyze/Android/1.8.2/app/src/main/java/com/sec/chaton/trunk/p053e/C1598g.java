package com.sec.chaton.trunk.p053e;

import android.widget.TextView;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.R;
import java.net.MalformedURLException;
import java.net.URL;
import twitter4j.Query;

/* compiled from: TrunkUtil.java */
/* renamed from: com.sec.chaton.trunk.e.g */
/* loaded from: classes.dex */
public class C1598g {
    /* renamed from: a */
    public static EnumC1599h m5506a(String str) {
        if (str.startsWith("image")) {
            return EnumC1599h.IMAGE;
        }
        if (str.startsWith("video")) {
            return EnumC1599h.VIDEO;
        }
        if (str.startsWith(Query.MIXED)) {
            if (str.substring(6).equals("image")) {
                return EnumC1599h.IMAGE;
            }
            return EnumC1599h.VIDEO;
        }
        return EnumC1599h.UNKNOWN;
    }

    /* renamed from: b */
    public static String m5508b(String str) {
        String file = new URL(str).getFile();
        if (file == null) {
            return null;
        }
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

    /* renamed from: c */
    public static boolean m5509c(String str) {
        AMSLibs aMSLibs = new AMSLibs();
        aMSLibs.VipAMS_Init();
        AMS_UI_DATA ams_ui_data = new AMS_UI_DATA();
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        return aMSLibs.VipAMS_IsAMSJPEGFile(ams_ui_data, ams_coding_file_infoArr) == 0;
    }

    /* renamed from: a */
    public static void m5507a(TextView textView, int i) {
        String strValueOf = String.valueOf(i);
        if (strValueOf.length() >= 3) {
            textView.setText(R.string.chat_max_unread);
        } else {
            textView.setText(strValueOf);
        }
    }
}
