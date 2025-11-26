package com.samsung.sdraw;

import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class ScrollThumbController {

    /* renamed from: a */
    AbstractSettingView f1161a;

    /* renamed from: b */
    private boolean f1162b = false;

    /* renamed from: com.samsung.sdraw.ScrollThumbController$a */
    enum EnumC0984a {
        NOR,
        PRE,
        FOC,
        SEL;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static EnumC0984a[] valuesCustom() {
            EnumC0984a[] enumC0984aArrValuesCustom = values();
            int length = enumC0984aArrValuesCustom.length;
            EnumC0984a[] enumC0984aArr = new EnumC0984a[length];
            System.arraycopy(enumC0984aArrValuesCustom, 0, enumC0984aArr, 0, length);
            return enumC0984aArr;
        }
    }

    public ScrollThumbController(AbstractSettingView settingView) {
        this.f1161a = settingView;
    }

    public void onLayout(boolean isPenSetting) {
        boolean z;
        relayoutSettingView(C1042ca.m1518a(this.f1161a.getContext()), false);
        C1044cc c1044ccM1063b = m1063b(isPenSetting);
        if (c1044ccM1063b != null) {
            moveScrollControlThumb(c1044ccM1063b.f1695aj.getScrollY(), isPenSetting);
            if (m1060a(isPenSetting) <= 0) {
                z = c1044ccM1063b.f1693ah.getVisibility() == 0;
                c1044ccM1063b.f1693ah.setVisibility(8);
            } else if (m1062a(c1044ccM1063b)) {
                z = c1044ccM1063b.f1693ah.getVisibility() == 0;
                c1044ccM1063b.f1693ah.setVisibility(8);
            } else {
                boolean z2 = c1044ccM1063b.f1693ah.getVisibility() == 8;
                c1044ccM1063b.f1693ah.setVisibility(0);
                z = z2;
            }
            this.f1161a.m770a(isPenSetting ? 1 : 3, z);
            m1061a(c1044ccM1063b.f1693ah);
        }
    }

    public void relayoutSettingView(boolean portrait, boolean fromCanvas) {
        if (this.f1161a.f782o != null) {
            relayoutSettingView(portrait, fromCanvas, this.f1161a.f782o);
        }
        if (this.f1161a.f784q != null) {
            relayoutSettingView(portrait, fromCanvas, this.f1161a.f784q);
        }
    }

    public void onScroll(MotionEvent event, boolean isPenSetting) {
        int action = event.getAction();
        C1044cc c1044ccM1063b = m1063b(isPenSetting);
        if (c1044ccM1063b != null) {
            if (action == 0 || action == 2) {
                m1064a(c1044ccM1063b, EnumC0984a.PRE);
                moveScrollControlThumb(event.getY() - (c1044ccM1063b.f1694ai.getHeight() / 2.0f), true, isPenSetting);
            } else if (action == 1 || action == 3) {
                m1064a(c1044ccM1063b, EnumC0984a.NOR);
            }
        }
    }

    /* renamed from: a */
    void m1064a(C1044cc c1044cc, EnumC0984a enumC0984a) {
        if (c1044cc != null) {
            if (enumC0984a == EnumC0984a.NOR) {
                if (this.f1161a.getContext().getResources().getDisplayMetrics().densityDpi == 480) {
                    c1044cc.f1694ai.setImageDrawable(c1044cc.m1527b("/snote_popup_scroll_handle_n_480.png"));
                    return;
                } else {
                    c1044cc.f1694ai.setImageDrawable(c1044cc.m1527b("/snote_popup_scroll_handle_n.png"));
                    return;
                }
            }
            if (enumC0984a == EnumC0984a.PRE) {
                if (this.f1161a.getContext().getResources().getDisplayMetrics().densityDpi == 480) {
                    c1044cc.f1694ai.setImageDrawable(c1044cc.m1527b("/snote_popup_scroll_handle_p_480.png"));
                } else {
                    c1044cc.f1694ai.setImageDrawable(c1044cc.m1527b("/snote_popup_scroll_handle_p.png"));
                }
            }
        }
    }

    public void moveScrollControlThumb(int scrollY, boolean isPenSetting) {
        C1044cc c1044cc;
        int i;
        boolean z;
        if (isPenSetting) {
            c1044cc = this.f1161a.f782o;
            i = 1;
        } else {
            c1044cc = this.f1161a.f784q;
            i = 3;
        }
        if (c1044cc != null) {
            int height = c1044cc.f1693ah.getHeight();
            int height2 = c1044cc.f1694ai.getHeight();
            if (m1060a(isPenSetting) <= 0) {
                z = c1044cc.f1693ah.getVisibility() == 0;
                c1044cc.f1693ah.setVisibility(8);
            } else if (m1062a(c1044cc)) {
                z = c1044cc.f1693ah.getVisibility() == 0;
                c1044cc.f1693ah.setVisibility(8);
            } else {
                z = c1044cc.f1693ah.getVisibility() == 8;
                c1044cc.f1693ah.setVisibility(0);
            }
            this.f1161a.m770a(i, z);
            m1061a(c1044cc.f1693ah);
            if (height > 0 && height2 > 0) {
                moveScrollControlThumb((int) (((height - c1044cc.getThumbPaddingTop()) - height2) * (scrollY / r6)), false, isPenSetting);
            }
        }
    }

    /* renamed from: a */
    private boolean m1062a(C1044cc c1044cc) {
        if (c1044cc == null) {
            return false;
        }
        return c1044cc instanceof C0999al ? this.f1161a.getPenSettingViewSizeOption() == 1 && this.f1161a.f782o.f1506t.getVisibility() != 0 : this.f1161a.getTextSettingViewSizeOption() == 1 && this.f1161a.f784q.f1619O.getVisibility() != 0;
    }

    public void moveScrollControlThumb(float marginTop, boolean ToMoveScrollView, boolean isPenSetting) {
        int i;
        C1044cc c1044ccM1063b = m1063b(isPenSetting);
        if (c1044ccM1063b != null) {
            int height = c1044ccM1063b.f1693ah.getHeight();
            int height2 = c1044ccM1063b.f1694ai.getHeight();
            if (height > 0 && height2 > 0) {
                int thumbPaddingTop = (height - c1044ccM1063b.getThumbPaddingTop()) - height2;
                float fM1060a = m1060a(isPenSetting);
                if (marginTop < VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET) {
                    marginTop = VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET;
                } else if (marginTop > thumbPaddingTop) {
                    marginTop = thumbPaddingTop;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) c1044ccM1063b.f1694ai.getLayoutParams();
                layoutParams.topMargin = (int) marginTop;
                c1044ccM1063b.f1694ai.setLayoutParams(layoutParams);
                if (ToMoveScrollView || this.f1162b) {
                    if (this.f1162b) {
                        i = (int) fM1060a;
                        this.f1162b = false;
                    } else {
                        i = (int) ((marginTop / thumbPaddingTop) * fM1060a);
                        if (i < 0) {
                            i = 0;
                        } else if (i > fM1060a) {
                            i = (int) fM1060a;
                        }
                    }
                    c1044ccM1063b.f1695aj.scrollTo(0, i);
                }
            }
        }
    }

    public void relayoutSettingView(boolean z, boolean z2, C1044cc c1044cc) {
        boolean z3;
        if (c1044cc != null) {
            boolean z4 = c1044cc instanceof C0999al;
            if (m1062a(c1044cc)) {
                boolean z5 = c1044cc.f1693ah.getVisibility() == 0;
                c1044cc.f1693ah.setVisibility(8);
                this.f1161a.m770a(c1044cc instanceof C0999al ? 1 : 3, z5);
                m1061a(c1044cc.f1693ah);
                return;
            }
            if (c1044cc instanceof C0999al) {
                ((C0999al) c1044cc).f1452C.setVisibility(0);
            }
            if (!z4 && !this.f1161a.f784q.f1616L.isSelected()) {
                boolean z6 = c1044cc.f1693ah.getVisibility() == 0;
                c1044cc.f1693ah.setVisibility(8);
                this.f1161a.m770a(3, z6);
                m1061a(c1044cc.f1693ah);
                return;
            }
            if (m1060a(c1044cc instanceof C0999al) <= 0) {
                z3 = (c1044cc.f1693ah.getVisibility() == 0 && !z2) || (c1044cc.f1693ah.getVisibility() == 8 && z2);
                c1044cc.f1693ah.setVisibility(z2 ? 0 : 8);
            } else {
                z3 = (c1044cc.f1693ah.getVisibility() == 0 && z2) || (c1044cc.f1693ah.getVisibility() == 8 && !z2);
                c1044cc.f1693ah.setVisibility(z2 ? 8 : 0);
            }
            this.f1161a.m770a(c1044cc instanceof C0999al ? 1 : 3, z3);
            m1061a(c1044cc.f1693ah);
        }
    }

    /* renamed from: a */
    private void m1061a(final View view) {
        view.postDelayed(new Runnable() { // from class: com.samsung.sdraw.ScrollThumbController.1
            @Override // java.lang.Runnable
            public void run() {
                view.requestLayout();
                view.invalidate();
            }
        }, 100L);
    }

    /* renamed from: a */
    private int m1060a(boolean z) {
        C1044cc c1044ccM1063b = m1063b(z);
        if (c1044ccM1063b == null || c1044ccM1063b.f1695aj == null) {
            return 0;
        }
        return c1044ccM1063b.f1695aj.computeVerticalScrollRange() - c1044ccM1063b.f1695aj.getHeight();
    }

    /* renamed from: b */
    private C1044cc m1063b(boolean z) {
        if (z) {
            return this.f1161a.f782o;
        }
        return this.f1161a.f784q;
    }

    public void setScrollToMax() {
        this.f1162b = true;
    }
}
