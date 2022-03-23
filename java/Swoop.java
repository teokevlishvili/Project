import StepObject.LoginSteps;
import StepObject.RegistrationSteps;
import Utils.Retry;
import Utils.Runner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static DataObject.LoginData.*;
import static DataObject.RegistrationData.*;
import static com.codeborne.selenide.Selenide.sleep;


@Listeners(Utils.TestLister.class)
public class Swoop extends Runner {
    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.NORMAL)
    public void RegistrationSwoop(){
        RegistrationSteps steps = new RegistrationSteps();
        SoftAssert softAssert = new SoftAssert();
        steps.GoToRegistrationPage();
        steps
                .FirstNameFill(FirstNameValue)
                .LastNameFill(LastNameValue)
                .PhoneFill(PhoneValue)
                .DataBirthFill(DateBirthValue)
                .PasswordFill(PasswordValue)
                .ConfirmPasswordFill(ConfirmPasswordValue)
                .IsAgreedTermsFill();
        softAssert.assertEquals(steps.FirstNameInput.getValue(),FirstNameValue);
        softAssert.assertEquals(steps.LastNameInput.getValue(),LastNameValue);
        softAssert.assertEquals(steps.PhoneInput.getValue(),PhoneValue);
        softAssert.assertEquals(steps.PasswordInput.getValue(),PasswordValue);
        softAssert.assertAll();
        sleep(3000);

    }

    @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.MINOR)
    public void authorization (){
       LoginSteps steps = new LoginSteps();
       steps.GoToLoginPage();
       steps
               .EmailFill(EmailValue)
               .PasswordFill(PasswordValue1)
               .LoginFill()
               .PasswordResetFill()
               .EmailFill2(EmailValue2)
               .PasswordFill2()
               .SwoopLoginFill()
               .EmailFill3(EmailValue3)
               .PasswordFill3(PasswordValue2)
               .LoginStepFill3();
       sleep(3000);





    }
}
