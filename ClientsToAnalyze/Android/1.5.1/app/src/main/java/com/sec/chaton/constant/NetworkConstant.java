package com.sec.chaton.constant;

import android.content.Context;
import com.sec.chaton.push.provisioning.ProvisioningManager;
import com.sec.chaton.util.ChatONPref;
import com.sec.chaton.util.DeviceInfoUtil;
import com.sec.chaton.util.ServerAddressMgr;

/* loaded from: classes.dex */
public class NetworkConstant {

    /* renamed from: a */
    public static final String[] f1347a = {"https://gld1.samsungchaton.com", "https://stg.gld1.samsungchaton.com", "https://stg.gld2.samsungchaton.com", "http://ec2-50-17-226-248.compute-1.amazonaws.com"};

    /* renamed from: b */
    public static final String[] f1348b = {"Production\n" + f1347a[0], "Staging\n" + f1347a[1], "Development\n" + f1347a[2], "SNS dev server\n" + f1347a[3]};

    public final class FunctionEnabler {
    }

    /* renamed from: a */
    public static String m1973a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("- GLD -\n").append(ChatONPref.m3519a().getString("pref_choose_server_test", f1347a[0]));
        sb.append("\n- Contact1 -\n").append(ServerAddressMgr.m3630b(ServerAddressMgr.ServerType.PRIMARY)).append(" : ").append(ServerAddressMgr.m3632c(ServerAddressMgr.ServerType.PRIMARY));
        sb.append("\n- Message1 -\n").append(ServerAddressMgr.m3636e()).append(" : ").append(ServerAddressMgr.m3640g());
        sb.append("\n- File1 -\n").append(ServerAddressMgr.m3635d(ServerAddressMgr.ServerType.PRIMARY)).append(" : ").append(ServerAddressMgr.m3638f(ServerAddressMgr.ServerType.PRIMARY));
        sb.append("\n- Contact2 -\n").append(ServerAddressMgr.m3630b(ServerAddressMgr.ServerType.SECONDARY)).append(" : ").append(ServerAddressMgr.m3632c(ServerAddressMgr.ServerType.SECONDARY));
        sb.append("\n- Message2 -\n").append(ServerAddressMgr.m3639f()).append(" : ").append(ServerAddressMgr.m3641h());
        sb.append("\n- File2 -\n").append(ServerAddressMgr.m3635d(ServerAddressMgr.ServerType.SECONDARY)).append(" : ").append(ServerAddressMgr.m3638f(ServerAddressMgr.ServerType.SECONDARY));
        sb.append("\n- Push Prov - \n").append("gld.push.samsungosp.com").append(" : ").append(5223);
        sb.append("\n- Push1 - \n").append(ProvisioningManager.m3003e(context)).append(" : ").append(ProvisioningManager.m3004f(context));
        sb.append("\n- Push2 - \n").append(ProvisioningManager.m3005g(context)).append(" : ").append(ProvisioningManager.m3006h(context));
        sb.append("\n- IMEI -\n").append(DeviceInfoUtil.m3564a());
        return sb.toString();
    }
}
