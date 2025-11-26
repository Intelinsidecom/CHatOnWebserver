package com.sec.chaton.settings;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.v4.widget.AbstractC0243c;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.p058a.C2183ai;
import com.sec.chaton.util.C4809aa;
import com.sec.chaton.util.C4812ad;
import com.sec.chaton.util.C4873ck;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.SelectableImageView;
import com.sec.common.p132g.C5007c;
import java.io.File;

/* compiled from: FragmentSkinChange3Adapter.java */
/* renamed from: com.sec.chaton.settings.fe */
/* loaded from: classes.dex */
public class C3622fe extends AbstractC0243c {

    /* renamed from: j */
    LayoutInflater f13156j;

    /* renamed from: k */
    private Context f13157k;

    /* renamed from: l */
    private int f13158l;

    /* renamed from: m */
    private C5007c f13159m;

    /* renamed from: n */
    private File f13160n;

    /* renamed from: o */
    private BitmapDrawable f13161o;

    public C3622fe(Context context, Cursor cursor, C5007c c5007c) {
        super(context, cursor);
        this.f13157k = context;
        this.f13159m = c5007c;
        this.f13156j = (LayoutInflater) context.getSystemService("layout_inflater");
        if (C4873ck.m18500a()) {
            this.f13160n = new File(GlobalApplication.m10279a().getExternalFilesDir(null).getAbsolutePath() + "/skins/");
        } else {
            this.f13160n = null;
        }
    }

    /* renamed from: c */
    public void m13902c() {
        this.f13161o = null;
    }

    /* renamed from: a */
    public void m13901a(int i) {
        this.f13158l = i;
    }

    /* renamed from: d */
    public BitmapDrawable m13903d() {
        try {
            if (C4873ck.m18500a() && this.f13160n != null) {
                if (this.f13161o == null) {
                    this.f13161o = new BitmapDrawable(C4812ad.m18142a(this.f13157k, Uri.parse(this.f13160n + "/skin_myskin.png_")));
                }
                return this.f13161o;
            }
            return new BitmapDrawable(BitmapFactory.decodeResource(this.f13157k.getResources(), R.drawable.image_broken));
        } catch (Exception e) {
            C4904y.m18635a(e, getClass().getSimpleName());
            return new BitmapDrawable(BitmapFactory.decodeResource(this.f13157k.getResources(), R.drawable.image_broken));
        }
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) {
        if (this.f13158l == FragmentSkinChange3.f12734b) {
            C3623ff c3623ff = (C3623ff) view.getTag();
            c3623ff.f13166e.setVisibility(8);
            c3623ff.f13167f.setVisibility(0);
            c3623ff.f13162a = cursor.getString(cursor.getColumnIndex("item_id"));
            String strM18121a = C4809aa.m18104a().m18121a("setting_change_bubble_receive", "-1");
            c3623ff.f13165d = cursor.getString(cursor.getColumnIndex("item_type"));
            if (strM18121a.equals(c3623ff.f13162a)) {
                c3623ff.f13170i.setVisibility(0);
            } else {
                c3623ff.f13170i.setVisibility(8);
            }
            this.f13159m.m19023b(c3623ff.f13169h, new C3573dj("recv_" + c3623ff.f13162a, this.f13157k));
            return;
        }
        if (this.f13158l == FragmentSkinChange3.f12733a) {
            C3623ff c3623ff2 = (C3623ff) view.getTag();
            c3623ff2.f13166e.setVisibility(8);
            c3623ff2.f13167f.setVisibility(0);
            c3623ff2.f13162a = cursor.getString(cursor.getColumnIndex("item_id"));
            String strM18121a2 = C4809aa.m18104a().m18121a("setting_change_bubble_send", "-1");
            c3623ff2.f13165d = cursor.getString(cursor.getColumnIndex("item_type"));
            if (strM18121a2.equals(c3623ff2.f13162a)) {
                c3623ff2.f13170i.setVisibility(0);
            } else {
                c3623ff2.f13170i.setVisibility(8);
            }
            this.f13159m.m19023b(c3623ff2.f13169h, new C3574dk("send_" + c3623ff2.f13162a, this.f13157k));
            return;
        }
        if (this.f13158l == FragmentSkinChange3.f12735c) {
            C3623ff c3623ff3 = (C3623ff) view.getTag();
            c3623ff3.f13166e.setVisibility(0);
            c3623ff3.f13167f.setVisibility(8);
            c3623ff3.f13163b = cursor.getString(cursor.getColumnIndex("item_id"));
            c3623ff3.f13165d = cursor.getString(cursor.getColumnIndex("item_type"));
            if (c3623ff3.f13163b.equals("skin_add")) {
                this.f13159m.m19015a((View) c3623ff3.f13168g);
                c3623ff3.f13168g.setImageResource(R.drawable.setting_add);
                c3623ff3.f13168g.setScaleType(ImageView.ScaleType.CENTER);
                c3623ff3.f13164c = "ma";
                c3623ff3.f13170i.setVisibility(8);
                return;
            }
            if (c3623ff3.f13163b.equals("skin_myskin.png_")) {
                this.f13159m.m19015a((View) c3623ff3.f13168g);
                c3623ff3.f13164c = "ma";
                c3623ff3.f13168g.setImageDrawable(m13903d());
                c3623ff3.f13168g.setScaleType(ImageView.ScaleType.FIT_XY);
            } else {
                try {
                    c3623ff3.f13164c = C2183ai.m9746a(cursor.getString(cursor.getColumnIndex("extras"))).m9752a();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f13159m.m19023b(c3623ff3.f13168g, new C3572di("bg_" + c3623ff3.f13163b, c3623ff3.f13165d, this.f13157k));
                c3623ff3.f13168g.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            if (C4809aa.m18104a().m18121a("setting_change_skin", "-1").equals(c3623ff3.f13163b)) {
                c3623ff3.f13170i.setVisibility(0);
            } else {
                c3623ff3.f13170i.setVisibility(8);
            }
        }
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public View mo873a(Context context, Cursor cursor, ViewGroup viewGroup) {
        C3623ff c3623ff = new C3623ff();
        View viewInflate = this.f13156j.inflate(R.layout.item_skin_bg_bubble, viewGroup, false);
        c3623ff.f13168g = (SelectableImageView) viewInflate.findViewById(R.id.skin_bg);
        c3623ff.f13168g.setFocusable(false);
        c3623ff.f13168g.setClickable(false);
        c3623ff.f13169h = (ImageView) viewInflate.findViewById(R.id.skin_bubble);
        SelectableImageView selectableImageView = (SelectableImageView) viewInflate.findViewById(R.id.skin_bubble_selector);
        selectableImageView.setFocusable(false);
        selectableImageView.setClickable(false);
        c3623ff.f13166e = (LinearLayout) viewInflate.findViewById(R.id.layout_bg);
        c3623ff.f13167f = (LinearLayout) viewInflate.findViewById(R.id.layout_bubble);
        c3623ff.f13170i = (ImageView) viewInflate.findViewById(R.id.frame_check);
        viewInflate.setTag(c3623ff);
        return viewInflate;
    }
}
