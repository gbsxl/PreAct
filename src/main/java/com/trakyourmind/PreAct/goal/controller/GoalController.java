package com.trakyourmind.PreAct.goal.controller;

import com.trakyourmind.PreAct.goal.controller.request.GoalRequest;
import com.trakyourmind.PreAct.goal.controller.response.GoalResponse;
import com.trakyourmind.PreAct.goal.mapper.GoalMapper;
import com.trakyourmind.PreAct.goal.model.Goal;
import com.trakyourmind.PreAct.goal.service.GoalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("preact/goal")
public class GoalController {
    GoalService service;

    public GoalController(GoalService service) {
        this.service = service;
    }

    @GetMapping
    ResponseEntity<List<GoalResponse>> listAllGoals(){
        return ResponseEntity.ok(service.listAllGoals().stream()
                .map(GoalMapper::toResponse)
                .toList());
    }

    @PostMapping("/create")
    ResponseEntity<GoalResponse> createGoal(@RequestBody GoalRequest request){
        Goal newGoal = GoalMapper.toGoal(request);
        Goal savedGoal = service.createGoal(newGoal);
        return ResponseEntity.status(HttpStatus.CREATED).body(GoalMapper.toResponse(savedGoal));
    }

    @GetMapping("/{id}")
    ResponseEntity<GoalResponse> findGoalById(@PathVariable Long id){
        return service.findGoalById(id)
                .map(goal -> ResponseEntity.ok(GoalMapper.toResponse(goal)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGoalById(@PathVariable Long id){
        service.deleteGoalById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
