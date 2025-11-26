package com.sec.chaton.userprofile;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.memo.C0837a;
import com.sec.chaton.memo.C0839c;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p007a.p008a.C0105f;
import com.sec.chaton.p017e.p018a.C0663g;
import com.sec.chaton.p017e.p018a.C0664h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1746bb;
import com.sec.chaton.util.C1786r;
import twitter4j.internal.http.HttpResponseCode;

/* compiled from: MyPageFragment.java */
/* renamed from: com.sec.chaton.userprofile.m */
/* loaded from: classes.dex */
class HandlerC1703m extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyPageFragment f6214a;

    HandlerC1703m(MyPageFragment myPageFragment) {
        this.f6214a = myPageFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 402:
                if (this.f6214a.f5855v != null && this.f6214a.f5855v.isShowing()) {
                    this.f6214a.f5855v.dismiss();
                }
                if (((C0105f) message.obj).f333a) {
                    this.f6214a.m5602i();
                    break;
                } else {
                    Toast.makeText(this.f6214a.getActivity(), R.string.toast_setting_profile_image_save_failed, 0).show();
                    break;
                }
                break;
            case HttpResponseCode.FORBIDDEN /* 403 */:
                if (this.f6214a.f5855v != null && this.f6214a.f5855v.isShowing()) {
                    this.f6214a.f5855v.dismiss();
                }
                C0101b c0101b = (C0101b) message.obj;
                if (c0101b.m664a() && c0101b.m664a()) {
                    this.f6214a.f5847n.setImageBitmap(C1746bb.m5940a(this.f6214a.f5820H, R.drawable.co_default_image_add));
                    break;
                } else {
                    Toast.makeText(this.f6214a.getActivity(), R.string.toast_setting_profile_image_save_failed, 0).show();
                    break;
                }
                break;
            case 901:
            case 902:
                if (this.f6214a.getActivity() != null) {
                    if (this.f6214a.f5832T != null) {
                        this.f6214a.f5832T.dismiss();
                    }
                    if (this.f6214a.f5827O != null) {
                        this.f6214a.f5827O.setVisibility(8);
                    }
                    C0101b c0101b2 = (C0101b) message.obj;
                    if (!c0101b2.m664a() || c0101b2.m665b() == EnumC0803m.ERROR) {
                        if (this.f6214a.f5832T != null) {
                            this.f6214a.f5832T.dismiss();
                        }
                        if (this.f6214a.f5827O != null) {
                            this.f6214a.f5827O.setVisibility(8);
                        }
                        this.f6214a.f5828P.setVisibility(0);
                        ((LinearLayout) this.f6214a.f5825M.findViewById(R.id.mypage_write_area)).setVisibility(8);
                        Toast.makeText(this.f6214a.getActivity(), this.f6214a.getResources().getString(R.string.toast_network_unable), 0).show();
                        this.f6214a.f5823K.clear();
                        if (this.f6214a.f5821I != null) {
                            this.f6214a.f5821I.notifyDataSetChanged();
                        }
                    } else {
                        ContentResolver contentResolver = this.f6214a.getActivity().getContentResolver();
                        Cursor cursorM3037a = C0663g.m3037a(contentResolver, this.f6214a.f5859z);
                        C1786r.m6066e("Memo list count: " + this.f6214a.f5859z + ", " + cursorM3037a.getCount(), MyPageFragment.f5812a);
                        this.f6214a.f5823K.clear();
                        this.f6214a.f5828P.setVisibility(8);
                        ((LinearLayout) this.f6214a.f5825M.findViewById(R.id.mypage_write_area)).setVisibility(8);
                        if (cursorM3037a.getCount() == 0) {
                            this.f6214a.f5827O.setVisibility(8);
                            this.f6214a.f5828P.setVisibility(0);
                            if (this.f6214a.f5821I != null) {
                                this.f6214a.f5821I.notifyDataSetChanged();
                            }
                        } else {
                            while (cursorM3037a.moveToNext()) {
                                this.f6214a.f5823K.add(new C0839c(cursorM3037a.getString(cursorM3037a.getColumnIndex("buddy_no")), cursorM3037a.getString(cursorM3037a.getColumnIndex("buddy_name")), cursorM3037a.getString(cursorM3037a.getColumnIndex("memo")), cursorM3037a.getString(cursorM3037a.getColumnIndex("timestamp"))));
                                this.f6214a.f5828P.setVisibility(8);
                            }
                            cursorM3037a.close();
                            Cursor cursorM3038a = C0664h.m3038a(contentResolver, this.f6214a.f5859z);
                            while (cursorM3038a.moveToNext()) {
                                this.f6214a.f5829Q = cursorM3038a.getString(cursorM3038a.getColumnIndex("buddy_name"));
                                this.f6214a.f5830R = cursorM3038a.getString(cursorM3038a.getColumnIndex("endtime"));
                            }
                            cursorM3038a.close();
                            if (this.f6214a.f5829Q == null || !this.f6214a.f5829Q.equals("true")) {
                                this.f6214a.f5827O.setVisibility(8);
                            } else {
                                this.f6214a.f5827O.setVisibility(0);
                            }
                            if (this.f6214a.f5821I != null) {
                                this.f6214a.f5821I.notifyDataSetChanged();
                            } else {
                                this.f6214a.f5821I = new C0837a(this.f6214a.f5822J, this.f6214a.f5820H, this.f6214a.f5823K, R.layout.memo_adapter_item);
                                this.f6214a.f5822J.setAdapter((ListAdapter) this.f6214a.f5821I);
                            }
                        }
                    }
                    this.f6214a.f5831S = false;
                    break;
                }
                break;
            case 904:
                if (this.f6214a.getActivity() != null) {
                    C0101b c0101b3 = (C0101b) message.obj;
                    if (!c0101b3.m664a() || c0101b3.m665b() == EnumC0803m.ERROR) {
                        if (this.f6214a.f5832T != null) {
                            this.f6214a.f5832T.dismiss();
                        }
                        Toast.makeText(this.f6214a.getActivity(), this.f6214a.getResources().getString(R.string.toast_network_unable), 0).show();
                        break;
                    } else {
                        this.f6214a.f5831S = true;
                        this.f6214a.f5824L.m2897a(this.f6214a.f5859z);
                        break;
                    }
                }
                break;
        }
    }
}
