package edu.mum.cs.sc425.exam.dpr610158brianbwengye.repository;

import edu.mum.cs.sc425.exam.dpr610158brianbwengye.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository extends JpaRepository<State,Integer> {
}
