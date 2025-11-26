package com.sec.chaton.multimedia.geotag;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.util.C3250y;
import java.util.ArrayList;

/* compiled from: GeoOverlay.java */
/* renamed from: com.sec.chaton.multimedia.geotag.a */
/* loaded from: classes.dex */
public class C1836a extends ItemizedOverlay {

    /* renamed from: a */
    private ArrayList<OverlayItem> f6859a;

    /* renamed from: b */
    private GeotagActivity f6860b;

    public C1836a(Drawable drawable, GeotagActivity geotagActivity) {
        super(boundCenterBottom(drawable));
        this.f6859a = new ArrayList<>();
        this.f6860b = geotagActivity;
    }

    /* renamed from: a */
    public void m7548a(OverlayItem overlayItem) {
        this.f6859a.add(overlayItem);
        populate();
    }

    /* renamed from: b */
    public void m7549b(OverlayItem overlayItem) {
        this.f6859a.clear();
        populate();
    }

    protected OverlayItem createItem(int i) {
        return this.f6859a.get(i);
    }

    public int size() {
        return this.f6859a.size();
    }

    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        if (!super.onTap(geoPoint, mapView)) {
            C3250y.m11441a(geoPoint);
            this.f6860b.m7544a(geoPoint);
            this.f6860b.m7546b();
            return true;
        }
        return true;
    }

    public void draw(Canvas canvas, MapView mapView, boolean z) {
        super.draw(canvas, mapView, false);
        this.f6860b.m7543a();
    }
}
