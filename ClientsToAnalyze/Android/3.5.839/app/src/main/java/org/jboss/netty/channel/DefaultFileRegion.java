package org.jboss.netty.channel;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

/* loaded from: classes.dex */
public class DefaultFileRegion implements FileRegion {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultFileRegion.class);
    private final long count;
    private final FileChannel file;
    private final long position;
    private final boolean releaseAfterTransfer;

    @Override // org.jboss.netty.channel.FileRegion
    public long getCount() {
        return this.count;
    }

    public boolean releaseAfterTransfer() {
        return this.releaseAfterTransfer;
    }

    @Override // org.jboss.netty.channel.FileRegion
    public long transferTo(WritableByteChannel writableByteChannel, long j) {
        long j2 = this.count - j;
        if (j2 < 0 || j < 0) {
            throw new IllegalArgumentException("position out of range: " + j + " (expected: 0 - " + (this.count - 1) + ")");
        }
        if (j2 == 0) {
            return 0L;
        }
        return this.file.transferTo(this.position + j, j2, writableByteChannel);
    }

    @Override // org.jboss.netty.util.ExternalResourceReleasable
    public void releaseExternalResources() {
        try {
            this.file.close();
        } catch (IOException e) {
            logger.warn("Failed to close a file.", e);
        }
    }
}
