package org.jboss.netty.channel;

import java.nio.channels.WritableByteChannel;
import org.jboss.netty.util.ExternalResourceReleasable;

/* loaded from: classes.dex */
public interface FileRegion extends ExternalResourceReleasable {
    long getCount();

    long getPosition();

    long transferTo(WritableByteChannel writableByteChannel, long j);
}
