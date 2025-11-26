package com.samsung.spen.p005a.p007b;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.samsung.spen.p005a.p009d.InterfaceC1086d;
import com.samsung.spen.p005a.p011f.InterfaceC1094a;
import com.samsung.spen.settings.SettingFillingInfo;
import com.samsung.spen.settings.SettingStrokeInfo;
import com.samsung.spen.settings.SettingTextInfo;
import com.samsung.spensdk.applistener.ColorPickerColorChangeListener;
import com.samsung.spensdk.applistener.HistoryUpdateListener;
import com.samsung.spensdk.applistener.SCanvasLongPressListener;

/* renamed from: com.samsung.spen.a.b.a */
/* loaded from: classes.dex */
public class C1073a implements InterfaceC1074b {

    /* renamed from: a */
    Context f1864a;

    /* renamed from: b */
    int f1865b;

    /* renamed from: c */
    int f1866c;

    /* renamed from: d */
    private boolean f1867d = false;

    /* renamed from: e */
    private InterfaceC1086d f1868e = new InterfaceC1086d() { // from class: com.samsung.spen.a.b.a.1
        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public SettingStrokeInfo onGetSettingStrokeInfo() {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetSettingStrokeInfo(SettingStrokeInfo settingStrokeInfo) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetPenSetting(int i, float f, int i2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetEraserPenSetting(int i) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public SettingTextInfo onGetSettingTextInfo() {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetSettingTextInfo(SettingTextInfo settingTextInfo) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetTextSetting(int i, float f, int i2, String str) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public SettingFillingInfo onGetSettingFillingInfo() {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetSettingFillingInfo(SettingFillingInfo settingFillingInfo) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public int onGetColorPickerColor(float f, float f2) {
            return 0;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public int onGetCanvasMode() {
            return 0;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onIsRedoable() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onIsRedoable(int i) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onIsUndoable() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onIsUndoable(int i) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onRedo() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onRedo(int i) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onIsDrawing() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onCancelDrawing() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onIsTextEditing() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onCancelTextEditing() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onCancelDrawing(int i) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onCancelAllDrawing() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onIsAnyoneDrawing() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetMultiTouchCancel(boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onDeleteAll(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onDeleteAll(boolean z, int i) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetCanvasDrawable(boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onGetCanvasDrawable() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetCanvasSupportPenOnly(boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onGetCanvasSupportPenOnly() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetCanvasZoomEnable(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onGetCanvasZoomEnable() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetCanvasPanEnable(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onGetCanvasPanEnable() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetDrawingFront(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetCanvasMode(int i) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetEraserCursorVisible(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetPanningMode(boolean z) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onGetPanningMode() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetColorPickerMode(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onIsColorPickerMode() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetDrawingUpdatable(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetTouchEventDispatchMode(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onGetTouchEventDispatchMode() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetHistoricalOperationSupport(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onIsHistoricalOperationSupport() {
            return true;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetTextLongClickSelectOption(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onGetTextLongClickSelectOption() {
            return true;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetUseCanvasLongPressListener(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onUndo() {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onUndo(int i) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onZoomSCanvas(float f) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onZoomSCanvas(float f, float f2, float f3) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public float onGetScale() {
            return -1.0f;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetScale(float f) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetSCanvasMatrix(Matrix matrix) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetSCanvasMaxZoom(float f) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onSetSCanvasMinZoom(float f) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onPanBySCanvas(float f, float f2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public boolean onPanToSCanvas(float f, float f2) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetObjectManagerInterface(InterfaceC1094a interfaceC1094a) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetOnSCanvasLayoutLongPressListener(SCanvasLongPressListener sCanvasLongPressListener) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetOnSCanvasLayoutDropperToolListener(ColorPickerColorChangeListener colorPickerColorChangeListener) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetOnSCanvasLayoutHistoryListener(HistoryUpdateListener historyUpdateListener) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public RectF onGetSelectedSObjectRect() {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetRemoveLongPressStroke(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetSelectAllTextByLongPress(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1086d
        public void onSetSelectAllTextByDoubleTap(boolean z) {
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1087e
        public SettingStrokeInfo onGetSettingStrokeInfo(int i) {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1087e
        public boolean onSetSettingStrokeInfo(int i, SettingStrokeInfo settingStrokeInfo) {
            return false;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1087e
        public SettingTextInfo onGetSettingTextInfo(int i) {
            return null;
        }

        @Override // com.samsung.spen.p005a.p009d.InterfaceC1087e
        public boolean onSetSettingTextInfo(int i, SettingTextInfo settingTextInfo) {
            return false;
        }
    };

    public C1073a(Context context, int i, int i2) {
        this.f1864a = context;
        this.f1865b = i;
        this.f1866c = i2;
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1076d
    /* renamed from: a */
    public SettingStrokeInfo mo1694a(int i) {
        return this.f1868e.onGetSettingStrokeInfo(i);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1076d
    /* renamed from: a */
    public boolean mo1702a(int i, SettingStrokeInfo settingStrokeInfo) {
        return this.f1868e.onSetSettingStrokeInfo(i, settingStrokeInfo);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1076d
    /* renamed from: b */
    public SettingTextInfo mo1709b(int i) {
        return this.f1868e.onGetSettingTextInfo(i);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1076d
    /* renamed from: a */
    public boolean mo1703a(int i, SettingTextInfo settingTextInfo) {
        return this.f1868e.onSetSettingTextInfo(i, settingTextInfo);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: b */
    public SettingStrokeInfo mo1708b() {
        return this.f1868e.onGetSettingStrokeInfo();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public boolean mo1706a(SettingStrokeInfo settingStrokeInfo) {
        return this.f1868e.onSetSettingStrokeInfo(settingStrokeInfo);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: c */
    public SettingTextInfo mo1712c() {
        return this.f1868e.onGetSettingTextInfo();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public boolean mo1707a(SettingTextInfo settingTextInfo) {
        return this.f1868e.onSetSettingTextInfo(settingTextInfo);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: d */
    public SettingFillingInfo mo1717d() {
        return this.f1868e.onGetSettingFillingInfo();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public boolean mo1705a(SettingFillingInfo settingFillingInfo) {
        return this.f1868e.onSetSettingFillingInfo(settingFillingInfo);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: c */
    public boolean mo1715c(int i) {
        return this.f1868e.onSetEraserPenSetting(i);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public int mo1693a(float f, float f2) {
        return this.f1868e.onGetColorPickerColor(f, f2);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public boolean mo1700a(float f) {
        return this.f1868e.onZoomSCanvas(f);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public boolean mo1701a(float f, float f2, float f3) {
        return this.f1868e.onZoomSCanvas(f, f2, f3);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: e */
    public float mo1721e() {
        return this.f1868e.onGetScale();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: b */
    public boolean mo1710b(float f) {
        return this.f1868e.onSetScale(f);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public boolean mo1704a(Matrix matrix) {
        return this.f1868e.onSetSCanvasMatrix(matrix);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: c */
    public boolean mo1713c(float f) {
        return this.f1868e.onSetSCanvasMaxZoom(f);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: d */
    public boolean mo1718d(float f) {
        return this.f1868e.onSetSCanvasMinZoom(f);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: b */
    public boolean mo1711b(float f, float f2) {
        return this.f1868e.onPanBySCanvas(f, f2);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: c */
    public boolean mo1714c(float f, float f2) {
        return this.f1868e.onPanToSCanvas(f, f2);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: c */
    public boolean mo1716c(boolean z) {
        return this.f1868e.onSetPanningMode(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: f */
    public boolean mo1725f() {
        return this.f1868e.onGetPanningMode();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: g */
    public int mo1727g() {
        return this.f1868e.onGetCanvasMode();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: d */
    public boolean mo1719d(int i) {
        return this.f1868e.onSetCanvasMode(i);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: d */
    public boolean mo1720d(boolean z) {
        return this.f1868e.onSetCanvasDrawable(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: h */
    public boolean mo1731h() {
        return this.f1868e.onGetCanvasDrawable();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: e */
    public boolean mo1723e(boolean z) {
        return this.f1868e.onSetCanvasSupportPenOnly(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: i */
    public boolean mo1734i() {
        return this.f1868e.onGetCanvasSupportPenOnly();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: f */
    public void mo1724f(boolean z) {
        this.f1868e.onSetCanvasZoomEnable(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: j */
    public boolean mo1737j() {
        return this.f1868e.onGetCanvasZoomEnable();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: g */
    public void mo1728g(boolean z) {
        this.f1868e.onSetCanvasPanEnable(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: k */
    public boolean mo1738k() {
        return this.f1868e.onGetCanvasPanEnable();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: h */
    public void mo1730h(boolean z) {
        this.f1868e.onSetDrawingFront(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: i */
    public void mo1733i(boolean z) {
        this.f1868e.onSetColorPickerMode(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: l */
    public boolean mo1741l() {
        return this.f1868e.onIsColorPickerMode();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: j */
    public void mo1736j(boolean z) {
        this.f1868e.onSetDrawingUpdatable(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: k */
    public boolean mo1739k(boolean z) {
        return this.f1868e.onSetMultiTouchCancel(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: l */
    public void mo1740l(boolean z) {
        this.f1868e.onSetTouchEventDispatchMode(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: m */
    public boolean mo1743m() {
        return this.f1868e.onGetTouchEventDispatchMode();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: m */
    public void mo1742m(boolean z) {
        this.f1868e.onSetHistoricalOperationSupport(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: n */
    public boolean mo1745n() {
        return this.f1868e.onIsHistoricalOperationSupport();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: n */
    public void mo1744n(boolean z) {
        this.f1868e.onSetTextLongClickSelectOption(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: o */
    public boolean mo1747o() {
        return this.f1868e.onGetTextLongClickSelectOption();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: o */
    public void mo1746o(boolean z) {
        this.f1868e.onSetUseCanvasLongPressListener(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: p */
    public RectF mo1748p() {
        return this.f1868e.onGetSelectedSObjectRect();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: p */
    public void mo1749p(boolean z) {
        this.f1868e.onSetRemoveLongPressStroke(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: q */
    public void mo1750q(boolean z) {
        this.f1868e.onSetSelectAllTextByLongPress(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: r */
    public void mo1752r(boolean z) {
        this.f1868e.onSetSelectAllTextByDoubleTap(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: q */
    public boolean mo1751q() {
        return this.f1868e.onUndo();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: e */
    public boolean mo1722e(int i) {
        return this.f1868e.onUndo(i);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: r */
    public boolean mo1753r() {
        return this.f1868e.onRedo();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: f */
    public boolean mo1726f(int i) {
        return this.f1868e.onRedo(i);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: s */
    public boolean mo1755s() {
        return this.f1868e.onIsUndoable();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: g */
    public boolean mo1729g(int i) {
        return this.f1868e.onIsUndoable(i);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: t */
    public boolean mo1756t() {
        return this.f1868e.onIsRedoable();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: h */
    public boolean mo1732h(int i) {
        return this.f1868e.onIsRedoable(i);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: u */
    public boolean mo1757u() {
        return this.f1868e.onIsDrawing();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: v */
    public boolean mo1758v() {
        return this.f1868e.onCancelDrawing();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: w */
    public boolean mo1759w() {
        return this.f1868e.onIsTextEditing();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: x */
    public boolean mo1760x() {
        return this.f1868e.onCancelTextEditing();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: i */
    public boolean mo1735i(int i) {
        return this.f1868e.onCancelDrawing(i);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: y */
    public boolean mo1761y() {
        return this.f1868e.onCancelAllDrawing();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: z */
    public boolean mo1762z() {
        return this.f1868e.onIsAnyoneDrawing();
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: s */
    public void mo1754s(boolean z) {
        this.f1868e.onDeleteAll(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public void mo1699a(boolean z, int i) {
        this.f1868e.onDeleteAll(z, i);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1075c
    /* renamed from: a */
    public boolean mo1673a(int i, float f, int i2) {
        return this.f1868e.onSetPenSetting(i, f, i2);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1075c
    /* renamed from: a */
    public boolean mo1674a(int i, float f, int i2, String str) {
        return this.f1868e.onSetTextSetting(i, f, i2, str);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1075c
    /* renamed from: a */
    public void mo1671a(boolean z) {
        this.f1867d = z;
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1075c
    /* renamed from: a */
    public boolean mo1672a() {
        return this.f1867d;
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1075c
    /* renamed from: b */
    public void mo1675b(boolean z) {
        this.f1868e.onSetEraserCursorVisible(z);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public void mo1696a(ColorPickerColorChangeListener colorPickerColorChangeListener) {
        this.f1868e.onSetOnSCanvasLayoutDropperToolListener(colorPickerColorChangeListener);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public void mo1697a(HistoryUpdateListener historyUpdateListener) {
        this.f1868e.onSetOnSCanvasLayoutHistoryListener(historyUpdateListener);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public void mo1698a(SCanvasLongPressListener sCanvasLongPressListener) {
        this.f1868e.onSetOnSCanvasLayoutLongPressListener(sCanvasLongPressListener);
    }

    @Override // com.samsung.spen.p005a.p007b.InterfaceC1074b
    /* renamed from: a */
    public void mo1695a(InterfaceC1086d interfaceC1086d) {
        this.f1868e = interfaceC1086d;
    }
}
