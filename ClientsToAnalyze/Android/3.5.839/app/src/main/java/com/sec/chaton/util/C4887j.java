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
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.multimedia.emoticon.C2797i;
import com.sec.chaton.p057e.C2255ba;
import com.sec.chaton.p057e.EnumC2214ab;
import com.sec.chaton.settings.p096a.C3460d;
import com.sec.common.CommonApplication;
import com.sec.common.util.C5035l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ChatONAirButtonAdapter.java */
/* renamed from: com.sec.chaton.util.j */
/* loaded from: classes.dex */
public class C4887j extends SlookAirButtonAdapter {

    /* renamed from: a */
    private static final String f17814a = C4887j.class.getSimpleName();

    /* renamed from: b */
    private EnumC2214ab f17815b;

    /* renamed from: c */
    private ArrayList<C4888k> f17816c = new ArrayList<>();

    /* renamed from: d */
    private HashMap<String, Drawable> f17817d = new HashMap<>();

    /* renamed from: e */
    private int f17818e;

    public C4887j(EnumC2214ab enumC2214ab) {
        this.f17815b = enumC2214ab;
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onDismiss(View view) {
        Iterator<Map.Entry<String, Drawable>> it = this.f17817d.entrySet().iterator();
        while (it.hasNext()) {
            C5035l.m19113a(it.next().getValue());
        }
        this.f17817d.clear();
        this.f17816c.clear();
        super.onDismiss(view);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onShow(View view) {
        this.f17816c.clear();
        if (this.f17815b == EnumC2214ab.IMAGE) {
            m18547a();
        } else if (this.f17815b == EnumC2214ab.ANICON) {
            m18546b();
        }
        super.onShow(view);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public void onHide(View view) {
        this.f17816c.clear();
        super.onHide(view);
    }

    /* renamed from: b */
    private void m18546b() {
        Cursor cursorQuery = GlobalApplication.m18732r().getContentResolver().query(C2255ba.f8038a.buildUpon().appendPath("recentused").build(), new String[]{"anicon_id"}, null, null, null);
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext() && this.f17816c.size() <= 7) {
                try {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("anicon_id"));
                    if (string != null) {
                        this.f17816c.add(new C4888k(this, EnumC4889l.ANICON, string, 0, 0L, 0));
                    }
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        }
        String[] strArrMo11703a = C2797i.m11705a().mo11703a();
        int iMin = Math.min(7, strArrMo11703a.length);
        for (int i = 0; i < iMin; i++) {
            int iM11704a = C2797i.m11704a(strArrMo11703a[i]);
            if (iM11704a > 0) {
                this.f17816c.add(new C4888k(this, EnumC4889l.EMOTICON, strArrMo11703a[i], iM11704a, 0L, 0));
            }
        }
        this.f17818e = this.f17816c.size();
    }

    /* renamed from: a */
    public void m18547a() {
        Cursor cursorQuery = GlobalApplication.m18732r().getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_data", "_id", null, "orientation"}, null, null, "datetaken DESC LIMIT 15");
        if (cursorQuery != null) {
            while (cursorQuery.moveToNext()) {
                try {
                    this.f17816c.add(new C4888k(this, EnumC4889l.IMAGE, cursorQuery.getString(cursorQuery.getColumnIndex("_data")), 0, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")), cursorQuery.getInt(cursorQuery.getColumnIndex("orientation"))));
                } finally {
                    if (cursorQuery != null) {
                        cursorQuery.close();
                    }
                }
            }
        }
        this.f17818e = this.f17816c.size();
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public SlookAirButtonAdapter.AirButtonItem getItem(int i) throws Resources.NotFoundException {
        Drawable drawable;
        BitmapDrawable bitmapDrawable;
        if (C4904y.f17872b) {
            C4904y.m18639b("getItem : " + i, f17814a);
        }
        C4888k c4888k = this.f17816c.get(i);
        if (c4888k.f17819a == EnumC4889l.IMAGE) {
            Bitmap thumbnail = MediaStore.Images.Thumbnails.getThumbnail(CommonApplication.m18732r().getContentResolver(), c4888k.f17822d, 3, null);
            Bitmap bitmapM18147a = (c4888k.f17823e <= 0 || thumbnail == null) ? thumbnail : C4812ad.m18147a(thumbnail, c4888k.f17823e);
            if (bitmapM18147a == null || bitmapM18147a.isRecycled()) {
                bitmapDrawable = null;
            } else {
                bitmapDrawable = new BitmapDrawable(GlobalApplication.m10283b(), bitmapM18147a);
                if (bitmapDrawable != null) {
                    this.f17817d.put(c4888k.f17820b, bitmapDrawable);
                }
            }
            return new SlookAirButtonAdapter.AirButtonItem(bitmapDrawable, null, c4888k.f17820b);
        }
        if (c4888k.f17819a == EnumC4889l.ANICON) {
            AnimationDrawable animationDrawableM13772b = C3460d.m13772b(CommonApplication.m18732r(), c4888k.f17820b);
            if (animationDrawableM13772b != null) {
                this.f17817d.put(c4888k.f17820b, animationDrawableM13772b);
                return new SlookAirButtonAdapter.AirButtonItem(animationDrawableM13772b, null, c4888k.f17820b);
            }
            return new SlookAirButtonAdapter.AirButtonItem(CommonApplication.m18732r().getResources().getDrawable(R.drawable.anicon_broken), null, c4888k.f17820b);
        }
        if (c4888k.f17819a != EnumC4889l.EMOTICON) {
            return null;
        }
        try {
            drawable = GlobalApplication.m10283b().getDrawable(c4888k.f17821c);
        } catch (Resources.NotFoundException e) {
            C4904y.m18635a(e, f17814a);
            drawable = null;
        }
        return new SlookAirButtonAdapter.AirButtonItem(drawable, null, c4888k.f17820b);
    }

    @Override // com.samsung.android.sdk.look.airbutton.SlookAirButtonAdapter
    public int getCount() {
        return this.f17818e;
    }
}
