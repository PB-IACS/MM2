package Clases;

public class medicineClass {
    private final int medicineId;
    private final String medicineName;
    private final int currentMedicineAmount;
    private final int desiredMedicineAmount;
    private final int medicineCategoryId;

    public medicineClass(int medicineId, String medicineName, int currentMedicineAmount, int desiredMedicineAmount, int medicineCategoryId) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.currentMedicineAmount = currentMedicineAmount;
        this.desiredMedicineAmount = desiredMedicineAmount;
        this.medicineCategoryId = medicineCategoryId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public int getCurrentMedicineAmount() {
        return currentMedicineAmount;
    }

    public int getDesiredMedicineAmount() {
        return desiredMedicineAmount;
    }

    public int getMedicineCategoryId() {
        return medicineCategoryId;
    }
}
