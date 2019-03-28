package com.holidu.interview.assignment.tree.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonIgnoreProperties(ignoreUnknown=true)
public class Tree {
    
    @JsonProperty("tree_id")
    private String treeId;

    @JsonProperty("spc_common")
    private String spcCommon;
    
    @JsonProperty("x_sp")
    private BigDecimal xSp;
    
    @JsonProperty("y_sp")
    private BigDecimal ySp;
    
    @JsonProperty("stump_diam")
    private BigDecimal stumDiam;

    public String getTreeId() {
        return treeId;
    }

    public void setTreeId(String treeId) {
        this.treeId = treeId;
    }

    public String getSpcCommon() {
        return spcCommon;
    }

    public void setSpcCommon(String spcCommon) {
        this.spcCommon = spcCommon;
    }

    public BigDecimal getxSp() {
        return xSp;
    }

    public void setxSp(BigDecimal xSp) {
        this.xSp = xSp;
    }

    public BigDecimal getySp() {
        return ySp;
    }

    public void setySp(BigDecimal ySp) {
        this.ySp = ySp;
    }

    public BigDecimal getStumDiam() {
        return stumDiam;
    }

    public void setStumDiam(BigDecimal stumDiam) {
        this.stumDiam = stumDiam;
    }
 
}
