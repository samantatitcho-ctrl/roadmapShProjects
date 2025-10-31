import java.util.Scanner;

public class Round {
    private final int randomValue;
    private Player player;
    public Round() {
        initialiseRound();
        this.randomValue = (int)(Math.random()*100)+1;
        selectDifficulty();
    }


    public void initialiseRound(){
        System.out.println("________________________________________________");
        System.out.println("Bienvenue dans notre jeux du nombre mystère");
        System.out.println("nous generons un nombre compris entre 1 et 100");
        System.out.println("vous avez un nombre de chance variant en fonction de la difficulté choisie pour trouver le nombre correct");
        System.out.println("________________________________________________");
    }
    public void guessingNumber(){
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("entrer une valeur");
            int valeur = sc.nextInt();
            if(valeur<=100 && valeur>=1){
                if(valeur<this.randomValue){
                    System.out.println("le nombre mystère est plus grand");
                    player.setLives(player.getLives()-1);
                    System.out.println("vies restantes "+player.getLives());
                }else if(valeur>this.randomValue){
                    System.out.println("le nombre mystère est plus petit");
                    player.setLives(player.getLives()-1);
                    System.out.println("vies restantes "+player.getLives());
                } else {
                    System.out.println("Bravo vous avez trouver le nombre correct\t"+randomValue);
                    break;
                }
            }else{
                System.out.println("entrez une valeur entre 1 et 100");
                player.setLives(player.getLives()-1);
                System.out.println("vies restantes "+player.getLives());
            }

        }while (player.getLives()>0);
    }
    public Player selectDifficulty() {
        Scanner sc = new Scanner(System.in);

        System.out.print("""
                choisir la difficulté(choisir le chiffre correspondant au niveau souhaité):\s
                1: pour facile(10 vies)
                2: pour moyen(5 vies)
                3 pour difficile(3 vies)
                """);
        int niveau = sc.nextInt();

        return switch (niveau){
            case 1 ->player = new Player(10);
            case 2 ->player = new Player(5);
            case 3 ->player = new Player(3);
            default ->player = new Player(5);
        };
    }
}
