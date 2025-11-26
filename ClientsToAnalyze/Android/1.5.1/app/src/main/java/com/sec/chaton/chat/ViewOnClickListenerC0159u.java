package com.sec.chaton.chat;

import android.database.Cursor;
import android.util.SparseBooleanArray;
import android.view.View;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONPref;

/* renamed from: com.sec.chaton.chat.u */
/* loaded from: classes.dex */
class ViewOnClickListenerC0159u implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f981a;

    ViewOnClickListenerC0159u(ChatFragment chatFragment) {
        this.f981a = chatFragment;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        SparseBooleanArray checkedItemPositions = this.f981a.f755Y.getCheckedItemPositions();
        Boolean bool4 = true;
        switch (view.getId()) {
            case C0062R.id.btnRangeAll /* 2131427576 */:
                if (checkedItemPositions.size() != 0) {
                    Boolean bool5 = bool4;
                    int i = 0;
                    while (true) {
                        if (i >= this.f981a.f755Y.getAdapter().getCount()) {
                            bool3 = bool5;
                        } else if (checkedItemPositions.get(i)) {
                            bool5 = false;
                            i++;
                        } else {
                            bool3 = true;
                        }
                    }
                } else {
                    bool3 = bool4;
                }
                for (int i2 = 0; i2 < this.f981a.f755Y.getAdapter().getCount(); i2++) {
                    this.f981a.f755Y.setItemChecked(i2, bool3.booleanValue());
                }
                break;
            case C0062R.id.btnRangeRcv /* 2131427577 */:
                if (checkedItemPositions.size() != 0) {
                    int i3 = 0;
                    while (true) {
                        Boolean bool6 = bool4;
                        if (i3 < this.f981a.f755Y.getAdapter().getCount()) {
                            Cursor cursor = (Cursor) this.f981a.f755Y.getAdapter().getItem(i3);
                            String string = cursor.getString(cursor.getColumnIndex("message_sender"));
                            if (string == null) {
                                bool4 = bool6;
                            } else if (string.equals(ChatONPref.m3519a().getString("msisdn", ""))) {
                                if (checkedItemPositions.get(i3)) {
                                    bool2 = true;
                                } else {
                                    bool4 = false;
                                }
                            } else if (checkedItemPositions.get(i3)) {
                                bool4 = false;
                            } else {
                                bool2 = true;
                            }
                            i3++;
                        } else {
                            bool2 = bool6;
                        }
                    }
                } else {
                    bool2 = bool4;
                }
                for (int i4 = 0; i4 < this.f981a.f755Y.getAdapter().getCount(); i4++) {
                    Cursor cursor2 = (Cursor) this.f981a.f755Y.getAdapter().getItem(i4);
                    String string2 = cursor2.getString(cursor2.getColumnIndex("message_sender"));
                    if (string2 != null) {
                        if (string2.equals(ChatONPref.m3519a().getString("msisdn", ""))) {
                            this.f981a.f755Y.setItemChecked(i4, false);
                        } else {
                            this.f981a.f755Y.setItemChecked(i4, bool2.booleanValue());
                        }
                    }
                }
                break;
            case C0062R.id.btnRangeSnt /* 2131427578 */:
                if (checkedItemPositions.size() != 0) {
                    int i5 = 0;
                    while (true) {
                        Boolean bool7 = bool4;
                        if (i5 < this.f981a.f755Y.getAdapter().getCount()) {
                            Cursor cursor3 = (Cursor) this.f981a.f755Y.getAdapter().getItem(i5);
                            String string3 = cursor3.getString(cursor3.getColumnIndex("message_sender"));
                            if (string3 == null) {
                                bool4 = bool7;
                            } else if (string3.equals(ChatONPref.m3519a().getString("msisdn", ""))) {
                                if (checkedItemPositions.get(i5)) {
                                    bool4 = false;
                                } else {
                                    bool = true;
                                }
                            } else if (checkedItemPositions.get(i5)) {
                                bool = true;
                            } else {
                                bool4 = false;
                            }
                            i5++;
                        } else {
                            bool = bool7;
                        }
                    }
                } else {
                    bool = bool4;
                }
                for (int i6 = 0; i6 < this.f981a.f755Y.getAdapter().getCount(); i6++) {
                    Cursor cursor4 = (Cursor) this.f981a.f755Y.getAdapter().getItem(i6);
                    String string4 = cursor4.getString(cursor4.getColumnIndex("message_sender"));
                    if (string4 != null) {
                        if (string4.equals(ChatONPref.m3519a().getString("msisdn", ""))) {
                            this.f981a.f755Y.setItemChecked(i6, bool.booleanValue());
                        } else {
                            this.f981a.f755Y.setItemChecked(i6, false);
                        }
                    }
                }
                break;
        }
    }
}
