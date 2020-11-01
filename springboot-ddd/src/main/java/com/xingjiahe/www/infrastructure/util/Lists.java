package com.xingjiahe.www.infrastructure.util;

import java.util.ArrayList;
import java.util.Arrays;

public final class Lists {
    public static ArrayList of(Object... objects) {
        return new ArrayList(Arrays.asList(objects));
    }
}
