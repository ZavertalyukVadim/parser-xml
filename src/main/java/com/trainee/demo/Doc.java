package com.trainee.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Doc {
    Reference("Reference","/Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference"),
    Country("Country","/Placing/ContractSection/RiskLocation/Location/Description"),
    Insured("(Re) Insured","/Placing/InsuredDescription", "/Placing/OriginalPolicyholder/Party/Name"),
    Description("Description","/Placing/ContractSection/ContractSectionClass/ClassOfBusinessDescription"),
    BrokerId("Broker Id","/Placing/Broker/Party/Id"),
    BrokerName("Broker Name","/Placing/Broker/Party/Name"),
    PremiumCurrency("Premium Currency (1st textbox)","/Placing/ContractSection/Premium/PremiumAmount/AmtCcy"),
    PremiumAmount("Premium Amount (2nd textbox)","/Placing/ContractSection/Premium/PremiumAmount/Amt"),
    LimitCurrency("Limit Currency (1st textbox)","/Placing/ContractSection/ContractCoverage/CoverageAmount/AmtCcy"),
    LimitAmount("Limit Amount (2nd textbox)","/Placing/ContractSection/ContractCoverage/CoverageAmount/Amt"),
    Bkrage("Bkrage %","/Placing/ContractSection/Brokerage/BrokeragePercentage/Rate"),
    Basis("Basis","/Placing/ContractSection/ContractCoverage/CoverageBasis "),
    ContractStart("Contract Start","/Placing/ContractSection/ContractPeriod/StartDateTime"),
    End("End","/Placing/ContractSection/ContractPeriod/EndDateTime"),
    Written("Written","/Placing/ContractSection/ContractMarket/WrittenDateTime"),
    Settle("Settle","/Placing/ContractSection/Premium/PaymentDate"),
    Cancel("Cancel","/Placing/ContractSection/ContractPeriod/EndDateTime"),
    UMR("UMR","/Placing/Contract/BrokerReference"),
    Ord("Ord %","/Placing/ContractSection/BrokerSharePercentage/Rate"),
    Line("Line %","/Placing/ContractSection/ContractMarket/InsurerSharePercentage/Rate"),
    Deduction("Deduction %","/Placing/ContractSection/OtherDeductions/OtherDeductionsPercentage/Rate"),
    InstCount("Inst. Count","Inst. Count"),
    LineBasis("Line % Basis","/Placing/ContractSection/LinePercentageBasis"),
    RiskCode("Risk Code","/Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationCode"),
    Name("Name","/Placing/CedentDescription ", "/Placing/InsuredDescription");

    Doc(String label, String... xPath) {
        this.label = label;
        this.xPath.addAll(Arrays.asList(xPath));
    }

    private String label;

    private List<String> xPath = new ArrayList<>();

    public String getLabel() {
        return label;
    }

    public List<String> getxPath() {
        return xPath;
    }

    public void setxPath(List<String> xPath) {
        this.xPath = xPath;
    }

}
//сделай большими названия в enum
//добавить в doc первую строку для имя
//добавить что бы проходило всю мапу
//отдавать map(str,str)
//переделать алгоритм, сделать его более уневерсальным
