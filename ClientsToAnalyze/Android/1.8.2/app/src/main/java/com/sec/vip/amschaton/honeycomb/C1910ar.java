package com.sec.vip.amschaton.honeycomb;

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
/* renamed from: com.sec.vip.amschaton.honeycomb.ar */
/* loaded from: classes.dex */
class C1910ar extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f7040a;

    /* renamed from: b */
    private C2064n f7041b;

    /* renamed from: c */
    private boolean[] f7042c;

    /* renamed from: d */
    private Handler f7043d = null;

    /* renamed from: e */
    private final View.OnClickListener f7044e = new ViewOnClickListenerC1911as(this);

    public C1910ar(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f7040a = aMSMyWorksActivity;
        this.f7041b = null;
        this.f7042c = null;
        this.f7041b = C2064n.m7173a();
        this.f7042c = new boolean[this.f7041b.m7190c()];
        m6852b();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f7041b == null) {
            return 0;
        }
        return this.f7041b.m7190c();
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
        C1912at c1912at;
        Bitmap bitmap;
        if (view == null) {
            c1912at = new C1912at(this, null);
            view = this.f7040a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_contents, viewGroup, false);
            c1912at.f7046a = (ImageView) view.findViewById(R.id.image_ams_image);
            c1912at.f7047b = (CheckBox) view.findViewById(R.id.check_box_delete);
            view.setTag(c1912at);
        } else {
            c1912at = (C1912at) view.getTag();
        }
        c1912at.f7047b.setId(i);
        c1912at.f7047b.setOnClickListener(this.f7044e);
        if (this.f7040a.f6968r != null && (bitmap = (Bitmap) this.f7040a.f6968r.get(i)) != null) {
            c1912at.f7046a.setImageBitmap(bitmap);
        } else {
            c1912at.f7046a.setImageResource(R.drawable.attach_ams);
        }
        c1912at.f7047b.setChecked(this.f7042c[i]);
        c1912at.f7047b.setVisibility(this.f7040a.f6966p == 2002 ? 0 : 8);
        return view;
    }

    /* renamed from: a */
    public void m6850a(Handler handler) {
        this.f7043d = handler;
    }

    /* renamed from: a */
    public boolean[] m6851a() {
        return this.f7042c;
    }

    /* renamed from: b */
    public void m6852b() {
        if (this.f7042c != null) {
            for (int i = 0; i < this.f7042c.length; i++) {
                this.f7042c[i] = false;
            }
        }
    }

    /* renamed from: c */
    public void m6853c() {
        if (this.f7043d != null) {
            int count = getCount();
            Message message = new Message();
            message.what = 1001;
            message.arg1 = count;
            this.f7043d.sendMessage(message);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6849d() {
        Message message = new Message();
        message.what = 1000;
        for (int i = 0; i < this.f7042c.length; i++) {
            if (this.f7042c[i]) {
                message.arg1 = 1;
                this.f7043d.sendMessage(message);
                return;
            }
        }
        message.arg1 = 0;
        this.f7043d.sendMessage(message);
    }
}
