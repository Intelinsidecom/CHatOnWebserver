package com.coolots.chaton.common.util;

import android.content.res.Resources;
import com.sds.coolots.MainApplication;

/* loaded from: classes.dex */
public class ContentDescriptionStringMaker {
    public static CharSequence makeString(int des, int shp) throws Resources.NotFoundException {
        CharSequence desString = MainApplication.mContext.getResources().getText(des);
        CharSequence shpString = MainApplication.mContext.getResources().getText(shp);
        CharSequence descriptionString = ((Object) desString) + ", " + ((Object) shpString);
        return descriptionString;
    }
}
