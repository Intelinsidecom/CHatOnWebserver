package com.sec.chaton.util;

import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.MediaStore;
import android.view.View;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C1833h;
import com.sec.chaton.p027e.C1396an;
import com.sec.chaton.p027e.EnumC1455w;
import com.sec.chaton.settings.downloads.C2646u;
import com.sec.common.CommonApplication;
import com.sec.common.util.C3348j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatONAirButtonAdapter.java */
/* renamed from: com.sec.chaton.util.m */
/* loaded from: classes.dex */
public class C3238m extends SlookAirButtonAdapter {

    /* renamed from: a */
    private static final String f11698a = C3238m.class.getSimpleName();

    /* renamed from: b */
    private EnumC1455w f11699b;

    /* renamed from: c */
    private ArrayList<C3239n> f11700c = new ArrayList<>();

    /* renamed from: d */
    private HashMap<String, Drawable> f11701d = new HashMap<>();

    /* renamed from: e */
    private int f11702e;

    public C3238m(EnumC1455w enumC1455w) {
        this.f11699b = enumC1455w;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onDismiss(View view) {
        Iterator<Map.Entry<String, Drawable>> it = this.f11701d.entrySet().iterator();
        while (it.hasNext()) {
            C3348j.m11795a(it.next().getValue());
        }
        this.f11701d.clear();
        this.f11700c.clear();
        super.onDismiss(view);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onShow(View view) {
        this.f11700c.clear();
        if (this.f11699b == EnumC1455w.IMAGE) {
            m11396a();
        } else if (this.f11699b == EnumC1455w.ANICON) {
            m11395b();
        }
        super.onShow(view);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onHide(View view) {
        this.f11700c.clear();
        super.onHide(view);
    }

    /* renamed from: b */
    private void m11395b() {
        Cursor cursorQuery = GlobalApplication.m11493l().getContentResolver().query(C1396an.f5203a.buildUpon().appendPath("recentused").build(), new String[]{"anicon_id"}, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext() && this.f11700c.size() <= 7) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("anicon_id"));
                    if (string != null) {
                        this.f11700c.add(new C3239n(this, EnumC3240o.ANICON, string, 0, 0L, 0));
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        }
        String[] strArrM11720a = C1833h.m7505b().m11720a();
        int iMin = Math.min(7, strArrM11720a.length);
        for (int i = 0; i < iMin; i++) {
            int iM7503a = C1833h.m7503a(strArrM11720a[i]);
            if (iM7503a > 0) {
                this.f11700c.add(new C3239n(this, EnumC3240o.EMOTICON, strArrM11720a[i], iM7503a, 0L, 0));
            }
        }
        this.f11702e = this.f11700c.size();
    }

    /* renamed from: a */
    public void m11396a() {
        Cursor cursorQuery = GlobalApplication.m11493l().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", null, "orientation"}, null, null, "datetaken DESC LIMIT 15");
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    this.f11700c.add(new C3239n(this, EnumC3240o.IMAGE, cursorQuery.getString(cursorQuery.getColumnIndex("_data")), 0, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")), cursorQuery.getInt(cursorQuery.getColumnIndex("orientation"))));
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        }
        this.f11702e = this.f11700c.size();
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public SlookAirButtonAdapter.AirButtonItem getItem(int i) throws Resources.NotFoundException {
        Drawable drawable;
        BitmapDrawable bitmapDrawable;
        if (C3250y.f11734b) {
            C3250y.m11450b("getItem : " + i, f11698a);
        }
        C3239n c3239n = this.f11700c.get(i);
        if (c3239n.f11703a == EnumC3240o.IMAGE) {
            Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(CommonApplication.m11493l().getContentResolver(), c3239n.f11706d, 3, null);
            Bitmap bitmapM11002a = c3239n.f11707e > 0 ? C3162ad.m11002a(thumbnail, c3239n.f11707e) : thumbnail;
            if (bitmapM11002a == null || bitmapM11002a.isRecycled()) {
                bitmapDrawable = null;
            } else {
                bitmapDrawable = new BitmapDrawable(GlobalApplication.m6451b(), bitmapM11002a);
                if (bitmapDrawable != null) {
                    this.f11701d.put(c3239n.f11704b, bitmapDrawable);
                }
            }
            return new SlookAirButtonAdapter.AirButtonItem(bitmapDrawable, null, c3239n.f11704b);
        }
        if (c3239n.f11703a == EnumC3240o.ANICON) {
            AnimationDrawable animationDrawableM9654b = C2646u.m9654b(CommonApplication.m11493l(), c3239n.f11704b);
            if (animationDrawableM9654b != null) {
                this.f11701d.put(c3239n.f11704b, animationDrawableM9654b);
            }
            return new SlookAirButtonAdapter.AirButtonItem(animationDrawableM9654b, null, c3239n.f11704b);
        }
        if (c3239n.f11703a != EnumC3240o.EMOTICON) {
            return null;
        }
        try {
            drawable = GlobalApplication.m6451b().getDrawable(c3239n.f11705c);
        } catch (Resources.NotFoundException e) {
            C3250y.m11443a(e, f11698a);
            drawable = null;
        }
        return new SlookAirButtonAdapter.AirButtonItem(drawable, null, c3239n.f11704b);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public int getCount() {
        return this.f11702e;
    }
}
