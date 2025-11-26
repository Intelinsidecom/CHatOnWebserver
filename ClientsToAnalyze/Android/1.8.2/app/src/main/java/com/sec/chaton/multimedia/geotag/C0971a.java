package com.sec.chaton.multimedia.geotag;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.util.C1786r;
import java.util.ArrayList;

/* compiled from: GeoOverlay.java */
/* renamed from: com.sec.chaton.multimedia.geotag.a */
/* loaded from: classes.dex */
public class C0971a extends ItemizedOverlay {

    /* renamed from: a */
    private ArrayList f3589a;

    /* renamed from: b */
    private GeotagActivity f3590b;

    public C0971a(Drawable drawable, GeotagActivity geotagActivity) {
        super(boundCenter(drawable));
        this.f3589a = new ArrayList();
        this.f3590b = geotagActivity;
    }

    /* renamed from: a */
    public void m3854a(OverlayItem overlayItem) {
        this.f3589a.add(overlayItem);
        populate();
    }

    /* renamed from: b */
    public void m3855b(OverlayItem overlayItem) {
        this.f3589a.clear();
        populate();
    }

    protected OverlayItem createItem(int i) {
        return (OverlayItem) this.f3589a.get(i);
    }

    public int size() {
        return this.f3589a.size();
    }

    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        if (!super.onTap(geoPoint, mapView)) {
            C1786r.m6053a(geoPoint);
            this.f3590b.m3852a(geoPoint);
            return true;
        }
        return true;
    }

    public void draw(Canvas canvas, MapView mapView, boolean z) {
        super.draw(canvas, mapView, false);
    }
}
