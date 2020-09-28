package ru.rudolf;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public abstract class AbstractElement {
    //ДатаСоздания
    private final LocalDateTime dateCreation;
    //ДатаНачала
    private LocalDateTime startDate;
    //ДатаЗавершения
    private LocalDateTime endDate;
    //Состояние
    private ElementState state;
    //ОтветственноеЛицо
    private String responsiblePerson;
    //Готовность
    private int readiness;

    protected AbstractElement(){
        dateCreation = LocalDateTime.now();
        state = ElementState.New;
        readiness = 0;
    }

    /*
        Возвращает дату создания
    */
    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    /*
        Возвращает дату начала
    */
    public LocalDateTime getStartDate() {
        return startDate;
    }

    /*
        Указать дату начала (ДатаСоздания < ДатаНачала)
    */
    public void setStartDate(LocalDateTime startDate) {
        if (ChronoUnit.SECONDS.between(dateCreation, startDate) > 0){
            this.startDate = startDate;
        }
    }

    /*
        Возвращает дату окончания
    */
    public LocalDateTime getEndDate() {
        return endDate;
    }

    /*
        Указать дату завершения (ДатаНачала < ДатаЗавершения)
    */
    public void setEndDate(LocalDateTime endDate) {
        if (ChronoUnit.SECONDS.between(startDate, endDate) > 0){
            this.endDate = endDate;
        }else System.out.println("ДатаНачала должна быть меньше ДатаЗавершения");
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
            if (state == ElementState.Completed) {
                if (endDate != null && readiness == 100)
                    this.state = state;
                else System.out.println("должна быть указана Дата Завершения и Готовность = 100");
            }else this.state = state;
        }else System.out.println("Должна быть указана Дата Начала");

        //Если Состояние == Завершено, то должна быть указана Дата Завершения и Готовность = 100
//        if (state == ElementState.Completed) {
//            if (endDate != null && readiness == 100)
//                this.state = state;
//            else System.out.println("должна быть указана Дата Завершения и Готовность = 100");
//        }

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
    public void setReadiness(int readiness) {
        if (readiness > 0 && readiness <= 100){
            this.readiness = readiness;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractElement)) return false;
        AbstractElement that = (AbstractElement) o;
        return getReadiness() == that.getReadiness() &&
                Objects.equals(getDateCreation(), that.getDateCreation()) &&
                Objects.equals(getStartDate(), that.getStartDate()) &&
                Objects.equals(getEndDate(), that.getEndDate()) &&
                getState() == that.getState() &&
                Objects.equals(getResponsiblePerson(), that.getResponsiblePerson());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDateCreation(), getStartDate(), getEndDate(), getState(), getResponsiblePerson(), getReadiness());
    }
}
