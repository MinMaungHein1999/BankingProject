package model;

public enum LoanStatus {
    ACTIVE(1),
    INACTIVE(2),
    SUSPENDED(3),
    TERMINATED(4);

    private final int value;

    LoanStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static LoanStatus fromInt(int i){
        for(LoanStatus status : LoanStatus.values()){
            if(status.getValue() == i){
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value : "+ 1);
    }
}
