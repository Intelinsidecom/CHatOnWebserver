package com.sec.chaton.multimedia.geotag;

import android.graphics.drawable.Drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.util.ChatONLogWriter;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GeoOverlay extends ItemizedOverlay {

    /* renamed from: a */
    private ArrayList f2138a;

    /* renamed from: b */
    private GeotagActivity f2139b;

    public GeoOverlay(Drawable drawable, GeotagActivity geotagActivity) {
        super(boundCenter(drawable));
        this.f2138a = new ArrayList();
        this.f2139b = geotagActivity;
    }

    /* renamed from: a */
    public void m2533a(OverlayItem overlayItem) {
        this.f2138a.add(overlayItem);
        populate();
    }

    /* renamed from: b */
    public void m2534b(OverlayItem overlayItem) {
        this.f2138a.clear();
        populate();
    }

    protected OverlayItem createItem(int i) {
        return (OverlayItem) this.f2138a.get(i);
    }

    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        ChatONLogWriter.m3498a(geoPoint);
        this.f2139b.m2552a(geoPoint);
        return false;
    }

    public int size() {
        return this.f2138a.size();
    }
}
