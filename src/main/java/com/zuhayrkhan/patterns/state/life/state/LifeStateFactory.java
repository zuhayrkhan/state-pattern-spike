package com.zuhayrkhan.patterns.state.life;

public class LifeStateFactory {

    Asleep createAsleep() {
        return new Asleep();
    }

    Awake createAwake() {
        return new Awake();
    }

    Hungry createHungry() {
        return new Hungry();
    }

    Tired createTired() {
        return new Tired();
    }

}
