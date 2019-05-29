package com.baeldung.jmockit101;

/**
 * @author rancho
 * @date 2019-05-29
 */
public class Performer {

    private Collaborator collaborator;

    public void perform(Model model) {
        boolean value = collaborator.collaborate(model.getInfo());
        collaborator.receive(value);
    }

}
