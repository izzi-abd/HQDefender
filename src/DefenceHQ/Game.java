package DefenceHQ;
import java.util.Scanner;
/**
 *
 * @author Abdurrahman Izzi - 13.7454
 * HEADQUARTER DEFENDER
 */
public class Game {
    //Membuat objek
    EnemyRocket ER;
    Headquarter HQ;
    Radar RDR;
    Randomizer RD;
    Missile MSL;
    
    void init() {
        //inisialisasi awal;
        ER = new EnemyRocket();
        HQ = new Headquarter();
        RDR = new Radar();
        RD = new Randomizer();
        MSL = new Missile();
        HQ.setPosition();
        RD.setHQPosition(HQ);
        ER.setState("ready");
        ER.setTarget(RD);
        MSL.setState("ready");
    }
    
    void intercept(EnemyRocket ER) {
        //intersep roket musuh dengan misil anti serangan udara
        //mengambil data posisi roket musuh dari perkiraan radar
        MSL.intercept(RDR);
    }
    
    void rocketLaunch() {
        //peluncuran roket musuh
        ER.launch();
        //menginisialisasi posisi roket setelah diluncurkan
        RD.setERPosition(ER);
    }
    
    int radarDetectER() {
        //mendeteksi & memperkirakan target yang dituju roket musuh 
        RDR.setERTarget(RD);
        return RDR.getERTarget();
    }
    
    void report(Game game) {
        System.out.println();
        System.out.println("REPORT");
        System.out.println("Enemy Rocket Position : " +game.ER.getPosition());
        System.out.println("Missile Target : " +game.MSL.getPosition());
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //intro
        System.out.println("Welcome to our Game : HEADQUARTER DEFENDER");
        System.out.println("your task is destroying rocket from enemy, which headed to your HQ");
        System.out.println("Please enjoy!");
        System.out.println("================================================");
        
        START:
        while(true) {
        System.out.print("Start Game? (y/n) : ");
        String a = in.nextLine();
        
        if (a.equalsIgnoreCase("n")) {
            return;
        } else if(a.equalsIgnoreCase("y")) {
            break START;
        } else {
            System.out.println("Error. Please input with 'y' for yes, and 'n' for no :");
            continue START;
        }}
        
        System.out.println("================================================");
        //membuat objek & inisialisasinya
        Game game = new Game();
        game.init();
        
        //meluncurkan roket musuh
        game.rocketLaunch();
        
        //menampilkan pesan peringatan
    {
        int a=game.HQ.getPosition();
        int b=game.radarDetectER();
        System.out.println("WARNING, ENEMY ROCKET HEADED TO US!");
        System.out.println("This is your HQ Position : " +a);
        System.out.println("Estimating rocket's target.....");
        System.out.println("Rocket's Target Coordinate : " +b);
        System.out.println("Estimation : ");
        
        //memperkirakan apakah target roket musuh, yang dideteksi radar akan mengenai HQ
        //apabila target berada di rentang -5 s/d 5 dari posisi HQ, maka menampilkan peringatan
        if ((a-b)*(a-b) <= 25) {
            System.out.println("Your HQ will be destroyed!");
        } else {
            System.out.println("Your HQ will be safe.");
        }
    }
        System.out.println();
        
        //menanyakan apakah harus meluncurkan misil anti serangan udara
        START:
        while(true) {
        System.out.print("Launch anti-air missile? (y/n) : ");
        String a = in.nextLine();
        
        //jika tidak meluncurkan serangan udara
        if (a.equalsIgnoreCase("n")) {
            /* jika posisi HQ tidak berada di range -5 s/d 5 dari target roket musuh,
             * maka HQ aman, tetapi jika sebaliknya maka HQ hancur
            */
            if(game.HQ.stillStand(game.ER)) {
                System.out.println("Enemy rocket missed!");
            } else {
                System.out.println("Our HQ destroyed!");
            }
            return;
            
        //jika meluncurkan serangan udara    
        } else if(a.equalsIgnoreCase("y")) {
            //menginisialisasi perkiraan posisi roket musuh dan memerintahkan misil untuk meluncur
            game.RDR.setERPosition(game.RD);
            game.intercept(game.ER);
            
            //jika posisi misil berdekatan dengan roket musuh di udara dengan jarak +-5, maka roket musuh meledak dan misi sukses.
            if(game.MSL.getState().equals("fly") && 
                    game.ER.getState().equals("fly") &&
                    (game.ER.getPosition()-5<=game.MSL.getPosition() &&
                            game.MSL.getPosition()<=game.ER.getPosition()+5)) {
                game.report(game);
                System.out.println("Mission success. Enemy rocket destroyed!");
                
            //jika posisi misil tidak berdekatan dengan roket musuh di udara, maka misi gagal.    
            } else if (game.MSL.getState().equals("fly") && 
                    game.ER.getState().equals("fly") &&
                    (game.MSL.getPosition()!=game.ER.getPosition())) {
                
                //jika misi gagal tapi roket musuh meleset dari posisi HQ sebenarnya, maka HQ aman
                if(game.HQ.stillStand(game.ER)) {
                    game.report(game);
                    System.out.println("Mission failed, but enemy rocket missed!");
                    
                //jika misi gagal dan roket musuh antara +-5 dari posisi HQ sebenarnya, maka HQ hancur
                } else {
                    game.report(game);
                    System.out.println("Mission failed. Our HQ destroyed!");
                }
            }
            break START;
        } else {
            System.out.println("Error. Please input with 'y' for yes, and 'n' for no :");
            continue START;
        }}
        
        
        
    }
}
