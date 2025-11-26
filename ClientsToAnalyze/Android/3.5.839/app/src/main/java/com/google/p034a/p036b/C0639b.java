package com.google.p034a.p036b;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

/* compiled from: $Gson$Types.java */
/* renamed from: com.google.a.b.b */
/* loaded from: classes.dex */
public final class C0639b {

    /* renamed from: a */
    static final Type[] f1506a = new Type[0];

    /* renamed from: a */
    public static ParameterizedType m2050a(Type type, Type type2, Type... typeArr) {
        return new C0641d(type, type2, typeArr);
    }

    /* renamed from: a */
    public static GenericArrayType m2049a(Type type) {
        return new C0640c(type);
    }

    /* renamed from: b */
    public static WildcardType m2059b(Type type) {
        return new C0642e(new Type[]{type}, f1506a);
    }

    /* renamed from: c */
    public static WildcardType m2061c(Type type) {
        return new C0642e(new Type[]{Object.class}, new Type[]{type});
    }

    /* renamed from: d */
    public static Type m2062d(Type type) {
        if (type instanceof Class) {
            Class cls = (Class) type;
            return cls.isArray() ? new C0640c(m2062d(cls.getComponentType())) : cls;
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            return new C0641d(parameterizedType.getOwnerType(), parameterizedType.getRawType(), parameterizedType.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            return new C0640c(((GenericArrayType) type).getGenericComponentType());
        }
        if (type instanceof WildcardType) {
            WildcardType wildcardType = (WildcardType) type;
            return new C0642e(wildcardType.getUpperBounds(), wildcardType.getLowerBounds());
        }
        return type;
    }

    /* renamed from: e */
    public static Class<?> m2063e(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            C0565a.m1952a(rawType instanceof Class);
            return (Class) rawType;
        }
        if (type instanceof GenericArrayType) {
            return Array.newInstance(m2063e(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
        }
        if (type instanceof TypeVariable) {
            return Object.class;
        }
        if (type instanceof WildcardType) {
            return m2063e(((WildcardType) type).getUpperBounds()[0]);
        }
        throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + (type == null ? "null" : type.getClass().getName()));
    }

    /* renamed from: a */
    static boolean m2055a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* renamed from: a */
    public static boolean m2056a(Type type, Type type2) {
        if (type == type2) {
            return true;
        }
        if (type instanceof Class) {
            return type.equals(type2);
        }
        if (type instanceof ParameterizedType) {
            if (!(type2 instanceof ParameterizedType)) {
                return false;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            ParameterizedType parameterizedType2 = (ParameterizedType) type2;
            return m2055a((Object) parameterizedType.getOwnerType(), (Object) parameterizedType2.getOwnerType()) && parameterizedType.getRawType().equals(parameterizedType2.getRawType()) && Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments());
        }
        if (type instanceof GenericArrayType) {
            if (type2 instanceof GenericArrayType) {
                return m2056a(((GenericArrayType) type).getGenericComponentType(), ((GenericArrayType) type2).getGenericComponentType());
            }
            return false;
        }
        if (type instanceof WildcardType) {
            if (!(type2 instanceof WildcardType)) {
                return false;
            }
            WildcardType wildcardType = (WildcardType) type;
            WildcardType wildcardType2 = (WildcardType) type2;
            return Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) && Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds());
        }
        if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) type;
        TypeVariable typeVariable2 = (TypeVariable) type2;
        return typeVariable.getGenericDeclaration() == typeVariable2.getGenericDeclaration() && typeVariable.getName().equals(typeVariable2.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static int m2057b(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: f */
    public static String m2064f(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* renamed from: a */
    static Type m2052a(Type type, Class<?> cls, Class<?> cls2) {
        if (cls2 != cls) {
            if (cls2.isInterface()) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                for (int i = 0; i < length; i++) {
                    if (interfaces[i] == cls2) {
                        return cls.getGenericInterfaces()[i];
                    }
                    if (cls2.isAssignableFrom(interfaces[i])) {
                        return m2052a(cls.getGenericInterfaces()[i], interfaces[i], cls2);
                    }
                }
            }
            if (!cls.isInterface()) {
                while (cls != Object.class) {
                    Class<? super Object> superclass = cls.getSuperclass();
                    if (superclass == cls2) {
                        return cls.getGenericSuperclass();
                    }
                    if (cls2.isAssignableFrom(superclass)) {
                        return m2052a(cls.getGenericSuperclass(), (Class<?>) superclass, cls2);
                    }
                    cls = superclass;
                }
            }
            return cls2;
        }
        return type;
    }

    /* renamed from: b */
    static Type m2058b(Type type, Class<?> cls, Class<?> cls2) {
        C0565a.m1952a(cls2.isAssignableFrom(cls));
        return m2053a(type, cls, m2052a(type, cls, cls2));
    }

    /* renamed from: g */
    public static Type m2065g(Type type) {
        return type instanceof GenericArrayType ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
    }

    /* renamed from: a */
    public static Type m2051a(Type type, Class<?> cls) {
        Type typeM2058b = m2058b(type, cls, Collection.class);
        if (typeM2058b instanceof WildcardType) {
            typeM2058b = ((WildcardType) typeM2058b).getUpperBounds()[0];
        }
        return typeM2058b instanceof ParameterizedType ? ((ParameterizedType) typeM2058b).getActualTypeArguments()[0] : Object.class;
    }

    /* renamed from: b */
    public static Type[] m2060b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type typeM2058b = m2058b(type, cls, Map.class);
        if (typeM2058b instanceof ParameterizedType) {
            return ((ParameterizedType) typeM2058b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    /* renamed from: a */
    public static Type m2053a(Type type, Class<?> cls, Type type2) {
        Type typeM2053a;
        TypeVariable typeVariable;
        do {
            Type type3 = type2;
            if (!(type3 instanceof TypeVariable)) {
                if ((type3 instanceof Class) && ((Class) type3).isArray()) {
                    Class cls2 = (Class) type3;
                    Class<?> componentType = cls2.getComponentType();
                    Type typeM2053a2 = m2053a(type, cls, (Type) componentType);
                    return componentType != typeM2053a2 ? m2049a(typeM2053a2) : cls2;
                }
                if (type3 instanceof GenericArrayType) {
                    GenericArrayType genericArrayType = (GenericArrayType) type3;
                    Type genericComponentType = genericArrayType.getGenericComponentType();
                    Type typeM2053a3 = m2053a(type, cls, genericComponentType);
                    return genericComponentType != typeM2053a3 ? m2049a(typeM2053a3) : genericArrayType;
                }
                if (type3 instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type3;
                    Type ownerType = parameterizedType.getOwnerType();
                    Type typeM2053a4 = m2053a(type, cls, ownerType);
                    boolean z = typeM2053a4 != ownerType;
                    Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                    int length = actualTypeArguments.length;
                    boolean z2 = z;
                    Type[] typeArr = actualTypeArguments;
                    for (int i = 0; i < length; i++) {
                        Type typeM2053a5 = m2053a(type, cls, typeArr[i]);
                        if (typeM2053a5 != typeArr[i]) {
                            if (!z2) {
                                typeArr = (Type[]) typeArr.clone();
                                z2 = true;
                            }
                            typeArr[i] = typeM2053a5;
                        }
                    }
                    return z2 ? m2050a(typeM2053a4, parameterizedType.getRawType(), typeArr) : parameterizedType;
                }
                if (type3 instanceof WildcardType) {
                    WildcardType wildcardType = (WildcardType) type3;
                    Type[] lowerBounds = wildcardType.getLowerBounds();
                    Type[] upperBounds = wildcardType.getUpperBounds();
                    if (lowerBounds.length == 1) {
                        Type typeM2053a6 = m2053a(type, cls, lowerBounds[0]);
                        if (typeM2053a6 != lowerBounds[0]) {
                            return m2061c(typeM2053a6);
                        }
                        return wildcardType;
                    }
                    if (upperBounds.length == 1 && (typeM2053a = m2053a(type, cls, upperBounds[0])) != upperBounds[0]) {
                        return m2059b(typeM2053a);
                    }
                    return wildcardType;
                }
                return type3;
            }
            typeVariable = (TypeVariable) type3;
            type2 = m2054a(type, cls, (TypeVariable<?>) typeVariable);
        } while (type2 != typeVariable);
        return type2;
    }

    /* renamed from: a */
    static Type m2054a(Type type, Class<?> cls, TypeVariable<?> typeVariable) {
        Class<?> clsM2048a = m2048a(typeVariable);
        if (clsM2048a != null) {
            Type typeM2052a = m2052a(type, cls, clsM2048a);
            if (typeM2052a instanceof ParameterizedType) {
                return ((ParameterizedType) typeM2052a).getActualTypeArguments()[m2047a((Object[]) clsM2048a.getTypeParameters(), (Object) typeVariable)];
            }
            return typeVariable;
        }
        return typeVariable;
    }

    /* renamed from: a */
    private static int m2047a(Object[] objArr, Object obj) {
        for (int i = 0; i < objArr.length; i++) {
            if (obj.equals(objArr[i])) {
                return i;
            }
        }
        throw new NoSuchElementException();
    }

    /* renamed from: a */
    private static Class<?> m2048a(TypeVariable<?> typeVariable) {
        GenericDeclaration genericDeclaration = typeVariable.getGenericDeclaration();
        if (genericDeclaration instanceof Class) {
            return (Class) genericDeclaration;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static void m2067i(Type type) {
        C0565a.m1952a(((type instanceof Class) && ((Class) type).isPrimitive()) ? false : true);
    }
}
