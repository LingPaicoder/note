package com.lpcoder.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeFieldDI_B {
    @Autowired
    private PrototypeFieldDI_C prototypeFieldDI_c;
}
