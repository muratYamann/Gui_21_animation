package com.yamankod.gui_21_animation;


import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

public class CodeActivity extends Activity implements ViewFactory {
	
	private Integer[] m_ImageIds = {
            R.drawable.img_01,
            R.drawable.img_02,
            R.drawable.img_03
	};
	ImageSwitcher m_ImageSwitcher;
	Handler m_Handler = new Handler();
	int m_imageIndex = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.use_code_activity);

        m_ImageSwitcher = (ImageSwitcher)findViewById(R.id.imageswitcher);
        m_ImageSwitcher.setFactory(this);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeIn.setDuration(3000);

        Animation fadeOut = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        fadeOut.setDuration(3000);

        m_ImageSwitcher.setInAnimation(fadeIn);
        m_ImageSwitcher.setOutAnimation(fadeOut);
        
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