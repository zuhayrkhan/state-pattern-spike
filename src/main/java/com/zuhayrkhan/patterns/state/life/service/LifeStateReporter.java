package com.zuhayrkhan.patterns.state.life.service;

import com.zuhayrkhan.patterns.state.life.model.stateful.NewPerson;
import com.zuhayrkhan.patterns.state.life.model.stateful.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LifeStateReporter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LifeStateReporter.class);

    public void reportLifeStatus(Person person) {
        LOGGER.info("{}: {}", person.getName(), person.getLabel());
    }

    public void reportLifeStatus(NewPerson person) {
        LOGGER.info("{}: {}", person.getName(), person.getContext().getLabel());
    }

}
