package com.spacecombat;

import java.io.InputStream;

public class Phaser extends Weapon 
{
	private static final String name = "phaser";
	private static final float damage = 10;	
	private static final float shotSpeed = 128;
	private static final float life = 5;

	public Phaser (Vector3 direction,InputStream shotImage,float reloadTime)
	{
		super(name, damage, shotImage, reloadTime, life, shotSpeed, direction);
	}
	
	@Override
	protected void fire(Vector3 position, InputStream is) 
	{
		// TODO Auto-generated method stub
		lastShotTime = Time.getTime();
		GameObject.create(PrefabFactory.createLaser(position, shotSpeedVector, gameObject.getTags(), shotImage, baseDamage, powerLevel, life));			
	}

}
