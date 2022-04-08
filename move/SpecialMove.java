public class SpecialMove extends Move{
    private int basePower;
    
    public SpecialMove(String elementTypes, int accuracy, int priority, int ammunition, int basePower) {
        super(elementTypes, accuracy, priority, ammunition);
        this.basePower = basePower;
    }
    public int getBasePower() {
        return basePower;
    }
    public void setBasePower(int basePower) {
        this.basePower = basePower;
    }
    public void useMove(){
    }
}
