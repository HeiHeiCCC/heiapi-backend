package com.heihei.project.service;

import com.heihei.heiapicommon.service.InnerUserInterfaceInfoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;


@SpringBootTest
public class UserInterfaceInfoServiceTest {
    @Resource
        private InnerUserInterfaceInfoService userInterfaceInfoService;

    @Test
    public void invokeCount() {
        boolean b = userInterfaceInfoService.invokeCount(1l, 1l);
        Assertions.assertTrue(b);

    }
}