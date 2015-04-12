package com.company.common.test;

import org.mockito.Mockito;
import org.mockito.internal.util.MockUtil;
import org.springframework.context.ApplicationContext;

/**
 * Support for using Mockito mocks in Spring application context.
 *
 * @author Daniel_Imre
 */
public final class MockitoSpringSupport {

    private MockitoSpringSupport() {
    }

    /**
     * Resets all Mockito mock bean in an application context.
     *
     * @param applicationContext the application context
     */
    public static void resetMockBeans(ApplicationContext applicationContext) {
        MockUtil mockUtil = new MockUtil();
        for (Object bean : applicationContext.getBeansOfType(Object.class).values()) {
            if (mockUtil.isMock(bean)) {
                Mockito.reset(bean);
            }
        }
    }
}
