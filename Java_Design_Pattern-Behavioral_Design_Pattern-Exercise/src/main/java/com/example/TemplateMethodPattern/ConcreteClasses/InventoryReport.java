package com.example.TemplateMethodPattern.ConcreteClasses;

import com.example.TemplateMethodPattern.AbstractClass.ReportTemplate;

public class InventoryReport extends ReportTemplate {
    @Override
    protected void retrieveData() {
        System.out.println("Retrieving inventory data...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing inventory data...");
    }

    @Override
    protected void formatReport() {
        System.out.println("Formatting inventory report...");
    }
}
