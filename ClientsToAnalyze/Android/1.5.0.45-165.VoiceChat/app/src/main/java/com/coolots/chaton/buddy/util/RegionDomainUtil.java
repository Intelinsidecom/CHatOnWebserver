package com.coolots.chaton.buddy.util;

import android.database.Cursor;
import com.coolots.chaton.common.controller.VAppPhoneManager;
import com.sds.coolots.MainApplication;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class RegionDomainUtil {
    private static ArrayList<Long> regionDomainInfoList = new ArrayList<>();
    private static boolean isNeededRegionDomainSync = false;

    public static void makeRegionDomainInfoList() {
        Cursor cursor = ((VAppPhoneManager) MainApplication.mPhoneManager).getChatOnContactManager().selectRegionCode();
        if (cursor != null && cursor.moveToFirst()) {
            regionDomainInfoList.clear();
            do {
                regionDomainInfoList.add(Long.valueOf(cursor.getLong(1)));
            } while (cursor.moveToNext());
            cursor.close();
        }
        if (cursor != null) {
            cursor.close();
        }
        isNeededRegionDomainSync = false;
    }

    public static boolean isExistDomainInfo(long regionCode) {
        Iterator<Long> it = regionDomainInfoList.iterator();
        while (it.hasNext()) {
            Long region = it.next();
            if (region.longValue() == regionCode) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNeededToRegionDomainSync() {
        return isNeededRegionDomainSync;
    }

    public static void setNeededToRegionDomainSync(boolean isNeeded) {
        isNeededRegionDomainSync = isNeeded;
    }
}
