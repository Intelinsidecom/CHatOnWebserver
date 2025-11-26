package com.sec.chaton.smsplugin.multimedia.geotag;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.motion.MotionRecognitionManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewRootImpl;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.R;
import com.sec.chaton.privateplugin.data.Spam;
import com.sec.chaton.smsplugin.p111h.C3890m;
import com.sec.chaton.smsplugin.p111h.C3894q;
import com.sec.chaton.widget.ClearableEditText;
import com.sec.common.CommonApplication;
import com.sec.common.actionbar.ActionBarMapActivity;
import com.sec.common.p123a.AbstractC4932a;
import com.sec.common.p123a.InterfaceC4936e;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class MmsGeotagActivity extends ActionBarMapActivity implements LocationListener, View.OnClickListener {

    /* renamed from: b */
    private static final String f14114b = MmsGeotagActivity.class.getSimpleName();

    /* renamed from: A */
    private boolean f14115A;

    /* renamed from: B */
    private Location f14116B;

    /* renamed from: C */
    private String f14117C;

    /* renamed from: D */
    private AsyncTaskC3936n f14118D;

    /* renamed from: E */
    private boolean f14119E;

    /* renamed from: F */
    private ProgressDialog f14120F;

    /* renamed from: G */
    private int f14121G;

    /* renamed from: H */
    private int f14122H;

    /* renamed from: c */
    private Context f14125c;

    /* renamed from: d */
    private Bundle f14126d;

    /* renamed from: e */
    private ClearableEditText f14127e;

    /* renamed from: f */
    private ImageButton f14128f;

    /* renamed from: g */
    private Drawable f14129g;

    /* renamed from: h */
    private MapView f14130h;

    /* renamed from: i */
    private MapController f14131i;

    /* renamed from: k */
    private List<Overlay> f14133k;

    /* renamed from: l */
    private C3923a f14134l;

    /* renamed from: m */
    private GeoPoint f14135m;

    /* renamed from: n */
    private GeoPoint f14136n;

    /* renamed from: r */
    private String f14140r;

    /* renamed from: s */
    private ImageButton f14141s;

    /* renamed from: t */
    private ImageButton f14142t;

    /* renamed from: u */
    private MenuItem f14143u;

    /* renamed from: v */
    private View f14144v;

    /* renamed from: w */
    private boolean f14145w;

    /* renamed from: x */
    private boolean f14146x;

    /* renamed from: y */
    private Handler f14147y;

    /* renamed from: z */
    private InterfaceC4936e f14148z;

    /* renamed from: j */
    private LocationManager f14132j = null;

    /* renamed from: o */
    private boolean f14137o = true;

    /* renamed from: p */
    private boolean f14138p = true;

    /* renamed from: q */
    private boolean f14139q = true;

    /* renamed from: I */
    private Bitmap f14123I = null;

    /* renamed from: a */
    public final Handler f14124a = new HandlerC3925c(this);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.sec.common.actionbar.ActionBarMapActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f14119E = getIntent().getBooleanExtra("image_location", true);
        this.f14125c = this;
        setContentView(R.layout.layout_geotag);
        m15154e();
        this.f14121G = 240;
        this.f14122H = 320;
        if (this.f14137o) {
            m15157f();
        } else {
            m15160h();
        }
        getWindow().addFlags(128);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: e */
    private void m15154e() {
        this.f14144v = findViewById(R.id.layout_search_location);
        this.f14127e = (ClearableEditText) this.f14144v.findViewById(R.id.text1);
        this.f14127e.setHint(R.string.search_location);
        this.f14127e.setMaxLength(30);
        this.f14127e.setImeOptions(3);
        this.f14127e.setText("");
        this.f14127e.setInputType(MotionRecognitionManager.EVENT_TILT_LEVEL_ZERO_LAND);
        this.f14127e.setOnMaxLengthReachListener(new C3924b(this));
        this.f14128f = (ImageButton) this.f14144v.findViewById(R.id.button1);
        this.f14128f.setImageResource(R.drawable.input_ic_gps);
        this.f14128f.setOnClickListener(this);
        this.f14130h = findViewById(R.id.map);
        this.f14131i = this.f14130h.getController();
        this.f14131i.setZoom(16);
        this.f14130h.setBuiltInZoomControls(false);
        this.f14141s = (ImageButton) findViewById(R.id.zoomIn);
        this.f14142t = (ImageButton) findViewById(R.id.zoomOut);
        this.f14141s.setOnClickListener(new ViewOnClickListenerC3928f(this));
        this.f14142t.setOnClickListener(new ViewOnClickListenerC3929g(this));
        this.f14133k = this.f14130h.getOverlays();
        this.f14129g = getResources().getDrawable(R.drawable.co_location_btn1);
        this.f14134l = new C3923a(this.f14129g, this);
        this.f14127e.setOnEditorActionListener(new C3930h(this));
        this.f14132j = (LocationManager) getSystemService("location");
        this.f14126d = getIntent().getExtras();
        if (this.f14126d != null && this.f14126d.containsKey("Geo Point")) {
            this.f14137o = false;
            this.f14144v.setVisibility(8);
        } else {
            this.f14137o = true;
            this.f14144v.setVisibility(0);
        }
        this.f14120F = new ProgressDialog(this);
        this.f14120F.setMessage(getString(R.string.dialog_geo_loading));
        this.f14120F.setCanceledOnTouchOutside(false);
        this.f14120F.setCancelable(true);
        this.f14120F.setOnCancelListener(new DialogInterfaceOnCancelListenerC3931i(this));
    }

    /* renamed from: a */
    protected void m15171a() {
        if (this.f14130h != null) {
            if (this.f14130h.getZoomLevel() >= 21) {
                this.f14141s.setEnabled(false);
                this.f14142t.setEnabled(true);
            } else {
                if (this.f14130h.getZoomLevel() <= 2) {
                    if (this.f14131i != null) {
                        this.f14131i.setZoom(2);
                    }
                    this.f14141s.setEnabled(true);
                    this.f14142t.setEnabled(false);
                    return;
                }
                this.f14141s.setEnabled(true);
                this.f14142t.setEnabled(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m15157f() {
        LocationProvider provider;
        boolean zIsProviderEnabled = this.f14132j.isProviderEnabled("gps");
        C3890m.m14999e("GPS_PROVIDER enabled : " + zIsProviderEnabled, f14114b);
        if (zIsProviderEnabled) {
            LocationProvider provider2 = this.f14132j.getProvider("gps");
            if (provider2 != null) {
                m15173a(provider2.getName());
                this.f14115A = true;
            }
            boolean zIsProviderEnabled2 = this.f14132j.isProviderEnabled("network");
            C3890m.m14999e("NETWORK_PROVIDER enabled : " + zIsProviderEnabled2, f14114b);
            if (zIsProviderEnabled2 && (provider = this.f14132j.getProvider("network")) != null) {
                m15173a(provider.getName());
                return;
            }
            return;
        }
        m15158g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: g */
    private void m15158g() {
        InterfaceC4936e interfaceC4936eMo18745a = AbstractC4932a.m18733a((Context) this).mo18740a(getResources().getString(R.string.pop_up_attention)).mo18749b(getResources().getString(R.string.geotag_dialog_findgsp_message_failed_notfound)).mo18755c(getResources().getString(R.string.dialog_ok), new DialogInterfaceOnClickListenerC3933k(this)).mo18741a(getResources().getString(R.string.dialog_cancel), new DialogInterfaceOnClickListenerC3932j(this)).mo18751b(false).mo18745a();
        interfaceC4936eMo18745a.setCanceledOnTouchOutside(false);
        interfaceC4936eMo18745a.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: h */
    private void m15160h() {
        String strNextToken = null;
        StringTokenizer stringTokenizer = new StringTokenizer(this.f14126d.getString("Geo Point").toString(), "\n");
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        C3890m.m14996b("*** RECEIVED GEO TAG COORD : " + strNextToken, f14114b);
        if (strNextToken == null) {
            Toast.makeText((Context) this, R.string.geotag_dialog_findgsp_title_failed_find_location, 1).show();
            return;
        }
        String[] strArrSplit = strNextToken.split(",");
        GeoPoint geoPoint = new GeoPoint((int) (Double.parseDouble(strArrSplit[0]) * 1000000.0d), (int) (Double.parseDouble(strArrSplit[1]) * 1000000.0d));
        this.f14134l.m15181a(new OverlayItem(geoPoint, Spam.CATEGORY_DEFAULT, "Searched location"));
        this.f14133k.clear();
        this.f14133k.add(this.f14134l);
        this.f14131i.animateTo(geoPoint);
    }

    @Override // com.sec.common.actionbar.ActionBarMapActivity
    protected boolean isRouteDisplayed() {
        return false;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        C3890m.m14996b(f14114b, "onLocationChanged() provider : " + location.getProvider());
        if (!this.f14146x) {
            if ("network".equals(location.getProvider()) && this.f14115A) {
                C3890m.m14996b(f14114b, "onLocationChanged() return : " + location.getProvider());
                this.f14116B = location;
            } else {
                m15144a(location);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15144a(Location location) {
        GeoPoint geoPoint = null;
        if (this.f14137o) {
            geoPoint = new GeoPoint((int) (location.getLatitude() * 1000000.0d), (int) (location.getLongitude() * 1000000.0d));
            this.f14135m = geoPoint;
            this.f14136n = geoPoint;
        }
        if (this.f14139q && !this.f14145w) {
            this.f14131i.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, Spam.CATEGORY_DEFAULT, "Current location");
            this.f14134l.m15182b(overlayItem);
            this.f14134l.m15181a(overlayItem);
            this.f14133k.clear();
            this.f14133k.add(this.f14134l);
            this.f14140r = m15142a(getApplicationContext(), location.getLatitude(), location.getLongitude());
            if (this.f14120F != null && this.f14120F.isShowing()) {
                this.f14120F.hide();
            }
            this.f14139q = false;
            this.f14143u.setEnabled(true);
        }
    }

    /* renamed from: a */
    private String m15142a(Context context, double d, double d2) throws IOException {
        try {
            List<Address> fromLocation = new Geocoder(context, Locale.getDefault()).getFromLocation(d, d2, 1);
            if (fromLocation != null) {
                return fromLocation.get(0).getAddressLine(0);
            }
            return null;
        } catch (IOException e) {
            C3890m.m14995a(f14114b, e.getMessage(), e);
            return null;
        } catch (Exception e2) {
            C3890m.m14995a(f14114b, e2.getMessage(), e2);
            return null;
        }
    }

    /* renamed from: a */
    public void m15173a(String str) {
        C3890m.m14996b("requestCurrentLocation() provider : " + str, f14114b);
        this.f14116B = null;
        if (str != null) {
            this.f14132j.requestLocationUpdates(str, 0L, 0.0f, this);
            this.f14147y = new Handler();
            this.f14147y.postDelayed(new RunnableC3934l(this), 15000L);
        } else {
            m15158g();
        }
        if (this.f14138p) {
            this.f14120F.show();
            this.f14138p = false;
        }
        if (str != null) {
            if (this.f14143u != null) {
                this.f14143u.setEnabled(true);
            }
            this.f14128f.setEnabled(true);
        } else {
            if (this.f14143u != null) {
                this.f14143u.setEnabled(false);
            }
            this.f14128f.setEnabled(false);
        }
    }

    /* renamed from: b */
    public void m15176b(String str) {
        int iM15037a = C3894q.m15037a(CommonApplication.m18732r());
        if (-3 == iM15037a || -2 == iM15037a) {
            Toast.makeText(this.f14125c, R.string.no_geo_point, 0).show();
            return;
        }
        this.f14120F.setOnCancelListener(new DialogInterfaceOnCancelListenerC3935m(this));
        this.f14120F.show();
        this.f14117C = str;
        this.f14118D = new AsyncTaskC3936n(this, null);
        this.f14118D.execute(str);
    }

    /* renamed from: a */
    public void m15172a(GeoPoint geoPoint) {
        if (this.f14137o && geoPoint != null) {
            this.f14140r = m15142a(getApplicationContext(), geoPoint.getLatitudeE6() / 1000000.0d, geoPoint.getLongitudeE6() / 1000000.0d);
            this.f14131i.animateTo(geoPoint);
            OverlayItem overlayItem = new OverlayItem(geoPoint, Spam.CATEGORY_DEFAULT, "Current location");
            this.f14134l.m15182b(overlayItem);
            this.f14134l.m15181a(overlayItem);
            this.f14133k.clear();
            this.f14133k.add(this.f14134l);
        }
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
        if ("gps".equals(str)) {
            this.f14115A = false;
        }
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
        if ("gps".equals(str)) {
            this.f14115A = true;
        }
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
        this.f14132j.removeUpdates(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1 /* 2131165821 */:
                m15178c();
                if (this.f14136n != null) {
                    m15172a(this.f14136n);
                    break;
                } else {
                    this.f14138p = true;
                    this.f14139q = true;
                    m15157f();
                    break;
                }
        }
    }

    /* renamed from: a */
    private boolean m15147a(int i, int i2, String str) {
        C3923a c3923a = (C3923a) this.f14130h.getOverlays().get(0);
        if (c3923a == null) {
            C3890m.m14996b(f14114b, "itemizedOverlay may not be null.");
            return false;
        }
        c3923a.m15181a(m15140a(i, i2, (Drawable) null, str));
        return true;
    }

    /* renamed from: a */
    private OverlayItem m15140a(int i, int i2, Drawable drawable, String str) {
        OverlayItem overlayItem = new OverlayItem(new GeoPoint(i, i2), "", str);
        overlayItem.setMarker(drawable);
        return overlayItem;
    }

    /* renamed from: a */
    private int m15137a(double d) {
        return Double.valueOf(1000000.0d * d).intValue();
    }

    /* renamed from: a */
    private boolean m15146a(int i, int i2, int i3, int i4) {
        GeoPoint geoPoint = new GeoPoint(((i2 - i) / 2) + i, ((i4 - i3) / 2) + i3);
        this.f14130h.getController().setCenter(geoPoint);
        this.f14130h.getController().animateTo(geoPoint);
        this.f14135m = geoPoint;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private boolean m15153d(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return false;
        }
        int iMin = 90000000;
        int iMax = -90000000;
        int iMin2 = 180000000;
        int iMax2 = -180000000;
        try {
            List<Address> fromLocationName = new Geocoder(this).getFromLocationName(str, 5);
            if (!fromLocationName.isEmpty()) {
                ((C3923a) this.f14130h.getOverlays().get(0)).m15180a();
                Address address = null;
                for (int i = 0; i < fromLocationName.size(); i++) {
                    address = fromLocationName.get(i);
                    int iM15137a = m15137a(address.getLatitude());
                    int iM15137a2 = m15137a(address.getLongitude());
                    m15147a(iM15137a, iM15137a2, address.getAdminArea());
                    iMin = Math.min(iMin, iM15137a);
                    iMax = Math.max(iMax, iM15137a);
                    iMin2 = Math.min(iMin2, iM15137a2);
                    iMax2 = Math.max(iMax2, iM15137a2);
                }
                if (address != null) {
                    m15146a(iMin, iMax, iMin2, iMax2);
                }
            } else {
                Toast.makeText((Context) this, (CharSequence) (getResources().getString(R.string.map_no_result) + str), 0).show();
            }
        } catch (Exception e) {
        }
        return true;
    }

    /* renamed from: b */
    protected void m15175b() {
        this.f14130h.setDrawingCacheEnabled(true);
        try {
            Bitmap drawingCache = this.f14130h.getDrawingCache();
            if (drawingCache != null) {
                this.f14123I = Bitmap.createBitmap(drawingCache, (drawingCache.getWidth() - this.f14122H) / 2, (drawingCache.getHeight() - this.f14121G) / 2, this.f14122H, this.f14121G);
            }
        } catch (ViewRootImpl.CalledFromWrongThreadException e) {
            e.printStackTrace();
            this.f14123I = null;
        }
    }

    /* renamed from: a */
    private double m15136a(int i) {
        return i / 1000000.0d;
    }

    /* renamed from: b */
    protected String m15174b(GeoPoint geoPoint) {
        return ("http://maps.google.com/maps?f=q&q=(" + m15136a(geoPoint.getLatitudeE6()) + "," + m15136a(geoPoint.getLongitudeE6()) + ")\n").toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    protected String m15177c(GeoPoint geoPoint) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        double dM15136a = m15136a(geoPoint.getLatitudeE6());
        double dM15136a2 = m15136a(geoPoint.getLongitudeE6());
        try {
            List<Address> fromLocation = geocoder.getFromLocation(dM15136a, dM15136a2, 1);
            if (!fromLocation.isEmpty()) {
                Address address = fromLocation.get(0);
                if (address == null) {
                    C3890m.m14996b(f14114b, "address may not be null");
                    return null;
                }
                for (int i = 0; i < address.getMaxAddressLineIndex() + 1; i++) {
                    if (address.getAddressLine(i) != null) {
                        sb2.append(address.getAddressLine(i)).append("\n");
                    }
                }
            }
            this.f14140r = sb2.toString();
            sb.append(this.f14140r);
            sb.append("http://maps.google.com/maps?f=q&q=(" + dM15136a + "," + dM15136a2 + ")").append("\n");
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: i */
    private void m15163i() throws IOException {
        String strM15177c = "";
        if (this.f14119E) {
            if (this.f14140r != null) {
                m15153d(this.f14140r);
            }
            m15175b();
            if (this.f14135m != null) {
                strM15177c = m15174b(this.f14135m);
            }
        } else if (this.f14135m != null) {
            strM15177c = m15177c(this.f14135m);
        }
        m15179c(strM15177c);
    }

    /* renamed from: c */
    protected void m15179c(String str) {
        Intent intent = new Intent();
        intent.putExtra("location", str);
        if (this.f14123I != null) {
            intent.putExtra("map_image", this.f14123I);
        }
        setResult(-1, intent);
        finish();
    }

    /* renamed from: c */
    public void m15178c() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f14127e.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        m15157f();
    }

    protected void onDestroy() {
        this.f14146x = true;
        if (this.f14120F != null) {
            this.f14120F.dismiss();
        }
        if (this.f14148z != null) {
            this.f14148z.dismiss();
        }
        if (this.f14147y != null) {
            this.f14147y.removeMessages(0);
        }
        if (this.f14118D != null) {
            this.f14118D.cancel(true);
        }
        getWindow().clearFlags(128);
        super.onDestroy();
    }

    protected void onUserLeaveHint() {
        C3890m.m14996b(getClass().getSimpleName(), "onUserLeaveHint");
    }

    @Override // com.sec.common.actionbar.ActionBarMapActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportCreateOptionsMenu(Menu menu) {
        if (this.f14137o) {
            getMenuInflater().inflate(R.menu.cancel_done_menu, menu);
            this.f14143u = menu.findItem(R.id.menu_done);
            this.f14143u.setTitle(R.string.layout_imageview_send);
            this.f14143u.setEnabled(false);
        }
        return super.onSupportCreateOptionsMenu(menu);
    }

    @Override // com.sec.common.actionbar.ActionBarMapActivity, com.sec.common.actionbar.InterfaceC4964s
    public boolean onSupportOptionsItemSelected(MenuItem menuItem) throws IOException {
        if (menuItem.getItemId() == 16908332 || menuItem.getItemId() == R.id.menu_cancel) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.menu_done) {
            m15163i();
            return true;
        }
        return super.onSupportOptionsItemSelected(menuItem);
    }
}
