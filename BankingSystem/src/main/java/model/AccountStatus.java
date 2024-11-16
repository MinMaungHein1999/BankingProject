package model;

public enum AccountStatus {
    ACTIVE(1),
    INACTIVE(2),
    SUSPENDED(3),
    TERMINATED(4);

    private final int value;

    AccountStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static AccountStatus fromInt(int i){
        for(AccountStatus status : AccountStatus.values()){
            if(status.getValue() == i){
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value : "+ 1);
    }
}
