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
import com.p137vk.sdk.api.VKApiConst;
import com.sec.chaton.R;
import com.sec.chaton.chat.C1736gi;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C2799k;
import com.sec.chaton.p046a.p047a.EnumC0789m;
import com.sec.chaton.p055d.C2142w;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p132g.C5007c;
import com.sec.common.util.C5034k;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public class FragmentScreenNotification extends Fragment {

    /* renamed from: b */
    private static final String f6712b = FragmentScreenNotification.class.getSimpleName();

    /* renamed from: d */
    private EditText f6715d;

    /* renamed from: e */
    private ImageView f6716e;

    /* renamed from: f */
    private LinearLayout f6717f;

    /* renamed from: g */
    private TextView f6718g;

    /* renamed from: h */
    private ImageView f6719h;

    /* renamed from: i */
    private C5007c f6720i;

    /* renamed from: k */
    private String f6722k;

    /* renamed from: l */
    private int f6723l;

    /* renamed from: m */
    private EnumC2301u f6724m;

    /* renamed from: n */
    private String f6725n;

    /* renamed from: c */
    private final String f6714c = GlobalApplication.m10283b().getString(R.string.unknown);

    /* renamed from: j */
    private C2142w f6721j = null;

    /* renamed from: a */
    Handler f6713a = new HandlerC1825n(this);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f6722k = getArguments() != null ? getArguments().getString(VKApiConst.MESSAGE) : this.f6714c;
        this.f6723l = getArguments() != null ? getArguments().getInt("msgType") : EnumC2214ab.TEXT.m10076a();
        this.f6725n = getArguments() != null ? getArguments().getString("name") : this.f6714c;
        if (getArguments().containsKey("roomType")) {
            this.f6724m = EnumC2301u.m10211a(getArguments().getInt("roomType"));
        } else {
            this.f6724m = EnumC2301u.NORMAL;
        }
        this.f6720i = new C5007c(Executors.newFixedThreadPool(5, new ThreadFactoryC1824m(this)));
        super.onCreate(bundle);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.layout_popup_noti_contents, viewGroup, false);
        this.f6715d = (EditText) viewInflate.findViewById(R.id.textMessage);
        this.f6715d.setVerticalScrollBarEnabled(true);
        this.f6716e = (ImageView) viewInflate.findViewById(R.id.imageMessage);
        this.f6717f = (LinearLayout) viewInflate.findViewById(R.id.mixedMessage);
        this.f6717f.setVisibility(8);
        this.f6718g = (TextView) viewInflate.findViewById(R.id.extraMessage);
        this.f6718g.setVisibility(8);
        this.f6719h = (ImageView) viewInflate.findViewById(R.id.progressImage);
        this.f6719h.setVisibility(8);
        return viewInflate;
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        if (C4904y.f17873c) {
            C4904y.m18641c("[onResume]", f6712b);
        }
        m8823b();
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        C4904y.m18641c("[onDestroy]", f6712b);
        this.f6720i.m19014a();
        super.onDestroy();
    }

    /* renamed from: b */
    private void m8823b() {
        this.f6716e.setVisibility(8);
        this.f6715d.setVisibility(0);
        if (C4904y.f17873c) {
            int length = this.f6722k.length();
            C4904y.m18641c("extra text:" + ((Object) this.f6722k.subSequence(0, length <= 4 ? length : 4)), f6712b);
        }
        if (EnumC2214ab.m10070a(this.f6723l) == EnumC2214ab.TEXT) {
            if (C1736gi.m8652d(this.f6722k)) {
                this.f6722k = this.f6722k.substring(1);
            }
            this.f6715d.setText(C2799k.m11709a(getActivity(), C1736gi.m8653e(this.f6722k), (int) C5034k.m19088a(30.0f)));
            return;
        }
        this.f6715d.setText(EnumC2214ab.m10073a(EnumC2214ab.m10070a(this.f6723l), this.f6722k, this.f6725n, m8825c()));
    }

    /* renamed from: a */
    public AbstractC4932a m8830a(EnumC0789m enumC0789m) {
        AbstractC4932a abstractC4932aM18733a = AbstractC4932a.m18733a(getActivity());
        if (enumC0789m == EnumC0789m.END_APP) {
            abstractC4932aM18733a.mo18746b(R.string.provision_error_end).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1826o(this));
            return abstractC4932aM18733a;
        }
        if (enumC0789m == EnumC0789m.RESTART_APP) {
            abstractC4932aM18733a.mo18746b(R.string.auth_error_restart).mo18756d(R.string.dialog_ok, new DialogInterfaceOnClickListenerC1827p(this));
            return abstractC4932aM18733a;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public boolean m8825c() {
        return "mixed".equals(this.f6722k.split("\n")[0]);
    }
}
