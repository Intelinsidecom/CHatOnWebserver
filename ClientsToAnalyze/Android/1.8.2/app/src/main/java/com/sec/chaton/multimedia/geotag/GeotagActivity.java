package com.sec.chaton.multimedia.geotag;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.CellLocation;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1786r;
import com.sec.chaton.widget.C1805i;
import com.sec.widget.AlertDialogBuilderC2120a;
import com.sec.widget.EditTextWithClearButton;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class GeotagActivity extends MapActivity implements LocationListener, View.OnClickListener {

    /* renamed from: a */
    public static final String f3561a = GeotagActivity.class.getSimpleName();

    /* renamed from: A */
    private ImageButton f3562A;

    /* renamed from: g */
    private Context f3569g;

    /* renamed from: h */
    private Bundle f3570h;

    /* renamed from: i */
    private ProgressDialog f3571i;

    /* renamed from: j */
    private LinearLayout f3572j;

    /* renamed from: k */
    private EditTextWithClearButton f3573k;

    /* renamed from: l */
    private ImageButton f3574l;

    /* renamed from: m */
    private Drawable f3575m;

    /* renamed from: n */
    private MapView f3576n;

    /* renamed from: o */
    private MapController f3577o;

    /* renamed from: q */
    private String f3579q;

    /* renamed from: r */
    private List f3580r;

    /* renamed from: s */
    private C0971a f3581s;

    /* renamed from: t */
    private GeoPoint f3582t;

    /* renamed from: u */
    private GeoPoint f3583u;

    /* renamed from: y */
    private LinearLayout f3587y;

    /* renamed from: z */
    private ImageButton f3588z;

    /* renamed from: p */
    private LocationManager f3578p = null;

    /* renamed from: v */
    private boolean f3584v = true;

    /* renamed from: w */
    private boolean f3585w = true;

    /* renamed from: x */
    private boolean f3586x = true;

    /* renamed from: B */
    private GeoPoint f3563B = null;

    /* renamed from: b */
    Handler f3564b = null;

    /* renamed from: c */
    Handler f3565c = null;

    /* renamed from: d */
    Runnable f3566d = new RunnableC0979i(this);

    /* renamed from: e */
    Runnable f3567e = new RunnableC0980j(this);

    /* renamed from: f */
    public final Handler f3568f = new HandlerC0973c(this);

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3569g = this;
        setContentView(R.layout.layout_geotag);
        if (GlobalApplication.m3265f()) {
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
        }
        m3838b();
        if (this.f3584v) {
            m3839c();
        } else {
            m3842d();
        }
    }

    /* renamed from: b */
    private void m3838b() {
        this.f3572j = (LinearLayout) findViewById(R.id.geotag_searcdh_bar);
        this.f3573k = (EditTextWithClearButton) findViewById(R.id.geo_search);
        this.f3573k.setShowSearch(true);
        this.f3576n = findViewById(R.id.map);
        this.f3576n.setBuiltInZoomControls(false);
        this.f3587y = (LinearLayout) findViewById(R.id.linearLayout1);
        this.f3588z = (ImageButton) findViewById(R.id.ZoomIn);
        this.f3588z.setOnClickListener(this);
        this.f3562A = (ImageButton) findViewById(R.id.ZoomOut);
        this.f3562A.setOnClickListener(this);
        this.f3577o = this.f3576n.getController();
        this.f3574l = (ImageButton) findViewById(R.id.geo_current);
        this.f3574l.setOnClickListener(this);
        this.f3580r = this.f3576n.getOverlays();
        this.f3575m = getResources().getDrawable(R.drawable.messenger_chat_pin);
        this.f3581s = new C0971a(this.f3575m, this);
        this.f3573k.setOnEditorActionListener(new C0972b(this));
        this.f3573k.addTextChangedListener(new C0975e(this));
        this.f3573k.setOnTouchListener(new ViewOnTouchListenerC0976f(this));
        this.f3578p = (LocationManager) getSystemService("location");
        this.f3570h = getIntent().getExtras();
        if (this.f3570h != null && this.f3570h.containsKey("Geo Point")) {
            this.f3584v = false;
            this.f3572j.setVisibility(8);
        } else {
            this.f3584v = true;
            this.f3572j.setVisibility(0);
        }
    }

    protected void onPostCreate(Bundle bundle) {
        ActionBar actionBar;
        super.onPostCreate(bundle);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14 && (actionBar = getActionBar()) != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
        }
        setTitle(R.string.multimedia_geotag_header);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_menu_send_cancel, menu);
        if (!this.f3584v) {
            menu.removeItem(R.id.menu_send);
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
            case R.id.menu_cancel /* 2131494116 */:
                finish();
                break;
            case R.id.menu_send /* 2131494119 */:
                m3844e();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    private void m3839c() {
        if (this.f3578p.isProviderEnabled("gps")) {
            LocationProvider provider = this.f3578p.getProvider("gps");
            if (provider != null) {
                this.f3579q = provider.getName();
            }
            m3851a();
            return;
        }
        CellLocation.requestLocationUpdate();
        if (this.f3563B == null) {
        }
        if (this.f3563B != null) {
            m3851a();
        } else {
            new AlertDialogBuilderC2120a(this).setTitle(getResources().getString(R.string.geotag_dialog_findgsp_title_failed_notfound)).setMessage(getResources().getString(R.string.geotag_dialog_findgsp_message_failed_notfound)).setPositiveButton(getResources().getString(R.string.geotag_dialog_findgsp_button_failed_cancel), new DialogInterfaceOnClickListenerC0978h(this)).setNegativeButton(getResources().getString(R.string.geotag_dialog_findgsp_button_failed_setting), new DialogInterfaceOnClickListenerC0977g(this)).show();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private void m3842d() {
        String strNextToken = null;
        StringTokenizer stringTokenizer = new StringTokenizer(this.f3570h.getString("Geo Point").toString(), "\n");
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        C1786r.m6067f("*** RECEIVED GEO TAG COORD : " + strNextToken, f3561a);
        if (strNextToken == null) {
            Toast.makeText((Context) this, R.string.no_geo_point, 1).show();
            return;
        }
        String[] strArrSplit = strNextToken.split(",");
        GeoPoint geoPoint = new GeoPoint((int) (Double.parseDouble(strArrSplit[0]) * 1000000.0d), (int) (Double.parseDouble(strArrSplit[1]) * 1000000.0d));
        this.f3581s.m3854a(new OverlayItem(geoPoint, "test", "Searched location"));
        this.f3580r.clear();
        this.f3580r.add(this.f3581s);
        this.f3577o.animateTo(geoPoint);
        this.f3577o.setZoom(16);
    }

    protected boolean isRouteDisplayed() {
        return false;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        C1786r.m6067f("onLocationChanged()", f3561a);
        if (this.f3586x) {
            GeoPoint geoPoint = null;
            if (this.f3584v) {
                geoPoint = new GeoPoint((int) (location.getLatitude() * 1000000.0d), (int) (location.getLongitude() * 1000000.0d));
                this.f3582t = geoPoint;
                this.f3583u = geoPoint;
            }
            this.f3577o.animateTo(geoPoint);
            this.f3577o.setZoom(16);
            OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Current location");
            this.f3581s.m3855b(overlayItem);
            this.f3581s.m3854a(overlayItem);
            this.f3580r.clear();
            this.f3580r.add(this.f3581s);
            if (this.f3571i != null && this.f3571i.isShowing()) {
                this.f3571i.dismiss();
            }
            this.f3586x = false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m3851a() {
        C1786r.m6067f("requestCurrentLocation()", f3561a);
        if (this.f3579q != null) {
            this.f3578p.requestLocationUpdates(this.f3579q, 0L, 0.0f, this);
            this.f3564b = new Handler();
            this.f3564b.postDelayed(this.f3566d, 20000L);
        } else if (this.f3563B != null) {
            if (this.f3584v) {
                this.f3582t = this.f3563B;
                this.f3583u = this.f3563B;
            }
            this.f3577o.animateTo(this.f3563B);
            this.f3577o.setZoom(16);
            OverlayItem overlayItem = new OverlayItem(this.f3563B, "test", "Current location");
            this.f3581s.m3855b(overlayItem);
            this.f3581s.m3854a(overlayItem);
            this.f3580r.clear();
            this.f3580r.add(this.f3581s);
            if (this.f3571i != null && this.f3571i.isShowing()) {
                this.f3571i.dismiss();
            }
            this.f3586x = false;
        } else {
            try {
                new AlertDialog.Builder(this).setMessage(R.string.dialog_geo_warning).setPositiveButton(R.string.password_confirm, new DialogInterfaceOnClickListenerC0981k(this)).show();
            } catch (WindowManager.BadTokenException e) {
                e.printStackTrace();
            }
        }
        if (this.f3585w && this.f3579q != null) {
            this.f3571i = (ProgressDialog) new C1805i(this).m6139a(R.string.dialog_geo_loading);
            this.f3571i.setOnKeyListener(new DialogInterfaceOnKeyListenerC0982l(this));
            this.f3571i.show();
            this.f3585w = false;
            this.f3565c = new Handler();
            new Handler();
            if (this.f3584v && "gps".equals(this.f3579q)) {
                this.f3565c.postDelayed(this.f3567e, 10000L);
            }
        }
        if (this.f3579q != null) {
            this.f3574l.setEnabled(true);
        } else {
            this.f3574l.setEnabled(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m3853a(String str) {
        try {
            List<Address> fromLocationName = new Geocoder(this).getFromLocationName(str, 5);
            if (fromLocationName.size() > 0) {
                GeoPoint geoPoint = new GeoPoint((int) (fromLocationName.get(0).getLatitude() * 1000000.0d), (int) (fromLocationName.get(0).getLongitude() * 1000000.0d));
                this.f3582t = geoPoint;
                this.f3577o.animateTo(geoPoint);
                OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Searched location");
                this.f3581s.m3855b(overlayItem);
                this.f3581s.m3854a(overlayItem);
                this.f3580r.clear();
                this.f3580r.add(this.f3581s);
            } else {
                Toast.makeText((Context) this, R.string.no_geo_point, 1).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m3852a(GeoPoint geoPoint) {
        if (this.f3584v && geoPoint != null && !this.f3582t.equals(geoPoint)) {
            this.f3582t = geoPoint;
            this.f3577o.animateTo(geoPoint);
            this.f3577o.setZoom(16);
            OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Current location");
            this.f3581s.m3855b(overlayItem);
            this.f3581s.m3854a(overlayItem);
            this.f3580r.clear();
            this.f3580r.add(this.f3581s);
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
        m3848g();
    }

    protected void onPause() {
        super.onPause();
        if (!this.f3585w) {
        }
        this.f3578p.removeUpdates(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.geo_current /* 2131493610 */:
                if (this.f3583u != null) {
                    m3852a(this.f3583u);
                    break;
                } else {
                    this.f3585w = true;
                    m3851a();
                    break;
                }
            case R.id.ZoomIn /* 2131493612 */:
                this.f3576n.getController().zoomIn();
                break;
            case R.id.ZoomOut /* 2131493613 */:
                this.f3576n.getController().zoomOut();
                break;
        }
    }

    /* renamed from: e */
    private void m3844e() {
        if (this.f3582t != null) {
            Intent intent = new Intent();
            intent.putExtra("GEOPOINT", (this.f3582t.getLatitudeE6() / 1000000.0d) + "," + (this.f3582t.getLongitudeE6() / 1000000.0d));
            setResult(-1, intent);
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m3846f() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f3573k.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        m3839c();
    }

    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", getClass().getSimpleName());
        C1781m.m6022b(getApplicationContext());
    }

    /* renamed from: g */
    private void m3848g() {
        C1786r.m6061b("showPasswordLockActivity", getClass().getSimpleName());
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }
}
