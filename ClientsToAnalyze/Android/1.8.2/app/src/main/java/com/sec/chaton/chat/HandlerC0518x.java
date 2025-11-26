package com.sec.chaton.chat;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.widget.Toast;
import com.sec.chaton.C0229at;
import com.sec.chaton.ExitAppDialogActivity;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p007a.p008a.C0100a;
import com.sec.chaton.p007a.p008a.C0103d;
import com.sec.chaton.p007a.p008a.EnumC0104e;
import com.sec.chaton.p007a.p008a.EnumC0106g;
import com.sec.chaton.p015d.p016a.C0564be;
import com.sec.chaton.p015d.p016a.C0568bi;
import com.sec.chaton.p015d.p016a.C0605u;
import com.sec.chaton.p017e.C0694i;
import com.sec.chaton.p017e.C0701p;
import com.sec.chaton.p017e.EnumC0695j;
import com.sec.chaton.trunk.database.p052a.C1584a;
import com.sec.chaton.util.C1786r;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatFragment.java */
/* renamed from: com.sec.chaton.chat.x */
/* loaded from: classes.dex */
class HandlerC0518x extends Handler {

    /* renamed from: a */
    final /* synthetic */ ChatFragment f2128a;

    HandlerC0518x(ChatFragment chatFragment) {
        this.f2128a = chatFragment;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ArrayList arrayList;
        int iM680a;
        AlertDialog.Builder builderM2584a;
        if (this.f2128a.getActivity() != null) {
            C0103d c0103d = (C0103d) message.obj;
            if (C0493bg.m2680a(message.what, c0103d.m680a()) == EnumC0104e.END_APP) {
                if (!ExitAppDialogActivity.m580a()) {
                    ExitAppDialogActivity.m581b();
                    return;
                }
                return;
            }
            if (C0493bg.m2680a(message.what, c0103d.m680a()) == EnumC0104e.RESTART_APP && (builderM2584a = this.f2128a.m2584a(EnumC0104e.RESTART_APP)) != null) {
                builderM2584a.create().show();
            }
            if (!c0103d.f333a && (((iM680a = c0103d.m680a()) == 24 || iM680a == 23 || iM680a == 21) && this.f2128a.f1831at != null)) {
                this.f2128a.f1831at.m2954f();
                this.f2128a.f1831at.m2947a(this.f2128a.f1912z, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
            }
            switch (message.what) {
                case 0:
                    this.f2128a.f1761B = true;
                    if (this.f2128a.f1771L.isShowing()) {
                        this.f2128a.f1771L.dismiss();
                    }
                    if (!c0103d.f333a) {
                        switch (C0493bg.m2680a(message.what, c0103d.m680a())) {
                            case CHANGE_SERVER:
                                this.f2128a.f1831at.m2954f();
                                this.f2128a.f1831at.m2947a(this.f2128a.f1912z, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                                break;
                            case BLOCK_RECEIVER:
                                Toast.makeText(this.f2128a.getActivity(), String.format(GlobalApplication.m3260b().getString(R.string.toast_was_blocked), ((C0100a) this.f2128a.f1835ax.get(this.f2128a.f1834aw.get(0))).m656b()), 0).show();
                                break;
                            case INVALID_USER:
                                StringBuilder sb = new StringBuilder();
                                Iterator it = this.f2128a.f1835ax.entrySet().iterator();
                                while (it.hasNext()) {
                                    sb.append(((C0100a) ((Map.Entry) it.next()).getValue()).m656b());
                                    if (it.hasNext()) {
                                        sb.append(",");
                                    }
                                }
                                Toast.makeText(this.f2128a.getActivity(), String.format(GlobalApplication.m3260b().getString(R.string.toast_deleted_account), sb.toString()), 0).show();
                                break;
                        }
                    } else {
                        if (c0103d instanceof C0564be) {
                            this.f2128a.f1766G = ((C0564be) c0103d).f2254d;
                        } else if (c0103d instanceof C0568bi) {
                            this.f2128a.f1766G = ((C0568bi) c0103d).f2279d;
                        }
                        if (this.f2128a.f1765F != EnumC0695j.BROADCAST) {
                            this.f2128a.f1783X.startQuery(5, null, C0701p.m3164a(this.f2128a.f1912z), new String[]{"buddy_no", "buddy_name", "buddy_status_message"}, null, null, "rowid DESC");
                            this.f2128a.m2605c();
                        }
                        if (C0493bg.m2680a(message.what, c0103d.m680a()) == EnumC0104e.SUCCESS_RECEIVER_ERROR) {
                            if (c0103d instanceof C0564be) {
                                arrayList = ((C0564be) c0103d).f2255e;
                            } else {
                                arrayList = c0103d instanceof C0568bi ? ((C0568bi) c0103d).f2280e : null;
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
                                Toast.makeText(this.f2128a.getActivity(), String.format(GlobalApplication.m3260b().getString(R.string.toast_deleted_account), sb2.toString()), 0).show();
                            } else {
                                C1786r.m6054a("1001 error - but invalid user list is empty", getClass().getSimpleName());
                            }
                        }
                        this.f2128a.m2532d(this.f2128a.f1912z);
                    }
                    if (this.f2128a.f1792aG != null) {
                        ContentValues contentValues = new ContentValues();
                        if (this.f2128a.f1765F != EnumC0695j.ONETOONE) {
                            contentValues.put("inbox_title", this.f2128a.f1792aG.substring(0, this.f2128a.f1792aG.length() - (Integer.toString(this.f2128a.f1834aw.size()).length() + 3)));
                        } else {
                            contentValues.put("inbox_title", this.f2128a.f1792aG);
                        }
                        contentValues.put("inbox_title_fixed", "Y");
                        this.f2128a.f1783X.startUpdate(-1, null, C0694i.f2616a, contentValues, "inbox_no='" + this.f2128a.f1912z + "'", null);
                        break;
                    }
                    break;
                case 2:
                    if (this.f2128a.f1771L.isShowing()) {
                        this.f2128a.f1771L.dismiss();
                    }
                    if (c0103d.f333a || this.f2128a.f1765F != EnumC0695j.GROUPCHAT || c0103d.f334b == EnumC0106g.NETWORKFAIL) {
                    }
                    break;
                case 4:
                    if (!c0103d.f333a) {
                        c0103d.m680a();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        switch (C0493bg.m2680a(message.what, r0)) {
                            case CHANGE_SERVER:
                                this.f2128a.f1831at.m2954f();
                                this.f2128a.f1831at.m2947a(this.f2128a.f1912z, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                                this.f2128a.f1831at.m2930a(480000 + jElapsedRealtime);
                                break;
                            case BLOCK_RECEIVER:
                                Toast.makeText(this.f2128a.getActivity(), String.format(GlobalApplication.m3260b().getString(R.string.toast_was_blocked), ((C0100a) this.f2128a.f1835ax.get(this.f2128a.f1834aw.get(0))).m656b()), 0).show();
                                break;
                            case INVALID_USER:
                                StringBuilder sb3 = new StringBuilder();
                                Iterator it3 = this.f2128a.f1835ax.entrySet().iterator();
                                while (it3.hasNext()) {
                                    sb3.append(((C0100a) ((Map.Entry) it3.next()).getValue()).m656b());
                                    if (it3.hasNext()) {
                                        sb3.append(",");
                                    }
                                }
                                break;
                            case RETRY:
                                this.f2128a.f1831at.m2947a(this.f2128a.f1912z, GlobalApplication.m3263d().m5922b().m5923a(), GlobalApplication.m3263d().m5922b().m5926b());
                                this.f2128a.f1831at.m2930a(jElapsedRealtime + 480000);
                                this.f2128a.f1766G = null;
                                break;
                        }
                    }
                    break;
                case 6:
                    int i = ((C0605u) c0103d).f2379f;
                    if (i > 0 && !this.f2128a.f1772M) {
                        this.f2128a.setPreviewText(i);
                        break;
                    }
                    break;
                case 8:
                    if (this.f2128a.f1771L.isShowing()) {
                        this.f2128a.f1771L.dismiss();
                    }
                    if (c0103d.f333a || C0493bg.m2680a(message.what, c0103d.m680a()) == EnumC0104e.REGARD_SUCCEESS) {
                        this.f2128a.m2560o();
                        this.f2128a.f1831at.m2953e();
                        try {
                            C1584a.m5471a(this.f2128a.getActivity(), C1584a.m5469a(this.f2128a.f1766G));
                            break;
                        } catch (Exception e) {
                            C1786r.m6056a(e, ChatFragment.f1742a);
                            return;
                        }
                    } else {
                        Toast.makeText(this.f2128a.getActivity(), R.string.toast_end_chat_fail, 0).show();
                        break;
                    }
                    break;
                case C0229at.HorizontalSrollView_android_background /* 12 */:
                    if (this.f2128a.f1771L.isShowing()) {
                        this.f2128a.f1771L.dismiss();
                    }
                    if (!c0103d.f333a) {
                        Toast.makeText(this.f2128a.getActivity(), R.string.toast_invite_fail, 0).show();
                        break;
                    }
                    break;
                case C0229at.HorizontalSrollView_android_focusable /* 18 */:
                    if (c0103d.f333a) {
                    }
                    break;
                case AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END /* 1024 */:
                    if (!c0103d.f333a) {
                        if (this.f2128a.f1771L.isShowing()) {
                            this.f2128a.f1771L.dismiss();
                        }
                        this.f2128a.f1857bT = c0103d.m680a();
                        if (this.f2128a.f1857bT == 28004) {
                            new AlertDialogBuilderC2120a(this.f2128a.getActivity()).setTitle(this.f2128a.getActivity().getResources().getString(R.string.ams_attention_title)).setMessage(this.f2128a.getActivity().getResources().getString(R.string.toast_supported_format)).setNegativeButton(this.f2128a.getActivity().getResources().getString(R.string.dialog_ok), (DialogInterface.OnClickListener) null).show();
                            break;
                        } else {
                            Toast.makeText(this.f2128a.getActivity(), R.string.toast_file_upload_fail, 0).show();
                            break;
                        }
                    }
                    break;
            }
        }
    }
}
