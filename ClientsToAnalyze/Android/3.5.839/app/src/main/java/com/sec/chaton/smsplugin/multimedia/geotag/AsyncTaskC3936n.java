package com.sec.chaton.smsplugin.multimedia.geotag;

import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.R;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.IOException;
import java.util.List;

/* compiled from: MmsGeotagActivity.java */
/* renamed from: com.sec.chaton.smsplugin.multimedia.geotag.n */
/* loaded from: classes.dex */
class AsyncTaskC3936n extends AsyncTask<String, Void, List<Address>> {

    /* renamed from: a */
    final /* synthetic */ MmsGeotagActivity f14164a;

    private AsyncTaskC3936n(MmsGeotagActivity mmsGeotagActivity) {
        this.f14164a = mmsGeotagActivity;
    }

    /* synthetic */ AsyncTaskC3936n(MmsGeotagActivity mmsGeotagActivity, C3924b c3924b) {
        this(mmsGeotagActivity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<Address> doInBackground(String... strArr) {
        try {
            return new Geocoder(this.f14164a).getFromLocationName(strArr[0], 5);
        } catch (IOException e) {
            C3890m.m14995a(MmsGeotagActivity.f14114b, e.getMessage(), e);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        super.onCancelled();
        if (!this.f14164a.f14146x) {
            this.f14164a.f14120F.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(List<Address> list) {
        super.onPostExecute(list);
        if (!this.f14164a.f14146x) {
            this.f14164a.f14120F.dismiss();
            if (list == null || list.size() <= 0) {
                Toast.makeText(this.f14164a.f14125c, R.string.no_geo_point, 0).show();
                return;
            }
            this.f14164a.f14140r = this.f14164a.f14117C;
            GeoPoint geoPoint = null;
            if (list.get(0) == null) {
                C3890m.m14996b(MmsGeotagActivity.f14114b, "addresses.get(0) may not be null");
            } else {
                geoPoint = new GeoPoint((int) (list.get(0).getLatitude() * 1000000.0d), (int) (list.get(0).getLongitude() * 1000000.0d));
            }
            this.f14164a.f14135m = geoPoint;
            this.f14164a.f14131i.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, Spam.CATEGORY_DEFAULT, "Searched location");
            this.f14164a.f14134l.m15182b(overlayItem);
            this.f14164a.f14134l.m15181a(overlayItem);
            this.f14164a.f14133k.clear();
            this.f14164a.f14133k.add(this.f14164a.f14134l);
            this.f14164a.f14143u.setEnabled(true);
        }
    }
}
