package com.spacecombat;

public class Time 
{
	private static float currentTime = 0;
	private static float deltaTime = 0;
	private static float lastTime = 0;
	
	public static float getTime ()
	{
		return currentTime;
	}
	
	public static float getDeltaTime ()
	{
		return deltaTime;
	}
	
	public static void tick ()
	{
		currentTime = ((float)System.nanoTime()) / 1000000000.0f;
				
		deltaTime = currentTime - lastTime;
		lastTime = currentTime;
	}
	
}
