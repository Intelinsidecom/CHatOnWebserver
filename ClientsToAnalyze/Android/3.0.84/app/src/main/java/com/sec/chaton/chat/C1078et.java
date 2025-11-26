package com.sec.chaton.chat;

import android.app.Activity;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coolots.sso.p006a.C0045a;
import com.coolots.sso.p006a.InterfaceC0046b;
import com.sec.chaton.R;
import com.sec.chaton.plugin.C1954g;
import com.sec.chaton.plugin.EnumC1955h;
import com.sec.chaton.util.C3227co;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: DuringCallController.java */
/* renamed from: com.sec.chaton.chat.et */
/* loaded from: classes.dex */
public class C1078et implements InterfaceC0046b {

    /* renamed from: a */
    private static final String f4319a = C1078et.class.getSimpleName();

    /* renamed from: b */
    private Activity f4320b;

    /* renamed from: c */
    private LinearLayout f4321c;

    /* renamed from: d */
    private ImageView f4322d;

    /* renamed from: e */
    private TextView f4323e;

    /* renamed from: f */
    private TextView f4324f;

    /* renamed from: g */
    private TextView f4325g;

    /* renamed from: h */
    private Button f4326h;

    /* renamed from: i */
    private C0045a f4327i;

    /* renamed from: j */
    private boolean f4328j = false;

    /* renamed from: k */
    private Handler f4329k = new HandlerC1079eu(this);

    public C1078et(Activity activity, LinearLayout linearLayout) {
        this.f4327i = null;
        this.f4320b = activity;
        this.f4321c = linearLayout;
        this.f4322d = (ImageView) this.f4321c.findViewById(R.id.callTypeIcon);
        this.f4323e = (TextView) this.f4321c.findViewById(R.id.callBuddyName);
        this.f4324f = (TextView) this.f4321c.findViewById(R.id.callBuddyCount);
        this.f4325g = (TextView) this.f4321c.findViewById(R.id.callDuration);
        this.f4326h = (Button) this.f4321c.findViewById(R.id.btnEndCall);
        if (C1954g.m7916a().m7918a(this.f4320b, EnumC1955h.ChatONV)) {
            this.f4327i = new C0045a();
        }
        m5345e();
    }

    /* renamed from: e */
    private void m5345e() {
        this.f4321c.setOnClickListener(new ViewOnClickListenerC1080ev(this));
        this.f4326h.setOnClickListener(new ViewOnClickListenerC1081ew(this));
    }

    /* renamed from: b */
    public void m5348b() {
        if (this.f4327i != null) {
            this.f4327i.m50a(this.f4320b, this);
            if (this.f4327i.m61j(this.f4320b)) {
                switch (this.f4327i.m62k(this.f4320b)) {
                    case 2:
                    case 100:
                    case 101:
                        C3250y.m11450b("[ChatONV] connected : " + C0045a.m28a(this.f4327i.m62k(this.f4320b)), f4319a);
                        m5346f();
                        break;
                    default:
                        C3250y.m11450b("[ChatONV] not connected : " + C0045a.m28a(this.f4327i.m62k(this.f4320b)), f4319a);
                        break;
                }
            }
        }
    }

    /* renamed from: c */
    public void m5349c() {
        if (this.f4327i != null) {
            this.f4327i.m50a(this.f4320b, (InterfaceC0046b) null);
            this.f4329k.sendEmptyMessage(3);
            this.f4321c.setVisibility(8);
        }
    }

    /* renamed from: f */
    private void m5346f() {
        C3250y.m11450b("[ChatONV] call online", f4319a);
        if (this.f4327i.m63l(this.f4320b) == 2) {
            this.f4322d.setImageResource(R.drawable.v_voice_icon);
        } else {
            this.f4322d.setImageResource(R.drawable.v_view_icon);
        }
        m5337a((ArrayList<String>) this.f4327i.m64m(this.f4320b));
        this.f4329k.sendMessage(this.f4329k.obtainMessage(4, this.f4327i.m60i(this.f4320b), 0));
        this.f4326h.setVisibility(0);
        this.f4321c.setVisibility(0);
    }

    /* renamed from: g */
    private void m5347g() {
        int iIntValue = this.f4325g.getTag() != null ? ((Integer) this.f4325g.getTag()).intValue() : 0;
        this.f4326h.setVisibility(4);
        this.f4329k.sendEmptyMessage(3);
        this.f4325g.setText(this.f4320b.getResources().getString(R.string.chat_call_ended) + " : " + C3227co.m11342b(iIntValue));
        this.f4325g.setTag(null);
        this.f4329k.sendMessageDelayed(this.f4329k.obtainMessage(1, 6, 0), 500L);
    }

    @Override // com.coolots.sso.p006a.InterfaceC0046b
    /* renamed from: a */
    public void mo67a(int i) {
        C3250y.m11450b("[ChatONV] onReceiveChangeCallState : " + C0045a.m28a(i), f4319a);
        switch (i) {
            case 2:
            case 100:
            case 101:
                C3250y.m11450b("[ChatONV] connected message received", f4319a);
                m5346f();
                break;
            case 3:
                C3250y.m11450b("[ChatONV] disconnected message received", f4319a);
                m5347g();
                break;
        }
    }

    @Override // com.coolots.sso.p006a.InterfaceC0046b
    /* renamed from: a */
    public void mo66a() {
        C3250y.m11450b("[ChatONV] conference member change message received", f4319a);
        m5346f();
    }

    /* renamed from: a */
    private void m5337a(ArrayList<String> arrayList) {
        if (arrayList == null) {
            this.f4323e.setText("UN Owen");
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
        this.f4323e.setText(sb.toString());
        if (arrayList.size() > 1) {
            this.f4324f.setText("(" + (arrayList.size() + 1) + ")");
            this.f4324f.setVisibility(0);
        } else {
            this.f4324f.setVisibility(8);
        }
    }
}
