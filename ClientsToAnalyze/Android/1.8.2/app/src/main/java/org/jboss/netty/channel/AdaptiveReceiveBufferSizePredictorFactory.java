package org.jboss.netty.channel;

import android.support.v4.view.accessibility.AccessibilityEventCompat;

/* loaded from: classes.dex */
public class AdaptiveReceiveBufferSizePredictorFactory implements ReceiveBufferSizePredictorFactory {
    private final int initial;
    private final int maximum;
    private final int minimum;

    public AdaptiveReceiveBufferSizePredictorFactory() {
        this(64, AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END, 65536);
    }

    public AdaptiveReceiveBufferSizePredictorFactory(int i, int i2, int i3) {
        if (i <= 0) {
            throw new IllegalArgumentException("minimum: " + i);
        }
        if (i2 < i) {
            throw new IllegalArgumentException("initial: " + i2);
        }
        if (i3 < i2) {
            throw new IllegalArgumentException("maximum: " + i3);
        }
        this.minimum = i;
        this.initial = i2;
        this.maximum = i3;
    }

    @Override // org.jboss.netty.channel.ReceiveBufferSizePredictorFactory
    public ReceiveBufferSizePredictor getPredictor() {
        return new AdaptiveReceiveBufferSizePredictor(this.minimum, this.initial, this.maximum);
    }
}
