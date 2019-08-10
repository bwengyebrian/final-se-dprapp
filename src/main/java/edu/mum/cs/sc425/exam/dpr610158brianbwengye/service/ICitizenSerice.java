package edu.mum.cs.sc425.exam.dpr610158brianbwengye.service;

import edu.mum.cs.sc425.exam.dpr610158brianbwengye.model.Citizen;

import java.util.List;

public interface ICitizenSerice {
    public  abstract Citizen saveCitizen(Citizen c);
    public  abstract Iterable<Citizen> getAllCitizens();
    public abstract double computeTotalNationalYearlyIncome(List<Citizen> citizens);
}
