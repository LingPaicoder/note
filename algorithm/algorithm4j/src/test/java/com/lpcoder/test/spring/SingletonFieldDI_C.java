package com.lpcoder.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingletonFieldDI_C {
    @Autowired
    private SingletonFieldDI_A singletonFieldDI_a;
}
