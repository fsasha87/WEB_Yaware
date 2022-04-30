package tests;

import org.testng.annotations.Listeners;
import utils.TestNGListener;
import utils.WorkerGenerator;
import org.testng.annotations.Test;
import pages.InnerPage;
import pages.LoginPage;
import pages.WorkerPage;


@Listeners(TestNGListener.class)
public class ResultsTest extends BaseTest{

    @Test
    public void importWorkersTest(){
        new WorkerGenerator()
                .generateWorkersToCSV();
        new LoginPage()
                .typeLogin("o.babeniuk+555@yaware.com")
                .typePassword("123456")
                .clickEnterButton();
        new InnerPage()
                .verifyTitle()
                .clickWorkerButton();
        new WorkerPage()
                .clickInactiveWorkersButton()
                .clickImportWorkersButton()
                .sendFile()
                .importButtonClick()
                .verifyModalTitle()
                .repeatImportButtonClick()
                .verifyWorkersQuantityBeforeAfterImport();
    }
}
