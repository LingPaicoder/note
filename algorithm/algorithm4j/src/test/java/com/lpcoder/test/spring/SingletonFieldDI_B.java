package com.lpcoder.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingletonFieldDI_B {
    @Autowired
    private SingletonFieldDI_C singletonFieldDI_c;
}
