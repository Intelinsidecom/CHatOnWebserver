package com.sec.chaton.trunk.p061c;

import android.text.TextUtils;
import android.widget.TextView;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.R;
import java.net.MalformedURLException;
import java.net.URL;
import twitter4j.Query;

/* compiled from: TrunkUtil.java */
/* renamed from: com.sec.chaton.trunk.c.f */
/* loaded from: classes.dex */
public class C3025f {
    /* renamed from: a */
    public static EnumC3026g m10537a(String str, boolean z) {
        if (z) {
            return EnumC3026g.AMS;
        }
        if (str.startsWith(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
            return EnumC3026g.IMAGE;
        }
        if (str.startsWith(SlookAirButtonRecentMediaAdapter.VIDEO_TYPE)) {
            return EnumC3026g.VIDEO;
        }
        if (str.startsWith(Query.MIXED)) {
            if (str.substring(6).equals(SlookAirButtonRecentMediaAdapter.IMAGE_TYPE)) {
                return EnumC3026g.IMAGE;
            }
            return EnumC3026g.VIDEO;
        }
        return EnumC3026g.UNKNOWN;
    }

    /* renamed from: a */
    public static String m10538a(String str) {
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

    /* renamed from: b */
    public static boolean m10540b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("file://")) {
            str = str.substring(6);
        }
        AMSLibs aMSLibs = new AMSLibs();
        aMSLibs.VipAMS_Init();
        AMS_UI_DATA ams_ui_data = new AMS_UI_DATA();
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        return aMSLibs.VipAMS_IsAMSJPEGFile(ams_ui_data, ams_coding_file_infoArr) == 0;
    }

    /* renamed from: a */
    public static void m10539a(TextView textView, int i) {
        String strValueOf = String.valueOf(i);
        if (strValueOf.length() >= 3) {
            textView.setText(R.string.chat_max_unread);
        } else {
            textView.setText(strValueOf);
        }
    }
}
