package ru.rudolf;

import junit.framework.TestCase;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TaskTest extends TestCase {
    //ДатаСоздания < ДатаНачала
    public void testGetDateCreation() {
        Task testTask = new Task();

        testTask.setStartDate(LocalDateTime.now().plusDays(1));
        testTask.setEndDate(LocalDateTime.now().plusDays(2));

        Assert.assertTrue(ChronoUnit.SECONDS.between(testTask.getDateCreation(), testTask.getStartDate()) > 0);

    }
    //ДатаНачала < ДатаЗавершения
    public void testGetStartDate() {
        Task testTask = new Task();

        testTask.setStartDate(LocalDateTime.now().plusDays(1));
        testTask.setEndDate(LocalDateTime.now().plusDays(2));
        Assert.assertTrue(ChronoUnit.SECONDS.between(testTask.getStartDate(), testTask.getEndDate()) > 0);
    }
    //Если Состояние != Новое, то должна быть указана ДатаНачала
    public void testState() {
        Task testTask = new Task();

        testTask.setStartDate(LocalDateTime.now().plusDays(1));

        testTask.setState(ElementState.InWork);

        Assert.assertSame(testTask.getState(), ElementState.InWork);
    }
    //Если Состояние == Завершено, то должна быть указана ДатаЗавершения и Готовность = 100
    public void testState2() {
        Task testTask = new Task();

        testTask.setStartDate(LocalDateTime.now().plusDays(1));
        testTask.setEndDate(LocalDateTime.now().plusDays(2));

        testTask.setReadiness(100);

        testTask.setState(ElementState.Completed);

        Assert.assertSame(testTask.getState(), ElementState.Completed);
    }

}