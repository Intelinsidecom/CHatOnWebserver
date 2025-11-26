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
    private final Map name2ctx = new HashMap(4);
    private volatile ChannelSink sink;
    private volatile DefaultChannelHandlerContext tail;
    static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultChannelPipeline.class);
    static final ChannelSink discardingSink = new DiscardingChannelSink();

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
        public boolean canHandleDownstream() {
            return this.canHandleDownstream;
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public boolean canHandleUpstream() {
            return this.canHandleUpstream;
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public Object getAttachment() {
            return this.attachment;
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public Channel getChannel() {
            return getPipeline().getChannel();
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
        public ChannelPipeline getPipeline() {
            return DefaultChannelPipeline.this;
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public void sendDownstream(ChannelEvent channelEvent) {
            DefaultChannelHandlerContext actualDownstreamContext = DefaultChannelPipeline.this.getActualDownstreamContext(this.prev);
            if (actualDownstreamContext != null) {
                DefaultChannelPipeline.this.sendDownstream(actualDownstreamContext, channelEvent);
                return;
            }
            try {
                DefaultChannelPipeline.this.getSink().eventSunk(DefaultChannelPipeline.this, channelEvent);
            } catch (Throwable th) {
                DefaultChannelPipeline.this.notifyHandlerException(channelEvent, th);
            }
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public void sendUpstream(ChannelEvent channelEvent) {
            DefaultChannelHandlerContext actualUpstreamContext = DefaultChannelPipeline.this.getActualUpstreamContext(this.next);
            if (actualUpstreamContext != null) {
                DefaultChannelPipeline.this.sendUpstream(actualUpstreamContext, channelEvent);
            }
        }

        @Override // org.jboss.netty.channel.ChannelHandlerContext
        public void setAttachment(Object obj) {
            this.attachment = obj;
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
                if (!z) {
                    throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".afterAdd() has thrown an exception; also failed to remove.", th);
                }
                throw new ChannelHandlerLifeCycleException(lifeCycleAwareChannelHandler.getClass().getName() + ".afterAdd() has thrown an exception; removed.", th);
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

    private void checkDuplicateName(String str) {
        if (this.name2ctx.containsKey(str)) {
            throw new IllegalArgumentException("Duplicate handler name.");
        }
    }

    private DefaultChannelHandlerContext getContextOrDie(Class cls) {
        DefaultChannelHandlerContext defaultChannelHandlerContext = (DefaultChannelHandlerContext) getContext(cls);
        if (defaultChannelHandlerContext == null) {
            throw new NoSuchElementException(cls.getName());
        }
        return defaultChannelHandlerContext;
    }

    private DefaultChannelHandlerContext getContextOrDie(String str) {
        DefaultChannelHandlerContext defaultChannelHandlerContext = (DefaultChannelHandlerContext) getContext(str);
        if (defaultChannelHandlerContext == null) {
            throw new NoSuchElementException(str);
        }
        return defaultChannelHandlerContext;
    }

    private DefaultChannelHandlerContext getContextOrDie(ChannelHandler channelHandler) {
        DefaultChannelHandlerContext defaultChannelHandlerContext = (DefaultChannelHandlerContext) getContext(channelHandler);
        if (defaultChannelHandlerContext == null) {
            throw new NoSuchElementException(channelHandler.getClass().getName());
        }
        return defaultChannelHandlerContext;
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

    private ChannelHandler replace(DefaultChannelHandlerContext defaultChannelHandlerContext, String str, ChannelHandler channelHandler) {
        ChannelHandlerLifeCycleException channelHandlerLifeCycleException;
        boolean z;
        ChannelHandlerLifeCycleException channelHandlerLifeCycleException2;
        boolean z2;
        if (defaultChannelHandlerContext == this.head) {
            removeFirst();
            addFirst(str, channelHandler);
        } else if (defaultChannelHandlerContext == this.tail) {
            removeLast();
            addLast(str, channelHandler);
        } else {
            boolean zEquals = defaultChannelHandlerContext.getName().equals(str);
            if (!zEquals) {
                checkDuplicateName(str);
            }
            DefaultChannelHandlerContext defaultChannelHandlerContext2 = defaultChannelHandlerContext.prev;
            DefaultChannelHandlerContext defaultChannelHandlerContext3 = defaultChannelHandlerContext.next;
            DefaultChannelHandlerContext defaultChannelHandlerContext4 = new DefaultChannelHandlerContext(defaultChannelHandlerContext2, defaultChannelHandlerContext3, str, channelHandler);
            callBeforeRemove(defaultChannelHandlerContext);
            callBeforeAdd(defaultChannelHandlerContext4);
            defaultChannelHandlerContext2.next = defaultChannelHandlerContext4;
            defaultChannelHandlerContext3.prev = defaultChannelHandlerContext4;
            if (!zEquals) {
                this.name2ctx.remove(defaultChannelHandlerContext.getName());
                this.name2ctx.put(str, defaultChannelHandlerContext4);
            }
            try {
                callAfterRemove(defaultChannelHandlerContext);
                z = true;
                channelHandlerLifeCycleException = null;
            } catch (ChannelHandlerLifeCycleException e) {
                channelHandlerLifeCycleException = e;
                z = false;
            }
            try {
                callAfterAdd(defaultChannelHandlerContext4);
                z2 = true;
                channelHandlerLifeCycleException2 = null;
            } catch (ChannelHandlerLifeCycleException e2) {
                channelHandlerLifeCycleException2 = e2;
                z2 = false;
            }
            if (!z && !z2) {
                logger.warn(channelHandlerLifeCycleException.getMessage(), channelHandlerLifeCycleException);
                logger.warn(channelHandlerLifeCycleException2.getMessage(), channelHandlerLifeCycleException2);
                throw new ChannelHandlerLifeCycleException("Both " + defaultChannelHandlerContext.getHandler().getClass().getName() + ".afterRemove() and " + defaultChannelHandlerContext4.getHandler().getClass().getName() + ".afterAdd() failed; see logs.");
            }
            if (!z) {
                throw channelHandlerLifeCycleException;
            }
            if (!z2) {
                throw channelHandlerLifeCycleException2;
            }
        }
        return defaultChannelHandlerContext.getHandler();
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized void addAfter(String str, String str2, ChannelHandler channelHandler) {
        DefaultChannelHandlerContext contextOrDie = getContextOrDie(str);
        if (contextOrDie == this.tail) {
            addLast(str2, channelHandler);
        } else {
            checkDuplicateName(str2);
            DefaultChannelHandlerContext defaultChannelHandlerContext = new DefaultChannelHandlerContext(contextOrDie, contextOrDie.next, str2, channelHandler);
            callBeforeAdd(defaultChannelHandlerContext);
            contextOrDie.next.prev = defaultChannelHandlerContext;
            contextOrDie.next = defaultChannelHandlerContext;
            this.name2ctx.put(str2, defaultChannelHandlerContext);
            callAfterAdd(defaultChannelHandlerContext);
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized void addBefore(String str, String str2, ChannelHandler channelHandler) {
        DefaultChannelHandlerContext contextOrDie = getContextOrDie(str);
        if (contextOrDie == this.head) {
            addFirst(str2, channelHandler);
        } else {
            checkDuplicateName(str2);
            DefaultChannelHandlerContext defaultChannelHandlerContext = new DefaultChannelHandlerContext(contextOrDie.prev, contextOrDie, str2, channelHandler);
            callBeforeAdd(defaultChannelHandlerContext);
            contextOrDie.prev.next = defaultChannelHandlerContext;
            contextOrDie.prev = defaultChannelHandlerContext;
            this.name2ctx.put(str2, defaultChannelHandlerContext);
            callAfterAdd(defaultChannelHandlerContext);
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized void addFirst(String str, ChannelHandler channelHandler) {
        if (this.name2ctx.isEmpty()) {
            init(str, channelHandler);
        } else {
            checkDuplicateName(str);
            DefaultChannelHandlerContext defaultChannelHandlerContext = this.head;
            DefaultChannelHandlerContext defaultChannelHandlerContext2 = new DefaultChannelHandlerContext(null, defaultChannelHandlerContext, str, channelHandler);
            callBeforeAdd(defaultChannelHandlerContext2);
            defaultChannelHandlerContext.prev = defaultChannelHandlerContext2;
            this.head = defaultChannelHandlerContext2;
            this.name2ctx.put(str, defaultChannelHandlerContext2);
            callAfterAdd(defaultChannelHandlerContext2);
        }
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
    public synchronized ChannelHandler get(Class cls) {
        ChannelHandlerContext context;
        context = getContext(cls);
        return context == null ? null : context.getHandler();
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandler get(String str) {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        defaultChannelHandlerContext = (DefaultChannelHandlerContext) this.name2ctx.get(str);
        return defaultChannelHandlerContext == null ? null : defaultChannelHandlerContext.getHandler();
    }

    DefaultChannelHandlerContext getActualDownstreamContext(DefaultChannelHandlerContext defaultChannelHandlerContext) {
        if (defaultChannelHandlerContext == null) {
            return null;
        }
        DefaultChannelHandlerContext defaultChannelHandlerContext2 = defaultChannelHandlerContext;
        while (!defaultChannelHandlerContext2.canHandleDownstream()) {
            defaultChannelHandlerContext2 = defaultChannelHandlerContext2.prev;
            if (defaultChannelHandlerContext2 == null) {
                return null;
            }
        }
        return defaultChannelHandlerContext2;
    }

    DefaultChannelHandlerContext getActualUpstreamContext(DefaultChannelHandlerContext defaultChannelHandlerContext) {
        if (defaultChannelHandlerContext == null) {
            return null;
        }
        DefaultChannelHandlerContext defaultChannelHandlerContext2 = defaultChannelHandlerContext;
        while (!defaultChannelHandlerContext2.canHandleUpstream()) {
            defaultChannelHandlerContext2 = defaultChannelHandlerContext2.next;
            if (defaultChannelHandlerContext2 == null) {
                return null;
            }
        }
        return defaultChannelHandlerContext2;
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public Channel getChannel() {
        return this.channel;
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandlerContext getContext(Class cls) {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        if (cls == null) {
            throw new NullPointerException("handlerType");
        }
        if (this.name2ctx.isEmpty()) {
            defaultChannelHandlerContext = null;
        } else {
            defaultChannelHandlerContext = this.head;
            while (true) {
                if (cls.isAssignableFrom(defaultChannelHandlerContext.getHandler().getClass())) {
                    break;
                }
                defaultChannelHandlerContext = defaultChannelHandlerContext.next;
                if (defaultChannelHandlerContext == null) {
                    defaultChannelHandlerContext = null;
                    break;
                }
            }
        }
        return defaultChannelHandlerContext;
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandlerContext getContext(String str) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        return (ChannelHandlerContext) this.name2ctx.get(str);
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandlerContext getContext(ChannelHandler channelHandler) {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        if (channelHandler == null) {
            throw new NullPointerException("handler");
        }
        if (this.name2ctx.isEmpty()) {
            defaultChannelHandlerContext = null;
        } else {
            defaultChannelHandlerContext = this.head;
            while (true) {
                if (defaultChannelHandlerContext.getHandler() == channelHandler) {
                    break;
                }
                defaultChannelHandlerContext = defaultChannelHandlerContext.next;
                if (defaultChannelHandlerContext == null) {
                    defaultChannelHandlerContext = null;
                    break;
                }
            }
        }
        return defaultChannelHandlerContext;
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandler getFirst() {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        defaultChannelHandlerContext = this.head;
        return defaultChannelHandlerContext == null ? null : defaultChannelHandlerContext.getHandler();
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandler getLast() {
        DefaultChannelHandlerContext defaultChannelHandlerContext;
        defaultChannelHandlerContext = this.tail;
        return defaultChannelHandlerContext == null ? null : defaultChannelHandlerContext.getHandler();
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public ChannelSink getSink() {
        ChannelSink channelSink = this.sink;
        return channelSink == null ? discardingSink : channelSink;
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public boolean isAttached() {
        return this.sink != null;
    }

    protected void notifyHandlerException(ChannelEvent channelEvent, Throwable th) {
        if (channelEvent instanceof ExceptionEvent) {
            logger.warn("An exception was thrown by a user handler while handling an exception event (" + channelEvent + ")", th);
            return;
        }
        try {
            this.sink.exceptionCaught(this, channelEvent, th instanceof ChannelPipelineException ? (ChannelPipelineException) th : new ChannelPipelineException(th));
        } catch (Exception e) {
            logger.warn("An exception was thrown by an exception handler.", e);
        }
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandler remove(Class cls) {
        return remove(getContextOrDie(cls)).getHandler();
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandler remove(String str) {
        return remove(getContextOrDie(str)).getHandler();
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized void remove(ChannelHandler channelHandler) {
        remove(getContextOrDie(channelHandler));
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
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

    @Override // org.jboss.netty.channel.ChannelPipeline
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

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandler replace(Class cls, String str, ChannelHandler channelHandler) {
        return replace(getContextOrDie(cls), str, channelHandler);
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized ChannelHandler replace(String str, String str2, ChannelHandler channelHandler) {
        return replace(getContextOrDie(str), str2, channelHandler);
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public synchronized void replace(ChannelHandler channelHandler, String str, ChannelHandler channelHandler2) {
        replace(getContextOrDie(channelHandler), str, channelHandler2);
    }

    @Override // org.jboss.netty.channel.ChannelPipeline
    public void sendDownstream(ChannelEvent channelEvent) {
        DefaultChannelHandlerContext actualDownstreamContext = getActualDownstreamContext(this.tail);
        if (actualDownstreamContext != null) {
            sendDownstream(actualDownstreamContext, channelEvent);
            return;
        }
        try {
            getSink().eventSunk(this, channelEvent);
        } catch (Throwable th) {
            notifyHandlerException(channelEvent, th);
        }
    }

    void sendDownstream(DefaultChannelHandlerContext defaultChannelHandlerContext, ChannelEvent channelEvent) {
        try {
            ((ChannelDownstreamHandler) defaultChannelHandlerContext.getHandler()).handleDownstream(defaultChannelHandlerContext, channelEvent);
        } catch (Throwable th) {
            notifyHandlerException(channelEvent, th);
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
    public Map toMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!this.name2ctx.isEmpty()) {
            DefaultChannelHandlerContext defaultChannelHandlerContext = this.head;
            do {
                linkedHashMap.put(defaultChannelHandlerContext.getName(), defaultChannelHandlerContext.getHandler());
                defaultChannelHandlerContext = defaultChannelHandlerContext.next;
            } while (defaultChannelHandlerContext != null);
        }
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
            if (defaultChannelHandlerContext == null) {
                sb.append('}');
                return sb.toString();
            }
            sb.append(", ");
        }
    }
}
