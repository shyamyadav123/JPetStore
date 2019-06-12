package org.csu.jpetstore;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author: sun
 * @date: 2019/6/12
 */
@Slf4j
public class LogTest extends BaseTest{

    @Test
    public void testLog() {
        log.info("Hello");
        log.error("hi");
    }

}
