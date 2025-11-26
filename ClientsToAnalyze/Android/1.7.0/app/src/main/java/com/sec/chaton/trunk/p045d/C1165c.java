package com.sec.chaton.trunk.p045d;

import android.widget.TextView;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.R;
import java.net.MalformedURLException;
import java.net.URL;

/* compiled from: TrunkUtil.java */
/* renamed from: com.sec.chaton.trunk.d.c */
/* loaded from: classes.dex */
public class C1165c {
    /* renamed from: a */
    public static EnumC1168f m4204a(String str) {
        if (str.startsWith("image")) {
            return EnumC1168f.IMAGE;
        }
        if (str.startsWith("video")) {
            return EnumC1168f.VIDEO;
        }
        return EnumC1168f.UNKNOWN;
    }

    /* renamed from: b */
    public static String m4206b(String str) throws MalformedURLException {
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
    public static boolean m4207c(String str) {
        AMSLibs aMSLibs = new AMSLibs();
        aMSLibs.VipAMS_Init();
        AMS_UI_DATA ams_ui_data = new AMS_UI_DATA();
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        return aMSLibs.VipAMS_IsAMSJPEGFile(ams_ui_data, ams_coding_file_infoArr) == 0;
    }

    /* renamed from: a */
    public static void m4205a(TextView textView, int i) {
        String strValueOf = String.valueOf(i);
        if (strValueOf.length() >= 3) {
            textView.setText(R.string.chat_max_unread);
        } else {
            textView.setText(strValueOf);
        }
    }
}
