import java.util.ArrayList;

public class Monster {
    
    private String nama;
    private ArrayList<ElementType> elementTypes;
    private Stats baseStats;
    private ArrayList<Move> moves;

    public Monster(String nama, ArrayList<ElementType> elementTypes, Stats baseStats, ArrayList<Move> moves){
        this.nama = nama;
        this.elementTypes = elementTypes;
        this.baseStats = baseStats;
        this.moves = moves;
    }
    
}