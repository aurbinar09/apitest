package com.nttdata.testing.tasks;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeletePasenger implements Task{

    private final String _id;

    public DeletePasenger(String id) {
        _id = id;
    }

    public static Performable fromPage(String _id) {
        return instrumented(DeletePasenger.class, _id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from("/passenger/" + _id)
                        .with(request -> request
                                .contentType(ContentType.JSON)) //
        );
    }
}

