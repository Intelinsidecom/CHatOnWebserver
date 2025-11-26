package com.google.protobuf;

import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.GeneratedMessage.Builder;
import com.google.protobuf.MessageOrBuilder;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class RepeatedFieldBuilder<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> implements GeneratedMessage.BuilderParent {
    private List<SingleFieldBuilder<MType, BType, IType>> builders;
    private BuilderExternalList<MType, BType, IType> externalBuilderList;
    private MessageExternalList<MType, BType, IType> externalMessageList;
    private MessageOrBuilderExternalList<MType, BType, IType> externalMessageOrBuilderList;
    private boolean isClean;
    private boolean isMessagesListMutable;
    private List<MType> messages;
    private GeneratedMessage.BuilderParent parent;

    public RepeatedFieldBuilder(List<MType> messages, boolean isMessagesListMutable, GeneratedMessage.BuilderParent parent, boolean isClean) {
        this.messages = messages;
        this.isMessagesListMutable = isMessagesListMutable;
        this.parent = parent;
        this.isClean = isClean;
    }

    public void dispose() {
        this.parent = null;
    }

    private void ensureMutableMessageList() {
        if (!this.isMessagesListMutable) {
            this.messages = new ArrayList(this.messages);
            this.isMessagesListMutable = true;
        }
    }

    private void ensureBuilders() {
        if (this.builders == null) {
            this.builders = new ArrayList(this.messages.size());
            for (int i = 0; i < this.messages.size(); i++) {
                this.builders.add(null);
            }
        }
    }

    public int getCount() {
        return this.messages.size();
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    public MType getMessage(int i) {
        return (MType) getMessage(i, false);
    }

    private MType getMessage(int i, boolean z) {
        if (this.builders == null) {
            return this.messages.get(i);
        }
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = this.builders.get(i);
        if (singleFieldBuilder == null) {
            return this.messages.get(i);
        }
        return z ? (MType) singleFieldBuilder.build() : (MType) singleFieldBuilder.getMessage();
    }

    public BType getBuilder(int i) {
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = this.builders.get(i);
        if (singleFieldBuilder == null) {
            singleFieldBuilder = new SingleFieldBuilder<>(this.messages.get(i), this, this.isClean);
            this.builders.set(i, singleFieldBuilder);
        }
        return (BType) singleFieldBuilder.getBuilder();
    }

    public IType getMessageOrBuilder(int i) {
        if (this.builders == null) {
            return this.messages.get(i);
        }
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = this.builders.get(i);
        if (singleFieldBuilder == null) {
            return this.messages.get(i);
        }
        return (IType) singleFieldBuilder.getMessageOrBuilder();
    }

    public RepeatedFieldBuilder<MType, BType, IType> setMessage(int index, MType message) {
        SingleFieldBuilder<MType, BType, IType> entry;
        if (message == null) {
            throw new NullPointerException();
        }
        ensureMutableMessageList();
        this.messages.set(index, message);
        if (this.builders != null && (entry = this.builders.set(index, null)) != null) {
            entry.dispose();
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder<MType, BType, IType> addMessage(MType message) {
        if (message == null) {
            throw new NullPointerException();
        }
        ensureMutableMessageList();
        this.messages.add(message);
        if (this.builders != null) {
            this.builders.add(null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder<MType, BType, IType> addMessage(int index, MType message) {
        if (message == null) {
            throw new NullPointerException();
        }
        ensureMutableMessageList();
        this.messages.add(index, message);
        if (this.builders != null) {
            this.builders.add(index, null);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public RepeatedFieldBuilder<MType, BType, IType> addAllMessages(Iterable<? extends MType> values) {
        for (MType value : values) {
            if (value == null) {
                throw new NullPointerException();
            }
        }
        if (values instanceof Collection) {
            Collection<MType> collection = (Collection) values;
            if (collection.size() != 0) {
                ensureMutableMessageList();
                for (MType value2 : values) {
                    addMessage(value2);
                }
            }
            return this;
        }
        ensureMutableMessageList();
        for (MType value3 : values) {
            addMessage(value3);
        }
        onChanged();
        incrementModCounts();
        return this;
    }

    public BType addBuilder(MType mtype) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = new SingleFieldBuilder<>(mtype, this, this.isClean);
        this.messages.add(null);
        this.builders.add(singleFieldBuilder);
        onChanged();
        incrementModCounts();
        return (BType) singleFieldBuilder.getBuilder();
    }

    public BType addBuilder(int i, MType mtype) {
        ensureMutableMessageList();
        ensureBuilders();
        SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = new SingleFieldBuilder<>(mtype, this, this.isClean);
        this.messages.add(i, null);
        this.builders.add(i, singleFieldBuilder);
        onChanged();
        incrementModCounts();
        return (BType) singleFieldBuilder.getBuilder();
    }

    public void remove(int index) {
        SingleFieldBuilder<MType, BType, IType> entry;
        ensureMutableMessageList();
        this.messages.remove(index);
        if (this.builders != null && (entry = this.builders.remove(index)) != null) {
            entry.dispose();
        }
        onChanged();
        incrementModCounts();
    }

    public void clear() {
        this.messages = Collections.emptyList();
        this.isMessagesListMutable = false;
        if (this.builders != null) {
            for (SingleFieldBuilder<MType, BType, IType> entry : this.builders) {
                if (entry != null) {
                    entry.dispose();
                }
            }
            this.builders = null;
        }
        onChanged();
        incrementModCounts();
    }

    public List<MType> build() {
        this.isClean = true;
        if (!this.isMessagesListMutable && this.builders == null) {
            return this.messages;
        }
        boolean z = true;
        if (!this.isMessagesListMutable) {
            int i = 0;
            while (true) {
                if (i >= this.messages.size()) {
                    break;
                }
                MType mtype = this.messages.get(i);
                SingleFieldBuilder<MType, BType, IType> singleFieldBuilder = this.builders.get(i);
                if (singleFieldBuilder == null || singleFieldBuilder.build() == mtype) {
                    i++;
                } else {
                    z = false;
                    break;
                }
            }
            if (z) {
                return this.messages;
            }
        }
        ensureMutableMessageList();
        for (int i2 = 0; i2 < this.messages.size(); i2++) {
            this.messages.set(i2, getMessage(i2, true));
        }
        this.messages = Collections.unmodifiableList(this.messages);
        this.isMessagesListMutable = false;
        return this.messages;
    }

    public List<MType> getMessageList() {
        if (this.externalMessageList == null) {
            this.externalMessageList = new MessageExternalList<>(this);
        }
        return this.externalMessageList;
    }

    public List<BType> getBuilderList() {
        if (this.externalBuilderList == null) {
            this.externalBuilderList = new BuilderExternalList<>(this);
        }
        return this.externalBuilderList;
    }

    public List<IType> getMessageOrBuilderList() {
        if (this.externalMessageOrBuilderList == null) {
            this.externalMessageOrBuilderList = new MessageOrBuilderExternalList<>(this);
        }
        return this.externalMessageOrBuilderList;
    }

    private void onChanged() {
        if (this.isClean && this.parent != null) {
            this.parent.markDirty();
            this.isClean = false;
        }
    }

    @Override // com.google.protobuf.GeneratedMessage.BuilderParent
    public void markDirty() {
        onChanged();
    }

    private void incrementModCounts() {
        if (this.externalMessageList != null) {
            this.externalMessageList.incrementModCount();
        }
        if (this.externalBuilderList != null) {
            this.externalBuilderList.incrementModCount();
        }
        if (this.externalMessageOrBuilderList != null) {
            this.externalMessageOrBuilderList.incrementModCount();
        }
    }

    private static class MessageExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<MType> implements List<MType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        MessageExternalList(RepeatedFieldBuilder<MType, BType, IType> builder) {
            this.builder = builder;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public MType get(int i) {
            return (MType) this.builder.getMessage(i);
        }

        void incrementModCount() {
            this.modCount++;
        }
    }

    private static class BuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<BType> implements List<BType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        BuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> builder) {
            this.builder = builder;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public BType get(int i) {
            return (BType) this.builder.getBuilder(i);
        }

        void incrementModCount() {
            this.modCount++;
        }
    }

    private static class MessageOrBuilderExternalList<MType extends GeneratedMessage, BType extends GeneratedMessage.Builder, IType extends MessageOrBuilder> extends AbstractList<IType> implements List<IType> {
        RepeatedFieldBuilder<MType, BType, IType> builder;

        MessageOrBuilderExternalList(RepeatedFieldBuilder<MType, BType, IType> builder) {
            this.builder = builder;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.builder.getCount();
        }

        @Override // java.util.AbstractList, java.util.List
        public IType get(int i) {
            return (IType) this.builder.getMessageOrBuilder(i);
        }

        void incrementModCount() {
            this.modCount++;
        }
    }
}
