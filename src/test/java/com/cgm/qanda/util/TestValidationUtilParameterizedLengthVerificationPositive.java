package com.cgm.qanda.util;

import com.cgm.qanda.QnAApplication;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.UseDataProvider;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = QnAApplication.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class TestValidationUtilParameterizedLengthVerificationPositive {
    private String parameter;

    public TestValidationUtilParameterizedLengthVerificationPositive(String parameter) {
        this.parameter = parameter;
    }

    @Test
    public void testValidateLengthPositiveTest() {
        boolean validate = ValidationUtil.validateLength(parameter);
        assertEquals(String.format("Length should be 255 characters or less. Current length is %s", parameter.length()),
                true, validate);
    }

    @Parameterized.Parameters
    public static String[] getPositiveData() {
        return new String[]{RandomStringUtils.randomAlphabetic(10), RandomStringUtils.randomAlphabetic(254),
                RandomStringUtils.randomAlphabetic(255)};
    }
}
