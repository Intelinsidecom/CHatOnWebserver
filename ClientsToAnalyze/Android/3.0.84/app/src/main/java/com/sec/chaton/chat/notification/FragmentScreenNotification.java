package com.sec.chaton.chat.notification;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1075eq;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C1835j;
import com.sec.chaton.p016a.p017a.EnumC0273j;
import com.sec.chaton.p025d.C1337o;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.util.C3172an;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p069e.C3326c;
import java.util.concurrent.Executors;
import twitter4j.Query;

/* loaded from: classes.dex */
public class FragmentScreenNotification extends Fragment {

    /* renamed from: b */
    private static final String f4367b = FragmentScreenNotification.class.getSimpleName();

    /* renamed from: d */
    private EditText f4370d;

    /* renamed from: e */
    private ImageView f4371e;

    /* renamed from: f */
    private LinearLayout f4372f;

    /* renamed from: g */
    private TextView f4373g;

    /* renamed from: h */
    private ImageView f4374h;

    /* renamed from: i */
    private C3326c f4375i;

    /* renamed from: k */
    private String f4377k;

    /* renamed from: l */
    private int f4378l;

    /* renamed from: m */
    private String f4379m;

    /* renamed from: n */
    private String f4380n;

    /* renamed from: c */
    private final String f4369c = GlobalApplication.m6451b().getString(R.string.unknown);

    /* renamed from: j */
    private C1337o f4376j = null;

    /* renamed from: a */
    Handler f4368a = new HandlerC1115k(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f4377k = getArguments() != null ? getArguments().getString("message") : this.f4369c;
        this.f4378l = getArguments() != null ? getArguments().getInt("msgType") : EnumC1455w.TEXT.m6364a();
        this.f4380n = getArguments() != null ? getArguments().getString("name") : this.f4369c;
        this.f4379m = getArguments().getString("msgID");
        this.f4375i = new C3326c(Executors.newFixedThreadPool(5, new ThreadFactoryC1114j(this)));
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_popup_noti_contents, viewGroup, false);
        this.f4370d = (EditText) viewInflate.findViewById(R.id.textMessage);
        this.f4370d.setVerticalScrollBarEnabled(true);
        this.f4371e = (ImageView) viewInflate.findViewById(R.id.imageMessage);
        this.f4372f = (LinearLayout) viewInflate.findViewById(R.id.mixedMessage);
        this.f4372f.setVisibility(8);
        this.f4373g = (TextView) viewInflate.findViewById(R.id.extraMessage);
        this.f4373g.setVisibility(8);
        this.f4374h = (ImageView) viewInflate.findViewById(R.id.progressImage);
        this.f4374h.setVisibility(8);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (C3250y.f11735c) {
            C3250y.m11453c("[onResume]", f4367b);
        }
        m5381b();
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        C3250y.m11453c("[onDestroy]", f4367b);
        this.f4375i.m11731a();
        super.onDestroy();
    }

    /* renamed from: b */
    private void m5381b() {
        this.f4371e.setVisibility(8);
        this.f4370d.setVisibility(0);
        if (C3250y.f11735c) {
            int length = this.f4377k.length();
            C3250y.m11453c("extra text:" + ((Object) this.f4377k.subSequence(0, length <= 4 ? length : 4)), f4367b);
        }
        if (EnumC1455w.m6358a(this.f4378l) == EnumC1455w.TEXT) {
            if (C1075eq.m5326c(this.f4377k)) {
                this.f4377k = this.f4377k.substring(1);
            }
            this.f4370d.setText(C1835j.m7508a(getActivity(), C1075eq.m5327d(this.f4377k), (int) C3172an.m11085a(30.0f)));
            return;
        }
        this.f4370d.setText(EnumC1455w.m6361a(EnumC1455w.m6358a(this.f4378l), this.f4377k, this.f4380n, m5383c()));
    }

    /* renamed from: a */
    public AbstractC3271a m5388a(EnumC0273j enumC0273j) {
        AbstractC3271a abstractC3271aM11494a = AbstractC3271a.m11494a(getActivity());
        if (enumC0273j == EnumC0273j.END_APP) {
            abstractC3271aM11494a.mo11506b(R.string.provision_error_end).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1116l(this));
            return abstractC3271aM11494a;
        }
        if (enumC0273j == EnumC0273j.RESTART_APP) {
            abstractC3271aM11494a.mo11506b(R.string.auth_error_restart).mo11515d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1117m(this));
            return abstractC3271aM11494a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m5383c() {
        return Query.MIXED.equals(this.f4377k.split("\n")[0]);
    }
}
