package com.sec.chaton.multimedia.emoticon;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.multimedia.emoticon.ams.AmsContainer;
import com.sec.chaton.multimedia.emoticon.ams.EnumC1807d;
import com.sec.chaton.multimedia.emoticon.ams.InterfaceC1806c;
import com.sec.chaton.multimedia.emoticon.anicon.AniconContainer;
import com.sec.chaton.multimedia.emoticon.anicon.InterfaceC1819i;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.util.C3364o;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class EmoticonSelectionView extends FrameLayout implements View.OnClickListener, InterfaceC1806c, InterfaceC1819i, InterfaceC1831f {

    /* renamed from: a */
    private static final String f6708a = EmoticonSelectionView.class.getSimpleName();

    /* renamed from: b */
    private Context f6709b;

    /* renamed from: c */
    private String f6710c;

    /* renamed from: d */
    private Fragment f6711d;

    /* renamed from: e */
    private Map<Fragment, Fragment.SavedState> f6712e;

    /* renamed from: f */
    private RelativeLayout f6713f;

    /* renamed from: g */
    private ImageButton f6714g;

    /* renamed from: h */
    private ImageButton f6715h;

    /* renamed from: i */
    private ImageButton f6716i;

    /* renamed from: j */
    private EmoticonContainer f6717j;

    /* renamed from: k */
    private AniconContainer f6718k;

    /* renamed from: l */
    private AmsContainer f6719l;

    /* renamed from: m */
    private InterfaceC1834i f6720m;

    public EmoticonSelectionView(Context context) {
        super(context);
        this.f6710c = null;
        this.f6711d = null;
        this.f6709b = context;
        m7436a();
    }

    public EmoticonSelectionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6710c = null;
        this.f6711d = null;
        this.f6709b = context;
        m7436a();
    }

    public EmoticonSelectionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6710c = null;
        this.f6711d = null;
        this.f6709b = context;
        m7436a();
    }

    public void setEmoticonSelectedListener(InterfaceC1834i interfaceC1834i) {
        this.f6720m = interfaceC1834i;
    }

    /* renamed from: a */
    private void m7436a() {
        if (C3250y.f11734b) {
            C3250y.m11450b("EmoticonSelectionView.initialize()", f6708a);
        }
        this.f6712e = new HashMap();
        View viewInflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.layout_emoticon_selection_view, (ViewGroup) this, true);
        this.f6713f = (RelativeLayout) viewInflate.findViewById(R.id.header);
        this.f6714g = (ImageButton) viewInflate.findViewById(R.id.emoticonButton);
        this.f6715h = (ImageButton) viewInflate.findViewById(R.id.ticonButton);
        this.f6716i = (ImageButton) viewInflate.findViewById(R.id.amsButton);
        this.f6714g.setOnClickListener(this);
        this.f6715h.setOnClickListener(this);
        this.f6716i.setOnClickListener(this);
        m7437a("anicon");
    }

    /* renamed from: a */
    public void m7439a(View view) {
        if (C3250y.f11734b) {
            C3250y.m11450b("EmoticonSelectionView.initializeForPhone()", f6708a);
        }
        this.f6713f.setVisibility(8);
        this.f6714g = (ImageButton) view.findViewById(R.id.emoticonButton);
        this.f6715h = (ImageButton) view.findViewById(R.id.ticonButton);
        this.f6716i = (ImageButton) view.findViewById(R.id.amsButton);
        this.f6714g.setOnClickListener(this);
        this.f6715h.setOnClickListener(this);
        this.f6716i.setOnClickListener(this);
        this.f6714g.setSelected(false);
        this.f6715h.setSelected(true);
        this.f6716i.setSelected(false);
    }

    /* renamed from: a */
    private void m7437a(String str) {
        if (!C3223ck.m11331e() && "animessage".equals(str)) {
            AbstractC3271a.m11494a(this.f6709b).mo11495a(R.string.pop_up_attention).mo11506b(R.string.popup_not_enough_memory).mo11515d(R.string.dialog_ok, null).mo11512b();
            return;
        }
        if (TextUtils.isEmpty(this.f6710c) || !this.f6710c.equals(str)) {
            FragmentManager supportFragmentManager = m7438b().getSupportFragmentManager();
            try {
                supportFragmentManager.executePendingTransactions();
            } catch (IllegalStateException e) {
            }
            if (this.f6711d != null) {
                this.f6712e.put(this.f6711d, supportFragmentManager.saveFragmentInstanceState(this.f6711d));
            }
            if ("emoticon".equals(str)) {
                this.f6710c = "emoticon";
                this.f6715h.setSelected(false);
                this.f6714g.setSelected(true);
                this.f6716i.setSelected(false);
                if (this.f6717j == null) {
                    this.f6717j = EmoticonContainer.m7432a(R.layout.layout_emoticon_container, false);
                    this.f6717j.m7434a(this);
                }
                this.f6711d = this.f6717j;
            } else if ("anicon".equals(str)) {
                this.f6710c = "anicon";
                this.f6714g.setSelected(false);
                this.f6715h.setSelected(true);
                this.f6716i.setSelected(false);
                if (this.f6718k == null) {
                    this.f6718k = AniconContainer.m7458a(R.layout.layout_anicon_container);
                    this.f6718k.m7472a(this);
                }
                this.f6711d = this.f6718k;
            } else if ("animessage".equals(str)) {
                this.f6710c = "animessage";
                this.f6714g.setSelected(false);
                this.f6715h.setSelected(false);
                this.f6716i.setSelected(true);
                if (this.f6719l == null) {
                    this.f6719l = AmsContainer.m7444a();
                    this.f6719l.m7446a(this);
                }
                this.f6711d = this.f6719l;
            }
            if (this.f6712e.containsKey(this.f6711d)) {
                this.f6711d.setInitialSavedState(this.f6712e.get(this.f6711d));
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, this.f6711d).commit();
        }
    }

    /* renamed from: b */
    private FragmentActivity m7438b() {
        return (FragmentActivity) getContext();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.f6714g)) {
            m7437a("emoticon");
        } else if (view.equals(this.f6715h)) {
            m7437a("anicon");
        } else if (view.equals(this.f6716i)) {
            m7437a("animessage");
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.InterfaceC1831f
    /* renamed from: a */
    public void mo7440a(EmoticonContainer emoticonContainer, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("onEmoticonClicked() ", emoticonContainer, ", " + str), f6708a);
        }
        if (this.f6720m != null) {
            this.f6720m.mo4977a(str);
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.anicon.InterfaceC1819i
    /* renamed from: a */
    public void mo7443a(AniconContainer aniconContainer, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("onAniconClicked() ", aniconContainer, ", ", str), f6708a);
        }
        if (this.f6720m != null) {
            this.f6720m.mo4986b(str);
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.ams.InterfaceC1806c
    /* renamed from: a */
    public void mo7441a(AmsContainer amsContainer) {
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("onCreateNewAmsItem() ", amsContainer), f6708a);
        }
        if (this.f6720m != null) {
            this.f6720m.mo5011l();
        }
    }

    @Override // com.sec.chaton.multimedia.emoticon.ams.InterfaceC1806c
    /* renamed from: a */
    public void mo7442a(AmsContainer amsContainer, EnumC1807d enumC1807d, String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b(C3364o.m11849a("onAmsItemClicked() ", amsContainer, ", ", str), f6708a);
        }
        if (this.f6720m != null) {
            this.f6720m.mo4974a(enumC1807d, str);
        }
    }
}
