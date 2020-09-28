package ru.rudolf;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class AbstractElement {
    //ДатаСоздания
    private final LocalDate dateCreation;
    //ДатаНачала
    private LocalDate startDate;
    //ДатаЗавершения
    private LocalDate endDate;
    //Состояние
    private ElementState state;
    //ОтветственноеЛицо
    private String responsiblePerson;
    //Готовность
    private int readiness;

    protected AbstractElement(){
        dateCreation = LocalDate.now();
        state = ElementState.New;
        readiness = 0;
    }

    /*
        Возвращает дату создания
    */
    public LocalDate getDateCreation() {
        return dateCreation;
    }

    /*
        Возвращает дату начала
    */
    public LocalDate getStartDate() {
        return startDate;
    }

    /*
        Указать дату начала (ДатаСоздания < ДатаНачала)
    */
    public void setStartDate(LocalDate startDate) {
        if (ChronoUnit.SECONDS.between(dateCreation, startDate) < 0){
            this.startDate = startDate;
        }
    }

    /*
        Возвращает дату окончания
    */
    public LocalDate getEndDate() {
        return endDate;
    }

    /*
        Указать дату завершения (ДатаНачала < ДатаЗавершения)
    */
    public void setEndDate(LocalDate endDate) {
        if (ChronoUnit.SECONDS.between(startDate, endDate) < 0){
            this.endDate = endDate;
        }
    }

    /*
        Возвращает дату состояние
    */
    public ElementState getState() {
        return state;
    }

    /*
        Указать состояние (Новое, Анализ, В работе, Завершено)
    */
    public void setState(ElementState state) {

        //Если Состояние != Новое, то должна быть указана Дата Начала
        if (state != ElementState.New && startDate != null){
            this.state = state;
        }else System.out.println("Должна быть указана Дата Начала");

        //Если Состояние == Завершено, то должна быть указана Дата Завершения и Готовность = 100
        if (state == ElementState.Completed && endDate != null && readiness == 100) {
            this.state = state;
        }else System.out.println("должна быть указана Дата Завершения и Готовность = 100");

    }

    /*
        Возвращает ответственное лицо
    */
    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    /*
        Указывает ответственное лицо
    */
    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    /*
        Возвращает готовность
    */
    public int getReadiness() {
        return readiness;
    }

    /*
        Указывает готовность
    */
    public void setReadiness(byte readiness) {
        if (readiness > 0 && readiness <= 100){
            this.readiness = readiness;
        }
    }
}
