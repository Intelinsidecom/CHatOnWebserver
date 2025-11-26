package com.android.p029ex.editstyledtext;

import android.R;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.ap */
/* loaded from: classes.dex */
class C0376ap {

    /* renamed from: a */
    private AlertDialog.Builder f919a;

    /* renamed from: b */
    private AlertDialog f920b;

    /* renamed from: c */
    private CharSequence f921c;

    /* renamed from: d */
    private CharSequence f922d;

    /* renamed from: e */
    private CharSequence f923e;

    /* renamed from: f */
    private CharSequence f924f;

    /* renamed from: g */
    private CharSequence[] f925g;

    /* renamed from: h */
    private CharSequence[] f926h;

    /* renamed from: i */
    private CharSequence[] f927i;

    /* renamed from: j */
    private CharSequence[] f928j;

    /* renamed from: k */
    private CharSequence[] f929k;

    /* renamed from: l */
    private CharSequence[] f930l;

    /* renamed from: m */
    private CharSequence[] f931m;

    /* renamed from: n */
    private CharSequence f932n;

    /* renamed from: o */
    private EditStyledText f933o;

    public C0376ap(EditStyledText editStyledText) {
        this.f933o = editStyledText;
    }

    /* renamed from: a */
    public void m1446a(AlertDialog.Builder builder) {
        this.f919a = builder;
    }

    /* renamed from: a */
    public void m1448a(CharSequence charSequence, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, CharSequence charSequence2) {
        this.f921c = charSequence;
        this.f925g = charSequenceArr;
        this.f926h = charSequenceArr2;
        this.f932n = charSequence2;
    }

    /* renamed from: a */
    public void m1449a(CharSequence charSequence, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, CharSequence[] charSequenceArr3) {
        this.f922d = charSequence;
        this.f927i = charSequenceArr;
        this.f928j = charSequenceArr2;
        this.f929k = charSequenceArr3;
    }

    /* renamed from: a */
    public void m1447a(CharSequence charSequence, CharSequence[] charSequenceArr) {
        this.f923e = charSequence;
        this.f930l = charSequenceArr;
    }

    /* renamed from: b */
    public void m1450b(CharSequence charSequence, CharSequence[] charSequenceArr) {
        this.f924f = charSequence;
        this.f931m = charSequenceArr;
    }

    /* renamed from: a */
    private boolean m1430a() {
        Log.d("EditStyledText", "--- checkParams");
        if (this.f919a == null) {
            Log.e("EditStyledText", "--- builder is null.");
            return false;
        }
        if (this.f921c == null || this.f925g == null || this.f926h == null) {
            Log.e("EditStyledText", "--- color alert params are null.");
            return false;
        }
        if (this.f925g.length != this.f926h.length) {
            Log.e("EditStyledText", "--- the length of color alert params are different.");
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private boolean m1432b() {
        Log.d("EditStyledText", "--- checkParams");
        if (this.f919a == null) {
            Log.e("EditStyledText", "--- builder is null.");
            return false;
        }
        if (this.f922d == null || this.f927i == null || this.f928j == null || this.f929k == null) {
            Log.e("EditStyledText", "--- size alert params are null.");
            return false;
        }
        if (this.f927i.length != this.f928j.length && this.f929k.length != this.f928j.length) {
            Log.e("EditStyledText", "--- the length of size alert params are different.");
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private boolean m1433c() {
        Log.d("EditStyledText", "--- checkAlignAlertParams");
        if (this.f919a == null) {
            Log.e("EditStyledText", "--- builder is null.");
            return false;
        }
        if (this.f923e == null) {
            Log.e("EditStyledText", "--- align alert params are null.");
            return false;
        }
        return true;
    }

    /* renamed from: d */
    private boolean m1436d() {
        Log.d("EditStyledText", "--- checkMarqueeAlertParams");
        if (this.f919a == null) {
            Log.e("EditStyledText", "--- builder is null.");
            return false;
        }
        if (this.f924f == null) {
            Log.e("EditStyledText", "--- Marquee alert params are null.");
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m1429a(CharSequence charSequence, CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
        this.f919a.setTitle(charSequence);
        this.f919a.setIcon(0);
        this.f919a.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
        this.f919a.setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC0377aq(this));
        this.f919a.setItems(charSequenceArr, onClickListener);
        this.f919a.setView((View) null);
        this.f919a.setCancelable(true);
        this.f919a.setOnCancelListener(new DialogInterfaceOnCancelListenerC0380at(this));
        this.f919a.show();
    }

    /* renamed from: a */
    private void m1428a(int i, CharSequence charSequence, int[] iArr) {
        int iM1266c = this.f933o.m1266c(50);
        int iM1266c2 = this.f933o.m1266c(2);
        int iM1266c3 = this.f933o.m1266c(15);
        this.f919a.setTitle(charSequence);
        this.f919a.setIcon(0);
        this.f919a.setPositiveButton((CharSequence) null, (DialogInterface.OnClickListener) null);
        this.f919a.setNegativeButton(R.string.cancel, new DialogInterfaceOnClickListenerC0381au(this));
        this.f919a.setItems((CharSequence[]) null, (DialogInterface.OnClickListener) null);
        LinearLayout linearLayout = new LinearLayout(this.f933o.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        linearLayout.setPadding(iM1266c3, iM1266c3, iM1266c3, iM1266c3);
        LinearLayout linearLayout2 = null;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (i2 % 5 == 0) {
                linearLayout2 = new LinearLayout(this.f933o.getContext());
                linearLayout.addView(linearLayout2);
            }
            Button button = new Button(this.f933o.getContext());
            button.setHeight(iM1266c);
            button.setWidth(iM1266c);
            button.setBackgroundDrawable(new C0387b(iArr[i2], iM1266c, iM1266c, iM1266c2));
            button.setDrawingCacheBackgroundColor(iArr[i2]);
            if (i == 0) {
                button.setOnClickListener(new ViewOnClickListenerC0382av(this));
            } else if (i == 1) {
                button.setOnClickListener(new ViewOnClickListenerC0383aw(this));
            }
            linearLayout2.addView(button);
        }
        if (i == 1) {
            this.f919a.setPositiveButton(this.f932n, new DialogInterfaceOnClickListenerC0384ax(this));
        } else if (i == 0) {
            this.f919a.setPositiveButton(this.f932n, new DialogInterfaceOnClickListenerC0385ay(this));
        }
        this.f919a.setView(linearLayout);
        this.f919a.setCancelable(true);
        this.f919a.setOnCancelListener(new DialogInterfaceOnCancelListenerC0386az(this));
        this.f920b = this.f919a.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m1437e() {
        Log.d("EditStyledText", "--- onShowForegroundColorAlertDialog");
        if (m1430a()) {
            int[] iArr = new int[this.f926h.length];
            for (int i = 0; i < iArr.length; i++) {
                iArr[i] = Integer.parseInt((String) this.f926h[i], 16) - 16777216;
            }
            m1428a(0, this.f921c, iArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m1439f() {
        Log.d("EditStyledText", "--- onShowBackgroundColorAlertDialog");
        if (m1430a()) {
            int[] iArr = new int[this.f926h.length];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < iArr.length) {
                    iArr[i2] = Integer.parseInt((String) this.f926h[i2], 16) - 16777216;
                    i = i2 + 1;
                } else {
                    m1428a(1, this.f921c, iArr);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m1441g() {
        Log.d("EditStyledText", "--- onShowSizeAlertDialog");
        if (m1432b()) {
            m1429a(this.f922d, this.f927i, new DialogInterfaceOnClickListenerC0388ba(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m1443h() {
        Log.d("EditStyledText", "--- onShowAlignAlertDialog");
        if (m1433c()) {
            m1429a(this.f923e, this.f930l, new DialogInterfaceOnClickListenerC0378ar(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m1445i() {
        Log.d("EditStyledText", "--- onShowMarqueeAlertDialog");
        if (m1436d()) {
            m1429a(this.f924f, this.f931m, new DialogInterfaceOnClickListenerC0379as(this));
        }
    }
}
