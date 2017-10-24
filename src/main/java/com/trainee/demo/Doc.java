package com.trainee.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Doc {
    Reference(),
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

    Doc(String... xPath) {
        this.xPath.addAll(Arrays.asList(xPath));
    }

    private List<String> xPath = new ArrayList<>();

    public List<String> getxPath() {
        return xPath;
    }

    public void setxPath(List<String> xPath) {
        this.xPath = xPath;
    }

}
