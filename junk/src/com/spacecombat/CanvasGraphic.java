package com.spacecombat;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import android.graphics.Rect;
import com.nea.nehe.lesson06.R;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;

public class CanvasGraphic implements GenericGraphic 
{
	private static Canvas canvas;
	private static Paint paint;
	private static HashMap<String,Bitmap> loaded;
	
	private Rect src;
	private Rect dst;
	private Bitmap myBitmap;
		
	public static void setCanvas (Canvas canvas)
	{
		CanvasGraphic.canvas = canvas;
	}
	
	public static void setPaint (Paint paint)
	{
		CanvasGraphic.paint = paint;
	}
	
	public CanvasGraphic ()
	{		
	}
	
	public void create (String name, InputStream is) 
	{		
		src = new Rect(0,0,32,32);
		dst = new Rect(0,0,32,32);

		
		if (loaded == null)
		{
			System.out.println("CREATED NEW IMAGE ARRAY");
			loaded = new HashMap<String,Bitmap>();
		}
				
		if (loaded.containsKey(name))
		{
			myBitmap = loaded.get(name);
			return;
		}
				
		Bitmap bitmap = null;
		try {
			//BitmapFactory is an Android graphics utility for images
			bitmap = BitmapFactory.decodeStream(is);
		} finally {
			//Always clear and close
			try {
				is.close();
				is = null;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		loaded.put(name, bitmap);	
		myBitmap = loaded.get(name);
		System.out.println("DONE CREATING");
	}
	
	public int getWidth()
	{		
		return myBitmap.getWidth();
	}
	
	public int getHeight()
	{		
		return myBitmap.getHeight();
	}
	
	public void draw(int x, int y, int width, int height, int offsetX, int offsetY, int rotx, int roty, int scalex, int scaley) 
	{
		if (canvas != null && paint != null)
		{
			//Bitmap bitmap = loaded.get(name);

			//Rect src = new Rect(x,y,x+width,y+height);
			//Rect dst = new Rect(offsetX,offsetY,offsetX+width,offsetY+width);

			//canvas.drawBitmap(bitmap, 100, 100, paint);
			
			src.set(x,y,x+width,y+height);
			dst.set(offsetX,offsetY,offsetX+width,offsetY+height);

			canvas.drawBitmap(myBitmap,src,dst,paint);
		}
		else if (canvas == null)
		{
			System.out.println("Canvas is null");
		}
		else if (paint == null)
		{
			System.out.println("paint is null");
		}
	}
}
