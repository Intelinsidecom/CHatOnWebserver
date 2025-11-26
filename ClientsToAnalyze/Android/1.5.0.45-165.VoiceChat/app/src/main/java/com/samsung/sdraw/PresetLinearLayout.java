package com.samsung.sdraw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import com.samsung.sdraw.StrokeSprite;
import com.vlingo.sdk.recognition.spotter.VLSpotterContext;

/* loaded from: classes.dex */
public class PresetLinearLayout extends LinearLayout {

    /* renamed from: h */
    private static String[] f1136h;

    /* renamed from: a */
    protected String f1137a;

    /* renamed from: b */
    protected C1006as f1138b;

    /* renamed from: c */
    protected StrokeSprite f1139c;

    /* renamed from: d */
    protected Drawable[] f1140d;

    /* renamed from: e */
    protected View.OnClickListener f1141e;

    /* renamed from: f */
    protected View.OnClickListener f1142f;

    /* renamed from: g */
    protected OnClickPresetItemListener f1143g;

    /* renamed from: i */
    private View.OnFocusChangeListener f1144i;

    /* renamed from: j */
    private InterfaceC0982a f1145j;

    public interface OnClickPresetItemListener {
        void deletePresetItem(int i);

        void selectPresetItem(int i);
    }

    /* renamed from: com.samsung.sdraw.PresetLinearLayout$a */
    interface InterfaceC0982a {
        /* renamed from: a */
        void mo803a(int i, View view);
    }

    static {
        String[] strArr = new String[6];
        strArr[0] = "/snote_popup_btn_03.png";
        strArr[1] = "/snote_popup_btn_04.png";
        strArr[2] = "/snote_popup_btn_02.png";
        strArr[3] = "/snote_popup_btn_01.png";
        strArr[5] = "/snote_popup_btn_05.png";
        f1136h = strArr;
    }

    public PresetLinearLayout(Context context) {
        super(context);
        this.f1144i = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.PresetLinearLayout.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (!v.isPressed() && hasFocus) {
                    if (v.getId() == 12070501 || v.getId() == 12070701) {
                        final ScrollView scrollView = (ScrollView) PresetLinearLayout.this.getParent().getParent();
                        PresetLinearLayout.this.postDelayed(new Runnable() { // from class: com.samsung.sdraw.PresetLinearLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                scrollView.scrollTo(0, 0);
                            }
                        }, 250L);
                    }
                }
            }
        };
        this.f1141e = new View.OnClickListener() { // from class: com.samsung.sdraw.PresetLinearLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int id = v.getId() - 12070501;
                if (v.getParent().getParent() instanceof PresetTabletLinearLayout) {
                    id = v.getId() - PresetTabletItem.IB_TABLET_PEN_PRESET_PREVIEW_ID;
                }
                if (PresetLinearLayout.this.f1143g != null) {
                    PresetLinearLayout.this.f1143g.selectPresetItem(id);
                }
                if (PresetLinearLayout.this.f1145j == null) {
                    return;
                }
                PresetLinearLayout.this.f1145j.mo803a(id, v);
            }
        };
        this.f1142f = new View.OnClickListener() { // from class: com.samsung.sdraw.PresetLinearLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int id = v.getId() - 12070701;
                if (v.getParent().getParent() instanceof PresetTabletLinearLayout) {
                    id = v.getId() - PresetTabletItem.IB_TABLET_PEN_PRESET_DELETE_ID;
                }
                if (PresetLinearLayout.this.f1143g != null) {
                    PresetLinearLayout.this.f1143g.deletePresetItem(id);
                }
            }
        };
    }

    public PresetLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.f1144i = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.PresetLinearLayout.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (!v.isPressed() && hasFocus) {
                    if (v.getId() == 12070501 || v.getId() == 12070701) {
                        final ScrollView scrollView = (ScrollView) PresetLinearLayout.this.getParent().getParent();
                        PresetLinearLayout.this.postDelayed(new Runnable() { // from class: com.samsung.sdraw.PresetLinearLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                scrollView.scrollTo(0, 0);
                            }
                        }, 250L);
                    }
                }
            }
        };
        this.f1141e = new View.OnClickListener() { // from class: com.samsung.sdraw.PresetLinearLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int id = v.getId() - 12070501;
                if (v.getParent().getParent() instanceof PresetTabletLinearLayout) {
                    id = v.getId() - PresetTabletItem.IB_TABLET_PEN_PRESET_PREVIEW_ID;
                }
                if (PresetLinearLayout.this.f1143g != null) {
                    PresetLinearLayout.this.f1143g.selectPresetItem(id);
                }
                if (PresetLinearLayout.this.f1145j == null) {
                    return;
                }
                PresetLinearLayout.this.f1145j.mo803a(id, v);
            }
        };
        this.f1142f = new View.OnClickListener() { // from class: com.samsung.sdraw.PresetLinearLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int id = v.getId() - 12070701;
                if (v.getParent().getParent() instanceof PresetTabletLinearLayout) {
                    id = v.getId() - PresetTabletItem.IB_TABLET_PEN_PRESET_DELETE_ID;
                }
                if (PresetLinearLayout.this.f1143g != null) {
                    PresetLinearLayout.this.f1143g.deletePresetItem(id);
                }
            }
        };
    }

    public PresetLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.f1144i = new View.OnFocusChangeListener() { // from class: com.samsung.sdraw.PresetLinearLayout.1
            @Override // android.view.View.OnFocusChangeListener
            public void onFocusChange(View v, boolean hasFocus) {
                if (!v.isPressed() && hasFocus) {
                    if (v.getId() == 12070501 || v.getId() == 12070701) {
                        final ScrollView scrollView = (ScrollView) PresetLinearLayout.this.getParent().getParent();
                        PresetLinearLayout.this.postDelayed(new Runnable() { // from class: com.samsung.sdraw.PresetLinearLayout.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                scrollView.scrollTo(0, 0);
                            }
                        }, 250L);
                    }
                }
            }
        };
        this.f1141e = new View.OnClickListener() { // from class: com.samsung.sdraw.PresetLinearLayout.2
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int id = v.getId() - 12070501;
                if (v.getParent().getParent() instanceof PresetTabletLinearLayout) {
                    id = v.getId() - PresetTabletItem.IB_TABLET_PEN_PRESET_PREVIEW_ID;
                }
                if (PresetLinearLayout.this.f1143g != null) {
                    PresetLinearLayout.this.f1143g.selectPresetItem(id);
                }
                if (PresetLinearLayout.this.f1145j == null) {
                    return;
                }
                PresetLinearLayout.this.f1145j.mo803a(id, v);
            }
        };
        this.f1142f = new View.OnClickListener() { // from class: com.samsung.sdraw.PresetLinearLayout.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                int id = v.getId() - 12070701;
                if (v.getParent().getParent() instanceof PresetTabletLinearLayout) {
                    id = v.getId() - PresetTabletItem.IB_TABLET_PEN_PRESET_DELETE_ID;
                }
                if (PresetLinearLayout.this.f1143g != null) {
                    PresetLinearLayout.this.f1143g.deletePresetItem(id);
                }
            }
        };
    }

    public void initData(String assetPath) {
        this.f1137a = assetPath;
        this.f1138b = new C1006as(getContext(), assetPath);
        this.f1140d = this.f1138b.m1394a();
    }

    public void setFocusOrder() {
        int i;
        int i2;
        int childCount = getChildCount();
        if (!(this instanceof PresetTabletLinearLayout)) {
            i = 12070701;
            i2 = 12070501;
        } else {
            i = 12070804;
            i2 = 12070602;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null) {
                ImageButton imageButton = (ImageButton) childAt.findViewWithTag(Integer.valueOf(i2));
                ImageButton imageButton2 = (ImageButton) childAt.findViewWithTag(Integer.valueOf(i));
                if (imageButton != null && imageButton2 != null) {
                    imageButton.setId(i2 + i3);
                    imageButton.setNextFocusUpId(i + i3);
                    imageButton.setNextFocusRightId(i + i3);
                    if (i3 == childCount - 1) {
                        imageButton.setNextFocusDownId(1004);
                    } else {
                        imageButton.setNextFocusDownId(i + i3 + 1);
                    }
                    imageButton2.setId(i + i3);
                    if (i3 == 0) {
                        imageButton2.setNextFocusUpId(1000);
                    } else {
                        imageButton2.setNextFocusUpId((i2 + i3) - 1);
                    }
                    imageButton2.setNextFocusDownId(i2 + i3);
                    imageButton2.setNextFocusRightId(1000);
                    imageButton2.setNextFocusLeftId(i2 + i3);
                }
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int index) {
        super.removeViewAt(index);
        setFocusOrder();
    }

    public void setPresetData(C1005ar presetData, C1044cc presetListItem) throws Throwable {
        if (presetData != null && presetListItem != null) {
            View penPresetListRow = ((PresetListItem) presetListItem).getPenPresetListRow();
            ImageButton imageButton = (ImageButton) penPresetListRow.findViewWithTag(12070501);
            imageButton.setOnClickListener(this.f1141e);
            ImageButton imageButton2 = (ImageButton) penPresetListRow.findViewWithTag(12070701);
            imageButton2.setOnClickListener(this.f1142f);
            if (!presetData.m1392h()) {
                m1052a(presetData);
                ((ImageView) penPresetListRow.findViewWithTag(12070601)).setImageDrawable(this.f1140d[presetData.m1390f()]);
                presetData.m1381a(true);
            }
            imageButton.setImageBitmap(presetData.m1382b());
            imageButton.setOnFocusChangeListener(this.f1144i);
            imageButton2.setOnFocusChangeListener(this.f1144i);
        }
    }

    /* renamed from: a */
    protected void m1052a(C1005ar c1005ar) throws Throwable {
        StrokeSprite.Type type;
        int iM1388e;
        if (c1005ar != null) {
            Bitmap bitmapM1382b = c1005ar.m1382b();
            bitmapM1382b.eraseColor(0);
            switch (c1005ar.m1390f()) {
                case 0:
                    type = StrokeSprite.Type.Solid;
                    break;
                case 1:
                    type = StrokeSprite.Type.Brush;
                    break;
                case 2:
                    type = StrokeSprite.Type.Pencil;
                    break;
                case 3:
                    type = StrokeSprite.Type.Hightlighter;
                    break;
                case 4:
                default:
                    type = StrokeSprite.Type.Solid;
                    break;
                case 5:
                    type = StrokeSprite.Type.Zenbrush;
                    break;
            }
            int iM1391g = c1005ar.m1391g();
            if (type == StrokeSprite.Type.Hightlighter) {
                iM1388e = (iM1391g & 16777215) | (c1005ar.m1388e() << 24);
            } else {
                iM1388e = (iM1391g & 16777215) | (-16777216);
            }
            Setting setting = new Setting(getContext());
            this.f1139c = new C1054j(getContext()).m1557a(type, StrokeSprite.ThicknessParameter.lookup(StrokeSprite.ThicknessParameter.Constant.name()), StrokeSprite.InputMethod.lookup(StrokeSprite.InputMethod.Hand.name()), c1005ar.m1386d(), iM1388e);
            this.f1139c.m1144a(setting.m1108b());
            this.f1139c.m1149b(setting.m1113d());
            Canvas canvas = new Canvas(bitmapM1382b);
            android.graphics.PointF[] pointFArr = new android.graphics.PointF[5];
            int i = getContext().getResources().getDisplayMetrics().densityDpi;
            if (i == 240 || i == 213) {
                pointFArr[0] = new android.graphics.PointF(41.0f, 43.0f);
                pointFArr[1] = new android.graphics.PointF(43.0f, 42.0f);
                pointFArr[2] = new android.graphics.PointF(48.0f, 41.0f);
                pointFArr[3] = new android.graphics.PointF(52.0f, 42.0f);
                pointFArr[4] = new android.graphics.PointF(53.0f, 43.0f);
                if (this.f1139c.getType() == StrokeSprite.Type.Hightlighter) {
                    pointFArr[0].offset(-14.0f, -1.5f);
                    pointFArr[1].offset(-7.0f, -1.5f);
                    pointFArr[2].offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, -1.5f);
                    pointFArr[3].offset(3.0f, -1.5f);
                    pointFArr[4].offset(10.0f, -1.5f);
                }
            } else {
                pointFArr[0] = new android.graphics.PointF(36.0f, 48.0f);
                pointFArr[1] = new android.graphics.PointF(47.0f, 47.0f);
                pointFArr[2] = new android.graphics.PointF(52.0f, 46.0f);
                pointFArr[3] = new android.graphics.PointF(56.0f, 47.0f);
                pointFArr[4] = new android.graphics.PointF(60.0f, 48.0f);
                if (this.f1139c.getType() == StrokeSprite.Type.Hightlighter) {
                    pointFArr[0].offset(-14.0f, -3.0f);
                    pointFArr[1].offset(-7.0f, -3.0f);
                    pointFArr[2].offset(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, -3.0f);
                    pointFArr[3].offset(3.0f, -3.0f);
                    pointFArr[4].offset(10.0f, -3.0f);
                }
            }
            for (android.graphics.PointF pointF : pointFArr) {
                if (this.f1139c.m1152b(pointF.x, pointF.y, 255.0f, 1L, true)) {
                    this.f1139c.m1147b(true);
                }
            }
            this.f1139c.m1164i();
            this.f1139c.m1157d(true);
            this.f1139c.mo1139a(canvas, new RectF(VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, VLSpotterContext.DEFAULT_PHRASESPOT_AOFFSET, bitmapM1382b.getWidth(), bitmapM1382b.getHeight()));
            this.f1139c.dispose();
        }
    }

    public void setClickPresetItemListener(OnClickPresetItemListener listener) {
        this.f1143g = listener;
    }

    public void setOnItemSelectedListener(InterfaceC0982a l) {
        this.f1145j = l;
    }
}
