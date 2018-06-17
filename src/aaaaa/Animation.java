package aaaaa;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Animation {

	ArrayList frames;
	int currentFrame;
        boolean loop;
	private long animTime;
	private long totalDuration;

	public Animation(boolean l) {
                loop = l;
		frames = new ArrayList();
		totalDuration = 0;

		synchronized (this) {
			animTime = 0;
			currentFrame = 0;
		}
	}
        

	public synchronized void addFrame(BufferedImage image, long duration) {
		totalDuration += duration;
		frames.add(new AnimFrame(image, totalDuration));
	}

	public synchronized void update(long elapsedTime) {
           
		if (frames.size() > 1) {
			animTime += elapsedTime;
                        
                        
                        if (!(loop && currentFrame == frames.size()-1)){
                            if (animTime >= totalDuration) {
                                    animTime = animTime % totalDuration;
                                    currentFrame = 0;

                            }

                            while (animTime > getFrame(currentFrame).endTime) {
                                    currentFrame++;

                            }
                        
                        }
                
                }}

	public synchronized BufferedImage getImage() {
		if (frames.size() == 0) {
			return null;
		} else {
			return getFrame(currentFrame).image;
		}
	}

	private AnimFrame getFrame(int i) {
		return (AnimFrame) frames.get(i);
	}

	private class AnimFrame {

		BufferedImage image;
		long endTime;

		public AnimFrame(Image image, long endTime) {
			this.image = (BufferedImage) image;
			this.endTime = endTime;
		}
	}
}
