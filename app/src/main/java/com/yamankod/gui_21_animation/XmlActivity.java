package com.yamankod.gui_21_animation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;



public class XmlActivity extends Activity implements ViewFactory {
	
	private Integer[] m_ImageIds = {
            R.drawable.img_01,
            R.drawable.img_02,
            R.drawable.img_03
	};

	ImageSwitcher m_ImageSwitcher;
	Handler m_Handler = new Handler(); 
	int m_imageIndex = 0;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_xml_activity);
        m_ImageSwitcher = (ImageSwitcher)findViewById(R.id.imageswitcher);
        m_ImageSwitcher.setFactory(this);
        m_Handler.post(m_UpdateTimeTask);        
    }

	@Override
	public View makeView() {
		ImageView i = new ImageView(this);
		i.setBackgroundColor(0xFF000000);
		i.setScaleType(ImageView.ScaleType.FIT_CENTER);
		i.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
		return i;
	}
	
	Runnable m_UpdateTimeTask = new Runnable() {
		   public void run() {
			   m_ImageSwitcher.setImageResource(m_ImageIds[m_imageIndex]);
			   m_imageIndex++;
			   if(m_imageIndex > (m_ImageIds.length-1)){
				   m_imageIndex = 0;
			   }
			   m_Handler.postDelayed(this, (5 * 1000));
		   }
	};

}