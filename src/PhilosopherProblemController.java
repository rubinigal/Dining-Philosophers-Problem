import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PhilosopherProblemController {
	private final static int SIZE = 5;
	private static ImageView p[];
	private static ImageView s[];
	
    @FXML
    private ImageView p1;

    @FXML
    private ImageView p2;

    @FXML
    private ImageView p3;

    @FXML
    private ImageView p4;

    @FXML
    private ImageView p5;

    @FXML
    private ImageView s1;

    @FXML
    private ImageView s2;

    @FXML
    private ImageView s3;

    @FXML
    private ImageView s4;

    @FXML
    private ImageView s0;
    
    public void initialize() {
    	p = new ImageView[]{p1,p2,p3,p4,p5};
    	s = new ImageView[]{s0,s1,s2,s3,s4};
    	
    	Sticks sticks = new Sticks();
    	Philosopher t[] = new Philosopher[SIZE];
    	
    	for (int i = 0; i < SIZE; i++) {
			t[i] = new Philosopher(i+1, sticks);
		}
		for (int i = 0; i < SIZE; i++) {
			t[i].start();
		}
    }
    
    public static synchronized void updateEating(int id) {
    	s[id-1].setVisible(false);
    	s[id%SIZE].setVisible(false);
    	p[id-1].setImage(new Image("eat.jpg"));
    	
    }
    
    public static synchronized void updateThinking(int id) {
    	s[id-1].setVisible(true);
    	s[id%SIZE].setVisible(true);
    	p[id-1].setImage(new Image("think.jpg"));
    	
    }
    
    
}