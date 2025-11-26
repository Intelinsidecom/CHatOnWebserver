package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import com.sec.chaton.smsplugin.p110g.C3866l;
import com.sec.chaton.smsplugin.p110g.InterfaceC3860f;

/* compiled from: Presenter.java */
/* renamed from: com.sec.chaton.smsplugin.ui.gx */
/* loaded from: classes.dex */
public abstract class AbstractC4277gx implements InterfaceC3860f {
    protected final Context mContext;
    protected C3866l mModel;
    protected InterfaceC4343ji mView;

    public abstract void present();

    public AbstractC4277gx(Context context, InterfaceC4343ji interfaceC4343ji, C3866l c3866l) {
        this.mContext = context;
        this.mView = interfaceC4343ji;
        this.mModel = c3866l;
        this.mModel.m14834c(this);
    }

    public InterfaceC4343ji getView() {
        return this.mView;
    }

    public void setView(InterfaceC4343ji interfaceC4343ji) {
        this.mView = interfaceC4343ji;
    }

    public C3866l getModel() {
        return this.mModel;
    }
}
