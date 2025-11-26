package org.jboss.netty.channel.socket.nio;

import android.hardware.motion.MotionRecognitionManager;
import java.net.Socket;
import java.util.Map;
import org.jboss.netty.channel.AdaptiveReceiveBufferSizePredictorFactory;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ReceiveBufferSizePredictor;
import org.jboss.netty.channel.ReceiveBufferSizePredictorFactory;
import org.jboss.netty.channel.socket.DefaultSocketChannelConfig;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.util.internal.ConversionUtil;

/* loaded from: classes.dex */
class DefaultNioSocketChannelConfig extends DefaultSocketChannelConfig implements NioSocketChannelConfig {
    private volatile ReceiveBufferSizePredictor predictor;
    private volatile ReceiveBufferSizePredictorFactory predictorFactory;
    private volatile int writeBufferHighWaterMark;
    private volatile int writeBufferLowWaterMark;
    private volatile int writeSpinCount;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultNioSocketChannelConfig.class);
    private static final ReceiveBufferSizePredictorFactory DEFAULT_PREDICTOR_FACTORY = new AdaptiveReceiveBufferSizePredictorFactory();

    DefaultNioSocketChannelConfig(Socket socket) {
        super(socket);
        this.writeBufferHighWaterMark = 65536;
        this.writeBufferLowWaterMark = MotionRecognitionManager.EVENT_SMART_ALERT_SETTING;
        this.predictorFactory = DEFAULT_PREDICTOR_FACTORY;
        this.writeSpinCount = 16;
    }

    @Override // org.jboss.netty.channel.DefaultChannelConfig, org.jboss.netty.channel.ChannelConfig
    public void setOptions(Map<String, Object> map) {
        super.setOptions(map);
        if (getWriteBufferHighWaterMark() < getWriteBufferLowWaterMark()) {
            setWriteBufferLowWaterMark0(getWriteBufferHighWaterMark() >>> 1);
            logger.warn("writeBufferLowWaterMark cannot be greater than writeBufferHighWaterMark; setting to the half of the writeBufferHighWaterMark.");
        }
    }

    @Override // org.jboss.netty.channel.socket.DefaultSocketChannelConfig, org.jboss.netty.channel.DefaultChannelConfig
    public boolean setOption(String str, Object obj) {
        if (super.setOption(str, obj)) {
            return true;
        }
        if (str.equals("writeBufferHighWaterMark")) {
            setWriteBufferHighWaterMark0(ConversionUtil.toInt(obj));
            return true;
        }
        if (str.equals("writeBufferLowWaterMark")) {
            setWriteBufferLowWaterMark0(ConversionUtil.toInt(obj));
            return true;
        }
        if (str.equals("writeSpinCount")) {
            setWriteSpinCount(ConversionUtil.toInt(obj));
            return true;
        }
        if (str.equals("receiveBufferSizePredictorFactory")) {
            setReceiveBufferSizePredictorFactory((ReceiveBufferSizePredictorFactory) obj);
            return true;
        }
        if (str.equals("receiveBufferSizePredictor")) {
            setReceiveBufferSizePredictor((ReceiveBufferSizePredictor) obj);
            return true;
        }
        return false;
    }

    @Override // org.jboss.netty.channel.socket.nio.NioSocketChannelConfig
    public int getWriteBufferHighWaterMark() {
        return this.writeBufferHighWaterMark;
    }

    private void setWriteBufferHighWaterMark0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("writeBufferHighWaterMark: " + i);
        }
        this.writeBufferHighWaterMark = i;
    }

    @Override // org.jboss.netty.channel.socket.nio.NioSocketChannelConfig
    public int getWriteBufferLowWaterMark() {
        return this.writeBufferLowWaterMark;
    }

    private void setWriteBufferLowWaterMark0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("writeBufferLowWaterMark: " + i);
        }
        this.writeBufferLowWaterMark = i;
    }

    @Override // org.jboss.netty.channel.socket.nio.NioSocketChannelConfig
    public int getWriteSpinCount() {
        return this.writeSpinCount;
    }

    public void setWriteSpinCount(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("writeSpinCount must be a positive integer.");
        }
        this.writeSpinCount = i;
    }

    @Override // org.jboss.netty.channel.socket.nio.NioSocketChannelConfig
    public ReceiveBufferSizePredictor getReceiveBufferSizePredictor() {
        ReceiveBufferSizePredictor receiveBufferSizePredictor = this.predictor;
        if (receiveBufferSizePredictor == null) {
            try {
                ReceiveBufferSizePredictor predictor = getReceiveBufferSizePredictorFactory().getPredictor();
                this.predictor = predictor;
                return predictor;
            } catch (Exception e) {
                throw new ChannelException("Failed to create a new " + ReceiveBufferSizePredictor.class.getSimpleName() + '.', e);
            }
        }
        return receiveBufferSizePredictor;
    }

    public void setReceiveBufferSizePredictor(ReceiveBufferSizePredictor receiveBufferSizePredictor) {
        if (receiveBufferSizePredictor == null) {
            throw new NullPointerException("predictor");
        }
        this.predictor = receiveBufferSizePredictor;
    }

    public ReceiveBufferSizePredictorFactory getReceiveBufferSizePredictorFactory() {
        return this.predictorFactory;
    }

    public void setReceiveBufferSizePredictorFactory(ReceiveBufferSizePredictorFactory receiveBufferSizePredictorFactory) {
        if (receiveBufferSizePredictorFactory == null) {
            throw new NullPointerException("predictorFactory");
        }
        this.predictorFactory = receiveBufferSizePredictorFactory;
    }
}
