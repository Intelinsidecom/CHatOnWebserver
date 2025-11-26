package com.sec.chaton.chat;

import android.database.Cursor;
import android.view.View;
import com.sec.chaton.R;
import com.sec.chaton.util.C1789u;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.r */
/* loaded from: classes.dex */
class ViewOnClickListenerC0512r implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2122a;

    ViewOnClickListenerC0512r(ChatFragment chatFragment) {
        this.f2122a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean.valueOf(true);
        Boolean bool4 = false;
        int count = this.f2122a.f1827ap.getAdapter().getCount();
        switch (view.getId()) {
            case R.id.btnRangeAll /* 2131493229 */:
                if (this.f2122a.f1828aq.m2674d() == EnumC0487ba.SELECT_NONE || this.f2122a.f1828aq.m2674d() == EnumC0487ba.SELECT_PART) {
                    this.f2122a.f1828aq.m2664a(EnumC0487ba.SELECT_ALL);
                    bool3 = true;
                } else {
                    this.f2122a.f1828aq.m2664a(EnumC0487ba.SELECT_NONE);
                    bool3 = false;
                }
                this.f2122a.f1828aq.m2673c(EnumC0487ba.SELECT_NONE);
                this.f2122a.f1828aq.m2671b(EnumC0487ba.SELECT_NONE);
                this.f2122a.f1828aq.m2672c();
                for (int i = 0; i < count; i++) {
                    Cursor cursor = (Cursor) this.f2122a.f1827ap.getAdapter().getItem(i);
                    String string = cursor.getString(cursor.getColumnIndex("message_sender"));
                    if (string != null) {
                        if (string.equals(C1789u.m6075a().getString("msisdn", ""))) {
                            this.f2122a.f1828aq.m2660a(Long.valueOf(cursor.getLong(cursor.getColumnIndex("_id"))), bool3);
                        } else {
                            this.f2122a.f1828aq.m2668b(Long.valueOf(Long.valueOf(cursor.getString(cursor.getColumnIndex("message_sever_id"))).longValue()), bool3);
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                this.f2122a.f1821aj.setEnabled(bool3.booleanValue());
                this.f2122a.f1827ap.invalidateViews();
                break;
            case R.id.btnRangeRcv /* 2131493230 */:
                if (this.f2122a.f1828aq.m2676f() == EnumC0487ba.SELECT_NONE || this.f2122a.f1828aq.m2676f() == EnumC0487ba.SELECT_PART) {
                    this.f2122a.f1828aq.m2673c(EnumC0487ba.SELECT_ALL);
                    bool2 = true;
                } else {
                    this.f2122a.f1828aq.m2673c(EnumC0487ba.SELECT_NONE);
                    bool2 = false;
                }
                this.f2122a.f1828aq.m2664a(EnumC0487ba.SELECT_NONE);
                this.f2122a.f1828aq.m2671b(EnumC0487ba.SELECT_NONE);
                for (int i2 = 0; i2 < count; i2++) {
                    Cursor cursor2 = (Cursor) this.f2122a.f1827ap.getAdapter().getItem(i2);
                    String string2 = cursor2.getString(cursor2.getColumnIndex("message_sender"));
                    if (string2 != null) {
                        if (!string2.equals(C1789u.m6075a().getString("msisdn", ""))) {
                            this.f2122a.f1828aq.m2668b(Long.valueOf(Long.valueOf(cursor2.getString(cursor2.getColumnIndex("message_sever_id"))).longValue()), bool2);
                            if (bool2.booleanValue()) {
                                bool4 = true;
                            }
                        } else {
                            this.f2122a.f1828aq.m2660a(Long.valueOf(cursor2.getLong(cursor2.getColumnIndex("_id"))), (Boolean) false);
                        }
                    }
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                }
                this.f2122a.f1821aj.setEnabled(bool4.booleanValue());
                this.f2122a.f1827ap.invalidateViews();
                break;
            case R.id.btnRangeSnt /* 2131493231 */:
                if (this.f2122a.f1828aq.m2675e() == EnumC0487ba.SELECT_NONE || this.f2122a.f1828aq.m2675e() == EnumC0487ba.SELECT_PART) {
                    this.f2122a.f1828aq.m2671b(EnumC0487ba.SELECT_ALL);
                    bool = true;
                } else {
                    this.f2122a.f1828aq.m2671b(EnumC0487ba.SELECT_NONE);
                    bool = false;
                }
                this.f2122a.f1828aq.m2664a(EnumC0487ba.SELECT_NONE);
                this.f2122a.f1828aq.m2673c(EnumC0487ba.SELECT_NONE);
                for (int i3 = 0; i3 < count; i3++) {
                    Cursor cursor3 = (Cursor) this.f2122a.f1827ap.getAdapter().getItem(i3);
                    String string3 = cursor3.getString(cursor3.getColumnIndex("message_sender"));
                    if (string3 != null) {
                        if (string3.equals(C1789u.m6075a().getString("msisdn", ""))) {
                            this.f2122a.f1828aq.m2660a(Long.valueOf(cursor3.getLong(cursor3.getColumnIndex("_id"))), bool);
                            if (bool.booleanValue()) {
                                bool4 = true;
                            }
                        } else {
                            this.f2122a.f1828aq.m2668b(Long.valueOf(Long.valueOf(cursor3.getString(cursor3.getColumnIndex("message_sever_id"))).longValue()), (Boolean) false);
                        }
                    }
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                }
                this.f2122a.f1821aj.setEnabled(bool4.booleanValue());
                this.f2122a.f1827ap.invalidateViews();
                break;
        }
    }
}
