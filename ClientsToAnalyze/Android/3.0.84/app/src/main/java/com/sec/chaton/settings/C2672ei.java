package com.sec.chaton.settings;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p027e.p028a.C1353ab;
import com.sec.chaton.util.C3159aa;
import com.sec.chaton.util.C3162ad;
import com.sec.chaton.util.C3223ck;
import com.sec.chaton.util.C3250y;
import com.sec.common.p069e.C3326c;
import java.io.File;

/* compiled from: FragmentSkinChange3Adapter.java */
/* renamed from: com.sec.chaton.settings.ei */
/* loaded from: classes.dex */
public class C2672ei extends CursorAdapter {

    /* renamed from: f */
    private static BitmapDrawable f9939f;

    /* renamed from: a */
    LayoutInflater f9940a;

    /* renamed from: b */
    private Context f9941b;

    /* renamed from: c */
    private int f9942c;

    /* renamed from: d */
    private C3326c f9943d;

    /* renamed from: e */
    private File f9944e;

    public C2672ei(Context context, Cursor cursor, C3326c c3326c) {
        super(context, cursor);
        this.f9941b = context;
        this.f9943d = c3326c;
        this.f9940a = (LayoutInflater) context.getSystemService("layout_inflater");
        if (C3223ck.m11327a()) {
            this.f9944e = new File(GlobalApplication.m6447a().getExternalFilesDir(null).getAbsolutePath() + "/skins/");
        } else {
            this.f9944e = null;
        }
    }

    /* renamed from: a */
    public void m9678a(int i) {
        this.f9942c = i;
    }

    /* renamed from: a */
    public BitmapDrawable m9677a() {
        try {
            if (C3223ck.m11327a() && this.f9944e != null) {
                if (f9939f == null) {
                    f9939f = new BitmapDrawable(C3162ad.m10997a(this.f9941b, Uri.parse(this.f9944e + "/skin_myskin.png_")));
                }
                return f9939f;
            }
            return new BitmapDrawable(BitmapFactory.decodeResource(this.f9941b.getResources(), R.drawable.download_default));
        } catch (Exception e) {
            C3250y.m11443a(e, getClass().getSimpleName());
            return new BitmapDrawable(BitmapFactory.decodeResource(this.f9941b.getResources(), R.drawable.download_default));
        }
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        if (this.f9942c == FragmentSkinChange3.f9173b) {
            C2673ej c2673ej = (C2673ej) view.getTag();
            c2673ej.f9948d.setVisibility(8);
            c2673ej.f9949e.setVisibility(0);
            c2673ej.f9945a = cursor.getString(cursor.getColumnIndex("item_id"));
            if (C3159aa.m10962a().m10979a("setting_change_bubble_receive", "-1").equals(c2673ej.f9945a)) {
                c2673ej.f9952h.setVisibility(0);
            } else {
                c2673ej.f9952h.setVisibility(8);
            }
            this.f9943d.m11730a(c2673ej.f9951g, new C2478cl("recv_" + c2673ej.f9945a, this.f9941b));
            return;
        }
        if (this.f9942c == FragmentSkinChange3.f9172a) {
            C2673ej c2673ej2 = (C2673ej) view.getTag();
            c2673ej2.f9948d.setVisibility(8);
            c2673ej2.f9949e.setVisibility(0);
            c2673ej2.f9945a = cursor.getString(cursor.getColumnIndex("item_id"));
            if (C3159aa.m10962a().m10979a("setting_change_bubble_send", "-1").equals(c2673ej2.f9945a)) {
                c2673ej2.f9952h.setVisibility(0);
            } else {
                c2673ej2.f9952h.setVisibility(8);
            }
            this.f9943d.m11730a(c2673ej2.f9951g, new C2479cm("send_" + c2673ej2.f9945a, this.f9941b));
            return;
        }
        if (this.f9942c == FragmentSkinChange3.f9174c) {
            C2673ej c2673ej3 = (C2673ej) view.getTag();
            c2673ej3.f9948d.setVisibility(0);
            c2673ej3.f9949e.setVisibility(8);
            c2673ej3.f9946b = cursor.getString(cursor.getColumnIndex("item_id"));
            if (c2673ej3.f9946b.equals("skin_add")) {
                this.f9943d.m11732a(c2673ej3.f9950f);
                c2673ej3.f9950f.setImageResource(R.drawable.setting_add);
                c2673ej3.f9950f.setScaleType(ImageView.ScaleType.CENTER);
                c2673ej3.f9947c = "ma";
                c2673ej3.f9952h.setVisibility(8);
                return;
            }
            if (c2673ej3.f9946b.equals("skin_myskin.png_")) {
                this.f9943d.m11732a(c2673ej3.f9950f);
                c2673ej3.f9947c = "ma";
                c2673ej3.f9950f.setImageDrawable(m9677a());
                c2673ej3.f9950f.setScaleType(ImageView.ScaleType.FIT_XY);
                f9939f = null;
            } else {
                try {
                    c2673ej3.f9947c = C1353ab.m5964a(cursor.getString(cursor.getColumnIndex("extras"))).m5971b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f9943d.m11730a(c2673ej3.f9950f, new C2477ck("bg_" + c2673ej3.f9946b, this.f9941b));
                c2673ej3.f9950f.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            if (C3159aa.m10962a().m10979a("setting_change_skin", "-1").equals(c2673ej3.f9946b)) {
                c2673ej3.f9952h.setVisibility(0);
            } else {
                c2673ej3.f9952h.setVisibility(8);
            }
        }
    }

    @Override // android.support.v4.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        C2673ej c2673ej = new C2673ej();
        View viewInflate = this.f9940a.inflate(R.layout.item_skin_bg_bubble, viewGroup, false);
        c2673ej.f9950f = (ImageView) viewInflate.findViewById(R.id.skin_bg);
        c2673ej.f9951g = (ImageView) viewInflate.findViewById(R.id.skin_bubble);
        c2673ej.f9948d = (LinearLayout) viewInflate.findViewById(R.id.layout_bg);
        c2673ej.f9949e = (LinearLayout) viewInflate.findViewById(R.id.layout_bubble);
        c2673ej.f9952h = (ImageView) viewInflate.findViewById(R.id.frame_check);
        viewInflate.setTag(c2673ej);
        return viewInflate;
    }
}
