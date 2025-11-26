package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* compiled from: SimpleCursorAdapter.java */
/* renamed from: android.support.v4.widget.z */
/* loaded from: classes.dex */
public class C0266z extends AbstractC0259s {

    /* renamed from: j */
    protected int[] f603j;

    /* renamed from: k */
    protected int[] f604k;

    /* renamed from: l */
    String[] f605l;

    /* renamed from: m */
    private int f606m;

    /* renamed from: n */
    private InterfaceC0226aa f607n;

    /* renamed from: o */
    private InterfaceC0227ab f608o;

    @Deprecated
    public C0266z(Context context, int i, Cursor cursor, String[] strArr, int[] iArr) {
        super(context, i, cursor);
        this.f606m = -1;
        this.f604k = iArr;
        this.f605l = strArr;
        m938a(strArr);
    }

    public C0266z(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.f606m = -1;
        this.f604k = iArr;
        this.f605l = strArr;
        m938a(strArr);
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: a */
    public void mo876a(View view, Context context, Cursor cursor) {
        InterfaceC0227ab interfaceC0227ab = this.f608o;
        int length = this.f604k.length;
        int[] iArr = this.f603j;
        int[] iArr2 = this.f604k;
        for (int i = 0; i < length; i++) {
            View viewFindViewById = view.findViewById(iArr2[i]);
            if (viewFindViewById != null) {
                if (interfaceC0227ab != null ? interfaceC0227ab.m807a(viewFindViewById, cursor, iArr[i]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (viewFindViewById instanceof TextView) {
                        m940a((TextView) viewFindViewById, string);
                    } else if (viewFindViewById instanceof ImageView) {
                        m939a((ImageView) viewFindViewById, string);
                    } else {
                        throw new IllegalStateException(viewFindViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m939a(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    /* renamed from: a */
    public void m940a(TextView textView, String str) {
        textView.setText(str);
    }

    @Override // android.support.v4.widget.AbstractC0243c, android.support.v4.widget.InterfaceC0248h
    /* renamed from: c */
    public CharSequence mo880c(Cursor cursor) {
        if (this.f607n != null) {
            return this.f607n.m806a(cursor);
        }
        if (this.f606m > -1) {
            return cursor.getString(this.f606m);
        }
        return super.mo880c(cursor);
    }

    /* renamed from: a */
    private void m938a(String[] strArr) {
        if (this.f579c != null) {
            int length = strArr.length;
            if (this.f603j == null || this.f603j.length != length) {
                this.f603j = new int[length];
            }
            for (int i = 0; i < length; i++) {
                this.f603j[i] = this.f579c.getColumnIndexOrThrow(strArr[i]);
            }
            return;
        }
        this.f603j = null;
    }

    @Override // android.support.v4.widget.AbstractC0243c
    /* renamed from: b */
    public Cursor mo877b(Cursor cursor) {
        Cursor cursorB = super.mo877b(cursor);
        m938a(this.f605l);
        return cursorB;
    }
}
