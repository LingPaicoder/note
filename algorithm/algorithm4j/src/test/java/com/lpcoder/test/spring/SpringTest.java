package com.lpcoder.test.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author liurenpeng
 * @date Created in 19-2-11
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        /*SingletonFieldDI_A bean = ac.getBean(SingletonFieldDI_A.class);
        System.out.println("success. " + bean.toString());*/
        /*ContractorDI_A bean = ac.getBean(ContractorDI_A.class);
        System.out.println("success. " + bean.toString());*/
        /*PrototypeFieldDI_A bean = ac.getBean(PrototypeFieldDI_A.class);
        System.out.println("success. " + bean.toString());*/
    }
}
