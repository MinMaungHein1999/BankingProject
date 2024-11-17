package model;

public enum CustomerStatus {
    ACTIVE(1),
    INACTIVE(2),
    SUSPENDED(3),
    TERMINATED(4);

    private final int value;

    CustomerStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static CustomerStatus fromInt(int i){
        for(CustomerStatus status : CustomerStatus.values()){
            if(status.getValue() == i){
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value : "+ 1);
    }
}
