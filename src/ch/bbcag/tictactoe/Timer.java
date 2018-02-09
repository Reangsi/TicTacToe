package ch.bbcag.tictactoe;

import ch.bbcag.tictactoe.view.GridButtons;

public class Timer extends Thread {

	private boolean isRunning = true;
	private int timeInSec = 0;
	private GridButtons view;

	public Timer(GridButtons view) {
		setView(view);
	}

	@Override
	public void run() {
		while (isRunning()) {
			try {
				sleep(1000);
				incrementTime();
				String[] time = splitToComponentTimes(getTimeInSec());
				getView().updateTime(time);
			} catch (InterruptedException e) {
				System.err.println("Error in timer occurred: " + e.getMessage());
			}
		}
	}

	public void stopTimer() {
		setRunning(false);
	}

	private boolean isRunning() {
		return isRunning;
	}

	private void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}

	private void incrementTime() {
		setTimeInSec(getTimeInSec() + 1);
	}

	private int getTimeInSec() {
		return timeInSec;
	}

	private void setTimeInSec(int timeInSec) {
		this.timeInSec = timeInSec;
	}

	public String[] splitToComponentTimes(int timeInSeconds) {

		int mins = (int) timeInSeconds / 60;
		int remainder = timeInSeconds - mins * 60;
		int secs = remainder;

		String minutes = null;
		String seconds = null;

		if (mins < 10) {
			minutes = "0" + mins;
		} else {
			minutes = String.valueOf(mins);
		}

		if (secs < 10) {
			seconds = "0" + secs;
		} else {
			seconds = String.valueOf(secs);
		}

		String[] time = { minutes, seconds };
		return time;
	}

	private GridButtons getView() {
		return view;
	}

	private void setView(GridButtons view) {
		this.view = view;
	}
}
