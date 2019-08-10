package edu.mum.cs.sc425.exam.dpr610158brianbwengye.service;

import edu.mum.cs.sc425.exam.dpr610158brianbwengye.model.State;

public interface IStateService {
    public abstract State saveState(State state);
    public abstract Iterable<State> getAllStates();
}
