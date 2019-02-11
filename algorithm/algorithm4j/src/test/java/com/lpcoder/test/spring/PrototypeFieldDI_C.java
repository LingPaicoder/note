package com.lpcoder.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class PrototypeFieldDI_C {
    @Autowired
    private PrototypeFieldDI_A prototypeFieldDI_a;
}
