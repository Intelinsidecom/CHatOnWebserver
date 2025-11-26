package org.jboss.netty.util;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public interface Timer {
    Timeout newTimeout(TimerTask timerTask, long j, TimeUnit timeUnit);

    Set stop();
}
