package model;

public enum TransactionType {
    DEPOSIT(1),
    WITHDRAW(2),
    TRANSFER(3);

    private final int value;

    TransactionType(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static TransactionType fromInt(int i){
        for(TransactionType type : TransactionType.values()){
            if(type.getValue() == i){
                return type;
            }
        }
        throw new IllegalArgumentException("Unexpected value : "+ 1);
    }
}
