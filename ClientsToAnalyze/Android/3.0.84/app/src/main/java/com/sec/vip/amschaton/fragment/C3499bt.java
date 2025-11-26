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

/* compiled from: AMSListFragment.java */
/* renamed from: com.sec.vip.amschaton.fragment.bt */
/* loaded from: classes.dex */
class C3499bt extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSListFragment f12883a;

    /* renamed from: b */
    private boolean[] f12884b;

    /* renamed from: d */
    private C3493bn f12886d;

    /* renamed from: e */
    private C3493bn f12887e;

    /* renamed from: f */
    private C3493bn f12888f;

    /* renamed from: c */
    private Handler f12885c = null;

    /* renamed from: g */
    private final View.OnClickListener f12889g = new ViewOnClickListenerC3500bu(this);

    /* renamed from: h */
    private final View.OnClickListener f12890h = new ViewOnClickListenerC3501bv(this);

    public C3499bt(AMSListFragment aMSListFragment, Context context) {
        this.f12883a = aMSListFragment;
        this.f12884b = null;
        this.f12886d = null;
        this.f12887e = null;
        this.f12888f = null;
        this.f12884b = new boolean[aMSListFragment.m12571h() + aMSListFragment.m12574i()];
        m12725a(false);
        this.f12886d = new C3493bn(aMSListFragment, context, 5000);
        this.f12887e = new C3493bn(aMSListFragment, context, 5001);
        this.f12888f = new C3493bn(aMSListFragment, context, 5002);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f12883a.m12571h() + this.f12883a.m12574i() + this.f12883a.m12576j() > 0) {
            return this.f12883a.f12728a == 2002 ? this.f12883a.m12571h() + this.f12883a.m12574i() + this.f12883a.m12576j() : this.f12883a.m12571h() + this.f12883a.m12574i() + this.f12883a.m12576j() + 1;
        }
        return 0;
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
        C3502bw c3502bw;
        if (view == null) {
            C3502bw c3502bw2 = new C3502bw(this, null);
            view = this.f12883a.getActivity().getLayoutInflater().inflate(R.layout.ams_ics_list_item_contents, viewGroup, false);
            c3502bw2.f12893a = (RelativeLayout) view.findViewById(R.id.layout_checkbox);
            c3502bw2.f12894b = (ImageView) view.findViewById(R.id.image_ams_image);
            c3502bw2.f12895c = (CheckBox) view.findViewById(R.id.checkbox_delete);
            view.setTag(c3502bw2);
            c3502bw = c3502bw2;
        } else {
            c3502bw = (C3502bw) view.getTag();
        }
        c3502bw.f12893a.setVisibility(8);
        c3502bw.f12894b.setScaleType(ImageView.ScaleType.FIT_CENTER);
        if (this.f12883a.f12728a == 2002) {
            if (i < 0 || i >= this.f12883a.m12571h()) {
                if (i < this.f12883a.m12571h() || i >= this.f12883a.m12571h() + this.f12883a.m12574i()) {
                    if (i >= this.f12883a.m12571h() + this.f12883a.m12574i() && i < this.f12883a.m12571h() + this.f12883a.m12574i() + this.f12883a.m12576j()) {
                        this.f12888f.m12713a((i - this.f12883a.m12571h()) - this.f12883a.m12574i(), c3502bw.f12894b);
                    }
                } else {
                    int iM12571h = i - this.f12883a.m12571h();
                    c3502bw.f12893a.setVisibility(0);
                    c3502bw.f12893a.setId(i);
                    c3502bw.f12893a.setOnClickListener(this.f12890h);
                    c3502bw.f12895c.setId(i);
                    c3502bw.f12895c.setOnClickListener(this.f12889g);
                    c3502bw.f12895c.setChecked(this.f12884b[i]);
                    this.f12887e.m12713a(iM12571h, c3502bw.f12894b);
                }
            } else {
                c3502bw.f12893a.setVisibility(0);
                c3502bw.f12893a.setId(i);
                c3502bw.f12893a.setOnClickListener(this.f12890h);
                c3502bw.f12895c.setId(i);
                c3502bw.f12895c.setOnClickListener(this.f12889g);
                c3502bw.f12895c.setChecked(this.f12884b[i]);
                this.f12886d.m12713a(i, c3502bw.f12894b);
            }
        } else if (i == 0) {
            c3502bw.f12894b.setScaleType(ImageView.ScaleType.CENTER);
            c3502bw.f12894b.setImageResource(R.drawable.setting_add);
        } else if (i <= 0 || i >= this.f12883a.m12571h() + 1) {
            if (i <= this.f12883a.m12571h() || i >= this.f12883a.m12571h() + this.f12883a.m12574i() + 1) {
                if (i > this.f12883a.m12571h() + this.f12883a.m12574i() && i < this.f12883a.m12571h() + this.f12883a.m12574i() + this.f12883a.m12576j() + 1) {
                    this.f12888f.m12713a(((i - this.f12883a.m12571h()) - this.f12883a.m12574i()) - 1, c3502bw.f12894b);
                }
            } else {
                this.f12887e.m12713a((i - this.f12883a.m12571h()) - 1, c3502bw.f12894b);
            }
        } else {
            this.f12886d.m12713a(i - 1, c3502bw.f12894b);
        }
        return view;
    }

    /* renamed from: a */
    public void m12724a(Handler handler) {
        this.f12885c = handler;
    }

    /* renamed from: a */
    public boolean[] m12726a() {
        return this.f12884b;
    }

    /* renamed from: a */
    public void m12725a(boolean z) {
        if (this.f12884b != null) {
            for (int i = 0; i < this.f12884b.length; i++) {
                this.f12884b[i] = z;
            }
            m12722c();
        }
    }

    /* renamed from: a */
    public void m12723a(int i) {
        if (this.f12884b != null && i >= 0 && i < this.f12884b.length) {
            this.f12884b[i] = !this.f12884b[i];
            m12722c();
        }
    }

    /* renamed from: b */
    public void m12727b() {
        if (this.f12885c != null) {
            int count = getCount() - 1;
            if (this.f12883a.f12728a == 2002) {
                count = getCount();
            }
            Message message = new Message();
            message.what = 1001;
            message.arg1 = count;
            this.f12885c.sendMessage(message);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m12722c() {
        if (this.f12885c != null) {
            Message message = new Message();
            message.what = 1000;
            boolean z = true;
            boolean z2 = false;
            for (int i = 0; i < this.f12884b.length; i++) {
                if (this.f12884b[i]) {
                    z2 = true;
                } else {
                    z = false;
                }
            }
            message.arg1 = z2 ? 1 : 0;
            message.arg2 = z ? 1 : 0;
            this.f12885c.sendMessage(message);
            this.f12883a.getActivity().supportInvalidateOptionsMenu();
        }
    }
}
