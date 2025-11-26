package com.sec.chaton.smsplugin.multimedia.geotag;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.util.ArrayList;

/* compiled from: MmsGeoOverlay.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.a */
/* loaded from: classes.dex */
public class C3923a extends ItemizedOverlay {

    /* renamed from: a */
    private static final String f14149a = C3923a.class.getSimpleName();

    /* renamed from: b */
    private ArrayList<OverlayItem> f14150b;

    /* renamed from: c */
    private MmsGeotagActivity f14151c;

    public C3923a(Drawable drawable, MmsGeotagActivity mmsGeotagActivity) {
        super(boundCenterBottom(drawable));
        this.f14150b = new ArrayList<>();
        this.f14151c = mmsGeotagActivity;
    }

    /* renamed from: a */
    public void m15181a(OverlayItem overlayItem) {
        this.f14150b.add(overlayItem);
        populate();
    }

    /* renamed from: b */
    public void m15182b(OverlayItem overlayItem) {
        this.f14150b.clear();
        populate();
    }

    /* renamed from: a */
    public void m15180a() {
        this.f14150b.clear();
        populate();
    }

    protected OverlayItem createItem(int i) {
        return this.f14150b.get(i);
    }

    public int size() {
        return this.f14150b.size();
    }

    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        if (!super.onTap(geoPoint, mapView)) {
            if (geoPoint != null) {
                C3890m.m14996b(f14149a, geoPoint.toString());
            }
            this.f14151c.m15172a(geoPoint);
            this.f14151c.m15178c();
            return true;
        }
        return true;
    }

    public void draw(Canvas canvas, MapView mapView, boolean z) {
        super.draw(canvas, mapView, false);
        this.f14151c.m15171a();
    }
}
