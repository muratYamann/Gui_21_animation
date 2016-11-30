package com.yamankod.gui_21_animation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Anismasyon extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.anismasyon);
		Button m_ButtonCode = (Button)findViewById(R.id.button_use_code);
        Button m_ButtonXml = (Button)findViewById(R.id.button_use_xml);
        m_ButtonCode.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent m_codeActivityIntent = new Intent(getApplicationContext(), CodeActivity.class);
				startActivity(m_codeActivityIntent);				
			}
		});
        m_ButtonXml.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent m_xmlActivityIntent = new Intent(getApplicationContext(), XmlActivity.class);
				startActivity(m_xmlActivityIntent);				
			}
		});
	}
}
