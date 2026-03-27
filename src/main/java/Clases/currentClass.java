package Clases;

public class currentClass {
    private final int currentId;
    private final int currentAmount;
    private final String currentName;
    private final String expirationDate;
    private final int isExpired;
    private final int currentMedicineId;

    public currentClass(int currentId, int currentAmount, String currentName, String expirationDate, int isExpired, int currentMedicineId) {
        this.currentId = currentId;
        this.currentAmount = currentAmount;
        this.currentName = currentName;
        this.expirationDate = expirationDate;
        this.isExpired = isExpired;
        this.currentMedicineId = currentMedicineId;
    }

    public int getCurrentId() {
        return currentId;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public String getCurrentName() {
        return currentName;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getIsExpired() {
        return isExpired;
    }

    public int getCurrentMedicineId() {
        return currentMedicineId;
    }
}
