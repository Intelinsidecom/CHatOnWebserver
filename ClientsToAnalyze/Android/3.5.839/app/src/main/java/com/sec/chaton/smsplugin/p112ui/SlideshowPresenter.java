package com.sec.chaton.smsplugin.p112ui;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;
import com.sec.chaton.R;
import com.sec.chaton.smsplugin.p110g.AbstractC3863i;
import com.sec.chaton.smsplugin.p110g.AbstractC3867m;
import com.sec.chaton.smsplugin.p110g.C3856b;
import com.sec.chaton.smsplugin.p110g.C3861g;
import com.sec.chaton.smsplugin.p110g.C3866l;
import com.sec.chaton.smsplugin.p110g.C3868n;
import com.sec.chaton.smsplugin.p110g.C3869o;
import com.sec.chaton.smsplugin.p110g.C3870p;
import com.sec.chaton.smsplugin.p110g.C3872r;
import com.sec.chaton.smsplugin.p110g.C3873s;
import com.sec.chaton.smsplugin.p110g.EnumC3864j;
import com.sec.chaton.smsplugin.p111h.C3890m;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SlideshowPresenter extends AbstractC4277gx {
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "SlideshowPresenter";
    protected final Handler mHandler;
    protected float mHeightTransformRatio;
    protected int mLocation;
    protected final int mSlideNumber;
    private final InterfaceC4118b mViewSizeChangedListener;
    protected float mWidthTransformRatio;

    public SlideshowPresenter(Context context, InterfaceC4343ji interfaceC4343ji, C3866l c3866l) {
        super(context, interfaceC4343ji, c3866l);
        this.mHandler = new Handler();
        this.mViewSizeChangedListener = new C4324iq(this);
        this.mLocation = 0;
        this.mSlideNumber = ((C3870p) this.mModel).size();
        if (interfaceC4343ji instanceof InterfaceC4091a) {
            ((InterfaceC4091a) interfaceC4343ji).setOnSizeChangedListener(this.mViewSizeChangedListener);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getWidthTransformRatio(int i, int i2) {
        if (i > 0) {
            return i2 / i;
        }
        return 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getHeightTransformRatio(int i, int i2) {
        if (i > 0) {
            return i2 / i;
        }
        return 1.0f;
    }

    private int transformWidth(int i) {
        return (int) (i / this.mWidthTransformRatio);
    }

    private int transformHeight(int i) {
        return (int) (i / this.mHeightTransformRatio);
    }

    @Override // com.sec.chaton.smsplugin.p112ui.AbstractC4277gx
    public void present() {
        presentSlide((InterfaceC4315ih) this.mView, ((C3870p) this.mModel).get(this.mLocation));
    }

    protected void presentSlide(InterfaceC4315ih interfaceC4315ih, C3869o c3869o) {
        interfaceC4315ih.mo15734e();
        try {
            Iterator<AbstractC3863i> it = c3869o.iterator();
            while (it.hasNext()) {
                AbstractC3863i next = it.next();
                if (next instanceof AbstractC3867m) {
                    presentRegionMedia(interfaceC4315ih, (AbstractC3867m) next, true);
                } else if (next.m14821v()) {
                    presentAudio(interfaceC4315ih, (C3856b) next, true);
                }
            }
        } catch (IOException e) {
            C3890m.m14995a(TAG, e.getMessage(), e);
            Toast.makeText(this.mContext, this.mContext.getString(R.string.insufficient_drm_rights), 0).show();
        }
    }

    protected void presentRegionMedia(InterfaceC4315ih interfaceC4315ih, AbstractC3867m abstractC3867m, boolean z) {
        C3868n c3868nM14836F = abstractC3867m.m14836F();
        if (abstractC3867m.m14818s()) {
            presentText(interfaceC4315ih, (C3872r) abstractC3867m, c3868nM14836F, z);
        } else if (abstractC3867m.m14819t()) {
            presentImage(interfaceC4315ih, (C3861g) abstractC3867m, c3868nM14836F, z);
        } else if (abstractC3867m.m14820u()) {
            presentVideo(interfaceC4315ih, (C3873s) abstractC3867m, c3868nM14836F, z);
        }
    }

    protected void presentAudio(InterfaceC4315ih interfaceC4315ih, C3856b c3856b, boolean z) {
        if (z) {
            interfaceC4315ih.setAudio(c3856b.m14814o(), c3856b.m14816q(), c3856b.m14751a());
        }
        EnumC3864j enumC3864jB = c3856b.m14801B();
        if (enumC3864jB == EnumC3864j.START) {
            interfaceC4315ih.mo15728a();
            return;
        }
        if (enumC3864jB == EnumC3864j.PAUSE) {
            interfaceC4315ih.mo15735f();
        } else if (enumC3864jB == EnumC3864j.STOP) {
            interfaceC4315ih.mo15732c();
        } else if (enumC3864jB == EnumC3864j.SEEK) {
            interfaceC4315ih.mo15729a(c3856b.m14800A());
        }
    }

    protected void presentText(InterfaceC4315ih interfaceC4315ih, C3872r c3872r, C3868n c3868n, boolean z) {
        if (z) {
            interfaceC4315ih.setText(c3872r.m14816q(), c3872r.m14940a());
        }
        if (interfaceC4315ih instanceof InterfaceC4091a) {
            ((InterfaceC4091a) interfaceC4315ih).setTextRegion(transformWidth(c3868n.m14841c()), transformHeight(c3868n.m14842d()), transformWidth(c3868n.m14843e()), transformHeight(c3868n.m14844f()));
        }
        interfaceC4315ih.setTextVisibility(c3872r.m14837G());
    }

    protected void presentImage(InterfaceC4315ih interfaceC4315ih, C3861g c3861g, C3868n c3868n, boolean z) {
        if (z) {
            interfaceC4315ih.setImage(c3861g.m14816q(), c3861g.m14777f());
        }
        if (interfaceC4315ih instanceof InterfaceC4091a) {
            ((InterfaceC4091a) interfaceC4315ih).setImageRegion(transformWidth(c3868n.m14841c()), transformHeight(c3868n.m14842d()), transformWidth(c3868n.m14843e()), transformHeight(c3868n.m14844f()));
        }
        interfaceC4315ih.setImageRegionFit(c3868n.m14840b());
        interfaceC4315ih.setImageVisibility(c3861g.m14837G());
    }

    protected void presentVideo(InterfaceC4315ih interfaceC4315ih, C3873s c3873s, C3868n c3868n, boolean z) {
        if (z) {
            interfaceC4315ih.setVideo(c3873s.m14816q(), c3873s.m14814o());
        }
        if (interfaceC4315ih instanceof InterfaceC4091a) {
            ((InterfaceC4091a) interfaceC4315ih).setVideoRegion(transformWidth(c3868n.m14841c()), transformHeight(c3868n.m14842d()), transformWidth(c3868n.m14843e()), transformHeight(c3868n.m14844f()));
        }
        interfaceC4315ih.setVideoVisibility(c3873s.m14837G());
        EnumC3864j enumC3864jB = c3873s.m14801B();
        if (enumC3864jB == EnumC3864j.START) {
            interfaceC4315ih.mo15730b();
            return;
        }
        if (enumC3864jB == EnumC3864j.PAUSE) {
            interfaceC4315ih.mo15736g();
        } else if (enumC3864jB == EnumC3864j.STOP) {
            interfaceC4315ih.mo15733d();
        } else if (enumC3864jB == EnumC3864j.SEEK) {
            interfaceC4315ih.mo15731b(c3873s.m14800A());
        }
    }

    public void setLocation(int i) {
        this.mLocation = i;
    }

    public int getLocation() {
        return this.mLocation;
    }

    public void goBackward() {
        if (this.mLocation > 0) {
            this.mLocation--;
        }
    }

    public void goForward() {
        if (this.mLocation < this.mSlideNumber - 1) {
            this.mLocation++;
        }
    }

    @Override // com.sec.chaton.smsplugin.p110g.InterfaceC3860f
    public void onModelChanged(C3866l c3866l, boolean z) {
        InterfaceC4315ih interfaceC4315ih = (InterfaceC4315ih) this.mView;
        if (!(c3866l instanceof C3870p)) {
            if (c3866l instanceof C3869o) {
                if (((C3869o) c3866l).m14859c()) {
                    this.mHandler.post(new RunnableC4325ir(this, interfaceC4315ih, c3866l));
                    return;
                } else {
                    this.mHandler.post(new RunnableC4326is(this));
                    return;
                }
            }
            if (c3866l instanceof AbstractC3863i) {
                if (c3866l instanceof AbstractC3867m) {
                    this.mHandler.post(new RunnableC4327it(this, interfaceC4315ih, c3866l, z));
                    return;
                } else {
                    if (((AbstractC3863i) c3866l).m14821v()) {
                        this.mHandler.post(new RunnableC4328iu(this, interfaceC4315ih, c3866l, z));
                        return;
                    }
                    return;
                }
            }
            if (c3866l instanceof C3868n) {
            }
        }
    }
}
