package android.support.v4.view;

import android.os.Build;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class ViewConfigurationCompat {

    /* renamed from: a */
    static final InterfaceC0040r f147a;

    static {
        if (Build.VERSION.SDK_INT >= 11) {
            f147a = new C0042t();
        } else {
            f147a = new C0030h();
        }
    }

    /* renamed from: a */
    public static int m193a(ViewConfiguration viewConfiguration) {
        return f147a.mo217a(viewConfiguration);
    }
}
