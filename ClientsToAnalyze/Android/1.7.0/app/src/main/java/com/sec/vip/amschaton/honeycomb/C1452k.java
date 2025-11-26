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
import com.sec.vip.amschaton.C1364aa;

/* compiled from: AMSMyWorksActivity.java */
/* renamed from: com.sec.vip.amschaton.honeycomb.k */
/* loaded from: classes.dex */
class C1452k extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSMyWorksActivity f5092a;

    /* renamed from: b */
    private C1364aa f5093b;

    /* renamed from: c */
    private boolean[] f5094c;

    /* renamed from: d */
    private Handler f5095d = null;

    /* renamed from: e */
    private final View.OnClickListener f5096e = new ViewOnClickListenerC1428ax(this);

    public C1452k(AMSMyWorksActivity aMSMyWorksActivity) {
        this.f5092a = aMSMyWorksActivity;
        this.f5093b = null;
        this.f5094c = null;
        this.f5093b = C1364aa.m4865a();
        this.f5094c = new boolean[this.f5093b.m4882c()];
        m5279b();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f5093b == null) {
            return 0;
        }
        return this.f5093b.m4882c();
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
        C1443bl c1443bl;
        Bitmap bitmap;
        if (view == null) {
            c1443bl = new C1443bl(this, null);
            view = this.f5092a.getLayoutInflater().inflate(R.layout.ams_ics_list_item_contents, viewGroup, false);
            c1443bl.f5080a = (ImageView) view.findViewById(R.id.image_ams_image);
            c1443bl.f5081b = (CheckBox) view.findViewById(R.id.check_box_delete);
            view.setTag(c1443bl);
        } else {
            c1443bl = (C1443bl) view.getTag();
        }
        c1443bl.f5081b.setId(i);
        c1443bl.f5081b.setOnClickListener(this.f5096e);
        if (this.f5092a.f4984r != null && (bitmap = (Bitmap) this.f5092a.f4984r.get(i)) != null) {
            c1443bl.f5080a.setImageBitmap(bitmap);
        } else {
            c1443bl.f5080a.setImageResource(R.drawable.attach_ams);
        }
        c1443bl.f5081b.setChecked(this.f5094c[i]);
        if (this.f5092a.f4980n) {
            c1443bl.f5081b.setVisibility(0);
        } else {
            c1443bl.f5081b.setVisibility(8);
        }
        return view;
    }

    /* renamed from: a */
    public void m5277a(Handler handler) {
        this.f5095d = handler;
    }

    /* renamed from: a */
    public boolean[] m5278a() {
        return this.f5094c;
    }

    /* renamed from: b */
    public void m5279b() {
        if (this.f5094c != null) {
            for (int i = 0; i < this.f5094c.length; i++) {
                this.f5094c[i] = false;
            }
        }
    }

    /* renamed from: c */
    public void m5280c() {
        if (this.f5095d != null && getCount() == 0) {
            Message message = new Message();
            message.what = 1001;
            message.arg1 = 0;
            this.f5095d.sendMessage(message);
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m5276d() {
        Message message = new Message();
        message.what = 1001;
        for (int i = 0; i < this.f5094c.length; i++) {
            if (this.f5094c[i]) {
                message.arg1 = 1;
                this.f5095d.sendMessage(message);
                return;
            }
        }
        message.arg1 = 0;
        this.f5095d.sendMessage(message);
    }
}
