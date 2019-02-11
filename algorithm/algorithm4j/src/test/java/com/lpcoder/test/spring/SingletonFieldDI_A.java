package com.lpcoder.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingletonFieldDI_A {
    @Autowired
    private SingletonFieldDI_B singletonFieldDI_b;
}
