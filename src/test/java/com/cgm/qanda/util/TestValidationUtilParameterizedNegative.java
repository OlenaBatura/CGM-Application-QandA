package com.cgm.qanda.util;

import com.cgm.qanda.QnAApplication;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = QnAApplication.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class TestValidationUtilParameterizedNegative {
    private String parameter;

    public TestValidationUtilParameterizedNegative(String parameter) {
        this.parameter = parameter;
    }

    @Test
    public void testValidateLengthPositiveTest() {
        boolean validate = ValidationUtil.validateLength(parameter);
        assertEquals(String.format("Length should be 255 characters or less. Current length is %s", parameter.length()),
                false, validate);
    }

    @Parameterized.Parameters
    public static String[] getNegativeData() {
        return new String[]{RandomStringUtils.randomAlphabetic(256), RandomStringUtils.randomAlphabetic(1000),
                RandomStringUtils.randomAlphabetic(200000)};
    }
}
