package com.myteam.riddlesbot.bean;

/**
 * 用户状态类
 */
public class UserCondition {

    int status;//用户所处阶段，0-初始 1-猜词中 2-抽奖中 other-结束
    int step;//猜词的次数
    LanternRiddle lanternRiddle;//灯谜
    String reward;//奖品

    public UserCondition() {
        this.status = 0;
        this.step = 0;
        //随机挑选灯谜
        int index1 = (int) (Math.random()*LanternRiddle.lanternRiddleList.size());
        this.lanternRiddle = LanternRiddle.lanternRiddleList.get(index1);
        //随机挑选奖品
        int index2 = (int) (Math.random()*Rewards.rewardList.size());
        this.reward = Rewards.rewardList.get(index2);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public LanternRiddle getLanternRiddle() {
        return lanternRiddle;
    }

    public void setLanternRiddle(LanternRiddle lanternRiddle) {
        this.lanternRiddle = lanternRiddle;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }
}
