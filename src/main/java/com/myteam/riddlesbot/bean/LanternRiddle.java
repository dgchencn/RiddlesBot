package com.myteam.riddlesbot.bean;

import java.util.ArrayList;
import java.util.List;

//灯谜类
public class LanternRiddle {
    static List<LanternRiddle> lanternRiddleList = new ArrayList<>();
    static {
        lanternRiddleList.add(new LanternRiddle("远看两个零，近看两个零。有人用了行不得，有人不用不得行（打一日常用品）","眼镜"));
        lanternRiddleList.add(new LanternRiddle("口比肚子大，给啥就吃啥。它吃为了你，你吃端着它（打一日常用品）","饭碗"));
        lanternRiddleList.add(new LanternRiddle("平日不思，中秋想你。有方有圆，又甜又蜜（打一日常用品）","月饼"));
        lanternRiddleList.add(new LanternRiddle("小小东西，放在腋底。有病没病，看它肚皮（打一日常用品）","温度计"));
        lanternRiddleList.add(new LanternRiddle("身上滑腻腻，喜欢钻河底。张嘴吐泡泡，可以测天气（打一动物名）","泥鳅"));
        lanternRiddleList.add(new LanternRiddle("小时像豆号，在水中玩耍。长大跳得高，是捉虫冠军（打一动物名）","青蛙"));
        lanternRiddleList.add(new LanternRiddle("一位公公精神好，从小到老不睡觉，身体轻劲不少，左推右推推不倒？（打一玩具）","不倒翁"));
        lanternRiddleList.add(new LanternRiddle("是花不是花，又能观来又能吃，早向东来晚向西，向着太阳笑开怀。（打一植物）","向日葵"));
    }

    String riddle;  //谜面
    String answer;  //谜底

    public LanternRiddle(String riddle, String answer) {
        this.riddle = riddle;
        this.answer = answer;
    }

    public String getRiddle() {
        return riddle;
    }

    public void setRiddle(String riddle) {
        this.riddle = riddle;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
