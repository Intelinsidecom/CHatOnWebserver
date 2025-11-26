package com.sec.vip.amschaton;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.sec.chaton.C0062R;

/* renamed from: com.sec.vip.amschaton.bl */
/* loaded from: classes.dex */
class C0665bl extends BaseAdapter {

    /* renamed from: a */
    final /* synthetic */ AMSFileListActivity f4285a;

    /* renamed from: b */
    private AMSFileManager f4286b;

    public C0665bl(AMSFileListActivity aMSFileListActivity) {
        this.f4285a = aMSFileListActivity;
        this.f4286b = null;
        this.f4286b = AMSFileManager.m3931a();
    }

    /* renamed from: a */
    public void m4229a() {
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f4286b == null) {
            return 0;
        }
        return this.f4286b.m3945b();
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
        C0713p c0713p;
        View view2;
        if (view == null) {
            C0713p c0713p2 = new C0713p(this, null);
            View viewInflate = this.f4285a.getLayoutInflater().inflate(C0062R.layout.ams_file_list_item, viewGroup, false);
            c0713p2.f4344a = (LinearLayout) viewInflate.findViewById(C0062R.id.layout_create_new);
            c0713p2.f4345b = (RelativeLayout) viewInflate.findViewById(C0062R.id.layout_ams_image);
            c0713p2.f4346c = (ImageView) viewInflate.findViewById(C0062R.id.image_ams_image);
            c0713p2.f4347d = (CheckBox) viewInflate.findViewById(C0062R.id.check_box_delete);
            viewInflate.setTag(c0713p2);
            c0713p = c0713p2;
            view2 = viewInflate;
        } else {
            c0713p = (C0713p) view.getTag();
            view2 = view;
        }
        c0713p.f4345b.setBackgroundResource(C0062R.drawable.ams_grid_selector_memo);
        AMSFileInfo aMSFileInfoM3943a = this.f4286b.m3943a(i);
        if (aMSFileInfoM3943a == null || aMSFileInfoM3943a.m3902b() == null) {
            c0713p.f4346c.setImageResource(C0062R.drawable.attach_ani_message);
        } else {
            c0713p.f4346c.setImageBitmap(this.f4286b.m3943a(i).m3902b());
        }
        c0713p.f4347d.setVisibility(8);
        c0713p.f4344a.setVisibility(8);
        return view2;
    }
}
