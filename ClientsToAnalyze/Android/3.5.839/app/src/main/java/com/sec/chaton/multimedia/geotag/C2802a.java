package com.sec.chaton.multimedia.geotag;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.util.C4904y;
import java.util.ArrayList;

/* compiled from: GeoOverlay.java */
/* renamed from: com.sec.chaton.multimedia.geotag.a */
/* loaded from: classes.dex */
public class C2802a extends ItemizedOverlay {

    /* renamed from: a */
    private ArrayList<OverlayItem> f10153a;

    /* renamed from: b */
    private GeotagActivity f10154b;

    public C2802a(Drawable drawable, GeotagActivity geotagActivity) {
        super(boundCenterBottom(drawable));
        this.f10153a = new ArrayList<>();
        this.f10154b = geotagActivity;
    }

    /* renamed from: a */
    public void m11753a(OverlayItem overlayItem) {
        this.f10153a.add(overlayItem);
        populate();
    }

    /* renamed from: b */
    public void m11754b(OverlayItem overlayItem) {
        this.f10153a.clear();
        populate();
    }

    protected OverlayItem createItem(int i) {
        return this.f10153a.get(i);
    }

    public int size() {
        return this.f10153a.size();
    }

    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        if (!super.onTap(geoPoint, mapView)) {
            C4904y.m18633a(geoPoint);
            this.f10154b.m11749a(geoPoint);
            this.f10154b.m11751b();
            return true;
        }
        return true;
    }

    public void draw(Canvas canvas, MapView mapView, boolean z) {
        super.draw(canvas, mapView, false);
        this.f10154b.m11748a();
    }
}
