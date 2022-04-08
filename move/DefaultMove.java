public class DefaultMove extends Move{
    private int basePower;

    public DefaultMove (){
        super("DefaultMove",100,0,int.MAX_VALUE);
        this.basePower = 50;
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