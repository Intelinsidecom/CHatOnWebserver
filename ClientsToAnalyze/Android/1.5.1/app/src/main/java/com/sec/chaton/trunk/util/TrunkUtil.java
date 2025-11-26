package com.sec.chaton.trunk.util;

import android.widget.TextView;
import com.sec.amsoma.AMSLibs;
import com.sec.amsoma.structure.AMS_CODING_FILE_INFO;
import com.sec.amsoma.structure.AMS_UI_DATA;
import com.sec.chaton.C0062R;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes.dex */
public class TrunkUtil {

    public enum ContentType {
        IMAGE,
        VIDEO,
        UNKNOWN
    }

    public static String ExtractFileNameFromUrl(String str) throws MalformedURLException {
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

    public static ContentType GetContentType(String str) {
        return str.startsWith("image") ? ContentType.IMAGE : str.startsWith("video") ? ContentType.VIDEO : ContentType.UNKNOWN;
    }

    public static boolean IsAMSImage(String str) {
        AMSLibs aMSLibs = new AMSLibs();
        aMSLibs.VipAMS_Init();
        AMS_UI_DATA ams_ui_data = new AMS_UI_DATA();
        AMS_CODING_FILE_INFO[] ams_coding_file_infoArr = {new AMS_CODING_FILE_INFO()};
        ams_coding_file_infoArr[0].setM_eExportType(0);
        ams_coding_file_infoArr[0].setM_strFileName(str);
        return aMSLibs.VipAMS_IsAMSJPEGFile(ams_ui_data, ams_coding_file_infoArr) == 0;
    }

    public static void SetCountToBubble(TextView textView, int i) {
        String strValueOf = String.valueOf(i);
        if (strValueOf.length() >= 3) {
            textView.setText(C0062R.string.chat_max_unread);
        } else {
            textView.setText(strValueOf);
        }
    }
}
