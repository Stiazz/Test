package ru.rudolf;

import java.util.ArrayList;
import java.util.Collection;

public class Project extends AbstractElement {

    private final ArrayList<Requirement> requirements;

    public Project() {
        requirements = new ArrayList<>();
    }

    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    public void addRequirement(Requirement requirement){
        this.requirements.add(requirement);
    }

    public void addRequirement(Collection<Requirement> requirement){
        this.requirements.addAll(requirement);
    }
}
