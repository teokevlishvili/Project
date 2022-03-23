import StepObject.GiftSteps;
import StepObject.WishlistSteps;
import Utils.Retry;
import Utils.Runner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static DataObject.GiftData.*;
import static DataObject.WishlistData.EmailWValue;
import static DataObject.WishlistData.PasswordWValue;
import static com.codeborne.selenide.Selenide.sleep;

@Listeners(Utils.TestLister.class)
public class Forme extends Runner {
        @Test(retryAnalyzer = Retry.class)
        @Severity(SeverityLevel.NORMAL)
    public void wishlist(){
        WishlistSteps steps = new WishlistSteps();
        SoftAssert softAssert = new SoftAssert();
        steps.GoToWishlistPage();
        steps
                .EmailWFill(EmailWValue)
                .PasswordWFill(PasswordWValue)
                .LoginAuthorizationFill()
                .WishlistFill()
                .XpathWFill()
                .XpathW2Fill()
                .Wishlist2Fill()
                .BasketBackFill()
                .BasketBack2Fill()
                .BasketCounterFill()
                .BasketRemoveFill()
                .BasketRemove2Fill()
                .BasketCounter2Fill();
                 sleep(5000);
    }

     @Test(retryAnalyzer = Retry.class)
    @Severity(SeverityLevel.CRITICAL)
    public void gift(){
        GiftSteps steps = new GiftSteps();
        SoftAssert softAssert = new SoftAssert();
        steps.GoToGiftPage();
        steps
                .RangeFill(RangeValue)
                .LocationFill()
                .OldTbilisiFill()
                .OfferFill()
                .CheckoutFill()
                .BuyFill()
                .GiftEmailFill(GiftEmailValue)
                .GiftPasswordFill(GiftPasswordValue)
                .LoginFill()
                .GiftEmail2Fill(GiftEmail2Value)
                .Gift2PasswordFill(GiftPassword2Value)
                .Login2Fill()
                .GiftEmail3Fill(GiftEmail3Value)
                .GiftPassword3Fill(GiftPassword3Value)
                .Login3Fill()
                .XpathFill()
                .Xpath2Fill()
                .NameFill(NameValue)
                .EmailFill(EmailValue)
                .PhoneFill(PhoneValue);
        softAssert.assertEquals(steps.GiftEmail3Input.getValue(),GiftEmail3Value);
        softAssert.assertEquals(steps.NameInput.getValue(),NameValue);
        softAssert.assertTrue(steps.BuyInput.isDisplayed());
        softAssert.assertAll();
    }
}
