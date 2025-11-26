package com.sec.chaton.push.network.connection;

import android.content.Context;
import com.sec.chaton.push.network.pipeline.ProvConnectionPipelineFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;

/* loaded from: classes.dex */
public class ProvConnectionManager extends AbstractConnectionManager {
    public ProvConnectionManager(Context context) {
        super(context);
    }

    @Override // com.sec.chaton.push.network.connection.AbstractConnectionManager
    /* renamed from: a */
    protected ChannelPipelineFactory mo2978a() {
        return new ProvConnectionPipelineFactory(this.f2743a, true);
    }
}
