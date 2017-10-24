package com.trainee.demo;

public enum Doc {
    Reference,
    Country,
    Insured,
    Description,
    BrokerId,
    BrokerName,
    PremiumCurrency,
    PremiumAmount,
    LimitCurrency,
    LimitAmount,
    Bkrage,
    Basis,
    ContractStart,
    End,
    Written,
    Settle,
    Cancel,
    UMR,
    Ord,
    Line,
    Deduction,
    InstCount,
    LineBasis,
    RiskCode,
    Name;

    private String url;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
