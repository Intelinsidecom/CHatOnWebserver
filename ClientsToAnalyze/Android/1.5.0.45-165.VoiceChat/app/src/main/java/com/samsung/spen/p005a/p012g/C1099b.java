package com.samsung.spen.p005a.p012g;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.spen.lib.input.SPenEvent;
import com.samsung.spen.lib.input.SPenEventLibrary;
import com.samsung.spen.lib.input.SPenLibrary;
import com.samsung.spen.lib.input.core.SPenDetachmentReceiver;
import com.samsung.spen.p005a.p007b.InterfaceC1077e;
import com.samsung.spen.p005a.p009d.InterfaceC1091i;
import com.samsung.spen.settings.SettingFillingInfo;
import com.samsung.spen.settings.SettingStrokeInfo;
import com.samsung.spen.settings.SettingTextInfo;
import com.samsung.spensdk.applistener.SPenHoverListener;
import com.samsung.spensdk.applistener.SPenTouchListener;
import com.samsung.spensdk.applistener.SettingFillingChangeListener;
import com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener;
import com.samsung.spensdk.applistener.SettingStrokeChangeListener;
import com.samsung.spensdk.applistener.SettingTextChangeListener;
import com.samsung.spensdk.applistener.SettingViewShowListener;
import java.util.HashMap;

/* renamed from: com.samsung.spen.a.g.b */
/* loaded from: classes.dex */
public class C1099b implements InterfaceC1098a {

    /* renamed from: c */
    private Context f2000c;

    /* renamed from: d */
    private ViewGroup f2001d;

    /* renamed from: e */
    private HashMap<String, Integer> f2002e;

    /* renamed from: f */
    private HashMap<String, String> f2003f;

    /* renamed from: g */
    private boolean f2004g;

    /* renamed from: k */
    private ViewGroup f2008k;

    /* renamed from: h */
    private SPenTouchListener f2005h = null;

    /* renamed from: i */
    private SPenHoverListener f2006i = null;

    /* renamed from: j */
    private View.OnTouchListener f2007j = null;

    /* renamed from: l */
    private boolean f2009l = false;

    /* renamed from: a */
    SettingPresetDeleteBtnClickListener f1998a = null;

    /* renamed from: b */
    SPenDetachmentReceiver f1999b = null;

    /* renamed from: m */
    private InterfaceC1091i f2010m = new InterfaceC1091i() { // from class: com.samsung.spen.a.g.b.1
        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onSetSettingView(ViewGroup viewGroup) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onCreateSettingView(Context context, HashMap<String, Integer> map, HashMap<String, String> map2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public ViewGroup onGetSettingView() {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onIsSettingViewVisible(int i) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onShowSettingView(int i, boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public int onGetSettingViewSizeOption(int i) {
            return 0;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onSetSettingViewSizeOption(int i, int i2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onCloseSettingView() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public SettingStrokeInfo onGetSettingViewStrokeInfo() {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onSetSettingViewStrokeInfo(SettingStrokeInfo settingStrokeInfo) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public SettingTextInfo onGetSettingViewTextInfo() {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onSetSettingViewTextInfo(SettingTextInfo settingTextInfo) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public SettingFillingInfo onGetSettingViewFillingInfo() {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onSetSettingViewFillingInfo(SettingFillingInfo settingFillingInfo) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public int onGetSettingViewPresetNum() {
            return 0;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public SettingStrokeInfo onGetSettingViewPresetInfo(int i) {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onDeleteSettingViewPresetInfo(int i, boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onSetSettingViewPresetCustomDelete(boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onSetDeleteAllPopupVisible(boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onGetDeleteAllPopupVisible() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onHideIME() {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onSetTextIMEOptionFlagNoExtractUI(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onReadyToFileLoad() {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onDispose() {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onSetOnSCanvasLayoutSettingViewListener(SettingViewShowListener settingViewShowListener) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onSetOnSCanvasLayoutPenEraserSettingListener(SettingStrokeChangeListener settingStrokeChangeListener) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onSetOnSCanvasLayoutTextSettingListener(SettingTextChangeListener settingTextChangeListener) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onSetOnSCanvasLayoutFillingSettingListener(SettingFillingChangeListener settingFillingChangeListener) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onSetOnHoverListener(Object obj) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onSetOnTouchListener(Object obj) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onSetTextBoxDefaultSize(int i, int i2) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onIsDeleteSettingViewDefaultDescription() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public boolean onDeleteSettingViewDefaultDescription() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
        public void onSetOnSettingViewPresetDeleteBtnClickListener(SettingPresetDeleteBtnClickListener settingPresetDeleteBtnClickListener) {
        }
    };

    /* renamed from: n */
    private InterfaceC1077e f2011n = new InterfaceC1077e() { // from class: com.samsung.spen.a.g.b.2
    };

    public C1099b(Context context, ViewGroup viewGroup, HashMap<String, Integer> map, HashMap<String, String> map2, ViewGroup viewGroup2, boolean z) {
        this.f2001d = null;
        this.f2002e = new HashMap<>();
        this.f2003f = new HashMap<>();
        this.f2004g = true;
        this.f2008k = null;
        this.f2000c = context;
        this.f2002e = map;
        this.f2003f = map2;
        this.f2001d = viewGroup;
        this.f2008k = viewGroup2;
        this.f2004g = z;
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public boolean mo1947a() {
        if (this.f2001d != null) {
            if (this.f2008k == null) {
                if (this.f2010m.onCreateSettingView(this.f2000c, this.f2002e, this.f2003f)) {
                    this.f2008k = this.f2010m.onGetSettingView();
                }
            } else {
                this.f2010m.onSetSettingView(this.f2008k);
            }
            if (this.f2004g) {
                mo1949a(2, 0);
            } else {
                mo1949a(2, 1);
            }
            if (!m1975a(this.f2001d, this.f2008k)) {
                this.f2001d.addView(this.f2008k);
            }
        }
        if (this.f2008k != null) {
            this.f2010m.onSetSettingView(this.f2008k);
        }
        if (this.f2009l) {
            this.f2010m.onDeleteSettingViewDefaultDescription();
        }
        return true;
    }

    /* renamed from: a */
    boolean m1975a(ViewGroup viewGroup, View view) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (viewGroup.getChildAt(i).equals(view)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public boolean mo1948a(int i) {
        if (m1974d(i)) {
            return this.f2010m.onIsSettingViewVisible(i);
        }
        return false;
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public boolean mo1950a(int i, boolean z) {
        if (m1974d(i)) {
            return this.f2010m.onShowSettingView(i, z);
        }
        return false;
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: b */
    public int mo1955b(int i) {
        if (m1974d(i)) {
            return this.f2010m.onGetSettingViewSizeOption(i);
        }
        return -1;
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public boolean mo1949a(int i, int i2) {
        if (m1974d(i)) {
            return this.f2010m.onSetSettingViewSizeOption(i, i2);
        }
        return false;
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: b */
    public boolean mo1958b() {
        return this.f2010m.onCloseSettingView();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: d */
    public SettingStrokeInfo mo1963d() {
        return this.f2010m.onGetSettingViewStrokeInfo();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public boolean mo1952a(SettingStrokeInfo settingStrokeInfo) {
        return this.f2010m.onSetSettingViewStrokeInfo(settingStrokeInfo);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: e */
    public SettingTextInfo mo1964e() {
        return this.f2010m.onGetSettingViewTextInfo();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public boolean mo1953a(SettingTextInfo settingTextInfo) {
        return this.f2010m.onSetSettingViewTextInfo(settingTextInfo);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: f */
    public SettingFillingInfo mo1965f() {
        return this.f2010m.onGetSettingViewFillingInfo();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public boolean mo1951a(SettingFillingInfo settingFillingInfo) {
        return this.f2010m.onSetSettingViewFillingInfo(settingFillingInfo);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: k */
    public int mo1970k() {
        return this.f2010m.onGetSettingViewPresetNum();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: c */
    public SettingStrokeInfo mo1960c(int i) {
        return this.f2010m.onGetSettingViewPresetInfo(i);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: b */
    public boolean mo1959b(int i, boolean z) {
        return this.f2010m.onDeleteSettingViewPresetInfo(i, z);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: c */
    public boolean mo1962c(boolean z) {
        return this.f2010m.onSetSettingViewPresetCustomDelete(z);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: l */
    public boolean mo1971l() {
        return this.f2010m.onIsDeleteSettingViewDefaultDescription();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public boolean mo1954a(boolean z) {
        return this.f2010m.onSetDeleteAllPopupVisible(z);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: g */
    public boolean mo1966g() {
        return this.f2010m.onGetDeleteAllPopupVisible();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: h */
    public void mo1967h() {
        this.f2010m.onHideIME();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: b */
    public void mo1957b(boolean z) {
        this.f2010m.onSetTextIMEOptionFlagNoExtractUI(z);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: i */
    public void mo1968i() {
        this.f2010m.onReadyToFileLoad();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: j */
    public void mo1969j() {
        this.f2010m.onDispose();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: b */
    public void mo1956b(int i, int i2) {
        this.f2010m.onSetTextBoxDefaultSize(i, i2);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public void mo1946a(SettingViewShowListener settingViewShowListener) {
        this.f2010m.onSetOnSCanvasLayoutSettingViewListener(settingViewShowListener);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public void mo1944a(SettingStrokeChangeListener settingStrokeChangeListener) {
        this.f2010m.onSetOnSCanvasLayoutPenEraserSettingListener(settingStrokeChangeListener);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public void mo1945a(SettingTextChangeListener settingTextChangeListener) {
        this.f2010m.onSetOnSCanvasLayoutTextSettingListener(settingTextChangeListener);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public void mo1942a(SettingFillingChangeListener settingFillingChangeListener) {
        this.f2010m.onSetOnSCanvasLayoutFillingSettingListener(settingFillingChangeListener);
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public void mo1943a(SettingPresetDeleteBtnClickListener settingPresetDeleteBtnClickListener) {
        this.f1998a = settingPresetDeleteBtnClickListener;
        if (this.f1998a != null) {
            this.f2010m.onSetOnSettingViewPresetDeleteBtnClickListener(new SettingPresetDeleteBtnClickListener() { // from class: com.samsung.spen.a.g.b.3
                @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
                public void onClick(int i) {
                    if (C1099b.this.f1998a != null) {
                        C1099b.this.f1998a.onClick(i);
                    }
                }
            });
        } else {
            this.f2010m.onSetOnSettingViewPresetDeleteBtnClickListener(settingPresetDeleteBtnClickListener);
        }
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public void mo1941a(SPenTouchListener sPenTouchListener) {
        this.f2005h = sPenTouchListener;
        this.f2007j = null;
        m1976m();
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public void mo1937a(View.OnTouchListener onTouchListener) {
        this.f2007j = onTouchListener;
        this.f2005h = null;
        m1976m();
    }

    /* renamed from: m */
    void m1976m() {
        if (this.f2005h != null) {
            this.f2010m.onSetOnTouchListener(new View.OnTouchListener() { // from class: com.samsung.spen.a.g.b.4

                /* renamed from: a */
                public boolean f2015a = false;

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean zOnTouchPenEraser = false;
                    if (C1099b.this.f2005h != null) {
                        SPenEvent event = SPenLibrary.getEvent(motionEvent);
                        if (event.isFinger()) {
                            zOnTouchPenEraser = C1099b.this.f2005h.onTouchFinger(view, motionEvent);
                        } else if (event.isPen()) {
                            zOnTouchPenEraser = C1099b.this.f2005h.onTouchPen(view, motionEvent);
                        } else if (event.isEraserPen()) {
                            zOnTouchPenEraser = C1099b.this.f2005h.onTouchPenEraser(view, motionEvent);
                        }
                        boolean zIsSideButtonPressed = event.isSideButtonPressed();
                        if (!this.f2015a && zIsSideButtonPressed) {
                            C1099b.this.f2005h.onTouchButtonDown(view, motionEvent);
                        } else if (this.f2015a && !zIsSideButtonPressed) {
                            C1099b.this.f2005h.onTouchButtonUp(view, motionEvent);
                        }
                        this.f2015a = zIsSideButtonPressed;
                    }
                    return zOnTouchPenEraser;
                }
            });
        } else if (this.f2007j != null) {
            this.f2010m.onSetOnTouchListener(this.f2007j);
        } else {
            this.f2010m.onSetOnTouchListener(null);
        }
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public void mo1940a(SPenHoverListener sPenHoverListener) {
        if (!SPenEventLibrary.isHoverListenerSupport()) {
            Log.e("LayoutManager", "S Pen Hover Listener cannot be supported under android ICS");
        } else {
            this.f2006i = sPenHoverListener;
            m1977n();
        }
    }

    /* renamed from: n */
    void m1977n() {
        if (SPenEventLibrary.isHoverListenerSupport()) {
            if (this.f2006i != null) {
                this.f2010m.onSetOnHoverListener(new View.OnHoverListener() { // from class: com.samsung.spen.a.g.b.5

                    /* renamed from: a */
                    public int f2017a = 0;

                    @Override // android.view.View.OnHoverListener
                    public boolean onHover(View view, MotionEvent motionEvent) {
                        if (C1099b.this.f2006i != null) {
                            boolean zOnHover = C1099b.this.f2006i.onHover(view, motionEvent);
                            int buttonState = motionEvent.getButtonState();
                            if (this.f2017a == 0 && buttonState == 2) {
                                C1099b.this.f2006i.onHoverButtonDown(view, motionEvent);
                            } else if (this.f2017a == 2 && buttonState == 0) {
                                C1099b.this.f2006i.onHoverButtonUp(view, motionEvent);
                            }
                            this.f2017a = buttonState;
                            return zOnHover;
                        }
                        return view.onHoverEvent(motionEvent);
                    }
                });
            } else {
                this.f2010m.onSetOnHoverListener(null);
            }
        }
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public void mo1939a(InterfaceC1091i interfaceC1091i) {
        this.f2010m = interfaceC1091i;
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: a */
    public void mo1938a(InterfaceC1077e interfaceC1077e) {
        this.f2011n = interfaceC1077e;
    }

    /* renamed from: d */
    public static boolean m1974d(int i) {
        return i == 1 || i == 2 || i == 3 || i == 4;
    }

    @Override // com.samsung.spen.p005a.p012g.InterfaceC1098a
    /* renamed from: c */
    public boolean mo1961c() {
        this.f2009l = true;
        return true;
    }
}
