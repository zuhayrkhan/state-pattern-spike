package com.zuhayrkhan.patterns.state.life;

import com.zuhayrkhan.patterns.state.life.model.stateful.Person;
import com.zuhayrkhan.patterns.state.life.model.stateful.PersonFactory;
import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;
import com.zuhayrkhan.patterns.state.life.state.LifeState;
import com.zuhayrkhan.patterns.state.life.state.LifeStateFactory;
import com.zuhayrkhan.patterns.state.support.state.StateRegistry;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class PersonTest {

    private final LifeStateReporter lifeStateReporter =
            new LifeStateReporter();

    private final LifeStateFactory lifeStateFactory =
            new LifeStateFactory(lifeStateReporter);

    private final StateRegistry<LifeState> lifeStateRegistry =
            new StateRegistry<>(lifeStateFactory);

    private final PersonFactory personFactory =
            new PersonFactory(lifeStateFactory);

    @Test
    void new_person_can_live_their_life() {

        Person zuhayr = personFactory.createNewPerson("Zuhayr");

        lifeStateReporter.reportLifeStatus(zuhayr);

        zuhayr.wakeUp();
        zuhayr.becomeHungry();
        zuhayr.becomeTired();
        zuhayr.goToSleep();

    }

    @Test
    void new_person_can_live_their_life_wrong() {

        Person zuhayr = personFactory.createNewPerson("Zuhayr");

        lifeStateReporter.reportLifeStatus(zuhayr);

        zuhayr.wakeUp();

        assertThrows(IllegalStateException.class, zuhayr::goToSleep);

    }
}