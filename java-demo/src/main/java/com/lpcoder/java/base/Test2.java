package com.lpcoder.java.base;

/**
 * @author liurenpeng
 * @date Created in 19-4-12
 */
public class Test2 {

    public static class Father{
        protected Number method(int a, int b){ return 0; }
    }

    public static class Son extends Father{
        // 报错 clash. attempting to assign weaker access privileges ('private'); was 'protected'
        //private Number method(int a, int b){ return 0;}

        // OK
        public Integer method(int a, int b){ return 0;}

        // 报错 clash. attempting to use incompatible return type
        //protected Object method(int a, int b){return 0;}
    }

}
