package ta.andy.einfo;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class ProfileActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profil);

    }
	public void go2jadwal(View view){
		Intent intent = new Intent(this,JadwalActivity.class);
	    startActivity(intent);
	}
	
}
