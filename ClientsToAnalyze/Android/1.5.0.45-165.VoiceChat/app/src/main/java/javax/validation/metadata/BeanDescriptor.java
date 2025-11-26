package javax.validation.metadata;

import java.util.Set;

/* loaded from: classes.dex */
public interface BeanDescriptor extends ElementDescriptor {
    Set<PropertyDescriptor> getConstrainedProperties();

    PropertyDescriptor getConstraintsForProperty(String str);

    boolean isBeanConstrained();
}
