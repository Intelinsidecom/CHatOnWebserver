package org.jboss.netty.channel;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import org.jboss.netty.logging.InternalLogger;
import org.jboss.netty.logging.InternalLoggerFactory;

/* loaded from: classes.dex */
public class DefaultChannelPipeline implements ChannelPipeline {
    private volatile Channel channel;
    private volatile DefaultChannelHandlerContext head;
    private final Map<String, DefaultChannelHandlerContext> name2ctx = new HashMap(4);
    private volatile ChannelSink sink;
    private volatile DefaultChannelHandlerContext tail;
    static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) DefaultChannelPipeline.class);
    static final ChannelSink discardingSink = new DiscardingChannelSink();

    @Override // org.jboss.netty.channel.ChannelPipeline
    public Channel getChannel() {
        return this.channel;
    }

    public ChannelSink getSink() {
        ChannelSink channelSink = this.sink;
        if (channelSink == null) {
            return discardingSink;
        }
        return channelSink;
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public void attach(Channel channel, ChannelSink channelSink) {
        if (channel == null) {
            throw new NullPointerException("channel");
        }
        if (channelSink == null) {
            throw new NullPointerException("sink");
        }
        if (this.channel != null || this.sink != null) {
            throw new IllegalStateException("attached already");
        }
        this.channel = channel;
        this.sink = channelSink;
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized void addLast(String str, ChannelHandler channelHandler) {
        if (this.name2ctx.isEmpty()) {
            init(str, channelHandler);
        } else {
            checkDuplicateName(str);
            DefaultChannelHandlerContext defaultChannelHandlerContext = this.tail;
            DefaultChannelHandlerContext defaultChannelHandlerContext2 = new DefaultChannelHandlerContext(defaultChannelHandlerContext, null, str, channelHandler);
            callBeforeAdd(defaultChannelHandlerContext2);
            defaultChannelHandlerContext.next = defaultChannelHandlerContext2;
            this.tail = defaultChannelHandlerContext2;
            this.name2ctx.put(str, defaultChannelHandlerContext2);
            callAfterAdd(defaultChannelHandlerContext2);
        }
    }

    private DefaultChannelHandlerContext remove(DefaultChannelHandlerContext defaultChannelHandlerContext) {
        if (this.head == this.tail) {
            this.tail = null;
            this.head = null;
            this.name2ctx.clear();
        } else if (defaultChannelHandlerContext == this.head) {
            removeFirst();
        } else if (defaultChannelHandlerContext == this.tail) {
            removeLast();
        } else {
            callBeforeRemove(defaultChannelHandlerContext);
            DefaultChannelHandlerContext defaultChannelHandlerContext2 = defaultChannelHandlerContext.prev;
            DefaultChannelHandlerContext defaultChannelHandlerContext3 = defaultChannelHandlerContext.next;
            defaultChannelHandlerContext2.next = defaultChannelHandlerContext3;
            defaultChannelHandlerContext3.prev = defaultChannelHandlerContext2;
            this.name2ctx.remove(defaultChannelHandlerContext.getName());
            callAfterRemove(defaultChannelHandlerContext);
        }
        return defaultChannelHandlerContext;
    }

    public synchronized ChannelHandler removeFirst() {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        if (this.name2ctx.isEmpty()) {
            throw new NoSuchElementException();
        }
        defaultChannelHandlerContext = this.head;
        if (defaultChannelHandlerContext == null) {
            throw new NoSuchElementException();
        }
        callBeforeRemove(defaultChannelHandlerContext);
        if (defaultChannelHandlerContext.next == null) {
            this.tail = null;
            this.head = null;
            this.name2ctx.clear();
        } else {
            defaultChannelHandlerContext.next.prev = null;
            this.head = defaultChannelHandlerContext.next;
            this.name2ctx.remove(defaultChannelHandlerContext.getName());
        }
        callAfterRemove(defaultChannelHandlerContext);
        return defaultChannelHandlerContext.getHandler();
    }

    public synchronized ChannelHandler removeLast() {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        if (this.name2ctx.isEmpty()) {
            throw new NoSuchElementException();
        }
        defaultChannelHandlerContext = this.tail;
        if (defaultChannelHandlerContext == null) {
            throw new NoSuchElementException();
        }
        callBeforeRemove(defaultChannelHandlerContext);
        if (defaultChannelHandlerContext.prev == null) {
            this.tail = null;
            this.head = null;
            this.name2ctx.clear();
        } else {
            defaultChannelHandlerContext.prev.next = null;
            this.tail = defaultChannelHandlerContext.prev;
            this.name2ctx.remove(defaultChannelHandlerContext.getName());
        }
        callBeforeRemove(defaultChannelHandlerContext);
        return defaultChannelHandlerContext.getHandler();
    }

    private void callBeforeAdd(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.getHandler() instanceof LifeCycleAwareChannelHandler) {
            LifeCycleAwareChannelHandler lifeCycleAwareChannelHandler = (LifeCycleAwareChannelHandler) channelHandlerContext.getHandler();
            try {
                lifeCycleAwareChannelHandler.beforeAdd(channelHandlerContext);
            } catch (Throwable th) {
                throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".beforeAdd() has thrown an exception; not adding.", th);
            }
        }
    }

    private void callAfterAdd(ChannelHandlerContext channelHandlerContext) {
        boolean z;
        if (channelHandlerContext.getHandler() instanceof LifeCycleAwareChannelHandler) {
            LifeCycleAwareChannelHandler lifeCycleAwareChannelHandler = (LifeCycleAwareChannelHandler) channelHandlerContext.getHandler();
            try {
                lifeCycleAwareChannelHandler.afterAdd(channelHandlerContext);
            } catch (Throwable th) {
                try {
                    remove((DefaultChannelHandlerContext) channelHandlerContext);
                    z = true;
                } catch (Throwable th2) {
                    logger.warn("Failed to remove a handler: " + channelHandlerContext.getName(), th2);
                    z = false;
                }
                if (z) {
                    throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".afterAdd() has thrown an exception; removed.", th);
                }
                throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".afterAdd() has thrown an exception; also failed to remove.", th);
            }
        }
    }

    private void callBeforeRemove(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.getHandler() instanceof LifeCycleAwareChannelHandler) {
            LifeCycleAwareChannelHandler lifeCycleAwareChannelHandler = (LifeCycleAwareChannelHandler) channelHandlerContext.getHandler();
            try {
                lifeCycleAwareChannelHandler.beforeRemove(channelHandlerContext);
            } catch (Throwable th) {
                throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".beforeRemove() has thrown an exception; not removing.", th);
            }
        }
    }

    private void callAfterRemove(ChannelHandlerContext channelHandlerContext) {
        if (channelHandlerContext.getHandler() instanceof LifeCycleAwareChannelHandler) {
            LifeCycleAwareChannelHandler lifeCycleAwareChannelHandler = (LifeCycleAwareChannelHandler) channelHandlerContext.getHandler();
            try {
                lifeCycleAwareChannelHandler.afterRemove(channelHandlerContext);
            } catch (Throwable th) {
                throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".afterRemove() has thrown an exception.", th);
            }
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandler getLast() {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        defaultChannelHandlerContext = this.tail;
        return defaultChannelHandlerContext == null ? null : defaultChannelHandlerContext.getHandler();
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandler get(String str) {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        defaultChannelHandlerContext = this.name2ctx.get(str);
        return defaultChannelHandlerContext == null ? null : defaultChannelHandlerContext.getHandler();
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized <T extends ChannelHandler> T get(Class<T> cls) {
        ChannelHandlerContext context;
        context = getContext(cls);
        return context == null ? null : (T) context.getHandler();
    }

    public synchronized ChannelHandlerContext getContext(Class<? extends ChannelHandler> cls) {
        DefaultChannelHandlerContext defaultChannelHandlerContext = null;
        synchronized (this) {
            if (cls == null) {
                throw new NullPointerException("handlerType");
            }
            if (!this.name2ctx.isEmpty()) {
                DefaultChannelHandlerContext defaultChannelHandlerContext2 = this.head;
                while (true) {
                    if (cls.isAssignableFrom(defaultChannelHandlerContext2.getHandler().getClass())) {
                        defaultChannelHandlerContext = defaultChannelHandlerContext2;
                        break;
                    }
                    defaultChannelHandlerContext2 = defaultChannelHandlerContext2.next;
                    if (defaultChannelHandlerContext2 == null) {
                        break;
                    }
                }
            }
        }
        return defaultChannelHandlerContext;
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public Map<String, ChannelHandler> toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (this.name2ctx.isEmpty()) {
            return linkedHashMap;
        }
        DefaultChannelHandlerContext defaultChannelHandlerContext = this.head;
        do {
            linkedHashMap.put(defaultChannelHandlerContext.getName(), defaultChannelHandlerContext.getHandler());
            defaultChannelHandlerContext = defaultChannelHandlerContext.next;
        } while (defaultChannelHandlerContext != null);
        return linkedHashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('{');
        DefaultChannelHandlerContext defaultChannelHandlerContext = this.head;
        while (true) {
            sb.append('(');
            sb.append(defaultChannelHandlerContext.getName());
            sb.append(" = ");
            sb.append(defaultChannelHandlerContext.getHandler().getClass().getName());
            sb.append(')');
            defaultChannelHandlerContext = defaultChannelHandlerContext.next;
            if (defaultChannelHandlerContext != null) {
                sb.append(", ");
            } else {
                sb.append('}');
                return sb.toString();
            }
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public void sendUpstream(ChannelEvent channelEvent) {
        DefaultChannelHandlerContext actualUpstreamContext = getActualUpstreamContext(this.head);
        if (actualUpstreamContext == null) {
            logger.warn("The pipeline contains no upstream handlers; discarding: " + channelEvent);
        } else {
            sendUpstream(actualUpstreamContext, channelEvent);
        }
    }

    void sendUpstream(DefaultChannelHandlerContext defaultChannelHandlerContext, ChannelEvent channelEvent) {
        try {
            ((ChannelUpstreamHandler) defaultChannelHandlerContext.getHandler()).handleUpstream(defaultChannelHandlerContext, channelEvent);
        } catch (Throwable th) {
            notifyHandlerException(channelEvent, th);
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public void sendDownstream(ChannelEvent channelEvent) {
        DefaultChannelHandlerContext actualDownstreamContext = getActualDownstreamContext(this.tail);
        if (actualDownstreamContext == null) {
            try {
                getSink().eventSunk(this, channelEvent);
                return;
            } catch (Throwable th) {
                notifyHandlerException(channelEvent, th);
                return;
            }
        }
        sendDownstream(actualDownstreamContext, channelEvent);
    }

    void sendDownstream(DefaultChannelHandlerContext defaultChannelHandlerContext, ChannelEvent channelEvent) {
        if (channelEvent instanceof UpstreamMessageEvent) {
            throw new IllegalArgumentException("cannot send an upstream event to downstream");
        }
        try {
            ((ChannelDownstreamHandler) defaultChannelHandlerContext.getHandler()).handleDownstream(defaultChannelHandlerContext, channelEvent);
        } catch (Throwable th) {
            channelEvent.getFuture().setFailure(th);
            notifyHandlerException(channelEvent, th);
        }
    }

    DefaultChannelHandlerContext getActualUpstreamContext(DefaultChannelHandlerContext defaultChannelHandlerContext) {
        if (defaultChannelHandlerContext == null) {
            return null;
        }
        while (!defaultChannelHandlerContext.canHandleUpstream()) {
            defaultChannelHandlerContext = defaultChannelHandlerContext.next;
            if (defaultChannelHandlerContext == null) {
                return null;
            }
        }
        return defaultChannelHandlerContext;
    }

    DefaultChannelHandlerContext getActualDownstreamContext(DefaultChannelHandlerContext defaultChannelHandlerContext) {
        if (defaultChannelHandlerContext == null) {
            return null;
        }
        while (!defaultChannelHandlerContext.canHandleDownstream()) {
            defaultChannelHandlerContext = defaultChannelHandlerContext.prev;
            if (defaultChannelHandlerContext == null) {
                return null;
            }
        }
        return defaultChannelHandlerContext;
    }

    protected void notifyHandlerException(ChannelEvent channelEvent, Throwable th) {
        ChannelPipelineException channelPipelineException;
        if (channelEvent instanceof ExceptionEvent) {
            logger.warn("An exception was thrown by a user handler while handling an exception event (" + channelEvent + ")", th);
            return;
        }
        if (th instanceof ChannelPipelineException) {
            channelPipelineException = (ChannelPipelineException) th;
        } else {
            channelPipelineException = new ChannelPipelineException(th);
        }
        try {
            this.sink.exceptionCaught(this, channelEvent, channelPipelineException);
        } catch (Exception e) {
            logger.warn("An exception was thrown by an exception handler.", e);
        }
    }

    private void init(String str, ChannelHandler channelHandler) {
        DefaultChannelHandlerContext defaultChannelHandlerContext = new DefaultChannelHandlerContext(null, null, str, channelHandler);
        callBeforeAdd(defaultChannelHandlerContext);
        this.tail = defaultChannelHandlerContext;
        this.head = defaultChannelHandlerContext;
        this.name2ctx.clear();
        this.name2ctx.put(str, defaultChannelHandlerContext);
        callAfterAdd(defaultChannelHandlerContext);
    }

    private void checkDuplicateName(String str) {
        if (this.name2ctx.containsKey(str)) {
            throw new IllegalArgumentException("Duplicate handler name.");
        }
    }

    final class DefaultChannelHandlerContext implements ChannelHandlerContext {
        private volatile Object attachment;
        private final boolean canHandleDownstream;
        private final boolean canHandleUpstream;
        private final ChannelHandler handler;
        private final String name;
        volatile DefaultChannelHandlerContext next;
        volatile DefaultChannelHandlerContext prev;

        DefaultChannelHandlerContext(DefaultChannelHandlerContext defaultChannelHandlerContext, DefaultChannelHandlerContext defaultChannelHandlerContext2, String str, ChannelHandler channelHandler) {
            if (str == null) {
                throw new NullPointerException("name");
            }
            if (channelHandler == null) {
                throw new NullPointerException("handler");
            }
            this.canHandleUpstream = channelHandler instanceof ChannelUpstreamHandler;
            this.canHandleDownstream = channelHandler instanceof ChannelDownstreamHandler;
            if (!this.canHandleUpstream && !this.canHandleDownstream) {
                throw new IllegalArgumentException("handler must be either " + ChannelUpstreamHandler.class.getName() + " or " + ChannelDownstreamHandler.class.getName() + '.');
            }
            this.prev = defaultChannelHandlerContext;
            this.next = defaultChannelHandlerContext2;
            this.name = str;
            this.handler = channelHandler;
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public Channel getChannel() {
            return getPipeline().getChannel();
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public ChannelPipeline getPipeline() {
            return DefaultChannelPipeline.this;
        }

        public boolean canHandleDownstream() {
            return this.canHandleDownstream;
        }

        public boolean canHandleUpstream() {
            return this.canHandleUpstream;
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public ChannelHandler getHandler() {
            return this.handler;
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public String getName() {
            return this.name;
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public Object getAttachment() {
            return this.attachment;
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public void setAttachment(Object obj) {
            this.attachment = obj;
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public void sendDownstream(ChannelEvent channelEvent) {
            DefaultChannelHandlerContext actualDownstreamContext = DefaultChannelPipeline.this.getActualDownstreamContext(this.prev);
            if (actualDownstreamContext == null) {
                try {
                    DefaultChannelPipeline.this.getSink().eventSunk(DefaultChannelPipeline.this, channelEvent);
                    return;
                } catch (Throwable th) {
                    DefaultChannelPipeline.this.notifyHandlerException(channelEvent, th);
                    return;
                }
            }
            DefaultChannelPipeline.this.sendDownstream(actualDownstreamContext, channelEvent);
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public void sendUpstream(ChannelEvent channelEvent) {
            DefaultChannelHandlerContext actualUpstreamContext = DefaultChannelPipeline.this.getActualUpstreamContext(this.next);
            if (actualUpstreamContext != null) {
                DefaultChannelPipeline.this.sendUpstream(actualUpstreamContext, channelEvent);
            }
        }
    }

    final class DiscardingChannelSink implements ChannelSink {
        DiscardingChannelSink() {
        }

        @Override // org.jboss.netty.channel.ChannelSink
        public void eventSunk(ChannelPipeline channelPipeline, ChannelEvent channelEvent) {
            DefaultChannelPipeline.logger.warn("Not attached yet; discarding: " + channelEvent);
        }

        @Override // org.jboss.netty.channel.ChannelSink
        public void exceptionCaught(ChannelPipeline channelPipeline, ChannelEvent channelEvent, ChannelPipelineException channelPipelineException) {
            throw channelPipelineException;
        }
    }
}
