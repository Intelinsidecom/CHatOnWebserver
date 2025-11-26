package com.sec.vip.amschaton.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;

/* compiled from: AMSStampSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.cw */
/* loaded from: classes.dex */
public class C3529cw extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSStampSelectionFragment f12936a;

    /* renamed from: b */
    private boolean[] f12937b;

    /* renamed from: d */
    private C3526ct f12939d;

    /* renamed from: e */
    private C3526ct f12940e;

    /* renamed from: f */
    private C3526ct f12941f;

    /* renamed from: g */
    private C3526ct f12942g;

    /* renamed from: c */
    private Handler f12938c = null;

    /* renamed from: h */
    private final View.OnClickListener f12943h = new ViewOnClickListenerC3530cx(this);

    /* renamed from: i */
    private final View.OnClickListener f12944i = new ViewOnClickListenerC3531cy(this);

    public C3529cw(AMSStampSelectionFragment aMSStampSelectionFragment, Context context) {
        this.f12936a = aMSStampSelectionFragment;
        this.f12937b = null;
        this.f12939d = null;
        this.f12940e = null;
        this.f12941f = null;
        this.f12942g = null;
        this.f12937b = new boolean[aMSStampSelectionFragment.m12645m() + aMSStampSelectionFragment.m12647n() + aMSStampSelectionFragment.m12651p()];
        m12737a(false);
        this.f12939d = new C3526ct(aMSStampSelectionFragment, context, 5000);
        this.f12940e = new C3526ct(aMSStampSelectionFragment, context, 5001);
        this.f12941f = new C3526ct(aMSStampSelectionFragment, context, 5002);
        this.f12942g = new C3526ct(aMSStampSelectionFragment, context, 5003);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f12936a.f12754m == 2002 ? this.f12936a.m12645m() + this.f12936a.m12647n() + this.f12936a.m12649o() + this.f12936a.m12651p() : this.f12936a.m12645m() + this.f12936a.m12647n() + this.f12936a.m12649o() + this.f12936a.m12651p() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3532cz c3532cz;
        if (view == null) {
            C3532cz c3532cz2 = new C3532cz(this, null);
            view = this.f12936a.getActivity().getLayoutInflater().inflate(R.layout.ams_ics_list_item_stamp, viewGroup, false);
            c3532cz2.f12947a = (RelativeLayout) view.findViewById(R.id.layout_create_stamp);
            c3532cz2.f12948b = (RelativeLayout) view.findViewById(R.id.layout_basic_stamp);
            c3532cz2.f12949c = (RelativeLayout) view.findViewById(R.id.layout_checkbox);
            c3532cz2.f12950d = (ImageView) view.findViewById(R.id.image_basic_stamp);
            if (GlobalApplication.m6456e()) {
                c3532cz2.f12950d.setScaleType(ImageView.ScaleType.CENTER);
            }
            c3532cz2.f12951e = (CheckBox) view.findViewById(R.id.checkbox_delete);
            view.setTag(c3532cz2);
            c3532cz = c3532cz2;
        } else {
            c3532cz = (C3532cz) view.getTag();
        }
        c3532cz.f12949c.setVisibility(8);
        if (this.f12936a.f12754m == 2002) {
            i++;
        }
        if (i == 0) {
            c3532cz.f12947a.setVisibility(this.f12936a.f12754m == 2002 ? 4 : 0);
            c3532cz.f12948b.setVisibility(4);
        } else {
            c3532cz.f12947a.setVisibility(4);
            c3532cz.f12948b.setVisibility(0);
            int i2 = i - 1;
            if (i2 >= 0 && i2 < this.f12936a.m12649o() + this.f12936a.m12647n() + this.f12936a.m12651p() + this.f12936a.m12645m()) {
                if (i2 >= this.f12936a.m12645m()) {
                    if (i2 < this.f12936a.m12645m() || i2 >= this.f12936a.m12645m() + this.f12936a.m12651p()) {
                        if (i2 < this.f12936a.m12645m() + this.f12936a.m12651p() || i2 >= this.f12936a.m12645m() + this.f12936a.m12651p() + this.f12936a.m12647n()) {
                            if (i2 >= this.f12936a.m12645m() + this.f12936a.m12651p() + this.f12936a.m12647n() && i2 < this.f12936a.m12645m() + this.f12936a.m12651p() + this.f12936a.m12647n() + this.f12936a.m12649o()) {
                                this.f12941f.m12731a(((i2 - this.f12936a.m12645m()) - this.f12936a.m12651p()) - this.f12936a.m12647n(), c3532cz.f12950d);
                            }
                        } else {
                            this.f12940e.m12731a((i2 - this.f12936a.m12645m()) - this.f12936a.m12651p(), c3532cz.f12950d);
                            if (this.f12936a.f12754m == 2002) {
                                c3532cz.f12949c.setVisibility(0);
                                c3532cz.f12949c.setId(i2);
                                c3532cz.f12949c.setOnClickListener(this.f12944i);
                                c3532cz.f12951e.setId(i2);
                                c3532cz.f12951e.setOnClickListener(this.f12943h);
                                c3532cz.f12951e.setChecked(this.f12937b[i2]);
                            }
                        }
                    } else {
                        this.f12942g.m12731a(i2 - this.f12936a.m12645m(), c3532cz.f12950d);
                        if (this.f12936a.f12754m == 2002) {
                            c3532cz.f12949c.setVisibility(0);
                            c3532cz.f12949c.setId(i2);
                            c3532cz.f12949c.setOnClickListener(this.f12944i);
                            c3532cz.f12951e.setId(i2);
                            c3532cz.f12951e.setOnClickListener(this.f12943h);
                            c3532cz.f12951e.setChecked(this.f12937b[i2]);
                        }
                    }
                } else {
                    this.f12939d.m12731a(i2, c3532cz.f12950d);
                    if (this.f12936a.f12754m == 2002) {
                        c3532cz.f12949c.setVisibility(0);
                        c3532cz.f12949c.setId(i2);
                        c3532cz.f12949c.setOnClickListener(this.f12944i);
                        c3532cz.f12951e.setId(i2);
                        c3532cz.f12951e.setOnClickListener(this.f12943h);
                        c3532cz.f12951e.setChecked(this.f12937b[i2]);
                    }
                }
                c3532cz.f12948b.setSelected(this.f12936a.f12751a == i2);
            }
        }
        return view;
    }

    /* renamed from: a */
    public void m12736a(Handler handler) {
        this.f12938c = handler;
    }

    /* renamed from: a */
    public boolean[] m12738a() {
        return this.f12937b;
    }

    /* renamed from: a */
    public void m12737a(boolean z) {
        if (this.f12937b != null) {
            for (int i = 0; i < this.f12937b.length; i++) {
                this.f12937b[i] = z;
            }
            m12734c();
        }
    }

    /* renamed from: a */
    public void m12735a(int i) {
        if (this.f12937b != null && i >= 0 && i < this.f12937b.length) {
            this.f12937b[i] = !this.f12937b[i];
            m12734c();
        }
    }

    /* renamed from: b */
    public void m12739b() {
        if (this.f12938c != null) {
            int count = (getCount() - this.f12936a.m12649o()) - 1;
            Message message = new Message();
            message.what = 1001;
            message.arg1 = count;
            this.f12938c.sendMessage(message);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12734c() {
        if (this.f12938c != null) {
            Message message = new Message();
            message.what = 1000;
            boolean z = true;
            boolean z2 = false;
            for (int i = 0; i < this.f12937b.length; i++) {
                if (this.f12937b[i]) {
                    z2 = true;
                } else {
                    z = false;
                }
            }
            message.arg1 = z2 ? 1 : 0;
            message.arg2 = z ? 1 : 0;
            this.f12938c.sendMessage(message);
        }
    }
}
