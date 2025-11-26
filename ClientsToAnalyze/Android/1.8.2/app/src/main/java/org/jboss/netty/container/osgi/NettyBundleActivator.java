package org.jboss.netty.container.osgi;

import org.jboss.netty.logging.InternalLoggerFactory;
import org.jboss.netty.logging.OsgiLoggerFactory;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/* loaded from: classes.dex */
public class NettyBundleActivator implements BundleActivator {
    private OsgiLoggerFactory loggerFactory;

    public void start(BundleContext bundleContext) {
        this.loggerFactory = new OsgiLoggerFactory(bundleContext);
        InternalLoggerFactory.setDefaultFactory(this.loggerFactory);
    }

    public void stop(BundleContext bundleContext) {
        if (this.loggerFactory != null) {
            InternalLoggerFactory.setDefaultFactory(this.loggerFactory.getFallback());
            this.loggerFactory.destroy();
            this.loggerFactory = null;
        }
    }
}
