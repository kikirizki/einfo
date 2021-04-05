package ta.andy.einfo;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class LoginActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
		
    }
	//Fungsi untuk pindah ke halaman login
	public void do_login(View view){
		Intent intent = new Intent(this,ProfileActivity.class);
	    startActivity(intent);
	}
	//Fungsi untuk pindah ke register
	public void go2register(View view){
		Intent intent = new Intent(this,RegisterActivity.class);
	    startActivity(intent);
		}
}
