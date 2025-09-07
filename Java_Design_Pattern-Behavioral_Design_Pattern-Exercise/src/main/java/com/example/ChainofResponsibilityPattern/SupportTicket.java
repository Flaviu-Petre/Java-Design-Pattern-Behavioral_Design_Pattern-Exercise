package com.example.ChainofResponsibilityPattern;

public class SupportTicket {
    //region Fields
    private ComplexityLevel complexityLevel;
    private String issueDescription;
    //endregion

    //region Constructors
    public SupportTicket(ComplexityLevel complexityLevel, String issueDescription) {
        this.complexityLevel = complexityLevel;
        this.issueDescription = issueDescription;
    }
    //endregion

    //region Getters

    public ComplexityLevel getComplexityLevel() {
        return complexityLevel;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    //endregion

    //region Setters

    public void setComplexityLevel(ComplexityLevel complexityLevel) {
        this.complexityLevel = complexityLevel;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    //endregion
}
