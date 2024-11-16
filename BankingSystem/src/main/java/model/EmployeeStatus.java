package model;

public enum EmployeeStatus {
    ACTIVE(1),
    INACTIVE(2),
    SUSPENDED(3),
    TERMINATED(4);

    private final int value;

    EmployeeStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static EmployeeStatus fromInt(int i){
        for(EmployeeStatus status : EmployeeStatus.values()){
            if(status.getValue() == i){
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value : "+ 1);
    }
}
