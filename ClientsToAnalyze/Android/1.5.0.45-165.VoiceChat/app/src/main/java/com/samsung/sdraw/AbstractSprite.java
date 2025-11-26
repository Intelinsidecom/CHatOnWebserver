package com.samsung.sdraw;

import android.graphics.RectF;

/* loaded from: classes.dex */
abstract class AbstractSprite implements InterfaceC1008au, InterfaceC1011ax, InterfaceC1057m, InterfaceC1070z {

    /* renamed from: a */
    protected boolean f830a;

    /* renamed from: b */
    protected RectF f831b = new RectF();

    /* renamed from: c */
    protected boolean f832c;

    /* renamed from: d */
    private InterfaceC1070z f833d;

    /* renamed from: e */
    private InterfaceC1057m f834e;

    /* renamed from: f */
    private InterfaceC1011ax f835f;

    /* renamed from: g */
    private int f836g;
    public int multiObjectID;
    public int multiUserID;
    public int objectID;

    public abstract void dispose();

    public abstract StringBuilder toXML();

    public AbstractSprite() {
        setVisible(false);
    }

    @Override // com.samsung.sdraw.InterfaceC1011ax
    public void deselect() {
        this.f835f.deselect();
    }

    @Override // com.samsung.sdraw.InterfaceC1011ax
    public boolean isSelected() {
        return this.f835f.isSelected();
    }

    @Override // com.samsung.sdraw.InterfaceC1011ax
    public void select() {
        this.f835f.select();
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void moveBy(PointF point) {
        this.f834e.moveBy(point);
        mo1136a();
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void resizeTo(RectF rect) {
        this.f834e.resizeTo(rect);
        mo1136a();
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void resizeTo(PointF[] resize) {
        this.f834e.resizeTo(resize);
        mo1136a();
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void rotateTo(float angle) {
        this.f834e.rotateTo(angle);
        mo1136a();
    }

    @Override // com.samsung.sdraw.InterfaceC1057m
    public void moveTo(float x, float y) {
        this.f834e.moveTo(x, y);
        mo1136a();
    }

    @Override // com.samsung.sdraw.InterfaceC1070z
    public boolean isHitted(RectF rect) {
        return this.f833d.isHitted(rect);
    }

    @Override // com.samsung.sdraw.InterfaceC1070z
    public boolean isHitted(PointF point) {
        return this.f833d.isHitted(point);
    }

    public void setVisible(boolean isVisible) {
        this.f830a = isVisible;
    }

    public boolean isVisible() {
        return this.f830a;
    }

    public RectF getBounds() {
        return this.f831b;
    }

    public void setBehavior(InterfaceC1070z hitBehavior, InterfaceC1057m dragBehavior, InterfaceC1011ax selectBehavior) {
        this.f833d = hitBehavior;
        this.f834e = dragBehavior;
        this.f835f = selectBehavior;
    }

    public int getLayerID() {
        return this.f836g;
    }

    public void setLayerID(int layerID) {
        this.f836g = layerID;
    }

    public boolean isPublicLayer() {
        return this.f836g == 0 || this.f836g == 2;
    }
}
