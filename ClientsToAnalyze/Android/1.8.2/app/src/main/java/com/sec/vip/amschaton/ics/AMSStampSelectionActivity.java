package com.sec.vip.amschaton.ics;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSImageEditorActivity;
import com.sec.vip.amschaton.C1849ai;
import com.sec.widget.GeneralHeaderView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSStampSelectionActivity extends AMSActivity {

    /* renamed from: l */
    public static boolean f7231l = true;

    /* renamed from: m */
    private int f7232m = 0;

    /* renamed from: n */
    private SharedPreferences f7233n = null;

    /* renamed from: o */
    private int[] f7234o = new int[4];

    /* renamed from: p */
    private GridView f7235p = null;

    /* renamed from: q */
    private C2036ce f7236q = null;

    /* renamed from: r */
    private GridView f7237r = null;

    /* renamed from: s */
    private C2035cd f7238s = null;

    /* renamed from: t */
    private C1849ai f7239t = C1849ai.m6394a();

    /* renamed from: u */
    private ArrayList f7240u = null;

    /* renamed from: v */
    private ArrayList f7241v = null;

    /* renamed from: w */
    private boolean f7242w = true;

    /* renamed from: x */
    private GeneralHeaderView f7243x = null;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i;
        C1786r.m6063c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_stamp);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            i = extras.getInt("AMS_STAMP_INDEX", 0);
        } else {
            C1786r.m6061b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            i = 0;
        }
        this.f7233n = getSharedPreferences("AMSPref", 3);
        this.f7234o[0] = this.f7233n.getInt("AMS_STAMP_PREF_00", -1);
        this.f7234o[1] = this.f7233n.getInt("AMS_STAMP_PREF_01", -1);
        this.f7234o[2] = this.f7233n.getInt("AMS_STAMP_PREF_02", -1);
        this.f7234o[3] = this.f7233n.getInt("AMS_STAMP_PREF_03", -1);
        boolean z = false;
        for (int i2 = 0; i2 < 4; i2++) {
            if (z || this.f7234o[i2] == 208) {
                this.f7234o[i2] = -1;
                z = true;
            }
        }
        int iM6402b = this.f7239t.m6402b();
        if (iM6402b == 0) {
            C1786r.m6061b("basicStampSize = " + iM6402b + " !, Load stamp again!", getClass().getSimpleName());
            m6264c();
        }
        m7157o();
        m7143h();
        m7145i();
        if (this.f7239t.m6405c() == 0) {
            m7134b(false);
        }
        m7130b(i);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        if (this.f7240u != null) {
            int size = this.f7240u.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f7240u.get(i)).recycle();
            }
            this.f7240u.clear();
            this.f7240u = null;
        }
        if (this.f7241v != null) {
            int size2 = this.f7241v.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((Bitmap) this.f7241v.get(i2)).recycle();
            }
            this.f7241v.clear();
            this.f7241v = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Bitmap bitmapM7122a;
        if (i2 == -1) {
            switch (i) {
                case 0:
                    Bundle extras = intent.getExtras();
                    if (extras != null && (bitmapM7122a = m7122a(intent, extras)) != null) {
                        m7127a(bitmapM7122a, AMSActivity.f6612e + m7124a("[STP]", System.currentTimeMillis(), ".png"));
                        m6264c();
                        m7143h();
                        if (this.f7237r != null) {
                            this.f7238s = null;
                            this.f7238s = new C2035cd(this);
                            this.f7237r.setAdapter((ListAdapter) this.f7238s);
                            new Handler().postDelayed(new RunnableC2028bx(this), 300L);
                        }
                        m7152l();
                        bitmapM7122a.recycle();
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: g */
    private void m7141g() {
        for (int i = 0; i < this.f7239t.m6402b(); i++) {
            this.f7240u.add(this.f7239t.m6397a(this.f7239t.m6403b(i), false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7143h() {
        if (this.f7240u == null) {
            this.f7240u = new ArrayList();
            m7141g();
        } else if (this.f7240u.size() == 0) {
            m7141g();
        }
        if (this.f7241v != null) {
            int size = this.f7241v.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f7241v.get(i)).recycle();
            }
            this.f7241v.clear();
            this.f7241v = null;
        }
        this.f7241v = new ArrayList();
        int iM6405c = this.f7239t.m6405c();
        for (int i2 = 0; i2 < iM6405c; i2++) {
            this.f7241v.add(this.f7239t.m6404b(i2, false));
        }
    }

    /* renamed from: i */
    private void m7145i() {
        if (this.f7234o[0] != -1) {
            this.f7235p = (GridView) findViewById(R.id.gridview_preference);
            this.f7236q = new C2036ce(this);
            this.f7235p.setAdapter((ListAdapter) this.f7236q);
            this.f7235p.setSelector(R.drawable.ams_ics_selector_basic_dummy);
            this.f7235p.setOnItemClickListener(new C2029by(this));
            ((ImageView) findViewById(R.id.stamp_line)).setVisibility(0);
        }
        this.f7237r = (GridView) findViewById(R.id.gridview_stamp);
        this.f7238s = new C2035cd(this);
        this.f7237r.setAdapter((ListAdapter) this.f7238s);
        this.f7237r.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        this.f7237r.setOnScrollListener(new C2030bz(this));
        this.f7237r.setOnItemClickListener(new C2032ca(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m7147j() {
        Intent intent = new Intent(this, (Class<?>) AMSImageEditorActivity.class);
        intent.putExtra("IMAGE_SELECTOR", 1003);
        startActivityForResult(intent, 0);
    }

    /* renamed from: b */
    private void m7130b(int i) {
        int iM6405c;
        int iM6405c2 = 0;
        if (i < 1000) {
            int iM6408d = this.f7239t.m6408d(i);
            if (this.f7237r != null) {
                if (iM6408d == -1) {
                    this.f7232m = 0;
                } else {
                    this.f7232m = iM6408d;
                    if (this.f7232m < this.f7239t.m6402b()) {
                        if (f7231l) {
                            iM6405c2 = this.f7232m + this.f7239t.m6405c();
                        } else {
                            iM6405c2 = this.f7232m;
                        }
                    }
                }
                this.f7237r.setSelection(iM6405c2);
            }
        } else {
            this.f7232m = (this.f7239t.m6402b() + i) - 1000;
            if (this.f7237r != null) {
                if (f7231l) {
                    iM6405c = (this.f7239t.m6405c() - 1) - (this.f7232m - this.f7239t.m6402b());
                } else {
                    iM6405c = this.f7232m;
                }
                this.f7237r.setSelection(iM6405c);
            }
        }
        m7152l();
    }

    /* renamed from: k */
    private int m7149k() {
        if (this.f7232m >= this.f7239t.m6402b()) {
            return (this.f7232m - this.f7239t.m6402b()) + 1000;
        }
        int iM6403b = this.f7239t.m6403b(this.f7232m);
        if (iM6403b == -1) {
            return 0;
        }
        return iM6403b;
    }

    /* renamed from: a */
    private boolean m7127a(Bitmap bitmap, String str) {
        return m7135b(bitmap, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m7152l() {
        if (this.f7238s != null) {
            this.f7238s.m7169a();
        }
        if (this.f7236q != null) {
            this.f7236q.m7170a();
        }
        if (this.f7239t.m6405c() > 0 || !this.f7242w) {
            m7134b(true);
        } else {
            m7134b(false);
        }
    }

    /* renamed from: a */
    private void m7125a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m7133b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009a  */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.sec.vip.amschaton.ics.AMSStampSelectionActivity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.graphics.Bitmap] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m7135b(android.graphics.Bitmap r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            r6 = this;
            r1 = 1
            r0 = 0
            java.lang.String r2 = r8.toLowerCase()
            java.lang.String r3 = ".png"
            boolean r2 = r2.endsWith(r3)
            if (r2 != 0) goto L1c
            java.lang.String r1 = "[saveBitmapToPNG] Wrong extension!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1786r.m6054a(r1, r2)
        L1b:
            return r0
        L1c:
            if (r7 != 0) goto L2c
            java.lang.String r1 = "[saveBitmapToPNG] Bitmap is null!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1786r.m6054a(r1, r2)
            goto L1b
        L2c:
            java.io.File r5 = new java.io.File
            r5.<init>(r8)
            r4 = 0
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L91
            r3.<init>(r5)     // Catch: java.io.IOException -> L55 java.lang.Throwable -> L91
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r4 = 100
            r7.compress(r2, r4, r3)     // Catch: java.lang.Throwable -> Lb2 java.io.IOException -> Lb4
            r6.m7125a(r3)
            r6.m7133b(r3)
            r2 = r1
        L45:
            if (r2 != 0) goto L9a
            java.lang.String r1 = "[saveBitmapToPNG] Fail to save file!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1786r.m6054a(r1, r2)
            goto L1b
        L55:
            r2 = move-exception
            r3 = r4
        L57:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = "[resizedJpegCopy] IO Exception!"
            java.lang.Class r4 = r6.getClass()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> Lb2
            com.sec.chaton.util.C1786r.m6054a(r2, r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r2.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = "[resizedJpegCopy] Out File: "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class r4 = r6.getClass()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> Lb2
            com.sec.chaton.util.C1786r.m6054a(r2, r4)     // Catch: java.lang.Throwable -> Lb2
            r6.m7125a(r3)
            r6.m7133b(r3)
            r2 = r0
            goto L45
        L91:
            r0 = move-exception
            r3 = r4
        L93:
            r6.m7125a(r3)
            r6.m7133b(r3)
            throw r0
        L9a:
            boolean r2 = r5.exists()
            if (r2 != 0) goto Laf
            java.lang.String r1 = "[saveBitmapToPNG] File does not exist!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1786r.m6054a(r1, r2)
            goto L1b
        Laf:
            r0 = r1
            goto L1b
        Lb2:
            r0 = move-exception
            goto L93
        Lb4:
            r2 = move-exception
            goto L57
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ics.AMSStampSelectionActivity.m7135b(android.graphics.Bitmap, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7136c(int i) {
        if (this.f7234o[0] != -1) {
            boolean z = false;
            for (int i2 = 0; i2 < 4; i2++) {
                if (this.f7234o[i2] == i + 1000) {
                    this.f7234o[i2] = -1;
                    z = true;
                }
                if (this.f7234o[i2] > i + 1000) {
                    this.f7234o[i2] = r0[i2] - 1;
                    z = true;
                }
            }
            boolean z2 = false;
            for (int i3 = 0; i3 < 3; i3++) {
                if (this.f7234o[i3] == -1) {
                    z2 = true;
                }
                if (z2) {
                    this.f7234o[i3] = this.f7234o[i3 + 1];
                }
            }
            if (z2) {
                this.f7234o[3] = -1;
            }
            if (z) {
                this.f7233n.edit().putInt("AMS_STAMP_PREF_00", this.f7234o[0]).commit();
                this.f7233n.edit().putInt("AMS_STAMP_PREF_01", this.f7234o[1]).commit();
                this.f7233n.edit().putInt("AMS_STAMP_PREF_02", this.f7234o[2]).commit();
                this.f7233n.edit().putInt("AMS_STAMP_PREF_03", this.f7234o[3]).commit();
            }
            if (this.f7234o[0] == -1) {
                this.f7235p.setVisibility(8);
                ((ImageView) findViewById(R.id.stamp_line)).setVisibility(8);
            } else {
                this.f7236q.m7170a();
            }
        }
        if (this.f7239t.m6405c() == 0) {
            this.f7242w = true;
            m7126a(true);
            m7134b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m7154m() {
        Intent intent = new Intent();
        intent.putExtra("AMS_STAMP_INDEX", m7149k());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m7156n() {
        this.f7242w = !this.f7242w;
        if (this.f7242w) {
            m7126a(true);
        } else {
            m7126a(false);
            if (this.f7237r != null) {
                this.f7238s = null;
                this.f7238s = new C2035cd(this);
                this.f7237r.setAdapter((ListAdapter) this.f7238s);
                if (f7231l) {
                    this.f7237r.setSelection(0);
                } else {
                    this.f7237r.setSelection(this.f7239t.m6402b());
                }
            }
        }
        m7152l();
    }

    /* renamed from: a */
    private Bitmap m7122a(Intent intent, Bundle bundle) {
        Bitmap bitmapDecodeFile;
        if (bundle.getBoolean("exceed_size", true)) {
            C1786r.m6061b("[getBitmapFromExtras] exceed_size is true!", getClass().getSimpleName());
            String string = bundle.getString("temp_file_path");
            if (string == null) {
                return null;
            }
            C1786r.m6061b("tmpFilePath : " + string, getClass().getSimpleName());
            bitmapDecodeFile = BitmapFactory.decodeFile(string);
            if (bitmapDecodeFile == null) {
                return null;
            }
            File file = new File(string);
            if (file.exists()) {
                file.delete();
            }
        } else {
            C1786r.m6061b("[getBitmapFromExtras] exceed_size is false!", getClass().getSimpleName());
            bitmapDecodeFile = (Bitmap) bundle.getParcelable("data");
        }
        C1786r.m6061b("[getBitmapFromExtras] bmp width and height : " + bitmapDecodeFile.getWidth() + "," + bitmapDecodeFile.getHeight(), getClass().getSimpleName());
        return bitmapDecodeFile;
    }

    /* renamed from: a */
    private String m7124a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: o */
    private void m7157o() {
        this.f7243x = (GeneralHeaderView) findViewById(R.id.view_titlebar);
        this.f7243x.setText(R.string.ams_title_stamp);
        this.f7243x.setButtonImageResource(R.drawable.general_btn_icon_delete_xml);
        this.f7243x.setBackClickListener(new ViewOnClickListenerC2033cb(this));
        this.f7243x.setButtonClickListener(new ViewOnClickListenerC2034cc(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m7126a(boolean z) {
        if (this.f7243x != null) {
            if (z) {
                this.f7243x.setButtonImageResource(R.drawable.general_btn_icon_delete_xml);
            } else {
                this.f7243x.setButtonImageResource(R.drawable.general_btn_icon_complete_xml);
            }
        }
    }

    /* renamed from: b */
    private void m7134b(boolean z) {
        if (this.f7243x != null) {
            this.f7243x.setButtonEnabled(z);
        }
    }
}
