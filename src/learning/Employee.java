package learning;

public class Employee {
    private int hourleyRate;
    private  int baseSalary;


    public Employee(int hourlyRate, int baseSalary) {
       setBaseSalary(baseSalary);
       setHourlyRate(hourlyRate);
    }
    public Employee(int baseSalary) {
       this(0,baseSalary);
    }
    public int calculateWage(int extraHours){
        return  baseSalary + (hourleyRate * extraHours);
    }
    public int calculateWage(){
        return  calculateWage(0);
    }

    private void setHourlyRate(int hourlyRate) {
        if (hourlyRate < 0)
            throw new RuntimeException();
        this.hourleyRate = hourlyRate;
    }

    private void setBaseSalary(int baseSalary) {
        if (baseSalary <=0)
            throw  new IllegalArgumentException("salary must be greater than zero");
        this.baseSalary = baseSalary;
    }


}
