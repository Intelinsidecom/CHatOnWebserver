package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
public class SimpleCursorAdapter extends ResourceCursorAdapter {

    /* renamed from: a */
    private int f181a;

    /* renamed from: b */
    private CursorToStringConverter f182b;

    /* renamed from: c */
    private ViewBinder f183c;

    /* renamed from: s */
    protected int[] f184s;

    /* renamed from: t */
    protected int[] f185t;

    /* renamed from: u */
    String[] f186u;

    public interface CursorToStringConverter {
        /* renamed from: a */
        CharSequence m225a(Cursor cursor);
    }

    public interface ViewBinder {
        /* renamed from: a */
        boolean m226a(View view, Cursor cursor, int i);
    }

    public SimpleCursorAdapter(Context context, int i, Cursor cursor, String[] strArr, int[] iArr, int i2) {
        super(context, i, cursor, i2);
        this.f181a = -1;
        this.f185t = iArr;
        this.f186u = strArr;
        m222a(strArr);
    }

    /* renamed from: a */
    private void m222a(String[] strArr) {
        if (this.mCursor == null) {
            this.f184s = null;
            return;
        }
        int length = strArr.length;
        if (this.f184s == null || this.f184s.length != length) {
            this.f184s = new int[length];
        }
        for (int i = 0; i < length; i++) {
            this.f184s[i] = this.mCursor.getColumnIndexOrThrow(strArr[i]);
        }
    }

    /* renamed from: a */
    public void m223a(ImageView imageView, String str) {
        try {
            imageView.setImageResource(Integer.parseInt(str));
        } catch (NumberFormatException e) {
            imageView.setImageURI(Uri.parse(str));
        }
    }

    /* renamed from: a */
    public void m224a(TextView textView, String str) {
        textView.setText(str);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ViewBinder viewBinder = this.f183c;
        int length = this.f185t.length;
        int[] iArr = this.f184s;
        int[] iArr2 = this.f185t;
        for (int i = 0; i < length; i++) {
            View viewFindViewById = view.findViewById(iArr2[i]);
            if (viewFindViewById != null) {
                if (viewBinder != null ? viewBinder.m226a(viewFindViewById, cursor, iArr[i]) : false) {
                    continue;
                } else {
                    String string = cursor.getString(iArr[i]);
                    if (string == null) {
                        string = "";
                    }
                    if (viewFindViewById instanceof TextView) {
                        m224a((TextView) viewFindViewById, string);
                    } else {
                        if (!(viewFindViewById instanceof ImageView)) {
                            throw new IllegalStateException(viewFindViewById.getClass().getName() + " is not a  view that can be bounds by this SimpleCursorAdapter");
                        }
                        m223a((ImageView) viewFindViewById, string);
                    }
                }
            }
        }
    }

    @Override // android.support.v4.widget.CursorAdapter, android.support.v4.widget.InterfaceC0046d
    public CharSequence convertToString(Cursor cursor) {
        return this.f182b != null ? this.f182b.m225a(cursor) : this.f181a > -1 ? cursor.getString(this.f181a) : super.convertToString(cursor);
    }

    @Override // android.support.v4.widget.CursorAdapter
    public Cursor swapCursor(Cursor cursor) {
        Cursor cursorSwapCursor = super.swapCursor(cursor);
        m222a(this.f186u);
        return cursorSwapCursor;
    }
}
