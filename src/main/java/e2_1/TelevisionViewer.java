package e2_1;
public class TelevisionViewer {
    public static class Television {
        int channel=1;
        boolean on=true;
        public void setChannel(int channel) {
            if (channel>10) {this.channel=1;}
            else {this.channel=channel;}
        }
        public int getChannel() {
            return this.channel;
        }
        public boolean isOn() { return this.on;}
        public void pressOnOff() {this.on=!this.on;}
    }
	public static void main(String[] args) {
		Television myTV = new Television();
		myTV.setChannel(1);

		for (int day = 1; day <= 10; day++) {
			System.out.println("Woke up, day " + day);
			
			boolean tired = false;
			
			if (!myTV.isOn())
				myTV.pressOnOff();

			while (!tired) {
				System.out.println("Watching channel " + myTV.getChannel());
				myTV.setChannel(myTV.getChannel() + 1);
				if (myTV.getChannel() % 4 == 0)
					tired = true;
			}

			myTV.pressOnOff();
			
			System.out.println("Falling asleep");
		}
	}
}