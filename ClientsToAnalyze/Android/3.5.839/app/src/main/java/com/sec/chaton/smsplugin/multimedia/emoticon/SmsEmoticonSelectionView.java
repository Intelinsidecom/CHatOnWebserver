package com.sec.chaton.smsplugin.multimedia.emoticon;

import android.content.Context;
import android.support.v4.app.AbstractC0069w;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.multimedia.emoticon.anicon.AniconContainer;
import com.sec.chaton.smsplugin.multimedia.emoticon.anicon.InterfaceC3921i;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class SmsEmoticonSelectionView extends FrameLayout implements InterfaceC3912a, InterfaceC3921i {

    /* renamed from: a */
    private static final String f14063a = SmsEmoticonSelectionView.class.getSimpleName();

    /* renamed from: b */
    private String f14064b;

    /* renamed from: c */
    private Fragment f14065c;

    /* renamed from: d */
    private Map<Fragment, Fragment.SavedState> f14066d;

    /* renamed from: e */
    private SmsEmoticonContainer f14067e;

    /* renamed from: f */
    private AniconContainer f14068f;

    /* renamed from: g */
    private InterfaceC3922b f14069g;

    public SmsEmoticonSelectionView(Context context) {
        super(context);
        this.f14064b = null;
        this.f14065c = null;
        m15101a();
    }

    public SmsEmoticonSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14064b = null;
        this.f14065c = null;
        m15101a();
    }

    public SmsEmoticonSelectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14064b = null;
        this.f14065c = null;
        m15101a();
    }

    public void setEmoticonSelectedListener(InterfaceC3922b interfaceC3922b) {
        this.f14069g = interfaceC3922b;
    }

    /* renamed from: a */
    private void m15101a() {
        this.f14066d = new HashMap();
        ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.layout_sms_emoticon_selection_view, (ViewGroup) this, true);
        m15102a("anicon");
    }

    /* renamed from: a */
    private void m15102a(String str) {
        if (TextUtils.isEmpty(this.f14064b) || !this.f14064b.equals(str)) {
            AbstractC0069w abstractC0069wM50e = m15103b().m50e();
            try {
                abstractC0069wM50e.mo186b();
            } catch (IllegalStateException e) {
            }
            if (this.f14065c != null) {
                this.f14066d.put(this.f14065c, abstractC0069wM50e.mo179a(this.f14065c));
            }
            if ("emoticon".equals(str)) {
                this.f14064b = "emoticon";
                if (this.f14067e == null) {
                    this.f14067e = SmsEmoticonContainer.m15097a(R.layout.layout_sms_emoticon_container, false);
                    this.f14067e.m15099a(this);
                }
                this.f14065c = this.f14067e;
            } else if ("anicon".equals(str)) {
                this.f14064b = "anicon";
                if (this.f14068f == null) {
                    this.f14068f = AniconContainer.m15110a(R.layout.layout_sms_anicon_container);
                    this.f14068f.m15131a(this);
                }
                this.f14065c = this.f14068f;
            }
            if (this.f14065c != null) {
                if (this.f14066d.containsKey(this.f14065c)) {
                    this.f14065c.setInitialSavedState(this.f14066d.get(this.f14065c));
                }
                abstractC0069wM50e.mo183a().mo100b(R.id.sms_fragment_container, this.f14065c).mo99b();
            }
        }
    }

    /* renamed from: b */
    private FragmentActivity m15103b() {
        return (FragmentActivity) getContext();
    }

    @Override // com.sec.chaton.smsplugin.multimedia.emoticon.InterfaceC3912a
    /* renamed from: a */
    public void mo15104a(SmsEmoticonContainer smsEmoticonContainer, String str) {
        if (this.f14069g != null) {
            this.f14069g.mo15134a_(str);
        }
    }

    @Override // com.sec.chaton.smsplugin.multimedia.emoticon.anicon.InterfaceC3921i
    /* renamed from: a */
    public void mo15105a(AniconContainer aniconContainer, String str, String str2) {
        if (str2.equals("emoticon")) {
            if (this.f14069g != null) {
                this.f14069g.mo15134a_(str);
            }
        } else if (this.f14069g != null) {
            this.f14069g.mo15135b(str);
        }
    }

    @Override // com.sec.chaton.smsplugin.multimedia.emoticon.anicon.InterfaceC3921i
    /* renamed from: a */
    public void mo15106a(AniconContainer aniconContainer, String str, String str2, String str3) {
        if (this.f14069g != null) {
            this.f14069g.mo15133a(str, str3);
        }
    }
}
