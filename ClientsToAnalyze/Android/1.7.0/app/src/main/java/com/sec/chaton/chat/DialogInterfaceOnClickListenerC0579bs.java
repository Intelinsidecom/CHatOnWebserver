package com.sec.chaton.chat;

import android.content.DialogInterface;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p018c.C0502i;
import com.sec.chaton.p018c.p019a.C0468e;
import com.sec.chaton.p025d.C0662o;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.widget.C1619g;
import java.io.File;
import java.net.URI;
import java.util.StringTokenizer;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bs */
/* loaded from: classes.dex */
class DialogInterfaceOnClickListenerC0579bs implements DialogInterface.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ View f1997a;

    /* renamed from: b */
    final /* synthetic */ long f1998b;

    /* renamed from: c */
    final /* synthetic */ boolean f1999c;

    /* renamed from: d */
    final /* synthetic */ ChatFragment f2000d;

    DialogInterfaceOnClickListenerC0579bs(ChatFragment chatFragment, View view, long j, boolean z) {
        this.f2000d = chatFragment;
        this.f1997a = view;
        this.f1998b = j;
        this.f1999c = z;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        String str;
        if (this.f1997a != null && this.f1997a.getParent() != null) {
            Cursor cursor = this.f2000d.f1795ae.getCursor();
            try {
                cursor.moveToPosition(this.f2000d.f1794ad.getPositionForView(this.f1997a));
            } catch (Exception e) {
                cursor = GlobalApplication.m3100a().getContentResolver().query(C0662o.f2289a, null, "_id=?", new String[]{String.valueOf(this.f1998b)}, null);
                cursor.moveToFirst();
            }
            long j = cursor.getLong(cursor.getColumnIndex("_id"));
            String string = cursor.getString(cursor.getColumnIndex("message_content"));
            String string2 = cursor.getString(cursor.getColumnIndex("message_inbox_no"));
            String string3 = cursor.getString(cursor.getColumnIndex("message_download_uri"));
            EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String string4 = cursor.getString(cursor.getColumnIndex("message_formatted"));
            int i2 = cursor.getInt(cursor.getColumnIndex("message_is_failed"));
            File file = null;
            View view = (View) this.f1997a.getTag();
            int i3 = 1 + i;
            if (!this.f1999c || this.f2000d.f1800aj == 1 || !this.f2000d.f1818bB) {
                i3++;
            }
            switch (i3) {
                case 1:
                    this.f2000d.m2626a(string, enumC0651dM2976a);
                    break;
                case 2:
                    int iM2526a = C0502i.m2526a(GlobalApplication.m3100a());
                    if (-3 == iM2526a || -2 == iM2526a) {
                        this.f2000d.f1797ag.cancel();
                        this.f2000d.f1797ag.setText(R.string.popup_no_network_connection);
                        this.f2000d.f1797ag.setDuration(0);
                        this.f2000d.f1797ag.show();
                        return;
                    }
                    Button button = (Button) view.findViewById(R.id.btnError);
                    if (button != null) {
                        button.setVisibility(8);
                    }
                    if (enumC0651dM2976a == EnumC0651d.TEXT || enumC0651dM2976a == EnumC0651d.GEO) {
                        str = "";
                    } else {
                        if (TextUtils.isEmpty(string3)) {
                            C1619g.m5888a(this.f2000d.getActivity(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
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
                    if (TextUtils.isEmpty(this.f2000d.f1867z)) {
                        if (this.f2000d.f1866y != EnumC0665r.BROADCAST && !this.f2000d.f1744E.isShowing()) {
                            this.f2000d.f1744E.show();
                        }
                        z = true;
                    }
                    if (enumC0651dM2976a == EnumC0651d.TEXT) {
                        this.f2000d.f1799ai.m830a(j, string2, enumC0651dM2976a, this.f2000d.f1866y, this.f2000d.f1867z, (String[]) this.f2000d.f1802al.toArray(new String[this.f2000d.f1802al.size()]), string, z);
                        break;
                    } else if (enumC0651dM2976a == EnumC0651d.GEO) {
                        this.f2000d.f1799ai.m826a(j, this.f2000d.f1866y, this.f2000d.f1867z, (String[]) this.f2000d.f1802al.toArray(new String[this.f2000d.f1802al.size()]), z, string);
                        break;
                    } else if (i2 == 3) {
                        this.f2000d.f1799ai.m825a(j, this.f2000d.f1866y, string, this.f2000d.f1867z, (String[]) this.f2000d.f1802al.toArray(new String[this.f2000d.f1802al.size()]), z, string4, str, enumC0651dM2976a);
                        break;
                    } else if (file != null) {
                        this.f2000d.f1799ai.m829a(j, file, enumC0651dM2976a, this.f2000d.f1866y, this.f2000d.f1867z, (String[]) this.f2000d.f1802al.toArray(new String[this.f2000d.f1802al.size()]), z, string4);
                        C0468e.m2389a().m2390a(j).m2424a(new HandlerC0584bx(this, enumC0651dM2976a, view));
                        break;
                    }
                    break;
                case 3:
                    this.f2000d.f1760U.startDelete(3, null, C0662o.f2289a, "_id='" + this.f1998b + "'", null);
                    break;
            }
            dialogInterface.cancel();
        }
    }
}
