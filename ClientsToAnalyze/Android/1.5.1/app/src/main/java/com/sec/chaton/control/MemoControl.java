package com.sec.chaton.control;

import android.os.Handler;
import com.sec.chaton.control.task.BlindMemoTask;
import com.sec.chaton.control.task.DeleteMemoTask;
import com.sec.chaton.control.task.GetMemoBlindListTask;
import com.sec.chaton.control.task.GetMemoListMoreTask;
import com.sec.chaton.control.task.GetMemoListTask;
import com.sec.chaton.control.task.WriteMemoTask;
import com.sec.chaton.memo.MemoAdapter;
import com.sec.chaton.network.HttpEnvelope;
import com.sec.chaton.network.HttpNetworkQueue;
import com.sec.chaton.p000io.entry.GetMemoBlindList;
import com.sec.chaton.p000io.entry.GetMemoList;
import com.sec.chaton.trunk.control.TrunkMessageControl;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class MemoControl {

    /* renamed from: a */
    private Handler f1361a;

    public MemoControl(Handler handler) {
        this.f1361a = handler;
    }

    /* renamed from: a */
    public void m2004a() {
        HttpNetworkQueue.m2745a().offer(new GetMemoBlindListTask(this.f1361a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/memo/blind").m2738a(HttpEnvelope.RequestMethod.GET).m2737a(TrunkMessageControl.METHOD_DELETE_ITEM).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("count", "2000").m2739a(GetMemoBlindList.class).m2742a()));
    }

    /* renamed from: a */
    public void m2005a(MemoAdapter.MemoItem memoItem) {
        HttpNetworkQueue.m2745a().offer(new WriteMemoTask(this.f1361a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/memo").m2738a(HttpEnvelope.RequestMethod.PUT).m2737a(TrunkMessageControl.METHOD_GET_COMMENT_ITEM_LIST).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2742a(), memoItem));
    }

    /* renamed from: a */
    public void m2006a(String str) {
        HttpNetworkQueue.m2745a().offer(new GetMemoListTask(this.f1361a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/memo/list/" + str).m2738a(HttpEnvelope.RequestMethod.GET).m2737a(TrunkMessageControl.METHOD_GET_TRUNK_ITEM).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("count", "30").m2741a("fulltext", "false").m2741a("length", "140").m2739a(GetMemoList.class).m2742a(), str));
    }

    /* renamed from: a */
    public void m2007a(String str, String str2) {
        HttpNetworkQueue.m2745a().offer(new GetMemoListMoreTask(this.f1361a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/memo/list/" + str).m2738a(HttpEnvelope.RequestMethod.GET).m2737a(TrunkMessageControl.METHOD_GET_TRUNK_ITEM).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("count", "30").m2741a("starttime", Long.valueOf(Long.parseLong(str2) - 1).toString()).m2741a("fulltext", "false").m2741a("length", "140").m2739a(GetMemoList.class).m2742a(), str));
    }

    /* renamed from: a */
    public void m2008a(String str, String str2, String str3) {
        HttpNetworkQueue.m2745a().offer(new DeleteMemoTask(this.f1361a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/memo").m2738a(HttpEnvelope.RequestMethod.DELETE).m2737a(TrunkMessageControl.METHOD_ADD_COMMENT).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("buddyid", str).m2741a("timestamp", str2).m2741a("isreceiver", str3).m2742a(), str2));
    }

    /* renamed from: a */
    public void m2009a(ArrayList arrayList, ArrayList arrayList2) {
        HttpNetworkQueue.m2745a().offer(new BlindMemoTask(this.f1361a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/memo/blind").m2738a(HttpEnvelope.RequestMethod.POST).m2737a(TrunkMessageControl.METHOD_REMOVE_COMMENT).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2742a(), arrayList, arrayList2));
    }

    /* renamed from: b */
    public void m2010b(String str, String str2) {
        HttpNetworkQueue.m2745a().offer(new DeleteMemoTask(this.f1361a, new HttpEnvelope.Builder(ServerAddressMgr.ServerWhat.CONTACT, "/memo").m2738a(HttpEnvelope.RequestMethod.DELETE).m2737a(TrunkMessageControl.METHOD_ADD_COMMENT).m2741a("uid", ChatONPref.m3519a().getString("uid", "")).m2741a("imei", DeviceInfoUtil.m3564a()).m2741a("buddyid", str).m2741a("timestamp", str2).m2742a(), str2));
    }
}
