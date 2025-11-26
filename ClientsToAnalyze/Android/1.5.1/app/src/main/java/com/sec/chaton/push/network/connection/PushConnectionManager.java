package com.sec.chaton.push.network.connection;

import android.content.Context;
import com.sec.chaton.push.network.pipeline.PushConnectionPipelineFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;

/* loaded from: classes.dex */
public class PushConnectionManager extends AbstractConnectionManager {
    public PushConnectionManager(Context context) {
        super(context);
    }

    @Override // com.sec.chaton.push.network.connection.AbstractConnectionManager
    /* renamed from: a */
    protected ChannelPipelineFactory mo2978a() {
        return new PushConnectionPipelineFactory(this.f2743a, true);
    }
}
