import java.util.ArrayList;

public class EP {
	
	
	public static void busyWait(long time){
		
		//System.out.println(time);
		while(System.currentTimeMillis() < time) Thread.yield();
	}
	
	/* Encontra e devolve o primeiro índice do  */
	/* array referente a uma posição "inativa". */
	
	public static void main(String[] args)
	{

		boolean running = true;
		Time.setCurrentTime();
		GameLib.initGraphics();
		GameController controller = GameController.Instance();
		Background bg = new Background("background", new Vector(0,0));
		Player player = Player.Instance();

		while(running){

			Time.setDeltaTime();
			Time.setCurrentTime();
			controller.update();
			if(GameLib.iskeyPressed(GameLib.KEY_ESCAPE)) running = false;
			GameLib.display();
			busyWait(Time.getCurrentTime() + 5);
		}

		System.exit(0);
	}
}

