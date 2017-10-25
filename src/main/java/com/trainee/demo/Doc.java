package com.trainee.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Doc {
    REFERENCE("Reference","/Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationReference"),
    COUNTRY("Country","/Placing/ContractSection/RiskLocation/Location/Description"),
    INSURED("(Re) Insured","/Placing/InsuredDescription", "/Placing/OriginalPolicyholder/Party/Name"),
    DESCRIPTION("Description","/Placing/ContractSection/ContractSectionClass/ClassOfBusinessDescription"),
    BROKEN_ID("Broker Id","/Placing/Broker/Party/Id"),
    BROKEN_NAME("Broker Name","/Placing/Broker/Party/Name"),
    PREMIUM_CURRENCY("Premium Currency (1st textbox)","/Placing/ContractSection/Premium/Premium Amount/Amt Ccy"),//
    PREMIUM_AMOUNT("Premium Amount (2nd textbox)","/Placing/ContractSection/Premium/PremiumAmount/Amt"),
    LIMIT_CURRENCY("Limit Currency (1st textbox)","/Placing/ContractSection/ContractCoverage/CoverageAmount/AmtCcy"),//
    LIMIT_AMOUNT("Limit Amount (2nd textbox)","/Placing/ContractSection/ContractCoverage/CoverageAmount/Amt"),
    BKRAGE("Bkrage %","/Placing/ContractSection/Brokerage/BrokeragePercentage/Rate"),
    BASIS("Basis","/Placing/ContractSection/ContractCoverage/CoverageBasis "),
    CONTRACT_START("Contract Start","/Placing/ContractSection/ContractPeriod/StartDateTime"),
    END("End","/Placing/ContractSection/ContractPeriod/EndDateTime"),
    WRITTEN("Written","/Placing/ContractSection/ContractMarket/WrittenDateTime"),
    SETTLE("Settle","/Placing/ContractSection/Premium/PaymentDate"),
    CANCEL("Cancel","/Placing/ContractSection/ContractPeriod/EndDateTime"),
    UMR("UMR","/Placing/Contract/BrokerReference"),
    ORD("Ord %","/Placing/ContractSection/BrokerSharePercentage/Rate"),
    LINE("Line %","/Placing/ContractSection/ContractMarket/InsurerSharePercentage/Rate"),
    DEDUCTION("Deduction %","/Placing/ContractSection/OtherDeductions/OtherDeductionsPercentage/Rate"),
    INST_COUNT("Inst. Count","Inst. Count"),//
    LINE_BASIS("Line % Basis","/Placing/ContractSection/LinePercentageBasis"),
    RISK_CODE("Risk Code","/Placing/ContractSection/ContractMarket/PremiumRegulatoryAllocationScheme/Allocation/AllocationCode"),
    NAME("Name","/Placing/CedentDescription ", "/Placing/InsuredDescription");//

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
//сделай большими названия в enum +
//добавить в doc первую строку для имя +
//добавить что бы проходило всю мапу   -
//добавить выборку, если несколько полей -
//отдавать map(str,str) -
//переделать алгоритм, сделать его более уневерсальным -
