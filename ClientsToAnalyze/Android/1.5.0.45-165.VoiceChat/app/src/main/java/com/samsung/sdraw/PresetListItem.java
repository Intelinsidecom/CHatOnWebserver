package com.samsung.sdraw;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class PresetListItem extends C1044cc {
    public static final int IB_PEN_PRESET_DELETE_ID = 12070701;
    public static final int IB_PEN_PRESET_PREVIEW_ID = 12070501;
    public static final int IV_PEN_PRESET_PREVIEW_ID = 12070601;

    /* renamed from: a */
    private View f1151a;

    /* renamed from: b */
    private String f1152b;

    /* renamed from: c */
    private String f1153c;

    @Override // com.samsung.sdraw.C1044cc
    public /* bridge */ /* synthetic */ int getThumbPaddingTop() {
        return super.getThumbPaddingTop();
    }

    public View getPenPresetListRow() {
        m1533h();
        return this.f1151a;
    }

    /* renamed from: a */
    private View m1053a(Context context) {
        ViewGroup.LayoutParams layoutParams;
        RelativeLayout.LayoutParams layoutParams2;
        RelativeLayout relativeLayout = new RelativeLayout(context);
        if (this.f1699an == 240) {
            layoutParams = new AbsListView.LayoutParams(-1, m1524a(55.5f));
        } else {
            layoutParams = new AbsListView.LayoutParams(-1, m1524a(47.5f));
        }
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setPadding(m1524a(3.0f), m1524a(3.0f), m1524a(3.0f), 0);
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setGravity(1);
        relativeLayout.setFocusable(false);
        ImageButton imageButton = new ImageButton(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        imageButton.setBackgroundColor(0);
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setLayoutParams(layoutParams3);
        imageButton.setMaxHeight(m1524a(42.5f));
        imageButton.setFocusable(true);
        imageButton.setTag(12070501);
        imageButton.setBackgroundDrawable(m1525a(null, "/snote_mypen_select.png", "/snote_mypen_select.png"));
        imageButton.setContentDescription(this.f1153c);
        try {
            imageButton.setHoverPopupType(0);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setFocusable(false);
        imageView.setTag(12070601);
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView2.setFocusable(false);
        imageView2.setBackgroundDrawable(m1531c("/snote_mypen.png"));
        C1052h c1052h = new C1052h(context);
        if (this.f1699an == 480) {
            layoutParams2 = new RelativeLayout.LayoutParams(m1524a(((28.5f * this.f1700ao) * 2.0f) / 3.0f), m1524a(((22.0f * this.f1700ao) * 2.0f) / 3.0f));
        } else {
            layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams2.addRule(11);
        c1052h.setLayoutParams(layoutParams2);
        c1052h.setBackgroundDrawable(m1529b("/snote_delete.png", "/snote_delete_press.png", (String) null));
        c1052h.setImageDrawable(m1529b((String) null, (String) null, "/snote_add_focus.png"));
        c1052h.setContentDescription(this.f1152b);
        c1052h.setFocusable(true);
        c1052h.setTag(12070701);
        c1052h.setPadding(0, 0, 0, 0);
        relativeLayout.addView(imageView2);
        relativeLayout.addView(imageButton);
        relativeLayout.addView(imageView);
        relativeLayout.addView(c1052h);
        relativeLayout.setNextFocusLeftId(1008);
        return relativeLayout;
    }

    public PresetListItem(Context context, String assetPath, String presetDeleteDesc, String presetPreviewDesc) {
        super(context, assetPath);
        this.f1152b = "Remove from preset";
        this.f1153c = "Pen type %s, thickness %d percent, transparency %d percent";
        this.f1152b = presetDeleteDesc;
        this.f1153c = presetPreviewDesc;
        this.f1151a = m1053a(context);
    }
}
