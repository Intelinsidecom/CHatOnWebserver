package com.sec.chaton.multimedia.geotag;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.R;
import com.sec.chaton.util.C3250y;
import com.sec.widget.C3641ai;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.m */
/* loaded from: classes.dex */
class AsyncTaskC1848m extends AsyncTask<String, Void, List<Address>> {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f6872a;

    /* renamed from: b */
    private boolean f6873b;

    /* renamed from: c */
    private double f6874c;

    /* renamed from: d */
    private double f6875d;

    public AsyncTaskC1848m(GeotagActivity geotagActivity, boolean z, double d, double d2) {
        this.f6872a = geotagActivity;
        this.f6873b = z;
        this.f6874c = d;
        this.f6875d = d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003a -> B:15:0x001b). Please report as a decompilation issue!!! */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Address> doInBackground(String... strArr) throws IOException {
        List<Address> fromLocation;
        Geocoder geocoder;
        try {
            geocoder = new Geocoder(this.f6872a.f6835c, Locale.getDefault());
        } catch (IOException e) {
            if (C3250y.f11737e) {
                C3250y.m11443a(e, GeotagActivity.f6826b);
            }
        }
        if (!this.f6873b) {
            if (this.f6872a.f6831E == null) {
                fromLocation = geocoder.getFromLocation(this.f6874c, this.f6875d, 1);
            } else {
                fromLocation = null;
            }
        } else {
            fromLocation = geocoder.getFromLocationName(strArr[0], 5);
        }
        return fromLocation;
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (!this.f6872a.f6858z) {
            this.f6872a.f6837e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<Address> list) {
        Address address;
        super.onPostExecute(list);
        if (!this.f6872a.f6858z) {
            this.f6872a.f6837e.dismiss();
            if (!this.f6873b) {
                if (this.f6872a.f6831E == null && list != null && list.size() > 0 && (address = list.get(0)) != null) {
                    this.f6872a.f6852t = address.getAddressLine(0);
                }
                Intent intent = new Intent();
                intent.putExtra("GEOPOINT", this.f6874c + "," + this.f6875d);
                intent.putExtra("GEOADDRESS", this.f6872a.f6852t);
                this.f6872a.setResult(-1, intent);
                this.f6872a.finish();
                return;
            }
            if (list == null || list.size() <= 0) {
                C3641ai.m13210a(this.f6872a.f6835c, R.string.no_geo_point, 0).show();
                return;
            }
            this.f6872a.f6852t = this.f6872a.f6831E;
            GeoPoint geoPoint = new GeoPoint((int) (list.get(0).getLatitude() * 1000000.0d), (int) (list.get(0).getLongitude() * 1000000.0d));
            this.f6872a.f6846n = geoPoint;
            this.f6872a.f6851s = this.f6872a.f6846n;
            this.f6872a.f6842j.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Searched location");
            this.f6872a.f6845m.m7549b(overlayItem);
            this.f6872a.f6845m.m7548a(overlayItem);
            this.f6872a.f6844l.clear();
            this.f6872a.f6844l.add(this.f6872a.f6845m);
            this.f6872a.f6855w.setEnabled(true);
        }
    }
}
