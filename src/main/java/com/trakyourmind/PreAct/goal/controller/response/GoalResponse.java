package com.trakyourmind.PreAct.goal.controller.response;

import lombok.Builder;

@Builder
public record GoalResponse(Long id, String goal) {
}
