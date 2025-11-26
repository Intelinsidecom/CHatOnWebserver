package com.sec.chaton.msgbox;

import android.content.Context;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1759he;
import com.sec.chaton.global.C2349a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.provider.p089a.C3035a;
import com.sec.chaton.smsplugin.provider.AsyncTaskC3950h;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4822an;
import com.sec.chaton.util.C4904y;
import com.sec.common.CommonApplication;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.widget.C5179v;
import java.util.ArrayList;

/* compiled from: MsgboxSync.java */
/* renamed from: com.sec.chaton.msgbox.bs */
/* loaded from: classes.dex */
public class C2654bs {

    /* renamed from: a */
    public static final String f9510a = C2654bs.class.getSimpleName();

    /* renamed from: h */
    private static C2654bs f9511h = null;

    /* renamed from: g */
    private C1759he f9517g;

    /* renamed from: j */
    private Handler f9519j;

    /* renamed from: b */
    private int f9512b = -1;

    /* renamed from: c */
    private int f9513c = -1;

    /* renamed from: d */
    private int f9514d = -1;

    /* renamed from: e */
    private AsyncTaskC3950h f9515e = null;

    /* renamed from: f */
    private Handler f9516f = null;

    /* renamed from: i */
    private AsyncTaskC2644bi f9518i = null;

    /* renamed from: a */
    public static C2654bs m11169a() {
        if (f9511h == null || f9511h.f9516f == null || f9511h.f9519j == null) {
            f9511h = new C2654bs();
        }
        return f9511h;
    }

    public C2654bs() {
        if (C4904y.f17872b) {
            C4904y.m18639b("MsgboxSync created.", f9510a);
        }
    }

    /* renamed from: a */
    public void m11186a(int i) {
        this.f9513c = i;
        if (C4904y.f17872b) {
            C4904y.m18639b("setSyncChatResult[" + this.f9513c + "]", f9510a);
        }
    }

    /* renamed from: a */
    public void m11187a(int i, Handler handler) {
        this.f9512b = i;
        this.f9513c = -1;
        this.f9514d = -1;
        if (handler != null) {
            this.f9516f = handler;
            this.f9519j = new HandlerC2657bv(this);
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("sync(" + i + ")", f9510a);
        }
        switch (i) {
            case 1:
                m11176b();
                break;
            case 2:
                m11179c();
                break;
            case 3:
                m11180d();
                break;
        }
    }

    /* renamed from: b */
    private void m11176b() {
        if (C4904y.f17872b) {
            C4904y.m18639b("syncWithInterval()", f9510a);
        }
        if (C4822an.m18255w()) {
            long jM18118a = C4809aa.m18104a().m18118a("multidevice_chatlist_sync_last_call_time", 0L);
            if (jM18118a == 0) {
                m11181e();
                return;
            } else if (m11175a(jM18118a, true)) {
                m11182f();
                return;
            } else {
                m11181e();
                return;
            }
        }
        m11181e();
    }

    /* renamed from: c */
    private void m11179c() {
        if (C4904y.f17872b) {
            C4904y.m18639b("syncRequest()", f9510a);
        }
        if (C4822an.m18255w()) {
            m11182f();
        } else if (C4822an.m18226c()) {
            m11183g();
        } else {
            m11184h();
        }
    }

    /* renamed from: d */
    private void m11180d() {
        if (C4904y.f17872b) {
            C4904y.m18639b("syncSMSViaBypass()", f9510a);
        }
        if (C4822an.m18226c()) {
            m11183g();
        } else if (C2349a.m10301a("sms_feature")) {
            m11174a(new ArrayList<>());
        } else {
            m11184h();
        }
    }

    /* renamed from: e */
    private void m11181e() {
        if (C4904y.f17872b) {
            C4904y.m18639b("syncSMSInterval()", f9510a);
        }
        if (C4822an.m18226c()) {
            long jM18118a = C4809aa.m18104a().m18118a("sms_chatlist_sync_last_time", 0L);
            if (jM18118a == 0) {
                m11184h();
                return;
            } else if (m11175a(jM18118a, false)) {
                m11183g();
                return;
            } else {
                m11184h();
                return;
            }
        }
        m11184h();
    }

    /* renamed from: f */
    private void m11182f() {
        if (C4904y.f17872b) {
            C4904y.m18639b("syncChat()", f9510a);
        }
        if (this.f9512b == 2 && this.f9516f != null) {
            this.f9516f.sendEmptyMessage(5);
        }
        m11185i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m11183g() {
        if (C4904y.f17872b) {
            C4904y.m18639b(" :: SMS sync :: full sync - import+delete", f9510a);
        }
        if (this.f9512b == 2 && this.f9516f != null) {
            this.f9516f.sendEmptyMessage(5);
        }
        if (this.f9515e != null && this.f9515e.getStatus() != AsyncTask.Status.FINISHED) {
            C4904y.m18639b("syncSMSFull() cancel mFullSyncTask : " + this.f9515e + " getStatus : " + this.f9515e.getStatus(), f9510a);
            this.f9515e.cancel(true);
        } else {
            this.f9515e = new AsyncTaskC2655bt(this);
            this.f9515e.execute(new Void[0]);
        }
        C4809aa.m18104a().m18124a("sms_chatlist_sync_last_time", Long.valueOf(System.currentTimeMillis()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11174a(ArrayList<String> arrayList) {
        if (C4904y.f17872b) {
            C4904y.m18639b("syncMergeSMS()", f9510a);
        }
        if (this.f9518i != null && this.f9518i.getStatus() != AsyncTask.Status.FINISHED) {
            this.f9518i.cancel(true);
            C4904y.m18639b("syncMergeSMS() cancel mMsgboxSMSMergingTask : " + this.f9518i + " getStatus : " + this.f9518i.getStatus(), f9510a);
        } else {
            this.f9518i = new AsyncTaskC2656bu(this, arrayList);
            this.f9518i.execute(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m11184h() {
        if (C4904y.f17872b) {
            C4904y.m18639b("syncUIUpdate()", f9510a);
        }
        if (this.f9516f != null) {
            this.f9516f.sendEmptyMessage(7);
        }
        if (this.f9512b != 2) {
            this.f9512b = -1;
            this.f9514d = -1;
            this.f9513c = -1;
            return;
        }
        if (this.f9516f != null) {
            this.f9516f.sendEmptyMessage(6);
        }
        if (this.f9513c == 1) {
            C5179v.m19811a(GlobalApplication.m18732r(), CommonApplication.m18732r().getResources().getString(R.string.chat_no_history_found_popup_text), 0).show();
            if (this.f9516f != null) {
                this.f9516f.sendEmptyMessage(4);
            }
        } else if (this.f9513c == 3 || this.f9514d == 0) {
            C5179v.m19811a(GlobalApplication.m18732r(), CommonApplication.m18732r().getResources().getString(R.string.sync_fail_retry_again), 0).show();
        } else if ((this.f9513c == 2 && this.f9514d == -1) || ((this.f9513c == -1 && this.f9514d > 0) || (this.f9513c == 2 && this.f9514d > 0))) {
            C5179v.m19811a(GlobalApplication.m18732r(), CommonApplication.m18732r().getResources().getString(R.string.chat_history_loaded_toast), 0).show();
            if (this.f9516f != null) {
                this.f9516f.sendEmptyMessage(4);
            }
        } else if (C4904y.f17872b) {
            C4904y.m18639b("syncHandler got exceptional case mSyncChatResult[" + this.f9513c + "], mSyncSMSResult[" + this.f9514d + "]", f9510a);
        }
        this.f9512b = -1;
        this.f9514d = -1;
        this.f9513c = -1;
    }

    /* renamed from: a */
    private boolean m11175a(long j, boolean z) {
        int i;
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = false;
        if (z) {
            i = 86400000;
        } else {
            i = 60000;
        }
        if (jCurrentTimeMillis - j > i) {
            z2 = true;
        }
        if (C4904y.f17872b && z2) {
            C4904y.m18639b("checkInterval() forChat[" + z + "]", f9510a);
        }
        return z2;
    }

    /* renamed from: i */
    private void m11185i() {
        if (C4904y.f17872b) {
            C4904y.m18639b("getChatInfoList()", f9510a);
        }
        C3035a.m12465c();
        C4809aa.m18104a().m18124a("multidevice_chatlist_sync_last_call_time", Long.valueOf(System.currentTimeMillis()));
        long jM18118a = C4809aa.m18104a().m18118a("multidevice_chatlist_sync_last_time", 0L);
        boolean z = false;
        if (jM18118a == 0) {
            z = true;
        }
        this.f9517g = C1759he.m8727a(this.f9519j, this.f9512b != 2 ? jM18118a : 0L, z);
        this.f9517g.m8728a();
    }

    /* renamed from: a */
    public static InterfaceC4936e m11171a(Context context) throws Resources.NotFoundException {
        if (C4904y.f17872b) {
            C4904y.m18639b("MsgboxSync.syncDialog()", f9510a);
        }
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.layout_multidevice_sync, (ViewGroup) null, false);
        String string = context.getResources().getString(R.string.multi_deivce_mapping_pop_up_title);
        String string2 = context.getResources().getString(R.string.multidevice_sync_chat_title);
        String str = context.getResources().getString(R.string.multidevice_sync_popup).split("\n\n")[1];
        TextView textView = (TextView) viewInflate.findViewById(R.id.messageText);
        ((TextView) viewInflate.findViewById(R.id.subTitleText)).setText(string2);
        textView.setText(str);
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(context);
        abstractC4932aM18733a.mo18740a(string);
        abstractC4932aM18733a.mo18748b(viewInflate);
        abstractC4932aM18733a.mo18742a(true);
        abstractC4932aM18733a.mo18751b(false);
        return abstractC4932aM18733a.mo18745a();
    }
}
