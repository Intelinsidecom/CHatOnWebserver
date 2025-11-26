package com.sec.chaton.chat;

import android.content.ContentValues;
import android.hardware.motion.MREvent;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p013a.p014a.C0176o;
import com.sec.chaton.p013a.p014a.C0177p;
import com.sec.chaton.p013a.p014a.C0183v;
import com.sec.chaton.p015b.p016a.C0257e;
import com.sec.chaton.p015b.p016a.C0258f;
import com.sec.chaton.p015b.p016a.EnumC0255c;
import com.sec.chaton.p015b.p016a.EnumC0256d;
import com.sec.chaton.p025d.C0654g;
import com.sec.chaton.p025d.C0671x;
import com.sec.chaton.p025d.EnumC0665r;
import com.sec.chaton.trunk.database.p046a.C1173b;
import com.sec.chaton.util.C1341p;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.bu */
/* loaded from: classes.dex */
class HandlerC0581bu extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2002a;

    HandlerC0581bu(ChatFragment chatFragment) {
        this.f2002a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ArrayList arrayList;
        int iM917b;
        AlertDialogBuilderC1625m alertDialogBuilderC1625mM2682a;
        if (this.f2002a.getActivity() != null) {
            C0257e c0257e = (C0257e) ((C0592i) message.obj).m2777a();
            if (C0520a.m2709a(message.what, c0257e.m917b()) == EnumC0255c.END_APP) {
                if (!ExitAppDialogActivity.m624a()) {
                    ExitAppDialogActivity.m625b();
                    return;
                }
                return;
            }
            if (C0520a.m2709a(message.what, c0257e.m917b()) == EnumC0255c.RESTART_APP && (alertDialogBuilderC1625mM2682a = this.f2002a.m2682a(EnumC0255c.RESTART_APP)) != null) {
                alertDialogBuilderC1625mM2682a.create().show();
            }
            if (!c0257e.f604a && (((iM917b = c0257e.m917b()) == 24 || iM917b == 23 || iM917b == 21) && this.f2002a.f1799ai != null)) {
                this.f2002a.f1799ai.m851a(this.f2002a.f1861t, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                this.f2002a.f1799ai.m858g();
            }
            switch (message.what) {
                case 0:
                case 1029:
                    this.f2002a.f1863v = true;
                    if (this.f2002a.f1744E.isShowing()) {
                        this.f2002a.f1744E.dismiss();
                    }
                    if (!c0257e.f604a) {
                        switch (C0520a.m2709a(message.what, c0257e.m917b())) {
                            case CHANGE_SERVER:
                                this.f2002a.f1799ai.m851a(this.f2002a.f1861t, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                                this.f2002a.f1799ai.m858g();
                                break;
                            case BLOCK_RECEIVER:
                                C1619g.m5889a(this.f2002a.getActivity(), String.format(GlobalApplication.m3100a().getString(R.string.toast_was_blocked), ((C0258f) this.f2002a.f1803am.get(this.f2002a.f1802al.get(0))).m919a()), 0).show();
                                break;
                            case INVALID_USER:
                                StringBuilder sb = new StringBuilder();
                                Iterator it = this.f2002a.f1803am.entrySet().iterator();
                                while (it.hasNext()) {
                                    sb.append(((C0258f) ((Map.Entry) it.next()).getValue()).m919a());
                                    if (it.hasNext()) {
                                        sb.append(",");
                                    }
                                }
                                C1619g.m5889a(this.f2002a.getActivity(), String.format(GlobalApplication.m3100a().getString(R.string.toast_deleted_account), sb.toString()), 0).show();
                                break;
                        }
                    } else {
                        if (c0257e instanceof C0176o) {
                            this.f2002a.f1867z = ((C0176o) c0257e).m715a();
                        } else if (c0257e instanceof C0177p) {
                            this.f2002a.f1867z = ((C0177p) c0257e).f424d;
                        }
                        this.f2002a.f1760U.startQuery(5, null, C0654g.m2980a(this.f2002a.f1861t), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "rowid DESC");
                        this.f2002a.m2701b();
                        if (C0520a.m2709a(message.what, c0257e.m917b()) == EnumC0255c.SUCCESS_RECEIVER_ERROR) {
                            if (c0257e instanceof C0176o) {
                                arrayList = ((C0176o) c0257e).f421d;
                            } else {
                                arrayList = c0257e instanceof C0177p ? ((C0177p) c0257e).f425e : null;
                            }
                            if (arrayList != null) {
                                StringBuilder sb2 = new StringBuilder();
                                Iterator it2 = arrayList.iterator();
                                while (it2.hasNext()) {
                                    sb2.append((String) it2.next());
                                    if (it2.hasNext()) {
                                        sb2.append(",");
                                    }
                                }
                                C1619g.m5889a(this.f2002a.getActivity(), String.format(GlobalApplication.m3100a().getString(R.string.toast_deleted_account), sb2.toString()), 0).show();
                            } else {
                                C1341p.m4658b("1001 error - but invalid user list is empty", getClass().getSimpleName());
                            }
                        }
                        this.f2002a.m2625a(this.f2002a.f1861t);
                    }
                    if (this.f2002a.f1812av != null) {
                        ContentValues contentValues = new ContentValues();
                        if (this.f2002a.f1866y != EnumC0665r.ONETOONE) {
                            contentValues.put("inbox_title", this.f2002a.f1812av.substring(0, this.f2002a.f1812av.length() - (Integer.toString(this.f2002a.f1802al.size()).length() + 3)));
                        } else {
                            contentValues.put("inbox_title", this.f2002a.f1812av);
                        }
                        contentValues.put("inbox_title_fixed", "Y");
                        this.f2002a.f1760U.startUpdate(-1, null, C0671x.f2315a, contentValues, "inbox_no='" + this.f2002a.f1861t + "'", null);
                    }
                    this.f2002a.f1828bM.mo2594a(this.f2002a.f1867z);
                    break;
                case 2:
                    if (this.f2002a.f1744E.isShowing()) {
                        this.f2002a.f1744E.dismiss();
                    }
                    if (c0257e.f604a || this.f2002a.f1866y != EnumC0665r.GROUPCHAT || c0257e.f605b == EnumC0256d.NETWORKFAIL) {
                    }
                    break;
                case 4:
                case 1025:
                    if (!c0257e.f604a) {
                        c0257e.m917b();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        switch (C0520a.m2709a(message.what, r0)) {
                            case CHANGE_SERVER:
                                this.f2002a.f1799ai.m851a(this.f2002a.f1861t, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                                this.f2002a.f1799ai.m841a(480000 + jElapsedRealtime);
                                this.f2002a.f1799ai.m858g();
                                break;
                            case BLOCK_RECEIVER:
                                C1619g.m5889a(this.f2002a.getActivity(), String.format(GlobalApplication.m3100a().getString(R.string.toast_was_blocked), ((C0258f) this.f2002a.f1803am.get(this.f2002a.f1802al.get(0))).m919a()), 0).show();
                                break;
                            case INVALID_USER:
                                StringBuilder sb3 = new StringBuilder();
                                Iterator it3 = this.f2002a.f1803am.entrySet().iterator();
                                while (it3.hasNext()) {
                                    sb3.append(((C0258f) ((Map.Entry) it3.next()).getValue()).m919a());
                                    if (it3.hasNext()) {
                                        sb3.append(",");
                                    }
                                }
                                break;
                            case RETRY:
                                this.f2002a.f1799ai.m851a(this.f2002a.f1861t, GlobalApplication.m3107h().m4488b().m4513a(), GlobalApplication.m3107h().m4488b().m4516b());
                                this.f2002a.f1799ai.m841a(jElapsedRealtime + 480000);
                                this.f2002a.f1867z = null;
                                break;
                        }
                    }
                    break;
                case 6:
                    int i = ((C0183v) c0257e).f459f;
                    if (i > 0 && !this.f2002a.f1745F) {
                        this.f2002a.m2685a(i);
                        break;
                    }
                    break;
                case 8:
                    if (this.f2002a.f1744E.isShowing()) {
                        this.f2002a.f1744E.dismiss();
                    }
                    if (c0257e.f604a || C0520a.m2709a(message.what, c0257e.m917b()) == EnumC0255c.REGARD_SUCCEESS) {
                        this.f2002a.m2672r();
                        this.f2002a.f1799ai.m856e();
                        try {
                            C1173b.m4237a(this.f2002a.getActivity(), C1173b.m4235a(this.f2002a.f1867z));
                            break;
                        } catch (Exception e) {
                            C1341p.m4653a(e, ChatFragment.f1725a);
                            return;
                        }
                    } else {
                        C1619g.m5888a(this.f2002a.getActivity(), R.string.toast_end_chat_fail, 0).show();
                        break;
                    }
                    break;
                case MREvent.TILT_PORTRAIT_BACK /* 12 */:
                    if (this.f2002a.f1744E.isShowing()) {
                        this.f2002a.f1744E.dismiss();
                    }
                    if (!c0257e.f604a) {
                        C1619g.m5888a(this.f2002a.getActivity(), R.string.toast_invite_fail, 0).show();
                        break;
                    }
                    break;
                case MREvent.TILT_LANDSCAPE_LEFT_LEVEL_2 /* 18 */:
                    if (c0257e.f604a) {
                    }
                    break;
                case 1024:
                    if (!c0257e.f604a) {
                        if (this.f2002a.f1744E.isShowing()) {
                            this.f2002a.f1744E.dismiss();
                        }
                        this.f2002a.f1841bm = c0257e.m917b();
                        if (this.f2002a.f1841bm == 28004) {
                            C1619g.m5888a(this.f2002a.getActivity(), R.string.toast_supported_format, 0).show();
                            break;
                        } else {
                            C1619g.m5888a(this.f2002a.getActivity(), R.string.toast_file_upload_fail, 0).show();
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
