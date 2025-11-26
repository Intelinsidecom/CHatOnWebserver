package com.sec.chaton.smsplugin.p112ui;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.MergeCursor;
import android.telephony.PhoneNumberUtils;
import android.text.Annotation;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import com.sec.chaton.R;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.p057e.C2289i;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.util.C4827as;
import java.util.ArrayList;

/* compiled from: RecipientsAdapter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gz */
/* loaded from: classes.dex */
public class C4279gz extends ResourceCursorAdapter {

    /* renamed from: a */
    private static final String[] f15656a = {"_id", "buddy_no", "buddy_sainfo", "buddy_phonenumber_external_use", "buddy_is_hide", "buddy_name", "buddy_coverstory_meta_id"};

    /* renamed from: b */
    private final Context f15657b;

    /* renamed from: c */
    private final ContentResolver f15658c;

    /* renamed from: d */
    private final String f15659d;

    public C4279gz(Context context) {
        super(context, R.layout.recipient_filter_item, (Cursor) null, false);
        this.f15657b = context;
        this.f15658c = context.getContentResolver();
        this.f15659d = GlobalApplication.m10279a().m10297l();
    }

    @Override // android.widget.CursorAdapter
    public final CharSequence convertToString(Cursor cursor) {
        String strReplace;
        String string = cursor.getString(3);
        if (string == null) {
            return "";
        }
        String strTrim = string.trim();
        String string2 = cursor.getString(5);
        String string3 = cursor.getString(4);
        if (string2 == null) {
            strReplace = "";
        } else {
            strReplace = string2.replace(", ", " ").replace(",", " ");
        }
        SpannableString spannableString = new SpannableString(C3782a.m14208a(strReplace, strTrim, cursor.getString(6)));
        int length = spannableString.length();
        if (!TextUtils.isEmpty(strReplace)) {
            spannableString.setSpan(new Annotation("name", strReplace), 0, length, 33);
        } else {
            spannableString.setSpan(new Annotation("name", strTrim), 0, length, 33);
        }
        spannableString.setSpan(new Annotation("person_id", cursor.getString(1)), 0, length, 33);
        spannableString.setSpan(new Annotation("label", string3.toString()), 0, length, 33);
        spannableString.setSpan(new Annotation("number", strTrim), 0, length, 33);
        return spannableString;
    }

    @Override // android.widget.CursorAdapter
    public final void bindView(View view, Context context, Cursor cursor) {
        ((TextView) view.findViewById(R.id.name)).setText(cursor.getString(5));
        TextView textView = (TextView) view.findViewById(R.id.label);
        TextView textView2 = (TextView) view.findViewById(R.id.number);
        if (!TextUtils.isEmpty(cursor.getString(3))) {
            if (cursor.getInt(0) != -1) {
                textView.setText(this.f15657b.getResources().getString(R.string.vcard_phone_type_02));
                textView.setVisibility(0);
            } else {
                textView.setVisibility(8);
            }
            String number = PhoneNumberUtils.formatNumber(cursor.getString(3), this.f15659d);
            if (number == null) {
                number = cursor.getString(3);
            }
            textView2.setText(number);
        }
    }

    @Override // android.widget.CursorAdapter
    public Cursor runQueryOnBackgroundThread(CharSequence charSequence) {
        String str;
        String strTrim;
        if (charSequence == null) {
            str = null;
            strTrim = "";
        } else {
            String string = charSequence.toString();
            if (!m16482a(string)) {
                str = string;
                strTrim = "";
            } else {
                String strConvertKeypadLettersToDigits = PhoneNumberUtils.convertKeypadLettersToDigits(string);
                if (strConvertKeypadLettersToDigits.equals(string)) {
                    str = string;
                    strTrim = "";
                } else {
                    str = string;
                    strTrim = strConvertKeypadLettersToDigits.trim();
                }
            }
        }
        Cursor cursorQuery = this.f15658c.query(C2289i.f8196a, f15656a, "(buddy_phonenumber_external_use !=\"\") and (buddy_name !=\"\" )", null, null);
        if (!TextUtils.isEmpty(str)) {
            cursorQuery = m16481a(cursorQuery, str);
        }
        if (strTrim.length() > 0) {
            MatrixCursor matrixCursor = new MatrixCursor(f15656a, 1);
            matrixCursor.addRow(new Object[]{-1, -1L, 0, strTrim, " ", str, strTrim});
            return cursorQuery == null ? matrixCursor : new MergeCursor(new Cursor[]{matrixCursor, cursorQuery});
        }
        return cursorQuery;
    }

    /* renamed from: a */
    private Cursor m16481a(Cursor cursor, String str) {
        ArrayList arrayList = new ArrayList();
        if (cursor.moveToFirst()) {
            do {
                Object[] objArr = {Integer.valueOf(cursor.getInt(0)), Integer.valueOf(cursor.getInt(1)), Integer.valueOf(cursor.getInt(2)), cursor.getString(3), cursor.getString(4), cursor.getString(5), cursor.getString(6)};
                if (str != null) {
                    str = str.toUpperCase();
                }
                if (str != null) {
                    String str2 = (String) objArr[3];
                    String upperCase = ((String) objArr[5]).toUpperCase();
                    if (C4827as.m18268a(upperCase, str) || C4827as.m18268a(str2, str)) {
                        String[] strArrSplit = str2.split(" ");
                        if (strArrSplit.length > 0) {
                            for (String str3 : strArrSplit) {
                                if (C4827as.m18268a(upperCase, str) || C4827as.m18268a(str3, str)) {
                                    MatrixCursor matrixCursor = new MatrixCursor(f15656a, 1);
                                    objArr[3] = str3;
                                    matrixCursor.addRow(objArr);
                                    arrayList.add(matrixCursor);
                                }
                            }
                        } else {
                            MatrixCursor matrixCursor2 = new MatrixCursor(f15656a, 1);
                            matrixCursor2.addRow(objArr);
                            arrayList.add(matrixCursor2);
                        }
                    }
                }
            } while (cursor.moveToNext());
            if (arrayList.size() <= 0) {
                return null;
            }
            Cursor[] cursorArr = new Cursor[arrayList.size()];
            arrayList.toArray(cursorArr);
            return new MergeCursor(cursorArr);
        }
        return cursor;
    }

    /* renamed from: a */
    private boolean m16482a(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = charSequence.charAt(i);
            if ((cCharAt < '0' || cCharAt > '9') && cCharAt != ' ' && cCharAt != '-' && cCharAt != '(' && cCharAt != ')' && cCharAt != '.' && cCharAt != '+' && cCharAt != '#' && cCharAt != '*' && ((cCharAt < 'A' || cCharAt > 'Z') && (cCharAt < 'a' || cCharAt > 'z'))) {
                return false;
            }
        }
        return true;
    }
}
