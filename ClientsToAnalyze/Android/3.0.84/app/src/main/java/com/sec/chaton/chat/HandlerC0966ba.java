package com.sec.chaton.chat;

import android.content.ContentValues;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.R;
import com.sec.chaton.TabActivity;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.msgsend.C1759s;
import com.sec.chaton.p016a.C0351cu;
import com.sec.chaton.p016a.C0366di;
import com.sec.chaton.p016a.p017a.C0264a;
import com.sec.chaton.p016a.p017a.C0265b;
import com.sec.chaton.p016a.p017a.C0272i;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.p025d.p026a.C1221cv;
import com.sec.chaton.p025d.p026a.C1230dd;
import com.sec.chaton.p027e.C1449q;
import com.sec.chaton.p027e.C1457y;
import com.sec.chaton.p027e.EnumC1450r;
import com.sec.chaton.p037j.C1589q;
import com.sec.chaton.p037j.p040c.RunnableC1563i;
import com.sec.chaton.util.C3194bi;
import com.sec.chaton.util.C3205bt;
import com.sec.chaton.util.C3250y;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarFragmentActivity;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.widget.C3641ai;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.ba */
/* loaded from: classes.dex */
class HandlerC0966ba extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f3964a;

    HandlerC0966ba(ChatFragment chatFragment) {
        this.f3964a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) throws Resources.NotFoundException {
        boolean z;
        C0366di c0366di;
        ArrayList<String> arrayList;
        ArrayList<String> arrayList2;
        boolean z2 = this.f3964a.f3705t;
        if (this.f3964a.f3672cr != null) {
            C0272i c0272i = (C0272i) ((C1092fg) message.obj).m5376a();
            if (c0272i == null) {
                if (C3250y.f11734b) {
                    C3250y.m11450b("resultEntry is null", ChatFragment.f3484a);
                    return;
                }
                return;
            }
            C1759s.m7260a(ChatFragment.f3484a, "ChatFragment, mUIHandler(), ChatType(%d), Result(%d), Error(%s)", Integer.valueOf(message.what), Integer.valueOf(c0272i.m1365f()), C1075eq.m5314a(message.what, c0272i.m1365f()));
            if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.END_APP) {
                if (!ExitAppDialogActivity.m1139a()) {
                    ExitAppDialogActivity.m1141b();
                    return;
                }
                return;
            }
            if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.RESTART_APP) {
                AbstractC3271a abstractC3271aM4961a = this.f3964a.m4961a(EnumC0273j.RESTART_APP);
                if (abstractC3271aM4961a != null) {
                    abstractC3271aM4961a.mo11505a().show();
                }
            } else if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.RESET_BY_WEB) {
                if (!ExitAppDialogActivity.m1139a()) {
                    ExitAppDialogActivity.m1138a(2);
                    return;
                }
                return;
            }
            if (c0272i.f858a) {
                z = true;
            } else {
                int iM1365f = c0272i.m1365f();
                if ((iM1365f == 24 || iM1365f == 23 || iM1365f == 21) && this.f3964a.f3530aF != null) {
                    this.f3964a.f3530aF.m5901j();
                    this.f3964a.f3530aF.m5880a(this.f3964a.f3703r, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                }
                z = false;
            }
            switch (message.what) {
                case 0:
                case 106:
                    if (z) {
                        this.f3964a.f3705t = true;
                    } else {
                        this.f3964a.f3705t = false;
                    }
                    if (!this.f3964a.f3705t) {
                        this.f3964a.f3705t = z2;
                    }
                    if (this.f3964a.f3709x == EnumC1450r.BROADCAST) {
                        if (this.f3964a.m4793aH()) {
                            this.f3964a.f3705t = true;
                        } else {
                            this.f3964a.f3705t = false;
                        }
                    }
                    this.f3964a.m5022w();
                    if (!c0272i.f858a) {
                        switch (C1075eq.m5314a(message.what, c0272i.m1365f())) {
                            case CHANGE_SERVER:
                                if (this.f3964a.f3530aF != null) {
                                    this.f3964a.f3530aF.m5901j();
                                    this.f3964a.f3530aF.m5880a(this.f3964a.f3703r, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                                    break;
                                }
                                break;
                            case BLOCK_RECEIVER:
                                C3641ai.m13211a(this.f3964a.f3672cr, String.format(CommonApplication.m11493l().getString(R.string.toast_was_blocked), ((C0264a) this.f3964a.f3537aM.get(this.f3964a.f3536aL.get(0))).m1329a()), 0).show();
                                break;
                            case INVALID_USER:
                                StringBuilder sb = new StringBuilder();
                                if (this.f3964a.f3537aM.size() > 0) {
                                    Iterator it = this.f3964a.f3537aM.entrySet().iterator();
                                    while (it.hasNext()) {
                                        sb.append(((C0264a) ((Map.Entry) it.next()).getValue()).m1329a());
                                        if (it.hasNext()) {
                                            sb.append(",");
                                        }
                                    }
                                } else {
                                    if (c0272i instanceof C1221cv) {
                                        arrayList = ((C1221cv) c0272i).f4733d;
                                    } else {
                                        arrayList = c0272i instanceof C1230dd ? ((C1230dd) c0272i).f4767e : null;
                                    }
                                    if (arrayList != null) {
                                        Iterator<String> it2 = arrayList.iterator();
                                        while (it2.hasNext()) {
                                            sb.append(it2.next());
                                            if (it2.hasNext()) {
                                                sb.append(",");
                                            }
                                        }
                                    }
                                }
                                C3641ai.m13211a(this.f3964a.f3672cr, String.format(GlobalApplication.m11493l().getString(R.string.toast_deleted_account), sb.toString()), 0).show();
                                break;
                            case NON_WEB_USER_DETECTED:
                                if (c0272i instanceof C1221cv) {
                                    c0366di = ((C1221cv) c0272i).f4734e;
                                } else {
                                    c0366di = c0272i instanceof C1230dd ? ((C1230dd) c0272i).f4768f : null;
                                }
                                if (c0366di != null) {
                                    for (C0351cu c0351cu : c0366di.m2468c()) {
                                        String strM2335d = c0351cu.m2335d();
                                        String strM2337f = c0351cu.m2337f();
                                        int iIndexOf = this.f3964a.f3536aL.indexOf(strM2335d);
                                        if (iIndexOf > -1) {
                                            this.f3964a.f3536aL.set(iIndexOf, strM2337f);
                                            C0264a c0264a = (C0264a) this.f3964a.f3537aM.remove(strM2335d);
                                            c0264a.m1330a(strM2337f);
                                            this.f3964a.f3537aM.put(strM2337f, c0264a);
                                        }
                                    }
                                }
                                this.f3964a.m4964a(c0272i.m1366g());
                                break;
                        }
                    } else {
                        if (c0272i instanceof C1221cv) {
                            this.f3964a.f3710y = ((C1221cv) c0272i).m5550a();
                        } else if (c0272i instanceof C1230dd) {
                            this.f3964a.f3710y = ((C1230dd) c0272i).f4766d;
                        }
                        this.f3964a.f3551aa.startQuery(5, null, C1457y.m6367a(this.f3964a.f3703r), null, null, null, null);
                        this.f3964a.m5006g();
                        if (C1075eq.m5314a(message.what, c0272i.m1365f()) == EnumC0273j.SUCCESS_RECEIVER_ERROR) {
                            if (c0272i instanceof C1221cv) {
                                arrayList2 = ((C1221cv) c0272i).f4733d;
                            } else {
                                arrayList2 = c0272i instanceof C1230dd ? ((C1230dd) c0272i).f4767e : null;
                            }
                            if (arrayList2 != null) {
                                StringBuilder sb2 = new StringBuilder();
                                Iterator<String> it3 = arrayList2.iterator();
                                while (it3.hasNext()) {
                                    sb2.append(it3.next());
                                    if (it3.hasNext()) {
                                        sb2.append(",");
                                    }
                                }
                                C3641ai.m13211a(this.f3964a.f3672cr, String.format(CommonApplication.m11493l().getString(R.string.toast_deleted_account), sb2.toString()), 0).show();
                            } else {
                                C3250y.m11450b("1001 error - but invalid user list is empty", getClass().getSimpleName());
                            }
                        }
                        this.f3964a.m4949s(this.f3964a.f3703r);
                    }
                    if (this.f3964a.f3546aV != null) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("inbox_title", this.f3964a.f3546aV);
                        contentValues.put("inbox_title_fixed", "Y");
                        this.f3964a.f3551aa.startUpdate(-1, null, C1449q.f5381a, contentValues, "inbox_no='" + this.f3964a.f3703r + "'", null);
                    }
                    if (z || !C1589q.m6726a(c0272i.m1365f())) {
                        this.f3964a.m4772a(true, z);
                    }
                    if (c0272i.m1365f() == 7005) {
                        this.f3964a.m4989c();
                    }
                    if (this.f3964a.f3709x == EnumC1450r.GROUPCHAT && this.f3964a.f3599bV != null && this.f3964a.f3710y != null) {
                        C3205bt.m11182a(this.f3964a.f3672cr).m11218a(this.f3964a.f3703r, this.f3964a.f3599bV, this.f3964a.f3710y);
                    }
                    if (this.f3964a.f3709x == EnumC1450r.BROADCAST) {
                        if (this.f3964a.f3526aB != null && this.f3964a.f3526aB.getCount() == 2) {
                            ((ActionBarFragmentActivity) this.f3964a.getActivity()).supportInvalidateOptionsMenu();
                            break;
                        }
                    } else {
                        ((ActionBarFragmentActivity) this.f3964a.getActivity()).supportInvalidateOptionsMenu();
                        break;
                    }
                    break;
                case 2:
                    this.f3964a.m5022w();
                    if (!c0272i.f858a) {
                        switch (C1075eq.m5314a(message.what, c0272i.m1365f())) {
                            case SESSION_USER_NOT_EXIST:
                                this.f3964a.m4994d();
                                break;
                            case SESSION_DEACTIVATED:
                                this.f3964a.m4855aw();
                                break;
                        }
                    }
                    break;
                case 4:
                case 102:
                    if (!c0272i.f858a) {
                        c0272i.m1365f();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        switch (C1075eq.m5314a(message.what, r0)) {
                            case CHANGE_SERVER:
                                if (this.f3964a.f3530aF != null) {
                                    this.f3964a.f3530aF.m5901j();
                                    this.f3964a.f3530aF.m5880a(this.f3964a.f3703r, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                                    this.f3964a.f3530aF.m5893c(480000 + jElapsedRealtime);
                                    break;
                                }
                                break;
                            case BLOCK_RECEIVER:
                                C3641ai.m13211a(this.f3964a.f3672cr, String.format(CommonApplication.m11493l().getString(R.string.toast_was_blocked), ((C0264a) this.f3964a.f3537aM.get(this.f3964a.f3536aL.get(0))).m1329a()), 0).show();
                                break;
                            case INVALID_USER:
                                StringBuilder sb3 = new StringBuilder();
                                Iterator it4 = this.f3964a.f3537aM.entrySet().iterator();
                                while (it4.hasNext()) {
                                    sb3.append(((C0264a) ((Map.Entry) it4.next()).getValue()).m1329a());
                                    if (it4.hasNext()) {
                                        sb3.append(",");
                                    }
                                }
                                break;
                            case RETRY:
                                if (this.f3964a.f3530aF != null) {
                                    this.f3964a.f3530aF.m5880a(this.f3964a.f3703r, C3194bi.m11149a().m11154c().m11155a(), C3194bi.m11149a().m11154c().m11158b());
                                    this.f3964a.f3530aF.m5893c(jElapsedRealtime + 480000);
                                }
                                this.f3964a.f3710y = null;
                                break;
                            case SESSION_USER_NOT_EXIST:
                                this.f3964a.m4994d();
                                break;
                            case SESSION_DEACTIVATED:
                                this.f3964a.m4855aw();
                                break;
                        }
                    }
                    if (z || !C1589q.m6726a(c0272i.m1365f())) {
                        this.f3964a.m4772a(true, z);
                    }
                    if (c0272i.m1365f() == 7005) {
                        this.f3964a.m4989c();
                        break;
                    }
                    break;
                case 6:
                    C0265b c0265b = (C0265b) c0272i;
                    int iM1334b = c0265b.m1334b();
                    if (iM1334b > 0 && !this.f3964a.f3503E) {
                        this.f3964a.mo4963a(iM1334b, c0265b.m1336d(), c0265b.m1335c(), c0265b.m1337e());
                    }
                    this.f3964a.m4772a(false, z);
                    break;
                case 8:
                    this.f3964a.m5022w();
                    if (!c0272i.f858a && C1075eq.m5314a(message.what, c0272i.m1365f()) != EnumC0273j.REGARD_SUCCEESS) {
                        C3641ai.m13210a(this.f3964a.f3672cr, R.string.toast_end_chat_fail, 0).show();
                    } else {
                        if (GlobalApplication.m6456e()) {
                            this.f3964a.m4949s("");
                            ((TabActivity) this.f3964a.getActivity()).m1312a(R.id.child, new Intent(), EmptyChatFragment.class);
                        } else {
                            ((InterfaceC1027cw) this.f3964a.getActivity()).mo4670c();
                        }
                        C3641ai.m13210a(GlobalApplication.m11493l(), R.string.trunk_toast_deleted, 0).show();
                    }
                    if (c0272i.m1365f() == 7005) {
                        this.f3964a.m4989c();
                        break;
                    }
                    break;
                case 12:
                    this.f3964a.m5022w();
                    if (!c0272i.f858a) {
                        switch (C1075eq.m5314a(message.what, c0272i.m1365f())) {
                            case SESSION_USER_NOT_EXIST:
                                this.f3964a.m4994d();
                                break;
                            case SESSION_DEACTIVATED:
                                this.f3964a.m4855aw();
                                break;
                        }
                        C3641ai.m13210a(this.f3964a.f3672cr, R.string.toast_invite_fail, 0).show();
                    }
                    if (c0272i.m1365f() == 7005) {
                        this.f3964a.m4989c();
                        break;
                    }
                    break;
                case 16:
                    if (c0272i.m1365f() == 3006) {
                        this.f3964a.m4994d();
                        break;
                    }
                    break;
                case 31:
                    this.f3964a.m5022w();
                    if (!c0272i.f858a) {
                        switch (C1075eq.m5314a(message.what, c0272i.m1365f())) {
                            case SESSION_USER_NOT_EXIST:
                                this.f3964a.m4994d();
                                break;
                        }
                        C3641ai.m13210a(this.f3964a.f3672cr, R.string.toast_invite_fail, 0).show();
                    }
                    if (c0272i.m1365f() == 7005) {
                        this.f3964a.m4989c();
                        break;
                    }
                    break;
                case 101:
                    if (!c0272i.f858a) {
                        this.f3964a.m5022w();
                        this.f3964a.f3589bL = c0272i.m1365f();
                        if (this.f3964a.f3589bL == 28004 || this.f3964a.f3589bL == 28003) {
                            C3641ai.m13210a(this.f3964a.f3672cr, R.string.toast_supported_format, 0).show();
                        } else if (!RunnableC1563i.m6645a(message.arg1, message.arg2)) {
                            C3641ai.m13210a(this.f3964a.f3672cr, R.string.toast_file_upload_fail, 0).show();
                        }
                        this.f3964a.m4772a(true, z);
                        break;
                    }
                    break;
                case 107:
                    if (c0272i.m1365f() == 7100) {
                        this.f3964a.m4843aq();
                        break;
                    } else {
                        this.f3964a.m4844ar();
                        break;
                    }
            }
        }
    }
}
