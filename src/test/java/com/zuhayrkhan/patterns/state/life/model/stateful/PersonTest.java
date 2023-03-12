package com.zuhayrkhan.patterns.state.life.model.stateful;

import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;
import com.zuhayrkhan.patterns.state.life.state.LifeStateFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

    private final LifeStateReporter lifeStateReporter =
            new LifeStateReporter();

    private final LifeStateFactory lifeStateFactory =
            new LifeStateFactory(lifeStateReporter);

    private final PersonFactory personFactory =
            new PersonFactory(lifeStateFactory);

    @Test
    void new_person_can_live_their_life() {

        Person zuhayr = personFactory.createNewPerson("Zuhayr");

        lifeStateReporter.reportLifeStatus(zuhayr);

        zuhayr.wakeUp();

        assertThat(zuhayr.getStateName()).isEqualTo("Awake");

        zuhayr.becomeHungry();

        assertThat(zuhayr.getStateName()).isEqualTo("Hungry");

        zuhayr.becomeTired();

        assertThat(zuhayr.getStateName()).isEqualTo("Tired");

        zuhayr.goToSleep();

        assertThat(zuhayr.getStateName()).isEqualTo("Asleep");

    }

    @Test
    void new_person_can_live_their_life_wrong() {

        Person zuhayr = personFactory.createNewPerson("Zuhayr");

        assertThat(zuhayr.getStateName()).isEqualTo("Asleep");

        lifeStateReporter.reportLifeStatus(zuhayr);

        zuhayr.wakeUp();

        assertThat(zuhayr.getStateName()).isEqualTo("Awake");

        assertThrows(IllegalStateException.class, zuhayr::goToSleep);

    }
}