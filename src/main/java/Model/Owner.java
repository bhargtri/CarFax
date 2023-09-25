package Model;

import lombok.Data;

import java.util.Objects;

@Data
public class Owner {

    private int licenseNum;
    private String name;
    private int birthYear;
    private String state;

    public Owner(int ssn, String name, int birthYear, String state) {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owner owner = (Owner) o;
        return licenseNum == owner.licenseNum && birthYear == owner.birthYear && Objects.equals(name, owner.name) && Objects.equals(state, owner.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(licenseNum, name, birthYear, state);
    }

    @Override
    public String toString() {
        return "Owner{" +
                "licenseNum=" + licenseNum +
                ", name='" + name + '\'' +
                ", birthYear=" + birthYear +
                ", state='" + state + '\'' + '}';
    }

}

