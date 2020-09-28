package ru.rudolf;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Project extends AbstractElement {

    private final Set<Requirement> requirements;

    public Project() {
        requirements = new HashSet<>();
    }

    public Set<Requirement> getRequirements() {
        return requirements;
    }

    public void addRequirement(Requirement requirement){
        this.requirements.add(requirement);
    }

    public void addRequirement(Collection<Requirement> requirement){
        this.requirements.addAll(requirement);
    }
}
