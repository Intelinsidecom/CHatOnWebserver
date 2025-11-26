package com.sec.chaton.multimedia.geotag;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.util.C1341p;
import java.util.ArrayList;

/* compiled from: GeoOverlay.java */
/* renamed from: com.sec.chaton.multimedia.geotag.a */
/* loaded from: classes.dex */
public class C0797a extends ItemizedOverlay {

    /* renamed from: a */
    private ArrayList f2728a;

    /* renamed from: b */
    private GeotagActivity f2729b;

    public C0797a(Drawable drawable, GeotagActivity geotagActivity) {
        super(boundCenter(drawable));
        this.f2728a = new ArrayList();
        this.f2729b = geotagActivity;
    }

    /* renamed from: a */
    public void m3299a(OverlayItem overlayItem) {
        this.f2728a.add(overlayItem);
        populate();
    }

    /* renamed from: b */
    public void m3300b(OverlayItem overlayItem) {
        this.f2728a.clear();
        populate();
    }

    protected OverlayItem createItem(int i) {
        return (OverlayItem) this.f2728a.get(i);
    }

    public int size() {
        return this.f2728a.size();
    }

    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        if (!super.onTap(geoPoint, mapView)) {
            C1341p.m4650a(geoPoint);
            this.f2729b.m3296a(geoPoint);
            this.f2729b.m3298b();
            return true;
        }
        return true;
    }

    public void draw(Canvas canvas, MapView mapView, boolean z) {
        super.draw(canvas, mapView, false);
    }
}
