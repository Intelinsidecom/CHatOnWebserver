package com.android.p029ex.editstyledtext;

import android.net.Uri;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.AlignmentSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.ParagraphStyle;
import android.text.style.QuoteSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import com.android.p029ex.editstyledtext.EditStyledText;

/* compiled from: EditStyledText.java */
/* renamed from: com.android.ex.editstyledtext.ak */
/* loaded from: classes.dex */
class C0371ak {

    /* renamed from: a */
    final /* synthetic */ EditStyledText f894a;

    /* renamed from: b */
    private boolean f895b = false;

    /* renamed from: c */
    private boolean f896c = false;

    /* renamed from: d */
    private boolean f897d = false;

    /* renamed from: e */
    private boolean f898e = false;

    /* renamed from: f */
    private boolean f899f = false;

    /* renamed from: g */
    private int f900g = 0;

    /* renamed from: h */
    private int f901h = 0;

    /* renamed from: i */
    private int f902i = 0;

    /* renamed from: j */
    private int f903j = 0;

    /* renamed from: k */
    private int f904k = 16777215;

    /* renamed from: l */
    private int f905l = 0;

    /* renamed from: m */
    private int f906m = 16777215;

    /* renamed from: n */
    private BackgroundColorSpan f907n;

    /* renamed from: o */
    private EditStyledText f908o;

    /* renamed from: p */
    private C0392c f909p;

    /* renamed from: q */
    private EditStyledText.SoftKeyReceiver f910q;

    /* renamed from: r */
    private SpannableStringBuilder f911r;

    C0371ak(EditStyledText editStyledText, EditStyledText editStyledText2, C0376ap c0376ap) {
        this.f894a = editStyledText;
        this.f908o = editStyledText2;
        this.f909p = new C0392c(editStyledText, this.f908o, this, c0376ap);
        this.f910q = new EditStyledText.SoftKeyReceiver(this.f908o);
    }

    /* renamed from: a */
    public void m1384a(int i) {
        m1386a(i, true);
    }

    /* renamed from: a */
    public void m1386a(int i, boolean z) {
        this.f909p.m1458a(i);
        if (z) {
            this.f908o.m1257a(this.f900g, this.f901h);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public void m1381y() {
        m1332I();
        m1417u();
    }

    /* renamed from: a */
    public void m1389a(boolean z) {
        Log.d("EditStyledText.EditorManager", "--- onClickSelect");
        this.f900g = 5;
        if (this.f901h == 0) {
            this.f909p.m1457a();
        } else {
            m1334K();
            this.f909p.m1457a();
        }
        if (z) {
            this.f908o.m1257a(this.f900g, this.f901h);
        }
    }

    /* renamed from: a */
    public void m1383a() {
        Log.d("EditStyledText.EditorManager", "--- onClickView");
        if (this.f901h == 1 || this.f901h == 2) {
            this.f909p.m1457a();
            this.f908o.m1257a(this.f900g, this.f901h);
        }
    }

    /* renamed from: b */
    public void m1395b(boolean z) {
        Log.d("EditStyledText.EditorManager", "--- onClickSelectAll");
        m1330G();
        if (z) {
            this.f908o.m1257a(this.f900g, this.f901h);
        }
    }

    /* renamed from: b */
    public void m1390b() {
        Log.d("EditStyledText.EditorManager", "--- onFixSelectedItem");
        m1326C();
        this.f908o.m1257a(this.f900g, this.f901h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1345a(Uri uri) {
        m1346a(new C0370aj(this.f908o.getContext(), uri, this.f908o.m1285z()), this.f908o.getSelectionStart());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m1365e(int i) {
        m1346a(new C0370aj(this.f908o.getContext(), i, this.f908o.m1284y()), this.f908o.getSelectionStart());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public void m1382z() {
        int i;
        Log.d("EditStyledText.EditorManager", "--- onInsertHorizontalLine:");
        int selectionStart = this.f908o.getSelectionStart();
        if (selectionStart <= 0 || this.f908o.getText().charAt(selectionStart - 1) == '\n') {
            i = selectionStart;
        } else {
            i = selectionStart + 1;
            this.f908o.getText().insert(selectionStart, "\n");
        }
        int i2 = i + 1;
        m1346a(new C0368ah(-16777216, this.f908o.getWidth(), this.f908o.getText()), i);
        this.f908o.getText().insert(i2, "\n");
        this.f908o.setSelection(i2 + 1);
        this.f908o.m1257a(this.f900g, this.f901h);
    }

    /* renamed from: a */
    private void m1350a(CharSequence charSequence) {
        Log.d("EditStyledText", "--- onClearStyles");
        int length = charSequence.length();
        if (charSequence instanceof Editable) {
            Editable editable = (Editable) charSequence;
            for (Object obj : editable.getSpans(0, length, Object.class)) {
                if ((obj instanceof ParagraphStyle) || (obj instanceof QuoteSpan) || ((obj instanceof CharacterStyle) && !(obj instanceof UnderlineSpan))) {
                    if ((obj instanceof ImageSpan) || (obj instanceof C0368ah)) {
                        editable.replace(editable.getSpanStart(obj), editable.getSpanEnd(obj), "");
                    }
                    editable.removeSpan(obj);
                }
            }
        }
    }

    /* renamed from: c */
    public void m1396c() {
        this.f909p.m1458a(14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m1324A() {
        Log.d("EditStyledText.EditorManager", "--- onClearStyles");
        m1350a((CharSequence) this.f908o.getText());
        this.f908o.setBackgroundDrawable(this.f908o.f873f);
        this.f906m = 16777215;
        m1399d();
    }

    /* renamed from: d */
    public void m1399d() {
        Editable text = this.f908o.getText();
        int i = 0;
        while (i < text.length()) {
            if (text.charAt(i) == 8288) {
                text.replace(i, i + 1, "");
                i--;
            }
            i++;
        }
    }

    /* renamed from: e */
    public void m1401e() {
        Log.d("EditStyledText.EditorManager", "--- onRefreshStyles");
        Editable text = this.f908o.getText();
        int length = text.length();
        int width = this.f908o.getWidth();
        C0368ah[] c0368ahArr = (C0368ah[]) text.getSpans(0, length, C0368ah.class);
        for (C0368ah c0368ah : c0368ahArr) {
            c0368ah.m1318a(width);
        }
        C0369ai[] c0369aiArr = (C0369ai[]) text.getSpans(0, length, C0369ai.class);
        for (C0369ai c0369ai : c0369aiArr) {
            c0369ai.m1321a(this.f908o.m1302p());
        }
        if (c0368ahArr.length > 0) {
            text.replace(0, 1, "" + text.charAt(0));
        }
    }

    /* renamed from: b */
    public void m1391b(int i) {
        this.f906m = i;
    }

    /* renamed from: b */
    public void m1393b(int i, boolean z) {
        Log.d("EditStyledText.EditorManager", "--- setItemSize");
        if (m1337N()) {
            this.f905l = i;
            return;
        }
        if (this.f901h == 2 || this.f901h == 3) {
            if (i > 0) {
                m1371h(i);
            }
            if (z) {
                m1332I();
            }
        }
    }

    /* renamed from: c */
    public void m1398c(int i, boolean z) {
        Log.d("EditStyledText.EditorManager", "--- setItemColor");
        if (m1337N()) {
            this.f904k = i;
            return;
        }
        if (this.f901h == 2 || this.f901h == 3) {
            if (i != 16777215) {
                m1373i(i);
            }
            if (z) {
                m1332I();
            }
        }
    }

    /* renamed from: a */
    public void m1388a(Layout.Alignment alignment) {
        if (this.f901h == 2 || this.f901h == 3) {
            m1356b(alignment);
            m1332I();
        }
    }

    /* renamed from: f */
    public void m1402f() {
        if (this.f901h == 2 || this.f901h == 3) {
            m1341R();
            m1332I();
        }
    }

    /* renamed from: g */
    public void m1403g() {
        if (this.f901h == 2 || this.f901h == 3) {
            m1342S();
            m1332I();
        }
    }

    /* renamed from: c */
    public void m1397c(int i) {
        if (this.f901h == 2 || this.f901h == 3) {
            m1375j(i);
            m1332I();
        }
    }

    /* renamed from: a */
    public void m1385a(int i, int i2) {
        int iM1286a;
        Log.d("EditStyledText", "--- setTextComposingMask:" + i + "," + i2);
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        if (m1408l() && this.f904k != 16777215) {
            iM1286a = this.f904k;
        } else {
            iM1286a = this.f908o.m1286a(iMin);
        }
        int iM1302p = this.f908o.m1302p();
        Log.d("EditStyledText", "--- fg:" + Integer.toHexString(iM1286a) + ",bg:" + Integer.toHexString(iM1302p) + "," + m1408l() + ",," + this.f900g);
        if (iM1286a == iM1302p) {
            int i3 = Integer.MIN_VALUE | ((iM1302p | (-16777216)) ^ (-1));
            if (this.f907n == null || this.f907n.getBackgroundColor() != i3) {
                this.f907n = new BackgroundColorSpan(i3);
            }
            this.f908o.getText().setSpan(this.f907n, iMin, iMax, 33);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m1367f(int i) {
        this.f900g = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m1369g(int i) {
        this.f901h = i;
    }

    /* renamed from: h */
    public void m1404h() {
        Log.d("EditStyledText", "--- unsetTextComposingMask");
        if (this.f907n != null) {
            this.f908o.getText().removeSpan(this.f907n);
            this.f907n = null;
        }
    }

    /* renamed from: i */
    public boolean m1405i() {
        return this.f895b;
    }

    /* renamed from: j */
    public boolean m1406j() {
        Editable text = this.f908o.getText();
        int length = text.length();
        return ((ParagraphStyle[]) text.getSpans(0, length, ParagraphStyle.class)).length > 0 || ((QuoteSpan[]) text.getSpans(0, length, QuoteSpan.class)).length > 0 || ((CharacterStyle[]) text.getSpans(0, length, CharacterStyle.class)).length > 0 || this.f906m != 16777215;
    }

    /* renamed from: k */
    public boolean m1407k() {
        return this.f896c;
    }

    /* renamed from: l */
    public boolean m1408l() {
        return this.f898e;
    }

    /* renamed from: m */
    public int m1409m() {
        return this.f906m;
    }

    /* renamed from: n */
    public int m1410n() {
        return this.f900g;
    }

    /* renamed from: o */
    public int m1411o() {
        return this.f901h;
    }

    /* renamed from: p */
    public int m1412p() {
        return this.f902i;
    }

    /* renamed from: q */
    public int m1413q() {
        return this.f903j;
    }

    /* renamed from: r */
    public int m1414r() {
        return this.f905l;
    }

    /* renamed from: s */
    public int m1415s() {
        return this.f904k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m1360c(int i, int i2) {
        this.f902i = i;
        this.f903j = i2;
    }

    /* renamed from: a */
    public void m1387a(Editable editable, int i, int i2, int i3) {
        int iM1355b;
        Log.d("EditStyledText.EditorManager", "updateSpanPrevious:" + i + "," + i2 + "," + i3);
        int i4 = i + i3;
        int iMin = Math.min(i, i4);
        int iMax = Math.max(i, i4);
        for (Object obj : editable.getSpans(iMin, iMin, Object.class)) {
            if ((obj instanceof ForegroundColorSpan) || (obj instanceof AbsoluteSizeSpan) || (obj instanceof C0369ai) || (obj instanceof AlignmentSpan)) {
                int spanStart = editable.getSpanStart(obj);
                int spanEnd = editable.getSpanEnd(obj);
                Log.d("EditStyledText.EditorManager", "spantype:" + obj.getClass() + "," + spanStart);
                if ((obj instanceof C0369ai) || (obj instanceof AlignmentSpan)) {
                    iM1355b = m1355b(this.f908o.getText(), iMax);
                } else {
                    iM1355b = this.f897d ? spanEnd : iMax;
                }
                if (spanEnd < iM1355b) {
                    Log.d("EditStyledText.EditorManager", "updateSpanPrevious: extend span");
                    editable.setSpan(obj, spanStart, iM1355b, 33);
                }
            } else if (obj instanceof C0368ah) {
                int spanStart2 = editable.getSpanStart(obj);
                int spanEnd2 = editable.getSpanEnd(obj);
                if (i2 > i3) {
                    editable.replace(spanStart2, spanEnd2, "");
                    editable.removeSpan(obj);
                } else if (spanEnd2 == i4 && i4 < editable.length() && this.f908o.getText().charAt(i4) != '\n') {
                    this.f908o.getText().insert(i4, "\n");
                }
            }
        }
    }

    /* renamed from: b */
    public void m1394b(Editable editable, int i, int i2, int i3) {
        Log.d("EditStyledText.EditorManager", "updateSpanNext:" + i + "," + i2 + "," + i3);
        int i4 = i + i3;
        int iMin = Math.min(i, i4);
        int iMax = Math.max(i, i4);
        for (Object obj : editable.getSpans(iMax, iMax, Object.class)) {
            if ((obj instanceof C0369ai) || (obj instanceof AlignmentSpan)) {
                int spanStart = editable.getSpanStart(obj);
                int spanEnd = editable.getSpanEnd(obj);
                Log.d("EditStyledText.EditorManager", "spantype:" + obj.getClass() + "," + spanEnd);
                if ((((obj instanceof C0369ai) || (obj instanceof AlignmentSpan)) ? m1343a(this.f908o.getText(), iMin) : iMin) < spanStart && i2 > i3) {
                    editable.removeSpan(obj);
                } else if (spanStart > iMin) {
                    editable.setSpan(obj, iMin, spanEnd, 33);
                }
            } else if ((obj instanceof C0368ah) && editable.getSpanStart(obj) == i4 && i4 > 0 && this.f908o.getText().charAt(i4 - 1) != '\n') {
                this.f908o.getText().insert(i4, "\n");
                this.f908o.setSelection(i4);
            }
        }
    }

    /* renamed from: t */
    public boolean m1416t() {
        return this.f911r != null && this.f911r.length() > 0 && m1344a(this.f911r).length() == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public void m1325B() {
        Log.d("EditStyledText.EditorManager", "--- handleCancel");
        this.f900g = 0;
        this.f901h = 0;
        this.f895b = false;
        this.f904k = 16777215;
        this.f905l = 0;
        this.f898e = false;
        this.f896c = false;
        this.f897d = false;
        this.f899f = false;
        m1334K();
        this.f908o.setOnClickListener(null);
        m1420x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m1326C() {
        Log.d("EditStyledText.EditorManager", "--- handleComplete:" + this.f902i + "," + this.f903j);
        if (this.f895b) {
            if (this.f902i == this.f903j) {
                Log.d("EditStyledText.EditorManager", "--- cancel handle complete:" + this.f902i);
                m1332I();
            } else {
                if (this.f901h == 2) {
                    this.f901h = 3;
                }
                this.f909p.m1461b(this.f900g);
                EditStyledText.m1270d(this.f908o, this.f908o.getText());
            }
        }
    }

    /* renamed from: a */
    private SpannableStringBuilder m1344a(SpannableStringBuilder spannableStringBuilder) {
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spannableStringBuilder);
        for (DynamicDrawableSpan dynamicDrawableSpan : (DynamicDrawableSpan[]) spannableStringBuilder2.getSpans(0, spannableStringBuilder2.length(), DynamicDrawableSpan.class)) {
            if ((dynamicDrawableSpan instanceof C0368ah) || (dynamicDrawableSpan instanceof C0370aj)) {
                spannableStringBuilder2.replace(spannableStringBuilder2.getSpanStart(dynamicDrawableSpan), spannableStringBuilder2.getSpanEnd(dynamicDrawableSpan), (CharSequence) "");
            }
        }
        return spannableStringBuilder2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: D */
    public void m1327D() {
        this.f911r = (SpannableStringBuilder) this.f908o.getText().subSequence(Math.min(m1412p(), m1413q()), Math.max(m1412p(), m1413q()));
        SpannableStringBuilder spannableStringBuilderM1344a = m1344a(this.f911r);
        ((ClipboardManager) this.f894a.getContext().getSystemService("clipboard")).setText(spannableStringBuilderM1344a);
        m1363c(spannableStringBuilderM1344a);
        m1363c(this.f911r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m1328E() {
        m1327D();
        this.f908o.getText().delete(Math.min(m1412p(), m1413q()), Math.max(m1412p(), m1413q()));
    }

    /* renamed from: b */
    private boolean m1359b(CharSequence charSequence) {
        Log.d("EditStyledText", "--- isClipBoardChanged:" + ((Object) charSequence));
        if (this.f911r == null) {
            return true;
        }
        int length = charSequence.length();
        SpannableStringBuilder spannableStringBuilderM1344a = m1344a(this.f911r);
        Log.d("EditStyledText", "--- clipBoard:" + length + "," + ((Object) spannableStringBuilderM1344a) + ((Object) charSequence));
        if (length != spannableStringBuilderM1344a.length()) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (charSequence.charAt(i) != spannableStringBuilderM1344a.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: F */
    public void m1329F() {
        int iMin = Math.min(this.f908o.getSelectionStart(), this.f908o.getSelectionEnd());
        int iMax = Math.max(this.f908o.getSelectionStart(), this.f908o.getSelectionEnd());
        Selection.setSelection(this.f908o.getText(), iMax);
        ClipboardManager clipboardManager = (ClipboardManager) this.f894a.getContext().getSystemService("clipboard");
        this.f897d = true;
        this.f908o.getText().replace(iMin, iMax, clipboardManager.getText());
        if (!m1359b(clipboardManager.getText())) {
            Log.d("EditStyledText", "--- handlePaste: startPasteImage");
            for (DynamicDrawableSpan dynamicDrawableSpan : (DynamicDrawableSpan[]) this.f911r.getSpans(0, this.f911r.length(), DynamicDrawableSpan.class)) {
                int spanStart = this.f911r.getSpanStart(dynamicDrawableSpan);
                if (dynamicDrawableSpan instanceof C0368ah) {
                    m1346a(new C0368ah(-16777216, this.f908o.getWidth(), this.f908o.getText()), spanStart + iMin);
                } else if (dynamicDrawableSpan instanceof C0370aj) {
                    m1346a(new C0370aj(this.f908o.getContext(), ((C0370aj) dynamicDrawableSpan).m1323a(), this.f908o.m1285z()), iMin + spanStart);
                }
            }
        }
    }

    /* renamed from: G */
    private void m1330G() {
        if (this.f895b) {
            this.f909p.m1458a(11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void m1331H() {
        Selection.selectAll(this.f908o.getText());
        this.f902i = this.f908o.getSelectionStart();
        this.f903j = this.f908o.getSelectionEnd();
        this.f900g = 5;
        this.f901h = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: I */
    public void m1332I() {
        m1325B();
        this.f895b = true;
        this.f908o.m1257a(this.f900g, this.f901h);
    }

    /* renamed from: J */
    private void m1333J() {
        Log.d("EditStyledText.EditorManager", "--- onSelect:" + this.f902i + "," + this.f903j);
        if (this.f902i >= 0 && this.f902i <= this.f908o.getText().length() && this.f903j >= 0 && this.f903j <= this.f908o.getText().length()) {
            if (this.f902i < this.f903j) {
                this.f908o.setSelection(this.f902i, this.f903j);
                this.f901h = 2;
                return;
            } else if (this.f902i > this.f903j) {
                this.f908o.setSelection(this.f903j, this.f902i);
                this.f901h = 2;
                return;
            } else {
                this.f901h = 1;
                return;
            }
        }
        Log.e("EditStyledText.EditorManager", "Select is on, but cursor positions are illigal.:" + this.f908o.getText().length() + "," + this.f902i + "," + this.f903j);
    }

    /* renamed from: K */
    private void m1334K() {
        Log.d("EditStyledText.EditorManager", "--- offSelect");
        EditStyledText.m1270d(this.f908o, this.f908o.getText());
        int selectionStart = this.f908o.getSelectionStart();
        this.f908o.setSelection(selectionStart, selectionStart);
        this.f901h = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m1335L() {
        Log.d("EditStyledText.EditorManager", "--- setSelectStartPos");
        this.f902i = this.f908o.getSelectionStart();
        this.f901h = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public void m1336M() {
        if (this.f908o.getSelectionEnd() == this.f902i) {
            m1400d(this.f908o.getSelectionStart());
        } else {
            m1400d(this.f908o.getSelectionEnd());
        }
    }

    /* renamed from: d */
    public void m1400d(int i) {
        Log.d("EditStyledText.EditorManager", "--- setSelectedEndPos:" + i);
        this.f903j = i;
        m1333J();
    }

    /* renamed from: N */
    private boolean m1337N() {
        Log.d("EditStyledText.EditorManager", "--- waitingNext:" + this.f902i + "," + this.f903j + "," + this.f901h);
        if (this.f902i == this.f903j && this.f901h == 3) {
            m1338O();
            return true;
        }
        m1339P();
        return false;
    }

    /* renamed from: O */
    private void m1338O() {
        Log.d("EditStyledText.EditorManager", "--- waitSelection");
        this.f898e = true;
        if (this.f902i == this.f903j) {
            this.f901h = 1;
        } else {
            this.f901h = 2;
        }
        EditStyledText.m1268c(this.f908o, this.f908o.getText());
    }

    /* renamed from: P */
    private void m1339P() {
        Log.d("EditStyledText.EditorManager", "--- resumeSelection");
        this.f898e = false;
        this.f901h = 3;
        EditStyledText.m1270d(this.f908o, this.f908o.getText());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Q */
    public boolean m1340Q() {
        return this.f901h == 2 || this.f901h == 3;
    }

    /* renamed from: a */
    private void m1352a(Object obj, int i, int i2) {
        Log.d("EditStyledText.EditorManager", "--- setStyledTextSpan:" + this.f900g + "," + i + "," + i2);
        int iMin = Math.min(i, i2);
        int iMax = Math.max(i, i2);
        this.f908o.getText().setSpan(obj, iMin, iMax, 33);
        Selection.setSelection(this.f908o.getText(), iMax);
    }

    /* renamed from: a */
    private void m1351a(Object obj) {
        int iMin = Math.min(this.f902i, this.f903j);
        int iMax = Math.max(this.f902i, this.f903j);
        int selectionStart = this.f908o.getSelectionStart();
        int iM1343a = m1343a(this.f908o.getText(), iMin);
        int iM1355b = m1355b(this.f908o.getText(), iMax);
        if (iM1343a == iM1355b) {
            this.f908o.getText().insert(iM1355b, "\n");
            m1352a(obj, iM1343a, iM1355b + 1);
        } else {
            m1352a(obj, iM1343a, iM1355b);
        }
        Selection.setSelection(this.f908o.getText(), selectionStart);
    }

    /* renamed from: h */
    private void m1371h(int i) {
        if (this.f902i != this.f903j) {
            m1352a(new AbsoluteSizeSpan(i), this.f902i, this.f903j);
        } else {
            Log.e("EditStyledText.EditorManager", "---changeSize: Size of the span is zero");
        }
    }

    /* renamed from: i */
    private void m1373i(int i) {
        if (this.f902i != this.f903j) {
            m1352a(new ForegroundColorSpan(i), this.f902i, this.f903j);
        } else {
            Log.e("EditStyledText.EditorManager", "---changeColor: Size of the span is zero");
        }
    }

    /* renamed from: b */
    private void m1356b(Layout.Alignment alignment) {
        m1351a(new AlignmentSpan.Standard(alignment));
    }

    /* renamed from: R */
    private void m1341R() {
        m1375j(1);
    }

    /* renamed from: S */
    private void m1342S() {
        m1375j(0);
    }

    /* renamed from: j */
    private void m1375j(int i) {
        Log.d("EditStyledText.EditorManager", "--- addMarquee:" + i);
        m1351a(new C0369ai(i, this.f908o.m1302p()));
    }

    /* renamed from: a */
    private void m1346a(DynamicDrawableSpan dynamicDrawableSpan, int i) {
        Log.d("EditStyledText.EditorManager", "--- insertImageSpan:");
        if (dynamicDrawableSpan != null && dynamicDrawableSpan.getDrawable() != null) {
            this.f908o.getText().insert(i, "￼");
            this.f908o.getText().setSpan(dynamicDrawableSpan, i, i + 1, 33);
            this.f908o.m1257a(this.f900g, this.f901h);
        } else {
            Log.e("EditStyledText.EditorManager", "--- insertImageSpan: null span was inserted");
            this.f908o.m1264b(5);
        }
    }

    /* renamed from: a */
    private int m1343a(Editable editable, int i) {
        int i2 = i;
        while (i2 > 0 && editable.charAt(i2 - 1) != '\n') {
            i2--;
        }
        Log.d("EditStyledText.EditorManager", "--- findLineStart:" + i + "," + editable.length() + "," + i2);
        return i2;
    }

    /* renamed from: b */
    private int m1355b(Editable editable, int i) {
        int i2 = i;
        while (true) {
            if (i2 >= editable.length()) {
                break;
            }
            if (editable.charAt(i2) != '\n') {
                i2++;
            } else {
                i2++;
                break;
            }
        }
        Log.d("EditStyledText.EditorManager", "--- findLineEnd:" + i + "," + editable.length() + "," + i2);
        return i2;
    }

    /* renamed from: c */
    private void m1363c(CharSequence charSequence) {
        if (charSequence instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence;
            int length = spannable.length();
            Log.d("EditStyledText", "--- dumpSpannableString, txt:" + ((Object) spannable) + ", len:" + length);
            for (Object obj : spannable.getSpans(0, length, Object.class)) {
                Log.d("EditStyledText", "--- dumpSpannableString, class:" + obj + "," + spannable.getSpanStart(obj) + "," + spannable.getSpanEnd(obj) + "," + spannable.getSpanFlags(obj));
            }
        }
    }

    /* renamed from: u */
    public void m1417u() {
        m1392b(this.f908o.getSelectionStart(), this.f908o.getSelectionEnd());
    }

    /* renamed from: b */
    public void m1392b(int i, int i2) {
        Log.d("EditStyledText.EditorManager", "--- showsoftkey");
        if (this.f908o.isFocused() && !m1407k()) {
            this.f910q.mNewStart = Selection.getSelectionStart(this.f908o.getText());
            this.f910q.mNewEnd = Selection.getSelectionEnd(this.f908o.getText());
            if (((InputMethodManager) this.f894a.getContext().getSystemService("input_method")).showSoftInput(this.f908o, 0, this.f910q) && this.f910q != null) {
                Selection.setSelection(this.f894a.getText(), i, i2);
            }
        }
    }

    /* renamed from: v */
    public void m1418v() {
        Log.d("EditStyledText.EditorManager", "--- hidesoftkey");
        if (this.f908o.isFocused()) {
            this.f910q.mNewStart = Selection.getSelectionStart(this.f908o.getText());
            this.f910q.mNewEnd = Selection.getSelectionEnd(this.f908o.getText());
            ((InputMethodManager) this.f908o.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f908o.getWindowToken(), 0, this.f910q);
        }
    }

    /* renamed from: w */
    public void m1419w() {
        Log.d("EditStyledText.EditorManager", "--- blockSoftKey:");
        m1418v();
        this.f896c = true;
    }

    /* renamed from: x */
    public void m1420x() {
        Log.d("EditStyledText.EditorManager", "--- unblockSoftKey:");
        this.f896c = false;
    }
}
