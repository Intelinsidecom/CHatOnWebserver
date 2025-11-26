package com.samsung.sdraw;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class PresetTabletLinearLayout extends PresetLinearLayout {

    /* renamed from: i */
    protected static String[] f1157i;

    /* renamed from: h */
    protected PresetTabletPenTypeImages f1158h;

    static {
        String[] strArr = new String[6];
        strArr[0] = "/snote_tablet_popup_btn_03.png";
        strArr[1] = "/snote_tablet_popup_btn_04.png";
        strArr[2] = "/snote_tablet_popup_btn_02.png";
        strArr[3] = "/snote_tablet_popup_btn_01.png";
        strArr[5] = "/snote_tablet_popup_btn_05.png";
        f1157i = strArr;
    }

    public PresetTabletLinearLayout(Context context) {
        super(context);
    }

    public PresetTabletLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PresetTabletLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override // com.samsung.sdraw.PresetLinearLayout
    public void initData(String assetPath) {
        this.f1137a = assetPath;
        this.f1158h = new PresetTabletPenTypeImages(getContext(), assetPath);
        this.f1140d = this.f1158h.getPenTypeList();
    }

    @Override // com.samsung.sdraw.PresetLinearLayout
    public void setPresetData(C1005ar presetData, C1044cc presetListItem) {
        if (presetData != null && presetListItem != null) {
            View penPresetListRow = ((PresetTabletItem) presetListItem).getPenPresetListRow();
            ImageButton imageButton = (ImageButton) penPresetListRow.findViewWithTag(Integer.valueOf(PresetTabletItem.IB_TABLET_PEN_PRESET_PREVIEW_ID));
            imageButton.setOnClickListener(this.f1141e);
            ((ImageButton) penPresetListRow.findViewWithTag(Integer.valueOf(PresetTabletItem.IB_TABLET_PEN_PRESET_DELETE_ID))).setOnClickListener(this.f1142f);
            if (!presetData.m1392h()) {
                m1052a(presetData);
                ((ImageView) penPresetListRow.findViewWithTag(Integer.valueOf(PresetTabletItem.IV_TABLET_PEN_PRESET_PREVIEW_ID))).setImageDrawable(this.f1140d[presetData.m1390f()]);
                presetData.m1381a(true);
            }
            imageButton.setImageBitmap(presetData.m1382b());
        }
    }
}
