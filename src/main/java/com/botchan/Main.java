package com.botchan;

public class Main {
	
	public static void main(String[] args) {
		Bot bot = new Bot();
		try {
			bot.login();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
