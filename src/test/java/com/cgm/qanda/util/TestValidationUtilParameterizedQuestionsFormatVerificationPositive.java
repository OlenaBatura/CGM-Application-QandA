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
public class TestValidationUtilParameterizedQuestionsFormatVerificationPositive {
    private String parameter;

    public TestValidationUtilParameterizedQuestionsFormatVerificationPositive(String parameter) {
        this.parameter = parameter;
    }

    @Test
    public void testValidateAnswerFormat() {
        boolean validate = ValidationUtil.validateQuestionFormat(parameter);
        assertEquals("Question format shoud be ? “” “” “”", true, validate);
    }

    @Parameterized.Parameters
    public static String[] getPositiveData() {
        String randomValue = RandomStringUtils.randomAlphabetic(10);
        return new String[] {String.format("%s ? %s", randomValue, randomValue),
                String.format("%s ? %s %s", randomValue, randomValue, randomValue)};
    }
}
