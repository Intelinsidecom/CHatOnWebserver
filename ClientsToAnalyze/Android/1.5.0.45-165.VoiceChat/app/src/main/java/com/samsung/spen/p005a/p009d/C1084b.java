package com.samsung.spen.p005a.p009d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.samm.common.SObject;
import com.samsung.samm.common.SObjectStroke;
import com.samsung.sdraw.AbstractSettingView;
import com.samsung.sdraw.CanvasView;
import com.samsung.sdraw.FillColorInfo;
import com.samsung.sdraw.FillingSettingInfo;
import com.samsung.sdraw.ImageInfo;
import com.samsung.sdraw.ObjectInfo;
import com.samsung.sdraw.PenSettingInfo;
import com.samsung.sdraw.SettingView;
import com.samsung.sdraw.StrokeInfo;
import com.samsung.sdraw.TextInfo;
import com.samsung.sdraw.TextSettingInfo;
import com.samsung.spen.engine.signature.InterfaceC1101b;
import com.samsung.spen.p005a.p011f.InterfaceC1094a;
import com.samsung.spen.p005a.p011f.InterfaceC1095b;
import com.samsung.spen.p005a.p012g.C1099b;
import com.samsung.spen.settings.SettingFillingInfo;
import com.samsung.spen.settings.SettingStrokeInfo;
import com.samsung.spen.settings.SettingTextInfo;
import com.samsung.spensdk.applistener.ColorPickerColorChangeListener;
import com.samsung.spensdk.applistener.HistoryUpdateListener;
import com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener;
import com.samsung.spensdk.applistener.SCanvasInitializeListener;
import com.samsung.spensdk.applistener.SCanvasLongPressListener;
import com.samsung.spensdk.applistener.SCanvasMatrixChangeListener;
import com.samsung.spensdk.applistener.SCanvasModeChangedListener;
import com.samsung.spensdk.applistener.SObjectSelectListener;
import com.samsung.spensdk.applistener.SObjectUpdateListener;
import com.samsung.spensdk.applistener.SPenTouchIDListener;
import com.samsung.spensdk.applistener.SettingFillingChangeListener;
import com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener;
import com.samsung.spensdk.applistener.SettingStrokeChangeListener;
import com.samsung.spensdk.applistener.SettingTextChangeListener;
import com.samsung.spensdk.applistener.SettingViewShowListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.samsung.spen.a.d.b */
/* loaded from: classes.dex */
public class C1084b extends CanvasView implements InterfaceC1085c {
    public static final String TAG = "CanvasViewWrapper";

    /* renamed from: A */
    private SettingTextChangeListener f1904A;

    /* renamed from: B */
    private SettingFillingChangeListener f1905B;

    /* renamed from: C */
    private SettingPresetDeleteBtnClickListener f1906C;

    /* renamed from: D */
    private SPenTouchIDListener f1907D;

    /* renamed from: E */
    private InterfaceC1095b f1908E;

    /* renamed from: F */
    private InterfaceC1101b f1909F;

    /* renamed from: a */
    CanvasView.OnSettingViewShowListener f1910a;

    /* renamed from: b */
    AbstractSettingView.OnPresetDelBtnOnClickListener f1911b;

    /* renamed from: c */
    CanvasView.OnObjectListener f1912c;

    /* renamed from: d */
    AbstractSettingView.OnSettingChangedListener f1913d;

    /* renamed from: e */
    private boolean f1914e;

    /* renamed from: f */
    private boolean f1915f;

    /* renamed from: g */
    private SettingView f1916g;

    /* renamed from: h */
    private CanvasView.OnInitializeFinishListener f1917h;

    /* renamed from: i */
    private CanvasView.OnCanvasMatrixChangeListener f1918i;

    /* renamed from: j */
    private CanvasView.OnModeChangedListener f1919j;

    /* renamed from: k */
    private AbstractSettingView.OnDeleteAllConfirmListener f1920k;

    /* renamed from: l */
    private CanvasView.OnLongPressListener f1921l;

    /* renamed from: m */
    private CanvasView.OnDropperColorChangeListener f1922m;

    /* renamed from: n */
    private CanvasView.OnHistoryChangeListener f1923n;

    /* renamed from: o */
    private CanvasView.OnDrawingInformationListener f1924o;

    /* renamed from: p */
    private SCanvasInitializeListener f1925p;

    /* renamed from: q */
    private SCanvasMatrixChangeListener f1926q;

    /* renamed from: r */
    private SCanvasModeChangedListener f1927r;

    /* renamed from: s */
    private SCanvasDeleteAllConfirmListener f1928s;

    /* renamed from: t */
    private SObjectUpdateListener f1929t;

    /* renamed from: u */
    private SObjectSelectListener f1930u;

    /* renamed from: v */
    private ColorPickerColorChangeListener f1931v;

    /* renamed from: w */
    private HistoryUpdateListener f1932w;

    /* renamed from: x */
    private SCanvasLongPressListener f1933x;

    /* renamed from: y */
    private SettingViewShowListener f1934y;

    /* renamed from: z */
    private SettingStrokeChangeListener f1935z;

    public C1084b(Context context) {
        super(context);
        this.f1914e = true;
        this.f1915f = true;
        this.f1916g = null;
        this.f1917h = new CanvasView.OnInitializeFinishListener() { // from class: com.samsung.spen.a.d.b.1
            @Override // com.samsung.sdraw.CanvasView.OnInitializeFinishListener
            public void onFinish() {
                if (C1084b.this.f1925p == null) {
                    return;
                }
                C1084b.this.f1925p.onInitialized();
            }
        };
        this.f1918i = new CanvasView.OnCanvasMatrixChangeListener() { // from class: com.samsung.spen.a.d.b.12
            @Override // com.samsung.sdraw.CanvasView.OnCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
                if (C1084b.this.f1926q == null) {
                    return;
                }
                C1084b.this.f1926q.onMatrixChanged(matrix);
            }

            @Override // com.samsung.sdraw.CanvasView.OnCanvasMatrixChangeListener
            public void onMatrixChangeEnd() {
                if (C1084b.this.f1926q == null) {
                    return;
                }
                C1084b.this.f1926q.onMatrixChangeFinished();
            }
        };
        this.f1919j = new CanvasView.OnModeChangedListener() { // from class: com.samsung.spen.a.d.b.22
            @Override // com.samsung.sdraw.CanvasView.OnModeChangedListener
            public void onModeChanged(int i) {
                if (C1084b.this.f1927r != null) {
                    C1084b.this.f1927r.onModeChanged(C1083a.m1813b(i));
                }
            }
        };
        this.f1920k = new AbstractSettingView.OnDeleteAllConfirmListener() { // from class: com.samsung.spen.a.d.b.23
            @Override // com.samsung.sdraw.AbstractSettingView.OnDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i) {
                if (C1084b.this.f1928s != null) {
                    return C1084b.this.f1928s.onDeleteAllConfirm(i);
                }
                return false;
            }
        };
        this.f1910a = new CanvasView.OnSettingViewShowListener() { // from class: com.samsung.spen.a.d.b.24
            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onPenSettingViewShow(boolean z) {
                Log.i(C1084b.TAG, "PenSettingViewShow : " + z);
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onPenSettingViewShow(z);
            }

            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onEraserSettingViewShow(boolean z) {
                Log.i(C1084b.TAG, "EraserSettingViewShow : " + z);
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onEraserSettingViewShow(z);
            }

            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onTextSettingViewShow(boolean z) {
                Log.i(C1084b.TAG, "TextSettingViewShow : " + z);
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onTextSettingViewShow(z);
            }

            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onFillingSettingViewShow(boolean z) {
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onFillingSettingViewShow(z);
            }
        };
        this.f1911b = new AbstractSettingView.OnPresetDelBtnOnClickListener() { // from class: com.samsung.spen.a.d.b.25
            @Override // com.samsung.sdraw.AbstractSettingView.OnPresetDelBtnOnClickListener
            public void onClick(int i) {
                if (C1084b.this.f1906C == null) {
                    return;
                }
                C1084b.this.f1906C.onClick(i);
            }
        };
        this.f1921l = new CanvasView.OnLongPressListener() { // from class: com.samsung.spen.a.d.b.26
            @Override // com.samsung.sdraw.CanvasView.OnLongPressListener
            public void onLongPress(float f, float f2) {
                if (C1084b.this.f1933x == null) {
                    return;
                }
                C1084b.this.f1933x.onLongPressed(f, f2);
            }

            @Override // com.samsung.sdraw.CanvasView.OnLongPressListener
            public void onLongPress() {
                if (C1084b.this.f1933x == null) {
                    return;
                }
                C1084b.this.f1933x.onLongPressed();
            }
        };
        this.f1922m = new CanvasView.OnDropperColorChangeListener() { // from class: com.samsung.spen.a.d.b.27
            @Override // com.samsung.sdraw.CanvasView.OnDropperColorChangeListener
            public void onDropperColorChanged(int i) {
                if (C1084b.this.f1931v == null) {
                    return;
                }
                C1084b.this.f1931v.onColorPickerColorChanged(i);
            }
        };
        this.f1923n = new CanvasView.OnHistoryChangeListener() { // from class: com.samsung.spen.a.d.b.28
            @Override // com.samsung.sdraw.CanvasView.OnHistoryChangeListener
            public void onHistoryChanged(boolean z, boolean z2) {
                if (C1084b.this.f1932w == null) {
                    return;
                }
                C1084b.this.f1932w.onHistoryChanged(z, z2);
            }
        };
        this.f1912c = new CanvasView.OnObjectListener() { // from class: com.samsung.spen.a.d.b.2
            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectInserted(ObjectInfo objectInfo, boolean z, boolean z2) {
                SObject sObjectMo1850a;
                int iMo1854b;
                if (C1084b.this.f1909F != null && (objectInfo instanceof StrokeInfo)) {
                    StrokeInfo strokeInfo = (StrokeInfo) objectInfo;
                    C1084b.this.f1909F.mo1986b(strokeInfo.points, strokeInfo.event_time);
                }
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        sObjectMo1850a = C1083a.m1804a(objectInfo);
                        if (sObjectMo1850a == null) {
                            Log.e(C1084b.TAG, "Fail to create SObject");
                            return;
                        }
                        if (layerID == 0) {
                            iMo1854b = C1084b.this.f1908E.mo1848a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID(), sObjectMo1850a);
                        } else if (layerID != 1) {
                            return;
                        } else {
                            iMo1854b = C1084b.this.f1908E.mo1854b(sObjectMo1850a);
                        }
                        if (iMo1854b >= 0) {
                            objectInfo.setID(iMo1854b);
                        } else {
                            return;
                        }
                    } else {
                        if (layerID == 0) {
                            sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                            if (sObjectMo1850a == null) {
                                Log.e(C1084b.TAG, "Fail to get SObject");
                                return;
                            }
                        } else {
                            if (layerID != 1) {
                                return;
                            }
                            sObjectMo1850a = C1084b.this.f1908E.mo1850a(id);
                            if (sObjectMo1850a == null) {
                                Log.e(C1084b.TAG, "Fail to get SObject");
                                return;
                            }
                        }
                        if (!z || z2) {
                            if (z || !z2) {
                                if (z || z2) {
                                    Log.e(C1084b.TAG, "Unexpected Insert.");
                                    return;
                                }
                                C1084b.this.f1908E.mo1856b(sObjectMo1850a, true);
                            } else {
                                C1084b.this.f1908E.mo1856b(sObjectMo1850a, true);
                            }
                        } else {
                            C1084b.this.f1908E.mo1856b(sObjectMo1850a, true);
                        }
                    }
                    if (C1084b.this.f1929t == null) {
                        return;
                    }
                    C1084b.this.f1929t.onSObjectInserted(sObjectMo1850a, z, z2);
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectDeleted(ObjectInfo objectInfo, boolean z, boolean z2, boolean z3) {
                SObject sObjectMo1850a;
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        Log.e(C1084b.TAG, "Unknown object deleted");
                        return;
                    }
                    if (layerID != 0) {
                        if (layerID != 1 || (sObjectMo1850a = C1084b.this.f1908E.mo1850a(id)) == null) {
                            return;
                        }
                    } else {
                        sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                        if (sObjectMo1850a == null) {
                            return;
                        }
                    }
                    if (!z || z2) {
                        if (z || !z2) {
                            if (z || z2) {
                                Log.e(C1084b.TAG, "Unexpected Insert.");
                                return;
                            }
                            C1084b.this.f1908E.mo1856b(sObjectMo1850a, false);
                        } else {
                            C1084b.this.f1908E.mo1856b(sObjectMo1850a, false);
                        }
                    } else {
                        C1084b.this.f1908E.mo1856b(sObjectMo1850a, false);
                    }
                    if (z3 && !C1084b.this.f1908E.mo1858c(sObjectMo1850a)) {
                        Log.e(C1084b.TAG, "Fail to Delete SObject List");
                    } else {
                        if (C1084b.this.f1929t == null) {
                            return;
                        }
                        C1084b.this.f1929t.onSObjectDeleted(sObjectMo1850a, z, z2, z3);
                    }
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectChanged(ObjectInfo objectInfo, boolean z, boolean z2) {
                SObject sObjectMo1850a;
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        Log.e(C1084b.TAG, "Unknown object changed");
                        return;
                    }
                    if (layerID == 0) {
                        sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                        if (sObjectMo1850a == null) {
                            return;
                        }
                    } else {
                        if (layerID != 1) {
                            return;
                        }
                        sObjectMo1850a = C1084b.this.f1908E.mo1850a(id);
                        if (sObjectMo1850a == null) {
                            Log.e(C1084b.TAG, "Fail to get SObject");
                            return;
                        }
                    }
                    if (!C1083a.m1810a(objectInfo, sObjectMo1850a)) {
                        Log.e(C1084b.TAG, "Fail to Update SObject List");
                    } else {
                        if (C1084b.this.f1929t == null) {
                            return;
                        }
                        C1084b.this.f1929t.onSObjectChanged(sObjectMo1850a, z, z2);
                    }
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectSelected(ObjectInfo objectInfo, boolean z) {
                SObject sObjectMo1850a;
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        Log.e(C1084b.TAG, "Unknown object selected");
                        return;
                    }
                    if (layerID != 0) {
                        if (layerID != 1 || (sObjectMo1850a = C1084b.this.f1908E.mo1850a(id)) == null) {
                            return;
                        }
                    } else {
                        sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                        if (sObjectMo1850a == null) {
                            return;
                        }
                    }
                    SObject sObjectMo1852a = C1084b.this.f1908E.mo1852a(sObjectMo1850a, z);
                    if (sObjectMo1852a == null) {
                        Log.e(C1084b.TAG, "Fail to Update SObject List");
                    }
                    if (C1084b.this.f1929t != null) {
                        C1084b.this.f1929t.onSObjectSelected(sObjectMo1852a, z);
                    }
                    if (C1084b.this.f1930u == null) {
                        return;
                    }
                    C1084b.this.f1930u.onSObjectSelected(sObjectMo1852a, z);
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectDeletedAll(boolean z, int i) {
                int i2 = 0;
                if (i != 0 && i == 1) {
                    i2 = 1;
                }
                if (z) {
                    C1084b.this.f1908E.mo1857c(i2);
                } else {
                    C1084b.this.f1908E.mo1859d(i2);
                }
                if (C1084b.this.f1929t == null) {
                    return;
                }
                C1084b.this.f1929t.onSObjectDeletedAll(z, i2);
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public boolean onStrokeInserting(StrokeInfo strokeInfo) {
                if (C1084b.this.f1915f && C1084b.this.f1908E != null && C1084b.this.f1914e) {
                    SObject sObjectM1804a = C1083a.m1804a(strokeInfo);
                    if (sObjectM1804a == null) {
                        Log.e(C1084b.TAG, "Fail to create SObject");
                        return false;
                    }
                    if ((sObjectM1804a instanceof SObjectStroke) && C1084b.this.f1929t != null) {
                        return C1084b.this.f1929t.onSObjectStrokeInserting((SObjectStroke) sObjectM1804a);
                    }
                    return false;
                }
                return false;
            }
        };
        this.f1913d = new AbstractSettingView.OnSettingChangedListener() { // from class: com.samsung.spen.a.d.b.3
            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onDeleteAll(boolean z) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onDeleteAll(z);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onClearAll(boolean z) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onClearAll(z);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onEraserWidthChanged(int i) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onEraserWidthChanged(i);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenAlphaChanged(int i) {
                PenSettingInfo penSettingViewInfo;
                if (C1084b.this.f1935z != null && (penSettingViewInfo = C1084b.this.getPenSettingViewInfo()) != null) {
                    int penColor = penSettingViewInfo.getPenColor();
                    int penAlpha = penSettingViewInfo.getPenAlpha();
                    C1084b.this.f1935z.onStrokeAlphaChanged(penAlpha);
                    C1084b.this.f1935z.onStrokeColorChanged(penColor | (penAlpha << 24));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenTypeChanged(int i) {
                if (C1084b.this.f1935z != null) {
                    C1084b.this.f1935z.onStrokeStyleChanged(C1083a.m1818g(i));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenWidthChanged(int i) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onStrokeWidthChanged(i);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenColorChanged(int i) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onStrokeColorChanged(i);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextColorChanged(int i) {
                if (C1084b.this.f1904A == null) {
                    return;
                }
                C1084b.this.f1904A.onTextColorChanged(i);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextFontChanged(String str) {
                if (C1084b.this.f1904A == null) {
                    return;
                }
                C1084b.this.f1904A.onTextFontChanged(str);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextSizeChanged(int i) {
                if (C1084b.this.f1904A == null) {
                    return;
                }
                C1084b.this.f1904A.onTextSizeChanged(i);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextTypeChanged(int i) {
                if (C1084b.this.f1904A != null) {
                    C1084b.this.f1904A.onTextStyleChanged(C1083a.m1823l(i));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextAlignmentChanged(Layout.Alignment alignment) {
                if (C1084b.this.f1904A != null) {
                    C1084b.this.f1904A.onTextAlignmentChanged(C1083a.m1803a(alignment));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onFillingColorChanged(int i) {
                if (C1084b.this.f1905B == null) {
                    return;
                }
                C1084b.this.f1905B.onFillingColorChanged(i);
            }
        };
        this.f1924o = new CanvasView.OnDrawingInformationListener() { // from class: com.samsung.spen.a.d.b.4
            @Override // com.samsung.sdraw.CanvasView.OnDrawingInformationListener
            public void onDrawingPen(View view, MotionEvent motionEvent) {
                if (C1084b.this.f1907D == null) {
                    return;
                }
                C1084b.this.f1907D.onDrawingPen(view, motionEvent, 0, 0);
            }
        };
        this.f1925p = new SCanvasInitializeListener() { // from class: com.samsung.spen.a.d.b.5
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
            }
        };
        this.f1926q = new SCanvasMatrixChangeListener() { // from class: com.samsung.spen.a.d.b.6
            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
            }

            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChangeFinished() {
            }
        };
        this.f1927r = new SCanvasModeChangedListener() { // from class: com.samsung.spen.a.d.b.7
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int i) {
            }
        };
        this.f1928s = new SCanvasDeleteAllConfirmListener() { // from class: com.samsung.spen.a.d.b.8
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i) {
                return false;
            }
        };
        this.f1929t = new SObjectUpdateListener() { // from class: com.samsung.spen.a.d.b.9
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean z, boolean z2) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean z, boolean z2, boolean z3) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean z, boolean z2) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectSelected(SObject sObject, boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public boolean onSObjectStrokeInserting(SObjectStroke sObjectStroke) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean z, int i) {
            }
        };
        this.f1930u = new SObjectSelectListener() { // from class: com.samsung.spen.a.d.b.10
            @Override // com.samsung.spensdk.applistener.SObjectSelectListener
            public void onSObjectSelected(SObject sObject, boolean z) {
            }
        };
        this.f1931v = new ColorPickerColorChangeListener() { // from class: com.samsung.spen.a.d.b.11
            @Override // com.samsung.spensdk.applistener.ColorPickerColorChangeListener
            public void onColorPickerColorChanged(int i) {
            }
        };
        this.f1932w = new HistoryUpdateListener() { // from class: com.samsung.spen.a.d.b.13
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean z, boolean z2) {
            }
        };
        this.f1933x = new SCanvasLongPressListener() { // from class: com.samsung.spen.a.d.b.14
            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed(float f, float f2) {
            }

            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed() {
            }
        };
        this.f1934y = new SettingViewShowListener() { // from class: com.samsung.spen.a.d.b.15
            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onEraserSettingViewShow(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onPenSettingViewShow(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onTextSettingViewShow(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onFillingSettingViewShow(boolean z) {
            }
        };
        this.f1935z = new SettingStrokeChangeListener() { // from class: com.samsung.spen.a.d.b.16
            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeColorChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeAlphaChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeStyleChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeWidthChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onEraserWidthChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onDeleteAll(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onClearAll(boolean z) {
            }
        };
        this.f1904A = new SettingTextChangeListener() { // from class: com.samsung.spen.a.d.b.17
            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextColorChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextFontChanged(String str) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextSizeChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextStyleChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextAlignmentChanged(int i) {
            }
        };
        this.f1905B = new SettingFillingChangeListener() { // from class: com.samsung.spen.a.d.b.18
            @Override // com.samsung.spensdk.applistener.SettingFillingChangeListener
            public void onFillingColorChanged(int i) {
            }
        };
        this.f1906C = new SettingPresetDeleteBtnClickListener() { // from class: com.samsung.spen.a.d.b.19
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int i) {
            }
        };
        this.f1907D = new SPenTouchIDListener() { // from class: com.samsung.spen.a.d.b.20
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onDrawingPen(View view, MotionEvent motionEvent, int i, int i2) {
                return false;
            }
        };
        this.f1908E = new InterfaceC1095b() { // from class: com.samsung.spen.a.d.b.21
            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: a */
            public int mo1849a(SObject sObject) {
                return -1;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: a */
            public SObject mo1850a(int i) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: b */
            public int mo1854b(SObject sObject) {
                return -1;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: c */
            public boolean mo1858c(SObject sObject) {
                return false;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: a */
            public SObject mo1852a(SObject sObject, boolean z) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: b */
            public void mo1856b(SObject sObject, boolean z) {
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: a */
            public SObject mo1851a(int i, int i2) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: a */
            public int mo1848a(int i, int i2, SObject sObject) {
                return -1;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: b */
            public LinkedList<SObject> mo1855b(int i) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: c */
            public void mo1857c(int i) {
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: d */
            public void mo1859d(int i) {
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: a */
            public boolean mo1853a(SObject sObject, SObject sObject2) {
                return false;
            }
        };
        this.f1909F = null;
        setParentCanvasListener();
    }

    public C1084b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1914e = true;
        this.f1915f = true;
        this.f1916g = null;
        this.f1917h = new CanvasView.OnInitializeFinishListener() { // from class: com.samsung.spen.a.d.b.1
            @Override // com.samsung.sdraw.CanvasView.OnInitializeFinishListener
            public void onFinish() {
                if (C1084b.this.f1925p == null) {
                    return;
                }
                C1084b.this.f1925p.onInitialized();
            }
        };
        this.f1918i = new CanvasView.OnCanvasMatrixChangeListener() { // from class: com.samsung.spen.a.d.b.12
            @Override // com.samsung.sdraw.CanvasView.OnCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
                if (C1084b.this.f1926q == null) {
                    return;
                }
                C1084b.this.f1926q.onMatrixChanged(matrix);
            }

            @Override // com.samsung.sdraw.CanvasView.OnCanvasMatrixChangeListener
            public void onMatrixChangeEnd() {
                if (C1084b.this.f1926q == null) {
                    return;
                }
                C1084b.this.f1926q.onMatrixChangeFinished();
            }
        };
        this.f1919j = new CanvasView.OnModeChangedListener() { // from class: com.samsung.spen.a.d.b.22
            @Override // com.samsung.sdraw.CanvasView.OnModeChangedListener
            public void onModeChanged(int i) {
                if (C1084b.this.f1927r != null) {
                    C1084b.this.f1927r.onModeChanged(C1083a.m1813b(i));
                }
            }
        };
        this.f1920k = new AbstractSettingView.OnDeleteAllConfirmListener() { // from class: com.samsung.spen.a.d.b.23
            @Override // com.samsung.sdraw.AbstractSettingView.OnDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i) {
                if (C1084b.this.f1928s != null) {
                    return C1084b.this.f1928s.onDeleteAllConfirm(i);
                }
                return false;
            }
        };
        this.f1910a = new CanvasView.OnSettingViewShowListener() { // from class: com.samsung.spen.a.d.b.24
            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onPenSettingViewShow(boolean z) {
                Log.i(C1084b.TAG, "PenSettingViewShow : " + z);
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onPenSettingViewShow(z);
            }

            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onEraserSettingViewShow(boolean z) {
                Log.i(C1084b.TAG, "EraserSettingViewShow : " + z);
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onEraserSettingViewShow(z);
            }

            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onTextSettingViewShow(boolean z) {
                Log.i(C1084b.TAG, "TextSettingViewShow : " + z);
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onTextSettingViewShow(z);
            }

            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onFillingSettingViewShow(boolean z) {
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onFillingSettingViewShow(z);
            }
        };
        this.f1911b = new AbstractSettingView.OnPresetDelBtnOnClickListener() { // from class: com.samsung.spen.a.d.b.25
            @Override // com.samsung.sdraw.AbstractSettingView.OnPresetDelBtnOnClickListener
            public void onClick(int i) {
                if (C1084b.this.f1906C == null) {
                    return;
                }
                C1084b.this.f1906C.onClick(i);
            }
        };
        this.f1921l = new CanvasView.OnLongPressListener() { // from class: com.samsung.spen.a.d.b.26
            @Override // com.samsung.sdraw.CanvasView.OnLongPressListener
            public void onLongPress(float f, float f2) {
                if (C1084b.this.f1933x == null) {
                    return;
                }
                C1084b.this.f1933x.onLongPressed(f, f2);
            }

            @Override // com.samsung.sdraw.CanvasView.OnLongPressListener
            public void onLongPress() {
                if (C1084b.this.f1933x == null) {
                    return;
                }
                C1084b.this.f1933x.onLongPressed();
            }
        };
        this.f1922m = new CanvasView.OnDropperColorChangeListener() { // from class: com.samsung.spen.a.d.b.27
            @Override // com.samsung.sdraw.CanvasView.OnDropperColorChangeListener
            public void onDropperColorChanged(int i) {
                if (C1084b.this.f1931v == null) {
                    return;
                }
                C1084b.this.f1931v.onColorPickerColorChanged(i);
            }
        };
        this.f1923n = new CanvasView.OnHistoryChangeListener() { // from class: com.samsung.spen.a.d.b.28
            @Override // com.samsung.sdraw.CanvasView.OnHistoryChangeListener
            public void onHistoryChanged(boolean z, boolean z2) {
                if (C1084b.this.f1932w == null) {
                    return;
                }
                C1084b.this.f1932w.onHistoryChanged(z, z2);
            }
        };
        this.f1912c = new CanvasView.OnObjectListener() { // from class: com.samsung.spen.a.d.b.2
            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectInserted(ObjectInfo objectInfo, boolean z, boolean z2) {
                SObject sObjectMo1850a;
                int iMo1854b;
                if (C1084b.this.f1909F != null && (objectInfo instanceof StrokeInfo)) {
                    StrokeInfo strokeInfo = (StrokeInfo) objectInfo;
                    C1084b.this.f1909F.mo1986b(strokeInfo.points, strokeInfo.event_time);
                }
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        sObjectMo1850a = C1083a.m1804a(objectInfo);
                        if (sObjectMo1850a == null) {
                            Log.e(C1084b.TAG, "Fail to create SObject");
                            return;
                        }
                        if (layerID == 0) {
                            iMo1854b = C1084b.this.f1908E.mo1848a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID(), sObjectMo1850a);
                        } else if (layerID != 1) {
                            return;
                        } else {
                            iMo1854b = C1084b.this.f1908E.mo1854b(sObjectMo1850a);
                        }
                        if (iMo1854b >= 0) {
                            objectInfo.setID(iMo1854b);
                        } else {
                            return;
                        }
                    } else {
                        if (layerID == 0) {
                            sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                            if (sObjectMo1850a == null) {
                                Log.e(C1084b.TAG, "Fail to get SObject");
                                return;
                            }
                        } else {
                            if (layerID != 1) {
                                return;
                            }
                            sObjectMo1850a = C1084b.this.f1908E.mo1850a(id);
                            if (sObjectMo1850a == null) {
                                Log.e(C1084b.TAG, "Fail to get SObject");
                                return;
                            }
                        }
                        if (!z || z2) {
                            if (z || !z2) {
                                if (z || z2) {
                                    Log.e(C1084b.TAG, "Unexpected Insert.");
                                    return;
                                }
                                C1084b.this.f1908E.mo1856b(sObjectMo1850a, true);
                            } else {
                                C1084b.this.f1908E.mo1856b(sObjectMo1850a, true);
                            }
                        } else {
                            C1084b.this.f1908E.mo1856b(sObjectMo1850a, true);
                        }
                    }
                    if (C1084b.this.f1929t == null) {
                        return;
                    }
                    C1084b.this.f1929t.onSObjectInserted(sObjectMo1850a, z, z2);
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectDeleted(ObjectInfo objectInfo, boolean z, boolean z2, boolean z3) {
                SObject sObjectMo1850a;
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        Log.e(C1084b.TAG, "Unknown object deleted");
                        return;
                    }
                    if (layerID != 0) {
                        if (layerID != 1 || (sObjectMo1850a = C1084b.this.f1908E.mo1850a(id)) == null) {
                            return;
                        }
                    } else {
                        sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                        if (sObjectMo1850a == null) {
                            return;
                        }
                    }
                    if (!z || z2) {
                        if (z || !z2) {
                            if (z || z2) {
                                Log.e(C1084b.TAG, "Unexpected Insert.");
                                return;
                            }
                            C1084b.this.f1908E.mo1856b(sObjectMo1850a, false);
                        } else {
                            C1084b.this.f1908E.mo1856b(sObjectMo1850a, false);
                        }
                    } else {
                        C1084b.this.f1908E.mo1856b(sObjectMo1850a, false);
                    }
                    if (z3 && !C1084b.this.f1908E.mo1858c(sObjectMo1850a)) {
                        Log.e(C1084b.TAG, "Fail to Delete SObject List");
                    } else {
                        if (C1084b.this.f1929t == null) {
                            return;
                        }
                        C1084b.this.f1929t.onSObjectDeleted(sObjectMo1850a, z, z2, z3);
                    }
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectChanged(ObjectInfo objectInfo, boolean z, boolean z2) {
                SObject sObjectMo1850a;
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        Log.e(C1084b.TAG, "Unknown object changed");
                        return;
                    }
                    if (layerID == 0) {
                        sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                        if (sObjectMo1850a == null) {
                            return;
                        }
                    } else {
                        if (layerID != 1) {
                            return;
                        }
                        sObjectMo1850a = C1084b.this.f1908E.mo1850a(id);
                        if (sObjectMo1850a == null) {
                            Log.e(C1084b.TAG, "Fail to get SObject");
                            return;
                        }
                    }
                    if (!C1083a.m1810a(objectInfo, sObjectMo1850a)) {
                        Log.e(C1084b.TAG, "Fail to Update SObject List");
                    } else {
                        if (C1084b.this.f1929t == null) {
                            return;
                        }
                        C1084b.this.f1929t.onSObjectChanged(sObjectMo1850a, z, z2);
                    }
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectSelected(ObjectInfo objectInfo, boolean z) {
                SObject sObjectMo1850a;
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        Log.e(C1084b.TAG, "Unknown object selected");
                        return;
                    }
                    if (layerID != 0) {
                        if (layerID != 1 || (sObjectMo1850a = C1084b.this.f1908E.mo1850a(id)) == null) {
                            return;
                        }
                    } else {
                        sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                        if (sObjectMo1850a == null) {
                            return;
                        }
                    }
                    SObject sObjectMo1852a = C1084b.this.f1908E.mo1852a(sObjectMo1850a, z);
                    if (sObjectMo1852a == null) {
                        Log.e(C1084b.TAG, "Fail to Update SObject List");
                    }
                    if (C1084b.this.f1929t != null) {
                        C1084b.this.f1929t.onSObjectSelected(sObjectMo1852a, z);
                    }
                    if (C1084b.this.f1930u == null) {
                        return;
                    }
                    C1084b.this.f1930u.onSObjectSelected(sObjectMo1852a, z);
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectDeletedAll(boolean z, int i) {
                int i2 = 0;
                if (i != 0 && i == 1) {
                    i2 = 1;
                }
                if (z) {
                    C1084b.this.f1908E.mo1857c(i2);
                } else {
                    C1084b.this.f1908E.mo1859d(i2);
                }
                if (C1084b.this.f1929t == null) {
                    return;
                }
                C1084b.this.f1929t.onSObjectDeletedAll(z, i2);
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public boolean onStrokeInserting(StrokeInfo strokeInfo) {
                if (C1084b.this.f1915f && C1084b.this.f1908E != null && C1084b.this.f1914e) {
                    SObject sObjectM1804a = C1083a.m1804a(strokeInfo);
                    if (sObjectM1804a == null) {
                        Log.e(C1084b.TAG, "Fail to create SObject");
                        return false;
                    }
                    if ((sObjectM1804a instanceof SObjectStroke) && C1084b.this.f1929t != null) {
                        return C1084b.this.f1929t.onSObjectStrokeInserting((SObjectStroke) sObjectM1804a);
                    }
                    return false;
                }
                return false;
            }
        };
        this.f1913d = new AbstractSettingView.OnSettingChangedListener() { // from class: com.samsung.spen.a.d.b.3
            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onDeleteAll(boolean z) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onDeleteAll(z);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onClearAll(boolean z) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onClearAll(z);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onEraserWidthChanged(int i) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onEraserWidthChanged(i);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenAlphaChanged(int i) {
                PenSettingInfo penSettingViewInfo;
                if (C1084b.this.f1935z != null && (penSettingViewInfo = C1084b.this.getPenSettingViewInfo()) != null) {
                    int penColor = penSettingViewInfo.getPenColor();
                    int penAlpha = penSettingViewInfo.getPenAlpha();
                    C1084b.this.f1935z.onStrokeAlphaChanged(penAlpha);
                    C1084b.this.f1935z.onStrokeColorChanged(penColor | (penAlpha << 24));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenTypeChanged(int i) {
                if (C1084b.this.f1935z != null) {
                    C1084b.this.f1935z.onStrokeStyleChanged(C1083a.m1818g(i));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenWidthChanged(int i) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onStrokeWidthChanged(i);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenColorChanged(int i) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onStrokeColorChanged(i);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextColorChanged(int i) {
                if (C1084b.this.f1904A == null) {
                    return;
                }
                C1084b.this.f1904A.onTextColorChanged(i);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextFontChanged(String str) {
                if (C1084b.this.f1904A == null) {
                    return;
                }
                C1084b.this.f1904A.onTextFontChanged(str);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextSizeChanged(int i) {
                if (C1084b.this.f1904A == null) {
                    return;
                }
                C1084b.this.f1904A.onTextSizeChanged(i);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextTypeChanged(int i) {
                if (C1084b.this.f1904A != null) {
                    C1084b.this.f1904A.onTextStyleChanged(C1083a.m1823l(i));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextAlignmentChanged(Layout.Alignment alignment) {
                if (C1084b.this.f1904A != null) {
                    C1084b.this.f1904A.onTextAlignmentChanged(C1083a.m1803a(alignment));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onFillingColorChanged(int i) {
                if (C1084b.this.f1905B == null) {
                    return;
                }
                C1084b.this.f1905B.onFillingColorChanged(i);
            }
        };
        this.f1924o = new CanvasView.OnDrawingInformationListener() { // from class: com.samsung.spen.a.d.b.4
            @Override // com.samsung.sdraw.CanvasView.OnDrawingInformationListener
            public void onDrawingPen(View view, MotionEvent motionEvent) {
                if (C1084b.this.f1907D == null) {
                    return;
                }
                C1084b.this.f1907D.onDrawingPen(view, motionEvent, 0, 0);
            }
        };
        this.f1925p = new SCanvasInitializeListener() { // from class: com.samsung.spen.a.d.b.5
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
            }
        };
        this.f1926q = new SCanvasMatrixChangeListener() { // from class: com.samsung.spen.a.d.b.6
            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
            }

            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChangeFinished() {
            }
        };
        this.f1927r = new SCanvasModeChangedListener() { // from class: com.samsung.spen.a.d.b.7
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int i) {
            }
        };
        this.f1928s = new SCanvasDeleteAllConfirmListener() { // from class: com.samsung.spen.a.d.b.8
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i) {
                return false;
            }
        };
        this.f1929t = new SObjectUpdateListener() { // from class: com.samsung.spen.a.d.b.9
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean z, boolean z2) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean z, boolean z2, boolean z3) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean z, boolean z2) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectSelected(SObject sObject, boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public boolean onSObjectStrokeInserting(SObjectStroke sObjectStroke) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean z, int i) {
            }
        };
        this.f1930u = new SObjectSelectListener() { // from class: com.samsung.spen.a.d.b.10
            @Override // com.samsung.spensdk.applistener.SObjectSelectListener
            public void onSObjectSelected(SObject sObject, boolean z) {
            }
        };
        this.f1931v = new ColorPickerColorChangeListener() { // from class: com.samsung.spen.a.d.b.11
            @Override // com.samsung.spensdk.applistener.ColorPickerColorChangeListener
            public void onColorPickerColorChanged(int i) {
            }
        };
        this.f1932w = new HistoryUpdateListener() { // from class: com.samsung.spen.a.d.b.13
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean z, boolean z2) {
            }
        };
        this.f1933x = new SCanvasLongPressListener() { // from class: com.samsung.spen.a.d.b.14
            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed(float f, float f2) {
            }

            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed() {
            }
        };
        this.f1934y = new SettingViewShowListener() { // from class: com.samsung.spen.a.d.b.15
            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onEraserSettingViewShow(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onPenSettingViewShow(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onTextSettingViewShow(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onFillingSettingViewShow(boolean z) {
            }
        };
        this.f1935z = new SettingStrokeChangeListener() { // from class: com.samsung.spen.a.d.b.16
            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeColorChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeAlphaChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeStyleChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeWidthChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onEraserWidthChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onDeleteAll(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onClearAll(boolean z) {
            }
        };
        this.f1904A = new SettingTextChangeListener() { // from class: com.samsung.spen.a.d.b.17
            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextColorChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextFontChanged(String str) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextSizeChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextStyleChanged(int i) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextAlignmentChanged(int i) {
            }
        };
        this.f1905B = new SettingFillingChangeListener() { // from class: com.samsung.spen.a.d.b.18
            @Override // com.samsung.spensdk.applistener.SettingFillingChangeListener
            public void onFillingColorChanged(int i) {
            }
        };
        this.f1906C = new SettingPresetDeleteBtnClickListener() { // from class: com.samsung.spen.a.d.b.19
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int i) {
            }
        };
        this.f1907D = new SPenTouchIDListener() { // from class: com.samsung.spen.a.d.b.20
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent motionEvent, int i) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onDrawingPen(View view, MotionEvent motionEvent, int i, int i2) {
                return false;
            }
        };
        this.f1908E = new InterfaceC1095b() { // from class: com.samsung.spen.a.d.b.21
            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: a */
            public int mo1849a(SObject sObject) {
                return -1;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: a */
            public SObject mo1850a(int i) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: b */
            public int mo1854b(SObject sObject) {
                return -1;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: c */
            public boolean mo1858c(SObject sObject) {
                return false;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: a */
            public SObject mo1852a(SObject sObject, boolean z) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: b */
            public void mo1856b(SObject sObject, boolean z) {
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: a */
            public SObject mo1851a(int i, int i2) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: a */
            public int mo1848a(int i, int i2, SObject sObject) {
                return -1;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: b */
            public LinkedList<SObject> mo1855b(int i) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: c */
            public void mo1857c(int i) {
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: d */
            public void mo1859d(int i) {
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: a */
            public boolean mo1853a(SObject sObject, SObject sObject2) {
                return false;
            }
        };
        this.f1909F = null;
        setParentCanvasListener();
    }

    public C1084b(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1914e = true;
        this.f1915f = true;
        this.f1916g = null;
        this.f1917h = new CanvasView.OnInitializeFinishListener() { // from class: com.samsung.spen.a.d.b.1
            @Override // com.samsung.sdraw.CanvasView.OnInitializeFinishListener
            public void onFinish() {
                if (C1084b.this.f1925p == null) {
                    return;
                }
                C1084b.this.f1925p.onInitialized();
            }
        };
        this.f1918i = new CanvasView.OnCanvasMatrixChangeListener() { // from class: com.samsung.spen.a.d.b.12
            @Override // com.samsung.sdraw.CanvasView.OnCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
                if (C1084b.this.f1926q == null) {
                    return;
                }
                C1084b.this.f1926q.onMatrixChanged(matrix);
            }

            @Override // com.samsung.sdraw.CanvasView.OnCanvasMatrixChangeListener
            public void onMatrixChangeEnd() {
                if (C1084b.this.f1926q == null) {
                    return;
                }
                C1084b.this.f1926q.onMatrixChangeFinished();
            }
        };
        this.f1919j = new CanvasView.OnModeChangedListener() { // from class: com.samsung.spen.a.d.b.22
            @Override // com.samsung.sdraw.CanvasView.OnModeChangedListener
            public void onModeChanged(int i2) {
                if (C1084b.this.f1927r != null) {
                    C1084b.this.f1927r.onModeChanged(C1083a.m1813b(i2));
                }
            }
        };
        this.f1920k = new AbstractSettingView.OnDeleteAllConfirmListener() { // from class: com.samsung.spen.a.d.b.23
            @Override // com.samsung.sdraw.AbstractSettingView.OnDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i2) {
                if (C1084b.this.f1928s != null) {
                    return C1084b.this.f1928s.onDeleteAllConfirm(i2);
                }
                return false;
            }
        };
        this.f1910a = new CanvasView.OnSettingViewShowListener() { // from class: com.samsung.spen.a.d.b.24
            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onPenSettingViewShow(boolean z) {
                Log.i(C1084b.TAG, "PenSettingViewShow : " + z);
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onPenSettingViewShow(z);
            }

            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onEraserSettingViewShow(boolean z) {
                Log.i(C1084b.TAG, "EraserSettingViewShow : " + z);
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onEraserSettingViewShow(z);
            }

            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onTextSettingViewShow(boolean z) {
                Log.i(C1084b.TAG, "TextSettingViewShow : " + z);
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onTextSettingViewShow(z);
            }

            @Override // com.samsung.sdraw.CanvasView.OnSettingViewShowListener
            public void onFillingSettingViewShow(boolean z) {
                if (C1084b.this.f1934y == null) {
                    return;
                }
                C1084b.this.f1934y.onFillingSettingViewShow(z);
            }
        };
        this.f1911b = new AbstractSettingView.OnPresetDelBtnOnClickListener() { // from class: com.samsung.spen.a.d.b.25
            @Override // com.samsung.sdraw.AbstractSettingView.OnPresetDelBtnOnClickListener
            public void onClick(int i2) {
                if (C1084b.this.f1906C == null) {
                    return;
                }
                C1084b.this.f1906C.onClick(i2);
            }
        };
        this.f1921l = new CanvasView.OnLongPressListener() { // from class: com.samsung.spen.a.d.b.26
            @Override // com.samsung.sdraw.CanvasView.OnLongPressListener
            public void onLongPress(float f, float f2) {
                if (C1084b.this.f1933x == null) {
                    return;
                }
                C1084b.this.f1933x.onLongPressed(f, f2);
            }

            @Override // com.samsung.sdraw.CanvasView.OnLongPressListener
            public void onLongPress() {
                if (C1084b.this.f1933x == null) {
                    return;
                }
                C1084b.this.f1933x.onLongPressed();
            }
        };
        this.f1922m = new CanvasView.OnDropperColorChangeListener() { // from class: com.samsung.spen.a.d.b.27
            @Override // com.samsung.sdraw.CanvasView.OnDropperColorChangeListener
            public void onDropperColorChanged(int i2) {
                if (C1084b.this.f1931v == null) {
                    return;
                }
                C1084b.this.f1931v.onColorPickerColorChanged(i2);
            }
        };
        this.f1923n = new CanvasView.OnHistoryChangeListener() { // from class: com.samsung.spen.a.d.b.28
            @Override // com.samsung.sdraw.CanvasView.OnHistoryChangeListener
            public void onHistoryChanged(boolean z, boolean z2) {
                if (C1084b.this.f1932w == null) {
                    return;
                }
                C1084b.this.f1932w.onHistoryChanged(z, z2);
            }
        };
        this.f1912c = new CanvasView.OnObjectListener() { // from class: com.samsung.spen.a.d.b.2
            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectInserted(ObjectInfo objectInfo, boolean z, boolean z2) {
                SObject sObjectMo1850a;
                int iMo1854b;
                if (C1084b.this.f1909F != null && (objectInfo instanceof StrokeInfo)) {
                    StrokeInfo strokeInfo = (StrokeInfo) objectInfo;
                    C1084b.this.f1909F.mo1986b(strokeInfo.points, strokeInfo.event_time);
                }
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        sObjectMo1850a = C1083a.m1804a(objectInfo);
                        if (sObjectMo1850a == null) {
                            Log.e(C1084b.TAG, "Fail to create SObject");
                            return;
                        }
                        if (layerID == 0) {
                            iMo1854b = C1084b.this.f1908E.mo1848a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID(), sObjectMo1850a);
                        } else if (layerID != 1) {
                            return;
                        } else {
                            iMo1854b = C1084b.this.f1908E.mo1854b(sObjectMo1850a);
                        }
                        if (iMo1854b >= 0) {
                            objectInfo.setID(iMo1854b);
                        } else {
                            return;
                        }
                    } else {
                        if (layerID == 0) {
                            sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                            if (sObjectMo1850a == null) {
                                Log.e(C1084b.TAG, "Fail to get SObject");
                                return;
                            }
                        } else {
                            if (layerID != 1) {
                                return;
                            }
                            sObjectMo1850a = C1084b.this.f1908E.mo1850a(id);
                            if (sObjectMo1850a == null) {
                                Log.e(C1084b.TAG, "Fail to get SObject");
                                return;
                            }
                        }
                        if (!z || z2) {
                            if (z || !z2) {
                                if (z || z2) {
                                    Log.e(C1084b.TAG, "Unexpected Insert.");
                                    return;
                                }
                                C1084b.this.f1908E.mo1856b(sObjectMo1850a, true);
                            } else {
                                C1084b.this.f1908E.mo1856b(sObjectMo1850a, true);
                            }
                        } else {
                            C1084b.this.f1908E.mo1856b(sObjectMo1850a, true);
                        }
                    }
                    if (C1084b.this.f1929t == null) {
                        return;
                    }
                    C1084b.this.f1929t.onSObjectInserted(sObjectMo1850a, z, z2);
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectDeleted(ObjectInfo objectInfo, boolean z, boolean z2, boolean z3) {
                SObject sObjectMo1850a;
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        Log.e(C1084b.TAG, "Unknown object deleted");
                        return;
                    }
                    if (layerID != 0) {
                        if (layerID != 1 || (sObjectMo1850a = C1084b.this.f1908E.mo1850a(id)) == null) {
                            return;
                        }
                    } else {
                        sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                        if (sObjectMo1850a == null) {
                            return;
                        }
                    }
                    if (!z || z2) {
                        if (z || !z2) {
                            if (z || z2) {
                                Log.e(C1084b.TAG, "Unexpected Insert.");
                                return;
                            }
                            C1084b.this.f1908E.mo1856b(sObjectMo1850a, false);
                        } else {
                            C1084b.this.f1908E.mo1856b(sObjectMo1850a, false);
                        }
                    } else {
                        C1084b.this.f1908E.mo1856b(sObjectMo1850a, false);
                    }
                    if (z3 && !C1084b.this.f1908E.mo1858c(sObjectMo1850a)) {
                        Log.e(C1084b.TAG, "Fail to Delete SObject List");
                    } else {
                        if (C1084b.this.f1929t == null) {
                            return;
                        }
                        C1084b.this.f1929t.onSObjectDeleted(sObjectMo1850a, z, z2, z3);
                    }
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectChanged(ObjectInfo objectInfo, boolean z, boolean z2) {
                SObject sObjectMo1850a;
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        Log.e(C1084b.TAG, "Unknown object changed");
                        return;
                    }
                    if (layerID == 0) {
                        sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                        if (sObjectMo1850a == null) {
                            return;
                        }
                    } else {
                        if (layerID != 1) {
                            return;
                        }
                        sObjectMo1850a = C1084b.this.f1908E.mo1850a(id);
                        if (sObjectMo1850a == null) {
                            Log.e(C1084b.TAG, "Fail to get SObject");
                            return;
                        }
                    }
                    if (!C1083a.m1810a(objectInfo, sObjectMo1850a)) {
                        Log.e(C1084b.TAG, "Fail to Update SObject List");
                    } else {
                        if (C1084b.this.f1929t == null) {
                            return;
                        }
                        C1084b.this.f1929t.onSObjectChanged(sObjectMo1850a, z, z2);
                    }
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectSelected(ObjectInfo objectInfo, boolean z) {
                SObject sObjectMo1850a;
                if (C1084b.this.f1915f && C1084b.this.f1908E != null) {
                    int id = objectInfo.getID();
                    int layerID = objectInfo.getLayerID();
                    if (id < 0) {
                        Log.e(C1084b.TAG, "Unknown object selected");
                        return;
                    }
                    if (layerID != 0) {
                        if (layerID != 1 || (sObjectMo1850a = C1084b.this.f1908E.mo1850a(id)) == null) {
                            return;
                        }
                    } else {
                        sObjectMo1850a = C1084b.this.f1908E.mo1851a(objectInfo.getMultiUserID(), objectInfo.getMultiObjectID());
                        if (sObjectMo1850a == null) {
                            return;
                        }
                    }
                    SObject sObjectMo1852a = C1084b.this.f1908E.mo1852a(sObjectMo1850a, z);
                    if (sObjectMo1852a == null) {
                        Log.e(C1084b.TAG, "Fail to Update SObject List");
                    }
                    if (C1084b.this.f1929t != null) {
                        C1084b.this.f1929t.onSObjectSelected(sObjectMo1852a, z);
                    }
                    if (C1084b.this.f1930u == null) {
                        return;
                    }
                    C1084b.this.f1930u.onSObjectSelected(sObjectMo1852a, z);
                }
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public void onObjectDeletedAll(boolean z, int i2) {
                int i22 = 0;
                if (i2 != 0 && i2 == 1) {
                    i22 = 1;
                }
                if (z) {
                    C1084b.this.f1908E.mo1857c(i22);
                } else {
                    C1084b.this.f1908E.mo1859d(i22);
                }
                if (C1084b.this.f1929t == null) {
                    return;
                }
                C1084b.this.f1929t.onSObjectDeletedAll(z, i22);
            }

            @Override // com.samsung.sdraw.CanvasView.OnObjectListener
            public boolean onStrokeInserting(StrokeInfo strokeInfo) {
                if (C1084b.this.f1915f && C1084b.this.f1908E != null && C1084b.this.f1914e) {
                    SObject sObjectM1804a = C1083a.m1804a(strokeInfo);
                    if (sObjectM1804a == null) {
                        Log.e(C1084b.TAG, "Fail to create SObject");
                        return false;
                    }
                    if ((sObjectM1804a instanceof SObjectStroke) && C1084b.this.f1929t != null) {
                        return C1084b.this.f1929t.onSObjectStrokeInserting((SObjectStroke) sObjectM1804a);
                    }
                    return false;
                }
                return false;
            }
        };
        this.f1913d = new AbstractSettingView.OnSettingChangedListener() { // from class: com.samsung.spen.a.d.b.3
            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onDeleteAll(boolean z) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onDeleteAll(z);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onClearAll(boolean z) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onClearAll(z);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onEraserWidthChanged(int i2) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onEraserWidthChanged(i2);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenAlphaChanged(int i2) {
                PenSettingInfo penSettingViewInfo;
                if (C1084b.this.f1935z != null && (penSettingViewInfo = C1084b.this.getPenSettingViewInfo()) != null) {
                    int penColor = penSettingViewInfo.getPenColor();
                    int penAlpha = penSettingViewInfo.getPenAlpha();
                    C1084b.this.f1935z.onStrokeAlphaChanged(penAlpha);
                    C1084b.this.f1935z.onStrokeColorChanged(penColor | (penAlpha << 24));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenTypeChanged(int i2) {
                if (C1084b.this.f1935z != null) {
                    C1084b.this.f1935z.onStrokeStyleChanged(C1083a.m1818g(i2));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenWidthChanged(int i2) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onStrokeWidthChanged(i2);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onPenColorChanged(int i2) {
                if (C1084b.this.f1935z == null) {
                    return;
                }
                C1084b.this.f1935z.onStrokeColorChanged(i2);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextColorChanged(int i2) {
                if (C1084b.this.f1904A == null) {
                    return;
                }
                C1084b.this.f1904A.onTextColorChanged(i2);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextFontChanged(String str) {
                if (C1084b.this.f1904A == null) {
                    return;
                }
                C1084b.this.f1904A.onTextFontChanged(str);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextSizeChanged(int i2) {
                if (C1084b.this.f1904A == null) {
                    return;
                }
                C1084b.this.f1904A.onTextSizeChanged(i2);
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextTypeChanged(int i2) {
                if (C1084b.this.f1904A != null) {
                    C1084b.this.f1904A.onTextStyleChanged(C1083a.m1823l(i2));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onTextAlignmentChanged(Layout.Alignment alignment) {
                if (C1084b.this.f1904A != null) {
                    C1084b.this.f1904A.onTextAlignmentChanged(C1083a.m1803a(alignment));
                }
            }

            @Override // com.samsung.sdraw.AbstractSettingView.OnSettingChangedListener
            public void onFillingColorChanged(int i2) {
                if (C1084b.this.f1905B == null) {
                    return;
                }
                C1084b.this.f1905B.onFillingColorChanged(i2);
            }
        };
        this.f1924o = new CanvasView.OnDrawingInformationListener() { // from class: com.samsung.spen.a.d.b.4
            @Override // com.samsung.sdraw.CanvasView.OnDrawingInformationListener
            public void onDrawingPen(View view, MotionEvent motionEvent) {
                if (C1084b.this.f1907D == null) {
                    return;
                }
                C1084b.this.f1907D.onDrawingPen(view, motionEvent, 0, 0);
            }
        };
        this.f1925p = new SCanvasInitializeListener() { // from class: com.samsung.spen.a.d.b.5
            @Override // com.samsung.spensdk.applistener.SCanvasInitializeListener
            public void onInitialized() {
            }
        };
        this.f1926q = new SCanvasMatrixChangeListener() { // from class: com.samsung.spen.a.d.b.6
            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChanged(Matrix matrix) {
            }

            @Override // com.samsung.spensdk.applistener.SCanvasMatrixChangeListener
            public void onMatrixChangeFinished() {
            }
        };
        this.f1927r = new SCanvasModeChangedListener() { // from class: com.samsung.spen.a.d.b.7
            @Override // com.samsung.spensdk.applistener.SCanvasModeChangedListener
            public void onModeChanged(int i2) {
            }
        };
        this.f1928s = new SCanvasDeleteAllConfirmListener() { // from class: com.samsung.spen.a.d.b.8
            @Override // com.samsung.spensdk.applistener.SCanvasDeleteAllConfirmListener
            public boolean onDeleteAllConfirm(int i2) {
                return false;
            }
        };
        this.f1929t = new SObjectUpdateListener() { // from class: com.samsung.spen.a.d.b.9
            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectChanged(SObject sObject, boolean z, boolean z2) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeleted(SObject sObject, boolean z, boolean z2, boolean z3) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectInserted(SObject sObject, boolean z, boolean z2) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectSelected(SObject sObject, boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public boolean onSObjectStrokeInserting(SObjectStroke sObjectStroke) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SObjectUpdateListener
            public void onSObjectDeletedAll(boolean z, int i2) {
            }
        };
        this.f1930u = new SObjectSelectListener() { // from class: com.samsung.spen.a.d.b.10
            @Override // com.samsung.spensdk.applistener.SObjectSelectListener
            public void onSObjectSelected(SObject sObject, boolean z) {
            }
        };
        this.f1931v = new ColorPickerColorChangeListener() { // from class: com.samsung.spen.a.d.b.11
            @Override // com.samsung.spensdk.applistener.ColorPickerColorChangeListener
            public void onColorPickerColorChanged(int i2) {
            }
        };
        this.f1932w = new HistoryUpdateListener() { // from class: com.samsung.spen.a.d.b.13
            @Override // com.samsung.spensdk.applistener.HistoryUpdateListener
            public void onHistoryChanged(boolean z, boolean z2) {
            }
        };
        this.f1933x = new SCanvasLongPressListener() { // from class: com.samsung.spen.a.d.b.14
            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed(float f, float f2) {
            }

            @Override // com.samsung.spensdk.applistener.SCanvasLongPressListener
            public void onLongPressed() {
            }
        };
        this.f1934y = new SettingViewShowListener() { // from class: com.samsung.spen.a.d.b.15
            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onEraserSettingViewShow(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onPenSettingViewShow(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onTextSettingViewShow(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingViewShowListener
            public void onFillingSettingViewShow(boolean z) {
            }
        };
        this.f1935z = new SettingStrokeChangeListener() { // from class: com.samsung.spen.a.d.b.16
            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeColorChanged(int i2) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeAlphaChanged(int i2) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeStyleChanged(int i2) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onStrokeWidthChanged(int i2) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onEraserWidthChanged(int i2) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onDeleteAll(boolean z) {
            }

            @Override // com.samsung.spensdk.applistener.SettingStrokeChangeListener
            public void onClearAll(boolean z) {
            }
        };
        this.f1904A = new SettingTextChangeListener() { // from class: com.samsung.spen.a.d.b.17
            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextColorChanged(int i2) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextFontChanged(String str) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextSizeChanged(int i2) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextStyleChanged(int i2) {
            }

            @Override // com.samsung.spensdk.applistener.SettingTextChangeListener
            public void onTextAlignmentChanged(int i2) {
            }
        };
        this.f1905B = new SettingFillingChangeListener() { // from class: com.samsung.spen.a.d.b.18
            @Override // com.samsung.spensdk.applistener.SettingFillingChangeListener
            public void onFillingColorChanged(int i2) {
            }
        };
        this.f1906C = new SettingPresetDeleteBtnClickListener() { // from class: com.samsung.spen.a.d.b.19
            @Override // com.samsung.spensdk.applistener.SettingPresetDeleteBtnClickListener
            public void onClick(int i2) {
            }
        };
        this.f1907D = new SPenTouchIDListener() { // from class: com.samsung.spen.a.d.b.20
            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPen(View view, MotionEvent motionEvent, int i2) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchPenEraser(View view, MotionEvent motionEvent, int i2) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onTouchFinger(View view, MotionEvent motionEvent, int i2) {
                return false;
            }

            @Override // com.samsung.spensdk.applistener.SPenTouchIDListener
            public boolean onDrawingPen(View view, MotionEvent motionEvent, int i2, int i22) {
                return false;
            }
        };
        this.f1908E = new InterfaceC1095b() { // from class: com.samsung.spen.a.d.b.21
            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: a */
            public int mo1849a(SObject sObject) {
                return -1;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: a */
            public SObject mo1850a(int i2) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: b */
            public int mo1854b(SObject sObject) {
                return -1;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: c */
            public boolean mo1858c(SObject sObject) {
                return false;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: a */
            public SObject mo1852a(SObject sObject, boolean z) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1095b
            /* renamed from: b */
            public void mo1856b(SObject sObject, boolean z) {
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: a */
            public SObject mo1851a(int i2, int i22) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: a */
            public int mo1848a(int i2, int i22, SObject sObject) {
                return -1;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: b */
            public LinkedList<SObject> mo1855b(int i2) {
                return null;
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: c */
            public void mo1857c(int i2) {
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: d */
            public void mo1859d(int i2) {
            }

            @Override // com.samsung.spen.p005a.p011f.InterfaceC1096c
            /* renamed from: a */
            public boolean mo1853a(SObject sObject, SObject sObject2) {
                return false;
            }
        };
        this.f1909F = null;
        setParentCanvasListener();
    }

    public void setParentCanvasListener() {
        super.setOnInitializeFinishListener(this.f1917h);
        super.setOnCanvasMatrixChangeListener(this.f1918i);
        super.setOnModeChangedListener(this.f1919j);
        super.setOnObjectListener(this.f1912c);
        super.setOnSettingViewShowListener(this.f1910a);
        super.setOnDropperColorChangeListener(this.f1922m);
        super.setOnHistoryChangeListener(this.f1923n);
        super.setOnLongPressListener(this.f1921l);
        super.setOnDrawingInformationListener(this.f1924o);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public void onSetDispatchObjectEvent(boolean z) {
        this.f1915f = z;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public boolean onDrawObject(SObject sObject, boolean z) {
        return drawObject(sObject, z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public boolean onDrawSAMMStrokePoint(int i, float f, float f2, float f3, int i2, long j, long j2) {
        super.drawStrokePoint(i, f, f2, f3, C1083a.m1820i(i2), j, j2);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public boolean onDeleteObject(SObject sObject) {
        return deleteCanvasObject(sObject);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public boolean onChangeObject(SObject sObject) {
        return changeCanvasObject(sObject);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public SObject onSelectSObject(int i, int i2) {
        return m1845a(i, i2);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public void onUpdateSelectedObjectList() {
        m1846a();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1089g
    public boolean onDrawObject(int i, int i2, SObject sObject) {
        return drawObject(i, i2, sObject);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1089g
    public boolean onDeleteObject(int i, int i2) {
        return deleteCanvasObject(i, i2);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1089g
    public boolean onChangeObject(int i, int i2, SObject sObject) {
        return changeCanvasObject(i, i2, sObject);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1089g
    public boolean onDrawStrokePoint(int i, int i2, int i3, float f, float f2, float f3, int i4, long j, long j2) {
        drawStrokePoint(i, i2, i3, f, f2, f3, i4, j, j2);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public boolean onDrawBackgroundImage(Bitmap bitmap) {
        return super.setBackgroundImage(bitmap);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public boolean onDrawCanvasBackground(Bitmap bitmap) {
        return m1847a(bitmap);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public Bitmap onDrawCanvasBackground(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        return m1844a(bitmap, bitmap2, bitmap3);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public boolean onSetCanvasBitmap(Bitmap bitmap, boolean z) {
        if (bitmap == null) {
            super.deleteAll(true);
        }
        if (bitmap != null) {
            super.setBitmap(bitmap, true);
        }
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public Bitmap onGetCanvasBitmap(boolean z) {
        return getBitmap(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public boolean onSetSCanvasBitmapData(byte[] bArr) {
        super.setData(bArr);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public boolean onSetSCanvasSize(int i, int i2) {
        super.setCanvasSize(i, i2);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public byte[] onGetSCanvasBitmapData() {
        return super.getData();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1088f
    public void onSetUsingHistoricalEventForStroke(boolean z) {
        super.setUsingHistoricalEventForStroke(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetPenSetting(int i, float f, int i2) {
        PenSettingInfo penSettingInfo = new PenSettingInfo();
        int iM1817f = C1083a.m1817f(i);
        penSettingInfo.setPenType(iM1817f);
        int i3 = (int) f;
        if (i3 <= 0) {
            i3 = 1;
        }
        if (iM1817f == 4) {
            int i4 = i3 <= 89 ? i3 : 89;
            penSettingInfo.setPenWidth(i4);
            penSettingInfo.setEraserWidth(i4);
        } else {
            if (i3 > 72) {
                i3 = 72;
            }
            penSettingInfo.setPenWidth(iM1817f, i3);
        }
        int i5 = (i2 >> 24) & 255;
        penSettingInfo.setPenAlpha(i5);
        penSettingInfo.setPenAlpha(iM1817f, i5);
        penSettingInfo.setPenColor(i2);
        penSettingInfo.setPenColor(iM1817f, i2);
        super.setPenSettingInfo(penSettingInfo);
        return true;
    }

    public boolean onSetPenSettingView(int i, float f, int i2) {
        PenSettingInfo penSettingInfo = new PenSettingInfo();
        int iM1817f = C1083a.m1817f(i);
        penSettingInfo.setPenType(iM1817f);
        int i3 = (int) f;
        if (i3 <= 0) {
            i3 = 1;
        }
        if (iM1817f == 4) {
            int i4 = i3 <= 89 ? i3 : 89;
            penSettingInfo.setPenWidth(i4);
            penSettingInfo.setEraserWidth(i4);
        } else {
            if (i3 > 72) {
                i3 = 72;
            }
            penSettingInfo.setPenWidth(iM1817f, i3);
        }
        int i5 = (i2 >> 24) & 255;
        penSettingInfo.setPenAlpha(i5);
        penSettingInfo.setPenAlpha(iM1817f, i5);
        penSettingInfo.setPenColor(i2);
        penSettingInfo.setPenColor(iM1817f, i2);
        super.setPenSettingViewInfo(penSettingInfo);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetTextSetting(int i, float f, int i2, String str) {
        TextSettingInfo textSettingInfo = getTextSettingInfo();
        if (textSettingInfo == null) {
            return false;
        }
        textSettingInfo.setTextType(C1083a.m1822k(i));
        textSettingInfo.setTextColor(i2);
        textSettingInfo.setTextSize((int) f);
        textSettingInfo.setTextFont(str);
        super.setTextSettingInfo(textSettingInfo);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetEraserPenSetting(int i) {
        PenSettingInfo penSettingInfo = new PenSettingInfo();
        penSettingInfo.setPenType(4);
        penSettingInfo.setPenWidth(i);
        penSettingInfo.setEraserWidth(i);
        super.setPenSettingInfo(penSettingInfo);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public int onGetColorPickerColor(float f, float f2) {
        return super.getDropperColor(f, f2);
    }

    public int onGetCurrentStyle() {
        TextSettingInfo textSettingInfo;
        int mode = super.getMode();
        if (mode == 1 || mode == 2) {
            PenSettingInfo penSettingInfo = super.getPenSettingInfo();
            if (penSettingInfo == null) {
                return -1;
            }
            return C1083a.m1818g(penSettingInfo.getPenType());
        }
        if (mode != 4 || (textSettingInfo = getTextSettingInfo()) == null) {
            return -1;
        }
        return C1083a.m1823l(textSettingInfo.getTextType());
    }

    public int onGetCurrentSize() {
        TextSettingInfo textSettingInfo;
        int mode = super.getMode();
        if (mode == 1 || mode == 2) {
            PenSettingInfo penSettingInfo = super.getPenSettingInfo();
            if (penSettingInfo == null) {
                return -1;
            }
            if (mode == 1) {
                return penSettingInfo.getPenWidth();
            }
            return penSettingInfo.getEraserWidth();
        }
        if (mode != 4 || (textSettingInfo = getTextSettingInfo()) == null) {
            return -1;
        }
        return textSettingInfo.getTextColor();
    }

    public int onGetCurrentColor() {
        TextSettingInfo textSettingInfo;
        int mode = super.getMode();
        if (mode == 1) {
            PenSettingInfo penSettingInfo = super.getPenSettingInfo();
            if (penSettingInfo == null) {
                return -1;
            }
            return penSettingInfo.getPenColor() | (penSettingInfo.getPenAlpha(penSettingInfo.getPenType()) << 24);
        }
        if (mode != 4 || (textSettingInfo = getTextSettingInfo()) == null) {
            return -1;
        }
        return textSettingInfo.getTextColor();
    }

    public String onGetCurrentTextFontName() {
        TextSettingInfo textSettingInfo;
        if (super.getMode() != 4 || (textSettingInfo = getTextSettingInfo()) == null) {
            return null;
        }
        return textSettingInfo.getTextFont();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetEraserCursorVisible(boolean z) {
        super.setEraserCursorVisible(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetCanvasDrawable(boolean z) {
        super.setDrawable(z);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onGetCanvasDrawable() {
        return super.getDrawable();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetCanvasSupportPenOnly(boolean z) {
        super.setObjectSupportPenOnly(z);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onGetCanvasSupportPenOnly() {
        return super.getObjectSupportPenOnly();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetCanvasZoomEnable(boolean z) {
        super.setZoomEnable(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onGetCanvasZoomEnable() {
        return super.getZoomEnable();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetCanvasPanEnable(boolean z) {
        super.setPanEnable(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onGetCanvasPanEnable() {
        return super.getPanEnable();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetDrawingFront(boolean z) {
        super.setDrawingFront(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetPanningMode(boolean z) {
        super.setPanningMode(z);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onGetPanningMode() {
        return super.getPanningMode();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetColorPickerMode(boolean z) {
        super.setDropperMode(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onIsColorPickerMode() {
        return super.getDropperMode();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetDrawingUpdatable(boolean z) {
        super.setDrawingUpdatable(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetTouchEventDispatchMode(boolean z) {
        super.setTouchEventDispatchMode(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onGetTouchEventDispatchMode() {
        return super.getTouchEventDispatchMode();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetHistoricalOperationSupport(boolean z) {
        super.setHistoricalOperationSupport(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onIsHistoricalOperationSupport() {
        return super.isHistoricalOperationSupport();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetTextLongClickSelectOption(boolean z) {
        super.setTextLongClickSelectOption(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onGetTextLongClickSelectOption() {
        return super.getTextLongClickSelectOption();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetUseCanvasLongPressListener(boolean z) {
        super.setUseLongPressListener(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetRemoveLongPressStroke(boolean z) {
        super.setRemoveLongPressStroke(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public RectF onGetSelectedSObjectRect() {
        return super.getSelectedObjectBounds();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetSelectAllTextByLongPress(boolean z) {
        super.setUseTextBoxLongPress(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetSelectAllTextByDoubleTap(boolean z) {
        super.setUseTextBoxDoubleTap(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onZoomSCanvas(float f) {
        super.zoomTo(f);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onZoomSCanvas(float f, float f2, float f3) {
        super.zoomTo(f, f2, f3);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public float onGetScale() {
        return super.getScale();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetScale(float f) {
        super.setBaseScale(f);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetSCanvasMatrix(Matrix matrix) {
        super.setMatrix(matrix);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetSCanvasMaxZoom(float f) {
        super.setMaxZoom(f);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetSCanvasMinZoom(float f) {
        super.setMinZoom(f);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onPanBySCanvas(float f, float f2) {
        super.panBy(f, f2);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onPanToSCanvas(float f, float f2) {
        super.panTo(f, f2);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public int onGetCanvasMode() {
        return C1083a.m1813b(super.getMode());
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetCanvasMode(int i) {
        if (i != 1 && i != 2 && i != 10 && i != 11 && i != 12 && i != 13 && i != 14) {
            return false;
        }
        super.changeModeTo(C1083a.m1802a(i));
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onUndo() {
        return super.undo();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onUndo(int i) {
        return super.undo(i);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onRedo() {
        return super.redo();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onRedo(int i) {
        return super.redo(i);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onIsUndoable() {
        return super.isUndoable();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onIsUndoable(int i) {
        return super.isUndoable(i);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onIsRedoable() {
        return super.isRedoable();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onIsRedoable(int i) {
        return super.isRedoable(i);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onIsDrawing() {
        return super.isDrawing();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onCancelDrawing() {
        super.cancelDrawing();
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onIsTextEditing() {
        return super.isEditing();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onCancelTextEditing() {
        super.cancelEditing();
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onCancelDrawing(int i) {
        super.cancelDrawing(i);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onCancelAllDrawing() {
        super.cancelAllDrawing();
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onIsAnyoneDrawing() {
        return super.isAnyoneDrawing();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetMultiTouchCancel(boolean z) {
        super.setMultiTouchCancel(z);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onDeleteAll(boolean z) {
        super.deleteAll(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onDeleteAll(boolean z, int i) {
        super.deleteAll(z, i);
    }

    public View onGetCanvasView() {
        return this;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onSetSettingView(ViewGroup viewGroup) {
        if (!(viewGroup instanceof SettingView)) {
            return false;
        }
        this.f1916g = (SettingView) viewGroup;
        super.setSettingView(this.f1916g);
        m1826b();
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onCreateSettingView(Context context, HashMap<String, Integer> map, HashMap<String, String> map2) {
        this.f1916g = new SettingView(context, map, map2);
        m1826b();
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public ViewGroup onGetSettingView() {
        return this.f1916g;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onIsSettingViewVisible(int i) {
        if (!C1099b.m1974d(i)) {
            return false;
        }
        return this.f1916g.isShown(C1083a.m1814c(i));
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onShowSettingView(int i, boolean z) {
        if (!C1099b.m1974d(i)) {
            return false;
        }
        if (z) {
            this.f1916g.showView(C1083a.m1814c(i));
            return true;
        }
        this.f1916g.closeView();
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public int onGetSettingViewSizeOption(int i) {
        int fillingSettingViewSizeOption;
        if (!C1099b.m1974d(i)) {
            return 0;
        }
        if (i == 1) {
            fillingSettingViewSizeOption = this.f1916g.getPenSettingViewSizeOption();
        } else if (i == 2) {
            fillingSettingViewSizeOption = this.f1916g.getEraserSettingViewSizeOption();
        } else if (i == 3) {
            fillingSettingViewSizeOption = this.f1916g.getTextSettingViewSizeOption();
        } else {
            if (i != 4) {
                return -1;
            }
            fillingSettingViewSizeOption = this.f1916g.getFillingSettingViewSizeOption();
        }
        return C1083a.m1816e(fillingSettingViewSizeOption);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onSetSettingViewSizeOption(int i, int i2) {
        if (!C1099b.m1974d(i)) {
            return false;
        }
        int iM1815d = C1083a.m1815d(i2);
        if (i == 1) {
            this.f1916g.setPenSettingViewSizeOption(iM1815d);
        } else if (i == 2) {
            this.f1916g.setEraserSettingViewSizeOption(iM1815d);
        } else if (i == 3) {
            this.f1916g.setTextSettingViewSizeOption(iM1815d);
        } else {
            if (i != 4) {
                return false;
            }
            this.f1916g.setFillingSettingViewSizeOption(iM1815d);
        }
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onSetDeleteAllPopupVisible(boolean z) {
        if (this.f1916g == null) {
            return false;
        }
        this.f1916g.setDeleteAllPopupVisible(z);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onGetDeleteAllPopupVisible() {
        if (this.f1916g != null) {
            return this.f1916g.getDeleteAllPopupVisible();
        }
        return false;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onCloseSettingView() {
        if (this.f1916g == null) {
            return false;
        }
        this.f1916g.closeView();
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onHideIME() {
        super.hideImm();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onSetTextIMEOptionFlagNoExtractUI(boolean z) {
        super.setTextImeOption(z);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onReadyToFileLoad() {
        super.readyToFileLoad();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onDispose() {
        super.dispose();
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onSetTextBoxDefaultSize(int i, int i2) {
        super.setTextBoxDefaultSize(i, i2);
    }

    /* renamed from: b */
    private void m1826b() {
        if (this.f1916g != null) {
            this.f1916g.setOnSettingChangedListener(this.f1913d);
            this.f1916g.setOnDeleteAllConfirmListener(this.f1920k);
            this.f1916g.setOnPresetDelBtnOnClickListener(this.f1911b);
        }
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public SettingStrokeInfo onGetSettingStrokeInfo() {
        PenSettingInfo penSettingInfo = super.getPenSettingInfo();
        if (penSettingInfo == null) {
            return null;
        }
        int penType = penSettingInfo.getPenType();
        int penColor = (penSettingInfo.getPenColor() & 16777215) | (penSettingInfo.getPenAlpha() << 24);
        int eraserWidth = penType == 4 ? penSettingInfo.getEraserWidth() : penSettingInfo.getPenWidth();
        int iM1818g = C1083a.m1818g(penType);
        SettingStrokeInfo settingStrokeInfo = new SettingStrokeInfo();
        settingStrokeInfo.setStrokeStyle(iM1818g);
        settingStrokeInfo.setStrokeColor(penColor);
        settingStrokeInfo.setStrokeWidth(eraserWidth);
        return settingStrokeInfo;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetSettingStrokeInfo(SettingStrokeInfo settingStrokeInfo) {
        if (settingStrokeInfo == null) {
            return false;
        }
        return onSetPenSetting(settingStrokeInfo.getStrokeStyle(), settingStrokeInfo.getStrokeWidth(), settingStrokeInfo.getStrokeColor());
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public SettingStrokeInfo onGetSettingViewStrokeInfo() {
        PenSettingInfo penSettingViewInfo = getPenSettingViewInfo();
        if (penSettingViewInfo == null) {
            return null;
        }
        int penType = penSettingViewInfo.getPenType();
        int penColor = (penSettingViewInfo.getPenColor() & 16777215) | (penSettingViewInfo.getPenAlpha() << 24);
        int eraserWidth = penType == 4 ? penSettingViewInfo.getEraserWidth() : penSettingViewInfo.getPenWidth();
        int iM1818g = C1083a.m1818g(penType);
        SettingStrokeInfo settingStrokeInfo = new SettingStrokeInfo();
        settingStrokeInfo.setStrokeStyle(iM1818g);
        settingStrokeInfo.setStrokeColor(penColor);
        settingStrokeInfo.setStrokeWidth(eraserWidth);
        return settingStrokeInfo;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onSetSettingViewStrokeInfo(SettingStrokeInfo settingStrokeInfo) {
        if (settingStrokeInfo == null) {
            return false;
        }
        return onSetPenSettingView(settingStrokeInfo.getStrokeStyle(), settingStrokeInfo.getStrokeWidth(), settingStrokeInfo.getStrokeColor());
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public SettingTextInfo onGetSettingTextInfo() {
        TextSettingInfo textSettingInfo = getTextSettingInfo();
        if (textSettingInfo == null) {
            return null;
        }
        SettingTextInfo settingTextInfo = new SettingTextInfo();
        settingTextInfo.setTextStyle(C1083a.m1823l(textSettingInfo.getTextType()));
        settingTextInfo.setTextColor(textSettingInfo.getTextColor());
        settingTextInfo.setTextSize(textSettingInfo.getTextSize());
        settingTextInfo.setTextFont(textSettingInfo.getTextFont());
        return settingTextInfo;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public SettingTextInfo onGetSettingViewTextInfo() {
        TextSettingInfo textSettingViewInfo = getTextSettingViewInfo();
        if (textSettingViewInfo == null) {
            return null;
        }
        SettingTextInfo settingTextInfo = new SettingTextInfo();
        settingTextInfo.setTextStyle(C1083a.m1823l(textSettingViewInfo.getTextType()));
        settingTextInfo.setTextColor(textSettingViewInfo.getTextColor());
        settingTextInfo.setTextSize(textSettingViewInfo.getTextSize());
        settingTextInfo.setTextFont(textSettingViewInfo.getTextFont());
        return settingTextInfo;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetSettingTextInfo(SettingTextInfo settingTextInfo) {
        if (settingTextInfo == null) {
            return false;
        }
        TextSettingInfo textSettingInfo = new TextSettingInfo();
        textSettingInfo.setTextType(C1083a.m1822k(settingTextInfo.getTextStyle()));
        textSettingInfo.setTextColor(settingTextInfo.getTextColor());
        textSettingInfo.setTextSize((int) settingTextInfo.getTextSize());
        textSettingInfo.setTextFont(settingTextInfo.getTextFont());
        super.setTextSettingInfo(textSettingInfo);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onSetSettingViewTextInfo(SettingTextInfo settingTextInfo) {
        if (settingTextInfo == null) {
            return false;
        }
        TextSettingInfo textSettingInfo = new TextSettingInfo();
        textSettingInfo.setTextType(C1083a.m1822k(settingTextInfo.getTextStyle()));
        textSettingInfo.setTextColor(settingTextInfo.getTextColor());
        textSettingInfo.setTextSize((int) settingTextInfo.getTextSize());
        textSettingInfo.setTextFont(settingTextInfo.getTextFont());
        super.setTextSettingViewInfo(textSettingInfo);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public SettingFillingInfo onGetSettingFillingInfo() {
        FillingSettingInfo fillingSettingInfo = getFillingSettingInfo();
        if (fillingSettingInfo == null) {
            return null;
        }
        int fillingColor = fillingSettingInfo.getFillingColor();
        SettingFillingInfo settingFillingInfo = new SettingFillingInfo();
        settingFillingInfo.setFillingStyle(0);
        settingFillingInfo.setFillingColor(fillingColor);
        return settingFillingInfo;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public SettingFillingInfo onGetSettingViewFillingInfo() {
        FillingSettingInfo fillingSettingViewInfo = getFillingSettingViewInfo();
        if (fillingSettingViewInfo == null) {
            return null;
        }
        SettingFillingInfo settingFillingInfo = new SettingFillingInfo();
        settingFillingInfo.setFillingStyle(0);
        settingFillingInfo.setFillingColor(fillingSettingViewInfo.getFillingColor());
        return settingFillingInfo;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public boolean onSetSettingFillingInfo(SettingFillingInfo settingFillingInfo) {
        if (settingFillingInfo == null) {
            return false;
        }
        int fillingColor = settingFillingInfo.getFillingColor();
        FillingSettingInfo fillingSettingInfo = getFillingSettingInfo();
        if (fillingSettingInfo == null) {
            return false;
        }
        fillingSettingInfo.setFillingColor(fillingColor);
        super.setFillingSettingInfo(fillingSettingInfo);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onSetSettingViewFillingInfo(SettingFillingInfo settingFillingInfo) {
        if (settingFillingInfo == null) {
            return false;
        }
        FillingSettingInfo fillingSettingInfo = new FillingSettingInfo();
        fillingSettingInfo.setFillingColor(settingFillingInfo.getFillingColor());
        super.setFillingSettingViewInfo(fillingSettingInfo);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onSetOnTouchListener(Object obj) {
        if (obj != null) {
            View.OnTouchListener onTouchListener = (View.OnTouchListener) obj;
            setOnTouchListener(onTouchListener);
            super.setOnSelectedTextViewTouchListener(onTouchListener);
        } else {
            setOnTouchListener(null);
            super.setOnSelectedTextViewTouchListener(null);
        }
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onSetOnHoverListener(Object obj) {
        if (obj != null) {
            View.OnHoverListener onHoverListener = (View.OnHoverListener) obj;
            setOnHoverListener(onHoverListener);
            super.setOnSelectedTextViewHoverListener(onHoverListener);
        } else {
            setOnHoverListener(null);
            super.setOnSelectedTextViewHoverListener(null);
        }
    }

    @Override // com.samsung.sdraw.CanvasView
    public PenSettingInfo getPenSettingInfo(int i) {
        return super.getPenSettingInfo(i);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1087e
    public SettingStrokeInfo onGetSettingStrokeInfo(int i) {
        PenSettingInfo penSettingInfo = getPenSettingInfo(i);
        int penType = penSettingInfo.getPenType();
        int penColor = (penSettingInfo.getPenColor() & 16777215) | (penSettingInfo.getPenAlpha() << 24);
        int eraserWidth = penType == 4 ? penSettingInfo.getEraserWidth() : penSettingInfo.getPenWidth();
        int iM1818g = C1083a.m1818g(penType);
        SettingStrokeInfo settingStrokeInfo = new SettingStrokeInfo();
        settingStrokeInfo.setStrokeStyle(iM1818g);
        settingStrokeInfo.setStrokeColor(penColor);
        settingStrokeInfo.setStrokeWidth(eraserWidth);
        return settingStrokeInfo;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1087e
    public boolean onSetSettingStrokeInfo(int i, SettingStrokeInfo settingStrokeInfo) {
        if (settingStrokeInfo == null) {
            return false;
        }
        return onSetPenSetting(i, settingStrokeInfo.getStrokeStyle(), settingStrokeInfo.getStrokeWidth(), settingStrokeInfo.getStrokeColor());
    }

    public boolean onSetPenSetting(int i, int i2, float f, int i3) {
        PenSettingInfo penSettingInfo = new PenSettingInfo();
        int iM1817f = C1083a.m1817f(i2);
        penSettingInfo.setPenType(iM1817f);
        int i4 = (int) f;
        if (i4 <= 0) {
            i4 = 1;
        }
        if (iM1817f == 4) {
            int i5 = i4 <= 89 ? i4 : 89;
            penSettingInfo.setPenWidth(i5);
            penSettingInfo.setEraserWidth(i5);
        } else {
            if (i4 > 72) {
                i4 = 72;
            }
            penSettingInfo.setPenWidth(iM1817f, i4);
        }
        int i6 = (i3 >> 24) & 255;
        penSettingInfo.setPenAlpha(i6);
        penSettingInfo.setPenAlpha(iM1817f, i6);
        penSettingInfo.setPenColor(i3);
        penSettingInfo.setPenColor(iM1817f, i3);
        super.setPenSettingInfo(i, penSettingInfo);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1087e
    public SettingTextInfo onGetSettingTextInfo(int i) {
        TextSettingInfo textSettingInfo = getTextSettingInfo(i);
        if (textSettingInfo == null) {
            return null;
        }
        SettingTextInfo settingTextInfo = new SettingTextInfo();
        settingTextInfo.setTextStyle(C1083a.m1823l(textSettingInfo.getTextType()));
        settingTextInfo.setTextColor(textSettingInfo.getTextColor());
        settingTextInfo.setTextSize(textSettingInfo.getTextSize());
        settingTextInfo.setTextFont(textSettingInfo.getTextFont());
        return settingTextInfo;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1087e
    public boolean onSetSettingTextInfo(int i, SettingTextInfo settingTextInfo) {
        if (settingTextInfo == null) {
            return false;
        }
        TextSettingInfo textSettingInfo = new TextSettingInfo();
        textSettingInfo.setTextType(C1083a.m1822k(settingTextInfo.getTextStyle()));
        textSettingInfo.setTextColor(settingTextInfo.getTextColor());
        textSettingInfo.setTextSize((int) settingTextInfo.getTextSize());
        textSettingInfo.setTextFont(settingTextInfo.getTextFont());
        super.setTextSettingInfo(i, textSettingInfo);
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public int onGetSettingViewPresetNum() {
        if (this.f1916g != null) {
            return this.f1916g.getPresetCount();
        }
        return 0;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public SettingStrokeInfo onGetSettingViewPresetInfo(int i) {
        PenSettingInfo presetInfo;
        if (this.f1916g == null || (presetInfo = this.f1916g.getPresetInfo(i)) == null) {
            return null;
        }
        return C1083a.m1807a(presetInfo);
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onDeleteSettingViewPresetInfo(int i, boolean z) {
        if (this.f1916g != null) {
            return this.f1916g.deletePresetInfo(i, z);
        }
        return false;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onSetSettingViewPresetCustomDelete(boolean z) {
        if (this.f1916g == null) {
            return false;
        }
        this.f1916g.setCustomDeletePreset(z);
        return true;
    }

    public boolean drawObject(SObject sObject, boolean z) {
        int iMo1849a;
        ObjectInfo objectInfoM1805a;
        if (sObject != null && (iMo1849a = this.f1908E.mo1849a(sObject)) != -1 && (objectInfoM1805a = C1083a.m1805a(sObject, iMo1849a)) != null) {
            if (objectInfoM1805a instanceof StrokeInfo) {
                return drawStrokeObject((StrokeInfo) objectInfoM1805a);
            }
            if (objectInfoM1805a instanceof ImageInfo) {
                return drawImageObject((ImageInfo) objectInfoM1805a, z);
            }
            if (objectInfoM1805a instanceof TextInfo) {
                return drawTextObject((TextInfo) objectInfoM1805a, z);
            }
            if (objectInfoM1805a instanceof FillColorInfo) {
                return drawFillColorObject((FillColorInfo) objectInfoM1805a);
            }
            Log.w(TAG, "I don't know How to draw object : Unknown SAMM Object");
            return false;
        }
        return false;
    }

    public boolean drawObject(int i, int i2, SObject sObject) {
        int iMo1849a;
        ObjectInfo objectInfoM1805a;
        if (sObject != null && (iMo1849a = this.f1908E.mo1849a(sObject)) != -1 && (objectInfoM1805a = C1083a.m1805a(sObject, iMo1849a)) != null) {
            if (objectInfoM1805a instanceof StrokeInfo) {
                return drawStrokeObject(i, i2, (StrokeInfo) objectInfoM1805a);
            }
            if (objectInfoM1805a instanceof ImageInfo) {
                return drawImageObject(i, i2, (ImageInfo) objectInfoM1805a);
            }
            if (objectInfoM1805a instanceof TextInfo) {
                return drawTextObject(i, i2, (TextInfo) objectInfoM1805a);
            }
            Log.w(TAG, "I don't know How to draw object : Unknown SAMM Object");
            return false;
        }
        return false;
    }

    public void drawStrokePoint(int i, int i2, int i3, float f, float f2, float f3, int i4, long j, long j2) {
        super.drawMultiUserStrokePoint(i, i2, i3, f, f2, f3, C1083a.m1820i(i4), j, j2);
    }

    public boolean deleteCanvasObject(SObject sObject) {
        int tempIntData;
        ObjectInfo objectInfoM1805a;
        if (sObject == null || (tempIntData = sObject.getTempIntData("SObjectIDKey", -1)) == -1 || (objectInfoM1805a = C1083a.m1805a(sObject, tempIntData)) == null) {
            return false;
        }
        return super.deleteObject(objectInfoM1805a, true);
    }

    public boolean changeCanvasObject(SObject sObject) {
        int tempIntData;
        ObjectInfo objectInfoM1805a;
        if (sObject == null || (tempIntData = sObject.getTempIntData("SObjectIDKey", -1)) == -1 || (objectInfoM1805a = C1083a.m1805a(sObject, tempIntData)) == null) {
            return false;
        }
        return super.changeObject(objectInfoM1805a);
    }

    /* renamed from: a */
    SObject m1845a(int i, int i2) {
        ObjectInfo objectInfoSelectObject = super.selectObject(i, i2);
        if (objectInfoSelectObject == null) {
            return null;
        }
        return this.f1908E.mo1850a(objectInfoSelectObject.getID());
    }

    /* renamed from: a */
    void m1846a() {
        LinkedList<ObjectInfo> selectedObjectInfos = super.getSelectedObjectInfos();
        if (selectedObjectInfos != null) {
            Iterator<ObjectInfo> it = selectedObjectInfos.iterator();
            while (it.hasNext()) {
                ObjectInfo next = it.next();
                int id = next.getID();
                if (id < 0) {
                    SObject sObjectM1804a = C1083a.m1804a(next);
                    if (sObjectM1804a == null) {
                        Log.e(TAG, "Fail to create SObject");
                        return;
                    }
                    int iMo1854b = this.f1908E.mo1854b(sObjectM1804a);
                    if (iMo1854b >= 0) {
                        next.setID(iMo1854b);
                    } else {
                        return;
                    }
                } else {
                    SObject sObjectMo1850a = this.f1908E.mo1850a(id);
                    if (sObjectMo1850a == null) {
                        Log.e(TAG, "Fail to get SObject");
                        return;
                    } else if (!C1083a.m1810a(next, sObjectMo1850a)) {
                        Log.e(TAG, "Fail to Update SObject List");
                        return;
                    }
                }
            }
        }
    }

    public boolean deleteCanvasObject(int i, int i2) {
        return super.deleteObject(i, i2, false);
    }

    public boolean changeCanvasObject(int i, int i2, SObject sObject) {
        int tempIntData;
        ObjectInfo objectInfoM1806a;
        if (sObject == null || (tempIntData = sObject.getTempIntData("SObjectIDKey", -1)) == -1 || (objectInfoM1806a = C1083a.m1806a(sObject, tempIntData, i, i2)) == null) {
            return false;
        }
        return super.changeObject(i, i2, objectInfoM1806a);
    }

    /* renamed from: a */
    boolean m1847a(Bitmap bitmap) {
        return bitmap != null && super.setBackgroundImage(bitmap);
    }

    /* renamed from: a */
    Bitmap m1844a(Bitmap bitmap, Bitmap bitmap2, Bitmap bitmap3) {
        if (bitmap == null && bitmap2 == null && bitmap3 == null) {
            Log.e(TAG, "setBackgroundTemplete Bitmaps are null");
            return null;
        }
        if (super.setBackgroundTemplate(bitmap, bitmap2, bitmap3)) {
            return super.getBackgroundImage();
        }
        return null;
    }

    public int getCanvasViewObjectNum() {
        LinkedList<ObjectInfo> objectInfos = super.getObjectInfos();
        if (objectInfos == null) {
            return 0;
        }
        return objectInfos.size();
    }

    public int getCanvasObjectID(int i) {
        LinkedList<ObjectInfo> objectInfos = super.getObjectInfos();
        if (objectInfos != null && i >= 0 && i < objectInfos.size()) {
            return objectInfos.get(i).getID();
        }
        return -1;
    }

    public final SObject findSObjectFromCanvasObject(ObjectInfo objectInfo) {
        return this.f1908E.mo1850a(objectInfo.getID());
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1085c
    public void onSetSCanvasInitializeListener(SCanvasInitializeListener sCanvasInitializeListener) {
        this.f1925p = sCanvasInitializeListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1085c
    public void onSetSCanvasMatrixChangeListener(SCanvasMatrixChangeListener sCanvasMatrixChangeListener) {
        this.f1926q = sCanvasMatrixChangeListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1085c
    public void onSetSCanvasModeChangedListener(SCanvasModeChangedListener sCanvasModeChangedListener) {
        this.f1927r = sCanvasModeChangedListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1085c
    public void onSetSCanvasDeleteAllConfirmListener(SCanvasDeleteAllConfirmListener sCanvasDeleteAllConfirmListener) {
        this.f1928s = sCanvasDeleteAllConfirmListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1085c
    public void onSetSCanvasSObjectUpdateListener(SObjectUpdateListener sObjectUpdateListener) {
        this.f1929t = sObjectUpdateListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1085c
    public void onSetSCanvasSObjectSelectListener(SObjectSelectListener sObjectSelectListener) {
        this.f1930u = sObjectSelectListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetOnSCanvasLayoutDropperToolListener(ColorPickerColorChangeListener colorPickerColorChangeListener) {
        this.f1931v = colorPickerColorChangeListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetOnSCanvasLayoutHistoryListener(HistoryUpdateListener historyUpdateListener) {
        this.f1932w = historyUpdateListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetOnSCanvasLayoutLongPressListener(SCanvasLongPressListener sCanvasLongPressListener) {
        this.f1933x = sCanvasLongPressListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onSetOnSCanvasLayoutSettingViewListener(SettingViewShowListener settingViewShowListener) {
        this.f1934y = settingViewShowListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onSetOnSCanvasLayoutPenEraserSettingListener(SettingStrokeChangeListener settingStrokeChangeListener) {
        this.f1935z = settingStrokeChangeListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onSetOnSCanvasLayoutTextSettingListener(SettingTextChangeListener settingTextChangeListener) {
        this.f1904A = settingTextChangeListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onSetOnSCanvasLayoutFillingSettingListener(SettingFillingChangeListener settingFillingChangeListener) {
        this.f1905B = settingFillingChangeListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public void onSetOnSettingViewPresetDeleteBtnClickListener(SettingPresetDeleteBtnClickListener settingPresetDeleteBtnClickListener) {
        this.f1906C = settingPresetDeleteBtnClickListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1089g
    public void onSetSPenTouchIDListener(SPenTouchIDListener sPenTouchIDListener) {
        this.f1907D = sPenTouchIDListener;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
    public void onSetObjectManagerInterface(InterfaceC1094a interfaceC1094a) {
        this.f1908E = interfaceC1094a;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1090h
    public void onSetOnSignatureDataListener(InterfaceC1101b interfaceC1101b) {
        this.f1909F = interfaceC1101b;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onDeleteSettingViewDefaultDescription() {
        if (this.f1916g == null) {
            return false;
        }
        this.f1916g.deleteDefaultDescription();
        return true;
    }

    @Override // com.samsung.spen.p005a.p009d.InterfaceC1091i
    public boolean onIsDeleteSettingViewDefaultDescription() {
        return this.f1916g.isDeleteDefaultDescription();
    }
}
