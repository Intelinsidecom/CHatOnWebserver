package com.sec.vip.amschaton.honeycomb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1786r;
import com.sec.vip.amschaton.AMSActionBarView;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSImageEditorActivity;
import com.sec.vip.amschaton.C1849ai;
import com.sec.widget.AlertDialogBuilderC2120a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSStampSelectionActivity extends AMSActivity {

    /* renamed from: l */
    public static boolean f7004l = true;

    /* renamed from: n */
    private int f7006n = 0;

    /* renamed from: o */
    private SharedPreferences f7007o = null;

    /* renamed from: p */
    private int[] f7008p = new int[4];

    /* renamed from: q */
    private GridView f7009q = null;

    /* renamed from: r */
    private C1952cf f7010r = null;

    /* renamed from: s */
    private GridView f7011s = null;

    /* renamed from: t */
    private C1951ce f7012t = null;

    /* renamed from: u */
    private C1849ai f7013u = C1849ai.m6394a();

    /* renamed from: v */
    private ArrayList f7014v = null;

    /* renamed from: w */
    private ArrayList f7015w = null;

    /* renamed from: x */
    private boolean f7016x = true;

    /* renamed from: m */
    AMSActionBarView f7005m = null;

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
        m6842o();
        this.f7007o = getSharedPreferences("AMSPref", 3);
        this.f7008p[0] = this.f7007o.getInt("AMS_STAMP_PREF_00", -1);
        this.f7008p[1] = this.f7007o.getInt("AMS_STAMP_PREF_01", -1);
        this.f7008p[2] = this.f7007o.getInt("AMS_STAMP_PREF_02", -1);
        this.f7008p[3] = this.f7007o.getInt("AMS_STAMP_PREF_03", -1);
        boolean z = false;
        for (int i2 = 0; i2 < 4; i2++) {
            if (z || this.f7008p[i2] == 208) {
                this.f7008p[i2] = -1;
                z = true;
            }
        }
        m6264c();
        m6828h();
        m6830i();
        if (this.f7013u.m6405c() == 0) {
            m6808a(false);
        }
        m6819c(i);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1786r.m6063c("[onDestroy]", getClass().getName());
        if (this.f7014v != null) {
            int size = this.f7014v.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f7014v.get(i)).recycle();
            }
            this.f7014v.clear();
            this.f7014v = null;
        }
        if (this.f7015w != null) {
            int size2 = this.f7015w.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((Bitmap) this.f7015w.get(i2)).recycle();
            }
            this.f7015w.clear();
            this.f7015w = null;
        }
        super.onDestroy();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
    }

    @Override // com.sec.vip.amschaton.AMSActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Bitmap bitmapM6804a;
        if (i2 == -1) {
            switch (i) {
                case 0:
                    Bundle extras = intent.getExtras();
                    if (extras != null && (bitmapM6804a = m6804a(intent, extras)) != null) {
                        m6809a(bitmapM6804a, AMSActivity.f6612e + m6806a("[STP]", System.currentTimeMillis(), ".png"));
                        m6264c();
                        m6828h();
                        if (this.f7011s != null) {
                            this.f7012t = null;
                            this.f7012t = new C1951ce(this);
                            this.f7011s.setAdapter((ListAdapter) this.f7012t);
                            if (f7004l) {
                                this.f7011s.setSelection(0);
                            } else {
                                this.f7011s.setSelection(this.f7013u.m6402b() + this.f7013u.m6405c());
                            }
                        }
                        m6837l();
                        bitmapM6804a.recycle();
                        break;
                    }
                    break;
            }
        }
    }

    /* renamed from: a */
    private void m6808a(boolean z) {
        if (this.f7005m != null) {
            this.f7005m.m6248a(5000, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6817b(boolean z) {
        if (this.f7005m != null) {
            if (z) {
                this.f7005m.m6245a(5000, R.drawable.ams_ics_selector_title_ic_delete);
                this.f7005m.m6250b(5000, R.string.ams_btn_delete);
            } else {
                this.f7005m.m6245a(5000, R.drawable.ams_ics_selector_title_ic_check);
                this.f7005m.m6250b(5000, R.string.ams_btn_done);
            }
        }
    }

    /* renamed from: g */
    private void m6826g() {
        for (int i = 0; i < this.f7013u.m6402b(); i++) {
            this.f7014v.add(this.f7013u.m6397a(this.f7013u.m6403b(i), false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m6828h() {
        if (this.f7014v == null) {
            this.f7014v = new ArrayList();
            m6826g();
        } else if (this.f7014v.size() == 0) {
            m6826g();
        }
        if (this.f7015w != null) {
            int size = this.f7015w.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f7015w.get(i)).recycle();
            }
            this.f7015w.clear();
            this.f7015w = null;
        }
        this.f7015w = new ArrayList();
        int iM6405c = this.f7013u.m6405c();
        for (int i2 = 0; i2 < iM6405c; i2++) {
            this.f7015w.add(this.f7013u.m6404b(i2, false));
        }
    }

    /* renamed from: i */
    private void m6830i() {
        if (this.f7008p[0] != -1) {
            this.f7009q = (GridView) findViewById(R.id.gridview_preference);
            this.f7010r = new C1952cf(this);
            this.f7009q.setAdapter((ListAdapter) this.f7010r);
            this.f7009q.setSelector(R.drawable.ams_ics_selector_basic_dummy);
            this.f7009q.setOnItemClickListener(new C1944by(this));
        }
        this.f7011s = (GridView) findViewById(R.id.gridview_stamp);
        this.f7012t = new C1951ce(this);
        this.f7011s.setAdapter((ListAdapter) this.f7012t);
        this.f7011s.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        this.f7011s.setOnScrollListener(new C1945bz(this));
        this.f7011s.setOnItemClickListener(new C1947ca(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m6833j() {
        new AlertDialogBuilderC2120a(this).setTitle(R.string.ams_title_stamp).setItems(R.array.ams_strarr_add_stamp, new DialogInterfaceOnClickListenerC1949cc(this)).setNegativeButton(R.string.ams_btn_cancel, new DialogInterfaceOnClickListenerC1948cb(this)).create().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m6813b(int i) {
        Intent intent = new Intent(this, (Class<?>) AMSImageEditorActivity.class);
        intent.putExtra("IMAGE_SELECTOR", i);
        startActivityForResult(intent, 0);
    }

    /* renamed from: c */
    private void m6819c(int i) {
        int iM6405c;
        int iM6405c2 = 0;
        if (i < 1000) {
            int iM6408d = this.f7013u.m6408d(i);
            if (this.f7011s != null) {
                if (iM6408d == -1) {
                    this.f7006n = 0;
                } else {
                    this.f7006n = iM6408d;
                    if (this.f7006n < this.f7013u.m6402b()) {
                        if (f7004l) {
                            iM6405c2 = this.f7006n + this.f7013u.m6405c();
                        } else {
                            iM6405c2 = this.f7006n;
                        }
                    }
                }
                this.f7011s.setSelection(iM6405c2);
            }
        } else {
            this.f7006n = (this.f7013u.m6402b() + i) - 1000;
            if (this.f7011s != null) {
                if (f7004l) {
                    iM6405c = (this.f7013u.m6405c() - 1) - (this.f7006n - this.f7013u.m6402b());
                } else {
                    iM6405c = this.f7006n;
                }
                this.f7011s.setSelection(iM6405c);
            }
        }
        m6837l();
    }

    /* renamed from: k */
    private int m6834k() {
        if (this.f7006n >= this.f7013u.m6402b()) {
            return (this.f7006n - this.f7013u.m6402b()) + 1000;
        }
        int iM6403b = this.f7013u.m6403b(this.f7006n);
        if (iM6403b == -1) {
            return 0;
        }
        return iM6403b;
    }

    /* renamed from: a */
    private boolean m6809a(Bitmap bitmap, String str) {
        return m6818b(bitmap, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m6837l() {
        if (this.f7012t != null) {
            this.f7012t.m6856a();
        }
        if (this.f7010r != null) {
            this.f7010r.m6857a();
        }
        if (this.f7013u.m6405c() > 0 || !this.f7016x) {
            m6808a(true);
        } else {
            m6808a(false);
        }
    }

    /* renamed from: a */
    private void m6807a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m6816b(FileOutputStream fileOutputStream) throws IOException {
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
    /* JADX WARN: Type inference failed for: r6v0, types: [com.sec.vip.amschaton.honeycomb.AMSStampSelectionActivity, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.graphics.Bitmap] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m6818b(android.graphics.Bitmap r7, java.lang.String r8) throws java.lang.Throwable {
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
            r6.m6807a(r3)
            r6.m6816b(r3)
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
            r6.m6807a(r3)
            r6.m6816b(r3)
            r2 = r0
            goto L45
        L91:
            r0 = move-exception
            r3 = r4
        L93:
            r6.m6807a(r3)
            r6.m6816b(r3)
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.honeycomb.AMSStampSelectionActivity.m6818b(android.graphics.Bitmap, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m6822d(int i) {
        if (this.f7008p[0] != -1) {
            boolean z = false;
            for (int i2 = 0; i2 < 4; i2++) {
                if (this.f7008p[i2] == i + 1000) {
                    this.f7008p[i2] = -1;
                    z = true;
                }
                if (this.f7008p[i2] > i + 1000) {
                    this.f7008p[i2] = r0[i2] - 1;
                    z = true;
                }
            }
            boolean z2 = false;
            for (int i3 = 0; i3 < 3; i3++) {
                if (this.f7008p[i3] == -1) {
                    z2 = true;
                }
                if (z2) {
                    this.f7008p[i3] = this.f7008p[i3 + 1];
                }
            }
            if (z2) {
                this.f7008p[3] = -1;
            }
            if (z) {
                this.f7007o.edit().putInt("AMS_STAMP_PREF_00", this.f7008p[0]).commit();
                this.f7007o.edit().putInt("AMS_STAMP_PREF_01", this.f7008p[1]).commit();
                this.f7007o.edit().putInt("AMS_STAMP_PREF_02", this.f7008p[2]).commit();
                this.f7007o.edit().putInt("AMS_STAMP_PREF_03", this.f7008p[3]).commit();
            }
            if (this.f7008p[0] == -1) {
                this.f7009q.setVisibility(8);
            } else {
                this.f7010r.m6857a();
            }
        }
        if (this.f7013u.m6405c() == 0) {
            this.f7016x = true;
            m6817b(true);
            m6808a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m6839m() {
        Intent intent = new Intent();
        intent.putExtra("AMS_STAMP_INDEX", m6834k());
        setResult(-1, intent);
        finish();
    }

    /* renamed from: a */
    private Bitmap m6804a(Intent intent, Bundle bundle) {
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
    private String m6806a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }

    /* renamed from: n */
    private void m6841n() {
        this.f7005m = (AMSActionBarView) findViewById(R.id.actionbar);
    }

    /* renamed from: o */
    private void m6842o() {
        m6841n();
        this.f7005m.setTitleText(R.string.ams_app_name);
        this.f7005m.m6244a();
        this.f7005m.m6246a(R.drawable.ams_ics_selector_title_ic_delete, R.string.ams_btn_delete, new ViewOnClickListenerC1950cd(this), 5000);
        this.f7005m.setMoreOptionIconVisibility(false);
        this.f7005m.setActionButtonLayoutVisibility(true);
    }
}
