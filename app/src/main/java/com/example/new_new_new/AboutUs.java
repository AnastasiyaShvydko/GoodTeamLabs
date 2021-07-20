//package com.example.new_new_new;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class NinthActivity extends AppCompatActivity {
//}
package com.example.new_new_new;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;
public class AboutUs extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Element adsElement = new Element();
        adsElement.setTitle("Advertise Here");
        View aboutPage =new AboutPage(this)
                .isRTL(false)
                .setImage(R.drawable.goodteam)
                .setDescription("This is good team labs and this is out team")
                .addItem(new Element().setTitle("Version1.0.0"))
                .addItem(adsElement)
                .addGroup("Connect With Us")
                .addEmail("nanakwamedickson@outlook.com")
                .addWebsite("goodteamlabs.com")
                .addFacebook("Nana Kwame Dickson")
                .addYoutube("GoodTeamLabs")
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }
    private Element createCopyright() {
        Element copyright = new Element();
        String copyrightString =String.format("Copyright by Nasty and Nana", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity((Gravity.CENTER));
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AboutUs.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;
    }
}