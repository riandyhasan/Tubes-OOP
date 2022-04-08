public class StatusCondition extends Stats{

    public void burn(double healthPoint, double attack){
        healthPoint = this.healthPoint - this.healthPoint * 1/8;
        // yang damage nya blm ngerti
    }

    public void poison(double healthPoint){
        healthPoint = this.healthPoint - this.healthPoint * 1/16;
    }

    // yg sleep bingungg

    public void paralyze(double speed) {
        speed = this.speed - this.speed * 1/2;
    }
}
