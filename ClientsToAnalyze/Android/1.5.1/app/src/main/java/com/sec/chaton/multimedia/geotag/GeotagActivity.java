package com.sec.chaton.multimedia.geotag;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.sec.chaton.C0062R;
import com.sec.chaton.util.ChatONLogWriter;
import com.sec.chaton.widget.SMSProgressBar;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes.dex */
public class GeotagActivity extends MapActivity implements LocationListener, View.OnClickListener {

    /* renamed from: a */
    public static final String f2140a = GeotagActivity.class.getSimpleName();

    /* renamed from: c */
    private Context f2142c;

    /* renamed from: d */
    private Bundle f2143d;

    /* renamed from: e */
    private Dialog f2144e;

    /* renamed from: f */
    private LinearLayout f2145f;

    /* renamed from: g */
    private EditText f2146g;

    /* renamed from: h */
    private LinearLayout f2147h;

    /* renamed from: i */
    private ImageButton f2148i;

    /* renamed from: j */
    private Button f2149j;

    /* renamed from: k */
    private Button f2150k;

    /* renamed from: l */
    private Drawable f2151l;

    /* renamed from: m */
    private MapView f2152m;

    /* renamed from: n */
    private MapController f2153n;

    /* renamed from: p */
    private String f2155p;

    /* renamed from: q */
    private List f2156q;

    /* renamed from: r */
    private GeoOverlay f2157r;

    /* renamed from: s */
    private GeoPoint f2158s;

    /* renamed from: t */
    private GeoPoint f2159t;

    /* renamed from: o */
    private LocationManager f2154o = null;

    /* renamed from: u */
    private boolean f2160u = true;

    /* renamed from: v */
    private boolean f2161v = true;

    /* renamed from: w */
    private boolean f2162w = true;

    /* renamed from: x */
    private final double f2163x = 37.49670534761301d;

    /* renamed from: y */
    private final double f2164y = 127.02687798057548d;

    /* renamed from: z */
    private GeoPoint f2165z = null;

    /* renamed from: b */
    public final Handler f2141b = new HandlerC0297a(this);

    /* renamed from: a */
    private GeoPoint m2536a(int i, int i2) throws IOException {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL("http://www.google.com/glm/mmap").openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            m2538a(httpURLConnection.getOutputStream(), i, i2);
            DataInputStream dataInputStream = new DataInputStream(httpURLConnection.getInputStream());
            dataInputStream.readShort();
            dataInputStream.readByte();
            if (dataInputStream.readInt() == 0) {
                return new GeoPoint((int) (dataInputStream.readInt() * 1000000.0d), (int) (dataInputStream.readInt() * 1000000.0d));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    private void m2538a(OutputStream outputStream, int i, int i2) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeShort(21);
        dataOutputStream.writeLong(0L);
        dataOutputStream.writeUTF("en");
        dataOutputStream.writeUTF("Android");
        dataOutputStream.writeUTF("1.0");
        dataOutputStream.writeUTF("Web");
        dataOutputStream.writeByte(27);
        dataOutputStream.writeInt(0);
        dataOutputStream.writeInt(0);
        dataOutputStream.writeInt(3);
        dataOutputStream.writeUTF("");
        dataOutputStream.writeInt(i);
        dataOutputStream.writeInt(i2);
        dataOutputStream.writeInt(0);
        dataOutputStream.writeInt(0);
        dataOutputStream.writeInt(0);
        dataOutputStream.writeInt(0);
        dataOutputStream.flush();
    }

    /* renamed from: b */
    private void m2541b() throws Resources.NotFoundException {
        this.f2145f = (LinearLayout) findViewById(C0062R.id.geotag_searcdh_bar);
        this.f2146g = (EditText) findViewById(C0062R.id.geo_search);
        this.f2152m = findViewById(C0062R.id.map);
        this.f2152m.setBuiltInZoomControls(true);
        this.f2153n = this.f2152m.getController();
        this.f2147h = (LinearLayout) findViewById(C0062R.id.geo_menu_bar);
        this.f2148i = (ImageButton) findViewById(C0062R.id.geo_current);
        this.f2148i.setOnClickListener(this);
        this.f2149j = (Button) findViewById(C0062R.id.geo_send);
        this.f2149j.setOnClickListener(this);
        this.f2150k = (Button) findViewById(C0062R.id.geo_cancel);
        this.f2150k.setOnClickListener(this);
        this.f2156q = this.f2152m.getOverlays();
        this.f2151l = getResources().getDrawable(C0062R.drawable.ic_location_pin);
        this.f2157r = new GeoOverlay(this.f2151l, this);
        this.f2146g.setOnEditorActionListener(new C0299c(this));
        Drawable drawable = getResources().getDrawable(C0062R.drawable.ic_btn_search);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        this.f2146g.setCompoundDrawables(null, null, drawable, null);
        this.f2146g.setOnTouchListener(new ViewOnTouchListenerC0301e(this, drawable));
        this.f2154o = (LocationManager) getSystemService("location");
        this.f2143d = getIntent().getExtras();
        if (this.f2143d == null || !this.f2143d.containsKey("Geo Point")) {
            this.f2160u = true;
            this.f2145f.setVisibility(0);
            this.f2147h.setVisibility(0);
        } else {
            this.f2160u = false;
            this.f2145f.setVisibility(8);
            this.f2147h.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    private void m2542c() {
        if (this.f2154o.isProviderEnabled("gps")) {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(0);
            this.f2155p = this.f2154o.getBestProvider(criteria, true);
            m2551a();
        } else {
            CellLocation.requestLocationUpdate();
            GsmCellLocation gsmCellLocation = (GsmCellLocation) ((TelephonyManager) getSystemService("phone")).getCellLocation();
            this.f2165z = m2536a(gsmCellLocation.getCid(), gsmCellLocation.getLac());
            if (this.f2165z == null) {
            }
            if (this.f2165z != null) {
                m2551a();
                return;
            }
            new AlertDialog.Builder(this).setTitle(getResources().getString(C0062R.string.geotag_dialog_findgsp_title_failed_notfound)).setMessage(getResources().getString(C0062R.string.geotag_dialog_findgsp_message_failed_notfound)).setPositiveButton(getResources().getString(C0062R.string.geotag_dialog_findgsp_button_failed_setting), new DialogInterfaceOnClickListenerC0303g(this)).setNegativeButton(getResources().getString(C0062R.string.geotag_dialog_findgsp_button_failed_cancel), new DialogInterfaceOnClickListenerC0300d(this)).show();
        }
        if (this.f2155p != null) {
            this.f2148i.setEnabled(true);
        } else {
            this.f2148i.setEnabled(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    private void m2545d() {
        String strNextToken = null;
        StringTokenizer stringTokenizer = new StringTokenizer(this.f2143d.getString("Geo Point").toString(), "\n");
        while (stringTokenizer.hasMoreTokens()) {
            strNextToken = stringTokenizer.nextToken();
        }
        ChatONLogWriter.m3512f("*** RECEIVED GEO TAG COORD : " + strNextToken, f2140a);
        if (strNextToken == null) {
            Toast.makeText((Context) this, C0062R.string.no_geo_point, 1).show();
            return;
        }
        String[] strArrSplit = strNextToken.split(",");
        GeoPoint geoPoint = new GeoPoint((int) (Double.parseDouble(strArrSplit[0]) * 1000000.0d), (int) (Double.parseDouble(strArrSplit[1]) * 1000000.0d));
        this.f2157r.m2533a(new OverlayItem(geoPoint, "test", "Searched location"));
        this.f2156q.add(this.f2157r);
        this.f2153n.animateTo(geoPoint);
        this.f2153n.setZoom(16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m2547e() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(this.f2146g.getWindowToken(), 0);
            }
        } catch (Exception e) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m2551a() {
        ChatONLogWriter.m3512f("requestCurrentLocation()", f2140a);
        if (this.f2155p != null) {
            this.f2154o.requestLocationUpdates(this.f2155p, 0L, 0.0f, this);
        } else if (this.f2165z != null) {
            if (this.f2160u) {
                this.f2158s = this.f2165z;
                this.f2159t = this.f2165z;
            }
            this.f2153n.animateTo(this.f2165z);
            this.f2153n.setZoom(16);
            OverlayItem overlayItem = new OverlayItem(this.f2165z, "test", "Current location");
            this.f2157r.m2534b(overlayItem);
            this.f2157r.m2533a(overlayItem);
            this.f2156q.add(this.f2157r);
            if (this.f2144e != null) {
                this.f2144e.dismiss();
            }
            this.f2162w = false;
        } else {
            new AlertDialog.Builder(this).setMessage(C0062R.string.dialog_geo_warning).setPositiveButton(C0062R.string.password_confirm, new DialogInterfaceOnClickListenerC0302f(this)).show();
        }
        if (!this.f2161v || this.f2155p == null) {
            return;
        }
        this.f2144e = new SMSProgressBar(this).onCreate(C0062R.string.dialog_geo_loading);
        this.f2144e.show();
        this.f2161v = false;
        new Handler().postDelayed(new RunnableC0298b(this), 20000L);
    }

    /* renamed from: a */
    public void m2552a(GeoPoint geoPoint) {
        if (!this.f2160u || geoPoint == null) {
            return;
        }
        this.f2158s = geoPoint;
        this.f2153n.animateTo(geoPoint);
        this.f2153n.setZoom(16);
        OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Current location");
        this.f2157r.m2534b(overlayItem);
        this.f2157r.m2533a(overlayItem);
        this.f2156q.add(this.f2157r);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public void m2553a(String str) {
        try {
            List<Address> fromLocationName = new Geocoder(this).getFromLocationName(str, 5);
            if (fromLocationName.size() > 0) {
                GeoPoint geoPoint = new GeoPoint((int) (fromLocationName.get(0).getLatitude() * 1000000.0d), (int) (fromLocationName.get(0).getLongitude() * 1000000.0d));
                this.f2158s = geoPoint;
                this.f2153n.animateTo(geoPoint);
                OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Searched location");
                this.f2157r.m2534b(overlayItem);
                this.f2157r.m2533a(overlayItem);
                this.f2156q.add(this.f2157r);
            } else {
                Toast.makeText((Context) this, C0062R.string.no_geo_point, 1).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected boolean isRouteDisplayed() {
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        m2542c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.geo_current /* 2131427812 */:
                if (this.f2159t == null) {
                    this.f2161v = true;
                    m2551a();
                    break;
                } else {
                    m2552a(this.f2159t);
                    break;
                }
            case C0062R.id.geo_send /* 2131427813 */:
                if (this.f2158s != null) {
                    Intent intent = new Intent();
                    intent.putExtra("GEOPOINT", (this.f2158s.getLatitudeE6() / 1000000.0d) + "," + (this.f2158s.getLongitudeE6() / 1000000.0d));
                    setResult(-1, intent);
                    finish();
                    break;
                }
                break;
            case C0062R.id.geo_cancel /* 2131427814 */:
                finish();
                break;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) throws Resources.NotFoundException {
        super.onCreate(bundle);
        this.f2142c = this;
        setContentView(C0062R.layout.layout_geotag);
        m2541b();
        if (this.f2160u) {
            m2542c();
        } else {
            m2545d();
        }
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        ChatONLogWriter.m3512f("onLocationChanged()", f2140a);
        if (this.f2162w) {
            GeoPoint geoPoint = null;
            if (this.f2160u) {
                GeoPoint geoPoint2 = new GeoPoint((int) (location.getLatitude() * 1000000.0d), (int) (location.getLongitude() * 1000000.0d));
                this.f2158s = geoPoint2;
                this.f2159t = geoPoint2;
                geoPoint = geoPoint2;
            }
            this.f2153n.animateTo(geoPoint);
            this.f2153n.setZoom(16);
            OverlayItem overlayItem = new OverlayItem(geoPoint, "test", "Current location");
            this.f2157r.m2534b(overlayItem);
            this.f2157r.m2533a(overlayItem);
            this.f2156q.add(this.f2157r);
            this.f2144e.dismiss();
            this.f2162w = false;
        }
    }

    protected void onPause() {
        super.onPause();
        if (this.f2161v) {
            return;
        }
        this.f2144e.dismiss();
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    protected void onResume() {
        super.onResume();
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }
}
