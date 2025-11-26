package com.sec.chaton.multimedia.geotag;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.CellLocation;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.chaton.widget.C1356c;
import com.sec.widget.AlertDialogBuilderC1625m;
import com.sec.widget.C1619g;
import com.sec.widget.EditTextWithClearButton;
import com.sec.widget.GeneralHeaderView;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class GeotagActivity extends MapActivity implements LocationListener, View.OnClickListener {

    /* renamed from: a */
    public static final String f2706a = GeotagActivity.class.getSimpleName();

    /* renamed from: c */
    private Context f2708c;

    /* renamed from: d */
    private Bundle f2709d;

    /* renamed from: e */
    private Dialog f2710e;

    /* renamed from: f */
    private LinearLayout f2711f;

    /* renamed from: g */
    private EditTextWithClearButton f2712g;

    /* renamed from: h */
    private ImageButton f2713h;

    /* renamed from: i */
    private Drawable f2714i;

    /* renamed from: j */
    private MapView f2715j;

    /* renamed from: k */
    private MapController f2716k;

    /* renamed from: m */
    private String f2718m;

    /* renamed from: n */
    private List f2719n;

    /* renamed from: o */
    private C0797a f2720o;

    /* renamed from: p */
    private GeoPoint f2721p;

    /* renamed from: q */
    private GeoPoint f2722q;

    /* renamed from: v */
    private GeneralHeaderView f2727v;

    /* renamed from: l */
    private LocationManager f2717l = null;

    /* renamed from: r */
    private boolean f2723r = true;

    /* renamed from: s */
    private boolean f2724s = true;

    /* renamed from: t */
    private boolean f2725t = true;

    /* renamed from: u */
    private GeoPoint f2726u = null;

    /* renamed from: b */
    public final Handler f2707b = new HandlerC0800d(this);

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            C1619g.m5888a(getBaseContext(), R.string.chat_send_recordvodeo_toast_failed, 0).show();
            finish();
            return;
        }
        this.f2708c = this;
        setContentView(R.layout.layout_geotag);
        m3286c();
        if (this.f2723r) {
            m3288d();
        } else {
            m3290e();
        }
    }

    /* renamed from: c */
    private void m3286c() {
        this.f2711f = (LinearLayout) findViewById(R.id.geotag_searcdh_bar);
        this.f2712g = (EditTextWithClearButton) findViewById(R.id.geo_search);
        this.f2712g.setMaxLengthString(R.string.toast_text_max_Length);
        this.f2715j = findViewById(R.id.map);
        this.f2715j.setBuiltInZoomControls(false);
        this.f2716k = this.f2715j.getController();
        this.f2713h = (ImageButton) findViewById(R.id.geo_current);
        this.f2713h.setOnClickListener(this);
        this.f2719n = this.f2715j.getOverlays();
        this.f2714i = getResources().getDrawable(R.drawable.messenger_chat_pin);
        this.f2720o = new C0797a(this.f2714i, this);
        this.f2712g.setOnEditorActionListener(new C0801e(this));
        this.f2712g.setShowSearch(true);
        this.f2717l = (LocationManager) getSystemService("location");
        this.f2727v = (GeneralHeaderView) findViewById(R.id.location_header_view);
        this.f2709d = getIntent().getExtras();
        if (this.f2709d != null && this.f2709d.containsKey("Geo Point")) {
            this.f2723r = false;
            this.f2711f.setVisibility(8);
            this.f2727v.setButtonImageResource(0);
        } else {
            this.f2723r = true;
            this.f2711f.setVisibility(0);
            this.f2727v.setButtonClickListener(new ViewOnClickListenerC0803g(this));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private void m3288d() {
        if (this.f2717l.isProviderEnabled("gps")) {
            LocationProvider provider = this.f2717l.getProvider("gps");
            if (provider != null) {
                this.f2718m = provider.getName();
            }
            m3295a();
            return;
        }
        CellLocation.requestLocationUpdate();
        if (this.f2726u == null) {
        }
        if (this.f2726u != null) {
            m3295a();
        } else {
            new AlertDialogBuilderC1625m(this).setTitle(getResources().getString(R.string.geotag_dialog_findgsp_title_failed_notfound)).setMessage(getResources().getString(R.string.geotag_dialog_findgsp_message_failed_notfound)).setPositiveButton(getResources().getString(R.string.geotag_dialog_findgsp_button_failed_setting), new DialogInterfaceOnClickListenerC0805i(this)).setNegativeButton(getResources().getString(R.string.geotag_dialog_findgsp_button_failed_cancel), new DialogInterfaceOnClickListenerC0802f(this)).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    private void m3290e() {
        String strNextToken = null;
        StringTokenizer stringTokenizer = new StringTokenizer(this.f2709d.getString("Geo Point").toString(), "\n");
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        C1341p.m4663f("*** RECEIVED GEO TAG COORD : " + strNextToken, f2706a);
        if (strNextToken == null) {
            C1619g.m5888a((Context) this, R.string.no_geo_point, 1).show();
            return;
        }
        String[] strArrSplit = strNextToken.split(",");
        GeoPoint geoPoint = new GeoPoint((int) (Double.parseDouble(strArrSplit[0]) * 1000000.0d), (int) (Double.parseDouble(strArrSplit[1]) * 1000000.0d));
        this.f2720o.m3299a(new OverlayItem(geoPoint, "test", "Searched location"));
        this.f2719n.clear();
        this.f2719n.add(this.f2720o);
        this.f2716k.animateTo(geoPoint);
        this.f2716k.setZoom(16);
    }

    protected boolean isRouteDisplayed() {
        return false;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        C1341p.m4663f("onLocationChanged()", f2706a);
        if (this.f2725t) {
            GeoPoint geoPoint = null;
            if (this.f2723r) {
                geoPoint = new GeoPoint((int) (location.getLatitude() * 1000000.0d), (int) (location.getLongitude() * 1000000.0d));
                this.f2721p = geoPoint;
                this.f2722q = geoPoint;
            }
            this.f2716k.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Current location");
            this.f2720o.m3300b(overlayItem);
            this.f2720o.m3299a(overlayItem);
            this.f2719n.clear();
            this.f2719n.add(this.f2720o);
            this.f2710e.dismiss();
            this.f2725t = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m3295a() {
        C1341p.m4663f("requestCurrentLocation()", f2706a);
        if (this.f2718m != null) {
            this.f2717l.requestLocationUpdates(this.f2718m, 0L, 0.0f, this);
            new Handler().postDelayed(new RunnableC0804h(this), 20000L);
        } else if (this.f2726u != null) {
            if (this.f2723r) {
                this.f2721p = this.f2726u;
                this.f2722q = this.f2726u;
            }
            this.f2716k.animateTo(this.f2726u);
            this.f2716k.setZoom(16);
            OverlayItem overlayItem = new OverlayItem(this.f2726u, "test", "Current location");
            this.f2720o.m3300b(overlayItem);
            this.f2720o.m3299a(overlayItem);
            this.f2719n.clear();
            this.f2719n.add(this.f2720o);
            if (this.f2710e != null) {
                this.f2710e.dismiss();
            }
            this.f2725t = false;
        } else {
            try {
                new AlertDialogBuilderC1625m(this).setMessage(R.string.dialog_geo_warning).setPositiveButton(R.string.password_confirm, new DialogInterfaceOnClickListenerC0799c(this)).show();
            } catch (WindowManager.BadTokenException e) {
                e.printStackTrace();
            }
        }
        if (this.f2724s && this.f2718m != null) {
            this.f2710e = new C1356c(this).m4728a(R.string.dialog_geo_loading);
            this.f2710e.show();
            this.f2724s = false;
            Handler handler = new Handler();
            if (this.f2723r && "gps".equals(this.f2718m)) {
                handler.postDelayed(new RunnableC0798b(this), 10000L);
            }
        }
        if (this.f2718m != null) {
            this.f2727v.setButtonEnabled(true);
            this.f2713h.setEnabled(true);
        } else {
            this.f2727v.setButtonEnabled(false);
            this.f2713h.setEnabled(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m3297a(String str) {
        try {
            List<Address> fromLocationName = new Geocoder(this).getFromLocationName(str, 5);
            if (fromLocationName.size() > 0) {
                GeoPoint geoPoint = new GeoPoint((int) (fromLocationName.get(0).getLatitude() * 1000000.0d), (int) (fromLocationName.get(0).getLongitude() * 1000000.0d));
                this.f2721p = geoPoint;
                this.f2716k.animateTo(geoPoint);
                OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Searched location");
                this.f2720o.m3300b(overlayItem);
                this.f2720o.m3299a(overlayItem);
                this.f2719n.clear();
                this.f2719n.add(this.f2720o);
                this.f2727v.setButtonEnabled(true);
            } else {
                C1619g.m5888a((Context) this, R.string.no_geo_point, 1).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m3296a(GeoPoint geoPoint) {
        if (this.f2723r && geoPoint != null && !this.f2721p.equals(geoPoint)) {
            this.f2721p = geoPoint;
            this.f2716k.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Current location");
            this.f2720o.m3300b(overlayItem);
            this.f2720o.m3299a(overlayItem);
            this.f2719n.clear();
            this.f2719n.add(this.f2720o);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        if (!this.f2724s) {
            this.f2710e.dismiss();
        }
        this.f2717l.removeUpdates(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.geo_current /* 2131427897 */:
                if (this.f2722q != null) {
                    m3296a(this.f2722q);
                    break;
                } else {
                    this.f2724s = true;
                    m3295a();
                    break;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3292f() {
        if (this.f2721p != null) {
            Intent intent = new Intent();
            intent.putExtra("GEOPOINT", (this.f2721p.getLatitudeE6() / 1000000.0d) + "," + (this.f2721p.getLongitudeE6() / 1000000.0d));
            setResult(-1, intent);
            finish();
        }
    }

    /* renamed from: b */
    public void m3298b() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f2712g.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        m3288d();
    }
}
