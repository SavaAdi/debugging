package eu.unicreditgroup.debugging.basic;

public interface Playable {

    State status = State.NEW;

    void plays();

    void sleeps();
}
