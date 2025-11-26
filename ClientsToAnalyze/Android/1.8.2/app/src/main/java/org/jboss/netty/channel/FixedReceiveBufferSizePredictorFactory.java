package org.jboss.netty.channel;

/* loaded from: classes.dex */
public class FixedReceiveBufferSizePredictorFactory implements ReceiveBufferSizePredictorFactory {
    private final ReceiveBufferSizePredictor predictor;

    public FixedReceiveBufferSizePredictorFactory(int i) {
        this.predictor = new FixedReceiveBufferSizePredictor(i);
    }

    @Override // org.jboss.netty.channel.ReceiveBufferSizePredictorFactory
    public ReceiveBufferSizePredictor getPredictor() {
        return this.predictor;
    }
}
