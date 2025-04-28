package com.trakyourmind.PreAct.goal.service;

import com.trakyourmind.PreAct.goal.model.Goal;
import com.trakyourmind.PreAct.goal.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoalService {
    private final GoalRepository repository;

    public GoalService(GoalRepository repository) {
        this.repository = repository;
    }

    public List<Goal> listAllGoals(){
        return repository.findAll();
    }

    public Goal createGoal(Goal goal){
        return repository.save(goal);
    }

    public Optional<Goal> findGoalById(Long id){
        return repository.findById(id);
    }

    public void deleteGoalById(Long id){
        repository.deleteById(id);
    }

}
