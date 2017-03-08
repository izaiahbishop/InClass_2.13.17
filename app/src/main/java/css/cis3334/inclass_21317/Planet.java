package css.cis3334.inclass_21317;

/**
 * Created by ibishop on 2/15/2017.
 */

public class Planet {

    private String name;
    private Double distFromSun, diameter;

    public Planet(String name, Double distFromSun, Double diameter) {
        this.name = name;
        this.distFromSun = distFromSun;
        this.diameter = diameter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDistFromSun() {
        return distFromSun;
    }

    public void setDistFromSun(Double distFromSun) {
        this.distFromSun = distFromSun;
    }

    public Double getDiameter() {
        return diameter;
    }

    public void setDiameter(Double diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "Name = " + name + "\nDistance from Sun = " + distFromSun + " kilometers \nDiameter = " + diameter;
    }
}
