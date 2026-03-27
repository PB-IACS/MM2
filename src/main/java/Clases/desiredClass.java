package Clases;

public class desiredClass {
    private final int desiredId;
    private final int desiredAmount;
    private final int desiredMedicineId;

    public desiredClass(int desiredId, int desiredAmount, int desiredMedicineId) {
        this.desiredId = desiredId;
        this.desiredAmount = desiredAmount;
        this.desiredMedicineId = desiredMedicineId;
    }

    public int getDesiredId() {
        return desiredId;
    }

    public int getDesiredAmount() {
        return desiredAmount;
    }

    public int getDesiredMedicineId() {
        return desiredMedicineId;
    }
}
