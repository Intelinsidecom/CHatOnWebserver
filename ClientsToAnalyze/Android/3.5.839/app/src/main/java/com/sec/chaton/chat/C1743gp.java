package com.sec.chaton.chat;

import android.app.Activity;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.sso.p030a.C0416a;
import com.coolots.sso.p030a.InterfaceC0417b;
import com.sec.chaton.R;
import com.sec.chaton.plugin.C2948h;
import com.sec.chaton.plugin.EnumC2949i;
import com.sec.chaton.util.C4877co;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DuringCallController.java */
/* renamed from: com.sec.chaton.chat.gp */
/* loaded from: classes.dex */
public class C1743gp implements InterfaceC0417b {

    /* renamed from: a */
    private static final String f6550a = C1743gp.class.getSimpleName();

    /* renamed from: b */
    private Activity f6551b;

    /* renamed from: c */
    private LinearLayout f6552c;

    /* renamed from: d */
    private ImageView f6553d;

    /* renamed from: e */
    private TextView f6554e;

    /* renamed from: f */
    private TextView f6555f;

    /* renamed from: g */
    private TextView f6556g;

    /* renamed from: h */
    private Button f6557h;

    /* renamed from: i */
    private C0416a f6558i;

    /* renamed from: j */
    private boolean f6559j = false;

    /* renamed from: k */
    private Handler f6560k = new HandlerC1744gq(this);

    /* renamed from: a */
    public static C1743gp m8675a(Activity activity, LinearLayout linearLayout) {
        return new C1743gp(activity, linearLayout);
    }

    private C1743gp(Activity activity, LinearLayout linearLayout) {
        this.f6558i = null;
        this.f6551b = activity;
        this.f6552c = linearLayout;
        this.f6553d = (ImageView) this.f6552c.findViewById(R.id.callTypeIcon);
        this.f6554e = (TextView) this.f6552c.findViewById(R.id.callBuddyName);
        this.f6555f = (TextView) this.f6552c.findViewById(R.id.callBuddyCount);
        this.f6556g = (TextView) this.f6552c.findViewById(R.id.callDuration);
        this.f6557h = (Button) this.f6552c.findViewById(R.id.btnEndCall);
        if (C2948h.m12190a().m12192a(this.f6551b, EnumC2949i.ChatONV)) {
            this.f6558i = new C0416a();
        }
        m8684e();
    }

    /* renamed from: e */
    private void m8684e() {
        this.f6552c.setOnClickListener(new ViewOnClickListenerC1745gr(this));
        this.f6557h.setOnClickListener(new ViewOnClickListenerC1746gs(this));
    }

    /* renamed from: b */
    public void m8687b() {
        if (this.f6558i != null) {
            this.f6558i.m1490a(this.f6551b, this);
            if (this.f6558i.m1501j(this.f6551b)) {
                switch (this.f6558i.m1502k(this.f6551b)) {
                    case 2:
                    case 100:
                    case 101:
                        C4904y.m18639b("[ChatONV] connected : " + C0416a.m1468a(this.f6558i.m1502k(this.f6551b)), f6550a);
                        m8685f();
                        break;
                    default:
                        C4904y.m18639b("[ChatONV] not connected : " + C0416a.m1468a(this.f6558i.m1502k(this.f6551b)), f6550a);
                        break;
                }
            }
        }
    }

    /* renamed from: c */
    public void m8688c() {
        if (this.f6558i != null) {
            this.f6558i.m1490a(this.f6551b, (InterfaceC0417b) null);
            this.f6560k.sendEmptyMessage(3);
            this.f6552c.setVisibility(8);
        }
    }

    /* renamed from: f */
    private void m8685f() {
        C4904y.m18639b("[ChatONV] call online", f6550a);
        if (this.f6558i.m1503l(this.f6551b) == 2) {
            this.f6553d.setImageResource(R.drawable.v_voice_icon);
        } else {
            this.f6553d.setImageResource(R.drawable.v_view_icon);
        }
        m8676a((ArrayList<String>) this.f6558i.m1504m(this.f6551b));
        this.f6560k.sendMessage(this.f6560k.obtainMessage(4, this.f6558i.m1500i(this.f6551b), 0));
        this.f6557h.setVisibility(0);
        this.f6552c.setVisibility(0);
    }

    /* renamed from: g */
    private void m8686g() {
        int iIntValue = this.f6556g.getTag() != null ? ((Integer) this.f6556g.getTag()).intValue() : 0;
        this.f6557h.setVisibility(4);
        this.f6560k.sendEmptyMessage(3);
        this.f6556g.setText(this.f6551b.getResources().getString(R.string.chat_call_ended) + " : " + C4877co.m18515b(iIntValue));
        this.f6556g.setTag(null);
        this.f6560k.sendMessageDelayed(this.f6560k.obtainMessage(1, 6, 0), 500L);
    }

    @Override // com.coolots.sso.p030a.InterfaceC0417b
    /* renamed from: a */
    public void mo1507a(int i) {
        C4904y.m18639b("[ChatONV] onReceiveChangeCallState : " + C0416a.m1468a(i), f6550a);
        switch (i) {
            case 2:
            case 100:
            case 101:
                C4904y.m18639b("[ChatONV] connected message received", f6550a);
                m8685f();
                break;
            case 3:
                C4904y.m18639b("[ChatONV] disconnected message received", f6550a);
                m8686g();
                break;
        }
    }

    @Override // com.coolots.sso.p030a.InterfaceC0417b
    /* renamed from: a */
    public void mo1506a() {
        C4904y.m18639b("[ChatONV] conference member change message received", f6550a);
        m8685f();
    }

    /* renamed from: a */
    private void m8676a(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.f6554e.setText("UN Owen");
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(next);
        }
        this.f6554e.setText(sb.toString());
        if (arrayList.size() > 1) {
            this.f6555f.setText("(" + (arrayList.size() + 1) + ")");
            this.f6555f.setVisibility(0);
        } else {
            this.f6555f.setVisibility(8);
        }
    }
}
