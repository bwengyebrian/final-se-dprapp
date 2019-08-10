package edu.mum.cs.sc425.exam.dpr610158brianbwengye.controller;

import edu.mum.cs.sc425.exam.dpr610158brianbwengye.model.Citizen;
import edu.mum.cs.sc425.exam.dpr610158brianbwengye.service.ICitizenSerice;
import edu.mum.cs.sc425.exam.dpr610158brianbwengye.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CitizenController {
    @Autowired
    private ICitizenSerice citizenSerice;
    @Autowired
    private IStateService stateService;

    @GetMapping(value = {"/dprapp/citizens/list","dprapp/citizens/list"})
    public String listCitizens(Model model){
        List<Citizen> citizens = (List<Citizen>)citizenSerice.getAllCitizens();
        double tnyi = citizenSerice.computeTotalNationalYearlyIncome(citizens);
        model.addAttribute("citizens",citizens);
        model.addAttribute("tnyi",tnyi);
        return  "secure/citizen/list";
    }

    @GetMapping(value = {"/dprapp/citizens/new","dprapp/citizens/new"})
    public String addNewAccount(Model model){
        Citizen citizen = new Citizen();
        model.addAttribute("citizen",citizen);
        model.addAttribute("states",stateService.getAllStates());

        return "secure/citizen/new";
    }

    @PostMapping(value = {"/dprapp/citizens/new","dprapp/citizens/new"})
    public String saveNewAccount(@Valid @ModelAttribute("citizen") Citizen citizen, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "secure/citizen/new";
        }
        citizenSerice.saveCitizen(citizen);
        return "redirect:/dprapp/citizens/list";
    }
}
