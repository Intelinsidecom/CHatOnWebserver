package com.sec.chaton.plugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import com.sec.common.C3330f;
import com.sec.common.util.C3364o;

/* loaded from: classes.dex */
public class PlugInMonitor extends BroadcastReceiver {

    /* renamed from: a */
    private static final String f7462a = PlugInMonitor.class.getSimpleName();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        InterfaceC1950c interfaceC1950c;
        Intent intentM7896a;
        String action = intent.getAction();
        String strM7897a = m7897a(intent);
        if (!TextUtils.isEmpty(strM7897a)) {
            if (C3330f.f12033a.f11972b) {
                C3330f.f12033a.m11651a(f7462a, "PlugInMonitor.onReceive()");
                C3330f.f12033a.m11651a(f7462a, C3364o.m11849a(" Action: ", action, ", Data:", intent.getData(), ", Package: ", strM7897a));
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
                            sb.append(C3364o.m11849a(str2, ","));
                        }
                        sb.append("}");
                    } else {
                        sb.append(extras.get(str));
                    }
                    sb.append("\n");
                }
                sb.append(" ===== Bundle");
                C3330f.f12033a.m11651a(f7462a, sb.toString());
            }
            EnumC1955h enumC1955hM7919a = EnumC1955h.m7919a(strM7897a);
            if (enumC1955hM7919a != null) {
                try {
                    interfaceC1950c = (InterfaceC1950c) C1954g.m7916a().m7917a(enumC1955hM7919a);
                } catch (C1953f e) {
                    if (!C3330f.f12033a.f11975e) {
                        interfaceC1950c = null;
                    } else {
                        C3330f.f12033a.m11652a(f7462a, e.getMessage(), e);
                        return;
                    }
                }
                if (C3330f.f12033a.f11972b) {
                    C3330f.f12033a.m11651a(f7462a, C3364o.m11849a("PlugInType: ", enumC1955hM7919a, ", PlugIn: ", interfaceC1950c));
                }
                if ("android.intent.action.PACKAGE_ADDED".equals(action)) {
                    intentM7896a = m7895a(context, interfaceC1950c, intent);
                } else if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                    intentM7896a = m7898b(context, interfaceC1950c, intent);
                } else if ("android.intent.action.PACKAGE_REPLACED".equals(action)) {
                    intentM7896a = m7900c(context, interfaceC1950c, intent);
                } else if ("android.intent.action.PACKAGE_DATA_CLEARED".equals(action)) {
                    intentM7896a = m7901d(context, interfaceC1950c, intent);
                } else if (!"android.intent.action.PACKAGE_CHANGED".equals(action)) {
                    intentM7896a = null;
                } else {
                    intentM7896a = m7896a(context, interfaceC1950c, strM7897a);
                }
                if (intentM7896a != null) {
                    intentM7896a.putExtra(C1954g.f7474g, enumC1955hM7919a);
                    if (C3330f.f12033a.f11972b) {
                        C3330f.f12033a.m11651a(f7462a, C3364o.m11849a("Send broadcast. Intent: ", intentM7896a));
                    }
                    LocalBroadcastManager.getInstance(context).sendBroadcast(intentM7896a);
                    return;
                }
                return;
            }
            if (C3330f.f12033a.f11972b) {
                C3330f.f12033a.m11651a(f7462a, C3364o.m11849a("It isn't supported plugin."));
            }
        }
    }

    /* renamed from: a */
    private Intent m7895a(Context context, InterfaceC1950c interfaceC1950c, Intent intent) {
        if (m7899b(intent)) {
            return null;
        }
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7462a, C3364o.m11849a("PlugIn is installed."));
        }
        if (interfaceC1950c != null) {
            interfaceC1950c.mo7907c(context);
        }
        return new Intent(C1954g.f7468a);
    }

    /* renamed from: b */
    private Intent m7898b(Context context, InterfaceC1950c interfaceC1950c, Intent intent) {
        if (m7899b(intent)) {
            return null;
        }
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7462a, C3364o.m11849a("PlugIn is removed."));
        }
        if (interfaceC1950c != null) {
            interfaceC1950c.mo7908d(context);
        }
        return new Intent(C1954g.f7469b);
    }

    /* renamed from: c */
    private Intent m7900c(Context context, InterfaceC1950c interfaceC1950c, Intent intent) {
        if (!m7899b(intent)) {
            return null;
        }
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7462a, C3364o.m11849a("PlugIn is replaced."));
        }
        if (interfaceC1950c != null) {
            interfaceC1950c.mo7909e(context);
        }
        return new Intent(C1954g.f7470c);
    }

    /* renamed from: d */
    private Intent m7901d(Context context, InterfaceC1950c interfaceC1950c, Intent intent) {
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7462a, C3364o.m11849a("PlugIn data is cleared."));
        }
        if (interfaceC1950c != null) {
            interfaceC1950c.mo7912h(context);
        }
        return new Intent(C1954g.f7473f);
    }

    /* renamed from: a */
    private Intent m7896a(Context context, InterfaceC1950c interfaceC1950c, String str) {
        if (context.getPackageManager().getApplicationEnabledSetting(str) != 3) {
            if (C3330f.f12033a.f11972b) {
                C3330f.f12033a.m11651a(f7462a, C3364o.m11849a("PlugIn is enabled."));
            }
            if (interfaceC1950c != null) {
                interfaceC1950c.mo7910f(context);
            }
            return new Intent(C1954g.f7471d);
        }
        if (C3330f.f12033a.f11972b) {
            C3330f.f12033a.m11651a(f7462a, C3364o.m11849a("PlugIn is disabled."));
        }
        if (interfaceC1950c != null) {
            interfaceC1950c.mo7911g(context);
        }
        return new Intent(C1954g.f7472e);
    }

    /* renamed from: a */
    private String m7897a(Intent intent) {
        try {
            return intent.getData().toString().split(":")[1];
        } catch (ArrayIndexOutOfBoundsException e) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f7462a, "Can't retrieve package name.", e);
            }
            return new String();
        } catch (NullPointerException e2) {
            if (C3330f.f12033a.f11975e) {
                C3330f.f12033a.m11652a(f7462a, "Can't retrieve package name.", e2);
            }
            return new String();
        }
    }

    /* renamed from: b */
    private boolean m7899b(Intent intent) {
        try {
            return intent.getExtras().getBoolean("android.intent.extra.REPLACING", false);
        } catch (NullPointerException e) {
            if (!C3330f.f12033a.f11975e) {
                return false;
            }
            C3330f.f12033a.m11652a(f7462a, e.getMessage(), e);
            return false;
        }
    }
}
