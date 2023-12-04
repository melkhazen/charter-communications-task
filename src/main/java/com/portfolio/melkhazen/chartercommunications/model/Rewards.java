package com.portfolio.melkhazen.chartercommunications.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rewards {

    private Long customerId;
    private Long lastMonthRewardPoints;
    private Long lastSecondMonthRewardPoints;
    private Long lastThirdMonthRewardPoints;
    private Long totalRewardPoints;

    public Rewards() {

    }
}
