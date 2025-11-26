package com.sec.common.util.log.collector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sec.common.C4996f;

/* loaded from: classes.dex */
public class LogCollectorReceiver extends BroadcastReceiver {

    /* renamed from: b */
    private static final String f18351b = LogCollectorReceiver.class.getSimpleName();

    /* renamed from: a */
    public static final String[] f18350a = {"Success", "Failed", "Invalid Parameters", "Internal Error", "Internal DB Error", "Http fail", "Timed out", "Blolcked app", "Package Not Found"};

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (C4996f.f18229a.f18172d) {
            C4996f.f18229a.m18893g(f18351b, "onReceive()");
        }
        if (!C5038c.m19168q()) {
            if (C4996f.f18229a.f18171c) {
                C4996f.f18229a.m18892f(f18351b, "writeWithInstance return because LogCollectorManager.isLogCollectorEnabled(" + C5038c.m19168q() + ")");
                return;
            }
            return;
        }
        if (context != null && intent != null && intent.getAction() != null) {
            if (intent.getAction().equals(context.getPackageName())) {
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    String string = extras2.getString("EXTRA_STR_ACTION");
                    if (C4996f.f18229a.f18172d) {
                        C4996f.f18229a.m18893g("recieve broadcast msg - extra : " + string, f18351b);
                    }
                    if (!TextUtils.isEmpty(string) && string.equals("ACTION_START_ULOG")) {
                        if (C4996f.f18229a.f18172d) {
                            C4996f.f18229a.m18893g("intent extra : ACTION_START_URGENT_LOG", f18351b);
                        }
                        Intent intent2 = new Intent(context, (Class<?>) LogCollectorSender.class);
                        if (C4996f.f18229a.f18172d) {
                            C4996f.f18229a.m18893g("onReceive bUrgent start LogCollectorSender", f18351b);
                        }
                        intent2.putExtra("bUrgent", true);
                        context.startService(intent2);
                        return;
                    }
                    if (!TextUtils.isEmpty(string) && string.equals("ACTION_STOP_ULOG") && C4996f.f18229a.f18172d) {
                        C4996f.f18229a.m18893g("intent extra : ACTION_STOP_URGENT_LOG", f18351b);
                        return;
                    }
                    return;
                }
                return;
            }
            if (intent.getAction().equals("com.sec.chaton.REGISTER_FILTER")) {
                Bundle extras3 = intent.getExtras();
                if (extras3 != null) {
                    extras3.getString("EXTRA_STR_ACTION");
                    String string2 = extras3.getString("EXTRA_STR");
                    int i = extras3.getInt("EXTRA_RESULT_CODE");
                    if (!TextUtils.isEmpty(string2) && string2.equals("RESULT_SUCCESS")) {
                        if (i == 200) {
                            if (C4996f.f18229a.f18172d) {
                                C4996f.f18229a.m18893g(f18351b, "LOG_COLLECTOR_REGISTER Already Registered()");
                            }
                        } else if (C4996f.f18229a.f18172d) {
                            C4996f.f18229a.m18893g(f18351b, "LOG_COLLECTOR_REGISTER Successfully Registered()");
                        }
                        C5038c.m19149b(true);
                        return;
                    }
                    if (C4996f.f18229a.f18172d && i != 0 && (-i) < 9) {
                        C4996f.f18229a.m18893g(f18351b, "LOG_COLLECTOR_REGISTER Failed :: " + f18350a[-i]);
                    }
                    C5038c.m19149b(false);
                    return;
                }
                return;
            }
            if (intent.getAction().equals("com.sec.chaton.DEREGISTER_FILTER") && (extras = intent.getExtras()) != null) {
                extras.getString("EXTRA_STR_ACTION");
                String string3 = extras.getString("EXTRA_STR");
                int i2 = extras.getInt("EXTRA_RESULT_CODE");
                if (!TextUtils.isEmpty(string3) && string3.equals("RESULT_SUCCESS")) {
                    C5038c.m19149b(false);
                    if (C4996f.f18229a.f18172d) {
                        C4996f.f18229a.m18893g(f18351b, "LOG_COLLECTOR_REGISTER Successfully DeRegistered()");
                        return;
                    }
                    return;
                }
                if (C4996f.f18229a.f18172d && i2 != 0 && (-i2) < 9) {
                    C4996f.f18229a.m18893g(f18351b, "LOG_COLLECTOR_REGISTER Failed :: " + f18350a[-i2]);
                }
            }
        }
    }
}
