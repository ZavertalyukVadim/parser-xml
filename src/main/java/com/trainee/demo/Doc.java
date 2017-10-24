package com.trainee.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//2,3
public enum Doc {
    Reference("/Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference"),
    Country("/Placing/ContractSection/RiskLocation/Location/Description"),
    Insured("/Placing/InsuredDescription", "/Placing/OriginalPolicyholder/Party/Name"),
    Description("/Placing/ContractSection/ContractSectionClass/ClassOfBusinessDescription"),
    BrokerId("/Placing/Broker/Party/Id"),
    BrokerName("/Placing/Broker/Party/Name"),
    PremiumCurrency("/Placing/ContractSection/Premium/PremiumAmount/AmtCcy"),
    PremiumAmount("/Placing/ContractSection/Premium/PremiumAmount/Amt"),
    LimitCurrency("/Placing/ContractSection/ContractCoverage/CoverageAmount/AmtCcy"),
    LimitAmount("/Placing/ContractSection/ContractCoverage/CoverageAmount/Amt"),
    Bkrage("/Placing/ContractSection/Brokerage/BrokeragePercentage/Rate"),
    Basis("/Placing/ContractSection/ContractCoverage/CoverageBasis "),
    ContractStart("/Placing/ContractSection/ContractPeriod/StartDateTime"),
    End("/Placing/ContractSection/ContractPeriod/EndDateTime"),
    Written("/Placing/ContractSection/ContractMarket/WrittenDateTime"),
    Settle("/Placing/ContractSection/Premium/PaymentDate"),
    Cancel("/Placing/ContractSection/ContractPeriod/EndDateTime"),
    UMR("/Placing/Contract/BrokerReference"),
    Ord("/Placing/ContractSection/BrokerSharePercentage/Rate"),
    Line("/Placing/ContractSection/ContractMarket/InsurerSharePercentage/Rate"),
    Deduction("/Placing/ContractSection/OtherDeductions/OtherDeductionsPercentage/Rate"),
    InstCount("Does not currently exist in the XML – show as blank."),
    LineBasis("/Placing/ContractSection/LinePercentageBasis"),
    RiskCode("/Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationCode"),
    Name("/Placing/CedentDescription ","/Placing/InsuredDescription");

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
