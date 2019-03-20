package main;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
public class Person {
    private final SimpleStringProperty firstName = new SimpleStringProperty("");
    private final SimpleStringProperty lastName = new SimpleStringProperty("");
    private final SimpleIntegerProperty grade = new SimpleIntegerProperty(0);
    private final SimpleStringProperty subject = new SimpleStringProperty("");
    private final SimpleBooleanProperty matched = new SimpleBooleanProperty(false);
    public Person(){
        this("","",0,"",false);
    }
    public Person(String firstName, String lastName, int grade, String subject, boolean matched){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.grade.set(grade);
        this.subject.set(subject);
        this.matched.set(matched);
    }
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lName) {
        lastName.set(lName);
    }

    public int getGrade(){
        return grade.get();
    }

    public void setGrade(int grade){
        this.grade.set(grade);
    }

    public String getSubject() {return subject.get();}

    public void setSubject(String subject){
        this.subject.set(subject);
    }

    public boolean getMatched(){
        return matched.get();
    }

    public void setMatched(boolean match){
        matched.set(match);
    }
}
