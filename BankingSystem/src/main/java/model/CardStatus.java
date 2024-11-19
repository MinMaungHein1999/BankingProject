package model;

public enum CardStatus {
    Credit(1),
    Debit(2),
    Saving(3);

    private final int value;

    CardStatus(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static CardStatus fromInt(int i){
        for(CardStatus status : CardStatus.values()){
            if(status.getValue() == i){
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value : "+ 1);
    }
}
