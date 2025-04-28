package com.trakyourmind.PreAct.goal.repository;

import com.trakyourmind.PreAct.goal.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {

}
