package com.android.p029ex.editstyledtext;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.Layout;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class EditStyledText extends EditText {

    /* renamed from: a */
    private static CharSequence f867a;

    /* renamed from: b */
    private static CharSequence f868b;

    /* renamed from: c */
    private static CharSequence f869c;

    /* renamed from: k */
    private static final NoCopySpan.Concrete f870k = new NoCopySpan.Concrete();

    /* renamed from: d */
    private float f871d;

    /* renamed from: e */
    private ArrayList<InterfaceC0365ae> f872e;

    /* renamed from: f */
    private Drawable f873f;

    /* renamed from: g */
    private C0371ak f874g;

    /* renamed from: h */
    private InputConnection f875h;

    /* renamed from: i */
    private C0374an f876i;

    /* renamed from: j */
    private C0376ap f877j;

    public EditStyledText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f871d = 0.0f;
        m1276q();
    }

    public EditStyledText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f871d = 0.0f;
        m1276q();
    }

    public EditStyledText(Context context) {
        super(context);
        this.f871d = 0.0f;
        m1276q();
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent;
        if (motionEvent.getAction() == 1) {
            cancelLongPress();
            boolean zM1298l = m1298l();
            if (!zM1298l) {
                m1288b();
            }
            int selectionStart = Selection.getSelectionStart(getText());
            int selectionEnd = Selection.getSelectionEnd(getText());
            zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (isFocused() && m1301o() == 0) {
                if (zM1298l) {
                    this.f874g.m1392b(Selection.getSelectionStart(getText()), Selection.getSelectionEnd(getText()));
                } else {
                    this.f874g.m1392b(selectionStart, selectionEnd);
                }
            }
            this.f874g.m1383a();
            this.f874g.m1404h();
        } else {
            zOnTouchEvent = super.onTouchEvent(motionEvent);
        }
        m1258a(motionEvent);
        return zOnTouchEvent;
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedStyledTextState savedStyledTextState = new SavedStyledTextState(super.onSaveInstanceState());
        savedStyledTextState.mBackgroundColor = this.f874g.m1409m();
        return savedStyledTextState;
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedStyledTextState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedStyledTextState savedStyledTextState = (SavedStyledTextState) parcelable;
        super.onRestoreInstanceState(savedStyledTextState.getSuperState());
        setBackgroundColor(savedStyledTextState.mBackgroundColor);
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f874g != null) {
            this.f874g.m1401e();
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int i) {
        boolean z = getSelectionStart() != getSelectionEnd();
        switch (i) {
            case 16776961:
                m1296j();
                return true;
            case 16776962:
                m1297k();
                return true;
            case 16776963:
                m1288b();
                return true;
            case 16776964:
                m1289c();
                return true;
            case R.id.selectAll:
                m1294h();
                return true;
            case R.id.cut:
                if (z) {
                    m1291e();
                    return true;
                }
                this.f874g.m1395b(false);
                m1291e();
                return true;
            case R.id.copy:
                if (z) {
                    m1290d();
                    return true;
                }
                this.f874g.m1395b(false);
                m1290d();
                return true;
            case R.id.paste:
                m1292f();
                return true;
            case R.id.startSelectingText:
                m1293g();
                this.f874g.m1419w();
                break;
            case R.id.stopSelectingText:
                m1295i();
                break;
        }
        return super.onTextContextMenuItem(i);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onCreateContextMenu(ContextMenu contextMenu) {
        super.onCreateContextMenu(contextMenu);
        MenuItemOnMenuItemClickListenerC0372al menuItemOnMenuItemClickListenerC0372al = new MenuItemOnMenuItemClickListenerC0372al(this);
        if (f867a != null) {
            contextMenu.add(0, 16776961, 0, f867a).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC0372al);
        }
        if (m1299m() && f868b != null) {
            contextMenu.add(0, 16776962, 0, f868b).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC0372al);
        }
        if (this.f874g.m1416t()) {
            contextMenu.add(0, R.id.paste, 0, f869c).setOnMenuItemClickListener(menuItemOnMenuItemClickListenerC0372al).setAlphabeticShortcut('v');
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f874g != null) {
            this.f874g.m1394b(getText(), i, i2, i3);
            this.f874g.m1387a(getText(), i, i2, i3);
            if (i3 > i2) {
                this.f874g.m1385a(i, i + i3);
            } else if (i2 < i3) {
                this.f874g.m1404h();
            }
            if (this.f874g.m1408l()) {
                if (i3 > i2) {
                    this.f874g.m1383a();
                    m1295i();
                } else if (i3 < i2) {
                    this.f874g.m1384a(22);
                }
            }
        }
        super.onTextChanged(charSequence, i, i2, i3);
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        this.f875h = new C0391bd(super.onCreateInputConnection(editorInfo), this);
        return this.f875h;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z) {
            m1288b();
        } else if (!m1287a()) {
            m1289c();
        }
    }

    /* renamed from: q */
    private void m1276q() {
        this.f876i = new C0374an(this, this, new C0390bc(this));
        this.f877j = new C0376ap(this);
        this.f874g = new C0371ak(this, this, this.f877j);
        setMovementMethod(new C0373am(this.f874g));
        this.f873f = getBackground();
        requestFocus();
    }

    public void setStyledTextHtmlConverter(InterfaceC0389bb interfaceC0389bb) {
        this.f876i.m1424a(interfaceC0389bb);
    }

    /* renamed from: a */
    private void m1258a(MotionEvent motionEvent) {
        if (this.f872e != null) {
            Iterator<InterfaceC0365ae> it = this.f872e.iterator();
            while (it.hasNext()) {
                it.next().m1309a(motionEvent);
            }
        }
    }

    /* renamed from: a */
    public boolean m1287a() {
        boolean zM1308a = false;
        if (this.f872e == null) {
            return false;
        }
        Iterator<InterfaceC0365ae> it = this.f872e.iterator();
        while (true) {
            boolean z = zM1308a;
            if (it.hasNext()) {
                zM1308a = it.next().m1308a() | z;
            } else {
                return z;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m1277r() {
        if (this.f872e != null) {
            Iterator<InterfaceC0365ae> it = this.f872e.iterator();
            while (it.hasNext() && !it.next().m1310b()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public void m1278s() {
        if (this.f872e != null) {
            Iterator<InterfaceC0365ae> it = this.f872e.iterator();
            while (it.hasNext()) {
                it.next().m1311c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void m1279t() {
        if (this.f872e != null) {
            Iterator<InterfaceC0365ae> it = this.f872e.iterator();
            while (it.hasNext() && !it.next().m1312d()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: u */
    public void m1280u() {
        if (this.f872e != null) {
            Iterator<InterfaceC0365ae> it = this.f872e.iterator();
            while (it.hasNext() && !it.next().m1313e()) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m1264b(int i) {
        if (this.f872e != null) {
            Iterator<InterfaceC0365ae> it = this.f872e.iterator();
            while (it.hasNext()) {
                it.next().m1306a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m1257a(int i, int i2) {
        if (this.f872e != null) {
            Iterator<InterfaceC0365ae> it = this.f872e.iterator();
            while (it.hasNext()) {
                it.next().m1307a(i, i2);
            }
        }
    }

    /* renamed from: b */
    public void m1288b() {
        this.f874g.m1384a(20);
    }

    /* renamed from: c */
    public void m1289c() {
        this.f874g.m1384a(21);
    }

    /* renamed from: d */
    public void m1290d() {
        this.f874g.m1384a(1);
    }

    /* renamed from: e */
    public void m1291e() {
        this.f874g.m1384a(7);
    }

    /* renamed from: f */
    public void m1292f() {
        this.f874g.m1384a(2);
    }

    /* renamed from: g */
    public void m1293g() {
        this.f874g.m1389a(true);
    }

    /* renamed from: h */
    public void m1294h() {
        this.f874g.m1395b(true);
    }

    /* renamed from: i */
    public void m1295i() {
        this.f874g.m1390b();
    }

    /* renamed from: j */
    public void m1296j() {
        this.f874g.m1384a(12);
    }

    /* renamed from: k */
    public void m1297k() {
        this.f874g.m1396c();
    }

    /* renamed from: v */
    private void m1281v() {
        this.f874g.m1401e();
    }

    public void setItemSize(int i) {
        this.f874g.m1393b(i, true);
    }

    public void setItemColor(int i) {
        this.f874g.m1398c(i, true);
    }

    public void setAlignment(Layout.Alignment alignment) {
        this.f874g.m1388a(alignment);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (i != 16777215) {
            super.setBackgroundColor(i);
        } else {
            setBackgroundDrawable(this.f873f);
        }
        this.f874g.m1391b(i);
        m1281v();
    }

    public void setMarquee(int i) {
        this.f874g.m1397c(i);
    }

    public void setHtml(String str) {
        this.f876i.m1425a(str);
    }

    public void setBuilder(AlertDialog.Builder builder) {
        this.f877j.m1446a(builder);
    }

    public void setColorAlertParams(CharSequence charSequence, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, CharSequence charSequence2) {
        this.f877j.m1448a(charSequence, charSequenceArr, charSequenceArr2, charSequence2);
    }

    public void setSizeAlertParams(CharSequence charSequence, CharSequence[] charSequenceArr, CharSequence[] charSequenceArr2, CharSequence[] charSequenceArr3) {
        this.f877j.m1449a(charSequence, charSequenceArr, charSequenceArr2, charSequenceArr3);
    }

    public void setAlignAlertParams(CharSequence charSequence, CharSequence[] charSequenceArr) {
        this.f877j.m1447a(charSequence, charSequenceArr);
    }

    public void setMarqueeAlertParams(CharSequence charSequence, CharSequence[] charSequenceArr) {
        this.f877j.m1450b(charSequence, charSequenceArr);
    }

    public void setContextMenuStrings(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        f867a = charSequence;
        f868b = charSequence2;
        f869c = charSequence3;
    }

    /* renamed from: l */
    public boolean m1298l() {
        return this.f874g.m1405i();
    }

    /* renamed from: m */
    public boolean m1299m() {
        return this.f874g.m1406j();
    }

    /* renamed from: n */
    public boolean m1300n() {
        return this.f874g.m1407k();
    }

    /* renamed from: o */
    public int m1301o() {
        return this.f874g.m1411o();
    }

    /* renamed from: p */
    public int m1302p() {
        return this.f874g.m1409m();
    }

    /* renamed from: a */
    public int m1286a(int i) {
        if (i < 0 || i > getText().length()) {
            return -16777216;
        }
        ForegroundColorSpan[] foregroundColorSpanArr = (ForegroundColorSpan[]) getText().getSpans(i, i, ForegroundColorSpan.class);
        if (foregroundColorSpanArr.length > 0) {
            return foregroundColorSpanArr[0].getForegroundColor();
        }
        return -16777216;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m1282w() {
        if (this.f875h != null && !this.f874g.f899f) {
            this.f875h.finishComposingText();
            this.f874g.f899f = true;
        }
    }

    /* renamed from: x */
    private float m1283x() {
        if (this.f871d <= 0.0f) {
            this.f871d = getContext().getResources().getDisplayMetrics().density;
        }
        return this.f871d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m1266c(int i) {
        if (this.f871d <= 0.0f) {
            this.f871d = getContext().getResources().getDisplayMetrics().density;
        }
        return (int) ((i * m1283x()) + 0.5d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: y */
    public int m1284y() {
        return 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public int m1285z() {
        return m1266c(300);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m1268c(View view, Spannable spannable) {
        spannable.setSpan(f870k, 0, 0, 16777233);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m1270d(View view, Spannable spannable) {
        spannable.removeSpan(f870k);
    }

    class SoftKeyReceiver extends ResultReceiver {
        EditStyledText mEST;
        int mNewEnd;
        int mNewStart;

        SoftKeyReceiver(EditStyledText editStyledText) {
            super(editStyledText.getHandler());
            this.mEST = editStyledText;
        }

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i, Bundle bundle) {
            if (i != 2) {
                Selection.setSelection(this.mEST.getText(), this.mNewStart, this.mNewEnd);
            }
        }
    }

    public class SavedStyledTextState extends View.BaseSavedState {
        public int mBackgroundColor;

        SavedStyledTextState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.mBackgroundColor);
        }

        public String toString() {
            return "EditStyledText.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " bgcolor=" + this.mBackgroundColor + "}";
        }
    }
}
