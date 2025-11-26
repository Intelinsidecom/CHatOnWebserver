package com.sec.vip.amschaton;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.vip.amschaton.av */
/* loaded from: classes.dex */
class C0648av extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSFileListActivity f4258a;

    /* renamed from: b */
    private AMSFileManager f4259b;

    /* renamed from: c */
    private boolean[] f4260c;

    /* renamed from: d */
    private Handler f4261d = null;

    /* renamed from: e */
    private final View.OnClickListener f4262e = new ViewOnClickListenerC0652az(this);

    public C0648av(AMSFileListActivity aMSFileListActivity) {
        this.f4258a = aMSFileListActivity;
        this.f4259b = null;
        this.f4260c = null;
        this.f4259b = AMSFileManager.m3931a();
        this.f4260c = new boolean[this.f4259b.m3948c()];
        m4227b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m4224d() {
        Message message = new Message();
        message.what = 1001;
        for (int i = 0; i < this.f4260c.length; i++) {
            if (this.f4260c[i]) {
                message.arg1 = 1;
                this.f4261d.sendMessage(message);
                return;
            }
        }
        message.arg1 = 0;
        this.f4261d.sendMessage(message);
    }

    /* renamed from: a */
    public void m4225a(Handler handler) {
        this.f4261d = handler;
    }

    /* renamed from: a */
    public boolean[] m4226a() {
        return this.f4260c;
    }

    /* renamed from: b */
    public void m4227b() {
        if (this.f4260c == null) {
            return;
        }
        for (int i = 0; i < this.f4260c.length; i++) {
            this.f4260c[i] = false;
        }
    }

    /* renamed from: c */
    public void m4228c() {
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f4259b == null) {
            return 0;
        }
        return this.f4259b.m3948c() + 1;
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
        C0703f c0703f;
        View view2;
        Bitmap bitmapM3902b;
        if (view == null) {
            C0703f c0703f2 = new C0703f(this, null);
            View viewInflate = this.f4258a.getLayoutInflater().inflate(C0062R.layout.ams_file_list_item, viewGroup, false);
            c0703f2.f4324a = (LinearLayout) viewInflate.findViewById(C0062R.id.layout_create_new);
            c0703f2.f4325b = (RelativeLayout) viewInflate.findViewById(C0062R.id.layout_ams_image);
            c0703f2.f4326c = (ImageView) viewInflate.findViewById(C0062R.id.image_ams_image);
            c0703f2.f4327d = (CheckBox) viewInflate.findViewById(C0062R.id.check_box_delete);
            viewInflate.setTag(c0703f2);
            c0703f = c0703f2;
            view2 = viewInflate;
        } else {
            c0703f = (C0703f) view.getTag();
            view2 = view;
        }
        c0703f.f4325b.setBackgroundResource(C0062R.drawable.ams_grid_selector_memo);
        if (i == 0) {
            if (this.f4258a.f3947p) {
                c0703f.f4324a.setVisibility(4);
            } else {
                c0703f.f4324a.setVisibility(0);
                c0703f.f4324a.setOnClickListener(new ViewOnClickListenerC0654ba(this));
            }
            c0703f.f4325b.setVisibility(8);
            c0703f.f4327d.setVisibility(8);
        } else {
            int i2 = i - 1;
            c0703f.f4324a.setVisibility(8);
            c0703f.f4325b.setVisibility(0);
            c0703f.f4327d.setId(i2);
            c0703f.f4327d.setOnClickListener(this.f4262e);
            AMSFileInfo aMSFileInfoM3950d = this.f4259b.m3950d(i2);
            if (aMSFileInfoM3950d == null || (bitmapM3902b = aMSFileInfoM3950d.m3902b()) == null) {
                c0703f.f4326c.setImageResource(C0062R.drawable.attach_ani_message);
            } else {
                c0703f.f4326c.setImageBitmap(bitmapM3902b);
            }
            c0703f.f4327d.setChecked(this.f4260c[i2]);
            if (this.f4258a.f3947p) {
                c0703f.f4327d.setVisibility(0);
            } else {
                c0703f.f4327d.setVisibility(8);
            }
        }
        return view2;
    }
}
