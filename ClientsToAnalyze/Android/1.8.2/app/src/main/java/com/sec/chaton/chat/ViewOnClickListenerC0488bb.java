package com.sec.chaton.chat;

import android.database.Cursor;
import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.p017e.EnumC0699n;
import com.sec.chaton.util.C1789u;
import java.text.SimpleDateFormat;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.bb */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0488bb implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0477as f2073a;

    /* renamed from: b */
    private CheckBox f2074b;

    /* renamed from: c */
    private String f2075c;

    public ViewOnClickListenerC0488bb(ViewOnClickListenerC0477as viewOnClickListenerC0477as, CheckBox checkBox, String str) {
        this.f2073a = viewOnClickListenerC0477as;
        this.f2074b = checkBox;
        this.f2075c = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        CheckBox checkBox = (CheckBox) view;
        Boolean boolValueOf = Boolean.valueOf(checkBox.isChecked());
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < this.f2073a.f1963B.getAdapter().getCount(); i++) {
            Cursor cursor = (Cursor) this.f2073a.f1963B.getAdapter().getItem(i);
            Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")));
            EnumC0699n enumC0699nM3160a = EnumC0699n.m3160a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lValueOf).split(" ");
            if (enumC0699nM3160a != EnumC0699n.SYSTEM && this.f2075c.equals(strArrSplit[0]) && (string = cursor.getString(cursor.getColumnIndex("message_sender"))) != null) {
                if (string.equals(C1789u.m6075a().getString("msisdn", ""))) {
                    j2++;
                    this.f2073a.f1972K.put(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))), boolValueOf);
                } else {
                    j++;
                    this.f2073a.f1973L.put(Long.valueOf(Long.valueOf(cursor.getString(cursor.getColumnIndex("message_sever_id"))).longValue()), boolValueOf);
                }
            }
        }
        long j3 = this.f2073a.f1975N + this.f2073a.f1974M;
        long j4 = j2 + j;
        if (boolValueOf.booleanValue()) {
            if (!this.f2073a.f1999s.contains(this.f2075c)) {
                this.f2073a.f1999s.add(this.f2075c);
            }
            if (j3 == j4) {
                this.f2073a.f1978Q = EnumC0487ba.SELECT_ALL;
                this.f2073a.f1980S = EnumC0487ba.SELECT_NONE;
                this.f2073a.f1979R = EnumC0487ba.SELECT_NONE;
            } else if (this.f2073a.f1975N == j) {
                this.f2073a.f1978Q = EnumC0487ba.SELECT_NONE;
                this.f2073a.f1980S = EnumC0487ba.SELECT_ALL;
                this.f2073a.f1979R = EnumC0487ba.SELECT_NONE;
            } else if (this.f2073a.f1974M == j2) {
                this.f2073a.f1978Q = EnumC0487ba.SELECT_NONE;
                this.f2073a.f1980S = EnumC0487ba.SELECT_NONE;
                this.f2073a.f1979R = EnumC0487ba.SELECT_ALL;
            } else {
                if (this.f2073a.f1978Q == EnumC0487ba.SELECT_ALL || this.f2073a.f1978Q == EnumC0487ba.SELECT_PART) {
                    this.f2073a.f1978Q = EnumC0487ba.SELECT_PART;
                } else {
                    this.f2073a.f1978Q = EnumC0487ba.SELECT_NONE;
                }
                if (this.f2073a.f1980S == EnumC0487ba.SELECT_ALL || this.f2073a.f1980S == EnumC0487ba.SELECT_PART) {
                    this.f2073a.f1980S = EnumC0487ba.SELECT_PART;
                } else {
                    this.f2073a.f1980S = EnumC0487ba.SELECT_NONE;
                }
                if (this.f2073a.f1979R == EnumC0487ba.SELECT_ALL || this.f2073a.f1979R == EnumC0487ba.SELECT_PART) {
                    this.f2073a.f1979R = EnumC0487ba.SELECT_PART;
                } else {
                    this.f2073a.f1979R = EnumC0487ba.SELECT_NONE;
                }
            }
        } else {
            if (this.f2073a.f1999s.contains(this.f2075c)) {
                this.f2073a.f1999s.remove(this.f2075c);
            }
            if (j3 == j4) {
                this.f2073a.f1978Q = EnumC0487ba.SELECT_NONE;
                this.f2073a.f1980S = EnumC0487ba.SELECT_NONE;
                this.f2073a.f1979R = EnumC0487ba.SELECT_NONE;
            } else if (this.f2073a.f1975N == j) {
                this.f2073a.f1978Q = EnumC0487ba.SELECT_NONE;
                this.f2073a.f1980S = EnumC0487ba.SELECT_NONE;
                this.f2073a.f1979R = EnumC0487ba.SELECT_NONE;
            } else if (this.f2073a.f1974M == j2) {
                this.f2073a.f1978Q = EnumC0487ba.SELECT_NONE;
                this.f2073a.f1980S = EnumC0487ba.SELECT_NONE;
                this.f2073a.f1979R = EnumC0487ba.SELECT_NONE;
            } else {
                if (this.f2073a.f1978Q == EnumC0487ba.SELECT_ALL || this.f2073a.f1978Q == EnumC0487ba.SELECT_PART) {
                    this.f2073a.f1978Q = EnumC0487ba.SELECT_PART;
                } else {
                    this.f2073a.f1978Q = EnumC0487ba.SELECT_NONE;
                }
                if (this.f2073a.f1980S == EnumC0487ba.SELECT_ALL || this.f2073a.f1980S == EnumC0487ba.SELECT_PART) {
                    this.f2073a.f1980S = EnumC0487ba.SELECT_PART;
                } else {
                    this.f2073a.f1980S = EnumC0487ba.SELECT_NONE;
                }
                if (this.f2073a.f1979R == EnumC0487ba.SELECT_ALL || this.f2073a.f1979R == EnumC0487ba.SELECT_PART) {
                    this.f2073a.f1979R = EnumC0487ba.SELECT_PART;
                } else {
                    this.f2073a.f1979R = EnumC0487ba.SELECT_NONE;
                }
            }
        }
        checkBox.setChecked(boolValueOf.booleanValue());
        this.f2073a.f1963B.invalidateViews();
    }
}
