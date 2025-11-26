package com.vlingo.sdk.internal.util;

import com.vlingo.sdk.internal.logging.Logger;
import java.util.Timer;

/* loaded from: classes.dex */
public class TimerSingleton {
    private static TimerSingletonTimer timer;

    public static synchronized Timer getTimer() {
        if (timer == null) {
            timer = new TimerSingletonTimer();
        }
        return timer;
    }

    public static synchronized void destroy() {
        if (timer != null) {
            timer.cancelTimer();
            timer = null;
        }
    }

    public static class TimerSingletonTimer extends Timer {
        @Override // java.util.Timer
        public void cancel() {
            Logger.getLogger(TimerSingletonTimer.class).error("GEN2", "someone calling cancel on shared timer.");
        }

        protected void cancelTimer() {
            super.cancel();
        }
    }
}
