package ta.andy.einfo;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import com.google.firebase.database.*;
import com.google.firebase.auth.*;
import com.google.android.gms.tasks.*;
import androidx.annotation.*;
import android.widget.*;
import android.util.*;

public class LoginActivity extends Activity 
{
	DatabaseReference users;
    
    private FirebaseAuth mAuth;
	EditText id_edt;
	EditText passwd_edt;
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
		mAuth = FirebaseAuth.getInstance();
		id_edt=(EditText)findViewById(R.id.input_pegawai);
		passwd_edt=(EditText)findViewById(R.id.password_pegawai);
		mAuth.signOut();
		}
	//Fungsi untuk pindah ke halaman profile
	public void do_login(View view){
		
		mAuth.signInWithEmailAndPassword(id_edt.getText().toString(), passwd_edt.getText().toString())
			.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {

				private String TAG="message";
				@Override
				public void onComplete(@NonNull Task<AuthResult> task) {
					if (task.isSuccessful()) {
						startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
						// Sign in berhasil, masuk ke halaman profile
						//Log.d(TAG, "signInWithEmail:success");
						finish();
					} else {
						// If sign in fails, display a message to the user.
						Log.d(TAG, "signInWithEmail:failed");
						
					}
				}
			});
		
		
	}
	//Fungsi untuk pindah ke register
	public void go2register(View view){
		Intent intent = new Intent(this,RegisterActivity.class);
	    startActivity(intent);
		}
}
