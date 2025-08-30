package gamefolder;
import java.util.Scanner;
public class Game {
	
	Scanner myscanner = new Scanner(System.in);
	Scanner enterscanner = new Scanner(System.in);
	int playerHp=10;
	int monsterHp=15;
	String playerWeapon;
	String playerName;
	int choice;
	String silverRing;
	
	public static void main(String[] args) {
		Game x;
		x=new Game();
		x.playerSetup();
		x.townGate();
	}
	
	public void playerSetup(){	
		playerWeapon = "Broken Sword";	
		System.out.println("HP:"+playerHp);
		System.out.println("Weapon Acquired:"+playerWeapon);
		myscanner=new Scanner(System.in);
		System.out.println("Name of character:");
		playerName=myscanner.nextLine();
		System.out.println("Hello "+playerName + "!, Let the Adventure Begin!!");
	}
	
	public void townGate() {
		System.out.println("\n>>------------------------------------>\n");
		System.out.println("");
		System.out.println("You are at the town gate.");
		System.out.println("A guard is standing infront of you.\n");
		System.out.println("What do you want to do?\n");
		System.out.println("1.Greet the guard and Ask to enter");	
		System.out.println("2.Fight the guard");
		System.out.println("3.Leave");
		choice=myscanner.nextInt();
		if (choice==1) {
			if (silverRing=="yes") {
				System.out.println("Oh welcome adventurer!");
				ending();
		}
			else {
				System.out.println("Hello Stranger.\nSorry no stranger allowed in town.");
				System.out.println("[Press Enter]");
				enterscanner.nextLine();
				townGate();
			}
		}
		else if (choice==2) {
			playerHp=playerHp-1;
			System.out.println("Guard:What the hell!!\nGuard hits you and you fall back\n(you recieve 1 damage)");
			System.out.println("Player Hp is : "+playerHp);
			townGate();
		}	
		else if (choice==3) {
			crossRoad();
		}
		else
			System.out.println("Wrong Input");
			townGate();
	}
	
	public void crossRoad() {
		System.out.println("\n>>------------------------------------>\n");
		System.out.println("You are at a crossroad.If you go south you go back to town gate.");
		System.out.println("1.Go North");
		System.out.println("2.Go East");
		System.out.println("3.Go West");
		System.out.println("4.Go South");
		System.out.println("\n>>------------------------------------>\n");
		choice=myscanner.nextInt();
		if (choice==1)
			north();
		if (choice==2)
			east();
		if (choice==3)
			west();
		if (choice==4)
			townGate();
		else
			System.out.println("Wrong Input");
			crossRoad();
	}
	
	public void north() {
		System.out.println("\n>>------------------------------------>\n");
		playerHp=playerHp+1;
		System.out.println("There is a river./nYou drink from that river and rest on the riverside.\n(HP is restored)");
		System.out.println("HP : "+playerHp);
		System.out.println("\n\n1.Go back to the crossroad");
		System.out.println("\n2.Rest");
		choice = myscanner.nextInt();
		if (choice==1)
			crossRoad();
		else
			north();
	}
	
	public void east() {
		System.out.println("\n>>------------------------------------>\n");
		System.out.println("You entered a forest and found a chest");
		System.out.println("You opened it and found a long sword");
		playerWeapon="Long Sword";
		System.out.println("Your Weapon:"+playerWeapon);
		System.out.println("\n1.Return to crossroad");
		System.out.println("\n>>------------------------------------>\n");
		choice = myscanner.nextInt();
		if (choice==1)
			crossRoad();
		else
			north();
	}
	
	public void west() {
		System.out.println("\n>>------------------------------------>\n");
		System.out.println("You encountered a goblin!");
		System.out.println("1.Fight");
		System.out.println("2.Run");
		System.out.println("\n>>------------------------------------>\n");	
		choice=myscanner.nextInt();
		if (choice==1)
			fight();
		if(choice==2)
			crossRoad();
		else
			west();
	}
	
	public void fight() {
		System.out.println("\n>>------------------------------------>\n");	
		System.out.println("your HP:"+playerHp);
		System.out.println("monster HP:"+monsterHp);
		System.out.println("\n\n1.Attack");
		System.out.println("\n2.Run");
		System.out.println("\n>>------------------------------------>\n");	
		choice=myscanner.nextInt();
		if (choice==1)
			attack();
		if(choice==2)
			crossRoad();
		else
			fight();
	}
	
	public void attack() {
		int playerDamage=0;
		if (playerWeapon=="Broken Sword")
			playerDamage = new java.util.Random().nextInt(5);
		if (playerWeapon=="Long Sword")
			playerDamage = new java.util.Random().nextInt(8);
		System.out.println("You attacked the monster and gave "+playerDamage+"Damage!");
		monsterHp=monsterHp-playerDamage;
		System.out.println("Monster HP:"+monsterHp);
		if (monsterHp<1)
			win();
		else if (monsterHp>0) {
			int monsterDamage=0;
			monsterDamage=new java.util.Random().nextInt(4);
			System.out.println("Monster attacked and gave "+monsterDamage+"Damage!");
			playerHp=playerHp-monsterDamage;
			System.out.println("Player HP:"+playerHp);
			if (playerHp<1)
				lose();
			else if (playerHp>0)	{
				fight();
			}
		}
		System.out.println("\n>>------------------------------------>\n");	
	}
	public void lose() {
		System.out.println("\n>>------------------------------------>\n");
		System.out.println("(You Died!)");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n>>------------------------------------>\n");
		playerHp=10;
		monsterHp=15;
		playerSetup();
	}
	public void win() {
		System.out.println("\n>>------------------------------------>\n");
		System.out.println("You killed the monster");
		System.out.println("monster dropped a ring");
		System.out.println("You obtained a silver ring!\n\n");
		silverRing="yes";
		System.out.println("1.Go back to east");
		System.out.println("\n>>------------------------------------>\n");
		choice=myscanner.nextInt();
		if (choice==1)
			crossRoad();
		else
			crossRoad();
	}
	public void ending() {
		System.out.println("\n>>------------------------------------>\n");
		System.out.println("Yeah you Won the game!!");
		System.out.println("        THE END        ");
		System.out.println("\n>>------------------------------------>\n");
	}
}
