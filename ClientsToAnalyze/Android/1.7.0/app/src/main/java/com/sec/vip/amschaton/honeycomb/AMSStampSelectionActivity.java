package com.sec.vip.amschaton.honeycomb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.sec.chaton.R;
import com.sec.chaton.util.C1341p;
import com.sec.vip.amschaton.AMSActivity;
import com.sec.vip.amschaton.AMSImageEditorActivity;
import com.sec.vip.amschaton.C1561z;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/* loaded from: classes.dex */
public class AMSStampSelectionActivity extends AMSActivity {

    /* renamed from: a */
    public static boolean f5018a = true;

    /* renamed from: b */
    private int f5019b = 0;

    /* renamed from: c */
    private SharedPreferences f5020c = null;

    /* renamed from: n */
    private int[] f5021n = new int[4];

    /* renamed from: o */
    private GridView f5022o = null;

    /* renamed from: p */
    private C1453l f5023p = null;

    /* renamed from: q */
    private GridView f5024q = null;

    /* renamed from: r */
    private C1454m f5025r = null;

    /* renamed from: s */
    private C1561z f5026s = C1561z.m5654a();

    /* renamed from: t */
    private ArrayList f5027t = null;

    /* renamed from: u */
    private ArrayList f5028u = null;

    /* renamed from: v */
    private boolean f5029v = true;

    /* renamed from: w */
    private boolean f5030w = true;

    /* renamed from: x */
    private boolean f5031x = true;

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
        getActionBar().setDisplayHomeAsUpEnabled(true);
        this.f5020c = getSharedPreferences("AMSPref", 3);
        this.f5021n[0] = this.f5020c.getInt("AMS_STAMP_PREF_00", -1);
        this.f5021n[1] = this.f5020c.getInt("AMS_STAMP_PREF_01", -1);
        this.f5021n[2] = this.f5020c.getInt("AMS_STAMP_PREF_02", -1);
        this.f5021n[3] = this.f5020c.getInt("AMS_STAMP_PREF_03", -1);
        boolean z = false;
        for (int i2 = 0; i2 < 4; i2++) {
            if (z || this.f5021n[i2] == 208) {
                this.f5021n[i2] = -1;
                z = true;
            }
        }
        int iM5662b = this.f5026s.m5662b();
        if (iM5662b == 0) {
            C1341p.m4658b("basicStampSize = " + iM5662b + " !, Load stamp again!", getClass().getSimpleName());
            m4741d();
        }
        m5257h();
        m5259i();
        if (this.f5026s.m5665c() == 0) {
            m5240a(false);
        }
        m5245b(i);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        C1341p.m4660c("[onDestroy]", getClass().getName());
        if (this.f5027t != null) {
            int size = this.f5027t.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f5027t.get(i)).recycle();
            }
            this.f5027t.clear();
            this.f5027t = null;
        }
        if (this.f5028u != null) {
            int size2 = this.f5028u.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((Bitmap) this.f5028u.get(i2)).recycle();
            }
            this.f5028u.clear();
            this.f5028u = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Bitmap bitmapM5236a;
        if (i2 == -1) {
            switch (i) {
                case 0:
                    Bundle extras = intent.getExtras();
                    if (extras != null && (bitmapM5236a = m5236a(intent, extras)) != null) {
                        m5241a(bitmapM5236a, AMSActivity.f4625g + m5237a("[STP]", System.currentTimeMillis(), ".png"));
                        m4741d();
                        m5257h();
                        if (this.f5024q != null) {
                            this.f5025r = null;
                            this.f5025r = new C1454m(this);
                            this.f5024q.setAdapter((ListAdapter) this.f5025r);
                            if (f5018a) {
                                this.f5024q.setSelection(0);
                            } else {
                                this.f5024q.setSelection(this.f5026s.m5662b() + this.f5026s.m5665c());
                            }
                        }
                        m5266l();
                        bitmapM5236a.recycle();
                        break;
                    }
                    break;
            }
        }
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.ams_ics_option_menu_stamp, menu);
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            case R.id.menu_btn_delete /* 2131428260 */:
                this.f5029v = !this.f5029v;
                if (this.f5029v) {
                    m5249b(true);
                } else {
                    m5249b(false);
                    if (this.f5024q != null) {
                        this.f5025r = null;
                        this.f5025r = new C1454m(this);
                        this.f5024q.setAdapter((ListAdapter) this.f5025r);
                        if (f5018a) {
                            this.f5024q.setSelection(0);
                        } else {
                            this.f5024q.setSelection(this.f5026s.m5662b());
                        }
                    }
                }
                m5266l();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItemFindItem = menu.findItem(R.id.menu_btn_delete);
        if (menuItemFindItem != null) {
            if (this.f5031x) {
                menuItemFindItem.setIcon(R.drawable.ams_ics_selector_title_ic_delete);
                menuItemFindItem.setTitle(R.string.ams_btn_delete);
            } else {
                menuItemFindItem.setIcon(R.drawable.ams_ics_selector_title_ic_check);
                menuItemFindItem.setTitle(R.string.ams_btn_done);
            }
            menuItemFindItem.setEnabled(this.f5030w);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    /* renamed from: a */
    private void m5240a(boolean z) {
        this.f5030w = z;
        invalidateOptionsMenu();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m5249b(boolean z) {
        this.f5031x = z;
        invalidateOptionsMenu();
    }

    /* renamed from: a */
    private void m5238a() {
        for (int i = 0; i < this.f5026s.m5662b(); i++) {
            this.f5027t.add(this.f5026s.m5657a(this.f5026s.m5663b(i), false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m5257h() {
        if (this.f5027t == null) {
            this.f5027t = new ArrayList();
            m5238a();
        } else if (this.f5027t.size() == 0) {
            m5238a();
        }
        if (this.f5028u != null) {
            int size = this.f5028u.size();
            for (int i = 0; i < size; i++) {
                ((Bitmap) this.f5028u.get(i)).recycle();
            }
            this.f5028u.clear();
            this.f5028u = null;
        }
        this.f5028u = new ArrayList();
        int iM5665c = this.f5026s.m5665c();
        for (int i2 = 0; i2 < iM5665c; i2++) {
            this.f5028u.add(this.f5026s.m5664b(i2, false));
        }
    }

    /* renamed from: i */
    private void m5259i() {
        if (this.f5021n[0] != -1) {
            this.f5022o = (GridView) findViewById(R.id.gridview_preference);
            this.f5023p = new C1453l(this);
            this.f5022o.setAdapter((ListAdapter) this.f5023p);
            this.f5022o.setSelector(R.drawable.ams_ics_selector_basic_dummy);
            this.f5022o.setOnItemClickListener(new C1411ag(this));
            ((ImageView) findViewById(R.id.stamp_line)).setVisibility(0);
        }
        this.f5024q = (GridView) findViewById(R.id.gridview_stamp);
        this.f5025r = new C1454m(this);
        this.f5024q.setAdapter((ListAdapter) this.f5025r);
        this.f5024q.setSelector(R.drawable.ams_ics_selector_basic_dummy);
        this.f5024q.setOnScrollListener(new C1412ah(this));
        this.f5024q.setOnItemClickListener(new C1413ai(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m5262j() {
        Intent intent = new Intent(this, (Class<?>) AMSImageEditorActivity.class);
        intent.putExtra("IMAGE_SELECTOR", 1002);
        startActivityForResult(intent, 0);
    }

    /* renamed from: b */
    private void m5245b(int i) {
        int iM5665c;
        int iM5665c2 = 0;
        if (i < 1000) {
            int iM5668d = this.f5026s.m5668d(i);
            if (this.f5024q != null) {
                if (iM5668d == -1) {
                    this.f5019b = 0;
                } else {
                    this.f5019b = iM5668d;
                    if (this.f5019b < this.f5026s.m5662b()) {
                        if (f5018a) {
                            iM5665c2 = this.f5019b + this.f5026s.m5665c();
                        } else {
                            iM5665c2 = this.f5019b;
                        }
                    }
                }
                this.f5024q.setSelection(iM5665c2);
            }
        } else {
            this.f5019b = (this.f5026s.m5662b() + i) - 1000;
            if (this.f5024q != null) {
                if (f5018a) {
                    iM5665c = (this.f5026s.m5665c() - 1) - (this.f5019b - this.f5026s.m5662b());
                } else {
                    iM5665c = this.f5019b;
                }
                this.f5024q.setSelection(iM5665c);
            }
        }
        m5266l();
    }

    /* renamed from: k */
    private int m5263k() {
        if (this.f5019b >= this.f5026s.m5662b()) {
            return (this.f5019b - this.f5026s.m5662b()) + 1000;
        }
        int iM5663b = this.f5026s.m5663b(this.f5019b);
        if (iM5663b == -1) {
            return 0;
        }
        return iM5663b;
    }

    /* renamed from: a */
    private boolean m5241a(Bitmap bitmap, String str) {
        return m5250b(bitmap, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m5266l() {
        if (this.f5025r != null) {
            this.f5025r.m5282a();
        }
        if (this.f5023p != null) {
            this.f5023p.m5281a();
        }
        if (this.f5026s.m5665c() > 0 || !this.f5029v) {
            m5240a(true);
        } else {
            m5240a(false);
        }
    }

    /* renamed from: a */
    private void m5239a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: b */
    private void m5248b(FileOutputStream fileOutputStream) throws IOException {
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
    private boolean m5250b(android.graphics.Bitmap r7, java.lang.String r8) throws java.lang.Throwable {
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
            r6.m5239a(r3)
            r6.m5248b(r3)
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
            r6.m5239a(r3)
            r6.m5248b(r3)
            r2 = r0
            goto L45
        L91:
            r0 = move-exception
            r3 = r4
        L93:
            r6.m5239a(r3)
            r6.m5248b(r3)
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
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.honeycomb.AMSStampSelectionActivity.m5250b(android.graphics.Bitmap, java.lang.String):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m5251c(int i) {
        if (this.f5021n[0] != -1) {
            boolean z = false;
            for (int i2 = 0; i2 < 4; i2++) {
                if (this.f5021n[i2] == i + 1000) {
                    this.f5021n[i2] = -1;
                    z = true;
                }
                if (this.f5021n[i2] > i + 1000) {
                    this.f5021n[i2] = r0[i2] - 1;
                    z = true;
                }
            }
            boolean z2 = false;
            for (int i3 = 0; i3 < 3; i3++) {
                if (this.f5021n[i3] == -1) {
                    z2 = true;
                }
                if (z2) {
                    this.f5021n[i3] = this.f5021n[i3 + 1];
                }
            }
            if (z2) {
                this.f5021n[3] = -1;
            }
            if (z) {
                this.f5020c.edit().putInt("AMS_STAMP_PREF_00", this.f5021n[0]).commit();
                this.f5020c.edit().putInt("AMS_STAMP_PREF_01", this.f5021n[1]).commit();
                this.f5020c.edit().putInt("AMS_STAMP_PREF_02", this.f5021n[2]).commit();
                this.f5020c.edit().putInt("AMS_STAMP_PREF_03", this.f5021n[3]).commit();
            }
            if (this.f5021n[0] == -1) {
                this.f5022o.setVisibility(8);
                ((ImageView) findViewById(R.id.stamp_line)).setVisibility(8);
            } else {
                this.f5023p.m5281a();
            }
        }
        if (this.f5026s.m5665c() == 0) {
            this.f5029v = true;
            m5249b(true);
            m5240a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m5267m() {
        Intent intent = new Intent();
        intent.putExtra("AMS_STAMP_INDEX", m5263k());
        setResult(-1, intent);
        finish();
    }

    /* renamed from: a */
    private Bitmap m5236a(Intent intent, Bundle bundle) {
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
    private String m5237a(String str, long j, String str2) {
        return str + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date(j)) + str2;
    }
}
