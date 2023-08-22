package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        byte byteEx = 1;
        short shortEx = 4;
        int intEx = 33;
        long longEx = 2147483649L;
        float floatEx = 8.5F;
        double doubleEx = 8.5;
        char sign = '\u2650';
        boolean status = true;
        LOG.debug("File info byte : {}, "
                        + "short : {}, "
                        + "int : {}, "
                        + "long : {}, "
                        + "float : {}, "
                        + "double : {}, "
                        + "char : {}, "
                        + "boolean : {}",
                byteEx, shortEx, intEx, longEx, floatEx, doubleEx, sign, status);
    }
}