package com.trakyourmind.PreAct.goal.mapper;

import com.trakyourmind.PreAct.goal.controller.request.GoalRequest;
import com.trakyourmind.PreAct.goal.controller.response.GoalResponse;
import com.trakyourmind.PreAct.goal.model.Goal;
import lombok.experimental.UtilityClass;

@UtilityClass
public class GoalMapper {

    public static Goal toGoal(GoalRequest request){
        return Goal
                .builder()
                .goal(request.goal())
                .build();
    }
    public static GoalResponse toResponse(Goal goal){
        return GoalResponse
                .builder()
                .id(goal.getId())
                .goal(goal.getGoal())
                .build();
    }
}
