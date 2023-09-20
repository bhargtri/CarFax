package Model;

import java.util.Objects;

public class Owner {
    private int ssn;
    private String name;
    private int birthYear;
    private String state;

    public Owner(int ssn, String name, int birthYear, String state) {
        this.ssn = ssn;
        this.name = name;
        this.birthYear = birthYear;
        this.state = state;
    }

    public int getSsn() {
        return ssn;
    }

    public void setSsn(int ssn) {
        this.ssn = ssn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return ssn == owner.ssn && birthYear == owner.birthYear && Objects.equals(name, owner.name) && Objects.equals(state, owner.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ssn, name, birthYear, state);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ssn=" + ssn +
                ", name='" + name + '\'' +
                ", Born in year=" + birthYear +
                ", Resident of state='" + state + '\'' +
                '}' + "/n";
    }
}
