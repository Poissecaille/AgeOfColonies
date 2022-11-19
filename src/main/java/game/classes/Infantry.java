package game.classes;

public class Infantry extends GameEntity{
    public Infantry(){
        this.type=GameEntityType.EARHTY;
        this.fuelLevel = 99;
        this.vision = 3;
        this.movement = 3;
        this.experience = 0;
        this.imagePath = "C:\\Users\\PC\\IdeaProjects\\AgeOfColonies\\src\\main\\java\\game\\assets\\character.png";
    };
}
