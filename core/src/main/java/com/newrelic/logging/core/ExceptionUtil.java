/*
 * Copyright 2019. New Relic Corporation. All rights reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package com.newrelic.logging.core;

public class ExceptionUtil {
    public static final int MAX_STACK_SIZE = 10;
    public static String getErrorStack(Throwable throwable) {
        if (throwable == null) {
            return null;
        }

        StackTraceElement[] stack = throwable.getStackTrace();
        return getErrorStack(stack);
    }

    public static String getErrorStack(StackTraceElement[] stack) {
        if (stack == null || stack.length == 0) {
            return null;
        }

        StringBuilder stackBuilder = new StringBuilder();
        for(int i = 0; i < Math.min(MAX_STACK_SIZE, stack.length); i++) {
            stackBuilder.append("  at " + stack[i].toString() + "\n");
        }
        return stackBuilder.toString();
    }
}
