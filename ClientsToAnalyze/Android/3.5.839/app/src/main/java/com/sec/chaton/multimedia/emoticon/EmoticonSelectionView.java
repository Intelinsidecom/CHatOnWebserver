package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.support.v4.app.AbstractC0069w;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.anicon.AniconContainer;
import com.sec.chaton.multimedia.emoticon.anicon.InterfaceC2778j;
import com.sec.chaton.p057e.EnumC2301u;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.util.C5052r;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class EmoticonSelectionView extends FrameLayout implements View.OnClickListener, InterfaceC2778j, InterfaceC2794f {

    /* renamed from: a */
    private static final String f10000a = EmoticonSelectionView.class.getSimpleName();

    /* renamed from: b */
    private Context f10001b;

    /* renamed from: c */
    private String f10002c;

    /* renamed from: d */
    private Fragment f10003d;

    /* renamed from: e */
    private Map<Fragment, Fragment.SavedState> f10004e;

    /* renamed from: f */
    private RelativeLayout f10005f;

    /* renamed from: g */
    private ImageButton f10006g;

    /* renamed from: h */
    private ImageButton f10007h;

    /* renamed from: i */
    private ImageButton f10008i;

    /* renamed from: j */
    private EmoticonContainer f10009j;

    /* renamed from: k */
    private AniconContainer f10010k;

    /* renamed from: l */
    private InterfaceC2798j f10011l;

    /* renamed from: m */
    private EnumC2301u f10012m;

    public EmoticonSelectionView(Context context, EnumC2301u enumC2301u) {
        super(context);
        this.f10002c = null;
        this.f10003d = null;
        this.f10001b = context;
        this.f10012m = enumC2301u;
        m11633a();
    }

    public void setEmoticonSelectedListener(InterfaceC2798j interfaceC2798j) {
        this.f10011l = interfaceC2798j;
    }

    /* renamed from: a */
    private void m11633a() {
        if (C4904y.f17872b) {
            C4904y.m18639b("EmoticonSelectionView.initialize()", f10000a);
        }
        this.f10004e = new HashMap();
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.layout_emoticon_selection_view, (ViewGroup) this, true);
        this.f10005f = (RelativeLayout) viewInflate.findViewById(R.id.header);
        this.f10006g = (ImageButton) viewInflate.findViewById(R.id.emoticonButton);
        this.f10007h = (ImageButton) viewInflate.findViewById(R.id.ticonButton);
        this.f10008i = (ImageButton) viewInflate.findViewById(R.id.amsButton);
        this.f10006g.setOnClickListener(this);
        this.f10007h.setOnClickListener(this);
        this.f10008i.setOnClickListener(this);
        if (this.f10012m == EnumC2301u.NORMAL) {
            m11634a("anicon");
        } else {
            m11634a("emoticon");
        }
        this.f10005f.setVisibility(8);
    }

    /* renamed from: a */
    private void m11634a(String str) {
        if (!C4873ck.m18504e() && "anicon".equals(str)) {
            AbstractC4932a.m18733a(this.f10001b).mo18734a(R.string.pop_up_attention).mo18746b(R.string.popup_not_enough_memory).mo18756d(R.string.dialog_ok, null).mo18752b();
            return;
        }
        if (TextUtils.isEmpty(this.f10002c) || !this.f10002c.equals(str)) {
            AbstractC0069w abstractC0069wM50e = m11635b().m50e();
            try {
                abstractC0069wM50e.mo186b();
            } catch (IllegalStateException e) {
            }
            if (this.f10003d != null) {
                this.f10004e.put(this.f10003d, abstractC0069wM50e.mo179a(this.f10003d));
            }
            if ("emoticon".equals(str)) {
                this.f10002c = "emoticon";
                this.f10007h.setSelected(false);
                this.f10006g.setSelected(true);
                this.f10008i.setSelected(false);
                if (this.f10009j == null) {
                    this.f10009j = EmoticonContainer.m11627a(R.layout.layout_emoticon_container, false);
                    this.f10009j.m11630a(this.f10012m);
                    this.f10009j.m11631a(this);
                }
                this.f10003d = this.f10009j;
            } else if ("anicon".equals(str)) {
                this.f10002c = "anicon";
                this.f10006g.setSelected(false);
                this.f10007h.setSelected(true);
                this.f10008i.setSelected(false);
                if (this.f10010k == null) {
                    this.f10010k = AniconContainer.m11640a(R.layout.layout_anicon_container);
                    this.f10010k.m11666a((InterfaceC2778j) this);
                }
                this.f10003d = this.f10010k;
            }
            if (this.f10004e.containsKey(this.f10003d) && this.f10003d != null) {
                this.f10003d.setInitialSavedState(this.f10004e.get(this.f10003d));
            }
            abstractC0069wM50e.mo183a().mo100b(R.id.fragment_container, this.f10003d).mo103c();
        }
    }

    /* renamed from: b */
    private FragmentActivity m11635b() {
        return (FragmentActivity) getContext();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f10006g)) {
            m11634a("emoticon");
        } else if (view.equals(this.f10007h)) {
            m11634a("anicon");
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC2794f
    /* renamed from: a */
    public void mo11636a(EmoticonContainer emoticonContainer, String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("onEmoticonClicked() ", emoticonContainer, ", " + str), f10000a);
        }
        if (this.f10011l != null) {
            this.f10011l.mo8232a(str);
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.anicon.InterfaceC2778j
    /* renamed from: a */
    public void mo11637a(AniconContainer aniconContainer, String str, String str2, String str3) {
        if (C4904y.f17872b) {
            C4904y.m18639b(C5052r.m19199a("onAniconClicked() ", aniconContainer, ", ", str), f10000a);
        }
        if (str2.equals("emoticon")) {
            if (this.f10011l != null) {
                this.f10011l.mo8232a(str);
            }
        } else if (this.f10011l != null) {
            this.f10011l.mo8233a(str, str3);
        }
    }
}
