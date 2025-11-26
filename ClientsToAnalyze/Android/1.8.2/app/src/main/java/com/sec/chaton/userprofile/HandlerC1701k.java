package com.sec.chaton.userprofile;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.memo.C0837a;
import com.sec.chaton.memo.C0839c;
import com.sec.chaton.p007a.p008a.C0101b;
import com.sec.chaton.p017e.p018a.C0663g;
import com.sec.chaton.p017e.p018a.C0664h;
import com.sec.chaton.p022h.EnumC0803m;
import com.sec.chaton.util.C1786r;

/* compiled from: MyPageBuddiesSay.java */
/* renamed from: com.sec.chaton.userprofile.k */
/* loaded from: classes.dex */
class HandlerC1701k extends Handler {

    /* renamed from: a */
    final /* synthetic */ MyPageBuddiesSay f6212a;

    HandlerC1701k(MyPageBuddiesSay myPageBuddiesSay) {
        this.f6212a = myPageBuddiesSay;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        switch (message.what) {
            case 901:
            case 902:
                if (this.f6212a.getActivity() != null) {
                    if (this.f6212a.f5804k != null) {
                        this.f6212a.f5804k.dismiss();
                    }
                    if (this.f6212a.f5805l != null) {
                        this.f6212a.f5805l.setVisibility(8);
                    }
                    C0101b c0101b = (C0101b) message.obj;
                    if (!c0101b.m664a() || c0101b.m665b() == EnumC0803m.ERROR) {
                        if (this.f6212a.f5804k != null) {
                            this.f6212a.f5804k.dismiss();
                        }
                        if (this.f6212a.f5805l != null) {
                            this.f6212a.f5805l.setVisibility(8);
                        }
                        this.f6212a.f5806m.setText(String.format(GlobalApplication.m3260b().getString(R.string.layout_msgbox_no_memo), this.f6212a.f5800g));
                        this.f6212a.f5806m.setVisibility(0);
                        ((LinearLayout) this.f6212a.f5797d.findViewById(R.id.mypage_write_area)).setVisibility(8);
                        Toast.makeText(this.f6212a.getActivity(), this.f6212a.getResources().getString(R.string.trunk_network_not_available), 0).show();
                        this.f6212a.f5803j.clear();
                        if (this.f6212a.getListAdapter() != null) {
                            ((C0837a) this.f6212a.getListAdapter()).notifyDataSetChanged();
                        }
                    } else {
                        ContentResolver contentResolver = this.f6212a.getActivity().getContentResolver();
                        Cursor cursorM3037a = C0663g.m3037a(contentResolver, this.f6212a.f5799f);
                        C1786r.m6066e("Memo list count: " + this.f6212a.f5799f + ", " + cursorM3037a.getCount(), MyPageBuddiesSay.f5794a);
                        this.f6212a.f5803j.clear();
                        this.f6212a.f5806m.setVisibility(8);
                        ((LinearLayout) this.f6212a.f5797d.findViewById(R.id.mypage_write_area)).setVisibility(8);
                        if (GlobalApplication.m3265f()) {
                            ((TextView) this.f6212a.f5797d.findViewById(R.id.buddy_say_participants)).setText("(" + cursorM3037a.getCount() + ")");
                        }
                        if (cursorM3037a.getCount() == 0) {
                            if (GlobalApplication.m3265f()) {
                                this.f6212a.f5806m.setVisibility(8);
                                this.f6212a.f5807n.setVisibility(0);
                                ((TextView) this.f6212a.f5807n.findViewById(R.id.msg_no_item_text)).setText(String.format(GlobalApplication.m3260b().getString(R.string.layout_msgbox_no_memo), this.f6212a.f5800g));
                            } else {
                                this.f6212a.f5807n.setVisibility(8);
                                this.f6212a.f5806m.setVisibility(0);
                            }
                            if (this.f6212a.getListAdapter() != null) {
                                ((C0837a) this.f6212a.getListAdapter()).notifyDataSetChanged();
                            }
                        } else {
                            if (GlobalApplication.m3265f()) {
                                this.f6212a.f5807n.setVisibility(8);
                            }
                            while (cursorM3037a.moveToNext()) {
                                this.f6212a.f5803j.add(new C0839c(cursorM3037a.getString(cursorM3037a.getColumnIndex("buddy_no")), cursorM3037a.getString(cursorM3037a.getColumnIndex("buddy_name")), cursorM3037a.getString(cursorM3037a.getColumnIndex("memo")), cursorM3037a.getString(cursorM3037a.getColumnIndex("timestamp"))));
                                this.f6212a.f5806m.setVisibility(8);
                            }
                            cursorM3037a.close();
                            Cursor cursorM3038a = C0664h.m3038a(contentResolver, this.f6212a.f5799f);
                            while (cursorM3038a.moveToNext()) {
                                this.f6212a.f5801h = cursorM3038a.getString(cursorM3038a.getColumnIndex("buddy_name"));
                                this.f6212a.f5802i = cursorM3038a.getString(cursorM3038a.getColumnIndex("endtime"));
                            }
                            cursorM3038a.close();
                            if (this.f6212a.f5801h == null || !this.f6212a.f5801h.equals("true")) {
                                this.f6212a.f5805l.setVisibility(8);
                            } else {
                                this.f6212a.f5805l.setVisibility(0);
                            }
                            if (this.f6212a.getListAdapter() == null) {
                                this.f6212a.setListAdapter(new C0837a(this.f6212a.getListView(), this.f6212a.getActivity(), this.f6212a.f5803j, R.layout.memo_adapter_item));
                            } else {
                                ((C0837a) this.f6212a.getListAdapter()).notifyDataSetChanged();
                            }
                        }
                    }
                    this.f6212a.f5808o = false;
                    break;
                }
                break;
            case 904:
                if (this.f6212a.getActivity() != null) {
                    C0101b c0101b2 = (C0101b) message.obj;
                    if (!c0101b2.m664a() || c0101b2.m665b() == EnumC0803m.ERROR) {
                        if (this.f6212a.f5804k != null) {
                            this.f6212a.f5804k.dismiss();
                        }
                        Toast.makeText(this.f6212a.getActivity(), this.f6212a.getResources().getString(R.string.trunk_network_not_available), 0).show();
                        break;
                    } else {
                        this.f6212a.f5808o = true;
                        this.f6212a.f5796c.m2897a(this.f6212a.f5799f);
                        break;
                    }
                }
                break;
        }
    }
}
