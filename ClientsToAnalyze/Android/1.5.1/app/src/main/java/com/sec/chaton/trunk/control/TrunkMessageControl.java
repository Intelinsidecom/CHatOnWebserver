package com.sec.chaton.trunk.control;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.trunk.control.task.AddCommentTask;
import com.sec.chaton.trunk.control.task.DeleteItemTask;
import com.sec.chaton.trunk.control.task.GetCommentListTask;
import com.sec.chaton.trunk.control.task.GetItemListTask;
import com.sec.chaton.trunk.control.task.GetItemTask;
import com.sec.chaton.trunk.control.task.GetTrunkListTask;
import com.sec.chaton.trunk.control.task.MarkAsReadTask;
import com.sec.chaton.trunk.control.task.RemoveCommentTask;
import com.sec.chaton.trunk.database.helper.TrunkDatabaseHelper;
import com.sec.chaton.trunk.entry.GetCommentListEntry;
import com.sec.chaton.trunk.entry.GetItemEntry;
import com.sec.chaton.trunk.entry.GetItemListEntry;
import com.sec.chaton.trunk.entry.GetTrunkListEntry;
import com.sec.chaton.trunk.network.TrunkNetworkQueue;
import com.sec.chaton.trunk.parser.GetCommentListParser;
import com.sec.chaton.trunk.parser.GetItemListParser;
import com.sec.chaton.trunk.parser.GetItemParser;
import com.sec.chaton.trunk.parser.GetTrunkListParser;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;
import java.util.List;

/* loaded from: classes.dex */
public class TrunkMessageControl {
    private static final int CONTROL_CODE = 900;
    public static final int METHOD_ADD_COMMENT = 904;
    public static final int METHOD_DELETE_ITEM = 905;
    public static final int METHOD_GET_COMMENT_ITEM_LIST = 903;
    public static final int METHOD_GET_ITEM_LIST = 902;
    public static final int METHOD_GET_TRUNK_ITEM = 901;
    public static final int METHOD_GET_TRUNK_LIST = 900;
    public static final int METHOD_MARK_AS_READ = 907;
    public static final int METHOD_REMOVE_COMMENT = 906;
    private Context context;
    private Handler handler;
    private TrunkDatabaseHelper trunkDatabaseHelper;

    public enum OrderingType {
        Recent("recentadded"),
        UnreadComment("unreadcommented");

        private String value;

        OrderingType(String str) {
            this.value = str;
        }

        public static OrderingType Convert(String str) {
            if (str.equals("recentadded")) {
                return Recent;
            }
            if (str.equals("unreadcommented")) {
                return UnreadComment;
            }
            return null;
        }

        public String getValue() {
            return this.value;
        }
    }

    public TrunkMessageControl(Context context, Handler handler) {
        this.context = context;
        this.handler = handler;
        this.trunkDatabaseHelper = new TrunkDatabaseHelper(context);
    }

    public void addComment(String str, String str2, String str3) {
        TrunkNetworkQueue.getQueue().offer(new AddCommentTask(this.handler, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/trunk/item/comment").m2738a(HttpEnvelope.RequestMethod.POST).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(METHOD_ADD_COMMENT).m2742a(), str, str2, str3));
    }

    public void deleteTrunkItem(String str, String str2) {
        TrunkNetworkQueue.getQueue().offer(new DeleteItemTask(this.handler, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/trunk/item").m2738a(HttpEnvelope.RequestMethod.DELETE).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("sessionid", str).m2741a("itemid", str2).m2737a(METHOD_DELETE_ITEM).m2742a()));
    }

    public Handler getHandler() {
        return this.handler;
    }

    public void markAsRead(String str, String str2) {
        TrunkNetworkQueue.getQueue().offer(new MarkAsReadTask(this.handler, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/trunk/item/markAsRead").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("sessionid", str).m2741a("itemid", str2).m2737a(METHOD_MARK_AS_READ).m2742a()));
    }

    public void removeComment(String str, String str2, String str3) {
        TrunkNetworkQueue.getQueue().offer(new RemoveCommentTask(this.handler, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/trunk/item/comment").m2738a(HttpEnvelope.RequestMethod.DELETE).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("sessionid", str).m2741a("itemid", str2).m2741a("commentid", str3).m2737a(METHOD_REMOVE_COMMENT).m2742a()));
    }

    public GetCommentListTask retrieveCommentList(String str, String str2, String str3, int i) {
        GetCommentListTask getCommentListTask = new GetCommentListTask(this.handler, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/trunk/item/commentlist").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("sessionid", str).m2741a("itemid", str2).m2741a("startcommentid", str3 == null ? String.valueOf(Integer.MAX_VALUE) : str3).m2741a("count", str3 == null ? String.valueOf(i) : String.valueOf(i + 1)).m2737a(METHOD_GET_COMMENT_ITEM_LIST).m2739a(GetCommentListEntry.class).m2743b(GetCommentListParser.class).m2742a());
        TrunkNetworkQueue.getQueue().offer(getCommentListTask);
        return getCommentListTask;
    }

    public GetItemTask retrieveTrunkItem(String str, String str2, int i, int i2) {
        GetItemTask getItemTask = new GetItemTask(this.handler, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/trunk/item").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("sessionid", str).m2741a("itemid", str2).m2741a("cmtlist", String.valueOf(i)).m2741a("thumbnailsize", String.valueOf(i2)).m2737a(METHOD_GET_TRUNK_ITEM).m2739a(GetItemEntry.class).m2743b(GetItemParser.class).m2742a());
        TrunkNetworkQueue.getQueue().offer(getItemTask);
        return getItemTask;
    }

    public GetItemListTask retrieveTrunkItemList(boolean z, String str, int i, OrderingType orderingType, int i2) {
        return retrieveTrunkItemList(z, str, i, orderingType, i2, null);
    }

    public GetItemListTask retrieveTrunkItemList(boolean z, String str, int i, OrderingType orderingType, int i2, String str2) {
        HttpEnvelope.Builder builderM2743b = new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/trunk/itemlist").m2738a(HttpEnvelope.RequestMethod.GET).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("sessionid", str).m2741a("type", orderingType.getValue()).m2741a("thumbnailsize", String.valueOf(i2)).m2741a("count", String.valueOf(i)).m2737a(METHOD_GET_ITEM_LIST).m2739a(GetItemListEntry.class).m2743b(GetItemListParser.class);
        if (!TextUtils.isEmpty(str2)) {
            builderM2743b.m2741a("startitemid", str2);
        }
        GetItemListTask getItemListTask = new GetItemListTask(this.handler, builderM2743b.m2742a(), z);
        TrunkNetworkQueue.getQueue().offer(getItemListTask);
        return getItemListTask;
    }

    public void retrieveTrunkList(List list) {
        TrunkNetworkQueue.getQueue().offer(new GetTrunkListTask(this.handler, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/trunklist").m2738a(HttpEnvelope.RequestMethod.POST).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2737a(900).m2739a(GetTrunkListEntry.class).m2743b(GetTrunkListParser.class).m2742a(), list));
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
