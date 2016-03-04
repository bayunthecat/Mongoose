package com.lwd.core.bean;

import java.util.Collections;
import java.util.List;

public class BeanDefinition {

    private String id;

    private String name;

    private String fullQualifiedNameOfTheClass;

    private List<String> aliases;

    private List<String> dependencies;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullQualifiedNameOfTheClass() {
        return fullQualifiedNameOfTheClass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFullQualifiedNameOfTheClass(String fullQualifiedNameOfTheClass) {
        this.fullQualifiedNameOfTheClass = fullQualifiedNameOfTheClass;
    }

    public void addAlias(String alias) {
        aliases.add(alias);
    }

    public void addDependency(String dependency) {
        dependencies.add(dependency);
    }

    public List<String> getAliases() {
        return Collections.unmodifiableList(aliases);
    }

    public List<String> getDependencies() {
        return Collections.unmodifiableList(dependencies);
    }
}
