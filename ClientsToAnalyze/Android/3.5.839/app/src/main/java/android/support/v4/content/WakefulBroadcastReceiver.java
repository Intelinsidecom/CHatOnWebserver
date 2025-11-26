package android.support.v4.content;

import android.content.BroadcastReceiver;
import android.os.PowerManager;
import android.util.SparseArray;

/* loaded from: classes.dex */
public abstract class WakefulBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static final SparseArray<PowerManager.WakeLock> f287a = new SparseArray<>();

    /* renamed from: b */
    private static int f288b = 1;
}
