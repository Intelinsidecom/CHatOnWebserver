package android.support.v4.content;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
class ContextCompatHoneycomb {
    ContextCompatHoneycomb() {
    }

    static void startActivities(Context context, Intent[] intentArr) {
        context.startActivities(intentArr);
    }
}
