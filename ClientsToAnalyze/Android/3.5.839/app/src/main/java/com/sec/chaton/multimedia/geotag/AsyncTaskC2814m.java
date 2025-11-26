package com.sec.chaton.multimedia.geotag;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.R;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4904y;
import com.sec.widget.C5179v;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/* compiled from: GeotagActivity.java */
/* renamed from: com.sec.chaton.multimedia.geotag.m */
/* loaded from: classes.dex */
class AsyncTaskC2814m extends AsyncTask<String, Void, List<Address>> {

    /* renamed from: a */
    final /* synthetic */ GeotagActivity f10166a;

    /* renamed from: b */
    private boolean f10167b;

    /* renamed from: c */
    private double f10168c;

    /* renamed from: d */
    private double f10169d;

    /* synthetic */ AsyncTaskC2814m(GeotagActivity geotagActivity, boolean z, double d, double d2, ViewOnClickListenerC2803b viewOnClickListenerC2803b) {
        this(geotagActivity, z, d, d2);
    }

    private AsyncTaskC2814m(GeotagActivity geotagActivity, boolean z, double d, double d2) {
        this.f10166a = geotagActivity;
        this.f10167b = z;
        this.f10168c = d;
        this.f10169d = d2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003a -> B:15:0x001b). Please report as a decompilation issue!!! */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Address> doInBackground(String... strArr) throws IOException {
        List<Address> fromLocation;
        Geocoder geocoder;
        try {
            geocoder = new Geocoder(this.f10166a.f10129c, Locale.getDefault());
        } catch (IOException e) {
            if (C4904y.f17875e) {
                C4904y.m18635a(e, GeotagActivity.f10121b);
            }
        }
        if (!this.f10167b) {
            if (this.f10166a.f10126E == null) {
                fromLocation = geocoder.getFromLocation(this.f10168c, this.f10169d, 1);
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
        if (!this.f10166a.f10152z) {
            this.f10166a.f10131e.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<Address> list) {
        Address address;
        super.onPostExecute(list);
        if (!this.f10166a.f10152z) {
            this.f10166a.f10131e.dismiss();
            if (!this.f10167b) {
                if (this.f10166a.f10126E == null && list != null && list.size() > 0 && (address = list.get(0)) != null) {
                    this.f10166a.f10146t = address.getAddressLine(0);
                }
                Intent intent = new Intent();
                intent.putExtra("GEOPOINT", this.f10168c + "," + this.f10169d);
                intent.putExtra("GEOADDRESS", this.f10166a.f10146t);
                this.f10166a.setResult(-1, intent);
                this.f10166a.finish();
                return;
            }
            if (list == null || list.size() <= 0) {
                C5179v.m19810a(this.f10166a.f10129c, R.string.no_geo_point, 0).show();
                return;
            }
            this.f10166a.f10146t = this.f10166a.f10126E;
            GeoPoint geoPoint = new GeoPoint((int) (list.get(0).getLatitude() * 1000000.0d), (int) (list.get(0).getLongitude() * 1000000.0d));
            this.f10166a.f10140n = geoPoint;
            this.f10166a.f10145s = this.f10166a.f10140n;
            this.f10166a.f10136j.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, Spam.CATEGORY_DEFAULT, "Searched location");
            this.f10166a.f10139m.m11754b(overlayItem);
            this.f10166a.f10139m.m11753a(overlayItem);
            this.f10166a.f10138l.clear();
            this.f10166a.f10138l.add(this.f10166a.f10139m);
            if (this.f10166a.f10149w != null) {
                this.f10166a.f10149w.setEnabled(true);
            }
        }
    }
}
