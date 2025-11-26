package com.sec.chaton.userprofile;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.memo.C0729b;
import com.sec.chaton.memo.C0734g;
import com.sec.chaton.p015b.p016a.C0254b;
import com.sec.chaton.p015b.p016a.C0259g;
import com.sec.chaton.p018c.EnumC0518y;
import com.sec.chaton.p025d.p026a.C0623c;
import com.sec.chaton.p025d.p026a.C0632l;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.util.C1348w;
import com.sec.widget.C1619g;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.av */
/* loaded from: classes.dex */
class HandlerC1225av extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f4304a;

    HandlerC1225av(MyPageFragment myPageFragment) {
        this.f4304a = myPageFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f4304a.getActivity() != null) {
            switch (message.what) {
                case 402:
                    if (this.f4304a.f4105C != null && this.f4304a.f4105C.isShowing()) {
                        this.f4304a.f4105C.dismiss();
                    }
                    if (((C0254b) message.obj).f604a) {
                        this.f4304a.m4314k();
                        break;
                    } else {
                        C1619g.m5888a(this.f4304a.getActivity(), R.string.toast_setting_profile_image_save_failed, 0).show();
                        break;
                    }
                    break;
                case 403:
                    if (this.f4304a.f4105C != null && this.f4304a.f4105C.isShowing()) {
                        this.f4304a.f4105C.dismiss();
                    }
                    C0259g c0259g = (C0259g) message.obj;
                    if (c0259g.m927a() && c0259g.m927a()) {
                        this.f4304a.f4158t.setImageBitmap(C1348w.m4680a(this.f4304a.f4116N, R.drawable.propile_default_image));
                        break;
                    } else {
                        C1619g.m5888a(this.f4304a.getActivity(), R.string.toast_setting_profile_image_save_failed, 0).show();
                        break;
                    }
                    break;
                case 901:
                case 902:
                    if (this.f4304a.getActivity() != null) {
                        if (this.f4304a.f4132ad != null) {
                            this.f4304a.f4132ad.dismiss();
                        }
                        if (this.f4304a.f4127Y != null) {
                            this.f4304a.f4127Y.setVisibility(8);
                        }
                        C0259g c0259g2 = (C0259g) message.obj;
                        if (!c0259g2.m927a() || c0259g2.m928b() == EnumC0518y.ERROR) {
                            if (this.f4304a.f4132ad != null) {
                                this.f4304a.f4132ad.dismiss();
                            }
                            if (this.f4304a.f4127Y != null) {
                                this.f4304a.f4127Y.setVisibility(8);
                            }
                            this.f4304a.f4128Z.setVisibility(0);
                            C1619g.m5889a(this.f4304a.getActivity(), this.f4304a.getResources().getString(R.string.popup_no_network_connection), 0).show();
                            this.f4304a.f4119Q.clear();
                            if (this.f4304a.f4117O != null) {
                                this.f4304a.f4117O.notifyDataSetChanged();
                            }
                        } else {
                            ContentResolver contentResolver = this.f4304a.getActivity().getContentResolver();
                            Cursor cursorM2853a = C0623c.m2853a(contentResolver, this.f4304a.f4110H);
                            if (cursorM2853a != null) {
                                C1341p.m4662e("Memo list count: " + this.f4304a.f4110H + ", " + cursorM2853a.getCount(), MyPageFragment.f4102a);
                                this.f4304a.f4119Q.clear();
                                this.f4304a.f4128Z.setVisibility(8);
                                if (cursorM2853a.getCount() == 0) {
                                    this.f4304a.f4127Y.setVisibility(8);
                                    this.f4304a.f4128Z.setVisibility(0);
                                    if (this.f4304a.f4117O != null) {
                                        this.f4304a.f4117O.notifyDataSetChanged();
                                    }
                                    cursorM2853a.close();
                                } else {
                                    while (cursorM2853a.moveToNext()) {
                                        this.f4304a.f4119Q.add(new C0734g(cursorM2853a.getString(cursorM2853a.getColumnIndex("buddy_no")), cursorM2853a.getString(cursorM2853a.getColumnIndex("buddy_name")), cursorM2853a.getString(cursorM2853a.getColumnIndex("memo")), cursorM2853a.getString(cursorM2853a.getColumnIndex("timestamp"))));
                                        this.f4304a.f4128Z.setVisibility(8);
                                    }
                                    cursorM2853a.close();
                                    Cursor cursorM2876a = C0632l.m2876a(contentResolver, this.f4304a.f4110H);
                                    if (cursorM2876a != null) {
                                        while (cursorM2876a.moveToNext()) {
                                            this.f4304a.f4129aa = cursorM2876a.getString(cursorM2876a.getColumnIndex("buddy_name"));
                                            this.f4304a.f4130ab = cursorM2876a.getString(cursorM2876a.getColumnIndex("endtime"));
                                        }
                                        cursorM2876a.close();
                                    }
                                    if (this.f4304a.f4129aa == null || !this.f4304a.f4129aa.equals("true")) {
                                        this.f4304a.f4127Y.setVisibility(8);
                                    } else {
                                        this.f4304a.f4127Y.setVisibility(0);
                                    }
                                    if (this.f4304a.f4117O != null) {
                                        this.f4304a.f4117O.notifyDataSetChanged();
                                    } else {
                                        this.f4304a.f4117O = new C0729b(this.f4304a.f4118P, this.f4304a.f4116N, this.f4304a.f4119Q, R.layout.memo_adapter_item);
                                        this.f4304a.f4118P.setAdapter((ListAdapter) this.f4304a.f4117O);
                                    }
                                }
                            }
                        }
                        this.f4304a.f4131ac = false;
                        break;
                    }
                    break;
                case 904:
                    if (this.f4304a.getActivity() != null) {
                        C0259g c0259g3 = (C0259g) message.obj;
                        if (!c0259g3.m927a() || c0259g3.m928b() == EnumC0518y.ERROR) {
                            if (this.f4304a.f4132ad != null) {
                                this.f4304a.f4132ad.dismiss();
                            }
                            C1619g.m5889a(this.f4304a.getActivity(), this.f4304a.getResources().getString(R.string.popup_no_network_connection), 0).show();
                            break;
                        } else {
                            this.f4304a.f4131ac = true;
                            this.f4304a.f4120R.m864a(this.f4304a.f4110H);
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
