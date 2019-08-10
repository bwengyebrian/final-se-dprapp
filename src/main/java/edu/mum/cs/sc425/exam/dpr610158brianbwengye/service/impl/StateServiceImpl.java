package edu.mum.cs.sc425.exam.dpr610158brianbwengye.service.impl;

import edu.mum.cs.sc425.exam.dpr610158brianbwengye.model.State;
import edu.mum.cs.sc425.exam.dpr610158brianbwengye.repository.IStateRepository;
import edu.mum.cs.sc425.exam.dpr610158brianbwengye.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StateServiceImpl implements IStateService {
    @Autowired
    private IStateRepository stateRepository;
    @Override
    public State saveState(State state) {
        return stateRepository.save(state);
    }

    @Override
    public Iterable<State> getAllStates() {
        return stateRepository.findAll();
    }
}
