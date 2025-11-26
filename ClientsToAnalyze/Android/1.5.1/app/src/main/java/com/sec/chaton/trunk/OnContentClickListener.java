package com.sec.chaton.trunk;

import android.view.View;
import com.sec.chaton.trunk.database.DatabaseConstant;
import com.sec.chaton.trunk.util.TrunkUtil;

/* loaded from: classes.dex */
public interface OnContentClickListener {
    void OnContentItemClickListener(View view, String str, DatabaseConstant.TrunkItemTable.ItemType itemType, String str2, TrunkUtil.ContentType contentType);
}
