package ru.rudolf;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

public class ProjectManager {
    public static LocalDate calculationPDZ(Collection<Project> projects) {
        //Максмальное ПДЗ
        LocalDate maxPDZ = LocalDate.now();

        //Получаем все проекты
        for (Project project : projects) {
            //Получаем у текущего проекта все требования
            for (Requirement requirement : project.getRequirements()) {
                //Получаем у текущего требования все задачи
                for (Task task : requirement.getTasks()) {
                    if (task.getReadiness() != 100) {
                        //ПДЗ задачи
                        LocalDate pdz = LocalDate.now().plusDays(
                                Math.round(1 / task.getTaskType().getK()
                                        * (100 - task.getReadiness())
                                        * ChronoUnit.DAYS.between(LocalDate.now(), task.getDateCreation()) / task.getReadiness()
                                )
                        );
                        //f.ПДЗ требования есть максимальное значений ПДЗ задачи
                        if (ChronoUnit.DAYS.between(pdz, maxPDZ) > 0) {
                            maxPDZ = pdz;
                        }
                    }
                }
            }
        }
        return maxPDZ;
    }
}
