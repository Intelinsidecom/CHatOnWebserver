package com.sec.chaton.smsplugin.p112ui;

import android.R;
import android.content.Context;
import android.provider.Telephony;
import android.telephony.PhoneNumberUtils;
import android.text.Annotation;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.widget.MultiAutoCompleteTextView;
import com.sec.chaton.smsplugin.C3847e;
import com.sec.chaton.smsplugin.p102b.C3782a;
import com.sec.chaton.smsplugin.p102b.C3789h;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class RecipientsEditor extends MultiAutoCompleteTextView {

    /* renamed from: a */
    private int f15076a;

    /* renamed from: b */
    private final C4283hc f15077b;

    /* renamed from: c */
    private char f15078c;

    public RecipientsEditor(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.autoCompleteTextViewStyle);
        this.f15076a = -1;
        this.f15078c = ',';
        this.f15077b = new C4283hc(this, context, this);
        setTokenizer(this.f15077b);
        setImeOptions(5);
        addTextChangedListener(new C4281ha(this));
    }

    @Override // android.widget.MultiAutoCompleteTextView, android.widget.AutoCompleteTextView
    public boolean enoughToFilter() {
        return getText().length() > 0;
    }

    /* renamed from: a */
    public int m16167a() {
        return this.f15077b.m16483a().size();
    }

    /* renamed from: b */
    public List<String> m16170b() {
        return this.f15077b.m16483a();
    }

    /* renamed from: a */
    public C3789h m16168a(boolean z) {
        List<String> listM16483a = this.f15077b.m16483a();
        C3789h c3789h = new C3789h();
        for (String str : listM16483a) {
            C3782a c3782aM14204a = C3782a.m14204a(str, z);
            c3782aM14204a.m14258b(str);
            c3789h.add(c3782aM14204a);
        }
        return c3789h;
    }

    /* renamed from: a */
    private boolean m16163a(String str, boolean z) {
        if (z) {
            return C4149cd.m16425b(str);
        }
        return PhoneNumberUtils.isWellFormedSmsAddress(str) || Telephony.Mms.isEmailAddress(str);
    }

    /* renamed from: b */
    public boolean m16171b(boolean z) {
        Iterator<String> it = this.f15077b.m16483a().iterator();
        while (it.hasNext()) {
            if (m16163a(it.next(), z)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public boolean m16173c(boolean z) {
        for (String str : this.f15077b.m16483a()) {
            if (m16163a(str, z) || (C3847e.m14705k() != null && C4149cd.m16418a(str))) {
            }
            return true;
        }
        return false;
    }

    /* renamed from: d */
    public String m16174d(boolean z) {
        StringBuilder sb = new StringBuilder();
        for (String str : this.f15077b.m16483a()) {
            if (!m16163a(str, z)) {
                if (sb.length() != 0) {
                    sb.append(", ");
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: c */
    public boolean m16172c() {
        if (TextUtils.indexOf((CharSequence) getText(), '@') == -1) {
            return false;
        }
        Iterator<String> it = this.f15077b.m16483a().iterator();
        while (it.hasNext()) {
            if (Telephony.Mms.isEmailAddress(it.next())) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static CharSequence m16159a(C3782a c3782a) {
        SpannableString spannableString = new SpannableString(c3782a.m14266h());
        int length = spannableString.length();
        if (length != 0) {
            spannableString.setSpan(new Annotation("number", c3782a.m14262d()), 0, length, 33);
        }
        return spannableString;
    }

    /* renamed from: a */
    public void m16169a(C3789h c3789h) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        Iterator<C3782a> it = c3789h.iterator();
        while (it.hasNext()) {
            spannableStringBuilder.append(m16159a(it.next())).append((CharSequence) ", ");
        }
    }

    /* renamed from: a */
    private int m16158a(int i, int i2) {
        int compoundPaddingLeft = i - getCompoundPaddingLeft();
        int extendedPaddingTop = i2 - getExtendedPaddingTop();
        int scrollX = compoundPaddingLeft + getScrollX();
        int scrollY = extendedPaddingTop + getScrollY();
        Layout layout = getLayout();
        if (layout == null) {
            return -1;
        }
        return layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action == 0) {
            this.f15076a = m16158a(x, y);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        int iFindTokenStart;
        int iFindTokenEnd;
        if (this.f15076a >= 0) {
            Editable text = getText();
            if (this.f15076a <= text.length() && (iFindTokenEnd = this.f15077b.findTokenEnd(text, (iFindTokenStart = this.f15077b.findTokenStart(text, this.f15076a)))) != iFindTokenStart) {
                return new ContextMenuContextMenuInfoC4282hb(C3782a.m14204a(m16165c(getText(), iFindTokenStart, iFindTokenEnd, getContext()), false));
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static String m16165c(Spanned spanned, int i, int i2, Context context) {
        return m16161a("number", spanned, i, i2, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static int m16166d(Spanned spanned, int i, int i2, Context context) {
        Annotation[] annotationArr = (Annotation[]) spanned.getSpans(i, i2, Annotation.class);
        if (annotationArr.length > 0) {
            return spanned.getSpanEnd(annotationArr[0]);
        }
        return 0;
    }

    /* renamed from: a */
    private static String m16161a(String str, Spanned spanned, int i, int i2, Context context) {
        String strM16162a = m16162a((Annotation[]) spanned.getSpans(i, i2, Annotation.class), str);
        if (TextUtils.isEmpty(strM16162a)) {
            return TextUtils.substring(spanned, i, i2);
        }
        return strM16162a;
    }

    /* renamed from: a */
    private static String m16162a(Annotation[] annotationArr, String str) {
        for (int i = 0; i < annotationArr.length; i++) {
            if (annotationArr[i].getKey().equals(str)) {
                return annotationArr[i].getValue();
            }
        }
        return "";
    }
}
