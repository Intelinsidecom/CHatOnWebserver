package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.anicon.C0921d;
import com.sec.chaton.p017e.C0698m;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.p022h.C0809s;
import java.io.File;
import java.net.URI;
import java.util.StringTokenizer;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.aa */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0459aa implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ View f1920a;

    /* renamed from: b */
    final /* synthetic */ boolean f1921b;

    /* renamed from: c */
    final /* synthetic */ long f1922c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f1923d;

    DialogInterfaceOnClickListenerC0459aa(ChatFragment chatFragment, View view, boolean z, long j) {
        this.f1923d = chatFragment;
        this.f1920a = view;
        this.f1921b = z;
        this.f1922c = j;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        int positionForView = this.f1923d.f1827ap.getPositionForView(this.f1920a);
        Cursor cursor = this.f1923d.f1828aq.getCursor();
        cursor.moveToPosition(positionForView);
        long j = cursor.getLong(cursor.getColumnIndex("_id"));
        String string = cursor.getString(cursor.getColumnIndex("message_content"));
        String string2 = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
        String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
        EnumC0699n enumC0699nM3160a = EnumC0699n.m3160a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
        String string4 = cursor.getString(cursor.getColumnIndex("message_formatted"));
        int i2 = cursor.getInt(cursor.getColumnIndex("message_is_failed"));
        File file = null;
        View view = (View) this.f1920a.getTag();
        int i3 = 1 + i;
        if (!this.f1921b || this.f1923d.f1832au == 1 || !this.f1923d.f1896ch) {
            i3++;
        }
        switch (i3) {
            case 1:
                this.f1923d.m2512a(string, enumC0699nM3160a);
                break;
            case 2:
                int iM3420a = C0809s.m3420a(GlobalApplication.m3260b());
                if (-3 == iM3420a || -2 == iM3420a) {
                    Toast.makeText(this.f1923d.getActivity(), R.string.toast_network_unable, 0).show();
                    return;
                }
                Button button = (Button) view.findViewById(R.id.btnError);
                if (button != null) {
                    button.setVisibility(8);
                }
                if (enumC0699nM3160a == EnumC0699n.TEXT || enumC0699nM3160a == EnumC0699n.GEO || enumC0699nM3160a == EnumC0699n.ANICON) {
                    str = "";
                } else {
                    if (TextUtils.isEmpty(string3)) {
                        Toast.makeText(this.f1923d.getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
                        return;
                    }
                    file = new File(URI.create(string3));
                    StringTokenizer stringTokenizer = new StringTokenizer(string3, ".");
                    String strNextToken = "";
                    while (stringTokenizer.hasMoreTokens()) {
                        strNextToken = stringTokenizer.nextToken();
                    }
                    str = "." + strNextToken.toUpperCase();
                }
                boolean z = false;
                if (TextUtils.isEmpty(this.f1923d.f1766G)) {
                    z = true;
                }
                if (enumC0699nM3160a == EnumC0699n.TEXT) {
                    this.f1923d.f1831at.m2931a(j, string2, enumC0699nM3160a, this.f1923d.f1765F, this.f1923d.f1766G, (String[]) this.f1923d.f1834aw.toArray(new String[this.f1923d.f1834aw.size()]), string, z);
                    break;
                } else if (enumC0699nM3160a == EnumC0699n.GEO) {
                    this.f1923d.f1831at.m2921a(j, this.f1923d.f1765F, this.f1923d.f1766G, (String[]) this.f1923d.f1834aw.toArray(new String[this.f1923d.f1834aw.size()]), z, string);
                    break;
                } else if (enumC0699nM3160a == EnumC0699n.ANICON) {
                    this.f1923d.f1831at.m2950c(j, this.f1923d.f1765F, this.f1923d.f1766G, (String[]) this.f1923d.f1834aw.toArray(new String[this.f1923d.f1834aw.size()]), z, C0921d.m3797c(string.split("\n")[2]), -1L);
                    break;
                } else {
                    if (enumC0699nM3160a == EnumC0699n.IMAGE || enumC0699nM3160a == EnumC0699n.VIDEO) {
                    }
                    if (i2 == 3) {
                        this.f1923d.f1831at.m2920a(j, this.f1923d.f1765F, string, this.f1923d.f1766G, (String[]) this.f1923d.f1834aw.toArray(new String[this.f1923d.f1834aw.size()]), z, string4, str, enumC0699nM3160a);
                        break;
                    } else if (file != null) {
                        String strSubstring = null;
                        if (string != null) {
                            String[] strArrSplit = string.split("\n");
                            if (strArrSplit.length > 6) {
                                StringBuffer stringBuffer = new StringBuffer();
                                for (int i4 = 6; i4 < strArrSplit.length; i4++) {
                                    stringBuffer.append(strArrSplit[i4] + "\n");
                                }
                                strSubstring = stringBuffer.toString().substring(0, stringBuffer.length() - 1);
                            }
                        }
                        this.f1923d.f1831at.m2924a(j, file, enumC0699nM3160a, this.f1923d.f1765F, this.f1923d.f1766G, (String[]) this.f1923d.f1834aw.toArray(new String[this.f1923d.f1834aw.size()]), z, string4, strSubstring);
                        break;
                    }
                }
                break;
            case 3:
                this.f1923d.f1783X.startDelete(3, null, C0698m.f2626a, "_id='" + this.f1922c + "'", null);
                break;
        }
        dialogInterface.cancel();
    }
}
