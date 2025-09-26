package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Testcases.BaseClassTest;

public class ExtentReportManager implements ITestListener {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;

    @Override
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String browser = testContext.getCurrentXmlTest().getParameter("browser");

        repName = "Test-Report-" + browser + "-" + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter(".\\reportss\\" + repName);

        sparkReporter.config().setDocumentTitle("opencart Automation Report");
        sparkReporter.config().setReportName("opencart Functional Testing - " + browser);
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "opencart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environemnt", "QA");
        extent.setSystemInfo("Operating System", testContext.getCurrentXmlTest().getParameter("os"));
        extent.setSystemInfo("Browser", browser);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        createTestEntry(result, Status.PASS, result.getMethod().getMethodName() + " got successfully executed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        createTestEntry(result, Status.FAIL, result.getMethod().getMethodName() + " got failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        try {
            String imgPath = new BaseClassTest().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        createTestEntry(result, Status.SKIP, result.getMethod().getMethodName() + " got skipped");
        test.log(Status.INFO, result.getThrowable() != null ? result.getThrowable().getMessage() : "No exception");
    }

    private void createTestEntry(ITestResult result, Status status, String logMessage) {
        String methodName = result.getMethod().getMethodName();
        String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");

        test = extent.createTest(methodName + " - [" + browser + "]");
        test.assignCategory(result.getMethod().getGroups());
        test.assignDevice(browser);
        test.log(Status.INFO, "Executed on browser: " + browser);
        test.log(status, logMessage);
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush();

        String pathOfExtentReport = System.getProperty("user.dir") + "\\reportss\\" + repName;
        File extentReport = new File(pathOfExtentReport);

        try {
            Desktop.getDesktop().browse(extentReport.toURI());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
