package com.sec.chaton.chat;

import android.database.Cursor;
import android.view.View;
import android.widget.CheckBox;
import com.sec.chaton.p025d.EnumC0651d;
import com.sec.chaton.util.C1323bs;
import java.text.SimpleDateFormat;

/* compiled from: ChatListAdapter.java */
/* renamed from: com.sec.chaton.chat.f */
/* loaded from: classes.dex */
public class ViewOnClickListenerC0589f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ViewOnClickListenerC0603t f2021a;

    /* renamed from: b */
    private CheckBox f2022b;

    /* renamed from: c */
    private String f2023c;

    public ViewOnClickListenerC0589f(ViewOnClickListenerC0603t viewOnClickListenerC0603t, CheckBox checkBox, String str) {
        this.f2021a = viewOnClickListenerC0603t;
        this.f2022b = checkBox;
        this.f2023c = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String string;
        CheckBox checkBox = (CheckBox) view;
        Boolean boolValueOf = Boolean.valueOf(checkBox.isChecked());
        long j = 0;
        long j2 = 0;
        for (int i = 0; i < this.f2021a.f2080t.getAdapter().getCount(); i++) {
            Cursor cursor = (Cursor) this.f2021a.f2080t.getAdapter().getItem(i);
            Long lValueOf = Long.valueOf(cursor.getLong(cursor.getColumnIndex("message_time")));
            EnumC0651d enumC0651dM2976a = EnumC0651d.m2976a(cursor.getInt(cursor.getColumnIndex("message_content_type")));
            String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(lValueOf).split(" ");
            if (enumC0651dM2976a != EnumC0651d.SYSTEM && this.f2023c.equals(strArrSplit[0]) && (string = cursor.getString(cursor.getColumnIndex("message_sender"))) != null) {
                if (string.equals(C1323bs.m4575a().getString("msisdn", ""))) {
                    j2++;
                    this.f2021a.f2048C.put(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))), boolValueOf);
                } else {
                    j++;
                    this.f2021a.f2049D.put(Long.valueOf(Long.valueOf(cursor.getString(cursor.getColumnIndex("message_sever_id"))).longValue()), boolValueOf);
                }
            }
        }
        long j3 = this.f2021a.f2051F + this.f2021a.f2050E;
        long j4 = j2 + j;
        if (boolValueOf.booleanValue()) {
            if (!this.f2021a.f2073l.contains(this.f2023c)) {
                this.f2021a.f2073l.add(this.f2023c);
            }
            if (j3 == j4) {
                this.f2021a.f2054I = EnumC0542ar.SELECT_ALL;
                this.f2021a.f2056K = EnumC0542ar.SELECT_NONE;
                this.f2021a.f2055J = EnumC0542ar.SELECT_NONE;
            } else if (this.f2021a.f2051F == j) {
                this.f2021a.f2054I = EnumC0542ar.SELECT_NONE;
                this.f2021a.f2056K = EnumC0542ar.SELECT_ALL;
                this.f2021a.f2055J = EnumC0542ar.SELECT_NONE;
            } else if (this.f2021a.f2050E == j2) {
                this.f2021a.f2054I = EnumC0542ar.SELECT_NONE;
                this.f2021a.f2056K = EnumC0542ar.SELECT_NONE;
                this.f2021a.f2055J = EnumC0542ar.SELECT_ALL;
            } else {
                if (this.f2021a.f2054I == EnumC0542ar.SELECT_ALL || this.f2021a.f2054I == EnumC0542ar.SELECT_PART) {
                    this.f2021a.f2054I = EnumC0542ar.SELECT_PART;
                } else {
                    this.f2021a.f2054I = EnumC0542ar.SELECT_NONE;
                }
                if (this.f2021a.f2056K == EnumC0542ar.SELECT_ALL || this.f2021a.f2056K == EnumC0542ar.SELECT_PART) {
                    this.f2021a.f2056K = EnumC0542ar.SELECT_PART;
                } else {
                    this.f2021a.f2056K = EnumC0542ar.SELECT_NONE;
                }
                if (this.f2021a.f2055J == EnumC0542ar.SELECT_ALL || this.f2021a.f2055J == EnumC0542ar.SELECT_PART) {
                    this.f2021a.f2055J = EnumC0542ar.SELECT_PART;
                } else {
                    this.f2021a.f2055J = EnumC0542ar.SELECT_NONE;
                }
            }
        } else {
            if (this.f2021a.f2073l.contains(this.f2023c)) {
                this.f2021a.f2073l.remove(this.f2023c);
            }
            if (j3 == j4) {
                this.f2021a.f2054I = EnumC0542ar.SELECT_NONE;
                this.f2021a.f2056K = EnumC0542ar.SELECT_NONE;
                this.f2021a.f2055J = EnumC0542ar.SELECT_NONE;
            } else if (this.f2021a.f2051F == j) {
                this.f2021a.f2054I = EnumC0542ar.SELECT_NONE;
                this.f2021a.f2056K = EnumC0542ar.SELECT_NONE;
                this.f2021a.f2055J = EnumC0542ar.SELECT_NONE;
            } else if (this.f2021a.f2050E == j2) {
                this.f2021a.f2054I = EnumC0542ar.SELECT_NONE;
                this.f2021a.f2056K = EnumC0542ar.SELECT_NONE;
                this.f2021a.f2055J = EnumC0542ar.SELECT_NONE;
            } else {
                if (this.f2021a.f2054I == EnumC0542ar.SELECT_ALL || this.f2021a.f2054I == EnumC0542ar.SELECT_PART) {
                    this.f2021a.f2054I = EnumC0542ar.SELECT_PART;
                } else {
                    this.f2021a.f2054I = EnumC0542ar.SELECT_NONE;
                }
                if (this.f2021a.f2056K == EnumC0542ar.SELECT_ALL || this.f2021a.f2056K == EnumC0542ar.SELECT_PART) {
                    this.f2021a.f2056K = EnumC0542ar.SELECT_PART;
                } else {
                    this.f2021a.f2056K = EnumC0542ar.SELECT_NONE;
                }
                if (this.f2021a.f2055J == EnumC0542ar.SELECT_ALL || this.f2021a.f2055J == EnumC0542ar.SELECT_PART) {
                    this.f2021a.f2055J = EnumC0542ar.SELECT_PART;
                } else {
                    this.f2021a.f2055J = EnumC0542ar.SELECT_NONE;
                }
            }
        }
        checkBox.setChecked(boolValueOf.booleanValue());
        this.f2021a.f2080t.invalidateViews();
    }
}
