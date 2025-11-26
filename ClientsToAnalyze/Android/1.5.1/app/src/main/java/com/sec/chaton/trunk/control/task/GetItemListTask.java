package com.sec.chaton.trunk.control.task;

import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.common.entry.HttpEntry;
import com.sec.chaton.control.task.AbstractHttpTask2;
import com.sec.chaton.global.GlobalApplication;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpResultCode;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.trunk.entry.GetItemListEntry;
import com.sec.chaton.trunk.entry.inner.TrunkItem;
import com.sec.chaton.util.ChatONLogWriter;
import org.apache.http.NameValuePair;

/* loaded from: classes.dex */
public class GetItemListTask extends AbstractHttpTask2 {
    private static final String TAG = GetItemListTask.class.getSimpleName();
    private boolean clearCache;
    private boolean isCanceled;

    public GetItemListTask(Handler handler, HttpEnvelope httpEnvelope, boolean z) {
        super(handler, httpEnvelope);
        this.clearCache = z;
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public void afterRequest(HttpEntry httpEntry) throws NumberFormatException {
        int i;
        int i2;
        TrunkMessageControl.OrderingType orderingTypeConvert;
        String value;
        String value2;
        httpEntry.m1953b(this);
        if (this.isCanceled) {
            ChatONLogWriter.m3506b("GetItemTask is canceled.", TAG);
            return;
        }
        if (httpEntry.m1951b() == HttpResultCode.SUCCESS) {
            GetItemListEntry getItemListEntry = (GetItemListEntry) httpEntry.m1955d();
            if (getItemListEntry == null) {
                ChatONLogWriter.m3499a("Http result object is null", TAG);
                return;
            }
            TrunkDatabaseHelper trunkDatabaseHelper = new TrunkDatabaseHelper(GlobalApplication.m2387e());
            TrunkMessageControl.OrderingType orderingType = null;
            String str = "";
            String str2 = "";
            int i3 = 0;
            for (NameValuePair nameValuePair : httpEntry.m1954c().m2731d()) {
                if (nameValuePair.getName().equals("sessionid")) {
                    int i4 = i3;
                    orderingTypeConvert = orderingType;
                    value = str;
                    value2 = nameValuePair.getValue();
                    i2 = i4;
                } else if (nameValuePair.getName().equals("type")) {
                    value = str;
                    value2 = str2;
                    int i5 = i3;
                    orderingTypeConvert = TrunkMessageControl.OrderingType.Convert(nameValuePair.getValue());
                    i2 = i5;
                } else if (nameValuePair.getName().equals("count")) {
                    i2 = Integer.parseInt(nameValuePair.getValue());
                    orderingTypeConvert = orderingType;
                    value = str;
                    value2 = str2;
                } else if (nameValuePair.getName().equals("startitemid")) {
                    value2 = str2;
                    TrunkMessageControl.OrderingType orderingType2 = orderingType;
                    value = nameValuePair.getValue();
                    i2 = i3;
                    orderingTypeConvert = orderingType2;
                } else {
                    i2 = i3;
                    orderingTypeConvert = orderingType;
                    value = str;
                    value2 = str2;
                }
                str2 = value2;
                str = value;
                orderingType = orderingTypeConvert;
                i3 = i2;
            }
            boolean z = (TextUtils.isEmpty(str) || str.equals("0")) ? false : true;
            if (orderingType == null) {
                ChatONLogWriter.m3499a("The ordering type is null.", TAG);
                return;
            }
            if (this.clearCache) {
                ChatONLogWriter.m3506b("Truncate trunk item cache.", TAG);
                trunkDatabaseHelper.removeTrunkItems(str2);
            }
            if (z) {
                ChatONLogWriter.m3506b("Remove load more trunk item.", TAG);
                trunkDatabaseHelper.removeLoadMoreTrunkItem(str);
            }
            if (httpEntry.m1955d() != null) {
                ChatONLogWriter.m3506b("Save trunk item to database.", TAG);
                int size = getItemListEntry.items.size();
                if (z) {
                    i3--;
                    i = size - 1;
                } else {
                    i = size;
                }
                ChatONLogWriter.m3506b("Request count: " + i3 + ", Response count: " + i, TAG);
                boolean z2 = i3 - i <= 0;
                int i6 = 0;
                while (i6 < getItemListEntry.items.size()) {
                    TrunkItem trunkItem = (TrunkItem) getItemListEntry.items.get(i6);
                    trunkItem.sessionid = str2;
                    boolean zSaveTrunkItem = trunkDatabaseHelper.saveTrunkItem(trunkItem);
                    ChatONLogWriter.m3506b("HasMore: " + z2 + ", IsLastItem: " + (i6 == getItemListEntry.items.size() - 1), TAG);
                    if (i6 != getItemListEntry.items.size() - 1) {
                        trunkDatabaseHelper.removeLoadMoreTrunkItem(trunkItem.itemid);
                    } else if (zSaveTrunkItem && z2) {
                        ChatONLogWriter.m3506b("Insert new load more trunk item.", TAG);
                        trunkDatabaseHelper.saveLoadMoreTrunkItem(trunkItem);
                    }
                    i6++;
                }
            }
        }
    }

    @Override // com.sec.chaton.control.task.AbstractHttpTask2
    public String beforeRequest() {
        return null;
    }

    public void cancel() {
        this.isCanceled = true;
    }
}
