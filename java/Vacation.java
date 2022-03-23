import StepObject.CappadociaSteps;
import StepObject.GinoSteps;
import Utils.Retry;
import Utils.Runner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static DataObject.CappadociaData.SearchKokhtaValue;
import static DataObject.CappadociaData.SearchTravelValue;
import static DataObject.GinoData.*;
import static com.codeborne.selenide.Selenide.closeWindow;

@Listeners(Utils.TestLister.class)
public class Vacation extends Runner {
        @Test(retryAnalyzer = Retry.class)
        @Severity(SeverityLevel.NORMAL)
        public void vacationCappadocia(){
            CappadociaSteps steps = new CappadociaSteps();
            steps.GoToCappadociaPage();
            steps
                    .SearchResultFill()
                    .AddButtonFill()
                    .SearchKokhtaFill(SearchKokhtaValue)
                    .SearchResultFill()
                    .Add2Fill()
                    .SearchTravelFill(SearchTravelValue)
                    .SearchTextFill()
                    .Add3Fill()
                    .BasketFill()
                    .BasketRemoveFill()
                    .BaskeRemove2Fill()
                    .BasketItemFill();
                     closeWindow();
        }

     @Test(retryAnalyzer = Retry.class)
     @Severity(SeverityLevel.CRITICAL)
        public void vacationgino(){
          GinoSteps steps = new GinoSteps();
          SoftAssert softAssert = new SoftAssert();
          steps.GoToGinoPage();
          steps
                  .SearchResult2Fill()
                  .CheckoutFill()
                  .TotalsFill()
                  .EmailGinoFill(EmailGinoValue)
                  .PasswordGinoFill(PassworGinodValue)
                  .LoginGinoFill()
                  .Totals2Fill()
                  .Totals3Fill()
                  .CardFill(CardValue)
                  .MonthFill()
                  .NumberFill()
                  .YearFill()
                  .YearNumber()
                  .CvcFill(CvcValue)
                  .PaymentFill();
          softAssert.assertEquals(steps.EmailGinoButton.getValue(),EmailGinoValue);
          softAssert.assertEquals(steps.PasswordGinoButton.getValue(),PassworGinodValue);
          softAssert.assertTrue(steps.UserIsOnGinoPage.isDisplayed());
          softAssert.assertTrue(steps.UserIsOnGinoPage2.isDisplayed());
          softAssert.assertAll();

 }
    }



