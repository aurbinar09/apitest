package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import net.serenitybdd.screenplay.rest.interactions.Patch;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PatchPasenger implements Task{

    private final String _id;
    private final String name;

    public PatchPasenger(String id, String name) {
        _id = id;
        this.name = name;
    }

    public static Performable withName(String id, String name) {
        return instrumented(PatchPasenger.class, id, name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Patch.to("/passenger/" + _id)
                        .with(request -> request
                                .contentType(ContentType.JSON)
                                .body("{\"name\": \"" + name + "\"}")
                        )
        );
    }
}

