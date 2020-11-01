package com.xingjiahe.www.infrastructure.util;

import java.util.HashMap;

public final class Maps {
    public static InnerHashMap of() {
        return new InnerHashMap();
    }

    public static class InnerHashMap extends HashMap {
        @Override
        public InnerHashMap put(Object key, Object value) {
            super.put(key, value);
            return this;
        }
    }
}
