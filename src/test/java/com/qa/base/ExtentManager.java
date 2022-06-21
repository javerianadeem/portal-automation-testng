package com.qa.base;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;
    private static String reportFileName = "Systems-Portal-Automaton-Report"+".html";
    private static String fileSeperator = System.getProperty("file.separator");
    private static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    private static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;


    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    //Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);

        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
//        htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
//        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Set environment details

//        extent.setSystemInfo("File separator", System.getProperty("file.separator"));
//        extent.setSystemInfo("java.specification.version", System.getProperty("java.specification.version"));
//        extent.setSystemInfo("java.vm.version", System.getProperty("java.vm.version"));
//        extent.setSystemInfo("java.class.path", System.getProperty("java.class.path"));
//        extent.setSystemInfo("java.vendor", System.getProperty("java.vendor"));
//        extent.setSystemInfo("java.class.version", System.getProperty("java.class.version"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("OS Architecture", System.getProperty("os.arch"));
        extent.setSystemInfo("Java Compiler", System.getProperty("java.compiler"));
//        extent.setSystemInfo("line.separator", System.getProperty("line.separator"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("java.vendor.url", System.getProperty("java.vendor.url"));
        extent.setSystemInfo("OS Name", System.getProperty("os.name"));

        return extent;
    }

    //Create the report path
    private static String getReportPath (String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdir()) {
                System.out.println("Directory: " + path + " is created!" );
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        }
        else {
            System.out.println("Directory already exists: " + path);
        }
        return reportFileLocation;
    }

}
