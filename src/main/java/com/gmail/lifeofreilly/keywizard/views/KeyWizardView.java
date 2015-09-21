package com.gmail.lifeofreilly.keywizard.views;

import com.gmail.lifeofreilly.keywizard.api.KeyRepresentation;
import io.dropwizard.views.View;

public class KeyWizardView extends View {
    private final KeyRepresentation keyRepresentation;

    public KeyWizardView(KeyRepresentation keyRepresentation) {
        super("/keywizard.ftl");
        this.keyRepresentation = keyRepresentation;
    }

    public KeyRepresentation getKeyRepresentation() {
        return keyRepresentation;
    }

}
