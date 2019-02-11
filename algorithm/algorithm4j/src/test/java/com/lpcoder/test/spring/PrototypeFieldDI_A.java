package com.lpcoder.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeFieldDI_A {
    @Autowired
    private PrototypeFieldDI_B prototypeFieldDI_b;
}
