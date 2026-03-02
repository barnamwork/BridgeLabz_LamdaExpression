import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LambdaExpressionTest {

    // ---------- UC1 First Name ----------
    @Test
    void givenFirstName_WhenProper_ShouldReturnTrue_Happy() {
        assertTrue(LambdaExpression.FIRST_NAME.validate("Devraj"));
    }

    @Test
    void givenFirstName_WhenImproper_ShouldReturnFalse_Sad() {
        assertFalse(LambdaExpression.FIRST_NAME.validate("devraj"));
        assertFalse(LambdaExpression.FIRST_NAME.validate("De"));
        assertFalse(LambdaExpression.FIRST_NAME.validate("De1"));
        assertFalse(LambdaExpression.FIRST_NAME.validate(null));
    }

    // ---------- UC2 Last Name ----------
    @Test
    void givenLastName_WhenProper_ShouldReturnTrue_Happy() {
        assertTrue(LambdaExpression.LAST_NAME.validate("Goswami"));
    }

    @Test
    void givenLastName_WhenImproper_ShouldReturnFalse_Sad() {
        assertFalse(LambdaExpression.LAST_NAME.validate("goswami"));
        assertFalse(LambdaExpression.LAST_NAME.validate("Go"));
        assertFalse(LambdaExpression.LAST_NAME.validate("Go@"));
        assertFalse(LambdaExpression.LAST_NAME.validate(null));
    }

    // ---------- UC9 Email ----------
    @Test
    void givenEmail_WhenProper_ShouldReturnTrue_Happy() {
        assertTrue(LambdaExpression.EMAIL.validate("abc@yahoo.com"));
        assertTrue(LambdaExpression.EMAIL.validate("abc-100@yahoo.com"));
        assertTrue(LambdaExpression.EMAIL.validate("abc.100@yahoo.com"));
        assertTrue(LambdaExpression.EMAIL.validate("abc111@abc.com"));
        assertTrue(LambdaExpression.EMAIL.validate("abc-100@abc.net"));
        assertTrue(LambdaExpression.EMAIL.validate("abc.100@abc.com.au"));
        assertTrue(LambdaExpression.EMAIL.validate("abc@1.com"));
        assertTrue(LambdaExpression.EMAIL.validate("abc@gmail.com.com"));
        assertTrue(LambdaExpression.EMAIL.validate("abc+100@gmail.com"));
    }

    @Test
    void givenEmail_WhenImproper_ShouldReturnFalse_Sad() {
        assertFalse(LambdaExpression.EMAIL.validate("abc"));
        assertFalse(LambdaExpression.EMAIL.validate("abc@.com.my"));
        assertFalse(LambdaExpression.EMAIL.validate("abc123@gmail.a"));
        assertFalse(LambdaExpression.EMAIL.validate("abc123@.com"));
        assertFalse(LambdaExpression.EMAIL.validate("abc123@.com.com"));
        assertFalse(LambdaExpression.EMAIL.validate(".abc@abc.com"));
        assertFalse(LambdaExpression.EMAIL.validate("abc()*@gmail.com"));
        assertFalse(LambdaExpression.EMAIL.validate("abc@%*.com"));
        assertFalse(LambdaExpression.EMAIL.validate("abc..2002@gmail.com"));
        assertFalse(LambdaExpression.EMAIL.validate("abc.@gmail.com"));
        assertFalse(LambdaExpression.EMAIL.validate("abc@abc@gmail.com"));
        assertFalse(LambdaExpression.EMAIL.validate("abc@gmail.com.1a"));
        assertFalse(LambdaExpression.EMAIL.validate("abc@gmail.com.aa.au"));
        assertFalse(LambdaExpression.EMAIL.validate(null));
    }

    // ---------- UC4 Mobile ----------
    @Test
    void givenMobile_WhenProper_ShouldReturnTrue_Happy() {
        assertTrue(LambdaExpression.MOBILE.validate("91 9919819801"));
    }

    @Test
    void givenMobile_WhenImproper_ShouldReturnFalse_Sad() {
        assertFalse(LambdaExpression.MOBILE.validate("919919819801"));
        assertFalse(LambdaExpression.MOBILE.validate("91 1234567890"));
        assertFalse(LambdaExpression.MOBILE.validate("91 99198"));
        assertFalse(LambdaExpression.MOBILE.validate(null));
    }

    // ---------- Password UC5–UC8 ----------
    @Test
    void givenPassword_WhenProper_ShouldReturnTrue_Happy() {
        assertTrue(LambdaExpression.PASSWORD_ALL.validate("Abcdefg1@"));
    }

    @Test
    void givenPassword_WhenImproper_ShouldReturnFalse_Sad() {
        assertFalse(LambdaExpression.PASSWORD_ALL.validate("Abc1@de"));     // <8
        assertFalse(LambdaExpression.PASSWORD_ALL.validate("abcdefg1@"));   // no uppercase
        assertFalse(LambdaExpression.PASSWORD_ALL.validate("Abcdefgh@"));   // no digit
        assertFalse(LambdaExpression.PASSWORD_ALL.validate("Abcdefg1"));    // no special
        assertFalse(LambdaExpression.PASSWORD_ALL.validate("Abcdefg1@@"));  // 2 specials
        assertFalse(LambdaExpression.PASSWORD_ALL.validate(null));
    }
}