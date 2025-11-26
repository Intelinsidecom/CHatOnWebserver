package com.samsung.sdraw;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
public class PresetTabletItem extends C1044cc {
    public static final int IB_TABLET_PEN_PRESET_DELETE_ID = 12070804;
    public static final int IB_TABLET_PEN_PRESET_PREVIEW_ID = 12070602;
    public static final int IV_TABLET_PEN_PRESET_PREVIEW_ID = 12070703;

    /* renamed from: a */
    private View f1154a;

    /* renamed from: b */
    private String f1155b;

    /* renamed from: c */
    private String f1156c;

    @Override // com.samsung.sdraw.C1044cc
    public /* bridge */ /* synthetic */ int getThumbPaddingTop() {
        return super.getThumbPaddingTop();
    }

    public View getPenPresetListRow() {
        return this.f1154a;
    }

    /* renamed from: a */
    private View m1054a(Context context) {
        RelativeLayout.LayoutParams layoutParams;
        m1533h();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, m1524a(45.0f * this.f1700ao) * 2);
        if (this.f1699an == 213) {
            layoutParams2.bottomMargin = m1524a(4.0f);
        }
        relativeLayout.setLayoutParams(layoutParams2);
        relativeLayout.setBackgroundColor(0);
        relativeLayout.setGravity(1);
        ImageButton imageButton = new ImageButton(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        imageButton.setBackgroundColor(0);
        imageButton.setPadding(0, 0, 0, 0);
        imageButton.setLayoutParams(layoutParams3);
        imageButton.setMaxHeight(m1524a(45.0f) * 2);
        imageButton.setFocusable(true);
        imageButton.setTag(Integer.valueOf(IB_TABLET_PEN_PRESET_PREVIEW_ID));
        imageButton.setBackgroundDrawable(m1525a(null, "/snote_tablet_mypen_select.png", "/snote_tablet_mypen_select.png"));
        imageButton.setContentDescription(this.f1156c);
        try {
            imageButton.setHoverPopupType(0);
        } catch (NoSuchMethodError e) {
            e.printStackTrace();
        }
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setFocusable(false);
        imageView.setTag(Integer.valueOf(IV_TABLET_PEN_PRESET_PREVIEW_ID));
        imageView.setPadding(0, 0, 0, 0);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView2.setFocusable(false);
        imageView2.setBackgroundDrawable(m1531c("/snote_tablet_mypen.png"));
        ImageButton imageButton2 = new ImageButton(context);
        new RelativeLayout.LayoutParams(-2, -2);
        if (this.f1699an == 213) {
            layoutParams = new RelativeLayout.LayoutParams(m1524a(this.f1700ao * 31.0f), m1524a(this.f1700ao * 31.0f));
        } else if (this.f1699an == 320) {
            layoutParams = new RelativeLayout.LayoutParams(m1524a(31.0f), m1524a(31.0f));
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        layoutParams.addRule(11);
        imageButton2.setLayoutParams(layoutParams);
        imageButton2.setBackgroundDrawable(m1529b("/snote_tablet_delete.png", "/snote_tablet_delete_press.png", (String) null));
        imageButton2.setImageDrawable(m1529b((String) null, (String) null, "/snote_tablet_add_focus.png"));
        imageButton2.setContentDescription(this.f1155b);
        imageButton2.setFocusable(true);
        imageButton2.setTag(Integer.valueOf(IB_TABLET_PEN_PRESET_DELETE_ID));
        imageButton2.setPadding(0, 0, 0, 0);
        imageButton2.setScaleType(ImageView.ScaleType.FIT_XY);
        relativeLayout.addView(imageView2);
        relativeLayout.addView(imageButton);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageButton2);
        return relativeLayout;
    }

    public PresetTabletItem(Context context, String assetPath, String presetDeleteDesc, String presetPreviewDesc) {
        super(context, assetPath);
        this.f1155b = "Remove from preset";
        this.f1156c = "Pen type %s, thickness %d percent, transparency %d percent";
        this.f1155b = presetDeleteDesc;
        this.f1156c = presetPreviewDesc;
        this.f1154a = m1054a(context);
    }
}
