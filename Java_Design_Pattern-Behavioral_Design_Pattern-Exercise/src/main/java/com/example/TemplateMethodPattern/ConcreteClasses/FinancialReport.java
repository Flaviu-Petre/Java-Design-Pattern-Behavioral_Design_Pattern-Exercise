package com.example.TemplateMethodPattern.ConcreteClasses;

import com.example.TemplateMethodPattern.AbstractClass.ReportTemplate;

public class FinancialReport extends ReportTemplate {

    @Override
    protected void retrieveData() {
        System.out.println("Retrieving financial data...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing financial data...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Formatting financial report...");
    }
}
