package com.sec.chaton.multimedia.geotag;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import com.sec.chaton.base.BaseActivity;
import com.sec.chaton.base.C0456a;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p037j.C1594v;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C3241p;
import com.sec.chaton.util.C3248w;
import com.sec.chaton.util.C3250y;
import com.sec.chaton.widget.C3263j;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarMapActivity;
import com.sec.common.p063a.AbstractC3271a;
import com.sec.common.p063a.InterfaceC3274d;
import com.sec.widget.C3641ai;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class GeotagActivity extends ActionBarMapActivity implements LocationListener, View.OnClickListener {

    /* renamed from: b */
    private static final String f6826b = GeotagActivity.class.getSimpleName();

    /* renamed from: A */
    private Handler f6827A;

    /* renamed from: B */
    private InterfaceC3274d f6828B;

    /* renamed from: C */
    private boolean f6829C;

    /* renamed from: D */
    private Location f6830D;

    /* renamed from: E */
    private String f6831E;

    /* renamed from: F */
    private AsyncTaskC1848m f6832F;

    /* renamed from: G */
    private boolean f6833G;

    /* renamed from: c */
    private Context f6835c;

    /* renamed from: d */
    private Bundle f6836d;

    /* renamed from: e */
    private Dialog f6837e;

    /* renamed from: f */
    private ClearableEditText f6838f;

    /* renamed from: g */
    private ImageButton f6839g;

    /* renamed from: h */
    private Drawable f6840h;

    /* renamed from: i */
    private MapView f6841i;

    /* renamed from: j */
    private MapController f6842j;

    /* renamed from: l */
    private List<Overlay> f6844l;

    /* renamed from: m */
    private C1836a f6845m;

    /* renamed from: n */
    private GeoPoint f6846n;

    /* renamed from: o */
    private GeoPoint f6847o;

    /* renamed from: s */
    private GeoPoint f6851s;

    /* renamed from: t */
    private String f6852t;

    /* renamed from: u */
    private ImageButton f6853u;

    /* renamed from: v */
    private ImageButton f6854v;

    /* renamed from: w */
    private MenuItem f6855w;

    /* renamed from: x */
    private View f6856x;

    /* renamed from: y */
    private boolean f6857y;

    /* renamed from: z */
    private boolean f6858z;

    /* renamed from: k */
    private LocationManager f6843k = null;

    /* renamed from: p */
    private boolean f6848p = true;

    /* renamed from: q */
    private boolean f6849q = true;

    /* renamed from: r */
    private boolean f6850r = true;

    /* renamed from: a */
    public final Handler f6834a = new HandlerC1845j(this);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.actionbar.ActionBarMapActivity
    public void onCreate(Bundle bundle) {
        C0456a.m3090a(this, bundle);
        super.onCreate(bundle);
        this.f6835c = this;
        setContentView(R.layout.layout_geotag);
        m7523d();
        if (this.f6848p) {
            m7524e();
        } else {
            m7528g();
        }
        getWindow().addFlags(128);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onConfigurationChanged(Configuration configuration) throws Resources.NotFoundException {
        super.onConfigurationChanged(configuration);
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a((Activity) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private void m7523d() {
        this.f6856x = findViewById(R.id.layout_search_location);
        this.f6838f = (ClearableEditText) this.f6856x.findViewById(R.id.text1);
        this.f6838f.setHint(R.string.search_location);
        this.f6838f.setImeOptions(268435459);
        this.f6838f.setInputType(16384);
        this.f6838f.setFilters(new InputFilter[]{new C3248w(this, 30)});
        this.f6839g = (ImageButton) this.f6856x.findViewById(R.id.button1);
        this.f6839g.setImageResource(R.drawable.input_ic_gps);
        this.f6839g.setOnClickListener(this);
        this.f6841i = findViewById(R.id.map);
        this.f6842j = this.f6841i.getController();
        this.f6842j.setZoom(16);
        this.f6841i.setBuiltInZoomControls(false);
        this.f6853u = (ImageButton) findViewById(R.id.zoomIn);
        this.f6854v = (ImageButton) findViewById(R.id.zoomOut);
        this.f6853u.setOnClickListener(new ViewOnClickListenerC1837b(this));
        this.f6854v.setOnClickListener(new ViewOnClickListenerC1838c(this));
        this.f6844l = this.f6841i.getOverlays();
        this.f6840h = getResources().getDrawable(R.drawable.co_location_btn1);
        this.f6845m = new C1836a(this.f6840h, this);
        this.f6838f.setOnEditorActionListener(new C1839d(this));
        this.f6843k = (LocationManager) getSystemService("location");
        this.f6836d = getIntent().getExtras();
        if (this.f6836d != null && this.f6836d.containsKey("Geo Point")) {
            this.f6848p = false;
            this.f6856x.setVisibility(8);
        } else {
            this.f6848p = true;
            this.f6856x.setVisibility(0);
        }
        if (this.f6836d != null && this.f6836d.containsKey("sendbutton")) {
            this.f6833G = this.f6836d.getBoolean("sendbutton");
        }
        this.f6837e = new C3263j(this).m11487a(R.string.dialog_geo_loading);
        this.f6837e.setCanceledOnTouchOutside(false);
        this.f6837e.setCancelable(true);
        this.f6837e.setOnCancelListener(new DialogInterfaceOnCancelListenerC1840e(this));
    }

    /* renamed from: a */
    protected void m7543a() {
        if (this.f6841i != null) {
            if (this.f6841i.getZoomLevel() >= 21) {
                this.f6853u.setEnabled(false);
                this.f6854v.setEnabled(true);
            } else {
                if (this.f6841i.getZoomLevel() <= 2) {
                    if (this.f6842j != null) {
                        this.f6842j.setZoom(2);
                    }
                    this.f6853u.setEnabled(true);
                    this.f6854v.setEnabled(false);
                    return;
                }
                this.f6853u.setEnabled(true);
                this.f6854v.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7524e() {
        LocationProvider provider;
        if (this.f6843k.isProviderEnabled("gps")) {
            LocationProvider provider2 = this.f6843k.getProvider("gps");
            if (provider2 != null) {
                m7545a(provider2.getName());
                this.f6829C = true;
            }
            if (this.f6843k.isProviderEnabled("network") && (provider = this.f6843k.getProvider("network")) != null) {
                m7545a(provider.getName());
                return;
            }
            return;
        }
        m7527f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: f */
    private void m7527f() {
        InterfaceC3274d interfaceC3274dMo11505a = AbstractC3271a.m11494a((Context) this).mo11500a(getResources().getString(R.string.pop_up_attention)).mo11509b(getResources().getString(R.string.geotag_dialog_findgsp_message_failed_notfound)).mo11510b(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC1842g(this)).mo11501a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC1841f(this)).mo11505a();
        interfaceC3274dMo11505a.setCanceledOnTouchOutside(false);
        interfaceC3274dMo11505a.setCancelable(false);
        interfaceC3274dMo11505a.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    private void m7528g() {
        String strNextToken = null;
        StringTokenizer stringTokenizer = new StringTokenizer(this.f6836d.getString("Geo Point").toString(), "\n");
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        if (C3250y.f11734b) {
            C3250y.m11450b("*** RECEIVED GEO TAG COORD : " + strNextToken, f6826b);
        }
        if (strNextToken == null) {
            C3641ai.m13210a((Context) this, R.string.geotag_dialog_findgsp_title_failed_find_location, 1).show();
            return;
        }
        String[] strArrSplit = strNextToken.split(",");
        GeoPoint geoPoint = new GeoPoint((int) (Double.parseDouble(strArrSplit[0]) * 1000000.0d), (int) (Double.parseDouble(strArrSplit[1]) * 1000000.0d));
        this.f6845m.m7548a(new OverlayItem(geoPoint, "test", "Searched location"));
        this.f6844l.clear();
        this.f6844l.add(this.f6845m);
        this.f6842j.animateTo(geoPoint);
    }

    @Override // com.sec.common.actionbar.ActionBarMapActivity
    protected boolean isRouteDisplayed() {
        return false;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (C3250y.f11734b) {
            C3250y.m11450b("onLocationChanged() provider : " + location.getProvider(), f6826b);
        }
        if (!this.f6858z) {
            if ("network".equals(location.getProvider()) && this.f6829C) {
                C3250y.m11450b("onLocationChanged() return : " + location.getProvider(), f6826b);
                this.f6830D = location;
            } else {
                m7515a(location);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7515a(Location location) {
        GeoPoint geoPoint = null;
        if (this.f6848p) {
            geoPoint = new GeoPoint((int) (location.getLatitude() * 1000000.0d), (int) (location.getLongitude() * 1000000.0d));
            this.f6846n = geoPoint;
            this.f6847o = geoPoint;
        }
        if (this.f6850r && !this.f6857y) {
            this.f6842j.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Current location");
            this.f6845m.m7549b(overlayItem);
            this.f6845m.m7548a(overlayItem);
            this.f6844l.clear();
            this.f6844l.add(this.f6845m);
            if (this.f6837e != null && this.f6837e.isShowing()) {
                this.f6837e.hide();
            }
            this.f6850r = false;
            this.f6855w.setEnabled(true);
        }
    }

    /* renamed from: a */
    public void m7545a(String str) {
        if (C3250y.f11734b) {
            C3250y.m11450b("requestCurrentLocation() provider : " + str, f6826b);
        }
        this.f6830D = null;
        if (str != null) {
            this.f6843k.requestLocationUpdates(str, 0L, 0.0f, this);
            this.f6827A = new Handler();
            this.f6827A.postDelayed(new RunnableC1843h(this), 15000L);
        } else {
            m7527f();
        }
        if (this.f6849q) {
            this.f6837e.show();
            this.f6849q = false;
        }
        if (str != null) {
            if (this.f6855w != null) {
                this.f6855w.setEnabled(true);
            }
            this.f6839g.setEnabled(true);
        } else {
            if (this.f6855w != null) {
                this.f6855w.setEnabled(false);
            }
            this.f6839g.setEnabled(false);
        }
    }

    /* renamed from: b */
    public void m7547b(String str) {
        int iM6733a = C1594v.m6733a(CommonApplication.m11493l());
        if (-3 == iM6733a || -2 == iM6733a) {
            C3641ai.m13210a(this.f6835c, R.string.no_geo_point, 0).show();
            return;
        }
        this.f6837e.setOnCancelListener(new DialogInterfaceOnCancelListenerC1844i(this));
        this.f6837e.show();
        this.f6831E = str;
        this.f6832F = new AsyncTaskC1848m(this, true, 0.0d, 0.0d);
        this.f6832F.execute(str);
    }

    /* renamed from: a */
    public void m7544a(GeoPoint geoPoint) {
        if (this.f6848p && geoPoint != null) {
            this.f6851s = geoPoint;
            this.f6842j.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Current location");
            this.f6845m.m7549b(overlayItem);
            this.f6845m.m7548a(overlayItem);
            this.f6844l.clear();
            this.f6844l.add(this.f6845m);
            this.f6831E = null;
            this.f6852t = null;
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            this.f6829C = false;
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if ("gps".equals(str)) {
            this.f6829C = true;
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected void onResume() throws Resources.NotFoundException {
        super.onResume();
        if (GlobalApplication.m6456e()) {
            BaseActivity.m3080a((Activity) this);
        }
        m7533i();
    }

    protected void onPause() {
        super.onPause();
        this.f6843k.removeUpdates(this);
        if (this.f6838f != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f6838f.getWindowToken(), 0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1 /* 2131165901 */:
                m7546b();
                if (this.f6847o != null) {
                    m7544a(this.f6847o);
                    break;
                } else {
                    this.f6849q = true;
                    this.f6850r = true;
                    m7524e();
                    break;
                }
        }
    }

    /* renamed from: h */
    private void m7530h() {
        if (this.f6851s != null) {
            this.f6832F = new AsyncTaskC1848m(this, false, this.f6851s.getLatitudeE6() / 1000000.0d, this.f6851s.getLongitudeE6() / 1000000.0d);
        } else if (this.f6846n != null) {
            this.f6832F = new AsyncTaskC1848m(this, false, this.f6846n.getLatitudeE6() / 1000000.0d, this.f6846n.getLongitudeE6() / 1000000.0d);
        }
        this.f6837e.show();
        this.f6832F.execute(new String[0]);
    }

    /* renamed from: b */
    public void m7546b() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f6838f.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        m7524e();
    }

    protected void onDestroy() {
        this.f6858z = true;
        if (this.f6837e != null) {
            this.f6837e.dismiss();
        }
        if (this.f6828B != null) {
            this.f6828B.dismiss();
        }
        if (this.f6827A != null) {
            this.f6827A.removeMessages(0);
        }
        if (this.f6832F != null) {
            this.f6832F.cancel(true);
        }
        getWindow().clearFlags(128);
        super.onDestroy();
    }

    protected void onUserLeaveHint() {
        C3250y.m11450b("onUserLeaveHint", getClass().getSimpleName());
        C3241p.m11402b(getApplicationContext());
    }

    /* renamed from: i */
    private void m7533i() {
        C3250y.m11450b("showPasswordLockActivity", "FacebookSubMenuActivity");
        Context applicationContext = getApplicationContext();
        if (C3241p.m11407c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    @Override // com.sec.common.actionbar.ActionBarMapActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        if (this.f6848p) {
            getMenuInflater().inflate(R.menu.cancel_done_menu, menu);
            this.f6855w = menu.findItem(R.id.menu_done);
            if (this.f6833G) {
                this.f6855w.setTitle(R.string.layout_imageview_send);
            } else {
                this.f6855w.setTitle(R.string.buddy_group_edit_menubar_add);
            }
            this.f6855w.setEnabled(false);
        }
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.ActionBarMapActivity, com.sec.common.actionbar.InterfaceC3302s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332 || menuItem.getItemId() == R.id.menu_cancel) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_done) {
            m7530h();
            return true;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
