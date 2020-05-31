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
public class TestValidationUtilParameterizedQuestionsFormatVerificationNegative {
    private String parameter;

    public TestValidationUtilParameterizedQuestionsFormatVerificationNegative(String parameter) {
        this.parameter = parameter;
    }

    @Test
    public void testValidateAnswerFormat() {
        boolean validate = ValidationUtil.validateQuestionFormat(parameter);
        assertEquals( false, validate);
    }

    @Parameterized.Parameters
    public static String[] getPositiveData() {
        String randomValue = RandomStringUtils.randomAlphabetic(10);
        return new String[] {String.format("? %s", randomValue),
                String.format("%s ?", randomValue)};
    }
}
