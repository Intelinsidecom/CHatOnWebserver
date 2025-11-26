package com.sec.vip.amschaton.ics;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.sec.chaton.R;
import com.sec.vip.amschaton.C2064n;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.aq */
/* loaded from: classes.dex */
class C1994aq extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f7268a;

    /* renamed from: b */
    private C2064n f7269b;

    /* renamed from: c */
    private boolean[] f7270c;

    /* renamed from: d */
    private Handler f7271d = null;

    /* renamed from: e */
    private final View.OnClickListener f7272e = new ViewOnClickListenerC1995ar(this);

    public C1994aq(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f7268a = aMSMyWorksActivity;
        this.f7269b = null;
        this.f7270c = null;
        this.f7269b = C2064n.m7173a();
        this.f7270c = new boolean[this.f7269b.m7190c()];
        m7165b();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7269b == null) {
            return 0;
        }
        return this.f7269b.m7190c();
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
        C1996as c1996as;
        Bitmap bitmap;
        if (view == null) {
            c1996as = new C1996as(this, null);
            view = this.f7268a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_contents, viewGroup, false);
            c1996as.f7274a = (ImageView) view.findViewById(R.id.image_ams_image);
            c1996as.f7275b = (CheckBox) view.findViewById(R.id.check_box_delete);
            view.setTag(c1996as);
        } else {
            c1996as = (C1996as) view.getTag();
        }
        c1996as.f7275b.setId(i);
        c1996as.f7275b.setOnClickListener(this.f7272e);
        if (this.f7268a.f7199q != null && (bitmap = (Bitmap) this.f7268a.f7199q.get(i)) != null) {
            c1996as.f7274a.setImageBitmap(bitmap);
        } else {
            c1996as.f7274a.setImageResource(R.drawable.attach_ams);
        }
        c1996as.f7275b.setChecked(this.f7270c[i]);
        if (this.f7268a.f7197o) {
            c1996as.f7275b.setVisibility(0);
        } else {
            c1996as.f7275b.setVisibility(8);
        }
        return view;
    }

    /* renamed from: a */
    public void m7163a(Handler handler) {
        this.f7271d = handler;
    }

    /* renamed from: a */
    public boolean[] m7164a() {
        return this.f7270c;
    }

    /* renamed from: b */
    public void m7165b() {
        if (this.f7270c != null) {
            for (int i = 0; i < this.f7270c.length; i++) {
                this.f7270c[i] = false;
            }
        }
    }

    /* renamed from: c */
    public void m7166c() {
        if (this.f7271d != null && getCount() == 0) {
            Message message = new Message();
            message.what = 1001;
            message.arg1 = 0;
            this.f7271d.sendMessage(message);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m7162d() {
        Message message = new Message();
        message.what = 1001;
        for (int i = 0; i < this.f7270c.length; i++) {
            if (this.f7270c[i]) {
                message.arg1 = 1;
                this.f7271d.sendMessage(message);
                return;
            }
        }
        message.arg1 = 0;
        this.f7271d.sendMessage(message);
    }
}
