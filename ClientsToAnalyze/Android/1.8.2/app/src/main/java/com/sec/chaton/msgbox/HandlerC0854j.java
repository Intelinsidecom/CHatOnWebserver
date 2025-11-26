package com.sec.chaton.msgbox;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;
import com.sec.chaton.HomeTabletFragment;
import com.sec.chaton.R;
import com.sec.chaton.chat.C0493bg;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p007a.p008a.EnumC0104e;
import com.sec.chaton.trunk.database.p052a.C1584a;

/* compiled from: MsgboxFragment.java */
/* renamed from: com.sec.chaton.msgbox.j */
/* loaded from: classes.dex */
class HandlerC0854j extends Handler {

    /* renamed from: a */
    final /* synthetic */ MsgboxFragment f3173a;

    HandlerC0854j(MsgboxFragment msgboxFragment) {
        this.f3173a = msgboxFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (this.f3173a.getActivity() != null) {
            C0103d c0103d = (C0103d) message.obj;
            switch (message.what) {
                case 2:
                    if (c0103d.f333a || C0493bg.m2680a(message.what, c0103d.m680a()) == EnumC0104e.CHANGE_SERVER) {
                        if (!this.f3173a.f3101E.isShowing()) {
                            this.f3173a.f3101E.show();
                        }
                        this.f3173a.f3100D.m2937a(this.f3173a.f3124r, this.f3173a.f3123q, this.f3173a.f3120n, (String[]) this.f3173a.f3118l.toArray(new String[0]));
                        break;
                    } else {
                        this.f3173a.f3100D.m2949b(false);
                        Toast.makeText(this.f3173a.getActivity(), R.string.toast_end_chat_fail, 0).show();
                        this.f3173a.f3100D.f2484b = false;
                        break;
                    }
                    break;
                case 8:
                    if (this.f3173a.f3101E.isShowing()) {
                        this.f3173a.f3101E.dismiss();
                    }
                    this.f3173a.f3100D.m2949b(false);
                    this.f3173a.f3100D.f2484b = false;
                    if (c0103d.f333a || C0493bg.m2680a(message.what, c0103d.m680a()) == EnumC0104e.REGARD_SUCCEESS) {
                        this.f3173a.m3515i();
                        this.f3173a.f3100D.m2954f();
                        this.f3173a.f3100D.m2953e();
                        if (this.f3173a.f3098B != null && this.f3173a.f3120n != null) {
                            if (GlobalApplication.m3265f() && this.f3173a.f3098B.equals(this.f3173a.f3120n)) {
                                HomeTabletFragment.m628a(this.f3173a.getFragmentManager(), new HomeTabletFragment.EmptyFragment());
                            }
                            try {
                                C1584a.m5471a(this.f3173a.getActivity(), C1584a.m5469a(this.f3173a.f3123q));
                                break;
                            } catch (Exception e) {
                                e.printStackTrace();
                                return;
                            }
                        }
                    } else {
                        Toast.makeText(this.f3173a.getActivity(), R.string.toast_end_chat_fail, 0).show();
                        break;
                    }
                    break;
            }
        }
    }
}
