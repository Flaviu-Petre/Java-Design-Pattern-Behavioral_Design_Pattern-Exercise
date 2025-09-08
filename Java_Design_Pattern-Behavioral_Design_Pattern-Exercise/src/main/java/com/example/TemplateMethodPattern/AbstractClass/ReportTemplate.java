package com.example.TemplateMethodPattern.AbstractClass;

public abstract class ReportTemplate {
    // Template method
    public final void generateReport() {
        retrieveData();
        processData();
        formatReport();
    }

    protected abstract void retrieveData();
    protected abstract void processData();
    protected abstract void formatReport();
}
