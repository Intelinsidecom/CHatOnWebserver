package com.sec.chaton.multimedia.image;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p012c.C0452a;
import com.sec.chaton.p022h.p025c.C0777a;
import com.sec.chaton.settings.ActivityPasswordLockSet;
import com.sec.chaton.trunk.database.C1587c;
import com.sec.chaton.trunk.p053e.C1597f;
import com.sec.chaton.trunk.p053e.C1598g;
import com.sec.chaton.util.C1767bw;
import com.sec.chaton.util.C1781m;
import com.sec.chaton.util.C1783o;
import com.sec.chaton.util.C1786r;
import com.sec.widget.C2153y;
import java.io.IOException;

/* loaded from: classes.dex */
public class ViewOriginalImage extends Activity {

    /* renamed from: b */
    private static final String f3602b = null;

    /* renamed from: e */
    private static final String f3603e = ViewOriginalImage.class.getSimpleName();

    /* renamed from: c */
    private String f3605c;

    /* renamed from: d */
    private Context f3606d;

    /* renamed from: f */
    private long f3607f;

    /* renamed from: g */
    private String f3608g;

    /* renamed from: h */
    private ZoomableImageView f3609h;

    /* renamed from: i */
    private ImageView f3610i;

    /* renamed from: j */
    private ProgressBar f3611j;

    /* renamed from: k */
    private MenuItem f3612k;

    /* renamed from: m */
    private ViewTreeObserver.OnGlobalLayoutListener f3614m;

    /* renamed from: n */
    private TextView f3615n;

    /* renamed from: o */
    private LinearLayout f3616o;

    /* renamed from: p */
    private String f3617p;

    /* renamed from: l */
    private boolean f3613l = false;

    /* renamed from: q */
    private boolean f3618q = true;

    /* renamed from: a */
    Handler f3604a = new HandlerC0986d(this);

    /* renamed from: r */
    private View.OnClickListener f3619r = new ViewOnClickListenerC0987e(this);

    @Override // android.app.Activity
    @SuppressLint({"NewApi"})
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_original_imageview);
        if (GlobalApplication.m3265f() && Build.VERSION.SDK_INT >= 14) {
            getActionBar().setDisplayHomeAsUpEnabled(true);
            getActionBar().setTitle(R.string.profile_image_photo);
        }
        this.f3606d = this;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f3605c = extras.getString("uri");
            this.f3607f = extras.getLong("messageId", 0L);
            this.f3608g = extras.getString("inboxNO");
            this.f3613l = extras.getBoolean(C0452a.f1729h, false);
            this.f3617p = extras.getString(C0452a.f1730i, "");
        }
        this.f3616o = (LinearLayout) findViewById(R.id.OrigImagebubblelayout);
        this.f3615n = (TextView) findViewById(R.id.origImgcommentbubble);
        if (this.f3613l && GlobalApplication.m3265f()) {
            this.f3616o.setVisibility(0);
            this.f3616o.setOnClickListener(this.f3619r);
            getWindow().setLayout(getResources().getDimensionPixelSize(R.dimen.layout_width), getResources().getDimensionPixelSize(R.dimen.layout_height));
            this.f3615n.setText(String.format(getString(R.string.trunk_comments), Integer.valueOf(m3866e())));
        }
        if (C1786r.f6452b) {
            C1786r.m6061b("mImageUri: " + this.f3605c + ", mMessageId: " + this.f3607f, f3603e);
        }
        if (C0777a.m3326a().m3328a(this.f3607f)) {
            C0777a.m3326a().m3330b(this.f3607f).m2791a(this.f3604a);
        }
        this.f3609h = (ZoomableImageView) findViewById(R.id.original_image);
        this.f3610i = (ImageView) findViewById(R.id.play_button);
        this.f3610i.setOnClickListener(new ViewOnClickListenerC0984b(this));
        this.f3611j = (ProgressBar) findViewById(R.id.download_progress);
        if (C0777a.m3326a().m3328a(this.f3607f)) {
            if (C1786r.f6452b) {
                C1786r.m6061b("isDonwloading : true, mMessageId: " + this.f3607f, f3603e);
            }
            this.f3611j.setVisibility(0);
            this.f3618q = false;
        } else if (C1786r.f6452b) {
            C1786r.m6061b("isDonwloading : false, mMessageId: " + this.f3607f, f3603e);
        }
        m3858a(this.f3605c);
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        C1786r.m6061b("onUserLeaveHint", "ViewOriginalImage");
        C1781m.m6022b(getApplicationContext());
    }

    /* renamed from: c */
    private void m3863c() {
        C1786r.m6061b("showPasswordLockActivity", "HomeActivity");
        Context applicationContext = getApplicationContext();
        if (C1781m.m6026c(applicationContext)) {
            Intent intent = new Intent(applicationContext, (Class<?>) ActivityPasswordLockSet.class);
            intent.putExtra("MODE", "HOME");
            startActivity(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m3858a(String str) {
        Boolean boolValueOf;
        if (TextUtils.isEmpty(str) || C0452a.f1724c.equals(str)) {
            this.f3609h.setImageResource(R.drawable.turnk_no_image_default);
            return;
        }
        if (C1598g.m5509c(str)) {
            this.f3610i.setVisibility(0);
        }
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Display defaultDisplay = ((WindowManager) this.f3606d.getSystemService("window")).getDefaultDisplay();
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = 1;
            int i = options.outWidth >> 1;
            for (int i2 = options.outHeight >> 1; i > defaultDisplay.getWidth() && i2 > defaultDisplay.getHeight(); i2 >>= 1) {
                options.inSampleSize <<= 1;
                i >>= 1;
            }
            options.inJustDecodeBounds = false;
            options.inDither = true;
            options.inPurgeable = true;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str, options);
            if (bitmapDecodeFile != null) {
                try {
                    String attribute = new ExifInterface(str).getAttribute("Orientation");
                    Matrix matrix = new Matrix();
                    Boolean.valueOf(false);
                    if ("6".equals(attribute)) {
                        boolValueOf = Boolean.valueOf(matrix.postRotate(90.0f));
                    } else if ("3".equals(attribute)) {
                        boolValueOf = Boolean.valueOf(matrix.postRotate(180.0f));
                    } else if ("8".equals(attribute)) {
                        boolValueOf = Boolean.valueOf(matrix.postRotate(270.0f));
                    } else {
                        boolValueOf = false;
                    }
                    if (boolValueOf.booleanValue()) {
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapDecodeFile, 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), matrix, true);
                        if (bitmapDecodeFile != null) {
                            bitmapDecodeFile.recycle();
                            bitmapDecodeFile = bitmapCreateBitmap;
                        } else {
                            bitmapDecodeFile = bitmapCreateBitmap;
                        }
                    }
                    this.f3609h.setImageBitmap(bitmapDecodeFile);
                } catch (IOException e) {
                    C1786r.m6056a(e, getApplicationContext().getClass().getName());
                }
            }
        } catch (Exception e2) {
            C1786r.m6056a(e2, getApplicationContext().getClass().getName());
        } catch (OutOfMemoryError e3) {
            C2153y.m7535a(this.f3606d, R.string.chat_view_memory_error, 1).show();
            C1786r.m6056a(e3, this.f3606d.getClass().getName());
            this.f3609h.setImageBitmap(null);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (this.f3609h != null) {
            ViewTreeObserver viewTreeObserver = this.f3609h.getViewTreeObserver();
            this.f3614m = new ViewTreeObserverOnGlobalLayoutListenerC0985c(this);
            viewTreeObserver.addOnGlobalLayoutListener(this.f3614m);
            m3863c();
        }
    }

    /* renamed from: a */
    public void m3868a() {
        if (!C1767bw.m6002a()) {
            Toast.makeText(getBaseContext(), R.string.sdcard_not_found, 0).show();
            return;
        }
        Intent intent = new Intent();
        String strM6032a = C1783o.m6032a(this.f3605c, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "//Camera//ChatON", this.f3605c.substring(this.f3605c.lastIndexOf("/") + 1));
        if (strM6032a != null) {
            sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED", Uri.parse("file://" + Environment.getExternalStorageDirectory())));
            intent.putExtra("SAVE", true);
            setResult(-1, intent);
            C1786r.m6061b("SAVE RESULT OK : " + strM6032a, getClass().getSimpleName());
        } else {
            C1786r.m6054a("SAVE RESULT Fail : " + this.f3605c, getClass().getSimpleName());
            intent.putExtra("SAVE", false);
            setResult(-1, intent);
        }
        finish();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        if (GlobalApplication.m3265f()) {
            getMenuInflater().inflate(R.menu.actionbar_menu_save_cancel, menu);
            if (this.f3618q) {
                this.f3612k = menu.findItem(R.id.menu_save).setVisible(true).setEnabled(true);
            } else {
                this.f3612k = menu.findItem(R.id.menu_save).setVisible(true).setEnabled(false);
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_cancel /* 2131494116 */:
                finish();
                break;
            case R.id.menu_save /* 2131494126 */:
                m3868a();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    protected void onPause() {
        ViewTreeObserver viewTreeObserver;
        super.onPause();
        if (this.f3609h != null && (viewTreeObserver = this.f3609h.getViewTreeObserver()) != null) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f3614m);
        }
    }

    /* renamed from: d */
    private Cursor m3864d() {
        return getApplicationContext().getContentResolver().query(C1587c.f5698a, null, C1597f.m5505a("item_id", " = ?"), new String[]{this.f3617p}, null);
    }

    /* renamed from: e */
    private int m3866e() {
        int i = 0;
        Cursor cursorM3864d = m3864d();
        if (cursorM3864d.moveToNext()) {
            i = cursorM3864d.getInt(cursorM3864d.getColumnIndex("total_comment_count"));
        }
        cursorM3864d.close();
        return i;
    }
}
