package com.sec.vip.amschaton.ics;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSImageEditorActivity;
import com.sec.vip.amschaton.C1561z;
import com.sec.widget.GeneralHeaderView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSStampSelectionActivity extends AMSActivity {

    /* renamed from: a */
    public static boolean f5263a = true;

    /* renamed from: b */
    private int f5264b = 0;

    /* renamed from: c */
    private SharedPreferences f5265c = null;

    /* renamed from: n */
    private int[] f5266n = new int[4];

    /* renamed from: o */
    private GridView f5267o = null;

    /* renamed from: p */
    private C1510bn f5268p = null;

    /* renamed from: q */
    private GridView f5269q = null;

    /* renamed from: r */
    private C1480ak f5270r = null;

    /* renamed from: s */
    private C1561z f5271s = C1561z.m5654a();

    /* renamed from: t */
    private ArrayList f5272t = null;

    /* renamed from: u */
    private ArrayList f5273u = null;

    /* renamed from: v */
    private boolean f5274v = true;

    /* renamed from: w */
    private GeneralHeaderView f5275w = null;

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        int i;
        C1341p.m4660c("[onCreate]", getClass().getName());
        super.onCreate(bundle);
        setContentView(R.layout.ams_ics_layout_stamp);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            i = extras.getInt("AMS_STAMP_INDEX", 0);
        } else {
            C1341p.m4658b("[onCreate] bundle is NULL!", getClass().getSimpleName());
            i = 0;
        }
        this.f5265c = getSharedPreferences("AMSPref", 3);
        this.f5266n[0] = this.f5265c.getInt("AMS_STAMP_PREF_00", -1);
        this.f5266n[1] = this.f5265c.getInt("AMS_STAMP_PREF_01", -1);
        this.f5266n[2] = this.f5265c.getInt("AMS_STAMP_PREF_02", -1);
        this.f5266n[3] = this.f5265c.getInt("AMS_STAMP_PREF_03", -1);
        boolean z = false;
        for (int i2 = 0; i2 < 4; i2++) {
            if (z || this.f5266n[i2] == 208) {
                this.f5266n[i2] = -1;
                z = true;
            }
        }
        int iM5662b = this.f5271s.m5662b();
        if (iM5662b == 0) {
            C1341p.m4658b("basicStampSize = " + iM5662b + " !, Load stamp again!", getClass().getSimpleName());
            m4741d();
        }
        m5600o();
        m5586h();
        m5588i();
        if (this.f5271s.m5665c() == 0) {
            m5578b(false);
        }
        m5574b(i);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getName());
        if (this.f5272t != null) {
            int size = this.f5272t.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f5272t.get(i)).recycle();
            }
            this.f5272t.clear();
            this.f5272t = null;
        }
        if (this.f5273u != null) {
            int size2 = this.f5273u.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((Bitmap) this.f5273u.get(i2)).recycle();
            }
            this.f5273u.clear();
            this.f5273u = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Bitmap bitmapM5565a;
        if (i2 == -1) {
            switch (i) {
                case 0:
                    Bundle extras = intent.getExtras();
                    if (extras != null && (bitmapM5565a = m5565a(intent, extras)) != null) {
                        m5571a(bitmapM5565a, AMSActivity.f4625g + m5567a("[STP]", System.currentTimeMillis(), ".png"));
                        m4741d();
                        m5586h();
                        if (this.f5269q != null) {
                            this.f5270r = null;
                            this.f5270r = new C1480ak(this);
                            this.f5269q.setAdapter((ListAdapter) this.f5270r);
                            new Handler().postDelayed(new RunnableC1538t(this), 300L);
                        }
                        m5595l();
                        bitmapM5565a.recycle();
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m5568a() {
        for (int i = 0; i < this.f5271s.m5662b(); i++) {
            this.f5272t.add(this.f5271s.m5657a(this.f5271s.m5663b(i), false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5586h() {
        if (this.f5272t == null) {
            this.f5272t = new ArrayList();
            m5568a();
        } else if (this.f5272t.size() == 0) {
            m5568a();
        }
        if (this.f5273u != null) {
            int size = this.f5273u.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f5273u.get(i)).recycle();
            }
            this.f5273u.clear();
            this.f5273u = null;
        }
        this.f5273u = new ArrayList();
        int iM5665c = this.f5271s.m5665c();
        for (int i2 = 0; i2 < iM5665c; i2++) {
            this.f5273u.add(this.f5271s.m5664b(i2, false));
        }
    }

    /* renamed from: i */
    private void m5588i() {
        if (this.f5266n[0] != -1) {
            this.f5267o = (GridView) findViewById(R.id.gridview_preference);
            this.f5268p = new C1510bn(this);
            this.f5267o.setAdapter((ListAdapter) this.f5268p);
            this.f5267o.setSelector(R.drawable.ams_ics_selector_basic_dummy);
            this.f5267o.setOnItemClickListener(new C1542x(this));
        }
        this.f5269q = (GridView) findViewById(R.id.gridview_stamp);
        this.f5270r = new C1480ak(this);
        this.f5269q.setAdapter((ListAdapter) this.f5270r);
        this.f5269q.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        this.f5269q.setOnScrollListener(new C1543y(this));
        this.f5269q.setOnItemClickListener(new C1540v(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m5590j() {
        Intent intent = new Intent(this, (Class<?>) AMSImageEditorActivity.class);
        intent.putExtra("IMAGE_SELECTOR", 1002);
        startActivityForResult(intent, 0);
    }

    /* renamed from: b */
    private void m5574b(int i) {
        int iM5665c;
        int iM5665c2 = 0;
        if (i < 1000) {
            int iM5668d = this.f5271s.m5668d(i);
            if (this.f5269q != null) {
                if (iM5668d == -1) {
                    this.f5264b = 0;
                } else {
                    this.f5264b = iM5668d;
                    if (this.f5264b < this.f5271s.m5662b()) {
                        if (f5263a) {
                            iM5665c2 = this.f5264b + this.f5271s.m5665c();
                        } else {
                            iM5665c2 = this.f5264b;
                        }
                    }
                }
                this.f5269q.setSelection(iM5665c2);
            }
        } else {
            this.f5264b = (this.f5271s.m5662b() + i) - 1000;
            if (this.f5269q != null) {
                if (f5263a) {
                    iM5665c = (this.f5271s.m5665c() - 1) - (this.f5264b - this.f5271s.m5662b());
                } else {
                    iM5665c = this.f5264b;
                }
                this.f5269q.setSelection(iM5665c);
            }
        }
        m5595l();
    }

    /* renamed from: k */
    private int m5592k() {
        if (this.f5264b >= this.f5271s.m5662b()) {
            return (this.f5264b - this.f5271s.m5662b()) + 1000;
        }
        int iM5663b = this.f5271s.m5663b(this.f5264b);
        if (iM5663b == -1) {
            return 0;
        }
        return iM5663b;
    }

    /* renamed from: a */
    private boolean m5571a(Bitmap bitmap, String str) {
        return m5579b(bitmap, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5595l() {
        if (this.f5270r != null) {
            this.f5270r.m5601a();
        }
        if (this.f5268p != null) {
            this.f5268p.m5613a();
        }
        if (this.f5271s.m5665c() > 0 || !this.f5274v) {
            m5578b(true);
        } else {
            m5578b(false);
        }
    }

    /* renamed from: a */
    private void m5569a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m5577b(FileOutputStream fileOutputStream) throws IOException {
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
    private boolean m5579b(android.graphics.Bitmap r7, java.lang.String r8) throws java.lang.Throwable {
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
            com.sec.chaton.util.C1341p.m4651a(r1, r2)
        L1b:
            return r0
        L1c:
            if (r7 != 0) goto L2c
            java.lang.String r1 = "[saveBitmapToPNG] Bitmap is null!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1341p.m4651a(r1, r2)
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
            r6.m5569a(r3)
            r6.m5577b(r3)
            r2 = r1
        L45:
            if (r2 != 0) goto L9a
            java.lang.String r1 = "[saveBitmapToPNG] Fail to save file!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1341p.m4651a(r1, r2)
            goto L1b
        L55:
            r2 = move-exception
            r3 = r4
        L57:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = "[resizedJpegCopy] IO Exception!"
            java.lang.Class r4 = r6.getClass()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> Lb2
            com.sec.chaton.util.C1341p.m4651a(r2, r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r2.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = "[resizedJpegCopy] Out File: "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class r4 = r6.getClass()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r4 = r4.getSimpleName()     // Catch: java.lang.Throwable -> Lb2
            com.sec.chaton.util.C1341p.m4651a(r2, r4)     // Catch: java.lang.Throwable -> Lb2
            r6.m5569a(r3)
            r6.m5577b(r3)
            r2 = r0
            goto L45
        L91:
            r0 = move-exception
            r3 = r4
        L93:
            r6.m5569a(r3)
            r6.m5577b(r3)
            throw r0
        L9a:
            boolean r2 = r5.exists()
            if (r2 != 0) goto Laf
            java.lang.String r1 = "[saveBitmapToPNG] File does not exist!"
            java.lang.Class r2 = r6.getClass()
            java.lang.String r2 = r2.getSimpleName()
            com.sec.chaton.util.C1341p.m4651a(r1, r2)
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.ics.AMSStampSelectionActivity.m5579b(android.graphics.Bitmap, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5580c(int i) {
        if (this.f5266n[0] != -1) {
            boolean z = false;
            for (int i2 = 0; i2 < 4; i2++) {
                if (this.f5266n[i2] == i + 1000) {
                    this.f5266n[i2] = -1;
                    z = true;
                }
                if (this.f5266n[i2] > i + 1000) {
                    this.f5266n[i2] = r0[i2] - 1;
                    z = true;
                }
            }
            boolean z2 = false;
            for (int i3 = 0; i3 < 3; i3++) {
                if (this.f5266n[i3] == -1) {
                    z2 = true;
                }
                if (z2) {
                    this.f5266n[i3] = this.f5266n[i3 + 1];
                }
            }
            if (z2) {
                this.f5266n[3] = -1;
            }
            if (z) {
                this.f5265c.edit().putInt("AMS_STAMP_PREF_00", this.f5266n[0]).commit();
                this.f5265c.edit().putInt("AMS_STAMP_PREF_01", this.f5266n[1]).commit();
                this.f5265c.edit().putInt("AMS_STAMP_PREF_02", this.f5266n[2]).commit();
                this.f5265c.edit().putInt("AMS_STAMP_PREF_03", this.f5266n[3]).commit();
            }
            if (this.f5266n[0] == -1) {
                this.f5267o.setVisibility(8);
            } else {
                this.f5268p.m5613a();
            }
        }
        if (this.f5271s.m5665c() == 0) {
            this.f5274v = true;
            m5570a(true);
            m5578b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m5597m() {
        Intent intent = new Intent();
        intent.putExtra("AMS_STAMP_INDEX", m5592k());
        setResult(-1, intent);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m5599n() {
        this.f5274v = !this.f5274v;
        if (this.f5274v) {
            m5570a(true);
        } else {
            m5570a(false);
            if (this.f5269q != null) {
                this.f5270r = null;
                this.f5270r = new C1480ak(this);
                this.f5269q.setAdapter((ListAdapter) this.f5270r);
                if (f5263a) {
                    this.f5269q.setSelection(0);
                } else {
                    this.f5269q.setSelection(this.f5271s.m5662b());
                }
            }
        }
        m5595l();
    }

    /* renamed from: a */
    private Bitmap m5565a(Intent intent, Bundle bundle) {
        Bitmap bitmapDecodeFile;
        if (bundle.getBoolean("exceed_size", true)) {
            C1341p.m4658b("[getBitmapFromExtras] exceed_size is true!", getClass().getSimpleName());
            String string = bundle.getString("temp_file_path");
            if (string == null) {
                return null;
            }
            C1341p.m4658b("tmpFilePath : " + string, getClass().getSimpleName());
            bitmapDecodeFile = BitmapFactory.decodeFile(string);
            if (bitmapDecodeFile == null) {
                return null;
            }
            File file = new File(string);
            if (file.exists()) {
                file.delete();
            }
        } else {
            C1341p.m4658b("[getBitmapFromExtras] exceed_size is false!", getClass().getSimpleName());
            bitmapDecodeFile = (Bitmap) bundle.getParcelable("data");
        }
        C1341p.m4658b("[getBitmapFromExtras] bmp width and height : " + bitmapDecodeFile.getWidth() + "," + bitmapDecodeFile.getHeight(), getClass().getSimpleName());
        return bitmapDecodeFile;
    }

    /* renamed from: a */
    private String m5567a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: o */
    private void m5600o() {
        this.f5275w = (GeneralHeaderView) findViewById(R.id.view_titlebar);
        this.f5275w.setText(R.string.ams_title_stamp);
        this.f5275w.setButtonImageResource(R.drawable.general_btn_icon_delete_xml);
        this.f5275w.setBackClickListener(new ViewOnClickListenerC1541w(this));
        this.f5275w.setButtonClickListener(new ViewOnClickListenerC1539u(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m5570a(boolean z) {
        if (this.f5275w != null) {
            if (z) {
                this.f5275w.setButtonImageResource(R.drawable.general_btn_icon_delete_xml);
            } else {
                this.f5275w.setButtonImageResource(R.drawable.general_btn_icon_complete_xml);
            }
        }
    }

    /* renamed from: b */
    private void m5578b(boolean z) {
        if (this.f5275w != null) {
            this.f5275w.setButtonEnabled(z);
        }
    }
}
