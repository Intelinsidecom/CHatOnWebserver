package com.sec.vip.amschaton.fragment;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.sec.chaton.R;

/* compiled from: AMSBgSelectionFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.t */
/* loaded from: classes.dex */
public class C3567t extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSBgSelectionFragment f13007a;

    /* renamed from: b */
    private boolean[] f13008b;

    /* renamed from: d */
    private C3561n f13010d;

    /* renamed from: e */
    private C3561n f13011e;

    /* renamed from: c */
    private Handler f13009c = null;

    /* renamed from: f */
    private final View.OnClickListener f13012f = new ViewOnClickListenerC3568u(this);

    /* renamed from: g */
    private final View.OnClickListener f13013g = new ViewOnClickListenerC3569v(this);

    public C3567t(AMSBgSelectionFragment aMSBgSelectionFragment, Context context) {
        this.f13007a = aMSBgSelectionFragment;
        this.f13008b = null;
        this.f13010d = null;
        this.f13011e = null;
        this.f13008b = new boolean[aMSBgSelectionFragment.m12409n()];
        m12755a(false);
        this.f13010d = new C3561n(aMSBgSelectionFragment, context, 5000);
        this.f13011e = new C3561n(aMSBgSelectionFragment, context, 5001);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C3570w c3570w;
        if (view == null) {
            C3570w c3570w2 = new C3570w(this, null);
            view = this.f13007a.getActivity().getLayoutInflater().inflate(R.layout.ams_ics_list_item_frame, viewGroup, false);
            c3570w2.f13016a = (RelativeLayout) view.findViewById(R.id.layout_checkbox);
            c3570w2.f13017b = (ImageView) view.findViewById(R.id.image_frame);
            c3570w2.f13018c = (CheckBox) view.findViewById(R.id.checkbox_delete);
            view.setTag(c3570w2);
            c3570w = c3570w2;
        } else {
            c3570w = (C3570w) view.getTag();
        }
        c3570w.f13016a.setVisibility(8);
        c3570w.f13017b.setScaleType(ImageView.ScaleType.FIT_CENTER);
        c3570w.f13017b.setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout_add);
        linearLayout.setVisibility(8);
        LinearLayout linearLayout2 = (LinearLayout) view.findViewById(R.id.layout_none);
        linearLayout2.setVisibility(8);
        if (this.f13007a.f12646v == 3002) {
            if (i != 0) {
                if (i >= this.f13007a.m12409n() + 1) {
                    if (i < this.f13007a.m12409n() + this.f13007a.m12411o() + 1) {
                        this.f13011e.m12747a((i - this.f13007a.m12409n()) - 1, c3570w.f13017b);
                    } else {
                        c3570w.f13017b.setImageResource(R.drawable.ams_tool_color_full);
                    }
                } else {
                    int i2 = i - 1;
                    c3570w.f13016a.setVisibility(0);
                    c3570w.f13016a.setId(i2);
                    c3570w.f13016a.setOnClickListener(this.f13013g);
                    c3570w.f13018c.setId(i2);
                    c3570w.f13018c.setOnClickListener(this.f13012f);
                    c3570w.f13018c.setChecked(this.f13008b[i2]);
                    this.f13010d.m12747a(i2, c3570w.f13017b);
                }
            } else {
                linearLayout2.setVisibility(0);
                c3570w.f13017b.setVisibility(8);
            }
        } else if (i == 0) {
            linearLayout.setVisibility(0);
            c3570w.f13017b.setVisibility(8);
        } else if (i != 1) {
            if (i >= this.f13007a.m12409n() + 2) {
                if (i < this.f13007a.m12409n() + this.f13007a.m12411o() + 2) {
                    this.f13011e.m12747a((i - this.f13007a.m12409n()) - 2, c3570w.f13017b);
                } else {
                    c3570w.f13017b.setImageResource(R.drawable.ams_tool_color_full);
                }
            } else {
                this.f13010d.m12747a(i - 2, c3570w.f13017b);
            }
        } else {
            linearLayout2.setVisibility(0);
            c3570w.f13017b.setVisibility(8);
        }
        return view;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13007a.f12646v == 3002 ? ((this.f13007a.m12409n() + this.f13007a.m12411o()) + 3) - 1 : this.f13007a.m12409n() + this.f13007a.m12411o() + 3;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* renamed from: a */
    public void m12754a(Handler handler) {
        this.f13009c = handler;
    }

    /* renamed from: a */
    public boolean[] m12756a() {
        return this.f13008b;
    }

    /* renamed from: a */
    public void m12755a(boolean z) {
        if (this.f13008b != null) {
            for (int i = 0; i < this.f13008b.length; i++) {
                this.f13008b[i] = z;
            }
            m12752c();
        }
    }

    /* renamed from: a */
    public void m12753a(int i) {
        if (this.f13008b != null && i >= 0 && i < this.f13008b.length) {
            this.f13008b[i] = !this.f13008b[i];
            m12752c();
        }
    }

    /* renamed from: b */
    public void m12757b() {
        if (this.f13009c != null) {
            int count = (getCount() - this.f13007a.m12411o()) - 3;
            Message message = new Message();
            message.what = 2001;
            message.arg1 = count;
            this.f13009c.sendMessage(message);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12752c() {
        if (this.f13009c != null) {
            Message message = new Message();
            message.what = 2000;
            boolean z = true;
            boolean z2 = false;
            for (int i = 0; i < this.f13008b.length; i++) {
                if (this.f13008b[i]) {
                    z2 = true;
                } else {
                    z = false;
                }
            }
            message.arg1 = z2 ? 1 : 0;
            message.arg2 = z ? 1 : 0;
            this.f13009c.sendMessage(message);
        }
    }
}
