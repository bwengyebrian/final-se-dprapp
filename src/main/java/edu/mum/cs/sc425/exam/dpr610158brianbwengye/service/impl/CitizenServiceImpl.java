package edu.mum.cs.sc425.exam.dpr610158brianbwengye.service.impl;

import edu.mum.cs.sc425.exam.dpr610158brianbwengye.model.Citizen;
import edu.mum.cs.sc425.exam.dpr610158brianbwengye.repository.ICitizenRepository;
import edu.mum.cs.sc425.exam.dpr610158brianbwengye.service.ICitizenSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImpl implements ICitizenSerice {
    @Autowired
    private ICitizenRepository citizenRepository;
    @Override
    public Citizen saveCitizen(Citizen c) {
        return citizenRepository.save(c);
    }

    @Override
    public Iterable<Citizen> getAllCitizens() {
        return citizenRepository.findAll(Sort.by("lastName"));
    }

    @Override
    public double computeTotalNationalYearlyIncome(List<Citizen> citizens) {
        double sum = 0;
        for (Citizen citizen : citizens){
               sum += citizen.getYearlyIncome();
        }
        return sum;
    }
}
