package com.example.TemplateMethodPattern.ConcreteClasses;

import com.example.TemplateMethodPattern.AbstractClass.ReportTemplate;

public class SalesReport extends ReportTemplate {
    @Override
    protected void retrieveData() {
        System.out.println("Retrieving sales data...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing sales data...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Formatting sales report...");
    }
}
