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
import com.sec.vip.amschaton.C1364aa;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.ics.aw */
/* loaded from: classes.dex */
class C1492aw extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f5307a;

    /* renamed from: b */
    private C1364aa f5308b;

    /* renamed from: c */
    private boolean[] f5309c;

    /* renamed from: d */
    private Handler f5310d = null;

    /* renamed from: e */
    private final View.OnClickListener f5311e = new ViewOnClickListenerC1469a(this);

    public C1492aw(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f5307a = aMSMyWorksActivity;
        this.f5308b = null;
        this.f5309c = null;
        this.f5308b = C1364aa.m4865a();
        this.f5309c = new boolean[this.f5308b.m4882c()];
        m5607b();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f5308b == null) {
            return 0;
        }
        return this.f5308b.m4882c();
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
        C1537s c1537s;
        Bitmap bitmap;
        if (view == null) {
            c1537s = new C1537s(this, null);
            view = this.f5307a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_contents, viewGroup, false);
            c1537s.f5365a = (ImageView) view.findViewById(R.id.image_ams_image);
            c1537s.f5366b = (CheckBox) view.findViewById(R.id.check_box_delete);
            view.setTag(c1537s);
        } else {
            c1537s = (C1537s) view.getTag();
        }
        c1537s.f5366b.setId(i);
        c1537s.f5366b.setOnClickListener(this.f5311e);
        if (this.f5307a.f5229p != null && (bitmap = (Bitmap) this.f5307a.f5229p.get(i)) != null) {
            c1537s.f5365a.setImageBitmap(bitmap);
        } else {
            c1537s.f5365a.setImageResource(R.drawable.attach_ams);
        }
        c1537s.f5366b.setChecked(this.f5309c[i]);
        c1537s.f5366b.setVisibility(this.f5307a.f5227n ? 0 : 8);
        return view;
    }

    /* renamed from: a */
    public void m5605a(Handler handler) {
        this.f5310d = handler;
    }

    /* renamed from: a */
    public boolean[] m5606a() {
        return this.f5309c;
    }

    /* renamed from: b */
    public void m5607b() {
        if (this.f5309c != null) {
            for (int i = 0; i < this.f5309c.length; i++) {
                this.f5309c[i] = false;
            }
        }
    }

    /* renamed from: c */
    public void m5608c() {
        if (this.f5310d != null && getCount() == 0) {
            Message message = new Message();
            message.what = 1001;
            message.arg1 = 0;
            this.f5310d.sendMessage(message);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5604d() {
        Message message = new Message();
        message.what = 1001;
        for (int i = 0; i < this.f5309c.length; i++) {
            if (this.f5309c[i]) {
                message.arg1 = 1;
                this.f5310d.sendMessage(message);
                return;
            }
        }
        message.arg1 = 0;
        this.f5310d.sendMessage(message);
    }
}
