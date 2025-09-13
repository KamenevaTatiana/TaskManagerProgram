package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TasksTest {

    @Test
    public void shouldMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Сделать д/з");

        boolean actual = simpleTask.matches("Сделать д/з");
        boolean expected  = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1, "Сделать д/з");

        boolean actual = simpleTask.matches("Пойти на прогулку");
        boolean expected  = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesEpic() {
        String[] subtasks = { "Сантехника", "Полы", "Пыль" };
        Epic epic = new Epic(7, subtasks);

        boolean actual = epic.matches("Сантехника");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesEpic() {
        String[] subtasks = { "Сантехника", "Полы", "Пыль" };
        Epic epic = new Epic(7, subtasks);

        boolean actual = epic.matches("Окна");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldMatchesMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Приложение НетоБанка");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotMatchesMeeting() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean actual = meeting.matches("Во вторник после обеда");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }
}
