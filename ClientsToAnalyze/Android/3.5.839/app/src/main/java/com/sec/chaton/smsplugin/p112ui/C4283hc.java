package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.widget.MultiAutoCompleteTextView;

/* compiled from: RecipientsEditor.java */
/* renamed from: com.sec.chaton.smsplugin.ui.hc */
/* loaded from: classes.dex */
class C4283hc implements MultiAutoCompleteTextView.Tokenizer {

    /* renamed from: a */
    final /* synthetic */ RecipientsEditor f15664a;

    /* renamed from: b */
    private final MultiAutoCompleteTextView f15665b;

    /* renamed from: c */
    private final Context f15666c;

    C4283hc(RecipientsEditor recipientsEditor, Context context, MultiAutoCompleteTextView multiAutoCompleteTextView) {
        this.f15664a = recipientsEditor;
        this.f15665b = multiAutoCompleteTextView;
        this.f15666c = context;
    }

    @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
    public int findTokenStart(CharSequence charSequence, int i) {
        int i2 = i;
        while (i2 > 0) {
            char cCharAt = charSequence.charAt(i2 - 1);
            if (cCharAt == ',' || cCharAt == ';') {
                break;
            }
            i2--;
        }
        while (i2 < i && charSequence.charAt(i2) == ' ') {
            i2++;
        }
        return i2;
    }

    @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
    public int findTokenEnd(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            if (cCharAt != ',' && cCharAt != ';') {
                i2++;
            } else {
                return i2;
            }
        }
        return length;
    }

    @Override // android.widget.MultiAutoCompleteTextView.Tokenizer
    public CharSequence terminateToken(CharSequence charSequence) {
        char cCharAt;
        int length = charSequence.length();
        while (length > 0 && charSequence.charAt(length - 1) == ' ') {
            length--;
        }
        if (length <= 0 || ((cCharAt = charSequence.charAt(length - 1)) != ',' && cCharAt != ';')) {
            String str = this.f15664a.f15078c + " ";
            if (charSequence instanceof Spanned) {
                SpannableString spannableString = new SpannableString(((Object) charSequence) + str);
                TextUtils.copySpansFrom((Spanned) charSequence, 0, charSequence.length(), Object.class, spannableString, 0);
                return spannableString;
            }
            return ((Object) charSequence) + str;
        }
        return charSequence;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x004e  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.String> m16483a() {
        /*
            r7 = this;
            r1 = 0
            android.widget.MultiAutoCompleteTextView r0 = r7.f15665b
            android.text.Editable r3 = r0.getText()
            int r4 = r3.length()
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r2 = r1
        L11:
            int r0 = r4 + 1
            if (r1 >= r0) goto L4d
            if (r1 == r4) goto L23
            char r0 = r3.charAt(r1)
            r6 = 44
            if (r0 == r6) goto L23
            r6 = 59
            if (r0 != r6) goto L49
        L23:
            if (r1 <= r2) goto L4e
            android.content.Context r0 = r7.f15666c
            java.lang.String r0 = com.sec.chaton.smsplugin.p112ui.RecipientsEditor.m16160a(r3, r2, r1, r0)
            r5.add(r0)
            android.content.Context r0 = r7.f15666c
            int r0 = com.sec.chaton.smsplugin.p112ui.RecipientsEditor.m16164b(r3, r2, r1, r0)
            if (r0 <= r1) goto L4e
        L36:
            int r0 = r0 + 1
        L38:
            if (r0 >= r4) goto L45
            char r1 = r3.charAt(r0)
            r2 = 32
            if (r1 != r2) goto L45
            int r0 = r0 + 1
            goto L38
        L45:
            r1 = r0
        L46:
            r2 = r1
            r1 = r0
            goto L11
        L49:
            int r0 = r1 + 1
            r1 = r2
            goto L46
        L4d:
            return r5
        L4e:
            r0 = r1
            goto L36
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sec.chaton.smsplugin.p112ui.C4283hc.m16483a():java.util.List");
    }
}
