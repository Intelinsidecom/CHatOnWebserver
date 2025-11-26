package com.sec.chaton.multimedia.geotag;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.hardware.motion.MotionRecognitionManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.R;
import com.sec.chaton.base.C1059a;
import com.sec.chaton.p067j.C2471v;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.util.C4902w;
import com.sec.chaton.util.C4904y;
import com.sec.chaton.widget.C4923p;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarMapActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import com.sec.widget.C5179v;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class GeotagActivity extends ActionBarMapActivity implements LocationListener, View.OnClickListener {

    /* renamed from: b */
    private static final String f10121b = GeotagActivity.class.getSimpleName();

    /* renamed from: A */
    private Handler f10122A;

    /* renamed from: B */
    private InterfaceC4936e f10123B;

    /* renamed from: C */
    private boolean f10124C;

    /* renamed from: D */
    private Location f10125D;

    /* renamed from: E */
    private String f10126E;

    /* renamed from: F */
    private AsyncTaskC2814m f10127F;

    /* renamed from: c */
    private Context f10129c;

    /* renamed from: d */
    private Bundle f10130d;

    /* renamed from: e */
    private Dialog f10131e;

    /* renamed from: f */
    private ClearableEditText f10132f;

    /* renamed from: g */
    private ImageButton f10133g;

    /* renamed from: h */
    private Drawable f10134h;

    /* renamed from: i */
    private MapView f10135i;

    /* renamed from: j */
    private MapController f10136j;

    /* renamed from: l */
    private List<Overlay> f10138l;

    /* renamed from: m */
    private C2802a f10139m;

    /* renamed from: n */
    private GeoPoint f10140n;

    /* renamed from: o */
    private GeoPoint f10141o;

    /* renamed from: s */
    private GeoPoint f10145s;

    /* renamed from: t */
    private String f10146t;

    /* renamed from: u */
    private ImageButton f10147u;

    /* renamed from: v */
    private ImageButton f10148v;

    /* renamed from: w */
    private MenuItem f10149w;

    /* renamed from: x */
    private View f10150x;

    /* renamed from: y */
    private boolean f10151y;

    /* renamed from: z */
    private boolean f10152z;

    /* renamed from: k */
    private LocationManager f10137k = null;

    /* renamed from: p */
    private boolean f10142p = true;

    /* renamed from: q */
    private boolean f10143q = true;

    /* renamed from: r */
    private boolean f10144r = true;

    /* renamed from: a */
    public final Handler f10128a = new HandlerC2811j(this);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.actionbar.ActionBarMapActivity
    public void onCreate(Bundle bundle) {
        C1059a.m6164a(this, bundle);
        super.onCreate(bundle);
        this.f10129c = this;
        setContentView(R.layout.layout_geotag);
        m11729d();
        if (this.f10142p) {
            m11730e();
        } else {
            m11734g();
        }
        getWindow().addFlags(128);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private void m11729d() {
        this.f10150x = findViewById(R.id.layout_search_location);
        this.f10132f = (ClearableEditText) this.f10150x.findViewById(R.id.text1);
        this.f10132f.setHint(R.string.search_location);
        this.f10132f.setImeOptions(268435459);
        this.f10132f.setInputType(MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND);
        this.f10132f.setFilters(new InputFilter[]{new C4902w(this, 30)});
        this.f10133g = (ImageButton) this.f10150x.findViewById(R.id.button1);
        this.f10133g.setImageResource(R.drawable.input_ic_gps);
        this.f10133g.setOnClickListener(this);
        this.f10133g.setContentDescription(this.f10129c.getResources().getString(R.string.my_location));
        this.f10135i = findViewById(R.id.map);
        this.f10136j = this.f10135i.getController();
        this.f10136j.setZoom(16);
        this.f10135i.setBuiltInZoomControls(false);
        this.f10147u = (ImageButton) findViewById(R.id.zoomIn);
        this.f10148v = (ImageButton) findViewById(R.id.zoomOut);
        this.f10147u.setOnClickListener(new ViewOnClickListenerC2803b(this));
        this.f10148v.setOnClickListener(new ViewOnClickListenerC2804c(this));
        this.f10138l = this.f10135i.getOverlays();
        this.f10134h = getResources().getDrawable(R.drawable.co_location_btn1);
        this.f10139m = new C2802a(this.f10134h, this);
        this.f10132f.setOnEditorActionListener(new C2805d(this));
        this.f10137k = (LocationManager) getSystemService("location");
        this.f10130d = getIntent().getExtras();
        if (this.f10130d != null && this.f10130d.containsKey("Geo Point")) {
            this.f10142p = false;
            this.f10150x.setVisibility(8);
        } else {
            this.f10142p = true;
            this.f10150x.setVisibility(0);
        }
        this.f10131e = new C4923p(this).m18724a(R.string.dialog_geo_loading);
        this.f10131e.setCanceledOnTouchOutside(false);
        this.f10131e.setCancelable(true);
        this.f10131e.setOnCancelListener(new DialogInterfaceOnCancelListenerC2806e(this));
    }

    /* renamed from: a */
    protected void m11748a() {
        if (this.f10135i != null) {
            if (this.f10135i.getZoomLevel() >= 21) {
                this.f10147u.setEnabled(false);
                this.f10148v.setEnabled(true);
            } else {
                if (this.f10135i.getZoomLevel() <= 2) {
                    if (this.f10136j != null) {
                        this.f10136j.setZoom(2);
                    }
                    this.f10147u.setEnabled(true);
                    this.f10148v.setEnabled(false);
                    return;
                }
                this.f10147u.setEnabled(true);
                this.f10148v.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m11730e() {
        LocationProvider provider;
        boolean zIsProviderEnabled = this.f10137k.isProviderEnabled("gps");
        if (C4904y.f17875e) {
            C4904y.m18634a("GPS_PROVIDER enabled : " + zIsProviderEnabled, f10121b);
        }
        if (zIsProviderEnabled) {
            Location lastKnownLocation = this.f10137k.getLastKnownLocation("gps");
            if (C4904y.f17875e) {
                C4904y.m18634a("lastLocation GPS_PROVIDER : " + lastKnownLocation, f10121b);
            }
            if (lastKnownLocation != null) {
                m11720a(lastKnownLocation, true);
                this.f10143q = false;
            }
            LocationProvider provider2 = this.f10137k.getProvider("gps");
            if (provider2 != null) {
                m11750a(provider2.getName());
                this.f10124C = true;
            }
            boolean zIsProviderEnabled2 = this.f10137k.isProviderEnabled("network");
            if (C4904y.f17875e) {
                C4904y.m18634a("NETWORK_PROVIDER enabled : " + zIsProviderEnabled2, f10121b);
            }
            if (zIsProviderEnabled2 && (provider = this.f10137k.getProvider("network")) != null) {
                m11750a(provider.getName());
                return;
            }
            return;
        }
        m11733f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    private void m11733f() {
        InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a((Context) this).mo18740a(getResources().getString(R.string.pop_up_attention)).mo18749b(getResources().getString(R.string.geotag_dialog_findgsp_message_failed_notfound)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC2808g(this)).mo18741a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC2807f(this)).mo18751b(false).mo18745a();
        interfaceC4936eMo18745a.setCanceledOnTouchOutside(false);
        interfaceC4936eMo18745a.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    private void m11734g() {
        String strNextToken = null;
        StringTokenizer stringTokenizer = new StringTokenizer(this.f10130d.getString("Geo Point").toString(), "\n");
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        if (C4904y.f17872b) {
            C4904y.m18639b("*** RECEIVED GEO TAG COORD : " + strNextToken, f10121b);
        }
        if (strNextToken == null) {
            C5179v.m19810a((Context) this, R.string.geotag_dialog_findgsp_title_failed_find_location, 1).show();
            return;
        }
        String[] strArrSplit = strNextToken.split(",");
        GeoPoint geoPoint = new GeoPoint((int) (Double.parseDouble(strArrSplit[0]) * 1000000.0d), (int) (Double.parseDouble(strArrSplit[1]) * 1000000.0d));
        this.f10139m.m11753a(new OverlayItem(geoPoint, Spam.CATEGORY_DEFAULT, "Searched location"));
        this.f10138l.clear();
        this.f10138l.add(this.f10139m);
        this.f10136j.animateTo(geoPoint);
    }

    @Override // com.sec.common.actionbar.ActionBarMapActivity
    protected boolean isRouteDisplayed() {
        return false;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (C4904y.f17872b) {
            C4904y.m18639b("onLocationChanged() provider : " + location.getProvider(), f10121b);
        }
        if (!this.f10152z) {
            if ("network".equals(location.getProvider()) && this.f10124C) {
                C4904y.m18639b("onLocationChanged() return : " + location.getProvider(), f10121b);
                this.f10125D = location;
            } else {
                m11720a(location, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m11720a(Location location, boolean z) {
        GeoPoint geoPoint = null;
        if (this.f10142p) {
            geoPoint = new GeoPoint((int) (location.getLatitude() * 1000000.0d), (int) (location.getLongitude() * 1000000.0d));
            this.f10140n = geoPoint;
            this.f10141o = geoPoint;
        }
        if (this.f10144r && !this.f10151y) {
            this.f10136j.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, Spam.CATEGORY_DEFAULT, "Current location");
            this.f10139m.m11754b(overlayItem);
            this.f10139m.m11753a(overlayItem);
            this.f10138l.clear();
            this.f10138l.add(this.f10139m);
            if (this.f10131e != null && this.f10131e.isShowing()) {
                this.f10131e.hide();
            }
            if (!z) {
                this.f10144r = false;
            }
            if (this.f10149w != null) {
                this.f10149w.setEnabled(true);
            }
        }
    }

    /* renamed from: a */
    public void m11750a(String str) {
        if (C4904y.f17872b) {
            C4904y.m18639b("requestCurrentLocation() provider : " + str, f10121b);
        }
        this.f10125D = null;
        if (str != null) {
            this.f10137k.requestLocationUpdates(str, 0L, 0.0f, this);
            this.f10122A = new Handler();
            this.f10122A.postDelayed(new RunnableC2809h(this), 15000L);
        } else {
            m11733f();
        }
        if (this.f10143q) {
            this.f10131e.show();
            this.f10143q = false;
        }
        if (str != null) {
            if (this.f10149w != null) {
                this.f10149w.setEnabled(true);
            }
            this.f10133g.setEnabled(true);
        } else {
            if (this.f10149w != null) {
                this.f10149w.setEnabled(false);
            }
            this.f10133g.setEnabled(false);
        }
    }

    /* renamed from: b */
    public void m11752b(String str) {
        boolean z = true;
        double d = 0.0d;
        int iM10677a = C2471v.m10677a(CommonApplication.m18732r());
        if (-3 == iM10677a || -2 == iM10677a) {
            C5179v.m19810a(this.f10129c, R.string.no_geo_point, 0).show();
            return;
        }
        this.f10131e.setOnCancelListener(new DialogInterfaceOnCancelListenerC2810i(this));
        this.f10131e.show();
        this.f10126E = str;
        this.f10127F = new AsyncTaskC2814m(this, z, d, d, null);
        this.f10127F.execute(str);
    }

    /* renamed from: a */
    public void m11749a(GeoPoint geoPoint) {
        if (this.f10142p && geoPoint != null) {
            this.f10145s = geoPoint;
            this.f10136j.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, Spam.CATEGORY_DEFAULT, "Current location");
            this.f10139m.m11754b(overlayItem);
            this.f10139m.m11753a(overlayItem);
            this.f10138l.clear();
            this.f10138l.add(this.f10139m);
            this.f10126E = null;
            this.f10146t = null;
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            this.f10124C = false;
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if ("gps".equals(str)) {
            this.f10124C = true;
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() {
        super.onResume();
        C1059a.m6166b(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onPause() {
        super.onPause();
        C1059a.m6167c(this);
        this.f10137k.removeUpdates(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1 /* 2131165821 */:
                m11751b();
                if (this.f10141o != null) {
                    m11749a(this.f10141o);
                    break;
                } else {
                    this.f10143q = true;
                    this.f10144r = true;
                    m11730e();
                    break;
                }
        }
    }

    /* renamed from: h */
    private void m11736h() {
        ViewOnClickListenerC2803b viewOnClickListenerC2803b = null;
        boolean z = false;
        if (this.f10145s != null) {
            this.f10127F = new AsyncTaskC2814m(this, z, this.f10145s.getLatitudeE6() / 1000000.0d, this.f10145s.getLongitudeE6() / 1000000.0d, viewOnClickListenerC2803b);
        } else if (this.f10140n != null) {
            this.f10127F = new AsyncTaskC2814m(this, z, this.f10140n.getLatitudeE6() / 1000000.0d, this.f10140n.getLongitudeE6() / 1000000.0d, viewOnClickListenerC2803b);
        }
        this.f10131e.show();
        this.f10127F.execute(new String[0]);
    }

    /* renamed from: b */
    public void m11751b() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f10132f.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onActivityResult(int i, int i2, Intent intent) {
        C1059a.m6169e(this);
        m11730e();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onDestroy() {
        this.f10152z = true;
        if (this.f10131e != null) {
            this.f10131e.dismiss();
        }
        if (this.f10123B != null) {
            this.f10123B.dismiss();
        }
        if (this.f10122A != null) {
            this.f10122A.removeMessages(0);
        }
        if (this.f10127F != null) {
            this.f10127F.cancel(true);
        }
        getWindow().clearFlags(128);
        super.onDestroy();
        C1059a.m6171g(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        C1059a.m6168d(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStop() {
        super.onStop();
        C1059a.m6170f(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onStart() {
        super.onStart();
        C1059a.m6163a((Activity) this);
    }

    @Override // com.sec.common.actionbar.ActionBarMapActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        if (this.f10142p) {
            getMenuInflater().inflate(R.menu.cancel_done_menu, menu);
            this.f10149w = menu.findItem(R.id.menu_done);
            if (this.f10141o == null) {
                this.f10149w.setEnabled(false);
            }
        }
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.ActionBarMapActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (this.f10132f != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f10132f.getWindowToken(), 0);
        }
        if (menuItem.getItemId() == 16908332 || menuItem.getItemId() == R.id.menu_cancel) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_done) {
            m11736h();
            return true;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
