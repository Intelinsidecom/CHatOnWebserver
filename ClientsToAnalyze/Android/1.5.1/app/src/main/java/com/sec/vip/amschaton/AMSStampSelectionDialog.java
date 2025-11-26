package com.sec.vip.amschaton;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.sec.chaton.C0062R;
import com.sec.pns.msg.MsgResultCode;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class AMSStampSelectionDialog extends AMSToolSelectionDialog {

    /* renamed from: f */
    private int f4050f;

    /* renamed from: g */
    private SharedPreferences f4051g;

    /* renamed from: h */
    private int[] f4052h;

    /* renamed from: i */
    private GridView f4053i;

    /* renamed from: j */
    private PreferenceStampGridAdapter f4054j;

    /* renamed from: k */
    private GridView f4055k;

    /* renamed from: l */
    private BasicStampGridAdapter f4056l;

    /* renamed from: m */
    private AMSStampManager f4057m;

    /* renamed from: n */
    private Button f4058n;

    /* renamed from: o */
    private Button f4059o;

    /* renamed from: p */
    private boolean f4060p;

    /* renamed from: q */
    private InterfaceC0702e f4061q;

    public class BasicStampGridAdapter extends BaseAdapter {

        /* renamed from: b */
        private AMSStampManager f4063b;

        public BasicStampGridAdapter() {
            this.f4063b = AMSStampSelectionDialog.this.f4057m;
        }

        /* renamed from: a */
        public void m4087a() {
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f4063b == null) {
                return 0;
            }
            return this.f4063b.m4063b() + this.f4063b.m4065c() + 1;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            Bitmap bitmapM4064b;
            View viewInflate = view == null ? AMSStampSelectionDialog.this.getLayoutInflater().inflate(C0062R.layout.ams_stamp_item, viewGroup, false) : view;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C0062R.id.layout_basic_stamp);
            linearLayout.setBackgroundResource(C0062R.drawable.ams_grid_selector_stamp);
            LinearLayout linearLayout2 = (LinearLayout) viewInflate.findViewById(C0062R.id.layout_remove_stamp);
            linearLayout2.setVisibility(4);
            if (i >= 0 && i < this.f4063b.m4063b() + this.f4063b.m4065c()) {
                if (i < this.f4063b.m4063b()) {
                    bitmapM4064b = this.f4063b.m4058a(i);
                } else {
                    bitmapM4064b = this.f4063b.m4064b(i - this.f4063b.m4063b());
                    if (!AMSStampSelectionDialog.this.f4060p) {
                        linearLayout2.setVisibility(0);
                    }
                }
                if (bitmapM4064b != null) {
                    ((ImageView) viewInflate.findViewById(C0062R.id.image_basic_stamp)).setImageBitmap(bitmapM4064b);
                }
                if (AMSStampSelectionDialog.this.f4050f == i) {
                    linearLayout.setSelected(true);
                } else {
                    linearLayout.setSelected(false);
                }
            } else if (i == this.f4063b.m4063b() + this.f4063b.m4065c()) {
                ((ImageView) viewInflate.findViewById(C0062R.id.image_basic_stamp)).setImageResource(C0062R.drawable.ams_add_stamp_selector);
            }
            return viewInflate;
        }
    }

    public class PreferenceStampGridAdapter extends BaseAdapter {

        /* renamed from: b */
        private AMSStampManager f4065b;

        public PreferenceStampGridAdapter() {
            this.f4065b = AMSStampSelectionDialog.this.f4057m;
        }

        /* renamed from: a */
        public void m4088a() {
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f4065b == null) {
                return 0;
            }
            int i = 5;
            while (i > 0 && AMSStampSelectionDialog.this.f4052h[i - 1] == -1) {
                i--;
            }
            return i;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return 0L;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            View viewInflate = view == null ? AMSStampSelectionDialog.this.getLayoutInflater().inflate(C0062R.layout.ams_stamp_item, viewGroup, false) : view;
            ((LinearLayout) viewInflate.findViewById(C0062R.id.layout_basic_stamp)).setBackgroundResource(C0062R.drawable.ams_grid_selector_stamp);
            int i2 = AMSStampSelectionDialog.this.f4052h[i];
            Bitmap bitmapM4058a = i2 < this.f4065b.m4063b() ? this.f4065b.m4058a(i2) : this.f4065b.m4064b(i2 - MsgResultCode.SUCCESS);
            if (bitmapM4058a != null) {
                ((ImageView) viewInflate.findViewById(C0062R.id.image_basic_stamp)).setImageBitmap(bitmapM4058a);
            }
            return viewInflate;
        }
    }

    public AMSStampSelectionDialog(Context context, int i) {
        super(context, i);
        this.f4050f = 0;
        this.f4051g = null;
        this.f4052h = new int[5];
        this.f4053i = null;
        this.f4054j = null;
        this.f4055k = null;
        this.f4056l = null;
        this.f4057m = AMSStampManager.m4056a();
        this.f4058n = null;
        this.f4059o = null;
        this.f4060p = true;
        this.f4061q = null;
        setContentView(C0062R.layout.ams_stamp_selection_layout);
        this.f4051g = context.getSharedPreferences("AMSPref", 3);
        this.f4052h[0] = this.f4051g.getInt("AMS_STAMP_PREF_00", -1);
        this.f4052h[1] = this.f4051g.getInt("AMS_STAMP_PREF_01", -1);
        this.f4052h[2] = this.f4051g.getInt("AMS_STAMP_PREF_02", -1);
        this.f4052h[3] = this.f4051g.getInt("AMS_STAMP_PREF_03", -1);
        this.f4052h[4] = this.f4051g.getInt("AMS_STAMP_PREF_04", -1);
        m4077c();
        this.f4058n = (Button) findViewById(C0062R.id.btn_cancel);
        this.f4058n.setOnClickListener(this);
        this.f4059o = (Button) findViewById(C0062R.id.btn_delete);
        this.f4059o.setOnClickListener(this);
        if (this.f4057m.m4065c() == 0) {
            this.f4059o.setEnabled(false);
        }
    }

    /* renamed from: a */
    private void m4069a(FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m4073b(int i) {
        if (this.f4052h[0] != -1) {
            boolean z = false;
            for (int i2 = 0; i2 < 5; i2++) {
                if (this.f4052h[i2] == i + MsgResultCode.SUCCESS) {
                    this.f4052h[i2] = -1;
                    z = true;
                }
                if (this.f4052h[i2] > i + MsgResultCode.SUCCESS) {
                    int[] iArr = this.f4052h;
                    iArr[i2] = iArr[i2] - 1;
                    z = true;
                }
            }
            boolean z2 = false;
            for (int i3 = 0; i3 < 4; i3++) {
                if (this.f4052h[i3] == -1) {
                    z2 = true;
                }
                if (z2) {
                    this.f4052h[i3] = this.f4052h[i3 + 1];
                }
            }
            if (z2) {
                this.f4052h[4] = -1;
            }
            if (z) {
                this.f4051g.edit().putInt("AMS_STAMP_PREF_00", this.f4052h[0]).commit();
                this.f4051g.edit().putInt("AMS_STAMP_PREF_01", this.f4052h[1]).commit();
                this.f4051g.edit().putInt("AMS_STAMP_PREF_02", this.f4052h[2]).commit();
                this.f4051g.edit().putInt("AMS_STAMP_PREF_03", this.f4052h[3]).commit();
                this.f4051g.edit().putInt("AMS_STAMP_PREF_04", this.f4052h[4]).commit();
            }
            if (this.f4052h[0] == -1) {
                this.f4053i.setVisibility(8);
                ((ImageView) findViewById(C0062R.id.stamp_line)).setVisibility(8);
            } else {
                this.f4054j.m4088a();
            }
        }
        if (this.f4057m.m4065c() == 0) {
            this.f4060p = true;
            this.f4059o.setText(C0062R.string.ams_btn_delete);
            this.f4059o.setEnabled(false);
        }
    }

    /* renamed from: b */
    private void m4075b(FileOutputStream fileOutputStream) throws IOException {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m4076b(android.graphics.Bitmap r8, java.lang.String r9) throws java.lang.Throwable {
        /*
            r7 = this;
            r5 = 1
            r4 = 0
            java.lang.String r0 = r9.toLowerCase()
            java.lang.String r1 = ".png"
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L1d
            java.lang.String r0 = "[saveBitmapToPNG] Wrong extension!"
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.ChatONLogWriter.m3499a(r0, r1)
            r0 = r4
        L1c:
            return r0
        L1d:
            if (r8 != 0) goto L2e
            java.lang.String r0 = "[saveBitmapToPNG] Bitmap is null!"
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.ChatONLogWriter.m3499a(r0, r1)
            r0 = r4
            goto L1c
        L2e:
            java.io.File r0 = new java.io.File
            r0.<init>(r9)
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.io.IOException -> L58 java.lang.Throwable -> L96
            r2.<init>(r0)     // Catch: java.io.IOException -> L58 java.lang.Throwable -> L96
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> Lb7 java.io.IOException -> Lba
            r3 = 100
            r8.compress(r1, r3, r2)     // Catch: java.lang.Throwable -> Lb7 java.io.IOException -> Lba
            r7.m4069a(r2)
            r7.m4075b(r2)
            r1 = r5
        L47:
            if (r1 != 0) goto L9e
            java.lang.String r0 = "[saveBitmapToPNG] Fail to save file!"
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.ChatONLogWriter.m3499a(r0, r1)
            r0 = r4
            goto L1c
        L58:
            r2 = move-exception
            r6 = r2
            r2 = r1
            r1 = r6
        L5c:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r1 = "[resizedJpegCopy] IO Exception!"
            java.lang.Class r3 = r7.getClass()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Throwable -> Lb7
            com.sec.chaton.util.ChatONLogWriter.m3499a(r1, r3)     // Catch: java.lang.Throwable -> Lb7
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb7
            r1.<init>()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r3 = "[resizedJpegCopy] Out File: "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r3 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> Lb7
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lb7
            java.lang.Class r3 = r7.getClass()     // Catch: java.lang.Throwable -> Lb7
            java.lang.String r3 = r3.getSimpleName()     // Catch: java.lang.Throwable -> Lb7
            com.sec.chaton.util.ChatONLogWriter.m3499a(r1, r3)     // Catch: java.lang.Throwable -> Lb7
            r7.m4069a(r2)
            r7.m4075b(r2)
            r1 = r4
            goto L47
        L96:
            r0 = move-exception
        L97:
            r7.m4069a(r1)
            r7.m4075b(r1)
            throw r0
        L9e:
            boolean r0 = r0.exists()
            if (r0 != 0) goto Lb4
            java.lang.String r0 = "[saveBitmapToPNG] File does not exist!"
            java.lang.Class r1 = r7.getClass()
            java.lang.String r1 = r1.getSimpleName()
            com.sec.chaton.util.ChatONLogWriter.m3499a(r0, r1)
            r0 = r4
            goto L1c
        Lb4:
            r0 = r5
            goto L1c
        Lb7:
            r0 = move-exception
            r1 = r2
            goto L97
        Lba:
            r1 = move-exception
            goto L5c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.vip.amschaton.AMSStampSelectionDialog.m4076b(android.graphics.Bitmap, java.lang.String):boolean");
    }

    /* renamed from: c */
    private void m4077c() {
        if (this.f4052h[0] != -1) {
            this.f4053i = (GridView) findViewById(C0062R.id.gridview_preference);
            ((LinearLayout) findViewById(C0062R.id.layout_preference)).setVisibility(0);
            this.f4054j = new PreferenceStampGridAdapter();
            this.f4053i.setAdapter((ListAdapter) this.f4054j);
            this.f4053i.setSelector(C0062R.drawable.ams_grid_selector_dummy);
            this.f4053i.setOnItemClickListener(new C0647au(this));
            ((ImageView) findViewById(C0062R.id.stamp_line)).setVisibility(0);
        }
        this.f4055k = (GridView) findViewById(C0062R.id.gridview_stamp);
        this.f4056l = new BasicStampGridAdapter();
        this.f4055k.setAdapter((ListAdapter) this.f4056l);
        this.f4055k.setSelector(C0062R.drawable.ams_grid_selector_dummy);
        this.f4055k.setOnScrollListener(new C0646at(this));
        this.f4055k.setOnItemClickListener(new C0645as(this));
    }

    /* renamed from: a */
    public int m4082a() {
        return this.f4050f < this.f4057m.m4063b() ? this.f4050f : (this.f4050f - this.f4057m.m4063b()) + MsgResultCode.SUCCESS;
    }

    /* renamed from: a */
    public void m4083a(int i) {
        if (i < 1000) {
            this.f4050f = i;
        } else {
            this.f4050f = (this.f4057m.m4063b() + i) - MsgResultCode.SUCCESS;
        }
        if (this.f4055k != null) {
            this.f4055k.setSelection(this.f4050f);
        }
        m4086b();
    }

    /* renamed from: a */
    public void m4084a(InterfaceC0702e interfaceC0702e) {
        this.f4061q = interfaceC0702e;
    }

    /* renamed from: a */
    public boolean m4085a(Bitmap bitmap, String str) {
        return m4076b(bitmap, str);
    }

    /* renamed from: b */
    public void m4086b() {
        this.f4056l.m4087a();
        if (this.f4057m.m4065c() > 0 || !this.f4060p) {
            this.f4059o.setEnabled(true);
        } else {
            this.f4059o.setEnabled(false);
        }
    }

    @Override // com.sec.vip.amschaton.AMSToolSelectionDialog, android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case C0062R.id.btn_cancel /* 2131427352 */:
                if (!this.f4060p) {
                    this.f4060p = !this.f4060p;
                    this.f4059o.setText(C0062R.string.ams_btn_delete);
                    m4086b();
                    break;
                } else {
                    super.onClick(view);
                    break;
                }
            case C0062R.id.btn_delete /* 2131427436 */:
                this.f4060p = !this.f4060p;
                if (this.f4060p) {
                    this.f4059o.setText(C0062R.string.ams_btn_delete);
                } else {
                    this.f4059o.setText(C0062R.string.ams_btn_done);
                }
                m4086b();
                break;
            default:
                super.onClick(view);
                break;
        }
    }
}
