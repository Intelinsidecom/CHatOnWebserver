package org.jboss.netty.channel.local;

import java.net.SocketAddress;

/* loaded from: classes.dex */
public final class LocalAddress extends SocketAddress implements Comparable {
    public static final String EPHEMERAL = "ephemeral";
    private static final long serialVersionUID = -3601961747680808645L;
    private final boolean ephemeral;

    /* renamed from: id */
    private final String f5791id;

    public LocalAddress(int i) {
        this(String.valueOf(i));
    }

    public LocalAddress(String str) {
        if (str == null) {
            throw new NullPointerException("id");
        }
        String lowerCase = str.trim().toLowerCase();
        if (lowerCase.length() == 0) {
            throw new IllegalArgumentException("empty id");
        }
        this.f5791id = lowerCase;
        this.ephemeral = lowerCase.equals(EPHEMERAL);
    }

    public String getId() {
        return this.f5791id;
    }

    public boolean isEphemeral() {
        return this.ephemeral;
    }

    public int hashCode() {
        return this.ephemeral ? System.identityHashCode(this) : this.f5791id.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LocalAddress)) {
            return false;
        }
        if (this.ephemeral) {
            return this == obj;
        }
        return getId().equals(((LocalAddress) obj).getId());
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalAddress localAddress) {
        if (this.ephemeral) {
            if (!localAddress.ephemeral) {
                return 1;
            }
            if (this == localAddress) {
                return 0;
            }
            int iIdentityHashCode = System.identityHashCode(this);
            int iIdentityHashCode2 = System.identityHashCode(this);
            if (iIdentityHashCode < iIdentityHashCode2) {
                return -1;
            }
            if (iIdentityHashCode > iIdentityHashCode2) {
                return 1;
            }
            throw new Error("Two different ephemeral addresses have same identityHashCode.");
        }
        if (localAddress.ephemeral) {
            return -1;
        }
        return getId().compareTo(localAddress.getId());
    }

    public String toString() {
        return "local:" + getId();
    }
}
