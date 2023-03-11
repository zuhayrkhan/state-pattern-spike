package com.zuhayrkhan.patterns.state.life;

import com.zuhayrkhan.patterns.state.life.model.Person;
import com.zuhayrkhan.patterns.state.life.model.PersonFactory;
import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;
import com.zuhayrkhan.patterns.state.life.state.LifeStateFactory;
import com.zuhayrkhan.patterns.state.life.state.LifeStateRegistry;
import org.junit.jupiter.api.Test;

class PersonTest {

    private final LifeStateReporter lifeStateReporter =
            new LifeStateReporter();

    private final LifeStateFactory lifeStateFactory =
            new LifeStateFactory(lifeStateReporter);

    private final LifeStateRegistry lifeStateRegistry =
            new LifeStateRegistry(lifeStateFactory);

    private final PersonFactory personFactory =
            new PersonFactory(lifeStateRegistry);

    @Test
    void person_can_live_their_life() {

        Person zuhayr = personFactory.createPerson("Zuhayr");

        lifeStateReporter.reportLifeStatus(zuhayr);

        zuhayr.wakeUp();
        zuhayr.becomeHungry();
        zuhayr.becomeTired();
        zuhayr.goToSleep();

    }
}