package com.sec.chaton.chat;

import android.database.Cursor;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1323bs;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bh */
/* loaded from: classes.dex */
class ViewOnClickListenerC0568bh implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f1980a;

    ViewOnClickListenerC0568bh(ChatFragment chatFragment) {
        this.f1980a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean.valueOf(true);
        Boolean bool4 = false;
        int count = this.f1980a.f1794ad.getAdapter().getCount();
        switch (view.getId()) {
            case R.id.btnRangeAll /* 2131427611 */:
                if (this.f1980a.f1795ae.m2827e() == EnumC0542ar.SELECT_NONE || this.f1980a.f1795ae.m2827e() == EnumC0542ar.SELECT_PART) {
                    this.f1980a.f1795ae.m2817a(EnumC0542ar.SELECT_ALL);
                    bool3 = true;
                } else {
                    this.f1980a.f1795ae.m2817a(EnumC0542ar.SELECT_NONE);
                    bool3 = false;
                }
                this.f1980a.f1795ae.m2825c(EnumC0542ar.SELECT_NONE);
                this.f1980a.f1795ae.m2823b(EnumC0542ar.SELECT_NONE);
                this.f1980a.f1795ae.m2826d();
                for (int i = 0; i < count; i++) {
                    Cursor cursor = (Cursor) this.f1980a.f1794ad.getAdapter().getItem(i);
                    String string = cursor.getString(cursor.getColumnIndex("message_sender"));
                    if (string != null) {
                        if (string.equals(C1323bs.m4575a().getString("msisdn", ""))) {
                            this.f1980a.f1795ae.m2812a(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))), bool3);
                        } else {
                            this.f1980a.f1795ae.m2820b(Long.valueOf(Long.valueOf(cursor.getString(cursor.getColumnIndex("message_sever_id"))).longValue()), bool3);
                        }
                    }
                }
                this.f1980a.f1763X.setEnabled(bool3.booleanValue());
                this.f1980a.f1794ad.invalidateViews();
                break;
            case R.id.btnRangeRcv /* 2131427612 */:
                if (this.f1980a.f1795ae.m2829g() == EnumC0542ar.SELECT_NONE || this.f1980a.f1795ae.m2829g() == EnumC0542ar.SELECT_PART) {
                    this.f1980a.f1795ae.m2825c(EnumC0542ar.SELECT_ALL);
                    bool2 = true;
                } else {
                    this.f1980a.f1795ae.m2825c(EnumC0542ar.SELECT_NONE);
                    bool2 = false;
                }
                this.f1980a.f1795ae.m2817a(EnumC0542ar.SELECT_NONE);
                this.f1980a.f1795ae.m2823b(EnumC0542ar.SELECT_NONE);
                for (int i2 = 0; i2 < count; i2++) {
                    Cursor cursor2 = (Cursor) this.f1980a.f1794ad.getAdapter().getItem(i2);
                    String string2 = cursor2.getString(cursor2.getColumnIndex("message_sender"));
                    if (string2 != null) {
                        if (!string2.equals(C1323bs.m4575a().getString("msisdn", ""))) {
                            this.f1980a.f1795ae.m2820b(Long.valueOf(Long.valueOf(cursor2.getString(cursor2.getColumnIndex("message_sever_id"))).longValue()), bool2);
                            bool4 = bool2.booleanValue() ? true : bool4;
                        } else {
                            this.f1980a.f1795ae.m2812a(Long.valueOf(cursor2.getLong(cursor2.getColumnIndex("_id"))), (Boolean) false);
                        }
                    }
                }
                this.f1980a.f1763X.setEnabled(bool4.booleanValue());
                this.f1980a.f1794ad.invalidateViews();
                break;
            case R.id.btnRangeSnt /* 2131427613 */:
                if (this.f1980a.f1795ae.m2828f() == EnumC0542ar.SELECT_NONE || this.f1980a.f1795ae.m2828f() == EnumC0542ar.SELECT_PART) {
                    this.f1980a.f1795ae.m2823b(EnumC0542ar.SELECT_ALL);
                    bool = true;
                } else {
                    this.f1980a.f1795ae.m2823b(EnumC0542ar.SELECT_NONE);
                    bool = false;
                }
                this.f1980a.f1795ae.m2817a(EnumC0542ar.SELECT_NONE);
                this.f1980a.f1795ae.m2825c(EnumC0542ar.SELECT_NONE);
                for (int i3 = 0; i3 < count; i3++) {
                    Cursor cursor3 = (Cursor) this.f1980a.f1794ad.getAdapter().getItem(i3);
                    String string3 = cursor3.getString(cursor3.getColumnIndex("message_sender"));
                    if (string3 != null) {
                        if (string3.equals(C1323bs.m4575a().getString("msisdn", ""))) {
                            this.f1980a.f1795ae.m2812a(Long.valueOf(cursor3.getLong(cursor3.getColumnIndex("_id"))), bool);
                            bool4 = bool.booleanValue() ? true : bool4;
                        } else {
                            this.f1980a.f1795ae.m2820b(Long.valueOf(Long.valueOf(cursor3.getString(cursor3.getColumnIndex("message_sever_id"))).longValue()), (Boolean) false);
                        }
                    }
                }
                this.f1980a.f1763X.setEnabled(bool4.booleanValue());
                this.f1980a.f1794ad.invalidateViews();
                break;
        }
    }
}
