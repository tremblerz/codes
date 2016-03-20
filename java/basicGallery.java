import java.util.ArrayList;

public class basicGallery{
	public static void main(String[] args){
		ArrayList<Picture> gallery = new ArrayList<Picture>();
		gallery.add(new Picture("netSpeed.png"));
		gallery.add(new Picture("netSpeed.png"));
		gallery.add(new Picture("netSpeed.png"));
		gallery.add(new Picture("netSpeed.png"));
		gallery.add(new Picture("netSpeed.png"));
		gallery.add(new Picture("netSpeed.png"));
		gallery.add(new Picture("netSpeed.png"));
		for(int i=gallery.start();i<gallery.size();i++){
			Picture pic = gallery.get(i);
			pic.translate(100*i,i%4);
			pic.draw();
		}
	}
}
