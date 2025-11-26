package com.sec.chaton.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.C0096i;
import android.text.TextUtils;
import com.sec.chaton.C0991aa;
import com.sec.chaton.C1048at;
import com.sec.chaton.C1049au;
import com.sec.chaton.C1050av;
import com.sec.chaton.C1052ax;
import com.sec.chaton.C1053ay;
import com.sec.chaton.C1054az;
import com.sec.common.C4996f;
import com.sec.common.util.C5052r;

/* loaded from: classes.dex */
public class PlugInMonitor extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f10790a = PlugInMonitor.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        InterfaceC2938d interfaceC2938d;
        Object c1049au;
        Intent intentM12132a;
        if (context != null && intent != null) {
            String action = intent.getAction();
            String strM12133a = m12133a(intent);
            if (!TextUtils.isEmpty(strM12133a)) {
                if (C4996f.f18229a.f18171c) {
                    C4996f.f18229a.m18892f(f10790a, "PlugInMonitor.onReceive()");
                    C4996f.f18229a.m18892f(f10790a, C5052r.m19199a(" Action: ", action, ", Data:", intent.getData(), ", Package: ", strM12133a));
                    StringBuilder sb = new StringBuilder();
                    Bundle extras = intent.getExtras();
                    sb.append(" ===== Bundle\n");
                    for (String str : extras.keySet()) {
                        sb.append(" Key: ");
                        sb.append(str);
                        sb.append(", Value: ");
                        Object obj = extras.get(str);
                        if (obj instanceof String[]) {
                            sb.append("{");
                            String[] strArr = (String[]) obj;
                            for (String str2 : strArr) {
                                sb.append(C5052r.m19199a(str2, ","));
                            }
                            sb.append("}");
                        } else {
                            sb.append(extras.get(str));
                        }
                        sb.append("\n");
                    }
                    sb.append(" ===== Bundle");
                    C4996f.f18229a.m18892f(f10790a, sb.toString());
                }
                EnumC2949i enumC2949iM12193a = EnumC2949i.m12193a(strM12133a);
                if (enumC2949iM12193a != null) {
                    try {
                        interfaceC2938d = (InterfaceC2938d) C2948h.m12190a().m12191a(enumC2949iM12193a);
                    } catch (C2947g e) {
                        if (!C4996f.f18229a.f18174f) {
                            interfaceC2938d = null;
                        } else {
                            C4996f.f18229a.mo18649a(f10790a, e.getMessage(), e);
                            return;
                        }
                    }
                    if (C4996f.f18229a.f18171c) {
                        C4996f.f18229a.m18892f(f10790a, C5052r.m19199a("PlugInType: ", enumC2949iM12193a, ", PlugIn: ", interfaceC2938d));
                    }
                    if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                        intentM12132a = m12131a(context, interfaceC2938d, intent);
                        c1049au = new C1052ax(enumC2949iM12193a);
                    } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                        intentM12132a = m12134b(context, interfaceC2938d, intent);
                        c1049au = new C1054az(enumC2949iM12193a);
                    } else if ("android.intent.action.PACKAGE_REPLACED".equals(action)) {
                        intentM12132a = m12136c(context, interfaceC2938d, intent);
                        c1049au = new C1053ay(enumC2949iM12193a);
                    } else if ("android.intent.action.PACKAGE_DATA_CLEARED".equals(action)) {
                        intentM12132a = m12137d(context, interfaceC2938d, intent);
                        c1049au = new C1048at(enumC2949iM12193a);
                    } else if (!"android.intent.action.PACKAGE_CHANGED".equals(action)) {
                        c1049au = null;
                        intentM12132a = null;
                    } else {
                        intentM12132a = m12132a(context, interfaceC2938d, strM12133a);
                        if (C2948h.f10847d.equals(intentM12132a.getAction())) {
                            c1049au = new C1050av(enumC2949iM12193a);
                        } else {
                            c1049au = C2948h.f10848e.equals(intentM12132a.getAction()) ? new C1049au(enumC2949iM12193a) : null;
                        }
                    }
                    if (intentM12132a != null) {
                        intentM12132a.putExtra(C2948h.f10850g, enumC2949iM12193a);
                        if (C4996f.f18229a.f18171c) {
                            C4996f.f18229a.m18892f(f10790a, C5052r.m19199a("Send broadcast. Intent: ", intentM12132a));
                        }
                        C0096i.m358a(context).m363a(intentM12132a);
                    }
                    if (c1049au != null) {
                        C0991aa.m6037a().m18961c(c1049au);
                        return;
                    }
                    return;
                }
                if (C4996f.f18229a.f18171c) {
                    C4996f.f18229a.m18892f(f10790a, C5052r.m19199a("It isn't supported plugin."));
                }
            }
        }
    }

    /* renamed from: a */
    private Intent m12131a(Context context, InterfaceC2938d interfaceC2938d, Intent intent) {
        if (m12135b(intent)) {
            return null;
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10790a, C5052r.m19199a("PlugIn is installed."));
        }
        if (interfaceC2938d != null) {
            interfaceC2938d.mo12146b(context);
        }
        return new Intent(C2948h.f10844a);
    }

    /* renamed from: b */
    private Intent m12134b(Context context, InterfaceC2938d interfaceC2938d, Intent intent) {
        if (m12135b(intent)) {
            return null;
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10790a, C5052r.m19199a("PlugIn is removed."));
        }
        if (interfaceC2938d != null) {
            interfaceC2938d.mo12147c(context);
        }
        return new Intent(C2948h.f10845b);
    }

    /* renamed from: c */
    private Intent m12136c(Context context, InterfaceC2938d interfaceC2938d, Intent intent) {
        if (!m12135b(intent)) {
            return null;
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10790a, C5052r.m19199a("PlugIn is replaced."));
        }
        if (interfaceC2938d != null) {
            interfaceC2938d.mo12148d(context);
        }
        return new Intent(C2948h.f10846c);
    }

    /* renamed from: d */
    private Intent m12137d(Context context, InterfaceC2938d interfaceC2938d, Intent intent) {
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10790a, C5052r.m19199a("PlugIn data is cleared."));
        }
        if (interfaceC2938d != null) {
            interfaceC2938d.mo12151g(context);
        }
        return new Intent(C2948h.f10849f);
    }

    /* renamed from: a */
    private Intent m12132a(Context context, InterfaceC2938d interfaceC2938d, String str) {
        if (context.getPackageManager().getApplicationEnabledSetting(str) != 3) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f10790a, C5052r.m19199a("PlugIn is enabled."));
            }
            if (interfaceC2938d != null) {
                interfaceC2938d.mo12149e(context);
            }
            return new Intent(C2948h.f10847d);
        }
        if (C4996f.f18229a.f18171c) {
            C4996f.f18229a.m18892f(f10790a, C5052r.m19199a("PlugIn is disabled."));
        }
        if (interfaceC2938d != null) {
            interfaceC2938d.mo12150f(context);
        }
        return new Intent(C2948h.f10848e);
    }

    /* renamed from: a */
    private String m12133a(Intent intent) {
        try {
            return intent.getData().toString().split(":")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f10790a, "Can't retrieve package name.", e);
            }
            return new String();
        } catch (NullPointerException e2) {
            if (C4996f.f18229a.f18174f) {
                C4996f.f18229a.mo18649a(f10790a, "Can't retrieve package name.", e2);
            }
            return new String();
        }
    }

    /* renamed from: b */
    private boolean m12135b(Intent intent) {
        try {
            return intent.getExtras().getBoolean("android.intent.extra.REPLACING", false);
        } catch (NullPointerException e) {
            if (!C4996f.f18229a.f18174f) {
                return false;
            }
            C4996f.f18229a.mo18649a(f10790a, e.getMessage(), e);
            return false;
        }
    }
}
